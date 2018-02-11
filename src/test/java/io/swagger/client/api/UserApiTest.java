/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications. Our API supports both GET and POST operations.  Capabilities of the API include:  - Uploading and downloading files. - Managing files and folders; including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and recieve folders.  - Setting up and managing notifications.  ## The API Endpoint  The ExaVault API is located at: https://api.exavault.com/v1/  # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Code-Libraries-and-Sample-PHP-Code/Obtain-your-API-key) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"e13395afc6278ce1555f\"></div>  ![ExaVault API Postman Colletion Usage](/images/postman.png)  If you'd prefer to skip Postman and start working with code directly, take a look at the sample code below.    # Code Libraries & Sample PHP Code  Once you're ready for full-scale development, we recommend looking at our code libraries available on [GitHub](https://github.com/ExaVault). We offer code libraries for [Python](https://github.com/ExaVault/evapi-python), [PHP](https://github.com/ExaVault/evapi-php) and [JavaScript](https://github.com/ExaVault/evapi-javascript).  While we recommend using our libraries, you're welcome to interact directly with our API via HTTP GET and POST requests -- a great option particularly if you're developing in a language for which we don't yet have sample code.     - [Download Python Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-python) - [Download PHP Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-php) - [Download JavaScript Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-javascript)  *Note: You can generate client libraries for any language using [Swagger Editor](http://editor2.swagger.io/). Just download our documentation file, past it into editor and use 'Generate Client' dropdown.*  ## Obtain Your API Key  You will need to obtain an API key for your application from the [Client Area](https://clients.exavault.com/clientarea.php?action=products) of your account.  To obtain an API key, please follow the instructions below.   + Login to the [Accounts](https://clients.exavault.com/clientarea.php?action=products) section of the Client Area.  + Use the drop down next to your desired account, and select *Manage API Keys*.  + You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.  *NOTE: As of Oct 2017, we are in the progress of migrating customers to our next generation platform. If your account is already on our new platform, you should log into your File Manager and create your API key under Account->Developer->Manage API Keys*.  # Status Codes  The ExaVault API returns only two HTTP status codes for its responses: 200 and 500.  When the request could be successfully processed by the endpoint, the response status code will be 200, regardless of whether the requested action could be taken.  For example, the response to a getUser request for a username that does not exist in your account would have the status of 200,  indicating that the response was received and processed, but the error member of the returned response object would contain object with `message` and `code` properties.  **Result Format:**  |Success   | Error     | Results   | | ---      | :---:       |  :---:      | | 0        |  `Object` |   Empty   | | 1        |   Empty       |    `Object` or `Array`        |     When a malformed request is received, a 500 HTTP status code will be returned, indicating that the request could not be processed.  ExaVault's API does not currently support traditional REST response codes such as '201 Created' or '405 Method Not Allowed', although we intend to support such codes a future version of the API.   # File Paths  Many API calls require you to provide one or more file paths. For example, the <a href=\"#operation/moveResources\">moveResources</a> call requires both an array of source paths, **filePaths**, and a destination path, **destinationPath**. Here's a few tips for working with paths:   - File paths should always be specified as a string, using the standard Unix format: e.g. `/path/to/a/file.txt`  - File paths are always absolute _from the home directory of the logged in user_. For example, if the user **bob** had a home directory restriction of `/bob_home`, then an API call made using his login would specify a file as `/myfile.txt`, whereas an API call made using the master user ( no home directory restriction ) would specify the same file as `/bob_home/myfile.txt`.  # API Rate Limits  We rate limit the number of API calls you can make to help prevent abuse and protect system stablity. Each API key will support 500 requests per rolling five minutes. If you make more than 500 requests in a five minute period, you will receive a response with an error object for fifteen minutes.  # Webhooks  A webhook is an HTTP callback: a simple event-notification via HTTP POST. If you define webhooks for Exavault, ExaVault will POST a  message to a URL when certain things happen.     Webhooks can be used to receive a JSON object to your endpoint URL. You choose what events will trigger webhook messages to your endpoint URL.     Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log.  ## Getting Started  1. Go to the Account tab inside SWFT.  2. Choose the Developer tab.  3. Configure your endpoint URL and select the events you want to trigger webhook messages.  4. Save settings.    You are all set to receive webhook callbacks on the events you selected.  ## Verification Signature  ExaVault includes a custom HTTP header, X-Exavault-Signature, with webhooks POST requests which will contain the signature for the request.  You can use the signature to verify the request for an additional level of security.  ## Generating the Signature  1. Go to Account tab inside SWFT.  2. Choose the Developer tab.  3. Obtain the verification token. This field will only be shown if you've configured your endpoint URL.  4. In your code that receives or processes the webhooks, you should concatenate the verification token with the JSON object that we sent in our      POST request and hash it with md5.     ```     md5($verificationToken.$webhooksObject);     ```  5. Compare signature that you generated to the signature provided in the X-Exavault-Signature HTTP header  ## Example JSON Response Object  ```json   {     \"accountname\": \"mycompanyname\",     \"username\": \"john\"     \"operation\": \"Upload\",     \"protocol\": \"https\",     \"path\": \"/testfolder/filename.jpg\"     \"attempt\": 1   } ```  ## Webhooks Logs  Keep track of all your webhooks requests in the Activity section of your account. You can find the following info for each request:    1. date and time - timestamp of the request.    2. endpoint url - where the webhook was sent.    3. event - what triggered the webhook.    4. status - HTTP status or curl error code.    5. attempt - how many times we tried to send this request.    6. response size - size of the response from your server.    7. details - you can check the response body if it was sent. 
 *
 * OpenAPI spec version: 1.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.AccountResponse;
