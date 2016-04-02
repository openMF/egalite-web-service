package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DisbursementTxnDao;
import com.bfsi.mfi.entity.Deposit;
import com.bfsi.mfi.service.DepositService;
import com.bfsi.mfi.vo.DepositVO;

@Service(value = "depositService")
public class DepositImpl extends MaintenanceServiceImpl<DepositVO,Deposit>
		implements DepositService {

	@Autowired
	private DisbursementTxnDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public DisbursementTxnDao  getMaintenanceDao() {
		return dao;
	}
	

	@Override
	protected Deposit getEntity(DepositVO vo) {
		return vo.getEntity();
	}

	@Override
	protected DepositVO getValueObject(Deposit entity) {
		DepositVO agentVO = new DepositVO(entity);
		return agentVO;
	}

}
