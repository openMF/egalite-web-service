package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "IFTB_PIGMY_DEPOSIT")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PigmyView extends MaintenanceEntity {
	
	public PigmyView() {
	}
	
	private String depositAccountNumber;
	private String branchCode;
	private String customerID;
	private String customerFullName;
	private String allocationStatus;
	private String agentId;
	private String locationCode;
	private String allocationByCode;
	private String currency;
	private Date openDate;
	private Date maturityDate;
	private double schInstallmentAmt;
	private String payFreqType;
	private String payFreq;
	private String tenureType;
	private String tenure;
	private float interestRate;
	private double principalMaturityAmount;
	private double interestAccuredTillDate;
	private double installmentPaidTillDate;
	private double totalInstallmentAmtDue;
	private String redemptionFlag;
	private Date redemptionPayoutDate;
	private double redemptionAmount;
	private String recordStat;
	private String cbsUplJobId;
	private String creditOfficerCode;
	private String creditOfficerName;
	
	
	public String getDepositAccountNumber() {
		return depositAccountNumber;
	}
	public void setDepositAccountNumber(String depositAccountNumber) {
		this.depositAccountNumber = depositAccountNumber;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getAllocationByCode() {
		return allocationByCode;
	}
	public void setAllocationByCode(String allocationByCode) {
		this.allocationByCode = allocationByCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public double getPrincipalMaturityAmount() {
		return principalMaturityAmount;
	}
	public void setPrincipalMaturityAmount(double principalMaturityAmount) {
		this.principalMaturityAmount = principalMaturityAmount;
	}
	public double getInterestAccuredTillDate() {
		return interestAccuredTillDate;
	}
	public void setInterestAccuredTillDate(double interestAccuredTillDate) {
		this.interestAccuredTillDate = interestAccuredTillDate;
	}
	public double getInstallmentPaidTillDate() {
		return installmentPaidTillDate;
	}
	public void setInstallmentPaidTillDate(double installmentPaidTillDate) {
		this.installmentPaidTillDate = installmentPaidTillDate;
	}
	public double getTotalInstallmentAmtDue() {
		return totalInstallmentAmtDue;
	}
	public void setTotalInstallmentAmtDue(double totalInstallmentAmtDue) {
		this.totalInstallmentAmtDue = totalInstallmentAmtDue;
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
	public double getRedemptionAmount() {
		return redemptionAmount;
	}
	public void setRedemptionAmount(double redemptionAmount) {
		this.redemptionAmount = redemptionAmount;
	}
	public String getRecordStat() {
		return recordStat;
	}
	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}
	public String getCbsUplJobId() {
		return cbsUplJobId;
	}
	public void setCbsUplJobId(String cbsUplJobId) {
		this.cbsUplJobId = cbsUplJobId;
	}
	public String getCreditOfficerCode() {
		return creditOfficerCode;
	}
	public void setCreditOfficerCode(String creditOfficerCode) {
		this.creditOfficerCode = creditOfficerCode;
	}
	public String getCreditOfficerName() {
		return creditOfficerName;
	}
	public void setCreditOfficerName(String creditOfficerName) {
		this.creditOfficerName = creditOfficerName;
	}
	
}
