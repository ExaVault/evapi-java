/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package com.exavault.evapi.model;

public class Error {
  private String message = null;
  private Integer code = null;
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

