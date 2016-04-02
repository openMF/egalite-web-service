package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.LoanDetailDisbrView;

public class LoanDetailDisbrViewVO extends MaintenanceVO<LoanDetailDisbrView>{

	public LoanDetailDisbrViewVO() {
		entity = new LoanDetailDisbrView();
	}
	
	public LoanDetailDisbrViewVO(LoanDetailDisbrView entity) {
		super(entity);
	}
	
	/*New Fields added  => Changes for Asomi Nirmal kanna S*/
	public String getAgendaId() {
		return entity.getAgendaId();
	}

	public void setAgendaId(String agendaId) {
		entity.setAgendaId(agendaId);
	}

	public String getCcyCode() {
		return entity.getCcyCode();
	}

	public void setCcyCode(String ccyCode) {
		entity.setCcyCode(ccyCode);
	}

	public Double getAmtDisbursed() {
		return entity.getAmtDisbursed();
	}

	public void setAmtDisbursed(Double amtDisbursed) {
		entity.setAmtDisbursed(amtDisbursed);
	}

	public String getIsSettled() {
		return entity.getIsSettled();
	}

	public void setIsSettled(String isSettled) {
		entity.setIsSettled(isSettled);
	}
	
	public String getBranchCode() {
		return  entity.getBranchCode();
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode); 
	}

	public String getComponentName() {
		return  entity.getComponentName();
	}

	public void setComponentName(String componentName) {
		entity.setComponentName(componentName); 
	}

	public String getDisbrType() {
		return  entity.getDisbrType();
	}

	public void setDisbrType(String disbrType) {
		entity.setDisbrType(disbrType);
		}

	public Date getSchStDate() {
		return  entity.getSchStDate();
	}

	public void setSchStDate(Date schStDate) {
		entity.setSchStDate(schStDate); 
	}

	public Date getSchEndDate() {
		return  entity.getSchEndDate();
	}

	public void setSchEndDate(Date schEndDate) {
		entity.setSchEndDate(schEndDate); 
	}

	public Double getAmtToDisbr() {
		return  entity.getAmtToDisbr();
	}

	public void setAmtToDisbr(Double amtToDisbr) {
		entity.setAmtToDisbr(amtToDisbr); 
	}
	
	
}
