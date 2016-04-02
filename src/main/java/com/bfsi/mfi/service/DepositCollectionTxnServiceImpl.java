package com.bfsi.mfi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DepositCollectionTxnDao;
import com.bfsi.mfi.entity.DepositCollectionTxnTracker;
import com.bfsi.mfi.service.impl.MaintenanceServiceImpl;
import com.bfsi.mfi.vo.DepositCollectionTxnTrackerVO;

@Service(value = "depositCollectionTxnService")
public class DepositCollectionTxnServiceImpl extends MaintenanceServiceImpl<DepositCollectionTxnTrackerVO,DepositCollectionTxnTracker>  implements DepositCollectionTxnService{

	
	@Autowired
	private DepositCollectionTxnDao dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public DepositCollectionTxnDao  getMaintenanceDao() {
		return dao;
	}
	
	@Override
	protected DepositCollectionTxnTracker getEntity(DepositCollectionTxnTrackerVO vo) {
		return vo.getEntity();
	}

	@Override
	protected DepositCollectionTxnTrackerVO getValueObject(DepositCollectionTxnTracker entity) {
		DepositCollectionTxnTrackerVO depoCollectionTxnVO = new DepositCollectionTxnTrackerVO(entity);
		return depoCollectionTxnVO;
	}
	
}
