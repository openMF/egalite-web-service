package com.bfsi.mfi.dao;

import java.util.Date;
import java.util.List;

import com.bfsi.mfi.entity.CbsJobDetail;
import com.bfsi.mfi.entity.CbsJobHistory;
import com.bfsi.mfi.entity.CbsUploadStatus;

/**
 * ListValueDao
 * 
 * @author Bablu kumar
 * @param <ListValue>
 */

public interface CbsJobHistoryDao extends ReadOnlyMaintenanceDao<CbsJobHistory> {
	// List<CbsJobHistory> getCbsJobHistoryForStartTime(String startTime);
	public String selectPk(String recordId);

	public String getJobId();

	public void insertJobId(String jobId, String userId, Date jobStartTime);

	public void updateWithEndTime(String jobId, Date jobEndTime);

	public String getExistingJobId(String userId);

	public void updateWithStartTime(String jobId, Date jobStartTime);

	public List<CbsJobDetail> getCbsDetailForLoan(String jobId);

	public List<CbsJobDetail> getCbsDetailForCustomer(String jobId);
	
	public List<CbsJobDetail> getCbsDetailForDeposit(String jobId);
	
	public List<CbsUploadStatus> loadCbsUploadStatusHistory();

	//public List<CbsUploadStatus> loadDynaCbsUploadStatusHistory(String id);

	public List<CbsUploadStatus> loadCbsUploadStatusHistory2();
	public List<CbsUploadStatus> loadCbsUploadStatusHistory3();
	public List<CbsUploadStatus> loadCbsUploadStatusHistory5();
	public List<CbsUploadStatus> loadCbsUploadStatusHistory6();
	public List<CbsUploadStatus> loadCbsUploadStatusHistory7();
	

}
