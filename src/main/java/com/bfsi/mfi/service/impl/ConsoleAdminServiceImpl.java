package com.bfsi.mfi.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.cbs.adapter.AdapterFactory;
import com.bfsi.mfi.cbs.adapter.CbsActionType;
import com.bfsi.mfi.cbs.adapter.CbsBranchInfoServiceAdapter;
import com.bfsi.mfi.dao.ConsoleAdminDao;
import com.bfsi.mfi.dao.SystemParameterDao;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ConsoleAdminService;
import com.bfsi.mfi.util.ConsoleTaskHelper;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 * 
 */
@Service("consoleAdminService")
public class ConsoleAdminServiceImpl implements ConsoleAdminService {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private static Map<String, String> PREVIOUS_TASK_MAP;
	private static final String BUSDATE_NAM_SYSPARAM = "APP_DATE_TODAY";
	static {
		PREVIOUS_TASK_MAP = new HashMap<String, String>();

		PREVIOUS_TASK_MAP.put("MARK_BUSINESS_DATE_UPLOAD", null);
		PREVIOUS_TASK_MAP.put("MARK_IBS_CLEANUP", "MARK_BUSINESS_DATE_UPLOAD");
		PREVIOUS_TASK_MAP.put("MARK_STAGE_DATA_UPLOAD", "MARK_IBS_CLEANUP");
		PREVIOUS_TASK_MAP.put("MARK_IBS_UPLOAD", "MARK_STAGE_DATA_UPLOAD");
		PREVIOUS_TASK_MAP.put("MARK_TXN_INPUT", "MARK_IBS_UPLOAD");
		PREVIOUS_TASK_MAP.put("MARK_START_SERVICES", "MARK_TXN_INPUT");
		// PREVIOUS_TASK_MAP.put("MARK_STOP_SERVICES", "MARK_START_SERVICES");
		PREVIOUS_TASK_MAP.put("MARK_STOP_TXN_INPUT", "MARK_START_SERVICES");
		PREVIOUS_TASK_MAP.put("MARK_STOP_FIN_INPUT", "MARK_STOP_TXN_INPUT");
		PREVIOUS_TASK_MAP
				.put("MARK_END_OF_BUSINESS_DAY", "MARK_STOP_FIN_INPUT");
	}
	private static final String IS_CONSOLE_CHECKEDIN_YES = "Y";
	private static final String IS_CONSOLE_CHECKEDIN_NO = "N";
	private static final String IS_TASK_HAS_ERROR_YES = "Y";
	private static final String TASK_STATUS_RUNNING = "R";
	private static final String TASK_STATUS_COMPLETED = "C";
	private static final String EOD_CHARTER_CODE = "MARK_END_OF_BUSINESS_DAY";
	private static final String DAY_BEGIN_CHARTER_CODE = "MARK_BUSINESS_DATE_UPLOAD";
	//private static final String FULL_RESET_CHARTER_CODE = "MARK_GROUP_1_RESET";
	@Autowired
	private SystemParameterDao systemParameterDao;

	@Autowired
	private ConsoleAdminDao consoleAdminDao;

	@Autowired
	ConsoleTaskHelper consoleTaskHelper;

