package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "IFTB_CBS_JOB_HISTORY")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CbsJobHistory extends MaintenanceEntity {
	public CbsJobHistory() {

	}
	@Column(name = "START_TIME", nullable = false)
	private Date startTime;
	@Column(name = "STARTED_BY", nullable = false)
	private String startedBy;
	@Column(name = "END_TIME", nullable = false)
	private Date endTime;
	@Column(name = "NUMBER_OF_LOAN_FETCHED", nullable = false)
	private int noOfLoanFetched;
	@Column(name = "NUMBER_OF_CUSTOMER_FETCHED", nullable = false)
	private int noOfCustomerFetched;
	@Column(name = "RECORD_TYPE", nullable = false)
	private String recordType;
	@Column(name = "TIMESTAMP", nullable = false)
	private Date timeStamp;
	@Column(name = "RECORD_ID", nullable = false)
	private String recordId;
	@Column(name = "OPERATION", nullable = false)
	private String operation;
	private String status;
	private int noOfDepositFetched;
	
	public int getNoOfDepositFetched() {
		return noOfDepositFetched;
	}

	public void setNoOfDepositFetched(int noOfDepositFetched) {
		this.noOfDepositFetched = noOfDepositFetched;
	}

	public String getJobId() {
		return super.getId();
	}

	public void setJobId(String jobId) {
		super.setId(jobId);
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String startTime) {
		this.recordType = startTime;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getStartedBy() {
		return startedBy;
	}

	public void setStartedBy(String startedBy) {
		this.startedBy = startedBy;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getNoOfLoanFetched() {
		return noOfLoanFetched;
	}

	public void setNoOfLoanFetched(int noOfLoanFetched) {
		this.noOfLoanFetched = noOfLoanFetched;
	}

	public int getNoOfCustomerFetched() {
		return noOfCustomerFetched;
	}

	public void setNoOfCustomerFetched(int noOfCustomerFetched) {
		this.noOfCustomerFetched = noOfCustomerFetched;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
