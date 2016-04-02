package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DepositDetail;

public class DepositDetailVO extends MaintenanceVO<DepositDetail> {

	public DepositDetailVO() {
		entity = new DepositDetail();
	}

	public DepositDetailVO(DepositDetail entity) {
		super(entity);
	}

	public String getDepositAccNo() {
		return entity.getDepositAccNo();
	}

	public void setDepositAccNo(String depositAccNo) {
		this.entity.setDepositAccNo(depositAccNo);
	}

	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		this.entity.setBranchCode(branchCode);
	}

	public String getCustomerId() {
		return entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		this.entity.setCustomerId(customerId);
	}

	public String getCustomerName() {
		return entity.getCustomerName();
	}

	public void setCustomerName(String customerName) {
		this.entity.setCustomerName(customerName);
	}

	public String getAccCcy() {
		return entity.getAccCcy();
	}

	public void setAccCcy(String accCcy) {
		this.entity.setAccCcy(accCcy);
	}

	public Date getOpenDate() {
		return entity.getOpenDate();
	}

	public void setOpenDate(Date openDate) {
		this.entity.setOpenDate(openDate);
	}

	public Date getMaturityDate() {
		return entity.getMaturityDate();
	}

	public void setMaturityDate(Date maturityDate) {
		this.entity.setMaturityDate(maturityDate);
	}

	public double getSchInstAmt() {
		return entity.getSchInstAmt();
	}

	public void setSchInstAmt(double schInstAmt) {
		this.entity.setSchInstAmt(schInstAmt);
	}

	public String getPayFreqType() {
		return entity.getPayFreqType();
	}

	public void setPayFreqType(String payFreqType) {
		this.entity.setPayFreqType(payFreqType);
	}

	public int getPayFreq() {
		return entity.getPayFreq();
	}

	public void setPayFreq(int payFreq) {
		this.entity.setPayFreq(payFreq);
	}

	public String getTenureType() {
		return entity.getTenureType();
	}

	public void setTenureType(String tenureType) {
		this.entity.setTenureType(tenureType);
	}

	public int getTenure() {
		return entity.getTenure();
	}

	public void setTenure(int tenure) {
		this.entity.setTenure(tenure);
	}

	public double getIntRate() {
		return entity.getIntRate();
	}

	public void setIntRate(double intRate) {
		this.entity.setIntRate(intRate);
	}

	public double getPrincMaturityAmt() {
		return entity.getPrincMaturityAmt();
	}

	public void setPrincMaturityAmt(double princMaturityAmt) {
		this.entity.setPrincMaturityAmt(princMaturityAmt);
	}

	public double getIntAccuredTillDate() {
		return entity.getIntAccuredTillDate();
	}

	public void setIntAccuredTillDate(double intAccuredTillDate) {
		this.entity.setIntAccuredTillDate(intAccuredTillDate);
	}

	public double getInstPaidTillDate() {
		return entity.getInstPaidTillDate();
	}

	public void setInstPaidTillDate(double instPaidTillDate) {
		this.entity.setInstPaidTillDate(instPaidTillDate);
	}

	public double getTotAmtDue() {
		return entity.getTotAmtDue();
	}

	public void setTotAmtDue(double totAmtDue) {
		this.entity.setTotAmtDue(totAmtDue);
	}

	public String getRedemptionFlag() {
		return entity.getRedemptionFlag();
	}

	public void setRedemptionFlag(String redemptionFlag) {
		this.entity.setRedemptionFlag(redemptionFlag);
	}

	public Date getRedemptionPayoutDate() {
		return entity.getRedemptionPayoutDate();
	}

	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		this.entity.setRedemptionPayoutDate(redemptionPayoutDate);
	}

	public double getRedemptionAmt() {
		return entity.getRedemptionAmt();
	}

	public void setRedemptionAmt(double redemptionAmt) {
		this.entity.setRedemptionAmt(redemptionAmt);
	}

	public String getRecordStatus() {
		return entity.getRecordStatus();
	}

	public void setRecordStatus(String recordStatus) {
		this.entity.setRecordStatus(recordStatus);
	}

	public String getCbsUploadJobId() {
		return entity.getCbsUploadJobId();
	}

	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.entity.setCbsUploadJobId(cbsUploadJobId);
	}

	public String getSyncStatus() {
		return entity.getSyncStatus();
	}

	public void setSyncStatus(String syncStatus) {
		this.entity.setSyncStatus(syncStatus);
	}

	public String getSyncTime() {
		return entity.getSyncTime();
	}

	public void setSyncTime(String syncTime) {
		this.entity.setSyncTime(syncTime);
	}

	public String getIsAllocated() {
		return entity.getIsAllocated();
	}

	public void setIsAllocated(String isAllocated) {
		this.entity.setIsAllocated(isAllocated);
	}

	public String getLocCode() {
		return entity.getLocCode();
	}
	public void setLocCode(String locCode) {
		this.entity.setLocCode( locCode);
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		this.entity.setAgentId( agentId);
	}
	public String getCreditOfficeCode() {
		return entity.getCreditOfficeCode();
	}
	public void setCreditOfficeCode(String creditOfficeCode) {
		this.entity.setCreditOfficeCode( creditOfficeCode);
	}

}
