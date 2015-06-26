/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */

package main.java.com.exavault.evapi.api;

import main.java.com.exavault.client.ApiException;
import main.java.com.exavault.client.ApiInvoker;
import main.java.com.exavault.evapi.model.ShareActivityResponse;
import main.java.com.exavault.evapi.model.LogResponse;
import main.java.com.exavault.evapi.model.AvailableUserResponse;
import main.java.com.exavault.evapi.model.PreviewFileResponse;
import main.java.com.exavault.evapi.model.UrlResponse;
import main.java.com.exavault.evapi.model.AccountResponse;
import main.java.com.exavault.evapi.model.UsersResponse;
import main.java.com.exavault.evapi.model.NotificationActivityResponse;
import main.java.com.exavault.evapi.model.DeletedResourcesResponse;
import main.java.com.exavault.evapi.model.NotificationsResponse;
import main.java.com.exavault.evapi.model.ModifiedResourcesResponse;
import main.java.com.exavault.evapi.model.UserResponse;
import main.java.com.exavault.evapi.model.AuthResponse;
import main.java.com.exavault.evapi.model.NotificationResponse;
import main.java.com.exavault.evapi.model.ShareResponse;
import main.java.com.exavault.evapi.model.ResourceResponse;
import main.java.com.exavault.evapi.model.Response;
import main.java.com.exavault.evapi.model.ResourcePropertiesResponse;
import main.java.com.exavault.evapi.model.ExistingResourcesResponse;
import main.java.com.exavault.evapi.model.SharesResponse;
import java.util.*;

// EV NOTE: use multimap functionality for serialization of "array" request parameters
import com.google.common.collect.Multimap;
import com.google.common.collect.HashMultimap;

public class V1Api {
    
    String basePath = "https://evapi-dev-dgleason.exavault.com";
    ApiInvoker apiInvoker = ApiInvoker.getInstance();

    public ApiInvoker getInvoker() {
        return apiInvoker;
    }
  
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
  
    public String getBasePath() {
        return basePath;
    }

    /**
     * EV NOTE: This function is needed to properly convert an array to a list
     * of URL encoded params.
     *
     * @param String paramName
     * @param List<String> list
     * @param Multimap<String, String> params
     */
    private void addParam(String paramName, List<String> list, Multimap<String, String> params) {
        for (String item : list) {
            params.put(paramName + "[]", String.valueOf(item));
        }
    }

    // EV NOTE: These dummy methods are needed because we can't
    // resolve a List<String> type reliably at runtime - only
    // List<String> needs to be serialized so we simply return the
    // object.

    private void addParam(String paramName, Boolean b, Multimap<String, String> params) {
        if (b != null) {
            params.put(paramName, String.valueOf(b));
        }
    }

    private void addParam(String paramName, Integer i, Multimap<String, String> params) {
        if (i != null) {
            params.put(paramName, String.valueOf(i));
        }
    }

    private void addParam(String paramName, Long l, Multimap<String, String> params) {
        if (l != null) {
            params.put(paramName, String.valueOf(l));
        }
    }

    private void addParam(String paramName, String s, Multimap<String, String> params) {
        if (s != null) {
            params.put(paramName, String.valueOf(s));
        }
    }

