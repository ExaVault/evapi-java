# AuthenticationApi

All URIs are relative to *https://api.exavault.com/v1.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**authenticateUser**](AuthenticationApi.md#authenticateUser) | **POST** /authenticateUser | authenticateUser
[**logoutUser**](AuthenticationApi.md#logoutUser) | **POST** /logoutUser | logoutUser


<a name="authenticateUser"></a>
# **authenticateUser**
> AuthResponse authenticateUser(apiKey, username, password)

authenticateUser

Before calling any other API methods, you must first authenticate to the API.  Call this method to get an accessToken, and then pass this token back to each API call. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthenticationApi;


AuthenticationApi apiInstance = new AuthenticationApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String username = "username_example"; // String | Name of the user to authenticate.
String password = "password_example"; // String | User's password.
try {
    AuthResponse result = apiInstance.authenticateUser(apiKey, username, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationApi#authenticateUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **username** | **String**| Name of the user to authenticate. |
 **password** | **String**| User&#39;s password. |

### Return type

[**AuthResponse**](AuthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="logoutUser"></a>
# **logoutUser**
> Response logoutUser(apiKey, accessToken)

logoutUser

Invalidate a user&#39;s access token, rendering it unable to make further API calls.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthenticationApi;


AuthenticationApi apiInstance = new AuthenticationApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
try {
    Response result = apiInstance.logoutUser(apiKey, accessToken);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationApi#logoutUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

