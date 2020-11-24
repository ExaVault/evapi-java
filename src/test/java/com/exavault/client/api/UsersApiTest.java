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
 *//*


package com.exavault.client.api;

import com.exavault.client.ApiException;
import com.exavault.client.model.AddUserRequestBody;
import java.math.BigDecimal;
import com.exavault.client.model.EmptyResponse;
import com.exavault.client.model.UpdateUserRequestBody;
import com.exavault.client.model.UserCollectionResponse;
import com.exavault.client.model.UserResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * API tests for UsersApi
 *//*

@Ignore
public class UsersApiTest {

    private final UsersApi api = new UsersApi();

    */
/**
     * Create a user
     *
     * Adds a new user to the account. The user may be configured as an admin or standard user, and (if a standard user) may be assigned a restricted [home directory](/docs/account/04-users/00-introduction#setting-the-user-s-home-directory) and restricted [permissions](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions).   **Notes:**  - You must be an [admin-level user](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to use this.
     *
     * @throws ApiException
     *          if the Api call fails
     *//*

    @Test
    public void addUserTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        AddUserRequestBody body = null;
        UserResponse response = api.addUser(evApiKey, evAccessToken, body);

        // TODO: test validations
    }
    */
/**
     * Delete a user
     *
     * Delete a user from the account. Deleting a user does **NOT** delete any files from the account; it merely removes a user&#x27;s access. Aternatively, locking a user via the [PATCH /users/{id}](#operation/updateUser) will keep the user in your account, but make it unable to log in.   Resources and shares owned by the deleted user will be owned by the master user after the deletion.  **Notes:**   - You must have [admin-level access](/docs/account/04-users/01-admin-users) to delete a user. - The primary owner of the account cannot be deleted. 
     *
     * @throws ApiException
     *          if the Api call fails
     *//*

    @Test
    public void deleteUserTest() throws ApiException {
        BigDecimal id = null;
        String evApiKey = null;
        String evAccessToken = null;
        EmptyResponse response = api.deleteUser(id, evApiKey, evAccessToken);

        // TODO: test validations
    }
    */
/**
     * Get info for a user
     *
     * Get the details for a specific user. You can use the &#x60;include&#x60; parameter to also get the details of related records, such as the account or the home directory.  **Notes:**  - You must have [admin or master](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) access to use this.
     *
     * @throws ApiException
     *          if the Api call fails
     *//*

    @Test
    public void getUserByIdTest() throws ApiException {
        BigDecimal id = null;
        String evApiKey = null;
        String evAccessToken = null;
        String include = null;
        UserResponse response = api.getUserById(id, evApiKey, evAccessToken, include);

        // TODO: test validations
    }
    */
/**
     * Get a list of users
     *
     * Get a list of the users in your account. There are three main types of searches you can do with this method:  1. Search for a user by username. If you provide the &#x60;username&#x60; parameter in your call, then only the user who exactly matches that username will be in the list of matches. Any other parameters are ignored. 1. Search for a user by individual filter fields (&#x60;nickname&#x60;,&#x60;email&#x60;,&#x60;role&#x60;,&#x60;status&#x60;,&#x60;homeDir&#x60;). Users in the list will be ones who match all of the filters you choose to search by. For example, you could look for users with the \&quot;admin\&quot; &#x60;role&#x60; AND &#x60;email&#x60; addresses ending in \&quot;*@acme.com\&quot;.  1. Search for a user by search string. If you provide the &#x60;search&#x60; parameter, users whose nickname OR email OR role OR homeDir match value your provide.  **Notes:**  - You must be an [admin-level user](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to use this. - The homeDir is the full path to the user&#x27;s home directory, not a resource ID or hash.
     *
     * @throws ApiException
     *          if the Api call fails
     *//*

    @Test
    public void listUsersTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        String username = null;
        String nickname = null;
        String email = null;
        String role = null;
        Integer status = null;
        String homeDir = null;
        String search = null;
        Integer offset = null;
        String sort = null;
        Integer limit = null;
        String include = null;
        UserCollectionResponse response = api.listUsers(evApiKey, evAccessToken, username, nickname, email, role, status, homeDir, search, offset, sort, limit, include);

        // TODO: test validations
    }
    */
/**
     * Update a user
     *
     * Updates the settings for the user. Note that the unique key for this API call is our internal ID, and _not_ the username, as the username can be changed.  In the request body, you should only send the parameters for values that you wish to change for the user.  **Notes:**  - You must have [admin or master](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) access to edit other users. If you have user-level access, you can only update your own user settings. - You cannot edit a master user with this method.
     *
     * @throws ApiException
     *          if the Api call fails
     *//*

    @Test
    public void updateUserTest() throws ApiException {
        String evApiKey = null;
        String evAccessToken = null;
        BigDecimal id = null;
        UpdateUserRequestBody body = null;
        UserResponse response = api.updateUser(evApiKey, evAccessToken, id, body);

        // TODO: test validations
    }
}
*/
