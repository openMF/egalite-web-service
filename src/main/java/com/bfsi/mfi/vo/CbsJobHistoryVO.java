package com.bfsi.mfi.vo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bfsi.mfi.entity.CbsJobHistory;

public class CbsJobHistoryVO extends MaintenanceVO<CbsJobHistory> {
	public CbsJobHistoryVO() {
		entity = new CbsJobHistory();
	}
	
	public CbsJobHistoryVO(CbsJobHistory entity) {
		super(entity);
	}

	public String getJobId() {
		return super.getId();
	}

	public void setJobId(String jobId) {
		super.setId(jobId);
	}

	public String getRecordType() {
		return entity.getRecordType();
	}

	public void setRecordTpye(String recordType) {
		entity.setRecordType(recordType);
	}

	public Date getTimeStamp() {
		return entity.getTimeStamp();
	}

	public void setTimeStamp(Date timeStamp) {
		entity.setTimeStamp(timeStamp);
	}

	public String getRecordId() {
		return entity.getRecordId();
	}

	public void setRecordId(String recordId) {
		entity.setRecordId(recordId);
	}

	public String getOperation() {
		return entity.getOperation();
	}

	public void setOperation(String operation) {
		entity.setOperation(operation);
	}

	public String getStartedBy() {
		return entity.getStartedBy();
	}

	public void setStartedBy(String startedBy) {
		entity.setStartedBy(startedBy);
	}

	public Date getEndTime() {
		return entity.getEndTime();
	}

	public void setEndTime(Date endTime) {
		entity.setEndTime(endTime);
	}

	public int getNoOfLoanFetched() {
		return entity.getNoOfLoanFetched();
	}

	public void setNoOfLoanFetched(int noOfLoanFetched) {
		entity.setNoOfLoanFetched(noOfLoanFetched);
	}

	public int getNoOfCustomerFetched() {
		return entity.getNoOfCustomerFetched();
	}

	public void setNoOfCustomerFetched(int noOfCustomerFetched) {
		entity.setNoOfCustomerFetched(noOfCustomerFetched);
	}

	public Date getStartTime() {
		return entity.getStartTime();
	}

	public void setStartTime(Date startTime) {
		entity.setStartTime(startTime);
	}

	public String getStatus() {
		return entity.getStatus();
	}

	public void setStatus(String status) {
		entity.setStatus(status);
	}

	public String getLoanAcNo() {
		return super.getId();

	}

	public void setLoanAcNo(String loanAcNo) {
		super.setId(loanAcNo);
	}
	public String getCustomerId() {
		return super.getId();
	}

	public void setCustomerId(String customerId) {
		super.setId(customerId);
	}

	public int getNoOfDepositFetched() {
		return entity.getNoOfDepositFetched();
	}

	public void setNoOfDepositFetched(int noOfDepositFetched) {
		this.entity.setNoOfDepositFetched(noOfDepositFetched);
	}
	public String getDepositAcNo() {
		return super.getId();

	}

	public void setDepositAcNo(String depositAcNo) {
		super.setId(depositAcNo);
	}
	// Search Field --- Bablu kumar
			private String startTimeText;
			private String endTimeText;
			public String getStartTimeText() {
				if (getStartTime() != null) {
					Date StartTime = getStartTime();
					Format formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
					String formattedDate = formatter.format(StartTime);
					startTimeText = formattedDate.toString();
					return startTimeText;
				} else {
					startTimeText = "";
					return startTimeText;
				}
			}


			public void setStartTimeText(String startTimeText) {
				this.startTimeText = startTimeText;
			}

			public String getEndTimeText() {
				if (getEndTime() != null) {
					Date EndTime = getEndTime();
					Format formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
					String formattedDate = formatter.format(EndTime);
					startTimeText = formattedDate.toString();
					return startTimeText;
				} else {
					startTimeText = "";
					return startTimeText;
				}
			}


			public void setEndTimeText(String endTimeText) {
				this.endTimeText = endTimeText;
			}
			
			
}
