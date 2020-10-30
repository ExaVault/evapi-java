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
import com.exavault.client.model.UserPermissions;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;
/**
 * Attributes of the user including expiration, home directory, and permissions. 
 */
@Schema(description = "Attributes of the user including expiration, home directory, and permissions. ")

public class UserAttributes {
  /**
   * Indicates user activity status. &#x60;0&#x60; means the user is locked and cannot log in. &#x60;1&#x60; means the user is active and can log in.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    NUMBER_0(0),
    NUMBER_1(1);

    private Integer value;

    StatusEnum(Integer value) {
      this.value = value;
    }
    public Integer getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        Integer value = jsonReader.nextInt();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("expiration")
  private String expiration = null;

  @SerializedName("created")
  private OffsetDateTime created = null;

  @SerializedName("modified")
  private OffsetDateTime modified = null;

  @SerializedName("accessTimestamp")
  private String accessTimestamp = null;

  @SerializedName("accountName")
  private String accountName = null;

  @SerializedName("username")
  private String username = null;

  @SerializedName("nickname")
  private String nickname = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("homeDir")
  private String homeDir = null;

  @SerializedName("permissions")
  private UserPermissions permissions = null;

  /**
   * User&#x27;s access level
   */
  @JsonAdapter(RoleEnum.Adapter.class)
  public enum RoleEnum {
    USER("user"),
    ADMIN("admin"),
    MASTER("master");

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

  @SerializedName("timeZone")
  private String timeZone = null;

  @SerializedName("onboarding")
  private Boolean onboarding = null;

  @SerializedName("firstLogin")
  private Boolean firstLogin = null;

  public UserAttributes status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Indicates user activity status. &#x60;0&#x60; means the user is locked and cannot log in. &#x60;1&#x60; means the user is active and can log in.
   * @return status
  **/
  @Schema(example = "1", required = true, description = "Indicates user activity status. `0` means the user is locked and cannot log in. `1` means the user is active and can log in.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public UserAttributes expiration(String expiration) {
    this.expiration = expiration;
    return this;
  }

   /**
   * Timestamp of user expiration.
   * @return expiration
  **/
  @Schema(example = "2020-06-30T13:33:30-07:00", description = "Timestamp of user expiration.")
  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public UserAttributes created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

