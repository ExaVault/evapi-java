/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

public class ModifiedResource {
  private String file = null;
  private String destination = null;
  private Integer size = null;
  private Integer success = null;
  public String getFile() {
    return file;
  }
  public void setFile(String file) {
    this.file = file;
  }

  public String getDestination() {
    return destination;
  }
  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Integer getSize() {
    return size;
  }
  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getSuccess() {
    return success;
  }
  public void setSuccess(Integer success) {
    this.success = success;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifiedResource {\n");
    sb.append("  file: ").append(file).append("\n");
    sb.append("  destination: ").append(destination).append("\n");
    sb.append("  size: ").append(size).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

