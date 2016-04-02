package com.bfsi.mfi.dao;

import java.util.Date;

/**
 * 
 * @author Vishal
 *
 */

import com.bfsi.mfi.entity.CbsJobHistory;

public interface CbsDataSyncDao extends ReadOnlyMaintenanceDao<CbsJobHistory> {

	public abstract String getJobId();

	public abstract void insertJobId(String jobId, String userId,
			Date jobStartTime);

	public abstract void updateWithEndTime(String jobId, Date jobEndTime);

	public void insertSyncJobDetails(String p_modCode, String p_modDesc,
			Date p_syncTime, java.sql.Date p_busDate, String p_jobId, int p_countFetch);
	
	public Date getSysDate();
	public void resetSyncDetails();

}
