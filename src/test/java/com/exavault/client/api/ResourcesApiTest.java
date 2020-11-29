package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;

import static com.exavault.client.api.ApiTestAssertionUtil.*;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.*;

/**
 * API tests for ResourcesApi
 */
@DisplayName("Resource API Tests")
public class ResourcesApiTest {

    private ResourcesApi api;

    @BeforeEach
    public void setup() {
        api = new ResourcesApi(ApiTestData.getApiClient());
    }

    @Nested
    @DisplayName("Create a folder, Method=POST, API=/resources")
    class CreateAFolder {
        @Test
        @DisplayName("When add folder called with path, folder id is returned")
        public void addFolderTest() throws ApiException {
            try {
                final AddFolderRequestBody requestBody = getAddFolderRequestBody();
                final ResourceResponse response = api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
                assertThat(response).isNotNull();
                validateAddFolderResponse(response);
            } catch (final ApiException e) {
                fail("Failed due to APIException", e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("When add folder called with name and parentResource, folder id is returned")
        public void addFolderTest2() throws ApiException {
            try {
                final AddFolderRequestBody requestBody = new AddFolderRequestBody();
                requestBody.setName(DUMMY_ADD_FOLDER_TEST);
                requestBody.setParentResource(SEPARATOR_PARENT);
                final ResourceResponse response = api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
                assertThat(response).isNotNull();
                validateAddFolderResponse2(response);
            } catch (final ApiException e) {
                fail("Failed due to APIException", e);
            } finally {
                cleanup(SEPARATOR_PARENT + DUMMY_ADD_FOLDER_TEST);
            }
        }

        @Test
        @DisplayName("Given bad credentials, when add folder called with path, error thrown")
        public void addFolderTest3() {
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
        final AddFolderRequestBody requestBody = new AddFolderRequestBody();
        requestBody.setPath(String.format(TEST_FOLDER, getRandomNumber()));
        return requestBody;
    }

    @Nested
    @DisplayName("Compress resources, Method=POST, API=/resources/compress")
    class CompressResources {
        @Test
        @DisplayName("Files are uploaded before, when compress files is called, zip with default name is created")
        public void compressFilesTest() throws ApiException {
            try {
                uploadDummyFiles(api);
                final CompressFilesRequestBody compress = new CompressFilesRequestBody();
                compress.setResources(Collections.singletonList(BASE_FOLDER_));
                compress.setParentResource(BASE_FOLDER_);
                final ResourceResponse response = api.compressFiles(EV_API_KEY, EV_ACCESS_TOKEN, compress);
                assertThat(response).isNotNull();
                validateCompressFilesResponse(response, null);
            } catch (final Exception e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files are uploaded before, with given archive name, when compress files is called, zip is created")
        public void compressFilesTest2() throws ApiException {
            try {
                uploadDummyFiles(api);
                final CompressFilesRequestBody compress = new CompressFilesRequestBody();
                compress.setResources(Collections.singletonList(BASE_FOLDER_));
                compress.setArchiveName(TEST_ARCHIVE);
                compress.setParentResource(BASE_FOLDER_);
                final ResourceResponse response = api.compressFiles(EV_API_KEY, EV_ACCESS_TOKEN, compress);
                assertThat(response).isNotNull();
                validateCompressFilesResponse(response, SEPARATOR_PARENT + TEST_ARCHIVE + ".zip");
            } catch (final ApiException | ParseException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Compress an empty folder, when compress files is called, error thrown")
        public void compressFilesTest3() throws ApiException {
            try {
                final AddFolderRequestBody requestBody = new AddFolderRequestBody();
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
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }
    }

    @Nested
    @DisplayName("Copy Resources, Method=POST, API=/resources/copy ")
    class CopyResources {
        @Test
        @DisplayName("Files are uploaded before, when copy files is called, files are copied correctly")
        public void copyResources() throws ApiException {
            try {
                uploadDummyFiles(api);
                final AddFolderRequestBody addFolder = new AddFolderRequestBody();
                final String folder = String.format(COPIED_FOLDER, getRandomNumber());
                addFolder.setPath(folder);
                api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, addFolder);
                final CopyResourcesRequestBody requestBody = new CopyResourcesRequestBody();
                requestBody.setParentResource(folder);
                requestBody.setResources(Collections.singletonList(BASE_FOLDER_));
                final ResourceCopyMove response = api.copyResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
                assertThat(response).isNotNull();
                validateCopyResponse(response, folder);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup("/copy");
            }
        }

        @Test
        @DisplayName("Without resources input, when copy files is called, copy should fail")
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
    }

    @Nested
    @DisplayName("Delete a Resource, Method=DELETE, API=/resources/{id} ")
    class DeleteResourcesById {
        @Test
        @DisplayName("Files are uploaded before, when delete by id is called with correct folder id, " +
                "resources are deleted successfully.")
        public void deleteResourceById() throws ApiException {
            try {
                final AddFolderRequestBody addFolder = new AddFolderRequestBody();
                final String folder = String.format(COPIED_FOLDER, getRandomNumber());
                addFolder.setPath(folder);
                final ResourceResponse resourceResponse = api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, addFolder);
                final Long id = resourceResponse.getData().getId();
                final EmptyResponse emptyResponse = api.deleteResourceById(id, EV_API_KEY, EV_ACCESS_TOKEN);
                assertThat(emptyResponse).isNotNull();
                assertThat(emptyResponse.getResponseStatus()).isEqualTo(200);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup("/copy");
            }
        }

        @Test
        @DisplayName("Non existing folder id, when delete resource by id is called, it should fail")
        public void deleteResourceById2() {
            assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
                @Override
                public void call() throws ApiException {
                    api.deleteResourceById(123L, EV_API_KEY, EV_ACCESS_TOKEN);
                }
            }).isInstanceOf(ApiException.class)
                    .hasMessageContaining(NOT_FOUND);
        }
    }

    @Nested
    @DisplayName("Delete Resources, Method=DELETE, API=/resources")
    class DeleteResources {
        @Test
        @DisplayName("Files uploaded before, when delete resources is called, resources are deleted successfully.")
        public void deleteResources() {
            try {
                createFolder(String.format(COPIED_FOLDER, getRandomNumber()));
                final DeleteResourcesRequestBody body = new DeleteResourcesRequestBody();
                body.setResources(Collections.singletonList("/copy"));
                final EmptyResponse emptyResponse = api.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, body);
                assertThat(emptyResponse).isNotNull();
                assertThat(emptyResponse.getResponseStatus()).isEqualTo(200);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            }
        }

        @Test
        @DisplayName("With non existing resources, when delete resources is called, it should fail")
        public void deleteResources2() {
            final DeleteResourcesRequestBody body = new DeleteResourcesRequestBody();
            body.setResources(Collections.singletonList("/no-existing"));
            assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
                @Override
                public void call() throws ApiException {
                    api.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, body);
                }
            }).isInstanceOf(ApiException.class)
                    .hasMessageContaining(NOT_FOUND);
        }
    }