   /**
   * Timestamp of user creation.
   * @return created
  **/
  @Schema(example = "2018-07-27T15:43:55-07:00", required = true, description = "Timestamp of user creation.")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public UserAttributes modified(OffsetDateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * Timestamp of user modification.
   * @return modified
  **/
  @Schema(example = "2018-07-29T15:43:55-07:00", required = true, description = "Timestamp of user modification.")
  public OffsetDateTime getModified() {
    return modified;
  }

  public void setModified(OffsetDateTime modified) {
    this.modified = modified;
  }

  public UserAttributes accessTimestamp(String accessTimestamp) {
    this.accessTimestamp = accessTimestamp;
    return this;
  }

   /**
   * Timestamp of most recent successful user login.
   * @return accessTimestamp
  **/
  @Schema(example = "2011-03-21T00:18:56-07:00", description = "Timestamp of most recent successful user login.")
  public String getAccessTimestamp() {
    return accessTimestamp;
  }

  public void setAccessTimestamp(String accessTimestamp) {
    this.accessTimestamp = accessTimestamp;
  }

  public UserAttributes accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * Name of the account this user belongs to.
   * @return accountName
  **/
  @Schema(example = "exampleaccount", required = true, description = "Name of the account this user belongs to.")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public UserAttributes username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Username of the user.
   * @return username
  **/
  @Schema(example = "exampleuser", required = true, description = "Username of the user.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserAttributes nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

   /**
   * Nickname of the user.
   * @return nickname
  **/
  @Schema(example = "exampleuser", required = true, description = "Nickname of the user.")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public UserAttributes email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email address of the user.
   * @return email
  **/
  @Schema(example = "example@exavault.mail", description = "Email address of the user.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserAttributes homeDir(String homeDir) {
    this.homeDir = homeDir;
    return this;
  }

   /**
   * Path to the user&#x27;s home folder.
   * @return homeDir
  **/
  @Schema(example = "/", required = true, description = "Path to the user's home folder.")
  public String getHomeDir() {
    return homeDir;
  }

  public void setHomeDir(String homeDir) {
    this.homeDir = homeDir;
  }

  public UserAttributes permissions(UserPermissions permissions) {
    this.permissions = permissions;
    return this;
  }

   /**
   * Get permissions
   * @return permissions
  **/
  @Schema(required = true, description = "")
  public UserPermissions getPermissions() {
    return permissions;
  }

  public void setPermissions(UserPermissions permissions) {
    this.permissions = permissions;
  }

  public UserAttributes role(RoleEnum role) {
    this.role = role;
    return this;
  }

   /**
   * User&#x27;s access level
   * @return role
  **/
  @Schema(example = "user", required = true, description = "User's access level")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public UserAttributes timeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

   /**
   * User&#x27;s timezone. See &lt;a href&#x3D;&#x27;https://php.net/manual/en/timezones.php&#x27; target&#x3D;&#x27;blank&#x27;&gt;this page&lt;/a&gt; for allowed values.
   * @return timeZone
  **/
  @Schema(example = "America/Chicago", required = true, description = "User's timezone. See <a href='https://php.net/manual/en/timezones.php' target='blank'>this page</a> for allowed values.")
  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public UserAttributes onboarding(Boolean onboarding) {
    this.onboarding = onboarding;
    return this;
  }

   /**
   * Whether the onboarding help system is enabled for this user. &#x60;true&#x60; means that additional help popups are displayed in the web application for this user.
   * @return onboarding
  **/
  @Schema(example = "false", required = true, description = "Whether the onboarding help system is enabled for this user. `true` means that additional help popups are displayed in the web application for this user.")
  public Boolean isOnboarding() {
    return onboarding;
  }

  public void setOnboarding(Boolean onboarding) {
    this.onboarding = onboarding;
  }

  public UserAttributes firstLogin(Boolean firstLogin) {
    this.firstLogin = firstLogin;
    return this;
  }

   /**
   * &#x60;true&#x60; if the user has logged into the system.
   * @return firstLogin
  **/
  @Schema(example = "false", description = "`true` if the user has logged into the system.")
  public Boolean isFirstLogin() {
    return firstLogin;
  }

  public void setFirstLogin(Boolean firstLogin) {
    this.firstLogin = firstLogin;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAttributes userAttributes = (UserAttributes) o;
    return Objects.equals(this.status, userAttributes.status) &&
        Objects.equals(this.expiration, userAttributes.expiration) &&
        Objects.equals(this.created, userAttributes.created) &&
        Objects.equals(this.modified, userAttributes.modified) &&
        Objects.equals(this.accessTimestamp, userAttributes.accessTimestamp) &&
        Objects.equals(this.accountName, userAttributes.accountName) &&
        Objects.equals(this.username, userAttributes.username) &&
        Objects.equals(this.nickname, userAttributes.nickname) &&
        Objects.equals(this.email, userAttributes.email) &&
        Objects.equals(this.homeDir, userAttributes.homeDir) &&
        Objects.equals(this.permissions, userAttributes.permissions) &&
        Objects.equals(this.role, userAttributes.role) &&
        Objects.equals(this.timeZone, userAttributes.timeZone) &&
        Objects.equals(this.onboarding, userAttributes.onboarding) &&
        Objects.equals(this.firstLogin, userAttributes.firstLogin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, expiration, created, modified, accessTimestamp, accountName, username, nickname, email, homeDir, permissions, role, timeZone, onboarding, firstLogin);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAttributes {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    accessTimestamp: ").append(toIndentedString(accessTimestamp)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    homeDir: ").append(toIndentedString(homeDir)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
    sb.append("    onboarding: ").append(toIndentedString(onboarding)).append("\n");
    sb.append("    firstLogin: ").append(toIndentedString(firstLogin)).append("\n");
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
