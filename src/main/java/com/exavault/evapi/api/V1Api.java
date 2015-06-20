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
import main.java.com.exavault.evapi.model.NotificationsResponse;
import main.java.com.exavault.evapi.model.ModifiedResourcesResponse;
import main.java.com.exavault.evapi.model.UserResponse;
import main.java.com.exavault.evapi.model.AuthResponse;
import main.java.com.exavault.evapi.model.NotificationResponse;
import main.java.com.exavault.evapi.model.ShareResponse;
import main.java.com.exavault.evapi.model.ResourceResponse;
import main.java.com.exavault.evapi.model.Response;
import main.java.com.exavault.evapi.model.FilesResponse;
import main.java.com.exavault.evapi.model.ResourcePropertiesResponse;
import main.java.com.exavault.evapi.model.ExistingResourcesResponse;
import main.java.com.exavault.evapi.model.SharesResponse;
import java.util.*;

public class V1Api {
    
    String basePath = "https://api.exavault.com";
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
     * This function is needed to properly serialize a List<String> to
     * a csv
     *
     * @author Juan Carlos González
     */
    private String serialize(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String item : list) {
            builder.append(item).append(",");
        }
        String csv = builder.toString();
        if (csv != null && csv.length() > 0) {
            csv = csv.substring(0, csv.length() - 1);
        }
        return csv;
    }

    // EV NOTE: These dummy methods are needed because we can't
    // resolve a List<String> type reliably at runtime - only
    // List<String> needs to be serialized so we simply return the
    // object.

    private String serialize(Boolean b) {
        return String.valueOf(b);
    }

    private String serialize(Integer i) {
        return String.valueOf(i);
    }

    private String serialize(String s) {
        return String.valueOf(s);
    }

    public AuthResponse authenticateUser (String username, String password) throws ApiException {
        // verify required params are set
        if(username == null || password == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/authenticateUser".replaceAll("\\{format\\}","json");

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("username", serialize(username));
        formParams.put("password", serialize(password));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("filePaths", serialize(filePaths));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("filePaths", serialize(filePaths));
        formParams.put("destinationPath", serialize(destinationPath));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("folderName", serialize(folderName));
        formParams.put("path", serialize(path));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("path", serialize(path));
        formParams.put("action", serialize(action));
        formParams.put("usernames", serialize(usernames));
        formParams.put("sendEmail", serialize(sendEmail));
        formParams.put("emails", serialize(emails));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("type", serialize(type));
        formParams.put("name", serialize(name));
        formParams.put("filePaths", serialize(filePaths));
        formParams.put("subject", serialize(subject));
        formParams.put("message", serialize(message));
        formParams.put("emails", serialize(emails));
        formParams.put("ccEmail", serialize(ccEmail));
        formParams.put("requireEmail", serialize(requireEmail));
        formParams.put("accessMode", serialize(accessMode));
        formParams.put("embed", serialize(embed));
        formParams.put("isPublic", serialize(isPublic));
        formParams.put("password", serialize(password));
        formParams.put("expiration", serialize(expiration));
        formParams.put("hasNotification", serialize(hasNotification));
        formParams.put("notificationEmails", serialize(notificationEmails));
        formParams.put("fileDropCreateFolders", serialize(fileDropCreateFolders));
        String contentType = "application/json";

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
    public Response createUser (String access_token, String username, String destinationFolder, String email, String password, String role, List<String> permissions, String nickname, String expiration, Boolean locked, Boolean welcomeEmail, String timeZone) throws ApiException {
        // verify required params are set
        if(access_token == null || username == null || destinationFolder == null || email == null || password == null || role == null || permissions == null || timeZone == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/createUser".replaceAll("\\{format\\}","json");

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("username", serialize(username));
        formParams.put("destinationFolder", serialize(destinationFolder));
        formParams.put("email", serialize(email));
        formParams.put("password", serialize(password));
        formParams.put("role", serialize(role));
        formParams.put("permissions", serialize(permissions));
        formParams.put("timeZone", serialize(timeZone));
        formParams.put("nickname", serialize(nickname));
        formParams.put("expiration", serialize(expiration));
        formParams.put("locked", serialize(locked));
        formParams.put("welcomeEmail", serialize(welcomeEmail));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("id", serialize(id));
        String contentType = "application/json";

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
    public FilesResponse deleteResources (String access_token, List<String> filePaths) throws ApiException {
        // verify required params are set
        if(access_token == null || filePaths == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/deleteResources".replaceAll("\\{format\\}","json");

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("filePaths", serialize(filePaths));
        String contentType = "application/json";

        try {
            String response = apiInvoker.invokeAPI(basePath, relativePath, "POST", queryParams, null, headerParams, formParams, contentType);
            if(response != null){
                return (FilesResponse) ApiInvoker.deserialize(response, "", FilesResponse.class);
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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("id", serialize(id));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("username", serialize(username));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("filePaths", serialize(filePaths));
        formParams.put("downloadName", serialize(downloadName));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("offset", serialize(offset));
        formParams.put("sortBy", serialize(sortBy));
        formParams.put("sortOrder", serialize(sortOrder));
        formParams.put("filterBy", serialize(filterBy));
        formParams.put("filter", serialize(filter));
        formParams.put("itemLimit", serialize(itemLimit));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("path", serialize(path));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("id", serialize(id));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("type", serialize(type));
        formParams.put("sortBy", serialize(sortBy));
        formParams.put("sortOrder", serialize(sortOrder));
        formParams.put("filter", serialize(filter));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("path", serialize(path));
        formParams.put("sortBy", serialize(sortBy));
        formParams.put("sortOrder", serialize(sortOrder));
        formParams.put("offset", serialize(offset));
        formParams.put("limit", serialize(limit));
        formParams.put("detailed", serialize(detailed));
        formParams.put("pattern", serialize(pattern));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("filePaths", serialize(filePaths));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("id", serialize(id));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("type", serialize(type));
        formParams.put("sortBy", serialize(sortBy));
        formParams.put("sortOrder", serialize(sortOrder));
        formParams.put("filter", serialize(filter));
        formParams.put("include", serialize(include));
        formParams.put("offset", serialize(offset));
        formParams.put("limit", serialize(limit));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("id", serialize(id));
        String contentType = "application/json";

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
    public UrlResponse getUploadFileUrl (String access_token, Integer fileSize, String destinationPath, Boolean allowOverwrite, Boolean resume) throws ApiException {
        // verify required params are set
        if(access_token == null || fileSize == null || destinationPath == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/getUploadFileUrl".replaceAll("\\{format\\}","json");

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("fileSize", serialize(fileSize));
        formParams.put("destinationPath", serialize(destinationPath));
        formParams.put("allowOverwrite", serialize(allowOverwrite));
        formParams.put("resume", serialize(resume));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("username", serialize(username));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("sortBy", serialize(sortBy));
        formParams.put("sortOrder", serialize(sortOrder));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("filePaths", serialize(filePaths));
        formParams.put("destinationPath", serialize(destinationPath));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("path", serialize(path));
        formParams.put("size", serialize(size));
        formParams.put("width", serialize(width));
        formParams.put("height", serialize(height));
        formParams.put("page", serialize(page));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("filePath", serialize(filePath));
        formParams.put("newName", serialize(newName));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("id", serialize(id));
        formParams.put("path", serialize(path));
        formParams.put("action", serialize(action));
        formParams.put("usernames", serialize(usernames));
        formParams.put("emails", serialize(emails));
        formParams.put("sendEmail", serialize(sendEmail));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("id", serialize(id));
        formParams.put("name", serialize(name));
        formParams.put("filePaths", serialize(filePaths));
        formParams.put("subject", serialize(subject));
        formParams.put("message", serialize(message));
        formParams.put("emails", serialize(emails));
        formParams.put("ccEmail", serialize(ccEmail));
        formParams.put("requireEmail", serialize(requireEmail));
        formParams.put("accessMode", serialize(accessMode));
        formParams.put("embed", serialize(embed));
        formParams.put("isPublic", serialize(isPublic));
        formParams.put("password", serialize(password));
        formParams.put("expiration", serialize(expiration));
        formParams.put("hasNotification", serialize(hasNotification));
        formParams.put("notificationEmails", serialize(notificationEmails));
        formParams.put("fileDropCreateFolders", serialize(fileDropCreateFolders));
        String contentType = "application/json";

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
    public Response updateUser (String access_token, Integer userId, String username, String nickname, String expiration, String email, String destinationFolder, String password, Boolean locked, String role, List<String> permissions) throws ApiException {
        // verify required params are set
        if(access_token == null || userId == null ) {
            throw new ApiException(400, "missing required params");
        }
        // create path and map variables
        String relativePath = "/v1/updateUser".replaceAll("\\{format\\}","json");

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("userId", serialize(userId));
        formParams.put("username", serialize(username));
        formParams.put("nickname", serialize(nickname));
        formParams.put("expiration", serialize(expiration));
        formParams.put("email", serialize(email));
        formParams.put("destinationFolder", serialize(destinationFolder));
        formParams.put("password", serialize(password));
        formParams.put("locked", serialize(locked));
        formParams.put("role", serialize(role));
        formParams.put("permissions", serialize(permissions));
        String contentType = "application/json";

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

        // query params
        Map<String, String> queryParams = new HashMap<String, String>();
        Map<String, String> headerParams = new HashMap<String, String>();
        Map<String, String> formParams = new HashMap<String, String>();

        formParams.put("access_token", serialize(access_token));
        formParams.put("username", serialize(username));
        String contentType = "application/json";

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

