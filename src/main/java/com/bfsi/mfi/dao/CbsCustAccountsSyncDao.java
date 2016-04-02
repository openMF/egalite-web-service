package com.bfsi.mfi.dao;

import java.util.List;



import com.bfsi.mfi.dao.jdbc.CbsSyncStatusJdbcDao;
import com.bfsi.mfi.entity.StgCustomerAccount;

public abstract class CbsCustAccountsSyncDao extends CbsSyncStatusJdbcDao {
	public abstract void insertCustomerAccounts(
			List<StgCustomerAccount> p_cstAccList);

	public abstract void deleteCustomerAccounts();
	public abstract void deleteCustAccountsOnError(String p_jobId);

}
