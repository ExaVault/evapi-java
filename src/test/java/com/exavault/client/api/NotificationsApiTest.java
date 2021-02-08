package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import com.google.gson.internal.LinkedTreeMap;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.*;

import java.util.Collections;

import static com.exavault.client.api.ApiTestAssertionUtil.*;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Notification API Tests")
public class NotificationsApiTest {

	private NotificationsApi api;

	@BeforeEach
	public void setup() {
		api = new NotificationsApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Create a new notification, Method=POST, API=/notifications ")
	class CreateNotification {
		@Test
		@DisplayName("Create a notification with default values")
		public void addNotificationTest() throws ApiException {
			int id = _1;
			try {
				final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
				final NotificationResponse response = api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateDefaultNotification(response, body, false);
				//TODO: Wrong error message i.e 500 when we try to create a same Notification Bug added in Asana
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Create a notification with non existing resource")
		public void addNotificationOnNonExistingResource() {
			final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
			body.setResource(INVALID);
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}

		@Test
		@DisplayName("Create a notification with non existing action")
		public void addNotificationWithNonExistingAction() {
			final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
			body.setAction(AddNotificationRequestBody.ActionEnum.fromValue(INVALID));
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Create a notification with non existing user")
		public void addNotificationWithNonExistingUser() throws ApiException {
			int id = _1;
			try {
				final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
				body.setUsernames(Collections.singletonList(INVALID));
				//TODO: there should be a validation for the user name? bug added in Asana.
				final NotificationResponse response = api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateDefaultNotification(response, body, false);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Create a notification with recipients")
		public void addNotificationWithRecipients() throws ApiException {
			int id = _1;
			try {
				final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
				body.setRecipients(Collections.singletonList(TEST_EMAIL3));
				final NotificationResponse response = api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateDefaultNotification(response, body, true);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Create a notification with custom message")
		public void addNotificationWithCustomMessage() throws ApiException {
			int id = _1;
			try {
				final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
				body.setMessage(MESSAGE);
				final NotificationResponse response = api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				validateDefaultNotification(response, body, false, true);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}
	}

	@Nested
	@DisplayName("Delete a notification, Method=DELETE, API=/notifications/{id} ")
	class DeleteNotification {
		@Test
		@DisplayName("Delete a notification with valid id")
		public void deleteNotificationTest() {
			int id = _1;
			try {
				id = createRandomNotification();
				final EmptyResponse emptyResponse = api.deleteNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id);
				validateDeleteResponse(emptyResponse);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Delete a notification with an invalid id")
		public void deleteUserWithUnknownIdTest() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.deleteNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, -_1000);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}

	@Nested
	@DisplayName("Get notification details, Method=GET, API=/notifications/{id} ")
	class GetNotificationDetails {
		@Test
		@DisplayName("Get notification details with valid id")
		public void getNotificationDetails() throws ApiException {
			int id = _1;
			try {
				final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
				final NotificationResponse addNotification = api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = addNotification.getData().getId();
				final NotificationResponse response = api.getNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id, null);
				validateDefaultNotification(response, body, false, false, RESPONSE_CODE_200);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Get notification details with valid id and include")
		public void getNotificationDetailsWithInclude() throws ApiException {
			int id = _1;
			try {
				final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
				final NotificationResponse addNotification = api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = addNotification.getData().getId();
				final NotificationResponse response = api.getNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id, RESOURCE);
				validateDefaultNotification(response, body, false, false, RESPONSE_CODE_200);
				assertThat(response.getIncluded()).isNotEmpty();
				for (final Object o : response.getIncluded()) {
					final LinkedTreeMap map = (LinkedTreeMap) o;
					assertThat(map.get(TYPE)).isEqualTo(RESOURCE);
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Get notification details with an invalid id")
		public void getNotificationDetailsWithUnknownIdTest() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, -_1000, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}

	@Nested
	@DisplayName("Update a new notification, Method=PATCH, API=/notifications/{id} ")
	class UpdateNotification {
		@Test
		@DisplayName("Update a notification with a new action")
		public void updateAction() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final UpdateNotificationByIdRequestBody body = new UpdateNotificationByIdRequestBody();
				body.action(UpdateNotificationByIdRequestBody.ActionEnum.ALL);
				final NotificationResponse response = api.updateNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				validateUpdatedActionNotification(response, body.getAction().getValue());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Update a notification with usernames")
		public void updateUsernames() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final UpdateNotificationByIdRequestBody body = new UpdateNotificationByIdRequestBody();
				body.setUsernames(Collections.singletonList(USERNAME));
				final NotificationResponse response = api.updateNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				validateUpdatedUsernamesNotification(response, body.getUsernames().get(_0));
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Update send email")
		public void updateSendEmail() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final UpdateNotificationByIdRequestBody body = new UpdateNotificationByIdRequestBody();
				body.setSendEmail(false);
				final NotificationResponse response = api.updateNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				validateUpdatedSendEmailNotification(response, false);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Update recipients")
		public void updateRecipients() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final UpdateNotificationByIdRequestBody body = new UpdateNotificationByIdRequestBody();
				body.setRecipients(Collections.singletonList(TEST_EMAIL2));
				final NotificationResponse response = api.updateNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				validateUpdatedRecipientsNotification(response, body.getRecipients().get(_0));
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Update custom message")
		public void updateMsg() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final UpdateNotificationByIdRequestBody body = new UpdateNotificationByIdRequestBody();
				body.setMessage(MESSAGE);
				final NotificationResponse response = api.updateNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				validateUpdatedMsgNotification(response, body.getMessage());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}
	}

	@Nested
	@DisplayName("Get a list of notifications, Method=GET, API=/notifications ")
	class ListNotifications {
		@Test
		@DisplayName("List notifications by type")
		public void listByType() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final NotificationCollectionResponse response =
						api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, FOLDER_TYPE,
								null, null, null, null, null);
				validateListNotificationByType(response, FOLDER_TYPE);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List notifications by invalid type")
		public void listByInvalidType() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, INVALID,
							null, null, null, null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Disabled("Known bug in the API")
		@Test
		@DisplayName("List notifications by offset")
		public void listByOffset() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final NotificationCollectionResponse response =
						api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
								_1, null, null, null, null);
				//TODO: Offset does not seems to be working? Asana task is created.
				assertThat(response.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List notifications by an invalid offset")
		public void listByAnInvalidOffset() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
							-_1000, null, null, null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List notifications by sort")
		public void listBySort() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final NotificationCollectionResponse response =
						api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
								null, TYPE, null, null, null);
				assertThat(response).isNotNull();
				assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List notifications by an invalid sort")
		public void listByAnInvalidSort() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
							null, INVALID, null, null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List notifications by limit")
		public void listByLimit() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final NotificationCollectionResponse response =
						api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
								null, null, _1, null, null);
				assertThat(response.getReturnedResults()).isEqualTo(_1);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List notifications by an invalid limit")
		public void listByAnInvalidLimit() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
							null, null, -_1000, null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List notifications by include")
		public void listByInclude() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final NotificationCollectionResponse response =
						api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
								null, null, null, RESOURCE, null);
				for (final Object o : response.getIncluded()) {
					final LinkedTreeMap map = (LinkedTreeMap) o;
					assertThat(map.get(TYPE)).isEqualTo(RESOURCE);
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Disabled("API not returning an error for invalid includes https://app.asana.com/0/1195625154865746/1199888654991076/f")
		@Test
		@DisplayName("List notifications by an invalid include")
		public void listByAnInvalidInclude() {
			try {
				final NotificationCollectionResponse response =
						api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
								null, null, null, INVALID, null);
				assertThat(response.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("List notifications by action")
		public void listByAction() throws ApiException {
			int id = _1;
			try {
				id = createRandomNotification();
				final NotificationCollectionResponse response =
						api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
								null, null, null, null, UPLOAD2);
				final NotificationCollectionResponse response2 =
						api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
								null, null, null, null, ALL);
				validateListNotificationByAction(response, UPLOAD2);
				assertThat(!response2.getReturnedResults().equals(response.getReturnedResults()));
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List notifications by an invalid action")
		public void listByAnInvalidAction() throws ApiException {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listNotifications(EV_API_KEY, EV_ACCESS_TOKEN, null,
							null, null, null, null, INVALID);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}
	}

	public void cleanup(final int... ids) throws ApiException {
		for (final int id : ids) {
			api.deleteNotificationById(EV_API_KEY, EV_ACCESS_TOKEN, id);
		}
	}

	private int createRandomNotification() throws ApiException {
		final AddNotificationRequestBody body = ApiTestData.createDefaultNotification();
		final NotificationResponse response = api.addNotification(EV_API_KEY, EV_ACCESS_TOKEN, body);
		return response.getData().getId();
	}
}
