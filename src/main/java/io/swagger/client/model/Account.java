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
import io.swagger.client.model.CallbackSettings;
import io.swagger.client.model.User;
import java.io.IOException;

/**
 * Object contains all account properties.
 */
@ApiModel(description = "Object contains all account properties.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-20T15:12:25.985Z")
public class Account {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("maxUsers")
  private Integer maxUsers = null;

  @SerializedName("userCount")
  private Integer userCount = null;

  @SerializedName("masterAccount")
  private User masterAccount = null;

  /**
   * Account status flag. A one (1) means the account is active; zero (0) means it is suspended.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    NUMBER_1(1),
    
    NUMBER_0(0);

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

  @SerializedName("branding")
  private Boolean branding = null;

  @SerializedName("customDomain")
  private Boolean customDomain = null;

  @SerializedName("planCode")
  private String planCode = null;

  @SerializedName("whmcsPlanId")
  private Integer whmcsPlanId = null;

  @SerializedName("diskQuotaLimit")
  private Long diskQuotaLimit = null;

  @SerializedName("bandwidthQuotaLimit")
  private Long bandwidthQuotaLimit = null;

  @SerializedName("diskQuotaUsed")
  private Long diskQuotaUsed = null;

  @SerializedName("bandwidthQuotaUsed")
  private Long bandwidthQuotaUsed = null;

  @SerializedName("quotaNoticeEnabled")
  private Integer quotaNoticeEnabled = null;

  @SerializedName("quotaNoticeThreshold")
  private Integer quotaNoticeThreshold = null;

  @SerializedName("secureOnly")
  private Boolean secureOnly = null;

  @SerializedName("complexPasswords")
  private Boolean complexPasswords = null;

  @SerializedName("showReferralLinks")
  private Boolean showReferralLinks = null;

  @SerializedName("externalDomains")
  private String externalDomains = null;

  @SerializedName("allowedIp")
  private String allowedIp = null;

  @SerializedName("callbackSettings")
  private CallbackSettings callbackSettings = null;

  @SerializedName("freeTrial")
  private Boolean freeTrial = null;

  @SerializedName("trialCode")
  private String trialCode = null;

  @SerializedName("trialStatus")
  private String trialStatus = null;

  @SerializedName("trialStart")
  private String trialStart = null;

  @SerializedName("trialEnd")
  private String trialEnd = null;

  @SerializedName("clientId")
  private Integer clientId = null;

  @SerializedName("welcomeEmailContent")
  private String welcomeEmailContent = null;

  @SerializedName("welcomeEmailSubject")
  private String welcomeEmailSubject = null;

  @SerializedName("customSignature")
  private String customSignature = null;

  @SerializedName("accountOnboarding")
  private Boolean accountOnboarding = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("modified")
  private String modified = null;

  public Account id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * (ExaVault Use Only) Internal ID of the account.
   * @return id
  **/
  @ApiModelProperty(example = "13758", value = "(ExaVault Use Only) Internal ID of the account.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Account username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Name of the account.
   * @return username
  **/
  @ApiModelProperty(example = "exampleuser", value = "Name of the account.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Account maxUsers(Integer maxUsers) {
    this.maxUsers = maxUsers;
    return this;
  }

   /**
   * Maximum number of users the account can have. This can be increased by contacting ExaVault Support.
   * @return maxUsers
  **/
  @ApiModelProperty(example = "1000", value = "Maximum number of users the account can have. This can be increased by contacting ExaVault Support.")
  public Integer getMaxUsers() {
    return maxUsers;
  }

  public void setMaxUsers(Integer maxUsers) {
    this.maxUsers = maxUsers;
  }

  public Account userCount(Integer userCount) {
    this.userCount = userCount;
    return this;
  }

   /**
   * Current number of users on the account.
   * @return userCount
  **/
  @ApiModelProperty(example = "3", value = "Current number of users on the account.")
  public Integer getUserCount() {
    return userCount;
  }

  public void setUserCount(Integer userCount) {
    this.userCount = userCount;
  }

  public Account masterAccount(User masterAccount) {
    this.masterAccount = masterAccount;
    return this;
  }

   /**
   * Master user object.
   * @return masterAccount
  **/
  @ApiModelProperty(value = "Master user object.")
  public User getMasterAccount() {
    return masterAccount;
  }

  public void setMasterAccount(User masterAccount) {
    this.masterAccount = masterAccount;
  }

  public Account status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Account status flag. A one (1) means the account is active; zero (0) means it is suspended.
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "Account status flag. A one (1) means the account is active; zero (0) means it is suspended.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Account branding(Boolean branding) {
    this.branding = branding;
    return this;
  }

