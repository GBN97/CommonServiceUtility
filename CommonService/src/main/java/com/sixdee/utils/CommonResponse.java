package com.sixdee.utils;

import com.sixdee.utils.supporters.ErrorConstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonResponse {

    private String transactionId;
    private Integer responseCode;
    private String responseMessage;
    private String timestamp;

    public CommonResponse() {
    }

    public CommonResponse(String transactionId, Integer responseCode, String responseMessage, String timestamp) {
        this.transactionId = transactionId;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.timestamp = timestamp;
    }

    public CommonResponse(Integer code, String defaultMessage, String transactionId) {
        this.transactionId = transactionId;
        this.responseCode = code;
        this.responseMessage = defaultMessage;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern(ErrorConstants.DATE_FORMAT));
    }
    
    public CommonResponse(String responseMessage) {
        this.responseMessage = responseMessage;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
    
    public CommonResponse(Integer code, String defaultMessage) {
        this.responseCode = code;
        this.responseMessage = defaultMessage;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern(ErrorConstants.DATE_FORMAT));
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "transactionId='" + transactionId + '\'' +
                ", responseCode=" + responseCode +
                ", responseMessage='" + responseMessage + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
