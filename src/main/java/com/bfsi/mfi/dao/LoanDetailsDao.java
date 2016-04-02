package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.LoanDetail;
import com.bfsi.mfi.entity.LoanDetailsServiceRequest;
import com.bfsi.mfi.entity.LoanPaidSchDetail;


/**
 * 
 * @author Shabu
 *
 */
public interface LoanDetailsDao {
	
	public List<LoanDetail> getLoans(LoanDetailsServiceRequest p_request);
	public List<LoanPaidSchDetail> getLoanPaidSch(String p_loanAcNo , LoanDetailsServiceRequest p_request);

}
