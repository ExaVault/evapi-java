/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications. Our API supports both GET and POST operations.  Capabilities of the API include:  - Uploading and downloading files. - Managing files and folders; including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and recieve folders.  - Setting up and managing notifications.  ## The API Endpoint  The ExaVault API is located at: https://api.exavault.com/v1.2/  # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Code-Libraries-and-Sample-PHP-Code/Obtain-your-API-key) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"e13395afc6278ce1555f\"></div>  ![ExaVault API Postman Colletion Usage](/images/postman.png)  If you'd prefer to skip Postman and start working with code directly, take a look at the sample code below.    # Code Libraries & Sample PHP Code  Once you're ready for full-scale development, we recommend looking at our code libraries available on [GitHub](https://github.com/ExaVault). We offer code libraries for [Python](https://github.com/ExaVault/evapi-python), [PHP](https://github.com/ExaVault/evapi-php) and [JavaScript](https://github.com/ExaVault/evapi-javascript).  While we recommend using our libraries, you're welcome to interact directly with our API via HTTP GET and POST requests -- a great option particularly if you're developing in a language for which we don't yet have sample code.     - [Download Python Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-python) - [Download PHP Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-php) - [Download JavaScript Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-javascript)  *Note: You can generate client libraries for any language using [Swagger Editor](http://editor2.swagger.io/). Just download our documentation file, past it into editor and use 'Generate Client' dropdown.*  ## Obtain Your API Key  You will need to obtain an API key for your application from the [Client Area](https://clients.exavault.com/clientarea.php?action=products) of your account.  To obtain an API key, please follow the instructions below.   + Login to the [Accounts](https://clients.exavault.com/clientarea.php?action=products) section of the Client Area.  + Use the drop down next to your desired account, and select *Manage API Keys*.  + You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.  *NOTE: As of Oct 2017, we are in the progress of migrating customers to our next generation platform. If your account is already on our new platform, you should log into your File Manager and create your API key under Account->Developer->Manage API Keys*.  # Status Codes  The ExaVault API returns only two HTTP status codes for its responses: 200 and 500.  When the request could be successfully processed by the endpoint, the response status code will be 200, regardless of whether the requested action could be taken.  For example, the response to a getUser request for a username that does not exist in your account would have the status of 200,  indicating that the response was received and processed, but the error member of the returned response object would contain object with `message` and `code` properties.  **Result Format:**  |Success   | Error     | Results   | | ---      | :---:       |  :---:      | | 0        |  `Object` |   Empty   | | 1        |   Empty       |    `Object` or `Array`        |     When a malformed request is received, a 500 HTTP status code will be returned, indicating that the request could not be processed.  ExaVault's API does not currently support traditional REST response codes such as '201 Created' or '405 Method Not Allowed', although we intend to support such codes a future version of the API.   # File Paths  Many API calls require you to provide one or more file paths. For example, the <a href=\"#operation/moveResources\">moveResources</a> call requires both an array of source paths, **filePaths**, and a destination path, **destinationPath**. Here's a few tips for working with paths:   - File paths should always be specified as a string, using the standard Unix format: e.g. `/path/to/a/file.txt`  - File paths are always absolute _from the home directory of the logged in user_. For example, if the user **bob** had a home directory restriction of `/bob_home`, then an API call made using his login would specify a file as `/myfile.txt`, whereas an API call made using the master user ( no home directory restriction ) would specify the same file as `/bob_home/myfile.txt`.  # API Rate Limits  We rate limit the number of API calls you can make to help prevent abuse and protect system stablity. Each API key will support 500 requests per rolling five minutes. If you make more than 500 requests in a five minute period, you will receive a response with an error object for fifteen minutes.  # Webhooks  A webhook is an HTTP callback: a simple event-notification via HTTP POST. If you define webhooks for Exavault, ExaVault will POST a  message to a URL when certain things happen.     Webhooks can be used to receive a JSON object to your endpoint URL. You choose what events will trigger webhook messages to your endpoint URL.     Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log.  ## Getting Started  1. Go to the Account tab inside SWFT.  2. Choose the Developer tab.  3. Configure your endpoint URL and select the events you want to trigger webhook messages.  4. Save settings.    You are all set to receive webhook callbacks on the events you selected.  ## Verification Signature  ExaVault includes a custom HTTP header, X-Exavault-Signature, with webhooks POST requests which will contain the signature for the request.  You can use the signature to verify the request for an additional level of security.  ## Generating the Signature  1. Go to Account tab inside SWFT.  2. Choose the Developer tab.  3. Obtain the verification token. This field will only be shown if you've configured your endpoint URL.  4. In your code that receives or processes the webhooks, you should concatenate the verification token with the JSON object that we sent in our      POST request and hash it with md5.     ```     md5($verificationToken.$webhooksObject);     ```  5. Compare signature that you generated to the signature provided in the X-Exavault-Signature HTTP header  ## Example JSON Response Object  ```json   {     \"accountname\": \"mycompanyname\",     \"username\": \"john\"     \"operation\": \"Upload\",     \"protocol\": \"https\",     \"path\": \"/testfolder/filename.jpg\"     \"attempt\": 1   } ```  ## Webhooks Logs  Keep track of all your webhooks requests in the Activity section of your account. You can find the following info for each request:    1. date and time - timestamp of the request.    2. endpoint url - where the webhook was sent.    3. event - what triggered the webhook.    4. status - HTTP status or curl error code.    5. attempt - how many times we tried to send this request.    6. response size - size of the response from your server.    7. details - you can check the response body if it was sent. 
 *
 * OpenAPI spec version: 1.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CallbackSettings
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-08T13:26:53.154Z")
public class CallbackSettings {
  @SerializedName("accountId")
  private String accountId = null;

