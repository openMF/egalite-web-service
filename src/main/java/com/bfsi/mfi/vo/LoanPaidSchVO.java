package com.bfsi.mfi.vo;

import java.util.Date;
import com.bfsi.mfi.entity.LoanPaidSchDetail;

public class LoanPaidSchVO extends MaintenanceVO<LoanPaidSchDetail> {
	
	public LoanPaidSchVO() {
		entity = new LoanPaidSchDetail();
	}

	public LoanPaidSchVO(LoanPaidSchDetail entity) {
		super(entity);
	}
	
	public String getLoanAcNo() {
		return entity.getLoanAcNo();
	}
	public void setLoanAcNo(String loanAcNo) {
		this.entity.setLoanAcNo(loanAcNo);
	}
	public String getBranchCode() {
		return entity.getBranchCode();
	}
	public void setBranchCode(String branchCode) {
		this.entity.setBranchCode(branchCode);
	}
	public String getParentLoanAcNo() {
		return entity.getParentLoanAcNo();
	}
	public void setParentLoanAcNo(String parentLoanAcNo) {
		this.entity.setParentLoanAcNo(parentLoanAcNo);
	}
	public String getCustomerId() {
		return entity.getCustomerId();
	}
	public void setCustomerId(String customerId) {
		this.entity.setCustomerId(customerId);
	}
	public String getParentCustomerId() {
		return entity.getParentCustomerId();
	}
	public void setParentCustomerId(String parentCustomerId) {
		this.entity.setParentCustomerId(parentCustomerId);
	}
	public String getIsParentLoan() {
		return entity.getIsParentLoan();
	}
	public void setIsParentLoan(String isParentLoan) {
		this.entity.setIsParentLoan(isParentLoan);
	}
	public String getIsGroupLoan() {
		return entity.getIsGroupLoan();
	}
	public void setIsGroupLoan(String isGroupLoan) {
		this.entity.setIsGroupLoan(isGroupLoan);
	}
	public String getGroupId() {
		return entity.getGroupId();
	}
	public void setGroupId(String groupId) {
		this.entity.setGroupId(groupId);
	}
	public String getCustomerName() {
		return entity.getCustomerName();
	}
	public void setCustomerName(String customerName) {
		this.entity.setCustomerName(customerName);
	}
	public Date getSchDueDate() {
		return entity.getSchDueDate();
	}
	public void setSchDueDate(Date schDueDate) {
		this.entity.setSchDueDate(schDueDate);
	}
	public Date getSchPaidDate() {
		return entity.getSchDueDate();
	}
	public void setSchPaidDate(Date schPaidDate) {
		this.entity.setSchPaidDate(schPaidDate);
	}
	public String getStlmtCcyCode() {
		return entity.getStlmtCcyCode();
	}
	public void setStlmtCcyCode(String stlmtCcyCode) {
		this.entity.setStlmtCcyCode(stlmtCcyCode);
	}
	public double getAmtSettled() {
		return entity.getAmtSettled();
	}
	public void setAmtSettled(double amtSettled) {
		this.entity.setAmtSettled(amtSettled);
	}
	public String getFullPartialInd() {
		return entity.getFullPartialInd();
	}
	public void setFullPartialInd(String fullPartialInd) {
		this.entity.setFullPartialInd(fullPartialInd);
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		this.entity.setAgentId(agentId);
	}
	public String getLocCode() {
		return entity.getLocCode();
	}
	public void setLocCode(String locCode) {
		this.entity.setLocCode(locCode);
	}
	public String getDeviceId() {
		return entity.getDeviceId();
	}
	public void setDeviceId(String deviceId) {
		this.entity.setDeviceId(deviceId);
	}

}
