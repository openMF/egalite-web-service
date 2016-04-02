package com.bfsi.mfi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bfsi.mfi.controller.HttpSessionController;
import com.bfsi.mfi.dao.SystemParameterDao;
import com.bfsi.mfi.dao.UserDao;
import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.service.Assembler;
import com.bfsi.mfi.service.SystemParameterService;

@Service("userAuthenticationService")
public class UserAuthenticationServiceImpl implements UserDetailsService,
		ApplicationListener<AuthenticationFailureBadCredentialsEvent> 
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;
	@Autowired
	private Assembler assembler;
	@Autowired
	private SystemParameterDao systemParamDao;
	ExternalContext externalContx;
	
	public UserDetails loadUserByUsername(String userId)
			throws UsernameNotFoundException {
		
		//logger.info("Validation in loadUserByUsername method");
		User userEntity = userDao.get(userId);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found:" + userId);
		}
		
		
		return assembler.buildSpringUserFromUserAccount(userEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationListener#onApplicationEvent(org
	 * .springframework.context.ApplicationEvent)
	 */
	@Override
	@Transactional
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) 
	{
		logger.info("Validation in onApplicationEvent method");
		
		Object userName = event.getAuthentication().getPrincipal();
		//Object credentials = event.getAuthentication().getCredentials();
		String user = String.valueOf(userName);
		logger.debug("Obtained BadCredentialsEvent for user " + user);
		userDao.updateInvalidLoginAttempt(user);
		userDao.logoutUser(user);
		int maxFailedLoginCount = systemParamDao
				.getIntParamValue(SystemParameterService.PARAM_MAX_INVALID_LOGIN_ATTEMPTS);
		
		int updateCount = userDao.lockUser(user, maxFailedLoginCount);
		
		if (updateCount > 0) 
		{
			logger.info("User account "	+ user
					+ " is locked as number of failed logins match max invalid login attempts "
					+ maxFailedLoginCount);
		}
		//event.getException().
	}

}