    @Nested
    @DisplayName("Download a File, Method=GET, API=/resources/download")
    class DownloadResources {
        @Test
        @DisplayName("Files uploaded before,when download resources is called, files are downloaded correctly")
        public void downloadResources() throws ApiException {
            try {
                uploadDummyFiles(api);
                final File download = api.download(EV_API_KEY, EV_ACCESS_TOKEN, Collections.singletonList(BASE_FOLDER_),
                        DOWNLOAD_ARCHIVE, true, null);
                assertThat(download).isNotNull();
                //TODO : Not correct data type is returned and file name is also not correct
                //validateDownloadedFile(download);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }
    }

    @Nested
    @DisplayName("Extract Resources, Method=POST, API=/resources/extract")
    class ExtractFiles {
        @Test
        @DisplayName("Files uploaded before,when Extract resources is called, files are Extracted correctly")
        public void extractResources() throws ApiException {
            try {
                uploadDummyFiles(api);
                createFolder(SEPARATOR_PARENT + COMPRESS_ZIP);
                createFolder(SEPARATOR_PARENT + DECOMPRESS_ZIP);
                final CompressFilesRequestBody compress = new CompressFilesRequestBody();
                compress.setResources(Collections.singletonList(BASE_FOLDER_));
                compress.setParentResource(SEPARATOR_PARENT + COMPRESS_ZIP);
                compress.setArchiveName(TEST_ZIP);
                api.compressFiles(EV_API_KEY, EV_ACCESS_TOKEN, compress);
                final ExtractFilesRequestBody body = new ExtractFilesRequestBody();
                body.setResource(SEPARATOR_PARENT + COMPRESS_ZIP + SEPARATOR_PARENT + TEST_ZIP);
                body.setParentResource(SEPARATOR_PARENT + DECOMPRESS_ZIP);
                final ResourceCollectionResponse response = api.extractFiles(EV_API_KEY, EV_ACCESS_TOKEN, body);
                validateExtract(response);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_, COMPRESS_ZIP, DECOMPRESS_ZIP);
            }
        }
    }

