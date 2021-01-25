package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class RecipientsApiTest {

	private RecipientsApi api;
	private final SharesApi sharesApi = new SharesApi(ApiTestData.getApiClient());
	final ResourcesApi resourcesApi = new ResourcesApi(ApiTestData.getApiClient());

	@BeforeEach
	public void setup() {
		api = new RecipientsApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Resend invitations to share recipients, Method=POST, API=/recipients/shares/invites/{shareId} ")
	class ResentInvitations {
		@Test
		@DisplayName("resend invitation")
		public void defaultShare() throws ApiException {
			int shareId = _1;
			try {
				final AddFolderRequestBody requestBody = new AddFolderRequestBody();
				requestBody.setPath(BASE_FOLDER_);
				resourcesApi.addFolder(EV_API_KEY, EV_ACCESS_TOKEN, requestBody);

				final AddShareRequestBody body = ApiTestData.createSendShare();
				final SharesRecipients shareRecipient = new SharesRecipients();
				shareRecipient.setType(DIRECT_EMAIL);
				shareRecipient.setEmail(TEST_EMAIL4);
				body.setRecipients(Collections.singletonList(shareRecipient));
				body.setMessageBody(MESSAGE);
				body.setMessageSubject(MESSAGE_SUBJECT);
				final ShareResponse response = sharesApi.addShare(EV_API_KEY, EV_ACCESS_TOKEN, body);
				shareId = response.getData().getId();

				final ShareResponse shareById = sharesApi.getShareById(shareId, EV_API_KEY, EV_ACCESS_TOKEN, null);
				final List<ShareRecipient> recipients = shareById.getData().getAttributes().getRecipients();
				final ShareRecipient shareRecipient1 = recipients.get(_0);
				final int shareRecipient1Id = shareRecipient1.getId();

				final ResendInvitationsRequestBody resendInvitationsRequestBody = new ResendInvitationsRequestBody();
				resendInvitationsRequestBody.setRecipientId(shareRecipient1Id);
				final ShareRecipientsResponse shareRecipientsResponse =
						api.resendInvitationsForShare(EV_API_KEY, EV_ACCESS_TOKEN, shareId, resendInvitationsRequestBody);
				assertThat(shareRecipientsResponse.getResponseStatus()).isEqualTo(RESPONSE_CODE_201);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				if (shareId != _1) {
					cleanup(shareId);
				}
				cleanup(BASE_FOLDER_);
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
}
