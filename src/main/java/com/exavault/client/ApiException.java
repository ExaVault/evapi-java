package main.java.com.exavault.client;

public class ApiException extends Exception {
  
  private static final long serialVersionUID = 1L;
  
  private int code = 0;
  private String message = null;

  public ApiException() {}

  public ApiException(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }
  
  public void setCode(int code) {
    this.code = code;
  }
  
  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
}
