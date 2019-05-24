
# LogEntry

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fileName** | **String** | Current resource path. |  [optional]
**fileSource** | **String** | Original path to the resource. Can be null if operation type not move or copy. |  [optional]
**operation** | [**OperationEnum**](#OperationEnum) | Type of operation that happened in the account. |  [optional]
**duration** | **String** | Duration of the operation. |  [optional]
**bytesTransferred** | **String** | Amount of bytes transfered during the operation. |  [optional]
**id** | **String** | ID of the log entry. |  [optional]
**created** | **String** | Timestamp of the operation. |  [optional]
**username** | **String** | Name of the user who triggered the operation. |  [optional]
**sessionId** | **String** | ID of user&#39;s session. |  [optional]
**ipAddress** | **String** | IP address of the connected client. |  [optional]
**protocol** | **String** | Protocol used for the operation. Protocol can vary on type of application you or your users used to work with your account. Some of possible values are &#x60;web&#x60;, &#x60;https&#x60;, &#x60;sftp&#x60;, &#x60;ftp&#x60;, &#x60;ftps&#x60;. Access via API will show the name of the API key used. |  [optional]
**status** | **String** | Operation status. |  [optional]


<a name="OperationEnum"></a>
## Enum: OperationEnum
Name | Value
---- | -----
PASS | &quot;PASS&quot;
EXIT | &quot;EXIT&quot;
STOR | &quot;STOR&quot;
RETR | &quot;RETR&quot;
DELE | &quot;DELE&quot;
MKD | &quot;MKD&quot;
RMD | &quot;RMD&quot;
RNTO | &quot;RNTO&quot;
COPY | &quot;COPY&quot;
MOVE | &quot;MOVE&quot;
SEND | &quot;SEND&quot;
SHARE | &quot;SHARE&quot;
RECV | &quot;RECV&quot;
NOTIFY | &quot;NOTIFY&quot;
EDIT_SEND | &quot;EDIT_SEND&quot;
EDIT_SHARE | &quot;EDIT_SHARE&quot;
EDIT_RECV | &quot;EDIT_RECV&quot;
EDIT_NTFY | &quot;EDIT_NTFY&quot;
EDIT_USER | &quot;EDIT_USER&quot;
DELE_SEND | &quot;DELE_SEND&quot;
DELE_SHARE | &quot;DELE_SHARE&quot;
DELE_NTFY | &quot;DELE_NTFY&quot;
DELE_USER | &quot;DELE_USER&quot;
DELE_RECV | &quot;DELE_RECV&quot;
COMPR | &quot;COMPR&quot;
EXTRACT | &quot;EXTRACT&quot;
DFA | &quot;DFA&quot;
EDIT_DFA | &quot;EDIT_DFA&quot;
DELE_DFA | &quot;DELE_DFA&quot;



