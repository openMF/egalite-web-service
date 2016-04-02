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
import com.bfsi.mfi.entity.LovBase;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.LovBaseService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.LovBaseVO;




@ManagedBean(name = "lovBaseController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addLovBase"),
		@Permission(type = PermissionType.MODIFY, name = "modifyLovBase"),
		@Permission(type = PermissionType.DELETE, name = "deleteLovBase"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authLovBase"),
		@Permission(type = PermissionType.LIST, name = "listLovBase") })
public class LovBaseController extends MaintenanceController<LovBaseVO, LovBase> {
	
	@ManagedProperty(value = "#{lovBaseService}")
	private LovBaseService lovBaseService;
	private LovBaseVO existing = new LovBaseVO();
	private LovBaseVO lovBaseVO = new LovBaseVO();

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	private String isStatusActive;
	
	 public String getIsStatusActive() {
		return isStatusActive;
	}
	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}



	private List<ListValueVO>  isTempActive;
	 @ManagedProperty(value = "#{listValueService}")
     private ListValueService listservice;
	 
	public ListValueService getListservice() {
		return listservice;
	}
	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}
	public List<ListValueVO> getIsTempActive() {
		return isTempActive;
	}
	public void setIsTempActive(List<ListValueVO> isTempActive) {
		this.isTempActive = isTempActive;
	}
	public LovBaseService getLovBaseService() {
		return lovBaseService;
	}
	public void setLovBaseService(LovBaseService lovBaseService) {
		this.lovBaseService = lovBaseService;
	}
	public LovBaseVO getLovBaseVO() {
		return lovBaseVO;
	}
	public void setLovBaseVO(LovBaseVO lovBaseVO) {
		this.lovBaseVO = lovBaseVO;
	}
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	@Override
	protected MaintenanceService<LovBaseVO, LovBase> getMaintenanceService() {
		return lovBaseService;
	}
	
	@Override
	public LovBaseVO getMaintenanceVO() {
		return lovBaseVO;
	}
	
	
	
	@PostConstruct
	public void init() {
		try {
			isTempActive = listservice.get("isActive");
			ListOfValuesUtil.addLocaleDescription(isTempActive);
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading init listservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading init listservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}

	}
	
	
	
	public void loadLov() {
		
		try {
			this.lovBaseVO = lovBaseService.get(lovBaseVO.getId());
			isStatusActive= listservice.getValue(lovBaseVO.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
			LoggerUtil.ibsJobDebug("LOV Base ID not Available: MFI00602");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading LOV Base: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading LOV Base : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(lovBaseVO);
		existing = (LovBaseVO) lovBaseVO.clone();
	}
	
	
	public String create() throws ServiceException {
		String lId;
		try {
			lId = validateLovId();

			if (lId.equals("success")) {
				super.create();
				result = "success";
			} else {
				result = "";
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while checking LOV ID : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return result;
	}
	
	// Validation for duplicate LOV ID.
		public String validateLovId() throws ServiceException {
			String id = lovBaseVO.getId();
			try {
				if (!lovBaseService.isLovIdAvailable(id)) {
					LoggerUtil.ibsJobDebug("loV id already exits: MFI00603");
					MessageUtil.addMessage("MFI30001");
					result = "failure";
				} else {

					result = "success";
				}
			}

			catch (ServiceException e) {
				LoggerUtil.ibsJobError(
						"Unexpected error while Checking userId: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
				result = "failure";
			}
			return result;
		}
	
	
	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = lovBaseService.deleteBaseLov(lovBaseVO.getId());
			LoggerUtil.ibsJobDebug("BaseLOV Record deleted successfully: "
					+ getMaintenanceVO().getId());
			MessageUtil.addMessage("MFI10011", getMaintenanceVO().getId());

			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while deleting record: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return result;
	}

	
	
	
	public String checkModifyForUpdate() {
		String agencycheckStatus;
		agencycheckStatus = validateLovStatus();

		if (lovBaseVO.getId().equals(existing.getId())
				&& lovBaseVO.getLovDesc().equals(existing.getLovDesc())
				&& lovBaseVO.getIsActive().equals(existing.getIsActive())
				){
																					
			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		} else if ((!agencycheckStatus.equals(OUTCOME_SUCCESS))
				&& (lovBaseVO.getIsActive().equalsIgnoreCase("I")))

		{
			LoggerUtil.ibsJobDebug("LOV record already in Active state: MFI00601");
			MessageUtil.addMessage("MFI00601");
			return null;
		} else {
			super.update();
		}

		return "success";
	}
	
	
	
	// For ModifyUniqueId
		public String validateLovStatus() {
			String id = lovBaseVO.getId().trim();
			try {
				if (lovBaseService.isLovStatustoInactive(id)) {
					result = "failure";
					LoggerUtil.ibsJobDebug("Invalid LOV validation ");
				} else {
					result = OUTCOME_SUCCESS;
				}
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError("Unhandled exception while validating LOV  status: MFI10001",e);
				MessageUtil.addMessage("MFI10001");
				result = OUTCOME_SUCCESS;
			}
			return result;
		}
	
	
	
	
}