import io.swagger.client.model.AvailableUserResponse;
import io.swagger.client.model.CreateUser;
import io.swagger.client.model.Response;
import io.swagger.client.model.UpdateUser;
import io.swagger.client.model.UserResponse;
import io.swagger.client.model.UsersResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
@Ignore
public class UserApiTest {

    private final UserApi api = new UserApi();

    
    /**
     * createUser
     *
     * Adds a new user to the account. The user may be configured as an admin or standard user, and (if a standard user) may be assigned a restricted home directory and restricted permissions.  &gt; **Notes:** - Authenticated user&#39;s role must be admin or master; standard users are not allowed to create other users. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createUserTest() throws ApiException {
        String apiKey = null;
        CreateUser createUser = null;
        Response response = api.createUser(apiKey, createUser);

        // TODO: test validations
    }
    
    /**
     * deleteUser
     *
     * Delete a user from the account. Deleting a user does **NOT** delete any files from the account; it merely removes a user&#39;s access. If you also need to delete the user&#39;s home folder or data when you delete the user, you should make a seperate call to &lt;a href&#x3D;\&quot;#operation/deleteResources\&quot;&gt;deleteResources&lt;/a&gt;. &gt; **Notes:** - Authenticated user&#39;s role must be admin or master 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteUserTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String username = null;
        Response response = api.deleteUser(apiKey, accessToken, username);

        // TODO: test validations
    }
    
    /**
     * getAccount
     *
     * Gets the account object and master user object for the authenticated user. Useful if you need to lookup or display information about the the account. If you need information the user you&#39;re logged in as, rather than the account and master user, see &lt;a href&#x3D;\&quot;#operation/getCurrentUser\&quot;&gt;getCurrentUser&lt;/a&gt;. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAccountTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        AccountResponse response = api.getAccount(apiKey, accessToken);

        // TODO: test validations
    }
    
    /**
     * getCurrentUser
     *
     * Gets the user object for the authenticated user. The user object contains detailed information on the user &amp;ndash; the creation timestamp, username, nickname, associated email, and more. See the response sample, below, for full details.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCurrentUserTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        UserResponse response = api.getCurrentUser(apiKey, accessToken);

        // TODO: test validations
    }
    
    /**
     * getUser
     *
     * Get details on the specified user from your account. The user object contains detailed information on the user &amp;ndash; the creation timestamp, username, nickname, associated email, and more. See the response sample, below, for full details.  **Notes:** - Authenticated user&#39;s role must be admin or master. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getUserTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String username = null;
        UserResponse response = api.getUser(apiKey, accessToken, username);

        // TODO: test validations
    }
    
    /**
     * getUsers
     *
     * Gets array of all user objects in your account. Each element of the array will contain details on a single user.  **Notes:** - Authenticated user&#39;s role must be admin or master. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getUsersTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String sortBy = null;
        String sortOrder = null;
        UsersResponse response = api.getUsers(apiKey, accessToken, sortBy, sortOrder);

        // TODO: test validations
    }
    
    /**
     * updateUser
     *
     * Updates specified user record in your account. Note that the unique key for this API call is our internal ID, and _not_ the username, as the username can be changed.   &gt; **Notes:** - Authenticated user&#39;s role must be admin or master. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateUserTest() throws ApiException {
        String apiKey = null;
        UpdateUser updateUser = null;
        Response response = api.updateUser(apiKey, updateUser);

        // TODO: test validations
    }
    
    /**
     * userAvailable
     *
     * Returns true if requested username has not already been taken in the system. Note that usernames are global in our system; if one account has claimed the username &#39;bobsmith&#39; then no other account may use that username.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void userAvailableTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String username = null;
        AvailableUserResponse response = api.userAvailable(apiKey, accessToken, username);

        // TODO: test validations
    }
    
}
