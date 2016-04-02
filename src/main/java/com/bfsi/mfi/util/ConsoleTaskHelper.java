package com.bfsi.mfi.util;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import com.bfsi.mfi.job.TransactionListener;
import com.bfsi.mfi.service.CbsDataSyncService;

/**
 * 
 * @author Shabu
 * 
 */
@Service
public class ConsoleTaskHelper {

	private static final String BUSDATE_NAM_SYSPARAM = "APP_DATE_TODAY";

	@Autowired
	private ConsoleAdminDao consoleAdminDao;

	@Autowired
	private TransactionListener transactionListener;

	@Autowired
	private CbsDataSyncService cbsDataSyncService;

	@Autowired
	private SystemParameterDao systemParameterDao;
	
	private static final Object LOCK=new Object();

	public ServiceResponse doTask(String p_charterCode) {
		ServiceResponse l_serRes = new ServiceResponse();
		dispatchTask(p_charterCode, getServletContext(), getLoggedinUser());
		l_serRes.setStatus(true);
		return l_serRes;
	}

	private ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
	}

	private void dispatchTask(final String p_charterCode,
			final ServletContext p_ServletContext, final String p_userId) {

		Thread task = new Thread(new Runnable() {

			@Override
			public void run() {
				ServiceResponse l_serRes = new ServiceResponse();
				Date l_taskBeginTime=null;
				synchronized (LOCK) {
					try {					
							l_taskBeginTime=consoleAdminDao.getCurrentBusinessDateTime();									
									
							if (p_charterCode.equals("MARK_BUSINESS_DATE_UPLOAD")){
									l_serRes = performBusinessDayInit(p_ServletContext,
											p_userId);
									consoleAdminDao.updateTaskStartStatus(p_charterCode, p_userId,l_taskBeginTime);
									if(l_serRes.getStatus())
										performStopServices(p_ServletContext);
									consoleAdminDao.resetTaskStatus("MARK_GROUP_1_RESET");
							}
							else if (p_charterCode.equals("MARK_IBS_CLEANUP"))
								l_serRes = performIbsCleanup(p_userId);
							else if (p_charterCode.equals("MARK_STAGE_DATA_UPLOAD"))
								l_serRes = performStagingUpload(p_ServletContext,
										p_userId);		
							else if (p_charterCode.equals("MARK_IBS_UPLOAD")){
								l_serRes = performAgendaCreation(p_userId);
								
									consoleAdminDao.resetTaskStatus("MARK_GROUP_2_RESET");	
							}
							else if (p_charterCode.equals("MARK_TXN_INPUT")){
								l_serRes = performMarkTI(p_userId);
								
									consoleAdminDao.resetTaskStatus("MARK_GROUP_3_RESET");	
								}
							else if (p_charterCode.equals("MARK_START_SERVICES")){
								l_serRes = performStartServices(p_ServletContext);
								
									consoleAdminDao.resetTaskStatus("MARK_STOP_SERVICES");	
							}
							else if (p_charterCode.equals("MARK_STOP_SERVICES"))
								l_serRes = performStopServices(p_ServletContext);
					
							else if (p_charterCode.equals("MARK_STOP_TXN_INPUT")){
								performStopServices(p_ServletContext);
								consoleAdminDao.forceTaskComplete("MARK_START_SERVICES", p_userId);
								l_serRes = performMarkStopTI(p_userId);
								
									consoleAdminDao.resetTaskStatus("MARK_GROUP_5_RESET");	
							}
							else if (p_charterCode.equals("MARK_STOP_FIN_INPUT")){
								performStopServices(p_ServletContext);
								consoleAdminDao.forceTaskComplete("MARK_START_SERVICES", p_userId);
								l_serRes = performMarkStopFI(p_userId);
								
									consoleAdminDao.resetTaskStatus("MARK_GROUP_6_RESET");	
							}
							else if (p_charterCode.equals("MARK_END_OF_BUSINESS_DAY")){
								performStopServices(p_ServletContext);
								consoleAdminDao.forceTaskComplete("MARK_START_SERVICES", p_userId);						
								l_serRes = performMarkEOD(p_userId);
								consoleAdminDao.resetTaskStatus("MARK_GROUP_7_RESET");	
							}
							else if (p_charterCode.contains("MARK_GROUP")){
								l_taskBeginTime=consoleAdminDao.getCurrentBusinessDateTime();
								l_serRes = performGrpResetFor(p_charterCode,
										p_userId);
								consoleAdminDao.updateTaskStartStatus(p_charterCode, p_userId,l_taskBeginTime);
							}
					} catch (Exception e) {
						LoggerUtil.ibsJobError("Error while starting the task: "
							+ p_charterCode, e);
						l_serRes.setStatus(false);
					}
					finally{
						if (l_serRes.getStatus())
							consoleAdminDao.updateTaskEndStatus(p_charterCode,consoleAdminDao.getCurrentBusinessDateTime(), false);
						else
							consoleAdminDao.updateTaskEndStatus(p_charterCode,consoleAdminDao.getCurrentBusinessDateTime(), true);
					}
				
				}
			}
		});
		task.start();

	}

	private ServiceResponse performBusinessDayInit(
			ServletContext p_servletContext, String p_userId) {

		ServiceResponse l_serRes = new ServiceResponse();
		l_serRes.setStatus(consoleAdminDao.beginBusinessDay(p_userId));
		if (!l_serRes.getStatus())
			return l_serRes;

		try {
			CbsBranchInfoServiceAdapter l_adapter = (CbsBranchInfoServiceAdapter) AdapterFactory
					.getAdapter(CbsActionType.CBSBUSINESSDATE);
			l_adapter.setServletContext(p_servletContext);
			Date l_currentBusinessDate = l_adapter.getBranchDate();
			systemParameterDao.updateSystemParameterFor(BUSDATE_NAM_SYSPARAM,
					getDateString(l_currentBusinessDate));
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Exception while getting/updating business date", e);
			l_serRes.setStatus(false);
			return l_serRes;
		}

		consoleAdminDao.updateBusinessDateForAll(getCurrentBusinessDate());
		l_serRes.setStatus(true);
		return l_serRes;
	}

	private ServiceResponse performIbsCleanup(String p_userId) {

		ServiceResponse l_serRes = new ServiceResponse();
		l_serRes.setStatus(consoleAdminDao.beginIbsCleanup(getCurrentBusinessDate(),
				p_userId));
		return l_serRes;
	}

	private ServiceResponse performStagingUpload(
			ServletContext p_ServletContext, String p_userId) {

		ServiceResponse l_serRes = new ServiceResponse();
		try {
			cbsDataSyncService.syncCbsData(p_ServletContext);
			l_serRes.setStatus(true);
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Exception while data extraction from CBS",
					e);
		}

		return l_serRes;
	}

	private ServiceResponse performAgendaCreation(String p_userId) {

		ServiceResponse l_serRes = new ServiceResponse();
		l_serRes.setStatus(consoleAdminDao.beginAgendaCreation(
				getCurrentBusinessDate(), p_userId));
		return l_serRes;
	}
	
	private ServiceResponse performGrpResetFor(String p_charterCode, String p_userId) {
		ServiceResponse l_serRes = new ServiceResponse();
		l_serRes.setStatus(consoleAdminDao.beginGrpResetForAll(getCurrentBusinessDate(), 
				p_charterCode, p_userId));
		return l_serRes;
	}

	private ServiceResponse performMarkTI(String p_userId) {

		ServiceResponse l_serRes = new ServiceResponse();
		l_serRes.setStatus(consoleAdminDao.beginMarkStartTxnInput(
				getCurrentBusinessDate(), p_userId));
		return l_serRes;
	}

	private ServiceResponse performStartServices(ServletContext p_servletContext) {

		ServiceResponse l_serRes = new ServiceResponse();
		try {
			transactionListener.startJob(p_servletContext);
			l_serRes.setStatus(true);
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError("Exception while starting background job", e);
		}

		return l_serRes;
	}

	private ServiceResponse performStopServices(ServletContext p_servletContext) {

		ServiceResponse l_serRes = new ServiceResponse();
		try {
			transactionListener.stopJob(p_servletContext);
			consoleAdminDao.resetTaskStatus("MARK_START_SERVICES");
			l_serRes.setStatus(true);
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError("Exception while stopping background job", e);
		}
		return l_serRes;
	}

	private ServiceResponse performMarkStopTI(String p_userId) {

		ServiceResponse l_serRes = new ServiceResponse();
		l_serRes.setStatus(consoleAdminDao.beginMarkStopTxnInput(
				getCurrentBusinessDate(), p_userId));
		return l_serRes;
	}

	private ServiceResponse performMarkStopFI(String p_userId) {

		ServiceResponse l_serRes = new ServiceResponse();
		l_serRes.setStatus(consoleAdminDao.beginMarkStopFinInput(
				getCurrentBusinessDate(), p_userId));
		return l_serRes;
	}

	private ServiceResponse performMarkEOD(String p_userId) {

		ServiceResponse l_serRes = new ServiceResponse();
		l_serRes.setStatus(consoleAdminDao.beginMarkEod(getCurrentBusinessDate(),
				p_userId));
		return l_serRes;
	}

	private String getDateString(Date p_date) {

		DateFormat l_df = new SimpleDateFormat("dd-MMM-yyyy");
		return l_df.format(p_date).toUpperCase();
	}

	public String getLoggedinUser() {

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

	public Date getCurrentBusinessDate() {

		String l_dtStr = systemParameterDao.getParamValue(BUSDATE_NAM_SYSPARAM);
		DateFormat l_df = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			return l_df.parse(l_dtStr);
		} catch (Exception e) {

			throw new ServiceException(
					"exception while parsing the date from sys param", e);
		}
	}
}
