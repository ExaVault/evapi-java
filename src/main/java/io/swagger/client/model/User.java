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
 * Object contains user properties.
 */
@ApiModel(description = "Object contains user properties.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-20T15:12:25.985Z")
public class User {
  /**
   * Indicates user activity status. &#x60;0&#x60; means the user is locked and cannot log in. &#x60;1&#x60; means the user is active and can log in.
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

  @SerializedName("expiration")
  private String expiration = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("modified")
  private String modified = null;

  @SerializedName("accessTimestamp")
  private String accessTimestamp = null;

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("accountId")
  private Integer accountId = null;

  @SerializedName("accountName")
  private String accountName = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("nickname")
  private String nickname = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("homeDir")
  private String homeDir = null;

  @SerializedName("onboarding")
  private Boolean onboarding = null;

  @SerializedName("firstLogin")
  private Boolean firstLogin = null;

  @SerializedName("download")
  private Boolean download = null;

  @SerializedName("upload")
  private Boolean upload = null;

  @SerializedName("modify")
  private Boolean modify = null;

  @SerializedName("delete")
  private Boolean delete = null;

  @SerializedName("list")
  private Boolean list = null;

  @SerializedName("changePassword")
  private Boolean changePassword = null;

  @SerializedName("share")
  private Boolean share = null;

  @SerializedName("notification")
  private Boolean notification = null;

  @SerializedName("viewFormData")
  private Boolean viewFormData = null;

  @SerializedName("deleteFormData")
  private Object deleteFormData = null;

  /**
   * User&#39;s role.
   */
  @JsonAdapter(RoleEnum.Adapter.class)
  public enum RoleEnum {
    USER("user"),
    
    ADMIN("admin"),
    
