package com.bfsi.mfi.exception;

import org.springframework.security.authentication.AccountStatusException;

/**
 * @author Arun
 *	Checking  whether the user is unauthorise it will throw exception.
 */

public class UserRoleActiveException extends AccountStatusException {

	private static final long serialVersionUID = 8654057554469354629L;
	
	public UserRoleActiveException(String msg, Throwable t) {
		super(msg, t);
	}

	public UserRoleActiveException(String msg) {
		super(msg);
	}
	
}
