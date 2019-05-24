
# ModifiedResourcesResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | [**SuccessEnum**](#SuccessEnum) | Flag indicates API call status. &#x60;0&#x60; is failure; &#x60;1&#x60; is success; &#x60;2&#x60; means partial success - some but not all files were moved, copied or deleted. |  [optional]
**error** | **Object** |  |  [optional]
**results** | [**List&lt;ModifiedResource&gt;**](ModifiedResource.md) |  |  [optional]


<a name="SuccessEnum"></a>
## Enum: SuccessEnum
Name | Value
---- | -----
NUMBER_0 | 0
NUMBER_1 | 1
NUMBER_2 | 2



