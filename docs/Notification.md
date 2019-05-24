
# Notification

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | ID of the notification. |  [optional]
**userId** | **String** | ID of the user that the notification belongs to. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Notification type. |  [optional]
**path** | **String** | Path to the item that the notification is set on. |  [optional]
**name** | **String** | Name of the item that the notification is set on. |  [optional]
**action** | [**ActionEnum**](#ActionEnum) | Action that triggers notification. |  [optional]
**usernames** | **List&lt;String&gt;** | Detail on which users can trigger the notification. |  [optional]
**recipients** | [**List&lt;NotificationRecipient&gt;**](NotificationRecipient.md) | Notification recipients. |  [optional]
**recipientEmails** | **List&lt;String&gt;** | Email addresses of all recipients. |  [optional]
**sendEmail** | [**SendEmailEnum**](#SendEmailEnum) | Send email when the notification is triggered. |  [optional]
**readableDescription** | **String** | Human readable description of the notification. |  [optional]
**readableDescriptionWithoutPath** | **String** | Human readable description of the notification without item path. |  [optional]
**shareId** | **String** | ID of the share that the notification belogns to. |  [optional]
**message** | **String** | Custom message that will be sent to the notification recipients. |  [optional]
**created** | **String** | Timestamp of notifiction creation. |  [optional]
**modified** | **String** | Timestamp of notification modification. |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
FILE | &quot;file&quot;
FOLDER | &quot;folder&quot;
SHARED_FOLDER | &quot;shared_folder&quot;
SEND_RECEIPT | &quot;send_receipt&quot;
SHARE_RECEIPT | &quot;share_receipt&quot;
FILE_DROP | &quot;file_drop&quot;


<a name="ActionEnum"></a>
## Enum: ActionEnum
Name | Value
---- | -----
UPLOAD | &quot;upload&quot;
DOWNLOAD | &quot;download&quot;
DELETE | &quot;delete&quot;
ALL | &quot;all&quot;


<a name="SendEmailEnum"></a>
## Enum: SendEmailEnum
Name | Value
---- | -----
_0 | &quot;0&quot;
_1 | &quot;1&quot;



