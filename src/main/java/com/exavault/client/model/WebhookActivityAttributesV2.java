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
import com.exavault.client.model.WebhookV2Details;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * WebhookActivityAttributesV2
 */


public class WebhookActivityAttributesV2 {
  @SerializedName("webhookId")
  private Integer webhookId = null;

  @SerializedName("webhookFormat")
  private String webhookFormat = null;

  @SerializedName("attemptId")
  private String attemptId = null;

  @SerializedName("accountId")
  private String accountId = null;

  @SerializedName("resend")
  private Boolean resend = null;

  @SerializedName("endpointUrl")
  private String endpointUrl = null;

  /**
   * Event type
   */
  @JsonAdapter(EventEnum.Adapter.class)
  public enum EventEnum {
    RESOURCES_UPLOAD("resources.upload"),
    RESOURCES_DOWNLOAD("resources.download"),
    RESOURCES_DELETE("resources.delete"),
    RESOURCES_RENAME("resources.rename"),
    RESOURCES_COPY("resources.copy"),
    RESOURCES_MOVE("resources.move"),
    RESOURCES_COMPRESS("resources.compress"),
    RESOURCES_EXTRACT("resources.extract"),
    RESOURCES_CREATEFOLDER("resources.createFolder"),
    SHARES_FORMSUBMIT("shares.formSubmit");

    private String value;

    EventEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static EventEnum fromValue(String text) {
      for (EventEnum b : EventEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<EventEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EventEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EventEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return EventEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("event")
  private EventEnum event = null;

  @SerializedName("status")
  private Integer status = null;

  @SerializedName("ipAddress")
  private String ipAddress = null;

  @SerializedName("response")
  private String response = null;

  @SerializedName("details")
  private WebhookV2Details details = null;

  @SerializedName("webhookPath")
  private String webhookPath = null;

  @SerializedName("resourcePath")
  private String resourcePath = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("created")
  private String created = null;

  public WebhookActivityAttributesV2 webhookId(Integer webhookId) {
    this.webhookId = webhookId;
    return this;
  }

   /**
   * Unique ID of webhook configuration
   * @return webhookId
  **/
  @Schema(description = "Unique ID of webhook configuration")
  public Integer getWebhookId() {
    return webhookId;
  }

  public void setWebhookId(Integer webhookId) {
    this.webhookId = webhookId;
  }

  public WebhookActivityAttributesV2 webhookFormat(String webhookFormat) {
    this.webhookFormat = webhookFormat;
    return this;
  }

   /**
   * What version of webhook message is being sent &#x60;v2&#x60;
   * @return webhookFormat
  **/
  @Schema(description = "What version of webhook message is being sent `v2`")
  public String getWebhookFormat() {
    return webhookFormat;
  }

  public void setWebhookFormat(String webhookFormat) {
    this.webhookFormat = webhookFormat;
  }

  public WebhookActivityAttributesV2 attemptId(String attemptId) {
    this.attemptId = attemptId;
    return this;
  }

   /**
   * Event - retry identifier
   * @return attemptId
  **/
  @Schema(description = "Event - retry identifier")
  public String getAttemptId() {
    return attemptId;
  }

  public void setAttemptId(String attemptId) {
    this.attemptId = attemptId;
  }

  public WebhookActivityAttributesV2 accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Unique ID of account
   * @return accountId
  **/
  @Schema(description = "Unique ID of account")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public WebhookActivityAttributesV2 resend(Boolean resend) {
    this.resend = resend;
    return this;
  }

   /**
   * Whether this attempt was a re-send of a previous attempt
   * @return resend
  **/
  @Schema(description = "Whether this attempt was a re-send of a previous attempt")
  public Boolean isResend() {
    return resend;
  }

  public void setResend(Boolean resend) {
    this.resend = resend;
  }

  public WebhookActivityAttributesV2 endpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
    return this;
  }

   /**
   * The URL the message was sent to
   * @return endpointUrl
  **/
  @Schema(description = "The URL the message was sent to")
  public String getEndpointUrl() {
    return endpointUrl;
  }

  public void setEndpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
  }

  public WebhookActivityAttributesV2 event(EventEnum event) {
    this.event = event;
    return this;
  }

   /**
   * Event type
   * @return event
  **/
  @Schema(description = "Event type")
  public EventEnum getEvent() {
    return event;
  }

