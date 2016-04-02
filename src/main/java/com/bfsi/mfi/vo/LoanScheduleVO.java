package com.bfsi.mfi.vo;
/**
 * @author bablu
 *
 */
import java.util.Date;

import com.bfsi.mfi.entity.LoanSchedule;

public class LoanScheduleVO extends MaintenanceVO <LoanSchedule> {

	public LoanScheduleVO() {
		entity = new LoanSchedule();
	}

	public LoanScheduleVO(LoanSchedule entity) {
		super(entity);
	}
	
	public Date getLoanScheduleDate() {
		return entity.getLoanScheduleDate();
	}
	public void setLoanScheduleDate(Date loanScheduleDate) {
		entity.setLoanScheduleDate(loanScheduleDate);
	}
	public String getComponentName() {
		return entity.getComponentName();
	}
	public void setComponentName(String componentName) {
		entity.setComponentName(componentName);
	}
	public Double getAmountDue() {
		return entity.getAmountDue();
	}
	public void setAmountDue(Double amountDue) {
		entity.setAmountDue(amountDue);
	}
	public Double getAmountPaid() {
		return entity.getAmountPaid();
	}
	public void setAmountPaid(Double amountPaid) {
		entity.setAmountPaid(amountPaid);
	}
	public Double getAmountOverdue() {
		return entity.getAmountOverdue();
	}
	public void setAmountOverdue(Double amountOverdue) {
		entity.setAmountOverdue(amountOverdue);
	}
	public String getCurrency() {
		return entity.getCurrency();
	}
	public void setCurrency(String currency) {
		entity.setCurrency(currency);
	} 
	public Date getLoanScheduleDueDate() {
		return entity.getLoanScheduleDueDate();
	}
	public void setLoanScheduleDueDate(Date loanScheduleDueDate) {
		entity.setLoanScheduleDueDate(loanScheduleDueDate);
	}
	
	public String getLoanAcNo() {
		return super.getId();

	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
	}
}
