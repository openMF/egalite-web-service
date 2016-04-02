

package com.bfsi.mfi.vo;

/**
 * @author Jyoti Ranjan
 *
 */

import com.bfsi.mfi.entity.LoanDetailsListView;

public class LoanDetailsListViewVO extends MaintenanceVO<LoanDetailsListView>{

	public LoanDetailsListViewVO() {
		entity = new LoanDetailsListView();
	}
	
	public LoanDetailsListViewVO(LoanDetailsListView entity) {
		super(entity);
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
	
	public String getCreditOfficerCode() {
		return entity.getCreditOfficerCode();
	}
	public void setCreditOfficerCode(String creditOfficerCode) {
		entity.setCreditOfficerCode(creditOfficerCode); 
	}
	public String getAllocationStatus() {
		return entity.getAllocationStatus();
	}
	public void setAllocationStatus(String allocationStatus) {
		entity.setAllocationStatus(allocationStatus); 
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
	
	public String getCurrency() {
		return entity.getCurrency();
	}
	public void setCurrency(String currency) {
		entity.setCurrency(currency); 
	}
	public Double getPrincipalAmount() {
		return entity.getPrincipalAmount();
	}
	public void setPrincipalAmount(Double principalAmount) {
		entity.setPrincipalAmount(principalAmount); 
	}
	public Double getPrincipalPaid() {
		return entity.getPrincipalPaid();
	}
	public void setPrincipalPaid(Double principalPaid) {
		entity.setPrincipalPaid(principalPaid); 

	}
	public Double getPrincipalOutstanding() {
		return entity.getPrincipalOutstanding();
	}
	public void setPrincipalOutstanding(Double principalOutstanding) {
		entity.setPrincipalOutstanding(principalOutstanding); 
	}
	
	
	public String getParentLoanAcNo() {
		return entity.getParentLoanAcNo();
	}
	public void setParentLoanAcNo(String parentLoanAcNo) {
		entity.setParentLoanAcNo(parentLoanAcNo); 
	}
	public String getParentCustId() {
		return entity.getParentCustId();
	}
	public void setParentCustId(String parentCustId) {
		entity.setParentCustId(parentCustId);
	}
	public String getIsParentLoan() {
		return entity.getIsParentLoan();
	}
	public void setIsParentLoan(String isParentLoan) {
		entity.setIsParentLoan(isParentLoan);
	}
	public String getIsGroupLoan() {
		return entity.getIsGroupLoan();
	}
	public void setIsGroupLoan(String isGroupLoan) {
		entity.setIsGroupLoan(isGroupLoan); 
	}
	
}
