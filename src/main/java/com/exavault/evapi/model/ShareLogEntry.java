/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

public class ShareLogEntry {
  private Integer id = null;
  private String shareId = null;
  private String username = null;
  private String action = null;
  private String actionObjectId = null;
  private String detail = null;
  private String created = null;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getShareId() {
    return shareId;
  }
  public void setShareId(String shareId) {
    this.shareId = shareId;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getAction() {
    return action;
  }
  public void setAction(String action) {
    this.action = action;
  }

  public String getActionObjectId() {
    return actionObjectId;
  }
  public void setActionObjectId(String actionObjectId) {
    this.actionObjectId = actionObjectId;
  }

  public String getDetail() {
    return detail;
  }
  public void setDetail(String detail) {
    this.detail = detail;
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
    sb.append("class ShareLogEntry {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  shareId: ").append(shareId).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  action: ").append(action).append("\n");
    sb.append("  actionObjectId: ").append(actionObjectId).append("\n");
    sb.append("  detail: ").append(detail).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

