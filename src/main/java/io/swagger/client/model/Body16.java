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
import io.swagger.client.model.SharesRecipients;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * Body16
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-10-13T19:47:31.812Z[GMT]")
public class Body16 {
  /**
   * The type of share to create. See above for a description of each.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    SHARED_FOLDER("shared_folder"),
    RECEIVE("receive"),
    SEND("send");

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

  @SerializedName("name")
  private String name = null;

  @SerializedName("resources")
  private List<String> resources = null;

  @SerializedName("accessMode")
  private List<String> accessMode = new ArrayList<String>();

  @SerializedName("embed")
  private Boolean embed = null;

  @SerializedName("recipients")
  private List<SharesRecipients> recipients = null;

  @SerializedName("expiration")
  private OffsetDateTime expiration = null;

  @SerializedName("hasNotification")
  private Boolean hasNotification = null;

  @SerializedName("isPublic")
  private Boolean isPublic = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("notificationEmails")
  private List<String> notificationEmails = null;

  @SerializedName("password")
  private String password = null;

  @SerializedName("requireEmail")
  private Boolean requireEmail = null;

  @SerializedName("subject")
  private String subject = null;

  @SerializedName("fileDropCreateFolders")
  private Boolean fileDropCreateFolders = null;

  @SerializedName("sendingLocalFiles")
  private Boolean sendingLocalFiles = null;

  public Body16 type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type of share to create. See above for a description of each.
   * @return type
  **/
  @Schema(example = "shared_folder", required = true, description = "The type of share to create. See above for a description of each.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Body16 name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A name for the share. This will be visible on the page that recipients visit. 
   * @return name
  **/
  @Schema(example = "Shared Folder", required = true, description = "A name for the share. This will be visible on the page that recipients visit. ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Body16 resources(List<String> resources) {
    this.resources = resources;
    return this;
  }

  public Body16 addResourcesItem(String resourcesItem) {
    if (this.resources == null) {
      this.resources = new ArrayList<String>();
    }
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Array of resources for this share. See details on [how to specify resources](#section/Identifying-Resources) above.  **shared_folder** and **receive** shares must have only one &#x60;resource&#x60;, which is a directory that does not have a current share attached.  **send** shares may have multiple &#x60;resource&#x60; parameters. You can also leave this parameter null if you are planning to upload files to the send. If you are planning to upload files to the send that are not yet in your account, you will also need to call the [POST /shares/complete-send/{id}](#operation/completeDirectSend) endpoint to finish the send operation. 
   * @return resources
  **/
  @Schema(example = "[\"/testfolder\"]", description = "Array of resources for this share. See details on [how to specify resources](#section/Identifying-Resources) above.  **shared_folder** and **receive** shares must have only one `resource`, which is a directory that does not have a current share attached.  **send** shares may have multiple `resource` parameters. You can also leave this parameter null if you are planning to upload files to the send. If you are planning to upload files to the send that are not yet in your account, you will also need to call the [POST /shares/complete-send/{id}](#operation/completeDirectSend) endpoint to finish the send operation. ")
  public List<String> getResources() {
    return resources;
  }

  public void setResources(List<String> resources) {
    this.resources = resources;
  }

  public Body16 accessMode(List<String> accessMode) {
    this.accessMode = accessMode;
    return this;
  }

  public Body16 addAccessModeItem(String accessModeItem) {
    this.accessMode.add(accessModeItem);
    return this;
  }

   /**
   * Array of permissions that describes what people can do when they visit the share. Valid options are &#x60;upload&#x60; &#x60;download&#x60; &#x60;modify&#x60; and &#x60;delete&#x60;  Not all permissions work with all shares - **receive** shares must always have the permission to **upload** and never provide a method for visitors to **download**.  If you are creating a share of type **send** and plan to upload files from your own computer before completing the send with [POST /shares/complete-send/{id}](#operation/completeDirectSend), use the access mode **upload**
   * @return accessMode
  **/
  @Schema(required = true, description = "Array of permissions that describes what people can do when they visit the share. Valid options are `upload` `download` `modify` and `delete`  Not all permissions work with all shares - **receive** shares must always have the permission to **upload** and never provide a method for visitors to **download**.  If you are creating a share of type **send** and plan to upload files from your own computer before completing the send with [POST /shares/complete-send/{id}](#operation/completeDirectSend), use the access mode **upload**")
  public List<String> getAccessMode() {
    return accessMode;
  }

  public void setAccessMode(List<String> accessMode) {
    this.accessMode = accessMode;
  }

  public Body16 embed(Boolean embed) {
    this.embed = embed;
    return this;
  }

   /**
   * Whether this share can be embedded within a web page.
   * @return embed
  **/
  @Schema(example = "false", description = "Whether this share can be embedded within a web page.")
  public Boolean isEmbed() {
    return embed;
  }

  public void setEmbed(Boolean embed) {
    this.embed = embed;
  }

  public Body16 recipients(List<SharesRecipients> recipients) {
    this.recipients = recipients;
    return this;
  }

  public Body16 addRecipientsItem(SharesRecipients recipientsItem) {
    if (this.recipients == null) {
      this.recipients = new ArrayList<SharesRecipients>();
    }
    this.recipients.add(recipientsItem);
    return this;
  }

   /**
   * People you want to invite to the share. **Note**: unless you also set the &#x60;subject&#x60; and &#x60;message&#x60; for the new share, invitation emails will not be sent to these recipients.
   * @return recipients
  **/
  @Schema(description = "People you want to invite to the share. **Note**: unless you also set the `subject` and `message` for the new share, invitation emails will not be sent to these recipients.")
  public List<SharesRecipients> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<SharesRecipients> recipients) {
    this.recipients = recipients;
  }

  public Body16 expiration(OffsetDateTime expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Expiration date for the share. If someone attempts to use the share after this date, they will receive an error that the share is not available.
   * @return expiration
  **/
  @Schema(example = "2017-09-25T14:12:10Z", description = "Expiration date for the share. If someone attempts to use the share after this date, they will receive an error that the share is not available.")
  public OffsetDateTime getExpiration() {
    return expiration;
  }

  public void setExpiration(OffsetDateTime expiration) {
    this.expiration = expiration;
  }

  public Body16 hasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
    return this;
  }

   /**
   * Whether delivery receipts should be sent.
   * @return hasNotification
  **/
  @Schema(example = "false", description = "Whether delivery receipts should be sent.")
  public Boolean isHasNotification() {
    return hasNotification;
  }

  public void setHasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
  }

  public Body16 isPublic(Boolean isPublic) {
    this.isPublic = isPublic;
    return this;
  }

   /**
   * Whether someone can visit the share without following a personalized recipient link.
   * @return isPublic
  **/
  @Schema(example = "true", description = "Whether someone can visit the share without following a personalized recipient link.")
  public Boolean isIsPublic() {
    return isPublic;
  }

  public void setIsPublic(Boolean isPublic) {
    this.isPublic = isPublic;
  }

  public Body16 message(String message) {
    this.message = message;
    return this;
  }

   /**
   * The message to be included in email invitations for your recipients. Ignored if you have not also provided &#x60;recipients&#x60; and &#x60;subject&#x60;
   * @return message
  **/
  @Schema(description = "The message to be included in email invitations for your recipients. Ignored if you have not also provided `recipients` and `subject`")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Body16 notificationEmails(List<String> notificationEmails) {
    this.notificationEmails = notificationEmails;
    return this;
  }

  public Body16 addNotificationEmailsItem(String notificationEmailsItem) {
    if (this.notificationEmails == null) {
      this.notificationEmails = new ArrayList<String>();
    }
    this.notificationEmails.add(notificationEmailsItem);
    return this;
  }

   /**
   * Emails that will receive delivery receipts for this share. &#x60;hasNotification&#x60; must be **true** for delivery receipts will be sent.
   * @return notificationEmails
  **/
  @Schema(example = "[\"notify@example.com\",\"notify2@example.com\"]", description = "Emails that will receive delivery receipts for this share. `hasNotification` must be **true** for delivery receipts will be sent.")
  public List<String> getNotificationEmails() {
    return notificationEmails;
  }

  public void setNotificationEmails(List<String> notificationEmails) {
    this.notificationEmails = notificationEmails;
  }

  public Body16 password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Set a password for recipients to access the share. All recipients will use the same password.
   * @return password
  **/
  @Schema(description = "Set a password for recipients to access the share. All recipients will use the same password.")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Body16 requireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
    return this;
  }

