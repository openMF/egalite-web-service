package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "mfi_mbs_req_cashdeposit_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CashDeposit extends MaintenanceEntity{
	public CashDeposit(){	
	}
	
	/*a.mbs_txn_id,//superid
	a.txn_code,a.cbs_ac_ref_no,a.branch_code,a.customer_id,b.customer_full_name,
	a.agent_id, agent_name,a.location_code,l.location_desc,
	 txn_amount,
	a.txn_narrative,a.txn_init_time,a.txn_sync_time,d.txn_status_desc,
	a.txn_err_code,a.txn_err_message*/
	
	@Column(name = "txn_code", nullable = false)
	private String txnCode;
	@Column(name = "txn_desc", nullable = false)
	private String txnDesc;
	@Column(name = "cbs_ac_ref_no", nullable = false)
	private String cbsAcRefNo;
	@Column(name = "branch_code", nullable = false)
	private String branCode;
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
	
	@Column(name = "txn_amount", nullable = false)
	private Double txnAmount;
	
	@Column(name = "txn_narrative", nullable = false)
	private String txnNarrative;
	
	@Column(name = "txn_init_time", nullable = false)
	private Date txnInitTime;
	@Column(name = "txn_sync_time", nullable = false)
	private Date txnSyncTime;
	
	@Column(name = "txn_status_desc", nullable = false)
	private String txnStatusDesc;
	@Column(name = "TXN_ERR_CODE", nullable = false)
	private String txnErrCode;
	@Column(name = "TXN_ERR_MESSAGE", nullable = false)
	private String txnErrMessage;
	
	
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
	public String getCbsAcRefNo() {
		return cbsAcRefNo;
	}
	public void setCbsAcRefNo(String cbsAcRefNo) {
		this.cbsAcRefNo = cbsAcRefNo;
	}
	public String getBranCode() {
		return branCode;
	}
	public void setBranCode(String branCode) {
		this.branCode = branCode;
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
	public Double getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(Double txnAmount) {
		this.txnAmount = txnAmount;
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
