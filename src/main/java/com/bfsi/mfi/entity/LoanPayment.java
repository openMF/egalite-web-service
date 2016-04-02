package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author bablu
 *
 */
@Entity(name = "IFTB_CL_LIQ")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanPayment extends MaintenanceEntity {
	public LoanPayment() {
	}
	@Column(name = "EXECUTION_DATE", nullable = false)
	private Date loanPaymentDate;
	@Column(name = "SETTLE_CCY", nullable = false)
	private String currency;
	@Column(name = "SETTLE_AMOUNT", nullable = false)
	private Integer amount;
	public Date getLoanPaymentDate() {
		return loanPaymentDate;
	}
	public void setLoanPaymentDate(Date loanPaymentDate) {
		this.loanPaymentDate = loanPaymentDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getLoanAcNo() {
		return super.getId();
	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
	}
}
