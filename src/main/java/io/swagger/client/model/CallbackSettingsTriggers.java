/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications.   Capabilities of the API include - Uploading and downloading files. - Managing files and folders, including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and receive folders.  - Setting up and managing notifications.  The ExaVault API v2.0 is a RESTful API using JSON.  ## The API URL  You will access your account from your server address. For example, if your account is available at exampleaccount.exavault.com, you'll connect to the API at https://exampleaccount.exavault.com/api/v2  # Obtaining Your API Key and Access Token  Account admins can create API Keys and personal access tokens within the ExaVault File Manager web application.   ## Create an API Key  1. Log into the ExaVault File Manager at your account name address. i.e., if your account is exampleaccount.exavault.com, go to https://exampleaccount.exavault.com and log in with your username and password 2. Click on the **My Account** option in the left-hand sidebar 3. Click on the **Developer** tab 4. Click the + button next to the table of API Keys to create a new key 5. Enter a name that will uniquely identify connections using this key. This name will appear in your activity session logs. 6. Enter a description with any other information that you need to track the purpose of your API key 7. Save the new key  As soon as you save a new API key, you'll be prompted to create a personal access token which will allow a specific user to connect via the API using that API key (jump to step 5 in the instructions below)  ## Generate an Access Token 1. Log into the ExaVault File Manager at your account name address. i.e., if your account is exampleaccount.exavault.com, go to https://exampleaccount.exavault.com and log in with your username and password 1. Click on the **My Account** option in the left-hand sidebar 1. Click on the **Developer** tab 1. Click the + button next to the table of Access Tokens to create a new token 1. Select the API Key from the first dropdown. 1. Select the user who will use this token from the second dropdown. 1. Click the **GENERATE TOKEN** button  The confirmation popup will display your API key and your access token. **Copy this access token to a safe location (such as a password vault) immediately.** Once you close this popup, you will not be able to see the token again. After you have saved your token securely, click CLOSE to close the popup.  The access token you have created will allow any program using that token and its API key to masquerade as the associated user. You should keep the token safe.  # Code Libraries   To get you started quicker, we've created libraries on our [GitHub](https://github.com/ExaVault) with sample code for Java, PhP, and JavaScript that will do basic actions including;  - Create a new user - Upload a file - Download a file - Create a share folder   # Authentication  The ExaVault API uses the combination of an API key and a persistent access token to authenticate a user. Both the API key and the access token can be created by an admin-level user  Each request made to the API must include 2 headers  | Header Name   | Contains      | | ---      | :---:          | | **ev-api-key**      |  Your API key   | | **ev-access-token**       |   Your access token          |     The access token uniquely identifies the user account for the connection. You should keep this token secure.   # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Obtaining-Your-API-Key-and-Access-Token) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"d72a708e9382d3b3db17\"></div>  ![ExaVault API Postman Collection Usage](/images/postman.png)  # HTTP Status Codes  The ExaVault API v2.0 is RESTful and returns appropriate HTTP status codes in its responses  **Success Statuses:**  | Status   | Notes   | | ---      | :---:       | | 200      | Successful operation   | | 201      | Successful creation operation     | | 207      | Multiple operation status |  **Request Error Statuses:**  | Status   | Notes   | | ---      | :---:       | | 400      | Bad Request   | | 401      | Unauthorized     | | 403      | Forbidden   | | 404      | Not Found* | | 429      | Too many requests |  **Server Error Statuses:**  | Status   | Notes | | ---      | ---   | | 500      | Server Error | | 503      | Service unavailable |   # Response Format  Nearly every response from the server will be a JSON object, which will contain a `responseStatus` attribute that matches the HTTP status of the response.  Most succesful responses will also include a `data` attribute that contains the data related to your request. For instance using GET /account will return the information for the account associated with your API key and access token.  ## Timestamps   All of our responses that include datetime information will be structured in an IS0 8601 format:   No offset from UTC: `YYYY-MM-DDThh:mm:ssZ` e.g. 2019-09-07T15:50Z  Minus offset from UTC: `YYYY-MM-DDThh:mm:ss-hh:mm` e.g. 2019-09-07T15:50-04:00  Plus offset from UTC: `YYYY-MM-DDThh:mm:ss+hh:mm` e.g. 2019-09-07T15:50+04:00  - YYYY = four-digit year - MM   = two-digit month - DD   = two-digit day of month - hh   = two digits of hour - mm   = two digits of minute - ss   = two digits of second - Z    = zero offset from UTC time  ## Error Responses  Error responses will have a similar format. The response will contain a `responseStatus` which contains the HTTP status code and an `errors` array, which will contain pertinent errors for the request. Each object in the `errors` array will contain a human-readable `code` and some explanatory `detail` text.  ## Common Errors   As you work with our suite of APIs, you'll likely encounter one or more of these error codes throughout the process. Let's take a look at some of the most common errors and how to resolve them quickly and painlessly.   ### 400 Error - Bad Request:  ```json {   \"responseStatus\":400,   \"errors\":[     {       \"code\":\"ERROR_INVALID_PARAMETER\",       \"detail\":\"Destination path cannot be an existing folder.\"     }   ] } ```  ```json {  \"responseStatus\": 400,  \"errors\": [   {    \"code\": \"ERROR_INVALID_PASSWORD\",    \"detail\": \"Password must be longer than eight (8) characters and contain one uppercase letter, one lowercase letter, and one number.\"   }  ] } ```  This error will generally mean a paramater or body element is invalid or missing. We suggest taking another look at the documentation of the API endpoint you're hitting to double check for; missing required fields in the request, spelling errors, invalid values be used.   The error messaging returned should point you exactly to what you need to correct to avoid going through trial and error.    ### 401 Error - Unauthorized   ```json {  \"responseStatus\": 401,  \"errors\": [   {    \"code\": \"ERROR_INVALID_CREDENTIALS\",    \"detail\": \"HTTP_UNAUTHORIZED\"   }  ] } ```  If you encounter a 401, it means we're not recognizing the credentials you're attempting to authenticate with. To resolve the issue;    1. Double check that your credenitals (API Key and Access Token) are correct. 2. Creating a second set of credentials (see \"Obtaining Your API Key and Access Token\" above) and attempt the call again.  3. If you're able to successfully make a call, regenerate the Access Token of the first user and try the call one last time.   If you're still encountering a 401, contact us for help.  ### 403 Error - Forbidden  ```json {  \"responseStatus\": 403,  \"errors\": [   {    \"code\": \"ERROR_INSUFFICIENT_PRIVILEGES\",    \"detail\": \"An error occurred\"   }  ] } ```  Similarly to a 401, you'll be unable to complete an API call if you encounter this error. Unlike a 401, your credentials were authenticated, but the authenticated user does not have permission to perform the action you're attempting.   To resolve the issue you can either;  - Execute the call using an master user's credentials.  - Log in to the ExaVault File Manager OR use the **PATCH /updateUser** endpoint to update the user's permissions.  ### 404 Error - Not Found  ```json  {  \"responseStatus\": 404,  \"errors\": [   {    \"code\": \"ERROR_SHARE_NOT_FOUND\",    \"detail\": \"Share not found\"   }  ] } ```  Encountering a 404 error means whatever type of resource you're attempting to find or update; isn't being found. Usually, this is just a case of using the wrong ID when using a call, and can be resolved by fixing the ID on your call.    If the ID on the call appears to be correct we recommend taking the following steps:  - Attempt a more generic GET call to get a list of the type of resource you're looking for to see if you can find the ID you're looking for.  - Check your activity logs to see if what you're looking for was recently deleted.    # Identifying Resources  Many API methods require you to provide one or more resources, which may be expressed as paths, ids, hashes, or some combination of the three (for calls that act upon multiple resources).   To specify a resource by path, provide a fully qualified string to the resource _relative to the associated user's home directory_. This path will always begin with a forward slash. Only forward slash characters may be used to separate the folders within a path string.  To specify a resource by ID, you'll need to obtain that ID from some other API method first. For example, **GET /resources/list** will return a list of resources in your account along with their IDs. Once you have the ID of that resource, append it to the string \"id:\" to specify that resource, such as `id:124447`. IDs are always whole-number numeric values.   To specify a resource by hash, first obtain the hash from another API method. Once you have the hash representing the resource, append it to the string \"hash:\" to specify that resource, such as `hash:3a1597ca982231f6666c75bcc2bd9c85` to indicate the resource with the hash value **3a1597ca982231f6666c75bcc2bd9c85**. Hashes are always an alphanumeric sequence without any special characters or punctuation.  ## Paths and Home Folders  Users with different home folders will use different paths to refer to the same resource. As an example, suppose there is a file located at **_/Data/Production/Inbound/1595978053_G12.xml**. For an admin-level user, or any user whose home folder permits them access to the entire account, the path for that resource is **_/Data/Production/Inbound/1595978053_G12.xml**.  For a user whose home folder is **_/Data/Production/_**, the path to the file becomes **_/Inbound/1595978053_G12.xml**  # Transaction Limits  The daily transaction limit restricts the overall number of operations you can perform in a 24-hour period in your ExaVault account. Those transactions could be file uploads, file downloads, making a shared folder, creating a user, deleting files, to name a few examples. All operations performed in your account count against the total daily transactions for your account, including:  - FTP/SFTP operations - Actions by users who are logged into your web interface - Interacting with Receive folders - Receiving files through Send files and Shared Folders - Accessing files shared through direct links - API access from any user using any of the API keys for your account  Each request sent to the API is one transaction. When your account has exceeded its rolling 24-hour rate limit, new operations will become available once the number of operations in the past 24-hours is below your daily rate limit. The response status of rate-limited API operations will be **429**.  ## Rate Limit Headers  To monitor your daily account transaction usage, the response object returned by the server for all API requests will include these custom headers:  - **X-RateLimit-Limit** indicates the total number of operations permitted within a rolling 24-hour period across your entire account. This number is dependent upon the plan your account is subscribed to, and whether you have an enterprise agreement in place. - **X-RateLimit-Remaining** indicates the number of operations currently remaning to you at that moment in time.    # Webhooks  ExaVault provides a webhook system for notifying you of changes to your account. The webhook sender will send a POST request to an endpoint you have specified whenever certain actions happen within your account. Account administrators can change these settings within the ExaVault File Manager.  Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log within the ExaVault File Manager web interface.  ## Configuring Webhooks  1. Log into the ExaVault File Manager at your account name address. i.e., if your account is exampleaccount.exavault.com, go to https://exampleaccount.exavault.com and log in with your username and password. 1. Click on the **My Account** option in the left-hand sidebar. 1. Click on the **Developer** tab 1. Add the URL where your webhook listener can receive requests 1. Check the boxes for the actions which should trigger your webhook. 1. Scroll to the bottom of the page to click SAVE SETTINGS.  ## Verification Signature  When you configure a webhook endpoint and triggering actions, a Verification Token will be displayed below the webhook endpoint URL. You may use this token in combination with the X-Exavault-Signature header to verify that ExaVault is the sender of the webhook request.  ## Comparing the Signature  You'll can use this 3-step procedure to validate an individual webhook request to ensure it was sent by ExaVault.  **1: Get Verification Token**  In order to verify the X-Exavault-Signature header value, you'll first need to obtain the Verification Token for your account:  1. Click on the **My Account** option in the left-hand sidebar. 1. Click on the **Developer** tab 1. Copy the Verification Token that appears below the Webhooks Endpoint url field.  Every webhook request sent to your endpoint URL will use the same verification token. This token won't change for your account.  **2: Concatenate Token and Request**  Once you have the verification token, you'll concatenate that token along with the raw string representing the request body that was received.   **Do not convert the request body to any other type** of object; if the library you're using automatically converts the request body to an object, look for a method to obtain the raw request body as text.  **3: Calculate MD5 Hash**  Calculate the md5 hash of that concatenation. The result should match the contents of your X-Exavault-Signature header.  ## Webhook Request Examples  The following examples demonstrate the structure of webhook requests and how to validate the verification signature for an individual request. All of these examples will use the same verification token; you'll need to use the token for your account to do the same checks on your own webhook requests.  **User Connect Example**  | Verification Token | X-Exavault-Signature header value | | --- | --- | | efb7e0030e6cef1b45d3d74a67881a2b | 6e13eb14edfd0bd54feff96be131e155 |  ```json {\"accountname\":\"exampleaccount\",\"username\":\"exampleaccount\",\"operation\":\"Connect\",\"protocol\":\"web\",\"path\":\"\",\"sourcepath\":\"\",\"attempt\":1} ```   **User Disconnect Example**  | Verification Token | X-Exavault-Signature header value | | --- | --- | | efb7e0030e6cef1b45d3d74a67881a2b | 186e8c73793666c8b5cfa0b55eee691d |  ```json {\"accountname\":\"exampleaccount\",\"username\":\"exampleaccount\",\"operation\":\"Disconnect\",\"protocol\":\"web\",\"path\":\"\",\"sourcepath\":\"\",\"attempt\":1} ```  **File Upload Example**  | Verification Token | X-Exavault-Signature header value | | --- | --- | | efb7e0030e6cef1b45d3d74a67881a2b | e86119ce1b679c7b6010d9ac9a843a36 |  ```json {\"accountname\":\"exampleaccount\",\"username\":\"exampleaccount\",\"operation\":\"Upload\",\"protocol\":\"web\",\"path\":\"/7df2beb1c50a8a066493ee47669a4319.jpg\",\"sourcepath\":\"\",\"attempt\":1} ```  ## Webhooks Logs  Account administrators can track all of the webhook requests sent for your account within the ExaVault File Manager web interface.   To access Webhook logs:  1. Log into the ExaVault File Manager at your account name address. i.e., if your account is exampleaccount.exavault.com, go to https://exampleaccount.exavault.com and log in with your username and password 1. Click on the **Activity** option in the left-hand sidebar 1. Click on **Webhooks Logs**  The webhook logs will show each time a webhook request was sent to your endpoint URL. The following information is recorded for each request:   - date and time - when the system sent the request   - endpoint url - where the webhook request was sent   - event - what triggered the webhook   - status - HTTP status or curl error code returned by the webhook endpoint   - attempt - how many times this request has been sent   - response size - size of the response from your webhook endpoint   - details - the response body returned from your webhook endpoint 
 *
 * OpenAPI spec version: 2.0
 * Contact: support@exavault.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * CallbackSettingsTriggers
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-10-13T19:47:31.812Z[GMT]")
public class CallbackSettingsTriggers {
  @SerializedName("upload")
  private Boolean upload = null;

