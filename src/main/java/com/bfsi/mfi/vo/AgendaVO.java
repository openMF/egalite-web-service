package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.Agenda;

public class AgendaVO extends MaintenanceVO<Agenda> {
	public AgendaVO() {
		entity = new Agenda();
	}

	public AgendaVO(Agenda entity) {
		super(entity);
	}	
	
	public String getSmsMobileNo() {
		return this.entity.getSmsMobileNo();
	}
	public void setSmsMobileNo(String smsMobileNo) {
		entity.smsMobileNo = smsMobileNo;
	}
	
	public Date getMbsSyncUpldTime() {
		return this.entity. getMbsSyncUpldTime();
	}
	public void setMbsSyncUpldTime(Date mbsSyncUpldTime) {
		entity.mbsSyncUpldTime = mbsSyncUpldTime;
	}
	
	public String getAgendaId() {
		return this.entity.getAgendaId();
	}

	public void setAgendaId(String agendaId) {
		entity.agendaId = agendaId;
	}

	public int getSeqNo() {
		return this.entity.getSeqNo();
	}

	public void setSeqNo(int seqNo) {
		entity.seqNo = seqNo;
	}

	public String getCbdAccRefNo() {
		return this.entity.getCbdAccRefNo();
	}

	public void setCbdAccRefNo(String cbdAccRefNo) {
		entity.cbdAccRefNo = cbdAccRefNo;
	}

	public String getModuleCode() {
		return this.entity.getModuleCode();
	}

	public void setModuleCode(String moduleCode) {
		entity.moduleCode = moduleCode;
	}

	public String getTxnCode() {
		return this.entity.getTxnCode();
	}

	public void setTxnCode(String txnCode) {
		entity.txnCode = txnCode;
	}

	public String getAgentId() {
		return this.entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.agentId = agentId;
	}

	public String getLocCode() {
		return this.entity.getLocCode();
	}

	public void setLocCode(String locCode) {
		entity.locCode = locCode;
	}

	public int getAgendaStatus() {
		return this.entity.getAgendaStatus();
	}

	public void setAgendaStatus(int agendaStatus) {
		entity.agendaStatus = agendaStatus;
	}

	public Date getAgendaUploadTime() {
		return this.entity.getAgendaUploadTime();
	}

	public void setAgendaUploadTime(Date agendaUploadTime) {
		entity.agendaUploadTime = agendaUploadTime;
	}

	public String getBranchCode() {
		return this.entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.branchCode = branchCode;
	}

	public String getCustomerId() {
		return this.entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		entity.customerId = customerId;
	}

	public String getCustomerName() {
		return this.entity.getCustomerName();
	}

	public void setCustomerName(String customerName) {
		entity.customerName = customerName;
	}

	public String getAgendaCcyCode() {
		return this.entity.getAgendaCcyCode();
	}

	public void setAgendaCcyCode(String agendaCcyCode) {
		entity.agendaCcyCode = agendaCcyCode;
	}

	public String getAgendaLocCcyCode() {
		return this.entity.getAgendaLocCcyCode();
	}

	public void setAgendaLocCcyCode(String agendaLocCcyCode) {
		entity.agendaLocCcyCode = agendaLocCcyCode;
	}

	public String getAgendaCmpName() {
		return this.entity.getAgendaCmpName();
	}

	public void setAgendaCmpName(String agendaCmpName) {
		entity.agendaCmpName = agendaCmpName;
	}

	public Date getAgendaCmpStartDate() {
		return this.entity.getAgendaCmpStartDate();
	}

	public void setAgendaCmpStartDate(Date agendaCmpStartDate) {
		entity.agendaCmpStartDate = agendaCmpStartDate;
	}

	public Date getAgendaCmpEndDate() {
		return this.entity.getAgendaCmpEndDate();
	}

	public void setAgendaCmpEndDate(Date agendaCmpEndDate) {
		entity.agendaCmpEndDate = agendaCmpEndDate;
	}

	public Date getAgendaMbsDate() {
		return this.entity.getAgendaMbsDate();
	}

	public void setAgendaMbsDate(Date agendaMbsDate) {
		entity.agendaMbsDate = agendaMbsDate;
	}

