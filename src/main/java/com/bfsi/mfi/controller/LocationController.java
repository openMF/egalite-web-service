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
import com.bfsi.mfi.entity.Location;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsCodesService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.LocationService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.LocationVO;

@ManagedBean(name = "locationController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addLocation"),
		@Permission(type = PermissionType.MODIFY, name = "modifyLocation"),
		@Permission(type = PermissionType.DELETE, name = "deleteLocation"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authLocation"),
		@Permission(type = PermissionType.LIST, name = "listLocation") })
public class LocationController extends
		MaintenanceController<LocationVO, Location> {

	@ManagedProperty(value = "#{locationService}")
	private LocationService locationService;
	
	@ManagedProperty(value = "#{cbsCodesService}")
	private CbsCodesService cbsCodesService;
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;

	private static String result;
	private static final String OUTCOME_SUCCESS = "success";

	boolean isCoRequired = true;

	private LocationVO existing = new LocationVO();
	private LocationVO location = new LocationVO();
	
	private List<LocationVO> countryCodes;
	private List<ListValueVO> locationStatuss;
	private List<CbsCodesVO> cbsLocationCodes;
	private List<CbsCodesVO> cbsLocationCodesUpdate;
	private List<CbsCodesVO> cbsBranchCodes;
	
	private String isCoModified, autoLocationCode, locationStatus, countryName;

	/*Tag No: EGA-MN15-000003  Starts*/
	private List<LocationVO> districts;
	private List<LocationVO> citys;
	private List<LocationVO> states;
	/*Tag No: EGA-MN15-000003  Ends*/
	
	@PostConstruct
	public void init() {
		countryCodes = locationService.getcountryCodes();
		// cbsLocationCodes = cbsCodesService.getCbsLocationCodes();
		cbsBranchCodes = cbsCodesService.getCbsBranchCodes();
		locationStatuss = listservice.get("isActive");
		ListOfValuesUtil.addLocaleDescription(locationStatuss);

		autoLocationCode = locationService.getAutoLocationCode();
		location.setLocationCode(autoLocationCode);
		cbsLocationCodes = locationService.getLocCbsCode();
		/*Tag No: EGA-MN15-000003 Start*/
		districts = locationService.getdistricts();
		citys = locationService.getcitys();
		states = locationService.getstates();
		/*Tag No: EGA-MN15-000003 Ends*/
	}

	public String checkModifyForUpdate() {
		String locationcheckStatus;
		locationcheckStatus = validateLocationStatus();
			
		//String add3Modified = existing.getAddress3() == null?"":existing.getAddress3();// Tag No: EGA-MN15-000003 

		if (location.getLocationCode().equals(existing.getLocationCode())
				
				&& location.getCbsBranchCode().equals(
						existing.getCbsBranchCode())
				&& location.getLocationDesc().equals(existing.getLocationDesc())	
				&& location.getAddress1().equals(existing.getAddress1())
				&& location.getAddress2().equals(existing.getAddress2())
				&& location.getAddress3().equals(existing.getAddress3())
				&& location.getAddress4().equals(existing.getAddress4())
				&& location.getContactNumber().equals(
						existing.getContactNumber())
				&& location.getIsActive().equals(existing.getIsActive())
				&& location.getZipCode().equals(existing.getZipCode())
				&& location.getCity().equals(existing.getCity())
				&& location.getState().equals(existing.getState())
				&& location.getCountry().equals(existing.getCountry())) {

			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		} else if ((!locationcheckStatus.equals(OUTCOME_SUCCESS))
				&& (location.getIsActive().equalsIgnoreCase("I")))

		{
			LoggerUtil.ibsJobDebug("Location already Active with Agent: MFI00604");
			MessageUtil.addMessage("MFI00604");
			return null;
		} else if("success".equalsIgnoreCase(validateLocationCodeModify())){
			//if(!location.getLocationCode().equals(existing.getLocationCode())) //Tag No: EGA-MN15-000003 
			//{
				super.update();
			}
	//	} //Tag No: EGA-MN15-000003 
		else
		{
			return null;
		}
		return "success";
	}

	public void loadLocation() {
		if(isCoModified == null ){
		LocationVO locationVO = new LocationVO();
		locationVO.setLocationCode(location.getLocationCode());
		try {

			this.location = locationService.get(location.getLocationCode());
			locationStatus = listservice.getValue(location.getIsActive(),
					ListValue.LIST_NAME_AGENT_STATUS);
			countryName = listservice.getValue(location.getCountry(),
					ListValue.LIST_NAME_COUNTRY_NAME);
			cbsLocationCodesUpdate = locationService.getLocCbsCode();
			
			if (location.getCbsLocationCode() != null
					&& location.getCbsLocationCode().trim().length() > 0) {
				for (CbsCodesVO cbsVo : cbsLocationCodes) {
					if (cbsVo != null
							&& location.getCbsLocationCode().equals(
									cbsVo.getDlValue())) {
						isCoRequired = false;
					} else {
						isCoRequired = true;
					}
				}
				if (isCoRequired) {
					CbsCodesVO cbsCodeVo = new CbsCodesVO();
					cbsCodeVo.setDlValue(location.getCbsLocationCode());
					cbsLocationCodes.add(cbsCodeVo);
				}
			}
			LoggerUtil.ibsJobDebug("Agency Code not Available: MFI00602");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading Agency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading Agency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(location);
		existing = (LocationVO) location.clone();
		}
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	// For delete Operation with Authorize check
	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = locationService.deleteLocation(location.getId());
			LoggerUtil.ibsJobDebug("Location Record deleted successfully: "
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

	public String validateLocationStatus() {
		String locationId = location.getId().trim();
		try {
			if (locationService.isLocationStatustoInactive(locationId)) {
				result = "failure";
				LoggerUtil.ibsJobDebug("Invalid Agency validation ");
			} else {
				result = OUTCOME_SUCCESS;
			}
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while validating Agency status: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = OUTCOME_SUCCESS;
		}
		return result;
	}
	
	
/*
	 * public boolean validateCbsLocCode() throws ServiceException {
	 * 
	 * boolean response = false; //isCoModified = coModified; try { String
	 * cbsLocCode = location.getCbsLocationCode(); // check availability of user
	 * id if (!locationService.isCbsLocCodeAvailable(cbsLocCode)) {
	 * LoggerUtil.ibsJobError
	 * ("Cbs Credit Officer Code already exists : MFI40002");
	 * MessageUtil.addMessage("MFI40002"); response = false; } else {
	 * LoggerUtil.ibsJobDebug("Cbs Credit Officer Code validated Successfully");
	 * response = true; } } catch (ServiceException e) { LoggerUtil.ibsJobError(
	 * "ServiceException while validating Cbs Credit Officer Code: MFI10001",
	 * e); MessageUtil.addMessage("MFI10001"); response = false; } catch
	 * (Exception e) { LoggerUtil.ibsJobError(
	 * "Unhandled exception while validating Cbs Credit Officer Code: MFI10001",
	 * e); MessageUtil.addMessage("MFI10001"); response = false; } return
	 * response;
	 * 
	 * }
	 * 
	 * @Override public String create()
	 * 
	 * { if(validateCbsLocCode()) { super.create(); return "success"; } else {
	 * return null;
	 * 
	 * }
	 * 
	 * }
	 */
	
/*Tag No: EGA-MN15-000003 Starts*/
	
	public String validateLocationCode() throws ServiceException {
		String locationCode = location.getCbsLocationCode();
		try {
			if (!locationService.isLocationCodeAvailable(locationCode)) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, msg
								.getString("locationMgmt.msg.locationCodeExists"),
								null));
				result = "failure";
			} else {

				result = "success";
			}
		}

		catch (ServiceException e) {
			logger.error(
					"Unexpected error while Checking Location Code = "
							+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
			result = "failure";
		}
		return result;
	}
	
	public String createLocation() throws ServiceException {
		String cbsLocationCodeCheck;
		try {
			cbsLocationCodeCheck = validateLocationCode();
			if (cbsLocationCodeCheck.equals("success")) {
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
	
	public String validateLocationCodeModify() throws ServiceException {
		String locationCode = location.getCbsLocationCode();
		try {
			if (!locationService.isLocationCodeAvailable(locationCode) &&
					(!(location.getCbsLocationCode().equals(
							existing.getCbsLocationCode())))) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, msg
								.getString("locationMgmt.msg.locationCodeExists"),
								null));
				result = "failure";
			} else {

				result = "success";
			}
		}

		catch (ServiceException e) {
			logger.error(
					"Unexpected error while Checking Location Code = "
							+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
			result = "failure";
		}
		return result;
	}
	/*Tag No: EGA-MN15-000003 End*/

	public List<CbsCodesVO> getCbsLocationCodesUpdate() {
		return cbsLocationCodesUpdate;
	}

	public void setCbsLocationCodesUpdate(List<CbsCodesVO> cbsLocationCodesUpdate) {
		this.cbsLocationCodesUpdate = cbsLocationCodesUpdate;
	}

	public List<LocationVO> getDistricts() {
		return districts;
	}

	public void setDistricts(List<LocationVO> districts) {
		this.districts = districts;
	}

	public List<LocationVO> getCitys() {
		return citys;
	}

	public void setCitys(List<LocationVO> citys) {
		this.citys = citys;
	}

	public List<LocationVO> getStates() {
		return states;
	}
	
	public void setStates(List<LocationVO> states) {
		this.states = states;
	}
	public List<CbsCodesVO> getCbsBranchCodes() {
		return cbsBranchCodes;
	}

	public void setCbsBranchCodes(List<CbsCodesVO> cbsBranchCodes) {
		this.cbsBranchCodes = cbsBranchCodes;
	}

	public String getIsCoModified() {
		return isCoModified;
	}

	public void setIsCoModified(String isCoModified) {
		this.isCoModified = isCoModified;
	}

	public List<CbsCodesVO> getCbsLocationCodes() {
		return cbsLocationCodes;
	}

	public void setCbsLocationCodes(List<CbsCodesVO> cbsLocationCodes) {
		this.cbsLocationCodes = cbsLocationCodes;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLocationStatus() {
		return locationStatus;
	}

	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public List<LocationVO> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<LocationVO> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public List<ListValueVO> getLocationStatuss() {
		return locationStatuss;
	}

	public void setLocationStatuss(List<ListValueVO> locationStatuss) {
		this.locationStatuss = locationStatuss;
	}
	
	public LocationVO getExisting() {
		return existing;
	}

	public void setExisting(LocationVO existing) {
		this.existing = existing;
	}

	public LocationVO getLocation() {
		return location;
	}

	public void setLocation(LocationVO location) {
		this.location = location;
	}

	public LocationVO getLocationDetails() {
		return location;
	}

	public void setLocationDetails(LocationVO location) {
		this.location = location;
	}

	@Override
	public LocationVO getMaintenanceVO() {
		return location;
	}

	@Override
	protected LocationService getMaintenanceService() {
		return locationService;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public boolean isAuthorize() {
		return !("A".equals(location.getAuthStatus()));
	}

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 */

	public CbsCodesService getCbsCodesService() {
		return cbsCodesService;
	}

	public void setCbsCodesService(CbsCodesService cbsCodesService) {
		this.cbsCodesService = cbsCodesService;
	}
}