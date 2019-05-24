
# Resource

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**totalFiles** | **Integer** | Total amount of files and folders in resource. |  [optional]
**resources** | [**List&lt;ResourceProperty&gt;**](ResourceProperty.md) | Array of resources inside given resource path. |  [optional]
**inheritedShares** | [**List&lt;Share&gt;**](Share.md) | Array of all shares inside the given resource. Property not emtpy only if &#x60;detailed&#x60; param was set to &#x60;true&#x60;. |  [optional]
**inheritedNotifications** | [**List&lt;Notification&gt;**](Notification.md) | Array of all notifications inside the given resource. Property not emtpy only if &#x60;detailed&#x60; param was set to &#x60;true&#x60;. |  [optional]
**inheritedDirectFiles** | [**List&lt;DirectFile&gt;**](DirectFile.md) | Array of all direct file objects inside the given resource. Property not emtpy only if &#x60;detailed&#x60; param was set to &#x60;true&#x60;. |  [optional]



