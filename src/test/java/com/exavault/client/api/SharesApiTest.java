package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import com.google.gson.internal.LinkedTreeMap;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.util.*;

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

	@Nested
	@DisplayName("Deactivate a share, Method=DELETE, API=/shares/{id} ")
	class DeactivateShare {
		@Test
		@DisplayName("Deactivate a share with valid id")
		public void deactivateShareTest() throws ApiException {
			final int id;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final EmptyResponse emptyResponse = api.deleteShareById(id, EV_API_KEY, EV_ACCESS_TOKEN);
				validateDeleteResponse(emptyResponse);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Deactivate a share with an invalid id")
		public void deactivateShareWithUnknownIdTest() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.deleteShareById(-_1000, EV_API_KEY, EV_ACCESS_TOKEN);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}

	@Nested
	@DisplayName("Get a share, Method=GET, API=/shares/{id} ")
	class GetShare {
		@Test
		@DisplayName("Get a share with valid id")
		public void getShareTest() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareResponse response1 = api.getShareById(id, EV_API_KEY, EV_ACCESS_TOKEN, null);
				validateDefaultShares(response1, body, RESPONSE_CODE_200);
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
		@DisplayName("Get a share with valid id and include")
		public void getShareWithIncludeTest() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareResponse response1 = api.getShareById(id, EV_API_KEY, EV_ACCESS_TOKEN, NOTIFICATIONS);
				validateDefaultShares(response1, body, RESPONSE_CODE_200);
				for (final Object o : response.getIncluded()) {
					final LinkedTreeMap map = (LinkedTreeMap) o;
					assertThat(map.get(TYPE)).isEqualTo(NOTIFICATIONS);
				}
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
		@DisplayName("Get a share with an invalid id")
		public void getShareWithUnknownIdTest() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getShareById(-_1000, EV_API_KEY, EV_ACCESS_TOKEN, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}


	@Nested
	@DisplayName("Get a list of shares, Method=GET, API=/shares ")
	class ListShares {
		@Test
		@DisplayName("List shares by type")
		public void listByType() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, SHARED_FOLDER, null, null,
								null, null, null, null);
				validateListSharesByType(response1, SHARED_FOLDER);
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
		@DisplayName("List shares by an invalid type")
		public void listByAnInvalidType() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, INVALID, null, null,
								null, null, null, null);
				assertThat(response1.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Need to check the offset")
		@Test
		@DisplayName("List shares by offset")
		public void listByOffset() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, _1, null,
								null, null, null, null, null,
								null, null, null, null);
				//TODO: Is this expected behaviour of offset? it does not return 0
				assertThat(response1.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Know bug, got not found error, should be bad request")
		@Test
		@DisplayName("List shares by an invalid offset")
		public void listByInvalidOffset() {
			//TODO: wrong error message.
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, -_1000, null,
							null, null, null, null, null,
							null, null, null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List shares by sort")
		public void listBySort() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, CREATED, null, null, null,
								null, null, null, null);
				assertThat(response1).isNotNull();
				assertThat(response1.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
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
		@DisplayName("List shares by invalid sort")
		public void listByInvalidSort() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
							null, INVALID, null, null, null,
							null, null, null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List shares by a valid limit")
		public void listByValidLimit() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, _1,
								null, null, null, null, null,
								null, null, null, null);
				assertThat(response1.getReturnedResults()).isEqualTo(_1);
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
		@DisplayName("List shares by invalid limit")
		public void listByInvalidLimit() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, -_1000,
							null, null, null, null, null,
							null, null, null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List shares by a scope")
		public void listByValidScope() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								ALL, null, null, null, null,
								null, null, null, null);
				validateListSharesByScope(response1, ALL);
				//TODO: How to validate the scope?
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
		@DisplayName("List shares by include")
		public void listByInclude() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, NOTIFICATIONS, null,
								null, null, null, null);
				for (final Object o : response1.getIncluded()) {
					final LinkedTreeMap map = (LinkedTreeMap) o;
					assertThat(map.get(TYPE)).isEqualTo(NOTIFICATIONS);
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Why does it return 25 results?")
		@Test
		@DisplayName("List shares by invalid include")
		public void listByInvalidInclude() {
			try {
				//TODO: Why it return 25 results, should it not be 0?
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, INVALID, null,
								null, null, null, null);
				assertThat(response1.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("List shares by name")
		public void listByName() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, null, SHARE_NAME,
								null, null, null, null);
				validateListSharesByName(response1, SHARE_NAME);
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
		@DisplayName("List shares by recipients")
		public void listByRecipients() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare();
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL3);
				body.setRecipients(Collections.singletonList(shareRecipient));
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, null, null,
								TEST_EMAIL3, null, null, null);
				validateListSharesByRecipients(response1, TEST_EMAIL3);
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
		@DisplayName("List shares by message")
		public void listByMessage() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare();
				body.setMessageBody(MESSAGE);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, null, null,
								null, MESSAGE, null, null);
				validateListSharesByMsg(response1, MESSAGE);
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
		@DisplayName("List shares by username")
		public void listByUsername() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, null, null,
								null, null, VALID_USER_NAME, null);
				validateListSharesByUsername(response1, VALID_USER_NAME);
				//TODO : how to validate username?
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
		@DisplayName("List shares by search")
		public void listBySearch() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, null, null,
								null, null, null, SHARE_NAME);
				validateListSharesBySearch(response1, SHARE_NAME);
				//TODO: how do we know which field to validate?
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

	@Nested
	@DisplayName("Complete send files, Method=POST, API=/complete-send/{id} ")
	class CompleteSendFiles {
		@Disabled("How to test this?")
		@Test
		@DisplayName("Complete send files with valid id")
		public void completeSend() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createSendShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareResponse shareResponse = api.completeDirectSend(EV_API_KEY, EV_ACCESS_TOKEN, id);
				validateDefaultShares(shareResponse, body, RESPONSE_CODE_200);
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
		@DisplayName("Complete send files with an invalid id")
		public void completeSendWithInvalidId() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.completeDirectSend(EV_API_KEY, EV_ACCESS_TOKEN, -_1000);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
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


	@Nested
	@DisplayName("Update a share, Method=PATCH, API=/shares/{id} ")
	class UpdateShares {
		@Test
		@DisplayName("Update Name")
		public void updateName() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setName(generateRandomName(NEW_NAME));
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.getName()).startsWith(NEW_NAME);
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
		@DisplayName("Update resources")
		public void updateResources() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				createResource2();
				body1.setResources(Collections.singletonList(BASE_FOLDER2_));
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.getPaths()).containsExactly(BASE_FOLDER2_);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_, BASE_FOLDER2_);
			}
		}

		@Test
		@DisplayName("Update embed flag")
		public void updateEmbedFlag() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setEmbed(true);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.isEmbed()).isTrue();
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
		@DisplayName("Update access mode")
		public void updateAccessMode() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				final AccessMode accessMode = new AccessMode();
				accessMode.setDownload(true);
				body1.setAccessMode(accessMode);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.getAccessMode().isDownload()).isTrue();
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
		@DisplayName("Update recipients")
		public void updateRecipients() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL4);
				body1.setRecipients(Collections.singletonList(shareRecipient));
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				//TODO: why its different sharerecipient vs sharesrecipients
				assertThat(shareAttributes.getRecipients().get(_0).getEmail()).isEqualTo(TEST_EMAIL4);
				assertThat(shareAttributes.getRecipients().get(_0).getType().getValue()).isEqualTo(DIRECT_EMAIL);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Flag is not set correctly, seems like a bug")
		@Test
		@DisplayName("Update has Notification")
		public void updateHasNotification() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setHasNotification(true);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.isHasNotification()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Flag is not set correctly, seems like a bug")
		@Test
		@DisplayName("Update is public flag")
		public void updateIsPublic() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setIsPublic(true);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.isPublic()).isTrue();
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
		@DisplayName("Update expiration")
		public void updateExpiration() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setExpiration(EXPIRATION1);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				final Date parse = dateTimeFormatter2.parse(shareAttributes.getExpiration());
				final Date parse1 = dateTimeFormatter2.parse(EXPIRATION1.toString());
				assertThat(parse).isEqualToIgnoringMillis(parse1);
			} catch (final ApiException | ParseException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Null values for type and body")
		@Test
		@DisplayName("Update msg body")
		public void updateMsgBody() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setMessageBody(MESSAGE);
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL4);
				body1.setMessageSubject(MESSAGE_SUBJECT);
				body1.setRecipients(Collections.singletonList(shareRecipient));
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.getMessages().size()).isGreaterThan(0);
				//TODO : why null values?
				assertThat(shareAttributes.getMessages().get(_0).getAttributes().getBody()).isEqualTo(MESSAGE);
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
		@DisplayName("Update notifications emails")
		public void updateNotificationEmails() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setNotificationEmails(Collections.singletonList(TEST_EMAIL4));
				body1.setHasNotification(true);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				//TODO: how to validate?
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
		@DisplayName("Update password")
		public void updatePassword() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setPassword(generateRandomName(PASSWORD));
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				//TODO: how to validate?
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
		@DisplayName("Update require email")
		public void updateRequireEmail() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createSendShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setRequireEmail(true);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.isRequireEmail()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_);
			}
		}

		@Disabled("Values are null")
		@Test
		@DisplayName("Update msg subject")
		public void updateMsgSubject() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createSendShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setMessageSubject(MESSAGE_SUBJECT);
				body1.setMessageBody(MESSAGE);
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL4);
				body1.setRecipients(Collections.singletonList(shareRecipient));
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.isRequireEmail()).isTrue();
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
		@DisplayName("Update fileDropCreateFolders")
		public void updateFileDropCreateFolders() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setFileDropCreateFolders(true);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.isFileDropCreateFolders()).isTrue();
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
		@DisplayName("Update status")
		public void updateStatus() throws ApiException {
			int id = _1;
			try {
				createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare();
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				body1.setStatus(_0);
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.getStatus().getValue()).isEqualTo(_0);
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
