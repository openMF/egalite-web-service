package com.bfsi.mfi.vo;


import java.util.Date;

import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;

public class MfiMbsTxnReceiverVO  extends MaintenanceVO<MfiMbsTxnReceiverV>{
	
	public MfiMbsTxnReceiverVO() {
		entity = new MfiMbsTxnReceiverV();
	}
	
	public MfiMbsTxnReceiverVO(MfiMbsTxnReceiverV entity) {
		super(entity);
	}
	/*public String getMbsTxnId() {
		return entity.getMbsTxnId();
	}

	public void setMbsTxnId(String mbsTxnId) {
		entity.setMbsTxnId(mbsTxnId);
	}*/

	public String getTxnCode()
	{
	 return entity.getTxnCode();
	}
	public void setTxnCode(String txnCode)
	{
		entity.setTxnCode(txnCode);
		
	}

	public String getTxnDesc() {
		return entity.getTxnDesc();
	}

	public void setTxnDesc(String txnDesc) {
		entity.setTxnDesc(txnDesc);
	
	}

	public String getAgendaId() {
		return entity.getAgendaId();
	}

	public void setAgendaId(String agendaId) {
		entity.setAgendaId(agendaId);
		
	}

	public long getSeqNo() {
		return entity.getSeqNo();
	}

	public void setSeqNo(long seqNo) {
		entity.setSeqNo(seqNo);
		
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

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
		
	}

	public String getCbsAcRefNo() {
		return entity.getCbsAcRefNo();
	}

	public void setCbsAcRefNo(String cbsAcRefNo) {
		entity.setCbsAcRefNo(cbsAcRefNo);
		
	}
	
	public String getDeviceId() {
		return entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		entity.setDeviceId(deviceId);
		
	}

	public String getLocationCode() {
		return entity.getLocationCode();
	}

	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode);
		
	}

	public Date getTxnInitTime() {
		return entity.getTxnInitTime();
	}

	public void setTxnInitTime(Date txnInitTime) {
		entity.setTxnInitTime(txnInitTime);
		
	}

	public String getTxnStatusDesc() {
		return entity.getTxnStatusDesc();
	}

	public void setTxnStatusDesc(String txnStatusDesc) {
		entity.setTxnStatusDesc(txnStatusDesc);
		
		
	}
	
	public String getParentLoanAcNo() {
		return entity.getParentLoanAcNo();
	}

	public void setParentLoanAcNo(String parentLoanAcNo) {
		entity.setParentLoanAcNo(parentLoanAcNo);
	}
	
	public String getLoanAcNo()  {
		return entity.getLoanAcNo() ;
	}

	public void setLoanAcNo(String loanAcNo) {
		entity.setLoanAcNo(loanAcNo);
	}
	public String getParentCustId()  {
		return entity.getParentCustId() ;
	}

	public void setParentCustId(String parentCustId) {
		entity.setParentCustId(parentCustId);
	}
	
	public String getIsGroupLoan()  {
		return entity.getIsGroupLoan() ;
	}

	public void setIsGroupLoan(String isGroupLoan) {
		entity.setIsGroupLoan(isGroupLoan);
	}
	
	public String getIsParentLoan()  {
		return entity.getIsParentLoan() ;
	}

	public void setIsParentLoan(String isParentLoan) {
		entity.setIsParentLoan(isParentLoan);
	}
}