  @SerializedName("download")
  private Boolean download = null;

  @SerializedName("delete")
  private Boolean delete = null;

  @SerializedName("createFolder")
  private Boolean createFolder = null;

  @SerializedName("rename")
  private Boolean rename = null;

  @SerializedName("move")
  private Boolean move = null;

  @SerializedName("copy")
  private Boolean copy = null;

  @SerializedName("compress")
  private Boolean compress = null;

  @SerializedName("extract")
  private Boolean extract = null;

  @SerializedName("shareFolder")
  private Boolean shareFolder = null;

  @SerializedName("sendFiles")
  private Boolean sendFiles = null;

  @SerializedName("receiveFiles")
  private Boolean receiveFiles = null;

  @SerializedName("updateShare")
  private Boolean updateShare = null;

  @SerializedName("updateReceive")
  private Boolean updateReceive = null;

  @SerializedName("deleteSend")
  private Boolean deleteSend = null;

  @SerializedName("deleteReceive")
  private Boolean deleteReceive = null;

  @SerializedName("deleteShare")
  private Boolean deleteShare = null;

  @SerializedName("createNotification")
  private Boolean createNotification = null;

  @SerializedName("updateNotification")
  private Boolean updateNotification = null;

  @SerializedName("deleteNotification")
  private Boolean deleteNotification = null;

