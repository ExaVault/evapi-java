/*
 * ExaVault API
 * # Introduction  Welcome to the ExaVault API documentation. Our API lets you control nearly all aspects of your ExaVault account programatically, from uploading and downloading files to creating and managing shares and notifications. Our API supports both GET and POST operations.  Capabilities of the API include:  - Uploading and downloading files. - Managing files and folders; including standard operations like move, copy and delete. - Getting information about activity occuring in your account. - Creating, updating and deleting users. - Creating and managing shares, including download-only shares and receive folders.  - Setting up and managing notifications.  ## The API Endpoint  The ExaVault API is located at: https://api.exavault.com/v1.2/  ## Obtain Your API Key  You will need to obtain an API key to connect to the API. To do this, follow the instructions below.   + Log into your account through the usual way, or use https://app.exavault.com.  + Click the Gear icon to access the account settings  + Locate the Developer tab in the account settings  + Click the link for *Manage API Keys*  + You will be brought to the API Key management screen. Fill out the form and save to generate a new key for your app.  *NOTE: You must have admin or master permissions to create an API key for your account. If you do not have access to developer settings for your account, contact your account administrator to create an API key for you.  # Testing w/ Postman  We've made it easy for you to test our API before you start full-scale development. Download [Postman](https://www.getpostman.com/) or the [Postman Chrome Extension](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en), and then download our Postman collection, below. [Obtain your API key](#section/Introduction/Obtain-Your-API-Key) and you'll be able to interact with your ExaVault account immediately, so you can better understand what the capabilities of the API are.  <div class=\"postman-run-button\" data-postman-action=\"collection/import\" data-postman-var-1=\"07891ce73cc525084ceb\"></div>  ![ExaVault API Postman Colletion Usage](/images/postman.png)  If you'd prefer to skip Postman and start working with code directly, take a look at the sample code below.    # Code Libraries & Sample PHP Code  Once you're ready for full-scale development, we recommend looking at our code libraries available on [GitHub](https://github.com/ExaVault). We offer code libraries for [Python](https://github.com/ExaVault/evapi-python), [PHP](https://github.com/ExaVault/evapi-php), [JavaScript](https://github.com/ExaVault/evapi-javascript) and [Java](https://github.com/ExaVault/evapi-java).  While we recommend using our libraries, you're welcome to interact directly with our API via HTTP GET and POST requests -- a great option particularly if you're developing in a language for which we don't yet have sample code.     - [Download Python Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-python) - [Download PHP Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-php) - [Download JavaScript Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-javascript) - [Download Java Library &amp; Sample Code &raquo;](https://github.com/ExaVault/evapi-java)  *Note: You can generate client libraries for any language using [Swagger Editor](http://editor2.swagger.io/). Just download our documentation file, past it into editor and use 'Generate Client' dropdown.*  # Status Codes  The ExaVault API returns only two HTTP status codes for its responses: 200 and 500.  When the request could be successfully processed by the endpoint, the response status code will be 200, regardless of whether the requested action could be taken.  For example, the response to a getUser request for a username that does not exist in your account would have the status of 200,  indicating that the response was received and processed, but the error member of the returned response object would contain object with `message` and `code` properties.  **Result Format:**  |Success   | Error     | Results   | | ---      | :---:       |  :---:      | | 0        |  `Object` |   Empty   | | 1        |   Empty       |    `Object` or `Array`        |     When a malformed request is received, a 500 HTTP status code will be returned, indicating that the request could not be processed.  ExaVault's API does not currently support traditional REST response codes such as '201 Created' or '405 Method Not Allowed'.  # File Paths  Many API calls require you to provide one or more file paths. For example, the <a href=\"#operation/moveResources\">moveResources</a> call requires both an array of source paths, **filePaths**, and a destination path, **destinationPath**. Here's a few tips for working with paths:   - File paths should always be specified as a string, using the standard Unix format: e.g. `/path/to/a/file.txt`  - File paths are always absolute _from the home directory of the logged in user_. For example, if the user **bob** had a home directory restriction of `/bob_home`, then an API call made using his login would specify a file as `/myfile.txt`, whereas an API call made using the master user ( no home directory restriction ) would specify the same file as `/bob_home/myfile.txt`.  # API Rate Limits  We rate limit the number of API calls you can make to help prevent abuse and protect system stablity. Each API key will support 500 requests per rolling five minutes. If you make more than 500 requests in a five minute period, you will receive a response with an error object for fifteen minutes.  # Webhooks  A webhook is an HTTP callback: a simple event-notification via HTTP POST. If you define webhooks for Exavault, ExaVault will POST a  message to a URL when certain things happen.     Webhooks can be used to receive a JSON object to your endpoint URL. You choose what events will trigger webhook messages to your endpoint URL.     Webhooks will attempt to send a message up to 8 times with increasing timeouts between each attempt. All webhook requests are tracked in the webhooks log.  ## Getting Started  1. Go to the Account tab inside the web application.  2. Choose the Developer tab.  3. Configure your endpoint URL and select the events you want to trigger webhook messages.  4. Save settings.    You are all set to receive webhook callbacks on the events you selected.  ## Verification Signature  ExaVault includes a custom HTTP header, X-Exavault-Signature, with webhooks POST requests which will contain the signature for the request.  You can use the signature to verify the request for an additional level of security.  ## Generating the Signature  1. Go to Account tab inside the web application.  2. Choose the Developer tab.  3. Obtain the verification token. This field will only be shown if you've configured your endpoint URL.  4. In your code that receives or processes the webhooks, you should concatenate the verification token with the response string and hash it with md5.     ```     md5($verificationToken.$responseString);     ```  5. Compare signature that you generated to the signature provided in the X-Exavault-Signature HTTP header  ## Example JSON Response Object  ```json   {     \"accountname\": \"mycompanyname\",     \"username\": \"john\"     \"operation\": \"Upload\",     \"protocol\": \"https\",     \"path\": \"/testfolder/filename.jpg\"     \"attempt\": 1   } ```  ## Webhooks Logs  Keep track of all your webhooks requests in the Activity section of your account. You can find the following info for each request:    1. date and time - timestamp of the request.    2. endpoint url - where the webhook was sent.    3. event - what triggered the webhook.    4. status - HTTP status or curl error code.    5. attempt - how many times we tried to send this request.    6. response size - size of the response from your server.    7. details - you can check the response body if it was sent.
 *
 * OpenAPI spec version: 1.2
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.DirectFile;
import io.swagger.client.model.Notification;
import io.swagger.client.model.Share;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Node
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-21T04:12:26.455Z")
public class Node {
    @SerializedName("id")
    private Integer id = null;

    @SerializedName("parentNodeId")
    private Integer parentNodeId = null;

    @SerializedName("hash")
    private String hash = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("extension")
    private String extension = null;

    /**
     * Type of item
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        DIR_FILE("dir file");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String text) {
            for (TypeEnum b : TypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("type")
    private TypeEnum type = null;

    @SerializedName("createdBy")
    private String createdBy = null;

    @SerializedName("uploadDate")
    private String uploadDate = null;

    @SerializedName("createdAt")
    private String createdAt = null;

    @SerializedName("updatedAt")
    private String updatedAt = null;

    @SerializedName("accessedAt")
    private String accessedAt = null;

    @SerializedName("createdTime")
    private String createdTime = null;

    @SerializedName("updatedTime")
    private String updatedTime = null;

    @SerializedName("accessedTime")
    private String accessedTime = null;

    @SerializedName("parent")
    private String parent = null;

    @SerializedName("path")
    private String path = null;

    @SerializedName("shares")
    private List<Share> shares = null;

    @SerializedName("notifications")
    private List<Notification> notifications = null;

    @SerializedName("size")
    private String size = null;

    @SerializedName("fileCount")
    private Integer fileCount = null;

    @SerializedName("previewable")
    private Boolean previewable = null;

    @SerializedName("directFile")
    private List<DirectFile> directFile = null;

    public Node id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Unique ID of the node
     * @return id
     **/
    @ApiModelProperty(value = "Unique ID of the node")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Node parentNodeId(Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
        return this;
    }

    /**
     * Unique ID of containing folder
     * @return parentNodeId
     **/
    @ApiModelProperty(value = "Unique ID of containing folder")
    public Integer getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public Node hash(String hash) {
        this.hash = hash;
        return this;
    }

    /**
     * unique hashed ID
     * @return hash
     **/
    @ApiModelProperty(value = "unique hashed ID")
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Node name(String name) {
        this.name = name;
        return this;
    }

    /**
     * File or folder name
     * @return name
     **/
    @ApiModelProperty(value = "File or folder name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node extension(String extension) {
        this.extension = extension;
        return this;
    }

    /**
     * File extension
     * @return extension
     **/
    @ApiModelProperty(value = "File extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Node type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of item
     * @return type
     **/
    @ApiModelProperty(value = "Type of item")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public Node createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * User id of creator
     * @return createdBy
     **/
    @ApiModelProperty(value = "User id of creator")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Node uploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
        return this;
    }

    /**
     * Date file or folder was created
     * @return uploadDate
     **/
    @ApiModelProperty(value = "Date file or folder was created")
    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Node createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Date file or folder was created
     * @return createdAt
     **/
    @ApiModelProperty(value = "Date file or folder was created")
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Node updatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Date file or folder was last changed
     * @return updatedAt
     **/
    @ApiModelProperty(value = "Date file or folder was last changed")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Node accessedAt(String accessedAt) {
        this.accessedAt = accessedAt;
        return this;
    }

    /**
     * Date file was last downloaded
     * @return accessedAt
     **/
    @ApiModelProperty(value = "Date file was last downloaded")
    public String getAccessedAt() {
        return accessedAt;
    }

    public void setAccessedAt(String accessedAt) {
        this.accessedAt = accessedAt;
    }

    public Node createdTime(String createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    /**
     * Timestamp of file or folder creation
     * @return createdTime
     **/
    @ApiModelProperty(value = "Timestamp of file or folder creation")
    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Node updatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    /**
     * Timestamp of file or folder last changed
     * @return updatedTime
     **/
    @ApiModelProperty(value = "Timestamp of file or folder last changed")
    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Node accessedTime(String accessedTime) {
        this.accessedTime = accessedTime;
        return this;
    }

    /**
     * Timestamp file was last downloaded
     * @return accessedTime
     **/
    @ApiModelProperty(value = "Timestamp file was last downloaded")
    public String getAccessedTime() {
        return accessedTime;
    }

    public void setAccessedTime(String accessedTime) {
        this.accessedTime = accessedTime;
    }

    public Node parent(String parent) {
        this.parent = parent;
        return this;
    }

    /**
     * Path of parent folder
     * @return parent
     **/
    @ApiModelProperty(value = "Path of parent folder")
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Node path(String path) {
        this.path = path;
        return this;
    }

    /**
     * full path to current file or folder, including self
     * @return path
     **/
    @ApiModelProperty(value = "full path to current file or folder, including self")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Node shares(List<Share> shares) {
        this.shares = shares;
        return this;
    }

    public Node addSharesItem(Share sharesItem) {
        if (this.shares == null) {
            this.shares = new ArrayList<Share>();
        }
        this.shares.add(sharesItem);
        return this;
    }

    /**
     * Get shares
     * @return shares
     **/
    @ApiModelProperty(value = "")
    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public Node notifications(List<Notification> notifications) {
        this.notifications = notifications;
        return this;
    }

    public Node addNotificationsItem(Notification notificationsItem) {
        if (this.notifications == null) {
            this.notifications = new ArrayList<Notification>();
        }
        this.notifications.add(notificationsItem);
        return this;
    }

    /**
     * Get notifications
     * @return notifications
     **/
    @ApiModelProperty(value = "")
    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Node size(String size) {
        this.size = size;
        return this;
    }

    /**
     * size of the file or folder in bytes
     * @return size
     **/
    @ApiModelProperty(value = "size of the file or folder in bytes")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Node fileCount(Integer fileCount) {
        this.fileCount = fileCount;
        return this;
    }

    /**
     * Number of files contained within this node
     * @return fileCount
     **/
    @ApiModelProperty(value = "Number of files contained within this node")
    public Integer getFileCount() {
        return fileCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }

    public Node previewable(Boolean previewable) {
        this.previewable = previewable;
        return this;
    }

    /**
     * Whether node can be previewed (supported image type)
     * @return previewable
     **/
    @ApiModelProperty(value = "Whether node can be previewed (supported image type)")
    public Boolean isPreviewable() {
        return previewable;
    }

    public void setPreviewable(Boolean previewable) {
        this.previewable = previewable;
    }

    public Node directFile(List<DirectFile> directFile) {
        this.directFile = directFile;
        return this;
    }

    public Node addDirectFileItem(DirectFile directFileItem) {
        if (this.directFile == null) {
            this.directFile = new ArrayList<DirectFile>();
        }
        this.directFile.add(directFileItem);
        return this;
    }

    /**
     * Get directFile
     * @return directFile
     **/
    @ApiModelProperty(value = "")
    public List<DirectFile> getDirectFile() {
        return directFile;
    }

    public void setDirectFile(List<DirectFile> directFile) {
        this.directFile = directFile;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(this.id, node.id) &&
                Objects.equals(this.parentNodeId, node.parentNodeId) &&
                Objects.equals(this.hash, node.hash) &&
                Objects.equals(this.name, node.name) &&
                Objects.equals(this.extension, node.extension) &&
                Objects.equals(this.type, node.type) &&
                Objects.equals(this.createdBy, node.createdBy) &&
                Objects.equals(this.uploadDate, node.uploadDate) &&
                Objects.equals(this.createdAt, node.createdAt) &&
                Objects.equals(this.updatedAt, node.updatedAt) &&
                Objects.equals(this.accessedAt, node.accessedAt) &&
                Objects.equals(this.createdTime, node.createdTime) &&
                Objects.equals(this.updatedTime, node.updatedTime) &&
                Objects.equals(this.accessedTime, node.accessedTime) &&
                Objects.equals(this.parent, node.parent) &&
                Objects.equals(this.path, node.path) &&
                Objects.equals(this.shares, node.shares) &&
                Objects.equals(this.notifications, node.notifications) &&
                Objects.equals(this.size, node.size) &&
                Objects.equals(this.fileCount, node.fileCount) &&
                Objects.equals(this.previewable, node.previewable) &&
                Objects.equals(this.directFile, node.directFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentNodeId, hash, name, extension, type, createdBy, uploadDate, createdAt, updatedAt, accessedAt, createdTime, updatedTime, accessedTime, parent, path, shares, notifications, size, fileCount, previewable, directFile);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Node {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    parentNodeId: ").append(toIndentedString(parentNodeId)).append("\n");
        sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    uploadDate: ").append(toIndentedString(uploadDate)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    accessedAt: ").append(toIndentedString(accessedAt)).append("\n");
        sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
        sb.append("    updatedTime: ").append(toIndentedString(updatedTime)).append("\n");
        sb.append("    accessedTime: ").append(toIndentedString(accessedTime)).append("\n");
        sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    shares: ").append(toIndentedString(shares)).append("\n");
        sb.append("    notifications: ").append(toIndentedString(notifications)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    fileCount: ").append(toIndentedString(fileCount)).append("\n");
        sb.append("    previewable: ").append(toIndentedString(previewable)).append("\n");
        sb.append("    directFile: ").append(toIndentedString(directFile)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

