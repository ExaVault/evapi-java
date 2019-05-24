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


import io.swagger.client.model.FormDataResponse;
import io.swagger.client.model.FormResponse;
import io.swagger.client.model.Response;
import io.swagger.client.model.Response1;
import io.swagger.client.model.ShareResponse;
import io.swagger.client.model.SharesResponse;
import io.swagger.client.model.UpdateForm;

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
     * Build call for addFormData
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Unique identifier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (required)
     * @param data JSON object containing field names and their values. (required)
     * @param paths Total number of entries to be downloaded. Default is 50 (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addFormDataCall(String apiKey, String accessToken, Integer formId, String data, List<String> paths, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/addFormData";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (formId != null)
        localVarFormParams.put("formId", formId);
        if (data != null)
        localVarFormParams.put("data", data);
        if (paths != null)
        localVarFormParams.put("paths[]", paths);

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
    private com.squareup.okhttp.Call addFormDataValidateBeforeCall(String apiKey, String accessToken, Integer formId, String data, List<String> paths, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling addFormData(Async)");
        }

        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling addFormData(Async)");
        }

        // verify the required parameter 'formId' is set
        if (formId == null) {
            throw new ApiException("Missing the required parameter 'formId' when calling addFormData(Async)");
        }

        // verify the required parameter 'data' is set
        if (data == null) {
            throw new ApiException("Missing the required parameter 'data' when calling addFormData(Async)");
        }

        // verify the required parameter 'paths' is set
        if (paths == null) {
            throw new ApiException("Missing the required parameter 'paths' when calling addFormData(Async)");
        }


        com.squareup.okhttp.Call call = addFormDataCall(apiKey, accessToken, formId, data, paths, progressListener, progressRequestListener);
        return call;

    }

    /**
     * addFormData
     * Upload form field data and associate with files that are in the receive folder.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Unique identifier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (required)
     * @param data JSON object containing field names and their values. (required)
     * @param paths Total number of entries to be downloaded. Default is 50 (required)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response addFormData(String apiKey, String accessToken, Integer formId, String data, List<String> paths) throws ApiException {
        ApiResponse<Response> resp = addFormDataWithHttpInfo(apiKey, accessToken, formId, data, paths);
        return resp.getData();
    }

    /**
     * addFormData
     * Upload form field data and associate with files that are in the receive folder.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Unique identifier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (required)
     * @param data JSON object containing field names and their values. (required)
     * @param paths Total number of entries to be downloaded. Default is 50 (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> addFormDataWithHttpInfo(String apiKey, String accessToken, Integer formId, String data, List<String> paths) throws ApiException {
        com.squareup.okhttp.Call call = addFormDataValidateBeforeCall(apiKey, accessToken, formId, data, paths, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * addFormData (asynchronously)
     * Upload form field data and associate with files that are in the receive folder.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Unique identifier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (required)
     * @param data JSON object containing field names and their values. (required)
     * @param paths Total number of entries to be downloaded. Default is 50 (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addFormDataAsync(String apiKey, String accessToken, Integer formId, String data, List<String> paths, final ApiCallback<Response> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addFormDataValidateBeforeCall(apiKey, accessToken, formId, data, paths, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for createShare
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type The type of share to create. See above for a description of each. (required)
     * @param name Name of the share. (required)
     * @param filePaths Array of strings containing the file paths to share. (required)
     * @param accessMode Type of permissions share recipients have. (required)
     * @param subject Share message subject (for email invitations). (optional)
     * @param message Share message contents (for email invitations). (optional)
     * @param emails Array of strings for email recipients (for email invitations). (optional)
     * @param ccEmail Array of strings for CC email recipients (for email invitations). (optional)
     * @param requireEmail Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  (optional, default to false)
     * @param embed Allows user to embed a widget with the share. (optional, default to false)
     * @param isPublic True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. (optional, default to false)
     * @param password If not null, value of password is required to access this share. (optional)
     * @param expiration The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. (optional)
     * @param hasNotification True if the user should be notified about activity on this share. (optional, default to false)
     * @param notificationEmails An array of recipients who should receive notification emails. (optional)
     * @param fileDropCreateFolders If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). (optional, default to false)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createShareCall(String apiKey, String accessToken, String type, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/createShare";

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
        if (name != null)
        localVarFormParams.put("name", name);
        if (filePaths != null)
        localVarFormParams.put("filePaths", filePaths);
        if (accessMode != null)
        localVarFormParams.put("accessMode", accessMode);
        if (subject != null)
        localVarFormParams.put("subject", subject);
        if (message != null)
        localVarFormParams.put("message", message);
        if (emails != null)
        localVarFormParams.put("emails", emails);
        if (ccEmail != null)
        localVarFormParams.put("ccEmail", ccEmail);
        if (requireEmail != null)
        localVarFormParams.put("requireEmail", requireEmail);
        if (embed != null)
        localVarFormParams.put("embed", embed);
        if (isPublic != null)
        localVarFormParams.put("isPublic", isPublic);
        if (password != null)
        localVarFormParams.put("password", password);
        if (expiration != null)
        localVarFormParams.put("expiration", expiration);
        if (hasNotification != null)
        localVarFormParams.put("hasNotification", hasNotification);
        if (notificationEmails != null)
        localVarFormParams.put("notificationEmails", notificationEmails);
        if (fileDropCreateFolders != null)
        localVarFormParams.put("fileDropCreateFolders", fileDropCreateFolders);

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
    private com.squareup.okhttp.Call createShareValidateBeforeCall(String apiKey, String accessToken, String type, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling createShare(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling createShare(Async)");
        }
        
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new ApiException("Missing the required parameter 'type' when calling createShare(Async)");
        }
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new ApiException("Missing the required parameter 'name' when calling createShare(Async)");
        }
        
        // verify the required parameter 'filePaths' is set
        if (filePaths == null) {
            throw new ApiException("Missing the required parameter 'filePaths' when calling createShare(Async)");
        }
        
        // verify the required parameter 'accessMode' is set
        if (accessMode == null) {
            throw new ApiException("Missing the required parameter 'accessMode' when calling createShare(Async)");
        }
        

        com.squareup.okhttp.Call call = createShareCall(apiKey, accessToken, type, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders, progressListener, progressRequestListener);
        return call;

    }

    /**
     * createShare
     * Creates a new share object for the given path in your account. We support three types of shares:   - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#39;live&#39;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A **file send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#39;point in time&#39; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **receive folder** lets you receive files into your account. You can either send users a link, or optionally embed &lt;a href&#x3D;\&quot;/docs/account/05-file-sharing/05-upload-widget\&quot;&gt;a customized form&lt;/a&gt; on your website.  **Notes:** - Authenticated user requires share permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type The type of share to create. See above for a description of each. (required)
     * @param name Name of the share. (required)
     * @param filePaths Array of strings containing the file paths to share. (required)
     * @param accessMode Type of permissions share recipients have. (required)
     * @param subject Share message subject (for email invitations). (optional)
     * @param message Share message contents (for email invitations). (optional)
     * @param emails Array of strings for email recipients (for email invitations). (optional)
     * @param ccEmail Array of strings for CC email recipients (for email invitations). (optional)
     * @param requireEmail Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  (optional, default to false)
     * @param embed Allows user to embed a widget with the share. (optional, default to false)
     * @param isPublic True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. (optional, default to false)
     * @param password If not null, value of password is required to access this share. (optional)
     * @param expiration The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. (optional)
     * @param hasNotification True if the user should be notified about activity on this share. (optional, default to false)
     * @param notificationEmails An array of recipients who should receive notification emails. (optional)
     * @param fileDropCreateFolders If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). (optional, default to false)
     * @return ShareResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareResponse createShare(String apiKey, String accessToken, String type, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders) throws ApiException {
        ApiResponse<ShareResponse> resp = createShareWithHttpInfo(apiKey, accessToken, type, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders);
        return resp.getData();
    }

    /**
     * createShare
     * Creates a new share object for the given path in your account. We support three types of shares:   - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#39;live&#39;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A **file send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#39;point in time&#39; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **receive folder** lets you receive files into your account. You can either send users a link, or optionally embed &lt;a href&#x3D;\&quot;/docs/account/05-file-sharing/05-upload-widget\&quot;&gt;a customized form&lt;/a&gt; on your website.  **Notes:** - Authenticated user requires share permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type The type of share to create. See above for a description of each. (required)
     * @param name Name of the share. (required)
     * @param filePaths Array of strings containing the file paths to share. (required)
     * @param accessMode Type of permissions share recipients have. (required)
     * @param subject Share message subject (for email invitations). (optional)
     * @param message Share message contents (for email invitations). (optional)
     * @param emails Array of strings for email recipients (for email invitations). (optional)
     * @param ccEmail Array of strings for CC email recipients (for email invitations). (optional)
     * @param requireEmail Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  (optional, default to false)
     * @param embed Allows user to embed a widget with the share. (optional, default to false)
     * @param isPublic True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. (optional, default to false)
     * @param password If not null, value of password is required to access this share. (optional)
     * @param expiration The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. (optional)
     * @param hasNotification True if the user should be notified about activity on this share. (optional, default to false)
     * @param notificationEmails An array of recipients who should receive notification emails. (optional)
     * @param fileDropCreateFolders If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). (optional, default to false)
     * @return ApiResponse&lt;ShareResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareResponse> createShareWithHttpInfo(String apiKey, String accessToken, String type, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders) throws ApiException {
        com.squareup.okhttp.Call call = createShareValidateBeforeCall(apiKey, accessToken, type, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders, null, null);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * createShare (asynchronously)
     * Creates a new share object for the given path in your account. We support three types of shares:   - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#39;live&#39;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A **file send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#39;point in time&#39; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **receive folder** lets you receive files into your account. You can either send users a link, or optionally embed &lt;a href&#x3D;\&quot;/docs/account/05-file-sharing/05-upload-widget\&quot;&gt;a customized form&lt;/a&gt; on your website.  **Notes:** - Authenticated user requires share permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param type The type of share to create. See above for a description of each. (required)
     * @param name Name of the share. (required)
     * @param filePaths Array of strings containing the file paths to share. (required)
     * @param accessMode Type of permissions share recipients have. (required)
     * @param subject Share message subject (for email invitations). (optional)
     * @param message Share message contents (for email invitations). (optional)
     * @param emails Array of strings for email recipients (for email invitations). (optional)
     * @param ccEmail Array of strings for CC email recipients (for email invitations). (optional)
     * @param requireEmail Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  (optional, default to false)
     * @param embed Allows user to embed a widget with the share. (optional, default to false)
     * @param isPublic True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. (optional, default to false)
     * @param password If not null, value of password is required to access this share. (optional)
     * @param expiration The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. (optional)
     * @param hasNotification True if the user should be notified about activity on this share. (optional, default to false)
     * @param notificationEmails An array of recipients who should receive notification emails. (optional)
     * @param fileDropCreateFolders If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createShareAsync(String apiKey, String accessToken, String type, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders, final ApiCallback<ShareResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createShareValidateBeforeCall(apiKey, accessToken, type, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders, progressListener, progressRequestListener);
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
     * Delete a share. Deleting a share does not remove the underlying files for &#x60;shared_folder&#x60; and &#x60;receive&#x60; share types; it merely removes the access URL. Delating a &#x60;send&#x60; share type does remove the associated files, as files that have been sent are _only_ associated with the share, and aren&#39;t stored anywhere else in the account. &gt; **Notes:**  - Authenticated user&#39;s role must be admin or master, or user must be the owner of the specified share.  
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
     * Delete a share. Deleting a share does not remove the underlying files for &#x60;shared_folder&#x60; and &#x60;receive&#x60; share types; it merely removes the access URL. Delating a &#x60;send&#x60; share type does remove the associated files, as files that have been sent are _only_ associated with the share, and aren&#39;t stored anywhere else in the account. &gt; **Notes:**  - Authenticated user&#39;s role must be admin or master, or user must be the owner of the specified share.  
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
     * Delete a share. Deleting a share does not remove the underlying files for &#x60;shared_folder&#x60; and &#x60;receive&#x60; share types; it merely removes the access URL. Delating a &#x60;send&#x60; share type does remove the associated files, as files that have been sent are _only_ associated with the share, and aren&#39;t stored anywhere else in the account. &gt; **Notes:**  - Authenticated user&#39;s role must be admin or master, or user must be the owner of the specified share.  
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
     * Build call for getForm
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Form ID to retrieve the setup for. Required if &#x60;shareId&#x60; is null (optional)
     * @param shareId Share ID to retrieve the form for. Required if &#x60;formId&#x60; is null (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getFormCall(String apiKey, String accessToken, Integer formId, Integer shareId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getForm";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (formId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("formId", formId));
        if (shareId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("shareId", shareId));

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
    private com.squareup.okhttp.Call getFormValidateBeforeCall(String apiKey, String accessToken, Integer formId, Integer shareId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getForm(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getForm(Async)");
        }
        

        com.squareup.okhttp.Call call = getFormCall(apiKey, accessToken, formId, shareId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getForm
     * Get the details of the form defined for a receive folder. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Form ID to retrieve the setup for. Required if &#x60;shareId&#x60; is null (optional)
     * @param shareId Share ID to retrieve the form for. Required if &#x60;formId&#x60; is null (optional)
     * @return FormResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FormResponse getForm(String apiKey, String accessToken, Integer formId, Integer shareId) throws ApiException {
        ApiResponse<FormResponse> resp = getFormWithHttpInfo(apiKey, accessToken, formId, shareId);
        return resp.getData();
    }

    /**
     * getForm
     * Get the details of the form defined for a receive folder. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Form ID to retrieve the setup for. Required if &#x60;shareId&#x60; is null (optional)
     * @param shareId Share ID to retrieve the form for. Required if &#x60;formId&#x60; is null (optional)
     * @return ApiResponse&lt;FormResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<FormResponse> getFormWithHttpInfo(String apiKey, String accessToken, Integer formId, Integer shareId) throws ApiException {
        com.squareup.okhttp.Call call = getFormValidateBeforeCall(apiKey, accessToken, formId, shareId, null, null);
        Type localVarReturnType = new TypeToken<FormResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getForm (asynchronously)
     * Get the details of the form defined for a receive folder. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Form ID to retrieve the setup for. Required if &#x60;shareId&#x60; is null (optional)
     * @param shareId Share ID to retrieve the form for. Required if &#x60;formId&#x60; is null (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFormAsync(String apiKey, String accessToken, Integer formId, Integer shareId, final ApiCallback<FormResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getFormValidateBeforeCall(apiKey, accessToken, formId, shareId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FormResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFormData
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Unique identier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (optional)
     * @param shareId Unique share ID (not hash) of receive folder. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (optional)
     * @param offset Used for pagination. Number of entries to \&quot;skip\&quot; before downloading results. Starts at 0. (optional)
     * @param limit Total number of entries to be downloaded. Default is 50 (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getFormDataCall(String apiKey, String accessToken, Integer formId, Long shareId, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getFormData";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (formId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("formId", formId));
        if (shareId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("shareId", shareId));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call getFormDataValidateBeforeCall(String apiKey, String accessToken, Integer formId, Long shareId, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getFormData(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getFormData(Async)");
        }
        

        com.squareup.okhttp.Call call = getFormDataCall(apiKey, accessToken, formId, shareId, offset, limit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getFormData
     * Retrieve the data and file paths associated with previous form submissions.  ** Notes: ** - Authenticated user must have ViewFormData permissions 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Unique identier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (optional)
     * @param shareId Unique share ID (not hash) of receive folder. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (optional)
     * @param offset Used for pagination. Number of entries to \&quot;skip\&quot; before downloading results. Starts at 0. (optional)
     * @param limit Total number of entries to be downloaded. Default is 50 (optional)
     * @return FormDataResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FormDataResponse getFormData(String apiKey, String accessToken, Integer formId, Long shareId, Integer offset, Integer limit) throws ApiException {
        ApiResponse<FormDataResponse> resp = getFormDataWithHttpInfo(apiKey, accessToken, formId, shareId, offset, limit);
        return resp.getData();
    }

    /**
     * getFormData
     * Retrieve the data and file paths associated with previous form submissions.  ** Notes: ** - Authenticated user must have ViewFormData permissions 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Unique identier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (optional)
     * @param shareId Unique share ID (not hash) of receive folder. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (optional)
     * @param offset Used for pagination. Number of entries to \&quot;skip\&quot; before downloading results. Starts at 0. (optional)
     * @param limit Total number of entries to be downloaded. Default is 50 (optional)
     * @return ApiResponse&lt;FormDataResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<FormDataResponse> getFormDataWithHttpInfo(String apiKey, String accessToken, Integer formId, Long shareId, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = getFormDataValidateBeforeCall(apiKey, accessToken, formId, shareId, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<FormDataResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getFormData (asynchronously)
     * Retrieve the data and file paths associated with previous form submissions.  ** Notes: ** - Authenticated user must have ViewFormData permissions 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param formId Unique identier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (optional)
     * @param shareId Unique share ID (not hash) of receive folder. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. (optional)
     * @param offset Used for pagination. Number of entries to \&quot;skip\&quot; before downloading results. Starts at 0. (optional)
     * @param limit Total number of entries to be downloaded. Default is 50 (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFormDataAsync(String apiKey, String accessToken, Integer formId, Long shareId, Integer offset, Integer limit, final ApiCallback<FormDataResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getFormDataValidateBeforeCall(apiKey, accessToken, formId, shareId, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FormDataResponse>(){}.getType();
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
        if (include != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("include", include));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
     * Build call for updateForm
     * @param apiKey API key required to make the API call. (required)
     * @param updateForm  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateFormCall(String apiKey, UpdateForm updateForm, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = updateForm;

        // create path and map variables
        String localVarPath = "/updateForm";

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
    private com.squareup.okhttp.Call updateFormValidateBeforeCall(String apiKey, UpdateForm updateForm, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling updateForm(Async)");
        }
        

        com.squareup.okhttp.Call call = updateFormCall(apiKey, updateForm, progressListener, progressRequestListener);
        return call;

    }

    /**
     * updateForm
     * Update an existing form object 
     * @param apiKey API key required to make the API call. (required)
     * @param updateForm  (optional)
     * @return Response1
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response1 updateForm(String apiKey, UpdateForm updateForm) throws ApiException {
        ApiResponse<Response1> resp = updateFormWithHttpInfo(apiKey, updateForm);
        return resp.getData();
    }

    /**
     * updateForm
     * Update an existing form object 
     * @param apiKey API key required to make the API call. (required)
     * @param updateForm  (optional)
     * @return ApiResponse&lt;Response1&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response1> updateFormWithHttpInfo(String apiKey, UpdateForm updateForm) throws ApiException {
        com.squareup.okhttp.Call call = updateFormValidateBeforeCall(apiKey, updateForm, null, null);
        Type localVarReturnType = new TypeToken<Response1>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * updateForm (asynchronously)
     * Update an existing form object 
     * @param apiKey API key required to make the API call. (required)
     * @param updateForm  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateFormAsync(String apiKey, UpdateForm updateForm, final ApiCallback<Response1> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateFormValidateBeforeCall(apiKey, updateForm, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response1>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateShare
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share to update. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param name Name of the share. (optional)
     * @param filePaths Array of strings containing the file paths to share. (optional)
     * @param accessMode Type of permissions share recipients have. (optional)
     * @param subject Share message subject (for email invitations). (optional)
     * @param message Share message contents (for email invitations). (optional)
     * @param emails Array of strings for email recipients (for email invitations). (optional)
     * @param ccEmail Array of strings for CC email recipients (for email invitations). (optional)
     * @param requireEmail Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  (optional, default to false)
     * @param embed Allows user to embed a widget with the share. (optional, default to false)
     * @param isPublic True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. (optional, default to false)
     * @param password If not null, value of password is required to access this share. (optional)
     * @param expiration The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. (optional)
     * @param hasNotification True if the user should be notified about activity on this share. (optional, default to false)
     * @param notificationEmails An array of recipients who should receive notification emails. (optional)
     * @param fileDropCreateFolders If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). (optional, default to false)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateShareCall(String apiKey, String accessToken, Integer id, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/updateShare";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (accessToken != null)
        localVarFormParams.put("access_token", accessToken);
        if (id != null)
        localVarFormParams.put("id", id);
        if (name != null)
        localVarFormParams.put("name", name);
        if (filePaths != null)
        localVarFormParams.put("filePaths", filePaths);
        if (accessMode != null)
        localVarFormParams.put("accessMode", accessMode);
        if (subject != null)
        localVarFormParams.put("subject", subject);
        if (message != null)
        localVarFormParams.put("message", message);
        if (emails != null)
        localVarFormParams.put("emails", emails);
        if (ccEmail != null)
        localVarFormParams.put("ccEmail", ccEmail);
        if (requireEmail != null)
        localVarFormParams.put("requireEmail", requireEmail);
        if (embed != null)
        localVarFormParams.put("embed", embed);
        if (isPublic != null)
        localVarFormParams.put("isPublic", isPublic);
        if (password != null)
        localVarFormParams.put("password", password);
        if (expiration != null)
        localVarFormParams.put("expiration", expiration);
        if (hasNotification != null)
        localVarFormParams.put("hasNotification", hasNotification);
        if (notificationEmails != null)
        localVarFormParams.put("notificationEmails", notificationEmails);
        if (fileDropCreateFolders != null)
        localVarFormParams.put("fileDropCreateFolders", fileDropCreateFolders);

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
    private com.squareup.okhttp.Call updateShareValidateBeforeCall(String apiKey, String accessToken, Integer id, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling updateShare(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling updateShare(Async)");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateShare(Async)");
        }
        

        com.squareup.okhttp.Call call = updateShareCall(apiKey, accessToken, id, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders, progressListener, progressRequestListener);
        return call;

    }

    /**
     * updateShare
     * Update an existing share object by specified ID. Note that it is not possible to change the type of share once it has been created; if you need to (for example) convert a shared folder to a receive folder, you must first delete the shared folder and then create a new receive folder.  **Notes:** - Authenticated user&#39;s role must be admin or master, or the authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share to update. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param name Name of the share. (optional)
     * @param filePaths Array of strings containing the file paths to share. (optional)
     * @param accessMode Type of permissions share recipients have. (optional)
     * @param subject Share message subject (for email invitations). (optional)
     * @param message Share message contents (for email invitations). (optional)
     * @param emails Array of strings for email recipients (for email invitations). (optional)
     * @param ccEmail Array of strings for CC email recipients (for email invitations). (optional)
     * @param requireEmail Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  (optional, default to false)
     * @param embed Allows user to embed a widget with the share. (optional, default to false)
     * @param isPublic True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. (optional, default to false)
     * @param password If not null, value of password is required to access this share. (optional)
     * @param expiration The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. (optional)
     * @param hasNotification True if the user should be notified about activity on this share. (optional, default to false)
     * @param notificationEmails An array of recipients who should receive notification emails. (optional)
     * @param fileDropCreateFolders If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). (optional, default to false)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ShareResponse updateShare(String apiKey, String accessToken, Integer id, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders) throws ApiException {
        ApiResponse<ShareResponse> resp = updateShareWithHttpInfo(apiKey, accessToken, id, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders);
        return resp.getData();
    }

    /**
     * updateShare
     * Update an existing share object by specified ID. Note that it is not possible to change the type of share once it has been created; if you need to (for example) convert a shared folder to a receive folder, you must first delete the shared folder and then create a new receive folder.  **Notes:** - Authenticated user&#39;s role must be admin or master, or the authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share to update. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param name Name of the share. (optional)
     * @param filePaths Array of strings containing the file paths to share. (optional)
     * @param accessMode Type of permissions share recipients have. (optional)
     * @param subject Share message subject (for email invitations). (optional)
     * @param message Share message contents (for email invitations). (optional)
     * @param emails Array of strings for email recipients (for email invitations). (optional)
     * @param ccEmail Array of strings for CC email recipients (for email invitations). (optional)
     * @param requireEmail Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  (optional, default to false)
     * @param embed Allows user to embed a widget with the share. (optional, default to false)
     * @param isPublic True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. (optional, default to false)
     * @param password If not null, value of password is required to access this share. (optional)
     * @param expiration The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. (optional)
     * @param hasNotification True if the user should be notified about activity on this share. (optional, default to false)
     * @param notificationEmails An array of recipients who should receive notification emails. (optional)
     * @param fileDropCreateFolders If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). (optional, default to false)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ShareResponse> updateShareWithHttpInfo(String apiKey, String accessToken, Integer id, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders) throws ApiException {
        com.squareup.okhttp.Call call = updateShareValidateBeforeCall(apiKey, accessToken, id, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders, null, null);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * updateShare (asynchronously)
     * Update an existing share object by specified ID. Note that it is not possible to change the type of share once it has been created; if you need to (for example) convert a shared folder to a receive folder, you must first delete the shared folder and then create a new receive folder.  **Notes:** - Authenticated user&#39;s role must be admin or master, or the authenticated user must be the owner of the specified share. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param id ID of the share to update. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. (required)
     * @param name Name of the share. (optional)
     * @param filePaths Array of strings containing the file paths to share. (optional)
     * @param accessMode Type of permissions share recipients have. (optional)
     * @param subject Share message subject (for email invitations). (optional)
     * @param message Share message contents (for email invitations). (optional)
     * @param emails Array of strings for email recipients (for email invitations). (optional)
     * @param ccEmail Array of strings for CC email recipients (for email invitations). (optional)
     * @param requireEmail Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  (optional, default to false)
     * @param embed Allows user to embed a widget with the share. (optional, default to false)
     * @param isPublic True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. (optional, default to false)
     * @param password If not null, value of password is required to access this share. (optional)
     * @param expiration The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. (optional)
     * @param hasNotification True if the user should be notified about activity on this share. (optional, default to false)
     * @param notificationEmails An array of recipients who should receive notification emails. (optional)
     * @param fileDropCreateFolders If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateShareAsync(String apiKey, String accessToken, Integer id, String name, List<String> filePaths, String accessMode, String subject, String message, List<String> emails, List<String> ccEmail, Boolean requireEmail, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders, final ApiCallback<Response> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateShareValidateBeforeCall(apiKey, accessToken, id, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ShareResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
