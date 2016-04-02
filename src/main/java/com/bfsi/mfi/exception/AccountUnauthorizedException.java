package com.bfsi.mfi.exception;

import org.springframework.security.authentication.AccountStatusException;

/**
 * @author Arun
 *	Checking  whether the user is unauthorise it will throw exception.
 */

public class AccountUnauthorizedException extends AccountStatusException {

	private static final long serialVersionUID = 8654057554469354629L;
	
	public AccountUnauthorizedException(String msg, Throwable t) {
		super(msg, t);
	}

	public AccountUnauthorizedException(String msg) {
		super(msg);
	}
	
}
