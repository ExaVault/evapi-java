package com.exavault.client.api;

import com.exavault.client.model.*;
import com.google.gson.internal.LinkedTreeMap;
import org.threeten.bp.OffsetDateTime;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.exavault.client.api.testdata.ApiTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiTestAssertionUtil {

	public static void validateAddFolderResponse(final ResourceResponse response) {
		final String path = validateResourceAPICommons(response);
		assertThat(path).startsWith(TEST_FOLDER.substring(0, TEST_FOLDER.indexOf("%d")));
	}

	public static void validateRenameResponse(final ResourceResponse response) {
		final String path = validateResourceAPICommons(response, RESPONSE_CODE_200);
		assertThat(path).endsWith(NEW_NAME);
	}

	public static void validateUploadResponse(final ResourceResponse response) {
		final String path = validateResourceAPICommons(response, RESPONSE_CODE_201);
		assertThat(path).contains(DUMMY);
	}

	public static void validateResourceInfo(final ResourceResponse response, final int size) {
		final Resource data = response.getData();
		assertThat(data).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
		final List<Object> included = response.getIncluded();
		assertThat(included).hasSize(size);
	}

	public static void validateDownloadedFile(final File file) {
		assertThat(file).hasName(DOWNLOAD_ARCHIVE + ZIP);
	}

	public static void validateAddFolderResponse2(final ResourceResponse response) {
		final String path = validateResourceAPICommons(response);
		assertThat(path).isEqualTo(PARENT_PATH + DUMMY_ADD_FOLDER_TEST);
	}

	public static void validateExtract(final ResourceCollectionResponse response) {
		validateResourcesList(response, _2, RESPONSE_CODE_201,
				PARENT_PATH + DECOMPRESS_ZIP + PARENT_PATH + DUMMY);
	}

	public static void validateResourcesList(final ResourceCollectionResponse response, final int size) {
		validateResourcesList(response, size, RESPONSE_CODE_200,
				BASE_FOLDER_ + PARENT_PATH + DUMMY);
	}

	public static void validateResourcesList(final ResourceCollectionResponse response, final int size,
											 final int responseCode, final String expectedPath) {
		assertThat(response).isNotNull();
		assertThat(response.getReturnedResults()).isEqualTo(size);
		assertThat(response.getResponseStatus()).isEqualTo(responseCode);
		final List<Resource> datas = response.getData();
		assertThat(datas).isNotNull();
		for (final Resource data : datas) {
			assertThat(data.getId()).isInstanceOf(Long.class);
			assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
			final ResourceAttributes attributes = data.getAttributes();
			assertThat(attributes).isNotNull();
			final String path = attributes.getPath();
			assertThat(path).startsWith(expectedPath);
		}
	}

	public static void validatePreview(final PreviewFileResponse response) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final PreviewFile data = response.getData();
		assertThat(data).isNotNull();
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(String.class);
	}

	public static void validateCompressFilesResponse(final ResourceResponse response,
													 final String compressName) throws ParseException {
		final String path = validateResourceAPICommons(response);
		assertThat(path).endsWith(ZIP);
		if (compressName != null) {
			assertThat(path).endsWith(compressName);
		}
	}

	private static String validateResourceAPICommons(final ResourceResponse response) {
		return validateResourceAPICommons(response, RESPONSE_CODE_201);
	}

	private static String validateResourceAPICommons(final ResourceResponse response, final int responseCode) {
		final Resource data = response.getData();
		assertThat(data).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(responseCode);
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
		final ResourceAttributes attributes = data.getAttributes();
		assertThat(attributes).isNotNull();
		return attributes.getPath();
	}

	public static void validateCopyResponse(final ResourceCopyMove response, final String copiedFolder) {
		final Resource data = response.getData();
		final LinkedTreeMap<String, String> meta = (LinkedTreeMap<String, String>) response.getMeta();
		assertThat(data).isNotNull();
		assertThat(meta).isNotNull();
		assertThat(data.getId()).isInstanceOf(Long.class);
		assertThat(data.getType()).isInstanceOf(Resource.TypeEnum.class);
		final ResourceAttributes attributes = data.getAttributes();
		assertThat(attributes).isNotNull();
		assertThat(meta.get(PATH)).isEqualTo(BASE_FOLDER_);
		assertThat(meta.get(DESTINATION_PATH)).startsWith(copiedFolder);
	}

	public static void validateWebhookLogs(final WebhooksActivityResponse response) {
		validateCommonWebhookLog(response);
	}

	public static void validateSessionLogs(final SessionActivityResponse response) {
		validateCommonSessionLog(response);
	}

	private static void validateAttribute(final SessionActivityResponse response,
										  final String attributeName, final Object... args) {
		final List<SessionActivityEntry> data = response.getData();
		for (final SessionActivityEntry entry : data) {
			final SessionActivityEntryAttributes attributes = entry.getAttributes();
			switch (attributeName) {
				case OFFSET_DATE:
					final String created = attributes.getCreated();
					final OffsetDateTime actual = OffsetDateTime.parse(created);
					assertThat(actual).isBetween((OffsetDateTime) args[_0], (OffsetDateTime) args[_1]);
					break;
				case USERNAME_ATTRIBUTE:
					final String real = attributes.getUsername();
					assertThat(real).isEqualTo((String) args[_0]);
					break;
				case FILENAME_ATTRIBUTE:
					final String real2 = attributes.getFileName();
					assertThat(real2).contains(BASE_FOLDER_);
					break;
				case OPS_TYPE:
					final String real3 = attributes.getOperation();
					assertThat(real3).isEqualTo((String) args[_0]);
					break;
				case ATTRIBUTE_NAME_IP:
					final String ipAddress = attributes.getIpAddress();
					assertThat(ipAddress).isEqualTo((String) args[_0]);
					break;
			}
		}
	}

	public static void validateDates(final SessionActivityResponse response, final OffsetDateTime start,
									 final OffsetDateTime end) {
		validateAttribute(response, OFFSET_DATE, start, end);
	}

	public static void validateIp(final SessionActivityResponse response, final String ip) {
		validateAttribute(response, ATTRIBUTE_NAME_IP, ip);
	}

	public static void validateUserName(final SessionActivityResponse response, final String username) {
		validateAttribute(response, USERNAME_ATTRIBUTE, username);
	}

	public static void validatePath(final SessionActivityResponse response) {
		validateAttribute(response, FILENAME_ATTRIBUTE);
	}

	public static void validateType(final SessionActivityResponse response, final String type) {
		validateAttribute(response, OPS_TYPE, type);
	}

	private static void validateCommonSessionLog(final SessionActivityResponse response) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final List<SessionActivityEntry> data = response.getData();
		for (final SessionActivityEntry entry : data) {
			assertThat(entry.getId()).isInstanceOf(Long.class);
			assertThat(entry.getType()).isInstanceOf(SessionActivityEntry.TypeEnum.class);
			assertThat(entry.getType().getValue()).isEqualTo(SESSION_ACTIVITY);
			final SessionActivityEntryAttributes attributes = entry.getAttributes();
			assertThat(attributes).isNotNull();
		}
	}

	private static void validateCommonWebhookLog(final WebhooksActivityResponse response) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final List<WebhooksActivityEntry> data = response.getData();
		for (final WebhooksActivityEntry entry : data) {
			assertThat(entry.getId()).isInstanceOf(Long.class);
			assertThat(entry.getType()).isInstanceOf(WebhooksActivityEntry.TypeEnum.class);
			assertThat(entry.getType().getValue()).isEqualTo(WEBHOOK_ACTIVITY);
			final WebhooksActivityEntryAttributes attributes = entry.getAttributes();
			assertThat(attributes).isNotNull();
		}
	}

	public static void validateEvent(final WebhooksActivityResponse response, final String event) {
		final List<WebhooksActivityEntry> data = response.getData();
		for (final WebhooksActivityEntry entry : data) {
			final WebhooksActivityEntryAttributes attributes = entry.getAttributes();
			final String real = attributes.getEvent();
			assertThat(real).isEqualTo(event);
		}
	}

	public static void validateStatusCode(final WebhooksActivityResponse response, final int statusCode) {
		final List<WebhooksActivityEntry> data = response.getData();
		for (final WebhooksActivityEntry entry : data) {
			final WebhooksActivityEntryAttributes attributes = entry.getAttributes();
			final int real = attributes.getStatus();
			assertThat(real).isEqualTo(statusCode);
		}
	}

	public static UserAttributes validateUserAndGetAttributes(final UserResponse response, final int status) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(status);
		final User data = response.getData();
		assertThat(data.getId()).isInstanceOf(Integer.class);
		assertThat(data.getType()).isEqualTo(USER);
		final UserAttributes attributes = data.getAttributes();
		assertThat(attributes).isNotNull();
		return attributes;
	}

	public static void validateUserAttributes(final UserAttributes userAttributes,
											  final AddUserRequestBody body, final boolean isAdmin) {
		assertThat(userAttributes.getUsername()).isEqualTo(body.getUsername());
		assertThat(userAttributes.getEmail()).isEqualTo(body.getEmail());
		assertThat(userAttributes.getTimeZone()).isEqualTo(LA_TIMEZONE);
		final UserPermissions permissions = userAttributes.getPermissions();
		if (isAdmin) {
			assertThat(userAttributes.getHomePath()).isEqualTo(PARENT_PATH);
			assertThat(userAttributes.getRole().getValue()).isEqualTo(AddUserRequestBody.RoleEnum.ADMIN.getValue());
			validatePermissions(permissions.isList(), permissions.isChangePassword(), permissions.isDeleteFormData(),
					permissions.isShare(), permissions.isViewFormData());
		} else {
			assertThat(userAttributes.getHomePath()).isEqualTo(BASE_FOLDER_);
			assertThat(userAttributes.getRole().getValue()).isEqualTo(AddUserRequestBody.RoleEnum.USER.getValue());
		}
		validatePermissions(permissions.isDelete(), permissions.isDownload(),
				permissions.isUpload(), permissions.isModify());
	}

	private static void validatePermissions(final boolean... permissions) {
		for (final boolean permission : permissions) {
			assertThat(permission).isTrue();
		}
	}

	public static void validateDeleteResponse(final EmptyResponse response) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
	}

	private static void validateUsersByAttribute(final UserCollectionResponse response, final String attributeName, final Object... args) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final List<User> users = response.getData();
		assertThat(users).isNotNull();
		for (final User user : users) {
			assertThat(user.getId()).isInstanceOf(Integer.class);
			assertThat(user.getType()).isEqualTo(USER);
			final UserAttributes attributes = user.getAttributes();
			assertThat(attributes).isNotNull();
			switch (attributeName) {
				case USERNAME_ATTRIBUTE:
					final String real = attributes.getUsername();
					assertThat(real).isEqualTo((String) args[_0]);
					break;
				case NICKNAME_ATTR:
					final String nickName = attributes.getNickname();
					assertThat(nickName).isEqualTo((String) args[_0]);
					break;
				case EMAIL_ATTR:
					final String email = attributes.getEmail();
					assertThat(email).isEqualTo((String) args[_0]);
					break;
				case EMAIL_ATTR_FALSE:
					final String email2 = attributes.getEmail();
					assertThat(email2).isNotEqualTo(args[_0]);
					break;
				case ROLE_ATTR:
					final UserAttributes.RoleEnum role = attributes.getRole();
					assertThat(role.getValue()).isEqualTo((String) args[_0]);
					break;
				case HOMEDIR_ATTR:
					final String homePath = attributes.getHomePath();
					assertThat(homePath).isEqualTo((String) args[_0]);
					break;
				default:
					break;
			}
		}
	}

	public static void validateListOfUsersByUsername(final UserCollectionResponse response, final String username) {
		validateUsersByAttribute(response, USERNAME, username);
	}

	public static void validateListOfUsersByNickname(final UserCollectionResponse response, final String nickname) {
		validateUsersByAttribute(response, NICKNAME_ATTR, nickname);
	}

	public static void validateListOfUsersByEmail(final UserCollectionResponse response, final String email) {
		validateUsersByAttribute(response, EMAIL_ATTR, email);
	}

	public static void validateListOfUsersNonEmptyInclude(final UserCollectionResponse response) {
		assertThat(response.getIncluded()).isNotEmpty();
	}

	public static void validateListOfUsersByEmailFalse(final UserCollectionResponse response, final String email) {
		validateUsersByAttribute(response, EMAIL_ATTR_FALSE, email);
	}

	public static void validateListOfUsersByRole(final UserCollectionResponse response, final String role) {
		validateUsersByAttribute(response, ROLE_ATTR, role);
	}

	public static void validateListOfUsersByStatus(final UserCollectionResponse response, final int status) {
		validateUsersByAttribute(response, STATUS_ATTR, status);
	}

	public static void validateListOfUsersByHomeDir(final UserCollectionResponse response, final String homeDir) {
		validateUsersByAttribute(response, HOMEDIR_ATTR, homeDir);
	}

	public static void validateListOfUsersDefault(final UserCollectionResponse response) {
		validateUsersByAttribute(response, EMPTY);
	}

	public static void validateDefaultNotification(final NotificationResponse response,
												   final AddNotificationRequestBody body, final boolean recipientCheck,
												   final boolean msgCheck) {
		validateDefaultNotification(response, body, recipientCheck, msgCheck, RESPONSE_CODE_201);
	}

	public static void validateDefaultNotification(final NotificationResponse response,
												   final AddNotificationRequestBody body, final boolean recipientCheck,
												   final boolean msgCheck, final int responseCode) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(responseCode);
		final Notification notification = response.getData();
		assertThat(notification.getId()).isInstanceOf(Integer.class);
		assertThat(notification.getType()).isEqualTo(NOTIFICATION);
		final NotificationAttributes attributes = notification.getAttributes();
		assertThat(attributes.getPath()).isEqualTo(body.getResource());
		assertThat(attributes.getType().getValue()).isEqualTo(body.getType().getValue());
		assertThat(attributes.getUsernames().size()).isEqualTo(body.getUsernames().size());
		assertThat(attributes.getUsernames().get(_0)).isEqualTo(body.getUsernames().get(_0));
		if (recipientCheck) {
			assertThat(attributes.getRecipients().get(_0).getEmail()).isEqualTo(body.getRecipients().get(_0));
		}
		if (msgCheck) {
			assertThat(attributes.getMessage()).isEqualTo(body.getMessage());
		}
		assertThat(attributes.getAction().getValue()).isEqualTo(body.getAction().getValue());
	}

	public static void validateDefaultNotification(final NotificationResponse response,
												   final AddNotificationRequestBody body, final boolean recipientCheck) {
		validateDefaultNotification(response, body, recipientCheck, false);
	}

	public static void validateUpdatedActionNotification(final NotificationResponse response, final String action) {
		validateUpdatedNotificationAttribute(response, ACTION_ATTRIBUTE, action);
	}

	public static void validateUpdatedUsernamesNotification(final NotificationResponse response, final String username) {
		validateUpdatedNotificationAttribute(response, USERNAME_ATTRIBUTE, username);
	}

	public static void validateUpdatedSendEmailNotification(final NotificationResponse response, final boolean newValue) {
		validateUpdatedNotificationAttribute(response, EMAIL_ATTR, newValue);
	}

	public static void validateUpdatedRecipientsNotification(final NotificationResponse response, final String newValue) {
		validateUpdatedNotificationAttribute(response, RECIPIENT_ATTR, newValue);
	}

	public static void validateUpdatedMsgNotification(final NotificationResponse response, final String newValue) {
		validateUpdatedNotificationAttribute(response, MSG_ATTR, newValue);
	}

	public static void validateUpdatedNotificationAttribute(final NotificationResponse response,
															final String attributeName, final Object... args) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final Notification notification = response.getData();
		assertThat(notification.getId()).isInstanceOf(Integer.class);
		assertThat(notification.getType()).isEqualTo(NOTIFICATION);
		final NotificationAttributes attributes = notification.getAttributes();
		switch (attributeName) {
			case ACTION_ATTRIBUTE:
				final String real = attributes.getAction().getValue();
				assertThat(real).isEqualTo((String) args[_0]);
				break;
			case USERNAME_ATTRIBUTE:
				final String realUserName = attributes.getUsernames().get(_0);
				assertThat(realUserName).isEqualTo((String) args[_0]);
				break;
			case EMAIL_ATTR:
				final boolean isSendEmail = attributes.isSendEmail();
				assertThat(isSendEmail).isEqualTo((boolean) args[_0]);
				break;
			case RECIPIENT_ATTR:
				final String realRecipient = attributes.getRecipients().get(_0).getEmail();
				assertThat(realRecipient).isEqualTo((String) args[_0]);
				break;
			case MSG_ATTR:
				final String msg = attributes.getMessage();
				assertThat(msg).isEqualTo((String) args[_0]);
				break;
			default:
				break;
		}
	}

	private static void validateNotificationsByAttribute(final NotificationCollectionResponse response,
														 final String attributeName, final Object... args) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final List<Notification> notifications = response.getData();
		assertThat(notifications).isNotNull();
		for (final Notification notification : notifications) {
			assertThat(notification.getId()).isInstanceOf(Integer.class);
			assertThat(notification.getType()).isEqualTo(NOTIFICATION);
			final NotificationAttributes attributes = notification.getAttributes();
			assertThat(attributes).isNotNull();
			switch (attributeName) {
				case TYPE_ATTR:
					final String real = attributes.getType().getValue();
					assertThat(real).isEqualTo((String) args[_0]);
					break;
				case ACTION_ATTRIBUTE:
					final String action = attributes.getAction().getValue();
					assertThat(action).isEqualTo((String) args[_0]);
					break;
				default:
					break;
			}
		}
	}

	public static void validateListNotificationByType(final NotificationCollectionResponse response, final String newValue) {
		validateNotificationsByAttribute(response, TYPE_ATTR, newValue);
	}

	public static void validateListNotificationByAction(final NotificationCollectionResponse response, final String newValue) {
		validateNotificationsByAttribute(response, ACTION_ATTRIBUTE, newValue);
	}

	public static void validateDefaultShares(final ShareResponse response, final AddShareRequestBody body,
											 final int responseCode) {
		validateShares(response, body, responseCode, body.getType().getValue());
	}

	public static void validateShares(final ShareResponse response, final AddShareRequestBody body,
									  final int responseCode, final String type) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(responseCode);
		final Share share = response.getData();
		assertThat(share.getId()).isInstanceOf(Integer.class);
		assertThat(share.getType().getValue()).isEqualTo(SHARE);
		final ShareAttributes attributes = share.getAttributes();
		assertThat(attributes.getName()).isEqualTo(body.getName());
		assertThat(attributes.getType().getValue()).isEqualTo(type);
		assertThat(attributes.getPaths()).containsAll(body.getResources());
	}

	public static ShareAttributes validateAndGetSharesAttributes(final ShareResponse response, final int responseCode) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(responseCode);
		final Share share = response.getData();
		assertThat(share.getId()).isInstanceOf(Integer.class);
		assertThat(share.getType().getValue()).isEqualTo(SHARE);
		return share.getAttributes();
	}

	public static void validateShares(final ShareResponse response, final AddShareRequestBody body,
									  final int responseCode, final OffsetDateTime expiration) throws ParseException {
		validateShares(response, body, responseCode, AddShareRequestBody.TypeEnum.SHARED_FOLDER.getValue());
		final Share share = response.getData();
		final ShareAttributes attributes = share.getAttributes();
		final Date parse = dateTimeFormatter2.parse(attributes.getExpiration());
		final Date parse1 = dateTimeFormatter2.parse(expiration.toString());
		assertThat(parse).isEqualToIgnoringMillis(parse1);
	}

	public static void validateShares(final ShareResponse response, final AddShareRequestBody body,
									  final int responseCode, final SharesRecipients sharesRecipients) {
		validateShares(response, body, responseCode, AddShareRequestBody.TypeEnum.SHARED_FOLDER.getValue());
		final Share share = response.getData();
		final ShareAttributes attributes = share.getAttributes();
		final List<ShareRecipient> recipients = attributes.getRecipients();
		assertThat(recipients.get(_0).getEmail()).isEqualTo(sharesRecipients.getEmail());
		assertThat(recipients.get(_0).getType().getValue()).isEqualTo(sharesRecipients.getType());
	}

	public static void validateShares(final ShareResponse response, final AddShareRequestBody body,
									  final int responseCode, final boolean hasNotification) {
		validateShares(response, body, responseCode, AddShareRequestBody.TypeEnum.SHARED_FOLDER.getValue());
		final Share share = response.getData();
		final ShareAttributes attributes = share.getAttributes();
		assertThat(attributes.isHasNotification()).isEqualTo(hasNotification);
	}

	public static void validateShares(final boolean isPublic, final ShareResponse response, final AddShareRequestBody body,
									  final int responseCode) {
		validateShares(response, body, responseCode, AddShareRequestBody.TypeEnum.SHARED_FOLDER.getValue());
		final Share share = response.getData();
		final ShareAttributes attributes = share.getAttributes();
		assertThat(attributes.isPublic()).isEqualTo(isPublic);
	}

	public static void validateShares(final String msg, final ShareResponse response, final AddShareRequestBody body,
									  final int responseCode) {
		validateShares(response, body, responseCode, AddShareRequestBody.TypeEnum.SHARED_FOLDER.getValue());
		final Share share = response.getData();
		final ShareAttributes attributes = share.getAttributes();
		final List<ShareMessage> messages = attributes.getMessages();
		assertThat(messages.size()).isEqualTo(_1);
		assertThat(messages.get(_0).getBody()).isEqualTo(msg);
	}

	public static void validateShares(final ShareResponse response, final AddShareRequestBody body,
									  final int responseCode, final List<String> emails) {
		validateShares(response, body, responseCode, AddShareRequestBody.TypeEnum.SHARED_FOLDER.getValue());
		final Share share = response.getData();
		final ShareAttributes attributes = share.getAttributes();
		/*final List<ShareMessage> messages = attributes.get
		assertThat(messages.size()).isEqualTo(_1);
		assertThat(messages.get(_0).getAttributes().getBody()).isEqualTo(msg);*/
	}

	public static void validateSharesWithInvite(final ShareResponse response, final AddShareRequestBody body,
												final int responseCode, final String inviteEmail,
												final String messageSubject, final String messageBody) {
		validateShares(response, body, responseCode, AddShareRequestBody.TypeEnum.SHARED_FOLDER.getValue());
		final Share share = response.getData();
		final ShareAttributes attributes = share.getAttributes();
		final List<ShareMessage> messages = attributes.getMessages();
		assertThat(messages.size()).isEqualTo(_1);
		assertThat(messages.get(_0).getBody()).isEqualTo(messageBody);
		assertThat(messages.get(_0).getSubject()).isEqualTo(messageSubject);
		final List<ShareRecipient> recipients = attributes.getRecipients();
		assertThat(recipients.get(_0).getEmail()).isEqualTo(inviteEmail);
		assertThat(recipients.get(_0).getType().getValue()).isEqualTo(DIRECT_EMAIL);
	}

	public static void validateSharesWithFileDropFlag(final ShareResponse response, final AddShareRequestBody body,
													  final int responseCode) {
		validateShares(response, body, responseCode, AddShareRequestBody.TypeEnum.RECEIVE.getValue());
		final Share share = response.getData();
		final ShareAttributes attributes = share.getAttributes();
		assertThat(attributes.isFileDropCreateFolders()).isEqualTo(true);
	}

	public static void validateListSharesByType(final ShareCollectionResponse response, final String newValue) {
		validateSharesByAttribute(response, TYPE_ATTR, newValue);
	}

	public static void validateListSharesByScope(final ShareCollectionResponse response, final String newValue) {
		validateSharesByAttribute(response, SCOPE_ATTR, newValue);
	}

	public static void validateListSharesByName(final ShareCollectionResponse response, final String newValue) {
		validateSharesByAttribute(response, NAME, newValue);
	}

	public static void validateListSharesByRecipients(final ShareCollectionResponse response, final String newValue) {
		validateSharesByAttribute(response, RECIPIENT_ATTR, newValue);
	}

	public static void validateListSharesByMsg(final ShareCollectionResponse response, final String newValue) {
		validateSharesByAttribute(response, MSG_ATTR, newValue);
	}

	public static void validateListSharesByUsername(final ShareCollectionResponse response, final String newValue) {
		validateSharesByAttribute(response, USERNAME_ATTRIBUTE, newValue);
	}

	public static void validateListSharesBySearch(final ShareCollectionResponse response, final String newValue) {
		validateSharesByAttribute(response, SEARCH_ATTRIBUTE, newValue);
	}

	private static void validateSharesByAttribute(final ShareCollectionResponse response,
												  final String attributeName, final Object... args) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(RESPONSE_CODE_200);
		final List<Share> shares = response.getData();
		assertThat(shares).isNotNull();
		for (final Share share : shares) {
			assertThat(share.getId()).isInstanceOf(Integer.class);
			assertThat(share.getType().getValue()).isEqualTo(SHARE);
			final ShareAttributes attributes = share.getAttributes();
			assertThat(attributes).isNotNull();
			switch (attributeName) {
				case TYPE_ATTR:
					final String real = attributes.getType().getValue();
					assertThat(real).isEqualTo((String) args[_0]);
					break;
				case SCOPE_ATTR:
					//TODO: check
					break;
				case NAME:
					final String name = attributes.getName();
					assertThat(name).isEqualTo((String) args[_0]);
					break;
				case MSG_ATTR:
					final List<ShareMessage> messages = attributes.getMessages();
					for (final ShareMessage message : messages) {
						assertThat(message.getBody()).isEqualTo((String) args[_0]);
					}
					break;
				case RECIPIENT_ATTR:
					final List<ShareRecipient> recipients = attributes.getRecipients();
					for (final ShareRecipient recipient : recipients) {
						assertThat(recipient.getEmail()).isEqualTo((String) args[_0]);
					}
					break;
				case USERNAME_ATTRIBUTE:
					break;
				case SEARCH_ATTRIBUTE:

				default:
					break;
			}
		}
	}

	public static void validateDefaultEmailList(final EmailListResponse response, final AddEmailListRequestBody body) {
		validateDefaultEmailList(response, body, RESPONSE_CODE_201);
	}

	public static void validateDefaultEmailList(final EmailListResponse response,
												final AddEmailListRequestBody body, final int responseCode) {
		assertThat(response).isNotNull();
		assertThat(response.getResponseStatus()).isEqualTo(responseCode);
		final EmailList emailList = response.getData();
		validateEachEmailGroup(body, emailList);
	}

	public static void validateEachEmailGroup(final AddEmailListRequestBody body, final EmailList emailList) {
		assertThat(emailList.getId()).isInstanceOf(Integer.class);
		assertThat(emailList.getType()).isEqualTo(EMAIL_LIST);
		final EmailListAttributes attributes = emailList.getAttributes();
		assertThat(attributes.getName()).isEqualTo(body.getName());
		assertThat(attributes.getEmails()).containsAll(body.getEmails());
	}


}
