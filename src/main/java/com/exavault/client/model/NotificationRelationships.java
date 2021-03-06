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
import com.exavault.client.model.NotificationRelationshipsOwnerUser;
import com.exavault.client.model.NotificationRelationshipsResource;
import com.exavault.client.model.NotificationRelationshipsShare;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * NotificationRelationships
 */


public class NotificationRelationships {
  @SerializedName("resource")
  private NotificationRelationshipsResource resource = null;

  @SerializedName("share")
  private NotificationRelationshipsShare share = null;

  @SerializedName("ownerUser")
  private NotificationRelationshipsOwnerUser ownerUser = null;

  public NotificationRelationships resource(NotificationRelationshipsResource resource) {
    this.resource = resource;
    return this;
  }

   /**
   * Get resource
   * @return resource
  **/
  @Schema(description = "")
  public NotificationRelationshipsResource getResource() {
    return resource;
  }

  public void setResource(NotificationRelationshipsResource resource) {
    this.resource = resource;
  }

  public NotificationRelationships share(NotificationRelationshipsShare share) {
    this.share = share;
    return this;
  }

   /**
   * Get share
   * @return share
  **/
  @Schema(description = "")
  public NotificationRelationshipsShare getShare() {
    return share;
  }

  public void setShare(NotificationRelationshipsShare share) {
    this.share = share;
  }

  public NotificationRelationships ownerUser(NotificationRelationshipsOwnerUser ownerUser) {
    this.ownerUser = ownerUser;
    return this;
  }

   /**
   * Get ownerUser
   * @return ownerUser
  **/
  @Schema(description = "")
  public NotificationRelationshipsOwnerUser getOwnerUser() {
    return ownerUser;
  }

  public void setOwnerUser(NotificationRelationshipsOwnerUser ownerUser) {
    this.ownerUser = ownerUser;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationRelationships notificationRelationships = (NotificationRelationships) o;
    return Objects.equals(this.resource, notificationRelationships.resource) &&
        Objects.equals(this.share, notificationRelationships.share) &&
        Objects.equals(this.ownerUser, notificationRelationships.ownerUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource, share, ownerUser);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationRelationships {\n");
    
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    share: ").append(toIndentedString(share)).append("\n");
    sb.append("    ownerUser: ").append(toIndentedString(ownerUser)).append("\n");
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
