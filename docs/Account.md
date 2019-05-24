
# Account

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Integer** | (ExaVault Use Only) Internal ID of the account. |  [optional]
**username** | **String** | Name of the account. |  [optional]
**maxUsers** | **Integer** | Maximum number of users the account can have. This can be increased by contacting ExaVault Support. |  [optional]
**userCount** | **Integer** | Current number of users on the account. |  [optional]
**masterAccount** | [**User**](User.md) | Master user object. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Account status flag. A one (1) means the account is active; zero (0) means it is suspended. |  [optional]
**branding** | **Boolean** | Branding flag. Set to &#x60;true&#x60; if the account has branding functionality enabled. |  [optional]
**customDomain** | **Boolean** | Custom domain flag. Set to &#x60;true&#x60; if account type allows custom domain functionality. |  [optional]
**planCode** | **String** | (ExaVault Use Only) Code of the plan account is signed up for. |  [optional]
**whmcsPlanId** | **Integer** | (ExaVault Use Only) Internal ID of the service in CMS. |  [optional]
**diskQuotaLimit** | **Long** | Amount of disk space that the account has available to it. This may be increased by upgrading to a larger plan. |  [optional]
**bandwidthQuotaLimit** | **Long** | Amount of bandwidth that the account has available before a warning is generated. All ExaVault accounts include unlimited bandwidth, but we flag high-bandwidth users. |  [optional]
**diskQuotaUsed** | **Long** | Amount of disk space currently in use. |  [optional]
**bandwidthQuotaUsed** | **Long** | Amount of bandwidth used by this account in the last billing period. |  [optional]
**quotaNoticeEnabled** | **Integer** | Should a quota warning be sent to the account owner when a threshold level of space utilization is reached? |  [optional]
**quotaNoticeThreshold** | **Integer** | Treshold that triggers a quota notification. This represents the \&quot;percent full\&quot; your account must be before the quota notification is generated. |  [optional]
**secureOnly** | **Boolean** | Flag to indicate whether the account disables connections via insecure protocols (e.g. FTP). Set to &#x60;true&#x60; to disable all traffic over port 21. |  [optional]
**complexPasswords** | **Boolean** | Flag to indicate whether the account requires complex passwords. Set to &#x60;true&#x60; to require complex passwords on all users and shares. |  [optional]
**showReferralLinks** | **Boolean** | Flag to indicate showing of referrals links in the account. Set to &#x60;true&#x60; to include marketing messages in share invitations. |  [optional]
**externalDomains** | **String** | Custom domain used to brand this account. |  [optional]
**allowedIp** | **String** | Range of IP addresses allowed to access this account. |  [optional]
**callbackSettings** | [**CallbackSettings**](CallbackSettings.md) | Callback settings (Webhooks) of the account. |  [optional]
**freeTrial** | **Boolean** | Flag indicates if free trial enabled. |  [optional]
**trialCode** | **String** | (ExaVault Use Only) Internal tracking code representing type of free trial for account. |  [optional]
**trialStatus** | **String** | (ExaVault Use Only) Internal tracking code representing whether trial has ended or is still in progress. |  [optional]
**trialStart** | **String** | (ExaVault Use Only) Date that free trial period began. |  [optional]
**trialEnd** | **String** | (ExaVault Use Only) Date that free trial period ends. |  [optional]
**clientId** | **Integer** | (ExaVault Use Only) Internal ID of the account in CMS. |  [optional]
**welcomeEmailContent** | **String** | Content of welcome email each new user will receive. |  [optional]
**welcomeEmailSubject** | **String** | Subject of welcome email each new user will receive. |  [optional]
**customSignature** | **String** | Custom signature for all account emails users or recipients will receive. |  [optional]
**accountOnboarding** | **Boolean** | Whether the web application onboarding help is enabled for new users in the account. |  [optional]
**created** | **String** | Timestamp of account creation. |  [optional]
**modified** | **String** | Timestamp of account modification. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NUMBER_1 | 1
NUMBER_0 | 0



