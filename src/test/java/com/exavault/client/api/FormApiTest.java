package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.exavault.client.api.ApiTestAssertionUtil.validateForm;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.*;

public class FormApiTest {

	private FormApi api = new FormApi();
	final ResourcesApi resourcesApi = new ResourcesApi(ApiTestData.getApiClient());
	final SharesApi sharesApi = new SharesApi(ApiTestData.getApiClient());

	@BeforeEach
	public void setup() {
		api = new FormApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Get receive folder form by Id, Method=GET, API=/forms/{id} ")
	class GetReceiveFormById {
		@Test
		@DisplayName("Get receive folder form by a valid Id")
		public void getFormById() throws ApiException {
			String resource = null;
			int id = _1;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final int formId = response.getData().getAttributes().getFormId();
				final FormResponse formById = api.getFormById(formId, EV_API_KEY, EV_ACCESS_TOKEN, null);
				validateForm(formById, RESPONSE_CODE_200);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				if (resource != null) {
					cleanup(resource);
				}
			}
		}

		@Test
		@DisplayName("Get receive folder form by an invalid Id")
		public void getFormByInvalidId() {
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.getFormById(-_1000, EV_API_KEY, EV_ACCESS_TOKEN, null);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(NOT_FOUND);
		}
	}

	@Nested
	@DisplayName("Get form data entries for a receive, Method=GET, API=/forms/entries/{id} ")
	class GetFormEntries {
		@Test
		@DisplayName("Get form data entries for a receive by a valid Id")
		public void getFormEntriesById() throws ApiException {
			String resource = null;
			int id = _1;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final int formId = response.getData().getAttributes().getFormId();
				final FormEntryResponse formById = api.getFormEntries(EV_API_KEY, EV_ACCESS_TOKEN, formId, null, null);
				assertThat(formById.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
				//TODO: how to add entries, and how to test delete entry as well.
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				if (resource != null) {
					cleanup(resource);
				}
			}
		}
	}

