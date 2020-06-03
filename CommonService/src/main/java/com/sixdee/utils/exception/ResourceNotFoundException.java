/**
 * 
 */
package com.sixdee.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author STS-117
 *
 * 17-Jun-2019
 * 
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8020979720078977469L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