  @SerializedName("createUser")
  private Boolean createUser = null;

  @SerializedName("updateUser")
  private Boolean updateUser = null;

  @SerializedName("deleteUser")
  private Boolean deleteUser = null;

  @SerializedName("userConnect")
  private Boolean userConnect = null;

  @SerializedName("userDisconnect")
  private Boolean userDisconnect = null;

  public CallbackSettingsTriggers upload(Boolean upload) {
    this.upload = upload;
    return this;
  }

   /**
   * Trigger callback on upload.
   * @return upload
  **/
  @Schema(example = "true", description = "Trigger callback on upload.")
  public Boolean isUpload() {
    return upload;
  }

  public void setUpload(Boolean upload) {
    this.upload = upload;
  }

  public CallbackSettingsTriggers download(Boolean download) {
    this.download = download;
    return this;
  }

   /**
   * Trigger callback on download.
   * @return download
  **/
  @Schema(example = "false", description = "Trigger callback on download.")
  public Boolean isDownload() {
    return download;
  }

  public void setDownload(Boolean download) {
    this.download = download;
  }

  public CallbackSettingsTriggers delete(Boolean delete) {
    this.delete = delete;
    return this;
  }

   /**
   * Trigger callback on delete.
   * @return delete
  **/
  @Schema(example = "false", description = "Trigger callback on delete.")
  public Boolean isDelete() {
    return delete;
  }

