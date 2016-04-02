package com.bfsi.mfi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.AgendaDepositDao;
import com.bfsi.mfi.entity.AgendaView;
import com.bfsi.mfi.service.AgendaDepositService;
import com.bfsi.mfi.vo.AgendaViewVO;

@Service(value = "agendaDepositService")
public class AgendaDepositServiceImpl extends MaintenanceServiceImpl<AgendaViewVO, AgendaView> implements AgendaDepositService {
	
	@Autowired
	private AgendaDepositDao agendaDao;
	@SuppressWarnings("unchecked")
	@Override
	protected AgendaDepositDao getMaintenanceDao() {
		return agendaDao;
	}
	
	@Override
	protected AgendaView getEntity(AgendaViewVO vo) {
		AgendaView userEntity = new AgendaView();
		BeanUtils.copyProperties(vo, userEntity);
		//LoggerUtil.ibsJobDebug("validateion in AgentTransaction getEntity");
		return userEntity;
	}
	
	@Override
	protected AgendaViewVO getValueObject(AgendaView entity) {
		AgendaViewVO userEntity = new AgendaViewVO();
		BeanUtils.copyProperties(entity, userEntity);
		//LoggerUtil.ibsJobDebug("validateion in AgentTransaction getEntity");
		return userEntity;
	}
}

