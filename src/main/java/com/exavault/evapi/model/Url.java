/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package com.exavault.evapi.model;

public class Url {
  private String url = null;
  private Integer offset = null;
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getOffset() {
    return offset;
  }
  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Url {\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  offset: ").append(offset).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