	@Nested
	@DisplayName("Get receive folder form settings, Method=GET, API=/forms ")
	class GetReceiveFormByShareHash {
		@Test
		@DisplayName("Get receive folder form by share hash")
		public void getFormByHash() throws ApiException {
			String resource = null;
			int id = _1;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final String hash = response.getData().getAttributes().getHash();
				final FormResponse formResponse = api.getFormByShareHash(EV_API_KEY, EV_ACCESS_TOKEN, hash, null);
				validateForm(formResponse, RESPONSE_CODE_200);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				if (resource != null) {
					cleanup(resource);
				}
			}
		}

	}


	@Nested
	@DisplayName("Updates a form with given parameters, Method=PATCH, API=/forms/{id} ")
	class UpdateForm {
		@Test
		@DisplayName("Updates a form with given parameters")
		public void updateFormDescription() throws ApiException {
			String resource = null;
			int id = _1;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final int formId = response.getData().getAttributes().getFormId();
				final UpdateFormByIdRequestBody updateFormByIdRequestBody = new UpdateFormByIdRequestBody();
				updateFormByIdRequestBody.setFormDescription(SOME_DESCRIPTION);
				final FormResponse formResponse = api.updateFormById(EV_API_KEY, EV_ACCESS_TOKEN, formId, updateFormByIdRequestBody);
				validateForm(formResponse, RESPONSE_CODE_200);
				assertThat(formResponse.getData().getAttributes().getFormDescription()).isEqualTo(SOME_DESCRIPTION);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				if (resource != null) {
					cleanup(resource);
				}
			}
		}

		@Test
		@DisplayName("Updates a form with given parameters, submitButtonText")
		public void updateSubmitButtonText() throws ApiException {
			String resource = null;
			int id = _1;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final int formId = response.getData().getAttributes().getFormId();
				final UpdateFormByIdRequestBody updateFormByIdRequestBody = new UpdateFormByIdRequestBody();
				updateFormByIdRequestBody.setSubmitButtonText(SOME_TEXT);
				final FormResponse formResponse = api.updateFormById(EV_API_KEY, EV_ACCESS_TOKEN, formId, updateFormByIdRequestBody);
				validateForm(formResponse, RESPONSE_CODE_200);
				assertThat(formResponse.getData().getAttributes().getSubmitButtonText()).isEqualTo(SOME_TEXT);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				if (resource != null) {
					cleanup(resource);
				}
			}
		}

		@Test
		@DisplayName("Updates a form with given parameters, successMessage")
		public void updateSuccessMsg() throws ApiException {
			String resource = null;
			int id = _1;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final int formId = response.getData().getAttributes().getFormId();
				final UpdateFormByIdRequestBody updateFormByIdRequestBody = new UpdateFormByIdRequestBody();
				updateFormByIdRequestBody.setSuccessMessage(MESSAGE);
				final FormResponse formResponse = api.updateFormById(EV_API_KEY, EV_ACCESS_TOKEN, formId, updateFormByIdRequestBody);
				validateForm(formResponse, RESPONSE_CODE_200);
				assertThat(formResponse.getData().getAttributes().getSuccessMessage()).isEqualTo(MESSAGE);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				if (resource != null) {
					cleanup(resource);
				}
			}
		}

		@Test
		@DisplayName("Updates a form with given parameters, cssStyles")
		public void updateCssStyles() throws ApiException {
			String resource = null;
			int id = _1;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final int formId = response.getData().getAttributes().getFormId();
				final UpdateFormByIdRequestBody updateFormByIdRequestBody = new UpdateFormByIdRequestBody();
				updateFormByIdRequestBody.setCssStyles(SOME_STYLE);
				//TODO: no validation done for CSS
				final FormResponse formResponse = api.updateFormById(EV_API_KEY, EV_ACCESS_TOKEN, formId, updateFormByIdRequestBody);
				validateForm(formResponse, RESPONSE_CODE_200);
				assertThat(formResponse.getData().getAttributes().getCssStyles()).isEqualTo(SOME_STYLE);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				if (resource != null) {
					cleanup(resource);
				}
			}
		}

		@Disabled("Form Element Models need updat https://app.asana.com/0/1199226257934550/1199888654991074/f")
		@Test
		@DisplayName("Updates a form with given parameters, elements")
		public void updateElements() throws ApiException {
			String resource = null;
			int id = _1;
			try {
				resource = createResource();
				final AddShareRequestBody body = ApiTestData.createReceiveShare(resource);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				id = response.getData().getId();
				final int formId = response.getData().getAttributes().getFormId();
				final FormResponse formById = api.getFormById(formId, EV_API_KEY, EV_ACCESS_TOKEN, null);
				final UpdateFormByIdRequestBody updateFormByIdRequestBody = new UpdateFormByIdRequestBody();
				final List<FormsidElements> elementsList = new ArrayList<>();
				final FormsidElements elements = new FormsidElements();
				elements.setName(generateRandomName(FORM));
				elementsList.add(elements);
				updateFormByIdRequestBody.setElements(elementsList);
				final FormResponse formResponse = api.updateFormById(EV_API_KEY, EV_ACCESS_TOKEN, formId, updateFormByIdRequestBody);
				validateForm(formResponse, RESPONSE_CODE_200);
				assertThat(formResponse.getData().getAttributes().getElements().size()).isEqualTo(_1);
				assertThat(formResponse.getData().getAttributes().getElements().get(_0).getName()).startsWith(FORM);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (id != _1) {
					cleanup(id);
				}
				if (resource != null) {
					cleanup(resource);
				}
			}
		}
	}

	public void cleanup(final int... ids) throws ApiException {
		for (final int id : ids) {
			sharesApi.deleteShareById(id, EV_API_KEY, EV_ACCESS_TOKEN);
		}
	}

	private void cleanup(final String... folderNames) throws ApiException {
		final DeleteResourcesRequestBody requestBody = new DeleteResourcesRequestBody();
		requestBody.setResources(Arrays.asList(folderNames));
		resourcesApi.deleteResources(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
	}

	private String createResource() throws ApiException {
		final AddFolderRequestBody requestBody = new AddFolderRequestBody();
		final String path = generateRandomName(BASE_FOLDER_);
		requestBody.setPath(path);
		resourcesApi.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);
		return path;
	}

}