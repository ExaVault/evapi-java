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
import java.util.ArrayList;
import java.util.List;

/**
 * UpdateNotification
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-20T15:12:25.985Z")
public class UpdateNotification {
  @SerializedName("access_token")
  private String accessToken = null;

  @SerializedName("id")
  private Integer id = null;

  @SerializedName("path")
  private String path = null;

  /**
   * Type of action to filter on. Notifications will only be fired for the given type of action.
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

  @SerializedName("sendEmail")
  private Boolean sendEmail = null;

  @SerializedName("emails")
  private List<String> emails = null;

  public UpdateNotification accessToken(String accessToken) {
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

  public UpdateNotification id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the notification. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID.
   * @return id
  **/
  @ApiModelProperty(example = "22", required = true, value = "ID of the notification. Use <a href=\"#operation/getNotifications\">getNotifications</a> if you need to lookup an ID.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UpdateNotification path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Full path of file/folder where the notification is set.
   * @return path
  **/
  @ApiModelProperty(example = "/folderNotification", value = "Full path of file/folder where the notification is set.")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public UpdateNotification action(ActionEnum action) {
    this.action = action;
    return this;
  }

   /**
   * Type of action to filter on. Notifications will only be fired for the given type of action.
   * @return action
  **/
  @ApiModelProperty(example = "all", value = "Type of action to filter on. Notifications will only be fired for the given type of action.")
  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public UpdateNotification usernames(List<String> usernames) {
    this.usernames = usernames;
    return this;
  }

  public UpdateNotification addUsernamesItem(String usernamesItem) {
    if (this.usernames == null) {
      this.usernames = new ArrayList<String>();
    }
    this.usernames.add(usernamesItem);
    return this;
  }

   /**
   * Array of usernames or with one flag to filter on. This options allows to filter what users will trigger the notification.
   * @return usernames
  **/
  @ApiModelProperty(example = "[\"notice_user_all\"]", value = "Array of usernames or with one flag to filter on. This options allows to filter what users will trigger the notification.")
  public List<String> getUsernames() {
    return usernames;
  }

  public void setUsernames(List<String> usernames) {
    this.usernames = usernames;
  }

  public UpdateNotification sendEmail(Boolean sendEmail) {
    this.sendEmail = sendEmail;
    return this;
  }

   /**
   * Set to true if the user should be notified by email when the notification is triggered.
   * @return sendEmail
  **/
  @ApiModelProperty(example = "true", value = "Set to true if the user should be notified by email when the notification is triggered.")
  public Boolean isSendEmail() {
    return sendEmail;
  }

  public void setSendEmail(Boolean sendEmail) {
    this.sendEmail = sendEmail;
  }

  public UpdateNotification emails(List<String> emails) {
    this.emails = emails;
    return this;
  }

  public UpdateNotification addEmailsItem(String emailsItem) {
    if (this.emails == null) {
      this.emails = new ArrayList<String>();
    }
    this.emails.add(emailsItem);
    return this;
  }

   /**
   * Email addresses to send notification to. If not specified, sends to the authenticated user.
   * @return emails
  **/
  @ApiModelProperty(example = "[\"myemail@example.com\"]", value = "Email addresses to send notification to. If not specified, sends to the authenticated user.")
  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateNotification updateNotification = (UpdateNotification) o;
    return Objects.equals(this.accessToken, updateNotification.accessToken) &&
        Objects.equals(this.id, updateNotification.id) &&
        Objects.equals(this.path, updateNotification.path) &&
        Objects.equals(this.action, updateNotification.action) &&
        Objects.equals(this.usernames, updateNotification.usernames) &&
        Objects.equals(this.sendEmail, updateNotification.sendEmail) &&
        Objects.equals(this.emails, updateNotification.emails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, id, path, action, usernames, sendEmail, emails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateNotification {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    usernames: ").append(toIndentedString(usernames)).append("\n");
    sb.append("    sendEmail: ").append(toIndentedString(sendEmail)).append("\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
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