  public void setDelete(Boolean delete) {
    this.delete = delete;
  }

  public CallbackSettingsTriggers createFolder(Boolean createFolder) {
    this.createFolder = createFolder;
    return this;
  }

   /**
   * Trigger callback on fodler create.
   * @return createFolder
  **/
  @Schema(example = "true", description = "Trigger callback on fodler create.")
  public Boolean isCreateFolder() {
    return createFolder;
  }

  public void setCreateFolder(Boolean createFolder) {
    this.createFolder = createFolder;
  }

  public CallbackSettingsTriggers rename(Boolean rename) {
    this.rename = rename;
    return this;
  }

   /**
   * Trigger callback on rename.
   * @return rename
  **/
  @Schema(example = "false", description = "Trigger callback on rename.")
  public Boolean isRename() {
    return rename;
  }

  public void setRename(Boolean rename) {
    this.rename = rename;
  }

  public CallbackSettingsTriggers move(Boolean move) {
    this.move = move;
    return this;
  }

   /**
   * Trigger callback on move.
   * @return move
  **/
  @Schema(example = "false", description = "Trigger callback on move.")
  public Boolean isMove() {
    return move;
  }

  public void setMove(Boolean move) {
    this.move = move;
  }

  public CallbackSettingsTriggers copy(Boolean copy) {
    this.copy = copy;
    return this;
  }

