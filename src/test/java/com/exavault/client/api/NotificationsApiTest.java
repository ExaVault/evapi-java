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
import com.exavault.client.model.AddNotificationRequestBody;
import com.exavault.client.model.EmptyResponse;
import com.exavault.client.model.NotificationCollectionResponse;
import com.exavault.client.model.NotificationResponse;
import com.exavault.client.model.UpdateNotificationByIdRequestBody;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for NotificationsApi
 */
@Ignore
public class NotificationsApiTest {

    private final NotificationsApi api = new NotificationsApi();

    /**
     * Create a new notification
     *
     * Create a new notification for a [resource](#section/Identifying-Resources) in your account. Notifications can be sent via email or webhook;  - To enable email, pass an array of email addresses to the &#x60;recipients&#x60; parameter of this call.  - To enable webhooks, setup the webhook callback URL in your account settings via [PATCH /account](#operation/updateAccount).   **Notes:**   - Authenticated user should have [notifications permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addNotificationTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        AddNotificationRequestBody body = null;
        NotificationResponse response = api.addNotification(evApiKey, evAccessToken, body);

        // TODO: test validations
    }
    /**
     * Delete a notification
     *
     * Deletes a notification. Note that deleting a notification _only_ deletes the notification &amp;ndash; it does not delete any underlying files or folders.  **Notes:**  - You need to have the [notifications permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to update a notification. - You can only delete notifications owned by your user account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteNotificationByIdTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        EmptyResponse response = api.deleteNotificationById(evApiKey, evAccessToken, id);

        // TODO: test validations
    }
    /**
     * Get notification details
     *
     * Get the details for a notification with a specific ID number. You&#x27;ll be able to review its path, triggers and who&#x27;s getting the notification.   **Notes**  - You need to have the [notifications permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to view the detail for a notification. - You can only retrieve notifications owned by your user account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getNotificationByIdTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        String include = null;
        NotificationResponse response = api.getNotificationById(evApiKey, evAccessToken, id, include);

        // TODO: test validations
    }
    /**
     * Get a list of notifications
     *
     * Get a list of all the [notifications](/docs/account/06-notifications) you have access to. You can use sorting and filtering to limit the returned list.  **Notes:**   - Authenticated user should have [notifications permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listNotificationsTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        String type = null;
        Integer offset = null;
        String sort = null;
        Integer limit = null;
        String include = null;
        String action = null;
        NotificationCollectionResponse response = api.listNotifications(evApiKey, evAccessToken, type, offset, sort, limit, include, action);

        // TODO: test validations
    }
    /**
     * Update a notification
     *
     * Update an existing notification. You can add additional emails or change the action or users that cause a notification to trigger.   When updating recipient emails, make sure your &#x60;recipients&#x60; parameter contains the full list of people who should be included on the notification. If you resend the list without an existing recipient, they will be deleted from the notification emails.   **Notes:**  - You need to have the [notifications permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to update a notification. - You can only change notifications owned by your user account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateNotificationByIdTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        Integer id = null;
        UpdateNotificationByIdRequestBody body = null;
        NotificationResponse response = api.updateNotificationById(evApiKey, evAccessToken, id, body);

        // TODO: test validations
    }
}
