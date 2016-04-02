package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.BranchDao;
import com.bfsi.mfi.entity.Branch;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.BranchService;
import com.bfsi.mfi.vo.BranchVO;
import com.bfsi.mfi.vo.CbsCodesVO;

@Service(value = "branchService")
public class BranchServiceImpl extends MaintenanceServiceImpl<BranchVO, Branch>
		implements BranchService {

	@Autowired
	private BranchDao branchDao;

	@Override
	public List<BranchVO> getBranchCode() {
		List<Branch> branch = branchDao.getBranchCode();
		if (branch != null) {
			List<BranchVO> agentVOs = new ArrayList<BranchVO>(branch.size());
			for (Branch lov : branch) {
				BranchVO branchVO = new BranchVO();
				BeanUtils.copyProperties(lov, branchVO);
				agentVOs.add(branchVO);
			}
			return agentVOs;
		} else {
			return new ArrayList<BranchVO>();
		}
	}

	@Override
	protected Branch getEntity(BranchVO vo) {
		return vo.getEntity();
	}

	@Override
	protected BranchVO getValueObject(Branch entity) {
		BranchVO branchVO = new BranchVO(entity);
		return branchVO;
	}

	@Override
	public List<BranchVO> getBranchList() throws ServiceException {
		List<BranchVO> branchVoList = new ArrayList<BranchVO>();
		List<Branch> branchList = new ArrayList<Branch>();
		try {
			branchList = branchDao.getBranchList();
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting list of Branch code:", e);
		}
		if (!branchList.isEmpty()) {
			for (Branch branch : branchList) {
				BranchVO branchVo = getValueObject(branch);
				branchVoList.add(branchVo);
			}
		}
		return branchVoList;
	}
	@SuppressWarnings("unchecked")
	@Override
	protected BranchDao getMaintenanceDao() {
	return branchDao;
	}

	@Override
	public List<CbsCodesVO> getUserCbsBranchCode() throws ServiceException {
		List<CbsCodes> cbsCodesList = branchDao.getUserCbsBranchCode();
		if (cbsCodesList != null) {
			List<CbsCodesVO> cbsCodeVOList = new ArrayList<CbsCodesVO>(cbsCodesList.size());
			for (CbsCodes cbsCodes : cbsCodesList) {
				CbsCodesVO cbsCodeVO = new CbsCodesVO();
				BeanUtils.copyProperties(cbsCodes, cbsCodeVO);
				cbsCodeVOList.add(cbsCodeVO);
			}
			return cbsCodeVOList;
		} else {
			return new ArrayList<CbsCodesVO>();
		}
	}
	
}
