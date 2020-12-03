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
import com.exavault.client.model.AddEmailListRequestBody;
import com.exavault.client.model.EmailListCollectionResponse;
import com.exavault.client.model.EmailListResponse;
import com.exavault.client.model.EmptyResponse;
import com.exavault.client.model.UpdateEmailListRequestBody;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for EmailListsApi
 */
@Ignore
public class EmailListsApiTest {

    private final EmailListsApi api = new EmailListsApi();

    /**
     * Create new email list
     *
     * Create a new email list. Among other things, email lists can be used to send files or share folders with a group of email addresses at once.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addEmailListTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        AddEmailListRequestBody body = null;
        EmailListResponse response = api.addEmailList(evApiKey, evAccessToken, body);

        // TODO: test validations
    }
    /**
     * Delete an email group with given id
     *
     * Permanently delete an email group. This action is not reversible. We recommend making a user confirm this action before sending the API call. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteEmailListByIdTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        EmptyResponse response = api.deleteEmailListById(evApiKey, evAccessToken, id);

        // TODO: test validations
    }
    /**
     * Get individual email group
     *
     * Retrieve all the details of a specific email list including it&#x27;s name, when it was created and all the email addresses that belong to the group.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEmailListByIdTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        String include = null;
        EmailListResponse response = api.getEmailListById(evApiKey, evAccessToken, id, include);

        // TODO: test validations
    }
    /**
     * Get all email groups
     *
     * List all email groups for authenticated user
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEmailListsTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        String include = null;
        EmailListCollectionResponse response = api.getEmailLists(evApiKey, evAccessToken, include);

        // TODO: test validations
    }
    /**
     * Update an email group
     *
     * Add or remove emails from an email list that can be used to send and share files with groups.   **Notes**  *This call will **replace** your current email list in its entirety.* If you want to keep any existing emails on the list, be sure to submit the call with any current emails you want to keep on the list.  
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateEmailListByIdTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        UpdateEmailListRequestBody body = null;
        EmailListResponse response = api.updateEmailListById(evApiKey, evAccessToken, id, body);

        // TODO: test validations
    }
}
