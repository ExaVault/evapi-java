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
import com.exavault.client.model.FormsidSettings;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * FormsidElements
 */


public class FormsidElements {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("order")
  private Integer order = null;

  /**
   * Type of form field to use.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    NAME("name"),
    EMAIL("email"),
    TEXT("text"),
    TEXTAREA("textarea"),
    UPLOAD_AREA("upload_area");

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

  @SerializedName("settings")
  private FormsidSettings settings = null;

  public FormsidElements id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the form element. If you&#x27;re adding a new element to the form, do not include this field.
   * @return id
  **/
  @Schema(example = "123", description = "ID of the form element. If you're adding a new element to the form, do not include this field.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public FormsidElements name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the form element.
   * @return name
  **/
  @Schema(example = "Your name", description = "Name of the form element.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FormsidElements order(Integer order) {
    this.order = order;
    return this;
  }

   /**
   * The order the fields will be displayed to the receipient. Starts at 0. 
   * @return order
  **/
  @Schema(example = "0", description = "The order the fields will be displayed to the receipient. Starts at 0. ")
  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public FormsidElements type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Type of form field to use.
   * @return type
  **/
  @Schema(example = "name", description = "Type of form field to use.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public FormsidElements settings(FormsidSettings settings) {
    this.settings = settings;
    return this;
  }

   /**
   * Get settings
   * @return settings
  **/
  @Schema(description = "")
  public FormsidSettings getSettings() {
    return settings;
  }

  public void setSettings(FormsidSettings settings) {
    this.settings = settings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormsidElements formsidElements = (FormsidElements) o;
    return Objects.equals(this.id, formsidElements.id) &&
        Objects.equals(this.name, formsidElements.name) &&
        Objects.equals(this.order, formsidElements.order) &&
        Objects.equals(this.type, formsidElements.type) &&
        Objects.equals(this.settings, formsidElements.settings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, order, type, settings);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormsidElements {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
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