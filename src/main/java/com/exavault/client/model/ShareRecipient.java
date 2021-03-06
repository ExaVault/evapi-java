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
import org.threeten.bp.OffsetDateTime;
/**
 * ShareRecipient
 */


public class ShareRecipient {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("shareId")
  private String shareId = null;

  /**
   * Type of the recipient.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    OWNER("owner"),
    DIRECT("direct");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("type")
  private TypeEnum type = null;

  @SerializedName("hash")
  private String hash = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("sent")
  private Boolean sent = null;

  @SerializedName("received")
  private Boolean received = null;

  @SerializedName("created")
  private OffsetDateTime created = null;

  public ShareRecipient id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the recipient.
   * @return id
  **/
  @Schema(example = "2", description = "ID of the recipient.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ShareRecipient shareId(String shareId) {
    this.shareId = shareId;
    return this;
  }

   /**
   * ID of the share that the recipoient belongs to.
   * @return shareId
  **/
  @Schema(example = "23", description = "ID of the share that the recipoient belongs to.")
  public String getShareId() {
    return shareId;
  }

  public void setShareId(String shareId) {
    this.shareId = shareId;
  }

  public ShareRecipient type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Type of the recipient.
   * @return type
  **/
  @Schema(example = "owner", description = "Type of the recipient.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ShareRecipient hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * Share hash.
   * @return hash
  **/
  @Schema(example = "fseowxan", description = "Share hash.")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public ShareRecipient email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Recipient email address.
   * @return email
  **/
  @Schema(example = "recipient@example.com", description = "Recipient email address.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ShareRecipient sent(Boolean sent) {
    this.sent = sent;
    return this;
  }

   /**
   * Set to true if invite email was sent; false otherwise.
   * @return sent
  **/
  @Schema(example = "true", description = "Set to true if invite email was sent; false otherwise.")
  public Boolean isSent() {
    return sent;
  }

  public void setSent(Boolean sent) {
    this.sent = sent;
  }

  public ShareRecipient received(Boolean received) {
    this.received = received;
    return this;
  }

   /**
   * Set to true if recipient has accessed the share. Note this is set to true when the recipient clicks the link to access the share; not when they download a file.
   * @return received
  **/
  @Schema(example = "false", description = "Set to true if recipient has accessed the share. Note this is set to true when the recipient clicks the link to access the share; not when they download a file.")
  public Boolean isReceived() {
    return received;
  }

  public void setReceived(Boolean received) {
    this.received = received;
  }

  public ShareRecipient created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of adding recipient to the share.
   * @return created
  **/
  @Schema(example = "2017-01-26T18:10:47Z", description = "Timestamp of adding recipient to the share.")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShareRecipient shareRecipient = (ShareRecipient) o;
    return Objects.equals(this.id, shareRecipient.id) &&
        Objects.equals(this.shareId, shareRecipient.shareId) &&
        Objects.equals(this.type, shareRecipient.type) &&
        Objects.equals(this.hash, shareRecipient.hash) &&
        Objects.equals(this.email, shareRecipient.email) &&
        Objects.equals(this.sent, shareRecipient.sent) &&
        Objects.equals(this.received, shareRecipient.received) &&
        Objects.equals(this.created, shareRecipient.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, shareId, type, hash, email, sent, received, created);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShareRecipient {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    shareId: ").append(toIndentedString(shareId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    sent: ").append(toIndentedString(sent)).append("\n");
    sb.append("    received: ").append(toIndentedString(received)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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
