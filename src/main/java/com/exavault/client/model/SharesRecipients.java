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
 * SharesRecipients
 */


public class SharesRecipients {
  @SerializedName("type")
  private String type = null;

  @SerializedName("email")
  private String email = null;

  public SharesRecipients type(String type) {
    this.type = type;
    return this;
  }

   /**
   * What kind of email should be sent to this recipient. Valid choices are **direct** and **cc**
   * @return type
  **/
  @Schema(description = "What kind of email should be sent to this recipient. Valid choices are **direct** and **cc**")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SharesRecipients email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email address of person you are inviting to the share
   * @return email
  **/
  @Schema(description = "Email address of person you are inviting to the share")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SharesRecipients sharesRecipients = (SharesRecipients) o;
    return Objects.equals(this.type, sharesRecipients.type) &&
        Objects.equals(this.email, sharesRecipients.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, email);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SharesRecipients {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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