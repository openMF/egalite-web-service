package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CbsJobDetail;

public class CbsJobDetailVO extends MaintenanceVO<CbsJobDetail> {
	public CbsJobDetailVO() {
		entity = new CbsJobDetail();
	}

	public CbsJobDetailVO(CbsJobDetail entity) {
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

	public void setRecordType(String recordType) {
		entity.setRecordType(recordType);
	}

	public String getRecordId() {
		return entity.getRecordId();
	}

	public void setRecordId(String recordId) {
		entity.setRecordId(recordId);
	}
}
