/*
 * ExaVault API
 * See our API reference documentation at https://www.exavault.com/developer/api-docs/
 *
 * OpenAPI spec version: 2.0
 * Contact: support@exavault.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.exavault.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Body10
 */


public class Body10 {
  @SerializedName("resources")
  private List<String> resources = new ArrayList<String>();

  @SerializedName("parentResource")
  private String parentResource = null;

  @SerializedName("archive Name")
  private String archiveName = null;

  public Body10 resources(List<String> resources) {
    this.resources = resources;
    return this;
  }

  public Body10 addResourcesItem(String resourcesItem) {
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Resource identifiers for file(s)/folder(s) to include in new zip file
   * @return resources
  **/
  @Schema(required = true, description = "Resource identifiers for file(s)/folder(s) to include in new zip file")
  public List<String> getResources() {
    return resources;
  }

  public void setResources(List<String> resources) {
    this.resources = resources;
  }

  public Body10 parentResource(String parentResource) {
    this.parentResource = parentResource;
    return this;
  }

   /**
   * Full path to folder new archive will be created in. If left blank, \&quot;/\&quot; will be used.
   * @return parentResource
  **/
  @Schema(description = "Full path to folder new archive will be created in. If left blank, \"/\" will be used.")
  public String getParentResource() {
    return parentResource;
  }

  public void setParentResource(String parentResource) {
    this.parentResource = parentResource;
  }

  public Body10 archiveName(String archiveName) {
    this.archiveName = archiveName;
    return this;
  }

   /**
   * Name of the zip archive to create. If left blank, current date will be used.
   * @return archiveName
  **/
  @Schema(description = "Name of the zip archive to create. If left blank, current date will be used.")
  public String getArchiveName() {
    return archiveName;
  }

  public void setArchiveName(String archiveName) {
    this.archiveName = archiveName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body10 body10 = (Body10) o;
    return Objects.equals(this.resources, body10.resources) &&
        Objects.equals(this.parentResource, body10.parentResource) &&
        Objects.equals(this.archiveName, body10.archiveName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resources, parentResource, archiveName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body10 {\n");
    
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    parentResource: ").append(toIndentedString(parentResource)).append("\n");
    sb.append("    archiveName: ").append(toIndentedString(archiveName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}