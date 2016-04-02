package com.bfsi.mfi.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.bfsi.mfi.rest.constants.Constants;


/**
 * 
 * @author Vishal
 * 
 */

public class LoggerUtil {
	
	private static final Logger IBS_DEBUG = Logger.getLogger("IBS_Debug_log");
	private static final Logger IBS_ERROR = Logger.getLogger("IBS_Error_log");
	private static final Logger MBS_DEBUG = Logger.getLogger("MBS_Debug_log");
	private static final Logger MBS_ERROR = Logger.getLogger("MBS_Error_log");
	private static final Logger CBS_DEBUG = Logger.getLogger("CBS_Debug_log");
	private static final Logger CBS_ERROR = Logger.getLogger("CBS_Error_log");
	private static final Logger Online_Debug = Logger.getLogger("Online_Debug_log");
	private static final Logger Online_Error = Logger.getLogger("Online_Error_log");
	private static String debugStatus = null;
	private static ArrayList<String> classInfo = null;
	 
	
	public static void ibsJobDebug(String message){
		if(isDebugEnable()) {
			classInfo = callerClassInfo();
			IBS_DEBUG.debug("[ "+classInfo.get(0)+" : "+classInfo.get(1)+"  : " +classInfo.get(2)+" : "+getLoggedInUserName()+ "]" +message);
		}
	}
	
	public static void ibsJobDebug(String message,Throwable t){
		if(isDebugEnable()) {
			classInfo = callerClassInfo();
			IBS_DEBUG.debug("[ "+classInfo.get(0)+" : "+classInfo.get(1)+"  : " +classInfo.get(2)+" : "+getLoggedInUserName()+"] "+message,t);
		}
	}
	
	public static void ibsJobError(String message){
		IBS_ERROR.error(getLoggedInUserName()+" : "+message);
	}
	public static void ibsJobError(String message,Throwable t){
		IBS_ERROR.error(getLoggedInUserName()+" : "+message,t);
	}

	public static void mbsJobDebug(String message){
		if(isDebugEnable()) {	
			classInfo = callerClassInfo();			
			MBS_DEBUG.debug("[ "+classInfo.get(0)+" : "+classInfo.get(1)+"  : " +classInfo.get(2)+" ] "+message);			
		}
	}
	
	public static void mbsJobDebug(String message,Throwable t){
		if(isDebugEnable()) {	
			classInfo = callerClassInfo();			
			MBS_DEBUG.debug("[ "+classInfo.get(0)+" : "+classInfo.get(1)+"  : " +classInfo.get(2)+" ] "+message, t);			
		}
	}
	
	public static void mbsJobError(String message){
		MBS_ERROR.error(message);
	}
	
	public static void mbsJobError(String message,Throwable t){
		MBS_ERROR.error(message, t);
	}
	
	public static void cbsJobDebug(String message){
		if(isDebugEnable()) {
			classInfo = callerClassInfo();
			CBS_DEBUG.debug("[ "+classInfo.get(0)+" : "+classInfo.get(1)+"  : " +classInfo.get(2)+" ] "+message);
		}
		
	}
	
	public static void cbsJobDebug(String message,Throwable t){
		if(isDebugEnable()) {
			classInfo = callerClassInfo();
			CBS_DEBUG.debug("[ "+classInfo.get(0)+" : "+classInfo.get(1)+"  : " +classInfo.get(2)+" ] "+message, t);
		}
		
	}
	
	public static void cbsJobError(String message){
		CBS_ERROR.error(message);
	}
	
	public static void cbsJobError(String message,Throwable t){
		CBS_ERROR.error(message,t);
	}
	
	public static void onlineJobDebug(String message){
		if(isDebugEnable()) {
			classInfo = callerClassInfo();
			Online_Debug.debug("[ "+classInfo.get(0)+" : "+classInfo.get(1)+"  : " +classInfo.get(2)+" ] "+message);
		}
	}
	
	public static void onlineJobDebug(String message,Throwable t){
		if(isDebugEnable()) {
			classInfo = callerClassInfo();
			Online_Debug.debug("[ "+classInfo.get(0)+" : "+classInfo.get(1)+"  : " +classInfo.get(2)+" ] "+message,t);
		}
	}
	
	public static void onlineJobError(String message){
		Online_Error.error(message);
	}
	
	public static void onlineJobError(String message,Throwable t){
		Online_Error.error(message,t);
	}
	
	private static boolean isDebugEnable(){
		try{
				if(debugStatus == null){
					synchronized (LoggerUtil.class) {
						if (debugStatus == null) {
							debugStatus = Constants.DEBUG_STATUS;
						}
					}
				}				
				
				return (debugStatus !=null && debugStatus.equalsIgnoreCase("true"));	
				} catch(Exception e){
					//ibsJobError(e.getMessage());
					return false;
			}
		}
	
	private static ArrayList<String> callerClassInfo() {
		
		ArrayList<String> list = new ArrayList<String>();
		try{
			final Throwable throwable = new Throwable();
			 final StackTraceElement methodCaller = throwable.getStackTrace()[2];
			 if(methodCaller!= null && methodCaller.getClassName()!= null && methodCaller.getMethodName() !=null){
				 list.add(methodCaller.getClassName());
				 list.add(methodCaller.getMethodName());
				 list.add(""+methodCaller.getLineNumber());
			 } else {
				 list.add("");
				 list.add("");
				 list.add("");
			 }
			 
		} catch(Exception e){
			//ibsJobError(e.getMessage());
			list.add("");
			list.add("");
			list.add("");
		}		
		return list;		
	}
	
	private static String getLoggedInUserName() {
		String userName = null;
		try {
			Object principal = SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				UserDetails userDetails = ((UserDetails) principal);
				if(userDetails !=null){
					userName =  userDetails.getUsername();				
				}
			} 
			
			if(userName != null && userName.trim().length() > 0) {					
				return userName;
			}  else {
				return "";
			}
		} catch(Exception e){
			//ibsJobError(e.getMessage());
			return "";
		}
	}
	
	
}
