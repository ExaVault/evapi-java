/**
 * EvapiTest.java
 * 
 * Unit tests for the Evapi client.
 * 
 * @author Dylan Gleason, support -at- exavault -dot- com
 * @package test.java
 */

package test.java;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import main.java.com.exavault.client.*;
import main.java.com.exavault.evapi.model.*;
import main.java.com.exavault.evapi.api.V1Api;

public class EvapiTest {
	
    // 
    // NOTE: the below constants are necessary for successful completion of the
    // unit tests. Please replace the fields where applicable to data specific
    // to your account.
    //
	
    private static final String USERNAME      = "yourusername";
    private static final String PASSWORD      = "yourpassword";
    private static final String API_KEY       = "yourapp-XXXXXXXXXXXXXXXXXXXX";
    private static final String ROOT_DIR      = "/";
    private static final String FOLDER        = "evapi-java-tests";
    private static final String SUBFOLDER     = "subfolder";
    private static final String RENAME_FOLDER = "test-rename-follder";
    private static final String TEST_USER     = "evapi-java-tests";
    private static final String TEST_EMAIL    = "youremail@yourdomain.com";
    private static final String DOWNLOAD_FILE = "/test-files/file-tree.txt";
    private static final String PREVIEW       = "/test-files/preview/images.jpg";
    private static final String UPLOAD_FILE   = "test-filename.txt";
    private static final String PERMISSIONS   = "upload,download,modify,delete";
    private static final String USER_ROLE     = "user";
    private static final String TIMEZONE      = "America/Los_Angeles";
	
