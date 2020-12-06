package com.exavault.client.api.testdata;

import com.exavault.client.ApiClient;
import com.exavault.client.ApiException;
import com.exavault.client.api.ResourcesApi;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Random;

public class ApiTestData {

	public static final String EV_API_KEY_BAD = "stagingtest-bad-name";
	public static final String EV_API_KEY = "KEY";
	public static final String EV_ACCESS_TOKEN = "TOKEN";
	public static final String EV_API_URL = "URL";
	public static final String BASE_FOLDER_ = "/folder_for_test";
	public static final String COPIED_FOLDER = "/copy/copied_%d";
	public static final String TEST_FOLDER = BASE_FOLDER_ + "/test_%d";
	public static final String DUMMY_ADD_FOLDER_TEST = "dummy_addFolder_Test";
	public static final String FILES = "files";
	public static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final String TEST_ARCHIVE = "test_archive";
	public static final String UNAUTHORIZED = "Unauthorized";
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final String BAD_REQUEST = "Bad Request";
	public static final String NOT_FOUND = "Not Found";
	public static final String DOWNLOAD_ARCHIVE = "download";
	public static final int RESPONSE_CODE_201 = 201;
	public static final int RESPONSE_CODE_200 = 200;
	public static final String COMPRESS_ZIP = "compress_zip";
	public static final String SEPARATOR_PARENT = "/";
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

	private static ApiClient apiClient;
	private static final Random random = new Random();

	public static ApiClient getApiClient() {
		if (apiClient == null) {
			apiClient = new ApiClient();
			apiClient.setBasePath(EV_API_URL);
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
		final String path = BASE_FOLDER_ + "/" + file.getName();
		final int fileSize = (int) file.length();
		final int offsetBytes = 0;
		final boolean resume = false;
		final boolean allowOverwrite = false;
		resourcesApi.uploadFile(EV_API_KEY, EV_ACCESS_TOKEN, path, fileSize, file, offsetBytes, resume, allowOverwrite);
	}
}