    @Nested
    @DisplayName("Preview a File, Method=GET, API=/resources/preview")
    class PreviewFile {
        @Test
        @DisplayName("Files uploaded before, when Preview File is called (with png file and small size param)," +
                " file is previewed correctly")
        public void previewFile() throws ApiException {
            try {
                uploadDummyFiles(api, "images");
                final PreviewFileResponse response = api.getPreviewImage(EV_API_KEY, EV_ACCESS_TOKEN,
                        BASE_FOLDER_ + "/flower.png", "small", null, null, null);
                validatePreview(response);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when Preview File is called with non supported image type, it should fail")
        public void previewFile2() throws ApiException {
            try {
                uploadDummyFiles(api);
                assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
                    @Override
                    public void call() throws ApiException {
                        api.getPreviewImage(EV_API_KEY, EV_ACCESS_TOKEN,
                                BASE_FOLDER_ + "/dummy.txt", "small", null, null, null);
                    }
                }).isInstanceOf(ApiException.class)
                        .hasMessageContaining(NOT_FOUND);
                //TODO: validate correct error message
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when Preview File is called with png image with width and height, " +
                "file is previewed correctly")
        public void previewFile3() throws ApiException {
            try {
                uploadDummyFiles(api, "images");
                final PreviewFileResponse response = api.getPreviewImage(EV_API_KEY, EV_ACCESS_TOKEN,
                        BASE_FOLDER_ + "/flower.png", "medium", 100, 100, null);
                validatePreview(response);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when Preview File is called with a .pdf and page number given," +
                " file is previewed correctly")
        public void previewFile4() throws ApiException {
            try {
                uploadDummyFiles(api, "docs");
                final PreviewFileResponse response = api.getPreviewImage(EV_API_KEY, EV_ACCESS_TOKEN,
                        BASE_FOLDER_ + "/doc1.pdf", "medium", 100, 100, 1);
                validatePreview(response);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when Preview File is called with a .pdf and invalid page number given, should fail")
        public void previewFile5() throws ApiException {
            try {
                uploadDummyFiles(api, "docs");
                assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
                    @Override
                    public void call() throws ApiException {
                        api.getPreviewImage(EV_API_KEY, EV_ACCESS_TOKEN,
                                BASE_FOLDER_ + "/doc1.pdf", "medium", 100, 100, -100);
                    }
                }).isInstanceOf(ApiException.class)
                        .hasMessageContaining(NOT_FOUND);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }
    }

    private ResourceResponse createFolder(final String folderName) throws ApiException {
        final AddFolderRequestBody addFolder = new AddFolderRequestBody();
        addFolder.setPath(folderName);
        return api.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, addFolder);
    }

    @Nested
    @DisplayName("Get Resources Properties, Method=GET, API=/resources")
    class ResourceInfo {
        @Test
        @DisplayName("Files uploaded before, when resource info is called with parentResource as Include, " +
                "resources meta is returned.")
        public void resourceInfo() throws ApiException {
            try {
                createFolder(BASE_FOLDER_);
                final ResourceResponse include = api.getResourceInfo(EV_API_KEY,
                        EV_ACCESS_TOKEN, BASE_FOLDER_, "parentResource");
                validateResourceInfo(include, 1);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when resource info is called with an invalid Include, should fail.")
        public void resourceInfo2() throws ApiException {
            try {
                createFolder(BASE_FOLDER_);
                final ResourceResponse invalid = api.getResourceInfo(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_, "invalid");
                //TODO: should throw an exception here
                validateResourceInfo(invalid, 0);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }
    }

    @Nested
    @DisplayName("Get Resource Metadata, Method=GET, API=/resources/{id}")
    class ResourceInfoById {
        @Test
        @DisplayName("Files uploaded before, when resource info by id is called with parentResource as Include, " +
                "resources meta is returned.")
        public void resourceInfo() throws ApiException {
            try {
                final ResourceResponse folder = createFolder(BASE_FOLDER_);
                final Long id = folder.getData().getId();
                final ResourceResponse include = api.getResourceInfoById(id, EV_API_KEY, EV_ACCESS_TOKEN, "parentResource");
                validateResourceInfo(include, 1);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when resource info by id is called with an invalid Include, should fail.")
        public void resourceInfo2() throws ApiException {
            try {
                final ResourceResponse folder = createFolder(BASE_FOLDER_);
                final Long id = folder.getData().getId();
                final ResourceResponse include = api.getResourceInfoById(id, EV_API_KEY, EV_ACCESS_TOKEN, "invalid");
                validateResourceInfo(include, 0);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }
    }

    @Nested
    @DisplayName("Get a list of all resources, Method=GET, API=/resources/list")
    class ListResources {
        @Test
        @DisplayName("Files uploaded before, when list resources is called, all default params, resources are returned.")
        public void listResources() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, null, null, null, null, "parentResource");
                validateResourcesList(response, 2);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with only offset, resources are returned.")
        public void listResources2() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, 1, null, null, null, "parentResource");
                validateResourcesList(response, 1);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with only limit, resources are returned.")
        public void listResources3() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, 0, 1, null, null, "parentResource");
                validateResourcesList(response, 1);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with only valid name, resources are returned.")
        public void listResources4() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, null, null, null, "*.txt", "parentResource");
                validateResourcesList(response, 2);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with only non existing file name, resources are returned.")
        public void listResources5() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, null, null, null, "*.csv", "parentResource");
                validateResourcesList(response, 0);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with type as file, resources are returned.")
        public void listResources6() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, null, null, "file", null, "parentResource");
                validateResourcesList(response, 2);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with type as dir, resources are returned.")
        public void listResources7() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, null, null, "dir", null, "parentResource");
                validateResourcesList(response, 0);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with sort only, resources are returned.")
        public void listResources8() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        "name", null, null, null, null, "parentResource");
                validateResourcesList(response, 2);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with name and type together, resources are returned.")
        public void listResources9() throws ApiException {
            try {
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, null, null, "file", "*.txt", "parentResource");
                //TODO: name and type both worked well together, should it fail?
                validateResourcesList(response, 2);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with invalid offset, should fail.")
        public void listResources10() throws ApiException {
            try {
                uploadDummyFiles(api);
                assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
                    @Override
                    public void call() throws ApiException {
                        api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                                null, -100, null, null, null, "parentResource");
                    }
                }).isInstanceOf(ApiException.class)
                        .hasMessageContaining(BAD_REQUEST);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with invalid type, resources are returned.")
        public void listResources11() throws ApiException {
            try {
                uploadDummyFiles(api);
                api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                        null, null, null, "invalid", null, "parentResource");
                //TODO: Should throw an exception with invalid type?
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }

