package com.bfsi.mfi.dao;

import java.util.Date;

/**
 * 
 * @author Shabu
 *
 */
public interface ConsoleAdminDao {
	
	public String getTaskStatus(String p_charterCode);
	public String getTaskErrorStatus(String p_charterCode);
	public void updateTaskStartStatus(String p_charterCode,String p_userId,Date p_busDate);
	public void updateTaskEndStatus(String p_charterCode,Date p_busDate, boolean p_hasError);
	public void updateBusinessDateForAll(Date p_businessDate);
	public Date getCurrentBusinessDateTime();
	public void resetTaskStatus(String p_charterCode);
	public void forceTaskComplete(String p_charterCode,String p_userId);
	public int getPendingTaskCount();
	
	public int getRunningTaskCount();
	public void clearLogs();
	public void clearCharterExceptions(String p_charterCode);
	public void forcePendingTaskComplete(String p_userId);
	
	public boolean beginBusinessDay(String p_userId);
	public boolean beginIbsCleanup(Date p_businessDate,String p_userId);
	public boolean beginAgendaCreation(Date p_businessDate, String p_userId);
	public boolean beginMarkStartTxnInput(Date p_businessDate, String p_userId);
	public boolean beginMarkStopTxnInput(Date p_businessDate, String p_userId);
	public boolean beginMarkStopFinInput(Date p_businessDate, String p_userId);
	public boolean beginMarkEod(Date p_businessDate, String p_userId);
	
	public boolean beginGrpResetForAll(Date p_businessDate, String charterCode, String p_userId);

}
