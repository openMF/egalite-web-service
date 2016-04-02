package com.bfsi.mfi.controller;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.CenterCodes;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsCodesService;
import com.bfsi.mfi.service.CenterCodeService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.LocationService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.CenterCodesVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.LocationVO;

@ManagedBean(name = "centerCodeController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addCenterCode"),
		@Permission(type = PermissionType.MODIFY, name = "modifyCenterCode"),
		@Permission(type = PermissionType.DELETE, name = "deleteCenterCode"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authCenterCode"),
		@Permission(type = PermissionType.LIST, name = "listCenterCode") })
public class CenterCodeController extends
		MaintenanceController<CenterCodesVO, CenterCodes> {

	@ManagedProperty(value = "#{centerCodeService}")
	private CenterCodeService centerCodeService;
	private CenterCodesVO existing = new CenterCodesVO();
	private CenterCodesVO centerCodes = new CenterCodesVO();
	private List<AgencyVO> countryCodes;
	private List<LocationVO> locationCodes;
	private String autoCenterCode, isStatusActive;
	private List<CbsCodesVO> cbsBranchCodes;
	private List<CbsCodesVO> cbsCenterCodes;
	private List<CbsCodesVO> cbsCenterCodesUpdate;
	
	boolean isCoRequired = true;
	boolean isLocRequired = true;
	private String countryName;
	
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	private String[] selectedConsoles;


	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	private List<ListValueVO> centerCodeStatuss;

	@ManagedProperty(value = "#{locationService}")
	private LocationService locationService;
	
	/*Tag No: EGA-MN15-000003  Starts*/
	private List<CenterCodesVO> districts;
	private List<CenterCodesVO> citys;
	private List<CenterCodesVO> states;
	
	/*Tag No: EGA-MN15-000003  Ends*/

	@PostConstruct
	public void init() {
		try {
			centerCodeStatuss = listservice.get("isActive");
			ListOfValuesUtil.addLocaleDescription(centerCodeStatuss);
			// cbsCenterCodes = cbsCodesService.getCbsCenterCodes();
			cbsBranchCodes = cbsCodesService.getCbsBranchCodes();
			countryCodes = centerCodeService.getcountryCodes();
			cbsCenterCodes = centerCodeService.getCbsCenterCode();
			/* EGALITE-45 start */
			autoCenterCode = centerCodeService.getAutoCenterCode();
			centerCodes.setId(autoCenterCode);
			/* EGALITE-45 end */
			//locationCodes = locationService.getlocationCodes();
			locationCodes = centerCodeService.getlocationCodes();
			
			/*Tag No: EGA-MN15-000004 Start*/
			districts = centerCodeService.getdistricts();
			citys = centerCodeService.getcitys();
			states = centerCodeService.getstates();
			/*Tag No: EGA-MN15-000004 Ends*/
			
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading init listservice: MFI10001",	e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading init listservice: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	public String checkModifyForUpdate() {

		if (centerCodes.getCenterCode().equals(existing.getCenterCode())
				&& centerCodes.getCbsCenterCode().equals(
						existing.getCbsCenterCode())
				&& centerCodes.getIbsLocationCode().equals(
						existing.getIbsLocationCode())
				&& centerCodes.getCenterCodeDesc().equals(
						existing.getCenterCodeDesc())
				&& centerCodes.getCbsBranchCode().equals(
						existing.getCbsBranchCode())
				&& centerCodes.getContactNumber().equals(
						existing.getContactNumber())
				&& centerCodes.getOnSunday() == (existing.getOnSunday())
				&& centerCodes.getOnMonday() == (existing.getOnMonday())
				&& centerCodes.getOnTuesday() == (existing.getOnTuesday())
				&& centerCodes.getOnWednesday() == (existing.getOnWednesday())
				&& centerCodes.getOnThursday() == (existing.getOnThursday())
				&& centerCodes.getOnFriday() == (existing.getOnFriday())
				&& centerCodes.getOnSaturday() == (existing.getOnSaturday())
				&& centerCodes.getAddressLine1().equals(
						existing.getAddressLine1())
				&& centerCodes.getAddressLine2().equals(
						existing.getAddressLine2())
				&& centerCodes.getAddressLine3().equals(
						existing.getAddressLine3())
				&& centerCodes.getAddressLine4().equals(
						existing.getAddressLine4())
				&& centerCodes.getZipCode().equals(existing.getZipCode())
				&& centerCodes.getCity().equals(existing.getCity())
				&& centerCodes.getState().equals(existing.getState())
				&& centerCodes.getCountry().equals(existing.getCountry())
				&& centerCodes.getIsActive().equals(existing.getIsActive())) {

			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		} else if("success".equalsIgnoreCase(validateCenterCodeModify())){
			super.update(); // Tag No: EGA-MN15-000004
		}
		else
		{
			return null;
		}

		return "success";
	}

	public void loadCenterCode() {
		CenterCodesVO centerCodesVO = new CenterCodesVO();
		centerCodesVO.setCenterCode(centerCodes.getCenterCode());

		try {
			this.centerCodes = centerCodeService.get(centerCodes
					.getCenterCode());
			isStatusActive = listservice.getValue(centerCodes.getIsActive(),
					ListValue.LIST_NAME_AGENT_STATUS);
			countryName = listservice.getValue(centerCodes.getCountry(),
					ListValue.LIST_NAME_COUNTRY_NAME);
			cbsCenterCodesUpdate = centerCodeService.getCbsCenterCode();
			if (centerCodes.getCbsCenterCode() != null
					&& centerCodes.getCbsCenterCode().trim().length() > 0) {
				for (CbsCodesVO cbsVo : cbsCenterCodes) {
					if (cbsVo != null
							&& centerCodes.getCbsCenterCode().equals(
									cbsVo.getDlValue())) {
						isCoRequired = false;
					} else {
						isCoRequired = true;
					}
				}
				if (isCoRequired) {
					CbsCodesVO cbsCodeVo = new CbsCodesVO();
					cbsCodeVo.setDlValue(centerCodes.getCbsCenterCode());
					cbsCenterCodes.add(cbsCodeVo);
				}
			}
			
			if(centerCodes.getIbsLocationCode()!= null && centerCodes.getIbsLocationCode().trim().length() >0)
			{
				for(LocationVO locVo:locationCodes)
				{
					if(locVo != null && centerCodes.getIbsLocationCode().equals(locVo.getLocationCode()))  {
						isLocRequired=false;
					  }
					else {
						isLocRequired=true;
					}
				}
				if(isLocRequired)  {
					LocationVO locVo = new LocationVO();
					locVo.setLocationCode(centerCodes.getIbsLocationCode());
					locationCodes.add(locVo);
				  }
			}
			LoggerUtil.ibsJobDebug("Route Code not Available: MFI10001");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading Route Code: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading Route Code: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(centerCodes);
		existing = (CenterCodesVO) centerCodes.clone();
	}

	// For delete Operation with Authorize check
	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = centerCodeService.deleteCenter(centerCodes.getId());
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
		
	public String validateCenterCode() throws ServiceException {
		String centerCode = centerCodes.getCbsCenterCode();
		try {
			if (!centerCodeService.isCenterCodeAvailable(centerCode)) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, msg
								.getString("centerMgmt.msg.routeCodeExists"),
								null));
				result = "failure";
			} else {

				result = "success";
			}
		}

		catch (ServiceException e) {
			logger.error(
					"Unexpected error while Checking Center Code = "
							+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
			result = "failure";
		}
		return result;
	}
	
	public String createCenterCode() throws ServiceException {
		String CenterCodeCheck;
		try {
			CenterCodeCheck = validateCenterCode();
			if (CenterCodeCheck.equals("success")) {
				super.create();
				result = "success";
			} else {
				result = "";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String validateCenterCodeModify() throws ServiceException {
		String centerCode = centerCodes.getCbsCenterCode();
		try {
			if (!centerCodeService.isCenterCodeAvailable(centerCode) &&
					(!(centerCodes.getCbsCenterCode().equals(
							existing.getCbsCenterCode())))) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, msg
								.getString("centerMgmt.msg.routeCodeExists"),
								null));
				result = "failure";
			} else {

				result = "success";
			}
		}

		catch (ServiceException e) {
			logger.error(
					"Unexpected error while Checking Center Code = "
							+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
			result = "failure";
		}
		return result;
	}
	/*Tag No: EGA-MN15-000004 End*/
	
	public List<CenterCodesVO> getDistricts() {
		return districts;
	}

	public void setDistricts(List<CenterCodesVO> districts) {
		this.districts = districts;
	}

	public List<CenterCodesVO> getCitys() {
		return citys;
	}

	public void setCitys(List<CenterCodesVO> citys) {
		this.citys = citys;
	}

	public List<CenterCodesVO> getStates() {
		return states;
	}

	public void setStates(List<CenterCodesVO> states) {
		this.states = states;
	}

	public List<CbsCodesVO> getCbsCenterCodesUpdate() {
		return cbsCenterCodesUpdate;
	}

	public void setCbsCenterCodesUpdate(List<CbsCodesVO> cbsCenterCodesUpdate) {
		this.cbsCenterCodesUpdate = cbsCenterCodesUpdate;
	}
	

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}

	public String[] getSelectedConsoles() {
		return selectedConsoles;
	}

	public void setSelectedConsoles(String[] selectedConsoles) {
		this.selectedConsoles = selectedConsoles;
	}

	public List<CbsCodesVO> getCbsBranchCodes() {
		return cbsBranchCodes;
	}

	public void setCbsBranchCodes(List<CbsCodesVO> cbsBranchCodes) {
		this.cbsBranchCodes = cbsBranchCodes;
	}

	public List<CbsCodesVO> getCbsCenterCodes() {
		return cbsCenterCodes;
	}

	public void setCbsCenterCodes(List<CbsCodesVO> cbsCenterCodes) {
		this.cbsCenterCodes = cbsCenterCodes;
	}

	public CbsCodesService getCbsCodesService() {
		return cbsCodesService;
	}

	public void setCbsCodesService(CbsCodesService cbsCodesService) {
		this.cbsCodesService = cbsCodesService;
	}

	@ManagedProperty(value = "#{cbsCodesService}")
	private CbsCodesService cbsCodesService;

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public List<ListValueVO> getCenterCodeStatuss() {
		return centerCodeStatuss;
	}

	public void setCenterCodeStatuss(List<ListValueVO> centerCodeStatuss) {
		this.centerCodeStatuss = centerCodeStatuss;
	}

	public List<AgencyVO> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<AgencyVO> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public CenterCodesVO getCenterCodes() {
		return centerCodes;
	}

	public void setCenterCodes(CenterCodesVO centerCodes) {
		this.centerCodes = centerCodes;
	}

	public CenterCodesVO getCenterCodesDetails() {
		return centerCodes;
	}

	public void setCenterCodesDetails(CenterCodesVO centerCodes) {
		this.centerCodes = centerCodes;
	}

	@Override
	public CenterCodesVO getMaintenanceVO() {

		return centerCodes;
	}

	@Override
	protected CenterCodeService getMaintenanceService() {

		return centerCodeService;
	}

	public CenterCodeService getCenterCodeService() {
		return centerCodeService;
	}

	public void setCenterCodeService(CenterCodeService centerCodeService) {
		this.centerCodeService = centerCodeService;
	}

	public boolean isAuthorize() {
		return !("A".equals(centerCodes.getAuthStatus()));
	}

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 */

	
	public List<LocationVO> getLocationCodes() {
		return locationCodes;
	}

	public void setLocationCodes(List<LocationVO> locationCodes) {
		this.locationCodes = locationCodes;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	
/*Tag No: EGA-MN15-000004 Starts*/
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
}