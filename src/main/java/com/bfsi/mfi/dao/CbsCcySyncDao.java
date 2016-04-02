package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.dao.jdbc.CbsSyncStatusJdbcDao;
import com.bfsi.mfi.entity.StgCurrency;

/**
 * 
 * @author Vishal
 *
 */

public abstract class CbsCcySyncDao extends CbsSyncStatusJdbcDao {
	
	public abstract void deleteCcy();
	public abstract void insertCcy(List<StgCurrency> p_ccy);
	public abstract void deleteCcyOnError(String p_jobId);
	public abstract void deleteCcy(List<StgCurrency> p_ccy);

}
