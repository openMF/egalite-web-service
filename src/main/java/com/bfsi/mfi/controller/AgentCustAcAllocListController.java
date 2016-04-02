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
import com.bfsi.mfi.service.CustAcEnrichmentService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CustAcEnrichmentVO;


@ManagedBean(name = "agentCustAcAllocListController")
@ViewScoped
public class AgentCustAcAllocListController extends
                               CommonListController<CustAcEnrichmentVO>{
	
	private static final String ADD_AGENT_ALLOCATIONS = "agentAllocationsCasa";
	private static final String LIST_AGENT_ALLOCATIONS = "listCustAcDetails"; 
	
	private static final String VIEWID_AGENT_BULK_ALLOC = "/casaadmin/bulkAgentAllocations.xhtml";  
	private static final String VIEWID_AGEN_ALLOC = "/casaadmin/agentAllocation.xhtml";  
	
	@ManagedProperty(value = "#{custAcEnrichmentService}")
	private CustAcEnrichmentService custAcEnrichmentService;
	@ManagedProperty(value = "#{agentService}")
	private AgentService agentService;
	@ManagedProperty(value = "#{auth}")
	protected AuthController authController;
	
	private CustAcEnrichmentVO custAcEnrichmentVO;
	

	public CustAcEnrichmentVO getCustAcEnrichmentVO() {
		return custAcEnrichmentVO;
	}

	public void setCustAcEnrichmentVO(CustAcEnrichmentVO custAcEnrichmentVO) {
		this.custAcEnrichmentVO = custAcEnrichmentVO;
	}

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<AgentVO> agents = new ArrayList<AgentVO>();
	private AgentVO agent = new AgentVO();
	private UserDetails userDetails;

	protected String getViewRecordUrl() {
		return "../casaadmin/viewCustAcDetails.xhtml";
	}
	
	public CustAcEnrichmentService getCustAcEnrichmentService() {
		return custAcEnrichmentService;
	}

	public void setCustAcEnrichmentService(
			CustAcEnrichmentService custAcEnrichmentService) {
		this.custAcEnrichmentService = custAcEnrichmentService;
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	public AuthController getAuthController() {
		return authController;
	}

	public void setAuthController(AuthController authController) {
		this.authController = authController;
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

	public boolean isAssignAgentAllowed() {
		return authController.checkAuthority(ADD_AGENT_ALLOCATIONS);
	}
	
	
	/*
	 * Load Customer Account details from load table and agent name from agent table when
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
			LoggerUtil.ibsJobDebug("Load Customer A/C for allocating customer A/C to agents : ");
			
			if (viewId.equalsIgnoreCase(VIEWID_AGEN_ALLOC)
					|| viewId.equalsIgnoreCase(VIEWID_AGENT_BULK_ALLOC)) {
				setRecords(custAcEnrichmentService.getUnassigned());
			} else {
				setRecords(custAcEnrichmentService.get());
			}
		} catch (ServiceException e) {
			 LoggerUtil.ibsJobError("ServiceException while load customer A/c for allocating to agents: MFI10001", e);
             MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while load customer A/c for allocating : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}

	public String allocateAgent() {
		String loggedInUser = userDetails.getUsername();
		Date date = new Date();

		if (getRecords() != null) {
			List<CustAcEnrichmentVO> allocVos = new ArrayList<CustAcEnrichmentVO>();
			for (CustAcEnrichmentVO allocVo : getRecords()) {
				if (("".equals(allocVo.getAgent().getAgentId()) || (allocVo.getAgent().getAgentId() == null))) {
					// no agent is allocated, continue
					continue;
				}
				// seting login user and timestamp.
				allocVo.setAllocationBy(loggedInUser);
				allocVo.setAllocationTime(new Timestamp(date.getTime()));
				allocVos.add(allocVo);
			}

			if (allocVos.size() > 0) {
				try {
					custAcEnrichmentService.insert(allocVos);
					LoggerUtil.ibsJobDebug("updating individual wise agentId on CustomerAC enrichment entity :");
					return "success";
				} catch (ServiceException e) {
					LoggerUtil.ibsJobError("ServiceException while updating agentId on CustomerAC enrichment entity : MFI10001", e);
                    MessageUtil.addMessage("MFI10001");
				} catch (Exception e) {
					 LoggerUtil.ibsJobError("Unhandled exception while updating agentId on CustomerAC enrichment entity: MFI10001", e);
                     MessageUtil.addMessage("MFI10001");
				}
			} else {
			    MessageUtil.addMessage("MFI01301");
				return null;
			}
		}
		return null;
	}

	/**
	 * Bulk Customer A/C are allocated to Agent for selected records.
	 */
	public String bulkAllocateAgent() {
		String loggedInUser = userDetails.getUsername();
		// System.out.println("***"+loggedInUser);

		if (getSelectedRecords() != null) {
			List<CustAcEnrichmentVO> selectedCustAcs = new ArrayList<CustAcEnrichmentVO>();
			for (CustAcEnrichmentVO agentAllocationVo : getSelectedRecords()) {
				selectedCustAcs.add(agentAllocationVo);
			}
			try {
				custAcEnrichmentService.insertBulk(selectedCustAcs, agent,
						loggedInUser);
				LoggerUtil.ibsJobDebug("updating bulk wise agentId on loan entity :");
				return "success";
			} catch (ServiceException e) {
				 LoggerUtil.ibsJobError("ServiceException while updating bulk wise agentId on customer A/c enrich entity : MFI10001", e);
                 MessageUtil.addMessage("MFI10001");
				return null;
			} catch (Exception e) {
				 LoggerUtil.ibsJobError("Unhandled exception while updating bulk wise agentId on customer A/c enrich entity: MFI10001", e);
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
				+ selectedRecord.getId() + "&faces-redirect=true");
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
			 MessageUtil.addMessage("MFI00600");
			return null;
		}
	}
}
