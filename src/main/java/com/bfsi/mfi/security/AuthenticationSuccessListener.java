package com.bfsi.mfi.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.UserService;

@Service("authenticationSuccessListener")
@RequestMapping(method = RequestMethod.POST)
public class AuthenticationSuccessListener implements
		ApplicationListener<AuthenticationSuccessEvent> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public void onApplicationEvent(AuthenticationSuccessEvent event) 
	{
		MfiAuthPrincipal user = (MfiAuthPrincipal) event.getAuthentication().getPrincipal();
		
		try {
			userService.updateSuccessfulLogin(user.getUsername());
			//logger.info("User " + user.getUsername() + " logged in successfully");
		} 
		catch (ServiceException e) {
			logger.error("Error while updating user record for successful login " + user.getUsername());
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}