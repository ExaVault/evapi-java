/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

import java.util.*;
import main.java.com.exavault.evapi.model.Share;
public class ResourceProperty {
  private Integer fileCount = null;
  private String file = null;
  private String name = null;
  private String createdBy = null;
  private String uploadDate = null;
  private String parent = null;
  private String path = null;
  private List<Share> shares = new ArrayList<Share>();
  private String notificationSettings = null;
  private Integer size = null;
  private Boolean previewable = null;
  private String type = null;
  public Integer getFileCount() {
    return fileCount;
  }
  public void setFileCount(Integer fileCount) {
    this.fileCount = fileCount;
  }

  public String getFile() {
    return file;
  }
  public void setFile(String file) {
    this.file = file;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getCreatedBy() {
    return createdBy;
  }
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getUploadDate() {
    return uploadDate;
  }
  public void setUploadDate(String uploadDate) {
    this.uploadDate = uploadDate;
  }

  public String getParent() {
    return parent;
  }
  public void setParent(String parent) {
    this.parent = parent;
  }

  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }

  public List<Share> getShares() {
    return shares;
  }
  public void setShares(List<Share> shares) {
    this.shares = shares;
  }

  public String getNotificationSettings() {
    return notificationSettings;
  }
  public void setNotificationSettings(String notificationSettings) {
    this.notificationSettings = notificationSettings;
  }

  public Integer getSize() {
    return size;
  }
  public void setSize(Integer size) {
    this.size = size;
  }

  public Boolean getPreviewable() {
    return previewable;
  }
  public void setPreviewable(Boolean previewable) {
    this.previewable = previewable;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceProperty {\n");
    sb.append("  fileCount: ").append(fileCount).append("\n");
    sb.append("  file: ").append(file).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  createdBy: ").append(createdBy).append("\n");
    sb.append("  uploadDate: ").append(uploadDate).append("\n");
    sb.append("  parent: ").append(parent).append("\n");
    sb.append("  path: ").append(path).append("\n");
    sb.append("  shares: ").append(shares).append("\n");
    sb.append("  notificationSettings: ").append(notificationSettings).append("\n");
    sb.append("  size: ").append(size).append("\n");
    sb.append("  previewable: ").append(previewable).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

