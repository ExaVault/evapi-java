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
import com.exavault.client.model.PlanDetailsWebhookOptions;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * PlanDetails
 */


public class PlanDetails {
  @SerializedName("storageAddOn")
  private Integer storageAddOn = null;

  @SerializedName("ipWhitelist")
  private Boolean ipWhitelist = null;

  @SerializedName("userExpiration")
  private Boolean userExpiration = null;

  @SerializedName("userImport")
  private Boolean userImport = null;

  @SerializedName("customDomain")
  private Boolean customDomain = null;

  @SerializedName("customName")
  private Boolean customName = null;

  @SerializedName("colorSchema")
  private Boolean colorSchema = null;

  @SerializedName("apiKeys")
  private Integer apiKeys = null;

  @SerializedName("apiTokens")
  private Integer apiTokens = null;

  @SerializedName("sshKeys")
  private Integer sshKeys = null;

  @SerializedName("directLinks")
  private Boolean directLinks = null;

  @SerializedName("sharingOptions")
  private List<String> sharingOptions = null;

  @SerializedName("webhookOptions")
  private PlanDetailsWebhookOptions webhookOptions = null;

  @SerializedName("unlimitedUsers")
  private Boolean unlimitedUsers = null;

  public PlanDetails storageAddOn(Integer storageAddOn) {
    this.storageAddOn = storageAddOn;
    return this;
  }

   /**
   * Get storageAddOn
   * @return storageAddOn
  **/
  @Schema(description = "")
  public Integer getStorageAddOn() {
    return storageAddOn;
  }

  public void setStorageAddOn(Integer storageAddOn) {
    this.storageAddOn = storageAddOn;
  }

  public PlanDetails ipWhitelist(Boolean ipWhitelist) {
    this.ipWhitelist = ipWhitelist;
    return this;
  }

   /**
   * Get ipWhitelist
   * @return ipWhitelist
  **/
  @Schema(description = "")
  public Boolean isIpWhitelist() {
    return ipWhitelist;
  }

  public void setIpWhitelist(Boolean ipWhitelist) {
    this.ipWhitelist = ipWhitelist;
  }

  public PlanDetails userExpiration(Boolean userExpiration) {
    this.userExpiration = userExpiration;
    return this;
  }

   /**
   * Get userExpiration
   * @return userExpiration
  **/
  @Schema(description = "")
  public Boolean isUserExpiration() {
    return userExpiration;
  }

  public void setUserExpiration(Boolean userExpiration) {
    this.userExpiration = userExpiration;
  }

  public PlanDetails userImport(Boolean userImport) {
    this.userImport = userImport;
    return this;
  }

   /**
   * Get userImport
   * @return userImport
  **/
  @Schema(description = "")
  public Boolean isUserImport() {
    return userImport;
  }

  public void setUserImport(Boolean userImport) {
    this.userImport = userImport;
  }

  public PlanDetails customDomain(Boolean customDomain) {
    this.customDomain = customDomain;
    return this;
  }

   /**
   * Get customDomain
   * @return customDomain
  **/
  @Schema(description = "")
  public Boolean isCustomDomain() {
    return customDomain;
  }

  public void setCustomDomain(Boolean customDomain) {
    this.customDomain = customDomain;
  }

  public PlanDetails customName(Boolean customName) {
    this.customName = customName;
    return this;
  }

   /**
   * Get customName
   * @return customName
  **/
  @Schema(description = "")
  public Boolean isCustomName() {
    return customName;
  }

  public void setCustomName(Boolean customName) {
    this.customName = customName;
  }

  public PlanDetails colorSchema(Boolean colorSchema) {
    this.colorSchema = colorSchema;
    return this;
  }

   /**
   * Get colorSchema
   * @return colorSchema
  **/
  @Schema(description = "")
  public Boolean isColorSchema() {
    return colorSchema;
  }

  public void setColorSchema(Boolean colorSchema) {
    this.colorSchema = colorSchema;
  }

  public PlanDetails apiKeys(Integer apiKeys) {
    this.apiKeys = apiKeys;
    return this;
  }

   /**
   * Get apiKeys
   * @return apiKeys
  **/
  @Schema(description = "")
  public Integer getApiKeys() {
    return apiKeys;
  }

  public void setApiKeys(Integer apiKeys) {
    this.apiKeys = apiKeys;
  }

  public PlanDetails apiTokens(Integer apiTokens) {
    this.apiTokens = apiTokens;
    return this;
  }

   /**
   * Get apiTokens
   * @return apiTokens
  **/
  @Schema(description = "")
  public Integer getApiTokens() {
    return apiTokens;
  }

  public void setApiTokens(Integer apiTokens) {
    this.apiTokens = apiTokens;
  }

  public PlanDetails sshKeys(Integer sshKeys) {
    this.sshKeys = sshKeys;
    return this;
  }

