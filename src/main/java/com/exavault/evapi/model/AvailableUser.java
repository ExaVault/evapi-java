/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

public class AvailableUser {
  private Boolean available = null;
  public Boolean getAvailable() {
    return available;
  }
  public void setAvailable(Boolean available) {
    this.available = available;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableUser {\n");
    sb.append("  available: ").append(available).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

