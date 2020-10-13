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


import io.swagger.client.model.Body10;
import io.swagger.client.model.Body11;
import io.swagger.client.model.Body12;
import io.swagger.client.model.Body13;
import io.swagger.client.model.Body7;
import io.swagger.client.model.Body8;
import io.swagger.client.model.Body9;
import io.swagger.client.model.DownloadPollingResponse;
import io.swagger.client.model.EmptyResponse;
import java.io.File;
import io.swagger.client.model.PreviewFileResponse;
import io.swagger.client.model.ResourceCollectionResponse;
import io.swagger.client.model.ResourceCopyMove;
import io.swagger.client.model.ResourceMultiResponse;
import io.swagger.client.model.ResourceResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourcesApi {
    private ApiClient apiClient;

    public ResourcesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ResourcesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addFolder
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addFolderCall(String evApiKey, String evAccessToken, Body8 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/resources";

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
    private com.squareup.okhttp.Call addFolderValidateBeforeCall(String evApiKey, String evAccessToken, Body8 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling addFolder(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling addFolder(Async)");
        }
        
        com.squareup.okhttp.Call call = addFolderCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a folder
     * Create a new empty folder at the specified path. New files can be uploaded via the [/resources/upload](#operation/uploadFile) endpoint.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse addFolder(String evApiKey, String evAccessToken, Body8 body) throws ApiException {
        ApiResponse<ResourceResponse> resp = addFolderWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Create a folder
     * Create a new empty folder at the specified path. New files can be uploaded via the [/resources/upload](#operation/uploadFile) endpoint.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceResponse> addFolderWithHttpInfo(String evApiKey, String evAccessToken, Body8 body) throws ApiException {
        com.squareup.okhttp.Call call = addFolderValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a folder (asynchronously)
     * Create a new empty folder at the specified path. New files can be uploaded via the [/resources/upload](#operation/uploadFile) endpoint.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addFolderAsync(String evApiKey, String evAccessToken, Body8 body, final ApiCallback<ResourceResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addFolderValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for compressFiles
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call compressFilesCall(String evApiKey, String evAccessToken, Body10 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/resources/compress";

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
    private com.squareup.okhttp.Call compressFilesValidateBeforeCall(String evApiKey, String evAccessToken, Body10 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling compressFiles(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling compressFiles(Async)");
        }
        
        com.squareup.okhttp.Call call = compressFilesCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Compress resources
     * Create a zip archive containing the files from given set of paths. Note that this can be a very slow operation if you have indicated many files should be included in the archive.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse compressFiles(String evApiKey, String evAccessToken, Body10 body) throws ApiException {
        ApiResponse<ResourceResponse> resp = compressFilesWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Compress resources
     * Create a zip archive containing the files from given set of paths. Note that this can be a very slow operation if you have indicated many files should be included in the archive.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceResponse> compressFilesWithHttpInfo(String evApiKey, String evAccessToken, Body10 body) throws ApiException {
        com.squareup.okhttp.Call call = compressFilesValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Compress resources (asynchronously)
     * Create a zip archive containing the files from given set of paths. Note that this can be a very slow operation if you have indicated many files should be included in the archive.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call compressFilesAsync(String evApiKey, String evAccessToken, Body10 body, final ApiCallback<ResourceResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = compressFilesValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for copyResources
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call copyResourcesCall(String evApiKey, String evAccessToken, Body12 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/resources/copy";

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
    private com.squareup.okhttp.Call copyResourcesValidateBeforeCall(String evApiKey, String evAccessToken, Body12 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling copyResources(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling copyResources(Async)");
        }
        
        com.squareup.okhttp.Call call = copyResourcesCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Copy resources
     * Copies a set of exisiting files/folders (provided by an array &#x60;resources&#x60;) to the requested &#x60;parentResource&#x60; in your account. In the &#x60;resources&#x60; array, you may specify paths pointing files/folders throughout the account, but everything will be copied to the  root of the &#x60;parentResource&#x60;.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ResourceCopyMove
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceCopyMove copyResources(String evApiKey, String evAccessToken, Body12 body) throws ApiException {
        ApiResponse<ResourceCopyMove> resp = copyResourcesWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Copy resources
     * Copies a set of exisiting files/folders (provided by an array &#x60;resources&#x60;) to the requested &#x60;parentResource&#x60; in your account. In the &#x60;resources&#x60; array, you may specify paths pointing files/folders throughout the account, but everything will be copied to the  root of the &#x60;parentResource&#x60;.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ResourceCopyMove&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceCopyMove> copyResourcesWithHttpInfo(String evApiKey, String evAccessToken, Body12 body) throws ApiException {
        com.squareup.okhttp.Call call = copyResourcesValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<ResourceCopyMove>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Copy resources (asynchronously)
     * Copies a set of exisiting files/folders (provided by an array &#x60;resources&#x60;) to the requested &#x60;parentResource&#x60; in your account. In the &#x60;resources&#x60; array, you may specify paths pointing files/folders throughout the account, but everything will be copied to the  root of the &#x60;parentResource&#x60;.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call copyResourcesAsync(String evApiKey, String evAccessToken, Body12 body, final ApiCallback<ResourceCopyMove> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = copyResourcesValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceCopyMove>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteResourceById
     * @param id ID number of the resource (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteResourceByIdCall(Integer id, String evApiKey, String evAccessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/resources/{id}"
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
    private com.squareup.okhttp.Call deleteResourceByIdValidateBeforeCall(Integer id, String evApiKey, String evAccessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteResourceById(Async)");
        }
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling deleteResourceById(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling deleteResourceById(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteResourceByIdCall(id, evApiKey, evAccessToken, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a Resource
     * Delete a single file or folder resource. Deleting a folder will also delete all of the contents.  **Notes:** - Authenticated user should have [delete permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - There is no way to un-delete a deleted resource. 
     * @param id ID number of the resource (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @return EmptyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmptyResponse deleteResourceById(Integer id, String evApiKey, String evAccessToken) throws ApiException {
        ApiResponse<EmptyResponse> resp = deleteResourceByIdWithHttpInfo(id, evApiKey, evAccessToken);
        return resp.getData();
    }

    /**
     * Delete a Resource
     * Delete a single file or folder resource. Deleting a folder will also delete all of the contents.  **Notes:** - Authenticated user should have [delete permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - There is no way to un-delete a deleted resource. 
     * @param id ID number of the resource (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @return ApiResponse&lt;EmptyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmptyResponse> deleteResourceByIdWithHttpInfo(Integer id, String evApiKey, String evAccessToken) throws ApiException {
        com.squareup.okhttp.Call call = deleteResourceByIdValidateBeforeCall(id, evApiKey, evAccessToken, null, null);
        Type localVarReturnType = new TypeToken<EmptyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a Resource (asynchronously)
     * Delete a single file or folder resource. Deleting a folder will also delete all of the contents.  **Notes:** - Authenticated user should have [delete permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - There is no way to un-delete a deleted resource. 
     * @param id ID number of the resource (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteResourceByIdAsync(Integer id, String evApiKey, String evAccessToken, final ApiCallback<EmptyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteResourceByIdValidateBeforeCall(id, evApiKey, evAccessToken, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmptyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteResources
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteResourcesCall(String evApiKey, String evAccessToken, Body9 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/resources";

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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteResourcesValidateBeforeCall(String evApiKey, String evAccessToken, Body9 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling deleteResources(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling deleteResources(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteResourcesCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete Resources
     * Delete multiple file or folder resourcess. Deleting a folder resource will also delete any resources in that folder.  **Notes:** - Authenticated user should have [delete permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - It is not possible to un-delete a deleted resource. 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param body  (optional)
     * @return EmptyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EmptyResponse deleteResources(String evApiKey, String evAccessToken, Body9 body) throws ApiException {
        ApiResponse<EmptyResponse> resp = deleteResourcesWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Delete Resources
     * Delete multiple file or folder resourcess. Deleting a folder resource will also delete any resources in that folder.  **Notes:** - Authenticated user should have [delete permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - It is not possible to un-delete a deleted resource. 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param body  (optional)
     * @return ApiResponse&lt;EmptyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EmptyResponse> deleteResourcesWithHttpInfo(String evApiKey, String evAccessToken, Body9 body) throws ApiException {
        com.squareup.okhttp.Call call = deleteResourcesValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<EmptyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete Resources (asynchronously)
     * Delete multiple file or folder resourcess. Deleting a folder resource will also delete any resources in that folder.  **Notes:** - Authenticated user should have [delete permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions). - It is not possible to un-delete a deleted resource. 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteResourcesAsync(String evApiKey, String evAccessToken, Body9 body, final ApiCallback<EmptyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteResourcesValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EmptyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for download
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resources Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. (required)
     * @param downloadName If zipping multiple files, the name of the zip file to create and download. (optional)
     * @param polling Used when downloading multiple files so url will be pulled till zip file is created. (optional)
     * @param pollingZipName Reference to the previously created zip for polling operation. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call downloadCall(String evApiKey, String evAccessToken, List<String> resources, String downloadName, Boolean polling, String pollingZipName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/resources/download";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (resources != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "resources[]", resources));
        if (downloadName != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("downloadName", downloadName));
        if (polling != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("polling", polling));
        if (pollingZipName != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("pollingZipName", pollingZipName));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/octet-stream", "application/zip", "application/json"
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
    private com.squareup.okhttp.Call downloadValidateBeforeCall(String evApiKey, String evAccessToken, List<String> resources, String downloadName, Boolean polling, String pollingZipName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling download(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling download(Async)");
        }
        // verify the required parameter 'resources' is set
        if (resources == null) {
            throw new ApiException("Missing the required parameter 'resources' when calling download(Async)");
        }
        
        com.squareup.okhttp.Call call = downloadCall(evApiKey, evAccessToken, resources, downloadName, polling, pollingZipName, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Download a file
     * Downloads a file. If more than one path is supplied, the files will be zipped before downloading with the downloadName parameter if supplied. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resources Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. (required)
     * @param downloadName If zipping multiple files, the name of the zip file to create and download. (optional)
     * @param polling Used when downloading multiple files so url will be pulled till zip file is created. (optional)
     * @param pollingZipName Reference to the previously created zip for polling operation. (optional)
     * @return File
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public File download(String evApiKey, String evAccessToken, List<String> resources, String downloadName, Boolean polling, String pollingZipName) throws ApiException {
        ApiResponse<File> resp = downloadWithHttpInfo(evApiKey, evAccessToken, resources, downloadName, polling, pollingZipName);
        return resp.getData();
    }

    /**
     * Download a file
     * Downloads a file. If more than one path is supplied, the files will be zipped before downloading with the downloadName parameter if supplied. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resources Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. (required)
     * @param downloadName If zipping multiple files, the name of the zip file to create and download. (optional)
     * @param polling Used when downloading multiple files so url will be pulled till zip file is created. (optional)
     * @param pollingZipName Reference to the previously created zip for polling operation. (optional)
     * @return ApiResponse&lt;File&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<File> downloadWithHttpInfo(String evApiKey, String evAccessToken, List<String> resources, String downloadName, Boolean polling, String pollingZipName) throws ApiException {
        com.squareup.okhttp.Call call = downloadValidateBeforeCall(evApiKey, evAccessToken, resources, downloadName, polling, pollingZipName, null, null);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Download a file (asynchronously)
     * Downloads a file. If more than one path is supplied, the files will be zipped before downloading with the downloadName parameter if supplied. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resources Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. (required)
     * @param downloadName If zipping multiple files, the name of the zip file to create and download. (optional)
     * @param polling Used when downloading multiple files so url will be pulled till zip file is created. (optional)
     * @param pollingZipName Reference to the previously created zip for polling operation. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call downloadAsync(String evApiKey, String evAccessToken, List<String> resources, String downloadName, Boolean polling, String pollingZipName, final ApiCallback<File> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = downloadValidateBeforeCall(evApiKey, evAccessToken, resources, downloadName, polling, pollingZipName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<File>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for extractFiles
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call extractFilesCall(String evApiKey, String evAccessToken, Body11 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/resources/extract";

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
    private com.squareup.okhttp.Call extractFilesValidateBeforeCall(String evApiKey, String evAccessToken, Body11 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling extractFiles(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling extractFiles(Async)");
        }
        
        com.squareup.okhttp.Call call = extractFilesCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Extract resources
     * Extract the contents of a zip archive to a specified directory. Note that this can be a very slow operation.  **Notes:** - You must have  [modify permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to do this. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ResourceCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceCollectionResponse extractFiles(String evApiKey, String evAccessToken, Body11 body) throws ApiException {
        ApiResponse<ResourceCollectionResponse> resp = extractFilesWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Extract resources
     * Extract the contents of a zip archive to a specified directory. Note that this can be a very slow operation.  **Notes:** - You must have  [modify permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to do this. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ResourceCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceCollectionResponse> extractFilesWithHttpInfo(String evApiKey, String evAccessToken, Body11 body) throws ApiException {
        com.squareup.okhttp.Call call = extractFilesValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<ResourceCollectionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Extract resources (asynchronously)
     * Extract the contents of a zip archive to a specified directory. Note that this can be a very slow operation.  **Notes:** - You must have  [modify permission](/docs/account/04-users/00-introduction#managing-user-roles-and-permissions) to do this. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call extractFilesAsync(String evApiKey, String evAccessToken, Body11 body, final ApiCallback<ResourceCollectionResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = extractFilesValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceCollectionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getPreviewImage
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param resource Resource identifier for the image file. (required)
     * @param size The size of the image. (required)
     * @param width Overrides sizes. Sets to a specific width. (optional)
     * @param height Overrides sizes. Sets to a specific height. (optional)
     * @param page Page number to extract from a multi-page document (0 is the first page). Vaild for **.pdf** or **.doc** files. (optional, default to 0)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getPreviewImageCall(String evApiKey, String evAccessToken, String resource, String size, Integer width, Integer height, Integer page, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/resources/preview";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (resource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("resource", resource));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("size", size));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));

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
    private com.squareup.okhttp.Call getPreviewImageValidateBeforeCall(String evApiKey, String evAccessToken, String resource, String size, Integer width, Integer height, Integer page, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling getPreviewImage(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling getPreviewImage(Async)");
        }
        // verify the required parameter 'resource' is set
        if (resource == null) {
            throw new ApiException("Missing the required parameter 'resource' when calling getPreviewImage(Async)");
        }
        // verify the required parameter 'size' is set
        if (size == null) {
            throw new ApiException("Missing the required parameter 'size' when calling getPreviewImage(Async)");
        }
        
        com.squareup.okhttp.Call call = getPreviewImageCall(evApiKey, evAccessToken, resource, size, width, height, page, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Preview a file
     * Returns a resized image of the specified document for supported file types.  Image data returned is encoded in base64 format and can be viewed using the &#x60;&lt;img&gt;&#x60; element.   &#x60;&#x60;&#x60;&lt;img src&#x3D;&#x27;data:image/jpeg;base64&#x27; + meta.image/&gt;&#x60;&#x60;&#x60;  **Notes:** - Supported files types are &#x60;&#x27;jpg&#x27;&#x60;, &#x60;&#x27;jpeg&#x27;&#x60;, &#x60;&#x27;gif&#x27;&#x60;, &#x60;&#x27;png&#x27;&#x60;, &#x60;&#x27;bmp&#x27;&#x60;, &#x60;&#x27;pdf&#x27;&#x60;, &#x60;&#x27;psd&#x27;&#x60;, &#x60;&#x27;doc&#x27;&#x60; 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param resource Resource identifier for the image file. (required)
     * @param size The size of the image. (required)
     * @param width Overrides sizes. Sets to a specific width. (optional)
     * @param height Overrides sizes. Sets to a specific height. (optional)
     * @param page Page number to extract from a multi-page document (0 is the first page). Vaild for **.pdf** or **.doc** files. (optional, default to 0)
     * @return PreviewFileResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PreviewFileResponse getPreviewImage(String evApiKey, String evAccessToken, String resource, String size, Integer width, Integer height, Integer page) throws ApiException {
        ApiResponse<PreviewFileResponse> resp = getPreviewImageWithHttpInfo(evApiKey, evAccessToken, resource, size, width, height, page);
        return resp.getData();
    }

    /**
     * Preview a file
     * Returns a resized image of the specified document for supported file types.  Image data returned is encoded in base64 format and can be viewed using the &#x60;&lt;img&gt;&#x60; element.   &#x60;&#x60;&#x60;&lt;img src&#x3D;&#x27;data:image/jpeg;base64&#x27; + meta.image/&gt;&#x60;&#x60;&#x60;  **Notes:** - Supported files types are &#x60;&#x27;jpg&#x27;&#x60;, &#x60;&#x27;jpeg&#x27;&#x60;, &#x60;&#x27;gif&#x27;&#x60;, &#x60;&#x27;png&#x27;&#x60;, &#x60;&#x27;bmp&#x27;&#x60;, &#x60;&#x27;pdf&#x27;&#x60;, &#x60;&#x27;psd&#x27;&#x60;, &#x60;&#x27;doc&#x27;&#x60; 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param resource Resource identifier for the image file. (required)
     * @param size The size of the image. (required)
     * @param width Overrides sizes. Sets to a specific width. (optional)
     * @param height Overrides sizes. Sets to a specific height. (optional)
     * @param page Page number to extract from a multi-page document (0 is the first page). Vaild for **.pdf** or **.doc** files. (optional, default to 0)
     * @return ApiResponse&lt;PreviewFileResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PreviewFileResponse> getPreviewImageWithHttpInfo(String evApiKey, String evAccessToken, String resource, String size, Integer width, Integer height, Integer page) throws ApiException {
        com.squareup.okhttp.Call call = getPreviewImageValidateBeforeCall(evApiKey, evAccessToken, resource, size, width, height, page, null, null);
        Type localVarReturnType = new TypeToken<PreviewFileResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Preview a file (asynchronously)
     * Returns a resized image of the specified document for supported file types.  Image data returned is encoded in base64 format and can be viewed using the &#x60;&lt;img&gt;&#x60; element.   &#x60;&#x60;&#x60;&lt;img src&#x3D;&#x27;data:image/jpeg;base64&#x27; + meta.image/&gt;&#x60;&#x60;&#x60;  **Notes:** - Supported files types are &#x60;&#x27;jpg&#x27;&#x60;, &#x60;&#x27;jpeg&#x27;&#x60;, &#x60;&#x27;gif&#x27;&#x60;, &#x60;&#x27;png&#x27;&#x60;, &#x60;&#x27;bmp&#x27;&#x60;, &#x60;&#x27;pdf&#x27;&#x60;, &#x60;&#x27;psd&#x27;&#x60;, &#x60;&#x27;doc&#x27;&#x60; 
     * @param evApiKey API Key (required)
     * @param evAccessToken Access Token (required)
     * @param resource Resource identifier for the image file. (required)
     * @param size The size of the image. (required)
     * @param width Overrides sizes. Sets to a specific width. (optional)
     * @param height Overrides sizes. Sets to a specific height. (optional)
     * @param page Page number to extract from a multi-page document (0 is the first page). Vaild for **.pdf** or **.doc** files. (optional, default to 0)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getPreviewImageAsync(String evApiKey, String evAccessToken, String resource, String size, Integer width, Integer height, Integer page, final ApiCallback<PreviewFileResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getPreviewImageValidateBeforeCall(evApiKey, evAccessToken, resource, size, width, height, page, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PreviewFileResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getResourceInfo
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resource Resource identifier of the file or folder to get metadata for. (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerUser**. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getResourceInfoCall(String evApiKey, String evAccessToken, String resource, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/resources";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (resource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("resource", resource));
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
    private com.squareup.okhttp.Call getResourceInfoValidateBeforeCall(String evApiKey, String evAccessToken, String resource, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling getResourceInfo(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling getResourceInfo(Async)");
        }
        // verify the required parameter 'resource' is set
        if (resource == null) {
            throw new ApiException("Missing the required parameter 'resource' when calling getResourceInfo(Async)");
        }
        
        com.squareup.okhttp.Call call = getResourceInfoCall(evApiKey, evAccessToken, resource, include, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get Resource Properties
     * Returns details for specified file/folder id or hash, including upload date, size and type. For the full list of returned properties, see the response syntax, below.  **Notes:** - Authenticated user should have list permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resource Resource identifier of the file or folder to get metadata for. (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerUser**. (optional)
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse getResourceInfo(String evApiKey, String evAccessToken, String resource, String include) throws ApiException {
        ApiResponse<ResourceResponse> resp = getResourceInfoWithHttpInfo(evApiKey, evAccessToken, resource, include);
        return resp.getData();
    }

    /**
     * Get Resource Properties
     * Returns details for specified file/folder id or hash, including upload date, size and type. For the full list of returned properties, see the response syntax, below.  **Notes:** - Authenticated user should have list permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resource Resource identifier of the file or folder to get metadata for. (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerUser**. (optional)
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceResponse> getResourceInfoWithHttpInfo(String evApiKey, String evAccessToken, String resource, String include) throws ApiException {
        com.squareup.okhttp.Call call = getResourceInfoValidateBeforeCall(evApiKey, evAccessToken, resource, include, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Resource Properties (asynchronously)
     * Returns details for specified file/folder id or hash, including upload date, size and type. For the full list of returned properties, see the response syntax, below.  **Notes:** - Authenticated user should have list permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resource Resource identifier of the file or folder to get metadata for. (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerUser**. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResourceInfoAsync(String evApiKey, String evAccessToken, String resource, String include, final ApiCallback<ResourceResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getResourceInfoValidateBeforeCall(evApiKey, evAccessToken, resource, include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getResourceInfoById
     * @param id ID number of the resource (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerAccount**. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getResourceInfoByIdCall(Integer id, String evApiKey, String evAccessToken, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/resources/{id}"
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
    private com.squareup.okhttp.Call getResourceInfoByIdValidateBeforeCall(Integer id, String evApiKey, String evAccessToken, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getResourceInfoById(Async)");
        }
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling getResourceInfoById(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling getResourceInfoById(Async)");
        }
        
        com.squareup.okhttp.Call call = getResourceInfoByIdCall(id, evApiKey, evAccessToken, include, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get resource metadata
     * Returns metadata for specified file/folder path, including upload date, size and type. For the full list of returned properties, see the response syntax, below.  **Notes:** - Authenticated user should have list permission. 
     * @param id ID number of the resource (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerAccount**. (optional)
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse getResourceInfoById(Integer id, String evApiKey, String evAccessToken, String include) throws ApiException {
        ApiResponse<ResourceResponse> resp = getResourceInfoByIdWithHttpInfo(id, evApiKey, evAccessToken, include);
        return resp.getData();
    }

    /**
     * Get resource metadata
     * Returns metadata for specified file/folder path, including upload date, size and type. For the full list of returned properties, see the response syntax, below.  **Notes:** - Authenticated user should have list permission. 
     * @param id ID number of the resource (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerAccount**. (optional)
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceResponse> getResourceInfoByIdWithHttpInfo(Integer id, String evApiKey, String evAccessToken, String include) throws ApiException {
        com.squareup.okhttp.Call call = getResourceInfoByIdValidateBeforeCall(id, evApiKey, evAccessToken, include, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get resource metadata (asynchronously)
     * Returns metadata for specified file/folder path, including upload date, size and type. For the full list of returned properties, see the response syntax, below.  **Notes:** - Authenticated user should have list permission. 
     * @param id ID number of the resource (required)
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerAccount**. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResourceInfoByIdAsync(Integer id, String evApiKey, String evAccessToken, String include, final ApiCallback<ResourceResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getResourceInfoByIdValidateBeforeCall(id, evApiKey, evAccessToken, include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for listResourceContents
     * @param evApiKey API Key required to make the API call.  (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the parent resource to get a list of resources for. (required)
     * @param sort Endpoint support multiple sort fields by allowing array of sort params. Sort fields should be applied in the order specified. The sort order for each sort field is ascending unless it is prefixed with a minus (“-“), in which case it will be descending. (optional)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls, incrementing the &#x60;offset parameter, above. (optional)
     * @param type Limit types of resources returned to \&quot;file\&quot; or \&quot;dir\&quot; only. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerUser**. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call listResourceContentsCall(String evApiKey, String evAccessToken, Integer id, String sort, Integer offset, Integer limit, String type, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/resources/list/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (type != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("type", type));
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
    private com.squareup.okhttp.Call listResourceContentsValidateBeforeCall(String evApiKey, String evAccessToken, Integer id, String sort, Integer offset, Integer limit, String type, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling listResourceContents(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling listResourceContents(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling listResourceContents(Async)");
        }
        
        com.squareup.okhttp.Call call = listResourceContentsCall(evApiKey, evAccessToken, id, sort, offset, limit, type, include, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List contents of folder
     * Returns a list of files/folders for the parent resource ID.   You can use this API call to get information about all files and folders at a specified path. By default, the API returns basic metadata on each file/folder. An optional &#x60;include&#x60; parameter forces the return of additional metadata. As with all API calls, the path should be the full path relative to the user&#x27;s home directory (e.g. **_/myfiles/some_folder**).  **Notes:** - Authenticated user should have list permission. 
     * @param evApiKey API Key required to make the API call.  (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the parent resource to get a list of resources for. (required)
     * @param sort Endpoint support multiple sort fields by allowing array of sort params. Sort fields should be applied in the order specified. The sort order for each sort field is ascending unless it is prefixed with a minus (“-“), in which case it will be descending. (optional)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls, incrementing the &#x60;offset parameter, above. (optional)
     * @param type Limit types of resources returned to \&quot;file\&quot; or \&quot;dir\&quot; only. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerUser**. (optional)
     * @return ResourceCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceCollectionResponse listResourceContents(String evApiKey, String evAccessToken, Integer id, String sort, Integer offset, Integer limit, String type, String include) throws ApiException {
        ApiResponse<ResourceCollectionResponse> resp = listResourceContentsWithHttpInfo(evApiKey, evAccessToken, id, sort, offset, limit, type, include);
        return resp.getData();
    }

    /**
     * List contents of folder
     * Returns a list of files/folders for the parent resource ID.   You can use this API call to get information about all files and folders at a specified path. By default, the API returns basic metadata on each file/folder. An optional &#x60;include&#x60; parameter forces the return of additional metadata. As with all API calls, the path should be the full path relative to the user&#x27;s home directory (e.g. **_/myfiles/some_folder**).  **Notes:** - Authenticated user should have list permission. 
     * @param evApiKey API Key required to make the API call.  (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the parent resource to get a list of resources for. (required)
     * @param sort Endpoint support multiple sort fields by allowing array of sort params. Sort fields should be applied in the order specified. The sort order for each sort field is ascending unless it is prefixed with a minus (“-“), in which case it will be descending. (optional)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls, incrementing the &#x60;offset parameter, above. (optional)
     * @param type Limit types of resources returned to \&quot;file\&quot; or \&quot;dir\&quot; only. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerUser**. (optional)
     * @return ApiResponse&lt;ResourceCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceCollectionResponse> listResourceContentsWithHttpInfo(String evApiKey, String evAccessToken, Integer id, String sort, Integer offset, Integer limit, String type, String include) throws ApiException {
        com.squareup.okhttp.Call call = listResourceContentsValidateBeforeCall(evApiKey, evAccessToken, id, sort, offset, limit, type, include, null, null);
        Type localVarReturnType = new TypeToken<ResourceCollectionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List contents of folder (asynchronously)
     * Returns a list of files/folders for the parent resource ID.   You can use this API call to get information about all files and folders at a specified path. By default, the API returns basic metadata on each file/folder. An optional &#x60;include&#x60; parameter forces the return of additional metadata. As with all API calls, the path should be the full path relative to the user&#x27;s home directory (e.g. **_/myfiles/some_folder**).  **Notes:** - Authenticated user should have list permission. 
     * @param evApiKey API Key required to make the API call.  (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param id ID of the parent resource to get a list of resources for. (required)
     * @param sort Endpoint support multiple sort fields by allowing array of sort params. Sort fields should be applied in the order specified. The sort order for each sort field is ascending unless it is prefixed with a minus (“-“), in which case it will be descending. (optional)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls, incrementing the &#x60;offset parameter, above. (optional)
     * @param type Limit types of resources returned to \&quot;file\&quot; or \&quot;dir\&quot; only. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerUser**. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listResourceContentsAsync(String evApiKey, String evAccessToken, Integer id, String sort, Integer offset, Integer limit, String type, String include, final ApiCallback<ResourceCollectionResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = listResourceContentsValidateBeforeCall(evApiKey, evAccessToken, id, sort, offset, limit, type, include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceCollectionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for listResources
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resource Resource identifier to get resources for. Can be path/id/name. (required)
     * @param sort Endpoint support multiple sort fields by allowing array of sort params. Sort fields should be applied in the order specified. The sort order for each sort field is ascending unless it is prefixed with a minus (“-“), in which case it will be descending. (optional)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls, incrementing the &#x60;offset&#x60; parameter, above. (optional)
     * @param type Limit types of resources returned to \&quot;file\&quot; or \&quot;dir\&quot; only. This is ignored if you are using the name parameter to trigger a search. (optional)
     * @param name Text to match resource names. This allows you to filter the results returned. For example, to locate only zip archive files, you can enter &#x60;*zip&#x60; and only resources ending in \&quot;zip\&quot; will be included in the list of results. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerAccount**. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call listResourcesCall(String evApiKey, String evAccessToken, String resource, String sort, Integer offset, Integer limit, String type, String name, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/resources/list";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (resource != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("resource", resource));
        if (sort != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sort", sort));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (type != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("type", type));
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("name", name));
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
    private com.squareup.okhttp.Call listResourcesValidateBeforeCall(String evApiKey, String evAccessToken, String resource, String sort, Integer offset, Integer limit, String type, String name, String include, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling listResources(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling listResources(Async)");
        }
        // verify the required parameter 'resource' is set
        if (resource == null) {
            throw new ApiException("Missing the required parameter 'resource' when calling listResources(Async)");
        }
        
        com.squareup.okhttp.Call call = listResourcesCall(evApiKey, evAccessToken, resource, sort, offset, limit, type, name, include, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a list of all resources
     * Returns a list of files and folders in the account. Use the &#x60;resource&#x60; query parameter to indicate the folder you wish to search in (which can be /).   **Searching for Files and Folders**  Using the &#x60;name&#x60; parameter triggers search mode, which will search the entire directory structure under the provided &#x60;resource&#x60; for files or folders with names matching the provided &#x60;name&#x60;. This supports wildcard matching such as:  - \\*Report\\* would find any files or folders with \&quot;Report\&quot; in the name. - Data\\_202?-09-30.xlsx would match items such as \&quot;Data\\_2020-09-30.xlsx\&quot;, \&quot;DATA\\_2021-09-30.xlsx\&quot;, \&quot;data\\_2022-09-30.xlsx\&quot; etc. - sales\\* would find any files or folders starting with the word \&quot;Sales\&quot; - \\*.csv would locate any files ending in \&quot;.csv\&quot; - \\* matches everything within the directory tree starting at your given &#x60;resource&#x60;  The search is not case-sensitive. Searching for Clients\\* or clients\\* or CLIENTS\\*, etc. will provide identical results  You cannot use the &#x60;type&#x60; parameter if you are using the &#x60;name&#x60; parameter to run a search.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resource Resource identifier to get resources for. Can be path/id/name. (required)
     * @param sort Endpoint support multiple sort fields by allowing array of sort params. Sort fields should be applied in the order specified. The sort order for each sort field is ascending unless it is prefixed with a minus (“-“), in which case it will be descending. (optional)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls, incrementing the &#x60;offset&#x60; parameter, above. (optional)
     * @param type Limit types of resources returned to \&quot;file\&quot; or \&quot;dir\&quot; only. This is ignored if you are using the name parameter to trigger a search. (optional)
     * @param name Text to match resource names. This allows you to filter the results returned. For example, to locate only zip archive files, you can enter &#x60;*zip&#x60; and only resources ending in \&quot;zip\&quot; will be included in the list of results. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerAccount**. (optional)
     * @return ResourceCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceCollectionResponse listResources(String evApiKey, String evAccessToken, String resource, String sort, Integer offset, Integer limit, String type, String name, String include) throws ApiException {
        ApiResponse<ResourceCollectionResponse> resp = listResourcesWithHttpInfo(evApiKey, evAccessToken, resource, sort, offset, limit, type, name, include);
        return resp.getData();
    }

    /**
     * Get a list of all resources
     * Returns a list of files and folders in the account. Use the &#x60;resource&#x60; query parameter to indicate the folder you wish to search in (which can be /).   **Searching for Files and Folders**  Using the &#x60;name&#x60; parameter triggers search mode, which will search the entire directory structure under the provided &#x60;resource&#x60; for files or folders with names matching the provided &#x60;name&#x60;. This supports wildcard matching such as:  - \\*Report\\* would find any files or folders with \&quot;Report\&quot; in the name. - Data\\_202?-09-30.xlsx would match items such as \&quot;Data\\_2020-09-30.xlsx\&quot;, \&quot;DATA\\_2021-09-30.xlsx\&quot;, \&quot;data\\_2022-09-30.xlsx\&quot; etc. - sales\\* would find any files or folders starting with the word \&quot;Sales\&quot; - \\*.csv would locate any files ending in \&quot;.csv\&quot; - \\* matches everything within the directory tree starting at your given &#x60;resource&#x60;  The search is not case-sensitive. Searching for Clients\\* or clients\\* or CLIENTS\\*, etc. will provide identical results  You cannot use the &#x60;type&#x60; parameter if you are using the &#x60;name&#x60; parameter to run a search.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resource Resource identifier to get resources for. Can be path/id/name. (required)
     * @param sort Endpoint support multiple sort fields by allowing array of sort params. Sort fields should be applied in the order specified. The sort order for each sort field is ascending unless it is prefixed with a minus (“-“), in which case it will be descending. (optional)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls, incrementing the &#x60;offset&#x60; parameter, above. (optional)
     * @param type Limit types of resources returned to \&quot;file\&quot; or \&quot;dir\&quot; only. This is ignored if you are using the name parameter to trigger a search. (optional)
     * @param name Text to match resource names. This allows you to filter the results returned. For example, to locate only zip archive files, you can enter &#x60;*zip&#x60; and only resources ending in \&quot;zip\&quot; will be included in the list of results. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerAccount**. (optional)
     * @return ApiResponse&lt;ResourceCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceCollectionResponse> listResourcesWithHttpInfo(String evApiKey, String evAccessToken, String resource, String sort, Integer offset, Integer limit, String type, String name, String include) throws ApiException {
        com.squareup.okhttp.Call call = listResourcesValidateBeforeCall(evApiKey, evAccessToken, resource, sort, offset, limit, type, name, include, null, null);
        Type localVarReturnType = new TypeToken<ResourceCollectionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a list of all resources (asynchronously)
     * Returns a list of files and folders in the account. Use the &#x60;resource&#x60; query parameter to indicate the folder you wish to search in (which can be /).   **Searching for Files and Folders**  Using the &#x60;name&#x60; parameter triggers search mode, which will search the entire directory structure under the provided &#x60;resource&#x60; for files or folders with names matching the provided &#x60;name&#x60;. This supports wildcard matching such as:  - \\*Report\\* would find any files or folders with \&quot;Report\&quot; in the name. - Data\\_202?-09-30.xlsx would match items such as \&quot;Data\\_2020-09-30.xlsx\&quot;, \&quot;DATA\\_2021-09-30.xlsx\&quot;, \&quot;data\\_2022-09-30.xlsx\&quot; etc. - sales\\* would find any files or folders starting with the word \&quot;Sales\&quot; - \\*.csv would locate any files ending in \&quot;.csv\&quot; - \\* matches everything within the directory tree starting at your given &#x60;resource&#x60;  The search is not case-sensitive. Searching for Clients\\* or clients\\* or CLIENTS\\*, etc. will provide identical results  You cannot use the &#x60;type&#x60; parameter if you are using the &#x60;name&#x60; parameter to run a search.
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param resource Resource identifier to get resources for. Can be path/id/name. (required)
     * @param sort Endpoint support multiple sort fields by allowing array of sort params. Sort fields should be applied in the order specified. The sort order for each sort field is ascending unless it is prefixed with a minus (“-“), in which case it will be descending. (optional)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls, incrementing the &#x60;offset&#x60; parameter, above. (optional)
     * @param type Limit types of resources returned to \&quot;file\&quot; or \&quot;dir\&quot; only. This is ignored if you are using the name parameter to trigger a search. (optional)
     * @param name Text to match resource names. This allows you to filter the results returned. For example, to locate only zip archive files, you can enter &#x60;*zip&#x60; and only resources ending in \&quot;zip\&quot; will be included in the list of results. (optional)
     * @param include Comma separated list of relationships to include in response. Possible values are **share**, **notifications**, **directFile**, **parentResource**, **ownerUser**, **ownerAccount**. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listResourcesAsync(String evApiKey, String evAccessToken, String resource, String sort, Integer offset, Integer limit, String type, String name, String include, final ApiCallback<ResourceCollectionResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = listResourcesValidateBeforeCall(evApiKey, evAccessToken, resource, sort, offset, limit, type, name, include, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceCollectionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for moveResources
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call moveResourcesCall(String evApiKey, String evAccessToken, Body13 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/resources/move";

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
    private com.squareup.okhttp.Call moveResourcesValidateBeforeCall(String evApiKey, String evAccessToken, Body13 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling moveResources(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling moveResources(Async)");
        }
        
        com.squareup.okhttp.Call call = moveResourcesCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Move resources
     * Moves a set of exisiting files/folders (provided by an array &#x60;resources&#x60;) to the requested &#x60;parentResource&#x60; in your account. In the &#x60;resources&#x60; array, you may specify paths pointing files/folders throughout the account, but everything will be moved to the root of the &#x60;parentResource&#x60;.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ResourceCopyMove
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceCopyMove moveResources(String evApiKey, String evAccessToken, Body13 body) throws ApiException {
        ApiResponse<ResourceCopyMove> resp = moveResourcesWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Move resources
     * Moves a set of exisiting files/folders (provided by an array &#x60;resources&#x60;) to the requested &#x60;parentResource&#x60; in your account. In the &#x60;resources&#x60; array, you may specify paths pointing files/folders throughout the account, but everything will be moved to the root of the &#x60;parentResource&#x60;.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ResourceCopyMove&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceCopyMove> moveResourcesWithHttpInfo(String evApiKey, String evAccessToken, Body13 body) throws ApiException {
        com.squareup.okhttp.Call call = moveResourcesValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<ResourceCopyMove>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Move resources (asynchronously)
     * Moves a set of exisiting files/folders (provided by an array &#x60;resources&#x60;) to the requested &#x60;parentResource&#x60; in your account. In the &#x60;resources&#x60; array, you may specify paths pointing files/folders throughout the account, but everything will be moved to the root of the &#x60;parentResource&#x60;.  **Notes:** - Authenticated user should have modify permission. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call moveResourcesAsync(String evApiKey, String evAccessToken, Body13 body, final ApiCallback<ResourceCopyMove> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = moveResourcesValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceCopyMove>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateResourceById
     * @param evAccessToken Access token required to make the API call. (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param id ID number of the resource (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateResourceByIdCall(String evAccessToken, String evApiKey, Integer id, Body7 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/resources/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));

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
    private com.squareup.okhttp.Call updateResourceByIdValidateBeforeCall(String evAccessToken, String evApiKey, Integer id, Body7 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling updateResourceById(Async)");
        }
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling updateResourceById(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateResourceById(Async)");
        }
        
        com.squareup.okhttp.Call call = updateResourceByIdCall(evAccessToken, evApiKey, id, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Rename a resource.
     * Update the specified file or folder resource record&#x27;s \&quot;name\&quot; parameter. The resource is identified by the numeric resource ID that is passed in as the last segment of the URI. 
     * @param evAccessToken Access token required to make the API call. (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param id ID number of the resource (required)
     * @param body  (optional)
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse updateResourceById(String evAccessToken, String evApiKey, Integer id, Body7 body) throws ApiException {
        ApiResponse<ResourceResponse> resp = updateResourceByIdWithHttpInfo(evAccessToken, evApiKey, id, body);
        return resp.getData();
    }

    /**
     * Rename a resource.
     * Update the specified file or folder resource record&#x27;s \&quot;name\&quot; parameter. The resource is identified by the numeric resource ID that is passed in as the last segment of the URI. 
     * @param evAccessToken Access token required to make the API call. (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param id ID number of the resource (required)
     * @param body  (optional)
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceResponse> updateResourceByIdWithHttpInfo(String evAccessToken, String evApiKey, Integer id, Body7 body) throws ApiException {
        com.squareup.okhttp.Call call = updateResourceByIdValidateBeforeCall(evAccessToken, evApiKey, id, body, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Rename a resource. (asynchronously)
     * Update the specified file or folder resource record&#x27;s \&quot;name\&quot; parameter. The resource is identified by the numeric resource ID that is passed in as the last segment of the URI. 
     * @param evAccessToken Access token required to make the API call. (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param id ID number of the resource (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateResourceByIdAsync(String evAccessToken, String evApiKey, Integer id, Body7 body, final ApiCallback<ResourceResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateResourceByIdValidateBeforeCall(evAccessToken, evApiKey, id, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for uploadFile
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param path Destination path for the file being uploaded, including the file name. (required)
     * @param fileSize File size, in bits, of the file being uploaded. (required)
     * @param file  (optional)
     * @param offsetBytes Allows a file upload to resume at a certain number of bytes. (optional)
     * @param resume True if upload resume is supported, false if it isn&#x27;t.  (optional, default to true)
     * @param allowOverwrite True if a file with the same name is found in the designated path, should be overwritten. False if different file names should be generated.  (optional, default to false)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call uploadFileCall(String evApiKey, String evAccessToken, String path, Integer fileSize, File file, Integer offsetBytes, Boolean resume, Boolean allowOverwrite, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/resources/upload";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (path != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
        if (fileSize != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fileSize", fileSize));
        if (resume != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("resume", resume));
        if (allowOverwrite != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("allowOverwrite", allowOverwrite));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (evApiKey != null)
        localVarHeaderParams.put("ev-api-key", apiClient.parameterToString(evApiKey));
        if (evAccessToken != null)
        localVarHeaderParams.put("ev-access-token", apiClient.parameterToString(evAccessToken));
        if (offsetBytes != null)
        localVarHeaderParams.put("offsetBytes", apiClient.parameterToString(offsetBytes));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (file != null)
        localVarFormParams.put("file", file);

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "multipart/form-data"
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
    private com.squareup.okhttp.Call uploadFileValidateBeforeCall(String evApiKey, String evAccessToken, String path, Integer fileSize, File file, Integer offsetBytes, Boolean resume, Boolean allowOverwrite, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling uploadFile(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling uploadFile(Async)");
        }
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new ApiException("Missing the required parameter 'path' when calling uploadFile(Async)");
        }
        // verify the required parameter 'fileSize' is set
        if (fileSize == null) {
            throw new ApiException("Missing the required parameter 'fileSize' when calling uploadFile(Async)");
        }
        
        com.squareup.okhttp.Call call = uploadFileCall(evApiKey, evAccessToken, path, fileSize, file, offsetBytes, resume, allowOverwrite, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Upload a file
     * Uploads a file to a specified path, with optional support for resuming a partially uploaded existing file. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param path Destination path for the file being uploaded, including the file name. (required)
     * @param fileSize File size, in bits, of the file being uploaded. (required)
     * @param file  (optional)
     * @param offsetBytes Allows a file upload to resume at a certain number of bytes. (optional)
     * @param resume True if upload resume is supported, false if it isn&#x27;t.  (optional, default to true)
     * @param allowOverwrite True if a file with the same name is found in the designated path, should be overwritten. False if different file names should be generated.  (optional, default to false)
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse uploadFile(String evApiKey, String evAccessToken, String path, Integer fileSize, File file, Integer offsetBytes, Boolean resume, Boolean allowOverwrite) throws ApiException {
        ApiResponse<ResourceResponse> resp = uploadFileWithHttpInfo(evApiKey, evAccessToken, path, fileSize, file, offsetBytes, resume, allowOverwrite);
        return resp.getData();
    }

    /**
     * Upload a file
     * Uploads a file to a specified path, with optional support for resuming a partially uploaded existing file. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param path Destination path for the file being uploaded, including the file name. (required)
     * @param fileSize File size, in bits, of the file being uploaded. (required)
     * @param file  (optional)
     * @param offsetBytes Allows a file upload to resume at a certain number of bytes. (optional)
     * @param resume True if upload resume is supported, false if it isn&#x27;t.  (optional, default to true)
     * @param allowOverwrite True if a file with the same name is found in the designated path, should be overwritten. False if different file names should be generated.  (optional, default to false)
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceResponse> uploadFileWithHttpInfo(String evApiKey, String evAccessToken, String path, Integer fileSize, File file, Integer offsetBytes, Boolean resume, Boolean allowOverwrite) throws ApiException {
        com.squareup.okhttp.Call call = uploadFileValidateBeforeCall(evApiKey, evAccessToken, path, fileSize, file, offsetBytes, resume, allowOverwrite, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Upload a file (asynchronously)
     * Uploads a file to a specified path, with optional support for resuming a partially uploaded existing file. 
     * @param evApiKey API Key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param path Destination path for the file being uploaded, including the file name. (required)
     * @param fileSize File size, in bits, of the file being uploaded. (required)
     * @param file  (optional)
     * @param offsetBytes Allows a file upload to resume at a certain number of bytes. (optional)
     * @param resume True if upload resume is supported, false if it isn&#x27;t.  (optional, default to true)
     * @param allowOverwrite True if a file with the same name is found in the designated path, should be overwritten. False if different file names should be generated.  (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call uploadFileAsync(String evApiKey, String evAccessToken, String path, Integer fileSize, File file, Integer offsetBytes, Boolean resume, Boolean allowOverwrite, final ApiCallback<ResourceResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = uploadFileValidateBeforeCall(evApiKey, evAccessToken, path, fileSize, file, offsetBytes, resume, allowOverwrite, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
