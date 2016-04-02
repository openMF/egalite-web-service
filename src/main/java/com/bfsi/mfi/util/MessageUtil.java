package com.bfsi.mfi.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import com.bfsi.mfi.messages.AppMessageField;
import com.bfsi.mfi.messages.ApplicationMessages;
import java.text.MessageFormat;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * MessageUtil
 * 
 */
public class MessageUtil {

	public static void addInfoMessage(String summary, Object... args) {
		addMessage(FacesMessage.SEVERITY_INFO, true, summary, "", args);
	}

	public static void addInfoMessage(String summary, String detail,
			Object... args) {
		addMessage(FacesMessage.SEVERITY_INFO, true, summary, detail, args);
	}

	public static void addInfoMessageWithoutKey(String summary, String detail,
			Object... args) {
		addMessage(FacesMessage.SEVERITY_INFO, false, summary, detail, args);
	}

	public static void addErrorMessage(String summary, Object... args) {
		addMessage(FacesMessage.SEVERITY_ERROR, true, summary, "", args);
	}

	public static void addErrorMessage(String summary, String detail,
			Object... args) {
		addMessage(FacesMessage.SEVERITY_ERROR, true, summary, detail, args);
	}

	public static void addErrorMessageWithoutKey(String summary, String detail,
			Object... args) {
		addMessage(FacesMessage.SEVERITY_ERROR, false, summary, detail, args);
	}

	public static void addWarningMessageWithoutKey(String summary,
			String detail, Object... args) {
		addMessage(FacesMessage.SEVERITY_WARN, false, summary, detail, args);
	}

	public static void addMessage(Severity severity, boolean useResourceBundle,
			String summary, String detail, Object... args) {
		FacesContext context = FacesContext.getCurrentInstance();
		String message = (useResourceBundle) ? getMessage(summary, context)
				: summary;
		if (args != null) {
			message = MessageFormat.format(message, args);
		}
		context.addMessage(null, new FacesMessage(severity, message, detail));
		context.getExternalContext().getFlash().setKeepMessages(true);
	}

	public static String getMessage(String str, FacesContext context) {
		ResourceBundle bundle = context.getApplication().getResourceBundle(
				context, "msg");
		String message = bundle.getString(str);
		return message;
	}

	public static String getMessage(String p_messageCode, Object... p_params) {
		if (p_params == null)
			return ApplicationMessages.getMessage(p_messageCode);
		else
			return ApplicationMessages.getMessage(p_messageCode, p_params);
	}

	public static void addMessage(String p_messageCode, Object... p_params) {
		Map<Object, String> l_msgMap = null;
		if (p_params == null)
			l_msgMap = ApplicationMessages.getMessageDetails(p_messageCode);
		else
			l_msgMap = ApplicationMessages.getMessageDetails(p_messageCode,
					p_params);
		if (l_msgMap == null) {
			addErrorMessageWithoutKey("Message not found  for code: "
					+ p_messageCode, "");
			LoggerUtil.ibsJobError("Message not found  for code: "
					+ p_messageCode);
		} else
			addMessageType(l_msgMap, p_messageCode);
	}

	private static void addMessageType(Map<Object, String> p_msgMap,
			String p_messageCode) {
		try {
			String l_msg = p_messageCode + " : "
					+ p_msgMap.get(AppMessageField.MSGDESC);
			LoggerUtil.ibsJobDebug("Adding Message to user UI-> " + l_msg);
			if (p_msgMap.get(AppMessageField.MSGTYPE).equals("I"))
				addInfoMessageWithoutKey(l_msg, "");
			else if (p_msgMap.get(AppMessageField.MSGTYPE).equals("E"))
				addErrorMessageWithoutKey(l_msg, "");
			else
				addWarningMessageWithoutKey(l_msg, "");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unexpected error while adding message to UI: "
					+ p_messageCode, e);
			addErrorMessageWithoutKey("Message not found  for code: "
					+ p_messageCode, "");
		}

	}
}
