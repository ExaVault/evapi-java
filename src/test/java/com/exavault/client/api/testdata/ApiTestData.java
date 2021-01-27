package com.exavault.client.api.testdata;

import com.exavault.client.ApiClient;
import com.exavault.client.ApiException;
import com.exavault.client.api.ResourcesApi;
import com.exavault.client.model.AddNotificationRequestBody;
import com.exavault.client.model.AddShareRequestBody;
import com.exavault.client.model.AddUserRequestBody;
import com.exavault.client.model.UsersPermissions;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

public class ApiTestData {

	public static final String EV_API_KEY_BAD = "stagingtest-bad-name";
	public static final String EV_API_KEY = "KEY";
	public static final String EV_ACCESS_TOKEN = "TOKEN";
	public static final String EV_API_URL = "URL";
	public static final String BASE_FOLDER_ = "/folder_for_test";
	public static final String BASE_FOLDER2_ = "/folder_for_test2";
	public static final String COPIED_FOLDER = "/copy/copied_%d";
	public static final String TEST_FOLDER = BASE_FOLDER_ + "/test_%d";
	public static final String DUMMY_ADD_FOLDER_TEST = "dummy_addFolder_Test";
	public static final String FILES = "files";
	public static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat dateTimeFormatter2 = new SimpleDateFormat("yyyy-MM-dd");
	public static final String TEST_ARCHIVE = "test_archive";
	public static final String UNAUTHORIZED = "Unauthorized";
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final String BAD_REQUEST = "Bad Request";
	public static final String NOT_FOUND = "Not Found";
	public static final String DOWNLOAD_ARCHIVE = "download";
	public static final int RESPONSE_CODE_201 = 201;
	public static final int RESPONSE_CODE_200 = 200;
	public static final String COMPRESS_ZIP = "compress_zip";
	public static final String PARENT_PATH = "/";
	public static final String TEST_ZIP = "test.zip";
	public static final String DECOMPRESS_ZIP = "decompress_zip";
	public static final String FAILED_DUE_TO = "Failed due to :";
	public static final String MOVE = "/move";
	public static final String NEW_NAME = "New_Name";
	public static final String DUMMY = "dummy";
	public static final String COPY = "/copy";
	public static final String NO_EXISTING = "/no-existing";
	public static final String IMAGES = "images";
	public static final String FLOWER_PNG = "/flower.png";
	public static final String SMALL = "small";
	public static final String DUMMY_TXT = "/dummy.txt";
	public static final String MEDIUM = "medium";
	public static final int _100 = 100;
	public static final String DOCS = "docs";
	public static final String DOC_1_PDF = "/doc1.pdf";
	public static final String PARENT_RESOURCE = "parentResource";
	public static final String HOME_RESOURCE = "homeResource";
	public static final int _1 = 1;
	public static final int _0 = 0;
	public static final String INVALID = "invalid";
	public static final int _2 = 2;
	public static final String TXT = "*.txt";
	public static final String CSV = "*.csv";
	public static final String FILE_TYPE = "file";
	public static final String DIR_TYPE = "dir";
	public static final String NAME = "name";
	public static final String ZIP = ".zip";
	public static final String _DOT = ".";
	public static final String PATH = "path";
	public static final String DESTINATION_PATH = "destinationPath";
	public static final String SESSION_ACTIVITY = "sessionActivity";
	public static final int _10 = 10;
	public static final int _1000 = 1000;
	public static final int _900 = 900;
	public static final String VALID_USER_NAME = "evapi-docs-java";
	public static final String DELETE_TYPE = "Delete";
	public static final String USERNAME = "username";
	public static final int _50 = 50;
	public static final String WEBHOOK_ACTIVITY = "webhookActivity";
	public static final String UPLOAD = "Upload";
	public static final String UPLOAD2 = "upload";
	public static final String UPLOAD_TREE = "/upload tree";
	public static final String PATH_COLON = "path:";
	public static final String EVENT = "event";
	public static final String TEST_EMAIL = "testuser@example.com";
	public static final String TEST_EMAIL2 = "testuser2@example.com";
	public static final String TEST_EMAIL3 = "testuser3@example.com";
	public static final String TEST_EMAIL4 = "testuser3-dasgfashgfsf-asasjfashjkfashjkf@example.com";
	public static final String TEST_PASSWORD = "testpaSsword8";
	public static final String LA_TIMEZONE = "America/Los_Angeles";
	public static final String DENVER_TIMEZONE = "America/Denver";
	public static final String HYPHEN_SEPARATOR = "-";
	public static final String EMPTY_STRING = "";
	public static final String EMPTY = EMPTY_STRING;
	public static final String TESTUSER = "testuser";
	public static final String USER = "user";
	public static final String USER_ROLE = "user";
	public static final String NICKNAME = "Nickname";
	public static final String NICKNAME_ATTR = "nicknameattr";
	public static final String EMAIL_ATTR = "emailattr";
	public static final String RECIPIENT_ATTR = "recipientAttr";
	public static final String MSG_ATTR = "msgAttr";
	public static final String ROLE_ATTR = "roleattr";
	public static final String STATUS_ATTR = "statusattr";
	public static final String HOMEDIR_ATTR = "homdir";
	public static final String TYPE_ATTR = "typeAttr";
	public static final String SCOPE_ATTR = "scopeAttr";
	public static final String ACTION_ATTRIBUTE = "action";
	public static final String EMAIL_ATTR_FALSE = "emailattr_false";
	public static final String EXPIRATION = "2020-12-12";
	public static final String EXPIRATION2 = "2020-12-13";
	public static final String VALID_NAME = "ValidName";
	public static final String INVALID_USER = "invalid user with space in the name";
	public static final int INVALID_USER_ID = 123;
	public static final String OFFSET_DATE = "date";
	public static final String USERNAME_ATTRIBUTE = "username";
	public static final String SEARCH_ATTRIBUTE = "search";
	public static final String FILENAME_ATTRIBUTE = "filename";
	public static final String OPS_TYPE = "type";
	public static final long INVALID_ID = 123L;
	public static final String HTTP_CHECKIP_AMAZONAWS_COM = "http://checkip.amazonaws.com";
	public static final String ATTRIBUTE_NAME_IP = "IP";
	public static final String WILDCARD = "*";
	public static final String NOTIFICATION = "notification";
	public static final String SHARE = "share";
	public static final String MESSAGE = "Hello There! I am a notification";
	public static final String PASSWORD = "Hello There! I am a Password";
	public static final String FOLDER_TYPE = "folder";
	public static final String TYPE = "type";
	public static final String RESOURCE = "resource";
	public static final String ALL = "all";
	public static final String SHARE_NAME = "Share_Name";
	public static final String DIRECT_EMAIL = "direct";
	public static final int _2021 = 2021;
	public static final int MONTH_12 = 12;
	public static final OffsetDateTime EXPIRATION1 = OffsetDateTime.of(_2021, MONTH_12, MONTH_12, _0, _0, _0, _0, ZoneOffset.UTC);
	public static final String NOTIFICATIONS = "notifications";
	public static final String SHARED_FOLDER = "shared_folder";
	public static final String CREATED = "created";
	public static final String MESSAGE_SUBJECT = "I am a subject";
	public static final String OWNER = "owner";
	public static final String ATTRIBUTES = "attributes";

