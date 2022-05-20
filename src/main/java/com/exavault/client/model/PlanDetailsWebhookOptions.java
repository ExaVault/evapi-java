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
import java.util.ArrayList;
import java.util.List;
/**
 * PlanDetailsWebhookOptions
 */


public class PlanDetailsWebhookOptions {
  @SerializedName("restrictionTypes")
  private List<String> restrictionTypes = null;

  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("includeTriggers")
  private String includeTriggers = null;

  public PlanDetailsWebhookOptions restrictionTypes(List<String> restrictionTypes) {
    this.restrictionTypes = restrictionTypes;
    return this;
  }

  public PlanDetailsWebhookOptions addRestrictionTypesItem(String restrictionTypesItem) {
    if (this.restrictionTypes == null) {
      this.restrictionTypes = new ArrayList<String>();
    }
    this.restrictionTypes.add(restrictionTypesItem);
    return this;
  }

   /**
   * Get restrictionTypes
   * @return restrictionTypes
  **/
  @Schema(description = "")
  public List<String> getRestrictionTypes() {
    return restrictionTypes;
  }

  public void setRestrictionTypes(List<String> restrictionTypes) {
    this.restrictionTypes = restrictionTypes;
  }

  public PlanDetailsWebhookOptions amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @Schema(description = "")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public PlanDetailsWebhookOptions includeTriggers(String includeTriggers) {
    this.includeTriggers = includeTriggers;
    return this;
  }

   /**
   * Get includeTriggers
   * @return includeTriggers
  **/
  @Schema(description = "")
  public String getIncludeTriggers() {
    return includeTriggers;
  }

  public void setIncludeTriggers(String includeTriggers) {
    this.includeTriggers = includeTriggers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanDetailsWebhookOptions planDetailsWebhookOptions = (PlanDetailsWebhookOptions) o;
    return Objects.equals(this.restrictionTypes, planDetailsWebhookOptions.restrictionTypes) &&
        Objects.equals(this.amount, planDetailsWebhookOptions.amount) &&
        Objects.equals(this.includeTriggers, planDetailsWebhookOptions.includeTriggers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restrictionTypes, amount, includeTriggers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanDetailsWebhookOptions {\n");
    
    sb.append("    restrictionTypes: ").append(toIndentedString(restrictionTypes)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    includeTriggers: ").append(toIndentedString(includeTriggers)).append("\n");
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