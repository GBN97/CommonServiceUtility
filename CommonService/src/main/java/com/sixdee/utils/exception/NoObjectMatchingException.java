package com.sixdee.utils.exception;

/**
 * @author arun.hm
 *
 */


public class NoObjectMatchingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoObjectMatchingException(String message) {
		super(message);
	}

}