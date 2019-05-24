# UserApi

All URIs are relative to *https://api.exavault.com/v1.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](UserApi.md#createUser) | **POST** /createUser | createUser
[**deleteUser**](UserApi.md#deleteUser) | **GET** /deleteUser | deleteUser
[**getAccount**](UserApi.md#getAccount) | **GET** /getAccount | getAccount
[**getCurrentUser**](UserApi.md#getCurrentUser) | **GET** /getCurrentUser | getCurrentUser
[**getUser**](UserApi.md#getUser) | **GET** /getUser | getUser
[**getUsers**](UserApi.md#getUsers) | **GET** /getUsers | getUsers
[**resendWelcomeEmail**](UserApi.md#resendWelcomeEmail) | **GET** /resendWelcomeEmail | resendWelcomeEmail
[**updateUser**](UserApi.md#updateUser) | **POST** /updateUser | updateUser
[**userAvailable**](UserApi.md#userAvailable) | **GET** /userAvailable | userAvailable


<a name="createUser"></a>
# **createUser**
> Response createUser(apiKey, accessToken, username, destinationFolder, email, password, role, permissions, timeZone, nickname, expiration, locked, welcomeEmail, onboarding)

createUser

Adds a new user to the account. The user may be configured as an admin or standard user, and (if a standard user) may be assigned a restricted home directory and restricted permissions.  &gt; **Notes:** - Authenticated user&#39;s role must be admin or master; standard users are not allowed to create other users. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String username = "username_example"; // String | Username of the user to create. This should follow standard username conventions; e.g. all lowercase, no spaces, etc. We do allow email addresses as usernames.
String destinationFolder = "destinationFolder_example"; // String | The path to the user's home folder. For the account root, specify `/`. Otherwise, use standard Unix path format, e.g. `/path/to/some/dir`. The user will be locked to this directory and unable to move 'up' in the account. If the folder does not exist in the account, it will be created. Note that users with the role `admin` cannot have a folder other than `/`.
String email = "email_example"; // String | The user's email address.
String password = "password_example"; // String | The user's password.
String role = "role_example"; // String | The user's role. Note that admin users cannot have a `destinationFolder` other than `/`, and will be setup with full permissions regardless of what you specify in the `permissions` property.
String permissions = "permissions_example"; // String | A CSV string of user permissions. For example: `upload,download,list`. Note that users will be unable to see any files in the account unless you include `list` permission.  
String timeZone = "timeZone_example"; // String | The user's timezone, used for accurate time display within the application. See <a href='https://php.net/manual/en/timezones.php' target='blank'>this page</a> for allowed values. 
String nickname = "nickname_example"; // String | An optional nickname (e.g. 'David from Sales').
String expiration = "expiration_example"; // String | Optional timestamp when the user should expire, formatted `YYYY-mm-dd hh:mm:ss`.
Boolean locked = false; // Boolean | If true, the user's account is locked by default. Locked users cannot log in.
Boolean welcomeEmail = false; // Boolean | If `true`, send a user email upon creation. The default welcome email can be configured from the settings page in your account.
Boolean onboarding = false; // Boolean | If `true`, enable extra help popups in the web application for this user.
try {
    Response result = apiInstance.createUser(apiKey, accessToken, username, destinationFolder, email, password, role, permissions, timeZone, nickname, expiration, locked, welcomeEmail, onboarding);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **username** | **String**| Username of the user to create. This should follow standard username conventions; e.g. all lowercase, no spaces, etc. We do allow email addresses as usernames. |
 **destinationFolder** | **String**| The path to the user&#39;s home folder. For the account root, specify &#x60;/&#x60;. Otherwise, use standard Unix path format, e.g. &#x60;/path/to/some/dir&#x60;. The user will be locked to this directory and unable to move &#39;up&#39; in the account. If the folder does not exist in the account, it will be created. Note that users with the role &#x60;admin&#x60; cannot have a folder other than &#x60;/&#x60;. |
 **email** | **String**| The user&#39;s email address. |
 **password** | **String**| The user&#39;s password. |
 **role** | **String**| The user&#39;s role. Note that admin users cannot have a &#x60;destinationFolder&#x60; other than &#x60;/&#x60;, and will be setup with full permissions regardless of what you specify in the &#x60;permissions&#x60; property. | [enum: user, admin]
 **permissions** | **String**| A CSV string of user permissions. For example: &#x60;upload,download,list&#x60;. Note that users will be unable to see any files in the account unless you include &#x60;list&#x60; permission.   | [enum: upload, download, delete, modify, list, changePassword, share, notification, viewFormData, deleteFormData]
 **timeZone** | **String**| The user&#39;s timezone, used for accurate time display within the application. See &lt;a href&#x3D;&#39;https://php.net/manual/en/timezones.php&#39; target&#x3D;&#39;blank&#39;&gt;this page&lt;/a&gt; for allowed values.  |
 **nickname** | **String**| An optional nickname (e.g. &#39;David from Sales&#39;). | [optional]
 **expiration** | **String**| Optional timestamp when the user should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. | [optional]
 **locked** | **Boolean**| If true, the user&#39;s account is locked by default. Locked users cannot log in. | [optional] [default to false]
 **welcomeEmail** | **Boolean**| If &#x60;true&#x60;, send a user email upon creation. The default welcome email can be configured from the settings page in your account. | [optional] [default to false]
 **onboarding** | **Boolean**| If &#x60;true&#x60;, enable extra help popups in the web application for this user. | [optional] [default to false]

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="deleteUser"></a>
# **deleteUser**
> Response deleteUser(apiKey, accessToken, username)

deleteUser

Delete a user from the account. Deleting a user does **NOT** delete any files from the account; it merely removes a user&#39;s access. If you also need to delete the user&#39;s home folder or data when you delete the user, you should make a separate call to &lt;a href&#x3D;\&quot;#operation/deleteResources\&quot;&gt;deleteResources&lt;/a&gt;. &gt; **Notes:** - Authenticated user&#39;s role must be admin or master 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String username = "username_example"; // String | Username of the user to delete.
try {
    Response result = apiInstance.deleteUser(apiKey, accessToken, username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#deleteUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **username** | **String**| Username of the user to delete. |

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAccount"></a>
# **getAccount**
> AccountResponse getAccount(apiKey, accessToken)

getAccount

Gets the account object and master user object for the authenticated user. Useful if you need to lookup or display information about the the account. If you need information the user you&#39;re logged in as, rather than the account and master user, see &lt;a href&#x3D;\&quot;#operation/getCurrentUser\&quot;&gt;getCurrentUser&lt;/a&gt;. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
try {
    AccountResponse result = apiInstance.getAccount(apiKey, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getAccount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |

### Return type

[**AccountResponse**](AccountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCurrentUser"></a>
# **getCurrentUser**
> UserResponse getCurrentUser(apiKey, accessToken)

getCurrentUser

Gets the user object for the authenticated user. The user object contains detailed information on the user &amp;ndash; the creation timestamp, username, nickname, associated email, and more. See the response sample, below, for full details.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
try {
    UserResponse result = apiInstance.getCurrentUser(apiKey, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getCurrentUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUser"></a>
# **getUser**
> UserResponse getUser(apiKey, accessToken, username)

getUser

Get details on the specified user from your account. The user object contains detailed information on the user &amp;ndash; the creation timestamp, username, nickname, associated email, and more. See the response sample, below, for full details.  **Notes:** - Authenticated user&#39;s role must be admin or master. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String username = "username_example"; // String | Username of the user to get.
try {
    UserResponse result = apiInstance.getUser(apiKey, accessToken, username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **username** | **String**| Username of the user to get. |

### Return type

[**UserResponse**](UserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsers"></a>
# **getUsers**
> UsersResponse getUsers(apiKey, accessToken, sortBy, sortOrder)

getUsers

Gets array of all user objects in your account. Each element of the array will contain details on a single user.  **Notes:** - Authenticated user&#39;s role must be admin or master. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String sortBy = "sort_users_username"; // String | Sort method for the returned array.
String sortOrder = "asc"; // String | Sort order for the returned array.
try {
    UsersResponse result = apiInstance.getUsers(apiKey, accessToken, sortBy, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#getUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **sortBy** | **String**| Sort method for the returned array. | [default to sort_users_username] [enum: sort_users_username, sort_users_nickname, sort_users_email, sort_users_home_folder]
 **sortOrder** | **String**| Sort order for the returned array. | [optional] [default to asc] [enum: asc, desc]

### Return type

[**UsersResponse**](UsersResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="resendWelcomeEmail"></a>
# **resendWelcomeEmail**
> ResendWelcomeEmailResponse resendWelcomeEmail(apiKey, accessToken, username)

resendWelcomeEmail

Send a welcome email for the user. The text of the welcome email can be configured from the settings page in your account.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String username = "username_example"; // String | Username of the user that will receive the welcome email.
try {
    ResendWelcomeEmailResponse result = apiInstance.resendWelcomeEmail(apiKey, accessToken, username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#resendWelcomeEmail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **username** | **String**| Username of the user that will receive the welcome email. |

### Return type

[**ResendWelcomeEmailResponse**](ResendWelcomeEmailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateUser"></a>
# **updateUser**
> Response updateUser(apiKey, accessToken, userId, username, nickname, destinationFolder, email, password, role, permissions, onboarding, timeZone, expiration, locked)

updateUser

Updates specified user record in your account. Note that the unique key for this API call is our internal ID, and _not_ the username, as the username can be changed.   &gt; **Notes:** - Authenticated user&#39;s role must be admin or master. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer userId = 56; // Integer | The user's ID. Note that this is our internal ID, and _not the username_. You can obtain it by calling the <a href=\"#operation/getUser\">getUser</a> method.
String username = "username_example"; // String | Username of the user to create. This should follow standard username conventions; e.g. all lowercase, no spaces, etc. We do allow email addresses as usernames.
String nickname = "nickname_example"; // String | An optional nickname (e.g. 'David from Sales').
String destinationFolder = "destinationFolder_example"; // String | The path to the user's home folder. For the account root, specify `/`. Otherwise, use standard Unix path format, e.g. `/path/to/some/dir`. The user will be locked to this directory and unable to move 'up' in the account. Note that users with the role `admin` must have the `/` destinationFolder
String email = "email_example"; // String | The user's email address.
String password = "password_example"; // String | The user's password.
String role = "role_example"; // String | The user's role. Note that admin users cannot have a `destinationFolder` other than `/`, and will be setup with full permissions regardless of what you specify in the `permissions` property.
String permissions = "permissions_example"; // String | A CSV string of user permissions. For example: `upload,download,list`. Note that users will be unable to see any files in the account unless you include `list` permission. 
Boolean onboarding = true; // Boolean | Flag to indicate whether extra help popups should be enabled when this user logs into the web application. 
String timeZone = "timeZone_example"; // String | The user's timezone, used for accurate time display within the application. See <a href='https://php.net/manual/en/timezones.php' target='blank'>this page</a> for allowed values. 
String expiration = "expiration_example"; // String | Optional timestamp when the user should expire, formatted `YYYY-mm-dd hh:mm:ss`.
Boolean locked = false; // Boolean | If true, the user's account is locked by default.
try {
    Response result = apiInstance.updateUser(apiKey, accessToken, userId, username, nickname, destinationFolder, email, password, role, permissions, onboarding, timeZone, expiration, locked);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#updateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **userId** | **Integer**| The user&#39;s ID. Note that this is our internal ID, and _not the username_. You can obtain it by calling the &lt;a href&#x3D;\&quot;#operation/getUser\&quot;&gt;getUser&lt;/a&gt; method. |
 **username** | **String**| Username of the user to create. This should follow standard username conventions; e.g. all lowercase, no spaces, etc. We do allow email addresses as usernames. | [optional]
 **nickname** | **String**| An optional nickname (e.g. &#39;David from Sales&#39;). | [optional]
 **destinationFolder** | **String**| The path to the user&#39;s home folder. For the account root, specify &#x60;/&#x60;. Otherwise, use standard Unix path format, e.g. &#x60;/path/to/some/dir&#x60;. The user will be locked to this directory and unable to move &#39;up&#39; in the account. Note that users with the role &#x60;admin&#x60; must have the &#x60;/&#x60; destinationFolder | [optional]
 **email** | **String**| The user&#39;s email address. | [optional]
 **password** | **String**| The user&#39;s password. | [optional]
 **role** | **String**| The user&#39;s role. Note that admin users cannot have a &#x60;destinationFolder&#x60; other than &#x60;/&#x60;, and will be setup with full permissions regardless of what you specify in the &#x60;permissions&#x60; property. | [optional] [enum: user, admin]
 **permissions** | **String**| A CSV string of user permissions. For example: &#x60;upload,download,list&#x60;. Note that users will be unable to see any files in the account unless you include &#x60;list&#x60; permission.  | [optional] [enum: upload, download, delete, modify, list, changePassword, share, notification, viewFormData, deleteFormData]
 **onboarding** | **Boolean**| Flag to indicate whether extra help popups should be enabled when this user logs into the web application.  | [optional]
 **timeZone** | **String**| The user&#39;s timezone, used for accurate time display within the application. See &lt;a href&#x3D;&#39;https://php.net/manual/en/timezones.php&#39; target&#x3D;&#39;blank&#39;&gt;this page&lt;/a&gt; for allowed values.  | [optional]
 **expiration** | **String**| Optional timestamp when the user should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;. | [optional]
 **locked** | **Boolean**| If true, the user&#39;s account is locked by default. | [optional] [default to false]

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="userAvailable"></a>
# **userAvailable**
> AvailableUserResponse userAvailable(apiKey, accessToken, username)

userAvailable

Returns true if requested username has not already been taken in the system. Note that usernames are global in our system; if one account has claimed the username &#39;bobsmith&#39; then no other account may use that username.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String username = "username_example"; // String | Username to check.
try {
    AvailableUserResponse result = apiInstance.userAvailable(apiKey, accessToken, username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#userAvailable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **username** | **String**| Username to check. |

### Return type

[**AvailableUserResponse**](AvailableUserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

