package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.PreeDepositDao;
import com.bfsi.mfi.entity.DepositRequestExt;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.PreeDepositService;
import com.bfsi.mfi.vo.DepositRequestVOExt;

@Service(value = "preeDepositService")
@Transactional(rollbackFor = { ServiceException.class })
public class PreeDepositServiceImpl extends MaintenanceServiceImpl<DepositRequestVOExt, DepositRequestExt> implements PreeDepositService {

	@Autowired
	private PreeDepositDao preeDepositDao ;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected PreeDepositDao getMaintenanceDao() {
		// TODO Auto-generated method stub
		return preeDepositDao;
	}

	public void setPreeDepositDao(PreeDepositDao preeDepositDao) {
		this.preeDepositDao = preeDepositDao;
	}

	@Override
	protected DepositRequestExt getEntity(DepositRequestVOExt vo) {
		// TODO Auto-generated method stub
		return vo.getEntity();
	}

	@Override
	protected DepositRequestVOExt getValueObject(DepositRequestExt entity) {
		DepositRequestVOExt depositRequestVO = new DepositRequestVOExt(entity);
		return depositRequestVO;
	}

}
