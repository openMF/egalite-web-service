package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.LoanDetailPaidSchView;

public class LoanDetailPaidSchViewVO extends MaintenanceVO<LoanDetailPaidSchView>{

	public LoanDetailPaidSchViewVO() {
		entity = new LoanDetailPaidSchView();
	}
	
	public LoanDetailPaidSchViewVO(LoanDetailPaidSchView entity) {
		super(entity);
	}	
	
	public String getBranchCode() {
		return  entity. getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode); 
	}

	public Date getSchDueDate() {
		return  entity.getSchDueDate();
	}

	public void setSchDueDate(Date schDueDate) {
		entity.setSchDueDate(schDueDate); 
	}

	public Date getSchPaidDate() {
		return  entity.getSchPaidDate();
	}

	public void setSchPaidDate(Date schPaidDate) {
		entity.setSchPaidDate(schPaidDate); 
	}

	public String getSettlementCcyCode() {
		return  entity.getSettlementCcyCode();
	}

	public void setSettlementCcyCode(String settlementCcyCode) {
		entity.setSettlementCcyCode(settlementCcyCode);
	}

	public Double getAmtSettled() {
		return  entity.getAmtSettled();
	}

	public void setAmtSettled(Double amtSettled) {
		entity.setAmtSettled(amtSettled); 
	}

	public String getFullPartialInd() {
		return  entity.getFullPartialInd();
	}

	public void setFullPartialInd(String fullPartialInd) {
		entity.setFullPartialInd(fullPartialInd); 
	}
	
	
}
