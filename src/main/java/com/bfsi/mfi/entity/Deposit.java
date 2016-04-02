package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;

public class Deposit extends MaintenanceEntity {

	public Deposit() {
	}

	@Column(name = "DEP_AC_NO", nullable = false)
	public String depAcNo;
	@Column(name = "BRANCH_CODE", nullable = false)
	public String BranchCode;
	@Column(name = "CUSTOMER_ID", nullable = false)
	public String customerId;
	@Column(name = "LOCATION_ID", nullable = false)
	public String LocationId;
	@Column(name = "AGENT_ID", nullable = false)
	public String AgentId;
	@Column(name = "DEP_CCY", nullable = false)
	public String DepCcy;
	@Column(name = "DEP_OPEN_DATE", nullable = false)
	public Date DepOpenDate;
	@Column(name = "DEP_PAY_FREQ", nullable = false)
	public String DepPayFreq;
	@Column(name = "DEP_INST_AMT", nullable = false)
	public Double DepInstAmt;
	@Column(name = "DEP_INST_AMT_DUE", nullable = false)
	public Double DepInstAmtDue;
	@Column(name = "DEP_INT_RATE", nullable = false)
	public Double DepIntRate;
	@Column(name = "DEP_MATURITY_AMT", nullable = false)
	public Double DepMaturityAmt;
	@Column(name = "DEP_MATURITY_DATE", nullable = false)
	public Date DepMaturityDate;
	@Column(name = "TOTAL_INST_PAID", nullable = false)
	public Double TotalInstPaid;
	@Column(name = "TOTAL_INT_ACCURED", nullable = false)
	public Double TotalIntAccured;
	@Column(name = "DEP_LAST_INST_DATE", nullable = false)
	public Date DepLastInstDate;
	@Column(name = "DEP_OVERDUE_STATUS", nullable = false)
	public String DepOverdueStatus;
	@Column(name = "DEP_OVER_DUE_DATE", nullable = false)
	public Date DepOverDueDate;
	@Column(name = "DEP_OVER_DUE_AMT", nullable = false)
	public Double DepOverDueAmt;
	@Column(name = "REDEMPTION_FLAG", nullable = false)
	public String RedemptionFlag;
	@Column(name = "REDEMPTION_PAYOUT_DATE", nullable = false)
	public Date RedemptionPayoutDate;
	@Column(name = "REDEMPTION_AMOUNT", nullable = false)
	public Double RedemptionAmount;
	@Column(name = "SYNC_STATUS", nullable = false)
	public String SyncStatus;
	@Column(name = "SYNC_TIME", nullable = false)
	public String SyncTime;
	@Column(name = "RECORD_STAT", nullable = false)
	public String RecordStat;
	@Column(name = "JOB_ID", nullable = false)
	public String JobId;
	
	
	public String getDepAcNo() {
		return super.getId();
	}

	public void setDepAcNo(String depAcNo) {
		super.setId(depAcNo);
	}
	public String getBranchCode() {
		return BranchCode;
	}
	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getLocationId() {
		return LocationId;
	}
	public void setLocationId(String locationId) {
		LocationId = locationId;
	}
	public String getAgentId() {
		return AgentId;
	}
	public void setAgentId(String agentId) {
		AgentId = agentId;
	}
	public String getDepCcy() {
		return DepCcy;
	}
	public void setDepCcy(String depCcy) {
		DepCcy = depCcy;
	}
	public Date getDepOpenDate() {
		return DepOpenDate;
	}
	public void setDepOpenDate(Date depOpenDate) {
		DepOpenDate = depOpenDate;
	}
	public String getDepPayFreq() {
		return DepPayFreq;
	}
	public void setDepPayFreq(String depPayFreq) {
		DepPayFreq = depPayFreq;
	}
	public Double getDepInstAmt() {
		return DepInstAmt;
	}
	public void setDepInstAmt(Double depInstAmt) {
		DepInstAmt = depInstAmt;
	}
	public Double getDepInstAmtDue() {
		return DepInstAmtDue;
	}
	public void setDepInstAmtDue(Double depInstAmtDue) {
		DepInstAmtDue = depInstAmtDue;
	}
	public Double getDepIntRate() {
		return DepIntRate;
	}
	public void setDepIntRate(Double depIntRate) {
		DepIntRate = depIntRate;
	}
	public Double getDepMaturityAmt() {
		return DepMaturityAmt;
	}
	public void setDepMaturityAmt(Double depMaturityAmt) {
		DepMaturityAmt = depMaturityAmt;
	}
	public Date getDepMaturityDate() {
		return DepMaturityDate;
	}
	public void setDepMaturityDate(Date depMaturityDate) {
		DepMaturityDate = depMaturityDate;
	}
	public Double getTotalInstPaid() {
		return TotalInstPaid;
	}
	public void setTotalInstPaid(Double totalInstPaid) {
		TotalInstPaid = totalInstPaid;
	}
	public Double getTotalIntAccured() {
		return TotalIntAccured;
	}
	public void setTotalIntAccured(Double totalIntAccured) {
		TotalIntAccured = totalIntAccured;
	}
	public Date getDepLastInstDate() {
		return DepLastInstDate;
	}
	public void setDepLastInstDate(Date depLastInstDate) {
		DepLastInstDate = depLastInstDate;
	}
	public String getDepOverdueStatus() {
		return DepOverdueStatus;
	}
	public void setDepOverdueStatus(String depOverdueStatus) {
		DepOverdueStatus = depOverdueStatus;
	}
	public Date getDepOverDueDate() {
		return DepOverDueDate;
	}
	public void setDepOverDueDate(Date depOverDueDate) {
		DepOverDueDate = depOverDueDate;
	}
	public Double getDepOverDueAmt() {
		return DepOverDueAmt;
	}
	public void setDepOverDueAmt(Double depOverDueAmt) {
		DepOverDueAmt = depOverDueAmt;
	}
	public String getRedemptionFlag() {
		return RedemptionFlag;
	}
	public void setRedemptionFlag(String redemptionFlag) {
		RedemptionFlag = redemptionFlag;
	}
	public Date getRedemptionPayoutDate() {
		return RedemptionPayoutDate;
	}
	public void setRedemptionPayoutDate(Date redemptionPayoutDate) {
		RedemptionPayoutDate = redemptionPayoutDate;
	}
	public Double getRedemptionAmount() {
		return RedemptionAmount;
	}
	public void setRedemptionAmount(Double redemptionAmount) {
		RedemptionAmount = redemptionAmount;
	}
	public String getSyncStatus() {
		return SyncStatus;
	}
	public void setSyncStatus(String syncStatus) {
		SyncStatus = syncStatus;
	}
	public String getSyncTime() {
		return SyncTime;
	}
	public void setSyncTime(String syncTime) {
		SyncTime = syncTime;
	}
	public String getRecordStat() {
		return RecordStat;
	}
	public void setRecordStat(String recordStat) {
		RecordStat = recordStat;
	}
	public String getJobId() {
		return JobId;
	}
	public void setJobId(String jobId) {
		JobId = jobId;
	}
	
	
	
}