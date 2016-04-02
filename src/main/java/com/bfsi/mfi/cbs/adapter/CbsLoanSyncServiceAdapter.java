package com.bfsi.mfi.cbs.adapter;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsLoanDetails;
import com.bfsi.mfi.cbs.request.LoanSyncRequest;
import com.bfsi.mfi.cbs.response.LoanSyncResponse;

/**
 * 
 * @author Vishal
 *
 */

public abstract class CbsLoanSyncServiceAdapter extends ApplicationContextHolder  {
	public abstract  LoanSyncResponse extractLoans(LoanSyncRequest p_request);
	public abstract  LoanSyncResponse extractLoanDisbr(List<CbsLoanDetails> p_loans, LoanSyncRequest p_request);
	public abstract  LoanSyncResponse extractLoanPaidSch(List<CbsLoanDetails> p_loans, LoanSyncRequest p_request);
	public abstract  LoanSyncResponse extractLoanSch(List<CbsLoanDetails> p_loans, LoanSyncRequest p_request);

}
