package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.PigmyView;

public class PigmyViewVO extends MaintenanceVO<PigmyView> {
	public PigmyViewVO() {
		entity = new PigmyView();
	}

	public PigmyViewVO(PigmyView entity) {
		super(entity);
	}
	
	public String getDepositAccountNumber() {
		return super.getId();
	}

	public void setDepositAccountNumber(String depositAccountNumber) {
		super.setId(depositAccountNumber);
	}

	public String getCustomerID() {
		return entity.getCustomerID();
	}

	public void setCustomerID(String customerID) {
		entity.setCustomerID(customerID);
	}

	public float getInterestRate() {
		return entity.getInterestRate();
	}

	public void setInterestRate(float interestRate) {
		entity.setInterestRate(interestRate);
	}


	public Date getMaturityDate() {
		return entity.getMaturityDate();
	}

	public void setMaturityDate(Date maturityDate) {
		entity.setMaturityDate(maturityDate);
	}

	public String getRedemptionFlag() {
		return entity.getRedemptionFlag();
	}

	public void setRedemptionFlag(String redemptionFlag) {
		entity.setRedemptionFlag(redemptionFlag);
	}

	public double getRedemptionAmount() {
		return entity.getRedemptionAmount();
	}

	public void setRedemptionAmount(double redemptionAmount) {
		entity.setRedemptionAmount(redemptionAmount);
	}

	public Date getRedemptionPayoutDate() {
		return entity.getRedemptionPayoutDate();
	}

	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		entity.setRedemptionPayoutDate(redemptionPayoutDate);
	}

	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}

	public String getRecordStat() {
		return entity.getRecordStat();
	}

	public void setRecordStat(String recordStat) {
		entity.setRecordStat(recordStat);
	}

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}
	
	public String getCustomerFullName() {
		return entity.getCustomerFullName();
	}

	public void setCustomerFullName(String customerFullName){
		this.entity.setCustomerFullName(customerFullName);
	}
	
	public String getAllocationStatus() {
		return entity.getAllocationStatus();
	}

	public void setAllocationStatus(String allocationStatus) {
		this.entity.setAllocationStatus(allocationStatus);
	}
	
	public String getLocationCode() {
		return entity.getLocationCode();
	}

	public void setLocationCode(String locationCode) {
		this.entity.setLocationCode(locationCode);
	}
	
	
	public double getSchInstallmentAmt() {
		return entity.getSchInstallmentAmt();
	}

	public void setSchInstallmentAmt(double schInstallmentAmt) {
		this.entity.setSchInstallmentAmt(schInstallmentAmt);
	}
	
	public String getPayFreqType() {
		return entity.getPayFreqType();
	}

	public void setPayFreqType(String payFreqType) {
		this.entity.setPayFreqType(payFreqType);
	}
	
	public String getPayFreq() {
		return entity.getPayFreq();
	}

	public void setPayFreq(String payFreq) {
		this.entity.setPayFreq(payFreq);
	}
	
	public String getTenureType() {
		return entity.getTenureType();
	}

	public void setTenureType(String tenureType) {
		this.entity.setTenureType(tenureType);
	}
	
	public double getPrincipalMaturityAmount() {
		return entity.getPrincipalMaturityAmount();
	}

	public void setPrincipalMaturityAmount(double principalMaturityAmount) {
		this.entity.setPrincipalMaturityAmount(principalMaturityAmount);
	}
	
	public double getInterestAccuredTillDate() {
		return entity.getInterestAccuredTillDate();
	}

	public void setInterestAccuredTillDate(double interestAccuredTillDate) {
		this.entity.setInterestAccuredTillDate(interestAccuredTillDate);
	}
	
	public double getInstallmentPaidTillDate() {
		return entity.getInstallmentPaidTillDate();
	}

	public void setInstallmentPaidTillDate(double installmentPaidTillDate) {
		this.entity.setInstallmentPaidTillDate(installmentPaidTillDate);
	}
	
	public double getTotalInstallmentAmtDue() {
		return entity.getTotalInstallmentAmtDue();
	}

	public void setTotalInstallmentAmtDue(double totalInstallmentAmtDue) {
		this.entity.setTotalInstallmentAmtDue(totalInstallmentAmtDue);
	}
	public String getCurrency() {
		return entity.getCurrency();
	}

	public void setCurrency(String currency) {
		this.entity.setCurrency(currency);
	}
	public String getAllocationByCode() {
		return entity.getAllocationByCode();
	}

	public void setAllocationByCode(String allocationByCode) {
		this.entity.setAllocationByCode(allocationByCode);
	}
	public Date getOpenDate() {
		return entity.getOpenDate();
	}

	public void setOpenDate(Date openDate) {
		this.entity.setOpenDate(openDate);
	}
	public String getTenure() {
		return entity.getTenure();
	}

	public void setTenure(String tenure) {
		this.entity.setTenure(tenure);
	}
	public String getCbsUplJobId() {
		return entity.getCbsUplJobId();
	}

	public void setCbsUplJobId(String cbsUplJobId) {
		this.entity.setCbsUplJobId(cbsUplJobId);
	}
	
	public String getCreditOfficerCode() {
		return entity.getCreditOfficerCode();
	}

	public void setCreditOfficerCode(String creditOfficerCode) {
		this.entity.setCreditOfficerCode(creditOfficerCode);
	}
	
	public String getCreditOfficerName() {
		return entity.getCreditOfficerName();
	}

	public void setCreditOfficerName(String creditOfficerName) {
		this.entity.setCreditOfficerName(creditOfficerName);
	}
}
