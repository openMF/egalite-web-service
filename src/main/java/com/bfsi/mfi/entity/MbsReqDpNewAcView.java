package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_mbs_req_dpnewac_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MbsReqDpNewAcView extends MaintenanceEntity {
 
	public MbsReqDpNewAcView() {
	}	
	/* a.mbs_txn_id,//superid
	a.txn_code,a.branch_code,a.customer_id,b.customer_full_name,a.agent_id, agent_name,
	a.location_code,l.location_desc, deposit_request_date, agreed_installment_amount,
	 proposed_installment_number, expected_maturity_date, proposed_interest_rate,proposed_tenure_type,
	proposed_tenure, proposed_frequency_type,proposed_frequency,a.txn_narrative,a.txn_init_time,
	a.txn_sync_time,d.txn_status_desc,a.txn_err_code,a.txn_err_message */
/*	@Column(name = "MBS_TXN_ID", nullable = false)
	private String mbsTxnId;*/
	@Column(name = "txn_code", nullable = false)
	private String txnCode;
	@Column(name = "txn_desc", nullable = false)
	private String txnDesc;
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	@Column(name = "customer_id", nullable = false)
	private String customerId;
	@Column(name = "customer_full_name", nullable = false)
	private String customerFullName;
	@Column(name = "agent_id", nullable = false)
	private String agentId;
	@Column(name = "agent_name", nullable = false)
	private String agentName;
	@Column(name = "location_code", nullable = false)
	private String locationCode;
	@Column(name = "location_desc", nullable = false)
	private String locationDesc;
	
	@Column(name = "deposit_request_date", nullable = false)
	private Date depositRequestDate;
	
	@Column(name = "agreed_installment_amount", nullable = false)
	private Double agreedInstallmentAmount;
	@Column(name = "proposed_installment_number", nullable = false)
	private Integer proposedInstallmentNumber;
	
	@Column(name = "expected_maturity_date", nullable = false)
	private Date expectedMaturityDate;
	
	@Column(name = "proposed_interest_rate", nullable = false)
	private Double proposedInterestRate;
	
	@Column(name = "proposed_tenure_type", nullable = false)
	private String proposedTenureType;
	
	@Column(name = "proposed_tenure", nullable = false)
	private Integer proposedTenure;
	
	@Column(name = "proposed_frequency_type", nullable = false)
	private String proposedFrequencyType;
	
	@Column(name = "proposed_frequency", nullable = false)
	private Integer proposedFrequency;
	
	@Column(name = "txn_narrative", nullable = false)
	private String txnNarrative;
	
	@Column(name = "txn_init_time", nullable = false)
	private Date txnInitTime;
	@Column(name = "txn_sync_time", nullable = false)
	private Date txnSyncTime;
	
	@Column(name = "txn_status_desc", nullable = false)
	private String txnStatusDesc;

	@Column(name = "txn_err_code", nullable = false)
	private String txnErrCode;
	@Column(name = "txn_err_message", nullable = false)
	private String txnErrMessage;
	/*EGA-MN15-000022 start*/
	@Column(name = "generated_sms", nullable = false)
	private String generatedSms;
	@Column(name = "sms_mobile_no", nullable = false)
	private String smsMobileNo;
	@Column(name = "sms_content", nullable = false)
	private String smsContent;
	@Column(name = "generated_revr", nullable = false)
	private String generatedRevr;
	
	@Column(name = "full_part_ind", nullable = false)
	private String fullPartInd;
	@Column(name = "sync_type", nullable = false)
	private String syncType;
	
	public String getGeneratedSms() {
		return generatedSms;
	}

	public void setGeneratedSms(String generatedSms) {
		this.generatedSms = generatedSms;
	}

	public String getSmsMobileNo() {
		return smsMobileNo;
	}

	public void setSmsMobileNo(String smsMobileNo) {
		this.smsMobileNo = smsMobileNo;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getGeneratedRevr() {
		return generatedRevr;
	}

	public void setGeneratedRevr(String generatedRevr) {
		this.generatedRevr = generatedRevr;
	}

	public String getFullPartInd() {
		return fullPartInd;
	}

	public void setFullPartInd(String fullPartInd) {
		this.fullPartInd = fullPartInd;
	}

	public String getSyncType() {
		return syncType;
	}

	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}

	/*EGA-MN15-000022 end*/
	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	
	public String getTxnDesc() {
		return txnDesc;
	}
	public void setTxnDesc(String txnDesc) {
		this.txnDesc = txnDesc;
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

	public String getCustomerFullName() {
		return customerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public Date getDepositRequestDate() {
		return depositRequestDate;
	}

	public void setDepositRequestDate(Date depositRequestDate) {
		this.depositRequestDate = depositRequestDate;
	}

	public Double getAgreedInstallmentAmount() {
		return agreedInstallmentAmount;
	}

	public void setAgreedInstallmentAmount(Double agreedInstallmentAmount) {
		this.agreedInstallmentAmount = agreedInstallmentAmount;
	}

	public Integer getProposedInstallmentNumber() {
		return proposedInstallmentNumber;
	}

	public void setProposedInstallmentNumber(Integer proposedInstallmentNumber) {
		this.proposedInstallmentNumber = proposedInstallmentNumber;
	}

	public Date getExpectedMaturityDate() {
		return expectedMaturityDate;
	}

	public void setExpectedMaturityDate(Date expectedMaturityDate) {
		this.expectedMaturityDate = expectedMaturityDate;
	}

	public Double getProposedInterestRate() {
		return proposedInterestRate;
	}

	public void setProposedInterestRate(Double proposedInterestRate) {
		this.proposedInterestRate = proposedInterestRate;
	}

	public String getProposedTenureType() {
		return proposedTenureType;
	}

	public void setProposedTenureType(String proposedTenureType) {
		this.proposedTenureType = proposedTenureType;
	}

	public Integer getProposedTenure() {
		return proposedTenure;
	}

	public void setProposedTenure(Integer proposedTenure) {
		this.proposedTenure = proposedTenure;
	}

	public String getProposedFrequencyType() {
		return proposedFrequencyType;
	}

	public void setProposedFrequencyType(String proposedFrequencyType) {
		this.proposedFrequencyType = proposedFrequencyType;
	}

	public Integer getProposedFrequency() {
		return proposedFrequency;
	}

	public void setProposedFrequency(Integer proposedFrequency) {
		this.proposedFrequency = proposedFrequency;
	}

	public String getTxnNarrative() {
		return txnNarrative;
	}

	public void setTxnNarrative(String txnNarrative) {
		this.txnNarrative = txnNarrative;
	}

	public Date getTxnInitTime() {
		return txnInitTime;
	}

	public void setTxnInitTime(Date txnInitTime) {
		this.txnInitTime = txnInitTime;
	}

	public Date getTxnSyncTime() {
		return txnSyncTime;
	}

	public void setTxnSyncTime(Date txnSyncTime) {
		this.txnSyncTime = txnSyncTime;
	}

	public String getTxnStatusDesc() {
		return txnStatusDesc;
	}

	public void setTxnStatusDesc(String txnStatusDesc) {
		this.txnStatusDesc = txnStatusDesc;
	}

	
	public String getTxnErrCode() {
		return txnErrCode;
	}

	public void setTxnErrCode(String txnErrCode) {
		this.txnErrCode = txnErrCode;
	}

	public String getTxnErrMessage() {
		return txnErrMessage;
	}

	public void setTxnErrMessage(String txnErrMessage) {
		this.txnErrMessage = txnErrMessage;
	}
		
}