   /**
   * Trigger callback on copy.
   * @return copy
  **/
  @Schema(example = "false", description = "Trigger callback on copy.")
  public Boolean isCopy() {
    return copy;
  }

  public void setCopy(Boolean copy) {
    this.copy = copy;
  }

  public CallbackSettingsTriggers compress(Boolean compress) {
    this.compress = compress;
    return this;
  }

   /**
   * Trigger callback on compress.
   * @return compress
  **/
  @Schema(example = "false", description = "Trigger callback on compress.")
  public Boolean isCompress() {
    return compress;
  }

  public void setCompress(Boolean compress) {
    this.compress = compress;
  }

  public CallbackSettingsTriggers extract(Boolean extract) {
    this.extract = extract;
    return this;
  }

   /**
   * Trigger callback on extract.
   * @return extract
  **/
  @Schema(example = "false", description = "Trigger callback on extract.")
  public Boolean isExtract() {
    return extract;
  }

  public void setExtract(Boolean extract) {
    this.extract = extract;
  }

  public CallbackSettingsTriggers shareFolder(Boolean shareFolder) {
    this.shareFolder = shareFolder;
    return this;
  }

   /**
   * Trigger callback on share folder create.
   * @return shareFolder
  **/
  @Schema(example = "false", description = "Trigger callback on share folder create.")
  public Boolean isShareFolder() {
    return shareFolder;
  }

