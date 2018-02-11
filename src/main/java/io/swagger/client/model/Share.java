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
import io.swagger.client.model.Message;
import io.swagger.client.model.ShareRecipient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Object contains share properties.
 */
@ApiModel(description = "Object contains share properties.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-08T13:26:53.154Z")
public class Share {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("hasPassword")
  private Boolean hasPassword = null;

  @SerializedName("public")
  private Boolean _public = null;

  /**
   * Access rights for the share.
   */
  @JsonAdapter(AccessModeEnum.Adapter.class)
  public enum AccessModeEnum {
    UPLOAD("upload"),
    
    DOWNLOAD("download"),
    
    DOWNLOAD_UPLOAD("download_upload"),
    
    DOWNLOAD_UPLOAD_MODIFY_DELETE("download_upload_modify_delete");

    private String value;

    AccessModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static AccessModeEnum fromValue(String text) {
      for (AccessModeEnum b : AccessModeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<AccessModeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final AccessModeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public AccessModeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return AccessModeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("accessMode")
  private AccessModeEnum accessMode = null;

  @SerializedName("accessDescription")
  private String accessDescription = null;

  @SerializedName("embed")
  private Boolean embed = null;

  @SerializedName("hash")
  private String hash = null;

  @SerializedName("ownerHash")
  private String ownerHash = null;

  @SerializedName("expiration")
  private String expiration = null;

  @SerializedName("expired")
  private Boolean expired = null;

  @SerializedName("resent")
  private String resent = null;

  @SerializedName("owner")
  private Integer owner = null;

  @SerializedName("ownerUsername")
  private String ownerUsername = null;

  /**
   * Type of share.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    SHARED_FOLDER("shared_folder"),
    
    SEND("send"),
    
    RECEIVE("receive");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;

  @SerializedName("requireEmail")
  private Boolean requireEmail = null;

  @SerializedName("fileDropCreateFolders")
  private Boolean fileDropCreateFolders = null;

  @SerializedName("paths")
  private List<String> paths = null;

  @SerializedName("recipients")
  private List<ShareRecipient> recipients = null;

  @SerializedName("recipientsWithOwner")
  private List<ShareRecipient> recipientsWithOwner = null;

  @SerializedName("messages")
  private List<Message> messages = null;

  @SerializedName("inherited")
  private Boolean inherited = null;

  /**
   * Share activity status. Can be active (1) or deactivated (0).
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    NUMBER_0(0),
    
    NUMBER_1(1);

    private Integer value;

    StatusEnum(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        Integer value = jsonReader.nextInt();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("hasNotification")
  private Boolean hasNotification = null;

  @SerializedName("notification")
  private String notification = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("modified")
  private String modified = null;

  public Share id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the share.
   * @return id
  **/
  @ApiModelProperty(example = "655621", value = "ID of the share.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Share name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Share name.
   * @return name
  **/
  @ApiModelProperty(example = "Example Folder", value = "Share name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Share hasPassword(Boolean hasPassword) {
    this.hasPassword = hasPassword;
    return this;
  }

   /**
   * True if the share has password.
   * @return hasPassword
  **/
  @ApiModelProperty(example = "false", value = "True if the share has password.")
  public Boolean getHasPassword() {
    return hasPassword;
  }

  public void setHasPassword(Boolean hasPassword) {
    this.hasPassword = hasPassword;
  }

  public Share _public(Boolean _public) {
    this._public = _public;
    return this;
  }

   /**
   * True if the share has a public url.
   * @return _public
  **/
  @ApiModelProperty(example = "true", value = "True if the share has a public url.")
  public Boolean getPublic() {
    return _public;
  }

  public void setPublic(Boolean _public) {
    this._public = _public;
  }

  public Share accessMode(AccessModeEnum accessMode) {
    this.accessMode = accessMode;
    return this;
  }

   /**
   * Access rights for the share.
   * @return accessMode
  **/
  @ApiModelProperty(example = "upload", value = "Access rights for the share.")
  public AccessModeEnum getAccessMode() {
    return accessMode;
  }

  public void setAccessMode(AccessModeEnum accessMode) {
    this.accessMode = accessMode;
  }

  public Share accessDescription(String accessDescription) {
    this.accessDescription = accessDescription;
    return this;
  }

   /**
   * Description of the share access rights.
   * @return accessDescription
  **/
  @ApiModelProperty(example = "Download only", value = "Description of the share access rights.")
  public String getAccessDescription() {
    return accessDescription;
  }

  public void setAccessDescription(String accessDescription) {
    this.accessDescription = accessDescription;
  }

  public Share embed(Boolean embed) {
    this.embed = embed;
    return this;
  }

   /**
   * True if share can be embedded.
   * @return embed
  **/
  @ApiModelProperty(example = "false", value = "True if share can be embedded.")
  public Boolean getEmbed() {
    return embed;
  }

  public void setEmbed(Boolean embed) {
    this.embed = embed;
  }

  public Share hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * Share hash.
   * @return hash
  **/
  @ApiModelProperty(example = "hd1e-3erufo72", value = "Share hash.")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public Share ownerHash(String ownerHash) {
    this.ownerHash = ownerHash;
    return this;
  }

   /**
   * Share owner&#39;s hash.
   * @return ownerHash
  **/
  @ApiModelProperty(example = "hd1e-3erufo72-fsxak999", value = "Share owner's hash.")
  public String getOwnerHash() {
    return ownerHash;
  }

  public void setOwnerHash(String ownerHash) {
    this.ownerHash = ownerHash;
  }

  public Share expiration(String expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Expiration date of the share.
   * @return expiration
  **/
  @ApiModelProperty(value = "Expiration date of the share.")
  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public Share expired(Boolean expired) {
    this.expired = expired;
    return this;
  }

   /**
   * True if the share has expired.
   * @return expired
  **/
  @ApiModelProperty(example = "false", value = "True if the share has expired.")
  public Boolean getExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  public Share resent(String resent) {
    this.resent = resent;
    return this;
  }

   /**
   * Invitations resent date. Can be &#x60;null&#x60; if resent never happened.
   * @return resent
  **/
  @ApiModelProperty(value = "Invitations resent date. Can be `null` if resent never happened.")
  public String getResent() {
    return resent;
  }

  public void setResent(String resent) {
    this.resent = resent;
  }

  public Share owner(Integer owner) {
    this.owner = owner;
    return this;
  }

   /**
   * ID of the share owner.
   * @return owner
  **/
  @ApiModelProperty(example = "192667", value = "ID of the share owner.")
  public Integer getOwner() {
    return owner;
  }

  public void setOwner(Integer owner) {
    this.owner = owner;
  }

  public Share ownerUsername(String ownerUsername) {
    this.ownerUsername = ownerUsername;
    return this;
  }

   /**
   * Username of share owner.
   * @return ownerUsername
  **/
  @ApiModelProperty(example = "exavaultuser", value = "Username of share owner.")
  public String getOwnerUsername() {
    return ownerUsername;
  }

  public void setOwnerUsername(String ownerUsername) {
    this.ownerUsername = ownerUsername;
  }

  public Share type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Type of share.
   * @return type
  **/
  @ApiModelProperty(example = "shared_folder", value = "Type of share.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Share requireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
    return this;
  }

   /**
   * True if share requires email to access.
   * @return requireEmail
  **/
  @ApiModelProperty(example = "true", value = "True if share requires email to access.")
  public Boolean getRequireEmail() {
    return requireEmail;
  }

  public void setRequireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
  }

  public Share fileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
    return this;
  }

   /**
   * Flag to show if separate folders should be created for each file upload to receive folder.
   * @return fileDropCreateFolders
  **/
  @ApiModelProperty(example = "false", value = "Flag to show if separate folders should be created for each file upload to receive folder.")
  public Boolean getFileDropCreateFolders() {
    return fileDropCreateFolders;
  }

  public void setFileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
  }

  public Share paths(List<String> paths) {
    this.paths = paths;
    return this;
  }

  public Share addPathsItem(String pathsItem) {
    if (this.paths == null) {
      this.paths = new ArrayList<String>();
    }
    this.paths.add(pathsItem);
    return this;
  }

   /**
   * Path to the shared resource in your account.
   * @return paths
  **/
  @ApiModelProperty(example = "[\"/Example Folder\"]", value = "Path to the shared resource in your account.")
  public List<String> getPaths() {
    return paths;
  }

  public void setPaths(List<String> paths) {
    this.paths = paths;
  }

  public Share recipients(List<ShareRecipient> recipients) {
    this.recipients = recipients;
    return this;
  }

  public Share addRecipientsItem(ShareRecipient recipientsItem) {
    if (this.recipients == null) {
      this.recipients = new ArrayList<ShareRecipient>();
    }
    this.recipients.add(recipientsItem);
    return this;
  }

   /**
   * Array of recipients.
   * @return recipients
  **/
  @ApiModelProperty(example = "[{\"id\":2,\"shareId\":23,\"type\":\"direct\",\"hash\":\"fseowxan\",\"email\":\"recipient@gmail.com\",\"sent\":true,\"received\":false,\"created\":\"2017-04-21 10:53:47\"}]", value = "Array of recipients.")
  public List<ShareRecipient> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<ShareRecipient> recipients) {
    this.recipients = recipients;
  }

