/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications.   Capabilities of the API include - Uploading and downloading files. - Managing files and folders, including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and receive folders.  - Setting up and managing notifications.  The ExaVault API v2.0 is a RESTful API using JSON.  ## The API URL  You will access your account from your server address. For example, if your account is available at exampleaccount.exavault.com, you'll connect to the API at https://exampleaccount.exavault.com/api/v2  # Obtaining Your API Key and Access Token  Account admins can create API Keys and personal access tokens within the ExaVault File Manager web application.   ## Create an API Key  1. Log into the ExaVault File Manager at your account name address. i.e., if your account is exampleaccount.exavault.com, go to https://exampleaccount.exavault.com and log in with your username and password 2. Click on the **My Account** option in the left-hand sidebar 3. Click on the **Developer** tab 4. Click the + button next to the table of API Keys to create a new key 5. Enter a name that will uniquely identify connections using this key. This name will appear in your activity session logs. 6. Enter a description with any other information that you need to track the purpose of your API key 7. Save the new key  As soon as you save a new API key, you'll be prompted to create a personal access token which will allow a specific user to connect via the API using that API key (jump to step 5 in the instructions below)  ## Generate an Access Token 1. Log into the ExaVault File Manager at your account name address. i.e., if your account is exampleaccount.exavault.com, go to https://exampleaccount.exavault.com and log in with your username and password 1. Click on the **My Account** option in the left-hand sidebar 1. Click on the **Developer** tab 1. Click the + button next to the table of Access Tokens to create a new token 1. Select the API Key from the first dropdown. 1. Select the user who will use this token from the second dropdown. 1. Click the **GENERATE TOKEN** button  The confirmation popup will display your API key and your access token. **Copy this access token to a safe location (such as a password vault) immediately.** Once you close this popup, you will not be able to see the token again. After you have saved your token securely, click CLOSE to close the popup.  The access token you have created will allow any program using that token and its API key to masquerade as the associated user. You should keep the token safe.  # Code Libraries   To get you started quicker, we've created libraries on our [GitHub](https://github.com/ExaVault) with sample code for Java, PhP, and JavaScript that will do basic actions including;  - Create a new user - Upload a file - Download a file - Create a share folder   # Authentication  The ExaVault API uses the combination of an API key and a persistent access token to authenticate a user. Both the API key and the access token can be created by an admin-level user  Each request made to the API must include 2 headers  | Header Name   | Contains      | | ---      | :---:          | | **ev-api-key**      |  Your API key   | | **ev-access-token**       |   Your access token          |     The access token uniquely identifies the user account for the connection. You should keep this token secure.   # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Obtaining-Your-API-Key-and-Access-Token) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"d72a708e9382d3b3db17\"></div>  ![ExaVault API Postman Collection Usage](/images/postman.png)  # HTTP Status Codes  The ExaVault API v2.0 is RESTful and returns appropriate HTTP status codes in its responses  **Success Statuses:**  | Status   | Notes   | | ---      | :---:       | | 200      | Successful operation   | | 201      | Successful creation operation     | | 207      | Multiple operation status |  **Request Error Statuses:**  | Status   | Notes   | | ---      | :---:       | | 400      | Bad Request   | | 401      | Unauthorized     | | 403      | Forbidden   | | 404      | Not Found* | | 429      | Too many requests |  **Server Error Statuses:**  | Status   | Notes | | ---      | ---   | | 500      | Server Error | | 503      | Service unavailable |   # Response Format  Nearly every response from the server will be a JSON object, which will contain a `responseStatus` attribute that matches the HTTP status of the response.  Most succesful responses will also include a `data` attribute that contains the data related to your request. For instance using GET /account will return the information for the account associated with your API key and access token.  ## Timestamps   All of our responses that include datetime information will be structured in an IS0 8601 format:   No offset from UTC: `YYYY-MM-DDThh:mm:ssZ` e.g. 2019-09-07T15:50Z  Minus offset from UTC: `YYYY-MM-DDThh:mm:ss-hh:mm` e.g. 2019-09-07T15:50-04:00  Plus offset from UTC: `YYYY-MM-DDThh:mm:ss+hh:mm` e.g. 2019-09-07T15:50+04:00  - YYYY = four-digit year - MM   = two-digit month - DD   = two-digit day of month - hh   = two digits of hour - mm   = two digits of minute - ss   = two digits of second - Z    = zero offset from UTC time  ## Error Responses  Error responses will have a similar format. The response will contain a `responseStatus` which contains the HTTP status code and an `errors` array, which will contain pertinent errors for the request. Each object in the `errors` array will contain a human-readable `code` and some explanatory `detail` text.  ## Common Errors   As you work with our suite of APIs, you'll likely encounter one or more of these error codes throughout the process. Let's take a look at some of the most common errors and how to resolve them quickly and painlessly.   ### 400 Error - Bad Request:  ```json {   \"responseStatus\":400,   \"errors\":[     {       \"code\":\"ERROR_INVALID_PARAMETER\",       \"detail\":\"Destination path cannot be an existing folder.\"     }   ] } ```  ```json {  \"responseStatus\": 400,  \"errors\": [   {    \"code\": \"ERROR_INVALID_PASSWORD\",    \"detail\": \"Password must be longer than eight (8) characters and contain one uppercase letter, one lowercase letter, and one number.\"   }  ] } ```  This error will generally mean a paramater or body element is invalid or missing. We suggest taking another look at the documentation of the API endpoint you're hitting to double check for; missing required fields in the request, spelling errors, invalid values be used.   The error messaging returned should point you exactly to what you need to correct to avoid going through trial and error.    ### 401 Error - Unauthorized   ```json {  \"responseStatus\": 401,  \"errors\": [   {    \"code\": \"ERROR_INVALID_CREDENTIALS\",    \"detail\": \"HTTP_UNAUTHORIZED\"   }  ] } ```  If you encounter a 401, it means we're not recognizing the credentials you're attempting to authenticate with. To resolve the issue;    1. Double check that your credenitals (API Key and Access Token) are correct. 2. Creating a second set of credentials (see \"Obtaining Your API Key and Access Token\" above) and attempt the call again.  3. If you're able to successfully make a call, regenerate the Access Token of the first user and try the call one last time.   If you're still encountering a 401, contact us for help.  ### 403 Error - Forbidden  ```json {  \"responseStatus\": 403,  \"errors\": [   {    \"code\": \"ERROR_INSUFFICIENT_PRIVILEGES\",    \"detail\": \"An error occurred\"   }  ] } ```  Similarly to a 401, you'll be unable to complete an API call if you encounter this error. Unlike a 401, your credentials were authenticated, but the authenticated user does not have permission to perform the action you're attempting.   To resolve the issue you can either;  - Execute the call using an master user's credentials.  - Log in to the ExaVault File Manager OR use the **PATCH /updateUser** endpoint to update the user's permissions.  ### 404 Error - Not Found  ```json  {  \"responseStatus\": 404,  \"errors\": [   {    \"code\": \"ERROR_SHARE_NOT_FOUND\",    \"detail\": \"Share not found\"   }  ] } ```  Encountering a 404 error means whatever type of resource you're attempting to find or update; isn't being found. Usually, this is just a case of using the wrong ID when using a call, and can be resolved by fixing the ID on your call.    If the ID on the call appears to be correct we recommend taking the following steps:  - Attempt a more generic GET call to get a list of the type of resource you're looking for to see if you can find the ID you're looking for.  - Check your activity logs to see if what you're looking for was recently deleted.    # Identifying Resources  Many API methods require you to provide one or more resources, which may be expressed as paths, ids, hashes, or some combination of the three (for calls that act upon multiple resources).   To specify a resource by path, provide a fully qualified string to the resource _relative to the associated user's home directory_. This path will always begin with a forward slash. Only forward slash characters may be used to separate the folders within a path string.  To specify a resource by ID, you'll need to obtain that ID from some other API method first. For example, **GET /resources/list** will return a list of resources in your account along with their IDs. Once you have the ID of that resource, append it to the string \"id:\" to specify that resource, such as `id:124447`. IDs are always whole-number numeric values.   To specify a resource by hash, first obtain the hash from another API method. Once you have the hash representing the resource, append it to the string \"hash:\" to specify that resource, such as `hash:3a1597ca982231f6666c75bcc2bd9c85` to indicate the resource with the hash value **3a1597ca982231f6666c75bcc2bd9c85**. Hashes are always an alphanumeric sequence without any special characters or punctuation.  ## Paths and Home Folders  Users with different home folders will use different paths to refer to the same resource. As an example, suppose there is a file located at **_/Data/Production/Inbound/1595978053_G12.xml**. For an admin-level user, or any user whose home folder permits them access to the entire account, the path for that resource is **_/Data/Production/Inbound/1595978053_G12.xml**.  For a user whose home folder is **_/Data/Production/_**, the path to the file becomes **_/Inbound/1595978053_G12.xml**  # Transaction Limits  The daily transaction limit restricts the overall number of operations you can perform in a 24-hour period in your ExaVault account. Those transactions could be file uploads, file downloads, making a shared folder, creating a user, deleting files, to name a few examples. All operations performed in your account count against the total daily transactions for your account, including:  - FTP/SFTP operations - Actions by users who are logged into your web interface - Interacting with Receive folders - Receiving files through Send files and Shared Folders - Accessing files shared through direct links - API access from any user using any of the API keys for your account  Each request sent to the API is one transaction. When your account has exceeded its rolling 24-hour rate limit, new operations will become available once the number of operations in the past 24-hours is below your daily rate limit. The response status of rate-limited API operations will be **429**.  ## Rate Limit Headers  To monitor your daily account transaction usage, the response object returned by the server for all API requests will include these custom headers:  - **X-RateLimit-Limit** indicates the total number of operations permitted within a rolling 24-hour period across your entire account. This number is dependent upon the plan your account is subscribed to, and whether you have an enterprise agreement in place. - **X-RateLimit-Remaining** indicates the number of operations currently remaning to you at that moment in time.    # Webhooks  ExaVault provides a webhook system for notifying you of changes to your account. The webhook sender will send a POST request to an endpoint you have specified whenever certain actions happen within your account. Account administrators can change these settings within the ExaVault File Manager.  Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log within the ExaVault File Manager web interface.  ## Configuring Webhooks  1. Log into the ExaVault File Manager at your account name address. i.e., if your account is exampleaccount.exavault.com, go to https://exampleaccount.exavault.com and log in with your username and password. 1. Click on the **My Account** option in the left-hand sidebar. 1. Click on the **Developer** tab 1. Add the URL where your webhook listener can receive requests 1. Check the boxes for the actions which should trigger your webhook. 1. Scroll to the bottom of the page to click SAVE SETTINGS.  ## Verification Signature  When you configure a webhook endpoint and triggering actions, a Verification Token will be displayed below the webhook endpoint URL. You may use this token in combination with the X-Exavault-Signature header to verify that ExaVault is the sender of the webhook request.  ## Comparing the Signature  You'll can use this 3-step procedure to validate an individual webhook request to ensure it was sent by ExaVault.  **1: Get Verification Token**  In order to verify the X-Exavault-Signature header value, you'll first need to obtain the Verification Token for your account:  1. Click on the **My Account** option in the left-hand sidebar. 1. Click on the **Developer** tab 1. Copy the Verification Token that appears below the Webhooks Endpoint url field.  Every webhook request sent to your endpoint URL will use the same verification token. This token won't change for your account.  **2: Concatenate Token and Request**  Once you have the verification token, you'll concatenate that token along with the raw string representing the request body that was received.   **Do not convert the request body to any other type** of object; if the library you're using automatically converts the request body to an object, look for a method to obtain the raw request body as text.  **3: Calculate MD5 Hash**  Calculate the md5 hash of that concatenation. The result should match the contents of your X-Exavault-Signature header.  ## Webhook Request Examples  The following examples demonstrate the structure of webhook requests and how to validate the verification signature for an individual request. All of these examples will use the same verification token; you'll need to use the token for your account to do the same checks on your own webhook requests.  **User Connect Example**  | Verification Token | X-Exavault-Signature header value | | --- | --- | | efb7e0030e6cef1b45d3d74a67881a2b | 6e13eb14edfd0bd54feff96be131e155 |  ```json {\"accountname\":\"exampleaccount\",\"username\":\"exampleaccount\",\"operation\":\"Connect\",\"protocol\":\"web\",\"path\":\"\",\"sourcepath\":\"\",\"attempt\":1} ```   **User Disconnect Example**  | Verification Token | X-Exavault-Signature header value | | --- | --- | | efb7e0030e6cef1b45d3d74a67881a2b | 186e8c73793666c8b5cfa0b55eee691d |  ```json {\"accountname\":\"exampleaccount\",\"username\":\"exampleaccount\",\"operation\":\"Disconnect\",\"protocol\":\"web\",\"path\":\"\",\"sourcepath\":\"\",\"attempt\":1} ```  **File Upload Example**  | Verification Token | X-Exavault-Signature header value | | --- | --- | | efb7e0030e6cef1b45d3d74a67881a2b | e86119ce1b679c7b6010d9ac9a843a36 |  ```json {\"accountname\":\"exampleaccount\",\"username\":\"exampleaccount\",\"operation\":\"Upload\",\"protocol\":\"web\",\"path\":\"/7df2beb1c50a8a066493ee47669a4319.jpg\",\"sourcepath\":\"\",\"attempt\":1} ```  ## Webhooks Logs  Account administrators can track all of the webhook requests sent for your account within the ExaVault File Manager web interface.   To access Webhook logs:  1. Log into the ExaVault File Manager at your account name address. i.e., if your account is exampleaccount.exavault.com, go to https://exampleaccount.exavault.com and log in with your username and password 1. Click on the **Activity** option in the left-hand sidebar 1. Click on **Webhooks Logs**  The webhook logs will show each time a webhook request was sent to your endpoint URL. The following information is recorded for each request:   - date and time - when the system sent the request   - endpoint url - where the webhook request was sent   - event - what triggered the webhook   - status - HTTP status or curl error code returned by the webhook endpoint   - attempt - how many times this request has been sent   - response size - size of the response from your webhook endpoint   - details - the response body returned from your webhook endpoint 
 *
 * OpenAPI spec version: 2.0
 * Contact: support@exavault.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Body16;
