package com.bfsi.mfi.entity;
/**
 * @author bablu
 *
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "IFTB_CLACCOUNT_SCHEDULES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class LoanSchedule extends MaintenanceEntity {
	public LoanSchedule() {
	}
	@Column(name = "SCHEDULE_ST_DATE", nullable = false)
	private Date loanScheduleDate;
	@Column(name = "COMPONENT_NAME", nullable = false)
	private String componentName;
	@Column(name = "AMOUNT_DUE", nullable = false)
	private Double amountDue;
	@Column(name = "AMOUNT_SETTLED", nullable = false)
	private Double amountPaid;
	@Column(name = "AMOUNT_OVERDUE", nullable = false)
	private Double amountOverdue;
	@Column(name = "SETTLEMENT_CCY", nullable = false)
	private String currency;
	@Column(name = "SCHEDULE_DUE_DATE", nullable = false)
	private Date loanScheduleDueDate;
	
	public Date getLoanScheduleDate() {
		return loanScheduleDate;
	}
	public void setLoanScheduleDate(Date loanScheduleDate) {
		this.loanScheduleDate = loanScheduleDate;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public Double getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(Double amountDue) {
		this.amountDue = amountDue;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Double getAmountOverdue() {
		return amountOverdue; 
	}
	public void setAmountOverdue(Double amountOverdue) {
		this.amountOverdue = amountOverdue;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getLoanScheduleDueDate() {
		return loanScheduleDueDate;
	}
	public void setLoanScheduleDueDate(Date loanScheduleDueDate) {
		this.loanScheduleDueDate = loanScheduleDueDate;
	}
	public String getLoanAcNo() {
		return super.getId();
	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
	}
	
}
