/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications. Our API supports both GET and POST operations.  Capabilities of the API include:  - Uploading and downloading files. - Managing files and folders; including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and recieve folders.  - Setting up and managing notifications.  ## The API Endpoint  The ExaVault API is located at: https://api.exavault.com/v1/  # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Code-Libraries-and-Sample-PHP-Code/Obtain-your-API-key) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"e13395afc6278ce1555f\"></div>  ![ExaVault API Postman Colletion Usage](/images/postman.png)  If you'd prefer to skip Postman and start working with code directly, take a look at the sample code below.    # Code Libraries & Sample PHP Code  Once you're ready for full-scale development, we recommend looking at our code libraries available on [GitHub](https://github.com/ExaVault). We offer code libraries for [Python](https://github.com/ExaVault/evapi-python), [PHP](https://github.com/ExaVault/evapi-php) and [JavaScript](https://github.com/ExaVault/evapi-javascript).  While we recommend using our libraries, you're welcome to interact directly with our API via HTTP GET and POST requests -- a great option particularly if you're developing in a language for which we don't yet have sample code.     - [Download Python Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-python) - [Download PHP Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-php) - [Download JavaScript Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-javascript)  *Note: You can generate client libraries for any language using [Swagger Editor](http://editor2.swagger.io/). Just download our documentation file, past it into editor and use 'Generate Client' dropdown.*  ## Obtain Your API Key  You will need to obtain an API key for your application from the [Client Area](https://clients.exavault.com/clientarea.php?action=products) of your account.  To obtain an API key, please follow the instructions below.   + Login to the [Accounts](https://clients.exavault.com/clientarea.php?action=products) section of the Client Area.  + Use the drop down next to your desired account, and select *Manage API Keys*.  + You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.  *NOTE: As of Oct 2017, we are in the progress of migrating customers to our next generation platform. If your account is already on our new platform, you should log into your File Manager and create your API key under Account->Developer->Manage API Keys*.  # Status Codes  The ExaVault API returns only two HTTP status codes for its responses: 200 and 500.  When the request could be successfully processed by the endpoint, the response status code will be 200, regardless of whether the requested action could be taken.  For example, the response to a getUser request for a username that does not exist in your account would have the status of 200,  indicating that the response was received and processed, but the error member of the returned response object would contain object with `message` and `code` properties.  **Result Format:**  |Success   | Error     | Results   | | ---      | :---:       |  :---:      | | 0        |  `Object` |   Empty   | | 1        |   Empty       |    `Object` or `Array`        |     When a malformed request is received, a 500 HTTP status code will be returned, indicating that the request could not be processed.  ExaVault's API does not currently support traditional REST response codes such as '201 Created' or '405 Method Not Allowed', although we intend to support such codes a future version of the API.   # File Paths  Many API calls require you to provide one or more file paths. For example, the <a href=\"#operation/moveResources\">moveResources</a> call requires both an array of source paths, **filePaths**, and a destination path, **destinationPath**. Here's a few tips for working with paths:   - File paths should always be specified as a string, using the standard Unix format: e.g. `/path/to/a/file.txt`  - File paths are always absolute _from the home directory of the logged in user_. For example, if the user **bob** had a home directory restriction of `/bob_home`, then an API call made using his login would specify a file as `/myfile.txt`, whereas an API call made using the master user ( no home directory restriction ) would specify the same file as `/bob_home/myfile.txt`.  # API Rate Limits  We rate limit the number of API calls you can make to help prevent abuse and protect system stablity. Each API key will support 500 requests per rolling five minutes. If you make more than 500 requests in a five minute period, you will receive a response with an error object for fifteen minutes.  # Webhooks  A webhook is an HTTP callback: a simple event-notification via HTTP POST. If you define webhooks for Exavault, ExaVault will POST a  message to a URL when certain things happen.     Webhooks can be used to receive a JSON object to your endpoint URL. You choose what events will trigger webhook messages to your endpoint URL.     Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log.  ## Getting Started  1. Go to the Account tab inside SWFT.  2. Choose the Developer tab.  3. Configure your endpoint URL and select the events you want to trigger webhook messages.  4. Save settings.    You are all set to receive webhook callbacks on the events you selected.  ## Verification Signature  ExaVault includes a custom HTTP header, X-Exavault-Signature, with webhooks POST requests which will contain the signature for the request.  You can use the signature to verify the request for an additional level of security.  ## Generating the Signature  1. Go to Account tab inside SWFT.  2. Choose the Developer tab.  3. Obtain the verification token. This field will only be shown if you've configured your endpoint URL.  4. In your code that receives or processes the webhooks, you should concatenate the verification token with the JSON object that we sent in our      POST request and hash it with md5.     ```     md5($verificationToken.$webhooksObject);     ```  5. Compare signature that you generated to the signature provided in the X-Exavault-Signature HTTP header  ## Example JSON Response Object  ```json   {     \"accountname\": \"mycompanyname\",     \"username\": \"john\"     \"operation\": \"Upload\",     \"protocol\": \"https\",     \"path\": \"/testfolder/filename.jpg\"     \"attempt\": 1   } ```  ## Webhooks Logs  Keep track of all your webhooks requests in the Activity section of your account. You can find the following info for each request:    1. date and time - timestamp of the request.    2. endpoint url - where the webhook was sent.    3. event - what triggered the webhook.    4. status - HTTP status or curl error code.    5. attempt - how many times we tried to send this request.    6. response size - size of the response from your server.    7. details - you can check the response body if it was sent. 
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
 * DirectFile
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-08T13:26:53.154Z")
public class DirectFile {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("accountId")
  private String accountId = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("isEnabled")
  private String isEnabled = null;

