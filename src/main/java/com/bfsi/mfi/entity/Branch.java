package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity(name = "CBS_BRANCH_DETAIL")
public class Branch extends MaintenanceEntity {
	public Branch() {
	}

	public String branchName;
	public String brnAdd1;
	public String brnAdd2;
	public String brnAdd3;
	public String brnAdd4;
	public Date branchDate;
	public String branchEodStatus;
	public String branchLcy;
	public String parentBrnCode;
	public String zipCode;
	public String city;
	public String state;
	public String country;
	public String dateChanged;
	public String recordStat;
	public String cbs_upload_Job_Id;
	
	public String changeDate;
	
	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBrnAdd1() {
		return brnAdd1;
	}

	public void setBrnAdd1(String brnAdd1) {
		this.brnAdd1 = brnAdd1;
	}

	public String getBrnAdd2() {
		return brnAdd2;
	}

	public void setBrnAdd2(String brnAdd2) {
		this.brnAdd2 = brnAdd2;
	}

	public String getBrnAdd3() {
		return brnAdd3;
	}

	public void setBrnAdd3(String brnAdd3) {
		this.brnAdd3 = brnAdd3;
	}

	public Date getBranchDate() {
		return branchDate;
	}

	public void setBranchDate(Date branchDate) {
		this.branchDate = branchDate;
	}

	public String getBranchEodStatus() {
		return branchEodStatus;
	}

	public void setBranchEodStatus(String branchEodStatus) {
		this.branchEodStatus = branchEodStatus;
	}

	public String getBranchLcy() {
		return branchLcy;
	}

	public void setBranchLcy(String branchLcy) {
		this.branchLcy = branchLcy;
	}

	public String getBrnAdd4() {
		return brnAdd4;
	}

	public void setBrnAdd4(String brnAdd4) {
		this.brnAdd4 = brnAdd4;
	}

	public String getParentBrnCode() {
		return parentBrnCode;
	}

	public void setParentBrnCode(String parentBrnCode) {
		this.parentBrnCode = parentBrnCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(String dateChanged) {
		this.dateChanged = dateChanged;
	}

	public String getRecordStat() {
		return recordStat;
	}

	public void setRecordStat(String recordStat) {
		this.recordStat = recordStat;
	}

	public String getCbs_upload_Job_Id() {
		return cbs_upload_Job_Id;
	}

	public void setCbs_upload_Job_Id(String cbs_upload_Job_Id) {
		this.cbs_upload_Job_Id = cbs_upload_Job_Id;
	}

	
}
