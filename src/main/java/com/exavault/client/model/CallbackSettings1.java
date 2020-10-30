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
import com.exavault.client.model.CallbackSettings1Triggers;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * CallbackSettings1
 */


public class CallbackSettings1 {
  @SerializedName("endpointUrl")
  private String endpointUrl = null;

  @SerializedName("triggers")
  private CallbackSettings1Triggers triggers = null;

  public CallbackSettings1 endpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
    return this;
  }

   /**
   * Get endpointUrl
   * @return endpointUrl
  **/
  @Schema(description = "")
  public String getEndpointUrl() {
    return endpointUrl;
  }

  public void setEndpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
  }

  public CallbackSettings1 triggers(CallbackSettings1Triggers triggers) {
    this.triggers = triggers;
    return this;
  }

   /**
   * Get triggers
   * @return triggers
  **/
  @Schema(description = "")
  public CallbackSettings1Triggers getTriggers() {
    return triggers;
  }

  public void setTriggers(CallbackSettings1Triggers triggers) {
    this.triggers = triggers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallbackSettings1 callbackSettings1 = (CallbackSettings1) o;
    return Objects.equals(this.endpointUrl, callbackSettings1.endpointUrl) &&
        Objects.equals(this.triggers, callbackSettings1.triggers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpointUrl, triggers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallbackSettings1 {\n");
    
    sb.append("    endpointUrl: ").append(toIndentedString(endpointUrl)).append("\n");
    sb.append("    triggers: ").append(toIndentedString(triggers)).append("\n");
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