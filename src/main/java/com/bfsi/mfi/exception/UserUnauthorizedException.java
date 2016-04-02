package com.bfsi.mfi.exception;

import org.springframework.security.authentication.AccountStatusException;

/**
 * @author Arun
 *	Checking  whether the user is unauthorise it will throw exception.
 */

public class UserUnauthorizedException extends AccountStatusException {

	private static final long serialVersionUID = 8654057554469354629L;
	
	public UserUnauthorizedException(String msg, Throwable t) {
		super(msg, t);
	}

	public UserUnauthorizedException(String msg) {
		super(msg);
	}
	
}
