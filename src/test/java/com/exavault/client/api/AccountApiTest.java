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
import com.exavault.client.model.AccountResponse;
import com.exavault.client.model.UpdateAccountRequestBody;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * API tests for AccountApi
 */
@Disabled
public class AccountApiTest {

	private final AccountApi api = new AccountApi();

	/**
	 * Get account settings
	 * <p>
	 * Get settings for your account, such as current space usage, webhooks settings, welcome email content and IP address restrictions.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@Test
	public void getAccountTest() throws ApiException {
		final String evApiKey = null;
		final String evAccessToken = null;
		final String include = null;
		final AccountResponse response = api.getAccount(evApiKey, evAccessToken, include);

		// TODO: test validations
	}

	/**
	 * Update account settings
	 * <p>
	 * Update account settings, such as welcome email content, IP address restrictions, webhooks settings and secure password requirements.  **Notes**  - You must have [admin-level access](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to change account settings.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@Test
	public void updateAccountTest() throws ApiException {
		final String evApiKey = null;
		final String evAccessToken = null;
		final UpdateAccountRequestBody body = null;
		final AccountResponse response = api.updateAccount(evApiKey, evAccessToken, body);

		// TODO: test validations
	}
}
