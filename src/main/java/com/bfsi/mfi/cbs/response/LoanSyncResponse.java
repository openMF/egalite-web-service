package com.bfsi.mfi.cbs.response;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsLoanDetails;
import com.bfsi.mfi.cbs.model.CbsLoanDisbursements;
import com.bfsi.mfi.cbs.model.CbsLoanPaidSchedules;
import com.bfsi.mfi.cbs.model.CbsLoanSchedules;

public class LoanSyncResponse {
	
	private List<CbsLoanDetails>  loanDetails;
	private List<CbsLoanDisbursements>  loanDisbr;
	private List<CbsLoanPaidSchedules> loanPaidSch;
	private List<CbsLoanSchedules> loanSch;
	
	public List<CbsLoanDetails> getLoanDetails() {
		return loanDetails;
	}
	public void setLoanDetails(List<CbsLoanDetails> loanDetails) {
		this.loanDetails = loanDetails;
	}
	public List<CbsLoanDisbursements> getLoanDisbr() {
		return loanDisbr;
	}
	public void setLoanDisbr(List<CbsLoanDisbursements> loanDisbr) {
		this.loanDisbr = loanDisbr;
	}
	public List<CbsLoanPaidSchedules> getLoanPaidSch() {
		return loanPaidSch;
	}
	public void setLoanPaidSch(List<CbsLoanPaidSchedules> loanPaidSch) {
		this.loanPaidSch = loanPaidSch;
	}
	public List<CbsLoanSchedules> getLoanSch() {
		return loanSch;
	}
	public void setLoanSch(List<CbsLoanSchedules> loanSch) {
		this.loanSch = loanSch;
	}
}
