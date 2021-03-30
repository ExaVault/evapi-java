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
 * BrandingSettings
 */


public class BrandingSettings {
  @SerializedName("companyName")
  private String companyName = null;

  @SerializedName("customEmail")
  private String customEmail = null;

  @SerializedName("logo")
  private String logo = null;

  @SerializedName("logoExt")
  private String logoExt = null;

  @SerializedName("theme")
  private String theme = null;

  @SerializedName("verifiedDomain")
  private String verifiedDomain = null;

  @SerializedName("verifiedDomainId")
  private String verifiedDomainId = null;

  @SerializedName("verifiedDomainValid")
  private Boolean verifiedDomainValid = null;

  public BrandingSettings companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

   /**
   * null
   * @return companyName
  **/
  @Schema(description = "null")
  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public BrandingSettings customEmail(String customEmail) {
    this.customEmail = customEmail;
    return this;
  }

   /**
   * null
   * @return customEmail
  **/
  @Schema(example = "custom@example.com", description = "null")
  public String getCustomEmail() {
    return customEmail;
  }

  public void setCustomEmail(String customEmail) {
    this.customEmail = customEmail;
  }

  public BrandingSettings logo(String logo) {
    this.logo = logo;
    return this;
  }

   /**
   * null
   * @return logo
  **/
  @Schema(example = "examplelogo.png", description = "null")
  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public BrandingSettings logoExt(String logoExt) {
    this.logoExt = logoExt;
    return this;
  }

   /**
   * null
   * @return logoExt
  **/
  @Schema(example = "png", description = "null")
  public String getLogoExt() {
    return logoExt;
  }

  public void setLogoExt(String logoExt) {
    this.logoExt = logoExt;
  }

  public BrandingSettings theme(String theme) {
    this.theme = theme;
    return this;
  }

   /**
   * null
   * @return theme
  **/
  @Schema(example = "default", description = "null")
  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public BrandingSettings verifiedDomain(String verifiedDomain) {
    this.verifiedDomain = verifiedDomain;
    return this;
  }

   /**
   * Get verifiedDomain
   * @return verifiedDomain
  **/
  @Schema(description = "")
  public String getVerifiedDomain() {
    return verifiedDomain;
  }

  public void setVerifiedDomain(String verifiedDomain) {
    this.verifiedDomain = verifiedDomain;
  }

  public BrandingSettings verifiedDomainId(String verifiedDomainId) {
    this.verifiedDomainId = verifiedDomainId;
    return this;
  }

   /**
   * Get verifiedDomainId
   * @return verifiedDomainId
  **/
  @Schema(description = "")
  public String getVerifiedDomainId() {
    return verifiedDomainId;
  }

  public void setVerifiedDomainId(String verifiedDomainId) {
    this.verifiedDomainId = verifiedDomainId;
  }

  public BrandingSettings verifiedDomainValid(Boolean verifiedDomainValid) {
    this.verifiedDomainValid = verifiedDomainValid;
    return this;
  }

   /**
   * Get verifiedDomainValid
   * @return verifiedDomainValid
  **/
  @Schema(description = "")
  public Boolean isVerifiedDomainValid() {
    return verifiedDomainValid;
  }

  public void setVerifiedDomainValid(Boolean verifiedDomainValid) {
    this.verifiedDomainValid = verifiedDomainValid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BrandingSettings brandingSettings = (BrandingSettings) o;
    return Objects.equals(this.companyName, brandingSettings.companyName) &&
        Objects.equals(this.customEmail, brandingSettings.customEmail) &&
        Objects.equals(this.logo, brandingSettings.logo) &&
        Objects.equals(this.logoExt, brandingSettings.logoExt) &&
        Objects.equals(this.theme, brandingSettings.theme) &&
        Objects.equals(this.verifiedDomain, brandingSettings.verifiedDomain) &&
        Objects.equals(this.verifiedDomainId, brandingSettings.verifiedDomainId) &&
        Objects.equals(this.verifiedDomainValid, brandingSettings.verifiedDomainValid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyName, customEmail, logo, logoExt, theme, verifiedDomain, verifiedDomainId, verifiedDomainValid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BrandingSettings {\n");
    
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    customEmail: ").append(toIndentedString(customEmail)).append("\n");
    sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
    sb.append("    logoExt: ").append(toIndentedString(logoExt)).append("\n");
    sb.append("    theme: ").append(toIndentedString(theme)).append("\n");
    sb.append("    verifiedDomain: ").append(toIndentedString(verifiedDomain)).append("\n");
    sb.append("    verifiedDomainId: ").append(toIndentedString(verifiedDomainId)).append("\n");
    sb.append("    verifiedDomainValid: ").append(toIndentedString(verifiedDomainValid)).append("\n");
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
