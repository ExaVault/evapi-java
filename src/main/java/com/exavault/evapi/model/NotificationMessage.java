/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

import main.java.com.exavault.evapi.model.Notification;
public class NotificationMessage {
  private Integer id = null;
  private Notification notificationSetting = null;
  private String message = null;
  private String path = null;
  private String action = null;
  private String username = null;
  private Boolean sent = null;
  private Boolean read = null;
  private String created = null;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public Notification getNotificationSetting() {
    return notificationSetting;
  }
  public void setNotificationSetting(Notification notificationSetting) {
    this.notificationSetting = notificationSetting;
  }

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }

  public String getAction() {
    return action;
  }
  public void setAction(String action) {
    this.action = action;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public Boolean getSent() {
    return sent;
  }
  public void setSent(Boolean sent) {
    this.sent = sent;
  }

  public Boolean getRead() {
    return read;
  }
  public void setRead(Boolean read) {
    this.read = read;
  }

  public String getCreated() {
    return created;
  }
  public void setCreated(String created) {
    this.created = created;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationMessage {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  notificationSetting: ").append(notificationSetting).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  path: ").append(path).append("\n");
    sb.append("  action: ").append(action).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  sent: ").append(sent).append("\n");
    sb.append("  read: ").append(read).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

