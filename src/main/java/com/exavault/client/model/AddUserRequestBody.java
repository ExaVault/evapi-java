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
import com.exavault.client.model.UsersPermissions;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * AddUserRequestBody
 */


public class AddUserRequestBody {
  @SerializedName("username")
  private String username = null;

  @SerializedName("nickname")
  private String nickname = null;

  @SerializedName("homeResource")
  private String homeResource = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("password")
  private String password = null;

  /**
   * The type of user to create. Note that admin users cannot have a &#x60;homeResource&#x60; other than &#x27;/&#x27;, and will have full permissions, but you must provide at least \&quot;download,upload,list,delete\&quot; in the &#x60;permissions&#x60; parameter.
   */
  @JsonAdapter(RoleEnum.Adapter.class)
  public enum RoleEnum {
    USER("user"),
    ADMIN("admin");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static RoleEnum fromValue(String text) {
      for (RoleEnum b : RoleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<RoleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RoleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RoleEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RoleEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("role")
  private RoleEnum role = null;

  @SerializedName("permissions")
  private UsersPermissions permissions = null;

  @SerializedName("timeZone")
  private String timeZone = null;

  @SerializedName("expiration")
  private String expiration = null;

  @SerializedName("locked")
  private Boolean locked = null;

  @SerializedName("welcomeEmail")
  private Boolean welcomeEmail = null;

  @SerializedName("onboarding")
  private Boolean onboarding = null;

  public AddUserRequestBody username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Username of the user to create. This should follow standard username conventions - spaces are not allowed, etc. We do allow email addresses as usernames.  **Note** Usernames must be unique across all ExaVault accounts.
   * @return username
  **/
  @Schema(example = "testuser", required = true, description = "Username of the user to create. This should follow standard username conventions - spaces are not allowed, etc. We do allow email addresses as usernames.  **Note** Usernames must be unique across all ExaVault accounts.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AddUserRequestBody nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

   /**
   * An optional nickname (e.g. &#x27;David from Sales&#x27;).
   * @return nickname
  **/
  @Schema(example = "testnickname", description = "An optional nickname (e.g. 'David from Sales').")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public AddUserRequestBody homeResource(String homeResource) {
    this.homeResource = homeResource;
    return this;
  }

   /**
   * Resource identifier for the user&#x27;s home folder. See details on [how to specify resources](#section/Identifying-Resources) above.  The user will be locked to this directory and unable to move &#x27;up&#x27; in the account. If the folder does not exist in the account, it will be created when the user is created.   This setting is ignored for users with the &#x60;role&#x60; **admin**.
   * @return homeResource
  **/
  @Schema(example = "/", required = true, description = "Resource identifier for the user's home folder. See details on [how to specify resources](#section/Identifying-Resources) above.  The user will be locked to this directory and unable to move 'up' in the account. If the folder does not exist in the account, it will be created when the user is created.   This setting is ignored for users with the `role` **admin**.")
  public String getHomeResource() {
    return homeResource;
  }

  public void setHomeResource(String homeResource) {
    this.homeResource = homeResource;
  }

  public AddUserRequestBody email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email address for the user
   * @return email
  **/
  @Schema(example = "testuser@email.com", required = true, description = "Email address for the user")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AddUserRequestBody password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Password for the user
   * @return password
  **/
  @Schema(required = true, description = "Password for the user")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AddUserRequestBody role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * The type of user to create. Note that admin users cannot have a &#x60;homeResource&#x60; other than &#x27;/&#x27;, and will have full permissions, but you must provide at least \&quot;download,upload,list,delete\&quot; in the &#x60;permissions&#x60; parameter.
   * @return role
  **/
  @Schema(example = "user", required = true, description = "The type of user to create. Note that admin users cannot have a `homeResource` other than '/', and will have full permissions, but you must provide at least \"download,upload,list,delete\" in the `permissions` parameter.")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public AddUserRequestBody permissions(UsersPermissions permissions) {
    this.permissions = permissions;
    return this;
  }

   /**
   * Get permissions
   * @return permissions
  **/
  @Schema(required = true, description = "")
  public UsersPermissions getPermissions() {
    return permissions;
  }

  public void setPermissions(UsersPermissions permissions) {
    this.permissions = permissions;
  }

  public AddUserRequestBody timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

   /**
   * Time zone, used for accurate time display within the application. See &lt;a href&#x3D;&#x27;https://php.net/manual/en/timezones.php&#x27; target&#x3D;&#x27;blank&#x27;&gt;this page&lt;/a&gt; for allowed values. 
   * @return timeZone
  **/
  @Schema(example = "America/Los_Angeles", required = true, description = "Time zone, used for accurate time display within the application. See <a href='https://php.net/manual/en/timezones.php' target='blank'>this page</a> for allowed values. ")
  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public AddUserRequestBody expiration(String expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Optional timestamp when the user should expire, formatted in date-time.
   * @return expiration
  **/
  @Schema(example = "2011-03-21 00:18:56", description = "Optional timestamp when the user should expire, formatted in date-time.")
  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public AddUserRequestBody locked(Boolean locked) {
    this.locked = locked;
    return this;
  }

   /**
   * If true, the user will not be able to log in
   * @return locked
  **/
  @Schema(example = "true", description = "If true, the user will not be able to log in")
  public Boolean isLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public AddUserRequestBody welcomeEmail(Boolean welcomeEmail) {
    this.welcomeEmail = welcomeEmail;
    return this;
  }

   /**
   * If **true**, send this new user a welcome email upon creation. The content of the welcome email can be configured with the [PATCH /accounts](#operation/updateAccount) method.
   * @return welcomeEmail
  **/
  @Schema(example = "true", description = "If **true**, send this new user a welcome email upon creation. The content of the welcome email can be configured with the [PATCH /accounts](#operation/updateAccount) method.")
  public Boolean isWelcomeEmail() {
    return welcomeEmail;
  }

  public void setWelcomeEmail(Boolean welcomeEmail) {
    this.welcomeEmail = welcomeEmail;
  }

  public AddUserRequestBody onboarding(Boolean onboarding) {
    this.onboarding = onboarding;
    return this;
  }

   /**
   * Set this to **true** to enable extra help popups in the web file manager for this user.
   * @return onboarding
  **/
  @Schema(example = "true", description = "Set this to **true** to enable extra help popups in the web file manager for this user.")
  public Boolean isOnboarding() {
    return onboarding;
  }

  public void setOnboarding(Boolean onboarding) {
    this.onboarding = onboarding;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddUserRequestBody addUserRequestBody = (AddUserRequestBody) o;
    return Objects.equals(this.username, addUserRequestBody.username) &&
        Objects.equals(this.nickname, addUserRequestBody.nickname) &&
        Objects.equals(this.homeResource, addUserRequestBody.homeResource) &&
        Objects.equals(this.email, addUserRequestBody.email) &&
        Objects.equals(this.password, addUserRequestBody.password) &&
        Objects.equals(this.role, addUserRequestBody.role) &&
        Objects.equals(this.permissions, addUserRequestBody.permissions) &&
        Objects.equals(this.timeZone, addUserRequestBody.timeZone) &&
        Objects.equals(this.expiration, addUserRequestBody.expiration) &&
        Objects.equals(this.locked, addUserRequestBody.locked) &&
        Objects.equals(this.welcomeEmail, addUserRequestBody.welcomeEmail) &&
        Objects.equals(this.onboarding, addUserRequestBody.onboarding);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, nickname, homeResource, email, password, role, permissions, timeZone, expiration, locked, welcomeEmail, onboarding);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddUserRequestBody {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    homeResource: ").append(toIndentedString(homeResource)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
    sb.append("    welcomeEmail: ").append(toIndentedString(welcomeEmail)).append("\n");
    sb.append("    onboarding: ").append(toIndentedString(onboarding)).append("\n");
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