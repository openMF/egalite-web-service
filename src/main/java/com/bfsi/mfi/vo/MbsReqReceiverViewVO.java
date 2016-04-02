package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.MbsReqReceiverView;

public class MbsReqReceiverViewVO extends MaintenanceVO<MbsReqReceiverView>{
	
	public MbsReqReceiverViewVO() {
		entity = new MbsReqReceiverView();
	}

	public MbsReqReceiverViewVO(MbsReqReceiverView entity) {
		super(entity);
	}

	
	public String getTxnDesc() {
		return  entity.getTxnDesc();
	}

	public void setTxnDesc(String txnDesc) {
		entity.setTxnDesc(txnDesc); 
	}

	public String getTxnCode() {
		return  entity.getTxnCode();
	}

	public void setTxnCode(String txnCode) {
		entity.setTxnCode(txnCode);
	}

	public String getCbsAcRefNo() {
		return  entity.getCbsAcRefNo();
	}

	public void setCbsAcRefNo(String cbsAcRefNo) {
		entity.setCbsAcRefNo(cbsAcRefNo); 
	}

	public String getBranchCode() {
		return  entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}

	public String getCustomerId() {
		return  entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId); 
	}

	public String getAgentId() {
		return  entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId); 
	}

	public String getDeviceId() {
		return  entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId); 
	}

	public String getLocationCode() {
		return  entity.getLocationCode();
	}

	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode);
	}

	public Date getTxnInitTime() {
		return  entity.getTxnInitTime();
	}

	public void setTxnInitTime(Date txnInitTime) {
		entity.setTxnInitTime(txnInitTime); 
	}

	public String getTxnStatusDesc() {
		return  entity.getTxnStatusDesc();
	}

	public void setTxnStatusDesc(String txnStatusDesc) {
		entity.setTxnStatusDesc(txnStatusDesc);
	}
	
}
