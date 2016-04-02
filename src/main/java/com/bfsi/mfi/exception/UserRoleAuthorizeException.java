package com.bfsi.mfi.exception;

import org.springframework.security.authentication.AccountStatusException;

/**
 * @author Arun
 *	Checking  whether the user is unauthorise it will throw exception.
 */

public class UserRoleAuthorizeException extends AccountStatusException {

	private static final long serialVersionUID = 8654057554469354629L;
	
	public UserRoleAuthorizeException(String msg, Throwable t) {
		super(msg, t);
	}

	public UserRoleAuthorizeException(String msg) {
		super(msg);
	}
	
}
