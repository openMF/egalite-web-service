package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DepositCollectionDao;
import com.bfsi.mfi.entity.DepositCollection;
import com.bfsi.mfi.service.DepositCollectionService;
import com.bfsi.mfi.vo.DepositCollectionVO;

@Service(value = "depositCollectionService")
public class DepositCollectionImpl extends MaintenanceServiceImpl<DepositCollectionVO,DepositCollection>
		implements DepositCollectionService {

	@Autowired
	private DepositCollectionDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public DepositCollectionDao  getMaintenanceDao() {
		return dao;
	}
	
	@Override
	protected DepositCollection getEntity(DepositCollectionVO vo) {
		return vo.getEntity();
	}

	@Override
	protected DepositCollectionVO getValueObject(DepositCollection entity) {
		DepositCollectionVO depositCollectionVO = new DepositCollectionVO(entity);
		return depositCollectionVO;
	}

}
