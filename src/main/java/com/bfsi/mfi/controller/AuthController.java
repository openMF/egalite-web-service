package com.bfsi.mfi.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bfsi.mfi.dao.RoleDao;
import com.bfsi.mfi.dao.UserDao;
import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.security.MfiAuthPrincipal;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.UserVO;

@ManagedBean(name = "auth")
@SessionScoped
@RequestMapping(method = RequestMethod.POST)
public class AuthController implements Serializable 
{
	private static final long serialVersionUID = 7875454057630671407L;
	protected final Log logger = LogFactory.getLog(getClass());
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	
	private UserDao dao;
	
	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	/**
	 * 
	 * @return User id of the logged in user
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String getUserName() 
	{
		//logger.info("Validation started in getUserName() method at AuthController class");
		MfiAuthPrincipal userDetails = (MfiAuthPrincipal) getUserDetails();
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		
		//System.out.println(authentication.getDetails());
		
		try{
		if (msg.getString("welcome.message.info") != null) {
			if (userDetails.getFirstName() == null) {
				return MessageFormat.format(
						msg.getString("welcome.message.info"),
						"", userDetails.getLastName());
			} else if (userDetails.getLastName() == null) {
				return MessageFormat.format(
						msg.getString("welcome.message.info"),
						userDetails.getFirstName(), "");
			} else {
				return MessageFormat.format(
						msg.getString("welcome.message.info"),
						userDetails.getFirstName(), userDetails.getLastName());
			}
			
		} else {
			return "";
		}
		}catch(Exception e){
			LoggerUtil.cbsJobError("Unhandeled Exception while get user name : MFI10001", e);
			return "";
		}
		
	}
	public String getLastLoggedTime()
	{
		//logger.info("Validation started in getLastLoggedTime() method at AuthController class");
		MfiAuthPrincipal userDetails = (MfiAuthPrincipal) getUserDetails();
		String lastLoginDate , response;
		if(userDetails.getLastLoggedInTime() != null)
		{
			lastLoginDate = formatLastLoggedInTime(userDetails.getLastLoggedInTime().toString());
			response =  msg.getString("last.loggedIn.info")+":" + lastLoginDate;
		}
		else 
		{
			response =  "";
		}
		return response;
	}
	
	public String getAppDateToday()
	{	
		String appDateToday = "";
		try {
			appDateToday = userService.getAppDateToday();			
			if(appDateToday != null){
				appDateToday = msg.getString("sys.date") +" :"+appDateToday;
			} else {
				appDateToday = msg.getString("sys.date") +" :";
			}
		} catch(Exception e){
			LoggerUtil.ibsJobError("Unhandeled Exception while get App Date Today : MFI10001", e);			
		}		
		return appDateToday;
	}
	
	public String getSystemMode()
	{	
		String systemMode = "";
		try {
			systemMode = userService.getSystemMode();		
			if(systemMode != null && !systemMode.trim().isEmpty()){
				if(systemMode.equalsIgnoreCase("B")){
					systemMode = msg.getString("systemMode.b");
					
				} else if(systemMode.equalsIgnoreCase("E")){
					systemMode = msg.getString("systemMode.e");
					
				} else if(systemMode.equalsIgnoreCase("F")){
					systemMode = msg.getString("systemMode.f");
					
				} else if(systemMode.equalsIgnoreCase("X")){
					systemMode = msg.getString("systemMode.x");
					
				} else if(systemMode.equalsIgnoreCase("T")){
					systemMode = msg.getString("systemMode.t");
					
				} 
				systemMode = msg.getString("sys.mode") +" :"+systemMode;
				
			} else {
				systemMode = msg.getString("sys.mode") +" :";
			}
		} catch(Exception e){
			LoggerUtil.ibsJobError("Unhandeled Exception while get System Mode : MFI10001", e);			
		}		
		return systemMode;
	}
	
	public String formatLastLoggedInTime(String value)
	{
		String formatAMPM1 = "dd-MMM-yyyy hh:mm:ss a";
		Timestamp ts = Timestamp.valueOf(value.toString());
		
		SimpleDateFormat obDateFormat1 = new SimpleDateFormat(formatAMPM1);
		return obDateFormat1.format(ts).toString();
	}
	/**
	 * @param command
	 * @return checks if the logged in user has the given authority (command) or
	 *         not
	 */
	public boolean checkAuthority(String command) 
	{
		//logger.info("Validation in checkAuthority() method at AuthController class");
		UserDetails userDetails = getUserDetails();
		
			if (userDetails != null) {
				for (GrantedAuthority auth : userDetails.getAuthorities()) {
					if (auth.getAuthority().equals(command)) {
						return true;
					}
				}
			}
			return false;
		
	}

	/**
	 * @param command
	 * @return checks if the logged in user has ANY of the given authorities
	 *         (commands) or not
	 */
	public boolean checkAuthorityHasAny(String... commands) 
	{
		//logger.info("Validation in checkAuthorityHasAny() method at AuthController class");
		for (String command : commands) {
			if (checkAuthority(command)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param command
	 * @return checks if the logged in user has ALL of the given authorities
	 *         (commands) or not
	 */
	public boolean checkAuthorityHasAll(String... commands) 
	{
		//logger.info("Validation in checkAuthorityHasAll() method at AuthController class");
		for (String command : commands) {
			if (!checkAuthority(command)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return logged in user's details
	 */
	public UserDetails getUserDetails() 
	{
		//logger.info("Validation in getUserDetails() method at AuthController class");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal);
		} else {
			return null;
		}	
	}
	
	public String changePwd()
	{
		return "changepasswd";
	}
	
	/*Tag No: EGA-MN15-000031 Starts*/
	public String getUserID()
	{	
		MfiAuthPrincipal userDetails = (MfiAuthPrincipal) getUserDetails();
		return MessageFormat.format(
				msg.getString("homescreen.message.info"),userDetails.getUsername());
	}
	/*Tag No: EGA-MN15-000031 End*/
}