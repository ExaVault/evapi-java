
# Share

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | ID of the share. |  [optional]
**name** | **String** | Share name. |  [optional]
**hasPassword** | **Boolean** | True if the share has password. |  [optional]
**_public** | **Boolean** | True if the share has a public url. |  [optional]
**accessMode** | [**AccessModeEnum**](#AccessModeEnum) | Access rights for the share. |  [optional]
**accessDescription** | **String** | Description of the share access rights. |  [optional]
**embed** | **Boolean** | True if share can be embedded. |  [optional]
**hash** | **String** | Share hash. |  [optional]
**ownerHash** | **String** | Share owner&#39;s hash. |  [optional]
**expiration** | **String** | Expiration date of the share. |  [optional]
**expired** | **Boolean** | True if the share has expired. |  [optional]
**resent** | **String** | Invitations resent date. Can be &#x60;null&#x60; if resent never happened. |  [optional]
**owner** | **Integer** | ID of the share owner. |  [optional]
**ownerUsername** | **String** | Username of share owner. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Type of share. |  [optional]
**requireEmail** | **Boolean** | True if share requires email to access. |  [optional]
**fileDropCreateFolders** | **Boolean** | Flag to show if separate folders should be created for each file upload to receive folder. |  [optional]
**paths** | **List&lt;String&gt;** | Path to the shared resource in your account. |  [optional]
**recipients** | [**List&lt;ShareRecipient&gt;**](ShareRecipient.md) | Array of recipients. |  [optional]
**recipientsWithOwner** | [**List&lt;ShareRecipient&gt;**](ShareRecipient.md) | Array of recipients with owner. |  [optional]
**messages** | [**List&lt;Message&gt;**](Message.md) | Array of invitation messages. |  [optional]
**inherited** | **Boolean** | True if share inherited from parent folder. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Share activity status. Can be active (1) or deactivated (0). |  [optional]
**hasNotification** | **Boolean** | True if share has notification. |  [optional]
**notification** | **String** | Notification object if share has one. |  [optional]
**created** | **String** | Timestamp of share creation. |  [optional]
**modified** | **String** | Timestamp of share modification. Can be &#x60;null&#x60; if it wasn&#39;t modified. |  [optional]


<a name="AccessModeEnum"></a>
## Enum: AccessModeEnum
Name | Value
---- | -----
UPLOAD | &quot;upload&quot;
DOWNLOAD | &quot;download&quot;
DOWNLOAD_UPLOAD | &quot;download_upload&quot;
DOWNLOAD_UPLOAD_MODIFY_DELETE | &quot;download_upload_modify_delete&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
SHARED_FOLDER | &quot;shared_folder&quot;
SEND | &quot;send&quot;
RECEIVE | &quot;receive&quot;


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NUMBER_0 | 0
NUMBER_1 | 1



