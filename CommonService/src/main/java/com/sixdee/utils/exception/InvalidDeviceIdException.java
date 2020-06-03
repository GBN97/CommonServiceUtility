/**
 * 
 */
package com.sixdee.utils.exception;

import java.time.Instant;

/**
 * @author STS-117
 *
 * 17-Jun-2019
 * 
 */
public class InvalidDeviceIdException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	
	private String message;
    private Integer statusCode;
    private String timeStamp;
    private boolean isDeviceIdValid;

    public InvalidDeviceIdException(String message, Integer statusCode) {
    	super(message);
        this.message = message;
        this.statusCode = statusCode;
        this.timeStamp = Instant.now().toString();
        this.isDeviceIdValid = false;
    }
    
    public InvalidDeviceIdException() {
    	super();
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isDeviceIdValid() {
		return isDeviceIdValid;
	}

	public void setDeviceIdValid(boolean isDeviceIdValid) {
		this.isDeviceIdValid = isDeviceIdValid;
	}

	@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
	
	@Override
	public String toString() {
		return "InvalidDeviceIdException [message=" + message + ", statusCode=" + statusCode + ", timeStamp="
				+ timeStamp + ", isDeviceIdValid=" + isDeviceIdValid + "]";
	}
    
}
