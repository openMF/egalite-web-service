package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DisburseSchedule;

/**
 * @author Jyoti Ranjan
 *
 */

public class DisburseScheduleVO extends MaintenanceVO <DisburseSchedule>{
	private static final String MANUAL = "loanMgmt.label.manual";
	private static final String AUTO = "loanMgmt.label.auto";
	protected String dTypeText;
	
	public DisburseScheduleVO() {
		entity = new DisburseSchedule();
	}

	public DisburseScheduleVO(DisburseSchedule entity) {
		super(entity);
	}
	
	public String getBranchCode() {
		return entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}
	
	public String getComponentName() {
		return entity.getComponentName();
	}

	public void setComponentName(String componentName) {
		entity.setComponentName(componentName);
	}
	
	public Date getScheduleStDate() {
		return entity.getScheduleStDate();
	}

	public void setScheduleStDate(Date scheduleStDate) {
		entity.setScheduleStDate(scheduleStDate);
	}

	public Date getScheduleDueDate() {
		return entity.getScheduleDueDate();
	}

	public void setScheduleDueDate(Date scheduleDueDate) {
		entity.setScheduleDueDate(scheduleDueDate);
	}

	public Double getAmountToDisbr() {
		return entity.getAmountToDisbr();
	}

	public void setAmountToDisbr(Double amountToDisbr) {
		entity.setAmountToDisbr(amountToDisbr);
	}

	public String getdType() {
		return entity.getdType();
	}

	public void setdType(String dType) {
		entity.setdType(dType);
	}

	public Double getManualAmtTrans() {
		return entity.getManualAmtTrans();
	}

	public void setManualAmtTrans(Double manualAmtTrans) {
		entity.setManualAmtTrans(manualAmtTrans);
	}

	public Double getCurDisbrAmt() {
		return entity.getCurDisbrAmt();
	}

	public void setCurDisbrAmt(Double curDisbrAmt) {
		entity.setCurDisbrAmt(curDisbrAmt);
	}

	public Double getAmtDisbursed() {
		return entity.getAmtDisbursed();
	}

	public void setAmtDisbursed(Double amtDisbursed) {
		entity.setAmtDisbursed(amtDisbursed);
	}

	public String getLoanAcNo() {
		return entity.getLoanAcNo();
	}

	public void setLoanAcNo(String loanAcNo) {
		entity.setLoanAcNo(loanAcNo);
	}

	public String getdTypeText() {
		if(getdType()!= null)
		  {
			 dTypeText = getResourceStr(MANUAL);		
		     return dTypeText;
		  }
		else{
			dTypeText = getResourceStr(AUTO);		
			return dTypeText;
		}
	}

	public void setdTypeText(String dTypeText) {
		this.dTypeText = dTypeText;
	}
	
}