   /**
   * Branding flag. Set to &#x60;true&#x60; if the account has branding functionality enabled.
   * @return branding
  **/
  @ApiModelProperty(example = "true", value = "Branding flag. Set to `true` if the account has branding functionality enabled.")
  public Boolean isBranding() {
    return branding;
  }

  public void setBranding(Boolean branding) {
    this.branding = branding;
  }

  public Account customDomain(Boolean customDomain) {
    this.customDomain = customDomain;
    return this;
  }

   /**
   * Custom domain flag. Set to &#x60;true&#x60; if account type allows custom domain functionality.
   * @return customDomain
  **/
  @ApiModelProperty(example = "true", value = "Custom domain flag. Set to `true` if account type allows custom domain functionality.")
  public Boolean isCustomDomain() {
    return customDomain;
  }

  public void setCustomDomain(Boolean customDomain) {
    this.customDomain = customDomain;
  }

  public Account planCode(String planCode) {
    this.planCode = planCode;
    return this;
  }

   /**
   * (ExaVault Use Only) Code of the plan account is signed up for.
   * @return planCode
  **/
  @ApiModelProperty(example = "350gb-r206", value = "(ExaVault Use Only) Code of the plan account is signed up for.")
  public String getPlanCode() {
    return planCode;
  }

  public void setPlanCode(String planCode) {
    this.planCode = planCode;
  }

  public Account whmcsPlanId(Integer whmcsPlanId) {
    this.whmcsPlanId = whmcsPlanId;
    return this;
  }

   /**
   * (ExaVault Use Only) Internal ID of the service in CMS.
   * @return whmcsPlanId
  **/
  @ApiModelProperty(example = "5970", value = "(ExaVault Use Only) Internal ID of the service in CMS.")
  public Integer getWhmcsPlanId() {
    return whmcsPlanId;
  }

  public void setWhmcsPlanId(Integer whmcsPlanId) {
    this.whmcsPlanId = whmcsPlanId;
  }

  public Account diskQuotaLimit(Long diskQuotaLimit) {
    this.diskQuotaLimit = diskQuotaLimit;
    return this;
  }

   /**
   * Amount of disk space that the account has available to it. This may be increased by upgrading to a larger plan.
   * @return diskQuotaLimit
  **/
  @ApiModelProperty(example = "375809638400", value = "Amount of disk space that the account has available to it. This may be increased by upgrading to a larger plan.")
  public Long getDiskQuotaLimit() {
    return diskQuotaLimit;
  }

  public void setDiskQuotaLimit(Long diskQuotaLimit) {
    this.diskQuotaLimit = diskQuotaLimit;
  }

  public Account bandwidthQuotaLimit(Long bandwidthQuotaLimit) {
    this.bandwidthQuotaLimit = bandwidthQuotaLimit;
    return this;
  }

   /**
   * Amount of bandwidth that the account has available before a warning is generated. All ExaVault accounts include unlimited bandwidth, but we flag high-bandwidth users.
   * @return bandwidthQuotaLimit
  **/
  @ApiModelProperty(value = "Amount of bandwidth that the account has available before a warning is generated. All ExaVault accounts include unlimited bandwidth, but we flag high-bandwidth users.")
  public Long getBandwidthQuotaLimit() {
    return bandwidthQuotaLimit;
  }

  public void setBandwidthQuotaLimit(Long bandwidthQuotaLimit) {
    this.bandwidthQuotaLimit = bandwidthQuotaLimit;
  }

  public Account diskQuotaUsed(Long diskQuotaUsed) {
    this.diskQuotaUsed = diskQuotaUsed;
    return this;
  }

   /**
   * Amount of disk space currently in use.
   * @return diskQuotaUsed
  **/
  @ApiModelProperty(example = "1225352192", value = "Amount of disk space currently in use.")
  public Long getDiskQuotaUsed() {
    return diskQuotaUsed;
  }

