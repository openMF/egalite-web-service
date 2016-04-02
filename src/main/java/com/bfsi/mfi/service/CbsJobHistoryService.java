package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.CbsJobHistory;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CbsJobDetailVO;
import com.bfsi.mfi.vo.CbsJobHistoryVO;
import com.bfsi.mfi.vo.CbsUploadStatusVO;

/**
 * @author bablu kumar
 * 
 */
public interface CbsJobHistoryService extends
		ReadOnlyMaintenanceService<CbsJobHistoryVO, CbsJobHistory> {
	void startCbsJob() throws ServiceException;

	public String selectPk(String recordId) throws ServiceException;

	List<CbsJobDetailVO> getjobDetails(String jobId) throws ServiceException;
	
	List<CbsUploadStatusVO> loadCbsUploadStatusHistory() throws ServiceException;

	//List<CbsUploadStatusVO> loadDynaCbsUploadStatusHistory(String id) throws ServiceException;

	List<CbsUploadStatusVO> loadCbsUploadStatusHistory2() throws ServiceException;	
	List<CbsUploadStatusVO> loadCbsUploadStatusHistory3() throws ServiceException;
	List<CbsUploadStatusVO> loadCbsUploadStatusHistory5() throws ServiceException;
	List<CbsUploadStatusVO> loadCbsUploadStatusHistory6() throws ServiceException;
	List<CbsUploadStatusVO> loadCbsUploadStatusHistory7() throws ServiceException;

}
