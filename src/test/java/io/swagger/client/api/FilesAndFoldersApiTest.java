/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications. Our API supports both GET and POST operations.  Capabilities of the API include:  - Uploading and downloading files. - Managing files and folders; including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and receive folders.  - Setting up and managing notifications.  ## The API Endpoint  The ExaVault API is located at: https://api.exavault.com/v1.2/  ## Obtain Your API Key  You will need to obtain an API key to connect to the API. To do this, follow the instructions below.   + Log into your account through the usual way, or use https://app.exavault.com.  + Click the Gear icon to access the account settings  + Locate the Developer tab in the account settings  + Click the link for *Manage API Keys*  + You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.  *NOTE: You must have admin or master permissions to create an API key for your account. If you do not have access to developer settings for your account, contact your account administrator to create an API key for you.  # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Introduction/Obtain-Your-API-Key) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"07891ce73cc525084ceb\"></div>  ![ExaVault API Postman Colletion Usage](/images/postman.png)  If you'd prefer to skip Postman and start working with code directly, take a look at the sample code below.    # Code Libraries & Sample PHP Code  Once you're ready for full-scale development, we recommend looking at our code libraries available on [GitHub](https://github.com/ExaVault). We offer code libraries for [Python](https://github.com/ExaVault/evapi-python), [PHP](https://github.com/ExaVault/evapi-php), [JavaScript](https://github.com/ExaVault/evapi-javascript) and [Java](https://github.com/ExaVault/evapi-java).  While we recommend using our libraries, you're welcome to interact directly with our API via HTTP GET and POST requests -- a great option particularly if you're developing in a language for which we don't yet have sample code.     - [Download Python Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-python) - [Download PHP Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-php) - [Download JavaScript Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-javascript) - [Download Java Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-java)  *Note: You can generate client libraries for any language using [Swagger Editor](http://editor2.swagger.io/). Just download our documentation file, past it into editor and use 'Generate Client' dropdown.*  # Status Codes  The ExaVault API returns only two HTTP status codes for its responses: 200 and 500.  When the request could be successfully processed by the endpoint, the response status code will be 200, regardless of whether the requested action could be taken.  For example, the response to a getUser request for a username that does not exist in your account would have the status of 200,  indicating that the response was received and processed, but the error member of the returned response object would contain object with `message` and `code` properties.  **Result Format:**  |Success   | Error     | Results   | | ---      | :---:       |  :---:      | | 0        |  `Object` |   Empty   | | 1        |   Empty       |    `Object` or `Array`        |     When a malformed request is received, a 500 HTTP status code will be returned, indicating that the request could not be processed.  ExaVault's API does not currently support traditional REST response codes such as '201 Created' or '405 Method Not Allowed'.  # File Paths  Many API calls require you to provide one or more file paths. For example, the <a href=\"#operation/moveResources\">moveResources</a> call requires both an array of source paths, **filePaths**, and a destination path, **destinationPath**. Here's a few tips for working with paths:   - File paths should always be specified as a string, using the standard Unix format: e.g. `/path/to/a/file.txt`  - File paths are always absolute _from the home directory of the logged in user_. For example, if the user **bob** had a home directory restriction of `/bob_home`, then an API call made using his login would specify a file as `/myfile.txt`, whereas an API call made using the master user ( no home directory restriction ) would specify the same file as `/bob_home/myfile.txt`.  # API Rate Limits  We rate limit the number of API calls you can make to help prevent abuse and protect system stablity. Each API key will support 500 requests per rolling five minutes. If you make more than 500 requests in a five minute period, you will receive a response with an error object for fifteen minutes.  # Webhooks  A webhook is an HTTP callback: a simple event-notification via HTTP POST. If you define webhooks for Exavault, ExaVault will POST a  message to a URL when certain things happen.     Webhooks can be used to receive a JSON object to your endpoint URL. You choose what events will trigger webhook messages to your endpoint URL.     Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log.  ## Getting Started  1. Go to the Account tab inside the web application.  2. Choose the Developer tab.  3. Configure your endpoint URL and select the events you want to trigger webhook messages.  4. Save settings.    You are all set to receive webhook callbacks on the events you selected.  ## Verification Signature  ExaVault includes a custom HTTP header, X-Exavault-Signature, with webhooks POST requests which will contain the signature for the request.  You can use the signature to verify the request for an additional level of security.  ## Generating the Signature  1. Go to Account tab inside the web application.  2. Choose the Developer tab.  3. Obtain the verification token. This field will only be shown if you've configured your endpoint URL.  4. In your code that receives or processes the webhooks, you should concatenate the verification token with the response string and hash it with md5.     ```     md5($verificationToken.$responseString);     ```  5. Compare signature that you generated to the signature provided in the X-Exavault-Signature HTTP header  ## Example JSON Response Object  ```json   {     \"accountname\": \"mycompanyname\",     \"username\": \"john\"     \"operation\": \"Upload\",     \"protocol\": \"https\",     \"path\": \"/testfolder/filename.jpg\"     \"attempt\": 1   } ```  ## Webhooks Logs  Keep track of all your webhooks requests in the Activity section of your account. You can find the following info for each request:    1. date and time - timestamp of the request.    2. endpoint url - where the webhook was sent.    3. event - what triggered the webhook.    4. status - HTTP status or curl error code.    5. attempt - how many times we tried to send this request.    6. response size - size of the response from your server.    7. details - you can check the response body if it was sent. 
 *
 * OpenAPI spec version: 1.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.CompressFilesResponse;
