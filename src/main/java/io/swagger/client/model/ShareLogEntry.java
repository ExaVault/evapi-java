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


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ShareLogEntry
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-20T15:12:25.985Z")
public class ShareLogEntry {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("shareId")
  private String shareId = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("action")
  private String action = null;

  @SerializedName("actionObjectId")
  private String actionObjectId = null;

  @SerializedName("detail")
  private String detail = null;

  @SerializedName("created")
  private String created = null;

  public ShareLogEntry id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the log entry.
   * @return id
  **/
  @ApiModelProperty(example = "1853767", value = "ID of the log entry.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ShareLogEntry shareId(String shareId) {
    this.shareId = shareId;
    return this;
  }

   /**
   * ID of the share this log entry belongs to.
   * @return shareId
  **/
  @ApiModelProperty(example = "744851", value = "ID of the share this log entry belongs to.")
  public String getShareId() {
    return shareId;
  }

  public void setShareId(String shareId) {
    this.shareId = shareId;
  }

  public ShareLogEntry username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Username of the user triggered the action.
   * @return username
  **/
  @ApiModelProperty(example = "exavaultuser", value = "Username of the user triggered the action.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public ShareLogEntry action(String action) {
    this.action = action;
    return this;
  }

   /**
   * Type of the action that happened in the share.
   * @return action
  **/
  @ApiModelProperty(example = "create", value = "Type of the action that happened in the share.")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public ShareLogEntry actionObjectId(String actionObjectId) {
    this.actionObjectId = actionObjectId;
    return this;
  }

   /**
   * ID of the object that the action happened to.
   * @return actionObjectId
  **/
  @ApiModelProperty(example = "21", value = "ID of the object that the action happened to.")
  public String getActionObjectId() {
    return actionObjectId;
  }

  public void setActionObjectId(String actionObjectId) {
    this.actionObjectId = actionObjectId;
  }

  public ShareLogEntry detail(String detail) {
    this.detail = detail;
    return this;
  }

   /**
   * Recipients the share was sent to.
   * @return detail
  **/
  @ApiModelProperty(example = "test@email.com", value = "Recipients the share was sent to.")
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public ShareLogEntry created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of the operation.
   * @return created
  **/
  @ApiModelProperty(example = "2017-05-03 17:52:01", value = "Timestamp of the operation.")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShareLogEntry shareLogEntry = (ShareLogEntry) o;
    return Objects.equals(this.id, shareLogEntry.id) &&
        Objects.equals(this.shareId, shareLogEntry.shareId) &&
        Objects.equals(this.username, shareLogEntry.username) &&
        Objects.equals(this.action, shareLogEntry.action) &&
        Objects.equals(this.actionObjectId, shareLogEntry.actionObjectId) &&
        Objects.equals(this.detail, shareLogEntry.detail) &&
        Objects.equals(this.created, shareLogEntry.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, shareId, username, action, actionObjectId, detail, created);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShareLogEntry {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    shareId: ").append(toIndentedString(shareId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    actionObjectId: ").append(toIndentedString(actionObjectId)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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

