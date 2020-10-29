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
 * WebhooksActivityEntryAttributes
 */


public class WebhooksActivityEntryAttributes {
  @SerializedName("attempt")
  private Integer attempt = null;

  @SerializedName("created")
  private String created = null;

  @SerializedName("endpointUrl")
  private String endpointUrl = null;

  @SerializedName("event")
  private String event = null;

  @SerializedName("response")
  private String response = null;

  @SerializedName("responseSize")
  private Integer responseSize = null;

  @SerializedName("status")
  private Integer status = null;

  public WebhooksActivityEntryAttributes attempt(Integer attempt) {
    this.attempt = attempt;
    return this;
  }

   /**
   * Get attempt
   * @return attempt
  **/
  @Schema(example = "1", description = "")
  public Integer getAttempt() {
    return attempt;
  }

  public void setAttempt(Integer attempt) {
    this.attempt = attempt;
  }

  public WebhooksActivityEntryAttributes created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @Schema(example = "2019-10-20T23:16:55Z", description = "")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public WebhooksActivityEntryAttributes endpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
    return this;
  }

   /**
   * Get endpointUrl
   * @return endpointUrl
  **/
  @Schema(example = "https://example.com", description = "")
  public String getEndpointUrl() {
    return endpointUrl;
  }

  public void setEndpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
  }

  public WebhooksActivityEntryAttributes event(String event) {
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @Schema(example = "Delete File", description = "")
  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public WebhooksActivityEntryAttributes response(String response) {
    this.response = response;
    return this;
  }

   /**
   * Get response
   * @return response
  **/
  @Schema(example = "OK", description = "")
  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public WebhooksActivityEntryAttributes responseSize(Integer responseSize) {
    this.responseSize = responseSize;
    return this;
  }

   /**
   * Get responseSize
   * @return responseSize
  **/
  @Schema(example = "654", description = "")
  public Integer getResponseSize() {
    return responseSize;
  }

  public void setResponseSize(Integer responseSize) {
    this.responseSize = responseSize;
  }

  public WebhooksActivityEntryAttributes status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @Schema(example = "200", description = "")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhooksActivityEntryAttributes webhooksActivityEntryAttributes = (WebhooksActivityEntryAttributes) o;
    return Objects.equals(this.attempt, webhooksActivityEntryAttributes.attempt) &&
        Objects.equals(this.created, webhooksActivityEntryAttributes.created) &&
        Objects.equals(this.endpointUrl, webhooksActivityEntryAttributes.endpointUrl) &&
        Objects.equals(this.event, webhooksActivityEntryAttributes.event) &&
        Objects.equals(this.response, webhooksActivityEntryAttributes.response) &&
        Objects.equals(this.responseSize, webhooksActivityEntryAttributes.responseSize) &&
        Objects.equals(this.status, webhooksActivityEntryAttributes.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attempt, created, endpointUrl, event, response, responseSize, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhooksActivityEntryAttributes {\n");
    
    sb.append("    attempt: ").append(toIndentedString(attempt)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    endpointUrl: ").append(toIndentedString(endpointUrl)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    responseSize: ").append(toIndentedString(responseSize)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
