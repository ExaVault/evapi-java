package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.*;

import java.io.File;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import static com.exavault.client.api.ApiTestAssertionUtil.validateAddFolderResponse;
import static com.exavault.client.api.ApiTestAssertionUtil.validateCompressFilesResponse;
import static com.exavault.client.api.ApiTestAssertionUtil.validateCopyResponse;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

/**
 * API tests for ResourcesApi
 */
@DisplayName("Resource API Tests")
@Tag("ResourceApi")
public class ResourcesApiTest {

	private ResourcesApi api;

	@BeforeEach
	public void setup() {
		api = new ResourcesApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Add Folder Call Tests") //add api details.
	@Tag("AddFolder")
	class AddFolder {
		@Test
		@DisplayName("Given good credentials, when add folder called with path, folder id is returned")
		public void addFolderTest() {
			try {
				AddFolderRequestBody requestBody = getAddFolderRequestBody();
				ResourceResponse response = api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
				assertThat(response).isNotNull();
				validateAddFolderResponse(response);
				cleanup();
			} catch (ApiException e) {
				fail("Failed due to APIException", e);
			}
		}

		@Test
		@DisplayName("Given bad credentials, when add folder called with path, error thrown")
		public void addFolderTest2() {
			final AddFolderRequestBody requestBody = getAddFolderRequestBody();
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.addFolder(EV_API_KEY_BAD, EV_ACCESS_TOKEN, requestBody);
				}
			}).isInstanceOf(ApiException.class)
				.hasMessageContaining(UNAUTHORIZED);
		}
	}

	private AddFolderRequestBody getAddFolderRequestBody() {
		AddFolderRequestBody requestBody = new AddFolderRequestBody();
		requestBody.setPath(String.format(TEST_FOLDER, getRandomNumber()));
		return requestBody;
	}

	@Nested
	@DisplayName("Compress Files Tests")
	@Tag("CompressFiles")
	class CompressFiles {
		@Test
		@DisplayName("Given good credentials and a new files uploaded before," +
			             " when compress files is called, zip is created")
		public void compressFilesTest() {
			try {
				//ApiTestData.uploadDummyFiles(api);
				CompressFilesRequestBody compress = new CompressFilesRequestBody();
				compress.setResources(Collections.singletonList("empty-test"));
				compress.setParentResource(BASE_FOLDER_);
				ResourceResponse response = api.compressFiles(EV_API_KEY, EV_ACCESS_TOKEN, compress);
				assertThat(response).isNotNull();
				validateCompressFilesResponse(response, null);
				cleanup();
			} catch (Exception e) {
				fail("Failed due to :", e);
			}
		}

		@Test
		@DisplayName("Given good credentials and a new files uploaded before, with given archive name" +
			             " when compress files is called, zip is created")
		public void compressFilesTest2() {
			try {
				ApiTestData.uploadDummyFiles(api);
				CompressFilesRequestBody compress = new CompressFilesRequestBody();
				compress.setResources(Collections.singletonList(BASE_FOLDER_));
				compress.setArchiveName(TEST_ARCHIVE);
				compress.setParentResource(BASE_FOLDER_);
				ResourceResponse response = api.compressFiles(EV_API_KEY, EV_ACCESS_TOKEN, compress);
				assertThat(response).isNotNull();
				validateCompressFilesResponse(response, "/" + TEST_ARCHIVE + ".zip");
				cleanup();
			} catch (ApiException | ParseException e) {
				fail("Failed due to :", e);
			}
		}

		@Test
		@DisplayName("Given bad credentials, when compress files is called, error thrown")
		public void compressFilesTest3() {
			final CompressFilesRequestBody compress = new CompressFilesRequestBody();
			compress.setResources(Collections.singletonList(BASE_FOLDER_));
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.compressFiles(EV_API_KEY_BAD, EV_ACCESS_TOKEN, compress);
				}
			}).isInstanceOf(ApiException.class)
				.hasMessageContaining(UNAUTHORIZED);
		}

		@Test
		@DisplayName("Given good credentials and an empty folder, when compress files is called, error thrown")
		public void compressFilesTest4() {
			try {
				AddFolderRequestBody requestBody = new AddFolderRequestBody();
				final String folder = String.format(TEST_FOLDER, getRandomNumber());
				requestBody.setPath(folder);
				api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
				final CompressFilesRequestBody compress = new CompressFilesRequestBody();
				compress.setResources(Collections.singletonList(folder));
				assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
					@Override
					public void call() throws ApiException {
						api.compressFiles(EV_API_KEY, EV_ACCESS_TOKEN, compress);
					}
				}).isInstanceOf(ApiException.class)
					.hasMessageContaining(INTERNAL_SERVER_ERROR);
				cleanup();
			} catch (ApiException e) {
				fail("Failed due to :", e);
			}
		}
	}

	@Nested
	@DisplayName("Copy Resources Tests")
	@Tag("CopyResources")
	class CopyResources {
		@Test
		@DisplayName("Given good credentials and files uploaded before," +
			             " when copy files is called, files are copied correctly")
		public void copyResources() {
			try {
				ApiTestData.uploadDummyFiles(api);
				AddFolderRequestBody addFolder = new AddFolderRequestBody();
				//TODO: What if copied folder is in the same directory? it does not work
				final String folder = String.format(COPIED_FOLDER, getRandomNumber());
				addFolder.setPath(folder);
				api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, addFolder);
				CopyResourcesRequestBody requestBody = new CopyResourcesRequestBody();
				requestBody.setParentResource(folder);
				requestBody.setResources(Collections.singletonList(BASE_FOLDER_));
				ResourceCopyMove response = api.copyResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
				assertThat(response).isNotNull();
				validateCopyResponse(response, folder);
				cleanup();
				cleanupCopyFolder();
			} catch (ApiException e) {
				fail("Failed due to :", e);
			}
		}

		@Test
		@DisplayName("Given good credentials without resources input," +
			             " when copy files is called, copy should fail")
		public void copyResources2() {
			final CopyResourcesRequestBody requestBody = new CopyResourcesRequestBody();
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.copyResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
				}
			}).isInstanceOf(ApiException.class)
				.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Given bad credentials," +
			             " when copy files is called, copy should fail")
		public void copyResources3() {
			final CopyResourcesRequestBody requestBody = new CopyResourcesRequestBody();
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.copyResources(EV_API_KEY_BAD, EV_ACCESS_TOKEN, requestBody);
				}
			}).isInstanceOf(ApiException.class)
				.hasMessageContaining(UNAUTHORIZED);
		}
	}

	@Nested
	@DisplayName("Copy Resources Tests")
	@Tag("CopyResources")
	class DeleteRes {
		@Test
		@DisplayName("Given good credentials and files uploaded before," +
			             " when copy files is called, files are copied correctly")
		public void copyResources() {
			try {
				ApiTestData.uploadDummyFiles(api);
				AddFolderRequestBody addFolder = new AddFolderRequestBody();
				//TODO: What if copied folder is in the same directory? it does not work
				final String folder = String.format(COPIED_FOLDER, getRandomNumber());
				addFolder.setPath(folder);
				api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, addFolder);
				CopyResourcesRequestBody requestBody = new CopyResourcesRequestBody();
				requestBody.setParentResource(folder);
				requestBody.setResources(Collections.singletonList(BASE_FOLDER_));
				ResourceCopyMove response = api.copyResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
				assertThat(response).isNotNull();
				validateCopyResponse(response, folder);
				cleanup();
				cleanupCopyFolder();
			} catch (ApiException e) {
				fail("Failed due to :", e);
			}
		}

		@Test
		@DisplayName("Given good credentials without resources input," +
			             " when copy files is called, copy should fail")
		public void copyResources2() {
			final CopyResourcesRequestBody requestBody = new CopyResourcesRequestBody();
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.copyResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
				}
			}).isInstanceOf(ApiException.class)
				.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Given bad credentials," +
			             " when copy files is called, copy should fail")
		public void copyResources3() {
			final CopyResourcesRequestBody requestBody = new CopyResourcesRequestBody();
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.copyResources(EV_API_KEY_BAD, EV_ACCESS_TOKEN, requestBody);
				}
			}).isInstanceOf(ApiException.class)
				.hasMessageContaining(UNAUTHORIZED);
		}
	}

	@Test
	public void deleteResourceByIdTest() throws ApiException {
		Integer id = null;
		EmptyResponse response = api.deleteResourceById(id, EV_API_KEY, EV_ACCESS_TOKEN);

		// TODO: test validations
	}

	@Test
	public void deleteResourcesTest() throws ApiException {
		DeleteResourcesRequestBody body = null;
		EmptyResponse response = api.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, body);

		// TODO: test validations
	}

	@Test
	public void downloadTest() throws ApiException {
		List<String> resources = null;
		String downloadArchiveName = null;
		Boolean polling = null;
		String pollingArchiveName = null;
		File response = api.download(EV_API_KEY, EV_ACCESS_TOKEN, resources, downloadArchiveName, polling, pollingArchiveName);

		// TODO: test validations
	}

	@Test
	public void extractFilesTest() throws ApiException {
		ExtractFilesRequestBody body = null;
		ResourceCollectionResponse response = api.extractFiles(EV_API_KEY, EV_ACCESS_TOKEN, body);

		// TODO: test validations
	}

	@Test
	public void getPreviewImageTest() throws ApiException {
		String resource = null;
		String size = null;
		Integer width = null;
		Integer height = null;
		Integer page = null;
		PreviewFileResponse response = api.getPreviewImage(EV_API_KEY, EV_ACCESS_TOKEN, resource, size, width, height, page);

		// TODO: test validations
	}

	@Test
	public void getResourceInfoTest() throws ApiException {
		String resource = null;
		String include = null;
		ResourceResponse response = api.getResourceInfo(EV_API_KEY, EV_ACCESS_TOKEN, resource, include);

		// TODO: test validations
	}

	@Test
	public void getResourceInfoByIdTest() throws ApiException {
		Integer id = null;
		String include = null;
		ResourceResponse response = api.getResourceInfoById(id, EV_API_KEY, EV_ACCESS_TOKEN, include);

		// TODO: test validations
	}

	@Test
	public void listResourceContentsTest() throws ApiException {
		Integer id = null;
		String sort = null;
		Integer offset = null;
		Integer limit = null;
		String type = null;
		String include = null;
		ResourceCollectionResponse response = api.listResourceContents(EV_API_KEY, EV_ACCESS_TOKEN, id, sort, offset, limit, type, include);

		// TODO: test validations
	}

	@Test
	public void listResourcesTest() throws ApiException {
		String resource = null;
		String sort = null;
		Integer offset = null;
		Integer limit = null;
		String type = null;
		String name = null;
		String include = null;
		ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, resource, sort, offset, limit, type, name, include);

		// TODO: test validations
	}

	@Test
	public void moveResourcesTest() throws ApiException {
		String EV_API_KEY = null;
		String EV_ACCESS_TOKEN = null;
		MoveResourcesRequestBody body = null;
		ResourceCopyMove response = api.moveResources(EV_API_KEY, EV_ACCESS_TOKEN, body);

		// TODO: test validations
	}

	@Test
	public void updateResourceByIdTest() throws ApiException {
		Integer id = null;
		UpdateReourceByIdRequestBody body = null;
		ResourceResponse response = api.updateResourceById(EV_ACCESS_TOKEN, EV_API_KEY, id, body);

		// TODO: test validations
	}

	@Test
	public void uploadFileTest() throws ApiException {
		String path = null;
		Integer fileSize = null;
		File file = null;
		Integer offsetBytes = null;
		Boolean resume = null;
		Boolean allowOverwrite = null;
		ResourceResponse response = api.uploadFile(EV_API_KEY, EV_ACCESS_TOKEN, path, fileSize, file, offsetBytes, resume, allowOverwrite);

		// TODO: test validations
	}

	private void cleanup() throws ApiException {
		DeleteResourcesRequestBody requestBody = new DeleteResourcesRequestBody();
		requestBody.setResources(Collections.singletonList(BASE_FOLDER_));
		api.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
		//TODO: Could have been an endpoint if a resource exists or deleteIfExists
		//TODO: Better exception handling for not found and Internal Server Error or Bad Request
		//TODO: Check AddFolder path and parent resource
		//TODO: Copy resource from and to invalid
	}

	private void cleanupCopyFolder() throws ApiException {
		DeleteResourcesRequestBody requestBody = new DeleteResourcesRequestBody();
		requestBody.setResources(Collections.singletonList("/copy"));
		api.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
	}
}
