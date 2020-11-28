package com.exavault.client.api.testdata;

import com.exavault.client.ApiClient;
import com.exavault.client.ApiException;
import com.exavault.client.api.ResourcesApi;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Random;

public class ApiTestData {

	public static final String EV_API_KEY = "evapi-docs-java-d3e28fc300621abc41b067a4b66cff";
	public static final String EV_API_KEY_BAD = "stagingtest-bad";
	public static final String EV_ACCESS_TOKEN = "eeb4512a4cddba9c13495979d6718283ae0c4dd77a6ff879b504d1952e12c369";
	public static final String EV_API_URL = "https://evapi-docs-java.exavault.com/api/v2";
	public static final String BASE_FOLDER_ = "/folder_for_test";
	public static final String COPIED_FOLDER = "/copy/copied_%d";
	public static final String TEST_FOLDER = BASE_FOLDER_ + "/test_%d";
	public static final String DUMMY_ADD_FOLDER_TEST = "dummy_addFolder_Test";
	private static final String FILES = "files";
	public static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final String TEST_ARCHIVE = "test_archive";
	public static final String UNAUTHORIZED = "Unauthorized";
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final String BAD_REQUEST = "Bad Request";
	public static final int RESPONSE_CODE_201 = 201;

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

	private static File[] getAllLocalFiles() {
		URL url = ApiTestData.class.getClassLoader().getResource(FILES);
		if (url != null) {
			String path = url.getPath();
			return new File(path).listFiles();
		}
		return null;
	}

	public static void uploadDummyFiles(ResourcesApi resourcesApi) throws ApiException {
		File[] files = getAllLocalFiles();
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isFile()) {
					uploadFile(resourcesApi, file);
				}
			}
		}
	}

	private static void uploadFile(ResourcesApi resourcesApi, File file) throws ApiException {
		String path = BASE_FOLDER_ + "/" + file.getName();
		int fileSize = (int) file.length();
		final int offsetBytes = 0;
		final boolean resume = false;
		final boolean allowOverwrite = false;
		resourcesApi.uploadFile(EV_API_KEY, EV_ACCESS_TOKEN, path, fileSize, file, offsetBytes, resume, allowOverwrite);
	}
}
