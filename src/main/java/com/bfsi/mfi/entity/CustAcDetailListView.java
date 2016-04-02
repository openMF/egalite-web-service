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


@Entity(name = "mfi_cust_ac_detail_list_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustAcDetailListView extends MaintenanceEntity {
	public CustAcDetailListView() {
	}

	/*a.cust_ac_no			cust_ac_no,//SUPER ID USED
	a.customer_id			customer_id,
	a.branch_code			branch_code,
	a.account_type			account_type,
	nvl(a.ac_stat_no_dr,'N') 	ac_stat_no_dr,
	nvl(a.ac_stat_no_cr,'N') 	ac_stat_no_cr,
	b.agent_id			agent_id,
	b.location_code			location_code,
	a.credit_officer_id		credit_officer_id*/
	
	@Column(name = "customer_id", nullable = false)
	private String customerId;
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	@Column(name = "account_type", nullable = false)
	private String accountType;
	@Column(name = "ac_stat_no_dr", nullable = false)
	private String acStatNoDr;
	@Column(name = "ac_stat_no_cr", nullable = false)
	private String acStatNoCr;
	@Column(name = "agent_id", nullable = false)
	private String agentId;
	@Column(name = "location_code", nullable = false)
	private String locationCode;
	@Column(name = "credit_officer_id", nullable = false)
	private String creditOfficerId;
	
	@Column(name = "acy_Curr_Bal", nullable = false)
	private String acyCurrBal;
	@Column(name = "acy_Avail_Bal", nullable = false)
	private String acyAvailBal;
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public String getAcyCurrBal() {
		return acyCurrBal;
	}
	public void setAcyCurrBal(String acyCurrBal) {
		this.acyCurrBal = acyCurrBal;
	}
	public String getAcyAvailBal() {
		return acyAvailBal;
	}
	public void setAcyAvailBal(String acyAvailBal) {
		this.acyAvailBal = acyAvailBal;
	}
	
	
	
	
	
	
	
}
