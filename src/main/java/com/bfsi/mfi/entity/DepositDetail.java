package com.bfsi.mfi.entity;

import java.util.Date;

public class DepositDetail extends MaintenanceEntity {
	private String depositAccNo;
	private String branchCode;
	private String customerId;
	private String customerName;  //
	private String accCcy;
	private Date openDate;
	private Date maturityDate;
	private double schInstAmt;
	private String payFreqType;
	private int payFreq;
	private String tenureType;
	private int tenure;
	private double intRate;
	private double princMaturityAmt;
	private double intAccuredTillDate;
	private double instPaidTillDate;
	private double totAmtDue;
	private String redemptionFlag;
	private Date redemptionPayoutDate;
	private double redemptionAmt;
	///
	private String recordStatus;
	private String cbsUploadJobId;
	private String syncStatus;
	private String syncTime;
	private String isAllocated;
	
	private String locCode;
	private String agentId;
	private String creditOfficeCode;
	
	
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getCreditOfficeCode() {
		return creditOfficeCode;
	}
	public void setCreditOfficeCode(String creditOfficeCode) {
		this.creditOfficeCode = creditOfficeCode;
	}
	public String getDepositAccNo() {
		return depositAccNo;
	}
	public void setDepositAccNo(String depositAccNo) {
		this.depositAccNo = depositAccNo;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccCcy() {
		return accCcy;
	}
	public void setAccCcy(String accCcy) {
		this.accCcy = accCcy;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public double getSchInstAmt() {
		return schInstAmt;
	}
	public void setSchInstAmt(double schInstAmt) {
		this.schInstAmt = schInstAmt;
	}
	public String getPayFreqType() {
		return payFreqType;
	}
	public void setPayFreqType(String payFreqType) {
		this.payFreqType = payFreqType;
	}
	public int getPayFreq() {
		return payFreq;
	}
	public void setPayFreq(int payFreq) {
		this.payFreq = payFreq;
	}
	public String getTenureType() {
		return tenureType;
	}
	public void setTenureType(String tenureType) {
		this.tenureType = tenureType;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getIntRate() {
		return intRate;
	}
	public void setIntRate(double intRate) {
		this.intRate = intRate;
	}
	public double getPrincMaturityAmt() {
		return princMaturityAmt;
	}
	public void setPrincMaturityAmt(double princMaturityAmt) {
		this.princMaturityAmt = princMaturityAmt;
	}
	public double getIntAccuredTillDate() {
		return intAccuredTillDate;
	}
	public void setIntAccuredTillDate(double intAccuredTillDate) {
		this.intAccuredTillDate = intAccuredTillDate;
	}
	public double getInstPaidTillDate() {
		return instPaidTillDate;
	}
	public void setInstPaidTillDate(double instPaidTillDate) {
		this.instPaidTillDate = instPaidTillDate;
	}
	public double getTotAmtDue() {
		return totAmtDue;
	}
	public void setTotAmtDue(double totAmtDue) {
		this.totAmtDue = totAmtDue;
	}
	public String getRedemptionFlag() {
		return redemptionFlag;
	}
	public void setRedemptionFlag(String redemptionFlag) {
		this.redemptionFlag = redemptionFlag;
	}
	public Date getRedemptionPayoutDate() {
		return redemptionPayoutDate;
	}
	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		this.redemptionPayoutDate = redemptionPayoutDate;
	}
	public double getRedemptionAmt() {
		return redemptionAmt;
	}
	public void setRedemptionAmt(double redemptionAmt) {
		this.redemptionAmt = redemptionAmt;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getCbsUploadJobId() {
		return cbsUploadJobId;
	}
	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.cbsUploadJobId = cbsUploadJobId;
	}
	public String getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}
	public String getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}
	public String getIsAllocated() {
		return isAllocated;
	}
	public void setIsAllocated(String isAllocated) {
		this.isAllocated = isAllocated;
	}
	
}
