package com.sixdee.utils.exception;

import java.time.Instant;

import com.sixdee.utils.supporters.ErrorConstants;


/**
 * This represents the response that is sent to the consumer when errors occur.
 */
public class ExceptionResponse {

    private String message;
    private String status;
    private Integer statusCode;
    private String timeStamp;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String message, String status, Integer statusCode) {
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }

    public ExceptionResponse(CommonException ex) {
        this.status = ExceptionConstants.getShortError(ex.getStatusCode());
        this.message = ex.getMessage();
        this.statusCode = ex.getStatusCode();
        this.timeStamp = ex.getTimeStamp();
    }

    public ExceptionResponse(Throwable ex) {
        this.status = ExceptionConstants.getShortError(ErrorConstants.INTERNAL_SERVER_ERROR_CODE);
        this.statusCode = ErrorConstants.INTERNAL_SERVER_ERROR_CODE;
        this.message = ex.getMessage();
        this.timeStamp = Instant.now().toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "message='" + message + '\'' +
                ", httpStatus=" + status +
                ", statusCode=" + statusCode +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
