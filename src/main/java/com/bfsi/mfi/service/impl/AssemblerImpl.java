package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bfsi.mfi.dao.AuditTrailDao;
import com.bfsi.mfi.dao.SystemParameterDao;
import com.bfsi.mfi.dao.UserDao;
import com.bfsi.mfi.exception.AccountExpiredException;
import com.bfsi.mfi.exception.AccountInactiveException;
import com.bfsi.mfi.exception.AccountLockedException;
import com.bfsi.mfi.exception.UserRoleActiveException;
import com.bfsi.mfi.exception.UserRoleAuthorizeException;
import com.bfsi.mfi.exception.UserSessionException;
import com.bfsi.mfi.exception.UserUnauthorizedException;
import com.bfsi.mfi.security.MfiAuthPrincipal;
import com.bfsi.mfi.service.Assembler;
import com.bfsi.mfi.service.UserService;

/**
 * @author arun
 */
@Component
@RequestMapping(method = RequestMethod.POST)
public class AssemblerImpl implements Assembler {
	@Autowired
	private UserDao userDao;

	@Autowired
	private AuditTrailDao<com.bfsi.mfi.entity.User> auditTrailDao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SystemParameterDao systemParamDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ramlabs.hms.service.Assembler#buildSpringUserFromUserAccount(com.
	 * ramlabs.hms.entity.UserAccount)
	 */
	@RequestMapping(method = RequestMethod.POST)
	@Override
	public User buildSpringUserFromUserAccount(
			com.bfsi.mfi.entity.User userAccount) {

		// logger.info("Validation started in buildSpringUserFromUserAccount at AssemblerImpl class");

		boolean credentialsNonExpired = true;
		String username = userAccount.getId();
		String password = userAccount.getPassword();

		boolean roleAuth = userDao.isRoleAuthorized(username);
		boolean userNotLocked = !UserService.USER_STATUS_LOCKED
				.equals(userAccount.getUserStatus());
		// boolean userAuthorise = auditTrailDao.isRecordOnceAuthorized(new
		// AuditTrail<com.bfsi.mfi.entity.User>(userAccount));
		boolean userAuthorise = userDao.isUserAuthorized(username);
		boolean roleActive = userDao.isRoleActive(username);

		if (userAccount.getUserStatus().equals("I")) {
			throw new AccountInactiveException("User Account Inactive");
		}

		else if (userAccount.getUserStatus().equals("L")) {
			throw new AccountLockedException("User Account Locked");
		}

		else if (!userAuthorise) {
			throw new UserUnauthorizedException("User Account Unauthorized");
		}

		else if (!(roleAuth)) {
			throw new UserRoleAuthorizeException("User Role Unauthorized");
		}

		else if (!(roleActive)) {
			throw new UserRoleActiveException("User Role Active / InActive");
		}

		else if (userAccount.getEndDate() != null) {
			Date expiry = userAccount.getEndDate();
			Date todaysDate = new Date();
			credentialsNonExpired = (expiry != null) ? (expiry
					.compareTo(todaysDate) > 0) : true;

			if (!credentialsNonExpired) {
				throw new AccountExpiredException("Account Expired Exception");
			}
			else
			{
				boolean userSession = userDao.isUserLogined(username);
				if (!(userSession)) 
				{
					throw new UserSessionException("User session expired");
				}
			}
		}

		
			boolean userSession = userDao.isUserLogined(username);
			if (!userSession) {
				throw new UserSessionException("User session expired");
			}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<String> entitlements = userDao.getEntitlements(userAccount);

		for (String entitlement : entitlements) {
			authorities.add(new SimpleGrantedAuthority(entitlement));
		}

		MfiAuthPrincipal user = new MfiAuthPrincipal(username, password, true,
				true, credentialsNonExpired, userNotLocked, authorities);

		user.setLastLoggedInTime(userAccount.getLastLoginDate());
		user.setFirstName(userAccount.getFirstName());
		user.setLastName(userAccount.getLastName());
		user.setAuthorized(userAuthorise);
		return user;
	}
}
