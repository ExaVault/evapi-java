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
/**
 * Identifying info for related record
 */
@Schema(description = "Identifying info for related record")

public class RelationshipData {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("type")
  private String type = null;

  public RelationshipData id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID number of related record
   * @return id
  **/
  @Schema(description = "ID number of related record")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RelationshipData type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Kind of record
   * @return type
  **/
  @Schema(description = "Kind of record")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelationshipData relationshipData = (RelationshipData) o;
    return Objects.equals(this.id, relationshipData.id) &&
        Objects.equals(this.type, relationshipData.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationshipData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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