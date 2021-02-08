package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import com.google.gson.internal.LinkedTreeMap;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.exavault.client.api.ApiTestAssertionUtil.*;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.*;

public class EmailListsApiTest {

	private EmailListsApi api;

	@BeforeEach
	public void setup() {
		api = new EmailListsApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Create a new email list, Method=POST, API=/email-lists")
	class CreateEmailList {
		@Test
		@DisplayName("Create EmailList")
		public void createEmailList() throws ApiException {
			int id = _1;
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateDefaultEmailList(response, body);
				//TODO: Update API doc to update type i.e emailList, but not EmailList
				id = response.getData().getId();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Create 2 EmailList with same name")
		public void createEmailListWithSameName() throws ApiException {
			int id = _1;
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final String resource = generateRandomName(EMAIL_LIST_NAME);
				body.setName(resource);
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
					@Override
					public void call() throws ApiException {
						final AddEmailListRequestBody body2 = defaultEmailList();
						body2.setName(resource);
						api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body2);
					}
				}).isInstanceOf(ApiException.class)
						.hasMessageContaining(BAD_REQUEST);
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
	@DisplayName("Get individual email group, Method=GET, API=/email-lists/{id}")
	class GetIndividualGroup {
		@Test
		@DisplayName("Get individual email group with valid id")
		public void getEmailList() throws ApiException {
			int id = _1;
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final EmailListResponse response1 = api.getEmailListById(EV_API_KEY, EV_ACCESS_TOKEN, id, null);
				validateDefaultEmailList(response1, body, RESPONSE_CODE_200);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Get individual email group with valid include")
		public void getEmailListWithInclude() throws ApiException {
			int id = _1;
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final EmailListResponse response1 = api.getEmailListById(EV_API_KEY, EV_ACCESS_TOKEN, id, OWNER_USER);
				validateDefaultEmailList(response1, body, RESPONSE_CODE_200);
				assertThat(response1.getIncluded()).isNotEmpty();
				for (final Object o : response.getIncluded()) {
					final LinkedTreeMap map = (LinkedTreeMap) o;
					assertThat(map.get(TYPE)).isEqualTo(USER);
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
		@DisplayName("Get individual email group with an invalid id")
		public void getEmailListWithInvalidId() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getEmailListById(EV_API_KEY, EV_ACCESS_TOKEN, (int) INVALID_ID, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}

	@Nested
	@DisplayName("Delete individual email group, Method=GET, API=/email-lists/{id}")
	class DeleteIndividualGroup {
		@Test
		@DisplayName("Delete individual email group with valid id")
		public void deleteEmailList() {
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				final int id = response.getData().getId();
				final EmptyResponse response1 = api.deleteEmailListById(EV_API_KEY, EV_ACCESS_TOKEN, id);
				validateDeleteResponse(response1);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Delete individual email group with an invalid id")
		public void deleteEmailListWithInvalidId() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.deleteEmailListById(EV_API_KEY, EV_ACCESS_TOKEN, (int) INVALID_ID);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}

	@Nested
	@DisplayName("Get all email groups, Method=GET, API=/email-lists")
	class GetAllEmailGroups {
		@Test
		@DisplayName("Get all email groups with default include")
		public void getAllEmailGroups() throws ApiException {
			int id = _1;
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final EmailListCollectionResponse response1 = api.getEmailLists(EV_API_KEY, EV_ACCESS_TOKEN, null);
				assertThat(response1).isNotNull();
				assertThat(response1.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
				final List<EmailList> data = response1.getData();
				for (final EmailList emailList : data) {
					validateEachEmailGroup(body, emailList);
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
		@DisplayName("Get all email groups with owner include")
		public void getAllEmailGroupsWithOwnerUser() throws ApiException {
			int id = _1;
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final EmailListCollectionResponse response1 = api.getEmailLists(EV_API_KEY, EV_ACCESS_TOKEN, OWNER_USER);
				assertThat(response1).isNotNull();
				assertThat(response1.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
				final List<EmailList> data = response1.getData();
				for (final EmailList emailList : data) {
					validateEachEmailGroup(body, emailList);
					for (final Object o : response.getIncluded()) {
						final LinkedTreeMap map = (LinkedTreeMap) o;
						assertThat(map.get(TYPE)).isEqualTo(USER);
					}
				}
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
	@DisplayName("update an new email list, Method=PATCH, API=/email-lists/{id}")
	class updateEmailList {
		@Test
		@DisplayName("update EmailList with name")
		public void updateEmailListName() throws ApiException {
			int id = _1;
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateEmailListRequestBody bodyNew = new UpdateEmailListRequestBody();
				bodyNew.setName(generateRandomName(EMAIL_ATTR));
				final EmailListResponse response1 = api.updateEmailListById(EV_API_KEY, EV_ACCESS_TOKEN, id, bodyNew);
				assertThat(response1.getData().getAttributes().getName()).startsWith(EMAIL_ATTR);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("update EmailList with emails")
		public void updateEmailListValues() throws ApiException {
			int id = _1;
			try {
				final AddEmailListRequestBody body = defaultEmailList();
				final EmailListResponse response = api.addEmailList(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UpdateEmailListRequestBody bodyNew = new UpdateEmailListRequestBody();
				final List<String> newEmails = new ArrayList<>();
				newEmails.add(TEST_EMAIL4);
				bodyNew.setEmails(newEmails);
				final EmailListResponse response1 = api.updateEmailListById(EV_API_KEY, EV_ACCESS_TOKEN, id, bodyNew);
				assertThat(response1.getData().getAttributes().getEmails()).containsAll(newEmails);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}
	}

	public void cleanup(final int... ids) throws ApiException {
		for (final int id : ids) {
			api.deleteEmailListById(EV_API_KEY, EV_ACCESS_TOKEN, id);
		}
	}
}
