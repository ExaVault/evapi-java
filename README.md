# ExaVault Java API Library - v2 API

## Introduction
Welcome to ExaVault's Java code library for our v2 API. Our v2 API will allow you to interact with all aspects of the service the same way our web portal would. The library is generated from our API's [public swagger YAML file](https://www.exavault.com/api/docs/evapi_2.0_public.yaml).

## Requirements

To use this library, you'll need Java 1.7+ and Maven/Gradle

You will also need an ExaVault account, as well as an API key and access token.

## Compiling and Installing the Code Library

### Option 1 - Using Maven

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```
Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Option 2 - Using Gradle

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Option 3 - Manual Installation

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/swagger-java-client-1.0.0.jar`
* `target/lib/*.jar`


## Sample Code

For a gentle introduction to using Java code with ExaVault's API, check out [our code samples](https://github.com/ExaVault/evapi-java-samples). Follow the instructions in that repository's README to run the sample project, which will demonstrate how to use several of the generated Java classes to interact with your ExaVault account.

## Writing Your Own Code

When you're ready to write your own code using this library, you'll need to:

1. Install our code library in your project, using above instructions in Installation section
2. Provide your API key and access token with every function method on the Api classes, which are in io.swagger.client.api.* namespace.
3. Whenever you instantiate an Api object (ResourcesApi, UsersApi, etc.), override the configuration to point the code at the correct API URL:
```java
public static ApiClient apiInstance; 
public static String apiUrl = "https://YOUR_ACCOUNT_NAME_HERE.exavault.com/api/v2/";

ApiClient apiClient = new ApiClient();
apiClient.setBasePath(apiUrl);
apiInstance = apiClient;  

AccountApi accountApiInstance = new AccountApi(apiInstance);
```

## Author

support@exavault.com
