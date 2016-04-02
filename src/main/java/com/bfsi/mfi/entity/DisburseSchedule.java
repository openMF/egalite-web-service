package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Pooja
 * 
 * Modification: Jyoti Ranjan
 */

@Entity(name = "IFTB_DISBR_SCHEDULES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DisburseSchedule extends MaintenanceEntity {
	public DisburseSchedule() {
	}
	@Column(name = "BRANCH_CODE", nullable = false)
	private String branchCode;
	@Column(name = "COMPONENT_NAME", nullable = false)
	private String componentName;
	@Column(name = "SCHEDULE_ST_DATE", nullable = false)
	private Date scheduleStDate;
	@Column(name = "SCHEDULE_DUE_DATE", nullable = false)
	private Date scheduleDueDate;
	@Column(name = "AMOUNT_TO_DISBR", nullable = false)
	private Double amountToDisbr;
	@Column(name = "DTYPE", nullable = false)
	private String dType;
	@Column(name = "MANUAL_AMT_DISBR", nullable = false)
	private Double manualAmtTrans;
	@Column(name = "CUR_DISBR_AMT", nullable = false)
	private Double curDisbrAmt;
	@Column(name = "AMT_DISBURSED", nullable = false)
	private Double amtDisbursed;

	public DisburseSchedule( Date scheduleDueDate, Double amtDisbursed) {
	        this.scheduleDueDate = scheduleDueDate;
	        this.amtDisbursed = amtDisbursed;
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

	public Date getScheduleStDate() {
		return scheduleStDate;
	}

	public void setScheduleStDate(Date scheduleStDate) {
		this.scheduleStDate = scheduleStDate;
	}

	public Date getScheduleDueDate() {
		return scheduleDueDate;
	}

	public void setScheduleDueDate(Date scheduleDueDate) {
		this.scheduleDueDate = scheduleDueDate;
	}

	public Double getAmountToDisbr() {
		return amountToDisbr;
	}

	public void setAmountToDisbr(Double amountToDisbr) {
		this.amountToDisbr = amountToDisbr;
	}

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	public Double getManualAmtTrans() {
		return manualAmtTrans;
	}

	public void setManualAmtTrans(Double manualAmtTrans) {
		this.manualAmtTrans = manualAmtTrans;
	}

	public Double getCurDisbrAmt() {
		return curDisbrAmt;
	}

	public void setCurDisbrAmt(Double curDisbrAmt) {
		this.curDisbrAmt = curDisbrAmt;
	}

	public Double getAmtDisbursed() {
		return amtDisbursed;
	}

	public void setAmtDisbursed(Double amtDisbursed) {
		this.amtDisbursed = amtDisbursed;
	}

	public String getLoanAcNo() {
		return super.getId();
	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
	}
}