    MASTER("master");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RoleEnum fromValue(String text) {
      for (RoleEnum b : RoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RoleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RoleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RoleEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RoleEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("role")
  private RoleEnum role = null;

  @SerializedName("timeZone")
  private String timeZone = null;

  public User status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Indicates user activity status. &#x60;0&#x60; means the user is locked and cannot log in. &#x60;1&#x60; means the user is active and can log in.
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "Indicates user activity status. `0` means the user is locked and cannot log in. `1` means the user is active and can log in.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public User expiration(String expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Timestamp of user expiration.
   * @return expiration
  **/
  @ApiModelProperty(value = "Timestamp of user expiration.")
  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public User created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of user creation.
   * @return created
  **/
  @ApiModelProperty(example = "2017-01-12 09:06:21", value = "Timestamp of user creation.")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public User modified(String modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp of user modification.
   * @return modified
  **/
  @ApiModelProperty(example = "2017-06-05 06:44:24", value = "Timestamp of user modification.")
  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }

  public User accessTimestamp(String accessTimestamp) {
    this.accessTimestamp = accessTimestamp;
    return this;
  }

   /**
   * Timestamp of most recent successful user login.
   * @return accessTimestamp
  **/
  @ApiModelProperty(example = "2017-06-05 06:44:24", value = "Timestamp of most recent successful user login.")
  public String getAccessTimestamp() {
    return accessTimestamp;
  }

  public void setAccessTimestamp(String accessTimestamp) {
    this.accessTimestamp = accessTimestamp;
  }

  public User id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the user.
   * @return id
  **/
  @ApiModelProperty(example = "192667", value = "ID of the user.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User accountId(Integer accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Internal ID of the account this user belongs to.
   * @return accountId
  **/
  @ApiModelProperty(example = "13758", value = "Internal ID of the account this user belongs to.")
  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  public User accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * Name of the account this user belongs to.
   * @return accountName
  **/
  @ApiModelProperty(example = "exampleuser", value = "Name of the account this user belongs to.")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public User username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Username of the user.
   * @return username
  **/
  @ApiModelProperty(example = "exampleuser", value = "Username of the user.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public User nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

   /**
   * Nickname of the user.
   * @return nickname
  **/
  @ApiModelProperty(example = "exampleuser", value = "Nickname of the user.")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email address of the user.
   * @return email
  **/
  @ApiModelProperty(example = "example@exavault.mail", value = "Email address of the user.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User homeDir(String homeDir) {
    this.homeDir = homeDir;
    return this;
  }

   /**
   * Path to the user&#39;s home folder.
   * @return homeDir
  **/
  @ApiModelProperty(example = "/", value = "Path to the user's home folder.")
  public String getHomeDir() {
    return homeDir;
  }

  public void setHomeDir(String homeDir) {
    this.homeDir = homeDir;
  }

  public User onboarding(Boolean onboarding) {
    this.onboarding = onboarding;
    return this;
  }

   /**
   * Whether the onboarding help system is enabled for this user. &#x60;true&#x60; means that additional help popups are displayed in the web application for this user.
   * @return onboarding
  **/
  @ApiModelProperty(example = "false", value = "Whether the onboarding help system is enabled for this user. `true` means that additional help popups are displayed in the web application for this user.")
  public Boolean isOnboarding() {
    return onboarding;
  }

  public void setOnboarding(Boolean onboarding) {
    this.onboarding = onboarding;
  }

  public User firstLogin(Boolean firstLogin) {
    this.firstLogin = firstLogin;
    return this;
  }

   /**
   * Whether this is the first time the user has logged into the system.
   * @return firstLogin
  **/
  @ApiModelProperty(example = "false", value = "Whether this is the first time the user has logged into the system.")
  public Boolean isFirstLogin() {
    return firstLogin;
  }

  public void setFirstLogin(Boolean firstLogin) {
    this.firstLogin = firstLogin;
  }

  public User download(Boolean download) {
    this.download = download;
    return this;
  }

   /**
   * Download permission flag.
   * @return download
  **/
  @ApiModelProperty(example = "true", value = "Download permission flag.")
  public Boolean isDownload() {
    return download;
  }

  public void setDownload(Boolean download) {
    this.download = download;
  }

  public User upload(Boolean upload) {
    this.upload = upload;
    return this;
  }

   /**
   * Upload permission flag.
   * @return upload
  **/
  @ApiModelProperty(example = "true", value = "Upload permission flag.")
  public Boolean isUpload() {
    return upload;
  }

  public void setUpload(Boolean upload) {
    this.upload = upload;
  }

  public User modify(Boolean modify) {
    this.modify = modify;
    return this;
  }

   /**
   * Modify permission flag.
   * @return modify
  **/
  @ApiModelProperty(example = "true", value = "Modify permission flag.")
  public Boolean isModify() {
    return modify;
  }

  public void setModify(Boolean modify) {
    this.modify = modify;
  }

  public User delete(Boolean delete) {
    this.delete = delete;
    return this;
  }

   /**
   * Delete permission flag.
   * @return delete
  **/
  @ApiModelProperty(example = "true", value = "Delete permission flag.")
  public Boolean isDelete() {
    return delete;
  }

  public void setDelete(Boolean delete) {
    this.delete = delete;
  }

  public User list(Boolean list) {
    this.list = list;
    return this;
  }

   /**
   * View files permission flag.
   * @return list
  **/
  @ApiModelProperty(example = "true", value = "View files permission flag.")
  public Boolean isList() {
    return list;
  }

  public void setList(Boolean list) {
    this.list = list;
  }

  public User changePassword(Boolean changePassword) {
    this.changePassword = changePassword;
    return this;
  }

   /**
   * Change permission flag.
   * @return changePassword
  **/
  @ApiModelProperty(example = "true", value = "Change permission flag.")
  public Boolean isChangePassword() {
    return changePassword;
  }

  public void setChangePassword(Boolean changePassword) {
    this.changePassword = changePassword;
  }

  public User share(Boolean share) {
    this.share = share;
    return this;
  }

   /**
   * Share folders permission flag.
   * @return share
  **/
  @ApiModelProperty(example = "true", value = "Share folders permission flag.")
  public Boolean isShare() {
    return share;
  }

  public void setShare(Boolean share) {
    this.share = share;
  }

  public User notification(Boolean notification) {
    this.notification = notification;
    return this;
  }

   /**
   * Create notifications permission flag.
   * @return notification
  **/
  @ApiModelProperty(example = "true", value = "Create notifications permission flag.")
  public Boolean isNotification() {
    return notification;
  }

  public void setNotification(Boolean notification) {
    this.notification = notification;
  }

  public User viewFormData(Boolean viewFormData) {
    this.viewFormData = viewFormData;
    return this;
  }

   /**
   * Access Form Data permission flag. If &#x60;true&#x60;, user can view submissions that have been stored for a receive folder. This includes any data submitted in the receive folder form.
   * @return viewFormData
  **/
  @ApiModelProperty(example = "true", value = "Access Form Data permission flag. If `true`, user can view submissions that have been stored for a receive folder. This includes any data submitted in the receive folder form.")
  public Boolean isViewFormData() {
    return viewFormData;
  }

  public void setViewFormData(Boolean viewFormData) {
    this.viewFormData = viewFormData;
  }

  public User deleteFormData(Object deleteFormData) {
    this.deleteFormData = deleteFormData;
    return this;
  }

   /**
   * Delete form data permission flag. If &#x60;true&#x60;, user can remove data that was submitted for a receive folder. This applies only to data submitted in the receive folder form, not the actual files uploaded.
   * @return deleteFormData
  **/
  @ApiModelProperty(value = "Delete form data permission flag. If `true`, user can remove data that was submitted for a receive folder. This applies only to data submitted in the receive folder form, not the actual files uploaded.")
  public Object getDeleteFormData() {
    return deleteFormData;
  }

  public void setDeleteFormData(Object deleteFormData) {
    this.deleteFormData = deleteFormData;
  }

  public User role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * User&#39;s role.
   * @return role
  **/
  @ApiModelProperty(example = "user", value = "User's role.")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public User timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

   /**
   * User&#39;s timezone. See &lt;a href&#x3D;&#39;https://php.net/manual/en/timezones.php&#39; target&#x3D;&#39;blank&#39;&gt;this page&lt;/a&gt; for allowed values.
   * @return timeZone
  **/
  @ApiModelProperty(example = "America/Chicago", value = "User's timezone. See <a href='https://php.net/manual/en/timezones.php' target='blank'>this page</a> for allowed values.")
  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.status, user.status) &&
        Objects.equals(this.expiration, user.expiration) &&
        Objects.equals(this.created, user.created) &&
        Objects.equals(this.modified, user.modified) &&
        Objects.equals(this.accessTimestamp, user.accessTimestamp) &&
        Objects.equals(this.id, user.id) &&
        Objects.equals(this.accountId, user.accountId) &&
        Objects.equals(this.accountName, user.accountName) &&
        Objects.equals(this.username, user.username) &&
        Objects.equals(this.nickname, user.nickname) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.homeDir, user.homeDir) &&
        Objects.equals(this.onboarding, user.onboarding) &&
        Objects.equals(this.firstLogin, user.firstLogin) &&
        Objects.equals(this.download, user.download) &&
        Objects.equals(this.upload, user.upload) &&
        Objects.equals(this.modify, user.modify) &&
        Objects.equals(this.delete, user.delete) &&
        Objects.equals(this.list, user.list) &&
        Objects.equals(this.changePassword, user.changePassword) &&
        Objects.equals(this.share, user.share) &&
        Objects.equals(this.notification, user.notification) &&
        Objects.equals(this.viewFormData, user.viewFormData) &&
        Objects.equals(this.deleteFormData, user.deleteFormData) &&
        Objects.equals(this.role, user.role) &&
        Objects.equals(this.timeZone, user.timeZone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, expiration, created, modified, accessTimestamp, id, accountId, accountName, username, nickname, email, homeDir, onboarding, firstLogin, download, upload, modify, delete, list, changePassword, share, notification, viewFormData, deleteFormData, role, timeZone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    accessTimestamp: ").append(toIndentedString(accessTimestamp)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    homeDir: ").append(toIndentedString(homeDir)).append("\n");
    sb.append("    onboarding: ").append(toIndentedString(onboarding)).append("\n");
    sb.append("    firstLogin: ").append(toIndentedString(firstLogin)).append("\n");
    sb.append("    download: ").append(toIndentedString(download)).append("\n");
    sb.append("    upload: ").append(toIndentedString(upload)).append("\n");
    sb.append("    modify: ").append(toIndentedString(modify)).append("\n");
    sb.append("    delete: ").append(toIndentedString(delete)).append("\n");
    sb.append("    list: ").append(toIndentedString(list)).append("\n");
    sb.append("    changePassword: ").append(toIndentedString(changePassword)).append("\n");
    sb.append("    share: ").append(toIndentedString(share)).append("\n");
    sb.append("    notification: ").append(toIndentedString(notification)).append("\n");
    sb.append("    viewFormData: ").append(toIndentedString(viewFormData)).append("\n");
    sb.append("    deleteFormData: ").append(toIndentedString(deleteFormData)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
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

