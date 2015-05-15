package main.java.com.exavault.evapi.model;

/**
 * File upload response. Not compatible with Response.
 * 
 * @author Juan Carlos González
 */
public class FileUploadResponse {
	  
	private Integer success = null;
	private Error error = null;
	private Boolean results;
	
	public Integer getSuccess() {
		return success;
	}
	
	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Error getError() {
		return error;
	}
	
	public void setError(Error error) {
		this.error = error;
	}

	public Boolean getResults() {
		return results;
	}
	
	public void setResults(Boolean results) {
	    this.results = results;
	}

	@Override
	public String toString()  {
		StringBuilder sb = new StringBuilder();
		sb.append("class FileUploadResponse {\n");
		sb.append("  success: ").append(success).append("\n");
		sb.append("  error: ").append(error).append("\n");
		sb.append("  results: ").append(results).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
