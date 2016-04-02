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
import com.bfsi.mfi.entity.ManualAgendaSettle;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.ManualAgendaSettleService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.ManualAgendaSettleVO;


@ManagedBean(name = "manualAgendaSettleController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addManualAgendaSettle"),
		@Permission(type = PermissionType.LIST, name = "listManualAgendaSettle") })
public class ManualAgendaSettleController extends MaintenanceController<ManualAgendaSettleVO, ManualAgendaSettle>{

	@ManagedProperty(value = "#{manualAgendaSettleService}")
	private ManualAgendaSettleService manualAgendaSettleService;
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	private ManualAgendaSettleVO existing = new ManualAgendaSettleVO();
	private ManualAgendaSettleVO manualAgendaSettleVO = new ManualAgendaSettleVO();

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	private String isactiveStatus;
	private List<ListValueVO> activeStatuss;
	private List<ListValueVO> fullPartIndicators;
	private String autoRecId;
	
	private final String defaultActiveStatus = "Active";
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	public String getDefaultActiveStatus() {
		return defaultActiveStatus;
	}

	public List<ListValueVO> getFullPartIndicators() {
		return fullPartIndicators;
	}

	public void setFullPartIndicators(List<ListValueVO> fullPartIndicators) {
		this.fullPartIndicators = fullPartIndicators;
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

	public String getIsactiveStatus() {
		return isactiveStatus;
	}

	public void setIsactiveStatus(String isactiveStatus) {
		this.isactiveStatus = isactiveStatus;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public ManualAgendaSettleService getManualAgendaSettleService() {
		return manualAgendaSettleService;
	}

	public void setManualAgendaSettleService(
			ManualAgendaSettleService manualAgendaSettleService) {
		this.manualAgendaSettleService = manualAgendaSettleService;
	}

	public ManualAgendaSettleVO getManualAgendaSettleVO() {
		return manualAgendaSettleVO;
	}

	public void setManualAgendaSettleVO(ManualAgendaSettleVO manualAgendaSettleVO) {
		this.manualAgendaSettleVO = manualAgendaSettleVO;
	}

	@Override
	protected MaintenanceService<ManualAgendaSettleVO, ManualAgendaSettle> getMaintenanceService() {
		return manualAgendaSettleService;
	}

	@Override
	public ManualAgendaSettleVO getMaintenanceVO() {
		return manualAgendaSettleVO;
	}

	
	
	@PostConstruct
	public void init() {
		try {
			
			//activeStatuss = listservice.get("isActive");
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
			
			this.manualAgendaSettleVO = manualAgendaSettleService.get(manualAgendaSettleVO.getAgendaId());
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
		loadAndShowAuditTrail(manualAgendaSettleVO);
		existing = (ManualAgendaSettleVO) manualAgendaSettleVO.clone();
	}

	public void loadAddManuAgdSet(){
		try {
			
			this.manualAgendaSettleVO = manualAgendaSettleService.get(manualAgendaSettleVO.getAgendaId());
			
			//isactiveStatus= listservice.getValue(manualAgendaSettleVO.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS); //
			
			autoRecId = manualAgendaSettleService.getAutoAgedaId();
			manualAgendaSettleVO.setRecId(autoRecId); 
			
			manualAgendaSettleVO.setIsActive(defaultActiveStatus); //set default to active
			
			//String tempId=manualAgendaSettleVO.getRecId();//
			//String tempAgendaId=manualAgendaSettleVO.getId();//
			
			//manualAgendaSettleVO.setId(tempId);//id
			//manualAgendaSettleVO.setAgendaId(tempAgendaId);// agendaId
			
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
		loadAndShowAuditTrail(manualAgendaSettleVO);
		existing = (ManualAgendaSettleVO) manualAgendaSettleVO.clone();
	}

	
	
	public  String  createManuAgendaSet(){
		  return super.create();
	}
	
	
	
}
