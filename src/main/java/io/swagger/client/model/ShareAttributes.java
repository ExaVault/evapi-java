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
import io.swagger.client.model.ShareMessage;
import io.swagger.client.model.ShareRecipient1;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * Attributes of the share including the name, path and share recipients. 
 */
@Schema(description = "Attributes of the share including the name, path and share recipients. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-10-13T19:47:31.812Z[GMT]")
public class ShareAttributes {
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
  }  @SerializedName("accessMode")
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
  private OffsetDateTime resent = null;

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
  }  @SerializedName("type")
  private TypeEnum type = null;

  @SerializedName("requireEmail")
  private Boolean requireEmail = null;

  @SerializedName("fileDropCreateFolders")
  private Boolean fileDropCreateFolders = null;

  @SerializedName("paths")
  private List<String> paths = null;

  @SerializedName("recipients")
  private List<ShareRecipient1> recipients = null;

  @SerializedName("messages")
  private List<ShareMessage> messages = null;

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
  }  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("hasNotification")
  private Boolean hasNotification = null;

  @SerializedName("created")
  private OffsetDateTime created = null;

  @SerializedName("modified")
  private OffsetDateTime modified = null;

  /**
   * Checks recipient received status and returns whether it&#x27;s been recevied (&#x60;complete&#x60;,) partial recevied (&#x60;incomplete&#x60;,) or not recevied yet (&#x60;pending&#x60;.)
   */
  @JsonAdapter(TrackingStatusEnum.Adapter.class)
  public enum TrackingStatusEnum {
    COMPLETE("complete"),
    INCOMPLETE("incomplete"),
    PENDING("pending");

    private String value;

    TrackingStatusEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static TrackingStatusEnum fromValue(String text) {
      for (TrackingStatusEnum b : TrackingStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<TrackingStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TrackingStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TrackingStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TrackingStatusEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("trackingStatus")
  private TrackingStatusEnum trackingStatus = null;

  @SerializedName("formId")
  private Integer formId = null;

  public ShareAttributes name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Share name.
   * @return name
  **/
  @Schema(example = "Example Folder", description = "Share name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ShareAttributes hasPassword(Boolean hasPassword) {
    this.hasPassword = hasPassword;
    return this;
  }

   /**
   * True if the share has password.
   * @return hasPassword
  **/
  @Schema(example = "false", description = "True if the share has password.")
  public Boolean isHasPassword() {
    return hasPassword;
  }

  public void setHasPassword(Boolean hasPassword) {
    this.hasPassword = hasPassword;
  }

  public ShareAttributes _public(Boolean _public) {
    this._public = _public;
    return this;
  }

   /**
   * True if the share has a public url.
   * @return _public
  **/
  @Schema(example = "true", description = "True if the share has a public url.")
  public Boolean isPublic() {
    return _public;
  }

  public void setPublic(Boolean _public) {
    this._public = _public;
  }

  public ShareAttributes accessMode(AccessModeEnum accessMode) {
    this.accessMode = accessMode;
    return this;
  }

   /**
   * Access rights for the share.
   * @return accessMode
  **/
  @Schema(example = "upload", description = "Access rights for the share.")
  public AccessModeEnum getAccessMode() {
    return accessMode;
  }

  public void setAccessMode(AccessModeEnum accessMode) {
    this.accessMode = accessMode;
  }

  public ShareAttributes accessDescription(String accessDescription) {
    this.accessDescription = accessDescription;
    return this;
  }

   /**
   * Description of the share access rights.
   * @return accessDescription
  **/
  @Schema(example = "Download only", description = "Description of the share access rights.")
  public String getAccessDescription() {
    return accessDescription;
  }

  public void setAccessDescription(String accessDescription) {
    this.accessDescription = accessDescription;
  }

  public ShareAttributes embed(Boolean embed) {
    this.embed = embed;
    return this;
  }

   /**
   * True if share can be embedded.
   * @return embed
  **/
  @Schema(example = "false", description = "True if share can be embedded.")
  public Boolean isEmbed() {
    return embed;
  }

  public void setEmbed(Boolean embed) {
    this.embed = embed;
  }

  public ShareAttributes hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * Share hash.
   * @return hash
  **/
  @Schema(example = "hd1e-3erufo72", description = "Share hash.")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public ShareAttributes ownerHash(String ownerHash) {
    this.ownerHash = ownerHash;
    return this;
  }

   /**
   * Share owner&#x27;s hash.
   * @return ownerHash
  **/
  @Schema(example = "hd1e-3erufo72-fsxak999", description = "Share owner's hash.")
  public String getOwnerHash() {
    return ownerHash;
  }

  public void setOwnerHash(String ownerHash) {
    this.ownerHash = ownerHash;
  }

  public ShareAttributes expiration(String expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Expiration date of the share.
   * @return expiration
  **/
  @Schema(description = "Expiration date of the share.")
  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public ShareAttributes expired(Boolean expired) {
    this.expired = expired;
    return this;
  }

   /**
   * True if the share has expired.
   * @return expired
  **/
  @Schema(example = "false", description = "True if the share has expired.")
  public Boolean isExpired() {
    return expired;
  }

  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  public ShareAttributes resent(OffsetDateTime resent) {
    this.resent = resent;
    return this;
  }

   /**
   * Invitations resent date. Can be &#x60;null&#x60; if resent never happened.
   * @return resent
  **/
  @Schema(description = "Invitations resent date. Can be `null` if resent never happened.")
  public OffsetDateTime getResent() {
    return resent;
  }

  public void setResent(OffsetDateTime resent) {
    this.resent = resent;
  }

  public ShareAttributes type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Type of share.
   * @return type
  **/
  @Schema(example = "shared_folder", description = "Type of share.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ShareAttributes requireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
    return this;
  }

   /**
   * True if share requires email to access.
   * @return requireEmail
  **/
  @Schema(example = "true", description = "True if share requires email to access.")
  public Boolean isRequireEmail() {
    return requireEmail;
  }

  public void setRequireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
  }

  public ShareAttributes fileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
    return this;
  }

   /**
   * Flag to show if separate folders should be created for each file upload to receive folder.
   * @return fileDropCreateFolders
  **/
  @Schema(example = "false", description = "Flag to show if separate folders should be created for each file upload to receive folder.")
  public Boolean isFileDropCreateFolders() {
    return fileDropCreateFolders;
  }

  public void setFileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
  }

  public ShareAttributes paths(List<String> paths) {
    this.paths = paths;
    return this;
  }

  public ShareAttributes addPathsItem(String pathsItem) {
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
  @Schema(example = "[\"/Example Folder\"]", description = "Path to the shared resource in your account.")
  public List<String> getPaths() {
    return paths;
  }

  public void setPaths(List<String> paths) {
    this.paths = paths;
  }

  public ShareAttributes recipients(List<ShareRecipient1> recipients) {
    this.recipients = recipients;
    return this;
  }

  public ShareAttributes addRecipientsItem(ShareRecipient1 recipientsItem) {
    if (this.recipients == null) {
      this.recipients = new ArrayList<ShareRecipient1>();
    }
    this.recipients.add(recipientsItem);
    return this;
  }

   /**
   * Array of recipients.
   * @return recipients
  **/
  @Schema(example = "[{\"id\":2,\"shareId\":23,\"type\":\"direct\",\"hash\":\"fseowxan\",\"email\":\"recipient@gmail.com\",\"sent\":true,\"received\":false,\"created\":\"2017-04-21T10:53:47Z\"}]", description = "Array of recipients.")
  public List<ShareRecipient1> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<ShareRecipient1> recipients) {
    this.recipients = recipients;
  }

  public ShareAttributes messages(List<ShareMessage> messages) {
    this.messages = messages;
    return this;
  }

  public ShareAttributes addMessagesItem(ShareMessage messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<ShareMessage>();
    }
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * Array of invitation messages.
   * @return messages
  **/
  @Schema(description = "Array of invitation messages.")
  public List<ShareMessage> getMessages() {
    return messages;
  }

  public void setMessages(List<ShareMessage> messages) {
    this.messages = messages;
  }

  public ShareAttributes inherited(Boolean inherited) {
    this.inherited = inherited;
    return this;
  }

   /**
   * True if share inherited from parent folder.
   * @return inherited
  **/
  @Schema(example = "false", description = "True if share inherited from parent folder.")
  public Boolean isInherited() {
    return inherited;
  }

  public void setInherited(Boolean inherited) {
    this.inherited = inherited;
  }

  public ShareAttributes status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Share activity status. Can be active (1) or deactivated (0).
   * @return status
  **/
  @Schema(example = "1", description = "Share activity status. Can be active (1) or deactivated (0).")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ShareAttributes hasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
    return this;
  }

   /**
   * True if share has notification.
   * @return hasNotification
  **/
  @Schema(example = "false", description = "True if share has notification.")
  public Boolean isHasNotification() {
    return hasNotification;
  }

  public void setHasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
  }

  public ShareAttributes created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of share creation.
   * @return created
  **/
  @Schema(example = "2017-01-28T13:10:47Z", description = "Timestamp of share creation.")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public ShareAttributes modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp of share modification. Can be &#x60;null&#x60; if it wasn&#x27;t modified.
   * @return modified
  **/
  @Schema(description = "Timestamp of share modification. Can be `null` if it wasn't modified.")
  public OffsetDateTime getModified() {
    return modified;
  }

  public void setModified(OffsetDateTime modified) {
    this.modified = modified;
  }

  public ShareAttributes trackingStatus(TrackingStatusEnum trackingStatus) {
    this.trackingStatus = trackingStatus;
    return this;
  }

   /**
   * Checks recipient received status and returns whether it&#x27;s been recevied (&#x60;complete&#x60;,) partial recevied (&#x60;incomplete&#x60;,) or not recevied yet (&#x60;pending&#x60;.)
   * @return trackingStatus
  **/
  @Schema(description = "Checks recipient received status and returns whether it's been recevied (`complete`,) partial recevied (`incomplete`,) or not recevied yet (`pending`.)")
  public TrackingStatusEnum getTrackingStatus() {
    return trackingStatus;
  }

  public void setTrackingStatus(TrackingStatusEnum trackingStatus) {
    this.trackingStatus = trackingStatus;
  }

  public ShareAttributes formId(Integer formId) {
    this.formId = formId;
    return this;
  }

   /**
   * ID of the form.
   * @return formId
  **/
  @Schema(description = "ID of the form.")
  public Integer getFormId() {
    return formId;
  }

  public void setFormId(Integer formId) {
    this.formId = formId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShareAttributes shareAttributes = (ShareAttributes) o;
    return Objects.equals(this.name, shareAttributes.name) &&
        Objects.equals(this.hasPassword, shareAttributes.hasPassword) &&
        Objects.equals(this._public, shareAttributes._public) &&
        Objects.equals(this.accessMode, shareAttributes.accessMode) &&
        Objects.equals(this.accessDescription, shareAttributes.accessDescription) &&
        Objects.equals(this.embed, shareAttributes.embed) &&
        Objects.equals(this.hash, shareAttributes.hash) &&
        Objects.equals(this.ownerHash, shareAttributes.ownerHash) &&
        Objects.equals(this.expiration, shareAttributes.expiration) &&
        Objects.equals(this.expired, shareAttributes.expired) &&
        Objects.equals(this.resent, shareAttributes.resent) &&
        Objects.equals(this.type, shareAttributes.type) &&
        Objects.equals(this.requireEmail, shareAttributes.requireEmail) &&
        Objects.equals(this.fileDropCreateFolders, shareAttributes.fileDropCreateFolders) &&
        Objects.equals(this.paths, shareAttributes.paths) &&
        Objects.equals(this.recipients, shareAttributes.recipients) &&
        Objects.equals(this.messages, shareAttributes.messages) &&
        Objects.equals(this.inherited, shareAttributes.inherited) &&
        Objects.equals(this.status, shareAttributes.status) &&
        Objects.equals(this.hasNotification, shareAttributes.hasNotification) &&
        Objects.equals(this.created, shareAttributes.created) &&
        Objects.equals(this.modified, shareAttributes.modified) &&
        Objects.equals(this.trackingStatus, shareAttributes.trackingStatus) &&
        Objects.equals(this.formId, shareAttributes.formId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, hasPassword, _public, accessMode, accessDescription, embed, hash, ownerHash, expiration, expired, resent, type, requireEmail, fileDropCreateFolders, paths, recipients, messages, inherited, status, hasNotification, created, modified, trackingStatus, formId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShareAttributes {\n");
    
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
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    requireEmail: ").append(toIndentedString(requireEmail)).append("\n");
    sb.append("    fileDropCreateFolders: ").append(toIndentedString(fileDropCreateFolders)).append("\n");
    sb.append("    paths: ").append(toIndentedString(paths)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    inherited: ").append(toIndentedString(inherited)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    hasNotification: ").append(toIndentedString(hasNotification)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    trackingStatus: ").append(toIndentedString(trackingStatus)).append("\n");
    sb.append("    formId: ").append(toIndentedString(formId)).append("\n");
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
