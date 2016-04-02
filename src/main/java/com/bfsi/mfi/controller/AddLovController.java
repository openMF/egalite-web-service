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
import com.bfsi.mfi.entity.LovDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.LovBaseService;
import com.bfsi.mfi.service.LovDetailService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.LovBaseVO;
import com.bfsi.mfi.vo.LovVO;


@ManagedBean(name = "addLovController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addListToLov"),
		@Permission(type = PermissionType.MODIFY, name = "modifyListToLov"),
		@Permission(type = PermissionType.DELETE, name = "deleteListToLov"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authListToLov"),
		@Permission(type = PermissionType.LIST, name = "listLovAddition") })
public class AddLovController extends MaintenanceController<LovVO, LovDetail>{
    
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{lovDetailService}")
	private LovDetailService lovDetailService;
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	@ManagedProperty(value = "#{lovBaseService}")
	private LovBaseService lovBaseService;
	
	private LovVO existing = new LovVO();
	private LovVO lovVo = new LovVO();
	private List<LovBaseVO> lovIds;
    private List<ListValueVO>  isTempActive;
    private int tempIntrValue;
    private String  isStatusActive;

	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	@Override
	protected LovDetailService getMaintenanceService() {
		return lovDetailService;
	}

	@Override
	public LovVO getMaintenanceVO() {
		//System.out.println("ID===="+lovVo.getId());
		
		//String value = String.valueOf(tempIntrValue);
		//this.lovVo.setIntrValue(value);
		//this.lovVo.setOrderBy(tempIntrValue);
		//this.lovVo.setId(this.lovVo.getLovId()+this.lovVo.getIntrValue());
		return lovVo;
	}

	public LovDetailService getLovDetailService() {
		return lovDetailService;
	}

	public void setLovDetailService(LovDetailService lovDetailService) {
		this.lovDetailService = lovDetailService;
	}

	public LovBaseService getLovBaseService() {
		return lovBaseService;
	}

	public void setLovBaseService(LovBaseService lovBaseService) {
		this.lovBaseService = lovBaseService;
	}

	public LovVO getLovVo() {
		return lovVo;
	}

	public void setLovVo(LovVO lovVo) {
		this.lovVo = lovVo;
	}
	
	public List<LovBaseVO> getLovIds() {
		return lovIds;
	}

	public void setLovIds(List<LovBaseVO> lovIds) {
		this.lovIds = lovIds;
	}

	public List<ListValueVO> getIsTempActive() {
		return isTempActive;
	}

	public void setIsTempActive(List<ListValueVO> isTempActive) {
		this.isTempActive = isTempActive;
	}

	public int getTempIntrValue() {
		tempIntrValue=lovDetailService.getInterValue(this.lovVo.getLovId())+1;
		return tempIntrValue;
	}

	public void setTempIntrValue(int tempIntrValue) {
		this.tempIntrValue = tempIntrValue;
	}

	@PostConstruct
	public void init() {
		try {
			isTempActive = listservice.get("isActive");
			ListOfValuesUtil.addLocaleDescription(isTempActive);

			lovIds = lovBaseService.get();
			//tempIntrValue=lovDetailService.getInterValue(this.lovVo.getLovId())+1;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading init listservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading init listservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}

	}
	
	
	
	public void loadAddLov() {
		
		try {
			//System.out.println("DISPLAY id============="+lovVo.getId());
			
			this.lovVo = lovDetailService.get(lovVo.getId());
			isStatusActive= listservice.getValue(lovVo.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
			LoggerUtil.ibsJobDebug("Load Lov add controller base on lovid : "+lovVo.getId() +" : MFI10001");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while get lov details : MFI10001"+lovVo.getId(), e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while get lov base on : lovId="+lovVo.getId()+ " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		
		existing = (LovVO) lovVo.clone();
		loadAndShowAuditTrail(lovVo);
	}

	
	// For delete Operation with Authorize check
		public String deleteUnAuthorized() throws ServiceException {
			try {
				result = lovDetailService.deleteUnAuthorized(lovVo.getId());//
				LoggerUtil.ibsJobDebug("Agency Record deleted successfully: "
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
	
		
		
		public String create() {
			LoggerUtil.ibsJobDebug("creating new record for controller : "
					+ this.getClass().getName());
			
			String value = String.valueOf(tempIntrValue);
			this.lovVo.setIntrValue(value);
			this.lovVo.setOrderBy(tempIntrValue);
			
			try {
				lovDetailService.createInfo(lovVo);
				MessageUtil.addMessage("MFI10008", getIdForMessage());
				return OUTCOME_SUCCESS;
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError(
						"ServiceException while creating record: controller: "
								+ this.getClass().getName() + " : MFI10014", e);
				MessageUtil.addMessage("MFI10014");
			} catch (Exception e) {
				LoggerUtil.ibsJobError(
						"unhandled exception while creating record: controller: "
								+ this.getClass().getName() + " : MFI10014", e);
				MessageUtil.addMessage("MFI10014");
			}
			return null;
		}
		
		@Override
		protected String getIdForMessage() {
			return "LovID: "+lovVo.getLovId()+" InternalValue: "+lovVo.getIntrValue() ;
		}
		
	
	
	public String checkModifyForUpdate() {
		String lovcheckStatus;
		lovcheckStatus = validateLovStatus();

		if (lovVo.getId().equals(existing.getId())
				&& lovVo.getLovDesc().equals(existing.getLovDesc())
				&& lovVo.getLovId().equals(existing.getLovId())
				&& lovVo.getIntrValue().equals(existing.getIntrValue())
				&& lovVo.getDisplayValue().equals(existing.getDisplayValue())
				&& lovVo.getOrderBy()==(existing.getOrderBy())
				&& lovVo.getAuthStatus().equals(existing.getAuthStatus())
				&& lovVo.getIsActive().equals(existing.getIsActive())){
																					
			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		} else if ((!lovcheckStatus.equals(OUTCOME_SUCCESS))
				&& (lovVo.getIsActive().equalsIgnoreCase("I")))

		{
			LoggerUtil.ibsJobDebug("LoV Record already in Active  state : MFI00601");
			MessageUtil.addMessage("MFI00601");
			return null;
		} else {
			super.update();
		}

		return "success";
	}

	
	
	// For ModifyUniqueId
		public String validateLovStatus() {
			String idd = lovVo.getId().trim();
			try {
				if (lovDetailService.isLovStatustoInactive(idd)) {
					result = "failure";
					LoggerUtil.ibsJobDebug("Invalid Lov record validation ");
				} else {
					result = OUTCOME_SUCCESS;
				}
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError("Unhandled exception while validating lov record status: MFI10001",e);
				MessageUtil.addMessage("MFI10001");
				result = OUTCOME_SUCCESS;
			}
			return result;
		}
	
}
