package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.EmptyResponse;
import com.exavault.client.model.SendReferralEmailRequestBody;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Email API Tests")
public class EmailApiTest {
	private EmailApi api;

	@BeforeEach
	public void setup() {
		api = new EmailApi(ApiTestData.getApiClient());
	}


	@Nested
	@DisplayName("Resend welcome email to specific user, Method=POST, API=/email/welcome/{username} ")
	class ResentEmail {
		@Test
		@DisplayName("Resend welcome email to specific user")
		public void resendEmailTest() throws ApiException {
			try {
				final SendReferralEmailRequestBody body = new SendReferralEmailRequestBody();
				//TODO: how to set username? is it applicable here?
				final EmptyResponse response = api.sendReferralEmail(EV_API_KEY, EV_ACCESS_TOKEN, body);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}
	}

	@Nested
	@DisplayName("Send referral email to a given address, Method=POST, API=/email/referral")
	class SendReferral {
		@Test
		@DisplayName("Send referral email to a given address")
		public void sendReferralEmailsValid() {
			try {
				final SendReferralEmailRequestBody body = new SendReferralEmailRequestBody();
				body.setMessage(MESSAGE);
				final List<String> emails = new ArrayList<>();
				emails.add(TEST_EMAIL);
				emails.add(TEST_EMAIL2);
				emails.add(TEST_EMAIL3);
				body.setEmails(emails);
				final EmptyResponse response = api.sendReferralEmail(EV_API_KEY, EV_ACCESS_TOKEN, body);
				assertThat(response).isNotNull();
				assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_201);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Send referral email without message")
		public void sendReferralEmailsWithoutMessage() {
			final SendReferralEmailRequestBody body = new SendReferralEmailRequestBody();
			final List<String> emails = new ArrayList<>();
			emails.add(TEST_EMAIL);
			emails.add(TEST_EMAIL2);
			emails.add(TEST_EMAIL3);
			body.setEmails(emails);
			assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
				@Override
				public void call() throws ApiException {
					api.sendReferralEmail(EV_API_KEY, EV_ACCESS_TOKEN, body);
				}
			}).isInstanceOf(ApiException.class)
					.hasMessageContaining(BAD_REQUEST);
		}
	}
}
