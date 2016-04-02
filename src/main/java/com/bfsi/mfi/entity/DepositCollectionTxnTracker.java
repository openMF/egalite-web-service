package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_MBS_TXN_DP_COLL_V")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositCollectionTxnTracker extends MaintenanceEntity{
	@Column(name = "AGENDA_ID", nullable = false)
	private String agendaId ;
	
	@Column(name = "SEQ_NO", nullable = false)
	private long seqNo ;
	
	@Column(name = "TXN_CODE", nullable = false)
	private String txnCode ;
	
	
	@Column(name = "CBS_AC_REF_NO ", nullable = true)
	private String cbsAcRefNo;
	
	@Column(name = "BRANCH_CODE", nullable = true)
	private String branchCode;
	
	@Column(name = "CUSTOMER_ID ", nullable = true)
	private String customerId;
	
	@Column(name = "CUSTOMER_FULL_NAME", nullable = true)
	private String customerFullName;
	
	@Column(name = "AGENT_ID", nullable = true)
	private String agentId;
	
	@Column(name = "AGENT_NAME", nullable = true)
	private String agentName;
	
	@Column(name = "LOCATION_CODE", nullable = true)
	private String locationCode;
	
	@Column(name = "LOCATION_DESC", nullable = true)
	private String locationDesc;
	
	@Column(name = "AMOUNT_DUE", nullable = true)
	private Double amountDue;
	
	@Column(name = "AMOUNT_PAID", nullable = true)
	private Double amountPaid;
	
	@Column(name = "TXN_NARRATIVE", nullable = true)
	private String txnNarrative;
	
	@Column(name = "TXN_INIT_TIME", nullable = true)
	private Date txnInitTime;
	
	@Column(name = "TXN_SYNC_TIME", nullable = true)
	private Date txnSyncTime;
	
	@Column(name = "TXN_STATUS_DESC", nullable = true)
	private String txnStatusDesc;
	
	@Column(name = "TXN_ERR_CODE", nullable = true)
	private String txnErrCode;
	

	@Column(name = "TXN_ERR_MESSAGE", nullable = true)
	private String txnErrMessage;
	
	
	/*For Tag No : EGA-MN15-000021 Starts*/
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
	
	/*For Tag No : EGA-MN15-000021 End*/
	
	
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

	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
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

	public Double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(Double amountDue) {
		this.amountDue = amountDue;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
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

/*For Tag No : EGA-MN15-000021 Starts*/
	
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
	
	/*For Tag No : EGA-MN15-000021 End*/


}