  @SerializedName("endpointUrl")
  private String endpointUrl = null;

  @SerializedName("token")
  private String token = null;

  @SerializedName("upload")
  private String upload = null;

  @SerializedName("download")
  private String download = null;

  @SerializedName("delete")
  private String delete = null;

  @SerializedName("createFolder")
  private String createFolder = null;

  @SerializedName("rename")
  private String rename = null;

  @SerializedName("move")
  private String move = null;

  @SerializedName("copy")
  private String copy = null;

  @SerializedName("compress")
  private String compress = null;

  @SerializedName("extract")
  private String extract = null;

  @SerializedName("shareFolder")
  private String shareFolder = null;

  @SerializedName("sendFiles")
  private String sendFiles = null;

  @SerializedName("receiveFiles")
  private String receiveFiles = null;

  @SerializedName("updateShare")
  private String updateShare = null;

  @SerializedName("updateReceive")
  private String updateReceive = null;

  @SerializedName("deleteSend")
  private String deleteSend = null;

  @SerializedName("deleteReceive")
  private String deleteReceive = null;

  @SerializedName("deleteShare")
  private String deleteShare = null;

  @SerializedName("createNotification")
  private String createNotification = null;

  @SerializedName("updateNotification")
  private String updateNotification = null;

  @SerializedName("deleteNotification")
  private String deleteNotification = null;

  @SerializedName("createUser")
  private String createUser = null;

  @SerializedName("updateUser")
  private String updateUser = null;

  @SerializedName("deleteUser")
  private String deleteUser = null;

  @SerializedName("userConnect")
  private String userConnect = null;

  @SerializedName("userDisconnect")
  private String userDisconnect = null;

