package com.bfsi.mfi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.AgentVO;

/**
 * @author Nirmal kanna S
 *
 */
@ManagedBean(name = "agentListController")
@ViewScoped
public class AgentListController extends MaintenanceListController<AgentVO, Agent>
		implements Serializable 	{
	private static final long serialVersionUID = -1376002694395713795L;
	@ManagedProperty(value = "#{agentService}")
	private AgentService agentService;
	
	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	@Override
	protected MaintenanceService<AgentVO, Agent> getMaintenanceService() {
		return agentService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewAgent";
	}
}