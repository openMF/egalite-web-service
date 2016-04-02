package com.bfsi.mfi.entity;

/**
 * @author Jyoti Ranjan
 *
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_loan_detail_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanDetailView extends MaintenanceEntity {
	
	public LoanDetailView() {
	}
	
	/*loan_ac_no,//SUPER
	branch_code,customer_id,customer_full_name,
	parent_loan_ac_no,parent_cust_id,
	-- not to be shown on the screen
	 is_parent_loan,is_group_loan,
	-- not to be shown on the screen
	 Loan_type,Group_type,
	credit_officer_code,Credit_officer_name,agent_id,agent_name,location_code,location_desc,allocation_by_code ,allocation_by_name,
	 allocation_status,group_id,sanctioned_date,last_disbursed_date,disbr_type,loan_ac_ccy,is_fully_disbursed,interest_rate,
	interest_accured, principal_amount,principal_paid, principal_outstanding,loan_status,last_repayment_date,record_stat,cbs_upld_job_id*/
	
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	@Column(name = "customer_id", nullable = false)
	private String customerId;
	@Column(name = "customer_full_name", nullable = false)
	private String customerFullName;
	
	@Column(name = "parent_loan_ac_no", nullable = false)
	private String parentLoanAcNo;
	@Column(name = "parent_cust_id", nullable = false)
	private String parentCustId;
	@Column(name = "is_parent_loan", nullable = false)
	private String isParentLoan;
	@Column(name = "is_group_loan", nullable = false)
	private String isGroupLoan;
	@Column(name = "Loan_type", nullable = false)
	private String loanType;
	@Column(name = "Group_type", nullable = false)
	private String groupType;
	
	@Column(name = "credit_officer_code", nullable = false)
	private String creditOfficerCode;
	@Column(name = "Credit_officer_name", nullable = false)
	private String creditOfficerName;
	@Column(name = "agent_id", nullable = false)
	private String agentId;
	@Column(name = "agent_name", nullable = false)
	private String agentName;
	@Column(name = "location_code", nullable = false)
	private String locationCode;
	@Column(name = "location_desc", nullable = false)
	private String locationDesc;
	@Column(name = "allocation_by_code", nullable = false)
	private String allocationByCode;
	@Column(name = "allocation_by_name", nullable = false)
	private String allocationByName;
	@Column(name = "group_id", nullable = false)
	private String groupId;
	@Column(name = "group_code", nullable = false)
	private String groupCode;
	
	@Column(name = "sanctioned_date", nullable = false)
	private Date sanctionedDate;
	@Column(name = "last_disbursed_date", nullable = false)
	private Date lastDisbursedDate;
	
	@Column(name = "disbr_type", nullable = false)
	private String disbrType;
	@Column(name = "loan_ac_ccy", nullable = false)
	private String loanAcCcy;
	@Column(name = "is_fully_disbursed", nullable = false)
	private String isFullyDisbursed;
	
	@Column(name = "interest_rate", nullable = false)
	private Double interestRate;
	@Column(name = "interest_accrued", nullable = false)
	private Double interestAccured;
	@Column(name = "principal_amount", nullable = false)
	private Double principalAmount;
	@Column(name = "principal_paid", nullable = false)
	private Double principalPaid;
	@Column(name = "principal_outstanding", nullable = false)
	private Double principalOutstanding;
	
	
	@Column(name = "loan_status", nullable = false)
	private String loanStatus;
	
	@Column(name = "last_repayment_date", nullable = false)
	private Date lastRepaymentDate;
	
	@Column(name = "record_stat", nullable = false)
	private String recordStat;
	@Column(name = "cbs_upld_job_id", nullable = false)
	private String cbsUpldJobId;
	@Column(name = "sync_status", nullable = false)
	private String syncStatus;
	@Column(name = "sync_time", nullable = false)
	private String syncTime;
	@Column(name = "allocation_status", nullable = false)
	private String allocationStatus;
	
	
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
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public String getCreditOfficerCode() {
		return creditOfficerCode;
	}
	public void setCreditOfficerCode(String creditOfficerCode) {
		this.creditOfficerCode = creditOfficerCode;
	}
	public String getCreditOfficerName() {
		return creditOfficerName;
	}
	public void setCreditOfficerName(String creditOfficerName) {
		this.creditOfficerName = creditOfficerName;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getLocationDesc() {
		return locationDesc;
	}
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}
	public String getAllocationByCode() {
		return allocationByCode;
	}
	public void setAllocationByCode(String allocationByCode) {
		this.allocationByCode = allocationByCode;
	}
	public String getAllocationByName() {
		return allocationByName;
	}
	public void setAllocationByName(String allocationByName) {
		this.allocationByName = allocationByName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public Date getSanctionedDate() {
		return sanctionedDate;
	}
	public void setSanctionedDate(Date sanctionedDate) {
		this.sanctionedDate = sanctionedDate;
	}
	public Date getLastDisbursedDate() {
		return lastDisbursedDate;
	}
	public void setLastDisbursedDate(Date lastDisbursedDate) {
		this.lastDisbursedDate = lastDisbursedDate;
	}
	public String getDisbrType() {
		return disbrType;
	}
	public void setDisbrType(String disbrType) {
		this.disbrType = disbrType;
	}
	public String getLoanAcCcy() {
		return loanAcCcy;
	}
	public void setLoanAcCcy(String loanAcCcy) {
		this.loanAcCcy = loanAcCcy;
	}
	public String getIsFullyDisbursed() {
		return isFullyDisbursed;
	}
	public void setIsFullyDisbursed(String isFullyDisbursed) {
		this.isFullyDisbursed = isFullyDisbursed;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Double getInterestAccured() {
		return interestAccured;
	}
	public void setInterestAccured(Double interestAccured) {
		this.interestAccured = interestAccured;
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
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public Date getLastRepaymentDate() {
		return lastRepaymentDate;
	}
	public void setLastRepaymentDate(Date lastRepaymentDate) {
		this.lastRepaymentDate = lastRepaymentDate;
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
	public String getSyncStatus() {
		return syncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}
	public String getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}
	public String getAllocationStatus() {
		return allocationStatus;
	}
	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}
	
	
	
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
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	
	
	
	
	
}
