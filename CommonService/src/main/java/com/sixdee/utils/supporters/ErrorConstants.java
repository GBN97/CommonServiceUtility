package com.sixdee.utils.supporters;

public interface ErrorConstants {

	Integer NOT_FOUND_STATUS_CODE = 404;
	Integer BAD_REQUEST_STATUS_CODE = 400;
	Integer INTERNAL_SERVER_ERROR_CODE = 500;
	Integer SUCCESS_STATUS_CODE = 200;
	Integer NOTIFICATION_FAIL_STATUS_CODE = 123;
	Integer INVALID_OTP_STATUS_CODE = 500;
	Integer INVALID_DEVICE_ID_CODE = 400;

	String WRONG_PASSWORD_ERROR_MSG = "Please check the credentials";
    String NO_USER_ERROR_MSG = "User does not exist";
    String USER_NOT_FOUND_MSG = "User not found";
    String ERROR = "Error";
    String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
    String PAYLOAD_DATE_FORMAT_WITH_TIME = "yyyy-MM-dd HH:mm:ss";

    String SUCCESS = "Success";
	int ACTIVE_STATUS = 1;
    String CHECK_USER_ID_MSG = "Please check the User ID";
    String CHECK_DEVICE_ID_MSG = "Please check the Device ID";
    String PASSWORD_IS_SET = "Sorry, password is set. Please login to change the password.";
    
    
    String NOTIFICATION_FAIL_MSG = "Failed to Send Notification";
    
    String BLANK_REQUES_BODY_MSG = "Blank Request received";
    String INVALID_OTP_REQUEST_MSG = "Invalid OTP Validation Request";
    String INVALID_OTP_MSG = "Invalid OTP ...!!!";
    String BLANK_OTP_MSG = "Enter the OTP ...!!!";
    String OTP_EXPIRED_MSG = "OTP Expired";
    String OTP_ALREADY_USED_MSG = "OTP alredy validated";
    String BLANK_OTP_SENDERID_MSG = "Empty Sender Id In the Request";
    String BLANK_OTP_VALIDATORID_MSG = "Empty Validator Id In the Request";
    String BLANK_OTP_SERVICEID_MSG = "Empty Service Id in the Request";
    String INVALID_SENDERID_MSG = "Invalid Sender Id In the Request";
    String INVALID_RECEIVERID_MSG = "Invalid Receiver Id In the Request";
    String INVALID_SERVICEID_MSG = "Invalid Service Id in the Request";
    String INVALID_OTP_GENERATE_REQUEST_MSG = "Invalid OTP Request";
	String DEVICE_ID_NULL = "Please provide Device Id";
    
    public static final String INVALID_DEVICE_ID = "Invalid Device Id";
    
  //esb
    public final static String ESB_NOTIF_SUCCESS_CODE = "0";
}

