package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.ManualAgendaSettle;

public class ManualAgendaSettleVO extends MaintenanceVO<ManualAgendaSettle>{   
	public ManualAgendaSettleVO() {
		entity = new ManualAgendaSettle();
	}

	public ManualAgendaSettleVO(ManualAgendaSettle entity) {
		super(entity);
	}	
	
	public String getAgendaId() {
		return  entity.getAgendaId();
	}

	public void setAgendaId(String agendaId) {
		entity.setAgendaId(agendaId); 
	}

	public Integer getSeqNo() {
		return  entity.getSeqNo();
	}

	public void setSeqNo(Integer seqNo) {
		entity.setSeqNo(seqNo); 
	}

	public String getCbsAcRefNo() {
		return  entity.getCbsAcRefNo();
	}

	public void setCbsAcRefNo(String cbsAcRefNo) {
		entity.setCbsAcRefNo(cbsAcRefNo); 
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

	public String getAgnCmpName() {
		return  entity.getAgnCmpName();
	}

	public void setAgnCmpName(String agnCmpName) {
		entity.setAgnCmpName(agnCmpName); 
	}

	public Date getAgnCmpStDate() {
		return  entity.getAgnCmpStDate();
	}

	public void setAgnCmpStDate(Date agnCmpStDate) {
		entity.setAgnCmpStDate(agnCmpStDate); 
	}

	public Date getAgnCmpEndDate() {
		return  entity.getAgnCmpEndDate();
	}

	public void setAgnCmpEndDate(Date agnCmpEndDate) {
		entity.setAgnCmpEndDate(agnCmpEndDate);
	}

	public String getAgnCcyCode() {
		return  entity.getAgnCcyCode();
	}

	public void setAgnCcyCode(String agnCcyCode) {
		entity.setAgnCcyCode(agnCcyCode); 
	}

	public Double getAgnAgendaAmt() {
		return  entity.getAgnAgendaAmt();
	}

	public void setAgnAgendaAmt(Double agnAgendaAmt) {
		entity.setAgnAgendaAmt(agnAgendaAmt);
	}

	public Double getAgnAgendaSettledAmt() {
		return  entity.getAgnAgendaSettledAmt();
	}

	public void setAgnAgendaSettledAmt(Double agnAgendaSettledAmt) {
		entity.setAgnAgendaSettledAmt(agnAgendaSettledAmt); 
	}

	public String getFullPartInd() {
		return  entity.getFullPartInd();
	}

	public void setFullPartInd(String fullPartInd) {
		entity.setFullPartInd(fullPartInd); 
	}

	public String getSettleRemarks() {
		return  entity.getSettleRemarks();
	}

	public void setSettleRemarks(String settleRemarks) {
		entity.setSettleRemarks(settleRemarks);
	}

	public String getIsActive() {
		return  entity.getIsActive();
	}

	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
	}

	public String getAuthStatus() {
		return  entity.getAuthStatus();
	}

	public void setAuthStatus(String authStatus) {
		entity.setAuthStatus(authStatus);
	}

	public String getInitByUserId() {
		return  entity.getInitByUserId();
	}

	public void setInitByUserId(String initByUserId) {
		entity.setInitByUserId(initByUserId);
	}

	public String getVerifyByUserId() {
		return  entity.getVerifyByUserId();
	}

	public void setVerifyByUserId(String verifyByUserId) {
		entity.setVerifyByUserId(verifyByUserId); 
	}

	public Date getInitDateTime() {
		return  entity.getInitDateTime();
	}

	public void setInitDateTime(Date initDateTime) {
		entity.setInitDateTime(initDateTime); 
	}

	public Date getAuthDateTime() {
		return  entity.getAuthDateTime();
	}

	public void setAuthDateTime(Date authDateTime) {
		entity.setAuthDateTime(authDateTime);
	}

	public String getProcessStat() {
		return  entity.getProcessStat();
	}

	public void setProcessStat(String processStat) {
		entity.setProcessStat(processStat);
	}
	
	
	public String getErrCode() {
		return entity.getErrCode();
	}

	public void setErrCode(String errCode) {
		entity.setErrCode(errCode);
	}

	public String getErrDesc() {
		return entity.getErrDesc();
	}

	public void setErrDesc(String errDesc) {
		entity.setErrDesc(errDesc); 
	}
	
	public String getRecId() {
		return entity.getRecId();
	}

	public void setRecId(String recId) {
		entity.setRecId(recId); 
	}
	
	public String getTxnCode() {
		return entity.getTxnCode();
	}

	public void setTxnCode(String txnCode) {
		entity.setTxnCode(txnCode); 
	}
	
	
	
	public Object clone() {
		ManualAgendaSettleVO copyObj = new ManualAgendaSettleVO();
		
		copyObj.setRecId(getRecId());
		copyObj.setAgendaId(getAgendaId());
		copyObj.setSeqNo(getSeqNo());
		copyObj.setCbsAcRefNo(getCbsAcRefNo());
		copyObj.setCustomerId(getCustomerId());
		copyObj.setAgentId(getAgentId());
		copyObj.setDeviceId(getDeviceId());
		copyObj.setLocationCode(getLocationCode());
		copyObj.setAgnCmpName(getAgnCmpName());
		copyObj.setAuthStatus(getAuthStatus());
		//copyObj.setAuthStatusText(getAuthStatusText());//
		copyObj.setIsActive(getIsActive());
		copyObj.setAgnCmpStDate(getAgnCmpStDate());
		copyObj.setAgnCmpEndDate(getAgnCmpEndDate());
		copyObj.setAgnCcyCode(getAgnCcyCode());
		copyObj.setAgnAgendaAmt(getAgnAgendaAmt());
		copyObj.setAgnAgendaSettledAmt(getAgnAgendaSettledAmt());
		copyObj.setFullPartInd(getFullPartInd());
		copyObj.setSettleRemarks(getSettleRemarks());
		copyObj.setInitByUserId(getInitByUserId());
		copyObj.setVerifyByUserId(getVerifyByUserId());
		copyObj.setInitDateTime(getInitDateTime());
		copyObj.setAuthDateTime(getAuthDateTime());
		copyObj.setProcessStat(getProcessStat());
		copyObj.setErrCode(getErrCode());
		copyObj.setErrDesc(getErrDesc());
		copyObj.setTxnCode(getTxnCode());
		
		return copyObj;
	}
}
