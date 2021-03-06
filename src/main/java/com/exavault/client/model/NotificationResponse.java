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
import com.exavault.client.model.Notification;
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
 * Response object for notifications.
 */
@Schema(description = "Response object for notifications.")

public class NotificationResponse {
  @SerializedName("responseStatus")
  private Integer responseStatus = null;

  @SerializedName("data")
  private Notification data = null;

  @SerializedName("included")
  private List<Object> included = null;

  public NotificationResponse responseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

   /**
   * Http status code of the response.
   * @return responseStatus
  **/
  @Schema(example = "200", description = "Http status code of the response.")
  public Integer getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
  }

  public NotificationResponse data(Notification data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Schema(description = "")
  public Notification getData() {
    return data;
  }

  public void setData(Notification data) {
    this.data = data;
  }

  public NotificationResponse included(List<Object> included) {
    this.included = included;
    return this;
  }

  public NotificationResponse addIncludedItem(Object includedItem) {
    if (this.included == null) {
      this.included = new ArrayList<Object>();
    }
    this.included.add(includedItem);
    return this;
  }

   /**
   * Get included
   * @return included
  **/
  @Schema(description = "")
  public List<Object> getIncluded() {
    return included;
  }

  public void setIncluded(List<Object> included) {
    this.included = included;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationResponse notificationResponse = (NotificationResponse) o;
    return Objects.equals(this.responseStatus, notificationResponse.responseStatus) &&
        Objects.equals(this.data, notificationResponse.data) &&
        Objects.equals(this.included, notificationResponse.included);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, data, included);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationResponse {\n");
    
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    included: ").append(toIndentedString(included)).append("\n");
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
