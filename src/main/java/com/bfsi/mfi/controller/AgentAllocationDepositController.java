package com.bfsi.mfi.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.service.DepositEnrichmentService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgentAllocationsForDepositVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.PigmyDepositVO;

@ManagedBean(name = "agentAllocationDepositController")
@ViewScoped
public class AgentAllocationDepositController extends CommonListController<AgentAllocationsForDepositVO>{
	private static final String ADD_AGENT_ALLOCATIONS = "allocateAgentForDeposit"; //addAgentAllocations
	private static final String VIEWID_AGENT_BULK_ALLOC = "/pigmydeposit/bulkDepositAgentAllocations.xhtml";  
	private static final String VIEWID_AGEN_ALLOC = "/pigmydeposit/depositAgentAllocation.xhtml";  
	
	@ManagedProperty(value = "#{depositEnrichmentService}")
	private DepositEnrichmentService depositEnrichmentService;
	@ManagedProperty(value = "#{agentService}")
	private AgentService agentService;
	@ManagedProperty(value = "#{auth}")
	protected AuthController authController;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<AgentVO> agents = new ArrayList<AgentVO>();
	private AgentVO agent = new AgentVO();
	private UserDetails userDetails;

	protected String getViewRecordUrl() {
		return "../pigmydeposit/viewpigmyDepositAccount.xhtml";
	}

	public DepositEnrichmentService getDepositEnrichmentService() {
		return depositEnrichmentService;
	}

	public void setDepositEnrichmentService(
			DepositEnrichmentService depositEnrichmentService) {
		this.depositEnrichmentService = depositEnrichmentService;
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	/*
	 * Load deposit details from deposit table and agent name from agent table when
	 * screen load.
	 * 
	 * Get agent FirstNames for drop-down.
	 */
	@PostConstruct
	public void load() {
		LoggerUtil.ibsJobDebug("Loading deposit & agent on screen loading..");
		userDetails = authController.getUserDetails();// getUserDetails();
		String viewId = FacesContext.getCurrentInstance().getViewRoot()
				.getViewId();
		try {
			agents = agentService.getAuthAgentHavCreditOfficer();

			if (viewId.equalsIgnoreCase(VIEWID_AGEN_ALLOC)
					|| viewId.equalsIgnoreCase(VIEWID_AGENT_BULK_ALLOC)) {
				setRecords(depositEnrichmentService.getUnassigned());
			}/* else {
				setRecords(depositEnrichmentService.get());
			}*/
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while get deposit with agent first name : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {			 
			LoggerUtil.ibsJobError("Unhandled exception while get deposit with agent first name : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	public String allocateAgent() {
		String loggedInUser = userDetails.getUsername();
		Date date = new Date();

		if (getRecords() != null) {
			List<AgentAllocationsForDepositVO> allocVos = new ArrayList<AgentAllocationsForDepositVO>();
			for (AgentAllocationsForDepositVO allocVo : getRecords()) {
				if (("".equals(allocVo.getAgent().getId()) || (allocVo
						.getAgent().getId() == null))) {
					// no agent is allocated, continue
					continue;
				}
				// seting login user and timestamp.
				allocVo.setAllocateUser(loggedInUser);
				allocVo.setAllocationTime(new Timestamp(date.getTime())); 
				allocVos.add(allocVo);
			}

			if (allocVos.size() > 0) {
				try {
					LoggerUtil.ibsJobDebug("Started agent allocation to deposit......");
					depositEnrichmentService.insert(allocVos);
					return "success";
				} catch (ServiceException e) {
					LoggerUtil.ibsJobError("ServiceException while agent allocation to deposit : MFI10001", e);
		            MessageUtil.addMessage("MFI10001");
				} catch (Exception e) {
					LoggerUtil.ibsJobError("Unhandled exception while agent allocation to deposit : MFI10001", e);
		            MessageUtil.addMessage("MFI10001");
				}
			} else {
				LoggerUtil.ibsJobDebug("Select agent to assign before save the deposit Number. : MFI01301");
				MessageUtil.addMessage("MFI01301");
				return null;
			}
		}
		return null;
	}

	/**
	 * Bulk loans are allocated to Agent for selected records.
	 */
	public String bulkAllocateAgent() {
		String loggedInUser = userDetails.getUsername();

		if (getSelectedRecords() != null) {
			LoggerUtil.ibsJobDebug("Started loans allocation to Agent for selected records....");
			List<PigmyDepositVO> selectedDeposits = new ArrayList<PigmyDepositVO>();
			for (AgentAllocationsForDepositVO agentAllocationVo : getSelectedRecords()) {
				selectedDeposits.add(agentAllocationVo.getDeposit());
				
			}
			try {
				depositEnrichmentService.insertBulk(selectedDeposits, agent,
						loggedInUser);
				return "success";
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError("ServiceException while bulk agent allocation to deposit : MFI10001", e);
				return null;
			} catch (Exception e) {
				LoggerUtil.ibsJobError("Unhandled exception while bulk agent allocation to deposit : MFI10001", e);
	            MessageUtil.addMessage("MFI10001");
				return null;
			}
		}
		return null;
	}

	/**
	 * Listener to handle selection of a record in the table to open user record
	 * in read mode
	 * 
	 * @param event
	 */
	public void listSelect(SelectEvent event) {
		ConfigurableNavigationHandler nh = (ConfigurableNavigationHandler) FacesContext
				.getCurrentInstance().getApplication().getNavigationHandler();
		nh.performNavigation(getViewRecordUrl() + "?id="
				+ selectedRecord.getLoan().getId() + "&faces-redirect=true");
	}

	/**
	 * Checking records are selected or not.
	 * 
	 * If selected show dialog otherwise show message.
	 */
	public String showDialog() {
		RequestContext context = RequestContext.getCurrentInstance();

		if (!getSelectedRecords().isEmpty() && agent.getAgentId() != null) {
			bulkAllocateAgent();
			return "success";
		} else {
			MessageUtil.addMessage("MFI01302");
			LoggerUtil.ibsJobDebug("User has not selected the any agent for allocation : MFI01302");
			return null;
		}
	}

	public List<AgentVO> getAgents() {
		return agents;
	}

	public void setAgents(List<AgentVO> agents) {
		this.agents = agents;
	}

	public AgentVO getAgent() {
		return agent;
	}

	public void setAgent(AgentVO agent) {
		this.agent = agent;
	}

	public AuthController getAuthController() {
		return authController;
	}

	public void setAuthController(AuthController authController) {
		this.authController = authController;
	}

	public boolean isAssignAgentAllowed() {
		return authController.checkAuthority(ADD_AGENT_ALLOCATIONS);
	}

}
