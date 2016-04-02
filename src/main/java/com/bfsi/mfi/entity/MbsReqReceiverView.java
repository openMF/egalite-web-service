package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_mbs_req_receiver_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MbsReqReceiverView extends MaintenanceEntity{

	public MbsReqReceiverView() {
	}
	/*a.mbs_txn_id,//super id
	b.txn_desc,a.txn_code,a.cbs_ac_ref_no,a.branch_code,a.customer_id,
	a.agent_id,a.device_id,a.location_code,a.txn_init_time,d.txn_status_desc*/
	
	@Column(name = "txn_desc", nullable = false)
	private String txnDesc;
	@Column(name = "txn_code", nullable = false)
	private String txnCode;
	@Column(name = "cbs_ac_ref_no", nullable = false)
	private String cbsAcRefNo;
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	@Column(name = "customer_id", nullable = false)
	private String customerId;
	@Column(name = "agent_id", nullable = false)
	private String agentId;
	@Column(name = "device_id", nullable = false)
	private String deviceId;
	@Column(name = "location_code", nullable = false)
	private String locationCode;
	
	@Column(name = "txn_init_time", nullable = false)
	private Date txnInitTime;
	
	@Column(name = "txn_status_desc", nullable = false)
	private String txnStatusDesc;

	public String getTxnDesc() {
		return txnDesc;
	}

	public void setTxnDesc(String txnDesc) {
		this.txnDesc = txnDesc;
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
	
	
	
}
