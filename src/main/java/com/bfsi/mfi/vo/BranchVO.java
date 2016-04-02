package com.bfsi.mfi.vo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bfsi.mfi.entity.Branch;

public class BranchVO extends MaintenanceVO<Branch> {

	public BranchVO() {
		entity = new Branch();
	}

	public BranchVO(Branch entity) {
		super(entity);
	}
	
	 private String branchTodayDateText;
	    
		public String getBranchTodayDateText() {
			if (getBranchDate() != null) {
				Date LastSync = getBranchDate();
				Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
				String formattedDate = formatter.format(LastSync);
				branchTodayDateText = formattedDate.toString();
				return branchTodayDateText;
			} else {
				branchTodayDateText = "";
				return branchTodayDateText;
			}
		}
		
		public void setBranchTodayDateText(String branchTodayDateText) {
			this.branchTodayDateText = branchTodayDateText;
		}

	public String getBranchCode() {
		return super.getId();
	}

	public void setBranchCode(String branchCode) {
		super.setId(branchCode);
	}
	
	public String getChangeDate() {
		return entity.changeDate;
	}

	public void setChangeDate(String changeDate) {
		entity.changeDate = changeDate;
	}
	
	public String getBranchName() {
		return entity.getBranchName();
	}

	public void setBranchName(String branchName) {
		entity.setBranchName(branchName);
	}

	public String getBrnAdd1() {
		return entity.getBrnAdd1();
	}

	public void setBrnAdd1(String brnAdd1) {
		entity.setBrnAdd1(brnAdd1);
	}

	public String getBrnAdd2() {
		return entity.getBrnAdd2();
	}

	public void setBrnAdd2(String brnAdd2) {
		entity.setBrnAdd2(brnAdd2);
	}

	public String getBrnAdd3() {
		return entity.getBrnAdd3();
	}

	public void setBrnAdd3(String brnAdd3) {
		entity.setBrnAdd3(brnAdd3);
	}
	
	public String getBrnAdd4() {
		return entity.getBrnAdd4();
	}

	public void setBrnAdd4(String brnAdd4) {
		entity.setBrnAdd4(brnAdd4);
	}

	public Date getBranchDate() {
		return entity.getBranchDate();
	}

	public void setBranchDate(Date branchDate) {
		entity.setBranchDate(branchDate);
	}

	public String getBranchEodStatus() {
		return entity.getBranchEodStatus();
	}

	public void setBranchEodStatus(String branchEodStatus) {
		entity.setBranchEodStatus(branchEodStatus);
	}

	public String getBranchLcy() {
		return entity.getBranchLcy();
	}

	public void setBranchLcy(String branchLcy) {
		entity.setBranchLcy(branchLcy);
	}

	public String getParentBrnCode() {
		return entity.getParentBrnCode();
	}

	public void setParentBrnCode(String parentBrnCode) {
		entity.setParentBrnCode(parentBrnCode);
	}

	public String getZipCode() {
		return entity.getZipCode();
	}
	public void setZipCode(String zipCode) {
		entity.setZipCode(zipCode);
	}	
	public String getCity() {
		return entity.getCity();
	}
	public void setCity(String city) {
		entity.setCity(city);
	}
	public String getState() {
		return entity.getState();
	}
	public void setState(String state) {
		entity.setState(state);
	}
	public String getCountry() {
		return entity.getCountry();
	}
	public void setCountry(String country) {
		entity.setCountry(country);
	}
	public String getDateChanged() {
		return entity.getDateChanged();
	}

	public void setDateChanged(String dateChanged) {
		entity.setDateChanged(dateChanged);
	}
	public String getRecordStat() {
		return entity.getRecordStat();
	}
	public void setRecordStat(String recordStat) {
		entity.setRecordStat(recordStat);
	}
	public String getCbs_upload_Job_Id() {
		return entity.getCbs_upload_Job_Id();
	}
	public void setCbs_upload_Job_Id(String cbs_upload_Job_Id) {
		entity.setCbs_upload_Job_Id(cbs_upload_Job_Id);
	}
}
