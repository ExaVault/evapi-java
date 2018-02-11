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
 * CreateUser
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-08T13:26:53.154Z")
public class CreateUser {
  @SerializedName("access_token")
  private String accessToken = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("nickname")
  private String nickname = null;

  @SerializedName("destinationFolder")
  private String destinationFolder = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("password")
  private String password = null;

  /**
   * The user&#39;s role. Note that admin users cannot have a &#x60;destinationFolder&#x60; other than &#x60;/&#x60;, and will be setup with full permissions regardless of what you specify in the &#x60;permissions&#x60; property.
   */
  @JsonAdapter(RoleEnum.Adapter.class)
  public enum RoleEnum {
    USER("user"),
    
    ADMIN("admin");

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

  /**
   * A CSV string of user permissions. For example: &#x60;upload,download,list&#x60;. Note that users will be unable to see any files in the account unless you include &#x60;list&#x60; permission.  
   */
  @JsonAdapter(PermissionsEnum.Adapter.class)
  public enum PermissionsEnum {
    UPLOAD("upload"),
    
    DOWNLOAD("download"),
    
    DELETE("delete"),
    
    MODIFY("modify"),
    
    LIST("list"),
    
    CHANGEPASSWORD("changePassword"),
    
    SHARE("share"),
    
    NOTIFICATION("notification");

    private String value;

    PermissionsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PermissionsEnum fromValue(String text) {
      for (PermissionsEnum b : PermissionsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<PermissionsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PermissionsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PermissionsEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return PermissionsEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("permissions")
  private PermissionsEnum permissions = null;

  @SerializedName("timeZone")
  private String timeZone = null;

  @SerializedName("expiration")
  private String expiration = null;

  @SerializedName("locked")
  private Boolean locked = false;

  @SerializedName("welcomeEmail")
  private Boolean welcomeEmail = false;

  public CreateUser accessToken(String accessToken) {
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

  public CreateUser username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Username of the user to create. This should follow standard username conventions; e.g. all lowercase, no spaces, etc. We do allow email addresses as usernames.
   * @return username
  **/
  @ApiModelProperty(example = "exavaultuser", required = true, value = "Username of the user to create. This should follow standard username conventions; e.g. all lowercase, no spaces, etc. We do allow email addresses as usernames.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public CreateUser nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

   /**
   * An optional nickname (e.g. &#39;David from Sales&#39;).
   * @return nickname
  **/
  @ApiModelProperty(example = "exavaultuser", value = "An optional nickname (e.g. 'David from Sales').")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public CreateUser destinationFolder(String destinationFolder) {
    this.destinationFolder = destinationFolder;
    return this;
  }

   /**
   * The path to the user&#39;s home folder. For the account root, specify &#x60;/&#x60;. Otherwise, use standard Unix path format, e.g. &#x60;/path/to/some/dir&#x60;. The user will be locked to this directory and unable to move &#39;up&#39; in the account.
   * @return destinationFolder
  **/
  @ApiModelProperty(example = "/", required = true, value = "The path to the user's home folder. For the account root, specify `/`. Otherwise, use standard Unix path format, e.g. `/path/to/some/dir`. The user will be locked to this directory and unable to move 'up' in the account.")
  public String getDestinationFolder() {
    return destinationFolder;
  }

  public void setDestinationFolder(String destinationFolder) {
    this.destinationFolder = destinationFolder;
  }

  public CreateUser email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The user&#39;s email address.
   * @return email
  **/
  @ApiModelProperty(example = "exavaultuser@test.com", required = true, value = "The user's email address.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateUser password(String password) {
    this.password = password;
    return this;
  }

   /**
   * The user&#39;s password.
   * @return password
  **/
  @ApiModelProperty(example = "secretPassw0rd", required = true, value = "The user's password.")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CreateUser role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * The user&#39;s role. Note that admin users cannot have a &#x60;destinationFolder&#x60; other than &#x60;/&#x60;, and will be setup with full permissions regardless of what you specify in the &#x60;permissions&#x60; property.
   * @return role
  **/
  @ApiModelProperty(example = "user", required = true, value = "The user's role. Note that admin users cannot have a `destinationFolder` other than `/`, and will be setup with full permissions regardless of what you specify in the `permissions` property.")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public CreateUser permissions(PermissionsEnum permissions) {
    this.permissions = permissions;
    return this;
  }

   /**
   * A CSV string of user permissions. For example: &#x60;upload,download,list&#x60;. Note that users will be unable to see any files in the account unless you include &#x60;list&#x60; permission.  
   * @return permissions
  **/
  @ApiModelProperty(example = "upload, download", required = true, value = "A CSV string of user permissions. For example: `upload,download,list`. Note that users will be unable to see any files in the account unless you include `list` permission.  ")
  public PermissionsEnum getPermissions() {
    return permissions;
  }

  public void setPermissions(PermissionsEnum permissions) {
    this.permissions = permissions;
  }

  public CreateUser timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

   /**
   * The user&#39;s timezone, used for accurate time display within the application. See &lt;a href&#x3D;&#39;https://php.net/manual/en/timezones.php&#39; target&#x3D;&#39;blank&#39;&gt;this page&lt;/a&gt; for allowed values. 
   * @return timeZone
  **/
  @ApiModelProperty(example = "America/Los_Angeles", required = true, value = "The user's timezone, used for accurate time display within the application. See <a href='https://php.net/manual/en/timezones.php' target='blank'>this page</a> for allowed values. ")
  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public CreateUser expiration(String expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Optional timestamp when the user should expire, formatted &#x60;YYYY-mm-dd hh:mm:ss&#x60;.
   * @return expiration
  **/
  @ApiModelProperty(example = "2017-12-20 23:59:59", value = "Optional timestamp when the user should expire, formatted `YYYY-mm-dd hh:mm:ss`.")
  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public CreateUser locked(Boolean locked) {
    this.locked = locked;
    return this;
  }

   /**
   * If true, the user&#39;s account is locked by default.
   * @return locked
  **/
  @ApiModelProperty(value = "If true, the user's account is locked by default.")
  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public CreateUser welcomeEmail(Boolean welcomeEmail) {
    this.welcomeEmail = welcomeEmail;
    return this;
  }

   /**
   * If true, send a user email upon creation. The default welcome email can be configured from the settings page in your account.
   * @return welcomeEmail
  **/
  @ApiModelProperty(value = "If true, send a user email upon creation. The default welcome email can be configured from the settings page in your account.")
  public Boolean getWelcomeEmail() {
    return welcomeEmail;
  }

  public void setWelcomeEmail(Boolean welcomeEmail) {
    this.welcomeEmail = welcomeEmail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUser createUser = (CreateUser) o;
    return Objects.equals(this.accessToken, createUser.accessToken) &&
        Objects.equals(this.username, createUser.username) &&
        Objects.equals(this.nickname, createUser.nickname) &&
        Objects.equals(this.destinationFolder, createUser.destinationFolder) &&
        Objects.equals(this.email, createUser.email) &&
        Objects.equals(this.password, createUser.password) &&
        Objects.equals(this.role, createUser.role) &&
        Objects.equals(this.permissions, createUser.permissions) &&
        Objects.equals(this.timeZone, createUser.timeZone) &&
        Objects.equals(this.expiration, createUser.expiration) &&
        Objects.equals(this.locked, createUser.locked) &&
        Objects.equals(this.welcomeEmail, createUser.welcomeEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, username, nickname, destinationFolder, email, password, role, permissions, timeZone, expiration, locked, welcomeEmail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUser {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    destinationFolder: ").append(toIndentedString(destinationFolder)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
    sb.append("    welcomeEmail: ").append(toIndentedString(welcomeEmail)).append("\n");
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

