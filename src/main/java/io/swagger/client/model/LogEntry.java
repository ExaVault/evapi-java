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
 * LogEntry
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-08T13:26:53.154Z")
public class LogEntry {
  @SerializedName("fileName")
  private String fileName = null;

  @SerializedName("fileSource")
  private String fileSource = null;

  /**
   * Type of operation that happened in the account.
   */
  @JsonAdapter(OperationEnum.Adapter.class)
  public enum OperationEnum {
    PASS("PASS"),
    
    EXIT("EXIT"),
    
    STOR("STOR"),
    
    RETR("RETR"),
    
    DELE("DELE"),
    
    MKD("MKD"),
    
    RMD("RMD"),
    
    RNTO("RNTO"),
    
    COPY("COPY"),
    
    MOVE("MOVE"),
    
    SEND("SEND"),
    
    SHARE("SHARE"),
    
    RECV("RECV"),
    
    NOTIFY("NOTIFY"),
    
    EDIT_SEND("EDIT_SEND"),
    
    EDIT_SHARE("EDIT_SHARE"),
    
    EDIT_RECV("EDIT_RECV"),
    
    EDIT_NTFY("EDIT_NTFY"),
    
    EDIT_USER("EDIT_USER"),
    
    DELE_SEND("DELE_SEND"),
    
    DELE_SHARE("DELE_SHARE"),
    
    DELE_NTFY("DELE_NTFY"),
    
    DELE_USER("DELE_USER"),
    
    DELE_RECV("DELE_RECV"),
    
    COMPR("COMPR"),
    
    EXTRACT("EXTRACT"),
    
    DFA("DFA"),
    
    EDIT_DFA("EDIT_DFA"),
    
    DELE_DFA("DELE_DFA");

    private String value;

    OperationEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OperationEnum fromValue(String text) {
      for (OperationEnum b : OperationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OperationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OperationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OperationEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OperationEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("operation")
  private OperationEnum operation = null;

  @SerializedName("duration")
  private String duration = null;

  @SerializedName("bytesTransferred")
  private String bytesTransferred = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("sessionId")
  private String sessionId = null;

  @SerializedName("ipAddress")
  private String ipAddress = null;

  @SerializedName("protocol")
  private String protocol = null;

  @SerializedName("status")
  private String status = null;

  public LogEntry fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

   /**
   * Current resource path.
   * @return fileName
  **/
  @ApiModelProperty(example = "/examplefolder/examplefile.JPG", value = "Current resource path.")
  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public LogEntry fileSource(String fileSource) {
    this.fileSource = fileSource;
    return this;
  }

   /**
   * Original path to the resource. Can be null if operation type not move or copy.
   * @return fileSource
  **/
  @ApiModelProperty(example = "", value = "Original path to the resource. Can be null if operation type not move or copy.")
  public String getFileSource() {
    return fileSource;
  }

  public void setFileSource(String fileSource) {
    this.fileSource = fileSource;
  }

  public LogEntry operation(OperationEnum operation) {
    this.operation = operation;
    return this;
  }

   /**
   * Type of operation that happened in the account.
   * @return operation
  **/
  @ApiModelProperty(example = "COPY", value = "Type of operation that happened in the account.")
  public OperationEnum getOperation() {
    return operation;
  }

  public void setOperation(OperationEnum operation) {
    this.operation = operation;
  }

  public LogEntry duration(String duration) {
    this.duration = duration;
    return this;
  }

   /**
   * Duration of the operation.
   * @return duration
  **/
  @ApiModelProperty(example = "21", value = "Duration of the operation.")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public LogEntry bytesTransferred(String bytesTransferred) {
    this.bytesTransferred = bytesTransferred;
    return this;
  }

   /**
   * Amount of bytes transfered during the operation.
   * @return bytesTransferred
  **/
  @ApiModelProperty(example = "2374534", value = "Amount of bytes transfered during the operation.")
  public String getBytesTransferred() {
    return bytesTransferred;
  }

  public void setBytesTransferred(String bytesTransferred) {
    this.bytesTransferred = bytesTransferred;
  }

  public LogEntry id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the log entry.
   * @return id
  **/
  @ApiModelProperty(example = "1352709977", value = "ID of the log entry.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LogEntry created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of the operation.
   * @return created
  **/
  @ApiModelProperty(example = "2017-05-29 14:46:30", value = "Timestamp of the operation.")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public LogEntry username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Name of the user who triggered the operation.
   * @return username
  **/
  @ApiModelProperty(example = "exampleuser", value = "Name of the user who triggered the operation.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public LogEntry sessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

   /**
   * ID of user&#39;s session.
   * @return sessionId
  **/
  @ApiModelProperty(example = "592c7a0e6a9297adc524f03a809e88", value = "ID of user's session.")
  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public LogEntry ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * IP address of the connected client.
   * @return ipAddress
  **/
  @ApiModelProperty(example = "93.172.190.132", value = "IP address of the connected client.")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public LogEntry protocol(String protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Protocol used for the operation. Protocol can vary on type of application you or your users used to work with your account. Some of possible values are &#x60;SWFT&#x60;, &#x60;APP&#x60;, &#x60;SFTP&#x60;, &#x60;FTP&#x60;, &#x60;FTPS&#x60;.
   * @return protocol
  **/
  @ApiModelProperty(example = "SWFT", value = "Protocol used for the operation. Protocol can vary on type of application you or your users used to work with your account. Some of possible values are `SWFT`, `APP`, `SFTP`, `FTP`, `FTPS`.")
  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public LogEntry status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Operation status.
   * @return status
  **/
  @ApiModelProperty(example = "success", value = "Operation status.")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogEntry logEntry = (LogEntry) o;
    return Objects.equals(this.fileName, logEntry.fileName) &&
        Objects.equals(this.fileSource, logEntry.fileSource) &&
        Objects.equals(this.operation, logEntry.operation) &&
        Objects.equals(this.duration, logEntry.duration) &&
        Objects.equals(this.bytesTransferred, logEntry.bytesTransferred) &&
        Objects.equals(this.id, logEntry.id) &&
        Objects.equals(this.created, logEntry.created) &&
        Objects.equals(this.username, logEntry.username) &&
        Objects.equals(this.sessionId, logEntry.sessionId) &&
        Objects.equals(this.ipAddress, logEntry.ipAddress) &&
        Objects.equals(this.protocol, logEntry.protocol) &&
        Objects.equals(this.status, logEntry.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileName, fileSource, operation, duration, bytesTransferred, id, created, username, sessionId, ipAddress, protocol, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogEntry {\n");
    
    sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
    sb.append("    fileSource: ").append(toIndentedString(fileSource)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    bytesTransferred: ").append(toIndentedString(bytesTransferred)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

