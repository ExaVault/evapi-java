/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

public class File {
  private String file = null;
  private String size = null;
  private Integer success = null;
  public String getFile() {
    return file;
  }
  public void setFile(String file) {
    this.file = file;
  }

  public String getSize() {
    return size;
  }
  public void setSize(String size) {
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
    sb.append("class File {\n");
    sb.append("  file: ").append(file).append("\n");
    sb.append("  size: ").append(size).append("\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

