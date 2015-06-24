/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

import main.java.com.exavault.evapi.model.ResourceProperty;
public class ExistingResource {
  private Boolean exists = null;
  private ResourceProperty resource = null;
  public Boolean getExists() {
    return exists;
  }
  public void setExists(Boolean exists) {
    this.exists = exists;
  }

  public ResourceProperty getResource() {
    return resource;
  }
  public void setResource(ResourceProperty resource) {
    this.resource = resource;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExistingResource {\n");
    sb.append("  exists: ").append(exists).append("\n");
    sb.append("  resource: ").append(resource).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