import io.swagger.client.model.DeletedResourcesResponse;
import io.swagger.client.model.ExistingResourcesResponse;
import io.swagger.client.model.ExtractFilesResponse;
import io.swagger.client.model.GetPageCountResponse;
import io.swagger.client.model.ModifiedResourcesResponse;
import io.swagger.client.model.PreviewFileResponse;
import io.swagger.client.model.ResourcePropertiesResponse;
import io.swagger.client.model.ResourceResponse;
import io.swagger.client.model.Response;
import io.swagger.client.model.UrlResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FilesAndFoldersApi
 */
@Ignore
public class FilesAndFoldersApiTest {

    private final FilesAndFoldersApi api = new FilesAndFoldersApi();

    
    /**
     * checkFilesExist
     *
     * Check if any of the file/folder paths in the input array exist in your account. This is particularly useful if you are uploading files and want to present the user with a dialog asking them if they want to overwrite existing files, as the &lt;a href&#x3D;\&quot;#operation/getUploadFileUrl\&quot;&gt;getUploadFileUrl&lt;/a&gt; call overwrites files by default.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void checkFilesExistTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        List<String> filePaths = null;
        ExistingResourcesResponse response = api.checkFilesExist(apiKey, accessToken, filePaths);

        // TODO: test validations
    }
    
    /**
     * compressFiles
     *
     * Create a zip archive containing the files from given set of paths. Note that this can be a very slow operation if you have indicated many files should be included in the archive.  **Notes:** - Authenticated user should have modify permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void compressFilesTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        List<String> filePaths = null;
        String archivePath = null;
        CompressFilesResponse response = api.compressFiles(apiKey, accessToken, filePaths, archivePath);

        // TODO: test validations
    }
    
    /**
     * copyResources
     *
     * Copies a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be copied to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void copyResourcesTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        List<String> filePaths = null;
        String destinationPath = null;
        ModifiedResourcesResponse response = api.copyResources(apiKey, accessToken, filePaths, destinationPath);

        // TODO: test validations
    }
    
    /**
     * createFolder
     *
     * Create a new folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createFolderTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String folderName = null;
        String path = null;
        Response response = api.createFolder(apiKey, accessToken, folderName, path);

        // TODO: test validations
    }
    
    /**
     * deleteResources
     *
     * Delete the files/folders located at a given set of paths. Note that this call performs the delete **immediately**, and it is irreversible. We strongly recommend that you confirm your user&#39;s intention to delete file(s) before issuing this API call.  **Notes:** - Authenticated user should have delete permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteResourcesTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        List<String> filePaths = null;
        DeletedResourcesResponse response = api.deleteResources(apiKey, accessToken, filePaths);

        // TODO: test validations
    }
    
    /**
     * extractFiles
     *
     * Extract the contents of a zip archive to a specified directory. Note that this can be a very slow operation.  **Notes:** - Authenticated user should have modify permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void extractFilesTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String archivePath = null;
        String extractPath = null;
        ExtractFilesResponse response = api.extractFiles(apiKey, accessToken, archivePath, extractPath);

        // TODO: test validations
    }
    
    /**
     * getDownloadFileUrl
     *
     * Returns an unique URL for a file download.  To download a file from ExaVault, you first request a download URL from our API using this API call. You then make an HTTP GET request to get the actual file contents using the download URL. The download URL will contain a link to an ExaVault storage server where the file is located, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to download the file.  It is possible to download a zip archive of several files at once. To do this, pass an array of several file paths using the filePaths parameter. You can also specify the full path to a folder as the filePaths parameter, and the entire contents of the folder will be recursively added to a zip file. The zip file will be named what you&#39;ve passed as the downloadName parameter.  **Notes:** - Authenticated user should have download permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getDownloadFileUrlTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        List<String> filePaths = new ArrayList<String>();
        String downloadName = null;
        UrlResponse response = api.getDownloadFileUrl(apiKey, accessToken, filePaths, downloadName);

        // TODO: test validations
    }
    
    /**
     * getFolders
     *
     * Gets the list of folder objects for a specified path. This is similar to &lt;a href&#x3D;\&quot;#operation/getResourceList\&quot;&gt;getResourceList&lt;/a&gt;, but returns only folders and is simpler and more perfomrant if you only need to get a list of folders at a given path. &gt; **Notes:** - Authenticated user should have list permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFoldersTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String path = null;
        ResourcePropertiesResponse response = api.getFolders(apiKey, accessToken, path);

        // TODO: test validations
    }
    
    /**
     * getPageCount
     *
     * For use with pdfs and doc files. Indicates the number of pages in the document. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getPageCountTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String path = null;
        GetPageCountResponse response = api.getPageCount(apiKey, accessToken, path);

        // TODO: test validations
    }
    
    /**
     * getResourceList
     *
     * Get a listing of files/folders for the specified path.   You can use this API call to get information about all files and folders at a specified path. By default, the API returns basic metadata on each file/folder. An optional &#39;detailed&#39; parameter forces the return of additional metadata. As with all API calls, the path should be the full path relative to the user&#39;s home directory (e.g. &#x60;/myfiles/some_folder&#x60;).  **Notes:** - Authenticated user should have list permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getResourceListTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String path = null;
        String sortBy = null;
        String sortOrder = null;
        Integer offset = null;
        Integer limit = null;
        Boolean detailed = null;
        String pattern = null;
        ResourceResponse response = api.getResourceList(apiKey, accessToken, path, sortBy, sortOrder, offset, limit, detailed, pattern);

        // TODO: test validations
    }
    
    /**
     * getResourceProperties
     *
     * Gets metadata for each of the specified file/folder paths, including things like upload date, size and type. For the full list of returned properties, see the response syntax, below. &gt; **Notes:** - Authenticated user should have list permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getResourcePropertiesTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        List<String> filePaths = null;
        ResourcePropertiesResponse response = api.getResourceProperties(apiKey, accessToken, filePaths);

        // TODO: test validations
    }
    
    /**
     * getUploadFileUrl
     *
     * Returns an unique URL for handling file uploads.  To upload a file to ExaVault, you first request an upload URL from our API using this API call. You then make an HTTP POST request to that url to put the file on the server. The upload URL will contain a link to an ExaVault storage server where the file can be stored, and a unique access token &amp;ndash; valid for only one use and thirty (30) seconds &amp;ndash; which allows you to upload the file.  **Notes:** - Authenticated user should have upload premission. - Make sure that the fileSize (in bytes) parameter set on getUploadFileUrl matches the number of bytes transferred in the POST body of the URL. If these do not match, the API will detect a cancelled upload and return an error. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getUploadFileUrlTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        Long fileSize = null;
        String destinationPath = null;
        Boolean allowOverwrite = null;
        Boolean resume = null;
        UrlResponse response = api.getUploadFileUrl(apiKey, accessToken, fileSize, destinationPath, allowOverwrite, resume);

        // TODO: test validations
    }
    
    /**
     * moveResources
     *
     * Moves a set of exisiting files/folders (provided by an array **filePaths**) to the requested **destinationPath** in your account. In the **filePaths** array, you may specify paths pointing files/folders throughout the account, but everything will be moved to the  root of the **destinationPath**.  **Notes:** - Authenticated user should have modify permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void moveResourcesTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        List<String> filePaths = null;
        String destinationPath = null;
        ModifiedResourcesResponse response = api.moveResources(apiKey, accessToken, filePaths, destinationPath);

        // TODO: test validations
    }
    
    /**
     * previewFile
     *
     * Returns a resized image of the specified document for supported file types.  Image data returned is encoded in base64 format and can be viewed using the &#x60;&lt;img&gt;&#x60; element.   &#x60;&#x60;&#x60;&lt;img src&#x3D;&#39;data:image/jpeg;base64&#39; + results.image/&gt;&#x60;&#x60;&#x60;  **Notes:** - Supported files types are &#x60;&#39;jpg&#39;&#x60;, &#x60;&#39;jpeg&#39;&#x60;, &#x60;&#39;gif&#39;&#x60;, &#x60;&#39;png&#39;&#x60;, &#x60;&#39;bmp&#39;&#x60;, &#x60;&#39;pdf&#39;&#x60;, &#x60;&#39;psd&#39;&#x60;, &#x60;&#39;doc&#39;&#x60; 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void previewFileTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String path = null;
        String size = null;
        Integer width = null;
        Integer height = null;
        Integer page = null;
        PreviewFileResponse response = api.previewFile(apiKey, accessToken, path, size, width, height, page);

        // TODO: test validations
    }
    
    /**
     * renameResource
     *
     * Rename a file or folder at the specified path. &gt; **Notes:** - Authenticated user should have modify permission. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void renameResourceTest() throws ApiException {
        String apiKey = null;
        String accessToken = null;
        String filePath = null;
        String newName = null;
        Response response = api.renameResource(apiKey, accessToken, filePath, newName);

        // TODO: test validations
    }
    
}
