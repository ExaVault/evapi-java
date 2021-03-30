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
import com.exavault.client.model.WebhookTriggers;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;
/**
 * WebhookAttributes
 */


public class WebhookAttributes {
  @SerializedName("endpointUrl")
  private String endpointUrl = null;

  @SerializedName("failed")
  private Boolean failed = null;

  @SerializedName("verificationToken")
  private String verificationToken = null;

  /**
   * The version of webhook request to send to the endpoint URL
   */
  @JsonAdapter(ResponseVersionEnum.Adapter.class)
  public enum ResponseVersionEnum {
    V1("v1"),
    V2("v2");

    private String value;

    ResponseVersionEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static ResponseVersionEnum fromValue(String text) {
      for (ResponseVersionEnum b : ResponseVersionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<ResponseVersionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ResponseVersionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ResponseVersionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ResponseVersionEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("responseVersion")
  private ResponseVersionEnum responseVersion = null;

  @SerializedName("triggers")
  private WebhookTriggers triggers = null;

  @SerializedName("created")
  private OffsetDateTime created = null;

  @SerializedName("modified")
  private OffsetDateTime modified = null;

  public WebhookAttributes endpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
    return this;
  }

   /**
   * The endpoint is where the webhook request will be sent.
   * @return endpointUrl
  **/
  @Schema(example = "https://example.com/webhook", description = "The endpoint is where the webhook request will be sent.")
  public String getEndpointUrl() {
    return endpointUrl;
  }

  public void setEndpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
  }

  public WebhookAttributes failed(Boolean failed) {
    this.failed = failed;
    return this;
  }

   /**
   * Whether webhook has been disabled for too many consecutive failures
   * @return failed
  **/
  @Schema(description = "Whether webhook has been disabled for too many consecutive failures")
  public Boolean isFailed() {
    return failed;
  }

  public void setFailed(Boolean failed) {
    this.failed = failed;
  }

  public WebhookAttributes verificationToken(String verificationToken) {
    this.verificationToken = verificationToken;
    return this;
  }

   /**
   * Token for verifying sender is ExaVault
   * @return verificationToken
  **/
  @Schema(example = "8df8200f7dee90ba4a41abe39c858c6c", description = "Token for verifying sender is ExaVault")
  public String getVerificationToken() {
    return verificationToken;
  }

  public void setVerificationToken(String verificationToken) {
    this.verificationToken = verificationToken;
  }

  public WebhookAttributes responseVersion(ResponseVersionEnum responseVersion) {
    this.responseVersion = responseVersion;
    return this;
  }

   /**
   * The version of webhook request to send to the endpoint URL
   * @return responseVersion
  **/
  @Schema(example = "v2", description = "The version of webhook request to send to the endpoint URL")
  public ResponseVersionEnum getResponseVersion() {
    return responseVersion;
  }

  public void setResponseVersion(ResponseVersionEnum responseVersion) {
    this.responseVersion = responseVersion;
  }

  public WebhookAttributes triggers(WebhookTriggers triggers) {
    this.triggers = triggers;
    return this;
  }

   /**
   * Get triggers
   * @return triggers
  **/
  @Schema(description = "")
  public WebhookTriggers getTriggers() {
    return triggers;
  }

  public void setTriggers(WebhookTriggers triggers) {
    this.triggers = triggers;
  }

  public WebhookAttributes created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp when webhook configuration was added to system.
   * @return created
  **/
  @Schema(example = "2021-03-04T22:22-08:00", description = "Timestamp when webhook configuration was added to system.")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public WebhookAttributes modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp when webhook configuration was last modified
   * @return modified
  **/
  @Schema(example = "2021-03-04T22:23:03-08:00", description = "Timestamp when webhook configuration was last modified")
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
    WebhookAttributes webhookAttributes = (WebhookAttributes) o;
    return Objects.equals(this.endpointUrl, webhookAttributes.endpointUrl) &&
        Objects.equals(this.failed, webhookAttributes.failed) &&
        Objects.equals(this.verificationToken, webhookAttributes.verificationToken) &&
        Objects.equals(this.responseVersion, webhookAttributes.responseVersion) &&
        Objects.equals(this.triggers, webhookAttributes.triggers) &&
        Objects.equals(this.created, webhookAttributes.created) &&
        Objects.equals(this.modified, webhookAttributes.modified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpointUrl, failed, verificationToken, responseVersion, triggers, created, modified);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebhookAttributes {\n");
    
    sb.append("    endpointUrl: ").append(toIndentedString(endpointUrl)).append("\n");
    sb.append("    failed: ").append(toIndentedString(failed)).append("\n");
    sb.append("    verificationToken: ").append(toIndentedString(verificationToken)).append("\n");
    sb.append("    responseVersion: ").append(toIndentedString(responseVersion)).append("\n");
    sb.append("    triggers: ").append(toIndentedString(triggers)).append("\n");
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
