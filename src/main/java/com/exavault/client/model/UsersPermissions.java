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
 * An object containing name/value pairs for each permission. Any permission that is not passed will be set to &#x60;false&#x60; by default. Note that users will be unable to see any files in the account unless you include &#x60;list&#x60; permission. When creating a user with the &#x60;role&#x60; **admin**, you should set all of the permissions to &#x60;true&#x60;
 */
@Schema(description = "An object containing name/value pairs for each permission. Any permission that is not passed will be set to `false` by default. Note that users will be unable to see any files in the account unless you include `list` permission. When creating a user with the `role` **admin**, you should set all of the permissions to `true`")

public class UsersPermissions {
  @SerializedName("list")
  private Boolean list = null;

  @SerializedName("download")
  private Boolean download = null;

  @SerializedName("upload")
  private Boolean upload = null;

  @SerializedName("modify")
  private Boolean modify = null;

  @SerializedName("delete")
  private Boolean delete = null;

  @SerializedName("changePassword")
  private Boolean changePassword = null;

  @SerializedName("share")
  private Boolean share = null;

  @SerializedName("notification")
  private Boolean notification = null;

  @SerializedName("viewFormData")
  private Boolean viewFormData = null;

  @SerializedName("deleteFormData")
  private Boolean deleteFormData = null;

  public UsersPermissions list(Boolean list) {
    this.list = list;
    return this;
  }

   /**
   * Get list
   * @return list
  **/
  @Schema(example = "true", description = "")
  public Boolean isList() {
    return list;
  }

  public void setList(Boolean list) {
    this.list = list;
  }

  public UsersPermissions download(Boolean download) {
    this.download = download;
    return this;
  }

   /**
   * Get download
   * @return download
  **/
  @Schema(example = "true", description = "")
  public Boolean isDownload() {
    return download;
  }

  public void setDownload(Boolean download) {
    this.download = download;
  }

  public UsersPermissions upload(Boolean upload) {
    this.upload = upload;
    return this;
  }

   /**
   * Get upload
   * @return upload
  **/
  @Schema(example = "true", description = "")
  public Boolean isUpload() {
    return upload;
  }

  public void setUpload(Boolean upload) {
    this.upload = upload;
  }

  public UsersPermissions modify(Boolean modify) {
    this.modify = modify;
    return this;
  }

   /**
   * Get modify
   * @return modify
  **/
  @Schema(example = "true", description = "")
  public Boolean isModify() {
    return modify;
  }

  public void setModify(Boolean modify) {
    this.modify = modify;
  }

  public UsersPermissions delete(Boolean delete) {
    this.delete = delete;
    return this;
  }

   /**
   * Get delete
   * @return delete
  **/
  @Schema(example = "true", description = "")
  public Boolean isDelete() {
    return delete;
  }

  public void setDelete(Boolean delete) {
    this.delete = delete;
  }

  public UsersPermissions changePassword(Boolean changePassword) {
    this.changePassword = changePassword;
    return this;
  }

   /**
   * Get changePassword
   * @return changePassword
  **/
  @Schema(example = "true", description = "")
  public Boolean isChangePassword() {
    return changePassword;
  }

  public void setChangePassword(Boolean changePassword) {
    this.changePassword = changePassword;
  }

  public UsersPermissions share(Boolean share) {
    this.share = share;
    return this;
  }

   /**
   * Get share
   * @return share
  **/
  @Schema(example = "true", description = "")
  public Boolean isShare() {
    return share;
  }

  public void setShare(Boolean share) {
    this.share = share;
  }

  public UsersPermissions notification(Boolean notification) {
    this.notification = notification;
    return this;
  }

   /**
   * Get notification
   * @return notification
  **/
  @Schema(example = "true", description = "")
  public Boolean isNotification() {
    return notification;
  }

  public void setNotification(Boolean notification) {
    this.notification = notification;
  }

  public UsersPermissions viewFormData(Boolean viewFormData) {
    this.viewFormData = viewFormData;
    return this;
  }

   /**
   * Get viewFormData
   * @return viewFormData
  **/
  @Schema(example = "true", description = "")
  public Boolean isViewFormData() {
    return viewFormData;
  }

  public void setViewFormData(Boolean viewFormData) {
    this.viewFormData = viewFormData;
  }

  public UsersPermissions deleteFormData(Boolean deleteFormData) {
    this.deleteFormData = deleteFormData;
    return this;
  }

   /**
   * Get deleteFormData
   * @return deleteFormData
  **/
  @Schema(example = "true", description = "")
  public Boolean isDeleteFormData() {
    return deleteFormData;
  }

  public void setDeleteFormData(Boolean deleteFormData) {
    this.deleteFormData = deleteFormData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersPermissions usersPermissions = (UsersPermissions) o;
    return Objects.equals(this.list, usersPermissions.list) &&
        Objects.equals(this.download, usersPermissions.download) &&
        Objects.equals(this.upload, usersPermissions.upload) &&
        Objects.equals(this.modify, usersPermissions.modify) &&
        Objects.equals(this.delete, usersPermissions.delete) &&
        Objects.equals(this.changePassword, usersPermissions.changePassword) &&
        Objects.equals(this.share, usersPermissions.share) &&
        Objects.equals(this.notification, usersPermissions.notification) &&
        Objects.equals(this.viewFormData, usersPermissions.viewFormData) &&
        Objects.equals(this.deleteFormData, usersPermissions.deleteFormData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list, download, upload, modify, delete, changePassword, share, notification, viewFormData, deleteFormData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersPermissions {\n");
    
    sb.append("    list: ").append(toIndentedString(list)).append("\n");
    sb.append("    download: ").append(toIndentedString(download)).append("\n");
    sb.append("    upload: ").append(toIndentedString(upload)).append("\n");
    sb.append("    modify: ").append(toIndentedString(modify)).append("\n");
    sb.append("    delete: ").append(toIndentedString(delete)).append("\n");
    sb.append("    changePassword: ").append(toIndentedString(changePassword)).append("\n");
    sb.append("    share: ").append(toIndentedString(share)).append("\n");
    sb.append("    notification: ").append(toIndentedString(notification)).append("\n");
    sb.append("    viewFormData: ").append(toIndentedString(viewFormData)).append("\n");
    sb.append("    deleteFormData: ").append(toIndentedString(deleteFormData)).append("\n");
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
