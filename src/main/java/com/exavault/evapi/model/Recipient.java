/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

public class Recipient {
  private Integer id = null;
  private String shareId = null;
  private String type = null;
  private String hash = null;
  private String email = null;
  private Boolean sent = null;
  private Boolean received = null;
  private String created = null;
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getShareId() {
    return shareId;
  }
  public void setShareId(String shareId) {
    this.shareId = shareId;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getHash() {
    return hash;
  }
  public void setHash(String hash) {
    this.hash = hash;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getSent() {
    return sent;
  }
  public void setSent(Boolean sent) {
    this.sent = sent;
  }

  public Boolean getReceived() {
    return received;
  }
  public void setReceived(Boolean received) {
    this.received = received;
  }

  public String getCreated() {
    return created;
  }
  public void setCreated(String created) {
    this.created = created;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipient {\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  shareId: ").append(shareId).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  hash: ").append(hash).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  sent: ").append(sent).append("\n");
    sb.append("  received: ").append(received).append("\n");
    sb.append("  created: ").append(created).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

