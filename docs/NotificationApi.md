# NotificationApi

All URIs are relative to *https://api.exavault.com/v1.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createNotification**](NotificationApi.md#createNotification) | **POST** /createNotification | createNotification
[**deleteNotification**](NotificationApi.md#deleteNotification) | **GET** /deleteNotification | deleteNotification
[**getNotification**](NotificationApi.md#getNotification) | **GET** /getNotification | getNotification
[**getNotifications**](NotificationApi.md#getNotifications) | **GET** /getNotifications | getNotifications
[**updateNotification**](NotificationApi.md#updateNotification) | **POST** /updateNotification | updateNotification


<a name="createNotification"></a>
# **createNotification**
> NotificationResponse createNotification(apiKey, accessToken, type, path, action, usernames, sendEmail, emails)

createNotification

Create a new notification for the given path in the current account. Notifications can be sent via email or webhook. To enable email, pass an array of email addresses to the &#x60;emails&#x60; parameter of this call. To enable webhooks, setup the webhook callback URL in your account settings.   **Notes:** - Authenticated user requires notification permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NotificationApi;


NotificationApi apiInstance = new NotificationApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String type = "type_example"; // String | Type of resource you're setting the notification on.
String path = "path_example"; // String | Full path of file/folder where the notification is set.
String action = "action_example"; // String | Type of action to filter on. Notifications will only be fired for the given type of action.
List<String> usernames = Arrays.asList("usernames_example"); // List<String> | Determines which users should trigger the notification. Either one of the values above, or an array of usernames.
Boolean sendEmail = true; // Boolean | Set to true if the user should be notified by email when the notification is triggered.
List<String> emails = Arrays.asList("emails_example"); // List<String> | Email addresses to send the notification to. If not specified, sends to the authenticated user.
try {
    NotificationResponse result = apiInstance.createNotification(apiKey, accessToken, type, path, action, usernames, sendEmail, emails);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationApi#createNotification");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **type** | **String**| Type of resource you&#39;re setting the notification on. | [enum: file, folder]
 **path** | **String**| Full path of file/folder where the notification is set. |
 **action** | **String**| Type of action to filter on. Notifications will only be fired for the given type of action. | [enum: upload, download, delete, all]
 **usernames** | [**List&lt;String&gt;**](String.md)| Determines which users should trigger the notification. Either one of the values above, or an array of usernames. |
 **sendEmail** | **Boolean**| Set to true if the user should be notified by email when the notification is triggered. |
 **emails** | [**List&lt;String&gt;**](String.md)| Email addresses to send the notification to. If not specified, sends to the authenticated user. | [optional]

### Return type

[**NotificationResponse**](NotificationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="deleteNotification"></a>
# **deleteNotification**
> Response deleteNotification(apiKey, accessToken, id)

deleteNotification

Deletes the specified notification. Note that deleting a notification _only_ deletes the notification &amp;ndash; it does not delete any underlying files or folders. &gt; **Notes:** - Authenticated usee requires notification permission.  - Authenticated user should be the owner of the specified notification. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NotificationApi;


NotificationApi apiInstance = new NotificationApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer id = 56; // Integer | ID of the notification to delete. Use <a href=\"#operation/getNotifications\">getNotifications</a> if you need to lookup an ID.
try {
    Response result = apiInstance.deleteNotification(apiKey, accessToken, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationApi#deleteNotification");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **id** | **Integer**| ID of the notification to delete. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. |

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNotification"></a>
# **getNotification**
> NotificationResponse getNotification(apiKey, accessToken, id)

getNotification

Returns the specified notification object.  **Notes:** - Authenticated user should be the owner of the specified notification 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NotificationApi;


NotificationApi apiInstance = new NotificationApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer id = 56; // Integer | ID of the notification. Use <a href=\"#operation/getNotifications\">getNotifications</a> if you need to lookup an ID.
try {
    NotificationResponse result = apiInstance.getNotification(apiKey, accessToken, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationApi#getNotification");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **id** | **Integer**| ID of the notification. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. |

### Return type

[**NotificationResponse**](NotificationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNotifications"></a>
# **getNotifications**
> NotificationsResponse getNotifications(apiKey, accessToken, type, sortBy, sortOrder, filter)

getNotifications

Returns array of all notification objects owned by the authenticated user. You can use sorting and filtering to limit the returned list.  **Notes:** - Autheticated user should have notification permission 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NotificationApi;


NotificationApi apiInstance = new NotificationApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String type = "type_example"; // String | Type of notification to filter on.
String sortBy = "sort_notifications_folder_name"; // String | Sort method.
String sortOrder = "asc"; // String | Sort order.
String filter = "filter_example"; // String | Filter by the provided search terms.
try {
    NotificationsResponse result = apiInstance.getNotifications(apiKey, accessToken, type, sortBy, sortOrder, filter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationApi#getNotifications");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **type** | **String**| Type of notification to filter on. | [enum: file, folder, shared_folder, send_receipt, share_receipt, file_drop]
 **sortBy** | **String**| Sort method. | [optional] [default to sort_notifications_folder_name] [enum: sort_notifications_folder_name, sort_notifications_path, sort_notifications_date]
 **sortOrder** | **String**| Sort order. | [optional] [default to asc] [enum: asc, desc]
 **filter** | **String**| Filter by the provided search terms. | [optional]

### Return type

[**NotificationsResponse**](NotificationsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateNotification"></a>
# **updateNotification**
> Response updateNotification(apiKey, updateNotification)

updateNotification

Update an existing notification object.  **Notes:** - Authenticated user should have notification permission.  - Authenticated user should be the owner of the specified notification. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NotificationApi;


NotificationApi apiInstance = new NotificationApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
UpdateNotification updateNotification = new UpdateNotification(); // UpdateNotification | 
try {
    Response result = apiInstance.updateNotification(apiKey, updateNotification);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationApi#updateNotification");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **updateNotification** | [**UpdateNotification**](UpdateNotification.md)|  | [optional]

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