	@Override
	public synchronized ServiceResponse startSubTask(String p_charterCode) {
		ServiceResponse l_serRes = new ServiceResponse();
		try {
			if (!canUserStartTask()) {
				l_serRes.setMessageCode("MFI110001");
				return l_serRes;
			}
			
			Date l_cbsCurrentBusinessDate = getCurrentBusinessDateFromCbs();
			if(l_cbsCurrentBusinessDate==null){  
				l_serRes.setMessageCode("MFI110016");
			return l_serRes;
			}
			
			if(!isValidDateFromCbs(l_cbsCurrentBusinessDate))
			{  
				l_serRes.setMessageCode("MFI110019");
				return l_serRes;
			}
			
			boolean l_isNewBusinessDay = isNewBusinessDay(l_cbsCurrentBusinessDate);
			if (!p_charterCode.equals(DAY_BEGIN_CHARTER_CODE)
					&& l_isNewBusinessDay) {
				l_serRes.setMessageCode("MFI110018");
				return l_serRes;
			}

			if (p_charterCode.equals(DAY_BEGIN_CHARTER_CODE)
					&& isEodTaskCompleted() && !l_isNewBusinessDay) {
				l_serRes.setMessageCode("MFI110015");
				return l_serRes;
			}

			if (!p_charterCode.equals(DAY_BEGIN_CHARTER_CODE) && !p_charterCode.equals("MARK_GROUP_7_RESET")
					&& isEodTaskCompleted()) {
				l_serRes.setMessageCode("MFI110015");
				return l_serRes;
			}

			if (p_charterCode.equals(DAY_BEGIN_CHARTER_CODE)
					&& l_isNewBusinessDay) {
				consoleAdminDao.forcePendingTaskComplete(getLoggedinUser());
			}

			if (p_charterCode.equals(DAY_BEGIN_CHARTER_CODE)
					&& isTaskRunning(p_charterCode) && !l_isNewBusinessDay) {
				l_serRes.setMessageCode("MFI110003");
				return l_serRes;
			}
			if (p_charterCode.equals(DAY_BEGIN_CHARTER_CODE)
					&& isTaskCompleted(p_charterCode) && !l_isNewBusinessDay) {
				l_serRes.setMessageCode("MFI110004");
				return l_serRes;
			}

			if (p_charterCode.equals(DAY_BEGIN_CHARTER_CODE))
				return l_serRes = handleTask(p_charterCode);

			if (p_charterCode.contains("MARK_GROUP")
					|| p_charterCode.equals("MARK_STOP_SERVICES")) {

				if (isAnyTaskRunning()) {
					l_serRes.setMessageCode("MFI110014");
					return l_serRes;
				}

				return l_serRes = handleTask(p_charterCode);

			}
			if (isPreviousTaskRunning(p_charterCode)) {
				l_serRes.setMessageCode("MFI110013");
				return l_serRes;
			}
			if (!isPreviousTaskCompleted(p_charterCode)) {
				l_serRes.setMessageCode("MFI110002");
				return l_serRes;
			}

			if (isPreviousTaskHasError(p_charterCode)) {
				l_serRes.setMessageCode("MFI110012");
				return l_serRes;
			}
			if (isTaskRunning(p_charterCode)) {
				l_serRes.setMessageCode("MFI110003");
				return l_serRes;
			}
			if (isTaskCompleted(p_charterCode)) {
				l_serRes.setMessageCode("MFI110004");
				return l_serRes;
			}
			l_serRes = handleTask(p_charterCode);
		} catch (Exception e) {
			l_serRes.setStatus(false);
			l_serRes.setMessageCode("MFI110009");
			LoggerUtil.ibsJobError("Unhandled exception", e);
		}
		return l_serRes;
	}

	private ServiceResponse handleTask(String p_charterCode) {
		ServiceResponse l_serRes = new ServiceResponse();
		try {		
		consoleAdminDao.updateTaskStartStatus(p_charterCode, getLoggedinUser(),  consoleAdminDao.getCurrentBusinessDateTime());
		consoleAdminDao.clearLogs();
		consoleAdminDao.clearCharterExceptions(p_charterCode);
		l_serRes = consoleTaskHelper.doTask(p_charterCode);
		if (l_serRes.getStatus())
			l_serRes.setMessageCode("MFI110008");
		else
			l_serRes.setMessageCode("MFI110009");
		} catch (Exception e) {
			consoleAdminDao.updateTaskEndStatus(p_charterCode, consoleAdminDao.getCurrentBusinessDateTime(), true);
			l_serRes.setMessageCode("MFI110009");
			l_serRes.setStatus(false);
			LoggerUtil.ibsJobError("Unhandled exception", e);
		}
		return l_serRes;
	}

	private boolean isNewBusinessDay(Date p_cbsCurrentBusinessDate) {
		try {
			String l_sysCurBusDtStr = systemParameterDao
					.getParamValue(BUSDATE_NAM_SYSPARAM);
			if (l_sysCurBusDtStr == null)
				return true;
			
			Date l_systemCurrentBusinessDate = new SimpleDateFormat(
					"dd-MMM-yyyy").parse(l_sysCurBusDtStr);
			LoggerUtil.ibsJobDebug("Business dt from app: "
					+ l_systemCurrentBusinessDate);
			LoggerUtil.ibsJobDebug("Business dt from cbs: "
					+ p_cbsCurrentBusinessDate);

			return !(new java.sql.Date(p_cbsCurrentBusinessDate.getTime()))
					.toString().equals(
							(new java.sql.Date(l_systemCurrentBusinessDate
									.getTime())).toString());

		} catch (Exception e) {
			throw new ServiceException("system error while isNewBusinessDay", e);
		}
	}

