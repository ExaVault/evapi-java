/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */

package com.exavault.evapi.api;

import com.exavault.client.ApiException;
import com.exavault.client.ApiInvoker;
import com.exavault.evapi.model.LogResponse;
import com.exavault.evapi.model.AvailableUserResponse;
import com.exavault.evapi.model.PreviewFileResponse;
import com.exavault.evapi.model.UrlResponse;
import com.exavault.evapi.model.AccountResponse;
import com.exavault.evapi.model.UsersResponse;
import com.exavault.evapi.model.ModifiedResourcesResponse;
import com.exavault.evapi.model.UserResponse;
import com.exavault.evapi.model.AuthResponse;
import com.exavault.evapi.model.ResourceResponse;
import com.exavault.evapi.model.Response;
import com.exavault.evapi.model.FilesResponse;
import com.exavault.evapi.model.ResourcePropertiesResponse;
import com.exavault.evapi.model.ExistingResourcesResponse;
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

  public AuthResponse authenticateUser (String username, String password) throws ApiException {
    // verify required params are set
    if(username == null || password == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/authenticateUser".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("username", username);
    queryParams.put("password", password);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/checkFilesExist".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("filePaths", stringListToCsv(filePaths));

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/copyResources".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();


    queryParams.put("access_token", access_token);
    queryParams.put("filePaths", stringListToCsv(filePaths));
    queryParams.put("destinationPath", destinationPath);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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

    queryParams.put("access_token", access_token);
    queryParams.put("folderName", folderName);
    queryParams.put("path", path);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, relativePath, "GET", queryParams, null, headerParams, formParams, contentType);
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
  
  public Response createUser (String access_token, String username, String destinationFolder, String email, String password, String role, List<String> permissions, String nickname, Boolean locked, Boolean welcomeEmail, String timeZone) throws ApiException {
    // verify required params are set
    if(access_token == null || username == null || destinationFolder == null || email == null || password == null || role == null || permissions == null || timeZone == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/createUser".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("username", username);
    queryParams.put("destinationFolder", destinationFolder);
    queryParams.put("email", email);
    queryParams.put("password", password);
    queryParams.put("role", role);
    queryParams.put("permissions", stringListToCsv(permissions));
    queryParams.put("timeZone", timeZone);
    
    if (nickname != null) {
      queryParams.put("nickname", nickname);
    }
    if (locked != null) {
      queryParams.put("locked", locked.toString());
    }
    if (welcomeEmail != null) {
      queryParams.put("welcomeEmail", welcomeEmail.toString());
    }

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/deleteResources".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("filePaths", stringListToCsv(filePaths));

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
  
  public Response deleteUser (String access_token, String username) throws ApiException {
    // verify required params are set
    if(access_token == null || username == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/deleteUser".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("username", username);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/getAccount".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    
    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/getCurrentUser".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();
    
    queryParams.put("access_token", access_token);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/getDownloadFileUrl".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("filePaths", filePaths);
    if(downloadName != null) {
      queryParams.put("downloadName", downloadName);
    }

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/getFileActivityLogs".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    if(offset != null) {
      queryParams.put("offset", String.valueOf(offset));
    }
    if(sortBy != null) {
      queryParams.put("sortBy", sortBy);
    }
    if(sortOrder != null) {
      queryParams.put("sortOrder", sortOrder);
    }
    if(filterBy != null) {
      queryParams.put("filterBy", filterBy);
    }
    if(filter != null) {
      queryParams.put("filter", filter);
    }
    if(itemLimit != null) {
      queryParams.put("itemLimit", String.valueOf(itemLimit));
    }

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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

    queryParams.put("access_token", access_token);
    queryParams.put("path", path);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, relativePath, "GET", queryParams, null, headerParams, formParams, contentType);
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

    queryParams.put("access_token", access_token);
    queryParams.put("path", path);
    queryParams.put("sortBy", sortBy);
    queryParams.put("sortOrder", sortOrder);
    queryParams.put("offset", String.valueOf(offset));
    queryParams.put("limit", String.valueOf(limit));   
    if(detailed != null) {
      queryParams.put("detailed", detailed.toString());
    }
    if(pattern != null) {
      queryParams.put("pattern", pattern);
    }

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, relativePath, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/getResourceProperties".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("filePaths", stringListToCsv(filePaths));

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
  
  public UrlResponse getUploadFileUrl (String access_token, Integer fileSize, String destinationPath, Boolean allowOverwrite, Boolean resume) throws ApiException {
    // verify required params are set
    if(access_token == null || fileSize == null || destinationPath == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/getUploadFileUrl".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("fileSize", String.valueOf(fileSize));
    queryParams.put("destinationPath", destinationPath);
    
    if(allowOverwrite != null) {
      queryParams.put("allowOverwrite", allowOverwrite.toString());
    }
    if(resume != null) {
      queryParams.put("resume", resume.toString());
    }

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/getUser".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("username", username);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/getUsers".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("sortBy", sortBy);
    queryParams.put("sortOrder", sortOrder);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/logoutUser".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/moveResources".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", String.valueOf(access_token));
    queryParams.put("filePaths", stringListToCsv(filePaths));
    queryParams.put("destinationPath", destinationPath);

    String contentType ="application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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

    queryParams.put("access_token", access_token);
    queryParams.put("path", path);
    queryParams.put("size", size);
    
    if(width != null) {
      queryParams.put("width", String.valueOf(width));
    }
    if(height != null) {
      queryParams.put("height", String.valueOf(height));
    }
    if(page != null) {
      queryParams.put("page", String.valueOf(page));
    }

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, relativePath, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/renameResource".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("filePath", filePath);
    queryParams.put("newName", newName);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
  
  public Response updateUser (String access_token, Integer userId, String username, String nickname, String email, String destinationFolder, String password, Boolean locked, String role, List<String> permissions) throws ApiException {
    // verify required params are set
    if(access_token == null || userId == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/updateUser".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("userId", String.valueOf(userId));
    
    if(username != null) {
      queryParams.put("username", username);
    }
    if(nickname != null) {
      queryParams.put("nickname", nickname);
    }
    if(email != null) {
      queryParams.put("email", email);
    }
    if(destinationFolder != null) {
      queryParams.put("destinationFolder", destinationFolder);
    }
    if(password != null) {
      queryParams.put("password", password);
    }
    if(locked != null) {
      queryParams.put("locked", locked.toString());
    }
    if(role != null) {
      queryParams.put("role", role);
    }
    if(permissions != null) {
      queryParams.put("permissions", stringListToCsv(permissions));
    }
    
    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
    String path = "/v1/userAvailable".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    queryParams.put("access_token", access_token);
    queryParams.put("username", username);

    String contentType = "application/json";

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, null, headerParams, formParams, contentType);
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
  
  private String stringListToCsv(List<String> list) {
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
}

