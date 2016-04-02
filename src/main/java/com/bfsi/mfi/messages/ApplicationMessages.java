package com.bfsi.mfi.messages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bfsi.mfi.rest.model.Message;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * 
 * @author Shabu
 * @date 11-Aug-2014
 * @version 1.0
 * @class ApplicationMessages.java
 * @description Java class which is responsible for loading the messages and handling it
 * 
 */
public final class ApplicationMessages {

	private static List<Message> MESSAGES = null;
	private static Map<String, Map<Object, String>> MESSAGESMAP = null;
	private static final String DEFAULT_LAN = "EN";
	private static final String DATA_SOURCE_NAME = "dataSource";
	private static final String LANG_KEY = "lang";
	private static final String SUB_SYS_ALL = "A";

	private ApplicationMessages() {
	}
/**
 * loads the messages from DB. It should be called at application initialisation
 */
	public static void loadMessages() {
		LoggerUtil.ibsJobDebug("Starting Loading of application messages");
		if (MESSAGESMAP == null) {
			synchronized (ApplicationMessages.class) {
				if (MESSAGESMAP == null) {
					try {
						loadMessagesFromDB();
					} catch (Exception e) {
						LoggerUtil.ibsJobError("Error while loading the messages from DB",e);
						MESSAGES = null;
						MESSAGESMAP = null;
					}
				}
			}
		}
		LoggerUtil.ibsJobDebug("Loading of application messages has completed");

	}

	private static void loadMessagesFromDB() throws SQLException {
		MESSAGES = new ArrayList<Message>();
		MESSAGESMAP = new HashMap<String, Map<Object, String>>();
		Message l_msg = null;
		Map<Object, String> l_errMap = null;
		String l_errCode, l_errDesc, l_lang, l_errType, l_subSys, l_msgType = null;
		
		Connection l_con = getDataSource().getConnection();
		PreparedStatement l_st = l_con
				.prepareStatement(ApplicationQuery.QUERY_GET_ALL_MESSAGES);
		ResultSet l_rs = l_st.executeQuery();

		while (l_rs.next()) {
			l_msg = new Message();
			l_errMap = new HashMap<Object, String>();
			l_errCode = l_rs.getString("MSG_CODE");
			l_lang = l_rs.getString("LANG");
			l_errDesc = l_rs.getString("MSG_DESC");
			l_errType = l_rs.getString("ERR_TYPE");
			l_subSys = l_rs.getString("SUB_SYS");
			l_msgType = l_rs.getString("MSG_TYPE");

			l_msg.setMsgCode(l_errCode);
			l_msg.setLang(l_lang);
			l_msg.setDesc(l_errDesc);
			l_msg.setErrorType(l_errType);
			l_msg.setSubSystem(l_subSys);
			l_msg.setMsgType(l_msgType);

			l_errMap.put(AppMessageField.MSGCODE, l_errCode);
			l_errMap.put(AppMessageField.MSGDESC, l_errDesc);
			l_errMap.put(AppMessageField.ERRTYPE, l_errType);
			l_errMap.put(AppMessageField.LANG, l_lang);
			l_errMap.put(AppMessageField.SUBSYS, l_subSys);
			l_errMap.put(AppMessageField.MSGTYPE, l_msgType);

			MESSAGES.add(l_msg);
			MESSAGESMAP.put((l_errCode + l_lang).toUpperCase(), l_errMap);
		}
	}
/**
 *Returns the language specific message string
 */
	public static String getMessage(String p_messageId, Object[] p_args) {

		if (MESSAGESMAP == null)
			loadMessages();
		
		Map<Object, String> l_msgMap = getMessageMapForKey(p_messageId, p_args);					
		if (l_msgMap != null)
			return l_msgMap.get(AppMessageField.MSGDESC);
	
		return "Could not find message with id " + p_messageId
				+ " and language " + getUserLanguage();
	}
	/**
	 *Returns the language specific message string
	 */
	public static String getMessage(String p_errorCode) {
		return getMessage(p_errorCode, null);
	}
	/**
	 *Returns the language specific message Map
	 */
	public static Map<Object, String> getMessageDetails(String p_messageId) {
		return getMessageDetails(p_messageId, null);

	}
	
