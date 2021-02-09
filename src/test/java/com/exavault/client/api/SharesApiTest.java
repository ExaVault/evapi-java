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
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateDefaultShares(response, body, RESPONSE_CODE_201);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Disabled("API Bug: No error from API when you pass multiple resources for shared folder https://app.asana.com/0/1195625154865746/1199548666006564/f")
		@Test
		@DisplayName("Create a shared_folder share with multiple resources")
		public void sharedFolderWithMultipleResources() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					final String resource1 = createResource();
					final String resource2 = createResource();
					final List<String> ids = new ArrayList<>();
					ids.add(resource1);
					ids.add(resource2);
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

		@Test
		@DisplayName("Create a share with type send")
		public void sendShare() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
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
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final AccessMode accessMode = new AccessMode();
				accessMode.setDownload(true);
				accessMode.setUpload(true);
				accessMode.setDelete(false);
				accessMode.setModify(false);
				body.setAccessMode(accessMode);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
				final ShareAttributes attributes = response.getData().getAttributes();
				assertThat(attributes.getAccessMode().isDownload()).isTrue();
				assertThat(attributes.getAccessMode().isUpload()).isTrue();
				// Disabling assertions because API is returning null rather than false https://app.asana.com/0/956984820471204/1199663247882988/f
				// assertThat(attributes.getAccessMode().isDelete()).isFalse();
				// assertThat(attributes.getAccessMode().isModify()).isFalse();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Create a share with an embed option")
		public void shareWithEmbedOption() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Create a share with recipients")
		public void shareWithRecipients() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Create a share with expiration")
		public void shareWithExpiration() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Create a share with hasNotification")
		public void shareWithHasNotification() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Create a share with public flag")
		public void shareWithPublicFlag() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				body.isPublic(true);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(true, response, body, RESPONSE_CODE_201);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Create a share with an invitation")
		public void shareWithInvitation() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				body.setMessageBody(MESSAGE);
				body.setMessageSubject(MESSAGE_SUBJECT);
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL3);
				body.setRecipients(Collections.singletonList(shareRecipient));
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateSharesWithInvite(response, body, RESPONSE_CODE_201, TEST_EMAIL3, MESSAGE_SUBJECT, MESSAGE);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Create a share with require email")
		public void shareWithRequireEmail() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				body.setRequireEmail(true);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateShares(response, body, RESPONSE_CODE_201, body.getType().getValue());
				assertThat(response.getData().getAttributes().isRequireEmail()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Create a share with fileDropCreateFolders")
		public void shareWithFileDropCreateFolders() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
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
				cleanup(resource);
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
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final EmptyResponse emptyResponse = api.deleteShareById(id, EV_API_KEY, EV_ACCESS_TOKEN);
				validateDeleteResponse(emptyResponse);
				assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
					@Override
					public void call() throws ApiException {
						api.getShareById(id, EV_API_KEY, EV_ACCESS_TOKEN, null);
					}
				}).isInstanceOf(ApiException.class)
						.hasMessageContaining(NOT_FOUND);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				cleanup(resource);
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
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareResponse response1 = api.getShareById(id, EV_API_KEY, EV_ACCESS_TOKEN, null);
				assertThat(response1.getData().getId()).isEqualTo(id);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Get a share with valid id and include")
		public void getShareWithIncludeTest() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareResponse response1 = api.getShareById(id, EV_API_KEY, EV_ACCESS_TOKEN, NOTIFICATIONS);
				assertThat(response1.getData().getId()).isEqualTo(id);
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
				cleanup(resource);
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
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("List shares by an invalid type")
		public void listByAnInvalidType() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("List shares by offset")
		public void listByOffset() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response0 = 
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
							null, null, null, null, null,
							null, null, null, null);				
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, _1, null,
								null, null, null, null, null,
								null, null, null, null);
				if (response1.getData().size() > 0) {
					// If for some reason there are existing shares in the account, just verify that 
					// the offset skips the first response
					int firstIdResponse0 = response0.getData().get(_0).getId();
					int firstIdResponse1 = response1.getData().get(_0).getId();
					assertThat(firstIdResponse0 != firstIdResponse1).isTrue();
				} else {
					// If the account has no other shares, there should be nothing returned with offset >= 1
					assertThat(response1.getReturnedResults()).isZero();
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Disabled("API Bug for wrong error message https://app.asana.com/0/956984820471204/1199657062477813/f")
		@Test
		@DisplayName("List shares by an invalid offset")
		public void listByInvalidOffset() {
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
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
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
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
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
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								ALL, null, null, null, null,
								null, null, null, null);
				final ShareCollectionResponse response2 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, null, null,
								null, null, null, null);
				for (int i = 0; i < response1.getData().size(); i++) {
					assertThat(response1.getData().get(i).getId()).isEqualTo(response2.getData().get(i).getId());
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("List shares by include")
		public void listByInclude() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, OWNER, null,
								null, null, null, null);
				for (final Object o : response1.getIncluded()) {
					final LinkedTreeMap map = (LinkedTreeMap) o;
					assertThat(map.get(TYPE)).isEqualTo(USER);
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("List shares by name")
		public void listByName() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("List shares by recipients")
		public void listByRecipients() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("List shares by username")
		public void listByUsername() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareCollectionResponse response1 =
						api.listShares(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
								null, null, null, OWNER, null,
								null, null, VALID_USER_NAME, null);
				for (final Object o : response1.getIncluded()) {
					final LinkedTreeMap map = (LinkedTreeMap) o;
					final LinkedTreeMap attributes = (LinkedTreeMap) map.get(ATTRIBUTES);
					assertThat(attributes.get(USERNAME)).isEqualTo(VALID_USER_NAME);
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}
	}

	@Nested
	@DisplayName("Complete send files, Method=POST, API=/complete-send/{id} ")
	class CompleteSendFiles {
		@Test
		@DisplayName("Complete send files with valid id")
		public void completeSend() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createSendShare(resource);
				body.setSendingLocalFiles(true);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final ShareResponse shareResponse = api.completeDirectSend(EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareResponse shareById = api.getShareById(id, EV_API_KEY, EV_ACCESS_TOKEN, null);
				assertThat(shareById.getData().getAttributes().getAccessMode().isUpload()).isNull();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
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

	private String createResource() throws ApiException {
		final AddFolderRequestBody requestBody = new AddFolderRequestBody();
		final String path = generateRandomName(BASE_FOLDER_);
		requestBody.setPath(path);
		resourcesApi.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
		return path;
	}

	@Nested
	@DisplayName("Update a share, Method=PATCH, API=/shares/{id} ")
	class UpdateShares {
		@Test
		@DisplayName("Update Name")
		public void updateName() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Update resources")
		public void updateResources() throws ApiException {
			int id = _1;
			String resource = null;
			String resource2 = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				resource2 = createResource();
				body1.setResources(Collections.singletonList(resource2));
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				assertThat(shareAttributes.getPaths()).containsExactly(resource2);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource, resource2);
			}
		}

		@Test
		@DisplayName("Update embed flag")
		public void updateEmbedFlag() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Update access mode")
		public void updateAccessMode() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Update recipients")
		public void updateRecipients() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL4);
				body1.setRecipients(Collections.singletonList(shareRecipient));
				final ShareResponse shareResponse = api.updateShareById(body1, EV_API_KEY, EV_ACCESS_TOKEN, id);
				final ShareAttributes shareAttributes = validateAndGetSharesAttributes(shareResponse, RESPONSE_CODE_200);
				//TODO: Models are inconsistent https://app.asana.com/0/956585750779720/1199663247882984/f
				assertThat(shareAttributes.getRecipients().get(_0).getEmail()).isEqualTo(TEST_EMAIL4);
				assertThat(shareAttributes.getRecipients().get(_0).getType().getValue()).isEqualTo(DIRECT_EMAIL);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(resource);
			}
		}

		@Disabled("API Bug: hasNotification flag does not update as expected - https://app.asana.com/0/1195625154865746/1199663247882990/f")
		@Test
		@DisplayName("Update has Notification")
		public void updateHasNotification() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
				final ShareResponse response = api.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateShareRequestBody body1 = new UpdateShareRequestBody();
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL4);
				body1.setRecipients(Collections.singletonList(shareRecipient));
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Update is public flag")
		public void updateIsPublic() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Update expiration")
		public void updateExpiration() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createDefaultShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Update require email")
		public void updateRequireEmail() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createSendShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Update fileDropCreateFolders")
		public void updateFileDropCreateFolders() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
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
				cleanup(resource);
			}
		}

		@Test
		@DisplayName("Update status")
		public void updateStatus() throws ApiException {
			int id = _1;
			String resource = null;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
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
				cleanup(resource);
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
