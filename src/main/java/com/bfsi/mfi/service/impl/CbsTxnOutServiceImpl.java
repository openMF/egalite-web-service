package com.bfsi.mfi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CbsTxnOutDao;
import com.bfsi.mfi.entity.CbsTxnOut;
import com.bfsi.mfi.service.CbsTxnOutService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CbsTxnOutVO;

@Service(value = "cbsTxnOutService")
public class CbsTxnOutServiceImpl extends MaintenanceServiceImpl<CbsTxnOutVO, CbsTxnOut> implements CbsTxnOutService {
	
	@Autowired
	private CbsTxnOutDao cbsTxnOutDao;

	@SuppressWarnings("unchecked")
	@Override
	protected CbsTxnOutDao getMaintenanceDao() {
	return cbsTxnOutDao;
	}

	@Override
	protected CbsTxnOut getEntity(CbsTxnOutVO vo) {
		CbsTxnOut cbsTxnOut = new CbsTxnOut();
		BeanUtils.copyProperties(vo, cbsTxnOut);
		LoggerUtil.ibsJobDebug("validateion in CbsTxnOutServiceImpl getEntity");
		return cbsTxnOut;
	}

	@Override
	protected CbsTxnOutVO getValueObject(CbsTxnOut entity) {
		// TODO Auto-generated method stub
		CbsTxnOutVO cbsTxnOutVO = new CbsTxnOutVO(entity);
		BeanUtils.copyProperties(entity, cbsTxnOutVO);
		return cbsTxnOutVO;
	}
}
