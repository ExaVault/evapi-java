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


import io.swagger.client.model.Body;
import io.swagger.client.model.Body1;
import io.swagger.client.model.EmailListCollectionResponse;
import io.swagger.client.model.EmailListResponse;
import io.swagger.client.model.EmptyResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailListsApi {
    private ApiClient apiClient;

    public EmailListsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public EmailListsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addEmailList
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addEmailListCall(String evApiKey, String evAccessToken, Body body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/email-lists";

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
    private com.squareup.okhttp.Call addEmailListValidateBeforeCall(String evApiKey, String evAccessToken, Body body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling addEmailList(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling addEmailList(Async)");
        }
        
        com.squareup.okhttp.Call call = addEmailListCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create new email list
     * Create a new email list. Among other things, email lists can be used to send files or share folders with a group of email addresses at once.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return EmailListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmailListResponse addEmailList(String evApiKey, String evAccessToken, Body body) throws ApiException {
        ApiResponse<EmailListResponse> resp = addEmailListWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Create new email list
     * Create a new email list. Among other things, email lists can be used to send files or share folders with a group of email addresses at once.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;EmailListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmailListResponse> addEmailListWithHttpInfo(String evApiKey, String evAccessToken, Body body) throws ApiException {
        com.squareup.okhttp.Call call = addEmailListValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<EmailListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create new email list (asynchronously)
     * Create a new email list. Among other things, email lists can be used to send files or share folders with a group of email addresses at once.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addEmailListAsync(String evApiKey, String evAccessToken, Body body, final ApiCallback<EmailListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addEmailListValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmailListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteEmailListById
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to delete (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteEmailListByIdCall(String evApiKey, String evAccessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/email-lists/{id}"
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
    private com.squareup.okhttp.Call deleteEmailListByIdValidateBeforeCall(String evApiKey, String evAccessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling deleteEmailListById(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling deleteEmailListById(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteEmailListById(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteEmailListByIdCall(evApiKey, evAccessToken, id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete an email group with given id
     * Permanently delete an email group. This action is not reversable. We recommend making a user confirm this action before sending the API call. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to delete (required)
     * @return EmptyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmptyResponse deleteEmailListById(String evApiKey, String evAccessToken, Integer id) throws ApiException {
        ApiResponse<EmptyResponse> resp = deleteEmailListByIdWithHttpInfo(evApiKey, evAccessToken, id);
        return resp.getData();
    }

    /**
     * Delete an email group with given id
     * Permanently delete an email group. This action is not reversable. We recommend making a user confirm this action before sending the API call. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to delete (required)
     * @return ApiResponse&lt;EmptyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmptyResponse> deleteEmailListByIdWithHttpInfo(String evApiKey, String evAccessToken, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteEmailListByIdValidateBeforeCall(evApiKey, evAccessToken, id, null, null);
        Type localVarReturnType = new TypeToken<EmptyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete an email group with given id (asynchronously)
     * Permanently delete an email group. This action is not reversable. We recommend making a user confirm this action before sending the API call. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteEmailListByIdAsync(String evApiKey, String evAccessToken, Integer id, final ApiCallback<EmptyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteEmailListByIdValidateBeforeCall(evApiKey, evAccessToken, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmptyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getEmailListById
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to return. (required)
     * @param include Related record types to include in the response. Valid option is &#x60;ownerUser&#x60; (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getEmailListByIdCall(String evApiKey, String evAccessToken, Integer id, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/email-lists/{id}"
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
    private com.squareup.okhttp.Call getEmailListByIdValidateBeforeCall(String evApiKey, String evAccessToken, Integer id, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling getEmailListById(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling getEmailListById(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getEmailListById(Async)");
        }
        
        com.squareup.okhttp.Call call = getEmailListByIdCall(evApiKey, evAccessToken, id, include, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get individual email group
     * Retrieve all the details of a specifc email list including it&#x27;s name, when it was created and all the email addresses that belong to the group.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to return. (required)
     * @param include Related record types to include in the response. Valid option is &#x60;ownerUser&#x60; (optional)
     * @return EmailListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmailListResponse getEmailListById(String evApiKey, String evAccessToken, Integer id, String include) throws ApiException {
        ApiResponse<EmailListResponse> resp = getEmailListByIdWithHttpInfo(evApiKey, evAccessToken, id, include);
        return resp.getData();
    }

    /**
     * Get individual email group
     * Retrieve all the details of a specifc email list including it&#x27;s name, when it was created and all the email addresses that belong to the group.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to return. (required)
     * @param include Related record types to include in the response. Valid option is &#x60;ownerUser&#x60; (optional)
     * @return ApiResponse&lt;EmailListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmailListResponse> getEmailListByIdWithHttpInfo(String evApiKey, String evAccessToken, Integer id, String include) throws ApiException {
        com.squareup.okhttp.Call call = getEmailListByIdValidateBeforeCall(evApiKey, evAccessToken, id, include, null, null);
        Type localVarReturnType = new TypeToken<EmailListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get individual email group (asynchronously)
     * Retrieve all the details of a specifc email list including it&#x27;s name, when it was created and all the email addresses that belong to the group.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to return. (required)
     * @param include Related record types to include in the response. Valid option is &#x60;ownerUser&#x60; (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getEmailListByIdAsync(String evApiKey, String evAccessToken, Integer id, String include, final ApiCallback<EmailListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getEmailListByIdValidateBeforeCall(evApiKey, evAccessToken, id, include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmailListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getEmailLists
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param include Related record types to include in the response. Valid option is &#x60;ownerUser&#x60; (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getEmailListsCall(String evApiKey, String evAccessToken, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/email-lists";

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
    private com.squareup.okhttp.Call getEmailListsValidateBeforeCall(String evApiKey, String evAccessToken, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling getEmailLists(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling getEmailLists(Async)");
        }
        
        com.squareup.okhttp.Call call = getEmailListsCall(evApiKey, evAccessToken, include, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get all email groups
     * 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param include Related record types to include in the response. Valid option is &#x60;ownerUser&#x60; (optional)
     * @return EmailListCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmailListCollectionResponse getEmailLists(String evApiKey, String evAccessToken, String include) throws ApiException {
        ApiResponse<EmailListCollectionResponse> resp = getEmailListsWithHttpInfo(evApiKey, evAccessToken, include);
        return resp.getData();
    }

    /**
     * Get all email groups
     * 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param include Related record types to include in the response. Valid option is &#x60;ownerUser&#x60; (optional)
     * @return ApiResponse&lt;EmailListCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmailListCollectionResponse> getEmailListsWithHttpInfo(String evApiKey, String evAccessToken, String include) throws ApiException {
        com.squareup.okhttp.Call call = getEmailListsValidateBeforeCall(evApiKey, evAccessToken, include, null, null);
        Type localVarReturnType = new TypeToken<EmailListCollectionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all email groups (asynchronously)
     * 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param include Related record types to include in the response. Valid option is &#x60;ownerUser&#x60; (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getEmailListsAsync(String evApiKey, String evAccessToken, String include, final ApiCallback<EmailListCollectionResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getEmailListsValidateBeforeCall(evApiKey, evAccessToken, include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmailListCollectionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateEmailListById
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to update. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateEmailListByIdCall(String evApiKey, String evAccessToken, Integer id, Body1 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/email-lists/{id}"
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
    private com.squareup.okhttp.Call updateEmailListByIdValidateBeforeCall(String evApiKey, String evAccessToken, Integer id, Body1 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling updateEmailListById(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling updateEmailListById(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateEmailListById(Async)");
        }
        
        com.squareup.okhttp.Call call = updateEmailListByIdCall(evApiKey, evAccessToken, id, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Update an email group
     * Add or remove emails from an email list that can be used to send and share files with groups.   **Notes**  *This call will **replace** your current email list in its entirety.* If you want to keep any existing emails on the list, be sure to submit the call with any current emails you want to keep on the list.  
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to update. (required)
     * @param body  (optional)
     * @return EmailListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmailListResponse updateEmailListById(String evApiKey, String evAccessToken, Integer id, Body1 body) throws ApiException {
        ApiResponse<EmailListResponse> resp = updateEmailListByIdWithHttpInfo(evApiKey, evAccessToken, id, body);
        return resp.getData();
    }

    /**
     * Update an email group
     * Add or remove emails from an email list that can be used to send and share files with groups.   **Notes**  *This call will **replace** your current email list in its entirety.* If you want to keep any existing emails on the list, be sure to submit the call with any current emails you want to keep on the list.  
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to update. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;EmailListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmailListResponse> updateEmailListByIdWithHttpInfo(String evApiKey, String evAccessToken, Integer id, Body1 body) throws ApiException {
        com.squareup.okhttp.Call call = updateEmailListByIdValidateBeforeCall(evApiKey, evAccessToken, id, body, null, null);
        Type localVarReturnType = new TypeToken<EmailListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update an email group (asynchronously)
     * Add or remove emails from an email list that can be used to send and share files with groups.   **Notes**  *This call will **replace** your current email list in its entirety.* If you want to keep any existing emails on the list, be sure to submit the call with any current emails you want to keep on the list.  
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the email list to update. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateEmailListByIdAsync(String evApiKey, String evAccessToken, Integer id, Body1 body, final ApiCallback<EmailListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateEmailListByIdValidateBeforeCall(evApiKey, evAccessToken, id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmailListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