  public Share recipientsWithOwner(List<ShareRecipient> recipientsWithOwner) {
    this.recipientsWithOwner = recipientsWithOwner;
    return this;
  }

  public Share addRecipientsWithOwnerItem(ShareRecipient recipientsWithOwnerItem) {
    if (this.recipientsWithOwner == null) {
      this.recipientsWithOwner = new ArrayList<ShareRecipient>();
    }
    this.recipientsWithOwner.add(recipientsWithOwnerItem);
    return this;
  }

   /**
   * Array of recipients with owner.
   * @return recipientsWithOwner
  **/
  @ApiModelProperty(example = "[{\"id\":null,\"shareId\":23,\"type\":\"owner\",\"hash\":\"fsxak999\",\"email\":\"owner@exavault.com\",\"sent\":false,\"received\":false,\"created\":null},{\"id\":2,\"shareId\":23,\"type\":\"direct\",\"hash\":\"fseowxan\",\"email\":\"recipient@gmail.com\",\"sent\":true,\"received\":false,\"created\":\"2017-04-21 10:53:47\"}]", value = "Array of recipients with owner.")
  public List<ShareRecipient> getRecipientsWithOwner() {
    return recipientsWithOwner;
  }

  public void setRecipientsWithOwner(List<ShareRecipient> recipientsWithOwner) {
    this.recipientsWithOwner = recipientsWithOwner;
  }

