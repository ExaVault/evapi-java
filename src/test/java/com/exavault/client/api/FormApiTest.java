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
import com.exavault.client.model.EmptyResponse;
import com.exavault.client.model.FormEntryResponse;
import com.exavault.client.model.FormResponse;
import com.exavault.client.model.UpdateFormByIdRequestBody;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FormApi
 */
@Ignore
public class FormApiTest {

    private final FormApi api = new FormApi();

    /**
     * Delete a receive form submission
     *
     * Deletes a form submission entry, which represents one time that a visitor filled out the form and uploaded files. This deletes only the record of the submission (the date, the values entered in the form and the names of the files uploaded by the visitor).The share and any associated file resources will not be deleted by this.   **Notes**:  - Use the [GET /form/entries/{formId}](#operation/getFormMessageById) to list the submissions and obtain the ID of the entry you want to delete - You must have the [DeleteFormData permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) in order to use this operation - It is not possible to un-delete data that is removed in this way 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteFormMessageByIdTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        EmptyResponse response = api.deleteFormMessageById(evApiKey, evAccessToken, id);

        // TODO: test validations
    }
    /**
     * Get receive folder form by Id
     *
     * Returns the [file upload form](/docs/account/05-file-sharing/05-form-builder) assigned to a [receive folder](/docs/account/05-file-sharing/04-receive-folders). The form details will return all the input fields and their settings.   Use the &#x60;include&#x60; parameter (with the value **share**) to also retrieve the details of the associated receive folder.   **Note**  If you prefer to find a form by its shareHash, you can use the [GET /forms](#operation/getFormByShareHash) endpoint instead.  
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFormByIdTest() throws ApiException {
        Integer id = null;
        String evApiKey = null;
        String evAccessToken = null;
        String include = null;
        FormResponse response = api.getFormById(id, evApiKey, evAccessToken, include);

        // TODO: test validations
    }
    /**
     * Get receive folder form settings
     *
     * Get the information for the [file upload form](/docs/account/05-file-sharing/05-form-builder) assigned to a [receive folder](/docs/account/05-file-sharing/04-receive-folders) by its shareHash. The form details will return all the input field settings and the CSS for the form.  Use the &#x60;include&#x60; parameter (with the value **share**) to also get the details of the associated receive folder.  **Note**  - If you prefer to find a form by its ID, you can use the [GET /forms/{id}](#operation/getFormById) endpoint instead.  
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFormByShareHashTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        String shareHash = null;
        String include = null;
        FormResponse response = api.getFormByShareHash(evApiKey, evAccessToken, shareHash, include);

        // TODO: test validations
    }
    /**
     * Get form data entries for a receive
     *
     * Returns the form data entries for a specific form for a receive. Optional parameters can be included in the call to manage larger data sets. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFormEntriesTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        Integer limit = null;
        Integer offset = null;
        FormEntryResponse response = api.getFormEntries(evApiKey, evAccessToken, id, limit, offset);

        // TODO: test validations
    }
    /**
     * Updates a form with given parameters
     *
     * Add, update, or delete a form&#x27;s parameters. This will alter how your users/customers will see and interact with the form when sending you files.   **Notes**  *This call will **replace** your current form in its entirety.* If you want to keep any existing elements unchanged, be sure to submit the call with an element&#x27;s current settings to preserve them.                          
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateFormByIdTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        UpdateFormByIdRequestBody body = null;
        FormResponse response = api.updateFormById(evApiKey, evAccessToken, id, body);

        // TODO: test validations
    }
}
