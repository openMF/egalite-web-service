package com.bfsi.mfi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DepositAgendaDao;
import com.bfsi.mfi.entity.Agenda;
import com.bfsi.mfi.service.DepositAgendaService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgendaVO;

@Service(value = "depositAgendaService")
public class DepositAgendaServiceImpl extends MaintenanceServiceImpl<AgendaVO, Agenda> implements DepositAgendaService {
	
	@Autowired
	private DepositAgendaDao depositAgendaDao;

	

	@SuppressWarnings("unchecked")
	@Override
	protected DepositAgendaDao getMaintenanceDao() {
	return depositAgendaDao;
	}

	@Override
	protected Agenda getEntity(AgendaVO vo) {
		Agenda userEntity = new Agenda();
		BeanUtils.copyProperties(vo, userEntity);
		LoggerUtil.ibsJobDebug("validateion in DepositAgendaServiceImpl getEntity");
		return userEntity;
	}

	@Override
	protected AgendaVO getValueObject(Agenda entity) {
		// TODO Auto-generated method stub
		AgendaVO agendaVO = new AgendaVO(entity);
		BeanUtils.copyProperties(entity, agendaVO);
		return agendaVO;
	}

	

}