   /**
   * Get sshKeys
   * @return sshKeys
  **/
  @Schema(description = "")
  public Integer getSshKeys() {
    return sshKeys;
  }

  public void setSshKeys(Integer sshKeys) {
    this.sshKeys = sshKeys;
  }

  public PlanDetails directLinks(Boolean directLinks) {
    this.directLinks = directLinks;
    return this;
  }

   /**
   * Get directLinks
   * @return directLinks
  **/
  @Schema(description = "")
  public Boolean isDirectLinks() {
    return directLinks;
  }

  public void setDirectLinks(Boolean directLinks) {
    this.directLinks = directLinks;
  }

  public PlanDetails sharingOptions(List<String> sharingOptions) {
    this.sharingOptions = sharingOptions;
    return this;
  }

  public PlanDetails addSharingOptionsItem(String sharingOptionsItem) {
    if (this.sharingOptions == null) {
      this.sharingOptions = new ArrayList<String>();
    }
    this.sharingOptions.add(sharingOptionsItem);
    return this;
  }

   /**
   * Get sharingOptions
   * @return sharingOptions
  **/
  @Schema(description = "")
  public List<String> getSharingOptions() {
    return sharingOptions;
  }

  public void setSharingOptions(List<String> sharingOptions) {
    this.sharingOptions = sharingOptions;
  }

  public PlanDetails webhookOptions(PlanDetailsWebhookOptions webhookOptions) {
    this.webhookOptions = webhookOptions;
    return this;
  }

   /**
   * Get webhookOptions
   * @return webhookOptions
  **/
  @Schema(description = "")
  public PlanDetailsWebhookOptions getWebhookOptions() {
    return webhookOptions;
  }

  public void setWebhookOptions(PlanDetailsWebhookOptions webhookOptions) {
    this.webhookOptions = webhookOptions;
  }

  public PlanDetails unlimitedUsers(Boolean unlimitedUsers) {
    this.unlimitedUsers = unlimitedUsers;
    return this;
  }

   /**
   * Get unlimitedUsers
   * @return unlimitedUsers
  **/
  @Schema(description = "")
  public Boolean isUnlimitedUsers() {
    return unlimitedUsers;
  }

  public void setUnlimitedUsers(Boolean unlimitedUsers) {
    this.unlimitedUsers = unlimitedUsers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanDetails planDetails = (PlanDetails) o;
    return Objects.equals(this.storageAddOn, planDetails.storageAddOn) &&
        Objects.equals(this.ipWhitelist, planDetails.ipWhitelist) &&
        Objects.equals(this.userExpiration, planDetails.userExpiration) &&
        Objects.equals(this.userImport, planDetails.userImport) &&
        Objects.equals(this.customDomain, planDetails.customDomain) &&
        Objects.equals(this.customName, planDetails.customName) &&
        Objects.equals(this.colorSchema, planDetails.colorSchema) &&
        Objects.equals(this.apiKeys, planDetails.apiKeys) &&
        Objects.equals(this.apiTokens, planDetails.apiTokens) &&
        Objects.equals(this.sshKeys, planDetails.sshKeys) &&
        Objects.equals(this.directLinks, planDetails.directLinks) &&
        Objects.equals(this.sharingOptions, planDetails.sharingOptions) &&
        Objects.equals(this.webhookOptions, planDetails.webhookOptions) &&
        Objects.equals(this.unlimitedUsers, planDetails.unlimitedUsers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storageAddOn, ipWhitelist, userExpiration, userImport, customDomain, customName, colorSchema, apiKeys, apiTokens, sshKeys, directLinks, sharingOptions, webhookOptions, unlimitedUsers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanDetails {\n");
    
    sb.append("    storageAddOn: ").append(toIndentedString(storageAddOn)).append("\n");
    sb.append("    ipWhitelist: ").append(toIndentedString(ipWhitelist)).append("\n");
    sb.append("    userExpiration: ").append(toIndentedString(userExpiration)).append("\n");
    sb.append("    userImport: ").append(toIndentedString(userImport)).append("\n");
    sb.append("    customDomain: ").append(toIndentedString(customDomain)).append("\n");
    sb.append("    customName: ").append(toIndentedString(customName)).append("\n");
    sb.append("    colorSchema: ").append(toIndentedString(colorSchema)).append("\n");
    sb.append("    apiKeys: ").append(toIndentedString(apiKeys)).append("\n");
    sb.append("    apiTokens: ").append(toIndentedString(apiTokens)).append("\n");
    sb.append("    sshKeys: ").append(toIndentedString(sshKeys)).append("\n");
    sb.append("    directLinks: ").append(toIndentedString(directLinks)).append("\n");
    sb.append("    sharingOptions: ").append(toIndentedString(sharingOptions)).append("\n");
    sb.append("    webhookOptions: ").append(toIndentedString(webhookOptions)).append("\n");
    sb.append("    unlimitedUsers: ").append(toIndentedString(unlimitedUsers)).append("\n");
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
