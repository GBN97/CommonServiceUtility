package com.sixdee.utils;

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