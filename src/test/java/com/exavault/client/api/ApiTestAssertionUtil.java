package com.exavault.client.api;

import com.exavault.client.model.Resource;
import com.exavault.client.model.ResourceAttributes;
import com.exavault.client.model.ResourceCopyMove;
import com.exavault.client.model.ResourceResponse;
import com.google.gson.internal.LinkedTreeMap;

import java.text.ParseException;
import java.util.Date;

import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiTestAssertionUtil {

	public static void validateAddFolderResponse(ResourceResponse response) {
		final String path = validateCommons(response);
		assertThat(path).startsWith(TEST_FOLDER.substring(0, TEST_FOLDER.indexOf("%d")));
	}

	public static void validateAddFolderResponse2(ResourceResponse response) {
		final String path = validateCommons(response);
		assertThat(path).isEqualTo("/" + DUMMY_ADD_FOLDER_TEST);
	}

	public static void validateCompressFilesResponse(ResourceResponse response, String compressName) throws ParseException {
		final String path = validateCommons(response);
		assertThat(path).endsWith(".zip");
		if (compressName != null) {
			assertThat(path).endsWith(compressName);
		} else {
			String timestamp = path.substring(path.lastIndexOf("/") + 1, path.indexOf("."));
			final Date parse = dateTimeFormatter.parse(timestamp);
			assertThat(parse).isBeforeOrEqualTo(new Date());
		}
	}

	private static String validateCommons(ResourceResponse response) {
		final Resource data = response.getData();
		assertThat(data).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_201);
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
		final ResourceAttributes attributes = data.getAttributes();
		assertThat(attributes).isNotNull();
		return attributes.getPath();
	}

	public static void validateCopyResponse(ResourceCopyMove response, String copiedFolder) {
		final Resource data = response.getData();
		final LinkedTreeMap<String, String> meta = (LinkedTreeMap<String, String>) response.getMeta();
		assertThat(data).isNotNull();
		assertThat(meta).isNotNull();
		//assertThat(response.get).isEqualTo(RESPONSE_CODE_201); TODO: How to check the response code
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
		final ResourceAttributes attributes = data.getAttributes();
		assertThat(attributes).isNotNull();
		assertThat(meta.get("path")).isEqualTo(BASE_FOLDER_);
		assertThat(meta.get("destinationPath")).startsWith(copiedFolder);
	}
}
