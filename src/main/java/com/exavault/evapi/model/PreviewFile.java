/**
 * Copyright 2014 ExaVault, Inc.
 *
 * NOTE: This file was generated automatically. Do not modify by hand.
 */ 

package main.java.com.exavault.evapi.model;

public class PreviewFile {
  private String image = null;
  private Long size = null;
  private String imageId = null;
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  public Long getSize() {
    return size;
  }
  public void setSize(Long size) {
    this.size = size;
  }

  public String getImageId() {
    return imageId;
  }
  public void setImageId(String imageId) {
    this.imageId = imageId;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreviewFile {\n");
    sb.append("  image: ").append(image).append("\n");
    sb.append("  size: ").append(size).append("\n");
    sb.append("  imageId: ").append(imageId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

