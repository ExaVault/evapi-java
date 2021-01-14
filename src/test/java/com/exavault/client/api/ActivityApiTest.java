package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.SessionActivityResponse;
import com.exavault.client.model.WebhooksActivityResponse;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.*;
import org.threeten.bp.OffsetDateTime;

import static com.exavault.client.api.ApiTestAssertionUtil.*;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Activity API Tests")
public class ActivityApiTest {
	private ActivityApi api;

	@BeforeEach
	public void setup() {
		api = new ActivityApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Get Session Logs, Method=GET, API=/activity/session ")
	class SessionLogs {
		@Test
		@DisplayName("Session logs with default values")
		public void getSessionLogs() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								null, null, null, null);
				validateSessionLogs(response);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs with start and end date")
		public void getSessionLogsWithStartAndEndDates() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								OffsetDateTime.now().minusDays(_10), OffsetDateTime.now(), null, null, null,
								null, null, null, null);
				validateSessionLogs(response);
				validateDates(response, OffsetDateTime.now().minusDays(_10), OffsetDateTime.now());
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		/* Disabled for outstanding API bug */
		@Disabled
		@Test
		@DisplayName("Session logs with no matching dates")
		public void getSessionLogsWithNoMatchingStartAndEndDates() throws ApiException {
			final SessionActivityResponse response = api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
					OffsetDateTime.now().minusDays(_1000), OffsetDateTime.now().minusDays(_900),
					null, null, null,
					null, null, null, null);
			assertThat(response.getReturnedResults()).isZero();
			//TODO: Error in API, if no records found, Invalid end data is returned, should be zero records, checked from webapp, postman as well
		}

		@Test
		@DisplayName("Session logs invalid ipaddress as filter")
		public void getSessionLogsWithInvalidIpAddress() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, INVALID, null, null,
								null, null, null, null);
				validateSessionLogs(response);
				assertThat(response.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs valid local ipaddress as filter")
		public void getSessionLogsWithIpAddress() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, getExternalIP(), null, null,
								null, null, null, null);
				validateSessionLogs(response);
				validateIp(response, getExternalIP());
			} catch (final Exception e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs with username")
		public void getSessionLogsWithUserName() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, VALID_USER_NAME, null,
								null, null, null, null);
				validateSessionLogs(response);
				validateUserName(response, VALID_USER_NAME);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs invalid username as filter")
		public void getSessionLogsWithInvalidUserName() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, INVALID, null,
								null, null, null, null);
				validateSessionLogs(response);
				assertThat(response.getReturnedResults()).isZero();
				//TODO: should be zero, does not work - Amy to check? API itself is returning returned results as 50
				//checked Postman, so its not Java API which is putting the result to 50.
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs with path")
		public void getSessionLogsWithPath() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, BASE_FOLDER_,
								null, null, null, null);
				validateSessionLogs(response); //TODO: should fetch only logs with the given path, not working as expected
				//TODO: Should be get session logs on the Documentation page as well
				//TODO : checked from webapi, it also failed there.
				validatePath(response);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs invalid path as filter")
		public void getSessionLogsWithInvalidPath() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, INVALID,
								null, null, null, null);
				validateSessionLogs(response);
				assertThat(response.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs with valid type")
		public void getSessionLogsWithValidType() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								DELETE_TYPE, null, null, null);
				validateSessionLogs(response);
				validateType(response, DELETE_TYPE);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs invalid type as filter")
		public void getSessionLogsWithInvalidType() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								INVALID, null, null, null);
				validateSessionLogs(response);
				assertThat(response.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs with valid offset")
		public void getSessionLogsWithValidOffset() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								null, null, null, null);
				final int totalResults = response.getTotalResults();
				if (totalResults > 2) {
					final int offset = 2;
					final SessionActivityResponse response2 =
							api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
									null, null, null, null, null,
									null, offset, null, null);
					final int totalResults2 = response2.getTotalResults();
					assertThat(totalResults2).isEqualTo(totalResults - offset);
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs invalid offset as filter")
		public void getSessionLogsWithInvalidOffset() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
							null, null, null, null, null,
							null, -_1000, null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Session logs with valid limit")
		public void getSessionLogsWithLimit() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								null, null, _1, null);
				assertThat(response.getReturnedResults()).isEqualTo(_1);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs invalid limit as filter")
		public void getSessionLogsWithInvalidLimit() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
							null, null, null, null, null,
							null, null, -_1000, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Session logs valid sort as filter")
		public void getSessionLogsWithValidSort() {
			try {
				final SessionActivityResponse response =
						api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								null, null, null, USERNAME);
				validateSessionLogs(response);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Session logs invalid sort columns as filter")
		public void getSessionLogsWithInvalidSort() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getSessionLogs(EV_API_KEY, EV_ACCESS_TOKEN,
							null, null, null, null, null,
							null, null, null, INVALID);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}
	}

	@Nested
	@DisplayName("Get Webhooks Logs, Method=GET, API=/activity/webhooks ")
	class WebhookLogs {
		@Test
		@DisplayName("Webhooks logs with default values")
		public void getWebhookLogs() {
			try {
				final WebhooksActivityResponse response =
						api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								null, null);
				assertThat(response).isNotNull();
				validateWebhookLogs(response);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Webhooks logs with valid event type")
		public void getWebhookLogsWithValidEvent() {
			try {
				final WebhooksActivityResponse response =
						api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								UPLOAD, null, null, null, null,
								null, null);
				validateWebhookLogs(response);
				validateEvent(response, UPLOAD);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Webhooks logs with an invalid event type")
		public void getWebhookLogsWithInvalidEvent() {
			try {
				final WebhooksActivityResponse response =
						api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								INVALID, null, null, null, null,
								null, null);
				validateWebhookLogs(response);
				assertThat(response.getReturnedResults()).isEqualTo(_0);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Webhooks logs with valid status code")
		public void getWebhookLogsWithValidStatusCode() {
			try {
				final WebhooksActivityResponse response =
						api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, RESPONSE_CODE_200, null, null, null,
								null, null);
				validateWebhookLogs(response);
				validateStatusCode(response, RESPONSE_CODE_200);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Webhooks logs with an invalid status code")
		public void getWebhookLogsWithInvalidStatusCode() {
			try {
				final WebhooksActivityResponse response =
						api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, _1000, null, null, null,
								null, null);
				validateWebhookLogs(response);
				assertThat(response.getReturnedResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		/* Ignoring this test because of offset bug */
		@Disabled
		@Test
		@DisplayName("Webhooks logs with a valid offset")
		public void getWebhookLogsWithValidOffset() {
			try {
				final WebhooksActivityResponse response =
						api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								null, null);
				final int totalResults = response.getTotalResults();
				if (totalResults > 2) {
					final int offset = 2;
					final WebhooksActivityResponse response2 =
							api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
									null, null, null, null, offset,
									null, null);
					final int totalResults2 = response2.getTotalResults();
					//TODO: test does not take into account the offset.
					assertThat(totalResults2).isEqualTo(totalResults - offset);
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Webhooks logs with an Invalid offset")
		public void getWebhookLogsWithInvalidOffset() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
							null, null, null, null, -_1000,
							null, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Webhooks logs with valid limit")
		public void getWebhookLogsWithValidLimit() {
			try {
				final WebhooksActivityResponse response =
						api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								_10, null);
				validateWebhookLogs(response);
				assertThat(response.getReturnedResults()).isEqualTo(_10);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Webhooks logs with an Invalid limit")
		public void getWebhookLogsWithInvalidLimit() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
							null, null, null, null, null,
							-_1000, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Webhooks logs valid sort as filter")
		public void getWebhookLogsWithValidSortColumn() {
			try {
				final WebhooksActivityResponse response =
						api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
								null, null, null, null, null,
								null, EVENT);
				validateWebhookLogs(response);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Webhooks logs invalid sort columns as filter")
		public void getWebhookLogsWithInvalidValidSortColumn() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getWebhookLogs(EV_API_KEY, EV_ACCESS_TOKEN,
							null, null, null, null, null,
							null, INVALID);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}
	}
}
