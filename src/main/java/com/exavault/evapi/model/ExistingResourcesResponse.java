/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

import java.util.*;
import main.java.com.exavault.evapi.model.Error;
import main.java.com.exavault.evapi.model.ExistingResource;
public class ExistingResourcesResponse {
  private Integer success = null;
  private Error error = null;
  private List<ExistingResource> results = new ArrayList<ExistingResource>();
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

  public List<ExistingResource> getResults() {
    return results;
  }
  public void setResults(List<ExistingResource> results) {
    this.results = results;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExistingResourcesResponse {\n");
    sb.append("  success: ").append(success).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("  results: ").append(results).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

