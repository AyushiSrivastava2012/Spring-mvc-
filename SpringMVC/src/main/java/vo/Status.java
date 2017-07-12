package vo;

public class Status {

	private String statusMessage;
	private int statusCode;
	
	public Status() {
	}
	
	public Status(String statusMessage, int statusCode) {
		super();
		this.statusMessage = statusMessage;
		this.statusCode = statusCode;
	}
	
	@Override
	public String toString() {
		return "Status [statusMessage=" + statusMessage + ", statusCode=" + statusCode + "]";
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
