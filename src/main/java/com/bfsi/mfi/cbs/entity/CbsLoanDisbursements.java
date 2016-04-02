package com.bfsi.mfi.cbs.entity;

import java.util.Date;

public class CbsLoanDisbursements {
	
	private String loanAcNo;
	private String branchCode;
	private String componentName;
	private String disbrType;
	private Date schStDate;
	private Date schEndDate;
	private String componentCcyCode;
	private String componentLcyCode;
	private long amtToDisbr;
	private long amtToDisbrLcy;	
	
	public String getLoanAcNo() {
		return loanAcNo;
	}
	public void setLoanAcNo(String loanAcNo) {
		this.loanAcNo = loanAcNo;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getDisbrType() {
		return disbrType;
	}
	public void setDisbrType(String disbrType) {
		this.disbrType = disbrType;
	}
	public Date getSchStDate() {
		return schStDate;
	}
	public void setSchStDate(Date schStDate) {
		this.schStDate = schStDate;
	}
	public Date getSchEndDate() {
		return schEndDate;
	}
	public void setSchEndDate(Date schEndDate) {
		this.schEndDate = schEndDate;
	}
	public String getComponentCcyCode() {
		return componentCcyCode;
	}
	public void setComponentCcyCode(String componentCcyCode) {
		this.componentCcyCode = componentCcyCode;
	}
	public String getComponentLcyCode() {
		return componentLcyCode;
	}
	public void setComponentLcyCode(String componentLcyCode) {
		this.componentLcyCode = componentLcyCode;
	}
	public long getAmtToDisbr() {
		return amtToDisbr;
	}
	public void setAmtToDisbr(long amtToDisbr) {
		this.amtToDisbr = amtToDisbr;
	}
	public long getAmtToDisbrLcy() {
		return amtToDisbrLcy;
	}
	public void setAmtToDisbrLcy(long amtToDisbrLcy) {
		this.amtToDisbrLcy = amtToDisbrLcy;
	}
	
}
