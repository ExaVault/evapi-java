
# CallbackLogEntry

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | ID of the log entry. |  [optional]
**created** | **String** | Timestamp of the operation. |  [optional]
**endpointUrl** | **String** | URL that webhook update was POSTed to. |  [optional]
**event** | **Object** | Action that triggered the webhook. |  [optional]
**attempt** | **Integer** | Number of times the message has been sent (including this entry). Whenever the receiving endpoint does not return a 200 response, the system attempts again up to maxium of 8 attempts |  [optional]
**responseSize** | **Integer** | Number of bytes returned in the body of the response from the endpoint |  [optional]
**response** | **String** | Body of the response. |  [optional]