  public void setDiskQuotaUsed(Long diskQuotaUsed) {
    this.diskQuotaUsed = diskQuotaUsed;
  }

  public Account bandwidthQuotaUsed(Long bandwidthQuotaUsed) {
    this.bandwidthQuotaUsed = bandwidthQuotaUsed;
    return this;
  }

   /**
   * Amount of bandwidth used by this account in the last billing period.
   * @return bandwidthQuotaUsed
  **/
  @ApiModelProperty(example = "0", value = "Amount of bandwidth used by this account in the last billing period.")
  public Long getBandwidthQuotaUsed() {
    return bandwidthQuotaUsed;
  }

  public void setBandwidthQuotaUsed(Long bandwidthQuotaUsed) {
    this.bandwidthQuotaUsed = bandwidthQuotaUsed;
  }

  public Account quotaNoticeEnabled(Integer quotaNoticeEnabled) {
    this.quotaNoticeEnabled = quotaNoticeEnabled;
    return this;
  }

   /**
   * Should a quota warning be sent to the account owner when a threshold level of space utilization is reached?
   * @return quotaNoticeEnabled
  **/
  @ApiModelProperty(example = "1", value = "Should a quota warning be sent to the account owner when a threshold level of space utilization is reached?")
  public Integer getQuotaNoticeEnabled() {
    return quotaNoticeEnabled;
  }

  public void setQuotaNoticeEnabled(Integer quotaNoticeEnabled) {
    this.quotaNoticeEnabled = quotaNoticeEnabled;
  }

  public Account quotaNoticeThreshold(Integer quotaNoticeThreshold) {
    this.quotaNoticeThreshold = quotaNoticeThreshold;
    return this;
  }

   /**
   * Treshold that triggers a quota notification. This represents the \&quot;percent full\&quot; your account must be before the quota notification is generated.
   * @return quotaNoticeThreshold
  **/
  @ApiModelProperty(example = "80", value = "Treshold that triggers a quota notification. This represents the \"percent full\" your account must be before the quota notification is generated.")
  public Integer getQuotaNoticeThreshold() {
    return quotaNoticeThreshold;
  }

  public void setQuotaNoticeThreshold(Integer quotaNoticeThreshold) {
    this.quotaNoticeThreshold = quotaNoticeThreshold;
  }

  public Account secureOnly(Boolean secureOnly) {
    this.secureOnly = secureOnly;
    return this;
  }

   /**
   * Flag to indicate whether the account disables connections via insecure protocols (e.g. FTP). Set to &#x60;true&#x60; to disable all traffic over port 21.
   * @return secureOnly
  **/
  @ApiModelProperty(example = "false", value = "Flag to indicate whether the account disables connections via insecure protocols (e.g. FTP). Set to `true` to disable all traffic over port 21.")
  public Boolean isSecureOnly() {
    return secureOnly;
  }

  public void setSecureOnly(Boolean secureOnly) {
    this.secureOnly = secureOnly;
  }

  public Account complexPasswords(Boolean complexPasswords) {
    this.complexPasswords = complexPasswords;
    return this;
  }

   /**
   * Flag to indicate whether the account requires complex passwords. Set to &#x60;true&#x60; to require complex passwords on all users and shares.
   * @return complexPasswords
  **/
  @ApiModelProperty(example = "false", value = "Flag to indicate whether the account requires complex passwords. Set to `true` to require complex passwords on all users and shares.")
  public Boolean isComplexPasswords() {
    return complexPasswords;
  }

  public void setComplexPasswords(Boolean complexPasswords) {
    this.complexPasswords = complexPasswords;
  }

  public Account showReferralLinks(Boolean showReferralLinks) {
    this.showReferralLinks = showReferralLinks;
    return this;
  }

   /**
   * Flag to indicate showing of referrals links in the account. Set to &#x60;true&#x60; to include marketing messages in share invitations.
   * @return showReferralLinks
  **/
  @ApiModelProperty(example = "true", value = "Flag to indicate showing of referrals links in the account. Set to `true` to include marketing messages in share invitations.")
  public Boolean isShowReferralLinks() {
    return showReferralLinks;
  }

