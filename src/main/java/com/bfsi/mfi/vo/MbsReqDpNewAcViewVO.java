package com.bfsi.mfi.vo;


import java.util.Date;

import com.bfsi.mfi.entity.MbsReqDpNewAcView;

public class MbsReqDpNewAcViewVO extends MaintenanceVO<MbsReqDpNewAcView>{

	public MbsReqDpNewAcViewVO() {
		entity = new MbsReqDpNewAcView();
	}

	public MbsReqDpNewAcViewVO(MbsReqDpNewAcView entity) {
		super(entity);
	}
	
/*	
	public String getId() {//
		return super.getId();
		}

		public void setId(String mbsTxnId) {
			super.setId(mbsTxnId);
		}
*/

	public String getMbsTxnId()
	{
		return  super.getId();	
	}
	public void setMbsTxnId(String mbsTxnId)
	{
		super.setId(mbsTxnId);
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
	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode); 
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

	public Date getDepositRequestDate() {
		return entity.getDepositRequestDate();
	}

	public void setDepositRequestDate(Date depositRequestDate) {
		entity.setDepositRequestDate(depositRequestDate); 
	}

	public Double getAgreedInstallmentAmount() {
		return entity.getAgreedInstallmentAmount();
	}

	public void setAgreedInstallmentAmount(Double agreedInstallmentAmount) {
		entity.setAgreedInstallmentAmount(agreedInstallmentAmount); 
	}

	public Integer getProposedInstallmentNumber() {
		return entity.getProposedInstallmentNumber();
	}

	public void setProposedInstallmentNumber(Integer proposedInstallmentNumber) {
		entity.setProposedInstallmentNumber(proposedInstallmentNumber); 
	}

	public Date getExpectedMaturityDate() {
		return entity.getExpectedMaturityDate();
	}

	public void setExpectedMaturityDate(Date expectedMaturityDate) {
		entity.setExpectedMaturityDate(expectedMaturityDate); 
	}

	public Double getProposedInterestRate() {
		return entity.getProposedInterestRate();
	}

	public void setProposedInterestRate(Double proposedInterestRate) {
		entity.setProposedInterestRate(proposedInterestRate); 
	}

	public String getProposedTenureType() {
		return entity.getProposedTenureType();
	}

	public void setProposedTenureType(String proposedTenureType) {
		entity.setProposedTenureType(proposedTenureType); 
	}

	public Integer getProposedTenure() {
		return entity.getProposedTenure();
	}

	public void setProposedTenure(Integer proposedTenure) {
		entity.setProposedTenure(proposedTenure); 
	}

	public String getProposedFrequencyType() {
		return entity.getProposedFrequencyType();
	}

	public void setProposedFrequencyType(String proposedFrequencyType) {
		entity.setProposedFrequencyType(proposedFrequencyType); 
	}

	public Integer getProposedFrequency() {
		return entity.getProposedFrequency();
	}

	public void setProposedFrequency(Integer proposedFrequency) {
		entity.setProposedFrequency(proposedFrequency); 
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
