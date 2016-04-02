package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_loan_detail_sch_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanDetailSchView extends MaintenanceEntity{

	public LoanDetailSchView() {
	}
	/*a.loan_ac_no //super id
	a.branch_code, a.component_name, a.sch_type, a.sch_st_date,
	a.sch_end_date,a.is_future_sch, a.amt_due*/
	
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	
	@Column(name = "component_name", nullable = false)
	private String componentName;
	
	@Column(name = "sch_type", nullable = false)
	private String schType;
	
	@Column(name = "sch_st_date", nullable = false)
	private Date schStDate;
	
	@Column(name = "sch_end_date", nullable = false)
	private Date schEndDate;
	
	@Column(name = "is_future_sch", nullable = false)
	private String isFutureSch;
	
	@Column(name = "amt_due", nullable = false)
	private Double amtDue;

	/*New Fields added  => Changes for Asomi Nirmal kanna S*/
	private String agendaId;
	private String ccyCode;
	private Double amtSettled;
	private String isSettled;
	
	
	
	public String getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(String agendaId) {
		this.agendaId = agendaId;
	}

	public String getCcyCode() {
		return ccyCode;
	}

	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}

	public Double getAmtSettled() {
		return amtSettled;
	}

	public void setAmtSettled(Double amtSettled) {
		this.amtSettled = amtSettled;
	}

	public String getIsSettled() {
		return isSettled;
	}

	public void setIsSettled(String isSettled) {
		this.isSettled = isSettled;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getSchType() {
		return schType;
	}

	public void setSchType(String schType) {
		this.schType = schType;
	}

	public Date getSchStDate() {
		return schStDate;
	}

	public void setSchStDate(Date schStDate) {
		this.schStDate = schStDate;
	}

	public Date getSchEndDate() {
		return schEndDate;
	}

	public void setSchEndDate(Date schEndDate) {
		this.schEndDate = schEndDate;
	}

	public String getIsFutureSch() {
		return isFutureSch;
	}

	public void setIsFutureSch(String isFutureSch) {
		this.isFutureSch = isFutureSch;
	}

	public Double getAmtDue() {
		return amtDue;
	}

	public void setAmtDue(Double amtDue) {
		this.amtDue = amtDue;
	}
	
	
	
}
