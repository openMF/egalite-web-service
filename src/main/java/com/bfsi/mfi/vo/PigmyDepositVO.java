package com.bfsi.mfi.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bfsi.mfi.entity.PigmyDeposit;

public class PigmyDepositVO extends MaintenanceVO<PigmyDeposit> {
	public PigmyDepositVO() {
		entity = new PigmyDeposit();
	}

	public PigmyDepositVO(PigmyDeposit entity) {
		super(entity);
	}
	public String getTxnType() {
		return entity.getTxnType();
	}

	public void setTxnType(String txnType) {
		entity.setTxnType(txnType);
	}

	public void setNumOfInstDue(String numOfInstDue) {
		entity.setNumOfInstDue(numOfInstDue);
	}

	public String getNumOfInstDue() {
		return entity.getNumOfInstDue();
	}

	public String getDepTenure() {
		return entity.getDepTenure();
	}

	public void setDepTenure(String depTenure) {
		entity.setDepTenure(depTenure);
	}

	public Date getNextInstDate() {
		return entity.getNextInstDate();
	}

	public void setNextInstDate(Date nextInstDate) {
		entity.setNextInstDate(nextInstDate);
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

	public String getLocationID() {
		return entity.getLocationID();
	}

	public void setLocationID(String locationID) {
		entity.setLocationID(locationID);
	}

	public String getDepositOpenedDate() {
		//return entity.getDepositOpenedDate();
		
		if(entity.getDepositOpenedDate()==null)
			return new String();
		DateFormat format=new SimpleDateFormat("dd-MMM-yyyy");
		return format.format(entity.getDepositOpenedDate());
	}

	public void setDepositOpenedDate(Date depositOpenedDate) {
		entity.setDepositOpenedDate(depositOpenedDate);
	}

	public String getDepositFrequency() {
		return entity.getDepositFrequency();
	}

	public void setDepositFrequency(String depositFrequency) {
		entity.setDepositFrequency(depositFrequency);
	}

	public float getInterestRate() {
		return entity.getInterestRate();
	}

	public void setInterestRate(float interestRate) {
		entity.setInterestRate(interestRate);
	}

	public String getDepositAccCcy() {
		return entity.getDepositAccCcy();
	}

	public void setDepositAccCcy(String depositAccCcy) {
		entity.setDepositAccCcy(depositAccCcy);
	}

	public double getPerinstallmentAmt() {
		return entity.getPerinstallmentAmt();
	}

	public void setPerinstallmentAmt(double perinstallmentAmt) {
		entity.setPerinstallmentAmt(perinstallmentAmt);
	}

	public Date getLastInstallmentDate() {
		return entity.getLastInstallmentDate();
	}

	public void setLastInstallmentDate(Date lastInstallmentDate) {
		entity.setLastInstallmentDate(lastInstallmentDate);
	}

	public double getInstallmentAmtDue() {
		return entity.getInstallmentAmtDue();
	}

	public void setInstallmentAmtDue(double installmentAmtDue) {
		entity.setInstallmentAmtDue(installmentAmtDue);
	}

	public String getOverdueStat() {
		return entity.getOverdueStat();
	}

	public void setOverdueStat(String overdueStat) {
		entity.setOverdueStat(overdueStat);
	}

	public double getOverdueAmt() {
		return entity.getOverdueAmt();
	}

	public void setOverdueAmt(double overdueAmt) {
		entity.setOverdueAmt(overdueAmt);
	}

	public Date getOverdueDate() {
		return entity.getOverdueDate();
	}

	public void setOverdueDate(Date overdueDate) {
		entity.setOverdueDate(overdueDate);
	}

	public String getMaturityDate() {
		if(entity.getMaturityDate()==null)
			return new String();
		DateFormat format=new SimpleDateFormat("dd-MMM-yyyy");
		return format.format(entity.getMaturityDate());
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

	public String getRedemptionPayoutDate() {
		//return entity.getRedemptionPayoutDate();
		
		if(entity.getRedemptionPayoutDate()==null)
			return new String();
		DateFormat format=new SimpleDateFormat("dd-MMM-yyyy");
		return format.format(entity.getRedemptionPayoutDate());
	}

	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		entity.setRedemptionPayoutDate(redemptionPayoutDate);
	}

	public String getAgentID() {
		return entity.getAgentID();
	}

	public void setAgentID(String agentID) {
		entity.setAgentID(agentID);
	}

	public String getSyncStatus() {
		return entity.getSyncStatus();
	}

	public void setSyncStatus(String syncStatus) {
		entity.setSyncStatus(syncStatus);
	}

	public String getSyncTime() {
		return entity.getSyncTime();
	}

	public void setSyncTime(String syncTime) {
		entity.setSyncTime(syncTime);
	}

	public String getJobID() {
		return entity.getJobID();
	}

	public void setJobID(String jobID) {
		entity.setJobID(jobID);
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

	public double getTotalInstPaid() {
		return entity.getTotalInstPaid();
	}

	public void setTotalInstPaid(double totalInstPaid) {
		entity.setTotalInstPaid(totalInstPaid);
	}

	public double getTotalIntAccured() {
		return entity.getTotalIntAccured();
	}

	public void setTotalIntAccured(double totalIntAccured) {
		entity.setTotalIntAccured(totalIntAccured);
	}

	public double getMaturityAmount() {
		return entity.getMaturityAmount();
	}

	public void setMaturityAmount(double maturityAmount) {
		entity.setMaturityAmount(maturityAmount);
	}

	public String getCustomerName() {
		return entity.getCustomerName();
	}

	public void setCustomerName(String customerName) {
		this.entity.setCustomerName(customerName);
	}

	public String getAgentName() {
		return entity.getAgentName();
	}

	public void setAgentName(String agentName) {
		this.entity.setAgentName(agentName);
	}

	public int getDepositTenure() {
		return entity.getDepositTenure();
	}

	public void setDepositTenure(int depositTenure) {
		this.entity.setDepositTenure(depositTenure);
	}

	public String getLocationName() {
		return entity.getLocationName();
	}

	public void setLocationName(String locationName) {
		this.entity.setLocationName(locationName);
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
	
	public String getAllocationBy() {
		return entity.getAllocationBy();
	}

	public void setAllocationBy(String allocationBy) {
		this.entity.setAllocationBy(allocationBy);
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
	
	public Date getInterestAccuredTillDate() {
		return entity.getInterestAccuredTillDate();
	}

	public void setInterestAccuredTillDate(Date interestAccuredTillDate) {
		this.entity.setInterestAccuredTillDate(interestAccuredTillDate);
	}
	
	public Date getInstallmentPaidTillDate() {
		return entity.getInstallmentPaidTillDate();
	}

	public void setInstallmentPaidTillDate(Date installmentPaidTillDate) {
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
}
