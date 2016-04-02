package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.jdbc.DepositMaturityTxnJdbcDao;
import com.bfsi.mfi.entity.DepositMaturityTxnTracker;
import com.bfsi.mfi.service.DepositMaturityTxnService;
import com.bfsi.mfi.vo.DepositMaturityTxnTrackerVO;

@Service(value = "depositMaturityTxnService")
public class DepositMaturityTxnServiceImpl extends MaintenanceServiceImpl<DepositMaturityTxnTrackerVO, DepositMaturityTxnTracker> implements DepositMaturityTxnService{
	@Autowired
	private DepositMaturityTxnJdbcDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public DepositMaturityTxnJdbcDao  getMaintenanceDao() {
		return dao;
	}
	
	@Override
	protected DepositMaturityTxnTracker getEntity(DepositMaturityTxnTrackerVO vo) {
		return vo.getEntity();
	}

	@Override
	protected DepositMaturityTxnTrackerVO getValueObject(DepositMaturityTxnTracker entity) {
		DepositMaturityTxnTrackerVO depositVO = new DepositMaturityTxnTrackerVO(entity);
		return depositVO;
	}
}
