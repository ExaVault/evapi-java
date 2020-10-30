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
import com.exavault.client.model.FormEntryField;
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
 * FormEntryAttributes
 */


public class FormEntryAttributes {
  @SerializedName("fields")
  private List<FormEntryField> fields = null;

  @SerializedName("paths")
  private List<String> paths = null;

  /**
   * Form entry status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    PENDING("pending"),
    COMPLETED("completed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("created")
  private OffsetDateTime created = null;

  @SerializedName("modified")
  private OffsetDateTime modified = null;

  public FormEntryAttributes fields(List<FormEntryField> fields) {
    this.fields = fields;
    return this;
  }

  public FormEntryAttributes addFieldsItem(FormEntryField fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<FormEntryField>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

   /**
   * Get fields
   * @return fields
  **/
  @Schema(description = "")
  public List<FormEntryField> getFields() {
    return fields;
  }

  public void setFields(List<FormEntryField> fields) {
    this.fields = fields;
  }

  public FormEntryAttributes paths(List<String> paths) {
    this.paths = paths;
    return this;
  }

  public FormEntryAttributes addPathsItem(String pathsItem) {
    if (this.paths == null) {
      this.paths = new ArrayList<String>();
    }
    this.paths.add(pathsItem);
    return this;
  }

   /**
   * Full paths to files associated with the form submission
   * @return paths
  **/
  @Schema(example = "[\"/image1.jpg\",\"/image2.jpg\",\"/image3.jpg\"]", description = "Full paths to files associated with the form submission")
  public List<String> getPaths() {
    return paths;
  }

  public void setPaths(List<String> paths) {
    this.paths = paths;
  }

  public FormEntryAttributes status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Form entry status
   * @return status
  **/
  @Schema(example = "completed", description = "Form entry status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public FormEntryAttributes created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of the submission
   * @return created
  **/
  @Schema(example = "2019-09-19T18:00Z", description = "Timestamp of the submission")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public FormEntryAttributes modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp of the field modified date
   * @return modified
  **/
  @Schema(example = "2019-09-20T18:00Z", description = "Timestamp of the field modified date")
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
    FormEntryAttributes formEntryAttributes = (FormEntryAttributes) o;
    return Objects.equals(this.fields, formEntryAttributes.fields) &&
        Objects.equals(this.paths, formEntryAttributes.paths) &&
        Objects.equals(this.status, formEntryAttributes.status) &&
        Objects.equals(this.created, formEntryAttributes.created) &&
        Objects.equals(this.modified, formEntryAttributes.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fields, paths, status, created, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormEntryAttributes {\n");
    
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    paths: ").append(toIndentedString(paths)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
