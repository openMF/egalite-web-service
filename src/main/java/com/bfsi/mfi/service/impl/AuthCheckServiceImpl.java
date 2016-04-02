package com.bfsi.mfi.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.service.AuthCheckService;
import com.bfsi.mfi.vo.AgentTransactionVO;

@Repository("authcheckservice")
public class AuthCheckServiceImpl extends MaintenanceServiceImpl<AgentTransactionVO, AgentTransaction> implements AuthCheckService{

	@Override
	public void checkAuthStatus(List<AgentTransactionVO> txnlist) {
	for (AgentTransactionVO agenttxn : txnlist){
		agenttxn.setAuthStatus("A");
	}
		
	}

	@Override
	protected <T extends MaintenanceDao<AgentTransaction>> T getMaintenanceDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AgentTransaction getEntity(AgentTransactionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AgentTransactionVO getValueObject(AgentTransaction entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
