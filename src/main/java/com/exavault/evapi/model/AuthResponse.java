/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package com.exavault.evapi.model;

import com.exavault.evapi.model.Error;
import com.exavault.evapi.model.Auth;
public class AuthResponse {
  private Integer success = null;
  private Error error = null;
  private Auth results = null;
  public Integer getSuccess() {
    return success;
  }
  public void setSuccess(Integer success) {
    this.success = success;
  }

  public Error getError() {
    return error;
  }
  public void setError(Error error) {
    this.error = error;
  }

  public Auth getResults() {
    return results;
  }
  public void setResults(Auth results) {
    this.results = results;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthResponse {\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("  results: ").append(results).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

