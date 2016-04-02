package com.bfsi.mfi.entity;

import java.util.Date;

public class StgLoanSchedules {
	
	private String loanAcNo;
	private String branchCode;
	private String prntLoanAcNo;
	private String customerId;
	private String prntCustId;
	private String isprntLoan;
	private String isgroupLoan;	
	private String isFutureSch;
	private String schType;
	private Date schStDate;
	private Date schEndDate;
	private String cbsGroupId;
	private String componentName;
	private String componentCcyCode;
	private String componentLcyCode;
	private long amtDue;
	private long amtDueLcy;
	private String cbsUploadJobId;
	private String ibsInternalErr;
	private String ibsErrDesc;
	
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
	public String getPrntLoanAcNo() {
		return prntLoanAcNo;
	}
	public void setPrntLoanAcNo(String prntLoanAcNo) {
		this.prntLoanAcNo = prntLoanAcNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPrntCustId() {
		return prntCustId;
	}
	public void setPrntCustId(String prntCustId) {
		this.prntCustId = prntCustId;
	}
	public String getIsprntLoan() {
		return isprntLoan;
	}
	public void setIsprntLoan(String isprntLoan) {
		this.isprntLoan = isprntLoan;
	}
	public String getIsgroupLoan() {
		return isgroupLoan;
	}
	public void setIsgroupLoan(String isgroupLoan) {
		this.isgroupLoan = isgroupLoan;
	}
	public String getIsFutureSch() {
		return isFutureSch;
	}
	public void setIsFutureSch(String isFutureSch) {
		this.isFutureSch = isFutureSch;
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
	public String getCbsGroupId() {
		return cbsGroupId;
	}
	public void setCbsGroupId(String cbsGroupId) {
		this.cbsGroupId = cbsGroupId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
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
	public String getIbsInternalErr() {
		return ibsInternalErr;
	}
	public void setIbsInternalErr(String ibsInternalErr) {
		this.ibsInternalErr = ibsInternalErr;
	}
	public String getIbsErrDesc() {
		return ibsErrDesc;
	}
	public void setIbsErrDesc(String ibsErrDesc) {
		this.ibsErrDesc = ibsErrDesc;
	}
}
