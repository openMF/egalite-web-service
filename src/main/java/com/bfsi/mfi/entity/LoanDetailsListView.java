package com.bfsi.mfi.entity;
/**
 * @author Jyoti Ranjan
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_loan_detail_list_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanDetailsListView extends MaintenanceEntity {
	
	public LoanDetailsListView() {
	}
	
	/*loan_ac_no,//super class
	branch_code,customer_id,
	parent_loan_ac_no,parent_cust_id,is_parent_loan,is_group_loan, //new
	credit_officer_code,
	allocation_status,agent_id,location_code,Currency,principal_amount,principal_paid,principal_outstanding*/
	
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	@Column(name = "customer_id", nullable = false)
	private String customerId;
	@Column(name = "Currency", nullable = false)
	private String currency;
	
	@Column(name = "parent_loan_ac_no", nullable = false)
	private String parentLoanAcNo;
	@Column(name = "parent_cust_id", nullable = false)
	private String parentCustId;
	@Column(name = "is_parent_loan", nullable = false)
	private String isParentLoan;
	@Column(name = "is_group_loan", nullable = false)
	private String isGroupLoan;
	
	@Column(name = "credit_officer_code", nullable = false)
	private String creditOfficerCode;
	@Column(name = "allocation_status", nullable = false)
	private String allocationStatus;
	@Column(name = "agent_id", nullable = false)
	private String agentId;
	@Column(name = "location_code", nullable = false)
	private String locationCode;
	
	@Column(name = "principal_amount", nullable = false)
	private Double principalAmount;
	@Column(name = "principal_paid", nullable = false)
	private Double principalPaid;
	@Column(name = "principal_outstanding", nullable = false)
	private Double principalOutstanding;
	
	/*@Column(name = "customer_full_name", nullable = false)
	private String customerFullName;*/
	
	
	/*@Column(name = "allocation_by_code", nullable = false)
	private String allocationByCode;
	@Column(name = "loan_status", nullable = false)
	private String loanStatus;
	@Column(name = "record_stat", nullable = false)
	private String recordStat;
	@Column(name = "cbs_upld_job_id", nullable = false)
	private String cbsUpldJobId;
	@Column(name = "sync_time", nullable = false)
	private String syncTime;*/
	
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
	/*public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}*/
	public String getCreditOfficerCode() {
		return creditOfficerCode;
	}
	public void setCreditOfficerCode(String creditOfficerCode) {
		this.creditOfficerCode = creditOfficerCode;
	}
	public String getAllocationStatus() {
		return allocationStatus;
	}
	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	/*public String getAllocationByCode() {
		return allocationByCode;
	}
	public void setAllocationByCode(String allocationByCode) {
		this.allocationByCode = allocationByCode;
	}*/
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(Double principalAmount) {
		this.principalAmount = principalAmount;
	}
	public Double getPrincipalPaid() {
		return principalPaid;
	}
	public void setPrincipalPaid(Double principalPaid) {
		this.principalPaid = principalPaid;
	}
	public Double getPrincipalOutstanding() {
		return principalOutstanding;
	}
	public void setPrincipalOutstanding(Double principalOutstanding) {
		this.principalOutstanding = principalOutstanding;
	}
	/*public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getRecordStat() {
		return recordStat;
	}
	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}
	public String getCbsUpldJobId() {
		return cbsUpldJobId;
	}
	public void setCbsUpldJobId(String cbsUpldJobId) {
		this.cbsUpldJobId = cbsUpldJobId;
	}
	public String getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}*/
	public String getParentLoanAcNo() {
		return parentLoanAcNo;
	}
	public void setParentLoanAcNo(String parentLoanAcNo) {
		this.parentLoanAcNo = parentLoanAcNo;
	}
	public String getParentCustId() {
		return parentCustId;
	}
	public void setParentCustId(String parentCustId) {
		this.parentCustId = parentCustId;
	}
	public String getIsParentLoan() {
		return isParentLoan;
	}
	public void setIsParentLoan(String isParentLoan) {
		this.isParentLoan = isParentLoan;
	}
	public String getIsGroupLoan() {
		return isGroupLoan;
	}
	public void setIsGroupLoan(String isGroupLoan) {
		this.isGroupLoan = isGroupLoan;
	}
	
	
}
