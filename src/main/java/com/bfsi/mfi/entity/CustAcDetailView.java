package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_cust_ac_detail_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustAcDetailView extends MaintenanceEntity{
	public CustAcDetailView() {
	}
    
	@Column(name = "customer_id", nullable = false)
	private String customerId;
	@Column(name = "customer_full_name", nullable = false)
	private String customerFullName;
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	@Column(name = "account_type", nullable = false)
	private String accountType;
	@Column(name = "ac_desc", nullable = false)
	private String acDesc;
	@Column(name = "ac_ccy", nullable = false)
	private String acCcy;
	
	@Column(name = "acy_curr_bal", nullable = false)
	private Double acyCurrBal;
	@Column(name = "acy_avail_bal", nullable = false)
	private Double acyAvailBal;
	
	@Column(name = "ac_stat_no_dr", nullable = false)
	private String acStatNoDr;
	@Column(name = "ac_stat_no_cr", nullable = false)
	private String acStatNoCr;
	@Column(name = "ac_stat_block", nullable = false)
	private String acStatBlock;
	@Column(name = "ac_stat_stop_pay", nullable = false)
	private String acStatStopPay;
	@Column(name = "ac_stat_dormant", nullable = false)
	private String acStatDormant;
	@Column(name = "agent_id", nullable = false)
	private String agentId;
	@Column(name = "location_code", nullable = false)
	private String locationCode;
	@Column(name = "credit_officer_id", nullable = false)
	private String creditOfficerId;
	@Column(name = "joint_ac_indicator", nullable = false)
	private String jointAcIndicator;
	@Column(name = "record_stat", nullable = false)
	private String recordStat;
	@Column(name = "cbs_upld_job_id", nullable = false)
	private String cbsUpldJobId;
	
	
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
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAcDesc() {
		return acDesc;
	}
	public void setAcDesc(String acDesc) {
		this.acDesc = acDesc;
	}
	public String getAcCcy() {
		return acCcy;
	}
	public void setAcCcy(String acCcy) {
		this.acCcy = acCcy;
	}
	public Double getAcyCurrBal() {
		return acyCurrBal;
	}
	public void setAcyCurrBal(Double acyCurrBal) {
		this.acyCurrBal = acyCurrBal;
	}
	public Double getAcyAvailBal() {
		return acyAvailBal;
	}
	public void setAcyAvailBal(Double acyAvailBal) {
		this.acyAvailBal = acyAvailBal;
	}
	public String getAcStatNoDr() {
		return acStatNoDr;
	}
	public void setAcStatNoDr(String acStatNoDr) {
		this.acStatNoDr = acStatNoDr;
	}
	public String getAcStatNoCr() {
		return acStatNoCr;
	}
	public void setAcStatNoCr(String acStatNoCr) {
		this.acStatNoCr = acStatNoCr;
	}
	public String getAcStatBlock() {
		return acStatBlock;
	}
	public void setAcStatBlock(String acStatBlock) {
		this.acStatBlock = acStatBlock;
	}
	public String getAcStatStopPay() {
		return acStatStopPay;
	}
	public void setAcStatStopPay(String acStatStopPay) {
		this.acStatStopPay = acStatStopPay;
	}
	public String getAcStatDormant() {
		return acStatDormant;
	}
	public void setAcStatDormant(String acStatDormant) {
		this.acStatDormant = acStatDormant;
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
	public String getCreditOfficerId() {
		return creditOfficerId;
	}
	public void setCreditOfficerId(String creditOfficerId) {
		this.creditOfficerId = creditOfficerId;
	}
	public String getJointAcIndicator() {
		return jointAcIndicator;
	}
	public void setJointAcIndicator(String jointAcIndicator) {
		this.jointAcIndicator = jointAcIndicator;
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
	
	
	
	
}
