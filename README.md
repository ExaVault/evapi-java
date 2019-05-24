# swagger-java-client

ExaVault API
- API version: 1.2
  - Build date: 2019-05-20T15:12:25.985Z

# Introduction  

Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications. Our API supports both GET and POST operations.  

Capabilities of the API include:  

- Uploading and downloading files. 
- Managing files and folders; including standard operations like move, copy and delete. 
- Getting information about activity occuring in your account. 
- Creating, updating and deleting users. 
- Creating and managing shares, including download-only shares and receive folders.  
- Setting up and managing notifications.  

## The API Endpoint  

The ExaVault API is located at: https://api.exavault.com/v1.2/  

## Obtain Your API Key  
You will need to obtain an API key to connect to the API. To do this, follow the instructions below.   

+ Log into your account through the usual way, or use https://app.exavault.com.  
+ Click the Gear icon to access the account settings  
+ Locate the Developer tab in the account settings  
+ Click the link for *Manage API Keys*  
+ You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.  *NOTE: You must have admin or master permissions to create an API key for your account. If you do not have access to developer settings for your account, contact your account administrator to create an API key for you.  

# Testing w/ Postman  
We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Introduction/Obtain-Your-API-Key) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"07891ce73cc525084ceb\"></div>  ![ExaVault API Postman Colletion Usage](/images/postman.png)  If you'd prefer to skip Postman and start working with code directly, take a look at the sample code below.    

