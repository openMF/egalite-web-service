package com.bfsi.mfi.exception;

import org.springframework.security.authentication.AccountStatusException;

/**
 * @author Nirmal kanna S
 *	Checking  whether the user is inactive it will throw exception.
 */
public class AccountLockedException extends AccountStatusException {

	private static final long serialVersionUID = 8654057554469354629L;
	
	public AccountLockedException(String msg, Throwable t) {
		super(msg, t);
	}

	public AccountLockedException(String msg) {
		super(msg);
	}
	
}
