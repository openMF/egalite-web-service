package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.jdbc.DepositRedemptionTxnJdbcDao;
import com.bfsi.mfi.entity.DepositRedemptionTxnTracker;
import com.bfsi.mfi.service.DepositRedemptionTxnService;
import com.bfsi.mfi.vo.DepositRedemptionTxnTrackerVO;


@Service(value = "depositRedemptionTxnService")
public class DepositRedemTxnServiceImpl extends MaintenanceServiceImpl<DepositRedemptionTxnTrackerVO, DepositRedemptionTxnTracker> implements DepositRedemptionTxnService{
	@Autowired
	private DepositRedemptionTxnJdbcDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public DepositRedemptionTxnJdbcDao  getMaintenanceDao() {
		return dao;
	}
	
	@Override
	protected DepositRedemptionTxnTracker getEntity(DepositRedemptionTxnTrackerVO vo) {
		return vo.getEntity();
	}

	@Override
	protected DepositRedemptionTxnTrackerVO getValueObject(DepositRedemptionTxnTracker entity) {
		DepositRedemptionTxnTrackerVO depositVO = new DepositRedemptionTxnTrackerVO(entity);
		return depositVO;
	}
	
}
