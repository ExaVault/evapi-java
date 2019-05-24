# FilesAndFoldersApi

All URIs are relative to *https://api.exavault.com/v1.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**checkFilesExist**](FilesAndFoldersApi.md#checkFilesExist) | **GET** /checkFilesExist | checkFilesExist
[**compressFiles**](FilesAndFoldersApi.md#compressFiles) | **POST** /compressFiles | compressFiles
[**copyResources**](FilesAndFoldersApi.md#copyResources) | **POST** /copyResources | copyResources
[**createFolder**](FilesAndFoldersApi.md#createFolder) | **POST** /createFolder | createFolder
[**deleteResources**](FilesAndFoldersApi.md#deleteResources) | **GET** /deleteResources | deleteResources
[**extractFiles**](FilesAndFoldersApi.md#extractFiles) | **POST** /extractFiles | extractFiles
[**getDownloadFileUrl**](FilesAndFoldersApi.md#getDownloadFileUrl) | **GET** /getDownloadFileUrl | getDownloadFileUrl
[**getFolders**](FilesAndFoldersApi.md#getFolders) | **GET** /getFolders | getFolders
[**getPageCount**](FilesAndFoldersApi.md#getPageCount) | **GET** /getPageCount | getPageCount
[**getResourceList**](FilesAndFoldersApi.md#getResourceList) | **GET** /getResourceList | getResourceList
[**getResourceProperties**](FilesAndFoldersApi.md#getResourceProperties) | **GET** /getResourceProperties | getResourceProperties
[**getUploadFileUrl**](FilesAndFoldersApi.md#getUploadFileUrl) | **GET** /getUploadFileUrl | getUploadFileUrl
[**moveResources**](FilesAndFoldersApi.md#moveResources) | **POST** /moveResources | moveResources
[**previewFile**](FilesAndFoldersApi.md#previewFile) | **GET** /previewFile | previewFile
[**renameResource**](FilesAndFoldersApi.md#renameResource) | **POST** /renameResource | renameResource


<a name="checkFilesExist"></a>
# **checkFilesExist**
> ExistingResourcesResponse checkFilesExist(apiKey, accessToken, filePaths)

checkFilesExist

Check if any of the file/folder paths in the input array exist in your account. This is particularly useful if you are uploading files and want to present the user with a dialog asking them if they want to overwrite existing files, as the &lt;a href&#x3D;\&quot;#operation/getUploadFileUrl\&quot;&gt;getUploadFileUrl&lt;/a&gt; call overwrites files by default.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
List<String> filePaths = Arrays.asList("filePaths_example"); // List<String> | Array containing file/folder paths to check.
try {
    ExistingResourcesResponse result = apiInstance.checkFilesExist(apiKey, accessToken, filePaths);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#checkFilesExist");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **filePaths** | [**List&lt;String&gt;**](String.md)| Array containing file/folder paths to check. |

### Return type

[**ExistingResourcesResponse**](ExistingResourcesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="compressFiles"></a>
# **compressFiles**
> CompressFilesResponse compressFiles(apiKey, accessToken, filePaths, archivePath)

compressFiles

Create a zip archive containing the files from given set of paths. Note that this can be a very slow operation if you have indicated many files should be included in the archive.  **Notes:** - Authenticated user should have modify permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
List<String> filePaths = Arrays.asList("filePaths_example"); // List<String> | Array containing paths of the files or folder to include in the zip archive.
String archivePath = "archivePath_example"; // String | Name of the archive to create, including the full path to the file.
try {
    CompressFilesResponse result = apiInstance.compressFiles(apiKey, accessToken, filePaths, archivePath);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#compressFiles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **filePaths** | [**List&lt;String&gt;**](String.md)| Array containing paths of the files or folder to include in the zip archive. |
 **archivePath** | **String**| Name of the archive to create, including the full path to the file. |

### Return type

[**CompressFilesResponse**](CompressFilesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="copyResources"></a>
# **copyResources**
> ModifiedResourcesResponse copyResources(apiKey, accessToken, filePaths, destinationPath)

copyResources

Copies a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be copied to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
List<String> filePaths = Arrays.asList("filePaths_example"); // List<String> | Array containing file/folder paths to copy.
String destinationPath = "destinationPath_example"; // String | Remote destination path to copy files/folders to.
try {
    ModifiedResourcesResponse result = apiInstance.copyResources(apiKey, accessToken, filePaths, destinationPath);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#copyResources");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **filePaths** | [**List&lt;String&gt;**](String.md)| Array containing file/folder paths to copy. |
 **destinationPath** | **String**| Remote destination path to copy files/folders to. |

### Return type

[**ModifiedResourcesResponse**](ModifiedResourcesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="createFolder"></a>
# **createFolder**
> Response createFolder(apiKey, accessToken, folderName, path)

createFolder

Create a new folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String folderName = "folderName_example"; // String | Name of the folder to create.
String path = "path_example"; // String | Where to create the folder. Use **_/_** to create a folder in the user's home directory.
try {
    Response result = apiInstance.createFolder(apiKey, accessToken, folderName, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#createFolder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **folderName** | **String**| Name of the folder to create. |
 **path** | **String**| Where to create the folder. Use **_/_** to create a folder in the user&#39;s home directory. |

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="deleteResources"></a>
# **deleteResources**
> DeletedResourcesResponse deleteResources(apiKey, accessToken, filePaths)

deleteResources

Delete the files/folders located at a given set of paths. Note that this call performs the delete **immediately**, and it is irreversible. We strongly recommend that you confirm your user&#39;s intention to delete file(s) before issuing this API call.  **Notes:** - Authenticated user should have delete permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
List<String> filePaths = Arrays.asList("filePaths_example"); // List<String> | Array containing paths of the files or folder to delete.
try {
    DeletedResourcesResponse result = apiInstance.deleteResources(apiKey, accessToken, filePaths);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#deleteResources");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **filePaths** | [**List&lt;String&gt;**](String.md)| Array containing paths of the files or folder to delete. |

### Return type

[**DeletedResourcesResponse**](DeletedResourcesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="extractFiles"></a>
# **extractFiles**
> ExtractFilesResponse extractFiles(apiKey, accessToken, archivePath, extractPath)

extractFiles

Extract the contents of a zip archive to a specified directory. Note that this can be a very slow operation.  **Notes:** - Authenticated user should have modify permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String archivePath = "archivePath_example"; // String | Name of the archive to create, including the full path to the file.
String extractPath = "extractPath_example"; // String | Path to the folder where the extracted files should be placed.
try {
    ExtractFilesResponse result = apiInstance.extractFiles(apiKey, accessToken, archivePath, extractPath);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#extractFiles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **archivePath** | **String**| Name of the archive to create, including the full path to the file. |
 **extractPath** | **String**| Path to the folder where the extracted files should be placed. |

### Return type

[**ExtractFilesResponse**](ExtractFilesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDownloadFileUrl"></a>
# **getDownloadFileUrl**
> UrlResponse getDownloadFileUrl(apiKey, accessToken, filePaths, downloadName)

getDownloadFileUrl

Returns an unique URL for a file download.  To download a file from ExaVault, you first request a download URL from our API using this API call. You then make an HTTP GET request to get the actual file contents using the download URL. The download URL will contain a link to an ExaVault storage server where the file is located, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to download the file.  It is possible to download a zip archive of several files at once. To do this, pass an array of several file paths using the filePaths parameter. You can also specify the full path to a folder as the filePaths parameter, and the entire contents of the folder will be recursively added to a zip file. The zip file will be named what you&#39;ve passed as the downloadName parameter.  **Notes:** - Authenticated user should have download permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String filePaths = "filePaths_example"; // String | Path of file or folder to be downloaded, starting from the root. Can also be an array of paths.
String downloadName = "downloadName_example"; // String | The name of the file to be downloaded.
try {
    UrlResponse result = apiInstance.getDownloadFileUrl(apiKey, accessToken, filePaths, downloadName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#getDownloadFileUrl");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **filePaths** | **String**| Path of file or folder to be downloaded, starting from the root. Can also be an array of paths. |
 **downloadName** | **String**| The name of the file to be downloaded. | [optional]

### Return type

[**UrlResponse**](UrlResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFolders"></a>
# **getFolders**
> ResourcePropertiesResponse getFolders(apiKey, accessToken, path)

getFolders

Gets the list of folder objects for a specified path. This is similar to &lt;a href&#x3D;\&quot;#operation/getResourceList\&quot;&gt;getResourceList&lt;/a&gt;, but returns only folders and is simpler and more perfomrant if you only need to get a list of folders at a given path. &gt; **Notes:** - Authenticated user should have list permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String path = "path_example"; // String | Path to get folders for.
try {
    ResourcePropertiesResponse result = apiInstance.getFolders(apiKey, accessToken, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#getFolders");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **path** | **String**| Path to get folders for. |

### Return type

[**ResourcePropertiesResponse**](ResourcePropertiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPageCount"></a>
# **getPageCount**
> GetPageCountResponse getPageCount(apiKey, accessToken, path)

getPageCount

For use with pdfs and doc files. Indicates the number of pages in the document. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String path = "path_example"; // String | Path including filename of the document relative to the user's home directory.
try {
    GetPageCountResponse result = apiInstance.getPageCount(apiKey, accessToken, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#getPageCount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **path** | **String**| Path including filename of the document relative to the user&#39;s home directory. |

### Return type

[**GetPageCountResponse**](GetPageCountResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getResourceList"></a>
# **getResourceList**
> ResourceResponse getResourceList(apiKey, accessToken, path, sortBy, sortOrder, offset, limit, detailed, pattern)

getResourceList

Get a listing of files/folders for the specified path.   You can use this API call to get information about all files and folders at a specified path. By default, the API returns basic metadata on each file/folder. An optional &#39;detailed&#39; parameter forces the return of additional metadata. As with all API calls, the path should be the full path relative to the user&#39;s home directory (e.g. &#x60;/myfiles/some_folder&#x60;).  **Notes:** - Authenticated user should have list permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String path = "path_example"; // String | Path to get listing of resources for.
String sortBy = "sort_files_name"; // String | Sort method. Use in conjunction with **sort_order**, below.
String sortOrder = "asc"; // String | Sort order.
Integer offset = 0; // Integer | Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list.
Integer limit = 50; // Integer | The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls to **getResourceList**, incrementing the **offset** parameter, above.
Boolean detailed = false; // Boolean | If true, returns sharedFolder, notifications or other objects associated with specified path. You should only set this paramter to true if you need the additional details, as the API call is less perfomant when it is enabled.
String pattern = "pattern_example"; // String | Regex string. If not null, perform a search with specified pattern.
try {
    ResourceResponse result = apiInstance.getResourceList(apiKey, accessToken, path, sortBy, sortOrder, offset, limit, detailed, pattern);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#getResourceList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **path** | **String**| Path to get listing of resources for. |
 **sortBy** | **String**| Sort method. Use in conjunction with **sort_order**, below. | [optional] [default to sort_files_name] [enum: sort_files_name, sort_files_size, sort_files_date, sort_files_type]
 **sortOrder** | **String**| Sort order. | [optional] [default to asc] [enum: asc, desc]
 **offset** | **Integer**| Determines which item to start on for pagination. Use zero (0) to start at the beginning of the list. | [optional] [default to 0]
 **limit** | **Integer**| The number of files to limit the result. Cannot be set higher than 100. If you have more than one hundred files in your directory, make multiple calls to **getResourceList**, incrementing the **offset** parameter, above. | [optional] [default to 50]
 **detailed** | **Boolean**| If true, returns sharedFolder, notifications or other objects associated with specified path. You should only set this paramter to true if you need the additional details, as the API call is less perfomant when it is enabled. | [optional] [default to false]
 **pattern** | **String**| Regex string. If not null, perform a search with specified pattern. | [optional]

### Return type

[**ResourceResponse**](ResourceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getResourceProperties"></a>
# **getResourceProperties**
> ResourcePropertiesResponse getResourceProperties(apiKey, accessToken, filePaths)

getResourceProperties

Gets metadata for each of the specified file/folder paths, including things like upload date, size and type. For the full list of returned properties, see the response syntax, below. &gt; **Notes:** - Authenticated user should have list permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
List<String> filePaths = Arrays.asList("filePaths_example"); // List<String> | Array containing paths of the files or folder to get metadata for.
try {
    ResourcePropertiesResponse result = apiInstance.getResourceProperties(apiKey, accessToken, filePaths);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#getResourceProperties");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **filePaths** | [**List&lt;String&gt;**](String.md)| Array containing paths of the files or folder to get metadata for. |

### Return type

[**ResourcePropertiesResponse**](ResourcePropertiesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUploadFileUrl"></a>
# **getUploadFileUrl**
> UrlResponse getUploadFileUrl(apiKey, accessToken, fileSize, destinationPath, allowOverwrite, resume)

getUploadFileUrl

Returns an unique URL for handling file uploads.  To upload a file to ExaVault, you first request an upload URL from our API using this API call. You then make an HTTP POST request to that url to put the file on the server. The upload URL will contain a link to an ExaVault storage server where the file can be stored, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to upload the file.  **Notes:** - Authenticated user should have upload premission. - Make sure that the fileSize (in bytes) parameter set on getUploadFileUrl matches the number of bytes transferred in the POST body of the URL. If these do not match, the API will detect a cancelled upload and return an error. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
Long fileSize = 789L; // Long | Size of the file to upload, in bytes.
String destinationPath = "destinationPath_example"; // String | Path relative to account's home directory, including file name.
Boolean allowOverwrite = true; // Boolean | True if the file should be overwritten, false if different file names should be generated. Call <a href=\"#operation/checkFilesExist\">checkFilesExist</a> first if you need to determine whether or not a file with the same name already exists. 
Boolean resume = false; // Boolean | True if upload resume is supported, false if it isn't.
try {
    UrlResponse result = apiInstance.getUploadFileUrl(apiKey, accessToken, fileSize, destinationPath, allowOverwrite, resume);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#getUploadFileUrl");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **fileSize** | **Long**| Size of the file to upload, in bytes. |
 **destinationPath** | **String**| Path relative to account&#39;s home directory, including file name. |
 **allowOverwrite** | **Boolean**| True if the file should be overwritten, false if different file names should be generated. Call &lt;a href&#x3D;\&quot;#operation/checkFilesExist\&quot;&gt;checkFilesExist&lt;/a&gt; first if you need to determine whether or not a file with the same name already exists.  | [optional] [default to true]
 **resume** | **Boolean**| True if upload resume is supported, false if it isn&#39;t. | [optional] [default to false]

### Return type

[**UrlResponse**](UrlResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="moveResources"></a>
# **moveResources**
> ModifiedResourcesResponse moveResources(apiKey, accessToken, filePaths, destinationPath)

moveResources

Moves a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be moved to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
List<String> filePaths = Arrays.asList("filePaths_example"); // List<String> | Array containing file/folder paths to move.
String destinationPath = "destinationPath_example"; // String | Remote destination path to move files/folders to.
try {
    ModifiedResourcesResponse result = apiInstance.moveResources(apiKey, accessToken, filePaths, destinationPath);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#moveResources");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **filePaths** | [**List&lt;String&gt;**](String.md)| Array containing file/folder paths to move. |
 **destinationPath** | **String**| Remote destination path to move files/folders to. |

### Return type

[**ModifiedResourcesResponse**](ModifiedResourcesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="previewFile"></a>
# **previewFile**
> PreviewFileResponse previewFile(apiKey, accessToken, path, size, width, height, page)

previewFile

Returns a resized image of the specified document for supported file types.  Image data returned is encoded in base64 format and can be viewed using the &#x60;&lt;img&gt;&#x60; element.   &#x60;&#x60;&#x60;&lt;img src&#x3D;&#39;data:image/jpeg;base64&#39; + results.image/&gt;&#x60;&#x60;&#x60;  **Notes:** - Supported files types are &#x60;&#39;jpg&#39;&#x60;, &#x60;&#39;jpeg&#39;&#x60;, &#x60;&#39;gif&#39;&#x60;, &#x60;&#39;png&#39;&#x60;, &#x60;&#39;bmp&#39;&#x60;, &#x60;&#39;pdf&#39;&#x60;, &#x60;&#39;psd&#39;&#x60;, &#x60;&#39;doc&#39;&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String path = "path_example"; // String | Path of the image relative to the user's home directory.
String size = "size_example"; // String | The size of the image.
Integer width = 56; // Integer | Overrides sizes. Sets to a specific width.
Integer height = 56; // Integer | Overrides sizes. Sets to a specific height.
Integer page = 0; // Integer | Page number for the `.pdf` or `.doc` files.
try {
    PreviewFileResponse result = apiInstance.previewFile(apiKey, accessToken, path, size, width, height, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#previewFile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **path** | **String**| Path of the image relative to the user&#39;s home directory. |
 **size** | **String**| The size of the image. | [enum: small, medium, large]
 **width** | **Integer**| Overrides sizes. Sets to a specific width. | [optional]
 **height** | **Integer**| Overrides sizes. Sets to a specific height. | [optional]
 **page** | **Integer**| Page number for the &#x60;.pdf&#x60; or &#x60;.doc&#x60; files. | [optional] [default to 0]

### Return type

[**PreviewFileResponse**](PreviewFileResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="renameResource"></a>
# **renameResource**
> Response renameResource(apiKey, accessToken, filePath, newName)

renameResource

Rename a file or folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.FilesAndFoldersApi;


FilesAndFoldersApi apiInstance = new FilesAndFoldersApi();
String apiKey = "apiKey_example"; // String | API key required to make the API call.
String accessToken = "accessToken_example"; // String | Access token required to make the API call.
String filePath = "filePath_example"; // String | Remote path of the file or folder to rename.
String newName = "newName_example"; // String | The new name of the file or folder.
try {
    Response result = apiInstance.renameResource(apiKey, accessToken, filePath, newName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FilesAndFoldersApi#renameResource");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | **String**| API key required to make the API call. |
 **accessToken** | **String**| Access token required to make the API call. |
 **filePath** | **String**| Remote path of the file or folder to rename. |
 **newName** | **String**| The new name of the file or folder. |

### Return type

[**Response**](Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

