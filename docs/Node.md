
# Node

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | Unique ID of the node |  [optional]
**parentNodeId** | **Integer** | Unique ID of containing folder |  [optional]
**hash** | **String** | unique hashed ID |  [optional]
**name** | **String** | File or folder name |  [optional]
**extension** | **String** | File extension |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Type of item |  [optional]
**createdBy** | **String** | User id of creator |  [optional]
**uploadDate** | **String** | Date file or folder was created |  [optional]
**createdAt** | **String** | Date file or folder was created |  [optional]
**updatedAt** | **String** | Date file or folder was last changed |  [optional]
**accessedAt** | **String** | Date file was last downloaded |  [optional]
**createdTime** | **String** | Timestamp of file or folder creation |  [optional]
**updatedTime** | **String** | Timestamp of file or folder last changed |  [optional]
**accessedTime** | **String** | Timestamp file was last downloaded |  [optional]
**parent** | **String** | Path of parent folder |  [optional]
**path** | **String** | full path to current file or folder, including self |  [optional]
**shares** | [**List&lt;Share&gt;**](Share.md) |  |  [optional]
**notifications** | [**List&lt;Notification&gt;**](Notification.md) |  |  [optional]
**size** | **String** | size of the file or folder in bytes |  [optional]
**fileCount** | **Integer** | Number of files contained within this node |  [optional]
**previewable** | **Boolean** | Whether node can be previewed (supported image type) |  [optional]
**directFile** | [**List&lt;DirectFile&gt;**](DirectFile.md) |  |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
DIR_FILE | &quot;dir file&quot;



