
# NotificationMessage

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | ID of the notifications message. |  [optional]
**notificationSetting** | [**Notification**](Notification.md) | Notification which triggered this message. |  [optional]
**message** | **String** | Message body. |  [optional]
**path** | **String** | Path to the resource the notification is set on. |  [optional]
**action** | [**ActionEnum**](#ActionEnum) | Action which triggers the notification. |  [optional]
**username** | **String** | Name of the user that triggered the notification. |  [optional]
**sent** | **Boolean** | Flag set to true if a notification email was sent. |  [optional]
**created** | **String** | Timestamp of notification message creation. |  [optional]


<a name="ActionEnum"></a>
## Enum: ActionEnum
Name | Value
---- | -----
UPLOAD | &quot;upload&quot;
DOWNLOAD | &quot;download&quot;
DELETE | &quot;delete&quot;
ALL | &quot;all&quot;