  @SerializedName("isIndexEnabled")
  private String isIndexEnabled = null;

  @SerializedName("blockUntil")
  private String blockUntil = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("modified")
  private String modified = null;

  public DirectFile id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the direc file object.
   * @return id
  **/
  @ApiModelProperty(example = "74", value = "ID of the direc file object.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DirectFile accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * ID of the account this direct file object belongs to.
   * @return accountId
  **/
  @ApiModelProperty(example = "13058", value = "ID of the account this direct file object belongs to.")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public DirectFile path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Path to the folder direct file is set on.
   * @return path
  **/
  @ApiModelProperty(example = "/dfa folder", value = "Path to the folder direct file is set on.")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public DirectFile isEnabled(String isEnabled) {
    this.isEnabled = isEnabled;
    return this;
  }

   /**
   * Flag indicates if direct file is turned &#x60;on&#x60; or &#x60;off&#x60;.
   * @return isEnabled
  **/
  @ApiModelProperty(example = "1", value = "Flag indicates if direct file is turned `on` or `off`.")
  public String getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(String isEnabled) {
    this.isEnabled = isEnabled;
  }

  public DirectFile isIndexEnabled(String isIndexEnabled) {
    this.isIndexEnabled = isIndexEnabled;
    return this;
  }

   /**
   * Flag indicates if folder listing is &#x60;on&#x60; or &#x60;off&#x60;. If it is enabled you can see folder content in the browser.
   * @return isIndexEnabled
  **/
  @ApiModelProperty(example = "1", value = "Flag indicates if folder listing is `on` or `off`. If it is enabled you can see folder content in the browser.")
  public String getIsIndexEnabled() {
    return isIndexEnabled;
  }

  public void setIsIndexEnabled(String isIndexEnabled) {
    this.isIndexEnabled = isIndexEnabled;
  }

  public DirectFile blockUntil(String blockUntil) {
    this.blockUntil = blockUntil;
    return this;
  }

   /**
   * Timestamp of direct file block until date. Equals &#x60;0000-00-00 00:00:00&#x60; when no block date is setup. Used when direct file bandwidth quota limit crossed.
   * @return blockUntil
  **/
  @ApiModelProperty(example = "0000-00-00 00:00:00", value = "Timestamp of direct file block until date. Equals `0000-00-00 00:00:00` when no block date is setup. Used when direct file bandwidth quota limit crossed.")
  public String getBlockUntil() {
    return blockUntil;
  }

  public void setBlockUntil(String blockUntil) {
    this.blockUntil = blockUntil;
  }

  public DirectFile created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Unix timestamp of direct file creation.
   * @return created
  **/
  @ApiModelProperty(example = "1504201616", value = "Unix timestamp of direct file creation.")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public DirectFile modified(String modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Unix timestamp of direct file modification.
   * @return modified
  **/
  @ApiModelProperty(example = "1504201780", value = "Unix timestamp of direct file modification.")
  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DirectFile directFile = (DirectFile) o;
    return Objects.equals(this.id, directFile.id) &&
        Objects.equals(this.accountId, directFile.accountId) &&
        Objects.equals(this.path, directFile.path) &&
        Objects.equals(this.isEnabled, directFile.isEnabled) &&
        Objects.equals(this.isIndexEnabled, directFile.isIndexEnabled) &&
        Objects.equals(this.blockUntil, directFile.blockUntil) &&
        Objects.equals(this.created, directFile.created) &&
        Objects.equals(this.modified, directFile.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountId, path, isEnabled, isIndexEnabled, blockUntil, created, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DirectFile {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
    sb.append("    isIndexEnabled: ").append(toIndentedString(isIndexEnabled)).append("\n");
    sb.append("    blockUntil: ").append(toIndentedString(blockUntil)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
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

