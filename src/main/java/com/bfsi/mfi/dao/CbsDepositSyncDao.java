package com.bfsi.mfi.dao;

import java.util.List;


import com.bfsi.mfi.dao.jdbc.CbsSyncStatusJdbcDao;
import com.bfsi.mfi.entity.StgDeposit;
import com.bfsi.mfi.entity.StgDepositActivity;
/**
 * 
 * @author Shabu S Francis
 *
 */
public abstract class CbsDepositSyncDao extends CbsSyncStatusJdbcDao {
	
	public abstract void insertDeposits(List<StgDeposit> p_deposits);
	public abstract void insertDepositActivities(List<StgDepositActivity> p_depoActivities);
	public abstract void deleteDeposits();
	public abstract void deleteDepositActivities();
	public abstract void deleteDepositsOnError(String p_jobId);
	public abstract void deleteDepositActivitiesOnError(String p_jobId);

}
