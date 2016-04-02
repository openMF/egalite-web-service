package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.LoanPayment;

public class LoanPaymentVO extends MaintenanceVO <LoanPayment> {
	
	public LoanPaymentVO() {
		entity = new LoanPayment();
	}

	public LoanPaymentVO(LoanPayment entity) {
		super(entity);
	}
	
	public Date getLoanPaymentDate() {
		return entity.getLoanPaymentDate();
	}

	public void setLoanPaymentDate(Date loanPaymentDate) {
		entity.setLoanPaymentDate(loanPaymentDate);
	}

	public String getCurrency() {
		return entity.getCurrency();
	}

	public void setCurrency(String currency) {
		entity.setCurrency(currency);
	}

	public Integer getAmount() {
		return entity.getAmount();
	}

	public void setAmount(Integer amount) {
		entity.setAmount(amount);
	}
	public String getLoanAcNo() {
		return super.getId();

	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
	}
	
	
}