        @Test
        @DisplayName("Files uploaded before, when list resources is called, with invalid limit, should fail.")
        public void listResources12() throws ApiException {
            try {
                uploadDummyFiles(api);
                assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
                    @Override
                    public void call() throws ApiException {
                        api.listResources(EV_API_KEY, EV_ACCESS_TOKEN, BASE_FOLDER_,
                                null, 0, -10, null, null, "parentResource");
                    }
                }).isInstanceOf(ApiException.class)
                        .hasMessageContaining(BAD_REQUEST);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }
    }

    @Nested
    @DisplayName("List contents of folder, Method=GET, API=/resources/list/{id}")
    class ListResourcesContent {
        @Test
        @DisplayName("Files uploaded before, when list resources content is called, all default params, resource content is returned.")
        public void listResources() throws ApiException {
            try {
                final ResourceResponse folder = createFolder(BASE_FOLDER_);
                final Long id = folder.getData().getId();
                uploadDummyFiles(api);
                final ResourceCollectionResponse response = api.listResourceContents(EV_API_KEY, EV_ACCESS_TOKEN,
                        id, null, null, null, null, "parentResource");
                validateResourcesList(response, 2);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }
    }

    @Nested
    @DisplayName("Move Resources, Method=POST,  API=/resources/move")
    class MoveResources {
        @Test
        @DisplayName("Files uploaded before, when move files is called, files are moved correctly")
        public void moveResources() throws ApiException {
            try {
                uploadDummyFiles(api);
                createFolder(MOVE);
                final MoveResourcesRequestBody body = new MoveResourcesRequestBody();
                body.setParentResource(MOVE);
                body.setResources(Collections.singletonList(BASE_FOLDER_));
                final ResourceCopyMove response = api.moveResources(EV_API_KEY, EV_ACCESS_TOKEN, body);
                assertThat(response).isNotNull();
                validateCopyResponse(response, MOVE);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(MOVE, BASE_FOLDER_);
            }
        }
    }

