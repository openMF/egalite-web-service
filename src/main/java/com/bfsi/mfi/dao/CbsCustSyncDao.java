package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.dao.jdbc.CbsSyncStatusJdbcDao;
import com.bfsi.mfi.entity.StgCustomer;

/**
 * 
 * @author Vishal
 *
 */
public abstract class CbsCustSyncDao  extends CbsSyncStatusJdbcDao {
	
	public abstract void deleteCustomer();
	public abstract void insertCustomer(List<StgCustomer> p_Cust);
	public abstract void deleteCustomerOnError(String p_jobId);

}
