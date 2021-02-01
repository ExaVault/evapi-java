package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import static com.exavault.client.api.ApiTestAssertionUtil.*;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("User API Tests")
public class UsersApiTest {
	private UsersApi api;


	@BeforeEach
	public void setup() {
		api = new UsersApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Create a user, Method=POST, API=/users ")
	class CreateUser {
		@Test
		@DisplayName("Create a user with default values")
		public void addUserTest() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UserAttributes userAttributes = validateUserAndGetAttributes(response, RESPONSE_CODE_201);
				validateUserAttributes(userAttributes, body, false);
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
		@DisplayName("Create a user with missing user name")
		public void addUserTestWithMissingUserName() {
			final AddUserRequestBody body = ApiTestData.createDefault();
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("Create a user with default values and nickname")
		public void addUserWithNicknameTest() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				body.setNickname(NICKNAME);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UserAttributes userAttributes = validateUserAndGetAttributes(response, RESPONSE_CODE_201);
				validateUserAttributes(userAttributes, body, false);
				assertThat(userAttributes.getNickname()).isEqualTo(NICKNAME);
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
		@DisplayName("Create an admin user")
		public void addAdmin() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createAdmin();
				final String userName = generateRandomName();
				body.setUsername(userName);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UserAttributes userAttributes = validateUserAndGetAttributes(response, RESPONSE_CODE_201);
				validateUserAttributes(userAttributes, body, true);
				//TODO: API has to be updated accordingly for all permissions for an admin.
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("Create a user with default values and expiration")
		public void addUserWithExpirationTest() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				body.setExpiration(EXPIRATION);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UserAttributes userAttributes = validateUserAndGetAttributes(response, RESPONSE_CODE_201);
				validateUserAttributes(userAttributes, body, false);
				final Date parse = dateTimeFormatter2.parse(userAttributes.getExpiration());
				final Date parse1 = dateTimeFormatter2.parse(EXPIRATION);
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

		@Test
		@DisplayName("Create a user with default values and locked")
		public void addUserWithLockedTest() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				body.setLocked(true);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UserAttributes userAttributes = validateUserAndGetAttributes(response, RESPONSE_CODE_201);
				validateUserAttributes(userAttributes, body, false);
				assertThat(userAttributes.isLocked()).isTrue();
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
		@DisplayName("Create a user with default values and onboarding  flag")
		public void addUserWithOnboardingTest() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				body.setOnboarding(true);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UserAttributes userAttributes = validateUserAndGetAttributes(response, RESPONSE_CODE_201);
				validateUserAttributes(userAttributes, body, false);
				assertThat(userAttributes.isOnboarding()).isTrue();
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
	@DisplayName("Delete a user, Method=DELETE, API=/users/{id} ")
	class DeleteUser {
		@Test
		@DisplayName("Delete a user with valid id")
		public void deleteUserTest() throws ApiException {
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				final int id = response.getData().getId();
				final EmptyResponse emptyResponse = api.deleteUser(id, EV_API_KEY, EV_ACCESS_TOKEN);
				validateDeleteResponse(emptyResponse);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				cleanup(BASE_FOLDER_);
			}
		}

		@Test
		@DisplayName("Delete a user with an Invalid id")
		public void deleteUserWithUnknownIdTest() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.deleteUser(INVALID_USER_ID, EV_API_KEY, EV_ACCESS_TOKEN);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}

	@Nested
	@DisplayName("Get info of a user, Method=GET, API=/users/{id} ")
	class GetUserById {
		@Test
		@DisplayName("Get user info with a valid id")
		public void getUserInfoTest() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final UserResponse userById = api.getUserById(id, EV_API_KEY, EV_ACCESS_TOKEN, PARENT_RESOURCE);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userById, RESPONSE_CODE_200);
				validateUserAttributes(userAttributes, body, false);
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
		@DisplayName("Get a user with an Invalid id")
		public void getUserWithUnknownIdTest() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getUserById(INVALID_USER_ID, EV_API_KEY, EV_ACCESS_TOKEN, PARENT_RESOURCE);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}


	@Nested
	@DisplayName("Update a user, Method=PATCH, API=/users/{id} ")
	class UpdateUser {
		@Test
		@DisplayName("Update username with a valid value")
		public void updateUsernameTest() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				final String randomUserName = generateRandomName();
				body.setUsername(randomUserName);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.getUsername()).isEqualTo(randomUserName);
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
		@DisplayName("Update username with an Invalid value")
		public void updateInvalidUsernameTest() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setUsername(INVALID_USER);
				//TODO: Wrong type of error message, got NOT FOUND
				final int finalId = id;
				assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
					@Override
					public void call() throws ApiException {
						api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, finalId, body);
					}
				}).isInstanceOf(ApiException.class)
						.hasMessageContaining(NOT_FOUND);
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
		@DisplayName("Update nickname")
		public void updateNicknameTest() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setNickname(NICKNAME);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.getNickname()).isEqualTo(NICKNAME);
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
		@DisplayName("Update home resource")
		public void updateHomeResource() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setHomeResource(COPIED_FOLDER);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.getHomePath()).isEqualTo(COPIED_FOLDER);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(BASE_FOLDER_, COPY);
			}
		}

		@Test
		@DisplayName("Update home resource for Admin")
		public void updateHomeResourceForAdmin() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body2 = ApiTestData.createAdmin();
				final String userName = generateRandomName();
				body2.setUsername(userName);
				final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body2);
				id = response.getData().getId();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setHomeResource(COPIED_FOLDER); //TODO: it is ok to update home resource for admin?
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.getHomePath()).isEqualTo(COPIED_FOLDER);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				cleanup(COPY);
			}
		}

		@Test
		@DisplayName("Update email")
		public void updateEmail() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setEmail(TEST_EMAIL2);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.getEmail()).isEqualTo(TEST_EMAIL2);
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
		@DisplayName("Update Role")
		public void updateRole() throws ApiException {
			int id = _1;
			try {
				id = createUser(); //create an admin
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setRole(UpdateUserRequestBody.RoleEnum.ADMIN); //normal user
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.getRole().getValue()).isEqualTo(UserAttributes.RoleEnum.ADMIN.getValue());
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
		@DisplayName("Update Permissions")
		public void updatePermissions() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				final UserPermissions permissions = new UserPermissions()
						.changePassword(true);
				body.setPermissions(permissions);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.getPermissions().isChangePassword()).isTrue();
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
		@DisplayName("Update TimeZone")
		public void updateTimeZone() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setTimeZone(DENVER_TIMEZONE);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.getTimeZone()).isEqualTo(DENVER_TIMEZONE);
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
		@DisplayName("Update Expiration")
		public void updateExpiration() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setExpiration(EXPIRATION2);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				final Date parse = dateTimeFormatter2.parse(userAttributes.getExpiration());
				final Date parse1 = dateTimeFormatter2.parse(EXPIRATION2);
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

		@Test
		@DisplayName("Update Locked")
		public void updateLocked() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setLocked(true);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.isLocked()).isTrue();
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
		@DisplayName("Update Onboarding")
		public void updateOnboarding() throws ApiException {
			int id = _1;
			try {
				id = createUser();
				final UpdateUserRequestBody body = new UpdateUserRequestBody();
				body.setOnboarding(true);
				final UserResponse userResponse = api.updateUser(EV_API_KEY, EV_ACCESS_TOKEN, id, body);
				final UserAttributes userAttributes = validateUserAndGetAttributes(userResponse, RESPONSE_CODE_200);
				assertThat(userAttributes.isOnboarding()).isTrue();
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
	@DisplayName("Get a list of Users, Method=GET, API=/users ")
	class ListUsers {
		@Test
		@DisplayName("List Users by username only")
		public void listByUsername() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, userName, null,
						null, null, null, null, null, null, null, null,
						null);
				assertThat(response.getTotalResults()).isEqualTo(_1);
				validateListOfUsersByUsername(response, userName);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by nickname only")
		public void listByNickname() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String nickName = generateRandomName(); //random nickname
				final String userName = generateRandomName();
				body.setNickname(nickName);
				body.setUsername(userName);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						nickName, null, null, null, null, null, null, null,
						null);
				validateListOfUsersByNickname(response, nickName);
				assertThat(response.getTotalResults()).isEqualTo(_1);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by nickname wildcard")
		public void listByNicknameWithWildcard() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String nickName = generateRandomName(); //random nickname
				final String userName = generateRandomName();
				body.setNickname(nickName);
				body.setUsername(userName);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						nickName.substring(_0, _10) + WILDCARD, null, null, null, null, null, null, null,
						null);
				validateListOfUsersByNickname(response, nickName);
				assertThat(response.getTotalResults()).isEqualTo(_1);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by an invalid nickname")
		public void listByInvalidNickname() {
			try {
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						INVALID, null, null, null, null, null, null, null,
						null);
				assertThat(response.getTotalResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("List Users by email only")
		public void listByEmail() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setEmail(TEST_EMAIL2);
				body.setUsername(userName);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, TEST_EMAIL2, null, null, null, null, null, null,
						null);
				validateListOfUsersByEmail(response, TEST_EMAIL2);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by an invalid email")
		public void listByInvalidEmail() {
			try {
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, INVALID, null, null, null, null, null, null,
						null);
				assertThat(response.getTotalResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("List Users by email and username, email should be ignored")
		public void listByEmailAndUsername() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setEmail(TEST_EMAIL2);
				body.setUsername(userName);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();

				//TODO: wrong error when we try to create a user with the same name already exist.
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, userName, null,
						null, TEST_EMAIL4, null, null, null, null, null, null,
						null); //email here should be ignored
				assertThat(response.getTotalResults()).isEqualTo(_1);
				validateListOfUsersByEmailFalse(response, TEST_EMAIL3); //none of the user should have this email
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by role")
		public void listByRole() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, USER_ROLE, null, null, null, null, null, null,
						null);
				validateListOfUsersByRole(response, USER_ROLE);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by an invalid role")
		public void listByInvalidRole() {
			try {
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, INVALID, null, null, null, null, null, null,
						null);
				assertThat(response.getTotalResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("List Users by unlocked status")
		public void listByUnlockStatus() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, null, null, _1, null, null, null, null,
						null);
				validateListOfUsersByStatus(response, _1);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by locked status")
		public void listByLockedStatus() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				body.setLocked(true);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, null, null, _0, null, null, null, null,
						null);
				validateListOfUsersByStatus(response, _0);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by invalid status")
		public void listByInvalidStatus() {
			try {
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, null, null, -_1, null, null, null, null,
						null);
				assertThat(response.getTotalResults()).isZero();
				//TODO: should be an error.
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("List Users by homeDir")
		public void listByHomeDir() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, BASE_FOLDER_,
						null, null, null, null, null, null, null, null,
						null);
				validateListOfUsersByHomeDir(response, BASE_FOLDER_);
				//TODO: Not working currently
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by search")
		public void listBySearch() throws ApiException {
			int id = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				body.setEmail(TEST_EMAIL3);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, TEST_EMAIL3, null, null, null, null, null, null,
						null);
				validateListOfUsersByEmail(response, TEST_EMAIL3);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
			}
		}

		@Test
		@DisplayName("List Users by search with non existing value")
		public void listBySearchWithNonExistingValue() {
			try {
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, null, null, null, INVALID, null, null, null,
						null);
				assertThat(response.getTotalResults()).isZero();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("List Users by valid offset")
		public void listByValidOffset() throws ApiException {
			int id = _1, id2 = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				body.setEmail(TEST_EMAIL4);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();

				final AddUserRequestBody body2 = ApiTestData.createDefault();
				final String userName2 = generateRandomName();
				body2.setUsername(userName2);
				body2.setEmail(TEST_EMAIL4);
				final UserResponse response2 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body2);
				id2 = response2.getData().getId();

				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, TEST_EMAIL4, null, null, null, _1, null, _1,
						null);
				//TODO: offset does not work properly, requires a limit
				assertThat(response.getReturnedResults()).isEqualTo(_1);
				validateListOfUsersByEmail(response, TEST_EMAIL4);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1 && id2 != _1) {
					cleanup(id, id2);
				}
			}
		}

		@Test
		@DisplayName("List Users by an invalid offset")
		public void listByInvalidOffset() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
							null, null, null, null, null, -_1, null, null,
							null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List Users by sort")
		public void listByValidSort() {
			try {
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, null, null, null, null, null, USERNAME, null,
						null);
				validateListOfUsersDefault(response);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("List Users by an invalid sort")
		public void listByInvalidSort() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
							null, null, null, null, null, null, INVALID, null,
							null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List Users by valid limit")
		public void listByValidLimit() throws ApiException {
			int id = _1, id2 = _1;
			try {
				final AddUserRequestBody body = ApiTestData.createDefault();
				final String userName = generateRandomName();
				body.setUsername(userName);
				body.setEmail(TEST_EMAIL4);
				final UserResponse response1 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response1.getData().getId();

				final AddUserRequestBody body2 = ApiTestData.createDefault();
				final String userName2 = generateRandomName();
				body2.setUsername(userName2);
				body2.setEmail(TEST_EMAIL4);
				final UserResponse response2 = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body2);
				id2 = response2.getData().getId();
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, TEST_EMAIL4, null, null, null, null, null, _1,
						null);
				assertThat(response.getReturnedResults()).isEqualTo(_1);
				validateListOfUsersByEmail(response, TEST_EMAIL4);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1 && id2 != _1) {
					cleanup(id, id2);
				}
			}
		}

		@Test
		@DisplayName("List Users by an invalid Limit")
		public void listByInvalidLimit() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
							null, null, null, null, null, null, null, -_1,
							null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}

		@Test
		@DisplayName("List Users by include")
		public void listByInclude() {
			try {
				final UserCollectionResponse response = api.listUsers(EV_API_KEY, EV_ACCESS_TOKEN, null, null,
						null, null, null, null, null, null, null, null,
						HOME_RESOURCE);
				validateListOfUsersDefault(response);
				validateListOfUsersNonEmptyInclude(response);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}
	}

	public void cleanup(final int... ids) throws ApiException {
		for (final int id : ids) {
			api.deleteUser(id, EV_API_KEY, EV_ACCESS_TOKEN);
		}
	}

	private void cleanup(final String... folderNames) throws ApiException {
		final ResourcesApi api = new ResourcesApi(ApiTestData.getApiClient());
		final DeleteResourcesRequestBody requestBody = new DeleteResourcesRequestBody();
		requestBody.setResources(Arrays.asList(folderNames));
		api.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
	}

	private int createUser() throws ApiException {
		final AddUserRequestBody body = ApiTestData.createDefault();
		final String userName = generateRandomName();
		body.setUsername(userName);
		final UserResponse response = api.addUser(EV_API_KEY, EV_ACCESS_TOKEN, body);
		return response.getData().getId();
	}
}
