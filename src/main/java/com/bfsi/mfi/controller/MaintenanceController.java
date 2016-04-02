package com.bfsi.mfi.controller;

import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.security.core.userdetails.UserDetails;

import com.bfsi.mfi.annotation.PermissionAnnotationProcessor;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MaintenanceVO;

/**
 * Base class for all the controllers providing Add, Modify, Delete, View,
 * Authorize functions
 * 
 * @author arun
 * 
 * @param <V>
 * @param <E>
 */

@SuppressWarnings("rawtypes")
public abstract class MaintenanceController<V extends MaintenanceVO, E extends MaintenanceEntity>
		extends ReadOnlyMaintenanceController<V, E> {

	private static final String OUTCOME_SUCCESS = "success";
	private static String loggedInUser = null;

	@ManagedProperty(value = "#{auditTrailController}")
	protected AuditTrailController auditTrailController;

	protected int version_no = 0;

	@ManagedProperty(value = "#{auth}")
	protected AuthController authController;

	protected ReadOnlyMaintenanceService<V, E> getReadOnlyMaintenanceService() {
		return getMaintenanceService();
	}

	protected abstract MaintenanceService<V, E> getMaintenanceService();

	/**
	 * @param event
	 * @return
	 * @throws ServiceException
	 */

	public String create(ActionEvent event) {
		LoggerUtil.ibsJobDebug("creating new record for controller : "
				+ this.getClass().getName());
		try {
			getMaintenanceService().create(getMaintenanceVO());
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

	public String create() {
		LoggerUtil.ibsJobDebug("creating new record for controller : "
				+ this.getClass().getName());
		try {
			getMaintenanceService().create(getMaintenanceVO());
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

	public String update() {
		LoggerUtil.ibsJobDebug("updating record for controller : "
				+ this.getClass().getName());
		try {
			getMaintenanceService().update(getMaintenanceVO());
			MessageUtil.addMessage("MFI10009", getIdForMessage());
			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while updating record: controller: "
							+ this.getClass().getName() + " : MFI10012", e);
			MessageUtil.addMessage("MFI10012");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while updating record: controller: "
							+ this.getClass().getName() + " : MFI10012", e);
			MessageUtil.addMessage("MFI10012");
		}
		return null;
	}

	public String update(ActionEvent event) {
		LoggerUtil.ibsJobDebug("updating record for controller : "
				+ this.getClass().getName());
		try {
			getMaintenanceService().update(getMaintenanceVO());
			MessageUtil.addMessage("MFI10009", getIdForMessage());
			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while updating record: controller: "
							+ this.getClass().getName() + " : MFI10012", e);
			MessageUtil.addMessage("MFI10012");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while updating record: controller: "
							+ this.getClass().getName() + " : MFI10012", e);
			MessageUtil.addMessage("MFI10012");
		}
		return null;
	}

	public void authorize(ActionEvent event) {
		LoggerUtil.ibsJobDebug("authorize record for controller : "
				+ this.getClass().getName());
		try {
			getMaintenanceService().authorize(getMaintenanceVO());
			MessageUtil.addMessage("MFI10010", getIdForMessage());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while updating record: controller: "
							+ this.getClass().getName() + " : MFI10015", e);
			MessageUtil.addMessage("MFI10015");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while updating record: controller: "
							+ this.getClass().getName() + " : MFI10015", e);
			MessageUtil.addMessage("MFI10015");
		}
	}

	public void authorize() {
		LoggerUtil.ibsJobDebug("authorize record for controller : "
				+ this.getClass().getName());
		try {
			getMaintenanceService().authorize(getMaintenanceVO());
			MessageUtil.addMessage("MFI10010", getIdForMessage());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while authorizing record: controller: "
							+ this.getClass().getName() + " : MFI10015", e);
			MessageUtil.addMessage("MFI10015");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while authorizing record: controller: "
							+ this.getClass().getName() + " : MFI10015", e);
			MessageUtil.addMessage("MFI10015");
		}
	}

	public String delete() {
		LoggerUtil.ibsJobDebug("delete record for controller : "
				+ this.getClass().getName());
		try {
			getMaintenanceService().delete(getMaintenanceVO());
			MessageUtil.addMessage("MFI10011", getIdForMessage());
			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while deleteing record: controller: "
							+ this.getClass().getName() + " : MFI10013", e);
			MessageUtil.addMessage("MFI10013");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while deleteing record: controller: "
							+ this.getClass().getName() + " : MFI10013", e);
			MessageUtil.addMessage("MFI10013");
		}
		return null;

	}

	protected void loadAndShowAuditTrail(V vo) {
		LoggerUtil.ibsJobDebug("loadAndShowAuditTrail for controller : "
				+ this.getClass().getName() + " id: " + vo.getId());
		try {
			auditTrailController.setEnabled(true);
			auditTrailController.setAuditTrails(getMaintenanceService()
					.getAllAuditTrails(vo));
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loadAndShowAuditTrail controller: "
							+ this.getClass().getName() + " : MFI10016", e);
			MessageUtil.addMessage("MFI10016");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while loadAndShowAuditTrail controller: "
							+ this.getClass().getName() + " : MFI10016", e);
			MessageUtil.addMessage("MFI10016");
		}
	}

	public boolean isListAllowed() {
		LoggerUtil.ibsJobDebug("checking isListAllowed");
		return authController.checkAuthority(getListPermissionString());
	}

	public boolean isAddAllowed() {
		LoggerUtil.ibsJobDebug("checking isAddAllowed");
		return authController.checkAuthority(getAddPermissionString());
	}

	public boolean isModifyAllowed() {
		LoggerUtil.ibsJobDebug("checking isModifyAllowed");
		return authController.checkAuthority(getModifyAuthority());
	}

	public boolean isAuthorizeAllowed() {
		LoggerUtil.ibsJobDebug("checking isAuthorizeAllowed");
		boolean value = true;
		try {
			if (!checkAuthority(getAuthorizePermissionString())) {
				value = false;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while isAuthorizeAllowed controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			value = false;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while isAuthorizeAllowed controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			value = false;
		}
		return value;
	}

	public boolean isAuthorizeEnable() {
		LoggerUtil.ibsJobDebug("checking isAuthorizeEnable");
		try{
		V vo = getMaintenanceVO();
		if ("A".equals(vo.getAuthStatus())) {
			// record already authorized, so dont allow
			return true;
		}
		// now record is not authorized
		// dont allow maker to authorize his own record
		UserDetails loggedInUser = getUserDetails();
		// String userId = getMaker(vo);
		List<String> makerIds = getMaker(vo);

		if (makerIds.contains(loggedInUser.getUsername())
				|| getMaintenanceVO().getId().equalsIgnoreCase(
						loggedInUser.getUsername())) {//
			return true;
		}
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while isAuthorizeEnable controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while isAuthorizeEnable controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		/*
		 * if (loggedInUser.getUsername().equals(userId)) { // both maker and
		 * logged in user are same, so disallow
		 * 
		 * }
		 */
		return false;
	}

	public boolean isDeleteAllowed() throws ServiceException {
		LoggerUtil.ibsJobDebug("checking isDeleteAllowed");
		boolean value = true;
		if (!checkAuthority(getDeletePermissionString())) {
			value = false;
		}
		/*
		 * version_no =
		 * getMaintenanceService().getMakerVersion(getMaintenanceVO());
		 * 
		 * V vo = getMaintenanceVO(); UserDetails details = getUserDetails();
		 * loggedInUser = details.getUsername(); //makerId = getMaker(vo);
		 * List<String> makerIds = getMaker(vo);
		 * 
		 * if (version_no == 1 && makerIds.contains(loggedInUser)) { return
		 * false; } else if (version_no == 0 && makerIds.contains(loggedInUser))
		 * { return true; } else if (version_no == 0 &&
		 * (!makerIds.contains(loggedInUser))) { return false; } else { return
		 * false; }
		 */
		return value;
	}

	public boolean isEnableDeleteAllowed() throws ServiceException {
		LoggerUtil.ibsJobDebug("checking isEnableDeleteAllowed");
		version_no = getMaintenanceService()
				.getMakerVersion(getMaintenanceVO());

		V vo = getMaintenanceVO();
		UserDetails details = getUserDetails();
		loggedInUser = details.getUsername();
		// makerId = getMaker(vo);
		List<String> makerIds = getMaker(vo);

		if (version_no == 1 && makerIds.contains(loggedInUser)) {
			return true;
		} else if (version_no == 0 && makerIds.contains(loggedInUser)) {
			return false;
		} else if (version_no == 0 && (!makerIds.contains(loggedInUser))) {
			return true;
		} else {
			return true;
		}
	}

	public boolean isEnableAuthorizeAllowed() throws ServiceException {
		LoggerUtil.ibsJobDebug("checking isEnableAuthorizeAllowed");
		boolean btn = isAuthorizeAllowed();

		if (btn) {
			btn = false;
		} else {
			return true;
		}
		return btn;
	}

	protected final String getAuthorizePermissionString() {
		return PermissionAnnotationProcessor.getPermissionString(
				this.getClass(), PermissionType.AUTHORIZE);
	}

	protected final String getListPermissionString() {
		return PermissionAnnotationProcessor.getPermissionString(
				this.getClass(), PermissionType.LIST);
	}

	protected final String getAddPermissionString() {
		return PermissionAnnotationProcessor.getPermissionString(
				this.getClass(), PermissionType.ADD);
	}

	protected String getModifyAuthority() {
		return PermissionAnnotationProcessor.getPermissionString(
				this.getClass(), PermissionType.MODIFY);
	}

	protected String getDeletePermissionString() {
		return PermissionAnnotationProcessor.getPermissionString(
				this.getClass(), PermissionType.DELETE);
	}

	protected final String getRejectedPermissionString() {
		return PermissionAnnotationProcessor.getPermissionString(
				this.getClass(), PermissionType.REJECT);
	}
	
	/*
	 * protected abstract V getMaintenanceVO();
	 * 
	 * protected abstract MaintenanceService<V, E> getMaintenanceService();
	 */

	public AuditTrailController getAuditTrailController() {
		return auditTrailController;
	}

	public void setAuditTrailController(
			AuditTrailController auditTrailController) {
		this.auditTrailController = auditTrailController;
	}

	public boolean checkAuthority(String command) {
		return authController.checkAuthority(command);
	}

	public boolean checkAuthorityHasAny(String... commands) {
		return authController.checkAuthorityHasAny(commands);
	}

	public boolean checkAuthorityHasAll(String... commands) {
		return authController.checkAuthorityHasAll(commands);
	}

	public UserDetails getUserDetails() {
		return authController.getUserDetails();
	}

	public List<String> getMaker(V vo) {
		LoggerUtil.ibsJobDebug("getting maker lsit for " + vo.getId());
		List<String> response = null;
		try {
			response = getMaintenanceService().getMaker(vo);
		} 		
		catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while getting maker list controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while getting maker list controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return response;
	}

	public AuthController getAuthController() {
		return authController;
	}

	public void setAuthController(AuthController authController) {
		this.authController = authController;
	}
}