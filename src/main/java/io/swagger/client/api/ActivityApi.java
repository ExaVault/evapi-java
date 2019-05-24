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


import io.swagger.client.model.CallbackLogResponse;
import io.swagger.client.model.LogResponse;
import io.swagger.client.model.NotificationActivityResponse;
import io.swagger.client.model.ShareActivityResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityApi {
    private ApiClient apiClient;

    public ActivityApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ActivityApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getCallbackLogs
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param offset Starting record in the result set. Can be used for pagination. (optional)
     * @param sortBy Sort method. (optional, default to sort_logs_date)
     * @param sortOrder Sort order. (optional, default to desc)
     * @param itemLimit Number of logs to return. Can be used for pagination. (optional, default to 25)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCallbackLogsCall(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, Integer itemLimit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getCallbackLogs";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (sortBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sortBy", sortBy));
        if (sortOrder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sortOrder", sortOrder));
        if (itemLimit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("itemLimit", itemLimit));

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
    private com.squareup.okhttp.Call getCallbackLogsValidateBeforeCall(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, Integer itemLimit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getCallbackLogs(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getCallbackLogs(Async)");
        }
        

        com.squareup.okhttp.Call call = getCallbackLogsCall(apiKey, accessToken, offset, sortBy, sortOrder, itemLimit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getCallbackLogs
     * Get the webhooks log from your account. Webhooks logs contain information on all webhooks that have been sent by your account.  **Notes:**  - The authenticated user&#39;s role must be admin or master in order to view callback logs. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param offset Starting record in the result set. Can be used for pagination. (optional)
     * @param sortBy Sort method. (optional, default to sort_logs_date)
     * @param sortOrder Sort order. (optional, default to desc)
     * @param itemLimit Number of logs to return. Can be used for pagination. (optional, default to 25)
     * @return CallbackLogResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CallbackLogResponse getCallbackLogs(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, Integer itemLimit) throws ApiException {
        ApiResponse<CallbackLogResponse> resp = getCallbackLogsWithHttpInfo(apiKey, accessToken, offset, sortBy, sortOrder, itemLimit);
        return resp.getData();
    }

    /**
     * getCallbackLogs
     * Get the webhooks log from your account. Webhooks logs contain information on all webhooks that have been sent by your account.  **Notes:**  - The authenticated user&#39;s role must be admin or master in order to view callback logs. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param offset Starting record in the result set. Can be used for pagination. (optional)
     * @param sortBy Sort method. (optional, default to sort_logs_date)
     * @param sortOrder Sort order. (optional, default to desc)
     * @param itemLimit Number of logs to return. Can be used for pagination. (optional, default to 25)
     * @return ApiResponse&lt;CallbackLogResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CallbackLogResponse> getCallbackLogsWithHttpInfo(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, Integer itemLimit) throws ApiException {
        com.squareup.okhttp.Call call = getCallbackLogsValidateBeforeCall(apiKey, accessToken, offset, sortBy, sortOrder, itemLimit, null, null);
        Type localVarReturnType = new TypeToken<CallbackLogResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getCallbackLogs (asynchronously)
     * Get the webhooks log from your account. Webhooks logs contain information on all webhooks that have been sent by your account.  **Notes:**  - The authenticated user&#39;s role must be admin or master in order to view callback logs. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param offset Starting record in the result set. Can be used for pagination. (optional)
     * @param sortBy Sort method. (optional, default to sort_logs_date)
     * @param sortOrder Sort order. (optional, default to desc)
     * @param itemLimit Number of logs to return. Can be used for pagination. (optional, default to 25)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCallbackLogsAsync(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, Integer itemLimit, final ApiCallback<CallbackLogResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCallbackLogsValidateBeforeCall(apiKey, accessToken, offset, sortBy, sortOrder, itemLimit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CallbackLogResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFileActivityLogs
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param offset Starting record in the result set. Can be used for pagination. (optional)
     * @param sortBy Sort method. (optional, default to sort_logs_date)
     * @param sortOrder Sort order. (optional, default to desc)
     * @param filterBy Field to search on (optional)
     * @param filter Search criteria. For date ranges, use format &#39;start_date::end_date&#39;. (optional)
     * @param itemLimit Number of logs to return. Can be used for pagination. (optional, default to 25)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getFileActivityLogsCall(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, String filterBy, String filter, Integer itemLimit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getFileActivityLogs";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (sortBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sortBy", sortBy));
        if (sortOrder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sortOrder", sortOrder));
        if (filterBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filterBy", filterBy));
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filter", filter));
        if (itemLimit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("itemLimit", itemLimit));

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
    private com.squareup.okhttp.Call getFileActivityLogsValidateBeforeCall(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, String filterBy, String filter, Integer itemLimit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getFileActivityLogs(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getFileActivityLogs(Async)");
        }
        

        com.squareup.okhttp.Call call = getFileActivityLogsCall(apiKey, accessToken, offset, sortBy, sortOrder, filterBy, filter, itemLimit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getFileActivityLogs
     * Get the activity log from your account. Activity logs contain information on all operations in your account &amp;ndash; connecting, uploading and downloading files, sharing, setting up notifications, and more. You can use different filter and sorting options to get the exact data you need.  **Notes:**  - The authenticated user&#39;s role must be admin or master in order to pull activity logs. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param offset Starting record in the result set. Can be used for pagination. (optional)
     * @param sortBy Sort method. (optional, default to sort_logs_date)
     * @param sortOrder Sort order. (optional, default to desc)
     * @param filterBy Field to search on (optional)
     * @param filter Search criteria. For date ranges, use format &#39;start_date::end_date&#39;. (optional)
     * @param itemLimit Number of logs to return. Can be used for pagination. (optional, default to 25)
     * @return LogResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LogResponse getFileActivityLogs(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, String filterBy, String filter, Integer itemLimit) throws ApiException {
        ApiResponse<LogResponse> resp = getFileActivityLogsWithHttpInfo(apiKey, accessToken, offset, sortBy, sortOrder, filterBy, filter, itemLimit);
        return resp.getData();
    }

    /**
     * getFileActivityLogs
     * Get the activity log from your account. Activity logs contain information on all operations in your account &amp;ndash; connecting, uploading and downloading files, sharing, setting up notifications, and more. You can use different filter and sorting options to get the exact data you need.  **Notes:**  - The authenticated user&#39;s role must be admin or master in order to pull activity logs. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param offset Starting record in the result set. Can be used for pagination. (optional)
     * @param sortBy Sort method. (optional, default to sort_logs_date)
     * @param sortOrder Sort order. (optional, default to desc)
     * @param filterBy Field to search on (optional)
     * @param filter Search criteria. For date ranges, use format &#39;start_date::end_date&#39;. (optional)
     * @param itemLimit Number of logs to return. Can be used for pagination. (optional, default to 25)
     * @return ApiResponse&lt;LogResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<LogResponse> getFileActivityLogsWithHttpInfo(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, String filterBy, String filter, Integer itemLimit) throws ApiException {
        com.squareup.okhttp.Call call = getFileActivityLogsValidateBeforeCall(apiKey, accessToken, offset, sortBy, sortOrder, filterBy, filter, itemLimit, null, null);
        Type localVarReturnType = new TypeToken<LogResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getFileActivityLogs (asynchronously)
     * Get the activity log from your account. Activity logs contain information on all operations in your account &amp;ndash; connecting, uploading and downloading files, sharing, setting up notifications, and more. You can use different filter and sorting options to get the exact data you need.  **Notes:**  - The authenticated user&#39;s role must be admin or master in order to pull activity logs. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param offset Starting record in the result set. Can be used for pagination. (optional)
     * @param sortBy Sort method. (optional, default to sort_logs_date)
     * @param sortOrder Sort order. (optional, default to desc)
     * @param filterBy Field to search on (optional)
     * @param filter Search criteria. For date ranges, use format &#39;start_date::end_date&#39;. (optional)
     * @param itemLimit Number of logs to return. Can be used for pagination. (optional, default to 25)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFileActivityLogsAsync(String apiKey, String accessToken, Integer offset, String sortBy, String sortOrder, String filterBy, String filter, Integer itemLimit, final ApiCallback<LogResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getFileActivityLogsValidateBeforeCall(apiKey, accessToken, offset, sortBy, sortOrder, filterBy, filter, itemLimit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LogResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getNotificationActivity
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getNotificationActivityCall(String apiKey, String accessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getNotificationActivity";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));

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
    private com.squareup.okhttp.Call getNotificationActivityValidateBeforeCall(String apiKey, String accessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getNotificationActivity(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getNotificationActivity(Async)");
        }
        

        com.squareup.okhttp.Call call = getNotificationActivityCall(apiKey, accessToken, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getNotificationActivity
     * Get all notification messages for the authenticated user. Notification messages are only recorded if a notification has been setup for a folder, and an action is taken (e.g. a file upload) in the given folder.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @return NotificationActivityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationActivityResponse getNotificationActivity(String apiKey, String accessToken) throws ApiException {
        ApiResponse<NotificationActivityResponse> resp = getNotificationActivityWithHttpInfo(apiKey, accessToken);
        return resp.getData();
    }

    /**
     * getNotificationActivity
     * Get all notification messages for the authenticated user. Notification messages are only recorded if a notification has been setup for a folder, and an action is taken (e.g. a file upload) in the given folder.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @return ApiResponse&lt;NotificationActivityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationActivityResponse> getNotificationActivityWithHttpInfo(String apiKey, String accessToken) throws ApiException {
        com.squareup.okhttp.Call call = getNotificationActivityValidateBeforeCall(apiKey, accessToken, null, null);
        Type localVarReturnType = new TypeToken<NotificationActivityResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getNotificationActivity (asynchronously)
     * Get all notification messages for the authenticated user. Notification messages are only recorded if a notification has been setup for a folder, and an action is taken (e.g. a file upload) in the given folder.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getNotificationActivityAsync(String apiKey, String accessToken, final ApiCallback<NotificationActivityResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getNotificationActivityValidateBeforeCall(apiKey, accessToken, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationActivityResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getShareActivity
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getShareActivityCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getShareActivity";

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
    private com.squareup.okhttp.Call getShareActivityValidateBeforeCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getShareActivity(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getShareActivity(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getShareActivity(Async)");
        }
        

        com.squareup.okhttp.Call call = getShareActivityCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getShareActivity
     * Get all share activity for the specified share ID. Share activity includes anything which happened on the share in question &amp;ndash; for example, a user being invited or a user connecting and downloading files.  **Notes:**  - Authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @return ShareActivityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareActivityResponse getShareActivity(String apiKey, String accessToken, Integer id) throws ApiException {
        ApiResponse<ShareActivityResponse> resp = getShareActivityWithHttpInfo(apiKey, accessToken, id);
        return resp.getData();
    }

    /**
     * getShareActivity
     * Get all share activity for the specified share ID. Share activity includes anything which happened on the share in question &amp;ndash; for example, a user being invited or a user connecting and downloading files.  **Notes:**  - Authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @return ApiResponse&lt;ShareActivityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareActivityResponse> getShareActivityWithHttpInfo(String apiKey, String accessToken, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = getShareActivityValidateBeforeCall(apiKey, accessToken, id, null, null);
        Type localVarReturnType = new TypeToken<ShareActivityResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getShareActivity (asynchronously)
     * Get all share activity for the specified share ID. Share activity includes anything which happened on the share in question &amp;ndash; for example, a user being invited or a user connecting and downloading files.  **Notes:**  - Authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getShareActivityAsync(String apiKey, String accessToken, Integer id, final ApiCallback<ShareActivityResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getShareActivityValidateBeforeCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareActivityResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
