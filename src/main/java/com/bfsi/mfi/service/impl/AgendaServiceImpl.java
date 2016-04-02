package com.bfsi.mfi.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.AgendaDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.Agenda;
import com.bfsi.mfi.entity.AgendaServiceRequest;
import com.bfsi.mfi.entity.AgendaServiceResponse;
import com.bfsi.mfi.entity.AgendaUpdate;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgendaService;
import com.bfsi.mfi.vo.AgendaVO;

@Service
public class AgendaServiceImpl extends MaintenanceServiceImpl<AgendaVO, Agenda> implements AgendaService {
	
	@Autowired
	private AgendaDao agendaDao;

	@Override
	public ServiceResponse updateAgendaStatus(List<AgendaUpdate> p_request) {
		ServiceResponse l_res = new ServiceResponse();
		
		try{
			for(AgendaUpdate agendaUpdate :p_request ){
				agendaDao.updateAgendaStatus(agendaUpdate);
			}			
			l_res.setStatus(true);
		}
		
		catch(DataAccessException e){
			throw new ServiceException("DataAccessException while updating syn agenda status",e);
		}
		catch (Exception e) {
			throw new ServiceException("Unhandled while updating syn agenda status",e);
		}
		return l_res;
	}

	@Override
	public AgendaServiceResponse getAgendaDetails(AgendaServiceRequest p_request) {		
		AgendaServiceResponse l_res = new AgendaServiceResponse();
		List<Agenda> l_agendaList=null;
		List<AgendaVO> l_agendaVoList=new ArrayList<AgendaVO>();
		AgendaVO l_agendaVo=null;
		
		try{
			l_agendaList= agendaDao.getAgendaDetails(p_request);			
			for(Agenda l_entity:l_agendaList){
				l_agendaVo = new AgendaVO(l_entity);
				BeanUtils.copyProperties(l_entity, l_agendaVo);
				l_agendaVoList.add(l_agendaVo);
			}
			l_res.setAgendaList(l_agendaVoList);
			l_res.setStatus(true);
		}
		
		catch(DataAccessException e){			
			throw new ServiceException("DataAccessException while updating syn agenda status",e);
		}
		catch (Exception e) {			
			throw new ServiceException("Unhandled Exception while updating syn agenda status",e);
		}
		return l_res;
	}

	@Override
	protected <T extends MaintenanceDao<Agenda>> T getMaintenanceDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Agenda getEntity(AgendaVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AgendaVO getValueObject(Agenda entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
