package com.bfsi.mfi.exception;

import org.springframework.security.authentication.AccountStatusException;

/**
 * @author Arun
 *	Checking  whether the user is unauthorise it will throw exception.
 */

public class UserSessionException extends AccountStatusException {

	private static final long serialVersionUID = 8654057554469354629L;
	
	public UserSessionException(String msg, Throwable t) {
		super(msg, t);
	}

	public UserSessionException(String msg) {
		super(msg);
	}
	
}
