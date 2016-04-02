package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_MBS_TXN_RECEIVER_V")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MfiMbsTxnReceiverV extends MaintenanceEntity {
	public MfiMbsTxnReceiverV() {
	}
	/*@Column(name = "MBS_TXN_ID", nullable = false)
	private String mbsTxnId;*/
	
	@Column(name = "TXN_CODE", nullable = true)
	private String txnCode;
	
	
	@Column(name = "TXN_DESC", nullable = true)
	private String txnDesc;
	
	@Column(name = "AGENDA_ID", nullable = true)
	private String agendaId;
	
	@Column(name = "SEQ_NO ", nullable = true)
	private long seqNo;
	
	@Column(name = "CBS_AC_REF_NO ", nullable = true)
	private String cbsAcRefNo;
	
	@Column(name = "BRANCH_CODE", nullable = true)
	private String branchCode;
	
	@Column(name = "CUSTOMER_ID ", nullable = true)
	private String customerId;
	
	@Column(name = "AGENT_ID", nullable = true)
	private String agentId;
	
	@Column(name = "DEVICE_ID ", nullable = true)
	private String deviceId;
	
	@Column(name = "LOCATION_CODE ", nullable = true)
	private String locationCode;
	
	@Column(name = "TXN_INIT_TIME", nullable = true)
	private Date txnInitTime;
	
	@Column(name = "TXN_STATUS_DESC", nullable = true)
	private String txnStatusDesc;
	
	@Column(name = "PARENT_LOAN_AC_NO", nullable = true)
	private String parentLoanAcNo;
	
	@Column(name = "LOAN_AC_NO", nullable = true)
	private String loanAcNo;
	
	@Column(name = "PARENT_CUST_ID", nullable = true)
	private String parentCustId;
	
	@Column(name = "IS_PARENT_LOAN", nullable = true)
	private String isParentLoan;
	
	@Column(name = "IS_GROUP_LOAN", nullable = true)
	private String isGroupLoan;
	
	

	/*public String getMbsTxnId() {
		return mbsTxnId;
	}

	public void setMbsTxnId(String mbsTxnId) {
		this.mbsTxnId = mbsTxnId;
	}*/

	public String getIsParentLoan() {
		return isParentLoan;
	}

	public void setIsParentLoan(String isParentLoan) {
		this.isParentLoan = isParentLoan;
	}

	public String getIsGroupLoan() {
		return isGroupLoan;
	}

	public void setIsGroupLoan(String isGroupLoan) {
		this.isGroupLoan = isGroupLoan;
	}

	public String getParentLoanAcNo() {
		return parentLoanAcNo;
	}

	public void setParentLoanAcNo(String parentLoanAcNo) {
		this.parentLoanAcNo = parentLoanAcNo;
	}

	public String getLoanAcNo() {
		return loanAcNo;
	}

	public void setLoanAcNo(String loanAcNo) {
		this.loanAcNo = loanAcNo;
	}

	public String getParentCustId() {
		return parentCustId;
	}

	public void setParentCustId(String parentCustId) {
		this.parentCustId = parentCustId;
	}

	public String getTxnDesc() {
		return txnDesc;
	}

	public void setTxnDesc(String txnDesc) {
		this.txnDesc = txnDesc;
	}


	public String getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(String agendaId) {
		this.agendaId = agendaId;
	}

	public long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(long seqNo) {
		this.seqNo = seqNo;
	}

	public String getCbsAcRefNo() {
		return cbsAcRefNo;
	}

	public void setCbsAcRefNo(String cbsAcRefNo) {
		this.cbsAcRefNo = cbsAcRefNo;
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

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getTxnInitTime() {
		return txnInitTime;
	}

	public void setTxnInitTime(Date txnInitTime) {
		this.txnInitTime = txnInitTime;
	}

	public String getTxnStatusDesc() {
		return txnStatusDesc;
	}

	public void setTxnStatusDesc(String txnStatusDesc) {
		this.txnStatusDesc = txnStatusDesc;
	}
	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
}
