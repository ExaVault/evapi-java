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
 * SSHKeysAttributes
 */


public class SSHKeysAttributes {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("user_id")
  private Integer userId = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("fingerprint")
  private String fingerprint = null;

  @SerializedName("lastLogin")
  private OffsetDateTime lastLogin = null;

  @SerializedName("created")
  private OffsetDateTime created = null;

  public SSHKeysAttributes id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the SSH Key. 
   * @return id
  **/
  @Schema(description = "ID of the SSH Key. ")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public SSHKeysAttributes userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * The user ID of the user who the SSH Key is asigned to.
   * @return userId
  **/
  @Schema(description = "The user ID of the user who the SSH Key is asigned to.")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public SSHKeysAttributes username(String username) {
    this.username = username;
    return this;
  }

   /**
   * The username of the user who the SSH Key is asigned to.
   * @return username
  **/
  @Schema(description = "The username of the user who the SSH Key is asigned to.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public SSHKeysAttributes fingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
    return this;
  }

   /**
   * The Key Fingerprint. The fingerprint can be used to identify and keep track of the key without exposing the actual credential. 
   * @return fingerprint
  **/
  @Schema(description = "The Key Fingerprint. The fingerprint can be used to identify and keep track of the key without exposing the actual credential. ")
  public String getFingerprint() {
    return fingerprint;
  }

  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public SSHKeysAttributes lastLogin(OffsetDateTime lastLogin) {
    this.lastLogin = lastLogin;
    return this;
  }

   /**
   * The date-time the SSH Key was last used to access ExaVault. 
   * @return lastLogin
  **/
  @Schema(description = "The date-time the SSH Key was last used to access ExaVault. ")
  public OffsetDateTime getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(OffsetDateTime lastLogin) {
    this.lastLogin = lastLogin;
  }

  public SSHKeysAttributes created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * The date-time the SSH Key was created.
   * @return created
  **/
  @Schema(description = "The date-time the SSH Key was created.")
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
    SSHKeysAttributes ssHKeysAttributes = (SSHKeysAttributes) o;
    return Objects.equals(this.id, ssHKeysAttributes.id) &&
        Objects.equals(this.userId, ssHKeysAttributes.userId) &&
        Objects.equals(this.username, ssHKeysAttributes.username) &&
        Objects.equals(this.fingerprint, ssHKeysAttributes.fingerprint) &&
        Objects.equals(this.lastLogin, ssHKeysAttributes.lastLogin) &&
        Objects.equals(this.created, ssHKeysAttributes.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, username, fingerprint, lastLogin, created);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SSHKeysAttributes {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    fingerprint: ").append(toIndentedString(fingerprint)).append("\n");
    sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
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