  public void setEvent(EventEnum event) {
    this.event = event;
  }

  public WebhookActivityAttributesV2 status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * HTTP Status Code returned by webhook listener
   * @return status
  **/
  @Schema(description = "HTTP Status Code returned by webhook listener")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public WebhookActivityAttributesV2 ipAddress(String ipAddress) {
    this.ipAddress = ipAddress;
    return this;
  }

   /**
   * IP Address of related activity
   * @return ipAddress
  **/
  @Schema(description = "IP Address of related activity")
  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public WebhookActivityAttributesV2 response(String response) {
    this.response = response;
    return this;
  }

   /**
   * Body of web response returned by webhook listener
   * @return response
  **/
  @Schema(description = "Body of web response returned by webhook listener")
  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public WebhookActivityAttributesV2 details(WebhookV2Details details) {
    this.details = details;
    return this;
  }

   /**
   * Get details
   * @return details
  **/
  @Schema(description = "")
  public WebhookV2Details getDetails() {
    return details;
  }

  public void setDetails(WebhookV2Details details) {
    this.details = details;
  }

  public WebhookActivityAttributesV2 webhookPath(String webhookPath) {
    this.webhookPath = webhookPath;
    return this;
  }

   /**
   * Path that webhook is watching
   * @return webhookPath
  **/
  @Schema(description = "Path that webhook is watching")
  public String getWebhookPath() {
    return webhookPath;
  }

  public void setWebhookPath(String webhookPath) {
    this.webhookPath = webhookPath;
  }

  public WebhookActivityAttributesV2 resourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
    return this;
  }

   /**
   * Path of resource that matched webhook
   * @return resourcePath
  **/
  @Schema(description = "Path of resource that matched webhook")
  public String getResourcePath() {
    return resourcePath;
  }

  public void setResourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
  }

  public WebhookActivityAttributesV2 username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Username of related activity
   * @return username
  **/
  @Schema(description = "Username of related activity")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public WebhookActivityAttributesV2 created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Date and time of webhook message being generated by system
   * @return created
  **/
  @Schema(description = "Date and time of webhook message being generated by system")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebhookActivityAttributesV2 webhookActivityAttributesV2 = (WebhookActivityAttributesV2) o;
    return Objects.equals(this.webhookId, webhookActivityAttributesV2.webhookId) &&
        Objects.equals(this.webhookFormat, webhookActivityAttributesV2.webhookFormat) &&
        Objects.equals(this.attemptId, webhookActivityAttributesV2.attemptId) &&
        Objects.equals(this.accountId, webhookActivityAttributesV2.accountId) &&
        Objects.equals(this.resend, webhookActivityAttributesV2.resend) &&
        Objects.equals(this.endpointUrl, webhookActivityAttributesV2.endpointUrl) &&
        Objects.equals(this.event, webhookActivityAttributesV2.event) &&
        Objects.equals(this.status, webhookActivityAttributesV2.status) &&
        Objects.equals(this.ipAddress, webhookActivityAttributesV2.ipAddress) &&
        Objects.equals(this.response, webhookActivityAttributesV2.response) &&
        Objects.equals(this.details, webhookActivityAttributesV2.details) &&
        Objects.equals(this.webhookPath, webhookActivityAttributesV2.webhookPath) &&
        Objects.equals(this.resourcePath, webhookActivityAttributesV2.resourcePath) &&
        Objects.equals(this.username, webhookActivityAttributesV2.username) &&
        Objects.equals(this.created, webhookActivityAttributesV2.created);
  }

  @Override
  public int hashCode() {
    return Objects.hash(webhookId, webhookFormat, attemptId, accountId, resend, endpointUrl, event, status, ipAddress, response, details, webhookPath, resourcePath, username, created);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookActivityAttributesV2 {\n");
    
    sb.append("    webhookId: ").append(toIndentedString(webhookId)).append("\n");
    sb.append("    webhookFormat: ").append(toIndentedString(webhookFormat)).append("\n");
    sb.append("    attemptId: ").append(toIndentedString(attemptId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    resend: ").append(toIndentedString(resend)).append("\n");
    sb.append("    endpointUrl: ").append(toIndentedString(endpointUrl)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    webhookPath: ").append(toIndentedString(webhookPath)).append("\n");
    sb.append("    resourcePath: ").append(toIndentedString(resourcePath)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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
