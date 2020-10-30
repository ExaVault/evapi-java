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
 * Body1
 */


public class Body1 {
  @SerializedName("name")
  private String name = null;

  @SerializedName("emails")
  private List<String> emails = null;

  public Body1 name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the email list.
   * @return name
  **/
  @Schema(example = "My friends list", description = "Name of the email list.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Body1 emails(List<String> emails) {
    this.emails = emails;
    return this;
  }

  public Body1 addEmailsItem(String emailsItem) {
    if (this.emails == null) {
      this.emails = new ArrayList<String>();
    }
    this.emails.add(emailsItem);
    return this;
  }

   /**
   * Array of email addresses to add to the email list.
   * @return emails
  **/
  @Schema(example = "[\"ykravchuk@exavault.com\",\"jdoe@exavault.com\"]", description = "Array of email addresses to add to the email list.")
  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body1 body1 = (Body1) o;
    return Objects.equals(this.name, body1.name) &&
        Objects.equals(this.emails, body1.emails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, emails);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body1 {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
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