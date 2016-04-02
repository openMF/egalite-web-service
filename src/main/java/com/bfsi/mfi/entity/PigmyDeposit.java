package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "IFTB_PIGMY_DEPOSIT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PigmyDeposit extends MaintenanceEntity {

	public PigmyDeposit() {
	}

	private double totalInstPaid;
	private double totalIntAccured;
	private String depositAccountNumber;// for Deposit List from View
	private String branchCode;// for Deposit List from View
	private String customerID;// for Deposit List from View
	private String customerFullName;// for Deposit List from View
	private String allocationStatus;// for Deposit List from View
	private String locationCode;// for Deposit List from View
	private String allocationBy;// for Deposit List from View
	private String locationID;
	private String agentID;// for Deposit List from View
	private String depositAccCcy;// for Deposit List from View
	private Date depositOpenedDate;// for Deposit List from View
	private String depositFrequency;
	private double perinstallmentAmt;
	private double installmentAmtDue;
	private float interestRate;
	private double maturityAmount;// maturityAmount
	private Date maturityDate;// for Deposit List from View
	private Date lastInstallmentDate;
	private String overdueStat;
	private Date overdueDate;
	private double overdueAmt;
	private String redemptionFlag;// for Deposit List from View
	private Date redemptionPayoutDate;// for Deposit List from View
	private double redemptionAmount;// for Deposit List from View
	private String syncStatus;
	private String syncTime;
	private String recordStat;
	private String jobID;

	private String customerName;
	private String agentName;
	private int depositTenure;
	private String locationName;

	private Date nextInstDate;
	private String depTenure;
	private String numOfInstDue;
	private String txnType;
	private double schInstallmentAmt;
	private String payFreqType;
	private String payFreq;
	private String tenureType;
	private double principalMaturityAmount;
	private Date interestAccuredTillDate;
	private Date installmentPaidTillDate;
	private double totalInstallmentAmtDue;
	private String currency;


	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getNumOfInstDue() {
		return numOfInstDue;
	}

	public void setNumOfInstDue(String numOfInstDue) {
		this.numOfInstDue = numOfInstDue;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public int getDepositTenure() {
		return depositTenure;
	}

	public void setDepositTenure(int depositTenure) {
		this.depositTenure = depositTenure;
	}

	public String getDepTenure() {
		return depTenure;
	}

	public void setDepTenure(String depTenure) {
		this.depTenure = depTenure;
	}

	public Date getNextInstDate() {
		return nextInstDate;
	}

	public void setNextInstDate(Date nextInstDate) {
		this.nextInstDate = nextInstDate;
	}

	public String getDepositAccountNumber() {
		return depositAccountNumber;
	}

	public void setDepositAccountNumber(String depositAccountNumber) {
		this.depositAccountNumber = depositAccountNumber;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public Date getDepositOpenedDate() {
		return depositOpenedDate;
	}

	public void setDepositOpenedDate(Date depositOpenedDate) {
		this.depositOpenedDate = depositOpenedDate;
	}

	public String getDepositFrequency() {
		return depositFrequency;
	}

	public void setDepositFrequency(String depositFrequency) {
		this.depositFrequency = depositFrequency;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public String getDepositAccCcy() {
		return depositAccCcy;
	}

	public void setDepositAccCcy(String depositAccCcy) {
		this.depositAccCcy = depositAccCcy;
	}

	public double getPerinstallmentAmt() {
		return perinstallmentAmt;
	}

	public void setPerinstallmentAmt(double perinstallmentAmt) {
		this.perinstallmentAmt = perinstallmentAmt;
	}

	public Date getLastInstallmentDate() {
		return lastInstallmentDate;
	}

	public void setLastInstallmentDate(Date lastInstallmentDate) {
		this.lastInstallmentDate = lastInstallmentDate;
	}

	public double getInstallmentAmtDue() {
		return installmentAmtDue;
	}

	public void setInstallmentAmtDue(double installmentAmtDue) {
		this.installmentAmtDue = installmentAmtDue;
	}

	public String getOverdueStat() {
		return overdueStat;
	}

	public void setOverdueStat(String overdueStat) {
		this.overdueStat = overdueStat;
	}

	public double getOverdueAmt() {
		return overdueAmt;
	}

	public void setOverdueAmt(double overdueAmt) {
		this.overdueAmt = overdueAmt;
	}

	public Date getOverdueDate() {
		return overdueDate;
	}

	public void setOverdueDate(Date overdueDate) {
		this.overdueDate = overdueDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getRedemptionFlag() {
		return redemptionFlag;
	}

	public void setRedemptionFlag(String redemptionFlag) {
		this.redemptionFlag = redemptionFlag;
	}

	public double getRedemptionAmount() {
		return redemptionAmount;
	}

	public void setRedemptionAmount(double redemptionAmount) {
		this.redemptionAmount = redemptionAmount;
	}

	public Date getRedemptionPayoutDate() {
		return redemptionPayoutDate;
	}

	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		this.redemptionPayoutDate = redemptionPayoutDate;
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
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

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getRecordStat() {
		return recordStat;
	}

	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}

	public double getTotalInstPaid() {
		return totalInstPaid;
	}

	public void setTotalInstPaid(double totalInstPaid) {
		this.totalInstPaid = totalInstPaid;
	}

	public double getTotalIntAccured() {
		return totalIntAccured;
	}

	public void setTotalIntAccured(double totalIntAccured) {
		this.totalIntAccured = totalIntAccured;
	}

	public double getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public String getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getAllocationBy() {
		return allocationBy;
	}

	public void setAllocationBy(String allocationBy) {
		this.allocationBy = allocationBy;
	}

	public double getSchInstallmentAmt() {
		return schInstallmentAmt;
	}

	public void setSchInstallmentAmt(double schInstallmentAmt) {
		this.schInstallmentAmt = schInstallmentAmt;
	}

	public String getPayFreqType() {
		return payFreqType;
	}

	public void setPayFreqType(String payFreqType) {
		this.payFreqType = payFreqType;
	}

	public String getPayFreq() {
		return payFreq;
	}

	public void setPayFreq(String payFreq) {
		this.payFreq = payFreq;
	}

	public String getTenureType() {
		return tenureType;
	}

	public void setTenureType(String tenureType) {
		this.tenureType = tenureType;
	}

	public double getPrincipalMaturityAmount() {
		return principalMaturityAmount;
	}

	public void setPrincipalMaturityAmount(double principalMaturityAmount) {
		this.principalMaturityAmount = principalMaturityAmount;
	}

	public Date getInterestAccuredTillDate() {
		return interestAccuredTillDate;
	}

	public void setInterestAccuredTillDate(Date interestAccuredTillDate) {
		this.interestAccuredTillDate = interestAccuredTillDate;
	}

	public Date getInstallmentPaidTillDate() {
		return installmentPaidTillDate;
	}

	public void setInstallmentPaidTillDate(Date installmentPaidTillDate) {
		this.installmentPaidTillDate = installmentPaidTillDate;
	}

	public double getTotalInstallmentAmtDue() {
		return totalInstallmentAmtDue;
	}

	public void setTotalInstallmentAmtDue(double totalInstallmentAmtDue) {
		this.totalInstallmentAmtDue = totalInstallmentAmtDue;
	}

}