	private static ApiClient apiClient;
	private static final Random random = new Random();

	public static ApiClient getApiClient() {
		if (apiClient == null) {
			apiClient = new ApiClient();
			apiClient.setBasePath(EV_API_URL);
			apiClient.setReadTimeout(300000);
		}
		return apiClient;
	}

	public static int getRandomNumber() {
		return Math.abs(random.nextInt());
	}

	public static File[] getAllLocalFiles(final String folderName) {
		final URL url = ApiTestData.class.getClassLoader().getResource(folderName);
		if (url != null) {
			final String path = url.getPath();
			return new File(path).listFiles();
		}
		return null;
	}

	public static void uploadDummyFiles(final ResourcesApi resourcesApi) throws ApiException {
		uploadDummyFiles(resourcesApi, FILES);
	}

	public static void uploadDummyFiles(final ResourcesApi resourcesApi, final String folderName) throws ApiException {
		final File[] files = getAllLocalFiles(folderName);
		if (files != null && files.length > 0) {
			for (final File file : files) {
				if (file.isFile()) {
					uploadFile(resourcesApi, file);
				}
			}
		}
	}

	private static void uploadFile(final ResourcesApi resourcesApi, final File file) throws ApiException {
		final String path = BASE_FOLDER_ + PARENT_PATH + file.getName();
		final int fileSize = (int) file.length();
		final int offsetBytes = 0;
		final boolean resume = false;
		final boolean allowOverwrite = false;
		resourcesApi.uploadFile(EV_API_KEY, EV_ACCESS_TOKEN, path, fileSize, file, offsetBytes, resume, allowOverwrite);
	}

