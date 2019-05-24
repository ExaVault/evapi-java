
# User

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | [**StatusEnum**](#StatusEnum) | Indicates user activity status. &#x60;0&#x60; means the user is locked and cannot log in. &#x60;1&#x60; means the user is active and can log in. |  [optional]
**expiration** | **String** | Timestamp of user expiration. |  [optional]
**created** | **String** | Timestamp of user creation. |  [optional]
**modified** | **String** | Timestamp of user modification. |  [optional]
**accessTimestamp** | **String** | Timestamp of most recent successful user login. |  [optional]
**id** | **Integer** | ID of the user. |  [optional]
**accountId** | **Integer** | Internal ID of the account this user belongs to. |  [optional]
**accountName** | **String** | Name of the account this user belongs to. |  [optional]
**username** | **String** | Username of the user. |  [optional]
**nickname** | **String** | Nickname of the user. |  [optional]
**email** | **String** | Email address of the user. |  [optional]
**homeDir** | **String** | Path to the user&#39;s home folder. |  [optional]
**onboarding** | **Boolean** | Whether the onboarding help system is enabled for this user. &#x60;true&#x60; means that additional help popups are displayed in the web application for this user. |  [optional]
**firstLogin** | **Boolean** | Whether this is the first time the user has logged into the system. |  [optional]
**download** | **Boolean** | Download permission flag. |  [optional]
**upload** | **Boolean** | Upload permission flag. |  [optional]
**modify** | **Boolean** | Modify permission flag. |  [optional]
**delete** | **Boolean** | Delete permission flag. |  [optional]
**list** | **Boolean** | View files permission flag. |  [optional]
**changePassword** | **Boolean** | Change permission flag. |  [optional]
**share** | **Boolean** | Share folders permission flag. |  [optional]
**notification** | **Boolean** | Create notifications permission flag. |  [optional]
**viewFormData** | **Boolean** | Access Form Data permission flag. If &#x60;true&#x60;, user can view submissions that have been stored for a receive folder. This includes any data submitted in the receive folder form. |  [optional]
**deleteFormData** | **Object** | Delete form data permission flag. If &#x60;true&#x60;, user can remove data that was submitted for a receive folder. This applies only to data submitted in the receive folder form, not the actual files uploaded. |  [optional]
**role** | [**RoleEnum**](#RoleEnum) | User&#39;s role. |  [optional]
**timeZone** | **String** | User&#39;s timezone. See &lt;a href&#x3D;&#39;https://php.net/manual/en/timezones.php&#39; target&#x3D;&#39;blank&#39;&gt;this page&lt;/a&gt; for allowed values. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NUMBER_0 | 0
NUMBER_1 | 1


<a name="RoleEnum"></a>
## Enum: RoleEnum
Name | Value
---- | -----
USER | &quot;user&quot;
ADMIN | &quot;admin&quot;
MASTER | &quot;master&quot;



