package com.bfsi.mfi.controller;

/**
 * @className : RoleController.java
 * @description : Controller class for Roles Managements
 * @author : Jyoti Ranjan Nayak
 */
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
import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.entity.TreeBean;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.FunctionService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.RoleService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.FunctionVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.RoleVO;

@ManagedBean(name = "roleController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addRole"),
		@Permission(type = PermissionType.MODIFY, name = "modifyRole"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authRole"),
		@Permission(type = PermissionType.LIST, name = "listRoles"),
		@Permission(type = PermissionType.DELETE, name = "deleteRole") })
public class RoleController extends MaintenanceController<RoleVO, Role> {
	@ManagedProperty(value = "#{roleService}")
	private RoleService roleService;
	@ManagedProperty(value = "#{functionService}")
	private FunctionService functionService;
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	private static final String ADMIN_ROLE = "ROL00000";
	private final String roleType = "I";
	public String getRoleType() {
		return roleType;
	}
	

	private RoleVO role = new RoleVO();
	private RoleVO existing = new RoleVO();
	private FunctionVO function = new FunctionVO();
	private TreeBean treeBean;
	private List<String> allFunctions;
	private String isStatusActive;
	private String autoRoleId;
	
	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}

	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	private List<ListValueVO> roleStatuss;
	private List<ListValueVO> roleTypes;

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

	@PostConstruct
	public void init() {
        
		autoRoleId = roleService.getAutoRoleId();
		role.setId(autoRoleId);
		
		roleStatuss = listservice.get("roleStatus");
		ListOfValuesUtil.addLocaleDescription(roleStatuss);
		
		roleTypes = listservice.get("roleType");
		ListOfValuesUtil.addLocaleDescription(roleTypes);
		
		try {
			treeBean = new TreeBean(functionService.get());
			LoggerUtil.ibsJobDebug("Initializing functions :");
		} catch (ServiceException e) {
			 LoggerUtil.ibsJobError("ServiceException while Initializing roles functions: MFI10001", e);
             MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while initializing functions: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}

	}

	public String create() {
		role.setFunctions(treeBean.getSelectedFunctions());
       
		if (role.getFunctions().isEmpty()) {
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
		role.setRoleName(role.getRoleName().trim());
		role.setFunctions(treeBean.getSelectedFunctions());
		String rolecheckstatus;
		rolecheckstatus = validateRoleStatus();

		boolean booleanFuncLists = role.getFunctions().size() == existing
				.getFunctions().size()
				&& role.getFunctions().containsAll(existing.getFunctions());

		if ((role.getRoleName().equals(existing.getRoleName()))
				&& (role.getRoleDesc().equals(existing.getRoleDesc()))
				&& (role.getRoleStatus().equals(existing.getRoleStatus()))
				&& (role.getRoleType().equals(existing.getRoleType()))
				&& (booleanFuncLists)) {
			MessageUtil.addMessage("MFI01203");
			return null;
		} 
		else if(!rolecheckstatus.equals(OUTCOME_SUCCESS) && role.getRoleStatus().equalsIgnoreCase("I"))	
		{
			MessageUtil.addMessage("MFI01402");
			return null;
		}else {
			update();
		}
		return OUTCOME_SUCCESS;
	}

	// Modification done.
	public String update() {
		RoleVO newRole = new RoleVO();
		newRole.setId(role.getId());
		newRole.setFunctions(treeBean.getSelectedFunctions());

		try {
			getRoleService().updateEntitlements(role, newRole);
			LoggerUtil.ibsJobDebug("Role modify sucess for id : MFI10009"+getIdForMessage());
			MessageUtil.addMessage("MFI10009", getIdForMessage());// message show "roleName" here.
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while updating entitlements : MFI10012", e);
			MessageUtil.addMessage("MFI10012",getMaintenanceVO().getId());
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unexpected error while updating entitlements : MFI10012", e);
			MessageUtil.addMessage("MFI10012",getMaintenanceVO().getId());
		}
		return OUTCOME_SUCCESS;
	}
	public TreeBean getTreeBean() {
		return treeBean;
	}

	public void setTreeBean(TreeBean treeBean) {
		this.treeBean = treeBean;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public RoleVO getMaintenanceVO() {
		role.setRoleType(roleType);
		return role;
	}

	public FunctionVO getFunctionVO() {
		return function;
	}

	public void setFunctionVO(FunctionVO functionVO) {
		this.function = functionVO;
	}

	@Override
	protected RoleService getMaintenanceService() {
		return roleService;
	}

	/**
	 * Called when an existing role is opened for viewing / modifying
	 */
	public void loadRole() {
		try {
			this.role = roleService.get(role.getId());
			isStatusActive= listservice.getValue(role.getRoleStatus(),ListValue.LIST_NAME_AGENT_STATUS);
			LoggerUtil.ibsJobDebug("Load Roles base on roleId : "+role.getId() +" : MFI10001");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while get role base on roleId : MFI10001"+role.getId(), e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while get role base on : roleId="+role.getId()+ " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		treeBean.setSelectedFunctions(role.getFunctions());

		existing = (RoleVO) role.clone();
		loadAndShowAuditTrail(role);
	}

	public FunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public RoleVO getRole() {
		return role;
	}

	public void setRole(RoleVO role) {
		this.role = role;
	}

	public FunctionVO getFunction() {
		return function;
	}

	public void setFunction(FunctionVO function) {
		this.function = function;
	}

	public List<String> getAllFunctions() {
		return allFunctions;
	}

	public void setAllFunctions(List<String> allFunctions) {
		this.allFunctions = allFunctions;
	}

	public boolean isAuthorize() {
		return !("A".equals(role.getAuthStatus()));
	}

	/**
	 * Validates Role Name as name types it. Checks for presence of special
	 * characters and availability of Role Name
	 * 
	 * @throws ServiceException
	 */
	public String validateRoleName() {
		String roleName = role.getRoleName().trim();

		// check availability of user id
		try {
			if (!roleService.isRoleNameAvailable(roleName)) {
				MessageUtil.addMessage("MFI01401");
				result = "failure";
			} else {
				result = OUTCOME_SUCCESS;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while validating roleName : "+roleName +": MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}catch (Exception e) {
            LoggerUtil.ibsJobError("Unhandled exception while while validating roleName : "+roleName+ ": MFI10001", e);
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
		role.setRoleName(role.getRoleName().trim());
		try {
			if (name.equals(OUTCOME_SUCCESS)) {
				create();
				LoggerUtil.ibsJobDebug("Creating Role : "+name);
				result = OUTCOME_SUCCESS;
			} else {
				result = "";
			}
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while creating role : "+name +": MFI10001", e);
            MessageUtil.addMessage("MFI10001");
			e.printStackTrace();
		}
		return result;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	/**
	 * For role if it is admin role then no one able to modify.
	 * 
	 * */
	@Override
	public boolean isModifyAllowed() {
		if (this.role.getId().equalsIgnoreCase(ADMIN_ROLE)) {
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
			result = roleService.deleteRole(role.getId());
			LoggerUtil.ibsJobDebug("Deleting unauthorized role: "+getMaintenanceVO().getId() + ": MFI10011");
			MessageUtil.addMessage("MFI10011",getMaintenanceVO().getId());
			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while deleting unauthorizes role :"+getMaintenanceVO().getId()+ ": MFI10013", e);
            MessageUtil.addMessage("MFI10013",getMaintenanceVO().getId());
			result = "failure";
		}
		return result;
	}

	// for check role to active or inactive
	// For ModifyUniqueId
	public String validateRoleStatus() {
		String roleId = role.getId().trim();
		try {
			if (!roleService.isRoleStatustoInactive(roleId)) {
				result = "failure";
			} else {
				result = OUTCOME_SUCCESS;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while Checking roleName :"+roleId +": MFI10001", e);
            MessageUtil.addMessage("MFI10001");
			result = "failure";
		} catch (Exception e) {
            LoggerUtil.ibsJobError("Unhandled exception while validating role status : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
            result = "failure";
     }
		return result;
	}
}