  public void setShowReferralLinks(Boolean showReferralLinks) {
    this.showReferralLinks = showReferralLinks;
  }

  public Account externalDomains(String externalDomains) {
    this.externalDomains = externalDomains;
    return this;
  }

   /**
   * Custom domain used to brand this account.
   * @return externalDomains
  **/
  @ApiModelProperty(value = "Custom domain used to brand this account.")
  public String getExternalDomains() {
    return externalDomains;
  }

  public void setExternalDomains(String externalDomains) {
    this.externalDomains = externalDomains;
  }

  public Account allowedIp(String allowedIp) {
    this.allowedIp = allowedIp;
    return this;
  }

   /**
   * Range of IP addresses allowed to access this account.
   * @return allowedIp
  **/
  @ApiModelProperty(value = "Range of IP addresses allowed to access this account.")
  public String getAllowedIp() {
    return allowedIp;
  }

  public void setAllowedIp(String allowedIp) {
    this.allowedIp = allowedIp;
  }

  public Account callbackSettings(CallbackSettings callbackSettings) {
    this.callbackSettings = callbackSettings;
    return this;
  }

   /**
   * Callback settings (Webhooks) of the account.
   * @return callbackSettings
  **/
  @ApiModelProperty(value = "Callback settings (Webhooks) of the account.")
  public CallbackSettings getCallbackSettings() {
    return callbackSettings;
  }

  public void setCallbackSettings(CallbackSettings callbackSettings) {
    this.callbackSettings = callbackSettings;
  }

  public Account freeTrial(Boolean freeTrial) {
    this.freeTrial = freeTrial;
    return this;
  }

   /**
   * Flag indicates if free trial enabled.
   * @return freeTrial
  **/
  @ApiModelProperty(example = "true", value = "Flag indicates if free trial enabled.")
  public Boolean isFreeTrial() {
    return freeTrial;
  }

  public void setFreeTrial(Boolean freeTrial) {
    this.freeTrial = freeTrial;
  }

  public Account trialCode(String trialCode) {
    this.trialCode = trialCode;
    return this;
  }

   /**
   * (ExaVault Use Only) Internal tracking code representing type of free trial for account.
   * @return trialCode
  **/
  @ApiModelProperty(value = "(ExaVault Use Only) Internal tracking code representing type of free trial for account.")
  public String getTrialCode() {
    return trialCode;
  }

  public void setTrialCode(String trialCode) {
    this.trialCode = trialCode;
  }

  public Account trialStatus(String trialStatus) {
    this.trialStatus = trialStatus;
    return this;
  }

   /**
   * (ExaVault Use Only) Internal tracking code representing whether trial has ended or is still in progress.
   * @return trialStatus
  **/
  @ApiModelProperty(example = "completed", value = "(ExaVault Use Only) Internal tracking code representing whether trial has ended or is still in progress.")
  public String getTrialStatus() {
    return trialStatus;
  }

  public void setTrialStatus(String trialStatus) {
    this.trialStatus = trialStatus;
  }

  public Account trialStart(String trialStart) {
    this.trialStart = trialStart;
    return this;
  }

   /**
   * (ExaVault Use Only) Date that free trial period began.
   * @return trialStart
  **/
  @ApiModelProperty(example = "2017-06-03 20:42:05", value = "(ExaVault Use Only) Date that free trial period began.")
  public String getTrialStart() {
    return trialStart;
  }

  public void setTrialStart(String trialStart) {
    this.trialStart = trialStart;
  }

  public Account trialEnd(String trialEnd) {
    this.trialEnd = trialEnd;
    return this;
  }

   /**
   * (ExaVault Use Only) Date that free trial period ends.
   * @return trialEnd
  **/
  @ApiModelProperty(example = "2017-07-02 20:42:04", value = "(ExaVault Use Only) Date that free trial period ends.")
  public String getTrialEnd() {
    return trialEnd;
  }

  public void setTrialEnd(String trialEnd) {
    this.trialEnd = trialEnd;
  }

  public Account clientId(Integer clientId) {
    this.clientId = clientId;
    return this;
  }

