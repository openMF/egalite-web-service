package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DisbursementTxnDao;
import com.bfsi.mfi.entity.DisbursementTxn;
import com.bfsi.mfi.service.DisbursementTxnService;
import com.bfsi.mfi.vo.DisbursementTxnVO;

@Service(value = "disbursementTxnService")
public class DisbursementTxnServiceImpl extends MaintenanceServiceImpl<DisbursementTxnVO,DisbursementTxn>
		implements DisbursementTxnService {

	@Autowired
	private DisbursementTxnDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public DisbursementTxnDao  getMaintenanceDao() {
		return dao;
	}
	

	@Override
	protected DisbursementTxn getEntity(DisbursementTxnVO vo) {
		return vo.getEntity();
	}

	@Override
	protected DisbursementTxnVO getValueObject(DisbursementTxn entity) {
		DisbursementTxnVO agentVO = new DisbursementTxnVO(entity);
		return agentVO;
	}

}
