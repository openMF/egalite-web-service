package com.bfsi.mfi.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CbsDropListDao;
import com.bfsi.mfi.entity.CbsDropList;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsDropListService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CbsDropListVO;

@Service(value = "cbsDropListService")
public class CbsDropListServiceImpl extends MaintenanceServiceImpl<CbsDropListVO, CbsDropList>
		implements CbsDropListService {

	@Autowired
	private CbsDropListDao cbsDropListDao;

	
	@SuppressWarnings("unchecked")
	protected CbsDropListDao getMaintenanceDao() {
		return cbsDropListDao;
	}

	protected CbsDropList getEntity(CbsDropListVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CbsDropListVO getValueObject(CbsDropList entity) {
		CbsDropListVO agencyVO = new CbsDropListVO(entity);
		return agencyVO;
	}

	@Override
	public String getCbsDropListValues(List<CbsDropList> cbsDropList) throws ServiceException {
		
		String cbsDropLists = cbsDropListDao.getCbsDropListValues(cbsDropList);
		try{
			CbsDropListVO cbsCodeVO = new CbsDropListVO();
			BeanUtils.copyProperties(cbsDropList, cbsCodeVO);
		} catch (ServiceException e) {
			LoggerUtil.mbsJobError("ServiceException while Getting getCbsDropListValues is failed : MFI10001 ",e);
		}
		return cbsDropLists;
		}
}