   /**
   * (ExaVault Use Only) Internal ID of the account in CMS.
   * @return clientId
  **/
  @ApiModelProperty(example = "1", value = "(ExaVault Use Only) Internal ID of the account in CMS.")
  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public Account welcomeEmailContent(String welcomeEmailContent) {
    this.welcomeEmailContent = welcomeEmailContent;
    return this;
  }

   /**
   * Content of welcome email each new user will receive.
   * @return welcomeEmailContent
  **/
  @ApiModelProperty(example = "Welcome to your new account!", value = "Content of welcome email each new user will receive.")
  public String getWelcomeEmailContent() {
    return welcomeEmailContent;
  }

  public void setWelcomeEmailContent(String welcomeEmailContent) {
    this.welcomeEmailContent = welcomeEmailContent;
  }

  public Account welcomeEmailSubject(String welcomeEmailSubject) {
    this.welcomeEmailSubject = welcomeEmailSubject;
    return this;
  }

   /**
   * Subject of welcome email each new user will receive.
   * @return welcomeEmailSubject
  **/
  @ApiModelProperty(example = "ExaVault File Sharing Account", value = "Subject of welcome email each new user will receive.")
  public String getWelcomeEmailSubject() {
    return welcomeEmailSubject;
  }

  public void setWelcomeEmailSubject(String welcomeEmailSubject) {
    this.welcomeEmailSubject = welcomeEmailSubject;
  }

  public Account customSignature(String customSignature) {
    this.customSignature = customSignature;
    return this;
  }

   /**
   * Custom signature for all account emails users or recipients will receive.
   * @return customSignature
  **/
  @ApiModelProperty(value = "Custom signature for all account emails users or recipients will receive.")
  public String getCustomSignature() {
    return customSignature;
  }

  public void setCustomSignature(String customSignature) {
    this.customSignature = customSignature;
  }

  public Account accountOnboarding(Boolean accountOnboarding) {
    this.accountOnboarding = accountOnboarding;
    return this;
  }

   /**
   * Whether the web application onboarding help is enabled for new users in the account.
   * @return accountOnboarding
  **/
  @ApiModelProperty(example = "false", value = "Whether the web application onboarding help is enabled for new users in the account.")
  public Boolean isAccountOnboarding() {
    return accountOnboarding;
  }

  public void setAccountOnboarding(Boolean accountOnboarding) {
    this.accountOnboarding = accountOnboarding;
  }

