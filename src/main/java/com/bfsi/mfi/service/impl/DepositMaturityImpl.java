package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DepositMaturityDao;
import com.bfsi.mfi.entity.DepositMaturity;
import com.bfsi.mfi.service.DepositMaturityService;
import com.bfsi.mfi.vo.DepositMaturityVO;

@Service(value = "depositMaturityService")
public class DepositMaturityImpl extends MaintenanceServiceImpl<DepositMaturityVO,DepositMaturity>
		implements DepositMaturityService {

	@Autowired
	private DepositMaturityDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public DepositMaturityDao  getMaintenanceDao() {
		return dao;
	}
	
	@Override
	protected DepositMaturity getEntity(DepositMaturityVO vo) {
		return vo.getEntity();
	}

	@Override
	protected DepositMaturityVO getValueObject(DepositMaturity entity) {
		DepositMaturityVO agentVO = new DepositMaturityVO(entity);
		return agentVO;
	}

}
