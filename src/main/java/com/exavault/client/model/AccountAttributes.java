/*
 * ExaVault API
 * See our API reference documentation at https://www.exavault.com/developer/api-docs/
 *
 * OpenAPI spec version: 2.0
 * Contact: support@exavault.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.exavault.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.exavault.client.model.AccountAttributesAllowedIp;
import com.exavault.client.model.BrandingSettings;
import com.exavault.client.model.CallbackSettings;
import com.exavault.client.model.Quota;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
/**
 * AccountAttributes
 */


public class AccountAttributes {
  @SerializedName("accountName")
  private String accountName = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("maxUsers")
  private Integer maxUsers = null;

  @SerializedName("userCount")
  private Integer userCount = null;

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
  }  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("branding")
  private Boolean branding = null;

  @SerializedName("customDomain")
  private Boolean customDomain = null;

  @SerializedName("quota")
  private Quota quota = null;

  @SerializedName("secureOnly")
  private Boolean secureOnly = null;

  @SerializedName("complexPasswords")
  private Boolean complexPasswords = null;

  @SerializedName("showReferralLinks")
  private Boolean showReferralLinks = null;

  @SerializedName("externalDomains")
  private List<String> externalDomains = null;

  @SerializedName("allowedIp")
  private List<AccountAttributesAllowedIp> allowedIp = null;

  @SerializedName("callbackSettings")
  private CallbackSettings callbackSettings = null;

  @SerializedName("brandingSettings")
  private BrandingSettings brandingSettings = null;

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
  private OffsetDateTime created = null;

  @SerializedName("modified")
  private OffsetDateTime modified = null;

  public AccountAttributes accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * Name of the account
   * @return accountName
  **/
  @Schema(example = "exampleaccount", description = "Name of the account")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public AccountAttributes username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Name of account&#x27;s master user
   * @return username
  **/
  @Schema(example = "exampleuser", description = "Name of account's master user")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AccountAttributes maxUsers(Integer maxUsers) {
    this.maxUsers = maxUsers;
    return this;
  }

   /**
   * Maximum number of users the account can have. This can be increased by contacting ExaVault Support.
   * @return maxUsers
  **/
  @Schema(example = "1000", description = "Maximum number of users the account can have. This can be increased by contacting ExaVault Support.")
  public Integer getMaxUsers() {
    return maxUsers;
  }

  public void setMaxUsers(Integer maxUsers) {
    this.maxUsers = maxUsers;
  }

  public AccountAttributes userCount(Integer userCount) {
    this.userCount = userCount;
    return this;
  }

   /**
   * Current number of users on the account.
   * @return userCount
  **/
  @Schema(example = "3", description = "Current number of users on the account.")
  public Integer getUserCount() {
    return userCount;
  }

  public void setUserCount(Integer userCount) {
    this.userCount = userCount;
  }

  public AccountAttributes status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Account status flag. A one (1) means the account is active; zero (0) means it is suspended.
   * @return status
  **/
  @Schema(example = "1", description = "Account status flag. A one (1) means the account is active; zero (0) means it is suspended.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public AccountAttributes branding(Boolean branding) {
    this.branding = branding;
    return this;
  }

   /**
   * Branding flag. Set to &#x60;true&#x60; if the account has branding functionality enabled.
   * @return branding
  **/
  @Schema(example = "true", description = "Branding flag. Set to `true` if the account has branding functionality enabled.")
  public Boolean isBranding() {
    return branding;
  }

  public void setBranding(Boolean branding) {
    this.branding = branding;
  }

  public AccountAttributes customDomain(Boolean customDomain) {
    this.customDomain = customDomain;
    return this;
  }

   /**
   * Custom domain flag. Set to &#x60;true&#x60; if account type allows custom domain functionality.
   * @return customDomain
  **/
  @Schema(example = "true", description = "Custom domain flag. Set to `true` if account type allows custom domain functionality.")
  public Boolean isCustomDomain() {
    return customDomain;
  }

  public void setCustomDomain(Boolean customDomain) {
    this.customDomain = customDomain;
  }

  public AccountAttributes quota(Quota quota) {
    this.quota = quota;
    return this;
  }

   /**
   * Get quota
   * @return quota
  **/
  @Schema(description = "")
  public Quota getQuota() {
    return quota;
  }

  public void setQuota(Quota quota) {
    this.quota = quota;
  }

  public AccountAttributes secureOnly(Boolean secureOnly) {
    this.secureOnly = secureOnly;
    return this;
  }

   /**
   * Flag to indicate whether the account disables connections via insecure protocols (e.g. FTP). Set to &#x60;true&#x60; to disable all traffic over port 21.
   * @return secureOnly
  **/
  @Schema(example = "false", description = "Flag to indicate whether the account disables connections via insecure protocols (e.g. FTP). Set to `true` to disable all traffic over port 21.")
  public Boolean isSecureOnly() {
    return secureOnly;
  }

  public void setSecureOnly(Boolean secureOnly) {
    this.secureOnly = secureOnly;
  }

  public AccountAttributes complexPasswords(Boolean complexPasswords) {
    this.complexPasswords = complexPasswords;
    return this;
  }

   /**
   * Flag to indicate whether the account requires complex passwords. Set to &#x60;true&#x60; to require complex passwords on all users and shares.
   * @return complexPasswords
  **/
  @Schema(example = "false", description = "Flag to indicate whether the account requires complex passwords. Set to `true` to require complex passwords on all users and shares.")
  public Boolean isComplexPasswords() {
    return complexPasswords;
  }

  public void setComplexPasswords(Boolean complexPasswords) {
    this.complexPasswords = complexPasswords;
  }

  public AccountAttributes showReferralLinks(Boolean showReferralLinks) {
    this.showReferralLinks = showReferralLinks;
    return this;
  }

   /**
   * Flag to indicate showing of referrals links in the account. Set to &#x60;true&#x60; to include marketing messages in share invitations.
   * @return showReferralLinks
  **/
  @Schema(example = "true", description = "Flag to indicate showing of referrals links in the account. Set to `true` to include marketing messages in share invitations.")
  public Boolean isShowReferralLinks() {
    return showReferralLinks;
  }

  public void setShowReferralLinks(Boolean showReferralLinks) {
    this.showReferralLinks = showReferralLinks;
  }

  public AccountAttributes externalDomains(List<String> externalDomains) {
    this.externalDomains = externalDomains;
    return this;
  }

  public AccountAttributes addExternalDomainsItem(String externalDomainsItem) {
    if (this.externalDomains == null) {
      this.externalDomains = new ArrayList<String>();
    }
    this.externalDomains.add(externalDomainsItem);
    return this;
  }

   /**
   * Custom domain used to brand this account.
   * @return externalDomains
  **/
  @Schema(example = "[]", description = "Custom domain used to brand this account.")
  public List<String> getExternalDomains() {
    return externalDomains;
  }

  public void setExternalDomains(List<String> externalDomains) {
    this.externalDomains = externalDomains;
  }

  public AccountAttributes allowedIp(List<AccountAttributesAllowedIp> allowedIp) {
    this.allowedIp = allowedIp;
    return this;
  }

  public AccountAttributes addAllowedIpItem(AccountAttributesAllowedIp allowedIpItem) {
    if (this.allowedIp == null) {
      this.allowedIp = new ArrayList<AccountAttributesAllowedIp>();
    }
    this.allowedIp.add(allowedIpItem);
    return this;
  }

   /**
   * Range of IP addresses allowed to access this account.
   * @return allowedIp
  **/
  @Schema(example = "[{\"ipStart\":\"192.30.23.2\",\"ipEnd\":\"192.30.24.5\"}]", description = "Range of IP addresses allowed to access this account.")
  public List<AccountAttributesAllowedIp> getAllowedIp() {
    return allowedIp;
  }

  public void setAllowedIp(List<AccountAttributesAllowedIp> allowedIp) {
    this.allowedIp = allowedIp;
  }

  public AccountAttributes callbackSettings(CallbackSettings callbackSettings) {
    this.callbackSettings = callbackSettings;
    return this;
  }

   /**
   * Get callbackSettings
   * @return callbackSettings
  **/
  @Schema(description = "")
  public CallbackSettings getCallbackSettings() {
    return callbackSettings;
  }

  public void setCallbackSettings(CallbackSettings callbackSettings) {
    this.callbackSettings = callbackSettings;
  }

  public AccountAttributes brandingSettings(BrandingSettings brandingSettings) {
    this.brandingSettings = brandingSettings;
    return this;
  }

   /**
   * Get brandingSettings
   * @return brandingSettings
  **/
  @Schema(description = "")
  public BrandingSettings getBrandingSettings() {
    return brandingSettings;
  }

  public void setBrandingSettings(BrandingSettings brandingSettings) {
    this.brandingSettings = brandingSettings;
  }

  public AccountAttributes clientId(Integer clientId) {
    this.clientId = clientId;
    return this;
  }

   /**
   * (ExaVault Use Only) Internal ID of the account in CMS.
   * @return clientId
  **/
  @Schema(example = "1", description = "(ExaVault Use Only) Internal ID of the account in CMS.")
  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public AccountAttributes welcomeEmailContent(String welcomeEmailContent) {
    this.welcomeEmailContent = welcomeEmailContent;
    return this;
  }

   /**
   * Content of welcome email each new user will receive.
   * @return welcomeEmailContent
  **/
  @Schema(example = "Welcome to your new account!", description = "Content of welcome email each new user will receive.")
  public String getWelcomeEmailContent() {
    return welcomeEmailContent;
  }

  public void setWelcomeEmailContent(String welcomeEmailContent) {
    this.welcomeEmailContent = welcomeEmailContent;
  }

  public AccountAttributes welcomeEmailSubject(String welcomeEmailSubject) {
    this.welcomeEmailSubject = welcomeEmailSubject;
    return this;
  }

   /**
   * Subject of welcome email each new user will receive.
   * @return welcomeEmailSubject
  **/
  @Schema(example = "ExaVault File Sharing Account", description = "Subject of welcome email each new user will receive.")
  public String getWelcomeEmailSubject() {
    return welcomeEmailSubject;
  }

  public void setWelcomeEmailSubject(String welcomeEmailSubject) {
    this.welcomeEmailSubject = welcomeEmailSubject;
  }

  public AccountAttributes customSignature(String customSignature) {
    this.customSignature = customSignature;
    return this;
  }

   /**
   * Custom signature for all account emails users or recipients will receive.
   * @return customSignature
  **/
  @Schema(description = "Custom signature for all account emails users or recipients will receive.")
  public String getCustomSignature() {
    return customSignature;
  }

  public void setCustomSignature(String customSignature) {
    this.customSignature = customSignature;
  }

  public AccountAttributes accountOnboarding(Boolean accountOnboarding) {
    this.accountOnboarding = accountOnboarding;
    return this;
  }

   /**
   * Whether the web application onboarding help is enabled for new users in the account.
   * @return accountOnboarding
  **/
  @Schema(example = "false", description = "Whether the web application onboarding help is enabled for new users in the account.")
  public Boolean isAccountOnboarding() {
    return accountOnboarding;
  }

  public void setAccountOnboarding(Boolean accountOnboarding) {
    this.accountOnboarding = accountOnboarding;
  }

  public AccountAttributes created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of account creation.
   * @return created
  **/
  @Schema(example = "2017-01-12T09:06:21Z", description = "Timestamp of account creation.")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public AccountAttributes modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp of account modification.
   * @return modified
  **/
  @Schema(example = "2017-06-03T20:42:05Z", description = "Timestamp of account modification.")
  public OffsetDateTime getModified() {
    return modified;
  }

  public void setModified(OffsetDateTime modified) {
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
    AccountAttributes accountAttributes = (AccountAttributes) o;
    return Objects.equals(this.accountName, accountAttributes.accountName) &&
        Objects.equals(this.username, accountAttributes.username) &&
        Objects.equals(this.maxUsers, accountAttributes.maxUsers) &&
        Objects.equals(this.userCount, accountAttributes.userCount) &&
        Objects.equals(this.status, accountAttributes.status) &&
        Objects.equals(this.branding, accountAttributes.branding) &&
        Objects.equals(this.customDomain, accountAttributes.customDomain) &&
        Objects.equals(this.quota, accountAttributes.quota) &&
        Objects.equals(this.secureOnly, accountAttributes.secureOnly) &&
        Objects.equals(this.complexPasswords, accountAttributes.complexPasswords) &&
        Objects.equals(this.showReferralLinks, accountAttributes.showReferralLinks) &&
        Objects.equals(this.externalDomains, accountAttributes.externalDomains) &&
        Objects.equals(this.allowedIp, accountAttributes.allowedIp) &&
        Objects.equals(this.callbackSettings, accountAttributes.callbackSettings) &&
        Objects.equals(this.brandingSettings, accountAttributes.brandingSettings) &&
        Objects.equals(this.clientId, accountAttributes.clientId) &&
        Objects.equals(this.welcomeEmailContent, accountAttributes.welcomeEmailContent) &&
        Objects.equals(this.welcomeEmailSubject, accountAttributes.welcomeEmailSubject) &&
        Objects.equals(this.customSignature, accountAttributes.customSignature) &&
        Objects.equals(this.accountOnboarding, accountAttributes.accountOnboarding) &&
        Objects.equals(this.created, accountAttributes.created) &&
        Objects.equals(this.modified, accountAttributes.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountName, username, maxUsers, userCount, status, branding, customDomain, quota, secureOnly, complexPasswords, showReferralLinks, externalDomains, allowedIp, callbackSettings, brandingSettings, clientId, welcomeEmailContent, welcomeEmailSubject, customSignature, accountOnboarding, created, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountAttributes {\n");
    
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    maxUsers: ").append(toIndentedString(maxUsers)).append("\n");
    sb.append("    userCount: ").append(toIndentedString(userCount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    branding: ").append(toIndentedString(branding)).append("\n");
    sb.append("    customDomain: ").append(toIndentedString(customDomain)).append("\n");
    sb.append("    quota: ").append(toIndentedString(quota)).append("\n");
    sb.append("    secureOnly: ").append(toIndentedString(secureOnly)).append("\n");
    sb.append("    complexPasswords: ").append(toIndentedString(complexPasswords)).append("\n");
    sb.append("    showReferralLinks: ").append(toIndentedString(showReferralLinks)).append("\n");
    sb.append("    externalDomains: ").append(toIndentedString(externalDomains)).append("\n");
    sb.append("    allowedIp: ").append(toIndentedString(allowedIp)).append("\n");
    sb.append("    callbackSettings: ").append(toIndentedString(callbackSettings)).append("\n");
    sb.append("    brandingSettings: ").append(toIndentedString(brandingSettings)).append("\n");
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
