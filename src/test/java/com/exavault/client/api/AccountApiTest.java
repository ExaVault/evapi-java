/*
 * ExaVault API
 * See our API reference documentation at https://www.exavault.com/developer/api-docs/
 *
 * OpenAPI spec version: 2.0
 * Contact: support@exavault.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.api.testdata.ApiTestData;
import com.exavault.client.model.AccountResponse;
import com.exavault.client.model.UpdateAccountRequestBody;
import com.exavault.client.model.AccountAllowedIpRanges;
import com.exavault.client.model.BrandingSettingsValues;
import com.exavault.client.model.AccountAttributes;
import com.exavault.client.model.AccountAttributesAllowedIp;
import com.exavault.client.model.User;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.exavault.client.api.ApiTestAssertionUtil.validateAccountSettings;
import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.AssertionsKt.fail;

@DisplayName("Account API Tests")
public class AccountApiTest {

	private AccountApi api;

	@BeforeEach
	public void setup() {
		api = new AccountApi(ApiTestData.getApiClient());
	}

	@Nested
	@DisplayName("Get account settings, Method=GET, API=/account ")
	class GetAccount {
		@Test
		@DisplayName("Get account settings")
		public void getAccountTest() {
			try {
				final AccountResponse response = api.getAccount(EV_API_KEY, EV_ACCESS_TOKEN, MASTER_USER);
				validateAccountSettings(response);
				for (final Object o : response.getIncluded()) {
					final User user = (User) o;
					assertThat(user.getType()).isEqualTo(USER);
				}
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Get account settings with invalid include")
		public void getAccountTestWithInvalidInclude() {
			try {
				final AccountResponse response = api.getAccount(EV_API_KEY, EV_ACCESS_TOKEN, INVALID);
				assertThat(response.getIncluded()).isEmpty();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}
	}

	@Nested
	@DisplayName("Update account settings, Method=PATCH, API=/account ")
	class UpdateAccount {
		@Disabled("Account request Quota object changed https://app.asana.com/0/995549068566762/1199905572508585/f")
		@Test
		@DisplayName("Update account settings, quotaNoticeEnabled")
		public void updateQuotaNoticeEnabled() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setQuotaNoticeEnabled(true);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().getQuota().isNoticeEnabled()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setQuotaNoticeEnabled(false);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}


		@Disabled("Account request Quota object changed https://app.asana.com/0/995549068566762/1199905572508585/f")
		@Test
		@DisplayName("Update account settings, quotaNoticeThreshold")
		public void updateQuotaNoticeThreshold() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setQuotaNoticeThreshold(NOTICE_THRESHOLD);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().getQuota().getNoticeThreshold()).isEqualTo(NOTICE_THRESHOLD);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setQuotaNoticeThreshold(NOTICE_THRESHOLD_DEFAULT);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}


		@Disabled("API not returning error for bad request https://app.asana.com/0/956984820471204/1199916676837985/f")
		@Test
		@DisplayName("Update account settings, invalid quotaNoticeThreshold")
		public void updateQuotaNoticeInvalidThreshold() {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setQuotaNoticeThreshold(_1);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().getQuota().getNoticeThreshold()).isEqualTo(_1);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Update account settings, secure only")
		public void updateSecureOnly() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setSecureOnly(true);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().isSecureOnly()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setSecureOnly(false);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}

		@Test
		@DisplayName("Update account settings, complex passwords")
		public void updateComplexPassword() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setComplexPasswords(true);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().isComplexPasswords()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setComplexPasswords(false);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}

		@Test
		@DisplayName("Update account settings, show referral links")
		public void updateShowReferralLinks() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setShowReferralLinks(true);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().isShowReferralLinks()).isTrue();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setShowReferralLinks(false);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}

		@Disabled("Not possible to reset to blank https://app.asana.com/0/956984820471204/1199916676837979/f")
		@Test
		@DisplayName("Update account settings, external domain")
		public void updateExternalDomain() {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setExternalDomain(SOME_DOMAIN);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().getExternalDomains().get(_0)).isEqualTo(SOME_DOMAIN);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			}
		}

		@Test
		@DisplayName("Update account settings, email content")
		public void updateEmailContent() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setEmailContent(MESSAGE);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().getWelcomeEmailContent()).isEqualTo(MESSAGE);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setEmailContent(EMAIL_CONTENT_DEFAULT);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}

		@Test
		@DisplayName("Update account settings, email subject")
		public void updateEmailSubject() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setEmailSubject(EMAIL_SUBJECT);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().getWelcomeEmailSubject()).isEqualTo(EMAIL_SUBJECT);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setEmailSubject(EMAIL_SUBJECT_DEFAULT);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}

		@Disabled("Need to regenerate java library with updated ipStart/ipEnd property names ")
		@Test
		@DisplayName("Update account settings, allowed IP ranges")
		public void updateAllowedIPRanges() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				final List<AccountAllowedIpRanges> ipRangesList = new ArrayList<>();
				final AccountAllowedIpRanges ranges = new AccountAllowedIpRanges();
				ranges.setIpStart(IP_START1);
				ranges.setIpEnd(IP_END1);
				ipRangesList.add(ranges);
				body.setAllowedIpRanges(ipRangesList);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				final AccountAttributes attributes = response.getData().getAttributes();
				final List<AccountAttributesAllowedIp> allowedIp = attributes.getAllowedIp();
				assertThat(allowedIp.size() > 0);
				assertThat(allowedIp.get(_0).getIpStart()).isEqualTo(IP_START1);
				assertThat(allowedIp.get(_0).getIpEnd()).isEqualTo(IP_END1);
			} catch (final Exception e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setAllowedIpRanges(Collections.<AccountAllowedIpRanges>emptyList());
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}

		@Test
		@DisplayName("Update account settings, custom signature")
		public void updateCustomSignature() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setCustomSignature(SIGNATURE);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().getCustomSignature()).isEqualTo(SIGNATURE);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setCustomSignature(EMPTY2);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}

		@Test
		@DisplayName("Update account settings, account onboarding")
		public void updateAccountOnboarding() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setAccountOnboarding(false);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
				assertThat(response.getData().getAttributes().isAccountOnboarding()).isFalse();
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				body.setAccountOnboarding(true);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}

		@Test
		@DisplayName("Update account settings, branding settings")
		public void updateBrandingSettings() throws ApiException {
			try {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				final BrandingSettingsValues brandingSettingsValues = new BrandingSettingsValues();
				brandingSettingsValues.setCompanyName(NAME1);
				brandingSettingsValues.setCustomEmail(TEST_EMAIL4);
				brandingSettingsValues.setTheme(THEME);
				body.setBrandingSettings(brandingSettingsValues);
				final AccountResponse response = api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
				validateAccountSettings(response, false);
			} catch (final ApiException e) {
				fail(FAILED_DUE_TO, e);
			} finally {
				final UpdateAccountRequestBody body = new UpdateAccountRequestBody();
				final BrandingSettingsValues brandingSettingsValues = new BrandingSettingsValues();
				brandingSettingsValues.setCompanyName(EMPTY2);
				brandingSettingsValues.setCustomEmail(EMPTY2);
				brandingSettingsValues.setTheme(DEFAULT);
				body.setBrandingSettings(brandingSettingsValues);
				api.updateAccount(EV_API_KEY, EV_ACCESS_TOKEN, body);
			}
		}
	}
}
