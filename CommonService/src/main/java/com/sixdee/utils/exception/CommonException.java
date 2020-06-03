package com.sixdee.utils.exception;


import java.time.Instant;

/**
 * Base exception class
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;
    private Integer statusCode;
    private String timeStamp;

    public CommonException(Integer statusCode, String message) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
        this.timeStamp = Instant.now().toString();
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
}
