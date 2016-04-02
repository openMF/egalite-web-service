package com.bfsi.mfi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.AgendaLoanDao;
import com.bfsi.mfi.entity.AgendaView;
import com.bfsi.mfi.service.AgendaLoanService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgendaViewVO;

@Service(value = "agendaLoanService")
public class AgendaLoanServiceImpl extends MaintenanceServiceImpl<AgendaViewVO, AgendaView> implements AgendaLoanService {
	
	@Autowired
	private AgendaLoanDao agendaDao;
	@SuppressWarnings("unchecked")
	@Override
	protected AgendaLoanDao getMaintenanceDao() {
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