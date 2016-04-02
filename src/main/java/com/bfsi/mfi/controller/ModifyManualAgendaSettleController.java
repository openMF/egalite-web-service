package com.bfsi.mfi.controller;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.entity.ModifyManualAgendaSettle;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.ModifyManualAgendaSettleService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.ModifyManualAgendaSettleVO;


@ManagedBean(name = "modifyManualAgendaSettleController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.MODIFY, name = "modifyManualAgendaSettle"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authModifyManualAgendaSettle"),
		@Permission(type = PermissionType.LIST, name = "listModifyManualAgendaSettle") })
public class ModifyManualAgendaSettleController extends MaintenanceController<ModifyManualAgendaSettleVO, ModifyManualAgendaSettle>{

	@ManagedProperty(value = "#{modifyManualAgendaSettleService}")
	private ModifyManualAgendaSettleService modifyManualAgendaSettleService;
	
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	private ModifyManualAgendaSettleVO existing = new ModifyManualAgendaSettleVO();
	private ModifyManualAgendaSettleVO modifyManualAgendaSettleVO = new ModifyManualAgendaSettleVO();

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	private String isactiveStatus;
	private List<ListValueVO> activeStatuss;
	private List<ListValueVO> fullPartIndicators;
	//private String autoRecId;
	
	private final String defaultActiveStatus = "Active";
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	
	@Override
	protected MaintenanceService<ModifyManualAgendaSettleVO, ModifyManualAgendaSettle> getMaintenanceService() {
		return modifyManualAgendaSettleService;
	}

	@Override
	public ModifyManualAgendaSettleVO getMaintenanceVO() {
		return modifyManualAgendaSettleVO;
	}


	public ModifyManualAgendaSettleService getModifyManualAgendaSettleService() {
		return modifyManualAgendaSettleService;
	}


	public void setModifyManualAgendaSettleService(
			ModifyManualAgendaSettleService modifyManualAgendaSettleService) {
		this.modifyManualAgendaSettleService = modifyManualAgendaSettleService;
	}


	public ListValueService getListservice() {
		return listservice;
	}


	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}


	public ModifyManualAgendaSettleVO getModifyManualAgendaSettleVO() {
		return modifyManualAgendaSettleVO;
	}


	public void setModifyManualAgendaSettleVO(
			ModifyManualAgendaSettleVO modifyManualAgendaSettleVO) {
		this.modifyManualAgendaSettleVO = modifyManualAgendaSettleVO;
	}


	public String getIsactiveStatus() {
		return isactiveStatus;
	}


	public void setIsactiveStatus(String isactiveStatus) {
		this.isactiveStatus = isactiveStatus;
	}


	public List<ListValueVO> getActiveStatuss() {
		return activeStatuss;
	}


	public void setActiveStatuss(List<ListValueVO> activeStatuss) {
		this.activeStatuss = activeStatuss;
	}


	public List<ListValueVO> getFullPartIndicators() {
		return fullPartIndicators;
	}


	public void setFullPartIndicators(List<ListValueVO> fullPartIndicators) {
		this.fullPartIndicators = fullPartIndicators;
	}


	public String getDefaultActiveStatus() {
		return defaultActiveStatus;
	}

	
	@PostConstruct
	public void init() {
		try {
			
			activeStatuss = listservice.get("isActive");
			//ListOfValuesUtil.addLocaleDescription(activeStatuss);
			
			fullPartIndicators  = listservice.get("fullPartInd");  //fullPartInd
			//ListOfValuesUtil.addLocaleDescription(fullPartIndicators);

			//autoRecId = manualAgendaSettleService.getAutoAgedaId();
			//manualAgendaSettleVO.setRecId(autoRecId); //add auto gen rec id..

		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading init listservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading init listservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}

	}
	
	
	public void loadManuAgdSet(){
		try {
			
			this.modifyManualAgendaSettleVO = modifyManualAgendaSettleService.get(modifyManualAgendaSettleVO.getId());
			//agencyCategory = listservice.getValue(manualAgendaSettleVO.getCategory(),ListValue.LIST_NAME_AGENCY_CATEGORY);
			//isactiveStatus= listservice.getValue(manualAgendaSettleVO.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS); //
			LoggerUtil.ibsJobDebug("Agenda id not Available: MFI00602");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading manual agenda: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading manual agenda view: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(modifyManualAgendaSettleVO);
		existing = (ModifyManualAgendaSettleVO) modifyManualAgendaSettleVO.clone();
	}
	
	public void loadAddManuAgdSet(){
		try {
			
			this.modifyManualAgendaSettleVO = modifyManualAgendaSettleService.get(modifyManualAgendaSettleVO.getId());
			
			//isactiveStatus= listservice.getValue(modifyManualAgendaSettleVO.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS); //
			
			//autoRecId = modifyManualAgendaSettleService.getAutoAgedaId();
			//modifyManualAgendaSettleVO.setRecId(autoRecId); 
			
			//modifyManualAgendaSettleVO.setIsActive(defaultActiveStatus); //set default to active
			
			LoggerUtil.ibsJobDebug("Agenda id not Available: MFI00602");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading manual agenda: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading manual agenda view: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(modifyManualAgendaSettleVO);
		existing = (ModifyManualAgendaSettleVO) modifyManualAgendaSettleVO.clone();
	}

	
	
	
	public String checkModifyForUpdate() {
		 Double a =modifyManualAgendaSettleVO.getAgnAgendaSettledAmt();
		 Double b =existing.getAgnAgendaSettledAmt();
		
		   if(modifyManualAgendaSettleVO.getId().equals(existing.getId())
				&& (0==a-b)
				&& modifyManualAgendaSettleVO.getFullPartInd().equals(existing.getFullPartInd())
			    && modifyManualAgendaSettleVO.getSettleRemarks().equals(existing.getSettleRemarks())
				&& modifyManualAgendaSettleVO.getIsActive().equals(existing.getIsActive())
				){
			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		}  else {
		   return super.update();
		}

		//return "success";
	
	}
	
	
	
	
}
