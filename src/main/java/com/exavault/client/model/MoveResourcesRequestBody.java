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
 * MoveResourcesRequestBody
 */


public class MoveResourcesRequestBody {
  @SerializedName("resources")
  private List<String> resources = new ArrayList<String>();

  @SerializedName("parentResource")
  private String parentResource = null;

  public MoveResourcesRequestBody resources(List<String> resources) {
    this.resources = resources;
    return this;
  }

  public MoveResourcesRequestBody addResourcesItem(String resourcesItem) {
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Array containing file/folder paths to move.
   * @return resources
  **/
  @Schema(example = "[\"/testone.jpg\",\"/folder\"]", required = true, description = "Array containing file/folder paths to move.")
  public List<String> getResources() {
    return resources;
  }

  public void setResources(List<String> resources) {
    this.resources = resources;
  }

  public MoveResourcesRequestBody parentResource(String parentResource) {
    this.parentResource = parentResource;
    return this;
  }

   /**
   * Remote destination path to move files/folders to.
   * @return parentResource
  **/
  @Schema(example = "/copyhere", required = true, description = "Remote destination path to move files/folders to.")
  public String getParentResource() {
    return parentResource;
  }

  public void setParentResource(String parentResource) {
    this.parentResource = parentResource;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoveResourcesRequestBody moveResourcesRequestBody = (MoveResourcesRequestBody) o;
    return Objects.equals(this.resources, moveResourcesRequestBody.resources) &&
        Objects.equals(this.parentResource, moveResourcesRequestBody.parentResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resources, parentResource);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoveResourcesRequestBody {\n");
    
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    parentResource: ").append(toIndentedString(parentResource)).append("\n");
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
