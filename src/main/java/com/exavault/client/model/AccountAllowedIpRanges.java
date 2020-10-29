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
 * AccountAllowedIpRanges
 */


public class AccountAllowedIpRanges {
  @SerializedName("ip_start")
  private String ipStart = null;

  @SerializedName("ip_end")
  private String ipEnd = null;

  public AccountAllowedIpRanges ipStart(String ipStart) {
    this.ipStart = ipStart;
    return this;
  }

   /**
   * Get ipStart
   * @return ipStart
  **/
  @Schema(description = "")
  public String getIpStart() {
    return ipStart;
  }

  public void setIpStart(String ipStart) {
    this.ipStart = ipStart;
  }

  public AccountAllowedIpRanges ipEnd(String ipEnd) {
    this.ipEnd = ipEnd;
    return this;
  }

   /**
   * Get ipEnd
   * @return ipEnd
  **/
  @Schema(description = "")
  public String getIpEnd() {
    return ipEnd;
  }

  public void setIpEnd(String ipEnd) {
    this.ipEnd = ipEnd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountAllowedIpRanges accountAllowedIpRanges = (AccountAllowedIpRanges) o;
    return Objects.equals(this.ipStart, accountAllowedIpRanges.ipStart) &&
        Objects.equals(this.ipEnd, accountAllowedIpRanges.ipEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipStart, ipEnd);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountAllowedIpRanges {\n");
    
    sb.append("    ipStart: ").append(toIndentedString(ipStart)).append("\n");
    sb.append("    ipEnd: ").append(toIndentedString(ipEnd)).append("\n");
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
