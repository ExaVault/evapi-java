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
 * Advanced field settings
 */
@Schema(description = "Advanced field settings")

public class FormFieldSettings {
  @SerializedName("description")
  private String description = null;

  @SerializedName("width")
  private Float width = null;

  @SerializedName("isRequired")
  private Boolean isRequired = null;

  @SerializedName("useAsFolderName")
  private Boolean useAsFolderName = null;

  @SerializedName("senderEmail")
  private Boolean senderEmail = null;

  public FormFieldSettings description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Secondary description of field.
   * @return description
  **/
  @Schema(description = "Secondary description of field.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FormFieldSettings width(Float width) {
    this.width = width;
    return this;
  }

   /**
   * How much of the available width the field should occupy
   * @return width
  **/
  @Schema(example = "0.5", description = "How much of the available width the field should occupy")
  public Float getWidth() {
    return width;
  }

  public void setWidth(Float width) {
    this.width = width;
  }

  public FormFieldSettings isRequired(Boolean isRequired) {
    this.isRequired = isRequired;
    return this;
  }

   /**
   * Whether this field must be completed before form can be submitted
   * @return isRequired
  **/
  @Schema(example = "false", description = "Whether this field must be completed before form can be submitted")
  public Boolean isIsRequired() {
    return isRequired;
  }

  public void setIsRequired(Boolean isRequired) {
    this.isRequired = isRequired;
  }

  public FormFieldSettings useAsFolderName(Boolean useAsFolderName) {
    this.useAsFolderName = useAsFolderName;
    return this;
  }

   /**
   * Whether to place submitted files into a subfolder named the contents of this field. Only takes effect when the &#x60;fileDropCreateFolders&#x60; parameter on the receive folder is &#x60;true&#x60;. &#x60;isRequired&#x60; must be set to &#x60;true&#x60; if this setting is &#x60;true&#x60;.
   * @return useAsFolderName
  **/
  @Schema(example = "false", description = "Whether to place submitted files into a subfolder named the contents of this field. Only takes effect when the `fileDropCreateFolders` parameter on the receive folder is `true`. `isRequired` must be set to `true` if this setting is `true`.")
  public Boolean isUseAsFolderName() {
    return useAsFolderName;
  }

  public void setUseAsFolderName(Boolean useAsFolderName) {
    this.useAsFolderName = useAsFolderName;
  }

  public FormFieldSettings senderEmail(Boolean senderEmail) {
    this.senderEmail = senderEmail;
    return this;
  }

   /**
   * Get senderEmail
   * @return senderEmail
  **/
  @Schema(description = "")
  public Boolean isSenderEmail() {
    return senderEmail;
  }

  public void setSenderEmail(Boolean senderEmail) {
    this.senderEmail = senderEmail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormFieldSettings formFieldSettings = (FormFieldSettings) o;
    return Objects.equals(this.description, formFieldSettings.description) &&
        Objects.equals(this.width, formFieldSettings.width) &&
        Objects.equals(this.isRequired, formFieldSettings.isRequired) &&
        Objects.equals(this.useAsFolderName, formFieldSettings.useAsFolderName) &&
        Objects.equals(this.senderEmail, formFieldSettings.senderEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, width, isRequired, useAsFolderName, senderEmail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormFieldSettings {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    isRequired: ").append(toIndentedString(isRequired)).append("\n");
    sb.append("    useAsFolderName: ").append(toIndentedString(useAsFolderName)).append("\n");
    sb.append("    senderEmail: ").append(toIndentedString(senderEmail)).append("\n");
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
