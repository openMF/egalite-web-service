package com.bfsi.mfi.dao.jdbc;

import java.util.Date;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.ConsoleAdminDao;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 * 
 */
@Repository
public class ConsoleAdminJdbcDao extends BaseJdbcDao implements ConsoleAdminDao {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@Override
	public String getTaskStatus(String p_charterCode) {

		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("charterCode", p_charterCode);
		return jdbcTemplate.queryForObject(ApplicationQuery.QUERY_GET_TASK_STATUS, l_params,
				String.class);
	}

	@Override
	public void updateTaskStartStatus(String p_charterCode, String p_userId,
			Date p_busDate) {

		Map<String, Object> l_params = new HashMap<String, Object>();
		//System.out.println("Chartyer code: " + p_charterCode);
		l_params.put("charterCode", p_charterCode);
		l_params.put("userId", p_userId);
		l_params.put("status", "R");
		if (p_busDate == null)
			l_params.put("sysDate", getAppDateTime());
		else
			l_params.put("sysDate", p_busDate);
		jdbcTemplate.update(ApplicationQuery.QUERY_UPDATE_TASK_START_STATUS, l_params);
	}

	@Override
	public void updateTaskEndStatus(String p_charterCode, Date p_busDate,
			boolean p_hasError) {

		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("charterCode", p_charterCode);
		l_params.put("status", "C");
		l_params.put("errorSuccess", "N");
		if (p_hasError)
			l_params.put("errorStatus", "Y");
		else
			l_params.put("errorStatus", "N");
		if (p_busDate == null)
			l_params.put("sysDate", getAppDateTime());
		else
			l_params.put("sysDate", p_busDate);
		jdbcTemplate.update(ApplicationQuery.QUERY_UPDATE_TASK_END_STATUS, l_params);
	}

