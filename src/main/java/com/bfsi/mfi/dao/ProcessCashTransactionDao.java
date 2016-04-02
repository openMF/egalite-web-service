package com.bfsi.mfi.dao;

import com.bfsi.mfi.cbs.response.CbsBaseResponse;

import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.entity.ServiceResponse;
/**
 * 
 * @author Shabu
 *
 */
public interface ProcessCashTransactionDao<T extends MaintenanceEntity,V extends ServiceResponse> // extends MaintenanceDao<CashTransaction>
{
	
	public V logTransaction(T p_transaction);
	public V updateLogTransaction(String p_outSeqNo, CbsBaseResponse p_res);

}