  public Share messages(List<Message> messages) {
    this.messages = messages;
    return this;
  }

  public Share addMessagesItem(Message messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<Message>();
    }
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * Array of invitation messages.
   * @return messages
  **/
  @ApiModelProperty(value = "Array of invitation messages.")
  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public Share inherited(Boolean inherited) {
    this.inherited = inherited;
    return this;
  }

   /**
   * True if share inherited from parent folder.
   * @return inherited
  **/
  @ApiModelProperty(example = "false", value = "True if share inherited from parent folder.")
  public Boolean getInherited() {
    return inherited;
  }

  public void setInherited(Boolean inherited) {
    this.inherited = inherited;
  }

  public Share status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Share activity status. Can be active (1) or deactivated (0).
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "Share activity status. Can be active (1) or deactivated (0).")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Share hasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
    return this;
  }

   /**
   * True if share has notification.
   * @return hasNotification
  **/
  @ApiModelProperty(example = "false", value = "True if share has notification.")
  public Boolean getHasNotification() {
    return hasNotification;
  }

  public void setHasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
  }

  public Share notification(String notification) {
    this.notification = notification;
    return this;
  }

   /**
   * Notification object if share has one.
   * @return notification
  **/
  @ApiModelProperty(value = "Notification object if share has one.")
  public String getNotification() {
    return notification;
  }

  public void setNotification(String notification) {
    this.notification = notification;
  }

  public Share created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of share creation.
   * @return created
  **/
  @ApiModelProperty(example = "2017-05-03 5:49:34 pm", value = "Timestamp of share creation.")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Share modified(String modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp of share modification. Can be &#x60;null&#x60; if it wasn&#39;t modified.
   * @return modified
  **/
  @ApiModelProperty(value = "Timestamp of share modification. Can be `null` if it wasn't modified.")
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
    Share share = (Share) o;
    return Objects.equals(this.id, share.id) &&
        Objects.equals(this.name, share.name) &&
        Objects.equals(this.hasPassword, share.hasPassword) &&
        Objects.equals(this._public, share._public) &&
        Objects.equals(this.accessMode, share.accessMode) &&
        Objects.equals(this.accessDescription, share.accessDescription) &&
        Objects.equals(this.embed, share.embed) &&
        Objects.equals(this.hash, share.hash) &&
        Objects.equals(this.ownerHash, share.ownerHash) &&
        Objects.equals(this.expiration, share.expiration) &&
        Objects.equals(this.expired, share.expired) &&
        Objects.equals(this.resent, share.resent) &&
        Objects.equals(this.owner, share.owner) &&
        Objects.equals(this.ownerUsername, share.ownerUsername) &&
        Objects.equals(this.type, share.type) &&
        Objects.equals(this.requireEmail, share.requireEmail) &&
        Objects.equals(this.fileDropCreateFolders, share.fileDropCreateFolders) &&
        Objects.equals(this.paths, share.paths) &&
        Objects.equals(this.recipients, share.recipients) &&
        Objects.equals(this.recipientsWithOwner, share.recipientsWithOwner) &&
        Objects.equals(this.messages, share.messages) &&
        Objects.equals(this.inherited, share.inherited) &&
        Objects.equals(this.status, share.status) &&
        Objects.equals(this.hasNotification, share.hasNotification) &&
        Objects.equals(this.notification, share.notification) &&
        Objects.equals(this.created, share.created) &&
        Objects.equals(this.modified, share.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, hasPassword, _public, accessMode, accessDescription, embed, hash, ownerHash, expiration, expired, resent, owner, ownerUsername, type, requireEmail, fileDropCreateFolders, paths, recipients, recipientsWithOwner, messages, inherited, status, hasNotification, notification, created, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Share {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    hasPassword: ").append(toIndentedString(hasPassword)).append("\n");
    sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
    sb.append("    accessMode: ").append(toIndentedString(accessMode)).append("\n");
    sb.append("    accessDescription: ").append(toIndentedString(accessDescription)).append("\n");
    sb.append("    embed: ").append(toIndentedString(embed)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    ownerHash: ").append(toIndentedString(ownerHash)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
    sb.append("    resent: ").append(toIndentedString(resent)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    ownerUsername: ").append(toIndentedString(ownerUsername)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    requireEmail: ").append(toIndentedString(requireEmail)).append("\n");
    sb.append("    fileDropCreateFolders: ").append(toIndentedString(fileDropCreateFolders)).append("\n");
    sb.append("    paths: ").append(toIndentedString(paths)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    recipientsWithOwner: ").append(toIndentedString(recipientsWithOwner)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    inherited: ").append(toIndentedString(inherited)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    hasNotification: ").append(toIndentedString(hasNotification)).append("\n");
    sb.append("    notification: ").append(toIndentedString(notification)).append("\n");
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