  public void setShareFolder(Boolean shareFolder) {
    this.shareFolder = shareFolder;
  }

  public CallbackSettingsTriggers sendFiles(Boolean sendFiles) {
    this.sendFiles = sendFiles;
    return this;
  }

   /**
   * Trigger callback on send files.
   * @return sendFiles
  **/
  @Schema(example = "false", description = "Trigger callback on send files.")
  public Boolean isSendFiles() {
    return sendFiles;
  }

  public void setSendFiles(Boolean sendFiles) {
    this.sendFiles = sendFiles;
  }

  public CallbackSettingsTriggers receiveFiles(Boolean receiveFiles) {
    this.receiveFiles = receiveFiles;
    return this;
  }

   /**
   * Trigger callback on receive folder create.
   * @return receiveFiles
  **/
  @Schema(example = "false", description = "Trigger callback on receive folder create.")
  public Boolean isReceiveFiles() {
    return receiveFiles;
  }

  public void setReceiveFiles(Boolean receiveFiles) {
    this.receiveFiles = receiveFiles;
  }

  public CallbackSettingsTriggers updateShare(Boolean updateShare) {
    this.updateShare = updateShare;
    return this;
  }

   /**
   * Trigger callback on share folder update.
   * @return updateShare
  **/
  @Schema(example = "false", description = "Trigger callback on share folder update.")
  public Boolean isUpdateShare() {
    return updateShare;
  }

  public void setUpdateShare(Boolean updateShare) {
    this.updateShare = updateShare;
  }

  public CallbackSettingsTriggers updateReceive(Boolean updateReceive) {
    this.updateReceive = updateReceive;
    return this;
  }

   /**
   * Trigger callback on receive folder update.
   * @return updateReceive
  **/
  @Schema(example = "false", description = "Trigger callback on receive folder update.")
  public Boolean isUpdateReceive() {
    return updateReceive;
  }

  public void setUpdateReceive(Boolean updateReceive) {
    this.updateReceive = updateReceive;
  }

  public CallbackSettingsTriggers deleteSend(Boolean deleteSend) {
    this.deleteSend = deleteSend;
    return this;
  }

   /**
   * Trigger callback on send files delete.
   * @return deleteSend
  **/
  @Schema(example = "false", description = "Trigger callback on send files delete.")
  public Boolean isDeleteSend() {
    return deleteSend;
  }

  public void setDeleteSend(Boolean deleteSend) {
    this.deleteSend = deleteSend;
  }

  public CallbackSettingsTriggers deleteReceive(Boolean deleteReceive) {
    this.deleteReceive = deleteReceive;
    return this;
  }

   /**
   * Trigger callback on receive folder delete.
   * @return deleteReceive
  **/
  @Schema(example = "false", description = "Trigger callback on receive folder delete.")
  public Boolean isDeleteReceive() {
    return deleteReceive;
  }

  public void setDeleteReceive(Boolean deleteReceive) {
    this.deleteReceive = deleteReceive;
  }

  public CallbackSettingsTriggers deleteShare(Boolean deleteShare) {
    this.deleteShare = deleteShare;
    return this;
  }

   /**
   * Trigger callback on share folder delete.
   * @return deleteShare
  **/
  @Schema(example = "false", description = "Trigger callback on share folder delete.")
  public Boolean isDeleteShare() {
    return deleteShare;
  }

  public void setDeleteShare(Boolean deleteShare) {
    this.deleteShare = deleteShare;
  }

  public CallbackSettingsTriggers createNotification(Boolean createNotification) {
    this.createNotification = createNotification;
    return this;
  }

   /**
   * Trigger callback on notification create.
   * @return createNotification
  **/
  @Schema(example = "false", description = "Trigger callback on notification create.")
  public Boolean isCreateNotification() {
    return createNotification;
  }

