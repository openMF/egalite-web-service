package com.bfsi.mfi.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bfsi.mfi.auth.UserFunctionViewMap;
import com.bfsi.mfi.dao.SystemParameterDao;
import com.bfsi.mfi.dao.UserDao;
import com.bfsi.mfi.dao.jdbc.UserJdbcDao;
import com.bfsi.mfi.messages.ApplicationMessages;

/**
 * 
 * @author Shabu S Francis
 * 
 * Bug id: BFSIMFI-244
 * 
*/


public class ApplicationInitController implements ServletContextListener
{
	private UserDao userDao;
	private SystemParameterDao systemParameterDao;
	private WebApplicationContext springContext;
	@Override
	public void contextDestroyed(ServletContextEvent p_event) {
				
	}
/*
 * (non-Javadoc)
 * Delete all the logged in user history at server start-up
 */
	@Override
	public void contextInitialized(ServletContextEvent p_event) {
		
		try {			
			springContext =	 WebApplicationContextUtils.getWebApplicationContext(p_event.getServletContext());
			userDao=(UserJdbcDao) springContext.getBean("userDao");
			userDao.deleteUserLoginHistory();
			UserFunctionViewMap.loadViewMap();
			ApplicationMessages.loadMessages();
			systemParameterDao =(SystemParameterDao) springContext.getBean("systemParameterDao");
			systemParameterDao.updateSystemParameterFor("IBS_JOB_RUNNING_STATUS", "N");
		} catch (Exception p_e) {
			p_e.printStackTrace();
		}
	}
}