# Code Libraries & Sample PHP Code  
Once you're ready for full-scale development, we recommend looking at our code libraries available on [GitHub](https://github.com/ExaVault). We offer code libraries for [Python](https://github.com/ExaVault/evapi-python), [PHP](https://github.com/ExaVault/evapi-php), [JavaScript](https://github.com/ExaVault/evapi-javascript) and [Java](https://github.com/ExaVault/evapi-java).  While we recommend using our libraries, you're welcome to interact directly with our API via HTTP GET and POST requests -- a great option particularly if you're developing in a language for which we don't yet have sample code.     - [Download Python Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-python) - [Download PHP Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-php) - [Download JavaScript Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-javascript) - [Download Java Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-java)  *Note: You can generate client libraries for any language using [Swagger Editor](http://editor2.swagger.io/). Just download our documentation file, past it into editor and use 'Generate Client' dropdown.*  

# Status Codes  
The ExaVault API returns only two HTTP status codes for its responses: 200 and 500.  When the request could be successfully processed by the endpoint, the response status code will be 200, regardless of whether the requested action could be taken.  For example, the response to a getUser request for a username that does not exist in your account would have the status of 200,  indicating that the response was received and processed, but the error member of the returned response object would contain object with `message` and `code` properties.  

**Result Format:**  
|Success   | Error     | Results   | 
| ---      | :---:       |  :---:      | 
| 0        |  `Object` |   Empty   | 
| 1        |   Empty       |    `Object` or `Array`        |     

When a malformed request is received, a 500 HTTP status code will be returned, indicating that the request could not be processed.  ExaVault's API does not currently support traditional REST response codes such as '201 Created' or '405 Method Not Allowed'.  

# File Paths  
Many API calls require you to provide one or more file paths. For example, the <a href=\"#operation/moveResources\">moveResources</a> call requires both an array of source paths, **filePaths**, and a destination path, **destinationPath**. Here's a few tips for working with paths:   

- File paths should always be specified as a string, using the standard Unix format: e.g. `/path/to/a/file.txt`  
- File paths are always absolute _from the home directory of the logged in user_. For example, if the user **bob** had a home directory restriction of `/bob_home`, then an API call made using his login would specify a file as `/myfile.txt`, whereas an API call made using the master user ( no home directory restriction ) would specify the same file as `/bob_home/myfile.txt`.  

# API Rate Limits  
We rate limit the number of API calls you can make to help prevent abuse and protect system stablity. Each API key will support 500 requests per rolling five minutes. If you make more than 500 requests in a five minute period, you will receive a response with an error object for fifteen minutes.  

# Webhooks  
A webhook is an HTTP callback: a simple event-notification via HTTP POST. If you define webhooks for Exavault, ExaVault will POST a  message to a URL when certain things happen.     Webhooks can be used to receive a JSON object to your endpoint URL. You choose what events will trigger webhook messages to your endpoint URL.     Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log.  

## Getting Started  

1. Go to the Account tab inside the web application.  
2. Choose the Developer tab.  
3. Configure your endpoint URL and select the events you want to trigger webhook messages.  
4. Save settings.    

You are all set to receive webhook callbacks on the events you selected.  

## Verification Signature  
ExaVault includes a custom HTTP header, X-Exavault-Signature, with webhooks POST requests which will contain the signature for the request.  You can use the signature to verify the request for an additional level of security.  

## Generating the Signature  

1. Go to Account tab inside the web application.  
2. Choose the Developer tab.  
3. Obtain the verification token. This field will only be shown if you've configured your endpoint URL.  
4. In your code that receives or processes the webhooks, you should concatenate the verification token with the response string and hash it with md5.     ```     md5($verificationToken.$responseString);     ```  
5. Compare signature that you generated to the signature provided in the X-Exavault-Signature HTTP header  

## Example JSON Response Object  
```json   {     \"accountname\": \"mycompanyname\",     \"username\": \"john\"     \"operation\": \"Upload\",     \"protocol\": \"https\",     \"path\": \"/testfolder/filename.jpg\"     \"attempt\": 1   } ```  

## Webhooks Logs  
Keep track of all your webhooks requests in the Activity section of your account. You can find the following info for each request:    

1. date and time - timestamp of the request.    
2. endpoint url - where the webhook was sent.    
3. event - what triggered the webhook.    
4. status - HTTP status or curl error code.    
5. attempt - how many times we tried to send this request.    
6. response size - size of the response from your server.    
7. details - you can check the response body if it was sent. 


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/swagger-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.ActivityApi;

import java.io.File;
import java.util.*;

public class ActivityApiExample {

    public static void main(String[] args) {
        
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
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.exavault.com/v1.2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ActivityApi* | [**getCallbackLogs**](docs/ActivityApi.md#getCallbackLogs) | **GET** /getCallbackLogs | getCallbackLogs
*ActivityApi* | [**getFileActivityLogs**](docs/ActivityApi.md#getFileActivityLogs) | **GET** /getFileActivityLogs | getFileActivityLogs
*ActivityApi* | [**getNotificationActivity**](docs/ActivityApi.md#getNotificationActivity) | **GET** /getNotificationActivity | getNotificationActivity
*ActivityApi* | [**getShareActivity**](docs/ActivityApi.md#getShareActivity) | **GET** /getShareActivity | getShareActivity
*AuthenticationApi* | [**authenticateUser**](docs/AuthenticationApi.md#authenticateUser) | **POST** /authenticateUser | authenticateUser
*AuthenticationApi* | [**logoutUser**](docs/AuthenticationApi.md#logoutUser) | **POST** /logoutUser | logoutUser
*FilesAndFoldersApi* | [**checkFilesExist**](docs/FilesAndFoldersApi.md#checkFilesExist) | **GET** /checkFilesExist | checkFilesExist
*FilesAndFoldersApi* | [**compressFiles**](docs/FilesAndFoldersApi.md#compressFiles) | **POST** /compressFiles | compressFiles
*FilesAndFoldersApi* | [**copyResources**](docs/FilesAndFoldersApi.md#copyResources) | **POST** /copyResources | copyResources
*FilesAndFoldersApi* | [**createFolder**](docs/FilesAndFoldersApi.md#createFolder) | **POST** /createFolder | createFolder
*FilesAndFoldersApi* | [**deleteResources**](docs/FilesAndFoldersApi.md#deleteResources) | **GET** /deleteResources | deleteResources
*FilesAndFoldersApi* | [**extractFiles**](docs/FilesAndFoldersApi.md#extractFiles) | **POST** /extractFiles | extractFiles
*FilesAndFoldersApi* | [**getDownloadFileUrl**](docs/FilesAndFoldersApi.md#getDownloadFileUrl) | **GET** /getDownloadFileUrl | getDownloadFileUrl
*FilesAndFoldersApi* | [**getFolders**](docs/FilesAndFoldersApi.md#getFolders) | **GET** /getFolders | getFolders
*FilesAndFoldersApi* | [**getPageCount**](docs/FilesAndFoldersApi.md#getPageCount) | **GET** /getPageCount | getPageCount
*FilesAndFoldersApi* | [**getResourceList**](docs/FilesAndFoldersApi.md#getResourceList) | **GET** /getResourceList | getResourceList
*FilesAndFoldersApi* | [**getResourceProperties**](docs/FilesAndFoldersApi.md#getResourceProperties) | **GET** /getResourceProperties | getResourceProperties
*FilesAndFoldersApi* | [**getUploadFileUrl**](docs/FilesAndFoldersApi.md#getUploadFileUrl) | **GET** /getUploadFileUrl | getUploadFileUrl
*FilesAndFoldersApi* | [**moveResources**](docs/FilesAndFoldersApi.md#moveResources) | **POST** /moveResources | moveResources
*FilesAndFoldersApi* | [**previewFile**](docs/FilesAndFoldersApi.md#previewFile) | **GET** /previewFile | previewFile
*FilesAndFoldersApi* | [**renameResource**](docs/FilesAndFoldersApi.md#renameResource) | **POST** /renameResource | renameResource
*NotificationApi* | [**createNotification**](docs/NotificationApi.md#createNotification) | **POST** /createNotification | createNotification
*NotificationApi* | [**deleteNotification**](docs/NotificationApi.md#deleteNotification) | **GET** /deleteNotification | deleteNotification
*NotificationApi* | [**getNotification**](docs/NotificationApi.md#getNotification) | **GET** /getNotification | getNotification
*NotificationApi* | [**getNotifications**](docs/NotificationApi.md#getNotifications) | **GET** /getNotifications | getNotifications
*NotificationApi* | [**updateNotification**](docs/NotificationApi.md#updateNotification) | **POST** /updateNotification | updateNotification
*ShareApi* | [**addFormData**](docs/ShareApi.md#addFormData) | **POST** /addFormData | addFormData
*ShareApi* | [**createShare**](docs/ShareApi.md#createShare) | **POST** /createShare | createShare
*ShareApi* | [**deleteShare**](docs/ShareApi.md#deleteShare) | **GET** /deleteShare | deleteShare
*ShareApi* | [**getForm**](docs/ShareApi.md#getForm) | **GET** /getForm | getForm
*ShareApi* | [**getFormData**](docs/ShareApi.md#getFormData) | **GET** /getFormData | getFormData
*ShareApi* | [**getShare**](docs/ShareApi.md#getShare) | **GET** /getShare | getShare
*ShareApi* | [**getShares**](docs/ShareApi.md#getShares) | **GET** /getShares | getShares
*ShareApi* | [**updateForm**](docs/ShareApi.md#updateForm) | **POST** /updateForm | updateForm
*ShareApi* | [**updateShare**](docs/ShareApi.md#updateShare) | **POST** /updateShare | updateShare
*UserApi* | [**createUser**](docs/UserApi.md#createUser) | **POST** /createUser | createUser
*UserApi* | [**deleteUser**](docs/UserApi.md#deleteUser) | **GET** /deleteUser | deleteUser
*UserApi* | [**getAccount**](docs/UserApi.md#getAccount) | **GET** /getAccount | getAccount
*UserApi* | [**getCurrentUser**](docs/UserApi.md#getCurrentUser) | **GET** /getCurrentUser | getCurrentUser
*UserApi* | [**getUser**](docs/UserApi.md#getUser) | **GET** /getUser | getUser
*UserApi* | [**getUsers**](docs/UserApi.md#getUsers) | **GET** /getUsers | getUsers
*UserApi* | [**resendWelcomeEmail**](docs/UserApi.md#resendWelcomeEmail) | **GET** /resendWelcomeEmail | resendWelcomeEmail
*UserApi* | [**updateUser**](docs/UserApi.md#updateUser) | **POST** /updateUser | updateUser
*UserApi* | [**userAvailable**](docs/UserApi.md#userAvailable) | **GET** /userAvailable | userAvailable


## Documentation for Models

 - [Account](docs/Account.md)
 - [AccountResponse](docs/AccountResponse.md)
 - [Auth](docs/Auth.md)
 - [AuthResponse](docs/AuthResponse.md)
 - [AvailableUser](docs/AvailableUser.md)
 - [AvailableUserResponse](docs/AvailableUserResponse.md)
 - [CallbackLogEntry](docs/CallbackLogEntry.md)
 - [CallbackLogResponse](docs/CallbackLogResponse.md)
 - [CallbackSettings](docs/CallbackSettings.md)
 - [CompressFilesResponse](docs/CompressFilesResponse.md)
 - [DeletedResource](docs/DeletedResource.md)
 - [DeletedResourcesResponse](docs/DeletedResourcesResponse.md)
 - [DirectFile](docs/DirectFile.md)
 - [Error](docs/Error.md)
 - [ExistingResource](docs/ExistingResource.md)
 - [ExistingResourcesResponse](docs/ExistingResourcesResponse.md)
 - [ExtractFilesResponse](docs/ExtractFilesResponse.md)
 - [Form](docs/Form.md)
 - [FormData](docs/FormData.md)
 - [FormDataResponse](docs/FormDataResponse.md)
 - [FormDataResponseResults](docs/FormDataResponseResults.md)
 - [FormField](docs/FormField.md)
 - [FormFieldData](docs/FormFieldData.md)
 - [FormFieldSettings](docs/FormFieldSettings.md)
 - [FormResponse](docs/FormResponse.md)
 - [GetPageCountResponse](docs/GetPageCountResponse.md)
 - [LogEntry](docs/LogEntry.md)
 - [LogResponse](docs/LogResponse.md)
 - [Message](docs/Message.md)
 - [ModifiedResource](docs/ModifiedResource.md)
 - [ModifiedResourcesResponse](docs/ModifiedResourcesResponse.md)
 - [Notification](docs/Notification.md)
 - [NotificationActivityResponse](docs/NotificationActivityResponse.md)
 - [NotificationMessage](docs/NotificationMessage.md)
 - [NotificationRecipient](docs/NotificationRecipient.md)
 - [NotificationResponse](docs/NotificationResponse.md)
 - [NotificationsResponse](docs/NotificationsResponse.md)
 - [PreviewFile](docs/PreviewFile.md)
 - [PreviewFileResponse](docs/PreviewFileResponse.md)
 - [ResendWelcomeEmailResponse](docs/ResendWelcomeEmailResponse.md)
 - [Resource](docs/Resource.md)
 - [ResourcePropertiesResponse](docs/ResourcePropertiesResponse.md)
 - [ResourceProperty](docs/ResourceProperty.md)
 - [ResourceResponse](docs/ResourceResponse.md)
 - [Response](docs/Response.md)
 - [Response1](docs/Response1.md)
 - [Response1Results](docs/Response1Results.md)
 - [Share](docs/Share.md)
 - [ShareActivityResponse](docs/ShareActivityResponse.md)
 - [ShareLogEntry](docs/ShareLogEntry.md)
 - [ShareRecipient](docs/ShareRecipient.md)
 - [ShareResponse](docs/ShareResponse.md)
 - [SharesResponse](docs/SharesResponse.md)
 - [UpdateForm](docs/UpdateForm.md)
 - [UpdateNotification](docs/UpdateNotification.md)
 - [Url](docs/Url.md)
 - [UrlResponse](docs/UrlResponse.md)
 - [User](docs/User.md)
 - [UserResponse](docs/UserResponse.md)
 - [UsersResponse](docs/UsersResponse.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