    public AuthResponse authenticateUser (String username, String password) throws ApiException {
        // verify required params are set
        if(username == null || password == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/authenticateUser".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("username", username, formParams);
        addParam("password", password, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (AuthResponse) ApiInvoker.deserialize(response, "", AuthResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public ExistingResourcesResponse checkFilesExist (String access_token, List<String> filePaths) throws ApiException {
        // verify required params are set
        if(access_token == null || filePaths == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/checkFilesExist".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("filePaths", filePaths, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (ExistingResourcesResponse) ApiInvoker.deserialize(response, "", ExistingResourcesResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public ModifiedResourcesResponse copyResources (String access_token, List<String> filePaths, String destinationPath) throws ApiException {
        // verify required params are set
        if(access_token == null || filePaths == null || destinationPath == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/copyResources".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("filePaths", filePaths, formParams);
        addParam("destinationPath", destinationPath, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (ModifiedResourcesResponse) ApiInvoker.deserialize(response, "", ModifiedResourcesResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response createFolder (String access_token, String folderName, String path) throws ApiException {
        // verify required params are set
        if(access_token == null || folderName == null || path == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/createFolder".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("folderName", folderName, formParams);
        addParam("path", path, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response createNotification (String access_token, String path, String action, String usernames, Boolean sendEmail, List<String> emails) throws ApiException {
        // verify required params are set
        if(access_token == null || path == null || action == null || usernames == null || sendEmail == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/createNotification".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("path", path, formParams);
        addParam("action", action, formParams);
        addParam("usernames", usernames, formParams);
        addParam("sendEmail", sendEmail, formParams);
        addParam("emails", emails, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response createShare (String access_token, String type, String name, List<String> filePaths, String subject, String message, List<String> emails, String ccEmail, Boolean requireEmail, String accessMode, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders) throws ApiException {
        // verify required params are set
        if(access_token == null || type == null || name == null || filePaths == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/createShare".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("type", type, formParams);
        addParam("name", name, formParams);
        addParam("filePaths", filePaths, formParams);
        addParam("subject", subject, formParams);
        addParam("message", message, formParams);
        addParam("emails", emails, formParams);
        addParam("ccEmail", ccEmail, formParams);
        addParam("requireEmail", requireEmail, formParams);
        addParam("accessMode", accessMode, formParams);
        addParam("embed", embed, formParams);
        addParam("isPublic", isPublic, formParams);
        addParam("password", password, formParams);
        addParam("expiration", expiration, formParams);
        addParam("hasNotification", hasNotification, formParams);
        addParam("notificationEmails", notificationEmails, formParams);
        addParam("fileDropCreateFolders", fileDropCreateFolders, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response createUser (String access_token, String username, String destinationFolder, String email, String password, String role, String permissions, String nickname, String expiration, Boolean locked, Boolean welcomeEmail, String timeZone) throws ApiException {
        // verify required params are set
        if(access_token == null || username == null || destinationFolder == null || email == null || password == null || role == null || permissions == null || timeZone == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/createUser".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("username", username, formParams);
        addParam("destinationFolder", destinationFolder, formParams);
        addParam("email", email, formParams);
        addParam("password", password, formParams);
        addParam("role", role, formParams);
        addParam("permissions", permissions, formParams);
        addParam("timeZone", timeZone, formParams);
        addParam("nickname", nickname, formParams);
        addParam("expiration", expiration, formParams);
        addParam("locked", locked, formParams);
        addParam("welcomeEmail", welcomeEmail, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response deleteNotification (String access_token, Integer id) throws ApiException {
        // verify required params are set
        if(access_token == null || id == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/deleteNotification".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("id", id, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public DeletedResourcesResponse deleteResources (String access_token, List<String> filePaths) throws ApiException {
        // verify required params are set
        if(access_token == null || filePaths == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/deleteResources".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("filePaths", filePaths, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (DeletedResourcesResponse) ApiInvoker.deserialize(response, "", DeletedResourcesResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response deleteShare (String access_token, Integer id) throws ApiException {
        // verify required params are set
        if(access_token == null || id == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/deleteShare".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("id", id, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response deleteUser (String access_token, String username) throws ApiException {
        // verify required params are set
        if(access_token == null || username == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/deleteUser".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("username", username, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public AccountResponse getAccount (String access_token) throws ApiException {
        // verify required params are set
        if(access_token == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getAccount".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (AccountResponse) ApiInvoker.deserialize(response, "", AccountResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public UserResponse getCurrentUser (String access_token) throws ApiException {
        // verify required params are set
        if(access_token == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getCurrentUser".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (UserResponse) ApiInvoker.deserialize(response, "", UserResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public UrlResponse getDownloadFileUrl (String access_token, String filePaths, String downloadName) throws ApiException {
        // verify required params are set
        if(access_token == null || filePaths == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getDownloadFileUrl".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("filePaths", filePaths, formParams);
        addParam("downloadName", downloadName, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (UrlResponse) ApiInvoker.deserialize(response, "", UrlResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public LogResponse getFileActivityLogs (String access_token, String filterBy, String filter, Integer itemLimit, Integer offset, String sortBy, String sortOrder) throws ApiException {
        // verify required params are set
        if(access_token == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getFileActivityLogs".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("offset", offset, formParams);
        addParam("sortBy", sortBy, formParams);
        addParam("sortOrder", sortOrder, formParams);
        addParam("filterBy", filterBy, formParams);
        addParam("filter", filter, formParams);
        addParam("itemLimit", itemLimit, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (LogResponse) ApiInvoker.deserialize(response, "", LogResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public ResourcePropertiesResponse getFolders (String access_token, String path) throws ApiException {
        // verify required params are set
        if(access_token == null || path == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getFolders".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("path", path, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (ResourcePropertiesResponse) ApiInvoker.deserialize(response, "", ResourcePropertiesResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public NotificationResponse getNotification (String access_token, Integer id) throws ApiException {
        // verify required params are set
        if(access_token == null || id == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getNotification".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("id", id, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (NotificationResponse) ApiInvoker.deserialize(response, "", NotificationResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public NotificationsResponse getNotifications (String access_token, String type, String sortBy, String sortOrder, String filter) throws ApiException {
        // verify required params are set
        if(access_token == null || type == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getNotifications".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("type", type, formParams);
        addParam("sortBy", sortBy, formParams);
        addParam("sortOrder", sortOrder, formParams);
        addParam("filter", filter, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (NotificationsResponse) ApiInvoker.deserialize(response, "", NotificationsResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public NotificationActivityResponse getNotificationActivity (String access_token) throws ApiException {
        // verify required params are set
        if(access_token == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getNotificationActivity".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (NotificationActivityResponse) ApiInvoker.deserialize(response, "", NotificationActivityResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public ResourceResponse getResourceList (String access_token, String path, String sortBy, String sortOrder, Integer offset, Integer limit, Boolean detailed, String pattern) throws ApiException {
        // verify required params are set
        if(access_token == null || path == null || sortBy == null || sortOrder == null || offset == null || limit == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getResourceList".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("path", path, formParams);
        addParam("sortBy", sortBy, formParams);
        addParam("sortOrder", sortOrder, formParams);
        addParam("offset", offset, formParams);
        addParam("limit", limit, formParams);
        addParam("detailed", detailed, formParams);
        addParam("pattern", pattern, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (ResourceResponse) ApiInvoker.deserialize(response, "", ResourceResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public ResourcePropertiesResponse getResourceProperties (String access_token, List<String> filePaths) throws ApiException {
        // verify required params are set
        if(access_token == null || filePaths == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getResourceProperties".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("filePaths", filePaths, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (ResourcePropertiesResponse) ApiInvoker.deserialize(response, "", ResourcePropertiesResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public ShareResponse getShare (String access_token, Integer id) throws ApiException {
        // verify required params are set
        if(access_token == null || id == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getShare".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("id", id, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (ShareResponse) ApiInvoker.deserialize(response, "", ShareResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public SharesResponse getShares (String access_token, String type, String sortBy, String sortOrder, String filter, String include, Integer offset, Integer limit) throws ApiException {
        // verify required params are set
        if(access_token == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getShares".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("type", type, formParams);
        addParam("sortBy", sortBy, formParams);
        addParam("sortOrder", sortOrder, formParams);
        addParam("filter", filter, formParams);
        addParam("include", include, formParams);
        addParam("offset", offset, formParams);
        addParam("limit", limit, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (SharesResponse) ApiInvoker.deserialize(response, "", SharesResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public ShareActivityResponse getShareActivity (String access_token, Integer id) throws ApiException {
        // verify required params are set
        if(access_token == null || id == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getShareActivity".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("id", id, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (ShareActivityResponse) ApiInvoker.deserialize(response, "", ShareActivityResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public UrlResponse getUploadFileUrl (String access_token, Long fileSize, String destinationPath, Boolean allowOverwrite, Boolean resume) throws ApiException {
        // verify required params are set
        if(access_token == null || fileSize == null || destinationPath == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getUploadFileUrl".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("fileSize", fileSize, formParams);
        addParam("destinationPath", destinationPath, formParams);
        addParam("allowOverwrite", allowOverwrite, formParams);
        addParam("resume", resume, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (UrlResponse) ApiInvoker.deserialize(response, "", UrlResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public UserResponse getUser (String access_token, String username) throws ApiException {
        // verify required params are set
        if(access_token == null || username == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getUser".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("username", username, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (UserResponse) ApiInvoker.deserialize(response, "", UserResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public UsersResponse getUsers (String access_token, String sortBy, String sortOrder) throws ApiException {
        // verify required params are set
        if(access_token == null || sortBy == null || sortOrder == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getUsers".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("sortBy", sortBy, formParams);
        addParam("sortOrder", sortOrder, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (UsersResponse) ApiInvoker.deserialize(response, "", UsersResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response logoutUser (String access_token) throws ApiException {
        // verify required params are set
        if(access_token == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/logoutUser".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public ModifiedResourcesResponse moveResources (String access_token, List<String> filePaths, String destinationPath) throws ApiException {
        // verify required params are set
        if(access_token == null || filePaths == null || destinationPath == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/moveResources".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("filePaths", filePaths, formParams);
        addParam("destinationPath", destinationPath, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (ModifiedResourcesResponse) ApiInvoker.deserialize(response, "", ModifiedResourcesResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public PreviewFileResponse previewFile (String access_token, String path, String size, Integer width, Integer height, Integer page) throws ApiException {
        // verify required params are set
        if(access_token == null || path == null || size == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/previewFile".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("path", path, formParams);
        addParam("size", size, formParams);
        addParam("width", width, formParams);
        addParam("height", height, formParams);
        addParam("page", page, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (PreviewFileResponse) ApiInvoker.deserialize(response, "", PreviewFileResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response renameResource (String access_token, String filePath, String newName) throws ApiException {
        // verify required params are set
        if(access_token == null || filePath == null || newName == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/renameResource".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("filePath", filePath, formParams);
        addParam("newName", newName, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response updateNotification (String access_token, Integer id, String path, String action, String usernames, List<String> emails, Boolean sendEmail) throws ApiException {
        // verify required params are set
        if(access_token == null || id == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/updateNotification".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("id", id, formParams);
        addParam("path", path, formParams);
        addParam("action", action, formParams);
        addParam("usernames", usernames, formParams);
        addParam("emails", emails, formParams);
        addParam("sendEmail", sendEmail, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response updateShare (String access_token, Integer id, String name, List<String> filePaths, String subject, String message, List<String> emails, String ccEmail, Boolean requireEmail, String accessMode, Boolean embed, Boolean isPublic, String password, String expiration, Boolean hasNotification, List<String> notificationEmails, Boolean fileDropCreateFolders) throws ApiException {
        // verify required params are set
        if(access_token == null || id == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/updateShare".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("id", id, formParams);
        addParam("name", name, formParams);
        addParam("filePaths", filePaths, formParams);
        addParam("subject", subject, formParams);
        addParam("message", message, formParams);
        addParam("emails", emails, formParams);
        addParam("ccEmail", ccEmail, formParams);
        addParam("requireEmail", requireEmail, formParams);
        addParam("accessMode", accessMode, formParams);
        addParam("embed", embed, formParams);
        addParam("isPublic", isPublic, formParams);
        addParam("password", password, formParams);
        addParam("expiration", expiration, formParams);
        addParam("hasNotification", hasNotification, formParams);
        addParam("notificationEmails", notificationEmails, formParams);
        addParam("fileDropCreateFolders", fileDropCreateFolders, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public Response updateUser (String access_token, Integer userId, String username, String nickname, String expiration, String email, String destinationFolder, String password, Boolean locked, String role, String permissions) throws ApiException {
        // verify required params are set
        if(access_token == null || userId == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/updateUser".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("userId", userId, formParams);
        addParam("username", username, formParams);
        addParam("nickname", nickname, formParams);
        addParam("expiration", expiration, formParams);
        addParam("email", email, formParams);
        addParam("destinationFolder", destinationFolder, formParams);
        addParam("password", password, formParams);
        addParam("locked", locked, formParams);
        addParam("role", role, formParams);
        addParam("permissions", permissions, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (Response) ApiInvoker.deserialize(response, "", Response.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    public AvailableUserResponse userAvailable (String access_token, String username) throws ApiException {
        // verify required params are set
        if(access_token == null || username == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/userAvailable".replaceAll("\\{format\\}","json");

        Multimap<String, String> queryParams = HashMultimap.create();
        Multimap<String, String> headerParams = HashMultimap.create();
        Multimap<String, String> formParams = HashMultimap.create();

        addParam("access_token", access_token, formParams);
        addParam("username", username, formParams);
        String contentType = "application/x-www-form-urlencoded";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (AvailableUserResponse) ApiInvoker.deserialize(response, "", AvailableUserResponse.class);
            }
            else {
                return null;
            }
        } catch (ApiException ex) {
            if(ex.getCode() == 404) {
                return null;
            }
            else {
                throw ex;
            }
        }
    }
    }

