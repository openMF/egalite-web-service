package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.AgendaServiceRequest;
import com.bfsi.mfi.entity.AgendaServiceResponse;
import com.bfsi.mfi.entity.AgendaUpdate;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.model.AgentAgenda;
import com.bfsi.mfi.rest.model.AgentAgendaRequest;
import com.bfsi.mfi.rest.model.AgentAgendaResponse;
import com.bfsi.mfi.rest.model.AgentAgendaUpdate;
import com.bfsi.mfi.rest.model.JsonRequestWrapper;
import com.bfsi.mfi.rest.model.JsonResponseWrapper;
import com.bfsi.mfi.rest.service.AgentAgendaSyncService;
import com.bfsi.mfi.service.AgendaService;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.EncryptDecryptUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgendaVO;

@Component("agentAgendaSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/agendalist")
public class AgentAgendaSyncServiceImpl implements AgentAgendaSyncService {

	@Autowired
	private AgendaService agendaService;
	
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtil;

	@Override
	@POST
	public JsonResponseWrapper getAgendaDetails(JsonRequestWrapper p_wrapRequest) {
		AgentAgendaRequest p_request=null;
		try {
			 p_request=(AgentAgendaRequest)encryptDecryptUtil.getRequestObject(p_wrapRequest, AgentAgendaRequest.class);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("exception", e);
			return new JsonResponseWrapper();
		}
		

		AgentAgendaResponse l_res = new AgentAgendaResponse();
		AgendaServiceRequest l_agendaReq = new AgendaServiceRequest();
		AgendaServiceResponse l_agendaRes = null;
		AgentAgenda l_agntAgenda = null;
		ServiceResponse l_servRes = null;
		List<AgendaUpdate> agendaUpdateList = null;
		AgendaUpdate agendaUpdate = null;
		List<AgentAgenda> l_agendaList = new ArrayList<AgentAgenda>();
		LoggerUtil.mbsJobDebug("agentAgendaSyncServiceImpl service started.....");

		try {
			if(p_request == null){
				l_res.setMessageCode("MFI00251");
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}
			
			if(p_request.getAgentId() == null || p_request.getDeviceId() == null || p_request.getLocationCode() == null || p_request.getBatchSize() <=0){
				l_res.setMessageCode("MFI00250");
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}
			
			BeanUtils.copyProperties(p_request, l_agendaReq);
			if(p_request.getAgentAgendaUpdate() != null && p_request.getAgentAgendaUpdate().size() > 0){
				agendaUpdateList = new ArrayList<AgendaUpdate>();
				for(AgentAgendaUpdate agentAgendaUpdate : p_request.getAgentAgendaUpdate() ){
					agendaUpdate = new AgendaUpdate();
					BeanUtils.copyProperties(agentAgendaUpdate, agendaUpdate);
					agendaUpdateList.add(agendaUpdate);
				}
				l_servRes = agendaService.updateAgendaStatus(agendaUpdateList);
			}			
			if (l_servRes  == null || (l_servRes != null && !l_servRes.getStatus())) {
				//l_res.setMessageCode("MFI00224");	
				LoggerUtil.mbsJobDebug("No Agenda List to update :MFI00224");
			}

			l_agendaRes = agendaService.getAgendaDetails(l_agendaReq);
			if (!l_agendaRes.getStatus()) {
				l_res.setMessageCode("MFI00256");
				LoggerUtil.mbsJobDebug("Agenda Data Size is Null :MFI00256");
				return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
			}

			for (AgendaVO l_vo : l_agendaRes.getAgendaList()) {
				l_agntAgenda = new AgentAgenda();				
				BeanUtils.copyProperties(l_vo, l_agntAgenda, new String[]{"agendaCmpStartDate","agendaCmpEndDate","agendaMbsDate"});
				l_agntAgenda.setAgendaCmpStartDate(ApplicationUtil.dateAsLongFormat(l_vo.getAgendaCmpStartDate()));
				l_agntAgenda.setAgendaCmpEndDate(ApplicationUtil.dateAsLongFormat(l_vo.getAgendaCmpEndDate()));
				l_agntAgenda.setAgendaMbsDate(ApplicationUtil.dateAsLongFormat(l_vo.getAgendaMbsDate()));
				l_agendaList.add(l_agntAgenda);
			}			
			l_res.setAgendaList(l_agendaList);
			l_res.setStatus(true);

		} catch (ServiceException e) {
			l_res.setMessageCode("MFI10001");
			LoggerUtil.mbsJobError("ServiceException While in Agenda Sync service call : MFI10001",e);
		} catch (Exception e) {
			l_res.setMessageCode("MFI10001");
			LoggerUtil.mbsJobError("Unhandeled Exception While in Agenda Sync service call : MFI10001",e);
		}

		return encryptDecryptUtil.getResponseObject(p_wrapRequest,l_res);
	}

}
