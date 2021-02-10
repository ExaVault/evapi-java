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
 */

package com.exavault.client.api;

import com.exavault.client.ApiCallback;
import com.exavault.client.ApiClient;
import com.exavault.client.ApiException;
import com.exavault.client.ApiResponse;
import com.exavault.client.Configuration;
import com.exavault.client.Pair;
import com.exavault.client.ProgressRequestBody;
import com.exavault.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.exavault.client.model.AddSSHKeyRequestBody;
import com.exavault.client.model.SSHKeyCollectionResponse;
import com.exavault.client.model.SSHKeyResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SshKeysApi {
    private ApiClient apiClient;

    public SshKeysApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SshKeysApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addSSHKey
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addSSHKeyCall(String evApiKey, String evAccessToken, AddSSHKeyRequestBody body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/ssh-keys";

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
    private com.squareup.okhttp.Call addSSHKeyValidateBeforeCall(String evApiKey, String evAccessToken, AddSSHKeyRequestBody body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling addSSHKey(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling addSSHKey(Async)");
        }
        
        com.squareup.okhttp.Call call = addSSHKeyCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a new SSH Key
     * Create a new SSH Key for a user. Provide the Public Key as formatted from the ssh-keygen command (openssh format or RFC-4716 format).  If you&#x27;d prefer to let us generate your key automatically, you can log in to your account via the web portal and set up new keys via the SSH Keys page. 
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return SSHKeyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SSHKeyResponse addSSHKey(String evApiKey, String evAccessToken, AddSSHKeyRequestBody body) throws ApiException {
        ApiResponse<SSHKeyResponse> resp = addSSHKeyWithHttpInfo(evApiKey, evAccessToken, body);
        return resp.getData();
    }

    /**
     * Create a new SSH Key
     * Create a new SSH Key for a user. Provide the Public Key as formatted from the ssh-keygen command (openssh format or RFC-4716 format).  If you&#x27;d prefer to let us generate your key automatically, you can log in to your account via the web portal and set up new keys via the SSH Keys page. 
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @return ApiResponse&lt;SSHKeyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SSHKeyResponse> addSSHKeyWithHttpInfo(String evApiKey, String evAccessToken, AddSSHKeyRequestBody body) throws ApiException {
        com.squareup.okhttp.Call call = addSSHKeyValidateBeforeCall(evApiKey, evAccessToken, body, null, null);
        Type localVarReturnType = new TypeToken<SSHKeyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new SSH Key (asynchronously)
     * Create a new SSH Key for a user. Provide the Public Key as formatted from the ssh-keygen command (openssh format or RFC-4716 format).  If you&#x27;d prefer to let us generate your key automatically, you can log in to your account via the web portal and set up new keys via the SSH Keys page. 
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addSSHKeyAsync(String evApiKey, String evAccessToken, AddSSHKeyRequestBody body, final ApiCallback<SSHKeyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addSSHKeyValidateBeforeCall(evApiKey, evAccessToken, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SSHKeyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteSSHKey
     * @param id  (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteSSHKeyCall(String id, String evApiKey, String evAccessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/ssh-keys/{id}"
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
    private com.squareup.okhttp.Call deleteSSHKeyValidateBeforeCall(String id, String evApiKey, String evAccessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteSSHKey(Async)");
        }
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling deleteSSHKey(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling deleteSSHKey(Async)");
        }
        
        com.squareup.okhttp.Call call = deleteSSHKeyCall(id, evApiKey, evAccessToken, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete an SSH Key
     * Delete the specified SSH key. This will not delete or deactivate the user tied to the key.
     * @param id  (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteSSHKey(String id, String evApiKey, String evAccessToken) throws ApiException {
        deleteSSHKeyWithHttpInfo(id, evApiKey, evAccessToken);
    }

    /**
     * Delete an SSH Key
     * Delete the specified SSH key. This will not delete or deactivate the user tied to the key.
     * @param id  (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteSSHKeyWithHttpInfo(String id, String evApiKey, String evAccessToken) throws ApiException {
        com.squareup.okhttp.Call call = deleteSSHKeyValidateBeforeCall(id, evApiKey, evAccessToken, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete an SSH Key (asynchronously)
     * Delete the specified SSH key. This will not delete or deactivate the user tied to the key.
     * @param id  (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteSSHKeyAsync(String id, String evApiKey, String evAccessToken, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteSSHKeyValidateBeforeCall(id, evApiKey, evAccessToken, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getSSHKey
     * @param id  (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getSSHKeyCall(String id, String evApiKey, String evAccessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/ssh-keys/{id}"
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getSSHKeyValidateBeforeCall(String id, String evApiKey, String evAccessToken, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getSSHKey(Async)");
        }
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling getSSHKey(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling getSSHKey(Async)");
        }
        
        com.squareup.okhttp.Call call = getSSHKeyCall(id, evApiKey, evAccessToken, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get metadata for an SSH Key
     * Return the information for a single SSH Key
     * @param id  (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @return SSHKeyResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SSHKeyResponse getSSHKey(String id, String evApiKey, String evAccessToken) throws ApiException {
        ApiResponse<SSHKeyResponse> resp = getSSHKeyWithHttpInfo(id, evApiKey, evAccessToken);
        return resp.getData();
    }

    /**
     * Get metadata for an SSH Key
     * Return the information for a single SSH Key
     * @param id  (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @return ApiResponse&lt;SSHKeyResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SSHKeyResponse> getSSHKeyWithHttpInfo(String id, String evApiKey, String evAccessToken) throws ApiException {
        com.squareup.okhttp.Call call = getSSHKeyValidateBeforeCall(id, evApiKey, evAccessToken, null, null);
        Type localVarReturnType = new TypeToken<SSHKeyResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get metadata for an SSH Key (asynchronously)
     * Return the information for a single SSH Key
     * @param id  (required)
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSSHKeyAsync(String id, String evApiKey, String evAccessToken, final ApiCallback<SSHKeyResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getSSHKeyValidateBeforeCall(id, evApiKey, evAccessToken, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SSHKeyResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getSSHKeysList
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param username  Only return results for the given username. Does not support wildcard searches. (optional)
     * @param limit  Limits the results by the given number. Cannot be set higher than 100. (optional)
     * @param offset  Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getSSHKeysListCall(String evApiKey, String evAccessToken, String username, Integer limit, Integer offset, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/ssh-keys";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (username != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("username", username));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));

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
    private com.squareup.okhttp.Call getSSHKeysListValidateBeforeCall(String evApiKey, String evAccessToken, String username, Integer limit, Integer offset, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'evApiKey' is set
        if (evApiKey == null) {
            throw new ApiException("Missing the required parameter 'evApiKey' when calling getSSHKeysList(Async)");
        }
        // verify the required parameter 'evAccessToken' is set
        if (evAccessToken == null) {
            throw new ApiException("Missing the required parameter 'evAccessToken' when calling getSSHKeysList(Async)");
        }
        
        com.squareup.okhttp.Call call = getSSHKeysListCall(evApiKey, evAccessToken, username, limit, offset, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get metadata for a list of SSH Keys
     * Returns a list of SSH Keys within the account. Can be filtered for a single username.
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param username  Only return results for the given username. Does not support wildcard searches. (optional)
     * @param limit  Limits the results by the given number. Cannot be set higher than 100. (optional)
     * @param offset  Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional)
     * @return SSHKeyCollectionResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SSHKeyCollectionResponse getSSHKeysList(String evApiKey, String evAccessToken, String username, Integer limit, Integer offset) throws ApiException {
        ApiResponse<SSHKeyCollectionResponse> resp = getSSHKeysListWithHttpInfo(evApiKey, evAccessToken, username, limit, offset);
        return resp.getData();
    }

    /**
     * Get metadata for a list of SSH Keys
     * Returns a list of SSH Keys within the account. Can be filtered for a single username.
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param username  Only return results for the given username. Does not support wildcard searches. (optional)
     * @param limit  Limits the results by the given number. Cannot be set higher than 100. (optional)
     * @param offset  Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional)
     * @return ApiResponse&lt;SSHKeyCollectionResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SSHKeyCollectionResponse> getSSHKeysListWithHttpInfo(String evApiKey, String evAccessToken, String username, Integer limit, Integer offset) throws ApiException {
        com.squareup.okhttp.Call call = getSSHKeysListValidateBeforeCall(evApiKey, evAccessToken, username, limit, offset, null, null);
        Type localVarReturnType = new TypeToken<SSHKeyCollectionResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get metadata for a list of SSH Keys (asynchronously)
     * Returns a list of SSH Keys within the account. Can be filtered for a single username.
     * @param evApiKey API key required to make the API call. (required)
     * @param evAccessToken Access token required to make the API call. (required)
     * @param username  Only return results for the given username. Does not support wildcard searches. (optional)
     * @param limit  Limits the results by the given number. Cannot be set higher than 100. (optional)
     * @param offset  Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getSSHKeysListAsync(String evApiKey, String evAccessToken, String username, Integer limit, Integer offset, final ApiCallback<SSHKeyCollectionResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getSSHKeysListValidateBeforeCall(evApiKey, evAccessToken, username, limit, offset, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SSHKeyCollectionResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