	private Date getCurrentBusinessDateFromCbs() {
		try {
			CbsBranchInfoServiceAdapter l_adapter = (CbsBranchInfoServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.CBSBUSINESSDATE);
			l_adapter.setServletContext(getServletContext());
			return l_adapter.getBranchDate();
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Exception while getting current business date from CBS",
							e);
		}
		return null;
	}

	private boolean isValidDateFromCbs(Date p_cbsCurrentBusinessDate){
		try {
			String l_sysCurBusDtStr = systemParameterDao
					.getParamValue(BUSDATE_NAM_SYSPARAM);
			if (l_sysCurBusDtStr == null)
				return true;
			Date l_systemCurrentBusinessDate = new SimpleDateFormat(
					"dd-MMM-yyyy").parse(l_sysCurBusDtStr);
			
			return p_cbsCurrentBusinessDate.after(l_systemCurrentBusinessDate) || (new java.sql.Date(p_cbsCurrentBusinessDate.getTime()))
					.toString().equals(
							(new java.sql.Date(l_systemCurrentBusinessDate
									.getTime())).toString());	
		} catch (Exception e) {
			throw new ServiceException("system error while isValidDateFromCbs", e);
		}
		
		
		
	}
	@SuppressWarnings("unused")
	private boolean isAnyTaskPending() {
		int l_count = consoleAdminDao.getPendingTaskCount();
		return l_count == 0 ? false : true;

	}

	private boolean isEodTaskCompleted() {
		return isTaskCompleted(EOD_CHARTER_CODE);
	}

	private boolean isAnyTaskRunning() {

		int l_count = consoleAdminDao.getRunningTaskCount();
		return l_count == 0 ? false : true;
	}

	private boolean isTaskRunning(String p_charterCode) {

		return consoleAdminDao.getTaskStatus(p_charterCode).equals(
				TASK_STATUS_RUNNING);
	}

	private boolean isTaskCompleted(String p_charterCode) {

		return consoleAdminDao.getTaskStatus(p_charterCode).equals(
				TASK_STATUS_COMPLETED);
	}

	private boolean isPreviousTaskCompleted(String p_charterCode) {

		String l_previousCharterCode = PREVIOUS_TASK_MAP.get(p_charterCode);
		//System.out.println("Prevoius task: " + l_previousCharterCode);
		if (l_previousCharterCode == null)
			return true;
		return consoleAdminDao.getTaskStatus(l_previousCharterCode).equals(
				TASK_STATUS_COMPLETED);
	}

	private boolean isPreviousTaskRunning(String p_charterCode) {

		String l_previousCharterCode = PREVIOUS_TASK_MAP.get(p_charterCode);
		//System.out.println("Prevoius task: " + l_previousCharterCode);
		if (l_previousCharterCode == null)
			return false;
		return consoleAdminDao.getTaskStatus(l_previousCharterCode).equals(
				TASK_STATUS_RUNNING);
	}

	private boolean isPreviousTaskHasError(String p_charterCode) {
		String l_previousCharterCode = PREVIOUS_TASK_MAP.get(p_charterCode);
		//System.out.println("Prevoius task: " + l_previousCharterCode);
		if (l_previousCharterCode == null)
			return false;
		return consoleAdminDao.getTaskErrorStatus(l_previousCharterCode)
				.equals(IS_TASK_HAS_ERROR_YES);

	}

	private boolean canUserStartTask() {

		return getConsoleCheckedinStatus().equals(IS_CONSOLE_CHECKEDIN_YES)
				&& isCurrentUserCheckedinConsole();
	}

	@Override
	public synchronized ServiceResponse doConsoleCheckout() {

		ServiceResponse l_serRes = new ServiceResponse();

		if (getConsoleCheckedinStatus().equals(IS_CONSOLE_CHECKEDIN_NO)) {
			l_serRes.setMessageCode("MFI110005");
			return l_serRes;
		}

		if (!isCurrentUserCheckedinConsole()) {
			l_serRes.setMessageCode("MFI110006");
			return l_serRes;
		}
		systemParameterDao.updateSystemParameterFor("IS_CONSOLE_CHECHEDIN",
				IS_CONSOLE_CHECKEDIN_NO);
		systemParameterDao.updateSystemParameterFor("CONSOLE_CHECKEDIN_USER",
				"");
		l_serRes.setMessageCode("MFI110011");
		l_serRes.setStatus(true);
		return l_serRes;
	}

	@Override
	public synchronized ServiceResponse doConsoleCheckin() {

		ServiceResponse l_serRes = new ServiceResponse();
		if (getConsoleCheckedinStatus().equals(IS_CONSOLE_CHECKEDIN_YES)) {
			l_serRes.setMessageCode("MFI110007");
			return l_serRes;
		}
		systemParameterDao.updateSystemParameterFor("IS_CONSOLE_CHECHEDIN",
				IS_CONSOLE_CHECKEDIN_YES);
		systemParameterDao.updateSystemParameterFor("CONSOLE_CHECKEDIN_USER",
				getLoggedinUser());
		l_serRes.setStatus(true);
		l_serRes.setMessageCode("MFI110010");
		return l_serRes;
	}

	private boolean isCurrentUserCheckedinConsole() {
		return getLoggedinUser().equals(getCheckedinUser());
	}

	private String getCheckedinUser() {
		String l_user = systemParameterDao
				.getParamValue("CONSOLE_CHECKEDIN_USER");
		return l_user == null ? "" : l_user;

	}

	private String getConsoleCheckedinStatus() {
		String l_status = systemParameterDao
				.getParamValue("IS_CONSOLE_CHECHEDIN");
		return l_status == null ? "" : l_status;
	}

	private String getLoggedinUser() {

		String userName = null;
		try {
			Object principal = SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				UserDetails userDetails = ((UserDetails) principal);
				if (userDetails != null) {
					userName = userDetails.getUsername();
				}
			}

		} catch (Exception e) {
			throw new ServiceException("Could not locate loggedin user id");
		}
		return userName;
	}

	private ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
	}

}
