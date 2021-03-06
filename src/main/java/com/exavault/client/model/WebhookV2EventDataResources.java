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
 * WebhookV2EventDataResources
 */


public class WebhookV2EventDataResources {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("hash")
  private String hash = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("createdBy")
  private String createdBy = null;

  @SerializedName("uploadDate")
  private OffsetDateTime uploadDate = null;

  @SerializedName("createdAt")
  private OffsetDateTime createdAt = null;

  @SerializedName("updatedAt")
  private OffsetDateTime updatedAt = null;

  @SerializedName("accessedAt")
  private OffsetDateTime accessedAt = null;

  @SerializedName("path")
  private String path = null;

  @SerializedName("size")
  private Integer size = null;

  @SerializedName("fileCount")
  private Integer fileCount = null;

  @SerializedName("previewable")
  private Boolean previewable = null;

  public WebhookV2EventDataResources id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Resource ID
   * @return id
  **/
  @Schema(description = "Resource ID")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public WebhookV2EventDataResources hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * Resource hash value
   * @return hash
  **/
  @Schema(description = "Resource hash value")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public WebhookV2EventDataResources name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Resource name
   * @return name
  **/
  @Schema(description = "Resource name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WebhookV2EventDataResources type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Type of resource &#x60;file&#x60; or &#x60;dir&#x60;
   * @return type
  **/
  @Schema(description = "Type of resource `file` or `dir`")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public WebhookV2EventDataResources createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Username who originally created resource
   * @return createdBy
  **/
  @Schema(description = "Username who originally created resource")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public WebhookV2EventDataResources uploadDate(OffsetDateTime uploadDate) {
    this.uploadDate = uploadDate;
    return this;
  }

   /**
   * Date resource was first uploaded
   * @return uploadDate
  **/
  @Schema(description = "Date resource was first uploaded")
  public OffsetDateTime getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(OffsetDateTime uploadDate) {
    this.uploadDate = uploadDate;
  }

  public WebhookV2EventDataResources createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Date and time of resource creation
   * @return createdAt
  **/
  @Schema(description = "Date and time of resource creation")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public WebhookV2EventDataResources updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Date and time resource was most recently changed
   * @return updatedAt
  **/
  @Schema(description = "Date and time resource was most recently changed")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public WebhookV2EventDataResources accessedAt(OffsetDateTime accessedAt) {
    this.accessedAt = accessedAt;
    return this;
  }

   /**
   * Date and time resource was most recently downloaded
   * @return accessedAt
  **/
  @Schema(description = "Date and time resource was most recently downloaded")
  public OffsetDateTime getAccessedAt() {
    return accessedAt;
  }

  public void setAccessedAt(OffsetDateTime accessedAt) {
    this.accessedAt = accessedAt;
  }

  public WebhookV2EventDataResources path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Full path to resource
   * @return path
  **/
  @Schema(description = "Full path to resource")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public WebhookV2EventDataResources size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Size of resource in bytes
   * @return size
  **/
  @Schema(description = "Size of resource in bytes")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public WebhookV2EventDataResources fileCount(Integer fileCount) {
    this.fileCount = fileCount;
    return this;
  }

   /**
   * Number of resources contained in this folder. If this is a file, fileCount is null
   * @return fileCount
  **/
  @Schema(description = "Number of resources contained in this folder. If this is a file, fileCount is null")
  public Integer getFileCount() {
    return fileCount;
  }

  public void setFileCount(Integer fileCount) {
    this.fileCount = fileCount;
  }

  public WebhookV2EventDataResources previewable(Boolean previewable) {
    this.previewable = previewable;
    return this;
  }

   /**
   * Whether the resource can be previewed
   * @return previewable
  **/
  @Schema(description = "Whether the resource can be previewed")
  public Boolean isPreviewable() {
    return previewable;
  }

  public void setPreviewable(Boolean previewable) {
    this.previewable = previewable;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookV2EventDataResources webhookV2EventDataResources = (WebhookV2EventDataResources) o;
    return Objects.equals(this.id, webhookV2EventDataResources.id) &&
        Objects.equals(this.hash, webhookV2EventDataResources.hash) &&
        Objects.equals(this.name, webhookV2EventDataResources.name) &&
        Objects.equals(this.type, webhookV2EventDataResources.type) &&
        Objects.equals(this.createdBy, webhookV2EventDataResources.createdBy) &&
        Objects.equals(this.uploadDate, webhookV2EventDataResources.uploadDate) &&
        Objects.equals(this.createdAt, webhookV2EventDataResources.createdAt) &&
        Objects.equals(this.updatedAt, webhookV2EventDataResources.updatedAt) &&
        Objects.equals(this.accessedAt, webhookV2EventDataResources.accessedAt) &&
        Objects.equals(this.path, webhookV2EventDataResources.path) &&
        Objects.equals(this.size, webhookV2EventDataResources.size) &&
        Objects.equals(this.fileCount, webhookV2EventDataResources.fileCount) &&
        Objects.equals(this.previewable, webhookV2EventDataResources.previewable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hash, name, type, createdBy, uploadDate, createdAt, updatedAt, accessedAt, path, size, fileCount, previewable);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookV2EventDataResources {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    uploadDate: ").append(toIndentedString(uploadDate)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    accessedAt: ").append(toIndentedString(accessedAt)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    fileCount: ").append(toIndentedString(fileCount)).append("\n");
    sb.append("    previewable: ").append(toIndentedString(previewable)).append("\n");
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
