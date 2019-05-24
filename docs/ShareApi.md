# ShareApi

All URIs are relative to *https://api.exavault.com/v1.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addFormData**](ShareApi.md#addFormData) | **POST** /addFormData | addFormData
[**createShare**](ShareApi.md#createShare) | **POST** /createShare | createShare
[**deleteShare**](ShareApi.md#deleteShare) | **GET** /deleteShare | deleteShare
[**getForm**](ShareApi.md#getForm) | **GET** /getForm | getForm
[**getFormData**](ShareApi.md#getFormData) | **GET** /getFormData | getFormData
[**getShare**](ShareApi.md#getShare) | **GET** /getShare | getShare
[**getShares**](ShareApi.md#getShares) | **GET** /getShares | getShares
[**updateForm**](ShareApi.md#updateForm) | **POST** /updateForm | updateForm
[**updateShare**](ShareApi.md#updateShare) | **POST** /updateShare | updateShare


<a name="addFormData"></a>
# **addFormData**
> Response addFormData(apiKey, accessToken, formId, data, paths)

addFormData

Upload form field data and associate with files that are in the receive folder. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer formId = 56; // Integer | Unique identifier for associated form. Either `formId` or `shareId` is required.
String data = "data_example"; // String | JSON object containing field names and their values.
List<String> paths = Arrays.asList("paths_example"); // List<String> | Total number of entries to be downloaded. Default is 50
try {
    Response result = apiInstance.addFormData(apiKey, accessToken, formId, data, paths);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#addFormData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **formId** | **Integer**| Unique identifier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. |
 **data** | **String**| JSON object containing field names and their values. |
 **paths** | [**List&lt;String&gt;**](String.md)| Total number of entries to be downloaded. Default is 50 |

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="createShare"></a>
# **createShare**
> ShareResponse createShare(apiKey, accessToken, type, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders)

createShare

Creates a new share object for the given path in your account. We support three types of shares:   - A **shared folder** allows you to let outside parties access a folder in your account (including any files and nested subfolders) using just a link. Shared folders can be restricted; e.g. with an expiration date, password, download-only, etc. Shared folders are &#39;live&#39;; if someone makes a change to a file in your shared folder, it will be immediately reflected in your account, and vice-versa.   - A **file send** lets you send one or more files via an easy download link. File sends are different than shared folders because file sends are &#39;point in time&#39; -- the recipient will get the files as you sent them. If you later make a change to the source file, it will not be updated for the recipient.   - A **receive folder** lets you receive files into your account. You can either send users a link, or optionally embed &lt;a href&#x3D;\&quot;/docs/account/05-file-sharing/05-upload-widget\&quot;&gt;a customized form&lt;/a&gt; on your website.  **Notes:** - Authenticated user requires share permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String type = "type_example"; // String | The type of share to create. See above for a description of each.
String name = "name_example"; // String | Name of the share.
List<String> filePaths = Arrays.asList("filePaths_example"); // List<String> | Array of strings containing the file paths to share.
String accessMode = "accessMode_example"; // String | Type of permissions share recipients have.
String subject = "subject_example"; // String | Share message subject (for email invitations).
String message = "message_example"; // String | Share message contents (for email invitations).
List<String> emails = Arrays.asList("emails_example"); // List<String> | Array of strings for email recipients (for email invitations).
List<String> ccEmail = Arrays.asList("ccEmail_example"); // List<String> | Array of strings for CC email recipients (for email invitations).
Boolean requireEmail = false; // Boolean | Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the `emails` paramater. 
Boolean embed = false; // Boolean | Allows user to embed a widget with the share.
Boolean isPublic = false; // Boolean | True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process.
String password = "password_example"; // String | If not null, value of password is required to access this share.
String expiration = "expiration_example"; // String | The timestamp the current share should expire, formatted `YYYY-mm-dd hh:mm:ss`.
Boolean hasNotification = false; // Boolean | True if the user should be notified about activity on this share.
List<String> notificationEmails = Arrays.asList("notificationEmails_example"); // List<String> | An array of recipients who should receive notification emails.
Boolean fileDropCreateFolders = false; // Boolean | If true, all receive folder submissions will be uploaded separate folders (only applicable for the `receive` share type).
try {
    ShareResponse result = apiInstance.createShare(apiKey, accessToken, type, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#createShare");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **type** | **String**| The type of share to create. See above for a description of each. | [enum: shared_folder, send, receive]
 **name** | **String**| Name of the share. |
 **filePaths** | [**List&lt;String&gt;**](String.md)| Array of strings containing the file paths to share. |
 **accessMode** | **String**| Type of permissions share recipients have. | [enum: upload, download, download_upload, download_upload_modify_delete]
 **subject** | **String**| Share message subject (for email invitations). | [optional]
 **message** | **String**| Share message contents (for email invitations). | [optional]
 **emails** | [**List&lt;String&gt;**](String.md)| Array of strings for email recipients (for email invitations). | [optional]
 **ccEmail** | [**List&lt;String&gt;**](String.md)| Array of strings for CC email recipients (for email invitations). | [optional]
 **requireEmail** | **Boolean**| Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  | [optional] [default to false]
 **embed** | **Boolean**| Allows user to embed a widget with the share. | [optional] [default to false]
 **isPublic** | **Boolean**| True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. | [optional] [default to false]
 **password** | **String**| If not null, value of password is required to access this share. | [optional]
 **expiration** | **String**| The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. | [optional]
 **hasNotification** | **Boolean**| True if the user should be notified about activity on this share. | [optional] [default to false]
 **notificationEmails** | [**List&lt;String&gt;**](String.md)| An array of recipients who should receive notification emails. | [optional]
 **fileDropCreateFolders** | **Boolean**| If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). | [optional] [default to false]

### Return type

[**ShareResponse**](ShareResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="deleteShare"></a>
# **deleteShare**
> Response deleteShare(apiKey, accessToken, id)

deleteShare

Delete a share. Deleting a share does not remove the underlying files for &#x60;shared_folder&#x60; and &#x60;receive&#x60; share types; it merely removes the access URL. Delating a &#x60;send&#x60; share type does remove the associated files, as files that have been sent are _only_ associated with the share, and aren&#39;t stored anywhere else in the account. &gt; **Notes:**  - Authenticated user&#39;s role must be admin or master, or user must be the owner of the specified share.  

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer id = 56; // Integer | ID of the share to delete. Use <a href=\"#operation/getShares\">getShares</a> if you need to lookup an ID.
try {
    Response result = apiInstance.deleteShare(apiKey, accessToken, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#deleteShare");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **id** | **Integer**| ID of the share to delete. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. |

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getForm"></a>
# **getForm**
> FormResponse getForm(apiKey, accessToken, formId, shareId)

getForm

Get the details of the form defined for a receive folder. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer formId = 56; // Integer | Form ID to retrieve the setup for. Required if `shareId` is null
Integer shareId = 56; // Integer | Share ID to retrieve the form for. Required if `formId` is null
try {
    FormResponse result = apiInstance.getForm(apiKey, accessToken, formId, shareId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#getForm");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **formId** | **Integer**| Form ID to retrieve the setup for. Required if &#x60;shareId&#x60; is null | [optional]
 **shareId** | **Integer**| Share ID to retrieve the form for. Required if &#x60;formId&#x60; is null | [optional]

### Return type

[**FormResponse**](FormResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFormData"></a>
# **getFormData**
> FormDataResponse getFormData(apiKey, accessToken, formId, shareId, offset, limit)

getFormData

Retrieve the data and file paths associated with previous form submissions.  ** Notes: ** - Authenticated user must have ViewFormData permissions 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer formId = 56; // Integer | Unique identier for associated form. Either `formId` or `shareId` is required.
Long shareId = 789L; // Long | Unique share ID (not hash) of receive folder. Either `formId` or `shareId` is required.
Integer offset = 56; // Integer | Used for pagination. Number of entries to \"skip\" before downloading results. Starts at 0.
Integer limit = 56; // Integer | Total number of entries to be downloaded. Default is 50
try {
    FormDataResponse result = apiInstance.getFormData(apiKey, accessToken, formId, shareId, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#getFormData");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **formId** | **Integer**| Unique identier for associated form. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. | [optional]
 **shareId** | **Long**| Unique share ID (not hash) of receive folder. Either &#x60;formId&#x60; or &#x60;shareId&#x60; is required. | [optional]
 **offset** | **Integer**| Used for pagination. Number of entries to \&quot;skip\&quot; before downloading results. Starts at 0. | [optional]
 **limit** | **Integer**| Total number of entries to be downloaded. Default is 50 | [optional]

### Return type

[**FormDataResponse**](FormDataResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getShare"></a>
# **getShare**
> ShareResponse getShare(apiKey, accessToken, id)

getShare

Returns a share object specified by a given share ID.   **Notes:** - Authenticated user should be the owner of the specified share. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer id = 56; // Integer | ID of the requested share. Note this is our internal ID, not the share hash. Use <a href=\"#operation/getShares\">getShares</a> if you need to lookup an ID.
try {
    ShareResponse result = apiInstance.getShare(apiKey, accessToken, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#getShare");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **id** | **Integer**| ID of the requested share. Note this is our internal ID, not the share hash. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. |

### Return type

[**ShareResponse**](ShareResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getShares"></a>
# **getShares**
> SharesResponse getShares(apiKey, accessToken, sortBy, sortOrder, type, filter, include, offset, limit)

getShares

Returns array of all share objects that the authenticated user has access to. Sorting and filtering options allow you to limit the returned list.  **Notes:**  - Authenticated user requires share permission.  - To get share objects with type &#x60;send&#x60;, authenticated user&#39;s role must be admin or master. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String sortBy = "sort_shares_name"; // String | Sort method.
String sortOrder = "asc"; // String | Sort order.
String type = "type_example"; // String | The type of share to return. If no argument specified, will return all shares of all types.
String filter = "filter_example"; // String | Filter by the provided search terms.
String include = "all"; // String | Filter returned shares. You can get all shares in the account, only active ones or shares you own.
Integer offset = 56; // Integer | Start position of results to return, for pagination. Defaults to zero (0).
Integer limit = 56; // Integer | Maximum number of shares to return.
try {
    SharesResponse result = apiInstance.getShares(apiKey, accessToken, sortBy, sortOrder, type, filter, include, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#getShares");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **sortBy** | **String**| Sort method. | [default to sort_shares_name] [enum: sort_shares_name, sort_shares_date, sort_shares_user, sort_shares_access_mode]
 **sortOrder** | **String**| Sort order. | [default to asc] [enum: asc, desc]
 **type** | **String**| The type of share to return. If no argument specified, will return all shares of all types. | [optional] [enum: shared_folder, send, receive]
 **filter** | **String**| Filter by the provided search terms. | [optional]
 **include** | **String**| Filter returned shares. You can get all shares in the account, only active ones or shares you own. | [optional] [default to all] [enum: all, active, current]
 **offset** | **Integer**| Start position of results to return, for pagination. Defaults to zero (0). | [optional]
 **limit** | **Integer**| Maximum number of shares to return. | [optional]

### Return type

[**SharesResponse**](SharesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateForm"></a>
# **updateForm**
> Response1 updateForm(apiKey, updateForm)

updateForm

Update an existing form object 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
UpdateForm updateForm = new UpdateForm(); // UpdateForm | 
try {
    Response1 result = apiInstance.updateForm(apiKey, updateForm);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#updateForm");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **updateForm** | [**UpdateForm**](UpdateForm.md)|  | [optional]

### Return type

[**Response1**](Response1.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="updateShare"></a>
# **updateShare**
> Response updateShare(apiKey, accessToken, id, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders)

updateShare

Update an existing share object by specified ID. Note that it is not possible to change the type of share once it has been created; if you need to (for example) convert a shared folder to a receive folder, you must first delete the shared folder and then create a new receive folder.  **Notes:** - Authenticated user&#39;s role must be admin or master, or the authenticated user must be the owner of the specified share. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ShareApi;


ShareApi apiInstance = new ShareApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer id = 56; // Integer | ID of the share to update. Use <a href=\"#operation/getShares\">getShares</a> if you need to lookup an ID.
String name = "name_example"; // String | Name of the share.
List<String> filePaths = Arrays.asList("filePaths_example"); // List<String> | Array of strings containing the file paths to share.
String accessMode = "accessMode_example"; // String | Type of permissions share recipients have.
String subject = "subject_example"; // String | Share message subject (for email invitations).
String message = "message_example"; // String | Share message contents (for email invitations).
List<String> emails = Arrays.asList("emails_example"); // List<String> | Array of strings for email recipients (for email invitations).
List<String> ccEmail = Arrays.asList("ccEmail_example"); // List<String> | Array of strings for CC email recipients (for email invitations).
Boolean requireEmail = false; // Boolean | Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the `emails` paramater. 
Boolean embed = false; // Boolean | Allows user to embed a widget with the share.
Boolean isPublic = false; // Boolean | True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process.
String password = "password_example"; // String | If not null, value of password is required to access this share.
String expiration = "expiration_example"; // String | The timestamp the current share should expire, formatted `YYYY-mm-dd hh:mm:ss`.
Boolean hasNotification = false; // Boolean | True if the user should be notified about activity on this share.
List<String> notificationEmails = Arrays.asList("notificationEmails_example"); // List<String> | An array of recipients who should receive notification emails.
Boolean fileDropCreateFolders = false; // Boolean | If true, all receive folder submissions will be uploaded separate folders (only applicable for the `receive` share type).
try {
    Response result = apiInstance.updateShare(apiKey, accessToken, id, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ShareApi#updateShare");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **id** | **Integer**| ID of the share to update. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. |
 **name** | **String**| Name of the share. | [optional]
 **filePaths** | [**List&lt;String&gt;**](String.md)| Array of strings containing the file paths to share. | [optional]
 **accessMode** | **String**| Type of permissions share recipients have. | [optional] [enum: upload, download, download_upload, download_upload_modify_delete]
 **subject** | **String**| Share message subject (for email invitations). | [optional]
 **message** | **String**| Share message contents (for email invitations). | [optional]
 **emails** | [**List&lt;String&gt;**](String.md)| Array of strings for email recipients (for email invitations). | [optional]
 **ccEmail** | [**List&lt;String&gt;**](String.md)| Array of strings for CC email recipients (for email invitations). | [optional]
 **requireEmail** | **Boolean**| Requires a user to enter their email address to access. If set true, isPublic must also be set true.  Please note that emails are not validated; we simply log the email in the share activity.  If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.  | [optional] [default to false]
 **embed** | **Boolean**| Allows user to embed a widget with the share. | [optional] [default to false]
 **isPublic** | **Boolean**| True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process. | [optional] [default to false]
 **password** | **String**| If not null, value of password is required to access this share. | [optional]
 **expiration** | **String**| The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. | [optional]
 **hasNotification** | **Boolean**| True if the user should be notified about activity on this share. | [optional] [default to false]
 **notificationEmails** | [**List&lt;String&gt;**](String.md)| An array of recipients who should receive notification emails. | [optional]
 **fileDropCreateFolders** | **Boolean**| If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type). | [optional] [default to false]

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

