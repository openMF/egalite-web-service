package com.bfsi.mfi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.IbsResetAgenda;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.service.IbsResetAgendaService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.IbsResetAgendaVO;
import com.bfsi.mfi.vo.ListValueVO;


@ManagedBean(name = "ibsResetAgendaController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addIbsResetAgenda"),
		@Permission(type = PermissionType.MODIFY, name = "modifyIbsResetAgenda"),
		@Permission(type = PermissionType.DELETE, name = "deleteIbsResetAgenda"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authIbsResetAgenda"),
		@Permission(type = PermissionType.LIST, name = "listIbsResetAgenda") })
public class IbsResetAgendaController extends MaintenanceController<IbsResetAgendaVO, IbsResetAgenda>{

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	@ManagedProperty(value = "#{ibsResetAgendaService}")
	private IbsResetAgendaService ibsResetAgendaService;
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	@ManagedProperty(value = "#{agentService}")
	private AgentService agentService;
	private IbsResetAgendaVO existing = new IbsResetAgendaVO();
	private IbsResetAgendaVO ibsResetAgenda = new IbsResetAgendaVO();
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	
	private List<ListValueVO> activeStatuss;
	private List<ListValueVO> agendaOptions;
	private String autoGenCode;
	private List<AgentVO> agents;
	private String isActiveStatus;
	private String resetOpts;
	private String valForDrop = null;
	private String val = null;
	private String val2 = null;
	private String val4 = null;
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	public String getIsActiveStatus() {
		return isActiveStatus;
	}

	public void setIsActiveStatus(String isActiveStatus) {
		this.isActiveStatus = isActiveStatus;
	}

	public String getResetOpts() {
		return resetOpts;
	}

	public void setResetOpts(String resetOpts) {
		this.resetOpts = resetOpts;
	}

	public List<AgentVO> getAgents() {
		return agents;
	}

	public void setAgents(List<AgentVO> agents) {
		this.agents = agents;
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}


	public List<ListValueVO> getAgendaOptions() {
		//System.out.println("getting agenda options list");
		return agendaOptions;
	}


	public void setAgendaOptions(List<ListValueVO> agendaOptions) {
		this.agendaOptions = agendaOptions;
	}


	public List<ListValueVO> getActiveStatuss() {
		return activeStatuss;
	}

