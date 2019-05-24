/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications. Our API supports both GET and POST operations.  Capabilities of the API include:  - Uploading and downloading files. - Managing files and folders; including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and receive folders.  - Setting up and managing notifications.  ## The API Endpoint  The ExaVault API is located at: https://api.exavault.com/v1.2/  ## Obtain Your API Key  You will need to obtain an API key to connect to the API. To do this, follow the instructions below.   + Log into your account through the usual way, or use https://app.exavault.com.  + Click the Gear icon to access the account settings  + Locate the Developer tab in the account settings  + Click the link for *Manage API Keys*  + You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.  *NOTE: You must have admin or master permissions to create an API key for your account. If you do not have access to developer settings for your account, contact your account administrator to create an API key for you.  # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Introduction/Obtain-Your-API-Key) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"07891ce73cc525084ceb\"></div>  ![ExaVault API Postman Colletion Usage](/images/postman.png)  If you'd prefer to skip Postman and start working with code directly, take a look at the sample code below.    # Code Libraries & Sample PHP Code  Once you're ready for full-scale development, we recommend looking at our code libraries available on [GitHub](https://github.com/ExaVault). We offer code libraries for [Python](https://github.com/ExaVault/evapi-python), [PHP](https://github.com/ExaVault/evapi-php), [JavaScript](https://github.com/ExaVault/evapi-javascript) and [Java](https://github.com/ExaVault/evapi-java).  While we recommend using our libraries, you're welcome to interact directly with our API via HTTP GET and POST requests -- a great option particularly if you're developing in a language for which we don't yet have sample code.     - [Download Python Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-python) - [Download PHP Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-php) - [Download JavaScript Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-javascript) - [Download Java Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-java)  *Note: You can generate client libraries for any language using [Swagger Editor](http://editor2.swagger.io/). Just download our documentation file, past it into editor and use 'Generate Client' dropdown.*  # Status Codes  The ExaVault API returns only two HTTP status codes for its responses: 200 and 500.  When the request could be successfully processed by the endpoint, the response status code will be 200, regardless of whether the requested action could be taken.  For example, the response to a getUser request for a username that does not exist in your account would have the status of 200,  indicating that the response was received and processed, but the error member of the returned response object would contain object with `message` and `code` properties.  **Result Format:**  |Success   | Error     | Results   | | ---      | :---:       |  :---:      | | 0        |  `Object` |   Empty   | | 1        |   Empty       |    `Object` or `Array`        |     When a malformed request is received, a 500 HTTP status code will be returned, indicating that the request could not be processed.  ExaVault's API does not currently support traditional REST response codes such as '201 Created' or '405 Method Not Allowed'.  # File Paths  Many API calls require you to provide one or more file paths. For example, the <a href=\"#operation/moveResources\">moveResources</a> call requires both an array of source paths, **filePaths**, and a destination path, **destinationPath**. Here's a few tips for working with paths:   - File paths should always be specified as a string, using the standard Unix format: e.g. `/path/to/a/file.txt`  - File paths are always absolute _from the home directory of the logged in user_. For example, if the user **bob** had a home directory restriction of `/bob_home`, then an API call made using his login would specify a file as `/myfile.txt`, whereas an API call made using the master user ( no home directory restriction ) would specify the same file as `/bob_home/myfile.txt`.  # API Rate Limits  We rate limit the number of API calls you can make to help prevent abuse and protect system stablity. Each API key will support 500 requests per rolling five minutes. If you make more than 500 requests in a five minute period, you will receive a response with an error object for fifteen minutes.  # Webhooks  A webhook is an HTTP callback: a simple event-notification via HTTP POST. If you define webhooks for Exavault, ExaVault will POST a  message to a URL when certain things happen.     Webhooks can be used to receive a JSON object to your endpoint URL. You choose what events will trigger webhook messages to your endpoint URL.     Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log.  ## Getting Started  1. Go to the Account tab inside the web application.  2. Choose the Developer tab.  3. Configure your endpoint URL and select the events you want to trigger webhook messages.  4. Save settings.    You are all set to receive webhook callbacks on the events you selected.  ## Verification Signature  ExaVault includes a custom HTTP header, X-Exavault-Signature, with webhooks POST requests which will contain the signature for the request.  You can use the signature to verify the request for an additional level of security.  ## Generating the Signature  1. Go to Account tab inside the web application.  2. Choose the Developer tab.  3. Obtain the verification token. This field will only be shown if you've configured your endpoint URL.  4. In your code that receives or processes the webhooks, you should concatenate the verification token with the response string and hash it with md5.     ```     md5($verificationToken.$responseString);     ```  5. Compare signature that you generated to the signature provided in the X-Exavault-Signature HTTP header  ## Example JSON Response Object  ```json   {     \"accountname\": \"mycompanyname\",     \"username\": \"john\"     \"operation\": \"Upload\",     \"protocol\": \"https\",     \"path\": \"/testfolder/filename.jpg\"     \"attempt\": 1   } ```  ## Webhooks Logs  Keep track of all your webhooks requests in the Activity section of your account. You can find the following info for each request:    1. date and time - timestamp of the request.    2. endpoint url - where the webhook was sent.    3. event - what triggered the webhook.    4. status - HTTP status or curl error code.    5. attempt - how many times we tried to send this request.    6. response size - size of the response from your server.    7. details - you can check the response body if it was sent. 
 *
 * OpenAPI spec version: 1.2
 * 
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


