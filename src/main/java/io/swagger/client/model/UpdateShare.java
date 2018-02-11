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
import java.util.ArrayList;
import java.util.List;

/**
 * UpdateShare
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-08T13:26:53.154Z")
public class UpdateShare {
  @SerializedName("access_token")
  private String accessToken = null;

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("filePaths")
  private List<String> filePaths = null;

  /**
   * Type of permissions share recipients have.
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

  @SerializedName("subject")
  private String subject = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("emails")
  private List<String> emails = null;

  @SerializedName("ccEmail")
  private List<String> ccEmail = null;

  @SerializedName("requireEmail")
  private Boolean requireEmail = false;

  @SerializedName("embed")
  private Boolean embed = false;

  @SerializedName("isPublic")
  private Boolean isPublic = false;

  @SerializedName("password")
  private String password = null;

  @SerializedName("expiration")
  private String expiration = null;

  @SerializedName("hasNotification")
  private Boolean hasNotification = false;

  @SerializedName("notificationEmails")
  private List<String> notificationEmails = null;

  @SerializedName("fileDropCreateFolders")
  private Boolean fileDropCreateFolders = false;

  public UpdateShare accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * Access token required to make the API call.
   * @return accessToken
  **/
  @ApiModelProperty(example = "58d2899d284a491eaf2010cecbe401d0c71cd84", required = true, value = "Access token required to make the API call.")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public UpdateShare id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the share to update. Use &lt;a href&#x3D;\&quot;#operation/getShares\&quot;&gt;getShares&lt;/a&gt; if you need to lookup an ID.
   * @return id
  **/
  @ApiModelProperty(example = "22", required = true, value = "ID of the share to update. Use <a href=\"#operation/getShares\">getShares</a> if you need to lookup an ID.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UpdateShare name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the share.
   * @return name
  **/
  @ApiModelProperty(example = "myUpdatedShare", value = "Name of the share.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateShare filePaths(List<String> filePaths) {
    this.filePaths = filePaths;
    return this;
  }

  public UpdateShare addFilePathsItem(String filePathsItem) {
    if (this.filePaths == null) {
      this.filePaths = new ArrayList<String>();
    }
    this.filePaths.add(filePathsItem);
    return this;
  }

   /**
   * Array of strings containing the file paths to share.
   * @return filePaths
  **/
  @ApiModelProperty(example = "[\"/myFolder\"]", value = "Array of strings containing the file paths to share.")
  public List<String> getFilePaths() {
    return filePaths;
  }

  public void setFilePaths(List<String> filePaths) {
    this.filePaths = filePaths;
  }

  public UpdateShare accessMode(AccessModeEnum accessMode) {
    this.accessMode = accessMode;
    return this;
  }

   /**
   * Type of permissions share recipients have.
   * @return accessMode
  **/
  @ApiModelProperty(example = "download_upload_modify_delete", value = "Type of permissions share recipients have.")
  public AccessModeEnum getAccessMode() {
    return accessMode;
  }

  public void setAccessMode(AccessModeEnum accessMode) {
    this.accessMode = accessMode;
  }

  public UpdateShare subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * Share message subject (for email invitations).
   * @return subject
  **/
  @ApiModelProperty(example = "Invitation to share folder.", value = "Share message subject (for email invitations).")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public UpdateShare message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Share message contents (for email invitations).
   * @return message
  **/
  @ApiModelProperty(example = "You are invited to access this share folder.", value = "Share message contents (for email invitations).")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public UpdateShare emails(List<String> emails) {
    this.emails = emails;
    return this;
  }

  public UpdateShare addEmailsItem(String emailsItem) {
    if (this.emails == null) {
      this.emails = new ArrayList<String>();
    }
    this.emails.add(emailsItem);
    return this;
  }

   /**
   * Array of strings for email recipients (for email invitations).
   * @return emails
  **/
  @ApiModelProperty(example = "[\"recipient@example.com\"]", value = "Array of strings for email recipients (for email invitations).")
  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  public UpdateShare ccEmail(List<String> ccEmail) {
    this.ccEmail = ccEmail;
    return this;
  }

  public UpdateShare addCcEmailItem(String ccEmailItem) {
    if (this.ccEmail == null) {
      this.ccEmail = new ArrayList<String>();
    }
    this.ccEmail.add(ccEmailItem);
    return this;
  }

   /**
   * Array of strings for CC email recipients (for email invitations).
   * @return ccEmail
  **/
  @ApiModelProperty(value = "Array of strings for CC email recipients (for email invitations).")
  public List<String> getCcEmail() {
    return ccEmail;
  }

  public void setCcEmail(List<String> ccEmail) {
    this.ccEmail = ccEmail;
  }

  public UpdateShare requireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
    return this;
  }

   /**
   * Requires a user to enter their email address to access. If set true, isPublic must also be set true. Please note that emails are not validated; we simply log the email in the share activity. If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the &#x60;emails&#x60; paramater.
   * @return requireEmail
  **/
  @ApiModelProperty(value = "Requires a user to enter their email address to access. If set true, isPublic must also be set true. Please note that emails are not validated; we simply log the email in the share activity. If you want a share to be invite only (e.g. restricted access to only invited email addresses) you should set this to false, and pass the set of email addresses via the `emails` paramater.")
  public Boolean getRequireEmail() {
    return requireEmail;
  }

  public void setRequireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
  }

  public UpdateShare embed(Boolean embed) {
    this.embed = embed;
    return this;
  }

   /**
   * Allows user to embed a widget with the share.
   * @return embed
  **/
  @ApiModelProperty(value = "Allows user to embed a widget with the share.")
  public Boolean getEmbed() {
    return embed;
  }

  public void setEmbed(Boolean embed) {
    this.embed = embed;
  }

  public UpdateShare isPublic(Boolean isPublic) {
    this.isPublic = isPublic;
    return this;
  }

   /**
   * True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process.
   * @return isPublic
  **/
  @ApiModelProperty(value = "True if share has a public URL. If false, the only way to access the share will be via the personalized URL sent via the email invite process.")
  public Boolean getIsPublic() {
    return isPublic;
  }

  public void setIsPublic(Boolean isPublic) {
    this.isPublic = isPublic;
  }

  public UpdateShare password(String password) {
    this.password = password;
    return this;
  }

   /**
   * If not null, value of password is required to access this share.
   * @return password
  **/
  @ApiModelProperty(example = "secretPassw0rd", value = "If not null, value of password is required to access this share.")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UpdateShare expiration(String expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * The timestamp the current share should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;.
   * @return expiration
  **/
  @ApiModelProperty(value = "The timestamp the current share should expire, formatted `YYYY-mm-dd hh:mm:ss`.")
  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public UpdateShare hasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
    return this;
  }

   /**
   * True if the user should be notified about activity on this share.
   * @return hasNotification
  **/
  @ApiModelProperty(example = "true", value = "True if the user should be notified about activity on this share.")
  public Boolean getHasNotification() {
    return hasNotification;
  }

  public void setHasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
  }

  public UpdateShare notificationEmails(List<String> notificationEmails) {
    this.notificationEmails = notificationEmails;
    return this;
  }

  public UpdateShare addNotificationEmailsItem(String notificationEmailsItem) {
    if (this.notificationEmails == null) {
      this.notificationEmails = new ArrayList<String>();
    }
    this.notificationEmails.add(notificationEmailsItem);
    return this;
  }

   /**
   * An array of recipients who should receive notification emails.
   * @return notificationEmails
  **/
  @ApiModelProperty(value = "An array of recipients who should receive notification emails.")
  public List<String> getNotificationEmails() {
    return notificationEmails;
  }

  public void setNotificationEmails(List<String> notificationEmails) {
    this.notificationEmails = notificationEmails;
  }

  public UpdateShare fileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
    return this;
  }

   /**
   * If true, all receive folder submissions will be uploaded separate folders (only applicable for the &#x60;receive&#x60; share type).
   * @return fileDropCreateFolders
  **/
  @ApiModelProperty(value = "If true, all receive folder submissions will be uploaded separate folders (only applicable for the `receive` share type).")
  public Boolean getFileDropCreateFolders() {
    return fileDropCreateFolders;
  }

  public void setFileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateShare updateShare = (UpdateShare) o;
    return Objects.equals(this.accessToken, updateShare.accessToken) &&
        Objects.equals(this.id, updateShare.id) &&
        Objects.equals(this.name, updateShare.name) &&
        Objects.equals(this.filePaths, updateShare.filePaths) &&
        Objects.equals(this.accessMode, updateShare.accessMode) &&
        Objects.equals(this.subject, updateShare.subject) &&
        Objects.equals(this.message, updateShare.message) &&
        Objects.equals(this.emails, updateShare.emails) &&
        Objects.equals(this.ccEmail, updateShare.ccEmail) &&
        Objects.equals(this.requireEmail, updateShare.requireEmail) &&
        Objects.equals(this.embed, updateShare.embed) &&
        Objects.equals(this.isPublic, updateShare.isPublic) &&
        Objects.equals(this.password, updateShare.password) &&
        Objects.equals(this.expiration, updateShare.expiration) &&
        Objects.equals(this.hasNotification, updateShare.hasNotification) &&
        Objects.equals(this.notificationEmails, updateShare.notificationEmails) &&
        Objects.equals(this.fileDropCreateFolders, updateShare.fileDropCreateFolders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, id, name, filePaths, accessMode, subject, message, emails, ccEmail, requireEmail, embed, isPublic, password, expiration, hasNotification, notificationEmails, fileDropCreateFolders);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateShare {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    filePaths: ").append(toIndentedString(filePaths)).append("\n");
    sb.append("    accessMode: ").append(toIndentedString(accessMode)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
    sb.append("    ccEmail: ").append(toIndentedString(ccEmail)).append("\n");
    sb.append("    requireEmail: ").append(toIndentedString(requireEmail)).append("\n");
    sb.append("    embed: ").append(toIndentedString(embed)).append("\n");
    sb.append("    isPublic: ").append(toIndentedString(isPublic)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    hasNotification: ").append(toIndentedString(hasNotification)).append("\n");
    sb.append("    notificationEmails: ").append(toIndentedString(notificationEmails)).append("\n");
    sb.append("    fileDropCreateFolders: ").append(toIndentedString(fileDropCreateFolders)).append("\n");
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

