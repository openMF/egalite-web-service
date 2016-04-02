package com.bfsi.mfi.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionAnnotationProcessor;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgencyService;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.service.CbsCodesService;
import com.bfsi.mfi.service.DeviceService;
import com.bfsi.mfi.service.ExternalDeviceService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.LocationService;
import com.bfsi.mfi.service.RoleService;
import com.bfsi.mfi.service.RouteCodeService;
import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.DeviceVO;
import com.bfsi.mfi.vo.ExternalDeviceVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.LocationVO;
import com.bfsi.mfi.vo.RoleVO;
import com.bfsi.mfi.vo.RouteCodesVO;
import com.bfsi.mfi.vo.UserVO;

/**
 * @className : AgentController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 */

@ManagedBean(name = "agentController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addAgent"),
		@Permission(type = PermissionType.MODIFY, name = "modifyAgent"),
		@Permission(type = PermissionType.DELETE, name = "deleteAgent"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authAgent"),
		@Permission(type = PermissionType.UNREGISTER, name = "unregisterAgent"),
		@Permission(type = PermissionType.LIST, name = "listAgents") })
public class AgentController extends MaintenanceController<AgentVO, Agent>
		implements Serializable, ActionListener {
	private static final long serialVersionUID = -8144614324632010903L;
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ManagedProperty(value = "#{agentService}")
	private AgentService agentService;
	
	@ManagedProperty(value = "#{cbsCodesService}")
	private CbsCodesService cbsCodesService;
	
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{agencyService}")
	private AgencyService agencyService;

	@ManagedProperty(value = "#{deviceService}")
	private DeviceService deviceService;

	@ManagedProperty(value = "#{externalDeviceService}")
	private ExternalDeviceService externalDeviceService;

	@ManagedProperty(value = "#{locationService}")
	private LocationService locationService;

	@ManagedProperty(value = "#{roleService}")
	private RoleService roleService;

	@ManagedProperty(value = "#{routeCodeService}")
	private RouteCodeService routeCodeService;
	
	private AgentVO modify = new AgentVO();
	private AgentVO agent = new AgentVO();
	private AgentVO agentVO = new AgentVO();
	private String countryName, autoAgentId, agentType, gender, isStatusActive;
	
	private List<CbsCodesVO> cbsAgentCodes;
	private List<DeviceVO> devices = new ArrayList<DeviceVO>();
	private List<ExternalDeviceVO> externalDevices = new ArrayList<ExternalDeviceVO>();

	private List<DeviceVO> modifyDevices = new ArrayList<DeviceVO>();
	private List<RoleVO> availableRolesForMbs;
	private List<RoleVO> filteredRoles = new ArrayList<RoleVO>();//

	private List<UserVO> creditOfficers;
	private List<ListValueVO> agentTypes;
	private List<ListValueVO> languages;
	private List<ListValueVO> genders;
	private List<ListValueVO> isActive;
	
	private List<AgencyVO> countryCodes;
	private List<RouteCodesVO> districts;
	private List<RouteCodesVO> citys;
	private List<RouteCodesVO> states;
	
	private List<AgencyVO> agencyCodes;
	private List<LocationVO> locationCodes;
	private static String result = null;

	private static boolean response;
	boolean isCoRequired = true;
	private static final String SUCCESS = "success", FAILURE = "failure";

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	private String userIdToLoad = null;
	private List<RoleVO> oldModifyAllocatedRoles = new ArrayList<RoleVO>();
	private List<RoleVO> modifyFilteredRoles = new ArrayList<RoleVO>();
	private List<RoleVO> modifyAvailableRoles = new ArrayList<RoleVO>();

	private List<RoleVO> selectedAvailableRoles = new ArrayList<RoleVO>();
	private List<RoleVO> selectedAllocatedRoles = new ArrayList<RoleVO>();
	private List<RoleVO> modifySelectedAvailableRoles = new ArrayList<RoleVO>();
	private List<RoleVO> modifySelectedAllocatedRoles = new ArrayList<RoleVO>();
	UserVO userVO = new UserVO();
	private String value;

	@PostConstruct
	public void init() {
		logger.error("Inside Agent Controller");
		agentTypes = listservice.get(ListValue.LIST_NAME_AGENT_TYPE);
		ListOfValuesUtil.addLocaleDescription(agentTypes);

		languages = listservice.get(ListValue.LIST_NAME_AGENT_LANGUAGE);
		ListOfValuesUtil.addLocaleDescription(languages);

		genders = listservice.get(ListValue.LIST_NAME_GENDER);
		ListOfValuesUtil.addLocaleDescription(genders);

		isActive = listservice.get(ListValue.LIST_NAME_AGENT_STATUS);
		ListOfValuesUtil.addLocaleDescription(isActive);

		try {
			devices = deviceService.getDevicesForAllocation();
			externalDevices = externalDeviceService.getDevicesForAllocation();
			agencyCodes = agencyService.getAuthorized();
			creditOfficers = userService.getCreditOfficers();
			autoAgentId = agentService.getAutoAgentId();
			agent.setAgentId(autoAgentId);
			//agent.setUserName(autoAgentId);
			//countryCodes = agentService.getcountryCodes();
			
			//cbsAgentCodes=cbsCodesService.getCbsAgentCodes();
			cbsAgentCodes=agentService.getCbsAgentCode();
			// EGALITE-289 START
			// locationCodes = locationService.getlocationCodes();
			locationCodes = locationService.getAgentlocationCodes();
			// EGALITE-289 END
			availableRolesForMbs = roleService.getAuthorizedRolesForMbs();
			loadAvailableRoles(agent.getAllocatedRoles());
			filteredRoles.clear();
			filteredRoles.addAll(availableRolesForMbs);
			
			countryCodes = routeCodeService.getcountryCodes();
			districts = routeCodeService.getdistricts();
			citys = routeCodeService.getcitys();
			states = routeCodeService.getstates();

			// loadDevice();
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while Loading init(Post) Method: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while Loading init(Post) Method: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}

	}

	public void loadAgent() throws ServiceException {

		LoggerUtil.ibsJobDebug("Validation in loadAgent() method");
		if (value != "mdfy") {
			try {
				this.agent = agentService.get(agent.getAgentId());
				countryName = listservice.getValue(agent.getCountry(),
						ListValue.LIST_NAME_COUNTRY_NAME);

				agent.setAllocatedRoles(roleService
						.getModifyAllocatedRolesForMbs(agent.getId()));
				oldModifyAllocatedRoles = roleService
						.getModifyAllocatedRolesForMbs(agent.getId());

				loadModifiedAvailableRoles(agent.getAllocatedRoles());
				modifyFilteredRoles.clear();
				modifyFilteredRoles.addAll(modifyAvailableRoles);
				LoggerUtil.ibsJobDebug("agent page loaded successfully ......");
				// EGALITE-227 start
				modify = (AgentVO) agent.clone();
				// EGALITE-227 end
				agentType = listservice.getValue(agent.getAgentType(),
						ListValue.LIST_NAME_AGENT_TYPE);
				gender = listservice.getValue(agent.getGender(),
						ListValue.LIST_NAME_GENDER);

				isStatusActive = listservice.getValue(agent.getIsActive(),
						ListValue.LIST_NAME_AGENT_STATUS);
				if (agent.getCbsagentcode() != null
						&& agent.getCbsagentcode().trim().length() > 0) {
					for (CbsCodesVO cbsVo : cbsAgentCodes) {
						if (cbsVo != null
								&& agent.getCbsagentcode().equals(
										cbsVo.getDlValue())) {
							isCoRequired = false;
						} else {
							isCoRequired = true;
						}
					}
					if (isCoRequired) {
						CbsCodesVO cbsCodeVo = new CbsCodesVO();
						cbsCodeVo.setDlValue(agent.getCbsagentcode());
						cbsAgentCodes.add(cbsCodeVo);
					}
				}
			
				// 	EGALITE-289 start
				if(agent.getLocationCode() !=null){
					LocationVO locVo = new LocationVO();
					locVo.setLocationCode(agent.getLocationCode());
					locationCodes.add(locVo);
				}
				
				//	EGALITE-289 end

				/*
				 * languages =
				 * listservice.get(ListValue.LIST_NAME_AGENT_LANGUAGE); genders
				 * = listservice.get(ListValue.LIST_NAME_GENDER); isActive =
				 * listservice.get(ListValue.LIST_NAME_AGENT_STATUS);
				 */

				if (agent.getDeviceId() != null) {
					DeviceVO deviceVO = new DeviceVO();
					deviceVO.setDeviceId(agent.getDeviceId());
					devices.add(deviceVO);
				}

				loadAndShowAuditTrail(agent);

			} catch (ServiceException e) {
				LoggerUtil
						.ibsJobError(
								"ServiceException while validating loadAgent: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			} catch (Exception e) {
				LoggerUtil
						.ibsJobError(
								"Unhandled exception while validating loadAgent: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			}
		}
	}

	// filter and selected value hold
	public void loadAvailableRoles(List<RoleVO> mallocatedRoles) {
		for (int i = 0; i < availableRolesForMbs.size();) {
			RoleVO v = availableRolesForMbs.get(i);
			boolean roleFound = false;
			for (RoleVO allocatedVo : mallocatedRoles) {
				if (allocatedVo.equals(v)) {
					availableRolesForMbs.remove(i);
					filteredRoles.remove(allocatedVo);
					roleFound = true;
					break;
				}
			}
			if (!roleFound) {
				i++;
			}
		}
	}

	public void loadModifiedAvailableRoles(List<RoleVO> modifyAllocatedRoles) {
		modifyAvailableRoles.clear();
		for (RoleVO v : availableRolesForMbs) {
			modifyAvailableRoles.add(v);
		}

		for (int i = 0; i < modifyAvailableRoles.size();) {
			RoleVO v = modifyAvailableRoles.get(i);
			boolean roleFound = false;
			for (RoleVO allocatedVo : modifyAllocatedRoles) {
				if (allocatedVo.equals(v)) {
					modifyAvailableRoles.remove(i);
					modifyFilteredRoles.remove(allocatedVo);
					roleFound = true;
					break;
				}
			}

			if (!roleFound) {
				i++;
			}
		}
	}

	public List<RoleVO> getSelectedAvailableRoles() {
		return selectedAvailableRoles;
	}

	public void setSelectedAvailableRoles(List<RoleVO> selectedAvailableRoles) {
		this.selectedAvailableRoles = selectedAvailableRoles;
	}

	public List<RoleVO> getSelectedAllocatedRoles() {
		return selectedAllocatedRoles;
	}

	public void setSelectedAllocatedRoles(List<RoleVO> selectedAllocatedRoles) {
		this.selectedAllocatedRoles = selectedAllocatedRoles;
	}

	public List<RoleVO> getModifySelectedAvailableRoles() {
		return modifySelectedAvailableRoles;
	}

	public void setModifySelectedAvailableRoles(
			List<RoleVO> modifySelectedAvailableRoles) {
		this.modifySelectedAvailableRoles = modifySelectedAvailableRoles;
	}

	public List<RoleVO> getModifySelectedAllocatedRoles() {
		return modifySelectedAllocatedRoles;
	}

	public void setModifySelectedAllocatedRoles(
			List<RoleVO> modifySelectedAllocatedRoles) {
		this.modifySelectedAllocatedRoles = modifySelectedAllocatedRoles;
	}

	public void moveToDest() {
		for (RoleVO r : selectedAvailableRoles) {
			agent.getAllocatedRoles().add(r);
			availableRolesForMbs.remove(r);
			filteredRoles.remove(r);
		}
		selectedAvailableRoles.clear();
	}

	public ActionListener getMoveToDest() {
		return this;
	}

	public void moveToSource() {
		for (RoleVO a : selectedAllocatedRoles) {
			availableRolesForMbs.add(a);
			filteredRoles.add(a);
			agent.getAllocatedRoles().remove(a);
		}
		selectedAllocatedRoles.clear();
	}

	public ActionListener getMoveToSource() {
		return this;
	}

	// For modify agent screen Roles Navigation.
	public void moveToModifyDest() {
		for (RoleVO r : modifySelectedAvailableRoles) {
			//System.out.println("R = " + r);
			modifyAvailableRoles.remove(r);
			modifyFilteredRoles.remove(r);
			agent.getAllocatedRoles().add(r);
		}
		modifySelectedAvailableRoles.clear();
		value = "mdfy";
	}

	public ActionListener getMoveToModifyDest() {
		return this;
	}

	public void moveToModifySource() {
		for (RoleVO a : modifySelectedAllocatedRoles) {
			modifyAvailableRoles.add(a);
			modifyFilteredRoles.add(a);
			agent.getAllocatedRoles().remove(a);
		}
		modifySelectedAllocatedRoles.clear();
		value = "mdfy";
	}

	public ActionListener getMoveToModifySource() {
		return this;
	}

	public boolean validateDob() throws ServiceException {
		try {
			Date myDate = agent.getDob();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dob_date = dateFormat.format(myDate);

			Date date = new Date();
			String curr_date = dateFormat.format(date);

			Date d_date = dateFormat.parse(dob_date);
			Date c_date = dateFormat.parse(curr_date);
			//System.out.println(d_date);
			//System.out.println(c_date);
			if (d_date.after(c_date)) {
				MessageUtil.addMessage("MFI00703");
				response = false;
			} else {
				response = true;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while validating DOB: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while validating DOB: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		}
		return response;
	}

	public void loadModifyDevice() throws ServiceException {
		try {
			modifyDevices = deviceService.getAllocatedDevices(agent
					.getAgentId());
			LoggerUtil.ibsJobDebug("Loaded the non allocated devices : ");
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while Loading non allocated devices : MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while validating non allocated devices: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}

	}

	public List<RoleVO> getModifyFilteredRoles() {
		return modifyFilteredRoles;
	}

	public void setModifyFilteredRoles(List<RoleVO> modifyFilteredRoles) {
		this.modifyFilteredRoles = modifyFilteredRoles;
	}

	public List<RoleVO> getModifyAvailableRoles() {
		return modifyAvailableRoles;
	}

	public void setModifyAvailableRoles(List<RoleVO> modifyAvailableRoles) {
		this.modifyAvailableRoles = modifyAvailableRoles;
	}

	public String getUserIdToLoad() {
		return userIdToLoad;
	}

	public void setUserIdToLoad(String userIdToLoad) {
		this.userIdToLoad = userIdToLoad;
	}

	@Override
	public void processAction(ActionEvent event)
			throws AbortProcessingException {
	}

	public String deleteUnAuthorized() throws ServiceException {
		LoggerUtil.ibsJobDebug("Validation in deleteUnAuthorized() method");
		try {
			result = agentService.deleteAgent(agent.getId());
			deviceService.updateIssueDateNull(agent.getDeviceId());
			MessageUtil.addMessage("MFI10011", agent.getId());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while delete UnAuthorized : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while delete UnAuthorized: MFI10001",
					e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	public boolean validateUserName() throws ServiceException {
		LoggerUtil.ibsJobDebug("Validation in validateUserName() method");
		String userId = agent.getUserName().trim();
		try {
			// check availability of agent id
			if (!agentService.isUserIdAvailable(userId)) {
				MessageUtil.addMessage("MFI00704", agent.getUserName());
				response = false;
			} else {
				response = true;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while validating UserName: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while validating UserName: MFI10001",
					e);
			MessageUtil.addMessage("MFI10001");
		}

		return response;
	}

	public String create() {
		LoggerUtil.ibsJobDebug("Validation in create() method");
		agent.setUserName(agent.getUserName().trim());
		boolean r_resp;
		try {
			r_resp = validateUserName();
			boolean dob = validateDob();
			if (r_resp && dob) {
				super.create();
				result = SUCCESS;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while creating Agent : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while creating Agent: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}

		return result;
	}

	public String checkModifyForUpdate() throws ServiceException {
		LoggerUtil.ibsJobDebug("Validation in checkModifyForUpdate() method");
		long prevCash = agent.getCashLimit();
		long mdfyCash = modify.getCashLimit();

		Date dob = agent.getDob();
		Date dob1 = modify.getDob();
		Date sdate = agent.getStartDate();
		Date sdate1 = modify.getStartDate();
		Date edate = agent.getEndDate();
		Date edate1 = modify.getEndDate();
		validateAgent();
		agent.setUserName(agent.getUserName().trim());		
		boolean dofbirth = validateDob();
		boolean alloctedLists = oldModifyAllocatedRoles.size() == agent
				.getAllocatedRoles().size()
				&& oldModifyAllocatedRoles.containsAll(agent
						.getAllocatedRoles());

		if (dofbirth) {
			if (!(agent.getUserName().equals(modify.getUserName()))) {
				boolean vUsername = validateUserName();
				if (!(vUsername)) {

				}
			} else {
				
				if (agent.getAgentId().equals(
						getNotNullString(modify.getAgentId()))
						&& agent.getFname().equals(modify.getFname())
						&& agent.getLname().equals(modify.getLname())						
						&& agent.getCreditOfficer().equals(
								modify.getCreditOfficer())
						&& agent.getDeviceId().equals(modify.getDeviceId())
						&& dateValidation(dob).equals(dateValidation(dob1))
						&& agent.getGender().equals(modify.getGender())
						&& agent.getIsActive().equals(modify.getIsActive())
						&& agent.getAgentType().equals(modify.getAgentType())
						&& (extracted(prevCash) == extracted(mdfyCash))
						&& agent.getCommAddr1().equals(modify.getCommAddr1())
						&& agent.getCommAddr2().equals(modify.getCommAddr2())
						&& agent.getCommAddr3().equals(modify.getCommAddr3())
						&& agent.getCommAddr4().equals(modify.getCommAddr4())
						&& agent.getContactNumber().equals(getNotNullString(
								modify.getContactNumber()))
						&& agent.getEmailAddress().equals(
								modify.getEmailAddress())
						&& agent.getStartDate().equals(modify.getStartDate())
						&& dateValidation(sdate).equals(dateValidation(sdate1))
						&& agent.getAgencyCode().equals(modify.getAgencyCode())
						&& agent.getAuthStatus().equals(modify.getAuthStatus())
						&& agent.getUserName().equals(modify.getUserName())
						&& agent.getAgentLang().equals(modify.getAgentLang())
						&& agent.getCity().equals(modify.getCity())
						&& agent.getZipCode().equals(modify.getZipCode())
						&& agent.getState().equals(modify.getState())
						&& agent.getCountry().equals(modify.getCountry())
						&& agent.getLocationCode().equals(
								modify.getLocationCode())
						&& agent.getCbsagentcode().equals(modify.getCbsagentcode())
						&& agent.getAgentAccId().equals(modify.getAgentAccId())
						&& agent.getExternalDeviceId().equals(
								modify.getExternalDeviceId()) && alloctedLists) {

					if (modify.getEndDate() == null
							&& agent.getEndDate() == null) {
						LoggerUtil.ibsJobDebug("No Fields Modified : MFI01203");
						MessageUtil.addMessage("MFI01203");
						result = null;
					} else {

						if (modify.getEndDate() != null
								&& agent.getEndDate() != null) {
							if (dateValidation(edate).equals(
									dateValidation(edate1))) {
								LoggerUtil
										.ibsJobDebug("No Fields Modified : MFI01203");
								MessageUtil.addMessage("MFI01203");
								result = null;

							} else {
								boolean dev_status = loadDevice();
								if (dev_status) {
							
									super.update();
								
									LoggerUtil
											.ibsJobDebug("Agent Updated Successfully"
													+ agent.getAgentId());
									result = SUCCESS;
								}
							}
						} else {
							boolean dev_status = loadDevice();
							if (dev_status) {
								LoggerUtil
										.ibsJobDebug("Agent Updated Successfully"
												+ agent.getAgentId());
						
								super.update();
							
								result = SUCCESS;
							}
						}
					}
				} else {
					boolean dev_status = loadDevice();
					if (dev_status) {
						LoggerUtil.ibsJobDebug("Agent Updated Successfully"
								+ agent.getAgentId());
						
						super.update();
						if (!(modify.getDeviceId().equals(agent.getDeviceId()))) {
							//System.out.println("Modified DeviceId="+modify.getDeviceId());
							//System.out.println("Existing DeviceId="+agent.getDeviceId());
							
							deviceService.updateIssueDateNull(modify.getDeviceId());
							deviceService.updateDeviceIssuedDate(agent.getDeviceId());
							
						}
					
						result = SUCCESS;
					}
				}
			}
		}
		return result;
	}

	// Generate Registration Key
	public void generatekey(ActionEvent event) throws ServiceException {

		LoggerUtil.ibsJobDebug("Validation in generatekey() method");
		try {

			agentVO.setAgentId(agent.getAgentId());
			this.agent = agentService.generateRegKey(agent.getAgentId());
			Timestamp ts = Timestamp.valueOf(agent.getRegKeyExpiryTime()
					.toString());
			String formatAMPM1 = "dd-MMM-yyyy hh:mm:ss a";
			SimpleDateFormat obDateFormat1 = new SimpleDateFormat(formatAMPM1);

			MessageUtil.addMessage("MFI00705", agent.getRegKey());
			MessageUtil.addMessage("MFI00706", obDateFormat1.format(ts)
					.toString());

			agent.setAgentId(agentVO.getAgentId());

		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while validating generate key: MFI10001",
					e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while validating generate key: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}

	}

	public String getLovValue(String listName, String listValue)
			throws ServiceException {
		return ListOfValuesUtil.getLocaleValue(listName, listValue);
	}

	public boolean loadDevice() throws ServiceException {

		LoggerUtil.ibsJobDebug("Validation in loadDevice() method");
		try {
			if ((agent.getRegStatus()).equals("R")) {
				// EGALITE-227 start
				// if (!agent.getDeviceId().equals(modify.getAgentId()))
				if (!agent.getDeviceId().equals(modify.getDeviceId()))
				// EGALITE-227 end
				{
					MessageUtil.addMessage("MFI00707");
					response = false;
				} else {
					response = true;
				}
			} else {
				response = true;
			}
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while validating loadDevice: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while validating loadDevice: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}

		return response;
	}

	private String getNotNullString(String strVal) {

		return (strVal != null) ? strVal.trim() : "";
	}

	public String dateValidation(Date value) {
		LoggerUtil.ibsJobDebug(" Converting the date format :MFI00708");
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return s.format(value);
	}

	public boolean isAuthorize() {
		return !("A".equals(agent.getAuthStatus()));
	}

	public void validateAgent() {
		LoggerUtil.ibsJobDebug("Validation in validateAgent() method");
		if (modify.getFname() == null || modify.getFname().equals(" ")) {
			modify.setFname("");
		}
		if (modify.getLname() == null || modify.getLname().equals(" ")) {
			modify.setLname("");
		}
		if (modify.getCreditOfficer() == null
				|| modify.getCreditOfficer().equals(" ")) {
			modify.setCreditOfficer("");
		}
		if (modify.getDeviceId() == null || modify.getDeviceId().equals(" ")) {
			modify.setDeviceId("");
		}
		if (modify.getGender() == null || modify.getGender().equals(" ")) {
			modify.setGender("");
		}
		if (modify.getIsActive() == null || modify.getIsActive().equals(" ")) {
			modify.setIsActive("");
		}
		if (modify.getAgentType() == null || modify.getAgentType().equals(" ")) {
			modify.setAgentType("");
		}
		if (modify.getCommAddr1() == null || modify.getCommAddr1().equals(" ")) {
			modify.setCommAddr2("");
		}
		if (modify.getCommAddr2() == null || modify.getCommAddr2().equals(" ")) {
			modify.setCommAddr2("");
		}
		if (modify.getCommAddr3() == null || modify.getCommAddr3().equals(" ")) {
			modify.setCommAddr3("");
		}
		if (modify.getCommAddr4() == null || modify.getCommAddr4().equals(" ")) {
			modify.setCommAddr4("");
		}
		if (modify.getEmailAddress() == null
				|| modify.getEmailAddress().equals(" ")) {
			modify.setEmailAddress("");
		}
		if (modify.getAgencyCode() == null
				|| modify.getAgencyCode().equals(" ")) {
			modify.setAgencyCode("");
		}
		if (modify.getUserName() == null || modify.getUserName().equals(" ")) {
			modify.setUserName("");
		}
		if (modify.getContactNumber() == null
				|| modify.getContactNumber().equals(" ")) {
			modify.setContactNumber("");
		}
		if (modify.getZipCode() == null || modify.getZipCode().equals(" ")) {
			modify.setZipCode("");
		}
		if (modify.getCity() == null || modify.getCity().equals(" ")) {
			modify.setCity("");
		}
		if (modify.getState() == null || modify.getState().equals(" ")) {
			modify.setState("");
		}
		if (modify.getCountry() == null || modify.getCountry().equals(" ")) {
			modify.setCountry("");
		}
		if (modify.getLocationCode() == null
				|| modify.getLocationCode().equals(" ")) {
			modify.setLocationCode("");
		}
		if (agent.getDeviceId() == null || agent.getDeviceId().equals(" ")) {
			agent.setDeviceId("");
		}
		if (agent.getContactNumber() == null
				|| agent.getContactNumber().equals(" ")) {
			agent.setContactNumber("");
		}
		if (modify.getCbsagentcode() == null
				|| modify.getCbsagentcode().equals(" ")) {
			modify.setCbsagentcode("");
		}
		if (modify.getAgentAccId() == null
				|| modify.getAgentAccId().equals(" ")) {
			modify.setAgentAccId("");
		}
	}

	private long extracted(long mdfyCash) {
		return mdfyCash;
	}

	public List<ListValueVO> getIsActive() {
		return isActive;
	}

	public void setIsActive(List<ListValueVO> isActive) {
		this.isActive = isActive;
	}

	public String getAutoAgentId() {
		return autoAgentId;
	}

	public void setAutoAgentId(String autoAgentId) {
		this.autoAgentId = autoAgentId;
	}

	public List<ListValueVO> getGenders() {
		return genders;
	}

	public void setGenders(List<ListValueVO> genders) {
		this.genders = genders;
	}

	public List<AgencyVO> getAgencyCodes() {
		return agencyCodes;
	}

	public void setAgencyCodes(List<AgencyVO> agencyCodes) {
		this.agencyCodes = agencyCodes;
	}

	public AgencyService getAgencyService() {
		return agencyService;
	}

	public void setAgencyService(AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	public void setAgent(AgentVO agent) {
		this.agent = agent;
	}

	public AgentVO getAgent() {
		return agent;
	}

	public AgentVO getMaintenanceVO() {
		return agent;
	}

	protected AgentService getMaintenanceService() {
		return agentService;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public List<ListValueVO> getAgentTypes() {
		return agentTypes;
	}

	public void setAgentTypes(List<ListValueVO> agentTypes) {
		this.agentTypes = agentTypes;
	}

	public List<ListValueVO> getLanguages() {
		return languages;
	}

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public ExternalDeviceService getExternalDeviceService() {
		return externalDeviceService;
	}

	public void setExternalDeviceService(
			ExternalDeviceService externalDeviceService) {
		this.externalDeviceService = externalDeviceService;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public List<DeviceVO> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceVO> devices) {
		this.devices = devices;
	}

	public List<ExternalDeviceVO> getExternalDevices() {
		return externalDevices;
	}

	public void setExternalDevices(List<ExternalDeviceVO> externalDevices) {
		this.externalDevices = externalDevices;
	}

	public List<UserVO> getCreditOfficers() {
		return creditOfficers;
	}

	public void setCreditOfficers(List<UserVO> creditOfficers) {
		this.creditOfficers = creditOfficers;
	}

	public void setLanguages(List<ListValueVO> language) {
		this.languages = language;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<DeviceVO> getModifyDevices() {
		return modifyDevices;
	}

	public void setModifyDevices(List<DeviceVO> modifyDevices) {
		this.modifyDevices = modifyDevices;
	}

	public List<LocationVO> getLocationCodes() {
		return locationCodes;
	}

	public void setLocationCodes(List<LocationVO> locationCodes) {
		this.locationCodes = locationCodes;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<RoleVO> getAvailableRolesForMbs() {
		return availableRolesForMbs;
	}

	public void setAvailableRolesForMbs(List<RoleVO> availableRolesForMbs) {
		this.availableRolesForMbs = availableRolesForMbs;
	}

	public List<RoleVO> getFilteredRoles() {
		return filteredRoles;
	}

	public void setFilteredRoles(List<RoleVO> filteredRoles) {
		this.filteredRoles = filteredRoles;
	}

	public boolean shouldDisableGenerateRegKey() {
		// EGALITE-253 fixes
		if (agent == null || agent.getId() == null
				|| agent.getAuthStatus() == null
				|| ("R".equalsIgnoreCase(agent.getRegStatus())))
			return true;
		return agent.getAuthStatus().equals("A") ? false : true;

	}

	public void unregisterAgent(ActionEvent event) {
		if (agent == null || agent.getId() == null)
			return;
		try {

			getAgentService().unregisterAgent(agent.getId());
			agent.setRegStatus("U");
			agent.setAuthStatus("U");
			MessageUtil.addMessage("MFI019001", agent.getUserName());

		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("Data Access Exception", e);
			MessageUtil.addMessage("MFI019002", agent.getUserName());
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled Exception", e);
			MessageUtil.addMessage("MFI019002", agent.getUserName());
		}

	}

	public boolean shouldDisableUnregister() {

		if (agent == null || agent.getRegStatus() == null
				|| agent.getRegStatus().equals("U"))
			return true;

		return false;
	}

	private String getUnregisterPermissionString() {
		return PermissionAnnotationProcessor.getPermissionString(
				this.getClass(), PermissionType.UNREGISTER);
	}

	public String agentCreate() {
		try {
			int roleLeng = agent.getAllocatedRoles().size();
			boolean dresp = validateDob();
			if (dresp == true) {
				if (roleLeng <= 0) {
					MessageUtil.addMessage("MFI00730");
				} else {
					deviceService.updateDeviceIssuedDate(agent.getDeviceId());
					//deviceService.updateIssueDateNull(agent.getDeviceId());
					
					super.create();
					
					result = SUCCESS;

				}
			} else {
				result = FAILURE;
			}
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while matching password with confirm password : MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while  matching password with confirm password : MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	public boolean isUnregisterAllowed() {
		LoggerUtil.ibsJobDebug("checking isUnregisterAllowed");
		return authController.checkAuthority(getUnregisterPermissionString());
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}

	public CbsCodesService getCbsCodesService() {
		return cbsCodesService;
	}

	public void setCbsCodesService(CbsCodesService cbsCodesService) {
		this.cbsCodesService = cbsCodesService;
	}

	public List<CbsCodesVO> getCbsAgentCodes() {
		return cbsAgentCodes;
	}

	public void setCbsAgentCodes(List<CbsCodesVO> cbsAgentCodes) {
		this.cbsAgentCodes = cbsAgentCodes;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public RouteCodeService getRouteCodeService() {
		return routeCodeService;
	}

	public void setRouteCodeService(RouteCodeService routeCodeService) {
		this.routeCodeService = routeCodeService;
	}

	public List<AgencyVO> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<AgencyVO> countryCodes) {
		this.countryCodes = countryCodes;
	}

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

	
}
