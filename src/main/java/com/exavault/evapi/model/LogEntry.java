/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

public class LogEntry {
  private String fileName = null;
  private String fileSource = null;
  private String operation = null;
  private String duration = null;
  private Long bytesTransferred = null;
  private Integer id = null;
  private String created = null;
  private String username = null;
  private String sessionId = null;
  private String ipAddress = null;
  private String protocol = null;
  private String status = null;
  public String getFileName() {
    return fileName;
  }
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileSource() {
    return fileSource;
  }
  public void setFileSource(String fileSource) {
    this.fileSource = fileSource;
  }

  public String getOperation() {
    return operation;
  }
  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getDuration() {
    return duration;
  }
  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Long getBytesTransferred() {
    return bytesTransferred;
  }
  public void setBytesTransferred(Long bytesTransferred) {
    this.bytesTransferred = bytesTransferred;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getCreated() {
    return created;
  }
  public void setCreated(String created) {
    this.created = created;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getSessionId() {
    return sessionId;
  }
  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public String getProtocol() {
    return protocol;
  }
  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogEntry {\n");
    sb.append("  fileName: ").append(fileName).append("\n");
    sb.append("  fileSource: ").append(fileSource).append("\n");
    sb.append("  operation: ").append(operation).append("\n");
    sb.append("  duration: ").append(duration).append("\n");
    sb.append("  bytesTransferred: ").append(bytesTransferred).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("  username: ").append(username).append("\n");
    sb.append("  sessionId: ").append(sessionId).append("\n");
    sb.append("  ipAddress: ").append(ipAddress).append("\n");
    sb.append("  protocol: ").append(protocol).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

