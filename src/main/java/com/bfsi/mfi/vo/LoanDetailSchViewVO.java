package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.LoanDetailSchView;

public class LoanDetailSchViewVO extends MaintenanceVO<LoanDetailSchView>{

	public LoanDetailSchViewVO() {
		entity = new LoanDetailSchView();
	}
	
	public LoanDetailSchViewVO(LoanDetailSchView entity) {
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

	public Double getAmtSettled() {
		return entity.getAmtSettled();
	}

	public void setAmtSettled(Double amtSettled) {
		entity.setAmtSettled(amtSettled);
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

	public String getSchType() {
		return  entity.getSchType();
	}

	public void setSchType(String schType) {
		entity.setSchType(schType);
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

	public String getIsFutureSch() {
		return  entity.getIsFutureSch();
	}

	public void setIsFutureSch(String isFutureSch) {
		entity.setIsFutureSch(isFutureSch); 
	}

	public Double getAmtDue() {
		return  entity.getAmtDue();
	}

	public void setAmtDue(Double amtDue) {
		entity.setAmtDue(amtDue);
	}
	
	
}
