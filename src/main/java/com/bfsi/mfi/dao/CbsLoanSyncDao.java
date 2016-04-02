package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.StgLoanPaidSchedules;
import com.bfsi.mfi.dao.jdbc.CbsSyncStatusJdbcDao;
import com.bfsi.mfi.entity.StgLoanDetails;
import com.bfsi.mfi.entity.StgLoanDisbursements;
import com.bfsi.mfi.entity.StgLoanSchedules;

/**
 * 
 * @author Vishal
 *
 */

public abstract class CbsLoanSyncDao extends CbsSyncStatusJdbcDao {
	public abstract void deleteLoanDetails();
	public abstract void insertLoanDetails(List<StgLoanDetails> p_loanList);
	
	public abstract void deleteLoanDisbr();
	public abstract void insertLoanDisbr(List<StgLoanDisbursements> p_loanDibrList);
	
	public abstract void deleteLoanPaidSch();
	public abstract void insertLoanPaidSch(List<StgLoanPaidSchedules> p_loanPaidSchList);
	
	public abstract void deleteLoanSch();
	public abstract void insertLoanSch(List<StgLoanSchedules> p_loanSchList);
	
	public abstract void deleteLoansOnError(String p_jobId);
	public abstract void deleteLoanDisbrOnError(String p_jobId);
	public abstract void deleteLoanPaidSchOnError(String p_jobId);
	public abstract void deleteLoanSchOnError(String p_jobId);

}
