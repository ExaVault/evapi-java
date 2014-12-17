/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package com.exavault.evapi.model;

public class Auth {
  private String username = null;
  private String accessToken = null;
  private Integer mode = null;
  private String clientIp = null;
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getAccessToken() {
    return accessToken;
  }
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public Integer getMode() {
    return mode;
  }
  public void setMode(Integer mode) {
    this.mode = mode;
  }

  public String getClientIp() {
    return clientIp;
  }
  public void setClientIp(String clientIp) {
    this.clientIp = clientIp;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Auth {\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  accessToken: ").append(accessToken).append("\n");
    sb.append("  mode: ").append(mode).append("\n");
    sb.append("  clientIp: ").append(clientIp).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

