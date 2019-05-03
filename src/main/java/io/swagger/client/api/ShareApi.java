/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications. Our API supports both GET and POST operations.  Capabilities of the API include:  - Uploading and downloading files. - Managing files and folders; including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and recieve folders.  - Setting up and managing notifications.  ## The API Endpoint  The ExaVault API is located at: https://api.exavault.com/v1.2/  # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Code-Libraries-and-Sample-PHP-Code/Obtain-your-API-key) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"e13395afc6278ce1555f\"></div>  ![ExaVault API Postman Colletion Usage](/images/postman.png)  If you'd prefer to skip Postman and start working with code directly, take a look at the sample code below.    # Code Libraries & Sample PHP Code  Once you're ready for full-scale development, we recommend looking at our code libraries available on [GitHub](https://github.com/ExaVault). We offer code libraries for [Python](https://github.com/ExaVault/evapi-python), [PHP](https://github.com/ExaVault/evapi-php) and [JavaScript](https://github.com/ExaVault/evapi-javascript).  While we recommend using our libraries, you're welcome to interact directly with our API via HTTP GET and POST requests -- a great option particularly if you're developing in a language for which we don't yet have sample code.     - [Download Python Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-python) - [Download PHP Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-php) - [Download JavaScript Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-javascript)  *Note: You can generate client libraries for any language using [Swagger Editor](http://editor2.swagger.io/). Just download our documentation file, past it into editor and use 'Generate Client' dropdown.*  ## Obtain Your API Key  You will need to obtain an API key for your application from the [Client Area](https://clients.exavault.com/clientarea.php?action=products) of your account.  To obtain an API key, please follow the instructions below.   + Login to the [Accounts](https://clients.exavault.com/clientarea.php?action=products) section of the Client Area.  + Use the drop down next to your desired account, and select *Manage API Keys*.  + You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.  *NOTE: As of Oct 2017, we are in the progress of migrating customers to our next generation platform. If your account is already on our new platform, you should log into your File Manager and create your API key under Account->Developer->Manage API Keys*.  # Status Codes  The ExaVault API returns only two HTTP status codes for its responses: 200 and 500.  When the request could be successfully processed by the endpoint, the response status code will be 200, regardless of whether the requested action could be taken.  For example, the response to a getUser request for a username that does not exist in your account would have the status of 200,  indicating that the response was received and processed, but the error member of the returned response object would contain object with `message` and `code` properties.  **Result Format:**  |Success   | Error     | Results   | | ---      | :---:       |  :---:      | | 0        |  `Object` |   Empty   | | 1        |   Empty       |    `Object` or `Array`        |     When a malformed request is received, a 500 HTTP status code will be returned, indicating that the request could not be processed.  ExaVault's API does not currently support traditional REST response codes such as '201 Created' or '405 Method Not Allowed', although we intend to support such codes a future version of the API.   # File Paths  Many API calls require you to provide one or more file paths. For example, the <a href=\"#operation/moveResources\">moveResources</a> call requires both an array of source paths, **filePaths**, and a destination path, **destinationPath**. Here's a few tips for working with paths:   - File paths should always be specified as a string, using the standard Unix format: e.g. `/path/to/a/file.txt`  - File paths are always absolute _from the home directory of the logged in user_. For example, if the user **bob** had a home directory restriction of `/bob_home`, then an API call made using his login would specify a file as `/myfile.txt`, whereas an API call made using the master user ( no home directory restriction ) would specify the same file as `/bob_home/myfile.txt`.  # API Rate Limits  We rate limit the number of API calls you can make to help prevent abuse and protect system stablity. Each API key will support 500 requests per rolling five minutes. If you make more than 500 requests in a five minute period, you will receive a response with an error object for fifteen minutes.  # Webhooks  A webhook is an HTTP callback: a simple event-notification via HTTP POST. If you define webhooks for Exavault, ExaVault will POST a  message to a URL when certain things happen.     Webhooks can be used to receive a JSON object to your endpoint URL. You choose what events will trigger webhook messages to your endpoint URL.     Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log.  ## Getting Started  1. Go to the Account tab inside SWFT.  2. Choose the Developer tab.  3. Configure your endpoint URL and select the events you want to trigger webhook messages.  4. Save settings.    You are all set to receive webhook callbacks on the events you selected.  ## Verification Signature  ExaVault includes a custom HTTP header, X-Exavault-Signature, with webhooks POST requests which will contain the signature for the request.  You can use the signature to verify the request for an additional level of security.  ## Generating the Signature  1. Go to Account tab inside SWFT.  2. Choose the Developer tab.  3. Obtain the verification token. This field will only be shown if you've configured your endpoint URL.  4. In your code that receives or processes the webhooks, you should concatenate the verification token with the JSON object that we sent in our      POST request and hash it with md5.     ```     md5($verificationToken.$webhooksObject);     ```  5. Compare signature that you generated to the signature provided in the X-Exavault-Signature HTTP header  ## Example JSON Response Object  ```json   {     \"accountname\": \"mycompanyname\",     \"username\": \"john\"     \"operation\": \"Upload\",     \"protocol\": \"https\",     \"path\": \"/testfolder/filename.jpg\"     \"attempt\": 1   } ```  ## Webhooks Logs  Keep track of all your webhooks requests in the Activity section of your account. You can find the following info for each request:    1. date and time - timestamp of the request.    2. endpoint url - where the webhook was sent.    3. event - what triggered the webhook.    4. status - HTTP status or curl error code.    5. attempt - how many times we tried to send this request.    6. response size - size of the response from your server.    7. details - you can check the response body if it was sent. 
 *
 * OpenAPI spec version: 1.0.1
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


