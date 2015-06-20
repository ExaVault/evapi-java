/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

public class User {
  private Integer gid = null;
  private Integer status = null;
  private String created = null;
  private String modified = null;
  private String accessTimestamp = null;
  private Integer id = null;
  private Integer owningAccountId = null;
  private String username = null;
  private String nickname = null;
  private String email = null;
  private String expiration = null;
  private String homeDir = null;
  private Boolean download = null;
  private Boolean upload = null;
  private Boolean modify = null;
  private Boolean delete = null;
  private Boolean list = null;
  private Boolean changePassword = null;
  private Boolean share = null;
  private Boolean notification = null;
  private String role = null;
  private String timeZone = null;
  public Integer getGid() {
    return gid;
  }
  public void setGid(Integer gid) {
    this.gid = gid;
  }

  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
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

  public String getAccessTimestamp() {
    return accessTimestamp;
  }
  public void setAccessTimestamp(String accessTimestamp) {
    this.accessTimestamp = accessTimestamp;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOwningAccountId() {
    return owningAccountId;
  }
  public void setOwningAccountId(Integer owningAccountId) {
    this.owningAccountId = owningAccountId;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getNickname() {
    return nickname;
  }
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getExpiration() {
    return expiration;
  }
  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public String getHomeDir() {
    return homeDir;
  }
  public void setHomeDir(String homeDir) {
    this.homeDir = homeDir;
  }

  public Boolean getDownload() {
    return download;
  }
  public void setDownload(Boolean download) {
    this.download = download;
  }

  public Boolean getUpload() {
    return upload;
  }
  public void setUpload(Boolean upload) {
    this.upload = upload;
  }

  public Boolean getModify() {
    return modify;
  }
  public void setModify(Boolean modify) {
    this.modify = modify;
  }

  public Boolean getDelete() {
    return delete;
  }
  public void setDelete(Boolean delete) {
    this.delete = delete;
  }

  public Boolean getList() {
    return list;
  }
  public void setList(Boolean list) {
    this.list = list;
  }

  public Boolean getChangePassword() {
    return changePassword;
  }
  public void setChangePassword(Boolean changePassword) {
    this.changePassword = changePassword;
  }

  public Boolean getShare() {
    return share;
  }
  public void setShare(Boolean share) {
    this.share = share;
  }

  public Boolean getNotification() {
    return notification;
  }
  public void setNotification(Boolean notification) {
    this.notification = notification;
  }

  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }

  public String getTimeZone() {
    return timeZone;
  }
  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("  gid: ").append(gid).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("  modified: ").append(modified).append("\n");
    sb.append("  accessTimestamp: ").append(accessTimestamp).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  owningAccountId: ").append(owningAccountId).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  nickname: ").append(nickname).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  expiration: ").append(expiration).append("\n");
    sb.append("  homeDir: ").append(homeDir).append("\n");
    sb.append("  download: ").append(download).append("\n");
    sb.append("  upload: ").append(upload).append("\n");
    sb.append("  modify: ").append(modify).append("\n");
    sb.append("  delete: ").append(delete).append("\n");
    sb.append("  list: ").append(list).append("\n");
    sb.append("  changePassword: ").append(changePassword).append("\n");
    sb.append("  share: ").append(share).append("\n");
    sb.append("  notification: ").append(notification).append("\n");
    sb.append("  role: ").append(role).append("\n");
    sb.append("  timeZone: ").append(timeZone).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

