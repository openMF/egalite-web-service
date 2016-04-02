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
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgencyService;
import com.bfsi.mfi.service.CbsCodesService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.UserVO;

@ManagedBean(name = "agencyController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addAgency"),
		@Permission(type = PermissionType.MODIFY, name = "modifyAgency"),
		@Permission(type = PermissionType.DELETE, name = "deleteAgency"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authAgency"),
		@Permission(type = PermissionType.LIST, name = "listAgencies") })
public class AgencyController extends MaintenanceController<AgencyVO, Agency> {

	@ManagedProperty(value = "#{agencyService}")
	private AgencyService agencyService;

	@ManagedProperty(value = "#{cbsCodesService}")
	private CbsCodesService cbsCodesService;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";

	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	private List<ListValueVO> agencyStatuss;
	private List<ListValueVO> agencyCategorys;
	private List<AgencyVO> countryCodes;
	private List<CbsCodesVO> cbsCodes;
	private List<UserVO> coCodes;

	private String isCoModified, agencyStatus, countryName, autoAgencyCode,
			agencyCategory;
	boolean isCoRequired = true;

	private AgencyVO existing = new AgencyVO();
	private AgencyVO agency = new AgencyVO();

	@PostConstruct
	public void init() {
		try {
			agencyStatuss = listservice.get("isActive");
			ListOfValuesUtil.addLocaleDescription(agencyStatuss);

			agencyCategorys = listservice.get("category");
			ListOfValuesUtil.addLocaleDescription(agencyCategorys);

			countryCodes = agencyService.getcountryCodes();

			autoAgencyCode = agencyService.getAutoAgencyCode();
			agency.setAgencyCode(autoAgencyCode);

			// cbsCodes = cbsCodesService.get();
			cbsCodes = agencyService.getAgencyCbsCode();
			coCodes = userService.getCreditOfficers();

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

	public String checkModifyForUpdate() {
		String agencycheckStatus;
		agencycheckStatus = validateAgencyStatus();

		if (agency.getAgencyCode().equals(existing.getAgencyCode())
				&& agency.getAgencyDesc().equals(existing.getAgencyDesc())
				&& agency.getAllocatedCo().equals(existing.getAllocatedCo())
				&& agency.getAddress1().equals(existing.getAddress1())
				&& agency.getAddress2().equals(existing.getAddress2())
				&& agency.getAddress3().equals(existing.getAddress3())
				&& agency.getAddress4().equals(existing.getAddress4())
				&& agency.getContactNumber()
						.equals(existing.getContactNumber())
				&& agency.getIsActive().equals(existing.getIsActive())
				&& agency.getCategory().equals(existing.getCategory())
				&& agency.getZipCode().equals(existing.getZipCode())
				&& agency.getCity().equals(existing.getCity())
				&& agency.getState().equals(existing.getState())
				&& agency.getCountry().equals(existing.getCountry())
				&& agency.getEmailAddress().equals(existing.getEmailAddress())) {

			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		} else if ((!agencycheckStatus.equals(OUTCOME_SUCCESS))
				&& (agency.getIsActive().equalsIgnoreCase("I")))

		{
			LoggerUtil
					.ibsJobDebug("Agency already Active with Agent: MFI00601");
			MessageUtil.addMessage("MFI00601");
			return null;
		} else {
			super.update();
		}

		return "success";
	}

	public void loadAgency() {
		if (isCoModified == null) {
			AgencyVO agencyVO = new AgencyVO();
			agencyVO.setAgencyCode(agency.getAgencyCode());
			try {
				this.agency = agencyService.get(agency.getAgencyCode());
				agencyCategory = listservice.getValue(agency.getCategory(),
						ListValue.LIST_NAME_AGENCY_CATEGORY);
			

				agencyStatus = listservice.getValue(agency.getIsActive(),
						ListValue.LIST_NAME_AGENT_STATUS);
				countryName = listservice.getValue(agency.getCountry(),
						ListValue.LIST_NAME_COUNTRY_NAME);

		

				if (agency.getAllocatedCo() != null
						&& agency.getAllocatedCo().trim().length() > 0) {
					for (CbsCodesVO cbsVo : cbsCodes) {
						if (cbsVo != null
								&& agency.getAllocatedCo().equals(
										cbsVo.getDlValue())) {
							isCoRequired = false;
						} else {

							isCoRequired = true;
						}
					}
					if (isCoRequired) {
						CbsCodesVO cbsCodeVo = new CbsCodesVO();
						cbsCodeVo.setDlValue(agency.getAllocatedCo());
						cbsCodes.add(cbsCodeVo);
					}
				}
				LoggerUtil.ibsJobDebug("Agency Code not Available: MFI00602");
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError(
						"ServiceException while loading Agency: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
			} catch (Exception e) {
				LoggerUtil
						.ibsJobError(
								"Unhandled exception while loading Agency: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			}
			loadAndShowAuditTrail(agency);
			existing = (AgencyVO) agency.clone();
		}
	}

	// Validation for duplicate Agency Code.

	public String validateAgencyCode() throws ServiceException {
		String agencyCode = agency.getId();
		try {
			if (!agencyService.isAgencyCodeAvailable(agencyCode)) {
				LoggerUtil.ibsJobDebug("Agency Code already exits: MFI00603");
				MessageUtil.addMessage("MFI00603");
				result = "failure";
			} else {
				result = "success";
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"Unexpected error while Checking userId: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}
		return result;
	}

	public String createAgency() throws ServiceException {
		String agencyCode;
		try {
			agencyCode = validateAgencyCode();
			// boolean cbsCoCode = validateCbscoCode("true");

			if (agencyCode.equals("success")) {
				super.create();
				result = "success";
			} else {
				result = "";
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while creating Agency: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return result;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	// For delete Operation with Authorize check
	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = agencyService.deleteAgency(agency.getId());
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

	// For ModifyUniqueId
	public String validateAgencyStatus() {
		String agencyId = agency.getId().trim();
		try {
			if (agencyService.isAgencyStatustoInactive(agencyId)) {
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

	public CbsCodesService getCbsCodesService() {
		return cbsCodesService;
	}
	/*Tag Name EGA-MN15-000030 Start */
	public String getCountryName() {
		
		List<AgencyVO> agvo = agencyService.getcountryCodes();
		for (AgencyVO agencyVO : agvo) {
			System.out.println("agencyVO.getCountryCode()="+agencyVO.getCountryCode());
			if (agencyVO.getCountryCode().equals(agency.getCountry())){
				countryName = agencyVO.getDescription();

			}

		}
		return countryName;
		//
	}
	/*Tag Name EGA-MN15-000030 End */

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setCbsCodesService(CbsCodesService cbsCodesService) {
		this.cbsCodesService = cbsCodesService;
	}

	public String getIsCoModified() {
		return isCoModified;
	}

	public void setIsCoModified(String isCoModified) {
		this.isCoModified = isCoModified;
	}

	public List<CbsCodesVO> getCbsCodes() {
		return cbsCodes;
	}

	public void setCbsCodes(List<CbsCodesVO> cbsCodes) {
		this.cbsCodes = cbsCodes;
	}

	public String getAgencyCategory() {
		return agencyCategory;
	}

	public void setAgencyCategory(String agencyCategory) {
		this.agencyCategory = agencyCategory;
	}

	public String getAgencyStatus() {
		return agencyStatus;
	}

	public void setAgencyStatus(String agencyStatus) {
		this.agencyStatus = agencyStatus;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public List<ListValueVO> getAgencyStatuss() {
		return agencyStatuss;
	}

	public void setAgencyStatuss(List<ListValueVO> agencyStatuss) {
		this.agencyStatuss = agencyStatuss;
	}

	public List<ListValueVO> getAgencyCategorys() {
		return agencyCategorys;
	}

	public void setAgencyCategorys(List<ListValueVO> agencyCategorys) {
		this.agencyCategorys = agencyCategorys;
	}

	public List<AgencyVO> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<AgencyVO> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public AgencyVO getagency() {
		return agency;
	}

	public void setagency(AgencyVO agency) {
		this.agency = agency;
	}

	public AgencyVO getAgencyDetails() {
		return agency;
	}

	public void setAgencyDetails(AgencyVO agency) {
		this.agency = agency;
	}

	@Override
	public AgencyVO getMaintenanceVO() {
		return agency;
	}

	@Override
	protected AgencyService getMaintenanceService() {
		return agencyService;
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public boolean isAuthorize() {
		return !("A".equals(agency.getAuthStatus()));
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<UserVO> getCoCodes() {
		return coCodes;
	}

	public void setCoCodes(List<UserVO> coCodes) {
		this.coCodes = coCodes;
	}

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 */

	/*
	 * public boolean validateCbscoCode(String coModified) throws
	 * ServiceException {
	 * 
	 * boolean response = false; isCoModified = coModified; try { String
	 * cbsCoCode = agency.getAllocatedCo(); // check availability of user id if
	 * (!agencyService.isCbsCoCodeAvailable(cbsCoCode)) {
	 * LoggerUtil.ibsJobError(
	 * "Cbs Credit Officer Code already exists : MFI40002");
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
	 */

}