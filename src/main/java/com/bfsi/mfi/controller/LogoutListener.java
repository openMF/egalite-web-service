package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.util.MessageUtil;

/**
 * @className : LogoutListener.java
 * @description : Controller class for User Session Logout
 * @author : Nirmal kanna S
 */

@Component
public class LogoutListener implements ApplicationListener<SessionDestroyedEvent>{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
    public void onApplicationEvent(SessionDestroyedEvent event)
    {
		try {
			 //logger.info("Validation started in onApplicationEvent ");
			 java.util.Date date= new java.util.Date();
			 //System.out.println(new Timestamp(date.getTime()));
			 //userService.userSessionExpired();
			 /*ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			 ec.invalidateSession();
			 ec.redirect(ec.getRequestContextPath() + "/login.xhtml");*/
		} catch (Exception e) {
			logger.error("Unexpected error while User Session Expired = "
					+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
		}
    }
}