	public Double getAgendaAmount() {
		return this.entity.getAgendaAmount();
	}

	public void setAgendaAmount(Double agendaAmount) {
		entity.agendaAmount = agendaAmount;
	}

	public Double getAgendaAmountCcy() {
		return this.entity.getAgendaAmountCcy();
	}

	public void setAgendaAmountCcy(Double agendaAmountCcy) {
		entity.agendaAmountCcy = agendaAmountCcy;
	}

	public Double getAgendaSettledAmount() {
		return this.entity.getAgendaSettledAmount();
	}

	public void setAgendaSettledAmount(Double agendaSettledAmount) {
		entity.agendaSettledAmount = agendaSettledAmount;
	}

	public Double getAgendaSettledAmountCcy() {
		return this.entity.getAgendaSettledAmountCcy();
	}

	public void setAgendaSettledAmountCcy(Double agendaSettledAmountCcy) {
		entity.agendaSettledAmountCcy = agendaSettledAmountCcy;
	}

	public String getIsFull() {
		return this.entity.getIsFull();
	}

	public void setIsFull(String isFull) {
		entity.isFull = isFull;
	}

	public String getLoanDisbType() {
		return this.entity.getLoanDisbType();
	}

	public void setLoanDisbType(String loanDisbType) {
		entity.loanDisbType = loanDisbType;
	}

	public String getIsLoanFutureSch() {
		return this.entity.getIsLoanFutureSch();
	}

	public void setIsLoanFutureSch(String isLoanFutureSch) {
		entity.isLoanFutureSch = isLoanFutureSch;
	}

	public String getIsLoanRedemption() {
		return this.entity.getIsLoanRedemption();
	}

	public void setIsLoanRedemption(String isLoanRedemption) {
		entity.isLoanRedemption = isLoanRedemption;
	}

	public String getDeviceId() {
		return this.entity.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		entity.deviceId = deviceId;
	}

	public String getMbsSyncUploadTime() {
		return this.entity.getMbsSyncUploadTime();
	}

	public void setMbsSyncUploadTime(String mbsSyncUploadTime) {
		entity.mbsSyncUploadTime = mbsSyncUploadTime;
	}

	public String getMbsTxnId() {
		return this.entity.getMbsTxnId();
	}

	public void setMbsTxnId(String mbsTxnId) {
		entity.mbsTxnId = mbsTxnId;
	}

	public String getCbsUploadJobId() {
		return this.entity.getCbsUploadJobId();
	}

	public void setCbsUploadJobId(String cbsUploadJobId) {
		entity.cbsUploadJobId = cbsUploadJobId;
	}

	public String getIsValid() {
		return this.entity.getIsValid();
	}

	public void setIsValid(String isValid) {
		entity.isValid = isValid;
	}

	public String getSmsMMobile() {
		return this.entity.getSmsMMobile();
	}

	public void setSmsMMobile(String smsMMobile) {
		entity.smsMMobile = smsMMobile;
	}

	public String getIsGroupLoan() {
		return this.entity.getIsGroupLoan();
	}

	public void setIsGroupLoan(String isGroupLoan) {
		entity.isGroupLoan = isGroupLoan;
	}

	public String getIsParentLoan() {
		return this.entity.getIsParentLoan();
	}

	public void setIsParentLoan(String isParentLoan) {
		entity.isParentLoan = isParentLoan;
	}

	public String getIsParentCust() {
		return this.entity.getIsParentCust();
	}

	public void setIsParentCust(String isParentCust) {
		entity.isParentCust = isParentCust;
	}

	public String getParentCustId() {
		return this.entity.getParentCustId();
	}

	public void setParentCustId(String parentCustId) {
		entity.parentCustId = parentCustId;
	}

	public String getParentCbsAcRefNo() {
		return this.entity.getParentCbsAcRefNo();
	}

	public void setParentCbsAcRefNo(String parentCbsAcRefNo) {
		entity.parentCbsAcRefNo = parentCbsAcRefNo;
	}
	
	public String getTxnDesc() {
		return this.entity.getTxnDesc();
	}
	public void setTxnDesc(String txnDesc) {
		entity.txnDesc = txnDesc;
	}
		
}
