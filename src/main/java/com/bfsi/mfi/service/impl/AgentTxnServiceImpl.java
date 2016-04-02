package com.bfsi.mfi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.AgentTxnDao;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.service.AgentTxnService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentTransactionVO;

@Service(value = "agentTxnService")
public class AgentTxnServiceImpl extends ReadOnlyServiceImpl<AgentTransactionVO, AgentTransaction>
		implements AgentTxnService {

	@Autowired
	private AgentTxnDao agentTxnDao;

	@SuppressWarnings("unchecked")
	@Override
	public AgentTxnDao  getReadOnlyMaintenanceDao() {
		return agentTxnDao;
	}
	

	@Override
	protected AgentTransaction getEntity(AgentTransactionVO vo) {
		AgentTransaction userEntity = new AgentTransaction();
		BeanUtils.copyProperties(vo, userEntity);
		LoggerUtil.ibsJobDebug("validateion in AgentTransaction getEntity");
		return userEntity;
	}

	@Override
	protected AgentTransactionVO getValueObject(AgentTransaction entity) {
		AgentTransactionVO agentVO = new AgentTransactionVO();
		BeanUtils.copyProperties(entity, agentVO);
		LoggerUtil.ibsJobDebug("validateion in AgentTransactionVO getValueObject");
		return agentVO;
	}

}