import io.swagger.client.model.NotificationResponse;
import io.swagger.client.model.NotificationsResponse;
import io.swagger.client.model.Response;
import io.swagger.client.model.UpdateNotification;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationApi {
    private ApiClient apiClient;

    public NotificationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public NotificationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createNotification
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type Type of resource you&#39;re setting the notification on. (required)
     * @param path Full path of file/folder where the notification is set. (required)
     * @param action Type of action to filter on. Notifications will only be fired for the given type of action. (required)
     * @param usernames Determines which users should trigger the notification. Either one of the values above, or an array of usernames. (required)
     * @param sendEmail Set to true if the user should be notified by email when the notification is triggered. (required)
     * @param emails Email addresses to send the notification to. If not specified, sends to the authenticated user. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createNotificationCall(String apiKey, String accessToken, String type, String path, String action, List<String> usernames, Boolean sendEmail, List<String> emails, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/createNotification";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (accessToken != null)
        localVarFormParams.put("access_token", accessToken);
        if (type != null)
        localVarFormParams.put("type", type);
        if (path != null)
        localVarFormParams.put("path", path);
        if (action != null)
        localVarFormParams.put("action", action);
        if (usernames != null)
        localVarFormParams.put("usernames", usernames);
        if (sendEmail != null)
        localVarFormParams.put("sendEmail", sendEmail);
        if (emails != null)
        localVarFormParams.put("emails", emails);

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
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
    private com.squareup.okhttp.Call createNotificationValidateBeforeCall(String apiKey, String accessToken, String type, String path, String action, List<String> usernames, Boolean sendEmail, List<String> emails, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling createNotification(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling createNotification(Async)");
        }
        
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new ApiException("Missing the required parameter 'type' when calling createNotification(Async)");
        }
        
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new ApiException("Missing the required parameter 'path' when calling createNotification(Async)");
        }
        
        // verify the required parameter 'action' is set
        if (action == null) {
            throw new ApiException("Missing the required parameter 'action' when calling createNotification(Async)");
        }
        
        // verify the required parameter 'usernames' is set
        if (usernames == null) {
            throw new ApiException("Missing the required parameter 'usernames' when calling createNotification(Async)");
        }
        
        // verify the required parameter 'sendEmail' is set
        if (sendEmail == null) {
            throw new ApiException("Missing the required parameter 'sendEmail' when calling createNotification(Async)");
        }
        

        com.squareup.okhttp.Call call = createNotificationCall(apiKey, accessToken, type, path, action, usernames, sendEmail, emails, progressListener, progressRequestListener);
        return call;

    }

    /**
     * createNotification
     * Create a new notification for the given path in the current account. Notifications can be sent via email or webhook. To enable email, pass an array of email addresses to the &#x60;emails&#x60; parameter of this call. To enable webhooks, setup the webhook callback URL in your account settings.   **Notes:** - Authenticated user requires notification permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type Type of resource you&#39;re setting the notification on. (required)
     * @param path Full path of file/folder where the notification is set. (required)
     * @param action Type of action to filter on. Notifications will only be fired for the given type of action. (required)
     * @param usernames Determines which users should trigger the notification. Either one of the values above, or an array of usernames. (required)
     * @param sendEmail Set to true if the user should be notified by email when the notification is triggered. (required)
     * @param emails Email addresses to send the notification to. If not specified, sends to the authenticated user. (optional)
     * @return NotificationResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationResponse createNotification(String apiKey, String accessToken, String type, String path, String action, List<String> usernames, Boolean sendEmail, List<String> emails) throws ApiException {
        ApiResponse<NotificationResponse> resp = createNotificationWithHttpInfo(apiKey, accessToken, type, path, action, usernames, sendEmail, emails);
        return resp.getData();
    }

    /**
     * createNotification
     * Create a new notification for the given path in the current account. Notifications can be sent via email or webhook. To enable email, pass an array of email addresses to the &#x60;emails&#x60; parameter of this call. To enable webhooks, setup the webhook callback URL in your account settings.   **Notes:** - Authenticated user requires notification permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type Type of resource you&#39;re setting the notification on. (required)
     * @param path Full path of file/folder where the notification is set. (required)
     * @param action Type of action to filter on. Notifications will only be fired for the given type of action. (required)
     * @param usernames Determines which users should trigger the notification. Either one of the values above, or an array of usernames. (required)
     * @param sendEmail Set to true if the user should be notified by email when the notification is triggered. (required)
     * @param emails Email addresses to send the notification to. If not specified, sends to the authenticated user. (optional)
     * @return ApiResponse&lt;NotificationResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationResponse> createNotificationWithHttpInfo(String apiKey, String accessToken, String type, String path, String action, List<String> usernames, Boolean sendEmail, List<String> emails) throws ApiException {
        com.squareup.okhttp.Call call = createNotificationValidateBeforeCall(apiKey, accessToken, type, path, action, usernames, sendEmail, emails, null, null);
        Type localVarReturnType = new TypeToken<NotificationResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * createNotification (asynchronously)
     * Create a new notification for the given path in the current account. Notifications can be sent via email or webhook. To enable email, pass an array of email addresses to the &#x60;emails&#x60; parameter of this call. To enable webhooks, setup the webhook callback URL in your account settings.   **Notes:** - Authenticated user requires notification permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type Type of resource you&#39;re setting the notification on. (required)
     * @param path Full path of file/folder where the notification is set. (required)
     * @param action Type of action to filter on. Notifications will only be fired for the given type of action. (required)
     * @param usernames Determines which users should trigger the notification. Either one of the values above, or an array of usernames. (required)
     * @param sendEmail Set to true if the user should be notified by email when the notification is triggered. (required)
     * @param emails Email addresses to send the notification to. If not specified, sends to the authenticated user. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createNotificationAsync(String apiKey, String accessToken, String type, String path, String action, List<String> usernames, Boolean sendEmail, List<String> emails, final ApiCallback<NotificationResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createNotificationValidateBeforeCall(apiKey, accessToken, type, path, action, usernames, sendEmail, emails, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteNotification
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the notification to delete. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteNotificationCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/deleteNotification";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("id", id));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

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
    private com.squareup.okhttp.Call deleteNotificationValidateBeforeCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling deleteNotification(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling deleteNotification(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteNotification(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteNotificationCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * deleteNotification
     * Deletes the specified notification. Note that deleting a notification _only_ deletes the notification &amp;ndash; it does not delete any underlying files or folders. &gt; **Notes:** - Authenticated usee requires notification permission.  - Authenticated user should be the owner of the specified notification. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the notification to delete. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. (required)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response deleteNotification(String apiKey, String accessToken, Integer id) throws ApiException {
        ApiResponse<Response> resp = deleteNotificationWithHttpInfo(apiKey, accessToken, id);
        return resp.getData();
    }

    /**
     * deleteNotification
     * Deletes the specified notification. Note that deleting a notification _only_ deletes the notification &amp;ndash; it does not delete any underlying files or folders. &gt; **Notes:** - Authenticated usee requires notification permission.  - Authenticated user should be the owner of the specified notification. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the notification to delete. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> deleteNotificationWithHttpInfo(String apiKey, String accessToken, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteNotificationValidateBeforeCall(apiKey, accessToken, id, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * deleteNotification (asynchronously)
     * Deletes the specified notification. Note that deleting a notification _only_ deletes the notification &amp;ndash; it does not delete any underlying files or folders. &gt; **Notes:** - Authenticated usee requires notification permission.  - Authenticated user should be the owner of the specified notification. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the notification to delete. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteNotificationAsync(String apiKey, String accessToken, Integer id, final ApiCallback<Response> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteNotificationValidateBeforeCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getNotification
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the notification. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getNotificationCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getNotification";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("id", id));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

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
    private com.squareup.okhttp.Call getNotificationValidateBeforeCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getNotification(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getNotification(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getNotification(Async)");
        }
        

        com.squareup.okhttp.Call call = getNotificationCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getNotification
     * Returns the specified notification object.  **Notes:** - Authenticated user should be the owner of the specified notification 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the notification. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. (required)
     * @return NotificationResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationResponse getNotification(String apiKey, String accessToken, Integer id) throws ApiException {
        ApiResponse<NotificationResponse> resp = getNotificationWithHttpInfo(apiKey, accessToken, id);
        return resp.getData();
    }

    /**
     * getNotification
     * Returns the specified notification object.  **Notes:** - Authenticated user should be the owner of the specified notification 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the notification. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. (required)
     * @return ApiResponse&lt;NotificationResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationResponse> getNotificationWithHttpInfo(String apiKey, String accessToken, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = getNotificationValidateBeforeCall(apiKey, accessToken, id, null, null);
        Type localVarReturnType = new TypeToken<NotificationResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getNotification (asynchronously)
     * Returns the specified notification object.  **Notes:** - Authenticated user should be the owner of the specified notification 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the notification. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getNotificationAsync(String apiKey, String accessToken, Integer id, final ApiCallback<NotificationResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getNotificationValidateBeforeCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getNotifications
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type Type of notification to filter on. (required)
     * @param sortBy Sort method. (optional, default to sort_notifications_folder_name)
     * @param sortOrder Sort order. (optional, default to asc)
     * @param filter Filter by the provided search terms. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getNotificationsCall(String apiKey, String accessToken, String type, String sortBy, String sortOrder, String filter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getNotifications";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (type != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("type", type));
        if (sortBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sortBy", sortBy));
        if (sortOrder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sortOrder", sortOrder));
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filter", filter));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

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
    private com.squareup.okhttp.Call getNotificationsValidateBeforeCall(String apiKey, String accessToken, String type, String sortBy, String sortOrder, String filter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getNotifications(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getNotifications(Async)");
        }
        
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new ApiException("Missing the required parameter 'type' when calling getNotifications(Async)");
        }
        

        com.squareup.okhttp.Call call = getNotificationsCall(apiKey, accessToken, type, sortBy, sortOrder, filter, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getNotifications
     * Returns array of all notification objects owned by the authenticated user. You can use sorting and filtering to limit the returned list.  **Notes:** - Autheticated user should have notification permission 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type Type of notification to filter on. (required)
     * @param sortBy Sort method. (optional, default to sort_notifications_folder_name)
     * @param sortOrder Sort order. (optional, default to asc)
     * @param filter Filter by the provided search terms. (optional)
     * @return NotificationsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationsResponse getNotifications(String apiKey, String accessToken, String type, String sortBy, String sortOrder, String filter) throws ApiException {
        ApiResponse<NotificationsResponse> resp = getNotificationsWithHttpInfo(apiKey, accessToken, type, sortBy, sortOrder, filter);
        return resp.getData();
    }

    /**
     * getNotifications
     * Returns array of all notification objects owned by the authenticated user. You can use sorting and filtering to limit the returned list.  **Notes:** - Autheticated user should have notification permission 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type Type of notification to filter on. (required)
     * @param sortBy Sort method. (optional, default to sort_notifications_folder_name)
     * @param sortOrder Sort order. (optional, default to asc)
     * @param filter Filter by the provided search terms. (optional)
     * @return ApiResponse&lt;NotificationsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationsResponse> getNotificationsWithHttpInfo(String apiKey, String accessToken, String type, String sortBy, String sortOrder, String filter) throws ApiException {
        com.squareup.okhttp.Call call = getNotificationsValidateBeforeCall(apiKey, accessToken, type, sortBy, sortOrder, filter, null, null);
        Type localVarReturnType = new TypeToken<NotificationsResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getNotifications (asynchronously)
     * Returns array of all notification objects owned by the authenticated user. You can use sorting and filtering to limit the returned list.  **Notes:** - Autheticated user should have notification permission 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type Type of notification to filter on. (required)
     * @param sortBy Sort method. (optional, default to sort_notifications_folder_name)
     * @param sortOrder Sort order. (optional, default to asc)
     * @param filter Filter by the provided search terms. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getNotificationsAsync(String apiKey, String accessToken, String type, String sortBy, String sortOrder, String filter, final ApiCallback<NotificationsResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getNotificationsValidateBeforeCall(apiKey, accessToken, type, sortBy, sortOrder, filter, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationsResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateNotification
     * @param apiKey API key required to make the API call. (required)
     * @param updateNotification  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateNotificationCall(String apiKey, UpdateNotification updateNotification, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = updateNotification;

        // create path and map variables
        String localVarPath = "/updateNotification";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/x-www-form-urlencoded"
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
    private com.squareup.okhttp.Call updateNotificationValidateBeforeCall(String apiKey, UpdateNotification updateNotification, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling updateNotification(Async)");
        }
        

        com.squareup.okhttp.Call call = updateNotificationCall(apiKey, updateNotification, progressListener, progressRequestListener);
        return call;

    }

    /**
     * updateNotification
     * Update an existing notification object.  **Notes:** - Authenticated user should have notification permission.  - Authenticated user should be the owner of the specified notification. 
     * @param apiKey API key required to make the API call. (required)
     * @param updateNotification  (optional)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response updateNotification(String apiKey, UpdateNotification updateNotification) throws ApiException {
        ApiResponse<Response> resp = updateNotificationWithHttpInfo(apiKey, updateNotification);
        return resp.getData();
    }

    /**
     * updateNotification
     * Update an existing notification object.  **Notes:** - Authenticated user should have notification permission.  - Authenticated user should be the owner of the specified notification. 
     * @param apiKey API key required to make the API call. (required)
     * @param updateNotification  (optional)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> updateNotificationWithHttpInfo(String apiKey, UpdateNotification updateNotification) throws ApiException {
        com.squareup.okhttp.Call call = updateNotificationValidateBeforeCall(apiKey, updateNotification, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * updateNotification (asynchronously)
     * Update an existing notification object.  **Notes:** - Authenticated user should have notification permission.  - Authenticated user should be the owner of the specified notification. 
     * @param apiKey API key required to make the API call. (required)
     * @param updateNotification  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateNotificationAsync(String apiKey, UpdateNotification updateNotification, final ApiCallback<Response> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateNotificationValidateBeforeCall(apiKey, updateNotification, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
