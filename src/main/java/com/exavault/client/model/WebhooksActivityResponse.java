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
import com.exavault.client.model.WebhooksActivityEntry;
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
 * Session activity list response
 */
@Schema(description = "Session activity list response")

public class WebhooksActivityResponse {
  @SerializedName("responseStatus")
  private Integer responseStatus = null;

  @SerializedName("totalResults")
  private Integer totalResults = null;

  @SerializedName("returnedResults")
  private Integer returnedResults = null;

  @SerializedName("data")
  private List<WebhooksActivityEntry> data = null;

  public WebhooksActivityResponse responseStatus(Integer responseStatus) {
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

  public WebhooksActivityResponse totalResults(Integer totalResults) {
    this.totalResults = totalResults;
    return this;
  }

   /**
   * Total results found.
   * @return totalResults
  **/
  @Schema(example = "2", description = "Total results found.")
  public Integer getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  public WebhooksActivityResponse returnedResults(Integer returnedResults) {
    this.returnedResults = returnedResults;
    return this;
  }

   /**
   * Number of results returned. 
   * @return returnedResults
  **/
  @Schema(example = "2", description = "Number of results returned. ")
  public Integer getReturnedResults() {
    return returnedResults;
  }

  public void setReturnedResults(Integer returnedResults) {
    this.returnedResults = returnedResults;
  }

  public WebhooksActivityResponse data(List<WebhooksActivityEntry> data) {
    this.data = data;
    return this;
  }

  public WebhooksActivityResponse addDataItem(WebhooksActivityEntry dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<WebhooksActivityEntry>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Schema(description = "")
  public List<WebhooksActivityEntry> getData() {
    return data;
  }

  public void setData(List<WebhooksActivityEntry> data) {
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
    WebhooksActivityResponse webhooksActivityResponse = (WebhooksActivityResponse) o;
    return Objects.equals(this.responseStatus, webhooksActivityResponse.responseStatus) &&
        Objects.equals(this.totalResults, webhooksActivityResponse.totalResults) &&
        Objects.equals(this.returnedResults, webhooksActivityResponse.returnedResults) &&
        Objects.equals(this.data, webhooksActivityResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, totalResults, returnedResults, data);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhooksActivityResponse {\n");
    
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
    sb.append("    returnedResults: ").append(toIndentedString(returnedResults)).append("\n");
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