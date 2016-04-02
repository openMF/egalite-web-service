package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.MbsReqDpPrepayView;

public class MbsReqDpPrepayViewVO extends MaintenanceVO<MbsReqDpPrepayView>{
	public MbsReqDpPrepayViewVO() {
		entity = new MbsReqDpPrepayView();
	}

	public MbsReqDpPrepayViewVO(MbsReqDpPrepayView entity) {
		super(entity);
	}

	
	
	public String getTxnCode() {
		return entity.getTxnCode();
	}
	public void setTxnCode(String txnCode) {
		entity.setTxnCode(txnCode); 
	}
	public String getTxnDesc() {
		return entity.getTxnDesc();
	}
	public void setTxnDesc(String txnDesc) {
		 entity.setTxnDesc(txnDesc);
	}
	public String getCbsAcRefNo() {
		return entity.getCbsAcRefNo();
	}
	public void setCbsAcRefNo(String cbsAcRefNo) {
		entity.setCbsAcRefNo(cbsAcRefNo); 
	}
	public String getBranCode() {
		return entity.getBranCode();
	}
	public void setBranCode(String branCode) {
		entity.setBranCode(branCode); 
	}
	public String getCustomerId() {
		return entity.getCustomerId();
	}
	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId); 
	}
	public String getCustomerFullName() {
		return entity.getCustomerFullName();
	}
	public void setCustomerFullName(String customerFullName) {
		entity.setCustomerFullName(customerFullName); 
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		entity.setAgentId(agentId); 
	}
	public String getAgentName() {
		return entity.getAgentName();
	}
	public void setAgentName(String agentName) {
		entity.setAgentName(agentName);
	}
	public String getLocationCode() {
		return entity.getLocationCode();
	}
	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode); 
	}
	public String getLocationDesc() {
		return entity.getLocationDesc();
	}
	public void setLocationDesc(String locationDesc) {
		entity.setLocationDesc(locationDesc); 
	}
	public Double getAmountPaid() {
		return entity.getAmountPaid();
	}
	public void setAmountPaid(Double amountPaid) {
		entity.setAmountPaid(amountPaid);
	}
	public Date getRedemptionRequestDate() {
		return entity.getRedemptionRequestDate();
	}
	public void setRedemptionRequestDate(Date redemptionRequestDate) {
		entity.setRedemptionRequestDate(redemptionRequestDate);
	}
	public String getTxnNarrative() {
		return entity.getTxnNarrative();
	}
	public void setTxnNarrative(String txnNarrative) {
		entity.setTxnNarrative(txnNarrative);
	}
	public Date getTxnInitTime() {
		return entity.getTxnInitTime();
	}
	public void setTxnInitTime(Date txnInitTime) {
		entity.setTxnInitTime(txnInitTime); 
	}
	public Date getTxnSyncTime() {
		return entity.getTxnSyncTime();
	}
	public void setTxnSyncTime(Date txnSyncTime) {
		entity.setTxnSyncTime(txnSyncTime); 
	}
	public String getTxnStatusDesc() {
		return entity.getTxnStatusDesc();
	}
	public void setTxnStatusDesc(String txnStatusDesc) {
		entity.setTxnStatusDesc(txnStatusDesc); 
	}
	public String getTxnErrCode() {
		return entity.getTxnErrCode();
	}
	public void setTxnErrCode(String txnErrCode) {
		entity.setTxnErrCode(txnErrCode); 
	}
	public String getTxnErrMessage() {
		return entity.getTxnErrMessage();
	}
	public void setTxnErrMessage(String txnErrMessage) {
		entity.setTxnErrMessage(txnErrMessage); 
	}
	/*EGA-MN15-000022 start*/
	public String getGeneratedSms() {
		return entity.getGeneratedSms();
	}
	public void setGeneratedSms(String generatedSms)
	{
		entity.setGeneratedSms(generatedSms);
		
	}
	public String getSmsMobileNo()
	{
		return entity.getSmsMobileNo();
	}
	public void setSmsMobileNo(String smsMobileNo) 
	{
		entity.setSmsMobileNo(smsMobileNo);
		
	}
	public String getSmsContent() {
		return entity.getSmsContent();
	}

	public void setSmsContent(String smsContent) {
		entity.setSmsContent(smsContent);
		
	}
	public String getGeneratedRevr() {
		return entity.getGeneratedRevr();
	}

	public void setGeneratedRevr(String generatedRevr) {
		entity.setGeneratedRevr(generatedRevr);
		
	}
	
	public String getFullPartInd() {
		return entity.getFullPartInd();
	}

	public void setFullPartInd(String fullPartInd) {
		entity.setFullPartInd(fullPartInd);
		
	}

	public String getSyncType() {
		return entity.getSyncType();
	}

	public void setSyncType(String syncType) {
		entity.setSyncType(syncType);
		
	}
	
	/*EGA-MN15-000022 end*/
	
}
