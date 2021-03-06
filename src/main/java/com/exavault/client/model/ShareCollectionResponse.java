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
import com.exavault.client.model.Share;
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
 * ShareCollectionResponse
 */


public class ShareCollectionResponse {
  @SerializedName("responseStatus")
  private Integer responseStatus = null;

  @SerializedName("totalResults")
  private Integer totalResults = null;

  @SerializedName("returnedResults")
  private Integer returnedResults = null;

  @SerializedName("data")
  private List<Share> data = null;

  @SerializedName("included")
  private List<Object> included = null;

  public ShareCollectionResponse responseStatus(Integer responseStatus) {
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

  public ShareCollectionResponse totalResults(Integer totalResults) {
    this.totalResults = totalResults;
    return this;
  }

   /**
   * Total results found. 
   * @return totalResults
  **/
  @Schema(example = "2", description = "Total results found. ")
  public Integer getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  public ShareCollectionResponse returnedResults(Integer returnedResults) {
    this.returnedResults = returnedResults;
    return this;
  }

   /**
   * Number of returned results.
   * @return returnedResults
  **/
  @Schema(example = "2", description = "Number of returned results.")
  public Integer getReturnedResults() {
    return returnedResults;
  }

  public void setReturnedResults(Integer returnedResults) {
    this.returnedResults = returnedResults;
  }

  public ShareCollectionResponse data(List<Share> data) {
    this.data = data;
    return this;
  }

  public ShareCollectionResponse addDataItem(Share dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Share>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @Schema(description = "")
  public List<Share> getData() {
    return data;
  }

  public void setData(List<Share> data) {
    this.data = data;
  }

  public ShareCollectionResponse included(List<Object> included) {
    this.included = included;
    return this;
  }

  public ShareCollectionResponse addIncludedItem(Object includedItem) {
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
    ShareCollectionResponse shareCollectionResponse = (ShareCollectionResponse) o;
    return Objects.equals(this.responseStatus, shareCollectionResponse.responseStatus) &&
        Objects.equals(this.totalResults, shareCollectionResponse.totalResults) &&
        Objects.equals(this.returnedResults, shareCollectionResponse.returnedResults) &&
        Objects.equals(this.data, shareCollectionResponse.data) &&
        Objects.equals(this.included, shareCollectionResponse.included);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, totalResults, returnedResults, data, included);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShareCollectionResponse {\n");
    
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
    sb.append("    returnedResults: ").append(toIndentedString(returnedResults)).append("\n");
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
