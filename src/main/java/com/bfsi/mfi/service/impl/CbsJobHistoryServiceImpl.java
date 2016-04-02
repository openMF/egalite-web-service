package com.bfsi.mfi.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.cbsadapter.CbsAdapterService;
import com.bfsi.mfi.dao.CbsJobHistoryDao;
import com.bfsi.mfi.entity.CbsJobDetail;
import com.bfsi.mfi.entity.CbsJobHistory;
import com.bfsi.mfi.entity.CbsUploadStatus;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsDataSyncService;
import com.bfsi.mfi.service.CbsJobHistoryService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CbsJobDetailVO;
import com.bfsi.mfi.vo.CbsJobHistoryVO;
import com.bfsi.mfi.vo.CbsUploadStatusVO;

@Service(value = "cbsJobHistoryService")
public class CbsJobHistoryServiceImpl extends
		ReadOnlyServiceImpl<CbsJobHistoryVO, CbsJobHistory> implements
		CbsJobHistoryService {

	@Autowired
	private CbsJobHistoryDao cbsJobHistoryDao;

	@Autowired
	private CbsAdapterService cbsAdapterService;
	
	@Autowired
	private CbsDataSyncService cbsDataSyncService;

	protected CbsJobHistory getEntity(CbsJobHistoryVO vo) {
		return vo.getEntity();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CbsJobHistoryDao getReadOnlyMaintenanceDao() {
		return cbsJobHistoryDao;
	}

	public CbsJobHistoryDao getCbsJobHistoryDao() {
		return cbsJobHistoryDao;
	}

	public void setCbsJobHistoryDao(CbsJobHistoryDao cbsJobHistoryDao) {
		this.cbsJobHistoryDao = cbsJobHistoryDao;
	}

	@Override
	protected CbsJobHistoryVO getValueObject(CbsJobHistory entity) {
		CbsJobHistoryVO cbsJobHistoryVO = new CbsJobHistoryVO(entity);
		return cbsJobHistoryVO;
	}

	protected CbsJobDetailVO getValueObject(CbsJobDetail entity) {
		CbsJobDetailVO cbsJobDetailVO = new CbsJobDetailVO(entity);
		return cbsJobDetailVO;
	}

	@Override
	public void startCbsJob() throws ServiceException {
		LoggerUtil.ibsJobDebug("starting cbs job");
		//cbsDataSyncService.syncCbsData();
		/*SimpleDateFormat dateformt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date jobStartTime = new Date();
		Date jobEndTime = null;
		String jobId = null;

		try {
			String userId = getLoggedInUserId();
			jobStartTime = dateformt.parse(dateformt.format(jobStartTime));
			//jobId = getCbsJobHistoryDao().getExistingJobId(userId);
			if (jobId == null) {
				jobId = getCbsJobHistoryDao().getJobId();
				getCbsJobHistoryDao().insertJobId(jobId, userId, jobStartTime);
			}
			startCbsJobs(jobId);
			jobEndTime = new Date();
			jobEndTime = dateformt.parse(dateformt.format(jobEndTime));
			getCbsJobHistoryDao().updateWithEndTime(jobId, jobEndTime);
		} catch (ParseException e) {
			String message = "ParseException while starting Cbs Job :"
					+ e.getMessage();
			throw new ServiceException(message, e);
		} catch (DataAccessException e) {
			String message = "DataAccessException while starting Cbs Job :"
					+ e.getMessage();
			throw new ServiceException(message, e);
		}
		*/
	}

	private void startCbsJobs(String jobId) {
		/*LoggerUtil.ibsJobDebug("starting cbs job : Branch -> Job Id: " + jobId);
		cbsAdapterService.fetchCbsBranches(jobId);
		LoggerUtil.ibsJobDebug("starting cbs job : Currency -> Job Id: "
				+ jobId);
		cbsAdapterService.fetchCbsCcy(jobId);
		LoggerUtil.ibsJobDebug("starting cbs job : FX -> Job Id: " + jobId);
		cbsAdapterService.fetchCbsFx(jobId);
		LoggerUtil.ibsJobDebug("starting cbs job : Customers -> Job Id: "
				+ jobId);
		cbsAdapterService.fetchCbsCustomers(jobId);
		LoggerUtil.ibsJobDebug("starting cbs job : Loans -> Job Id: " + jobId);
		cbsDataSyncService.syncCbsData();
		cbsAdapterService.fetchCbsMfiLoans(jobId);
		LoggerUtil.ibsJobDebug("starting cbs job : Deposits -> Job Id: "+ jobId);
		cbsAdapterService.fetchCbsMfiDeposit(jobId);*/

	}

	public String getLoggedInUserId() {
		LoggerUtil.ibsJobDebug("getting legged in user id");

		UserDetails userDetails = getUserDetails();
		return (userDetails != null) ? userDetails.getUsername() : "";
	}

	public UserDetails getUserDetails() {
		LoggerUtil.ibsJobDebug("getting legged in user details");
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal);
		} else {
			return null;
		}
	}

	/*
	 * @Override public List<CbsJobHistoryVO> getCbsJobHistories(String
	 * startTime) { // TODO Auto-generated method stub List<CbsJobHistoryVO>
	 * cbsJobHistoryList=new ArrayList<CbsJobHistoryVO>(); List<CbsJobHistory>
	 * cbsJobHistorylist
	 * =cbsJobHistoryDao.getCbsJobHistoryForStartTime(startTime);
	 * if(cbsJobHistorylist!=null) { for(CbsJobHistory
	 * cbsJobHistoryEntity:cbsJobHistorylist) { CbsJobHistoryVO
	 * cbsJobHistoryvo=new CbsJobHistoryVO();
	 * BeanUtils.copyProperties(cbsJobHistoryEntity,cbsJobHistoryvo);
	 * cbsJobHistoryList.add(cbsJobHistoryvo); } } return cbsJobHistoryList;
	 * 
	 * }
	 */
	@Override
	public String selectPk(String recordId) throws ServiceException {
		try {
			return cbsJobHistoryDao.selectPk(recordId);
		} catch (DataAccessException e) {
			String message = "DataAccessException while checking availability of record id:"
					+ recordId + ". Error: " + e.getMessage();
			throw new ServiceException(message, e);
		}
	}

	@Override
	public List<CbsJobDetailVO> getjobDetails(String jobId)
			throws ServiceException {
		List<CbsJobDetail> cbsDetailForCustomer = new ArrayList<CbsJobDetail>();
		List<CbsJobDetail> cbsDetailForLoan = new ArrayList<CbsJobDetail>();
		List<CbsJobDetail> cbsDetailForDeposit = new ArrayList<CbsJobDetail>();
		List<CbsJobDetailVO> cbsJobDetail = new ArrayList<CbsJobDetailVO>();
		try {
			cbsDetailForCustomer = cbsJobHistoryDao
					.getCbsDetailForCustomer(jobId);
			cbsDetailForLoan = cbsJobHistoryDao.getCbsDetailForLoan(jobId);
			cbsDetailForDeposit = cbsJobHistoryDao
					.getCbsDetailForDeposit(jobId);
			cbsDetailForCustomer.addAll(cbsDetailForLoan);
			cbsDetailForCustomer.addAll(cbsDetailForDeposit);
			for (CbsJobDetail cbsDetail : cbsDetailForCustomer) {
				CbsJobDetailVO cbsDetailVO = getValueObject(cbsDetail);
				cbsJobDetail.add(cbsDetailVO);
			}
		} catch (DataAccessException e) {
			String message = "DataAccessException while checking records of job id:"
					+ jobId + ". Error: " + e.getMessage();
			throw new ServiceException(message, e);
		}

		return cbsJobDetail;
	}

	@Override
	public List<CbsUploadStatusVO> loadCbsUploadStatusHistory()
			throws ServiceException {
		List<CbsUploadStatusVO> l_jobStatusHistoryVoList = new ArrayList<CbsUploadStatusVO>();
		List<CbsUploadStatus> l_jobStatusHistoryList = new ArrayList<CbsUploadStatus>();
		CbsUploadStatusVO l_jobStatusHistoryVo = null;		
		try {
				l_jobStatusHistoryList = cbsJobHistoryDao.loadCbsUploadStatusHistory();
				for (CbsUploadStatus l_cbsUploadStatus : l_jobStatusHistoryList) {
					l_jobStatusHistoryVo = new CbsUploadStatusVO();
					BeanUtils.copyProperties(l_cbsUploadStatus, l_jobStatusHistoryVo);
					l_jobStatusHistoryVoList.add(l_jobStatusHistoryVo);
				}
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while loadCbsUploadStatusHistory:", e);
		}
		return l_jobStatusHistoryVoList;
	}	
	
	
	/*@Override
	public List<CbsUploadStatusVO> loadDynaCbsUploadStatusHistory(String id)
			throws ServiceException {
		List<CbsUploadStatusVO> d_jobStatusHistoryVoList = new ArrayList<CbsUploadStatusVO>();
		List<CbsUploadStatus> d_jobStatusHistoryList = new ArrayList<CbsUploadStatus>();
		CbsUploadStatusVO d_jobStatusHistoryVo = null;		
		try {
				d_jobStatusHistoryList = cbsJobHistoryDao.loadDynaCbsUploadStatusHistory(id);
				for (CbsUploadStatus d_cbsUploadStatus : d_jobStatusHistoryList) {
					d_jobStatusHistoryVo = new CbsUploadStatusVO();
					BeanUtils.copyProperties(d_cbsUploadStatus, d_jobStatusHistoryVo);
					d_jobStatusHistoryVoList.add(d_jobStatusHistoryVo);
				}
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while loadCbsUploadStatusHistory:", e);
		}
		return d_jobStatusHistoryVoList;
	}	*/
	
	
	@Override
	public List<CbsUploadStatusVO> loadCbsUploadStatusHistory2()
			throws ServiceException {
		List<CbsUploadStatusVO> l2_jobStatusHistoryVoList = new ArrayList<CbsUploadStatusVO>();
		List<CbsUploadStatus> l2_jobStatusHistoryList = new ArrayList<CbsUploadStatus>();
		CbsUploadStatusVO l2_jobStatusHistoryVo = null;		
		try {
				l2_jobStatusHistoryList = cbsJobHistoryDao.loadCbsUploadStatusHistory2();
				for (CbsUploadStatus l2_cbsUploadStatus : l2_jobStatusHistoryList) {
					l2_jobStatusHistoryVo = new CbsUploadStatusVO();
					BeanUtils.copyProperties(l2_cbsUploadStatus, l2_jobStatusHistoryVo);
					l2_jobStatusHistoryVoList.add(l2_jobStatusHistoryVo);
				}
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while loadCbsUploadStatusHistory:", e);
		}
		return l2_jobStatusHistoryVoList;
	}	

	
	
	@Override
	public List<CbsUploadStatusVO> loadCbsUploadStatusHistory3()
			throws ServiceException {
		List<CbsUploadStatusVO> l3_jobStatusHistoryVoList = new ArrayList<CbsUploadStatusVO>();
		List<CbsUploadStatus> l3_jobStatusHistoryList = new ArrayList<CbsUploadStatus>();
		CbsUploadStatusVO l3_jobStatusHistoryVo = null;		
		try {
				l3_jobStatusHistoryList = cbsJobHistoryDao.loadCbsUploadStatusHistory3();
				for (CbsUploadStatus l3_cbsUploadStatus : l3_jobStatusHistoryList) {
					l3_jobStatusHistoryVo = new CbsUploadStatusVO();
					BeanUtils.copyProperties(l3_cbsUploadStatus, l3_jobStatusHistoryVo);
					l3_jobStatusHistoryVoList.add(l3_jobStatusHistoryVo);
				}
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while loadCbsUploadStatusHistory:", e);
		}
		return l3_jobStatusHistoryVoList;
	}	
	
	
	@Override
	public List<CbsUploadStatusVO> loadCbsUploadStatusHistory5()
			throws ServiceException {
		List<CbsUploadStatusVO> l5_jobStatusHistoryVoList = new ArrayList<CbsUploadStatusVO>();
		List<CbsUploadStatus> l5_jobStatusHistoryList = new ArrayList<CbsUploadStatus>();
		CbsUploadStatusVO l5_jobStatusHistoryVo = null;		
		try {
				l5_jobStatusHistoryList = cbsJobHistoryDao.loadCbsUploadStatusHistory5();
				for (CbsUploadStatus l5_cbsUploadStatus : l5_jobStatusHistoryList) {
					l5_jobStatusHistoryVo = new CbsUploadStatusVO();
					BeanUtils.copyProperties(l5_cbsUploadStatus, l5_jobStatusHistoryVo);
					l5_jobStatusHistoryVoList.add(l5_jobStatusHistoryVo);
				}
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while loadCbsUploadStatusHistory:", e);
		}
		return l5_jobStatusHistoryVoList;
	}	
	
	
	@Override
	public List<CbsUploadStatusVO> loadCbsUploadStatusHistory6()
			throws ServiceException {
		List<CbsUploadStatusVO> l6_jobStatusHistoryVoList = new ArrayList<CbsUploadStatusVO>();
		List<CbsUploadStatus> l6_jobStatusHistoryList = new ArrayList<CbsUploadStatus>();
		CbsUploadStatusVO l6_jobStatusHistoryVo = null;		
		try {
				l6_jobStatusHistoryList = cbsJobHistoryDao.loadCbsUploadStatusHistory6();
				for (CbsUploadStatus l6_cbsUploadStatus : l6_jobStatusHistoryList) {
					l6_jobStatusHistoryVo = new CbsUploadStatusVO();
					BeanUtils.copyProperties(l6_cbsUploadStatus, l6_jobStatusHistoryVo);
					l6_jobStatusHistoryVoList.add(l6_jobStatusHistoryVo);
				}
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while loadCbsUploadStatusHistory:", e);
		}
		return l6_jobStatusHistoryVoList;
	}	
	
	@Override
	public List<CbsUploadStatusVO> loadCbsUploadStatusHistory7()
			throws ServiceException {
		List<CbsUploadStatusVO> l7_jobStatusHistoryVoList = new ArrayList<CbsUploadStatusVO>();
		List<CbsUploadStatus> l7_jobStatusHistoryList = new ArrayList<CbsUploadStatus>();
		CbsUploadStatusVO l7_jobStatusHistoryVo = null;		
		try {
				l7_jobStatusHistoryList = cbsJobHistoryDao.loadCbsUploadStatusHistory7();
				for (CbsUploadStatus l7_cbsUploadStatus : l7_jobStatusHistoryList) {
					l7_jobStatusHistoryVo = new CbsUploadStatusVO();
					BeanUtils.copyProperties(l7_cbsUploadStatus, l7_jobStatusHistoryVo);
					l7_jobStatusHistoryVoList.add(l7_jobStatusHistoryVo);
				}
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while loadCbsUploadStatusHistory:", e);
		}
		return l7_jobStatusHistoryVoList;
	}	
}
