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
import io.swagger.client.model.NotificationRecipient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Object containing notification properties.
 */
@ApiModel(description = "Object containing notification properties.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-08T13:26:53.154Z")
public class Notification {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("userId")
  private String userId = null;

  /**
   * Notification type.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    FILE("file"),
    
    FOLDER("folder"),
    
    SHARED_FOLDER("shared_folder"),
    
    SEND_RECEIPT("send_receipt"),
    
    SHARE_RECEIPT("share_receipt"),
    
    FILE_DROP("file_drop");

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

  @SerializedName("path")
  private String path = null;

  @SerializedName("name")
  private String name = null;

  /**
   * Action that triggers notification.
   */
  @JsonAdapter(ActionEnum.Adapter.class)
  public enum ActionEnum {
    UPLOAD("upload"),
    
    DOWNLOAD("download"),
    
    DELETE("delete"),
    
    ALL("all");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ActionEnum fromValue(String text) {
      for (ActionEnum b : ActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ActionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ActionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ActionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ActionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("action")
  private ActionEnum action = null;

  @SerializedName("usernames")
  private List<String> usernames = null;

  @SerializedName("recipients")
  private List<NotificationRecipient> recipients = null;

  @SerializedName("recipientEmails")
  private List<String> recipientEmails = null;

  /**
   * Send email when the notification is triggered.
   */
  @JsonAdapter(SendEmailEnum.Adapter.class)
  public enum SendEmailEnum {
    _0("0"),
    
    _1("1");

    private String value;

    SendEmailEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SendEmailEnum fromValue(String text) {
      for (SendEmailEnum b : SendEmailEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<SendEmailEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SendEmailEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SendEmailEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return SendEmailEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("sendEmail")
  private SendEmailEnum sendEmail = null;

  @SerializedName("readableDescription")
  private String readableDescription = null;

  @SerializedName("readableDescriptionWithoutPath")
  private String readableDescriptionWithoutPath = null;

  @SerializedName("shareId")
  private String shareId = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("modified")
  private String modified = null;

  public Notification id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the notification.
   * @return id
  **/
  @ApiModelProperty(example = "45", value = "ID of the notification.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Notification userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * ID of the user that the notification belongs to.
   * @return userId
  **/
  @ApiModelProperty(example = "2", value = "ID of the user that the notification belongs to.")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Notification type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Notification type.
   * @return type
  **/
  @ApiModelProperty(example = "folder", value = "Notification type.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Notification path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Path to the item that the notification is set on.
   * @return path
  **/
  @ApiModelProperty(example = "/examplefolder", value = "Path to the item that the notification is set on.")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Notification name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the item that the notification is set on.
   * @return name
  **/
  @ApiModelProperty(example = "examplefolder", value = "Name of the item that the notification is set on.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Notification action(ActionEnum action) {
    this.action = action;
    return this;
  }

   /**
   * Action that triggers notification.
   * @return action
  **/
  @ApiModelProperty(example = "all", value = "Action that triggers notification.")
  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public Notification usernames(List<String> usernames) {
    this.usernames = usernames;
    return this;
  }

  public Notification addUsernamesItem(String usernamesItem) {
    if (this.usernames == null) {
      this.usernames = new ArrayList<String>();
    }
    this.usernames.add(usernamesItem);
    return this;
  }

   /**
   * Detail on which users can trigger the notification.
   * @return usernames
  **/
  @ApiModelProperty(example = "[\"notice_user_all\"]", value = "Detail on which users can trigger the notification.")
  public List<String> getUsernames() {
    return usernames;
  }

  public void setUsernames(List<String> usernames) {
    this.usernames = usernames;
  }

  public Notification recipients(List<NotificationRecipient> recipients) {
    this.recipients = recipients;
    return this;
  }

  public Notification addRecipientsItem(NotificationRecipient recipientsItem) {
    if (this.recipients == null) {
      this.recipients = new ArrayList<NotificationRecipient>();
    }
    this.recipients.add(recipientsItem);
    return this;
  }

   /**
   * Notification recipients.
   * @return recipients
  **/
  @ApiModelProperty(value = "Notification recipients.")
  public List<NotificationRecipient> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<NotificationRecipient> recipients) {
    this.recipients = recipients;
  }

  public Notification recipientEmails(List<String> recipientEmails) {
    this.recipientEmails = recipientEmails;
    return this;
  }

  public Notification addRecipientEmailsItem(String recipientEmailsItem) {
    if (this.recipientEmails == null) {
      this.recipientEmails = new ArrayList<String>();
    }
    this.recipientEmails.add(recipientEmailsItem);
    return this;
  }

   /**
   * Email addresses of all recipients.
   * @return recipientEmails
  **/
  @ApiModelProperty(example = "[\"recipient@gmail.com\"]", value = "Email addresses of all recipients.")
  public List<String> getRecipientEmails() {
    return recipientEmails;
  }

  public void setRecipientEmails(List<String> recipientEmails) {
    this.recipientEmails = recipientEmails;
  }

  public Notification sendEmail(SendEmailEnum sendEmail) {
    this.sendEmail = sendEmail;
    return this;
  }

   /**
   * Send email when the notification is triggered.
   * @return sendEmail
  **/
  @ApiModelProperty(example = "1", value = "Send email when the notification is triggered.")
  public SendEmailEnum getSendEmail() {
    return sendEmail;
  }

  public void setSendEmail(SendEmailEnum sendEmail) {
    this.sendEmail = sendEmail;
  }

  public Notification readableDescription(String readableDescription) {
    this.readableDescription = readableDescription;
    return this;
  }

   /**
   * Human readable description of the notification.
   * @return readableDescription
  **/
  @ApiModelProperty(example = "anybody changes, downloads or deletes '/examplefile.jpg'", value = "Human readable description of the notification.")
  public String getReadableDescription() {
    return readableDescription;
  }

  public void setReadableDescription(String readableDescription) {
    this.readableDescription = readableDescription;
  }

  public Notification readableDescriptionWithoutPath(String readableDescriptionWithoutPath) {
    this.readableDescriptionWithoutPath = readableDescriptionWithoutPath;
    return this;
  }

   /**
   * Human readable description of the notification without item path.
   * @return readableDescriptionWithoutPath
  **/
  @ApiModelProperty(example = "anybody changes or downloads this file", value = "Human readable description of the notification without item path.")
  public String getReadableDescriptionWithoutPath() {
    return readableDescriptionWithoutPath;
  }

  public void setReadableDescriptionWithoutPath(String readableDescriptionWithoutPath) {
    this.readableDescriptionWithoutPath = readableDescriptionWithoutPath;
  }

  public Notification shareId(String shareId) {
    this.shareId = shareId;
    return this;
  }

   /**
   * ID of the share that the notification belogns to.
   * @return shareId
  **/
  @ApiModelProperty(value = "ID of the share that the notification belogns to.")
  public String getShareId() {
    return shareId;
  }

  public void setShareId(String shareId) {
    this.shareId = shareId;
  }

  public Notification message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Custom message that will be sent to the notification recipients.
   * @return message
  **/
  @ApiModelProperty(value = "Custom message that will be sent to the notification recipients.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Notification created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of notifiction creation.
   * @return created
  **/
  @ApiModelProperty(example = "2017-05-02 13:17:56", value = "Timestamp of notifiction creation.")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Notification modified(String modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp of notification modification.
   * @return modified
  **/
  @ApiModelProperty(example = "2017-05-10 13:17:56", value = "Timestamp of notification modification.")
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
    Notification notification = (Notification) o;
    return Objects.equals(this.id, notification.id) &&
        Objects.equals(this.userId, notification.userId) &&
        Objects.equals(this.type, notification.type) &&
        Objects.equals(this.path, notification.path) &&
        Objects.equals(this.name, notification.name) &&
        Objects.equals(this.action, notification.action) &&
        Objects.equals(this.usernames, notification.usernames) &&
        Objects.equals(this.recipients, notification.recipients) &&
        Objects.equals(this.recipientEmails, notification.recipientEmails) &&
        Objects.equals(this.sendEmail, notification.sendEmail) &&
        Objects.equals(this.readableDescription, notification.readableDescription) &&
        Objects.equals(this.readableDescriptionWithoutPath, notification.readableDescriptionWithoutPath) &&
        Objects.equals(this.shareId, notification.shareId) &&
        Objects.equals(this.message, notification.message) &&
        Objects.equals(this.created, notification.created) &&
        Objects.equals(this.modified, notification.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, type, path, name, action, usernames, recipients, recipientEmails, sendEmail, readableDescription, readableDescriptionWithoutPath, shareId, message, created, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    usernames: ").append(toIndentedString(usernames)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    recipientEmails: ").append(toIndentedString(recipientEmails)).append("\n");
    sb.append("    sendEmail: ").append(toIndentedString(sendEmail)).append("\n");
    sb.append("    readableDescription: ").append(toIndentedString(readableDescription)).append("\n");
    sb.append("    readableDescriptionWithoutPath: ").append(toIndentedString(readableDescriptionWithoutPath)).append("\n");
    sb.append("    shareId: ").append(toIndentedString(shareId)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