  public CallbackSettings accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * ID of the account these settings belongs to.
   * @return accountId
  **/
  @ApiModelProperty(example = "13058", value = "ID of the account these settings belongs to.")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public CallbackSettings endpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
    return this;
  }

   /**
   * Where callback settings object sent to.
   * @return endpointUrl
  **/
  @ApiModelProperty(example = "http://test-endpoint.exavault.com", value = "Where callback settings object sent to.")
  public String getEndpointUrl() {
    return endpointUrl;
  }

  public void setEndpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
  }

  public CallbackSettings token(String token) {
    this.token = token;
    return this;
  }

   /**
   * Verification token for the request authentication.
   * @return token
  **/
  @ApiModelProperty(example = "380814daa6886641d2ffsw2f43b30312", value = "Verification token for the request authentication.")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public CallbackSettings upload(String upload) {
    this.upload = upload;
    return this;
  }

   /**
   * Trigger callback on upload.
   * @return upload
  **/
  @ApiModelProperty(example = "1", value = "Trigger callback on upload.")
  public String getUpload() {
    return upload;
  }

  public void setUpload(String upload) {
    this.upload = upload;
  }

  public CallbackSettings download(String download) {
    this.download = download;
    return this;
  }

   /**
   * Trigger callback on download.
   * @return download
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on download.")
  public String getDownload() {
    return download;
  }

  public void setDownload(String download) {
    this.download = download;
  }

  public CallbackSettings delete(String delete) {
    this.delete = delete;
    return this;
  }

   /**
   * Trigger callback on delete.
   * @return delete
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on delete.")
  public String getDelete() {
    return delete;
  }

  public void setDelete(String delete) {
    this.delete = delete;
  }

  public CallbackSettings createFolder(String createFolder) {
    this.createFolder = createFolder;
    return this;
  }

   /**
   * Trigger callback on fodler create.
   * @return createFolder
  **/
  @ApiModelProperty(example = "1", value = "Trigger callback on fodler create.")
  public String getCreateFolder() {
    return createFolder;
  }

  public void setCreateFolder(String createFolder) {
    this.createFolder = createFolder;
  }

  public CallbackSettings rename(String rename) {
    this.rename = rename;
    return this;
  }

   /**
   * Trigger callback on rename.
   * @return rename
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on rename.")
  public String getRename() {
    return rename;
  }

  public void setRename(String rename) {
    this.rename = rename;
  }

  public CallbackSettings move(String move) {
    this.move = move;
    return this;
  }

   /**
   * Trigger callback on move.
   * @return move
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on move.")
  public String getMove() {
    return move;
  }

  public void setMove(String move) {
    this.move = move;
  }

  public CallbackSettings copy(String copy) {
    this.copy = copy;
    return this;
  }

   /**
   * Trigger callback on copy.
   * @return copy
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on copy.")
  public String getCopy() {
    return copy;
  }

  public void setCopy(String copy) {
    this.copy = copy;
  }

  public CallbackSettings compress(String compress) {
    this.compress = compress;
    return this;
  }

   /**
   * Trigger callback on compress.
   * @return compress
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on compress.")
  public String getCompress() {
    return compress;
  }

  public void setCompress(String compress) {
    this.compress = compress;
  }

  public CallbackSettings extract(String extract) {
    this.extract = extract;
    return this;
  }

   /**
   * Trigger callback on extract.
   * @return extract
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on extract.")
  public String getExtract() {
    return extract;
  }

  public void setExtract(String extract) {
    this.extract = extract;
  }

  public CallbackSettings shareFolder(String shareFolder) {
    this.shareFolder = shareFolder;
    return this;
  }

   /**
   * Trigger callback on share folder create.
   * @return shareFolder
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on share folder create.")
  public String getShareFolder() {
    return shareFolder;
  }

  public void setShareFolder(String shareFolder) {
    this.shareFolder = shareFolder;
  }

  public CallbackSettings sendFiles(String sendFiles) {
    this.sendFiles = sendFiles;
    return this;
  }

   /**
   * Trigger callback on send files.
   * @return sendFiles
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on send files.")
  public String getSendFiles() {
    return sendFiles;
  }

  public void setSendFiles(String sendFiles) {
    this.sendFiles = sendFiles;
  }

  public CallbackSettings receiveFiles(String receiveFiles) {
    this.receiveFiles = receiveFiles;
    return this;
  }

   /**
   * Trigger callback on receive folder create.
   * @return receiveFiles
  **/
  @ApiModelProperty(example = "1", value = "Trigger callback on receive folder create.")
  public String getReceiveFiles() {
    return receiveFiles;
  }

  public void setReceiveFiles(String receiveFiles) {
    this.receiveFiles = receiveFiles;
  }

  public CallbackSettings updateShare(String updateShare) {
    this.updateShare = updateShare;
    return this;
  }

   /**
   * Trigger callback on share folder update.
   * @return updateShare
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on share folder update.")
  public String getUpdateShare() {
    return updateShare;
  }

  public void setUpdateShare(String updateShare) {
    this.updateShare = updateShare;
  }

  public CallbackSettings updateReceive(String updateReceive) {
    this.updateReceive = updateReceive;
    return this;
  }

   /**
   * Trigger callback on receive folder update.
   * @return updateReceive
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on receive folder update.")
  public String getUpdateReceive() {
    return updateReceive;
  }

  public void setUpdateReceive(String updateReceive) {
    this.updateReceive = updateReceive;
  }

  public CallbackSettings deleteSend(String deleteSend) {
    this.deleteSend = deleteSend;
    return this;
  }

   /**
   * Trigger callback on send files delete.
   * @return deleteSend
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on send files delete.")
  public String getDeleteSend() {
    return deleteSend;
  }

  public void setDeleteSend(String deleteSend) {
    this.deleteSend = deleteSend;
  }

  public CallbackSettings deleteReceive(String deleteReceive) {
    this.deleteReceive = deleteReceive;
    return this;
  }

   /**
   * Trigger callback on receive folder delete.
   * @return deleteReceive
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on receive folder delete.")
  public String getDeleteReceive() {
    return deleteReceive;
  }

  public void setDeleteReceive(String deleteReceive) {
    this.deleteReceive = deleteReceive;
  }

  public CallbackSettings deleteShare(String deleteShare) {
    this.deleteShare = deleteShare;
    return this;
  }

   /**
   * Trigger callback on share folder delete.
   * @return deleteShare
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on share folder delete.")
  public String getDeleteShare() {
    return deleteShare;
  }

  public void setDeleteShare(String deleteShare) {
    this.deleteShare = deleteShare;
  }

  public CallbackSettings createNotification(String createNotification) {
    this.createNotification = createNotification;
    return this;
  }

   /**
   * Trigger callback on notification create.
   * @return createNotification
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on notification create.")
  public String getCreateNotification() {
    return createNotification;
  }

  public void setCreateNotification(String createNotification) {
    this.createNotification = createNotification;
  }

  public CallbackSettings updateNotification(String updateNotification) {
    this.updateNotification = updateNotification;
    return this;
  }

   /**
   * Trigger callback on notification update.
   * @return updateNotification
  **/
  @ApiModelProperty(example = "1", value = "Trigger callback on notification update.")
  public String getUpdateNotification() {
    return updateNotification;
  }

  public void setUpdateNotification(String updateNotification) {
    this.updateNotification = updateNotification;
  }

  public CallbackSettings deleteNotification(String deleteNotification) {
    this.deleteNotification = deleteNotification;
    return this;
  }

   /**
   * Trigger callback on notification delete.
   * @return deleteNotification
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on notification delete.")
  public String getDeleteNotification() {
    return deleteNotification;
  }

  public void setDeleteNotification(String deleteNotification) {
    this.deleteNotification = deleteNotification;
  }

  public CallbackSettings createUser(String createUser) {
    this.createUser = createUser;
    return this;
  }

   /**
   * Trigger callback on user create.
   * @return createUser
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on user create.")
  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public CallbackSettings updateUser(String updateUser) {
    this.updateUser = updateUser;
    return this;
  }

   /**
   * Trigger callback on user update.
   * @return updateUser
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on user update.")
  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public CallbackSettings deleteUser(String deleteUser) {
    this.deleteUser = deleteUser;
    return this;
  }

   /**
   * Trigger callback on user delete.
   * @return deleteUser
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on user delete.")
  public String getDeleteUser() {
    return deleteUser;
  }

  public void setDeleteUser(String deleteUser) {
    this.deleteUser = deleteUser;
  }

  public CallbackSettings userConnect(String userConnect) {
    this.userConnect = userConnect;
    return this;
  }

   /**
   * Trigger callback on user connect.
   * @return userConnect
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on user connect.")
  public String getUserConnect() {
    return userConnect;
  }

  public void setUserConnect(String userConnect) {
    this.userConnect = userConnect;
  }

  public CallbackSettings userDisconnect(String userDisconnect) {
    this.userDisconnect = userDisconnect;
    return this;
  }

   /**
   * Trigger callback on user disconnect.
   * @return userDisconnect
  **/
  @ApiModelProperty(example = "0", value = "Trigger callback on user disconnect.")
  public String getUserDisconnect() {
    return userDisconnect;
  }

  public void setUserDisconnect(String userDisconnect) {
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
    CallbackSettings callbackSettings = (CallbackSettings) o;
    return Objects.equals(this.accountId, callbackSettings.accountId) &&
        Objects.equals(this.endpointUrl, callbackSettings.endpointUrl) &&
        Objects.equals(this.token, callbackSettings.token) &&
        Objects.equals(this.upload, callbackSettings.upload) &&
        Objects.equals(this.download, callbackSettings.download) &&
        Objects.equals(this.delete, callbackSettings.delete) &&
        Objects.equals(this.createFolder, callbackSettings.createFolder) &&
        Objects.equals(this.rename, callbackSettings.rename) &&
        Objects.equals(this.move, callbackSettings.move) &&
        Objects.equals(this.copy, callbackSettings.copy) &&
        Objects.equals(this.compress, callbackSettings.compress) &&
        Objects.equals(this.extract, callbackSettings.extract) &&
        Objects.equals(this.shareFolder, callbackSettings.shareFolder) &&
        Objects.equals(this.sendFiles, callbackSettings.sendFiles) &&
        Objects.equals(this.receiveFiles, callbackSettings.receiveFiles) &&
        Objects.equals(this.updateShare, callbackSettings.updateShare) &&
        Objects.equals(this.updateReceive, callbackSettings.updateReceive) &&
        Objects.equals(this.deleteSend, callbackSettings.deleteSend) &&
        Objects.equals(this.deleteReceive, callbackSettings.deleteReceive) &&
        Objects.equals(this.deleteShare, callbackSettings.deleteShare) &&
        Objects.equals(this.createNotification, callbackSettings.createNotification) &&
        Objects.equals(this.updateNotification, callbackSettings.updateNotification) &&
        Objects.equals(this.deleteNotification, callbackSettings.deleteNotification) &&
        Objects.equals(this.createUser, callbackSettings.createUser) &&
        Objects.equals(this.updateUser, callbackSettings.updateUser) &&
        Objects.equals(this.deleteUser, callbackSettings.deleteUser) &&
        Objects.equals(this.userConnect, callbackSettings.userConnect) &&
        Objects.equals(this.userDisconnect, callbackSettings.userDisconnect);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, endpointUrl, token, upload, download, delete, createFolder, rename, move, copy, compress, extract, shareFolder, sendFiles, receiveFiles, updateShare, updateReceive, deleteSend, deleteReceive, deleteShare, createNotification, updateNotification, deleteNotification, createUser, updateUser, deleteUser, userConnect, userDisconnect);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbackSettings {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    endpointUrl: ").append(toIndentedString(endpointUrl)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

