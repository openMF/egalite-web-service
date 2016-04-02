package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.MfiMbsTxnLnrepayV;

public interface LoanRepaymentTxnDao extends MaintenanceDao<MfiMbsTxnLnrepayV>{
	
	List<MfiMbsTxnLnrepayV> getchildLoan(String cbsAcRefNo);

}
