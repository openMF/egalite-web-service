package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "mfi_loan_detail_paid_sch_v")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoanDetailPaidSchView extends MaintenanceEntity{
   
	public LoanDetailPaidSchView() {
	}
	/*a.loan_ac_no,//SUPER ID
	a.branch_code,a.sch_due_date,a.sch_paid_date,a.settlement_ccy_code,
	a.amt_settled,a.full_partial_ind*/
	
	@Column(name = "branch_code", nullable = false)
	private String branchCode;
	
	@Column(name = "sch_due_date", nullable = false)
	private Date schDueDate;
	@Column(name = "sch_paid_date", nullable = false)
	private Date schPaidDate;
	
	@Column(name = "settlement_ccy_code", nullable = false)
	private String settlementCcyCode;
	
	@Column(name = "amt_settled", nullable = false)
	private Double amtSettled;
	
	@Column(name = "full_partial_ind", nullable = false)
	private String fullPartialInd;

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Date getSchDueDate() {
		return schDueDate;
	}

	public void setSchDueDate(Date schDueDate) {
		this.schDueDate = schDueDate;
	}

	public Date getSchPaidDate() {
		return schPaidDate;
	}

	public void setSchPaidDate(Date schPaidDate) {
		this.schPaidDate = schPaidDate;
	}

	public String getSettlementCcyCode() {
		return settlementCcyCode;
	}

	public void setSettlementCcyCode(String settlementCcyCode) {
		this.settlementCcyCode = settlementCcyCode;
	}

	public Double getAmtSettled() {
		return amtSettled;
	}

	public void setAmtSettled(Double amtSettled) {
		this.amtSettled = amtSettled;
	}

	public String getFullPartialInd() {
		return fullPartialInd;
	}

	public void setFullPartialInd(String fullPartialInd) {
		this.fullPartialInd = fullPartialInd;
	}
	
	
	
}