	public static AddUserRequestBody createDefault() {
		final AddUserRequestBody requestBody = new AddUserRequestBody();
		requestBody.setEmail(TEST_EMAIL);
		requestBody.setPassword(TEST_PASSWORD);
		requestBody.setHomeResource(BASE_FOLDER_);
		final UsersPermissions permissions = new UsersPermissions()
				.delete(true)
				.download(true)
				.upload(true)
				.modify(true);
		requestBody.setPermissions(permissions);
		requestBody.setRole(AddUserRequestBody.RoleEnum.USER);
		requestBody.setTimeZone(LA_TIMEZONE);
		return requestBody;
	}


	public static AddUserRequestBody createAdmin() {
		final AddUserRequestBody aDefault = createDefault();
		final UsersPermissions permissions = aDefault.getPermissions();
		permissions.list(true).deleteFormData(true).changePassword(true)
				.notification(true).share(true).viewFormData(true);
		aDefault.setPermissions(permissions);
		aDefault.setHomeResource(PARENT_PATH);
		aDefault.setRole(AddUserRequestBody.RoleEnum.ADMIN);
		return aDefault;
	}

	public static String generateRandomName() {
		return generateRandomName(TESTUSER);
	}

	public static String generateRandomName(final String prefix) {
		final UUID uuid = UUID.randomUUID();
		return prefix + HYPHEN_SEPARATOR + uuid.toString().replaceAll(HYPHEN_SEPARATOR, EMPTY)
				+ HYPHEN_SEPARATOR + Math.abs(getRandomNumber());
	}

	public static String getExternalIP() throws Exception {
		final URL externalIP = new URL(HTTP_CHECKIP_AMAZONAWS_COM);
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					externalIP.openStream()));
			return in.readLine();
		} catch (final IOException e) {
			throw new IOException();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (final IOException e) {
					throw new IOException();
				}
			}
		}
	}

	public static AddNotificationRequestBody createDefaultNotification() {
		final AddNotificationRequestBody requestBody = new AddNotificationRequestBody();
		requestBody.setType(AddNotificationRequestBody.TypeEnum.FOLDER);
		requestBody.setResource(PARENT_PATH);
		requestBody.setAction(AddNotificationRequestBody.ActionEnum.UPLOAD);
		requestBody.setUsernames(Collections.singletonList(VALID_USER_NAME));
		requestBody.sendEmail(true);
		return requestBody;
	}

	public static AddShareRequestBody createDefaultShare() {
		return createDefaultShare(BASE_FOLDER_);
	}

	public static AddShareRequestBody createDefaultShare(final String resource) {
		final AddShareRequestBody requestBody = new AddShareRequestBody();
		requestBody.setType(AddShareRequestBody.TypeEnum.SHARED_FOLDER);
		requestBody.setName(generateRandomName(SHARE_NAME));
		requestBody.setResources(Collections.singletonList(resource));
		return requestBody;
	}

	public static AddShareRequestBody createReceiveShare(final String resource) {
		final AddShareRequestBody requestBody = new AddShareRequestBody();
		requestBody.setType(AddShareRequestBody.TypeEnum.RECEIVE);
		requestBody.setName(generateRandomName());
		requestBody.setResources(Collections.singletonList(resource));
		return requestBody;
	}

	public static AddShareRequestBody createSendShare(final String resource) {
		final AddShareRequestBody requestBody = new AddShareRequestBody();
		requestBody.setType(AddShareRequestBody.TypeEnum.SEND);
		requestBody.setName(generateRandomName());
		requestBody.setResources(Collections.singletonList(resource));
		return requestBody;
	}
}
