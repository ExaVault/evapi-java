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
import com.exavault.client.model.DownloadPolling;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * DownloadPollingResponse
 */


public class DownloadPollingResponse {
  @SerializedName("responseStatus")
  private Integer responseStatus = null;

  @SerializedName("data")
  private DownloadPolling data = null;

  public DownloadPollingResponse responseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

   /**
   * Http status code of the response. 
   * @return responseStatus
  **/
  @Schema(example = "202", description = "Http status code of the response. ")
  public Integer getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
  }

  public DownloadPollingResponse data(DownloadPolling data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Schema(description = "")
  public DownloadPolling getData() {
    return data;
  }

  public void setData(DownloadPolling data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DownloadPollingResponse downloadPollingResponse = (DownloadPollingResponse) o;
    return Objects.equals(this.responseStatus, downloadPollingResponse.responseStatus) &&
        Objects.equals(this.data, downloadPollingResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, data);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DownloadPollingResponse {\n");
    
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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