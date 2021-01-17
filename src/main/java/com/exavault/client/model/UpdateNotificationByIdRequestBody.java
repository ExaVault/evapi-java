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
 * UpdateNotificationByIdRequestBody
 */


public class UpdateNotificationByIdRequestBody {
  /**
   * Type of action be notified about. Notifications will only be sent for the given type of action. Valid choices are **upload**, **download**, **delete** or **all** (upload/download/delete)
   */
  @JsonAdapter(ActionEnum.Adapter.class)
  public enum ActionEnum {
    UPLOAD("upload"),
    DOWNLOAD("download"),
    DELETE("delete"),
    ALL("all");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static ActionEnum fromValue(String text) {
      for (ActionEnum b : ActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<ActionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ActionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ActionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ActionEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("action")
  private ActionEnum action = null;

  @SerializedName("usernames")
  private List<String> usernames = null;

  @SerializedName("sendEmail")
  private Boolean sendEmail = null;

  @SerializedName("recipients")
  private List<String> recipients = null;

  @SerializedName("message")
  private String message = null;

  public UpdateNotificationByIdRequestBody action(ActionEnum action) {
    this.action = action;
    return this;
  }

   /**
   * Type of action be notified about. Notifications will only be sent for the given type of action. Valid choices are **upload**, **download**, **delete** or **all** (upload/download/delete)
   * @return action
  **/
  @Schema(example = "all", description = "Type of action be notified about. Notifications will only be sent for the given type of action. Valid choices are **upload**, **download**, **delete** or **all** (upload/download/delete)")
  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public UpdateNotificationByIdRequestBody usernames(List<String> usernames) {
    this.usernames = usernames;
    return this;
  }

  public UpdateNotificationByIdRequestBody addUsernamesItem(String usernamesItem) {
    if (this.usernames == null) {
      this.usernames = new ArrayList<String>();
    }
    this.usernames.add(usernamesItem);
    return this;
  }

   /**
   * Determines which users&#x27; actions should trigger the notification.   Rather than listing  individual users, you can also use 3 special options:  - **notice\\_user\\_all** for activity by any user or share recipient - **notice\\_user\\_all\\_users** for activity only by user accounts - **notice\\_user\\_all\\_recipients** for activity only by share recipients
   * @return usernames
  **/
  @Schema(example = "[\"notice_user_all\"]", description = "Determines which users' actions should trigger the notification.   Rather than listing  individual users, you can also use 3 special options:  - **notice\\_user\\_all** for activity by any user or share recipient - **notice\\_user\\_all\\_users** for activity only by user accounts - **notice\\_user\\_all\\_recipients** for activity only by share recipients")
  public List<String> getUsernames() {
    return usernames;
  }

  public void setUsernames(List<String> usernames) {
    this.usernames = usernames;
  }

  public UpdateNotificationByIdRequestBody sendEmail(Boolean sendEmail) {
    this.sendEmail = sendEmail;
    return this;
  }

   /**
   * Whether an email should be sent to the recipients when matching activity happens.
   * @return sendEmail
  **/
  @Schema(example = "true", description = "Whether an email should be sent to the recipients when matching activity happens.")
  public Boolean isSendEmail() {
    return sendEmail;
  }

  public void setSendEmail(Boolean sendEmail) {
    this.sendEmail = sendEmail;
  }

  public UpdateNotificationByIdRequestBody recipients(List<String> recipients) {
    this.recipients = recipients;
    return this;
  }

  public UpdateNotificationByIdRequestBody addRecipientsItem(String recipientsItem) {
    if (this.recipients == null) {
      this.recipients = new ArrayList<String>();
    }
    this.recipients.add(recipientsItem);
    return this;
  }

   /**
   * Email addresses to send notification emails to. If empty, sends to the current user&#x27;s email address.
   * @return recipients
  **/
  @Schema(example = "[\"myemail@example.com\"]", description = "Email addresses to send notification emails to. If empty, sends to the current user's email address.")
  public List<String> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<String> recipients) {
    this.recipients = recipients;
  }

  public UpdateNotificationByIdRequestBody message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Custom message to insert into the notification emails, along with the matching activity.
   * @return message
  **/
  @Schema(description = "Custom message to insert into the notification emails, along with the matching activity.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateNotificationByIdRequestBody updateNotificationByIdRequestBody = (UpdateNotificationByIdRequestBody) o;
    return Objects.equals(this.action, updateNotificationByIdRequestBody.action) &&
        Objects.equals(this.usernames, updateNotificationByIdRequestBody.usernames) &&
        Objects.equals(this.sendEmail, updateNotificationByIdRequestBody.sendEmail) &&
        Objects.equals(this.recipients, updateNotificationByIdRequestBody.recipients) &&
        Objects.equals(this.message, updateNotificationByIdRequestBody.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, usernames, sendEmail, recipients, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateNotificationByIdRequestBody {\n");
    
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    usernames: ").append(toIndentedString(usernames)).append("\n");
    sb.append("    sendEmail: ").append(toIndentedString(sendEmail)).append("\n");
    sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
