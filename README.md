# evapi-java

evapi-java is an API client written in Java for connecting to the ExaVault API. The ExaVault API is a REST-like API providing operations for file and user management, and supports both POST and GET requests.

To get started using ExaVault's API, you first must have an ExaVault account and obtain an API key. For more information, please refer to our Developer page or contact support@exavault.com for details.

## Prerequisites 

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting started 

You will need to obtain an API key for your application from the [Client Area](https://clients.exavault.com/clientarea.php?action=products) of your account.  To
obtain an API key, please follow the instructions below.

 + Login to the [Accounts](https://clients.exavault.com/clientarea.php?action=products) section of the Client Area.
 + Use the drop down next to your desired account, and select *Manage API Keys*.
 + You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.

Once you obtain your API you can use the following snippet. It will allow you to authenticate into API, create folder, get activity logs and log out user from the API.

```java
import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AuthenticationApi;
import io.swagger.client.api.FilesAndFoldersApi;
import io.swagger.client.api.ActivityApi;

import java.io.File;
import java.util.*;
import java.util.Random;


public class Example {

    public static void main(String[] args) {
        
        AuthenticationApi authApi = new AuthenticationApi();
        String accessToken = null;
        AuthResponse.SuccessEnum loginSuccess = null;
        
        String apiKey = "your_api_key_goe_here"; 
        String username = "existing_username_goes_here";
        String password = "user_password_goes_here";
        
        try {
            AuthResponse authResult = authApi.authenticateUser(apiKey, username, password);
            loginSuccess = authResult.getSuccess();
            
            if (loginSuccess.getValue() == 1) {
                    accessToken = authResult.getResults().getAccessToken();
            } else {
                // something went wrong check authResult.getError() for more details
                    System.out.println(authResult.getError());
                    return;
            }
                
        } catch (ApiException e) {
            // server error occurred
            System.err.println("Exception when calling AuthenticationApi#authenticateUser");
            e.printStackTrace();
        }
        

        FilesAndFoldersApi filesFoldersApi = new FilesAndFoldersApi();
        Random rand = new Random();
        String folderName = "api_test_folder"+rand.nextInt(99999);
        String path = "/";
         
        try {
                Response createResult = filesFoldersApi.createFolder(apiKey, accessToken, folderName, path);
                Response.SuccessEnum createSuccess = createResult.getSuccess();
            
            if (createSuccess.getValue() == 1) {
                    // Folder created successfully
                    System.out.println("Folder created successfully");
            } else {
                // something went wrong check createResult.getError() for more details
                    System.out.println(createResult.getError());
                    return;
            }
                
        } catch (ApiException e) {
            // server error occurred
            System.err.println("Exception when calling FilesAndFoldersApi#createFolder");
            e.printStackTrace();
        }
        
        ActivityApi activityApi = new ActivityApi();
        Integer offset = 0;
        String sortBy = "sort_logs_date"; 
        String sortOrder = "desc"; 

        try {
            LogResponse getLogsResult = activityApi.getFileActivityLogs(apiKey, accessToken, offset, sortBy, sortOrder, null, null, null);
            System.out.println(getLogsResult);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActivityApi#getFileActivityLogs");
            e.printStackTrace();
        }
        
        // To logout the current user, simply check the loginSuccess flag that was stored earlier and then call the `logoutUser` method
        if (loginSuccess.getValue() == 1) {
                try {
                    authApi.logoutUser(apiKey, accessToken);
            } catch (ApiException e) {
                // server error occurred
                System.err.println("Exception when calling AuthenticationApi#logoutUser");
                e.printStackTrace();
            }
        }   
    }
}
```

You can find list of all API requets here - [ExaVault API Docs](https://www.exavault.com/developer/api-docs/)