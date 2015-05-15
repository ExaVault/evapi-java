/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

import java.util.*;
import main.java.com.exavault.evapi.model.Message;
import main.java.com.exavault.evapi.model.Recipient;
public class Share {
  private Integer id = null;
  private String name = null;
  private Boolean hasPassword = null;
  private Boolean isPublic = null;
  private String accessMode = null;
  private String accessDescription = null;
  private Boolean embed = null;
  private String hash = null;
  private String ownerHash = null;
  private String expiration = null;
  private String trackingStatus = null;
  private String expired = null;
  private Boolean resent = null;
  private Integer owner = null;
  private String ownerUsername = null;
  private String type = null;
  private Boolean requireEmail = null;
  private Boolean fileDropCreateFolders = null;
  private List<String> paths = new ArrayList<String>();
  private List<Recipient> recipients = new ArrayList<Recipient>();
  private List<Recipient> recipientsWithOwner = new ArrayList<Recipient>();
  private List<Message> messages = new ArrayList<Message>();
  private Boolean inherited = null;
  private Integer status = null;
  private Boolean hasNotification = null;
  private String notification = null;
  private String created = null;
  private String modified = null;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public Boolean getHasPassword() {
    return hasPassword;
  }
  public void setHasPassword(Boolean hasPassword) {
    this.hasPassword = hasPassword;
  }

  public Boolean getIsPublic() {
    return isPublic;
  }
  public void setIsPublic(Boolean isPublic) {
    this.isPublic = isPublic;
  }

  public String getAccessMode() {
    return accessMode;
  }
  public void setAccessMode(String accessMode) {
    this.accessMode = accessMode;
  }

  public String getAccessDescription() {
    return accessDescription;
  }
  public void setAccessDescription(String accessDescription) {
    this.accessDescription = accessDescription;
  }

  public Boolean getEmbed() {
    return embed;
  }
  public void setEmbed(Boolean embed) {
    this.embed = embed;
  }

  public String getHash() {
    return hash;
  }
  public void setHash(String hash) {
    this.hash = hash;
  }

  public String getOwnerHash() {
    return ownerHash;
  }
  public void setOwnerHash(String ownerHash) {
    this.ownerHash = ownerHash;
  }

  public String getExpiration() {
    return expiration;
  }
  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public String getTrackingStatus() {
    return trackingStatus;
  }
  public void setTrackingStatus(String trackingStatus) {
    this.trackingStatus = trackingStatus;
  }

  public String getExpired() {
    return expired;
  }
  public void setExpired(String expired) {
    this.expired = expired;
  }

  public Boolean getResent() {
    return resent;
  }
  public void setResent(Boolean resent) {
    this.resent = resent;
  }

  public Integer getOwner() {
    return owner;
  }
  public void setOwner(Integer owner) {
    this.owner = owner;
  }

  public String getOwnerUsername() {
    return ownerUsername;
  }
  public void setOwnerUsername(String ownerUsername) {
    this.ownerUsername = ownerUsername;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public Boolean getRequireEmail() {
    return requireEmail;
  }
  public void setRequireEmail(Boolean requireEmail) {
    this.requireEmail = requireEmail;
  }

  public Boolean getFileDropCreateFolders() {
    return fileDropCreateFolders;
  }
  public void setFileDropCreateFolders(Boolean fileDropCreateFolders) {
    this.fileDropCreateFolders = fileDropCreateFolders;
  }

  public List<String> getPaths() {
    return paths;
  }
  public void setPaths(List<String> paths) {
    this.paths = paths;
  }

  public List<Recipient> getRecipients() {
    return recipients;
  }
  public void setRecipients(List<Recipient> recipients) {
    this.recipients = recipients;
  }

  public List<Recipient> getRecipientsWithOwner() {
    return recipientsWithOwner;
  }
  public void setRecipientsWithOwner(List<Recipient> recipientsWithOwner) {
    this.recipientsWithOwner = recipientsWithOwner;
  }

  public List<Message> getMessages() {
    return messages;
  }
  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public Boolean getInherited() {
    return inherited;
  }
  public void setInherited(Boolean inherited) {
    this.inherited = inherited;
  }

  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  public Boolean getHasNotification() {
    return hasNotification;
  }
  public void setHasNotification(Boolean hasNotification) {
    this.hasNotification = hasNotification;
  }

  public String getNotification() {
    return notification;
  }
  public void setNotification(String notification) {
    this.notification = notification;
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
    sb.append("class Share {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  hasPassword: ").append(hasPassword).append("\n");
    sb.append("  isPublic: ").append(isPublic).append("\n");
    sb.append("  accessMode: ").append(accessMode).append("\n");
    sb.append("  accessDescription: ").append(accessDescription).append("\n");
    sb.append("  embed: ").append(embed).append("\n");
    sb.append("  hash: ").append(hash).append("\n");
    sb.append("  ownerHash: ").append(ownerHash).append("\n");
    sb.append("  expiration: ").append(expiration).append("\n");
    sb.append("  trackingStatus: ").append(trackingStatus).append("\n");
    sb.append("  expired: ").append(expired).append("\n");
    sb.append("  resent: ").append(resent).append("\n");
    sb.append("  owner: ").append(owner).append("\n");
    sb.append("  ownerUsername: ").append(ownerUsername).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  requireEmail: ").append(requireEmail).append("\n");
    sb.append("  fileDropCreateFolders: ").append(fileDropCreateFolders).append("\n");
    sb.append("  paths: ").append(paths).append("\n");
    sb.append("  recipients: ").append(recipients).append("\n");
    sb.append("  recipientsWithOwner: ").append(recipientsWithOwner).append("\n");
    sb.append("  messages: ").append(messages).append("\n");
    sb.append("  inherited: ").append(inherited).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  hasNotification: ").append(hasNotification).append("\n");
    sb.append("  notification: ").append(notification).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("  modified: ").append(modified).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

