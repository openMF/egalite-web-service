package com.bfsi.mfi.vo;

import java.util.Date;

import javax.faces.context.FacesContext;

import com.bfsi.mfi.entity.Cash;
import com.bfsi.mfi.util.MessageUtil;

public class CashSettlementVO extends MaintenanceVO<Cash> 
{
	private String cashSettlementText;
	private String cashTxnTypeText;

	public String getCashSettlementText() 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		if(getIsActive() == null)
		{
			return cashSettlementText =null;
		}
		else if (getIsActive().equalsIgnoreCase("A")) {
			cashSettlementText = MessageUtil.getMessage("device.active",context);
			return cashSettlementText;
		} else {
			cashSettlementText = MessageUtil.getMessage("device.inActive",context);
			return cashSettlementText;
		}
	}

	public void setCashSettlementText(String cashSettlementText) {
		this.cashSettlementText = cashSettlementText;
	}

	public CashSettlementVO() {
		entity = new Cash();
	}

	public CashSettlementVO(Cash entity) {
		super(entity);
	}
	
	
	public String getCashTxnTypeText() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(getCashTxnType() != null)
		{
			String txnId = getCashTxnType().trim();
			if (txnId == null) {
				return cashTxnTypeText = null;
			} else if (txnId.equalsIgnoreCase("1")) {
				cashTxnTypeText = MessageUtil.getMessage("cashMgmt.Cash", context);
				return cashTxnTypeText;
			} else if (txnId.equalsIgnoreCase("2")) {
				cashTxnTypeText = MessageUtil.getMessage("cashMgmt.Sink", context);
				return cashTxnTypeText;
			} else {
				cashTxnTypeText = MessageUtil.getMessage("cashMgmt.Adjustment",	context);
		}
		return cashTxnTypeText;
		}
		
		else
		{
			String txnId ="";
			return txnId;
		}
		
	}
	public  String getCashTxnType() {
		return entity.getCashTxnType();

	}

	public void setCashTxnType(String cashTxnType) {
		entity.setCashTxnType(cashTxnType);

	}
	public void setCashTxnTypeText(String cashTxnTypeText) {
		this.cashTxnTypeText = cashTxnTypeText;
	}

	public String getTillId() {
		return entity.getId();
	}

	public void setTillId(String tillId) {
		entity.setId(tillId);
	}
	
	/*public String getTillId() {
		return entity.getTillId();
	}

	public void setTillId(String tillId) {
		entity.setTillId(tillId);
	}*/
	
	public Double getCtgAmount() {
		return entity.getCtgAmount();
	}

	public void setCtgAmount(Double ctgAmount) {
		entity.setCtgAmount(ctgAmount);
	}

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}
	
	public String getTxnCode() {
		return entity.getTxnCode();
	}

	public void setTxnCode(String txnCode) {
		entity.setTxnCode(txnCode);
	}
	
	public String getCurrencyCode() {
		return entity.getCurrencyCode();
	}

	public void setCurrencyCode(String currencyCode) {
		entity.setCurrencyCode(currencyCode);
	}
	
	
	public Double getCashAmount() {
		return entity.getCashAmount();
	}

	public void setCashAmount(Double cashAmount) {
		entity.setCashAmount(cashAmount);
	}
	
	public String getTxnRemarks() {
		return entity.getTxnRemarks();
	}

	public void setTxnRemarks(String txnRemarks) {
		entity.setTxnRemarks(txnRemarks);
	}
	
	public String getIsActive() {
		return entity.getIsActive();
	}

	public void setIsActive(String isActive) {
		entity.setIsActive(isActive);
	}
	
	public String getInitByUserId() {
		return entity.getInitByUserId();
	}

	public void setInitByUserId(String initByUserId) {
		entity.setInitByUserId(initByUserId);
	}
	
	public String getVerifyByUserId() {
		return entity.getVerifyByUserId();
	}

	public void setVerifyByUserId(String verifyByUserId) {
		entity.setVerifyByUserId(verifyByUserId);
	}
	
	public Date getTxnInitDatetime() {
		return entity.getTxnInitDatetime();
	}

	public void setTxnInitDatetime(Date txnInitDatetime) {
		entity.setTxnInitDatetime(txnInitDatetime);
	}
	
	public Date getTxnAuthDatetime() {
		return entity.getTxnAuthDatetime();
	}

	public void setTxnAuthDatetime(Date txnAuthDatetime) {
		entity.setTxnAuthDatetime(txnAuthDatetime);
	}

	
	public Object clone() 
	{
		CashSettlementVO copyObj = new CashSettlementVO();
		copyObj.setTillId(getTillId());
		copyObj.setAgentId(getAgentId());
		copyObj.setCashTxnType(getCashTxnType());
		
		//copyObj.setCashTxnTypeText(getCashTxnTypeText());
		copyObj.setTxnCode(getTxnCode());
		copyObj.setCurrencyCode(getCurrencyCode());
		copyObj.setCashAmount(getCashAmount());
		copyObj.setTxnRemarks(getTxnRemarks());
		copyObj.setIsActive(getIsActive());
		copyObj.setAuthStatus(getAuthStatusText());
		copyObj.setInitByUserId(getInitByUserId());
		copyObj.setVerifyByUserId(getVerifyByUserId());
		copyObj.setTxnInitDatetime(getTxnInitDatetime());
		copyObj.setTxnAuthDatetime(getTxnAuthDatetime());
		return copyObj;
	}
}