	/**
	 *Returns the language specific message Map
	 */
	public static Map<Object, String> getMessageDetails(String p_messageId,
			Object[] p_args) {
		if (MESSAGESMAP == null)
			loadMessages();
		return getMessageMapForKey(p_messageId, p_args);
	}

	private static Map<Object, String> getMessageMapForKey(String p_messageId,
			Object[] p_args) {

		if (MESSAGESMAP == null)
			loadMessages();
				
		Map<Object, String> l_msgMap = null;
		Map<Object, String> l_msgResMap = null;
		String l_formatedMsg = null;
		String l_lang=getUserLanguage();
		try {
			if ((l_msgMap =getMessageMap(p_messageId, l_lang)) !=null) {
				if (p_args != null && p_args.length > 0)
					l_formatedMsg = MessageFormat.format(
							l_msgMap.get(AppMessageField.MSGDESC), p_args);
				else
					l_formatedMsg = l_msgMap.get(AppMessageField.MSGDESC);
				l_msgResMap = new HashMap<Object, String>(l_msgMap);
				l_msgResMap.put(AppMessageField.MSGDESC, l_formatedMsg);
				return l_msgResMap;

			}
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Error while getting message for the default language " +DEFAULT_LAN +" OR user language "+l_lang+" and msg code"+ p_messageId,e);
		}

		return null;
	}
	
	private static  Map<Object, String> getMessageMap(String p_messageId, String p_lang){
		
		if (MESSAGESMAP.containsKey((p_messageId + p_lang).toUpperCase())) 
			return MESSAGESMAP.get((p_messageId + p_lang).toUpperCase());
		else if (MESSAGESMAP.containsKey((p_messageId + DEFAULT_LAN).toUpperCase())) {
			LoggerUtil.ibsJobError("Could not find message with id " + p_messageId+ " and language " + p_lang);
			return MESSAGESMAP.get((p_messageId + DEFAULT_LAN).toUpperCase());
		}
		else{
			LoggerUtil.ibsJobError("could not find the message for the default language " +DEFAULT_LAN +" OR user language "+p_lang+" and msg code "+ p_messageId);
			return null;
		}
	}
	
	/**
	 *Returns the collection of subsystem specific messages
	 */
	public static List<Message> getAllMessagesForSubSystem(String p_subSys) {
		List<Message> l_subSysMessages = new ArrayList<Message>();
		if (MESSAGES == null)
			loadMessages();

		if (p_subSys == null)
			return MESSAGES;
		for (Message l_msg : MESSAGES) {
			if (p_subSys.equals(l_msg.getSubSystem())
					|| l_msg.getSubSystem().equals(SUB_SYS_ALL))
				l_subSysMessages.add(l_msg);
		}
		return l_subSysMessages;
	}
	/**
	 *Returns the collection of all the messages
	 */
	public static List<Message> getAllMessages() {
		return getAllMessagesForSubSystem(null);
	}

	private static String getUserLanguage() {
		try {
			ExternalContext l_externalContext = FacesContext
					.getCurrentInstance().getExternalContext();
			Map<String, Object> l_sessionMap = l_externalContext
					.getSessionMap();
			if (l_sessionMap.containsKey(LANG_KEY))
				return l_sessionMap.get(LANG_KEY).toString();
			LoggerUtil.ibsJobDebug("User language is not set for the logged in user");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Error while getting user language from user session",e);
		}
		LoggerUtil.ibsJobDebug("default language for the user is "+DEFAULT_LAN);
		return DEFAULT_LAN;

	}

	private static DataSource getDataSource() {
		WebApplicationContext l_springContext = WebApplicationContextUtils
				.getWebApplicationContext((ServletContext) FacesContext
						.getCurrentInstance().getExternalContext().getContext());
		return (DataSource) l_springContext.getBean(DATA_SOURCE_NAME);
	}
}
