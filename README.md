# ExaVault Java API Library - v2 API

## Introduction
Welcome to ExaVault's Java code library for our v2 API. Our v2 API will allow you to interact with all aspects of the service the same way our web portal would. The library is generated from our API's [public swagger YAML file](https://www.exavault.com/api/docs/evapi_2.0_public.yaml).

## Requirements

To use this library, you'll need [Java 1.7+](https://www.java.com/en/download/help/download_options.xml) and [Maven](https://howtodoinjava.com/maven/how-to-install-maven-on-windows/).

You will also need an [ExaVault](https://www.exavault.com/) account, as well as an [API key and access token](https://www.exavault.com/developer/api-docs/#section/Obtaining-Your-API-Key-and-Access-Token).

## Setting Up

Clone the project from our repository 

```shell
git clone https://github.com/ExaVault/evapi-java.git
```

As a next step, import the project into your favorite Java IDE. Please refer to this [guide](https://github.com/ExaVault/evapi-java-samples/blob/main/README.md#running-your-first-sample) to install an IDE and import the project into it.


## Compiling and Installing the Code Library

### Option 1 - Using Maven

As a first step, you need to install **our Java SDK** into your local maven repository. To do so, please run the following command from the root folder (where you've imported/cloned our Java SDK).

```shell
mvn clean -DskipTests=true install
```

Now, our Java SDK and its related dependencies are installed into your local maven repository.

Furthermore, Add this dependency to **your project's** `POM.XML`:

```xml
<dependency>
  <groupId>com.exavault</groupId>
  <artifactId>exavault-api-client</artifactId>
  <version>INSERT_VERSION_NUMBER_HERE</version>
  <scope>compile</scope>
</dependency>
```

At the end of this step, your project should be able to use our Java SDK.

### Option 1a - Running Tests During Build

While you don't need to do this strictly to build our SDK, you may want to run our test suite before building. To do so, you'll need to create an API key and access token in your account, and add them to the ``ApiTestData.java`` file. 

Once you've done that, to just run tests:

```shell
mvn clean test
```

To run tests and do a full build:

```shell
mvn clean install
```

### Option 2 - Manual Installation

We've provided pre-compiled jar files in the `lib` directory. You may manually install these files into **your project**. Please follow this [guide](https://github.com/ExaVault/evapi-java-samples/blob/main/README.md#running-your-first-sample) to configure jar files.

If you'd like to build the jar package from source, you may do:

```shell
mvn clean -DskipTests=true package
```
This step will generate JAR files from **our SDK** (and other related dependencies) into the `target` folder at the project root. Generally, you can just use the compiled JAR files (or use maven), but if you want to build yourself, you can. 

## Sample Code

For a gentle introduction to using Java code with ExaVault's API, check out [our code samples](https://github.com/ExaVault/evapi-java-samples). Follow the instructions in that repository's README to run the sample project, which will demonstrate how to use several of the generated Java classes to interact with your ExaVault account.

## Writing Your Own Code

When you're ready to write your own code using this library, you'll need to:

1. Install our code library in your project, using above instructions in Installation section.
2. Provide your API key and access token with every function method on the Api classes, which are in com.exavault.client.api.* namespace.
3. Whenever you instantiate an Api object (ResourcesApi, UsersApi, etc.), override the configuration to point the code at the correct API URL:

```java
public static String apiUrl = "https://YOUR_ACCOUNT_NAME_HERE.exavault.com/api/v2/";

ApiClient apiClient = new ApiClient();
apiClient.setBasePath(apiUrl); 

AccountApi accountApiInstance = new AccountApi(apiClient);
```

## Author

support@exavault.com
