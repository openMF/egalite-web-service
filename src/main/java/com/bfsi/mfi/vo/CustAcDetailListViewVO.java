package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CustAcDetailListView;

/**
 * @author Jyoti Ranjan
 * 
 */

public class CustAcDetailListViewVO extends MaintenanceVO<CustAcDetailListView>{

	public CustAcDetailListViewVO() {
		entity = new CustAcDetailListView();
	}

	public CustAcDetailListViewVO(CustAcDetailListView entity) {
		super(entity);
	}
	
	public String getCustomerId() {
		return entity.getCustomerId();
	}
	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId); 
	}
	public String getBranchCode() {
		return entity.getBranchCode();
	}
	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode); 
	}
	public String getAccountType() {
		return entity.getAccountType();
	}
	public void setAccountType(String accountType) {
		entity.setAccountType(accountType); 
	}
	public String getAcStatNoDr() {
		return entity.getAcStatNoDr();
	}
	public void setAcStatNoDr(String acStatNoDr) {
		entity.setAcStatNoDr(acStatNoDr); 
	}
	public String getAcStatNoCr() {
		return entity.getAcStatNoCr();
	}
	public void setAcStatNoCr(String acStatNoCr) {
		entity.setAcStatNoCr(acStatNoCr); 
	}
	public String getAgentId() {
		return entity.getAgentId();
	}
	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}
	public String getLocationCode() {
		return entity.getLocationCode();
	}
	public void setLocationCode(String locationCode) {
		entity.setLocationCode(locationCode); 
	}
	public String getCreditOfficerId() {
		return entity.getCreditOfficerId();
	}
	public void setCreditOfficerId(String creditOfficerId) {
		entity.setCreditOfficerId(creditOfficerId); 
	}
	
	public String getAcyCurrBal() {
		return  entity.getAcyCurrBal();
	}
	public void setAcyCurrBal(String acyCurrBal) {
		entity.setAcyCurrBal(acyCurrBal);
	}
	public String getAcyAvailBal() {
		return entity.getAcyAvailBal();
	}
	public void setAcyAvailBal(String acyAvailBal) {
		entity.setAcyAvailBal(acyAvailBal);
	}
	
}