    private static V1Api api = null;
    private static String accessToken = null;
	
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        api = new V1Api();
        api.getInvoker().addDefaultHeader("api_key", API_KEY);
        authenticateUser();
    }
	
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (api != null && accessToken != null) {
            api.logoutUser(accessToken);
        }
    }
	
    /**
     * Authenticate the user into the API.
     * 
     * @throws Exception
     */
    private static void authenticateUser() throws Exception {
        try {
            AuthResponse response = api.authenticateUser(USERNAME, PASSWORD);
            if (response.getSuccess() != 1) {
                throw new Exception();
            }
            accessToken = response.getResults().getAccessToken();
        } catch (ApiException e) {
            throw new Exception(e);
        }
    }
	
    /**
     * Create a test folder.
     * 
     * @param  String testFolder - the test folder to create
     * @return Response
     * @throws Exception
     */
    private Response createTestFolder(String testFolder) throws Exception {
        try {
            Response response = api.createFolder(accessToken, testFolder, ROOT_DIR);
            if (response.getSuccess() != 1) {
                throw new Exception();
            }
            return response;
        } catch (ApiException e) {
            throw new Exception(e);
        }
    }
	
    /**
     * Create a test user.
     * 
     * @return Response
     * @throws Exception
     */
    private Response createTestUser() throws Exception {
        try {
            Response response = api.createUser(accessToken, TEST_USER, ROOT_DIR, TEST_EMAIL, PASSWORD, USER_ROLE, PERMISSIONS, null, null, false, false, TIMEZONE);
            return response;
        } catch (ApiException e) {
            throw new Exception (e);
        }
    }
	
    /**
     * Delete the test folder.
     * 
     * @param  String folder - the test folder to delete
     * @return FilesResponse
     * @throws Exception
     */
    private DeletedResourcesResponse deleteTestFolder(String folder) throws Exception {
        try {
            List<String> paths = new ArrayList<String>();
            paths.add(folder);
            DeletedResourcesResponse response = api.deleteResources(accessToken, paths);
            return response;
        } catch (ApiException e) {
            throw new Exception (e);
        }
    }
	
    /**
     * Delete the test user
     * 
     * @return Response
     * @throws Exception
     */
    private Response deleteTestUser() throws Exception {
        try {
            Response response = api.deleteUser(accessToken, TEST_USER);
            return response;
        } catch (ApiException e) {
            throw new Exception (e);
        }
    }
	
    /**
     * Run assertions on a User object
     * 
     * @param User user - the user object to test
     */
    private void runUserAssertions(User user) {
        assertNotNull(user);
        assertNotNull(user.getGid());
        assertNotNull(user.getStatus());
        assertNotNull(user.getCreated());
        assertNotNull(user.getModified());
        assertNotNull(user.getAccessTimestamp());
        assertNotNull(user.getId());
        assertNotNull(user.getOwningAccountId());
        assertNotNull(user.getUsername());
        assertNotNull(user.getEmail());
        assertNotNull(user.getHomeDir());
        assertNotNull(user.getDownload());
        assertNotNull(user.getUpload());
        assertNotNull(user.getModify());
        assertNotNull(user.getDelete());
        assertNotNull(user.getList());
        assertNotNull(user.getChangePassword());
        assertNotNull(user.getShare());
        assertNotNull(user.getNotification());
        assertNotNull(user.getRole());
        assertNotNull(user.getTimeZone());
        assertThat(user.getGid(), instanceOf(Integer.class));
        assertThat(user.getStatus(), instanceOf(Integer.class));
        assertThat(user.getCreated(), instanceOf(String.class));
        assertThat(user.getModified(), instanceOf(String.class));
        assertThat(user.getAccessTimestamp(), instanceOf(String.class));
        assertThat(user.getId(), instanceOf(Integer.class));
        assertThat(user.getOwningAccountId(), instanceOf(Integer.class));
        assertThat(user.getUsername(), instanceOf(String.class));
        assertThat(user.getEmail(), instanceOf(String.class));
        assertThat(user.getHomeDir(), instanceOf(String.class));
        assertThat(user.getDownload(), instanceOf(Boolean.class));
        assertThat(user.getUpload(), instanceOf(Boolean.class));
        assertThat(user.getModify(), instanceOf(Boolean.class));
        assertThat(user.getDelete(), instanceOf(Boolean.class));
        assertThat(user.getList(), instanceOf(Boolean.class));
        assertThat(user.getChangePassword(), instanceOf(Boolean.class));
        assertThat(user.getShare(), instanceOf(Boolean.class));
        assertThat(user.getNotification(), instanceOf(Boolean.class));
        assertThat(user.getRole(), instanceOf(String.class));
        assertThat(user.getTimeZone(), instanceOf(String.class));
    }
	
    /**
     * Run assertions on a ResourceProperty instance.
     * 
     * @param ResourceProperty resource - the resource to test
     */
    private void runResourcePropertyAssertions(ResourceProperty resource) {
        assertNotNull(resource);
        assertThat(resource.getType(), instanceOf(String.class));
        assertThat(resource.getShares(), instanceOf(List.class));
        assertThat(resource.getUploadDate(), instanceOf(String.class));
        assertThat(resource.getPath(), instanceOf(String.class));
        assertThat(resource.getSize(), instanceOf(Long.class));
        String createdBy = resource.getCreatedBy();
        if (createdBy != null) {
            assertThat(createdBy, instanceOf(String.class));
        }
        String parent = resource.getParent();
        if (parent != null) {
            assertThat(parent, instanceOf(String.class));
        }
    }
	
    /**
     * Run Modified resource assertions.
     * 
     * @param ModifiedResourcesResponse response - the response to test
     */
    private void runModifiedResourceAssertions(ModifiedResourcesResponse response) {
		
        assertThat(response.getSuccess(), instanceOf(Integer.class));
        assertThat(response.getSuccess(), equalTo(1));
        assertNull(response.getError());
		
        List<ModifiedResource> results = response.getResults();
        ModifiedResource firstResult = results.get(0);
		
        assertNotNull(results);
        assertThat(firstResult.getFile(), instanceOf(String.class));
        assertThat(firstResult.getDestination(), instanceOf(String.class));
        assertThat(firstResult.getSize(), instanceOf(Long.class));
        assertThat(firstResult.getSuccess(), instanceOf(Integer.class));
    }

    @Test
    public void testAuthenticateAndLogoutUser() {
		
        boolean error = false;
        Auth authResults = null;
        AuthResponse authResponse = null;
        Response logoutResponse = null;
		
        try {
            // create a test user, authenticate and logout and delete test user
            createTestUser();
            authResponse = api.authenticateUser(TEST_USER, PASSWORD);
            logoutResponse = api.logoutUser(authResponse.getResults().getAccessToken());
            deleteTestUser();
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(authResponse);
		
        assertThat(authResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(authResponse.getSuccess(), equalTo(1));
        assertNull(authResponse.getError());
		
        authResults = authResponse.getResults();
        assertNotNull(authResults);
        assertThat(authResults, instanceOf(Auth.class));
        assertThat(authResults.getUsername(), instanceOf(String.class));
        assertThat(authResults.getAccessToken(), instanceOf(String.class));
        assertThat(authResults.getMode(), instanceOf(Integer.class));
        assertThat(authResults.getClientIp(), instanceOf(String.class));
		
        assertThat(logoutResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(logoutResponse.getSuccess(), equalTo(1));
        assertNull(logoutResponse.getError());
    }
	
    @Test
    public void testCheckFilesExists() {

        boolean error = false;
        Response response = null;
        ExistingResourcesResponse existResponse = null;
		
        try {
            // create a test folder
            response = createTestFolder(FOLDER);
			
            // add the files/folders to check
            List<String> files = new ArrayList<String>();
            files.add(ROOT_DIR);
            files.add(FOLDER);
			
            existResponse = api.checkFilesExist(accessToken, files);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(response);
        assertNotNull(existResponse);
		
        assertThat(existResponse, instanceOf(ExistingResourcesResponse.class));
		
        List<ExistingResource> existingResources = existResponse.getResults();
		
        assertNotNull(existingResources);
		
        // clean up the test directory
        try {
            deleteTestFolder(FOLDER);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
    }
	
    @Test
    public void testCopyResources() {
		
        boolean error = false;
        ModifiedResourcesResponse copied = null;
		
        try {			
            // create two folders
            Response folder1 = createTestFolder(FOLDER);
            Response folder2 = createTestFolder(SUBFOLDER);
			
            if (folder1.getSuccess() != 1 || folder2.getSuccess() != 1) {
                throw new Exception();
            }
			
            // copy the subfolder to the folder
            List<String> resources = new ArrayList<String>();
            resources.add(SUBFOLDER);
            copied = api.copyResources(accessToken, resources, FOLDER);
			
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(copied);
		
        runModifiedResourceAssertions(copied);
		
        try {
            deleteTestFolder(FOLDER);
            deleteTestFolder(SUBFOLDER);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
    }
	
    @Test
    public void testCreateFolder() {
		
        boolean error = false;
        Response response = null;
		
        try {
            response = createTestFolder(FOLDER);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(response);
		
        assertThat(response.getSuccess(), instanceOf(Integer.class));
        assertThat(response.getSuccess(), equalTo(1));
        assertNull(response.getError());
		
        try {
            deleteTestFolder(FOLDER);
        } catch (Exception e) {
            error = true;
        }

        assertFalse(error);
    }
	
    @Test
    public void testCreateUser() {
		
        boolean error = false;
        Response response = null;
		
        try {
            response = createTestUser();
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(response);
		
        assertThat(response.getSuccess(), instanceOf(Integer.class));
        assertThat(response.getSuccess(), equalTo(1));
        assertNull(response.getError());
		
        // delete the test user
        try {
            deleteTestUser();
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
    }
	
    @Test 
    public void testDeleteResources() {
		
        boolean error = false;
        Response createResponse = null;
        DeletedResourcesResponse deleteResponse = null;
		
        try {			
            // create the folder, then delete it
            createResponse = createTestFolder(FOLDER);
            deleteResponse = deleteTestFolder(FOLDER);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(createResponse);
        assertNotNull(deleteResponse);
		
        assertThat(deleteResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(deleteResponse.getSuccess(), equalTo(1));
        assertNull(deleteResponse.getError());
		
        List<DeletedResource> filesResult = deleteResponse.getResults();
        DeletedResource firstFile = filesResult.get(0);
		
        assertThat(firstFile.getFile(), instanceOf(String.class));
        assertThat(firstFile.getSuccess(), instanceOf(Integer.class));
        assertThat(firstFile.getSize(), instanceOf(Long.class));
    }
	
    @Test
    public void testDeleteUser() {
		
        boolean error = false;
        Response createUserResponse = null;
        Response deleteUserResponse = null;
		
        try {
            // create the user, then delete the user
            createUserResponse = createTestUser();
            deleteUserResponse = deleteTestUser();
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(createUserResponse);
        assertNotNull(deleteUserResponse);
		
        assertThat(deleteUserResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(deleteUserResponse.getSuccess(), equalTo(1));
        assertNull(deleteUserResponse.getError());
    }
	
    @Test
    public void testGetAccount() {
		
        boolean error = false;
        AccountResponse accountResponse = null;
		
        try {
            accountResponse = api.getAccount(accessToken);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(accountResponse);
		
        assertThat(accountResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(accountResponse.getSuccess(), equalTo(1));
        assertNull(accountResponse.getError());
		
        Account account = accountResponse.getResults();
		
        assertNotNull(account);	
        assertNotNull(account.getId());
        assertNotNull(account.getUsername());
        assertNotNull(account.getMaxUsers());
        assertNotNull(account.getUserCount());
        assertNotNull(account.getMasterAccount());
        assertNotNull(account.getStatus());
        assertNotNull(account.getBranding());
        assertNotNull(account.getCustomDomain());
        assertNotNull(account.getPlanCode());
        assertNotNull(account.getDiskQuotaLimit());
        assertNotNull(account.getBandwidthQuotaLimit());
        assertNotNull(account.getDiskQuotaUsed());
        assertNotNull(account.getBandwidthQuotaUsed());
        assertNotNull(account.getQuotaNoticeEnabled());
        assertNotNull(account.getQuotaNoticeThreshold());
        assertNotNull(account.getRedirect());
        assertNotNull(account.getSecureOnly());
        assertNotNull(account.getComplexPasswords());
        assertNotNull(account.getShowReferralLinks());
        assertNotNull(account.getFreeTrial());
        assertNotNull(account.getClientId());
        assertNotNull(account.getCreated());
        assertNotNull(account.getModified());
        assertThat(account.getId(), instanceOf(Integer.class));
        assertThat(account.getUsername(), instanceOf(String.class));
        assertThat(account.getMaxUsers(), instanceOf(Integer.class));
        assertThat(account.getUserCount(), instanceOf(Integer.class));
        assertThat(account.getMasterAccount(), instanceOf(User.class));
        assertThat(account.getStatus(), instanceOf(Integer.class));
        assertThat(account.getBranding(), instanceOf(Boolean.class));
        assertThat(account.getCustomDomain(), instanceOf(Boolean.class));
        assertThat(account.getPlanCode(), instanceOf(String.class));
        assertThat(account.getDiskQuotaLimit(), instanceOf(Long.class));
        assertThat(account.getBandwidthQuotaLimit(), instanceOf(Long.class));
        assertThat(account.getDiskQuotaUsed(), instanceOf(Long.class));
        assertThat(account.getBandwidthQuotaUsed(), instanceOf(Long.class));
        assertThat(account.getQuotaNoticeEnabled(), instanceOf(Integer.class));
        assertThat(account.getQuotaNoticeThreshold(), instanceOf(Integer.class));
        assertThat(account.getRedirect(), instanceOf(String.class));
        assertThat(account.getSecureOnly(), instanceOf(Boolean.class));
        assertThat(account.getComplexPasswords(), instanceOf(Boolean.class));
        assertThat(account.getShowReferralLinks(), instanceOf(Boolean.class));
        assertThat(account.getFreeTrial(), instanceOf(Boolean.class));
        assertThat(account.getClientId(), instanceOf(Integer.class));
        assertThat(account.getCreated(), instanceOf(String.class));
        assertThat(account.getModified(), instanceOf(String.class));
		
        runUserAssertions(account.getMasterAccount());
    }
	
    @Test
    public void testGetCurrentUser() {
		
        boolean error = false;
        UserResponse userResponse = null;
		
        try {
            // authenticate and get the current user
            userResponse = api.getCurrentUser(accessToken);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(userResponse);
		
        assertThat(userResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(userResponse.getSuccess(), equalTo(1));
        assertNull(userResponse.getError());
		
        runUserAssertions(userResponse.getResults());
    }
	
    @Test
    public void testGetDownloadFileUrl() {
		
        boolean error = false;
        UrlResponse urlResponse = null;
		
        try {
            urlResponse = api.getUploadFileUrl(accessToken, 1024L, UPLOAD_FILE, true, true);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(urlResponse);
		
        assertThat(urlResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(urlResponse.getSuccess(), equalTo(1));
        assertNull(urlResponse.getError());
		
        Url results = urlResponse.getResults();
        assertThat(results.getUrl(), instanceOf(String.class));
    }
	
    @Test
    public void testGetUploadFileUrl() {
		
        boolean error = false;
        UrlResponse urlResponse = null;
		
        try {
            urlResponse = api.getDownloadFileUrl(accessToken, DOWNLOAD_FILE, ROOT_DIR);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(urlResponse);
		
        assertThat(urlResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(urlResponse.getSuccess(), equalTo(1));
        assertNull(urlResponse.getError());
		
        Url results = urlResponse.getResults();
        assertThat(results.getUrl(), instanceOf(String.class));
    }
	
    @Test 
    public void testGetFileActivityLogs() {
		
        boolean error = false;
        LogResponse logResponse = null;
		
        try {
            logResponse = api.getFileActivityLogs(accessToken, null, null, null, 0, null, null);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(logResponse);
		
        assertThat(logResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(logResponse.getSuccess(), equalTo(1));
        assertNull(logResponse.getError());
		
        List<LogEntry> logs = logResponse.getResults();
		
        for (LogEntry log : logs) {
            assertThat(log, instanceOf(LogEntry.class));
            assertThat(log.getId(), instanceOf(Integer.class));
            assertThat(log.getFileName(), instanceOf(String.class));
            assertThat(log.getFileSource(), instanceOf(String.class));
            assertThat(log.getOperation(), instanceOf(String.class));
            assertThat(log.getCreated(), instanceOf(String.class));
            assertThat(log.getUsername(), instanceOf(String.class));
            assertThat(log.getSessionId(), instanceOf(String.class));
            assertThat(log.getIpAddress(), instanceOf(String.class));
            assertThat(log.getProtocol(), instanceOf(String.class));
            assertThat(log.getStatus(), instanceOf(String.class));
        }
    }
	
    @Test
    public void testGetFolders() {
		
        boolean error = false;
        ResourcePropertiesResponse resourcesResponse = null;
		
        try {
            resourcesResponse = api.getFolders(accessToken, ROOT_DIR);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(resourcesResponse);
		
        assertThat(resourcesResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(resourcesResponse.getSuccess(), equalTo(1));
        assertNull(resourcesResponse.getError());
		
        List<ResourceProperty> properties = resourcesResponse.getResults();
		
        for (ResourceProperty property : properties) {
            runResourcePropertyAssertions(property);
        }
    }
	
    @Test
    public void testGetResourceList() {
		
        boolean error = false;
        ResourceResponse resourceResponse = null;
		
        try {
            resourceResponse = api.getResourceList(accessToken, ROOT_DIR, "sort_files_type", "asc", 1, 25, false, null);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(resourceResponse);
		
        assertThat(resourceResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(resourceResponse.getSuccess(), equalTo(1));
        assertNull(resourceResponse.getError());
		
        Resource resource = resourceResponse.getResults();
        assertNotNull(resource);
        assertThat(resource, instanceOf(Resource.class));
        assertThat(resource.getTotalFiles(), instanceOf(Integer.class));
		
        List<ResourceProperty> resourceProperties = resource.getResources();
        assertThat(resourceProperties, instanceOf(List.class));
		
        for (ResourceProperty resourceProperty : resourceProperties) {
            runResourcePropertyAssertions(resourceProperty);
        }
    }
	
    @Test
    public void testGetResourceProperties() {
		
        boolean error = false;
        ResourcePropertiesResponse resourceResponse = null;
		
        try {
            List<String> paths = new ArrayList<String>();
            paths.add(ROOT_DIR);
            resourceResponse = api.getResourceProperties(accessToken, paths);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(resourceResponse);
		
        assertThat(resourceResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(resourceResponse.getSuccess(), equalTo(1));
        assertNull(resourceResponse.getError());
		
        List<ResourceProperty> resourceProperties = resourceResponse.getResults();
        assertNotNull(resourceProperties);
        assertThat(resourceProperties, instanceOf(List.class));
		
        for (ResourceProperty resourceProperty : resourceProperties) {
            runResourcePropertyAssertions(resourceProperty);
        }
    }
	
    @Test
    public void testGetUser() {
		
        boolean error = false;
        UserResponse userResponse = null;
		
        try {
            userResponse = api.getUser(accessToken, USERNAME);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(userResponse);
		
        assertThat(userResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(userResponse.getSuccess(), equalTo(1));
        assertNull(userResponse.getError());
		
        User user = userResponse.getResults();
        runUserAssertions(user);
    }
	
    @Test
    public void testGetUsers() {
		
        boolean error = false;
        UsersResponse usersResponse = null;
		
        try {
            usersResponse = api.getUsers(accessToken, "sort_users_username", "asc");
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(usersResponse);
		
        assertThat(usersResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(usersResponse.getSuccess(), equalTo(1));
        assertNull(usersResponse.getError());
		
        List<User> users = usersResponse.getResults();
        for (User user : users) {
            runUserAssertions(user);
        }
    }
	
    @Test
    public void testMoveResources() {
		
        boolean error = false;
        ModifiedResourcesResponse moved = null;
		
        try {			
            // create two folders
            Response folder1 = createTestFolder(FOLDER);
            Response folder2 = createTestFolder(SUBFOLDER);
			
            if (folder1.getSuccess() != 1 || folder2.getSuccess() != 1) {
                throw new Exception();
            }
			
            // move the subfolder to the folder
            List<String> resources = new ArrayList<String>();
            resources.add(SUBFOLDER);
            moved = api.moveResources(accessToken, resources, FOLDER);
			
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(moved);
		
        runModifiedResourceAssertions(moved);
		
        try {
            deleteTestFolder(FOLDER);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
    }
	
    @Test
    public void testPreviewFile() {
		
        boolean error = false;
        PreviewFileResponse previewResponse = null;
		
        try {
            previewResponse = api.previewFile(accessToken, PREVIEW, "small", null, null, null);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(previewResponse);
		
        assertThat(previewResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(previewResponse.getSuccess(), equalTo(1));
        assertNull(previewResponse.getError());
		
        PreviewFile preview = previewResponse.getResults();
		
        assertNotNull(preview);
        assertThat(preview.getSize(), instanceOf(Long.class));
        assertThat(preview.getImage(), instanceOf(String.class));
        assertThat(preview.getImageId(), instanceOf(String.class));
    }
	
    @Test
    public void testRenameResource() {
		
        boolean error = false;
        Response renamedResourceResponse = null;
		
        try {
            // authenticate and create a test folder
            renamedResourceResponse = api.createFolder(accessToken, RENAME_FOLDER, ROOT_DIR);
			
            // rename the folder
            String filePath = ROOT_DIR + RENAME_FOLDER;
            String newName = RENAME_FOLDER + "-changed";
            renamedResourceResponse = api.renameResource(accessToken, filePath, newName);
			
            // cleanup the test folder
            deleteTestFolder(newName);
			
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(renamedResourceResponse);
		
        assertThat(renamedResourceResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(renamedResourceResponse.getSuccess(), equalTo(1));
        assertNull(renamedResourceResponse.getError());
    }
	
    @Test
    public void testUpdateUser() {
		
        boolean error = false;
        Response updatedUserResponse = null;
		
        try {
            // create a new test user
            createTestUser();
            UserResponse userResponse = api.getUser(accessToken, TEST_USER);
			
            // now update the user with a new username
            Integer userId = userResponse.getResults().getId();
            String username = userResponse.getResults().getUsername() + "-changed";
            updatedUserResponse = api.updateUser(accessToken, userId, username, null, null, null, null, null, null, null, null);
			
            api.deleteUser(accessToken, username);
			
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(updatedUserResponse);
		
        assertThat(updatedUserResponse.getSuccess(), instanceOf(Integer.class));
        assertThat(updatedUserResponse.getSuccess(), equalTo(1));
        assertNull(updatedUserResponse.getError());
    }
	
    @Test
    public void testUserAvailable() {
		
        boolean error = false;
        AvailableUserResponse response = null;
		
        try {
            response = api.userAvailable(accessToken, TEST_USER);
        } catch (Exception e) {
            error = true;
        }
		
        assertFalse(error);
        assertNotNull(response);
		
        assertThat(response.getSuccess(), instanceOf(Integer.class));
        assertThat(response.getSuccess(), equalTo(1));
        assertNull(response.getError());
		
        AvailableUser user = response.getResults();
        assertNotNull(user);
        assertThat(user.getAvailable(), instanceOf(Boolean.class));
        assertTrue(user.getAvailable());
    }
}