   /**
   * True if recipients must provide their email to view the share.
   * @return requireEmail
  **/
  @Schema(example = "false", description = "True if recipients must provide their email to view the share.")
  public Boolean isRequireEmail() {
    return requireEmail;
  }

  public void setRequireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
  }

  public Body16 subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * Subject to use on emails inviting recipients to the share. Ignored if you have not also provided &#x60;recipients&#x60; and a &#x60;message&#x60;
   * @return subject
  **/
  @Schema(example = "Invitation to a shared folder", description = "Subject to use on emails inviting recipients to the share. Ignored if you have not also provided `recipients` and a `message`")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Body16 fileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
    return this;
  }

   /**
   * Only used for **receive** shares. If true, uploads will be automatically placed into sub-folders of the folder, named after the chosen field on your form. 
   * @return fileDropCreateFolders
  **/
  @Schema(example = "false", description = "Only used for **receive** shares. If true, uploads will be automatically placed into sub-folders of the folder, named after the chosen field on your form. ")
  public Boolean isFileDropCreateFolders() {
    return fileDropCreateFolders;
  }

  public void setFileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
  }

  public Body16 sendingLocalFiles(Boolean sendingLocalFiles) {
    this.sendingLocalFiles = sendingLocalFiles;
    return this;
  }

   /**
   * Use this only for **send** shares. Flag to indicate that you are going to upload additional files from your computer to the share. If this is **true**, you will also need to use the [POST /shares/complete-send/{id}](#operation/completeDirectSend) call to finish setting up your share after the files are uploaded.
   * @return sendingLocalFiles
  **/
  @Schema(description = "Use this only for **send** shares. Flag to indicate that you are going to upload additional files from your computer to the share. If this is **true**, you will also need to use the [POST /shares/complete-send/{id}](#operation/completeDirectSend) call to finish setting up your share after the files are uploaded.")
  public Boolean isSendingLocalFiles() {
    return sendingLocalFiles;
  }

  public void setSendingLocalFiles(Boolean sendingLocalFiles) {
    this.sendingLocalFiles = sendingLocalFiles;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body16 body16 = (Body16) o;
    return Objects.equals(this.type, body16.type) &&
        Objects.equals(this.name, body16.name) &&
        Objects.equals(this.resources, body16.resources) &&
        Objects.equals(this.accessMode, body16.accessMode) &&
        Objects.equals(this.embed, body16.embed) &&
        Objects.equals(this.recipients, body16.recipients) &&
        Objects.equals(this.expiration, body16.expiration) &&
        Objects.equals(this.hasNotification, body16.hasNotification) &&
        Objects.equals(this.isPublic, body16.isPublic) &&
        Objects.equals(this.message, body16.message) &&
        Objects.equals(this.notificationEmails, body16.notificationEmails) &&
        Objects.equals(this.password, body16.password) &&
        Objects.equals(this.requireEmail, body16.requireEmail) &&
        Objects.equals(this.subject, body16.subject) &&
        Objects.equals(this.fileDropCreateFolders, body16.fileDropCreateFolders) &&
        Objects.equals(this.sendingLocalFiles, body16.sendingLocalFiles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, name, resources, accessMode, embed, recipients, expiration, hasNotification, isPublic, message, notificationEmails, password, requireEmail, subject, fileDropCreateFolders, sendingLocalFiles);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body16 {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    accessMode: ").append(toIndentedString(accessMode)).append("\n");
    sb.append("    embed: ").append(toIndentedString(embed)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    hasNotification: ").append(toIndentedString(hasNotification)).append("\n");
    sb.append("    isPublic: ").append(toIndentedString(isPublic)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    notificationEmails: ").append(toIndentedString(notificationEmails)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    requireEmail: ").append(toIndentedString(requireEmail)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    fileDropCreateFolders: ").append(toIndentedString(fileDropCreateFolders)).append("\n");
    sb.append("    sendingLocalFiles: ").append(toIndentedString(sendingLocalFiles)).append("\n");
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