	@Override
	public boolean beginBusinessDay(String p_userId) {

		Map<String, Object> l_procRes = null;

		ProcHandler procHandler = new ProcHandler(
				ApplicationQuery.PROC_BEGIN_BUSINESS_DAY);

		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("userId", p_userId, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		LoggerUtil
				.ibsJobDebug("PROC Response fn_exec_begin_all:: " + l_procRes);
		if (l_procRes.get("result").toString().equals("0"))
			return true;

		return false;
	}

	@Override
	public boolean beginIbsCleanup(Date p_businessDate, String p_userId) {

		Map<String, Object> l_procRes = null;

		ProcHandler procHandler = new ProcHandler(
				ApplicationQuery.PROC_BEGIN_IBS_CELANUP);

		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("date", p_businessDate, Types.DATE);
		procHandler.registerInputParam("userId", p_userId, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		LoggerUtil
				.ibsJobDebug("PROC Response fn_exec_begin_all:: " + l_procRes);
		if (l_procRes.get("result").toString().equals("0"))
			return true;

		return false;
	}

	@Override
	public boolean beginAgendaCreation(Date p_businessDate, String p_userId) {
		Map<String, Object> l_procRes = null;

		ProcHandler procHandler = new ProcHandler(
				ApplicationQuery.PROC_BEGIN_AGENDA_CREATION);

		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("date", p_businessDate, Types.DATE);
		procHandler.registerInputParam("userId", p_userId, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		LoggerUtil.ibsJobDebug("PROC Response fn_mark_ibs_upload:: "
				+ l_procRes);
		if (l_procRes.get("result").toString().equals("0"))
			return true;
		return false;
	}

	@Override
	public boolean beginMarkStartTxnInput(Date p_businessDate, String p_userId) {
		Map<String, Object> l_procRes = null;

		ProcHandler procHandler = new ProcHandler(
				ApplicationQuery.PROC_BEGIN_MARK_START_TXN);

		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("date", p_businessDate, Types.DATE);
		procHandler.registerInputParam("userId", p_userId, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		LoggerUtil
				.ibsJobDebug("PROC Response fn_mark_txn_input:: " + l_procRes);
		if (l_procRes.get("result").toString().equals("0"))
			return true;
		return false;
	}

	@Override
	public boolean beginMarkStopTxnInput(Date p_businessDate, String p_userId) {
		Map<String, Object> l_procRes = null;

		ProcHandler procHandler = new ProcHandler(
				ApplicationQuery.PROC_BEGIN_MARK_STOP_TXN);

		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("date", p_businessDate, Types.DATE);
		procHandler.registerInputParam("userId", p_userId, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		LoggerUtil.ibsJobDebug("PROC Response fn_mark_stop_txn_input:: "
				+ l_procRes);
		if (l_procRes.get("result").toString().equals("0"))
			return true;
		return false;
	}

	@Override
	public boolean beginMarkEod(Date p_businessDate, String p_userId) {
		Map<String, Object> l_procRes = null;

		ProcHandler procHandler = new ProcHandler(
				ApplicationQuery.PROC_MARK_EOD);

		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("date", p_businessDate, Types.DATE);
		procHandler.registerInputParam("userId", p_userId, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		LoggerUtil.ibsJobDebug("PROC Response fn_mark_end_of_business_day:: "
				+ l_procRes);
		if (l_procRes.get("result").toString().equals("0"))
			return true;
		return false;
	}

	@Override
	public boolean beginMarkStopFinInput(Date p_businessDate, String p_userId) {
		Map<String, Object> l_procRes = null;

		ProcHandler procHandler = new ProcHandler(
				ApplicationQuery.PROC_MARK_STOP_FIN);

		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("date", p_businessDate, Types.DATE);
		procHandler.registerInputParam("userId", p_userId, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		LoggerUtil.ibsJobDebug("PROC Response fn_mark_stop_fin_input:: "
				+ l_procRes);
		if (l_procRes.get("result").toString().equals("0"))
			return true;
		return false;
	}

	@Override
	public void updateBusinessDateForAll(Date p_businessDate) {

		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("businessDate", p_businessDate);

		jdbcTemplate.update(ApplicationQuery.QUERY_UPDATE_BUSINESSDATE, l_params);

	}

	@Override
	public String getTaskErrorStatus(String p_charterCode) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("charterCode", p_charterCode);
		return jdbcTemplate.queryForObject(ApplicationQuery.QUERY_GET_ERROR_STATUS, l_params,
				String.class);
	}

	@Override
	public boolean beginGrpResetForAll(Date p_businessDate, String charterCode,
			String p_userId) {
		Map<String, Object> l_procRes = null;

		ProcHandler procHandler = new ProcHandler(ApplicationQuery.FN_RESET_DATA);
		
		procHandler.registerOutputParam("result", Types.NUMERIC);
		procHandler.registerInputParam("charterCode", charterCode,
				Types.VARCHAR);
		procHandler.registerInputParam("date", p_businessDate, Types.DATE);
		procHandler.registerInputParam("userId", p_userId, Types.VARCHAR);

		l_procRes = procHandler.execute(true);
		LoggerUtil.ibsJobDebug("PROC Response fn_reset_groups:: " + l_procRes);
		if (l_procRes.get("result").toString().equals("0"))
			return true;
		return false;
	}

	@Override
	public int getRunningTaskCount() {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("status", "R");
		return jdbcTemplate.queryForInt(ApplicationQuery.QUERY_IS_ANY_TASK_RUNNING, l_params);
	}

	@Override
	public Date getCurrentBusinessDateTime() {
		try {
			return super.getBusinessDateTime();
		} catch (Exception e) {
			return getAppDateTime();
		}

	}

	@Override
	public void clearLogs() {

		jdbcTemplate.update(ApplicationQuery.QUERY_DELETE_LOGS_TABLE,
				new HashMap<String, String>());
	}

	@Override
	public void clearCharterExceptions(String p_charterCode) {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("charterCode", p_charterCode);
		jdbcTemplate.update(ApplicationQuery.QUERY_DELETE_CHARTER_EXCEPTION, l_params);
	}

	@Override
	public void resetTaskStatus(String p_charterCode) {
		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("charterCode", p_charterCode);
		l_params.put("status", "N");
		l_params.put("startTime", null);
		l_params.put("endTime", null);
		l_params.put("userId", null);
		l_params.put("hasError", null);

		jdbcTemplate.update(ApplicationQuery.QUERY_RESET_TASK_START_STATUS, l_params);

	}

	@Override
	public void forceTaskComplete(String p_charterCode, String p_userId) {

		Map<String, Object> l_params = new HashMap<String, Object>();
		//System.out.println("Chartyer code: " + p_charterCode);
		l_params.put("charterCode", p_charterCode);
		l_params.put("userId", p_userId);
		l_params.put("completeStatus", "C");
		l_params.put("errorNo", "N");
		l_params.put("sysDate", getCurrentBusinessDateTime());
		jdbcTemplate.update(ApplicationQuery.QUERY_UPDATE_TASK_COMPLETE_STATUS, l_params);
	}

	@Override
	public int getPendingTaskCount() {
		Map<String, String> l_params = new HashMap<String, String>();
		l_params.put("statusRunning", "R");
		l_params.put("statusPending", "N");
		return jdbcTemplate.queryForInt(ApplicationQuery.QUERY_IS_ANY_TASK_PENDING, l_params);
	}

	@Override
	public void forcePendingTaskComplete(String p_userId) {
		Map<String, Object> l_params = new HashMap<String, Object>();
		l_params.put("status", "C");
		l_params.put("errorStatus", "N");
		l_params.put("userId",p_userId);
		l_params.put("sysDate",getCurrentBusinessDateTime());
		
		jdbcTemplate.update(ApplicationQuery.QUERY_PENDING_TASK_COMPLETE, l_params);
	}

}
