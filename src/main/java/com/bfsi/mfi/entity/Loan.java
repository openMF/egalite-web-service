package com.bfsi.mfi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "mfi_loan_detail")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Loan extends MaintenanceEntity {
	public Loan() {
	}

	private Agent agent = new Agent();
	private List<Agent> agents;
	// private LoanEnrichment loanEnrichment;
	private DisburseSchedule disburseSchedule = new DisburseSchedule();

	@Column(name = "CUSTOMER_ID", nullable = false)
	private String customerId;
	@Column(name = "CUSTOMER_NAME", nullable = false)
	private String customerName;
	@Column(name = "LOCATION_NAME", nullable = false)
	private String locationName;
	@Column(name = "LOCATION_ID", nullable = false)
	private String locationId;
	@Column(name = "NEXT_REPAYMENT_DATE", nullable = false)
	private Date nextRepaymentDate;
	@Column(name = "OVERDUE_STATUS", nullable = false)
	private String overDueStatus;
	@Column(name = "LAST_DISBR_DATE", nullable = false)
	private Date disbursementDate;
	@Column(name = "OVER_DUE_DATE", nullable = false)
	private Date overDueDate;
	@Column(name = "SANCTIONED_DATE", nullable = false)
	private Date sanctionedDate;
	@Column(name = "GROUP_FLAG", nullable = false)
	private String groupFlag;
	@Column(name = "GROUP_NAME", nullable = false)
	private String groupName;
	@Column(name = "LAST_REPAYMENT_DATE", nullable = false)
	private Date lastRepaymentDate;
	@Column(name = "DISBURSEMENT_STATUS", nullable = false)
	private String disbursementStatus;
	@Column(name = "GROUP_ID", nullable = false)
	private String groupId;
	@Column(name = "AGENT_ID", nullable = false)
	private String agentId;
	@Column(name = "SYNC_STATUS", nullable = false)
	private String syncStatus;
	@Column(name = "AMOUNT_DISBURSED", nullable = false)
	private Double amtDisbursed;
	@Column(name = "PRINC_OUTSTAND", nullable = false)
	private Double princOutstand;
	@Column(name = "AMOUNT_SANCTIONED", nullable = false)
	private Double amountSanctioned;
	@Column(name = "LOAN_AC_CCY", nullable = false)
	private String loanAcCcy;
	@Column(name = "CREDIT_OFFICER", nullable = false)
	private String creditOfficer;
	@Column(name = "BRANCH_CODE", nullable = false)
	private String branchCode;

	private List<DisburseSchedule> disbrSchedule;
	private List<RepaymentSchedule> repaymentSchedule;
	private List<RepaymentLiquidation> repaymentliquidation;

	public String getLoanAcCcy() {
		return loanAcCcy;
	}

	public void setLoanAcCcy(String loanAcCcy) {
		this.loanAcCcy = loanAcCcy;
	}

	public Double getAmtDisbursed() {
		return amtDisbursed;
	}

	public void setAmtDisbursed(Double amtDisbursed) {
		this.amtDisbursed = amtDisbursed;
	}

	public Double getPrincOutstand() {
		return princOutstand;
	}

	public void setPrincOutstand(Double princOutstand) {
		this.princOutstand = princOutstand;
	}

	public List<RepaymentSchedule> getRepaymentSchedule() {
		return repaymentSchedule;
	}

	public void setRepaymentSchedule(List<RepaymentSchedule> repaymentSchedule) {
		this.repaymentSchedule = repaymentSchedule;
	}

	public List<DisburseSchedule> getDisbrSchedule() {
		return disbrSchedule;
	}

	public void setDisbrSchedule(List<DisburseSchedule> disbrSchedule) {
		this.disbrSchedule = disbrSchedule;
	}

	public String getLoanAcNo() {
		return super.getId();
	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Date getNextRepaymentDate() {
		return nextRepaymentDate;
	}

	public void setNextRepaymentDate(Date nextRepaymentDate) {
		this.nextRepaymentDate = nextRepaymentDate;
	}

	public String getOverDueStatus() {
		return overDueStatus;
	}

	public void setOverDueStatus(String overDueStatus) {
		this.overDueStatus = overDueStatus;
	}

	public Date getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public Date getOverDueDate() {
		return overDueDate;
	}

	public void setOverDueDate(Date overDueDate) {
		this.overDueDate = overDueDate;
	}

	public Date getSanctionedDate() {
		return sanctionedDate;
	}

	public void setSanctionedDate(Date sanctionedDate) {
		this.sanctionedDate = sanctionedDate;
	}

	public String getGroupFlag() {
		return groupFlag;
	}

	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getLastRepaymentDate() {
		return lastRepaymentDate;
	}

	public void setLastRepaymentDate(Date lastRepaymentDate) {
		this.lastRepaymentDate = lastRepaymentDate;
	}

	public String getDisbursementStatus() {
		return disbursementStatus;
	}

	public void setDisbursementStatus(String disbursementStatus) {
		this.disbursementStatus = disbursementStatus;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	/*
	 * public LoanEnrichment getLoanEnrichment() { return loanEnrichment; }
	 * 
	 * public void setLoanEnrichment(LoanEnrichment loanEnrichment) {
	 * this.loanEnrichment = loanEnrichment; }
	 */

	public DisburseSchedule getDisburseSchedule() {
		return disburseSchedule;
	}

	public void setDisburseSchedule(DisburseSchedule disburseSchedule) {
		this.disburseSchedule = disburseSchedule;
	}

	public List<RepaymentLiquidation> getRepaymentliquidation() {
		return repaymentliquidation;
	}

	public void setRepaymentliquidation(
			List<RepaymentLiquidation> repaymentliquidation) {
		this.repaymentliquidation = repaymentliquidation;
	}

	public Double getAmountSanctioned() {
		return amountSanctioned;
	}

	public void setAmountSanctioned(Double amountSanctioned) {
		this.amountSanctioned = amountSanctioned;
	}

	public String getCreditOfficer() {
		return creditOfficer;
	}

	public void setCreditOfficer(String creditOfficer) {
		this.creditOfficer = creditOfficer;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

}
