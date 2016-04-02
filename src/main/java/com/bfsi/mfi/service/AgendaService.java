package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Agenda;
import com.bfsi.mfi.entity.AgendaServiceRequest;
import com.bfsi.mfi.entity.AgendaServiceResponse;
import com.bfsi.mfi.entity.AgendaUpdate;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.vo.AgendaVO;

public interface AgendaService extends MaintenanceService<AgendaVO, Agenda> {

	public ServiceResponse updateAgendaStatus(List<AgendaUpdate> p_request);

	public AgendaServiceResponse getAgendaDetails(AgendaServiceRequest p_request);
	
	
}
