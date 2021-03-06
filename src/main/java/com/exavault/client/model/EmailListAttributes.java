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
import org.threeten.bp.OffsetDateTime;
/**
 * Information for the email list, including its short title and recipient emails
 */
@Schema(description = "Information for the email list, including its short title and recipient emails")

public class EmailListAttributes {
  @SerializedName("name")
  private String name = null;

  @SerializedName("emails")
  private List<String> emails = null;

  @SerializedName("created")
  private OffsetDateTime created = null;

  @SerializedName("modified")
  private OffsetDateTime modified = null;

  public EmailListAttributes name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Short title for email list
   * @return name
  **/
  @Schema(description = "Short title for email list")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EmailListAttributes emails(List<String> emails) {
    this.emails = emails;
    return this;
  }

  public EmailListAttributes addEmailsItem(String emailsItem) {
    if (this.emails == null) {
      this.emails = new ArrayList<String>();
    }
    this.emails.add(emailsItem);
    return this;
  }

   /**
   * Recipient emails in the email list
   * @return emails
  **/
  @Schema(description = "Recipient emails in the email list")
  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  public EmailListAttributes created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Created datetime
   * @return created
  **/
  @Schema(description = "Created datetime")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public EmailListAttributes modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Modified datetime
   * @return modified
  **/
  @Schema(description = "Modified datetime")
  public OffsetDateTime getModified() {
    return modified;
  }

  public void setModified(OffsetDateTime modified) {
    this.modified = modified;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailListAttributes emailListAttributes = (EmailListAttributes) o;
    return Objects.equals(this.name, emailListAttributes.name) &&
        Objects.equals(this.emails, emailListAttributes.emails) &&
        Objects.equals(this.created, emailListAttributes.created) &&
        Objects.equals(this.modified, emailListAttributes.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, emails, created, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailListAttributes {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
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
