/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package com.exavault.evapi.model;

import java.util.*;
import com.exavault.evapi.model.ResourceProperty;
public class Resource {
  private Integer totalFiles = null;
  private List<ResourceProperty> resources = new ArrayList<ResourceProperty>();
  private String inheritedShares = null;
  private String inheritedNotifications = null;
  public Integer getTotalFiles() {
    return totalFiles;
  }
  public void setTotalFiles(Integer totalFiles) {
    this.totalFiles = totalFiles;
  }

  public List<ResourceProperty> getResources() {
    return resources;
  }
  public void setResources(List<ResourceProperty> resources) {
    this.resources = resources;
  }

  public String getInheritedShares() {
    return inheritedShares;
  }
  public void setInheritedShares(String inheritedShares) {
    this.inheritedShares = inheritedShares;
  }

  public String getInheritedNotifications() {
    return inheritedNotifications;
  }
  public void setInheritedNotifications(String inheritedNotifications) {
    this.inheritedNotifications = inheritedNotifications;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    sb.append("  totalFiles: ").append(totalFiles).append("\n");
    sb.append("  resources: ").append(resources).append("\n");
    sb.append("  inheritedShares: ").append(inheritedShares).append("\n");
    sb.append("  inheritedNotifications: ").append(inheritedNotifications).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

