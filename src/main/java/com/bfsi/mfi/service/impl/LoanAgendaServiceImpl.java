package com.bfsi.mfi.service.impl;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanAgendaDao;
import com.bfsi.mfi.entity.Agenda;
import com.bfsi.mfi.service.LoanAgendaService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgendaVO;

@Service(value = "loanAgendaService")
public class LoanAgendaServiceImpl extends MaintenanceServiceImpl<AgendaVO, Agenda> implements LoanAgendaService {
	
	@Autowired
	private LoanAgendaDao loanAgendaDao;

	@SuppressWarnings("unchecked")
	@Override
	protected LoanAgendaDao getMaintenanceDao() {
	return loanAgendaDao;
	}

	@Override
	protected Agenda getEntity(AgendaVO vo) {
		Agenda userEntity = new Agenda();
		BeanUtils.copyProperties(vo, userEntity);
		LoggerUtil.ibsJobDebug("validateion in LoanAgendaServiceImpl getEntity");
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
