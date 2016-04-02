package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_loan_detail_disbr_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanDetailDisbrView extends MaintenanceEntity{
	
	public LoanDetailDisbrView() {
	}

	/*a.loan_ac_no,//super id
	a.branch_code,a.component_name,a.disbr_type,a.sch_st_date,
	a.sch_end_date,a.amt_to_disbr*/
	
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	
	@Column(name = "component_name", nullable = false)
	private String componentName;
	
	@Column(name = "disbr_type", nullable = false)
	private String disbrType;
	
	@Column(name = "sch_st_date", nullable = false)
	private Date schStDate;
	
	@Column(name = "sch_end_date", nullable = false)
	private Date schEndDate;
	
	@Column(name = "amt_to_disbr", nullable = false)
	private Double amtToDisbr;
	
	/*New Fields added  => Changes for Asomi Nirmal kanna S*/
	private String agendaId;
	private String ccyCode;
	private Double amtDisbursed;
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

	public Double getAmtDisbursed() {
		return amtDisbursed;
	}

	public void setAmtDisbursed(Double amtDisbursed) {
		this.amtDisbursed = amtDisbursed;
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

	public String getDisbrType() {
		return disbrType;
	}

	public void setDisbrType(String disbrType) {
		this.disbrType = disbrType;
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

	public Double getAmtToDisbr() {
		return amtToDisbr;
	}

	public void setAmtToDisbr(Double amtToDisbr) {
		this.amtToDisbr = amtToDisbr;
	}
	
	
}