	public void setActiveStatuss(List<ListValueVO> activeStatuss) {
		this.activeStatuss = activeStatuss;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public IbsResetAgendaService getIbsResetAgendaService() {
		return ibsResetAgendaService;
	}

	public void setIbsResetAgendaService(IbsResetAgendaService ibsResetAgendaService) {
		this.ibsResetAgendaService = ibsResetAgendaService;
	}

	public IbsResetAgendaVO getIbsResetAgenda() {
		return ibsResetAgenda;
	}

	public void setIbsResetAgenda(IbsResetAgendaVO ibsResetAgenda) {
		
		this.ibsResetAgenda = ibsResetAgenda;
	}

	@Override
	protected MaintenanceService<IbsResetAgendaVO, IbsResetAgenda> getMaintenanceService() {
		return ibsResetAgendaService;
	}

	@Override
	public IbsResetAgendaVO getMaintenanceVO() {
		return ibsResetAgenda;
	}
     
	
	@PostConstruct
	public void init() {
		try {

			autoGenCode = ibsResetAgendaService.getAutoGenCode();
			ibsResetAgenda.setId(autoGenCode);
			
			activeStatuss = listservice.get("isActive");
			//ListOfValuesUtil.addLocaleDescription(activeStatuss);
			
			agendaOptions = listservice.get("resetOptAgenda");
			
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading init listservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading init listservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}

	}
	
	
	public boolean isOptAgtsDisable(){
	    if((this.ibsResetAgenda.getResetOption()==null))
	        return true;
	    else if((this.ibsResetAgenda.getResetOption().trim().equalsIgnoreCase("1")) || (this.ibsResetAgenda.getResetOption().trim().equalsIgnoreCase("3")))
			return false;
		else
		    return true;
	    }
	 
	
	public boolean isModifyOptAgtsDisable(){
	    if((getMaintenanceVO().getResetOption()==null))
	        return true;
	    else if((getMaintenanceVO().getResetOption().trim().equalsIgnoreCase("1")) || (getMaintenanceVO().getResetOption().trim().equalsIgnoreCase("3"))){
	    	val = "1";
	    	valForDrop ="3";
	    	return false;
	    }
	    else{
	    	val = "1";
	    	return true;}
	    }
	
	
	
	public void updateAgents(){
		//if((this.ibsResetAgenda.getResetOption().equalsIgnoreCase("1")) || (this.ibsResetAgenda.getResetOption().equalsIgnoreCase("3"))){//
		try{
			 agents = agentService.getAuthAgentHavCreditOfficer();
		}catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading geting  list agents : MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while geting  list agents: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		 }
	  //}//
	}
	
	
	public String createAgenda() throws ServiceException {
		
		try {
				super.create();
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while creating Agency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return result;
	}
	
	public void loadResetAgenda(){
		
		try {
			this.ibsResetAgenda = ibsResetAgendaService.get(ibsResetAgenda.getId());
			resetOpts = listservice.getValue(ibsResetAgenda.getResetOption(),ListValue.LIST_NAME_AGENDA_OPTIONS);
			isActiveStatus = listservice.getValue(ibsResetAgenda.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
			LoggerUtil.ibsJobDebug("Reset Agenda Id not Available: MFI00602"); //message need to add
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading Agency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading Agency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(ibsResetAgenda);
		existing = (IbsResetAgendaVO) ibsResetAgenda.clone();
	}
	
	//FOR MODIFY LOAD
    public void loadResetAgendaModify(){
	
    if(val == null)
    {
    	
    	try {
			this.ibsResetAgenda = ibsResetAgendaService.getModify(ibsResetAgenda.getId());
			resetOpts = listservice.getValue(ibsResetAgenda.getResetOption(),ListValue.LIST_NAME_AGENDA_OPTIONS);
			isActiveStatus = listservice.getValue(ibsResetAgenda.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
			LoggerUtil.ibsJobDebug("Reset Agenda Id not Available: MFI00602"); //message need to add
			agents = agentService.getAuthAgentHavCreditOfficer(); //ADD FOR MODIFY
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading Agency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading Agency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(ibsResetAgenda);
		existing = (IbsResetAgendaVO) ibsResetAgenda.clone();
		
     
     }
    }
    
    
	
	// For delete Operation with Authorize check
		public String deleteUnAuthorized() throws ServiceException {
			try {
				result = ibsResetAgendaService.deleteAgenda(ibsResetAgenda.getId());
				LoggerUtil.ibsJobDebug("Agenda Record deleted successfully: "
						+ getMaintenanceVO().getId());
				MessageUtil.addMessage("MFI10011", getMaintenanceVO().getId());//message need to change

				return OUTCOME_SUCCESS;
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError(
						"Unhandled exception while deleting record: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
			}
			return result;
		}
	
		//modify validtions and if change done then modify
		public String checkModifyForUpdate(){
			if (ibsResetAgenda.getId().equals(existing.getId())
					&& ibsResetAgenda.getResetOption().equals(existing.getResetOption())
					&& ibsResetAgenda.getAgentId().equals(existing.getAgentId())
					&& ibsResetAgenda.getResetRemarks().equals(existing.getResetRemarks())
					&& ibsResetAgenda.getIsActive().equals(existing.getIsActive())
					&& ibsResetAgenda.getProcessStatus().equals(existing.getProcessStatus()))/* EGA-MN15-000007 Processing Status Column added*/
				{
																						
				LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
				MessageUtil.addMessage("MFI01203");
				return null;
			} /*else if ((!agencycheckStatus.equals(OUTCOME_SUCCESS))
					&& (agency.getIsActive().equalsIgnoreCase("I")))

			{
				LoggerUtil.ibsJobDebug("Agency already Active with Agent: MFI00601");
				MessageUtil.addMessage("MFI00601");
				return null;
			} */else {
				if (ibsResetAgenda.getResetOption().equalsIgnoreCase("2") || ibsResetAgenda.getResetOption().equalsIgnoreCase("4"))
				{
					ibsResetAgenda.setAgentId(null);
					super.update();
				}
				else{
					super.update();
				}
			}

			return "success";
		}
		
		
		// For ModifyUniqueId
		/*public String validateAgencyStatus() {
			String agencyId = agency.getId().trim();
			try {
				if (agencyService.isAgencyStatustoInactive(agencyId)) {
					result = "failure";
					LoggerUtil.ibsJobDebug("Invalid Agency validation ");
				} else {
					result = OUTCOME_SUCCESS;
				}
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError("Unhandled exception while validating Agency status: MFI10001",e);
				MessageUtil.addMessage("MFI10001");
				result = OUTCOME_SUCCESS;
			}
			return result;
		}*/
}
