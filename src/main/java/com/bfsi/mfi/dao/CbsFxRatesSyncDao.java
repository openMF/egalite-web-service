package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.dao.jdbc.CbsSyncStatusJdbcDao;
import com.bfsi.mfi.entity.StgFxRates;

/**
 * 
 * @author Vishal
 *
 */

public abstract class CbsFxRatesSyncDao  extends CbsSyncStatusJdbcDao {
	public abstract void insertFxRates(List<StgFxRates> p_fx);
	public abstract void deleteFxRates();
	public abstract void deleteFxRatesOnError(String p_jobId);
}
