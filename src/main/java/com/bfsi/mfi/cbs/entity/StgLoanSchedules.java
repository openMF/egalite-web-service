package com.bfsi.mfi.cbs.entity;

import java.util.Date;

public class StgLoanSchedules {
		
	private String loanAcNo;
	private String branchCode;
	private String componentName;
	private String schType;
	private Date schStDate;
	private Date schEndDate;
	private String componentCcyCode;
	private String componentLcyCode;
	private long amtDue;
	private long amtDueLcy;
	private String cbsUploadJobId;
	
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
	public String getSchType() {
		return schType;
	}
	public void setSchType(String schType) {
		this.schType = schType;
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
	public long getAmtDue() {
		return amtDue;
	}
	public void setAmtDue(long amtDue) {
		this.amtDue = amtDue;
	}
	public long getAmtDueLcy() {
		return amtDueLcy;
	}
	public void setAmtDueLcy(long amtDueLcy) {
		this.amtDueLcy = amtDueLcy;
	}
	public String getCbsUploadJobId() {
		return cbsUploadJobId;
	}
	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.cbsUploadJobId = cbsUploadJobId;
	}
	
	
	
}
