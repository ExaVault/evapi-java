/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package com.exavault.evapi.model;

public class Account {
  private Integer id = null;
  private String username = null;
  private Integer maxUsers = null;
  private Integer userCount = null;
  private Account masterAccount = null;
  private Integer status = null;
  private Boolean branding = null;
  private Boolean customDomain = null;
  private String planCode = null;
  private String diskQuotaLimit = null;
  private String bandwidthQuotaLimit = null;
  private String diskQuotaUsed = null;
  private String bandwidthQuotaUsed = null;
  private String quotaNoticeEnabled = null;
  private String quotaNoticeThreshold = null;
  private String redirect = null;
  private Boolean secureOnly = null;
  private Boolean complexPasswords = null;
  private Boolean showReferralLinks = null;
  private String externalDomains = null;
  private Boolean freeTrial = null;
  private String appliedPromotion = null;
  private String clientId = null;
  private String created = null;
  private String modified = null;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getMaxUsers() {
    return maxUsers;
  }
  public void setMaxUsers(Integer maxUsers) {
    this.maxUsers = maxUsers;
  }

  public Integer getUserCount() {
    return userCount;
  }
  public void setUserCount(Integer userCount) {
    this.userCount = userCount;
  }

  public Account getMasterAccount() {
    return masterAccount;
  }
  public void setMasterAccount(Account masterAccount) {
    this.masterAccount = masterAccount;
  }

  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  public Boolean getBranding() {
    return branding;
  }
  public void setBranding(Boolean branding) {
    this.branding = branding;
  }

  public Boolean getCustomDomain() {
    return customDomain;
  }
  public void setCustomDomain(Boolean customDomain) {
    this.customDomain = customDomain;
  }

  public String getPlanCode() {
    return planCode;
  }
  public void setPlanCode(String planCode) {
    this.planCode = planCode;
  }

  public String getDiskQuotaLimit() {
    return diskQuotaLimit;
  }
  public void setDiskQuotaLimit(String diskQuotaLimit) {
    this.diskQuotaLimit = diskQuotaLimit;
  }

  public String getBandwidthQuotaLimit() {
    return bandwidthQuotaLimit;
  }
  public void setBandwidthQuotaLimit(String bandwidthQuotaLimit) {
    this.bandwidthQuotaLimit = bandwidthQuotaLimit;
  }

  public String getDiskQuotaUsed() {
    return diskQuotaUsed;
  }
  public void setDiskQuotaUsed(String diskQuotaUsed) {
    this.diskQuotaUsed = diskQuotaUsed;
  }

  public String getBandwidthQuotaUsed() {
    return bandwidthQuotaUsed;
  }
  public void setBandwidthQuotaUsed(String bandwidthQuotaUsed) {
    this.bandwidthQuotaUsed = bandwidthQuotaUsed;
  }

  public String getQuotaNoticeEnabled() {
    return quotaNoticeEnabled;
  }
  public void setQuotaNoticeEnabled(String quotaNoticeEnabled) {
    this.quotaNoticeEnabled = quotaNoticeEnabled;
  }

  public String getQuotaNoticeThreshold() {
    return quotaNoticeThreshold;
  }
  public void setQuotaNoticeThreshold(String quotaNoticeThreshold) {
    this.quotaNoticeThreshold = quotaNoticeThreshold;
  }

  public String getRedirect() {
    return redirect;
  }
  public void setRedirect(String redirect) {
    this.redirect = redirect;
  }

  public Boolean getSecureOnly() {
    return secureOnly;
  }
  public void setSecureOnly(Boolean secureOnly) {
    this.secureOnly = secureOnly;
  }

  public Boolean getComplexPasswords() {
    return complexPasswords;
  }
  public void setComplexPasswords(Boolean complexPasswords) {
    this.complexPasswords = complexPasswords;
  }

  public Boolean getShowReferralLinks() {
    return showReferralLinks;
  }
  public void setShowReferralLinks(Boolean showReferralLinks) {
    this.showReferralLinks = showReferralLinks;
  }

  public String getExternalDomains() {
    return externalDomains;
  }
  public void setExternalDomains(String externalDomains) {
    this.externalDomains = externalDomains;
  }

  public Boolean getFreeTrial() {
    return freeTrial;
  }
  public void setFreeTrial(Boolean freeTrial) {
    this.freeTrial = freeTrial;
  }

  public String getAppliedPromotion() {
    return appliedPromotion;
  }
  public void setAppliedPromotion(String appliedPromotion) {
    this.appliedPromotion = appliedPromotion;
  }

  public String getClientId() {
    return clientId;
  }
  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getCreated() {
    return created;
  }
  public void setCreated(String created) {
    this.created = created;
  }

  public String getModified() {
    return modified;
  }
  public void setModified(String modified) {
    this.modified = modified;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  maxUsers: ").append(maxUsers).append("\n");
    sb.append("  userCount: ").append(userCount).append("\n");
    sb.append("  masterAccount: ").append(masterAccount).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  branding: ").append(branding).append("\n");
    sb.append("  customDomain: ").append(customDomain).append("\n");
    sb.append("  planCode: ").append(planCode).append("\n");
    sb.append("  diskQuotaLimit: ").append(diskQuotaLimit).append("\n");
    sb.append("  bandwidthQuotaLimit: ").append(bandwidthQuotaLimit).append("\n");
    sb.append("  diskQuotaUsed: ").append(diskQuotaUsed).append("\n");
    sb.append("  bandwidthQuotaUsed: ").append(bandwidthQuotaUsed).append("\n");
    sb.append("  quotaNoticeEnabled: ").append(quotaNoticeEnabled).append("\n");
    sb.append("  quotaNoticeThreshold: ").append(quotaNoticeThreshold).append("\n");
    sb.append("  redirect: ").append(redirect).append("\n");
    sb.append("  secureOnly: ").append(secureOnly).append("\n");
    sb.append("  complexPasswords: ").append(complexPasswords).append("\n");
    sb.append("  showReferralLinks: ").append(showReferralLinks).append("\n");
    sb.append("  externalDomains: ").append(externalDomains).append("\n");
    sb.append("  freeTrial: ").append(freeTrial).append("\n");
    sb.append("  appliedPromotion: ").append(appliedPromotion).append("\n");
    sb.append("  clientId: ").append(clientId).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("  modified: ").append(modified).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

