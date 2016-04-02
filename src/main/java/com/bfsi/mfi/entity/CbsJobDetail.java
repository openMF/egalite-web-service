package com.bfsi.mfi.entity;

public class CbsJobDetail extends MaintenanceEntity {
	private String recordType;
	private String recordId;

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getJobId() {
		return super.getId();
	}

	public void setJobId(String jobId) {
		super.setId(jobId);
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
}
