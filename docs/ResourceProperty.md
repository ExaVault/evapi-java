
# ResourceProperty

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fileCount** | **Integer** | Count of files in resource. Property exists only if resource &#x60;type&#x60; is folder. |  [optional]
**extension** | **String** | Resource extension. Property exists only if resource &#x60;type&#x60; is file. |  [optional]
**name** | **String** | Resource name, e.g. the name of the file or folder. |  [optional]
**createdBy** | **String** | Username of the creator. |  [optional]
**uploadDate** | **String** | Timestamp of resource upload or creation. |  [optional]
**parent** | **String** | Parent path of the resource. |  [optional]
**path** | **String** | Full path to the resource. |  [optional]
**shares** | [**List&lt;Share&gt;**](Share.md) | Associated shares array. |  [optional]
**notificationSettings** | **String** | Associated  notificactions array. |  [optional]
**size** | **Long** | Resource size. |  [optional]
**previewable** | **Boolean** | Can resource be previewed. Property equals &#x60;null&#x60; if resource &#x60;type&#x60; is folder. |  [optional]
**directFile** | **String** | Associated direct file objects. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Type of the resource. |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
FILE | &quot;file&quot;
FOLDER | &quot;folder&quot;
DIR | &quot;dir&quot;



