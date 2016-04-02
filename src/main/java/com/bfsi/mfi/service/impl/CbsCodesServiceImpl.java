package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CbsCodesDao;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsCodesService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CbsCodesVO;

@Service(value = "cbsCodesService")
public class CbsCodesServiceImpl extends
		MaintenanceServiceImpl<CbsCodesVO, CbsCodes> implements CbsCodesService {
	@Autowired
	private CbsCodesDao cbsCodesDao;

	@SuppressWarnings("unchecked")
	@Override
	protected CbsCodesDao getMaintenanceDao() {

		return cbsCodesDao;
	}

	@Override
	protected CbsCodes getEntity(CbsCodesVO vo) {

		return vo.getEntity();
	}

	@Override
	protected CbsCodesVO getValueObject(CbsCodes entity) {

		CbsCodesVO cbsCodesVO = new CbsCodesVO(entity);

		return cbsCodesVO;
	}

	@Override
	public List<CbsCodesVO> getCbsLocationCodes() throws ServiceException {
		List<CbsCodes> cbsCodes = cbsCodesDao.getCbsLocationCodes();
		if (cbsCodes != null) {
			List<CbsCodesVO> cbsCodeVO = new ArrayList<CbsCodesVO>(
					cbsCodes.size());
			for (CbsCodes lov : cbsCodes) {
				CbsCodesVO cbsCodesVO = new CbsCodesVO();
				BeanUtils.copyProperties(lov, cbsCodesVO);
				cbsCodeVO.add(cbsCodesVO);
			}
			LoggerUtil
					.ibsJobDebug("validation in getting CBS LocationCodes");
			return cbsCodeVO;
		} else {
			LoggerUtil
					.ibsJobDebug("validation in getting CBS LocationCodes");
			return new ArrayList<CbsCodesVO>();
		}
	}
	
	
	@Override
	public List<CbsCodesVO> getCbsBranchCodes() throws ServiceException {
		List<CbsCodes> cbsCodes = cbsCodesDao.getCbsBranchCodes();
		if (cbsCodes != null) {
			List<CbsCodesVO> cbsCodeVO = new ArrayList<CbsCodesVO>(
					cbsCodes.size());
			for (CbsCodes lov : cbsCodes) {
				CbsCodesVO cbsCodesVO = new CbsCodesVO();
				BeanUtils.copyProperties(lov, cbsCodesVO);
				cbsCodeVO.add(cbsCodesVO);
			}
			LoggerUtil
					.ibsJobDebug("validation in getting CBS BranchCodes");
			return cbsCodeVO;
		} else {
			LoggerUtil
					.ibsJobDebug("validation in getting CBS BranchCodes");
			return new ArrayList<CbsCodesVO>();
		}
	}

	@Override
	public List<CbsCodesVO> getCbsRouteCodes() throws ServiceException {

		List<CbsCodes> cbsCodes = cbsCodesDao.getCbsRouteCodes();
		if (cbsCodes != null) {
			List<CbsCodesVO> cbsCodeVO = new ArrayList<CbsCodesVO>(
					cbsCodes.size());
			for (CbsCodes lov : cbsCodes) {
				CbsCodesVO cbsCodesVO = new CbsCodesVO();
				BeanUtils.copyProperties(lov, cbsCodesVO);
				cbsCodeVO.add(cbsCodesVO);
			}
			LoggerUtil
					.ibsJobDebug("validation in getting CBS BranchCodes");
			return cbsCodeVO;
		} else {
			LoggerUtil
					.ibsJobDebug("validation in getting CBS BranchCodes");
			return new ArrayList<CbsCodesVO>();
		}
	
	}

	@Override
	public List<CbsCodesVO> getCbsCenterCodes() throws ServiceException {


		List<CbsCodes> cbsCodes = cbsCodesDao.getCbsCenterCodes();
		if (cbsCodes != null) {
			List<CbsCodesVO> cbsCodeVO = new ArrayList<CbsCodesVO>(
					cbsCodes.size());
			for (CbsCodes lov : cbsCodes) {
				CbsCodesVO cbsCodesVO = new CbsCodesVO();
				BeanUtils.copyProperties(lov, cbsCodesVO);
				cbsCodeVO.add(cbsCodesVO);
			}
			LoggerUtil
					.ibsJobDebug("validation in getting CBS BranchCodes");
			return cbsCodeVO;
		} else {
			LoggerUtil
					.ibsJobDebug("validation in getting CBS BranchCodes");
			return new ArrayList<CbsCodesVO>();
		}
	
	
	}

	@Override
	public List<CbsCodesVO> getCbsAgentCodes() throws ServiceException {
		List<CbsCodes> cbsCodes = cbsCodesDao.getCbsAgentCodes();
		if (cbsCodes != null) {
			List<CbsCodesVO> cbsCodeVO = new ArrayList<CbsCodesVO>(
					cbsCodes.size());
			for (CbsCodes lov : cbsCodes) {
				CbsCodesVO cbsCodesVO = new CbsCodesVO();
				BeanUtils.copyProperties(lov, cbsCodesVO);
				cbsCodeVO.add(cbsCodesVO);
			}
			LoggerUtil
					.ibsJobDebug("validation in getting CBS BranchCodes");
			return cbsCodeVO;
		} else {
			LoggerUtil
					.ibsJobDebug("validation in getting CBS BranchCodes");
			return new ArrayList<CbsCodesVO>();
		}
	
	}



}
