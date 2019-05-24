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


import io.swagger.client.model.CompressFilesResponse;
import io.swagger.client.model.DeletedResourcesResponse;
import io.swagger.client.model.ExistingResourcesResponse;
import io.swagger.client.model.ExtractFilesResponse;
import io.swagger.client.model.GetPageCountResponse;
import io.swagger.client.model.ModifiedResourcesResponse;
import io.swagger.client.model.PreviewFileResponse;
import io.swagger.client.model.ResourcePropertiesResponse;
import io.swagger.client.model.ResourceResponse;
import io.swagger.client.model.Response;
import io.swagger.client.model.UrlResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesAndFoldersApi {
    private ApiClient apiClient;

    public FilesAndFoldersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FilesAndFoldersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for checkFilesExist
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to check. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call checkFilesExistCall(String apiKey, String accessToken, List<String> filePaths, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/checkFilesExist";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (filePaths != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "filePaths[]", filePaths));

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
    private com.squareup.okhttp.Call checkFilesExistValidateBeforeCall(String apiKey, String accessToken, List<String> filePaths, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling checkFilesExist(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling checkFilesExist(Async)");
        }
        
        // verify the required parameter 'filePaths' is set
        if (filePaths == null) {
            throw new ApiException("Missing the required parameter 'filePaths' when calling checkFilesExist(Async)");
        }
        

        com.squareup.okhttp.Call call = checkFilesExistCall(apiKey, accessToken, filePaths, progressListener, progressRequestListener);
        return call;

    }

    /**
     * checkFilesExist
     * Check if any of the file/folder paths in the input array exist in your account. This is particularly useful if you are uploading files and want to present the user with a dialog asking them if they want to overwrite existing files, as the &lt;a href&#x3D;\&quot;#operation/getUploadFileUrl\&quot;&gt;getUploadFileUrl&lt;/a&gt; call overwrites files by default.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to check. (required)
     * @return ExistingResourcesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExistingResourcesResponse checkFilesExist(String apiKey, String accessToken, List<String> filePaths) throws ApiException {
        ApiResponse<ExistingResourcesResponse> resp = checkFilesExistWithHttpInfo(apiKey, accessToken, filePaths);
        return resp.getData();
    }

    /**
     * checkFilesExist
     * Check if any of the file/folder paths in the input array exist in your account. This is particularly useful if you are uploading files and want to present the user with a dialog asking them if they want to overwrite existing files, as the &lt;a href&#x3D;\&quot;#operation/getUploadFileUrl\&quot;&gt;getUploadFileUrl&lt;/a&gt; call overwrites files by default.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to check. (required)
     * @return ApiResponse&lt;ExistingResourcesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ExistingResourcesResponse> checkFilesExistWithHttpInfo(String apiKey, String accessToken, List<String> filePaths) throws ApiException {
        com.squareup.okhttp.Call call = checkFilesExistValidateBeforeCall(apiKey, accessToken, filePaths, null, null);
        Type localVarReturnType = new TypeToken<ExistingResourcesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * checkFilesExist (asynchronously)
     * Check if any of the file/folder paths in the input array exist in your account. This is particularly useful if you are uploading files and want to present the user with a dialog asking them if they want to overwrite existing files, as the &lt;a href&#x3D;\&quot;#operation/getUploadFileUrl\&quot;&gt;getUploadFileUrl&lt;/a&gt; call overwrites files by default.
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to check. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call checkFilesExistAsync(String apiKey, String accessToken, List<String> filePaths, final ApiCallback<ExistingResourcesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = checkFilesExistValidateBeforeCall(apiKey, accessToken, filePaths, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ExistingResourcesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for compressFiles
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to include in the zip archive. (required)
     * @param archivePath Name of the archive to create, including the full path to the file. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call compressFilesCall(String apiKey, String accessToken, List<String> filePaths, String archivePath, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/compressFiles";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (filePaths != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "filePaths[]", filePaths));
        if (archivePath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("archivePath", archivePath));

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call compressFilesValidateBeforeCall(String apiKey, String accessToken, List<String> filePaths, String archivePath, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling compressFiles(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling compressFiles(Async)");
        }
        
        // verify the required parameter 'filePaths' is set
        if (filePaths == null) {
            throw new ApiException("Missing the required parameter 'filePaths' when calling compressFiles(Async)");
        }
        
        // verify the required parameter 'archivePath' is set
        if (archivePath == null) {
            throw new ApiException("Missing the required parameter 'archivePath' when calling compressFiles(Async)");
        }
        

        com.squareup.okhttp.Call call = compressFilesCall(apiKey, accessToken, filePaths, archivePath, progressListener, progressRequestListener);
        return call;

    }

    /**
     * compressFiles
     * Create a zip archive containing the files from given set of paths. Note that this can be a very slow operation if you have indicated many files should be included in the archive.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to include in the zip archive. (required)
     * @param archivePath Name of the archive to create, including the full path to the file. (required)
     * @return CompressFilesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CompressFilesResponse compressFiles(String apiKey, String accessToken, List<String> filePaths, String archivePath) throws ApiException {
        ApiResponse<CompressFilesResponse> resp = compressFilesWithHttpInfo(apiKey, accessToken, filePaths, archivePath);
        return resp.getData();
    }

    /**
     * compressFiles
     * Create a zip archive containing the files from given set of paths. Note that this can be a very slow operation if you have indicated many files should be included in the archive.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to include in the zip archive. (required)
     * @param archivePath Name of the archive to create, including the full path to the file. (required)
     * @return ApiResponse&lt;CompressFilesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CompressFilesResponse> compressFilesWithHttpInfo(String apiKey, String accessToken, List<String> filePaths, String archivePath) throws ApiException {
        com.squareup.okhttp.Call call = compressFilesValidateBeforeCall(apiKey, accessToken, filePaths, archivePath, null, null);
        Type localVarReturnType = new TypeToken<CompressFilesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * compressFiles (asynchronously)
     * Create a zip archive containing the files from given set of paths. Note that this can be a very slow operation if you have indicated many files should be included in the archive.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to include in the zip archive. (required)
     * @param archivePath Name of the archive to create, including the full path to the file. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call compressFilesAsync(String apiKey, String accessToken, List<String> filePaths, String archivePath, final ApiCallback<CompressFilesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = compressFilesValidateBeforeCall(apiKey, accessToken, filePaths, archivePath, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CompressFilesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for copyResources
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to copy. (required)
     * @param destinationPath Remote destination path to copy files/folders to. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call copyResourcesCall(String apiKey, String accessToken, List<String> filePaths, String destinationPath, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/copyResources";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (accessToken != null)
        localVarFormParams.put("access_token", accessToken);
        if (filePaths != null)
        localVarFormParams.put("filePaths", filePaths);
        if (destinationPath != null)
        localVarFormParams.put("destinationPath", destinationPath);

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
    private com.squareup.okhttp.Call copyResourcesValidateBeforeCall(String apiKey, String accessToken, List<String> filePaths, String destinationPath, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling copyResources(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling copyResources(Async)");
        }
        
        // verify the required parameter 'filePaths' is set
        if (filePaths == null) {
            throw new ApiException("Missing the required parameter 'filePaths' when calling copyResources(Async)");
        }
        
        // verify the required parameter 'destinationPath' is set
        if (destinationPath == null) {
            throw new ApiException("Missing the required parameter 'destinationPath' when calling copyResources(Async)");
        }
        

        com.squareup.okhttp.Call call = copyResourcesCall(apiKey, accessToken, filePaths, destinationPath, progressListener, progressRequestListener);
        return call;

    }

    /**
     * copyResources
     * Copies a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be copied to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to copy. (required)
     * @param destinationPath Remote destination path to copy files/folders to. (required)
     * @return ModifiedResourcesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ModifiedResourcesResponse copyResources(String apiKey, String accessToken, List<String> filePaths, String destinationPath) throws ApiException {
        ApiResponse<ModifiedResourcesResponse> resp = copyResourcesWithHttpInfo(apiKey, accessToken, filePaths, destinationPath);
        return resp.getData();
    }

    /**
     * copyResources
     * Copies a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be copied to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to copy. (required)
     * @param destinationPath Remote destination path to copy files/folders to. (required)
     * @return ApiResponse&lt;ModifiedResourcesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ModifiedResourcesResponse> copyResourcesWithHttpInfo(String apiKey, String accessToken, List<String> filePaths, String destinationPath) throws ApiException {
        com.squareup.okhttp.Call call = copyResourcesValidateBeforeCall(apiKey, accessToken, filePaths, destinationPath, null, null);
        Type localVarReturnType = new TypeToken<ModifiedResourcesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * copyResources (asynchronously)
     * Copies a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be copied to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to copy. (required)
     * @param destinationPath Remote destination path to copy files/folders to. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call copyResourcesAsync(String apiKey, String accessToken, List<String> filePaths, String destinationPath, final ApiCallback<ModifiedResourcesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = copyResourcesValidateBeforeCall(apiKey, accessToken, filePaths, destinationPath, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ModifiedResourcesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for createFolder
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param folderName Name of the folder to create. (required)
     * @param path Where to create the folder. Use **_/_** to create a folder in the user&#39;s home directory. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createFolderCall(String apiKey, String accessToken, String folderName, String path, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/createFolder";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (accessToken != null)
        localVarFormParams.put("access_token", accessToken);
        if (folderName != null)
        localVarFormParams.put("folderName", folderName);
        if (path != null)
        localVarFormParams.put("path", path);

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
    private com.squareup.okhttp.Call createFolderValidateBeforeCall(String apiKey, String accessToken, String folderName, String path, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling createFolder(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling createFolder(Async)");
        }
        
        // verify the required parameter 'folderName' is set
        if (folderName == null) {
            throw new ApiException("Missing the required parameter 'folderName' when calling createFolder(Async)");
        }
        
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new ApiException("Missing the required parameter 'path' when calling createFolder(Async)");
        }
        

        com.squareup.okhttp.Call call = createFolderCall(apiKey, accessToken, folderName, path, progressListener, progressRequestListener);
        return call;

    }

    /**
     * createFolder
     * Create a new folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param folderName Name of the folder to create. (required)
     * @param path Where to create the folder. Use **_/_** to create a folder in the user&#39;s home directory. (required)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response createFolder(String apiKey, String accessToken, String folderName, String path) throws ApiException {
        ApiResponse<Response> resp = createFolderWithHttpInfo(apiKey, accessToken, folderName, path);
        return resp.getData();
    }

    /**
     * createFolder
     * Create a new folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param folderName Name of the folder to create. (required)
     * @param path Where to create the folder. Use **_/_** to create a folder in the user&#39;s home directory. (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> createFolderWithHttpInfo(String apiKey, String accessToken, String folderName, String path) throws ApiException {
        com.squareup.okhttp.Call call = createFolderValidateBeforeCall(apiKey, accessToken, folderName, path, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * createFolder (asynchronously)
     * Create a new folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param folderName Name of the folder to create. (required)
     * @param path Where to create the folder. Use **_/_** to create a folder in the user&#39;s home directory. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createFolderAsync(String apiKey, String accessToken, String folderName, String path, final ApiCallback<Response> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createFolderValidateBeforeCall(apiKey, accessToken, folderName, path, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteResources
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to delete. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteResourcesCall(String apiKey, String accessToken, List<String> filePaths, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/deleteResources";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (filePaths != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "filePaths[]", filePaths));

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
    private com.squareup.okhttp.Call deleteResourcesValidateBeforeCall(String apiKey, String accessToken, List<String> filePaths, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling deleteResources(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling deleteResources(Async)");
        }
        
        // verify the required parameter 'filePaths' is set
        if (filePaths == null) {
            throw new ApiException("Missing the required parameter 'filePaths' when calling deleteResources(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteResourcesCall(apiKey, accessToken, filePaths, progressListener, progressRequestListener);
        return call;

    }

    /**
     * deleteResources
     * Delete the files/folders located at a given set of paths. Note that this call performs the delete **immediately**, and it is irreversible. We strongly recommend that you confirm your user&#39;s intention to delete file(s) before issuing this API call.  **Notes:** - Authenticated user should have delete permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to delete. (required)
     * @return DeletedResourcesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeletedResourcesResponse deleteResources(String apiKey, String accessToken, List<String> filePaths) throws ApiException {
        ApiResponse<DeletedResourcesResponse> resp = deleteResourcesWithHttpInfo(apiKey, accessToken, filePaths);
        return resp.getData();
    }

    /**
     * deleteResources
     * Delete the files/folders located at a given set of paths. Note that this call performs the delete **immediately**, and it is irreversible. We strongly recommend that you confirm your user&#39;s intention to delete file(s) before issuing this API call.  **Notes:** - Authenticated user should have delete permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to delete. (required)
     * @return ApiResponse&lt;DeletedResourcesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DeletedResourcesResponse> deleteResourcesWithHttpInfo(String apiKey, String accessToken, List<String> filePaths) throws ApiException {
        com.squareup.okhttp.Call call = deleteResourcesValidateBeforeCall(apiKey, accessToken, filePaths, null, null);
        Type localVarReturnType = new TypeToken<DeletedResourcesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * deleteResources (asynchronously)
     * Delete the files/folders located at a given set of paths. Note that this call performs the delete **immediately**, and it is irreversible. We strongly recommend that you confirm your user&#39;s intention to delete file(s) before issuing this API call.  **Notes:** - Authenticated user should have delete permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to delete. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteResourcesAsync(String apiKey, String accessToken, List<String> filePaths, final ApiCallback<DeletedResourcesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteResourcesValidateBeforeCall(apiKey, accessToken, filePaths, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DeletedResourcesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for extractFiles
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param archivePath Name of the archive to create, including the full path to the file. (required)
     * @param extractPath Path to the folder where the extracted files should be placed. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call extractFilesCall(String apiKey, String accessToken, String archivePath, String extractPath, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/extractFiles";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (archivePath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("archivePath", archivePath));
        if (extractPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("extractPath", extractPath));

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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call extractFilesValidateBeforeCall(String apiKey, String accessToken, String archivePath, String extractPath, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling extractFiles(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling extractFiles(Async)");
        }
        
        // verify the required parameter 'archivePath' is set
        if (archivePath == null) {
            throw new ApiException("Missing the required parameter 'archivePath' when calling extractFiles(Async)");
        }
        
        // verify the required parameter 'extractPath' is set
        if (extractPath == null) {
            throw new ApiException("Missing the required parameter 'extractPath' when calling extractFiles(Async)");
        }
        

        com.squareup.okhttp.Call call = extractFilesCall(apiKey, accessToken, archivePath, extractPath, progressListener, progressRequestListener);
        return call;

    }

    /**
     * extractFiles
     * Extract the contents of a zip archive to a specified directory. Note that this can be a very slow operation.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param archivePath Name of the archive to create, including the full path to the file. (required)
     * @param extractPath Path to the folder where the extracted files should be placed. (required)
     * @return ExtractFilesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ExtractFilesResponse extractFiles(String apiKey, String accessToken, String archivePath, String extractPath) throws ApiException {
        ApiResponse<ExtractFilesResponse> resp = extractFilesWithHttpInfo(apiKey, accessToken, archivePath, extractPath);
        return resp.getData();
    }

    /**
     * extractFiles
     * Extract the contents of a zip archive to a specified directory. Note that this can be a very slow operation.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param archivePath Name of the archive to create, including the full path to the file. (required)
     * @param extractPath Path to the folder where the extracted files should be placed. (required)
     * @return ApiResponse&lt;ExtractFilesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ExtractFilesResponse> extractFilesWithHttpInfo(String apiKey, String accessToken, String archivePath, String extractPath) throws ApiException {
        com.squareup.okhttp.Call call = extractFilesValidateBeforeCall(apiKey, accessToken, archivePath, extractPath, null, null);
        Type localVarReturnType = new TypeToken<ExtractFilesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * extractFiles (asynchronously)
     * Extract the contents of a zip archive to a specified directory. Note that this can be a very slow operation.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param archivePath Name of the archive to create, including the full path to the file. (required)
     * @param extractPath Path to the folder where the extracted files should be placed. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call extractFilesAsync(String apiKey, String accessToken, String archivePath, String extractPath, final ApiCallback<ExtractFilesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = extractFilesValidateBeforeCall(apiKey, accessToken, archivePath, extractPath, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ExtractFilesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDownloadFileUrl
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. (required)
     * @param downloadName The name of the file to be downloaded. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDownloadFileUrlCall(String apiKey, String accessToken, List<String> filePaths, String downloadName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getDownloadFileUrl";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (filePaths != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("filePaths", filePaths));
        if (downloadName != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("downloadName", downloadName));

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
    private com.squareup.okhttp.Call getDownloadFileUrlValidateBeforeCall(String apiKey, String accessToken, List<String> filePaths, String downloadName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getDownloadFileUrl(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getDownloadFileUrl(Async)");
        }
        
        // verify the required parameter 'filePaths' is set
        if (filePaths == null) {
            throw new ApiException("Missing the required parameter 'filePaths' when calling getDownloadFileUrl(Async)");
        }
        

        com.squareup.okhttp.Call call = getDownloadFileUrlCall(apiKey, accessToken, filePaths, downloadName, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getDownloadFileUrl
     * Returns an unique URL for a file download.  To download a file from ExaVault, you first request a download URL from our API using this API call. You then make an HTTP GET request to get the actual file contents using the download URL. The download URL will contain a link to an ExaVault storage server where the file is located, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to download the file.  It is possible to download a zip archive of several files at once. To do this, pass an array of several file paths using the filePaths parameter. You can also specify the full path to a folder as the filePaths parameter, and the entire contents of the folder will be recursively added to a zip file. The zip file will be named what you&#39;ve passed as the downloadName parameter.  **Notes:** - Authenticated user should have download permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. (required)
     * @param downloadName The name of the file to be downloaded. (optional)
     * @return UrlResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UrlResponse getDownloadFileUrl(String apiKey, String accessToken, List<String> filePaths, String downloadName) throws ApiException {
        ApiResponse<UrlResponse> resp = getDownloadFileUrlWithHttpInfo(apiKey, accessToken, filePaths, downloadName);
        return resp.getData();
    }

    /**
     * getDownloadFileUrl
     * Returns an unique URL for a file download.  To download a file from ExaVault, you first request a download URL from our API using this API call. You then make an HTTP GET request to get the actual file contents using the download URL. The download URL will contain a link to an ExaVault storage server where the file is located, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to download the file.  It is possible to download a zip archive of several files at once. To do this, pass an array of several file paths using the filePaths parameter. You can also specify the full path to a folder as the filePaths parameter, and the entire contents of the folder will be recursively added to a zip file. The zip file will be named what you&#39;ve passed as the downloadName parameter.  **Notes:** - Authenticated user should have download permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. (required)
     * @param downloadName The name of the file to be downloaded. (optional)
     * @return ApiResponse&lt;UrlResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UrlResponse> getDownloadFileUrlWithHttpInfo(String apiKey, String accessToken, List<String> filePaths, String downloadName) throws ApiException {
        com.squareup.okhttp.Call call = getDownloadFileUrlValidateBeforeCall(apiKey, accessToken, filePaths, downloadName, null, null);
        Type localVarReturnType = new TypeToken<UrlResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getDownloadFileUrl (asynchronously)
     * Returns an unique URL for a file download.  To download a file from ExaVault, you first request a download URL from our API using this API call. You then make an HTTP GET request to get the actual file contents using the download URL. The download URL will contain a link to an ExaVault storage server where the file is located, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to download the file.  It is possible to download a zip archive of several files at once. To do this, pass an array of several file paths using the filePaths parameter. You can also specify the full path to a folder as the filePaths parameter, and the entire contents of the folder will be recursively added to a zip file. The zip file will be named what you&#39;ve passed as the downloadName parameter.  **Notes:** - Authenticated user should have download permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. (required)
     * @param downloadName The name of the file to be downloaded. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDownloadFileUrlAsync(String apiKey, String accessToken, List<String> filePaths, String downloadName, final ApiCallback<UrlResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getDownloadFileUrlValidateBeforeCall(apiKey, accessToken, filePaths, downloadName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UrlResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getFolders
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path to get folders for. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getFoldersCall(String apiKey, String accessToken, String path, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getFolders";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (path != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("path", path));

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
    private com.squareup.okhttp.Call getFoldersValidateBeforeCall(String apiKey, String accessToken, String path, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getFolders(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getFolders(Async)");
        }
        
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new ApiException("Missing the required parameter 'path' when calling getFolders(Async)");
        }
        

        com.squareup.okhttp.Call call = getFoldersCall(apiKey, accessToken, path, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getFolders
     * Gets the list of folder objects for a specified path. This is similar to &lt;a href&#x3D;\&quot;#operation/getResourceList\&quot;&gt;getResourceList&lt;/a&gt;, but returns only folders and is simpler and more perfomrant if you only need to get a list of folders at a given path. &gt; **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path to get folders for. (required)
     * @return ResourcePropertiesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourcePropertiesResponse getFolders(String apiKey, String accessToken, String path) throws ApiException {
        ApiResponse<ResourcePropertiesResponse> resp = getFoldersWithHttpInfo(apiKey, accessToken, path);
        return resp.getData();
    }

    /**
     * getFolders
     * Gets the list of folder objects for a specified path. This is similar to &lt;a href&#x3D;\&quot;#operation/getResourceList\&quot;&gt;getResourceList&lt;/a&gt;, but returns only folders and is simpler and more perfomrant if you only need to get a list of folders at a given path. &gt; **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path to get folders for. (required)
     * @return ApiResponse&lt;ResourcePropertiesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourcePropertiesResponse> getFoldersWithHttpInfo(String apiKey, String accessToken, String path) throws ApiException {
        com.squareup.okhttp.Call call = getFoldersValidateBeforeCall(apiKey, accessToken, path, null, null);
        Type localVarReturnType = new TypeToken<ResourcePropertiesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getFolders (asynchronously)
     * Gets the list of folder objects for a specified path. This is similar to &lt;a href&#x3D;\&quot;#operation/getResourceList\&quot;&gt;getResourceList&lt;/a&gt;, but returns only folders and is simpler and more perfomrant if you only need to get a list of folders at a given path. &gt; **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path to get folders for. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFoldersAsync(String apiKey, String accessToken, String path, final ApiCallback<ResourcePropertiesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getFoldersValidateBeforeCall(apiKey, accessToken, path, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourcePropertiesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getPageCount
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path including filename of the document relative to the user&#39;s home directory. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getPageCountCall(String apiKey, String accessToken, String path, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getPageCount";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (path != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("path", path));

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
    private com.squareup.okhttp.Call getPageCountValidateBeforeCall(String apiKey, String accessToken, String path, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getPageCount(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getPageCount(Async)");
        }
        
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new ApiException("Missing the required parameter 'path' when calling getPageCount(Async)");
        }
        

        com.squareup.okhttp.Call call = getPageCountCall(apiKey, accessToken, path, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getPageCount
     * For use with pdfs and doc files. Indicates the number of pages in the document. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path including filename of the document relative to the user&#39;s home directory. (required)
     * @return GetPageCountResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetPageCountResponse getPageCount(String apiKey, String accessToken, String path) throws ApiException {
        ApiResponse<GetPageCountResponse> resp = getPageCountWithHttpInfo(apiKey, accessToken, path);
        return resp.getData();
    }

    /**
     * getPageCount
     * For use with pdfs and doc files. Indicates the number of pages in the document. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path including filename of the document relative to the user&#39;s home directory. (required)
     * @return ApiResponse&lt;GetPageCountResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetPageCountResponse> getPageCountWithHttpInfo(String apiKey, String accessToken, String path) throws ApiException {
        com.squareup.okhttp.Call call = getPageCountValidateBeforeCall(apiKey, accessToken, path, null, null);
        Type localVarReturnType = new TypeToken<GetPageCountResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getPageCount (asynchronously)
     * For use with pdfs and doc files. Indicates the number of pages in the document. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path including filename of the document relative to the user&#39;s home directory. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getPageCountAsync(String apiKey, String accessToken, String path, final ApiCallback<GetPageCountResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getPageCountValidateBeforeCall(apiKey, accessToken, path, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GetPageCountResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getResourceList
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path to get listing of resources for. (required)
     * @param sortBy Sort method. Use in conjunction with **sort_order**, below. (optional, default to sort_files_name)
     * @param sortOrder Sort order. (optional, default to asc)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls to **getResourceList**, incrementing the **offset** parameter, above. (optional, default to 50)
     * @param detailed If true, returns sharedFolder, notifications or other objects associated with specified path. You should only set this paramter to true if you need the additional details, as the API call is less perfomant when it is enabled. (optional, default to false)
     * @param pattern Regex string. If not null, perform a search with specified pattern. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getResourceListCall(String apiKey, String accessToken, String path, String sortBy, String sortOrder, Integer offset, Integer limit, Boolean detailed, String pattern, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getResourceList";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (path != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
        if (sortBy != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sortBy", sortBy));
        if (sortOrder != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("sortOrder", sortOrder));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (detailed != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("detailed", detailed));
        if (pattern != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("pattern", pattern));

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
    private com.squareup.okhttp.Call getResourceListValidateBeforeCall(String apiKey, String accessToken, String path, String sortBy, String sortOrder, Integer offset, Integer limit, Boolean detailed, String pattern, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getResourceList(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getResourceList(Async)");
        }
        
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new ApiException("Missing the required parameter 'path' when calling getResourceList(Async)");
        }
        

        com.squareup.okhttp.Call call = getResourceListCall(apiKey, accessToken, path, sortBy, sortOrder, offset, limit, detailed, pattern, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getResourceList
     * Get a listing of files/folders for the specified path.   You can use this API call to get information about all files and folders at a specified path. By default, the API returns basic metadata on each file/folder. An optional &#39;detailed&#39; parameter forces the return of additional metadata. As with all API calls, the path should be the full path relative to the user&#39;s home directory (e.g. &#x60;/myfiles/some_folder&#x60;).  **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path to get listing of resources for. (required)
     * @param sortBy Sort method. Use in conjunction with **sort_order**, below. (optional, default to sort_files_name)
     * @param sortOrder Sort order. (optional, default to asc)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls to **getResourceList**, incrementing the **offset** parameter, above. (optional, default to 50)
     * @param detailed If true, returns sharedFolder, notifications or other objects associated with specified path. You should only set this paramter to true if you need the additional details, as the API call is less perfomant when it is enabled. (optional, default to false)
     * @param pattern Regex string. If not null, perform a search with specified pattern. (optional)
     * @return ResourceResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourceResponse getResourceList(String apiKey, String accessToken, String path, String sortBy, String sortOrder, Integer offset, Integer limit, Boolean detailed, String pattern) throws ApiException {
        ApiResponse<ResourceResponse> resp = getResourceListWithHttpInfo(apiKey, accessToken, path, sortBy, sortOrder, offset, limit, detailed, pattern);
        return resp.getData();
    }

    /**
     * getResourceList
     * Get a listing of files/folders for the specified path.   You can use this API call to get information about all files and folders at a specified path. By default, the API returns basic metadata on each file/folder. An optional &#39;detailed&#39; parameter forces the return of additional metadata. As with all API calls, the path should be the full path relative to the user&#39;s home directory (e.g. &#x60;/myfiles/some_folder&#x60;).  **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path to get listing of resources for. (required)
     * @param sortBy Sort method. Use in conjunction with **sort_order**, below. (optional, default to sort_files_name)
     * @param sortOrder Sort order. (optional, default to asc)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls to **getResourceList**, incrementing the **offset** parameter, above. (optional, default to 50)
     * @param detailed If true, returns sharedFolder, notifications or other objects associated with specified path. You should only set this paramter to true if you need the additional details, as the API call is less perfomant when it is enabled. (optional, default to false)
     * @param pattern Regex string. If not null, perform a search with specified pattern. (optional)
     * @return ApiResponse&lt;ResourceResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourceResponse> getResourceListWithHttpInfo(String apiKey, String accessToken, String path, String sortBy, String sortOrder, Integer offset, Integer limit, Boolean detailed, String pattern) throws ApiException {
        com.squareup.okhttp.Call call = getResourceListValidateBeforeCall(apiKey, accessToken, path, sortBy, sortOrder, offset, limit, detailed, pattern, null, null);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getResourceList (asynchronously)
     * Get a listing of files/folders for the specified path.   You can use this API call to get information about all files and folders at a specified path. By default, the API returns basic metadata on each file/folder. An optional &#39;detailed&#39; parameter forces the return of additional metadata. As with all API calls, the path should be the full path relative to the user&#39;s home directory (e.g. &#x60;/myfiles/some_folder&#x60;).  **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path to get listing of resources for. (required)
     * @param sortBy Sort method. Use in conjunction with **sort_order**, below. (optional, default to sort_files_name)
     * @param sortOrder Sort order. (optional, default to asc)
     * @param offset Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional, default to 0)
     * @param limit The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls to **getResourceList**, incrementing the **offset** parameter, above. (optional, default to 50)
     * @param detailed If true, returns sharedFolder, notifications or other objects associated with specified path. You should only set this paramter to true if you need the additional details, as the API call is less perfomant when it is enabled. (optional, default to false)
     * @param pattern Regex string. If not null, perform a search with specified pattern. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResourceListAsync(String apiKey, String accessToken, String path, String sortBy, String sortOrder, Integer offset, Integer limit, Boolean detailed, String pattern, final ApiCallback<ResourceResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getResourceListValidateBeforeCall(apiKey, accessToken, path, sortBy, sortOrder, offset, limit, detailed, pattern, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourceResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getResourceProperties
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to get metadata for. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getResourcePropertiesCall(String apiKey, String accessToken, List<String> filePaths, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getResourceProperties";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (filePaths != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "filePaths[]", filePaths));

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
    private com.squareup.okhttp.Call getResourcePropertiesValidateBeforeCall(String apiKey, String accessToken, List<String> filePaths, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getResourceProperties(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getResourceProperties(Async)");
        }
        
        // verify the required parameter 'filePaths' is set
        if (filePaths == null) {
            throw new ApiException("Missing the required parameter 'filePaths' when calling getResourceProperties(Async)");
        }
        

        com.squareup.okhttp.Call call = getResourcePropertiesCall(apiKey, accessToken, filePaths, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getResourceProperties
     * Gets metadata for each of the specified file/folder paths, including things like upload date, size and type. For the full list of returned properties, see the response syntax, below. &gt; **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to get metadata for. (required)
     * @return ResourcePropertiesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResourcePropertiesResponse getResourceProperties(String apiKey, String accessToken, List<String> filePaths) throws ApiException {
        ApiResponse<ResourcePropertiesResponse> resp = getResourcePropertiesWithHttpInfo(apiKey, accessToken, filePaths);
        return resp.getData();
    }

    /**
     * getResourceProperties
     * Gets metadata for each of the specified file/folder paths, including things like upload date, size and type. For the full list of returned properties, see the response syntax, below. &gt; **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to get metadata for. (required)
     * @return ApiResponse&lt;ResourcePropertiesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResourcePropertiesResponse> getResourcePropertiesWithHttpInfo(String apiKey, String accessToken, List<String> filePaths) throws ApiException {
        com.squareup.okhttp.Call call = getResourcePropertiesValidateBeforeCall(apiKey, accessToken, filePaths, null, null);
        Type localVarReturnType = new TypeToken<ResourcePropertiesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getResourceProperties (asynchronously)
     * Gets metadata for each of the specified file/folder paths, including things like upload date, size and type. For the full list of returned properties, see the response syntax, below. &gt; **Notes:** - Authenticated user should have list permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing paths of the files or folder to get metadata for. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getResourcePropertiesAsync(String apiKey, String accessToken, List<String> filePaths, final ApiCallback<ResourcePropertiesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getResourcePropertiesValidateBeforeCall(apiKey, accessToken, filePaths, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResourcePropertiesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getUploadFileUrl
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param fileSize Size of the file to upload, in bytes. (required)
     * @param destinationPath Path relative to account&#39;s home directory, including file name. (required)
     * @param allowOverwrite True if the file should be overwritten, false if different file names should be generated. Call &lt;a href&#x3D;\&quot;#operation/checkFilesExist\&quot;&gt;checkFilesExist&lt;/a&gt; first if you need to determine whether or not a file with the same name already exists.  (optional, default to true)
     * @param resume True if upload resume is supported, false if it isn&#39;t. (optional, default to false)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getUploadFileUrlCall(String apiKey, String accessToken, Long fileSize, String destinationPath, Boolean allowOverwrite, Boolean resume, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/getUploadFileUrl";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (fileSize != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fileSize", fileSize));
        if (destinationPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("destinationPath", destinationPath));
        if (allowOverwrite != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("allowOverwrite", allowOverwrite));
        if (resume != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("resume", resume));

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
    private com.squareup.okhttp.Call getUploadFileUrlValidateBeforeCall(String apiKey, String accessToken, Long fileSize, String destinationPath, Boolean allowOverwrite, Boolean resume, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling getUploadFileUrl(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling getUploadFileUrl(Async)");
        }
        
        // verify the required parameter 'fileSize' is set
        if (fileSize == null) {
            throw new ApiException("Missing the required parameter 'fileSize' when calling getUploadFileUrl(Async)");
        }
        
        // verify the required parameter 'destinationPath' is set
        if (destinationPath == null) {
            throw new ApiException("Missing the required parameter 'destinationPath' when calling getUploadFileUrl(Async)");
        }
        

        com.squareup.okhttp.Call call = getUploadFileUrlCall(apiKey, accessToken, fileSize, destinationPath, allowOverwrite, resume, progressListener, progressRequestListener);
        return call;

    }

    /**
     * getUploadFileUrl
     * Returns an unique URL for handling file uploads.  To upload a file to ExaVault, you first request an upload URL from our API using this API call. You then make an HTTP POST request to that url to put the file on the server. The upload URL will contain a link to an ExaVault storage server where the file can be stored, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to upload the file.  **Notes:** - Authenticated user should have upload premission. - Make sure that the fileSize (in bytes) parameter set on getUploadFileUrl matches the number of bytes transferred in the POST body of the URL. If these do not match, the API will detect a cancelled upload and return an error. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param fileSize Size of the file to upload, in bytes. (required)
     * @param destinationPath Path relative to account&#39;s home directory, including file name. (required)
     * @param allowOverwrite True if the file should be overwritten, false if different file names should be generated. Call &lt;a href&#x3D;\&quot;#operation/checkFilesExist\&quot;&gt;checkFilesExist&lt;/a&gt; first if you need to determine whether or not a file with the same name already exists.  (optional, default to true)
     * @param resume True if upload resume is supported, false if it isn&#39;t. (optional, default to false)
     * @return UrlResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UrlResponse getUploadFileUrl(String apiKey, String accessToken, Long fileSize, String destinationPath, Boolean allowOverwrite, Boolean resume) throws ApiException {
        ApiResponse<UrlResponse> resp = getUploadFileUrlWithHttpInfo(apiKey, accessToken, fileSize, destinationPath, allowOverwrite, resume);
        return resp.getData();
    }

    /**
     * getUploadFileUrl
     * Returns an unique URL for handling file uploads.  To upload a file to ExaVault, you first request an upload URL from our API using this API call. You then make an HTTP POST request to that url to put the file on the server. The upload URL will contain a link to an ExaVault storage server where the file can be stored, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to upload the file.  **Notes:** - Authenticated user should have upload premission. - Make sure that the fileSize (in bytes) parameter set on getUploadFileUrl matches the number of bytes transferred in the POST body of the URL. If these do not match, the API will detect a cancelled upload and return an error. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param fileSize Size of the file to upload, in bytes. (required)
     * @param destinationPath Path relative to account&#39;s home directory, including file name. (required)
     * @param allowOverwrite True if the file should be overwritten, false if different file names should be generated. Call &lt;a href&#x3D;\&quot;#operation/checkFilesExist\&quot;&gt;checkFilesExist&lt;/a&gt; first if you need to determine whether or not a file with the same name already exists.  (optional, default to true)
     * @param resume True if upload resume is supported, false if it isn&#39;t. (optional, default to false)
     * @return ApiResponse&lt;UrlResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UrlResponse> getUploadFileUrlWithHttpInfo(String apiKey, String accessToken, Long fileSize, String destinationPath, Boolean allowOverwrite, Boolean resume) throws ApiException {
        com.squareup.okhttp.Call call = getUploadFileUrlValidateBeforeCall(apiKey, accessToken, fileSize, destinationPath, allowOverwrite, resume, null, null);
        Type localVarReturnType = new TypeToken<UrlResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * getUploadFileUrl (asynchronously)
     * Returns an unique URL for handling file uploads.  To upload a file to ExaVault, you first request an upload URL from our API using this API call. You then make an HTTP POST request to that url to put the file on the server. The upload URL will contain a link to an ExaVault storage server where the file can be stored, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to upload the file.  **Notes:** - Authenticated user should have upload premission. - Make sure that the fileSize (in bytes) parameter set on getUploadFileUrl matches the number of bytes transferred in the POST body of the URL. If these do not match, the API will detect a cancelled upload and return an error. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param fileSize Size of the file to upload, in bytes. (required)
     * @param destinationPath Path relative to account&#39;s home directory, including file name. (required)
     * @param allowOverwrite True if the file should be overwritten, false if different file names should be generated. Call &lt;a href&#x3D;\&quot;#operation/checkFilesExist\&quot;&gt;checkFilesExist&lt;/a&gt; first if you need to determine whether or not a file with the same name already exists.  (optional, default to true)
     * @param resume True if upload resume is supported, false if it isn&#39;t. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUploadFileUrlAsync(String apiKey, String accessToken, Long fileSize, String destinationPath, Boolean allowOverwrite, Boolean resume, final ApiCallback<UrlResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getUploadFileUrlValidateBeforeCall(apiKey, accessToken, fileSize, destinationPath, allowOverwrite, resume, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UrlResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for moveResources
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to move. (required)
     * @param destinationPath Remote destination path to move files/folders to. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call moveResourcesCall(String apiKey, String accessToken, List<String> filePaths, String destinationPath, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/moveResources";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (accessToken != null)
        localVarFormParams.put("access_token", accessToken);
        if (filePaths != null)
        localVarFormParams.put("filePaths", filePaths);
        if (destinationPath != null)
        localVarFormParams.put("destinationPath", destinationPath);

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
    private com.squareup.okhttp.Call moveResourcesValidateBeforeCall(String apiKey, String accessToken, List<String> filePaths, String destinationPath, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling moveResources(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling moveResources(Async)");
        }
        
        // verify the required parameter 'filePaths' is set
        if (filePaths == null) {
            throw new ApiException("Missing the required parameter 'filePaths' when calling moveResources(Async)");
        }
        
        // verify the required parameter 'destinationPath' is set
        if (destinationPath == null) {
            throw new ApiException("Missing the required parameter 'destinationPath' when calling moveResources(Async)");
        }
        

        com.squareup.okhttp.Call call = moveResourcesCall(apiKey, accessToken, filePaths, destinationPath, progressListener, progressRequestListener);
        return call;

    }

    /**
     * moveResources
     * Moves a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be moved to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to move. (required)
     * @param destinationPath Remote destination path to move files/folders to. (required)
     * @return ModifiedResourcesResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ModifiedResourcesResponse moveResources(String apiKey, String accessToken, List<String> filePaths, String destinationPath) throws ApiException {
        ApiResponse<ModifiedResourcesResponse> resp = moveResourcesWithHttpInfo(apiKey, accessToken, filePaths, destinationPath);
        return resp.getData();
    }

    /**
     * moveResources
     * Moves a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be moved to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to move. (required)
     * @param destinationPath Remote destination path to move files/folders to. (required)
     * @return ApiResponse&lt;ModifiedResourcesResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ModifiedResourcesResponse> moveResourcesWithHttpInfo(String apiKey, String accessToken, List<String> filePaths, String destinationPath) throws ApiException {
        com.squareup.okhttp.Call call = moveResourcesValidateBeforeCall(apiKey, accessToken, filePaths, destinationPath, null, null);
        Type localVarReturnType = new TypeToken<ModifiedResourcesResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * moveResources (asynchronously)
     * Moves a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be moved to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePaths Array containing file/folder paths to move. (required)
     * @param destinationPath Remote destination path to move files/folders to. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call moveResourcesAsync(String apiKey, String accessToken, List<String> filePaths, String destinationPath, final ApiCallback<ModifiedResourcesResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = moveResourcesValidateBeforeCall(apiKey, accessToken, filePaths, destinationPath, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ModifiedResourcesResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for previewFile
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path of the image relative to the user&#39;s home directory. (required)
     * @param size The size of the image. (required)
     * @param width Overrides sizes. Sets to a specific width. (optional)
     * @param height Overrides sizes. Sets to a specific height. (optional)
     * @param page Page number for the &#x60;.pdf&#x60; or &#x60;.doc&#x60; files. (optional, default to 0)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call previewFileCall(String apiKey, String accessToken, String path, String size, Integer width, Integer height, Integer page, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/previewFile";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (accessToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("access_token", accessToken));
        if (path != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("path", path));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("size", size));
        if (width != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("width", width));
        if (height != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("height", height));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));

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
    private com.squareup.okhttp.Call previewFileValidateBeforeCall(String apiKey, String accessToken, String path, String size, Integer width, Integer height, Integer page, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling previewFile(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling previewFile(Async)");
        }
        
        // verify the required parameter 'path' is set
        if (path == null) {
            throw new ApiException("Missing the required parameter 'path' when calling previewFile(Async)");
        }
        
        // verify the required parameter 'size' is set
        if (size == null) {
            throw new ApiException("Missing the required parameter 'size' when calling previewFile(Async)");
        }
        

        com.squareup.okhttp.Call call = previewFileCall(apiKey, accessToken, path, size, width, height, page, progressListener, progressRequestListener);
        return call;

    }

    /**
     * previewFile
     * Returns a resized image of the specified document for supported file types.  Image data returned is encoded in base64 format and can be viewed using the &#x60;&lt;img&gt;&#x60; element.   &#x60;&#x60;&#x60;&lt;img src&#x3D;&#39;data:image/jpeg;base64&#39; + results.image/&gt;&#x60;&#x60;&#x60;  **Notes:** - Supported files types are &#x60;&#39;jpg&#39;&#x60;, &#x60;&#39;jpeg&#39;&#x60;, &#x60;&#39;gif&#39;&#x60;, &#x60;&#39;png&#39;&#x60;, &#x60;&#39;bmp&#39;&#x60;, &#x60;&#39;pdf&#39;&#x60;, &#x60;&#39;psd&#39;&#x60;, &#x60;&#39;doc&#39;&#x60; 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path of the image relative to the user&#39;s home directory. (required)
     * @param size The size of the image. (required)
     * @param width Overrides sizes. Sets to a specific width. (optional)
     * @param height Overrides sizes. Sets to a specific height. (optional)
     * @param page Page number for the &#x60;.pdf&#x60; or &#x60;.doc&#x60; files. (optional, default to 0)
     * @return PreviewFileResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PreviewFileResponse previewFile(String apiKey, String accessToken, String path, String size, Integer width, Integer height, Integer page) throws ApiException {
        ApiResponse<PreviewFileResponse> resp = previewFileWithHttpInfo(apiKey, accessToken, path, size, width, height, page);
        return resp.getData();
    }

    /**
     * previewFile
     * Returns a resized image of the specified document for supported file types.  Image data returned is encoded in base64 format and can be viewed using the &#x60;&lt;img&gt;&#x60; element.   &#x60;&#x60;&#x60;&lt;img src&#x3D;&#39;data:image/jpeg;base64&#39; + results.image/&gt;&#x60;&#x60;&#x60;  **Notes:** - Supported files types are &#x60;&#39;jpg&#39;&#x60;, &#x60;&#39;jpeg&#39;&#x60;, &#x60;&#39;gif&#39;&#x60;, &#x60;&#39;png&#39;&#x60;, &#x60;&#39;bmp&#39;&#x60;, &#x60;&#39;pdf&#39;&#x60;, &#x60;&#39;psd&#39;&#x60;, &#x60;&#39;doc&#39;&#x60; 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path of the image relative to the user&#39;s home directory. (required)
     * @param size The size of the image. (required)
     * @param width Overrides sizes. Sets to a specific width. (optional)
     * @param height Overrides sizes. Sets to a specific height. (optional)
     * @param page Page number for the &#x60;.pdf&#x60; or &#x60;.doc&#x60; files. (optional, default to 0)
     * @return ApiResponse&lt;PreviewFileResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PreviewFileResponse> previewFileWithHttpInfo(String apiKey, String accessToken, String path, String size, Integer width, Integer height, Integer page) throws ApiException {
        com.squareup.okhttp.Call call = previewFileValidateBeforeCall(apiKey, accessToken, path, size, width, height, page, null, null);
        Type localVarReturnType = new TypeToken<PreviewFileResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * previewFile (asynchronously)
     * Returns a resized image of the specified document for supported file types.  Image data returned is encoded in base64 format and can be viewed using the &#x60;&lt;img&gt;&#x60; element.   &#x60;&#x60;&#x60;&lt;img src&#x3D;&#39;data:image/jpeg;base64&#39; + results.image/&gt;&#x60;&#x60;&#x60;  **Notes:** - Supported files types are &#x60;&#39;jpg&#39;&#x60;, &#x60;&#39;jpeg&#39;&#x60;, &#x60;&#39;gif&#39;&#x60;, &#x60;&#39;png&#39;&#x60;, &#x60;&#39;bmp&#39;&#x60;, &#x60;&#39;pdf&#39;&#x60;, &#x60;&#39;psd&#39;&#x60;, &#x60;&#39;doc&#39;&#x60; 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param path Path of the image relative to the user&#39;s home directory. (required)
     * @param size The size of the image. (required)
     * @param width Overrides sizes. Sets to a specific width. (optional)
     * @param height Overrides sizes. Sets to a specific height. (optional)
     * @param page Page number for the &#x60;.pdf&#x60; or &#x60;.doc&#x60; files. (optional, default to 0)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call previewFileAsync(String apiKey, String accessToken, String path, String size, Integer width, Integer height, Integer page, final ApiCallback<PreviewFileResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = previewFileValidateBeforeCall(apiKey, accessToken, path, size, width, height, page, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PreviewFileResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for renameResource
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePath Remote path of the file or folder to rename. (required)
     * @param newName The new name of the file or folder. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call renameResourceCall(String apiKey, String accessToken, String filePath, String newName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/renameResource";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (apiKey != null)
        localVarHeaderParams.put("api_key", apiClient.parameterToString(apiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (accessToken != null)
        localVarFormParams.put("access_token", accessToken);
        if (filePath != null)
        localVarFormParams.put("filePath", filePath);
        if (newName != null)
        localVarFormParams.put("newName", newName);

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
    private com.squareup.okhttp.Call renameResourceValidateBeforeCall(String apiKey, String accessToken, String filePath, String newName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKey' is set
        if (apiKey == null) {
            throw new ApiException("Missing the required parameter 'apiKey' when calling renameResource(Async)");
        }
        
        // verify the required parameter 'accessToken' is set
        if (accessToken == null) {
            throw new ApiException("Missing the required parameter 'accessToken' when calling renameResource(Async)");
        }
        
        // verify the required parameter 'filePath' is set
        if (filePath == null) {
            throw new ApiException("Missing the required parameter 'filePath' when calling renameResource(Async)");
        }
        
        // verify the required parameter 'newName' is set
        if (newName == null) {
            throw new ApiException("Missing the required parameter 'newName' when calling renameResource(Async)");
        }
        

        com.squareup.okhttp.Call call = renameResourceCall(apiKey, accessToken, filePath, newName, progressListener, progressRequestListener);
        return call;

    }

    /**
     * renameResource
     * Rename a file or folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePath Remote path of the file or folder to rename. (required)
     * @param newName The new name of the file or folder. (required)
     * @return Response
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Response renameResource(String apiKey, String accessToken, String filePath, String newName) throws ApiException {
        ApiResponse<Response> resp = renameResourceWithHttpInfo(apiKey, accessToken, filePath, newName);
        return resp.getData();
    }

    /**
     * renameResource
     * Rename a file or folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePath Remote path of the file or folder to rename. (required)
     * @param newName The new name of the file or folder. (required)
     * @return ApiResponse&lt;Response&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Response> renameResourceWithHttpInfo(String apiKey, String accessToken, String filePath, String newName) throws ApiException {
        com.squareup.okhttp.Call call = renameResourceValidateBeforeCall(apiKey, accessToken, filePath, newName, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * renameResource (asynchronously)
     * Rename a file or folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 
     * @param apiKey API key required to make the API call. (required)
     * @param accessToken Access token required to make the API call. (required)
     * @param filePath Remote path of the file or folder to rename. (required)
     * @param newName The new name of the file or folder. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call renameResourceAsync(String apiKey, String accessToken, String filePath, String newName, final ApiCallback<Response> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = renameResourceValidateBeforeCall(apiKey, accessToken, filePath, newName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
