package com.bfsi.mfi.controller;

/**
 * @className : RoleControllerForMbs.java
 * @description : Controller class for Roles Managements
 * @author : Bablu kumar
 */
import java.util.ArrayList;
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
import com.bfsi.mfi.entity.RoleMbs;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.FunctionMbsService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.RoleMbsService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.FunctionMbsVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.RoleMbsVO;

@ManagedBean(name = "roleMbsController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addMbsRole"),
		@Permission(type = PermissionType.MODIFY, name = "modifyMbsRole"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authMbsRole"),
		@Permission(type = PermissionType.LIST, name = "listMbsRoles"),
		@Permission(type = PermissionType.DELETE, name = "deleteMbsRole") })
public class RoleMbsController extends
		MaintenanceController<RoleMbsVO, RoleMbs> {
	
	@ManagedProperty(value = "#{roleMbsService}")
	private RoleMbsService roleMbsService;
	
	@ManagedProperty(value = "#{functionMbsService}")
	private FunctionMbsService functionMbsService;
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	
	private static String result, roleType = "M";
	private static final String OUTCOME_SUCCESS = "success", ADMIN_ROLE = "ROL00000";
	private String autoRoleId , isStatusActive;
	
	private RoleMbsVO rolembs = new RoleMbsVO();
	private RoleMbsVO existing = new RoleMbsVO();
	private FunctionMbsVO functionMbs = new FunctionMbsVO();
	
	private List<String> allFunctions;
	private List<FunctionMbsVO> functionsmbsfunc;
	private List<RoleMbsVO> roleMbsVo;
	private List<ListValueVO> roleStatuss , roleTypes;

	@PostConstruct
	public void init() {

		autoRoleId = roleMbsService.getAutoRoleId(); // <!-- Role Id is added for Asomi by Nirmal kanna S -->  
		rolembs.setId(autoRoleId);
		
		roleStatuss = listservice.get("roleStatus");
		ListOfValuesUtil.addLocaleDescription(roleStatuss);

		roleTypes = listservice.get("roleType");
		ListOfValuesUtil.addLocaleDescription(roleTypes);

		try {
			functionsmbsfunc = functionMbsService.getMbsFunction();
			LoggerUtil.ibsJobDebug("Initializing functions :");
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while Initializing roles functionsmbs: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while initializing functions: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}

	}

	public String create() {

		if (rolembs.getFunctionsmbs().isEmpty()) {
			MessageUtil.addMessage("MFI01400");
			return null;
		} else {
			super.create(null);
		}
		return OUTCOME_SUCCESS;
	}

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 */
	public String checkModifyForUpdate() {
		String roleId = rolembs.getId();
		List<String> list = new ArrayList<String>(); 
		rolembs.setRoleName(rolembs.getRoleName().trim());
		rolembs.setFunctionsmbs(rolembs.getFunctionsmbs());
		//String rolecheckstatus = validateRoleStatus();

		boolean booleanFuncLists = rolembs.getFunctionsmbs().size() == existing
				.getFunctionsmbs().size() && rolembs.getFunctionsmbs().containsAll(
						existing.getFunctionsmbs());
		
		boolean brole = rolembs.getRoleName().equals(existing.getRoleName());
		boolean brdesc = rolembs.getRoleDesc().equals(existing.getRoleDesc());
		boolean brstatus = rolembs.getRoleStatus().equals(existing.getRoleStatus());
		
		if ((brole && brdesc && brstatus && booleanFuncLists) == true) 
		{
			MessageUtil.addMessage("MFI01203");
			return null;
		}
		/*else if (!rolecheckstatus.equals(OUTCOME_SUCCESS)
				&& rolembs.getRoleStatus().equalsIgnoreCase("I")) {
			MessageUtil.addMessage("MFI01402");
			return null;
		}*/ 
		else {
			update();
			for(int i=0; i<rolembs.getFunctionsmbs().size(); i++)
			{
				FunctionMbsVO t = rolembs.getFunctionsmbs().get(i);
				list.add(t.getId());
			}
			roleMbsService.modifyRoleEntitlements(roleId, list);
		}
		return OUTCOME_SUCCESS;
	}

	/*// Modification done.
	public String update() {
		
		
		try {
			String result=checkModifyForUpdate();
			if(result==null)
				return null;
			getRoleMbsService().updateEntitlements(rolembs, rolembs);
			LoggerUtil.ibsJobDebug("Role modify sucess for id : MFI10009"
					+ getIdForMessage());
			MessageUtil.addMessage("MFI10009", getIdForMessage());// message
																	// show
																	// "roleName"
																	// here.
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while updating entitlements : MFI10012",
					e);
			MessageUtil.addMessage("MFI10012", getMaintenanceVO().getId());
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unexpected error while updating entitlements : MFI10012",
					e);
			MessageUtil.addMessage("MFI10012", getMaintenanceVO().getId());
		}
		return OUTCOME_SUCCESS;
	}*/

	public RoleMbsService getRoleMbsService() {
		return roleMbsService;
	}

	public void setRoleMbsService(RoleMbsService roleMbsService) {
		this.roleMbsService = roleMbsService;
	}

	@Override
	public RoleMbsVO getMaintenanceVO() {
		rolembs.setRoleType(roleType);
		return rolembs;
	}

	public FunctionMbsVO getFunctionMbsVO() {
		return functionMbs;
	}

	public void setFunctionMbsVO(FunctionMbsVO functionMbsVO) {
		this.functionMbs = functionMbsVO;
	}

	@Override
	protected RoleMbsService getMaintenanceService() {
		return roleMbsService;
	}

	/**
	 * Called when an existing rolembs is opened for viewing / modifying
	 */
	public void loadRole() {
		try {
			this.rolembs = roleMbsService.get(rolembs.getId());
			isStatusActive = listservice.getValue(rolembs.getRoleStatus(),
					ListValue.LIST_NAME_AGENT_STATUS);
			LoggerUtil.ibsJobDebug("Load Roles base on roleId : "
					+ rolembs.getId() + " : MFI10001");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while get rolembs base on roleId : MFI10001"
							+ rolembs.getId(), e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while get rolembs base on : roleId="
							+ rolembs.getId() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}

		existing = (RoleMbsVO) rolembs.clone();
		loadAndShowAuditTrail(rolembs);
	}

	public FunctionMbsService getFunctionMbsService() {
		return functionMbsService;
	}

	public void setFunctionMbsService(FunctionMbsService functionMbsService) {
		this.functionMbsService = functionMbsService;
	}

	public RoleMbsVO getRolembs() {
		return rolembs;
	}

	public void setRolembs(RoleMbsVO rolembs) {
		this.rolembs = rolembs;
	}

	public FunctionMbsVO getFunctionMbs() {
		return functionMbs;
	}

	public void setFunctionMbs(FunctionMbsVO functionMbs) {
		this.functionMbs = functionMbs;
	}

	public List<String> getAllFunctions() {
		return allFunctions;
	}

	public void setAllFunctions(List<String> allFunctions) {
		this.allFunctions = allFunctions;
	}

	public boolean isAuthorize() {
		return !("A".equals(rolembs.getAuthStatus()));
	}

	/**
	 * Validates Role Name as name types it. Checks for presence of special
	 * characters and availability of Role Name
	 * 
	 * @throws ServiceException
	 */
	public String validateRoleName() {
		String roleName = rolembs.getRoleName().trim();

		// check availability of user id
		try {
			if (!roleMbsService.isRoleNameAvailable(roleName)) {
				MessageUtil.addMessage("MFI01401");
				result = "failure";
			} else {
				result = OUTCOME_SUCCESS;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while validating roleName : " + roleName
							+ ": MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while while validating roleName : "
							+ roleName + ": MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}
		return result;
	}

	/**
	 * Call the create method after validations.
	 * 
	 * */
	public String createRole() {
		String name;
		name = validateRoleName();
		rolembs.setRoleName(rolembs.getRoleName().trim());
		try {
			if (name.equals(OUTCOME_SUCCESS)) {
				roleMbsService.addRoleMBS(rolembs);
				LoggerUtil.ibsJobDebug("Creating Role : " + name);
				MessageUtil.addMessage("MFI10008", rolembs.getId());
				result = OUTCOME_SUCCESS;
			}
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while creating rolembs : " + name
							+ ": MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			e.printStackTrace();
		}
		return result;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	/**
	 * For rolembs if it is admin rolembs then no one able to modify.
	 * 
	 * */
	@Override
	public boolean isModifyAllowed() {
		if (this.rolembs.getId().equalsIgnoreCase(ADMIN_ROLE)) {
			return false;
		} else {
			return super.isModifyAllowed();
		}
	}

	@Override
	public String getIdForMessage() {
		return getMaintenanceVO().getRoleName();
	}

	// For Delete Operation
	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = roleMbsService.deleteRole(rolembs.getId());
			LoggerUtil.ibsJobDebug("Deleting unauthorized rolembs: "
					+ getMaintenanceVO().getId() + ": MFI10011");
			MessageUtil.addMessage("MFI10011", getMaintenanceVO().getId());
			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"Unexpected error while deleting unauthorizes rolembs :"
							+ getMaintenanceVO().getId() + ": MFI10013", e);
			MessageUtil.addMessage("MFI10013", getMaintenanceVO().getId());
			result = "failure";
		}
		return result;
	}

	// for check rolembs to active or inactive
	// For ModifyUniqueId
	public String validateRoleStatus() {
		String roleId = rolembs.getId().trim();
		try {
			if (!roleMbsService.isRoleStatustoInactive(roleId)) {
				result = "failure";
			} else {
				result = OUTCOME_SUCCESS;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while Checking roleName :"
					+ roleId + ": MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while validating rolembs status : MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}
		return result;
	}

	public List<FunctionMbsVO> getFunctionsmbsfunc() {
		return functionsmbsfunc;
	}

	public void setFunctionsmbsfunc(List<FunctionMbsVO> functionsmbsfunc) {
		this.functionsmbsfunc = functionsmbsfunc;
	}

	public List<RoleMbsVO> getRoleMbsVo() {
		return roleMbsVo;
	}

	public void setRoleMbsVo(List<RoleMbsVO> roleMbsVo) {
		this.roleMbsVo = roleMbsVo;
	}
	
	public String getRoleType() {
		return roleType;
	}

	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}

	public List<ListValueVO> getRoleStatuss() {
		return roleStatuss;
	}

	public void setRoleStatuss(List<ListValueVO> roleStatuss) {
		this.roleStatuss = roleStatuss;
	}

	public List<ListValueVO> getRoleTypes() {
		return roleTypes;
	}

	public void setRoleTypes(List<ListValueVO> roleTypes) {
		this.roleTypes = roleTypes;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}	
	

}
