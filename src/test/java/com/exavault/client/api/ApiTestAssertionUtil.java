package com.exavault.client.api;

import com.exavault.client.model.*;
import com.google.gson.internal.LinkedTreeMap;
import org.threeten.bp.OffsetDateTime;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiTestAssertionUtil {

	public static void validateAddFolderResponse(final ResourceResponse response) {
		final String path = validateCommons(response);
		assertThat(path).startsWith(TEST_FOLDER.substring(0, TEST_FOLDER.indexOf("%d")));
	}

	public static void validateRenameResponse(final ResourceResponse response) {
		final String path = validateCommons(response, RESPONSE_CODE_200);
		assertThat(path).endsWith(NEW_NAME);
	}

	public static void validateUploadResponse(final ResourceResponse response) {
		final String path = validateCommons(response, RESPONSE_CODE_201);
		assertThat(path).contains(DUMMY);
	}

	public static void validateResourceInfo(final ResourceResponse response, final int size) {
		final Resource data = response.getData();
		assertThat(data).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
		final List<Object> included = response.getIncluded();
		assertThat(included).hasSize(size);
	}

	public static void validateDownloadedFile(final File file) {
		assertThat(file).hasName(DOWNLOAD_ARCHIVE + ZIP);
	}

	public static void validateAddFolderResponse2(final ResourceResponse response) {
		final String path = validateCommons(response);
		assertThat(path).isEqualTo(SEPARATOR_PARENT + DUMMY_ADD_FOLDER_TEST);
	}

	public static void validateExtract(final ResourceCollectionResponse response) {
		validateResourcesList(response, _2, RESPONSE_CODE_201,
				SEPARATOR_PARENT + DECOMPRESS_ZIP + SEPARATOR_PARENT + DUMMY);
	}

	public static void validateResourcesList(final ResourceCollectionResponse response, final int size) {
		validateResourcesList(response, size, RESPONSE_CODE_200,
				BASE_FOLDER_ + SEPARATOR_PARENT + DUMMY);
	}

	public static void validateResourcesList(final ResourceCollectionResponse response, final int size,
											 final int responseCode, final String expectedPath) {
		assertThat(response).isNotNull();
		assertThat(response.getReturnedResults()).isEqualTo(size);
		assertThat(response.getResponseStatus()).isEqualTo(responseCode);
		final List<Resource> datas = response.getData();
		assertThat(datas).isNotNull();
		for (final Resource data : datas) {
			assertThat(data.getId()).isInstanceOf(Long.class);
			assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
			final ResourceAttributes attributes = data.getAttributes();
			assertThat(attributes).isNotNull();
			final String path = attributes.getPath();
			assertThat(path).startsWith(expectedPath);
		}
	}

	public static void validatePreview(final PreviewFileResponse response) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final PreviewFile data = response.getData();
		assertThat(data).isNotNull();
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(String.class);
	}

	public static void validateCompressFilesResponse(final ResourceResponse response,
													 final String compressName) throws ParseException {
		final String path = validateCommons(response);
		assertThat(path).endsWith(ZIP);
		if (compressName != null) {
			assertThat(path).endsWith(compressName);
		} else {
			final String timestamp = path.substring(path.lastIndexOf(SEPARATOR_PARENT) + _1, path.indexOf(_DOT));
			final Date parse = dateTimeFormatter.parse(timestamp);
			assertThat(parse).isBeforeOrEqualTo(new Date());
		}
	}

	private static String validateCommons(final ResourceResponse response) {
		return validateCommons(response, RESPONSE_CODE_201);
	}

	private static String validateCommons(final ResourceResponse response, final int responseCode) {
		final Resource data = response.getData();
		assertThat(data).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(responseCode);
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
		final ResourceAttributes attributes = data.getAttributes();
		assertThat(attributes).isNotNull();
		return attributes.getPath();
	}

	public static void validateCopyResponse(final ResourceCopyMove response, final String copiedFolder) {
		final Resource data = response.getData();
		final LinkedTreeMap<String, String> meta = (LinkedTreeMap<String, String>) response.getMeta();
		assertThat(data).isNotNull();
		assertThat(meta).isNotNull();
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
		final ResourceAttributes attributes = data.getAttributes();
		assertThat(attributes).isNotNull();
		assertThat(meta.get(PATH)).isEqualTo(BASE_FOLDER_);
		assertThat(meta.get(DESTINATION_PATH)).startsWith(copiedFolder);
	}

	public static void validateSessionLogs(final SessionActivityResponse response) {
		validateCommonSessionLog(response);
	}

	public static void validateDates(final SessionActivityResponse response, final OffsetDateTime start, final OffsetDateTime end) {
		final List<SessionActivityEntry> data = response.getData();
		for (final SessionActivityEntry entry : data) {
			final SessionActivityEntryAttributes attributes = entry.getAttributes();
			final String created = attributes.getCreated();
			final OffsetDateTime actual = OffsetDateTime.parse(created);
			assertThat(actual).isBetween(start, end);
		}
	}

	public static void validateUserName(final SessionActivityResponse response, final String username) {
		final List<SessionActivityEntry> data = response.getData();
		for (final SessionActivityEntry entry : data) {
			final SessionActivityEntryAttributes attributes = entry.getAttributes();
			final String real = attributes.getUsername();
			assertThat(real).isEqualTo(username);
		}
	}

	public static void validatePath(final SessionActivityResponse response) {
		final List<SessionActivityEntry> data = response.getData();
		for (final SessionActivityEntry entry : data) {
			final SessionActivityEntryAttributes attributes = entry.getAttributes();
			final String real = attributes.getFileName();
			assertThat(real).startsWith(BASE_FOLDER_);
		}
	}

	public static void validateType(final SessionActivityResponse response, final String type) {
		final List<SessionActivityEntry> data = response.getData();
		for (final SessionActivityEntry entry : data) {
			final SessionActivityEntryAttributes attributes = entry.getAttributes();
			final String real = attributes.getOperation();
			assertThat(real).isEqualTo(type);
		}
	}

	private static void validateCommonSessionLog(final SessionActivityResponse response) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final List<SessionActivityEntry> data = response.getData();
		for (final SessionActivityEntry entry : data) {
			assertThat(entry.getId()).isInstanceOf(Long.class);
			assertThat(entry.getType()).isInstanceOf(SessionActivityEntry.TypeEnum.class);
			assertThat(entry.getType().getValue()).isEqualTo(SESSION_ACTIVITY);
			final SessionActivityEntryAttributes attributes = entry.getAttributes();
			assertThat(attributes).isNotNull();
		}
	}
}