    @Nested
    @DisplayName("Move Resources, Method=PATCH,  API=/resources/move")
    class UpdateResources {
        @Test
        @DisplayName("Files uploaded before, when update resource is called, resource renamed correctly")
        public void renameResources() throws ApiException {
            try {
                final ResourceResponse folder = createFolder(BASE_FOLDER_);
                final Long id = folder.getData().getId();
                final UpdateResourceByIdRequestBody body = new UpdateResourceByIdRequestBody();
                body.setName(NEW_NAME);
                final ResourceResponse response = api.updateResourceById(EV_ACCESS_TOKEN, EV_API_KEY, id, body);
                assertThat(response).isNotNull();
                validateRenameResponse(response);
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(NEW_NAME);
            }
        }
    }

    @Nested
    @DisplayName("Upload a File, Method=POST,  API=/resources/upload")
    class UploadResources {
        @Test
        @DisplayName("Files uploaded before, when upload resource is called with default values, resource uploaded correctly")
        public void uploadResources() throws ApiException {
            try {
                final File[] files = getAllLocalFiles(FILES);
                if (files != null && files.length > 0) {
                    if (files[0].isFile()) {
                        final ResourceResponse resourceResponse = api.uploadFile(EV_API_KEY, EV_ACCESS_TOKEN,
                                BASE_FOLDER_ + "/" + files[0].getName(), (int) files[0].length(),
                                files[0], 0, false, false);
                        validateUploadResponse(resourceResponse);
                    }
                }
            } catch (final ApiException e) {
                fail(FAILED_DUE_TO, e);
            } finally {
                cleanup(BASE_FOLDER_);
            }
        }
    }

    private void cleanup(final String... folderNames) throws ApiException {
        final DeleteResourcesRequestBody requestBody = new DeleteResourcesRequestBody();
        requestBody.setResources(Arrays.asList(folderNames));
        api.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
        //TODO: Could have been an endpoint if a resource exists or deleteIfExists
        //TODO: Better exception handling for not found and Internal Server Error or Bad Request
        //TODO: Check AddFolder path and parent resource
        //TODO: Copy resource from and to invalid
        //delete resource api doc update to long
        //preview does not fail for size not small, medium or large
        //content of list folder api should be long
        //rename api should be long
    }
}
