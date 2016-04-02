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
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.entity.RouteCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsCodesService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.LocationService;
import com.bfsi.mfi.service.RouteCodeService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.LocationVO;
import com.bfsi.mfi.vo.RouteCodesVO;

@ManagedBean(name = "routeCodeController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addRouteCode"),
		@Permission(type = PermissionType.MODIFY, name = "modifyRouteCode"),
		@Permission(type = PermissionType.DELETE, name = "deleteRouteCode"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authRouteCode"),
		@Permission(type = PermissionType.LIST, name = "listRouteCode") })
public class RouteCodeController extends
		MaintenanceController<RouteCodesVO, RouteCodes> {

	@ManagedProperty(value = "#{routeCodeService}")
	private RouteCodeService routeCodeService;

	private RouteCodesVO existing = new RouteCodesVO();
	private RouteCodesVO routeCodes = new RouteCodesVO();
	private List<AgencyVO> countryCodes;
	
	/*Tag No: EGA-MN15-000002  Starts*/
	private List<RouteCodesVO> districts;
	private List<RouteCodesVO> citys;
	private List<RouteCodesVO> states;
	/*Tag No: EGA-MN15-000002  Ends*/
	private String autoRouteCode;
	private String isStatusActive;
	private String fromCountryName;
	private String toCountryName;
	
	private List<LocationVO> locationCodes;
	private List<CbsCodesVO> cbsBranchCodes;
	private List<CbsCodesVO> cbsRouteCodes;
	private List<CbsCodesVO> cbsRouteCodesUpdate;
	
	boolean isCoRequired = true;
	boolean isLocRequired = true;

	@ManagedProperty(value = "#{locationService}")
	private LocationService locationService;
	
	@ManagedProperty(value = "#{cbsCodesService}")
	private CbsCodesService cbsCodesService;

	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	private String[] selectedConsoles;

	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	
	private List<ListValueVO> routeCodeStatuss;

	@PostConstruct
	public void init() {
		try {
			routeCodeStatuss = listservice.get("isActive");
			ListOfValuesUtil.addLocaleDescription(routeCodeStatuss);
			countryCodes = routeCodeService.getcountryCodes();
			autoRouteCode = routeCodeService.getAutoRouteCode();
			routeCodes.setId(autoRouteCode);
			
			locationCodes= routeCodeService.getlocationCodes();
			cbsRouteCodes = routeCodeService.getCbsRouteCode();
			cbsBranchCodes = cbsCodesService.getCbsBranchCodes();
			districts = routeCodeService.getdistricts();
			citys = routeCodeService.getcitys();
			states = routeCodeService.getstates();
	
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while loading init listservice: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while loading init listservice: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 */

	public String checkModifyForUpdate() {

		if (routeCodes.getRouteCode().equals(existing.getRouteCode())
				&& routeCodes.getCbsRouteCode().equals(
						existing.getCbsRouteCode())
				&& routeCodes.getIbsLocationCode().equals(
						existing.getIbsLocationCode())
				&& routeCodes.getRouteCodeDesc().equals(
						existing.getRouteCodeDesc())
				&& routeCodes.getCbsBranchCode().equals(
						existing.getCbsBranchCode())
				&& routeCodes.getContactNumber().equals(
						existing.getContactNumber())
				&& routeCodes.getOnSunday() == (existing.getOnSunday())
				&& routeCodes.getOnMonday() == (existing.getOnMonday())
				&& routeCodes.getOnTuesday() == (existing.getOnTuesday())
				&& routeCodes.getOnWednesday() == (existing.getOnWednesday())
				&& routeCodes.getOnThursday() == (existing.getOnThursday())
				&& routeCodes.getOnFriday() == (existing.getOnFriday())
				&& routeCodes.getOnSaturday() == (existing.getOnSaturday())
				&& routeCodes.getFrmAddressLine1().equals(
						existing.getFrmAddressLine1())
				&& routeCodes.getFrmAddressLine2().equals(
						existing.getFrmAddressLine2())
				&& routeCodes.getFrmAddressLine3().equals(
						existing.getFrmAddressLine3())
				&& routeCodes.getFrmAddressLine4().equals(
						existing.getFrmAddressLine4())
				&& routeCodes.getFrmZipCode().equals(existing.getFrmZipCode())
				&& routeCodes.getFrmCity().equals(existing.getFrmCity())
				&& routeCodes.getFrmState().equals(existing.getFrmState())
				&& routeCodes.getFrmCountry().equals(existing.getFrmCountry())
				&& routeCodes.getToAddressLine1().equals(
						existing.getToAddressLine1())
				&& routeCodes.getToAddressLine2().equals(
						existing.getToAddressLine2())
				&& routeCodes.getToAddressLine3().equals(
						existing.getToAddressLine3())
				&& routeCodes.getToAddressLine4().equals(
						existing.getToAddressLine4())
				&& routeCodes.getToZipCode().equals(existing.getToZipCode())
				&& routeCodes.getToCity().equals(existing.getToCity())
				&& routeCodes.getToState().equals(existing.getToState())
				&& routeCodes.getToCountry().equals(existing.getToCountry())
				&& routeCodes.getIsActive().equals(existing.getIsActive())) {

			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		} else if("success".equalsIgnoreCase(validateRouteCodeModify())){
			super.update(); // Tag No: EGA-MN15-000002
		}
		else
		{
			return null;
		}

		return "success";
	}

	public void loadRouteCode() {

		RouteCodesVO routeCodesVO = new RouteCodesVO();
		routeCodesVO.setRouteCode(routeCodes.getRouteCode());

		try {
			this.routeCodes = routeCodeService.get(routeCodes.getRouteCode());
			fromCountryName = listservice.getValue(routeCodes.getFrmCountry(),
					ListValue.LIST_NAME_COUNTRY_NAME);
			toCountryName = listservice.getValue(routeCodes.getToCountry(),
					ListValue.LIST_NAME_COUNTRY_NAME);
			
			isStatusActive = listservice.getValue(routeCodes.getIsActive()
					.trim(), ListValue.LIST_NAME_AGENT_STATUS);
			cbsRouteCodesUpdate = routeCodeService.getCbsRouteCode();
			
			if (routeCodes.getCbsRouteCode() != null
					&& routeCodes.getCbsRouteCode().trim().length() > 0) {
				for (CbsCodesVO cbsVo : cbsRouteCodes) {
					if (cbsVo != null
							&& routeCodes.getCbsRouteCode().equals(
									cbsVo.getDlValue())) {
						isCoRequired = false;
					} else {
						isCoRequired = true;
					}
				}
				if (isCoRequired) {
					CbsCodesVO cbsCodeVo = new CbsCodesVO();
					cbsCodeVo.setDlValue(routeCodes.getCbsRouteCode());
					cbsRouteCodes.add(cbsCodeVo);
				}
			}
			
			if(routeCodes.getIbsLocationCode()!= null && routeCodes.getIbsLocationCode().trim().length() >0)
			{
				for(LocationVO locVo:locationCodes)
				{
					if(locVo != null && routeCodes.getIbsLocationCode().equals(locVo.getLocationCode()))
					  {
						isLocRequired=false;
					  }
					else
					{
						isLocRequired=true;
					}
				}
				if(isLocRequired)
				  {
					LocationVO locVo = new LocationVO();
					locVo.setLocationCode(routeCodes.getIbsLocationCode());
					locationCodes.add(locVo);
				  }
				
			}
			
		
			LoggerUtil.ibsJobDebug("Route Code not Available: MFI10001");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading Route Code: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil
					.ibsJobError(
							"Unhandled exception while loading Route Code: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(routeCodes);
		existing = (RouteCodesVO) routeCodes.clone();
	}

	// For delete Operation with Authorize check
	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = routeCodeService.deleteRoute(routeCodes.getId());
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
	
	/*Tag No: EGA-MN15-000002 Starts*/
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	
	public String validateRouteCode() throws ServiceException {
		String routeCode = routeCodes.getCbsRouteCode();
		try {
			if (!routeCodeService.isRouteCodeAvailable(routeCode)) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, msg
								.getString("routeMgmt.msg.routeCodeExists"),
								null));
				result = "failure";
			} else {

				result = "success";
			}
		}

		catch (ServiceException e) {
			logger.error(
					"Unexpected error while Checking Route Code = "
							+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
			result = "failure";
		}
		return result;
	}
	
	public String createRouteCode() throws ServiceException {
		String RouteCodeCheck;
		try {
			RouteCodeCheck = validateRouteCode();
			if (RouteCodeCheck.equals("success")) {
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
	
	public String validateRouteCodeModify() throws ServiceException {
		String routeCode = routeCodes.getCbsRouteCode();
		try {
			if (!routeCodeService.isRouteCodeAvailable(routeCode) &&
					(!(routeCodes.getCbsRouteCode().equals(
							existing.getCbsRouteCode())))) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, msg
								.getString("routeMgmt.msg.routeCodeExists"),
								null));
				result = "failure";
			} else {

				result = "success";
			}
		}

		catch (ServiceException e) {
			logger.error(
					"Unexpected error while Checking Route Code = "
							+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
			result = "failure";
		}
		return result;
	}
	
	/*Tag No: EGA-MN15-000002 End*/
	public RouteCodesVO getRouteCodes() {
		return routeCodes;
	}

	public void setRouteCodes(RouteCodesVO routeCodes) {
		this.routeCodes = routeCodes;
	}

	public RouteCodesVO getRouteCodesDetails() {
		return routeCodes;
	}

	public void setRouteCodesDetails(RouteCodesVO routeCodes) {
		this.routeCodes = routeCodes;
	}

	@Override
	public RouteCodesVO getMaintenanceVO() {

		return routeCodes;
	}

	@Override
	protected RouteCodeService getMaintenanceService() {

		return routeCodeService;
	}

	public RouteCodeService getRouteCodeService() {
		return routeCodeService;
	}

	public void setRouteCodeService(RouteCodeService routeCodeService) {
		this.routeCodeService = routeCodeService;
	}

	public boolean isAuthorize() {
		return !("A".equals(routeCodes.getAuthStatus()));
	}
	

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public List<ListValueVO> getRouteCodeStatuss() {
		return routeCodeStatuss;
	}

	public void setRouteCodeStatuss(List<ListValueVO> routeCodeStatuss) {
		this.routeCodeStatuss = routeCodeStatuss;
	}

	public List<AgencyVO> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<AgencyVO> countryCodes) {
		this.countryCodes = countryCodes;
	}
	
	/*Tag No: EGA-MN15-000002 Starts*/
	
	public List<RouteCodesVO> getDistricts() {
		return districts;
	}

	public void setDistricts(List<RouteCodesVO> districts) {
		this.districts = districts;
	}
	
	public List<RouteCodesVO> getCitys() {
		return citys;
	}

	public void setCitys(List<RouteCodesVO> citys) {
		this.citys = citys;
	}
	
	public List<RouteCodesVO> getStates() {
		return states;
	}

	public void setStates(List<RouteCodesVO> states) {
		this.states = states;
	}
	/*Tag No: EGA-MN15-000002 Ends*/
	

	public List<CbsCodesVO> getCbsBranchCodes() {
		return cbsBranchCodes;
	}

	public void setCbsBranchCodes(List<CbsCodesVO> cbsBranchCodes) {
		this.cbsBranchCodes = cbsBranchCodes;
	}

	public List<CbsCodesVO> getCbsRouteCodes() {
		return cbsRouteCodes;
	}

	public void setCbsRouteCodes(List<CbsCodesVO> cbsRouteCodes) {
		this.cbsRouteCodes = cbsRouteCodes;
	}

	public CbsCodesService getCbsCodesService() {
		return cbsCodesService;
	}

	public void setCbsCodesService(CbsCodesService cbsCodesService) {
		this.cbsCodesService = cbsCodesService;
	}

	public String getIsStatusActive() {
		return isStatusActive;
	}

	public String getFromCountryName() {
		return fromCountryName;
	}

	public void setFromCountryName(String fromCountryName) {
		this.fromCountryName = fromCountryName;
	}

	public String getToCountryName() {
		return toCountryName;
	}

	public void setToCountryName(String toCountryName) {
		this.toCountryName = toCountryName;
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

	public List<CbsCodesVO> getCbsRouteCodesUpdate() {
		return cbsRouteCodesUpdate;
	}

	public void setCbsRouteCodesUpdate(List<CbsCodesVO> cbsRouteCodesUpdate) {
		this.cbsRouteCodesUpdate = cbsRouteCodesUpdate;
	}

}