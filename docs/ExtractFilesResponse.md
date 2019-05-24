
# ExtractFilesResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**success** | [**SuccessEnum**](#SuccessEnum) | Flag indicates API call status. &#x60;0&#x60; is failure; &#x60;1&#x60; is success. |  [optional]
**error** | **Object** | when success attribute is &#x60;0&#x60;, this will contain an explanatory message. |  [optional]
**results** | [**List&lt;ResourceProperty&gt;**](ResourceProperty.md) | Array of extracted resources. |  [optional]


<a name="SuccessEnum"></a>
## Enum: SuccessEnum
Name | Value
---- | -----
NUMBER_0 | 0
NUMBER_1 | 1



