package com.bfsi.mfi.controller;

/**
 * @className : AgentAllocationListController.java
 * @description : Class for Lists of LoanEnrichment with Assign- Agent Name for view to the User.
 * @author : Jyoti Ranjan Nayak
 */

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
import com.bfsi.mfi.service.LoanEnrichmentService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgentAllocationsVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.LoanVO;

@ManagedBean(name = "agentAllocationsListController")
@ViewScoped
public class AgentAllocationListController extends
		CommonListController<AgentAllocationsVO> {

	private static final String ADD_AGENT_ALLOCATIONS = "addAgentAllocations";
	private static final String LIST_AGENT_ALLOCATIONS = "listLoanAccounts"; //"listAgentAllocations";
	
	private static final String VIEWID_AGENT_BULK_ALLOC = "/loanadmin/bulkAgentAllocations.xhtml";  
	private static final String VIEWID_AGEN_ALLOC = "/loanadmin/agentAllocation.xhtml";  
	@ManagedProperty(value = "#{loanEnrichmentService}")
	private LoanEnrichmentService loanEnrichmentService;
	@ManagedProperty(value = "#{agentService}")
	private AgentService agentService;
	@ManagedProperty(value = "#{auth}")
	protected AuthController authController;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<AgentVO> agents = new ArrayList<AgentVO>();
	private AgentVO agent = new AgentVO();
	private UserDetails userDetails;

	protected String getViewRecordUrl() {
		return "../loanadmin/viewLoanAccount.xhtml";
	}

	public LoanEnrichmentService getLoanEnrichmentService() {
		return loanEnrichmentService;
	}

	public void setLoanEnrichmentService(
			LoanEnrichmentService loanEnrichmentService) {
		this.loanEnrichmentService = loanEnrichmentService;
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	/*
	 * Load loan details from load table and agent name from agent table when
	 * screen load.
	 * 
	 * Get agent FirstNames for drop-down.
	 */
	@PostConstruct
	public void load() {
		userDetails = authController.getUserDetails();// getUserDetails();
		String viewId = FacesContext.getCurrentInstance().getViewRoot()
				.getViewId();
		try {
			agents = agentService.getAuthAgentHavCreditOfficer();
			LoggerUtil.ibsJobDebug("Load loans for allocating loans to agents : ");
			
			if (viewId.equalsIgnoreCase(VIEWID_AGEN_ALLOC)
					|| viewId.equalsIgnoreCase(VIEWID_AGENT_BULK_ALLOC)) {
				setRecords(loanEnrichmentService.getUnassigned());
			} else {
				setRecords(loanEnrichmentService.get());
			}
		} catch (ServiceException e) {
			 LoggerUtil.ibsJobError("ServiceException while load loans for allocating to agents: MFI10001", e);
             MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while load loans for allocating : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}

	public String allocateAgent() {
		String loggedInUser = userDetails.getUsername();
		Date date = new Date();

		if (getRecords() != null) {
			List<AgentAllocationsVO> allocVos = new ArrayList<AgentAllocationsVO>();
			for (AgentAllocationsVO allocVo : getRecords()) {
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
					loanEnrichmentService.insert(allocVos);
					LoggerUtil.ibsJobDebug("updating individual wise agentId on loan entity :");
					return "success";
				} catch (ServiceException e) {
					LoggerUtil.ibsJobError("ServiceException while updating agentId on loan entity : MFI10001", e);
                    MessageUtil.addMessage("MFI10001");
				} catch (Exception e) {
					 LoggerUtil.ibsJobError("Unhandled exception while updating agentId on loan entity: MFI10001", e);
                     MessageUtil.addMessage("MFI10001");
				}
			} else {
				/*MessageUtil.addErrorMessageWithoutKey("Select Agent",
						"Select agent to assign");*/
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
		// System.out.println("***"+loggedInUser);

		if (getSelectedRecords() != null) {
			List<LoanVO> selectedLoans = new ArrayList<LoanVO>();
			for (AgentAllocationsVO agentAllocationVo : getSelectedRecords()) {
				selectedLoans.add(agentAllocationVo.getLoan());
			}
			try {
				loanEnrichmentService.insertBulk(selectedLoans, agent,
						loggedInUser);
				LoggerUtil.ibsJobDebug("updating bulk wise agentId on loan entity :");
				return "success";
			} catch (ServiceException e) {
				 LoggerUtil.ibsJobError("ServiceException while updating bulk wise agentId on loan entity : MFI10001", e);
                 MessageUtil.addMessage("MFI10001");
				return null;
			} catch (Exception e) {
				 LoggerUtil.ibsJobError("Unhandled exception while updating bulk wise agentId on loan entity: MFI10001", e);
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
			/*MessageUtil.addErrorMessageWithoutKey("Select Bulk Agent :",
					"CheckBox or Agent is not selected");*/
			 MessageUtil.addMessage("MFI00600");
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