import io.swagger.client.model.Body17;
import io.swagger.client.model.EmptyResponse;
import io.swagger.client.model.ShareCollectionResponse;
import io.swagger.client.model.ShareResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SharesApi {
    private ApiClient apiClient;

    public SharesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SharesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addShare
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addShareCall(String evApiKey, String evAccessToken, Body16 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/shares";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addShareValidateBeforeCall(String evApiKey, String evAccessToken, Body16 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling addShare(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling addShare(Async)");
        }
        
        com.squareup.okhttp.Call call = addShareCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Creates a share
     * Creates a new share object for the given path in your account. We support three types of shares:    - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#x27;live&#x27;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A file **send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#x27;point in time&#x27; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **receive** folder lets you receive files into your account. You can either send users a link, or optionally [embed a customized form](/docs/account/05-file-sharing/05-upload-widget) on your website.    **How to send files from your computer using the API**:  In order to use the API to send files which are not already stored in your account, you&#x27;ll need to follow a three-step process:  1. Use the [POST /shares](#operation/addShare) endpoint to set up your send, including password, recipients, expiration, etc. You must include **upload** among the permissions in the &#x60;accessMode&#x60; and set the &#x60;sendingLocalFiles&#x60; paramter to **true**. The response that is returned will include a \&quot;meta\&quot; attribute, which contains an **accessToken** attribute. This new access token is valid only for the send. 2. Use the [POST /resources/upload](#operation/uploadFile) endpoint to upload your files to the send you&#x27;ve created. The \&quot;/\&quot; path represents the root of the share, not your home directory. **You must send the access token that you received from the first step in the &#x60;ev-access-token&#x60; header** 3. Use the [POST /shares/complete-send/{id}](#operation/completeDirectSend) endpoint to indicate that you have finished uploading files to your send. This will trigger the system to remove the **upload** permission from the share and send any invitation emails you set up in the first step of the process. **You must send YOUR access token in the &#x60;ev-access-token&#x60; header, not the temporary access token**  **Notes:**  Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions).
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ShareResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareResponse addShare(String evApiKey, String evAccessToken, Body16 body) throws ApiException {
        ApiResponse<ShareResponse> resp = addShareWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Creates a share
     * Creates a new share object for the given path in your account. We support three types of shares:    - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#x27;live&#x27;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A file **send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#x27;point in time&#x27; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **receive** folder lets you receive files into your account. You can either send users a link, or optionally [embed a customized form](/docs/account/05-file-sharing/05-upload-widget) on your website.    **How to send files from your computer using the API**:  In order to use the API to send files which are not already stored in your account, you&#x27;ll need to follow a three-step process:  1. Use the [POST /shares](#operation/addShare) endpoint to set up your send, including password, recipients, expiration, etc. You must include **upload** among the permissions in the &#x60;accessMode&#x60; and set the &#x60;sendingLocalFiles&#x60; paramter to **true**. The response that is returned will include a \&quot;meta\&quot; attribute, which contains an **accessToken** attribute. This new access token is valid only for the send. 2. Use the [POST /resources/upload](#operation/uploadFile) endpoint to upload your files to the send you&#x27;ve created. The \&quot;/\&quot; path represents the root of the share, not your home directory. **You must send the access token that you received from the first step in the &#x60;ev-access-token&#x60; header** 3. Use the [POST /shares/complete-send/{id}](#operation/completeDirectSend) endpoint to indicate that you have finished uploading files to your send. This will trigger the system to remove the **upload** permission from the share and send any invitation emails you set up in the first step of the process. **You must send YOUR access token in the &#x60;ev-access-token&#x60; header, not the temporary access token**  **Notes:**  Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions).
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ShareResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareResponse> addShareWithHttpInfo(String evApiKey, String evAccessToken, Body16 body) throws ApiException {
        com.squareup.okhttp.Call call = addShareValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Creates a share (asynchronously)
     * Creates a new share object for the given path in your account. We support three types of shares:    - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#x27;live&#x27;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A file **send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#x27;point in time&#x27; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **receive** folder lets you receive files into your account. You can either send users a link, or optionally [embed a customized form](/docs/account/05-file-sharing/05-upload-widget) on your website.    **How to send files from your computer using the API**:  In order to use the API to send files which are not already stored in your account, you&#x27;ll need to follow a three-step process:  1. Use the [POST /shares](#operation/addShare) endpoint to set up your send, including password, recipients, expiration, etc. You must include **upload** among the permissions in the &#x60;accessMode&#x60; and set the &#x60;sendingLocalFiles&#x60; paramter to **true**. The response that is returned will include a \&quot;meta\&quot; attribute, which contains an **accessToken** attribute. This new access token is valid only for the send. 2. Use the [POST /resources/upload](#operation/uploadFile) endpoint to upload your files to the send you&#x27;ve created. The \&quot;/\&quot; path represents the root of the share, not your home directory. **You must send the access token that you received from the first step in the &#x60;ev-access-token&#x60; header** 3. Use the [POST /shares/complete-send/{id}](#operation/completeDirectSend) endpoint to indicate that you have finished uploading files to your send. This will trigger the system to remove the **upload** permission from the share and send any invitation emails you set up in the first step of the process. **You must send YOUR access token in the &#x60;ev-access-token&#x60; header, not the temporary access token**  **Notes:**  Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions).
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addShareAsync(String evApiKey, String evAccessToken, Body16 body, final ApiCallback<ShareResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addShareValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for completeDirectSend
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param id ID of the share to trigger invitations for. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call completeDirectSendCall(String evApiKey, String evAccessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/shares/complete-send/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call completeDirectSendValidateBeforeCall(String evApiKey, String evAccessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling completeDirectSend(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling completeDirectSend(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling completeDirectSend(Async)");
        }
        
        com.squareup.okhttp.Call call = completeDirectSendCall(evApiKey, evAccessToken, id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Complete send files
     * After uploading the file(s) to be sent, this method will trigger invitation emails and finish the send files setup. If you are not sending files from your own computer in a send, you will not need this step.    **How to send files from your computer using the API**:  In order to use the API to send files which are not already stored in your account, you&#x27;ll need to follow a three-step process:  1. Use the [POST /shares](#operation/addShare) endpoint to set up your send, including password, recipients, expiration, etc. You must include **upload** among the permissions in the &#x60;accessMode&#x60; and set the &#x60;sendingLocalFiles&#x60; paramter to **true**. The response that is returned will include a \&quot;meta\&quot; attribute, which contains an **accessToken** attribute. This new access token is valid only for the send. 2. Use the [POST /resources/upload](#operation/uploadFile) endpoint to upload your files to the send you&#x27;ve created. The \&quot;/\&quot; path represents the root of the share, not your home directory. **You must send the access token that you received from the first step in the &#x60;ev-access-token&#x60; header** 3. Use the [POST /shares/complete-send/{id}](#operation/completeDirectSend) endpoint to indicate that you have finished uploading files to your send. This will trigger the system to remove the **upload** permission from the share and send any invitation emails you set up in the first step of the process. **You must send YOUR access token in the &#x60;ev-access-token&#x60; header, not the temporary access token** 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param id ID of the share to trigger invitations for. (required)
     * @return ShareResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareResponse completeDirectSend(String evApiKey, String evAccessToken, Integer id) throws ApiException {
        ApiResponse<ShareResponse> resp = completeDirectSendWithHttpInfo(evApiKey, evAccessToken, id);
        return resp.getData();
    }

    /**
     * Complete send files
     * After uploading the file(s) to be sent, this method will trigger invitation emails and finish the send files setup. If you are not sending files from your own computer in a send, you will not need this step.    **How to send files from your computer using the API**:  In order to use the API to send files which are not already stored in your account, you&#x27;ll need to follow a three-step process:  1. Use the [POST /shares](#operation/addShare) endpoint to set up your send, including password, recipients, expiration, etc. You must include **upload** among the permissions in the &#x60;accessMode&#x60; and set the &#x60;sendingLocalFiles&#x60; paramter to **true**. The response that is returned will include a \&quot;meta\&quot; attribute, which contains an **accessToken** attribute. This new access token is valid only for the send. 2. Use the [POST /resources/upload](#operation/uploadFile) endpoint to upload your files to the send you&#x27;ve created. The \&quot;/\&quot; path represents the root of the share, not your home directory. **You must send the access token that you received from the first step in the &#x60;ev-access-token&#x60; header** 3. Use the [POST /shares/complete-send/{id}](#operation/completeDirectSend) endpoint to indicate that you have finished uploading files to your send. This will trigger the system to remove the **upload** permission from the share and send any invitation emails you set up in the first step of the process. **You must send YOUR access token in the &#x60;ev-access-token&#x60; header, not the temporary access token** 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param id ID of the share to trigger invitations for. (required)
     * @return ApiResponse&lt;ShareResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareResponse> completeDirectSendWithHttpInfo(String evApiKey, String evAccessToken, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = completeDirectSendValidateBeforeCall(evApiKey, evAccessToken, id, null, null);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Complete send files (asynchronously)
     * After uploading the file(s) to be sent, this method will trigger invitation emails and finish the send files setup. If you are not sending files from your own computer in a send, you will not need this step.    **How to send files from your computer using the API**:  In order to use the API to send files which are not already stored in your account, you&#x27;ll need to follow a three-step process:  1. Use the [POST /shares](#operation/addShare) endpoint to set up your send, including password, recipients, expiration, etc. You must include **upload** among the permissions in the &#x60;accessMode&#x60; and set the &#x60;sendingLocalFiles&#x60; paramter to **true**. The response that is returned will include a \&quot;meta\&quot; attribute, which contains an **accessToken** attribute. This new access token is valid only for the send. 2. Use the [POST /resources/upload](#operation/uploadFile) endpoint to upload your files to the send you&#x27;ve created. The \&quot;/\&quot; path represents the root of the share, not your home directory. **You must send the access token that you received from the first step in the &#x60;ev-access-token&#x60; header** 3. Use the [POST /shares/complete-send/{id}](#operation/completeDirectSend) endpoint to indicate that you have finished uploading files to your send. This will trigger the system to remove the **upload** permission from the share and send any invitation emails you set up in the first step of the process. **You must send YOUR access token in the &#x60;ev-access-token&#x60; header, not the temporary access token** 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param id ID of the share to trigger invitations for. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call completeDirectSendAsync(String evApiKey, String evAccessToken, Integer id, final ApiCallback<ShareResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = completeDirectSendValidateBeforeCall(evApiKey, evAccessToken, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteShareById
     * @param id ID of the share entry (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteShareByIdCall(Integer id, String evApiKey, String evAccessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/shares/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteShareByIdValidateBeforeCall(Integer id, String evApiKey, String evAccessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteShareById(Async)");
        }
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling deleteShareById(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling deleteShareById(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteShareByIdCall(id, evApiKey, evAccessToken, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Deactivate a share
     * Deactivate a share. Deactivating a share does not remove the underlying files for **shared_folder** and **receive** share types; it merely removes the access URL. Deleting a **send** share type does remove the associated files, as files that have been sent are only associated with the share, and aren&#x27;t stored anywhere else in the account.  **Notes:**  - You must have [sharing permissons](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to use this. - You must have [admin-level access](/docs/account/04-users/01-admin-users), or you must be the owner of the specified share you wish to delete.
     * @param id ID of the share entry (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @return EmptyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmptyResponse deleteShareById(Integer id, String evApiKey, String evAccessToken) throws ApiException {
        ApiResponse<EmptyResponse> resp = deleteShareByIdWithHttpInfo(id, evApiKey, evAccessToken);
        return resp.getData();
    }

    /**
     * Deactivate a share
     * Deactivate a share. Deactivating a share does not remove the underlying files for **shared_folder** and **receive** share types; it merely removes the access URL. Deleting a **send** share type does remove the associated files, as files that have been sent are only associated with the share, and aren&#x27;t stored anywhere else in the account.  **Notes:**  - You must have [sharing permissons](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to use this. - You must have [admin-level access](/docs/account/04-users/01-admin-users), or you must be the owner of the specified share you wish to delete.
     * @param id ID of the share entry (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @return ApiResponse&lt;EmptyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmptyResponse> deleteShareByIdWithHttpInfo(Integer id, String evApiKey, String evAccessToken) throws ApiException {
        com.squareup.okhttp.Call call = deleteShareByIdValidateBeforeCall(id, evApiKey, evAccessToken, null, null);
        Type localVarReturnType = new TypeToken<EmptyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deactivate a share (asynchronously)
     * Deactivate a share. Deactivating a share does not remove the underlying files for **shared_folder** and **receive** share types; it merely removes the access URL. Deleting a **send** share type does remove the associated files, as files that have been sent are only associated with the share, and aren&#x27;t stored anywhere else in the account.  **Notes:**  - You must have [sharing permissons](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to use this. - You must have [admin-level access](/docs/account/04-users/01-admin-users), or you must be the owner of the specified share you wish to delete.
     * @param id ID of the share entry (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteShareByIdAsync(Integer id, String evApiKey, String evAccessToken, final ApiCallback<EmptyResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteShareByIdValidateBeforeCall(id, evApiKey, evAccessToken, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmptyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getShareById
     * @param id ID of the share entry (required)
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **owner**, **resources**, **notifications**, **activity**. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getShareByIdCall(Integer id, String evApiKey, String evAccessToken, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/shares/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (include != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("include", include));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getShareByIdValidateBeforeCall(Integer id, String evApiKey, String evAccessToken, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getShareById(Async)");
        }
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling getShareById(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling getShareById(Async)");
        }
        
        com.squareup.okhttp.Call call = getShareByIdCall(id, evApiKey, evAccessToken, include, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a share
     * Get the details for a specific share entry. You can use the &#x60;include&#x60; parameter to also get the details of related records, such as the owning user or the resources involved in the share.  **Notes:**  - Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - To get share objects with type send, authenticated user&#x27;s role must be admin or master.
     * @param id ID of the share entry (required)
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **owner**, **resources**, **notifications**, **activity**. (optional)
     * @return ShareResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareResponse getShareById(Integer id, String evApiKey, String evAccessToken, String include) throws ApiException {
        ApiResponse<ShareResponse> resp = getShareByIdWithHttpInfo(id, evApiKey, evAccessToken, include);
        return resp.getData();
    }

    /**
     * Get a share
     * Get the details for a specific share entry. You can use the &#x60;include&#x60; parameter to also get the details of related records, such as the owning user or the resources involved in the share.  **Notes:**  - Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - To get share objects with type send, authenticated user&#x27;s role must be admin or master.
     * @param id ID of the share entry (required)
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **owner**, **resources**, **notifications**, **activity**. (optional)
     * @return ApiResponse&lt;ShareResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareResponse> getShareByIdWithHttpInfo(Integer id, String evApiKey, String evAccessToken, String include) throws ApiException {
        com.squareup.okhttp.Call call = getShareByIdValidateBeforeCall(id, evApiKey, evAccessToken, include, null, null);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a share (asynchronously)
     * Get the details for a specific share entry. You can use the &#x60;include&#x60; parameter to also get the details of related records, such as the owning user or the resources involved in the share.  **Notes:**  - Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - To get share objects with type send, authenticated user&#x27;s role must be admin or master.
     * @param id ID of the share entry (required)
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **owner**, **resources**, **notifications**, **activity**. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getShareByIdAsync(Integer id, String evApiKey, String evAccessToken, String include, final ApiCallback<ShareResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getShareByIdValidateBeforeCall(id, evApiKey, evAccessToken, include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for listShares
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param offset Current offset of records (for pagination) (optional)
     * @param limit Limit of records to be returned (for pagination) (optional, default to 100)
     * @param scope Set of shares to return. (**all**&#x3D;all of them, **active**&#x3D;shares that are currently active, **curentUser**&#x3D;shares created by you) (optional)
     * @param sort What order the list of matches should be in. (optional)
     * @param type Limit the list of matches to only certain types of shares. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **owner**, **resources**, **notifications**, **activity**. (optional)
     * @param name When provided, only shares whose names include this value will be in the list. Supports wildcards, such as **send\\*** to return everything starting with \&quot;send\&quot;.  Use this parameter if you are searching for shares or receives for a specific folder name. For example **_/Clients/ACME/To Be Processed**. (optional)
     * @param recipient Filter the results to include only shares that invited a certain email address. Supports wildcard matching so that **\\*@example.com** will give back entries shared with addresses ending in \&quot;@example.com\&quot;.  (optional)
     * @param message When provided, only shares with a message that contains the text will be included in the list of matches. Both the subject and the body of all messages will be checked for matches. This will allways be a wildcard match, so that searching for **taxes** will return any shares with a message that contains the word \&quot;taxes\&quot;. (optional)
     * @param username When provided, only shares created by the user with that &#x60;username&#x60; will be included in the list. Does not support wildcard searching. (optional)
     * @param search Searches the share name, username, recipients, share messages fields for the provided value. Supports wildcard searches. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call listSharesCall(String evApiKey, String evAccessToken, Integer offset, Integer limit, String scope, String sort, String type, String include, String name, String recipient, String message, String username, String search, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/shares";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (scope != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("scope", scope));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
        if (type != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("type", type));
        if (include != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("include", include));
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("name", name));
        if (recipient != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("recipient", recipient));
        if (message != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("message", message));
        if (username != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("username", username));
        if (search != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("search", search));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call listSharesValidateBeforeCall(String evApiKey, String evAccessToken, Integer offset, Integer limit, String scope, String sort, String type, String include, String name, String recipient, String message, String username, String search, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling listShares(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling listShares(Async)");
        }
        
        com.squareup.okhttp.Call call = listSharesCall(evApiKey, evAccessToken, offset, limit, scope, sort, type, include, name, recipient, message, username, search, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a list of shares
     * Get a list of shares that you would have access to view through the web interface. You can limit which results are returned by specifying specific types of shares you wish to view, finding things shared with a specific email address, as well as finding shares for specific folder names.   **Notes:**  - Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - To get share objects with type send, authenticated user&#x27;s role must be admin or master.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param offset Current offset of records (for pagination) (optional)
     * @param limit Limit of records to be returned (for pagination) (optional, default to 100)
     * @param scope Set of shares to return. (**all**&#x3D;all of them, **active**&#x3D;shares that are currently active, **curentUser**&#x3D;shares created by you) (optional)
     * @param sort What order the list of matches should be in. (optional)
     * @param type Limit the list of matches to only certain types of shares. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **owner**, **resources**, **notifications**, **activity**. (optional)
     * @param name When provided, only shares whose names include this value will be in the list. Supports wildcards, such as **send\\*** to return everything starting with \&quot;send\&quot;.  Use this parameter if you are searching for shares or receives for a specific folder name. For example **_/Clients/ACME/To Be Processed**. (optional)
     * @param recipient Filter the results to include only shares that invited a certain email address. Supports wildcard matching so that **\\*@example.com** will give back entries shared with addresses ending in \&quot;@example.com\&quot;.  (optional)
     * @param message When provided, only shares with a message that contains the text will be included in the list of matches. Both the subject and the body of all messages will be checked for matches. This will allways be a wildcard match, so that searching for **taxes** will return any shares with a message that contains the word \&quot;taxes\&quot;. (optional)
     * @param username When provided, only shares created by the user with that &#x60;username&#x60; will be included in the list. Does not support wildcard searching. (optional)
     * @param search Searches the share name, username, recipients, share messages fields for the provided value. Supports wildcard searches. (optional)
     * @return ShareCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareCollectionResponse listShares(String evApiKey, String evAccessToken, Integer offset, Integer limit, String scope, String sort, String type, String include, String name, String recipient, String message, String username, String search) throws ApiException {
        ApiResponse<ShareCollectionResponse> resp = listSharesWithHttpInfo(evApiKey, evAccessToken, offset, limit, scope, sort, type, include, name, recipient, message, username, search);
        return resp.getData();
    }

    /**
     * Get a list of shares
     * Get a list of shares that you would have access to view through the web interface. You can limit which results are returned by specifying specific types of shares you wish to view, finding things shared with a specific email address, as well as finding shares for specific folder names.   **Notes:**  - Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - To get share objects with type send, authenticated user&#x27;s role must be admin or master.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param offset Current offset of records (for pagination) (optional)
     * @param limit Limit of records to be returned (for pagination) (optional, default to 100)
     * @param scope Set of shares to return. (**all**&#x3D;all of them, **active**&#x3D;shares that are currently active, **curentUser**&#x3D;shares created by you) (optional)
     * @param sort What order the list of matches should be in. (optional)
     * @param type Limit the list of matches to only certain types of shares. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **owner**, **resources**, **notifications**, **activity**. (optional)
     * @param name When provided, only shares whose names include this value will be in the list. Supports wildcards, such as **send\\*** to return everything starting with \&quot;send\&quot;.  Use this parameter if you are searching for shares or receives for a specific folder name. For example **_/Clients/ACME/To Be Processed**. (optional)
     * @param recipient Filter the results to include only shares that invited a certain email address. Supports wildcard matching so that **\\*@example.com** will give back entries shared with addresses ending in \&quot;@example.com\&quot;.  (optional)
     * @param message When provided, only shares with a message that contains the text will be included in the list of matches. Both the subject and the body of all messages will be checked for matches. This will allways be a wildcard match, so that searching for **taxes** will return any shares with a message that contains the word \&quot;taxes\&quot;. (optional)
     * @param username When provided, only shares created by the user with that &#x60;username&#x60; will be included in the list. Does not support wildcard searching. (optional)
     * @param search Searches the share name, username, recipients, share messages fields for the provided value. Supports wildcard searches. (optional)
     * @return ApiResponse&lt;ShareCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareCollectionResponse> listSharesWithHttpInfo(String evApiKey, String evAccessToken, Integer offset, Integer limit, String scope, String sort, String type, String include, String name, String recipient, String message, String username, String search) throws ApiException {
        com.squareup.okhttp.Call call = listSharesValidateBeforeCall(evApiKey, evAccessToken, offset, limit, scope, sort, type, include, name, recipient, message, username, search, null, null);
        Type localVarReturnType = new TypeToken<ShareCollectionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a list of shares (asynchronously)
     * Get a list of shares that you would have access to view through the web interface. You can limit which results are returned by specifying specific types of shares you wish to view, finding things shared with a specific email address, as well as finding shares for specific folder names.   **Notes:**  - Authenticated user requires [share permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - To get share objects with type send, authenticated user&#x27;s role must be admin or master.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param offset Current offset of records (for pagination) (optional)
     * @param limit Limit of records to be returned (for pagination) (optional, default to 100)
     * @param scope Set of shares to return. (**all**&#x3D;all of them, **active**&#x3D;shares that are currently active, **curentUser**&#x3D;shares created by you) (optional)
     * @param sort What order the list of matches should be in. (optional)
     * @param type Limit the list of matches to only certain types of shares. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **owner**, **resources**, **notifications**, **activity**. (optional)
     * @param name When provided, only shares whose names include this value will be in the list. Supports wildcards, such as **send\\*** to return everything starting with \&quot;send\&quot;.  Use this parameter if you are searching for shares or receives for a specific folder name. For example **_/Clients/ACME/To Be Processed**. (optional)
     * @param recipient Filter the results to include only shares that invited a certain email address. Supports wildcard matching so that **\\*@example.com** will give back entries shared with addresses ending in \&quot;@example.com\&quot;.  (optional)
     * @param message When provided, only shares with a message that contains the text will be included in the list of matches. Both the subject and the body of all messages will be checked for matches. This will allways be a wildcard match, so that searching for **taxes** will return any shares with a message that contains the word \&quot;taxes\&quot;. (optional)
     * @param username When provided, only shares created by the user with that &#x60;username&#x60; will be included in the list. Does not support wildcard searching. (optional)
     * @param search Searches the share name, username, recipients, share messages fields for the provided value. Supports wildcard searches. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listSharesAsync(String evApiKey, String evAccessToken, Integer offset, Integer limit, String scope, String sort, String type, String include, String name, String recipient, String message, String username, String search, final ApiCallback<ShareCollectionResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = listSharesValidateBeforeCall(evApiKey, evAccessToken, offset, limit, scope, sort, type, include, name, recipient, message, username, search, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareCollectionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateShareById
     * @param body  (required)
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param id ID of the share entry (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateShareByIdCall(Body17 body, String evApiKey, String evAccessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/shares/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateShareByIdValidateBeforeCall(Body17 body, String evApiKey, String evAccessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling updateShareById(Async)");
        }
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling updateShareById(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling updateShareById(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateShareById(Async)");
        }
        
        com.squareup.okhttp.Call call = updateShareByIdCall(body, evApiKey, evAccessToken, id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update a share
     * Change the settings on an active share. Any changes made will affect all users that have access to the share.   When updating invitees, pass the &#x60;recipients&#x60; body paramater with the full list of people who should be included on the share. If you resend the list without an existing recipient, they will be removed from the share.  **Notes:**    - Authenticated user should be the owner of the specified share.
     * @param body  (required)
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param id ID of the share entry (required)
     * @return ShareResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareResponse updateShareById(Body17 body, String evApiKey, String evAccessToken, Integer id) throws ApiException {
        ApiResponse<ShareResponse> resp = updateShareByIdWithHttpInfo(body, evApiKey, evAccessToken, id);
        return resp.getData();
    }

    /**
     * Update a share
     * Change the settings on an active share. Any changes made will affect all users that have access to the share.   When updating invitees, pass the &#x60;recipients&#x60; body paramater with the full list of people who should be included on the share. If you resend the list without an existing recipient, they will be removed from the share.  **Notes:**    - Authenticated user should be the owner of the specified share.
     * @param body  (required)
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param id ID of the share entry (required)
     * @return ApiResponse&lt;ShareResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareResponse> updateShareByIdWithHttpInfo(Body17 body, String evApiKey, String evAccessToken, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = updateShareByIdValidateBeforeCall(body, evApiKey, evAccessToken, id, null, null);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update a share (asynchronously)
     * Change the settings on an active share. Any changes made will affect all users that have access to the share.   When updating invitees, pass the &#x60;recipients&#x60; body paramater with the full list of people who should be included on the share. If you resend the list without an existing recipient, they will be removed from the share.  **Notes:**    - Authenticated user should be the owner of the specified share.
     * @param body  (required)
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param id ID of the share entry (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateShareByIdAsync(Body17 body, String evApiKey, String evAccessToken, Integer id, final ApiCallback<ShareResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updateShareByIdValidateBeforeCall(body, evApiKey, evAccessToken, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
