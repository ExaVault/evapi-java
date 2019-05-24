# ActivityApi

All URIs are relative to *https://api.exavault.com/v1.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCallbackLogs**](ActivityApi.md#getCallbackLogs) | **GET** /getCallbackLogs | getCallbackLogs
[**getFileActivityLogs**](ActivityApi.md#getFileActivityLogs) | **GET** /getFileActivityLogs | getFileActivityLogs
[**getNotificationActivity**](ActivityApi.md#getNotificationActivity) | **GET** /getNotificationActivity | getNotificationActivity
[**getShareActivity**](ActivityApi.md#getShareActivity) | **GET** /getShareActivity | getShareActivity


<a name="getCallbackLogs"></a>
# **getCallbackLogs**
> CallbackLogResponse getCallbackLogs(apiKey, accessToken, offset, sortBy, sortOrder, itemLimit)

getCallbackLogs

Get the webhooks log from your account. Webhooks logs contain information on all webhooks that have been sent by your account.  **Notes:**  - The authenticated user&#39;s role must be admin or master in order to view callback logs. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActivityApi;


ActivityApi apiInstance = new ActivityApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer offset = 56; // Integer | Starting record in the result set. Can be used for pagination.
String sortBy = "sort_logs_date"; // String | Sort method.
String sortOrder = "desc"; // String | Sort order.
Integer itemLimit = 25; // Integer | Number of logs to return. Can be used for pagination.
try {
    CallbackLogResponse result = apiInstance.getCallbackLogs(apiKey, accessToken, offset, sortBy, sortOrder, itemLimit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivityApi#getCallbackLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **offset** | **Integer**| Starting record in the result set. Can be used for pagination. | [optional]
 **sortBy** | **String**| Sort method. | [optional] [default to sort_logs_date] [enum: sort_logs_date, sort_logs_endpoint_url, sort_logs_event, sort_logs_status, sort_logs_attempt, sort_logs_response_size]
 **sortOrder** | **String**| Sort order. | [optional] [default to desc] [enum: desc, asc]
 **itemLimit** | **Integer**| Number of logs to return. Can be used for pagination. | [optional] [default to 25]

### Return type

[**CallbackLogResponse**](CallbackLogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFileActivityLogs"></a>
# **getFileActivityLogs**
> LogResponse getFileActivityLogs(apiKey, accessToken, offset, sortBy, sortOrder, filterBy, filter, itemLimit)

getFileActivityLogs

Get the activity log from your account. Activity logs contain information on all operations in your account &amp;ndash; connecting, uploading and downloading files, sharing, setting up notifications, and more. You can use different filter and sorting options to get the exact data you need.  **Notes:**  - The authenticated user&#39;s role must be admin or master in order to pull activity logs. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActivityApi;


ActivityApi apiInstance = new ActivityApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer offset = 56; // Integer | Starting record in the result set. Can be used for pagination.
String sortBy = "sort_logs_date"; // String | Sort method.
String sortOrder = "desc"; // String | Sort order.
String filterBy = "filterBy_example"; // String | Field to search on
String filter = "filter_example"; // String | Search criteria. For date ranges, use format 'start_date::end_date'.
Integer itemLimit = 25; // Integer | Number of logs to return. Can be used for pagination.
try {
    LogResponse result = apiInstance.getFileActivityLogs(apiKey, accessToken, offset, sortBy, sortOrder, filterBy, filter, itemLimit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivityApi#getFileActivityLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **offset** | **Integer**| Starting record in the result set. Can be used for pagination. | [optional]
 **sortBy** | **String**| Sort method. | [optional] [default to sort_logs_date] [enum: sort_logs_date, sort_logs_ip_address, sort_logs_username, sort_logs_file, sort_logs_file_source, sort_logs_operation, sort_logs_duration, sort_logs_size, sort_logs_protocol]
 **sortOrder** | **String**| Sort order. | [optional] [default to desc] [enum: desc, asc]
 **filterBy** | **String**| Field to search on | [optional] [enum: filter_logs_date, filter_logs_ip_address, filter_logs_username, filter_logs_operation, filter_logs_file]
 **filter** | **String**| Search criteria. For date ranges, use format &#39;start_date::end_date&#39;. | [optional]
 **itemLimit** | **Integer**| Number of logs to return. Can be used for pagination. | [optional] [default to 25]

### Return type

[**LogResponse**](LogResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNotificationActivity"></a>
# **getNotificationActivity**
> NotificationActivityResponse getNotificationActivity(apiKey, accessToken)

getNotificationActivity

Get all notification messages for the authenticated user. Notification messages are only recorded if a notification has been setup for a folder, and an action is taken (e.g. a file upload) in the given folder.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActivityApi;


ActivityApi apiInstance = new ActivityApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
try {
    NotificationActivityResponse result = apiInstance.getNotificationActivity(apiKey, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivityApi#getNotificationActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |

### Return type

[**NotificationActivityResponse**](NotificationActivityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getShareActivity"></a>
# **getShareActivity**
> ShareActivityResponse getShareActivity(apiKey, accessToken, id)

getShareActivity

Get all share activity for the specified share ID. Share activity includes anything which happened on the share in question &amp;ndash; for example, a user being invited or a user connecting and downloading files.  **Notes:**  - Authenticated user must be the owner of the specified share. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ActivityApi;


ActivityApi apiInstance = new ActivityApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Integer id = 56; // Integer | ID of the share. Use <a href=\"#operation/getShares\">getShares</a> if you need to lookup an ID.
try {
    ShareActivityResponse result = apiInstance.getShareActivity(apiKey, accessToken, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivityApi#getShareActivity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **id** | **Integer**| ID of the share. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID. |

### Return type

[**ShareActivityResponse**](ShareActivityResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