  public void setCreateNotification(Boolean createNotification) {
    this.createNotification = createNotification;
  }

  public CallbackSettingsTriggers updateNotification(Boolean updateNotification) {
    this.updateNotification = updateNotification;
    return this;
  }

   /**
   * Trigger callback on notification update.
   * @return updateNotification
  **/
  @Schema(example = "true", description = "Trigger callback on notification update.")
  public Boolean isUpdateNotification() {
    return updateNotification;
  }

  public void setUpdateNotification(Boolean updateNotification) {
    this.updateNotification = updateNotification;
  }

  public CallbackSettingsTriggers deleteNotification(Boolean deleteNotification) {
    this.deleteNotification = deleteNotification;
    return this;
  }

   /**
   * Trigger callback on notification delete.
   * @return deleteNotification
  **/
  @Schema(example = "false", description = "Trigger callback on notification delete.")
  public Boolean isDeleteNotification() {
    return deleteNotification;
  }

  public void setDeleteNotification(Boolean deleteNotification) {
    this.deleteNotification = deleteNotification;
  }

  public CallbackSettingsTriggers createUser(Boolean createUser) {
    this.createUser = createUser;
    return this;
  }

   /**
   * Trigger callback on user create.
   * @return createUser
  **/
  @Schema(example = "false", description = "Trigger callback on user create.")
  public Boolean isCreateUser() {
    return createUser;
  }

  public void setCreateUser(Boolean createUser) {
    this.createUser = createUser;
  }

  public CallbackSettingsTriggers updateUser(Boolean updateUser) {
    this.updateUser = updateUser;
    return this;
  }

   /**
   * Trigger callback on user update.
   * @return updateUser
  **/
  @Schema(example = "false", description = "Trigger callback on user update.")
  public Boolean isUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(Boolean updateUser) {
    this.updateUser = updateUser;
  }

  public CallbackSettingsTriggers deleteUser(Boolean deleteUser) {
    this.deleteUser = deleteUser;
    return this;
  }

   /**
   * Trigger callback on user delete.
   * @return deleteUser
  **/
  @Schema(example = "false", description = "Trigger callback on user delete.")
  public Boolean isDeleteUser() {
    return deleteUser;
  }

  public void setDeleteUser(Boolean deleteUser) {
    this.deleteUser = deleteUser;
  }

  public CallbackSettingsTriggers userConnect(Boolean userConnect) {
    this.userConnect = userConnect;
    return this;
  }

   /**
   * Trigger callback on user connect.
   * @return userConnect
  **/
  @Schema(example = "false", description = "Trigger callback on user connect.")
  public Boolean isUserConnect() {
    return userConnect;
  }

  public void setUserConnect(Boolean userConnect) {
    this.userConnect = userConnect;
  }

  public CallbackSettingsTriggers userDisconnect(Boolean userDisconnect) {
    this.userDisconnect = userDisconnect;
    return this;
  }

   /**
   * Trigger callback on user disconnect.
   * @return userDisconnect
  **/
  @Schema(example = "false", description = "Trigger callback on user disconnect.")
  public Boolean isUserDisconnect() {
    return userDisconnect;
  }

