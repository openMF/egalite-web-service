package com.bfsi.mfi.entity;

import java.util.List;

import com.bfsi.mfi.vo.LoanDetailVO;

public class LoanDetailsServiceResponse extends ServiceResponse {
	private List<LoanDetailVO> loanList;

	public List<LoanDetailVO> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<LoanDetailVO> loanList) {
		this.loanList = loanList;
	}

}
