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
import com.exavault.client.model.FormRelationshipsShare;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Share relationship data of the form. 
 */
@Schema(description = "Share relationship data of the form. ")

public class FormRelationships {
  @SerializedName("share")
  private FormRelationshipsShare share = null;

  public FormRelationships share(FormRelationshipsShare share) {
    this.share = share;
    return this;
  }

   /**
   * Get share
   * @return share
  **/
  @Schema(description = "")
  public FormRelationshipsShare getShare() {
    return share;
  }

  public void setShare(FormRelationshipsShare share) {
    this.share = share;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormRelationships formRelationships = (FormRelationships) o;
    return Objects.equals(this.share, formRelationships.share);
  }

  @Override
  public int hashCode() {
    return Objects.hash(share);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormRelationships {\n");
    
    sb.append("    share: ").append(toIndentedString(share)).append("\n");
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