  public void setUserDisconnect(Boolean userDisconnect) {
    this.userDisconnect = userDisconnect;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallbackSettingsTriggers callbackSettingsTriggers = (CallbackSettingsTriggers) o;
    return Objects.equals(this.upload, callbackSettingsTriggers.upload) &&
        Objects.equals(this.download, callbackSettingsTriggers.download) &&
        Objects.equals(this.delete, callbackSettingsTriggers.delete) &&
        Objects.equals(this.createFolder, callbackSettingsTriggers.createFolder) &&
        Objects.equals(this.rename, callbackSettingsTriggers.rename) &&
        Objects.equals(this.move, callbackSettingsTriggers.move) &&
        Objects.equals(this.copy, callbackSettingsTriggers.copy) &&
        Objects.equals(this.compress, callbackSettingsTriggers.compress) &&
        Objects.equals(this.extract, callbackSettingsTriggers.extract) &&
        Objects.equals(this.shareFolder, callbackSettingsTriggers.shareFolder) &&
        Objects.equals(this.sendFiles, callbackSettingsTriggers.sendFiles) &&
        Objects.equals(this.receiveFiles, callbackSettingsTriggers.receiveFiles) &&
        Objects.equals(this.updateShare, callbackSettingsTriggers.updateShare) &&
        Objects.equals(this.updateReceive, callbackSettingsTriggers.updateReceive) &&
        Objects.equals(this.deleteSend, callbackSettingsTriggers.deleteSend) &&
        Objects.equals(this.deleteReceive, callbackSettingsTriggers.deleteReceive) &&
        Objects.equals(this.deleteShare, callbackSettingsTriggers.deleteShare) &&
        Objects.equals(this.createNotification, callbackSettingsTriggers.createNotification) &&
        Objects.equals(this.updateNotification, callbackSettingsTriggers.updateNotification) &&
        Objects.equals(this.deleteNotification, callbackSettingsTriggers.deleteNotification) &&
        Objects.equals(this.createUser, callbackSettingsTriggers.createUser) &&
        Objects.equals(this.updateUser, callbackSettingsTriggers.updateUser) &&
        Objects.equals(this.deleteUser, callbackSettingsTriggers.deleteUser) &&
        Objects.equals(this.userConnect, callbackSettingsTriggers.userConnect) &&
        Objects.equals(this.userDisconnect, callbackSettingsTriggers.userDisconnect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(upload, download, delete, createFolder, rename, move, copy, compress, extract, shareFolder, sendFiles, receiveFiles, updateShare, updateReceive, deleteSend, deleteReceive, deleteShare, createNotification, updateNotification, deleteNotification, createUser, updateUser, deleteUser, userConnect, userDisconnect);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbackSettingsTriggers {\n");
    
    sb.append("    upload: ").append(toIndentedString(upload)).append("\n");
    sb.append("    download: ").append(toIndentedString(download)).append("\n");
    sb.append("    delete: ").append(toIndentedString(delete)).append("\n");
    sb.append("    createFolder: ").append(toIndentedString(createFolder)).append("\n");
    sb.append("    rename: ").append(toIndentedString(rename)).append("\n");
    sb.append("    move: ").append(toIndentedString(move)).append("\n");
    sb.append("    copy: ").append(toIndentedString(copy)).append("\n");
    sb.append("    compress: ").append(toIndentedString(compress)).append("\n");
    sb.append("    extract: ").append(toIndentedString(extract)).append("\n");
    sb.append("    shareFolder: ").append(toIndentedString(shareFolder)).append("\n");
    sb.append("    sendFiles: ").append(toIndentedString(sendFiles)).append("\n");
    sb.append("    receiveFiles: ").append(toIndentedString(receiveFiles)).append("\n");
    sb.append("    updateShare: ").append(toIndentedString(updateShare)).append("\n");
    sb.append("    updateReceive: ").append(toIndentedString(updateReceive)).append("\n");
    sb.append("    deleteSend: ").append(toIndentedString(deleteSend)).append("\n");
    sb.append("    deleteReceive: ").append(toIndentedString(deleteReceive)).append("\n");
    sb.append("    deleteShare: ").append(toIndentedString(deleteShare)).append("\n");
    sb.append("    createNotification: ").append(toIndentedString(createNotification)).append("\n");
    sb.append("    updateNotification: ").append(toIndentedString(updateNotification)).append("\n");
    sb.append("    deleteNotification: ").append(toIndentedString(deleteNotification)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    updateUser: ").append(toIndentedString(updateUser)).append("\n");
    sb.append("    deleteUser: ").append(toIndentedString(deleteUser)).append("\n");
    sb.append("    userConnect: ").append(toIndentedString(userConnect)).append("\n");
    sb.append("    userDisconnect: ").append(toIndentedString(userDisconnect)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
