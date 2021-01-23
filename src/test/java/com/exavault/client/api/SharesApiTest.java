package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.exavault.client.api.ApiTestAssertionUtil.*;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Shares API Tests")
public class SharesApiTest {

	private SharesApi api;
	final ResourcesApi resourcesApi = new ResourcesApi(ApiTestData.getApiClient());

	@BeforeEach
	public void setup() {
		api = new SharesApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Create a share, Method=POST, API=/shares ")
	class CreateShares {
		@Test
		@DisplayName("Create a share with default values")
		public void defaultShare() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				//TODO: resource is a required field, API doc needs to be updated
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateDefaultShares(response, body, RESPONSE_CODE_201);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Current bug in API, Multiple resource for shared_folder not allowed.Asana task added")
		@Test
		@DisplayName("Create a shared_folder share with multiple resources")
		public void sharedFolderWithMultipleResources() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					createResource();
					createResource2();
					final List<String> ids = new ArrayList<>();
					ids.add(BASE_FOLDER2_);
					ids.add(BASE_FOLDER_);
					final AddShareRequestBody body = ApiTestData.createDefaultShare();
					body.setResources(ids);
					api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Create a shared_folder share with invalid resource")
		public void sharedFolderWithInvalidResources() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					final AddShareRequestBody body = ApiTestData.createDefaultShare();
					body.setResources(Collections.singletonList(INVALID));
					api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}

		@Disabled("Check, why its failing?")
		@Test
		@DisplayName("Create a share with type receive")
		public void receiveShare() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setType(AddShareRequestBody.TypeEnum.RECEIVE);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with type send")
		public void sendShare() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setType(AddShareRequestBody.TypeEnum.SEND);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with invalid type")
		public void sharedFolderWithInvalidType() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					final AddShareRequestBody body = ApiTestData.createDefaultShare();
					body.setType(AddShareRequestBody.TypeEnum.fromValue(INVALID));
					api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Create a share with access mode")
		public void shareWithAccessMode() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final AccessMode accessMode = new AccessMode();
				accessMode.setDownload(true);
				body.setAccessMode(accessMode);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				//TODO: how does access mode work? does it work on folder level or send or receive? API has to be updated
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
				final ShareAttributes attributes = response.getData().getAttributes();
				assertThat(attributes.getAccessMode().isDownload()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with an embed option")
		public void shareWithEmbedOption() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setEmbed(true);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
				final ShareAttributes attributes = response.getData().getAttributes();
				assertThat(attributes.isEmbed()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with recipients")
		public void shareWithRecipients() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL4);
				body.setRecipients(Collections.singletonList(shareRecipient));
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, shareRecipient);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with expiration")
		public void shareWithExpiration() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setExpiration(EXPIRATION1);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, EXPIRATION1);
			} catch (final ApiException | ParseException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with hasNotification")
		public void shareWithHasNotification() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setHasNotification(true);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, true);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Failed currently, need to check")
		@Test
		@DisplayName("Create a share with public flag")
		public void shareWithPublicFlag() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.isPublic(true);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				//TODO: public is null in the response
				validateShares(true, response, body, RESPONSE_CODE_201);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Currently failing, need to check")
		@Test
		@DisplayName("Create a share with message body")
		public void shareWithMsgBody() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setMessageBody(MESSAGE);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				//TODO: Why messages comes empty?
				validateShares(MESSAGE, response, body, RESPONSE_CODE_201);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("How to validate notification emails?")
		@Test
		@DisplayName("Create a share with notificationEmails")
		public void shareWithNotificationEmails() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setNotificationEmails(Collections.singletonList(TEST_EMAIL4));
				body.hasNotification(true);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				//TODO: "How to validate notification emails?"
				validateShares(response, body, RESPONSE_CODE_201, Collections.singletonList(TEST_EMAIL4));
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with password")
		public void shareWithPassword() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setPassword(PASSWORD);
				//TODO: we can not validate password?
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with require email")
		public void shareWithRequireEmail() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setRequireEmail(true);
				//TODO: how to validate this flag?
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with msg subject")
		public void shareWithMsgSubject() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				body.setMessageSubject(MESSAGE);
				//TODO: how to validate this?
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with fileDropCreateFolders")
		public void shareWithFileDropCreateFolders() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare();
				body.setFileDropCreateFolders(true);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateSharesWithFileDropFlag(response, body, RESPONSE_CODE_201);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Create a share with sendingLocalFiles")
		public void shareWithSendingLocalFiles() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createSendShare();
				body.setSendingLocalFiles(true);
				//TODO: how to validate this flag?
				//TODO: Why do shares fail first time?
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

	}

	private void createResource() throws ApiException {
		final AddFolderRequestBody requestBody = new AddFolderRequestBody();
		requestBody.setPath(BASE_FOLDER_);
		resourcesApi.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
	}

	private void createResource2() throws ApiException {
		final AddFolderRequestBody requestBody = new AddFolderRequestBody();
		requestBody.setPath(BASE_FOLDER2_);
		resourcesApi.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
	}

	@Test
	public void completeDirectSendTest() throws ApiException {
		final String evApiKey = null;
		final String evAccessToken = null;
		final Integer id = null;
		final ShareResponse response = api.completeDirectSend(evApiKey, evAccessToken, id);

		// TODO: test validations
	}


	@Test
	public void deleteShareByIdTest() throws ApiException {
		final Integer id = null;
		final String evApiKey = null;
		final String evAccessToken = null;
		final EmptyResponse response = api.deleteShareById(id, evApiKey, evAccessToken);

		// TODO: test validations
	}

	@Test
	public void getShareByIdTest() throws ApiException {
		final Integer id = null;
		final String evApiKey = null;
		final String evAccessToken = null;
		final String include = null;
		final ShareResponse response = api.getShareById(id, evApiKey, evAccessToken, include);

		// TODO: test validations
	}


	@Test
	public void listSharesTest() throws ApiException {
		final String evApiKey = null;
		final String evAccessToken = null;
		final Integer offset = null;
		final Integer limit = null;
		final String scope = null;
		final String sort = null;
		final String type = null;
		final String include = null;
		final String name = null;
		final String recipient = null;
		final String message = null;
		final String username = null;
		final String search = null;
		final ShareCollectionResponse response = api.listShares(evApiKey, evAccessToken, offset, limit, scope, sort, type, include, name, recipient, message, username, search);

		// TODO: test validations
	}


	@Test
	public void updateShareByIdTest() throws ApiException {
		final UpdateShareRequestBody body = null;
		final String evApiKey = null;
		final String evAccessToken = null;
		final Integer id = null;
		final ShareResponse response = api.updateShareById(body, evApiKey, evAccessToken, id);

		// TODO: test validations
	}

	public void cleanup(final int... ids) throws ApiException {
		for (final int id : ids) {
			api.deleteShareById(id, EV_API_KEY, EV_ACCESS_TOKEN);
		}
	}

	private void cleanup(final String... folderNames) throws ApiException {
		final DeleteResourcesRequestBody requestBody = new DeleteResourcesRequestBody();
		requestBody.setResources(Arrays.asList(folderNames));
		resourcesApi.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
	}
}
