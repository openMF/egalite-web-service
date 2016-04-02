package com.bfsi.mfi.exception;

import org.springframework.security.authentication.AccountStatusException;

/**
 * @author Nirmal kanna S
 *	Checking  whether the user is inactive it will throw exception.
 */
public class AccountExpiredException extends AccountStatusException {

	private static final long serialVersionUID = 8654057554469354629L;
	
	public AccountExpiredException(String msg, Throwable t) {
		super(msg, t);
	}

	public AccountExpiredException(String msg) {
		super(msg);
	}
	
}
