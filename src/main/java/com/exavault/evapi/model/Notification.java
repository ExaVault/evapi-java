/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

import java.util.*;
import main.java.com.exavault.evapi.model.Recipient;
public class Notification {
  private String id = null;
  private String userId = null;
  private String type = null;
  private String path = null;
  private String name = null;
  private String action = null;
  private List<String> usernames = new ArrayList<String>();
  private List<Recipient> recipients = new ArrayList<Recipient>();
  private List<String> recipientEmails = new ArrayList<String>();
  private String sendEmail = null;
  private String readableDescription = null;
  private String readableDescriptionWithoutPath = null;
  private String shareId = null;
  private String created = null;
  private String modified = null;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getAction() {
    return action;
  }
  public void setAction(String action) {
    this.action = action;
  }

  public List<String> getUsernames() {
    return usernames;
  }
  public void setUsernames(List<String> usernames) {
    this.usernames = usernames;
  }

  public List<Recipient> getRecipients() {
    return recipients;
  }
  public void setRecipients(List<Recipient> recipients) {
    this.recipients = recipients;
  }

  public List<String> getRecipientEmails() {
    return recipientEmails;
  }
  public void setRecipientEmails(List<String> recipientEmails) {
    this.recipientEmails = recipientEmails;
  }

  public String getSendEmail() {
    return sendEmail;
  }
  public void setSendEmail(String sendEmail) {
    this.sendEmail = sendEmail;
  }

  public String getReadableDescription() {
    return readableDescription;
  }
  public void setReadableDescription(String readableDescription) {
    this.readableDescription = readableDescription;
  }

  public String getReadableDescriptionWithoutPath() {
    return readableDescriptionWithoutPath;
  }
  public void setReadableDescriptionWithoutPath(String readableDescriptionWithoutPath) {
    this.readableDescriptionWithoutPath = readableDescriptionWithoutPath;
  }

  public String getShareId() {
    return shareId;
  }
  public void setShareId(String shareId) {
    this.shareId = shareId;
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
    sb.append("class Notification {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  userId: ").append(userId).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  path: ").append(path).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  action: ").append(action).append("\n");
    sb.append("  usernames: ").append(usernames).append("\n");
    sb.append("  recipients: ").append(recipients).append("\n");
    sb.append("  recipientEmails: ").append(recipientEmails).append("\n");
    sb.append("  sendEmail: ").append(sendEmail).append("\n");
    sb.append("  readableDescription: ").append(readableDescription).append("\n");
    sb.append("  readableDescriptionWithoutPath: ").append(readableDescriptionWithoutPath).append("\n");
    sb.append("  shareId: ").append(shareId).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("  modified: ").append(modified).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

