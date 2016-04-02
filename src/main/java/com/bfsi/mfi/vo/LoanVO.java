package com.bfsi.mfi.vo;

/**
 * @author bablu
 *
 */
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.DisburseSchedule;
import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.entity.RepaymentLiquidation;
import com.bfsi.mfi.entity.RepaymentSchedule;

public class LoanVO extends MaintenanceVO<Loan> {

	/*
	 * private List<DisburseSchedule> disbrSchedule; private
	 * List<RepaymentSchedule> repaymentSchedule; private
	 * List<RepaymentLiquidation> repaymentliquidation;
	 */

	public String getLoanAcCcy() {
		return entity.getLoanAcCcy();
	}

	public void setLoanAcCcy(String loanAcCcy) {
		entity.setLoanAcCcy(loanAcCcy);
	}

	public LoanVO() {
		entity = new Loan();
	}

	public LoanVO(Loan entity) {
		super(entity);
	}

	private String lastDisDate;

	public Double getAmtDisbursed() {
		return entity.getAmtDisbursed();
	}

	public void setAmtDisbursed(Double amtDisbursed) {
		entity.setAmtDisbursed(amtDisbursed);
	}

	public Double getPrincOutstand() {
		return entity.getPrincOutstand();
	}

	public void setPrincOutstand(Double princOutstand) {
		entity.setPrincOutstand(princOutstand);
	}

	public List<RepaymentLiquidation> getRepaymentliquidation() {
		return entity.getRepaymentliquidation();
	}

	public void setRepaymentliquidation(
			List<RepaymentLiquidation> repaymentliquidation) {
		entity.setRepaymentliquidation(repaymentliquidation);
	}

	public List<RepaymentSchedule> getRepaymentSchedule() {
		return entity.getRepaymentSchedule();
	}

	public void setRepaymentSchedule(List<RepaymentSchedule> repaymentSchedule) {
		entity.setRepaymentSchedule(repaymentSchedule);
	}

	public List<DisburseSchedule> getDisbrSchedule() {
		return entity.getDisbrSchedule();
	}

	public void setDisbrSchedule(List<DisburseSchedule> disbrSchedule) {
		entity.setDisbrSchedule(disbrSchedule);
	}

	public String getLoanAcNo() {
		return super.getId();

	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
	}

	public String getCustomerId() {
		return entity.getCustomerId();
	}

	public void setCustomerId(String customerId) {
		entity.setCustomerId(customerId);
	}

	public String getCustomerName() {
		return entity.getCustomerName();
	}

	public void setCustomerName(String customerName) {
		entity.setCustomerName(customerName);
	}

	public String getLocationName() {
		return entity.getLocationName();
	}

	public void setLocationName(String locationName) {
		entity.setLocationName(locationName);
	}

	public Date getNextRepaymentDate() {
		return entity.getNextRepaymentDate();
	}

	public void setNextRepaymentDate(Date nextRepaymentDate) {
		entity.setNextRepaymentDate(nextRepaymentDate);
	}

	public String getOverDueStatus() {
		return entity.getOverDueStatus();
	}

	public void setOverDueStatus(String overDueStatus) {
		entity.setOverDueStatus(overDueStatus);
	}

	public Date getDisbursementDate() {
		return entity.getDisbursementDate();
	}

	public void setDisbursementDate(Date disbursementDate) {
		entity.setDisbursementDate(disbursementDate);
	}

	public Date getOverDueDate() {
		return entity.getOverDueDate();
	}

	public void setOverDueDate(Date overDueDate) {
		entity.setOverDueDate(overDueDate);
	}

	public Date getSanctionedDate() {
		return entity.getSanctionedDate();
	}

	public void setSanctionedDate(Date sanctionedDate) {
		entity.setSanctionedDate(sanctionedDate);
	}

	public String getGroupFlag() {
		return entity.getGroupFlag();
	}

	public void setGroupFlag(String groupFlag) {
		entity.setGroupFlag(groupFlag);
	}

	public String getGroupName() {
		return entity.getGroupName();
	}

	public void setGroupName(String groupName) {
		entity.setGroupName(groupName);
	}

	public Date getLastRepaymentDate() {
		return entity.getLastRepaymentDate();
	}

	public void setLastRepaymentDate(Date lastRepaymentDate) {
		entity.setLastRepaymentDate(lastRepaymentDate);
	}

	public String getDisbursementStatus() {
		return entity.getDisbursementStatus();
	}

	public void setDisbursementStatus(String disbursementStatus) {
		entity.setDisbursementStatus(disbursementStatus);
	}

	public String getGroupId() {
		return entity.getGroupId();
	}

	public void setGroupId(String groupId) {
		entity.setGroupId(groupId);
	}

	public String getAgentId() {
		return entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}

	public String getSyncStatus() {
		return entity.getSyncStatus();
	}

	public void setSyncStatus(String syncStatus) {
		entity.setSyncStatus(syncStatus);
	}

	public String getLocationId() {
		return entity.getLocationId();
	}

	public void setLocationId(String locationId) {
		entity.setLocationId(locationId);
	}

	public Double getAmountSanctioned() {
		return entity.getAmountSanctioned();
	}

	public void setAmountSanctioned(Double amountSanctioned) {
		entity.setAmountSanctioned(amountSanctioned);
	}

	public String getCreditOfficer() {
		return entity.getCreditOfficer();
	}

	public void setCreditOfficer(String creditOfficer) {
		entity.setCreditOfficer(creditOfficer);
	}

	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}

	public DisburseSchedule getDisburseSchedule() {
		return entity.getDisburseSchedule();
	}

	public void setDisburseSchedule(DisburseSchedule disburseSchedule) {
		entity.setDisburseSchedule(disburseSchedule);
	}

	public Agent getAgent() {
		return entity.getAgent();
	}

	public void setAgent(Agent agent) {
		entity.setAgent(agent);
	}

	// For Loan payment and Schedule
	/*
	 * private List<LoanSchedule> loanSchedules; public List<LoanSchedule>
	 * getLoanSchedules() { return loanSchedules; }
	 * 
	 * public void setLoanSchedules(List<LoanSchedule> loanSchedules) {
	 * this.loanSchedules = loanSchedules; }
	 */
	public String getLastDisDate() {
		if (getDisbursementDate() != null) {
			Date LastSync = getDisbursementDate();
			Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
			String formattedDate = formatter.format(LastSync);
			lastDisDate = formattedDate.toString();
			return lastDisDate;
		} else {
			lastDisDate = "";
			return lastDisDate;
		}
	}

	public void setLastDisDate(String lastDisDate) {
		this.lastDisDate = lastDisDate;
	}

}