import io.swagger.client.model.CreateShare;
import io.swagger.client.model.Response;
import io.swagger.client.model.ShareResponse;
import io.swagger.client.model.SharesResponse;
import io.swagger.client.model.UpdateShare;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareApi {
    private ApiClient apiClient;

    public ShareApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ShareApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createShare
     * @param apiKey API key required to make the API call. (required)
     * @param createShare  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createShareCall(String apiKey, CreateShare createShare, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = createShare;
        
        // create path and map variables
        String localVarPath = "/createShare";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createShareValidateBeforeCall(String apiKey, CreateShare createShare, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling createShare(Async)");
        }
        
        
        com.squareup.okhttp.Call call = createShareCall(apiKey, createShare, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * createShare
     * Creates a new share object for the given path in your account. We support three types of shares:   - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#39;live&#39;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A **file send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#39;point in time&#39; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **recieve folder** lets you recieve files into your account. You can either send users a link, or optionally drop an upload widget on your website.   **Notes:** - Authenticated user requires share permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param createShare  (optional)
     * @return ShareResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareResponse createShare(String apiKey, CreateShare createShare) throws ApiException {
        ApiResponse<ShareResponse> resp = createShareWithHttpInfo(apiKey, createShare);
        return resp.getData();
    }

    /**
     * createShare
     * Creates a new share object for the given path in your account. We support three types of shares:   - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#39;live&#39;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A **file send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#39;point in time&#39; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **recieve folder** lets you recieve files into your account. You can either send users a link, or optionally drop an upload widget on your website.   **Notes:** - Authenticated user requires share permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param createShare  (optional)
     * @return ApiResponse&lt;ShareResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareResponse> createShareWithHttpInfo(String apiKey, CreateShare createShare) throws ApiException {
        com.squareup.okhttp.Call call = createShareValidateBeforeCall(apiKey, createShare, null, null);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * createShare (asynchronously)
     * Creates a new share object for the given path in your account. We support three types of shares:   - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#39;live&#39;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A **file send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#39;point in time&#39; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **recieve folder** lets you recieve files into your account. You can either send users a link, or optionally drop an upload widget on your website.   **Notes:** - Authenticated user requires share permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param createShare  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createShareAsync(String apiKey, CreateShare createShare, final ApiCallback<ShareResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createShareValidateBeforeCall(apiKey, createShare, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteShare
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share to delete. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteShareCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/deleteShare";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteShareValidateBeforeCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling deleteShare(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling deleteShare(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteShare(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deleteShareCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * deleteShare
     * Delete a share. Deleting a share does not remove the underlying files for &#x60;shared_folder&#x60; and &#x60;recieve&#x60; share types; it merely removes the access URL. Delating a &#x60;send&#x60; share type does remove the associated files, as files that have been sent are _only_ associated with the share, and aren&#39;t stored anywhere else in the account. &gt; **Notes:**  - Authenticated user&#39;s role must be admin or master, or user must be the owner of the specified share.  
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share to delete. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response deleteShare(String apiKey, String accessToken, Integer id) throws ApiException {
        ApiResponse<Response> resp = deleteShareWithHttpInfo(apiKey, accessToken, id);
        return resp.getData();
    }

    /**
     * deleteShare
     * Delete a share. Deleting a share does not remove the underlying files for &#x60;shared_folder&#x60; and &#x60;recieve&#x60; share types; it merely removes the access URL. Delating a &#x60;send&#x60; share type does remove the associated files, as files that have been sent are _only_ associated with the share, and aren&#39;t stored anywhere else in the account. &gt; **Notes:**  - Authenticated user&#39;s role must be admin or master, or user must be the owner of the specified share.  
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share to delete. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> deleteShareWithHttpInfo(String apiKey, String accessToken, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = deleteShareValidateBeforeCall(apiKey, accessToken, id, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * deleteShare (asynchronously)
     * Delete a share. Deleting a share does not remove the underlying files for &#x60;shared_folder&#x60; and &#x60;recieve&#x60; share types; it merely removes the access URL. Delating a &#x60;send&#x60; share type does remove the associated files, as files that have been sent are _only_ associated with the share, and aren&#39;t stored anywhere else in the account. &gt; **Notes:**  - Authenticated user&#39;s role must be admin or master, or user must be the owner of the specified share.  
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share to delete. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteShareAsync(String apiKey, String accessToken, Integer id, final ApiCallback<Response> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteShareValidateBeforeCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getShare
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the requested share. Note this is our internal ID, not the share hash. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getShareCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/getShare";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getShareValidateBeforeCall(String apiKey, String accessToken, Integer id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getShare(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getShare(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getShare(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getShareCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * getShare
     * Returns a share object specified by a given share ID.   **Notes:** - Authenticated user should be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the requested share. Note this is our internal ID, not the share hash. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @return ShareResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareResponse getShare(String apiKey, String accessToken, Integer id) throws ApiException {
        ApiResponse<ShareResponse> resp = getShareWithHttpInfo(apiKey, accessToken, id);
        return resp.getData();
    }

    /**
     * getShare
     * Returns a share object specified by a given share ID.   **Notes:** - Authenticated user should be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the requested share. Note this is our internal ID, not the share hash. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @return ApiResponse&lt;ShareResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareResponse> getShareWithHttpInfo(String apiKey, String accessToken, Integer id) throws ApiException {
        com.squareup.okhttp.Call call = getShareValidateBeforeCall(apiKey, accessToken, id, null, null);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getShare (asynchronously)
     * Returns a share object specified by a given share ID.   **Notes:** - Authenticated user should be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the requested share. Note this is our internal ID, not the share hash. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getShareAsync(String apiKey, String accessToken, Integer id, final ApiCallback<ShareResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getShareValidateBeforeCall(apiKey, accessToken, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getShares
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param sortBy Sort method. (required)
     * @param sortOrder Sort order. (required)
     * @param type The type of share to return. If no argument specified, will return all shares of all types. (optional)
     * @param filter Filter by the provided search terms. (optional)
     * @param include Filter returned shares. You can get all shares in the account, only active ones or shares you own. (optional, default to all)
     * @param offset Start position of results to return, for pagination. Defaults to zero (0). (optional)
     * @param limit Maximum number of shares to return. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getSharesCall(String apiKey, String accessToken, String sortBy, String sortOrder, String type, String filter, String include, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/getShares";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_token", accessToken));
        if (type != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "type", type));
        if (sortBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
        if (sortOrder != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortOrder", sortOrder));
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter", filter));
        if (include != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "include", include));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSharesValidateBeforeCall(String apiKey, String accessToken, String sortBy, String sortOrder, String type, String filter, String include, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getShares(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getShares(Async)");
        }
        
        // verify the required parameter 'sortBy' is set
        if (sortBy == null) {
            throw new ApiException("Missing the required parameter 'sortBy' when calling getShares(Async)");
        }
        
        // verify the required parameter 'sortOrder' is set
        if (sortOrder == null) {
            throw new ApiException("Missing the required parameter 'sortOrder' when calling getShares(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getSharesCall(apiKey, accessToken, sortBy, sortOrder, type, filter, include, offset, limit, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * getShares
     * Returns array of all share objects that the authenticated user has access to. Sorting and filtering options allow you to limit the returned list.  **Notes:**  - Authenticated user requires share permission.  - To get share objects with type &#x60;send&#x60;, authenticated user&#39;s role must be admin or master. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param sortBy Sort method. (required)
     * @param sortOrder Sort order. (required)
     * @param type The type of share to return. If no argument specified, will return all shares of all types. (optional)
     * @param filter Filter by the provided search terms. (optional)
     * @param include Filter returned shares. You can get all shares in the account, only active ones or shares you own. (optional, default to all)
     * @param offset Start position of results to return, for pagination. Defaults to zero (0). (optional)
     * @param limit Maximum number of shares to return. (optional)
     * @return SharesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SharesResponse getShares(String apiKey, String accessToken, String sortBy, String sortOrder, String type, String filter, String include, Integer offset, Integer limit) throws ApiException {
        ApiResponse<SharesResponse> resp = getSharesWithHttpInfo(apiKey, accessToken, sortBy, sortOrder, type, filter, include, offset, limit);
        return resp.getData();
    }

    /**
     * getShares
     * Returns array of all share objects that the authenticated user has access to. Sorting and filtering options allow you to limit the returned list.  **Notes:**  - Authenticated user requires share permission.  - To get share objects with type &#x60;send&#x60;, authenticated user&#39;s role must be admin or master. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param sortBy Sort method. (required)
     * @param sortOrder Sort order. (required)
     * @param type The type of share to return. If no argument specified, will return all shares of all types. (optional)
     * @param filter Filter by the provided search terms. (optional)
     * @param include Filter returned shares. You can get all shares in the account, only active ones or shares you own. (optional, default to all)
     * @param offset Start position of results to return, for pagination. Defaults to zero (0). (optional)
     * @param limit Maximum number of shares to return. (optional)
     * @return ApiResponse&lt;SharesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SharesResponse> getSharesWithHttpInfo(String apiKey, String accessToken, String sortBy, String sortOrder, String type, String filter, String include, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = getSharesValidateBeforeCall(apiKey, accessToken, sortBy, sortOrder, type, filter, include, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<SharesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getShares (asynchronously)
     * Returns array of all share objects that the authenticated user has access to. Sorting and filtering options allow you to limit the returned list.  **Notes:**  - Authenticated user requires share permission.  - To get share objects with type &#x60;send&#x60;, authenticated user&#39;s role must be admin or master. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param sortBy Sort method. (required)
     * @param sortOrder Sort order. (required)
     * @param type The type of share to return. If no argument specified, will return all shares of all types. (optional)
     * @param filter Filter by the provided search terms. (optional)
     * @param include Filter returned shares. You can get all shares in the account, only active ones or shares you own. (optional, default to all)
     * @param offset Start position of results to return, for pagination. Defaults to zero (0). (optional)
     * @param limit Maximum number of shares to return. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSharesAsync(String apiKey, String accessToken, String sortBy, String sortOrder, String type, String filter, String include, Integer offset, Integer limit, final ApiCallback<SharesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getSharesValidateBeforeCall(apiKey, accessToken, sortBy, sortOrder, type, filter, include, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SharesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateShare
     * @param apiKey API key required to make the API call. (required)
     * @param updateShare  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateShareCall(String apiKey, UpdateShare updateShare, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = updateShare;
        
        // create path and map variables
        String localVarPath = "/updateShare";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateShareValidateBeforeCall(String apiKey, UpdateShare updateShare, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling updateShare(Async)");
        }
        
        
        com.squareup.okhttp.Call call = updateShareCall(apiKey, updateShare, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * updateShare
     * Update an existing share object by specified ID. Note that it is not possible to change the type of share once it has been created; if you need to (for example) convert a shared folder to a recieve folder, you must first delete the shared folder and then create a new recieve folder.  **Notes:** - Authenticated user&#39;s role must be admin or master, or the authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param updateShare  (optional)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response updateShare(String apiKey, UpdateShare updateShare) throws ApiException {
        ApiResponse<Response> resp = updateShareWithHttpInfo(apiKey, updateShare);
        return resp.getData();
    }

    /**
     * updateShare
     * Update an existing share object by specified ID. Note that it is not possible to change the type of share once it has been created; if you need to (for example) convert a shared folder to a recieve folder, you must first delete the shared folder and then create a new recieve folder.  **Notes:** - Authenticated user&#39;s role must be admin or master, or the authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param updateShare  (optional)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> updateShareWithHttpInfo(String apiKey, UpdateShare updateShare) throws ApiException {
        com.squareup.okhttp.Call call = updateShareValidateBeforeCall(apiKey, updateShare, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * updateShare (asynchronously)
     * Update an existing share object by specified ID. Note that it is not possible to change the type of share once it has been created; if you need to (for example) convert a shared folder to a recieve folder, you must first delete the shared folder and then create a new recieve folder.  **Notes:** - Authenticated user&#39;s role must be admin or master, or the authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param updateShare  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateShareAsync(String apiKey, UpdateShare updateShare, final ApiCallback<Response> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateShareValidateBeforeCall(apiKey, updateShare, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
