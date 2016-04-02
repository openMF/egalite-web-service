package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "MFI_AGENDA_MASTER")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AgendaView extends MaintenanceEntity {
	
	public AgendaView(){
		
	}
	public String agendaId;
	public int seqNo;
	public String cbdAccRefNo;
	public String moduleCode;
	public String txnCode;
	public String agentId;
	public String locCode;
	public String agendaStatus;
	public Date agendaUploadTime;
	public String branchCode;
	public String customerId;
	public String customerName;
	public String agendaCcyCode;
	public String agendaLocCcyCode;
	public String agendaCmpName;
	public Date agendaCmpStartDate;
	public Date agendaCmpEndDate;
	public Date agendaMbsDate;
	public Double agendaAmount;
	public Double agendaAmountCcy;
	public Double agendaSettledAmount;
	public Double agendaSettledAmountCcy;
	public String isFull;
	public String loanDisbType;
	public String isLoanFutureSch;
	public String isLoanRedemption;
	public String deviceId;
	public String mbsSyncUploadTime;
	public String mbsTxnId;
	public String cbsUploadJobId;
	public String isValid;
	public String smsMMobile;
	public String isGroupLoan;		
	public String isParentLoan;
	public String isParentCust;
	public String parentCustId;
	public String parentCbsAcRefNo;
	public String txnDesc;
	public Date mbsSyncUpldTime;
	public String smsMobileNo;
	
	public Date getMbsSyncUpldTime() {
		return mbsSyncUpldTime;
	}
	public void setMbsSyncUpldTime(Date mbsSyncUpldTime) {
		this.mbsSyncUpldTime = mbsSyncUpldTime;
	}
	public String getSmsMobileNo() {
		return smsMobileNo;
	}
	public void setSmsMobileNo(String smsMobileNo) {
		this.smsMobileNo = smsMobileNo;
	}
	public String getAgendaId() {
		return super.getId();
	}
	public void setAgendaId(String agendaId) {
		super.setId(agendaId);
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getCbdAccRefNo() {
		return cbdAccRefNo;
	}
	public void setCbdAccRefNo(String cbdAccRefNo) {
		this.cbdAccRefNo = cbdAccRefNo;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getTxnCode() {
		return txnCode;
	}
	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	public String getAgendaStatus() {
		return agendaStatus;
	}
	public void setAgendaStatus(String agendaStatus) {
		this.agendaStatus = agendaStatus;
	}
	public Date getAgendaUploadTime() {
		return agendaUploadTime;
	}
	public void setAgendaUploadTime(Date agendaUploadTime) {
		this.agendaUploadTime = agendaUploadTime;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAgendaCcyCode() {
		return agendaCcyCode;
	}
	public void setAgendaCcyCode(String agendaCcyCode) {
		this.agendaCcyCode = agendaCcyCode;
	}
	public String getAgendaLocCcyCode() {
		return agendaLocCcyCode;
	}
	public void setAgendaLocCcyCode(String agendaLocCcyCode) {
		this.agendaLocCcyCode = agendaLocCcyCode;
	}
	public String getAgendaCmpName() {
		return agendaCmpName;
	}
	public void setAgendaCmpName(String agendaCmpName) {
		this.agendaCmpName = agendaCmpName;
	}
	public Date getAgendaCmpStartDate() {
		return agendaCmpStartDate;
	}
	public void setAgendaCmpStartDate(Date agendaCmpStartDate) {
		this.agendaCmpStartDate = agendaCmpStartDate;
	}
	public Date getAgendaCmpEndDate() {
		return agendaCmpEndDate;
	}
	public void setAgendaCmpEndDate(Date agendaCmpEndDate) {
		this.agendaCmpEndDate = agendaCmpEndDate;
	}
	public Date getAgendaMbsDate() {
		return agendaMbsDate;
	}
	public void setAgendaMbsDate(Date agendaMbsDate) {
		this.agendaMbsDate = agendaMbsDate;
	}
	public Double getAgendaAmount() {
		return agendaAmount;
	}
	public void setAgendaAmount(Double agendaAmount) {
		this.agendaAmount = agendaAmount;
	}
	public Double getAgendaAmountCcy() {
		return agendaAmountCcy;
	}
	public void setAgendaAmountCcy(Double agendaAmountCcy) {
		this.agendaAmountCcy = agendaAmountCcy;
	}
	public Double getAgendaSettledAmount() {
		return agendaSettledAmount;
	}
	public void setAgendaSettledAmount(Double agendaSettledAmount) {
		this.agendaSettledAmount = agendaSettledAmount;
	}
	public Double getAgendaSettledAmountCcy() {
		return agendaSettledAmountCcy;
	}
	public void setAgendaSettledAmountCcy(Double agendaSettledAmountCcy) {
		this.agendaSettledAmountCcy = agendaSettledAmountCcy;
	}
	public String getIsFull() {
		return isFull;
	}
	public void setIsFull(String isFull) {
		this.isFull = isFull;
	}
	public String getLoanDisbType() {
		return loanDisbType;
	}
	public void setLoanDisbType(String loanDisbType) {
		this.loanDisbType = loanDisbType;
	}
	public String getIsLoanFutureSch() {
		return isLoanFutureSch;
	}
	public void setIsLoanFutureSch(String isLoanFutureSch) {
		this.isLoanFutureSch = isLoanFutureSch;
	}
	public String getIsLoanRedemption() {
		return isLoanRedemption;
	}
	public void setIsLoanRedemption(String isLoanRedemption) {
		this.isLoanRedemption = isLoanRedemption;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getMbsSyncUploadTime() {
		return mbsSyncUploadTime;
	}
	public void setMbsSyncUploadTime(String mbsSyncUploadTime) {
		this.mbsSyncUploadTime = mbsSyncUploadTime;
	}
	public String getMbsTxnId() {
		return mbsTxnId;
	}
	public void setMbsTxnId(String mbsTxnId) {
		this.mbsTxnId = mbsTxnId;
	}
	public String getCbsUploadJobId() {
		return cbsUploadJobId;
	}
	public void setCbsUploadJobId(String cbsUploadJobId) {
		this.cbsUploadJobId = cbsUploadJobId;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getSmsMMobile() {
		return smsMMobile;
	}
	public void setSmsMMobile(String smsMMobile) {
		this.smsMMobile = smsMMobile;
	}
	public String getIsGroupLoan() {
		return isGroupLoan;
	}
	public void setIsGroupLoan(String isGroupLoan) {
		this.isGroupLoan = isGroupLoan;
	}
	public String getIsParentLoan() {
		return isParentLoan;
	}
	public void setIsParentLoan(String isParentLoan) {
		this.isParentLoan = isParentLoan;
	}
	public String getIsParentCust() {
		return isParentCust;
	}
	public void setIsParentCust(String isParentCust) {
		this.isParentCust = isParentCust;
	}
	public String getParentCustId() {
		return parentCustId;
	}
	public void setParentCustId(String parentCustId) {
		this.parentCustId = parentCustId;
	}
	public String getParentCbsAcRefNo() {
		return parentCbsAcRefNo;
	}
	public void setParentCbsAcRefNo(String parentCbsAcRefNo) {
		this.parentCbsAcRefNo = parentCbsAcRefNo;
	}
	public String getTxnDesc() {
		return txnDesc;
	}
	public void setTxnDesc(String txnDesc) {
		this.txnDesc = txnDesc;
	}
	
	
}
