package com.sixdee.utils;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sixdee.utils.exception.CommonException;
import com.sixdee.utils.exception.CommonExceptionResponse;
import com.sixdee.utils.supporters.Sequencer;
import com.sixdee.utils.supporters.StatusConstants.HttpConstants;

/**
 * Handles all the exceptions.
 **/

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@Autowired
	Sequencer sequencer;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse errorDetail = new CommonExceptionResponse(HttpConstants.CUSTOM_FIELD_VALIDATION.getCode(),
				ex.getBindingResult().getFieldError().getDefaultMessage(), transactionId);
		if (LOGGER.isErrorEnabled())
			LOGGER.error("Method Argument Not Valid : {}", errorDetail.toString());
		return new ResponseEntity<Object>(errorDetail, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handles client, server and gateway exceptions
	 *
	 * @param ex Exception that denotes any problems.
	 * @return response entity that represents the exception response
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleException(Throwable ex) {

		if (LOGGER.isErrorEnabled())
			LOGGER.error("Internal server error : {}", ex.toString());

		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(HttpConstants.INTERNAL_SERVER_ERROR.getCode(),
				ex.getMessage(), transactionId);
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidDeviceIdException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	protected ResponseEntity<Object> handleInvalidDeviceIdException(InvalidDeviceIdException ex) {
		if (LOGGER.isErrorEnabled())
			LOGGER.error("InvalidDeviceIdException: {}", ex.getMessage());
		
		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(ex.getStatusCode(),
				ex.getMessage(), transactionId);
		
		return new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
	}
	
	
	
	@ExceptionHandler({IllegalArgumentException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handlerExceptionResolver(IllegalArgumentException e) {
		
		if(LOGGER.isInfoEnabled())
			LOGGER.info("Returning HTTP 400 Bad Request", e);
		
		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(HttpConstants.CUSTOM_FIELD_VALIDATION.getCode(),
				e.getMessage(), transactionId);
		
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler({ResourceNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handlerExceptionResolver(ResourceNotFoundException e) {
		
		if(LOGGER.isInfoEnabled())
			LOGGER.info("Resource Not Found : {}", e);
		
		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(HttpConstants.CUSTOM_FIELD_VALIDATION.getCode(),
				e.getMessage(), transactionId);
		
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler({BadCredentialsException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseEntity<Object> handlerExceptionResolver(BadCredentialsException e) {
		
		if(LOGGER.isInfoEnabled())
			LOGGER.info("Invalid username/Password : {}", e.getMessage());
		
		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(HttpConstants.UNAUTHORIZED_STATUS_CODE.getCode(),
				e.getMessage(), transactionId);
		return new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler({LockedException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseEntity<Object> handlerExceptionResolver(LockedException e) {
		
		if(LOGGER.isInfoEnabled())
			LOGGER.info("Account Blocked : {}", e.getMessage());
		
		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(HttpConstants.FORBIDDEN_STATUS_CODE.getCode(),
				e.getMessage(), transactionId);
		return new ResponseEntity<Object>(response, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler({ CommonException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> commonException(CommonException ex) {
		int statusCode = HttpConstants.CUSTOM_FIELD_VALIDATION.getCode();
		String message = (ex != null) ? ex.getMessage() : "Unable to process request";

		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(statusCode, message, transactionId);

		LOGGER.error("CommonException : ResultCode-" + statusCode + " : Message : " + message);

		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({ SQLException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> sqlException(SQLException ex) {
		int statusCode = HttpConstants.CUSTOM_FIELD_VALIDATION.getCode();
		String message = "Unable to process request";
		
		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(statusCode, message, transactionId);
		
		LOGGER.error("CommonException : ResultCode-" + statusCode + " : Message : " + message);
		
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({ HttpMessageConversionException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> httpMessageConversionException(HttpMessageConversionException ex) {
		int statusCode = HttpConstants.CUSTOM_FIELD_VALIDATION.getCode();
		String message = "Unable to process request";
		
		String transactionId = sequencer.getSequenceId();
		
		CommonExceptionResponse response = new CommonExceptionResponse(statusCode, message, transactionId);
		
		LOGGER.error("CommonException : ResultCode-" + statusCode + " : Message : " + message);
		
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler({MaxUploadSizeExceededException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleMaxSizeException(MaxUploadSizeExceededException e) {
		
		if(LOGGER.isInfoEnabled())
			LOGGER.info("File upload size exceeded", e);
		
		String transactionId = sequencer.getSequenceId();
		return new ResponseEntity<Object>(new CommonExceptionResponse(HttpConstants.CUSTOM_FIELD_VALIDATION.getCode(),
				                        "File upload size exceeded.", transactionId), HttpStatus.BAD_REQUEST);
	}
}
