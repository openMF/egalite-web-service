package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CashTxnCode;


public interface CashTxnCodeDao extends MaintenanceDao<CashTxnCode>{
	public List<CashTxnCode> getCashTxnCode() ;
}
