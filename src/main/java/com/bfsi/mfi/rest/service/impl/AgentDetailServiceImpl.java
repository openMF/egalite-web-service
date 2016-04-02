package com.bfsi.mfi.rest.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.model.AgentDetail;
import com.bfsi.mfi.rest.model.AgentResponse;
import com.bfsi.mfi.rest.service.AgentDetailService;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentVO;

@Component("agentDetailServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/agent")
public class AgentDetailServiceImpl implements AgentDetailService {
	@Autowired
	private AgentService agentService;

	public AgentService getAgentServiceImp() {
		return agentService;
	}

	public void setAgentServiceImp(AgentService agentService) {
		this.agentService = agentService;
	}

	@Override
	@GET
	public AgentResponse getAgentDetail() {
		
		AgentResponse response = new AgentResponse();
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		String id;

		try {
			id = sess.getAttribute("agentId").toString();
		} 
		catch (Exception e) {
			response.setAgentdetail(null);
			response.setMessageCode("MFI00253");
			LoggerUtil.mbsJobError("unhandeled Exception while get agent list : MFI00253", e);
			return response;
		}
		AgentVO agent;
		try {
			LoggerUtil.mbsJobDebug("Validating Agent Details ");
			// agent = getAgentServiceImp().get(id);
			agent = getAgentServiceImp().getAgentByUserName(id);
			if(agent != null){
				AgentDetail agentDetail = new AgentDetail();
				BeanUtils.copyProperties(agent, agentDetail, new String[]{"dob","startDate","endDate","regKeyExpiryTime"});
				agentDetail.setDob(ApplicationUtil.dateAsLongFormat(agent.getDob()));
				agentDetail.setStartDate(ApplicationUtil.dateAsLongFormat(agent.getStartDate()));
				agentDetail.setEndDate(ApplicationUtil.dateAsLongFormat(agent.getEndDate()));
				agentDetail.setRegKeyExpiryTime(ApplicationUtil.dateAsLongFormat(agent.getRegKeyExpiryTime()));
				if (agentDetail.getDob() == 0L)
					agentDetail.setDob(ApplicationUtil.dateAsLongFormat(new Date(0l)));
				if (agentDetail.getStartDate() == 0L)
					agentDetail.setStartDate(ApplicationUtil.dateAsLongFormat(new Date(0l)));
				if (agentDetail.getEndDate() == 0L)
					agentDetail.setEndDate(ApplicationUtil.dateAsLongFormat(new Date(0l)));
				// Agent Role
				List<String> agentRoles =  getAgentServiceImp().getAgentRoles(id);
				// External Device MacId
				String macId = getAgentServiceImp().getMacId(id);
				
				agentDetail.setAgentRoles(agentRoles);	
				agentDetail.setMacId(macId);
				response.setAgentdetail(agentDetail);				
				response.setStatus(true);
				
				
			} else {
				response.setStatus(false);
				response.setMessageCode("MFI00252");
				LoggerUtil.mbsJobDebug("Agent List is null");
			}
			
			LoggerUtil.mbsJobDebug("Agent details are setted Successfully");
		} catch (ServiceException e) {
			response.setMessageCode("MFI10001");
			LoggerUtil.mbsJobError("ServiceException while Getting agent is failed : MFI10001 ",e);
		}
		return response;
	}
}
