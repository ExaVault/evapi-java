
# UpdateNotification

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accessToken** | **String** | Access token required to make the API call. | 
**id** | **Integer** | ID of the notification. Use &lt;a href&#x3D;\&quot;#operation/getNotifications\&quot;&gt;getNotifications&lt;/a&gt; if you need to lookup an ID. | 
**path** | **String** | Full path of file/folder where the notification is set. |  [optional]
**action** | [**ActionEnum**](#ActionEnum) | Type of action to filter on. Notifications will only be fired for the given type of action. |  [optional]
**usernames** | **List&lt;String&gt;** | Array of usernames or with one flag to filter on. This options allows to filter what users will trigger the notification. |  [optional]
**sendEmail** | **Boolean** | Set to true if the user should be notified by email when the notification is triggered. |  [optional]
**emails** | **List&lt;String&gt;** | Email addresses to send notification to. If not specified, sends to the authenticated user. |  [optional]


<a name="ActionEnum"></a>
## Enum: ActionEnum
Name | Value
---- | -----
UPLOAD | &quot;upload&quot;
DOWNLOAD | &quot;download&quot;
DELETE | &quot;delete&quot;
ALL | &quot;all&quot;