  public Account created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of account creation.
   * @return created
  **/
  @ApiModelProperty(example = "2017-01-12 09:06:21", value = "Timestamp of account creation.")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Account modified(String modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp of account modification.
   * @return modified
  **/
  @ApiModelProperty(example = "2017-06-03 20:42:05", value = "Timestamp of account modification.")
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
    Account account = (Account) o;
    return Objects.equals(this.id, account.id) &&
        Objects.equals(this.username, account.username) &&
        Objects.equals(this.maxUsers, account.maxUsers) &&
        Objects.equals(this.userCount, account.userCount) &&
        Objects.equals(this.masterAccount, account.masterAccount) &&
        Objects.equals(this.status, account.status) &&
        Objects.equals(this.branding, account.branding) &&
        Objects.equals(this.customDomain, account.customDomain) &&
        Objects.equals(this.planCode, account.planCode) &&
        Objects.equals(this.whmcsPlanId, account.whmcsPlanId) &&
        Objects.equals(this.diskQuotaLimit, account.diskQuotaLimit) &&
        Objects.equals(this.bandwidthQuotaLimit, account.bandwidthQuotaLimit) &&
        Objects.equals(this.diskQuotaUsed, account.diskQuotaUsed) &&
        Objects.equals(this.bandwidthQuotaUsed, account.bandwidthQuotaUsed) &&
        Objects.equals(this.quotaNoticeEnabled, account.quotaNoticeEnabled) &&
        Objects.equals(this.quotaNoticeThreshold, account.quotaNoticeThreshold) &&
        Objects.equals(this.secureOnly, account.secureOnly) &&
        Objects.equals(this.complexPasswords, account.complexPasswords) &&
        Objects.equals(this.showReferralLinks, account.showReferralLinks) &&
        Objects.equals(this.externalDomains, account.externalDomains) &&
        Objects.equals(this.allowedIp, account.allowedIp) &&
        Objects.equals(this.callbackSettings, account.callbackSettings) &&
        Objects.equals(this.freeTrial, account.freeTrial) &&
        Objects.equals(this.trialCode, account.trialCode) &&
        Objects.equals(this.trialStatus, account.trialStatus) &&
        Objects.equals(this.trialStart, account.trialStart) &&
        Objects.equals(this.trialEnd, account.trialEnd) &&
        Objects.equals(this.clientId, account.clientId) &&
        Objects.equals(this.welcomeEmailContent, account.welcomeEmailContent) &&
        Objects.equals(this.welcomeEmailSubject, account.welcomeEmailSubject) &&
        Objects.equals(this.customSignature, account.customSignature) &&
        Objects.equals(this.accountOnboarding, account.accountOnboarding) &&
        Objects.equals(this.created, account.created) &&
        Objects.equals(this.modified, account.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, maxUsers, userCount, masterAccount, status, branding, customDomain, planCode, whmcsPlanId, diskQuotaLimit, bandwidthQuotaLimit, diskQuotaUsed, bandwidthQuotaUsed, quotaNoticeEnabled, quotaNoticeThreshold, secureOnly, complexPasswords, showReferralLinks, externalDomains, allowedIp, callbackSettings, freeTrial, trialCode, trialStatus, trialStart, trialEnd, clientId, welcomeEmailContent, welcomeEmailSubject, customSignature, accountOnboarding, created, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    maxUsers: ").append(toIndentedString(maxUsers)).append("\n");
    sb.append("    userCount: ").append(toIndentedString(userCount)).append("\n");
    sb.append("    masterAccount: ").append(toIndentedString(masterAccount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    branding: ").append(toIndentedString(branding)).append("\n");
    sb.append("    customDomain: ").append(toIndentedString(customDomain)).append("\n");
    sb.append("    planCode: ").append(toIndentedString(planCode)).append("\n");
    sb.append("    whmcsPlanId: ").append(toIndentedString(whmcsPlanId)).append("\n");
    sb.append("    diskQuotaLimit: ").append(toIndentedString(diskQuotaLimit)).append("\n");
    sb.append("    bandwidthQuotaLimit: ").append(toIndentedString(bandwidthQuotaLimit)).append("\n");
    sb.append("    diskQuotaUsed: ").append(toIndentedString(diskQuotaUsed)).append("\n");
    sb.append("    bandwidthQuotaUsed: ").append(toIndentedString(bandwidthQuotaUsed)).append("\n");
    sb.append("    quotaNoticeEnabled: ").append(toIndentedString(quotaNoticeEnabled)).append("\n");
    sb.append("    quotaNoticeThreshold: ").append(toIndentedString(quotaNoticeThreshold)).append("\n");
    sb.append("    secureOnly: ").append(toIndentedString(secureOnly)).append("\n");
    sb.append("    complexPasswords: ").append(toIndentedString(complexPasswords)).append("\n");
    sb.append("    showReferralLinks: ").append(toIndentedString(showReferralLinks)).append("\n");
    sb.append("    externalDomains: ").append(toIndentedString(externalDomains)).append("\n");
    sb.append("    allowedIp: ").append(toIndentedString(allowedIp)).append("\n");
    sb.append("    callbackSettings: ").append(toIndentedString(callbackSettings)).append("\n");
    sb.append("    freeTrial: ").append(toIndentedString(freeTrial)).append("\n");
    sb.append("    trialCode: ").append(toIndentedString(trialCode)).append("\n");
    sb.append("    trialStatus: ").append(toIndentedString(trialStatus)).append("\n");
    sb.append("    trialStart: ").append(toIndentedString(trialStart)).append("\n");
    sb.append("    trialEnd: ").append(toIndentedString(trialEnd)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    welcomeEmailContent: ").append(toIndentedString(welcomeEmailContent)).append("\n");
    sb.append("    welcomeEmailSubject: ").append(toIndentedString(welcomeEmailSubject)).append("\n");
    sb.append("    customSignature: ").append(toIndentedString(customSignature)).append("\n");
    sb.append("    accountOnboarding: ").append(toIndentedString(accountOnboarding)).append("\n");
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

