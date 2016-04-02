package com.bfsi.mfi.controller;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.userdetails.UserDetails;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.GroupCodes;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.GroupCodesService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.GroupCodesVO;
import com.bfsi.mfi.vo.ListValueVO;

@ManagedBean(name = "groupCodeController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addGroupCode"),
		@Permission(type = PermissionType.MODIFY, name = "modifyGroupCode"),
		@Permission(type = PermissionType.DELETE, name = "deleteGroupCode"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authGroupCode"),
		@Permission(type = PermissionType.LIST, name = "listGroupCode") })
public class GroupCodeController extends MaintenanceController<GroupCodesVO, GroupCodes> {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{groupCodesService}")
	private GroupCodesService groupCodesService;

	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	private UserDetails userDetails;

	private GroupCodesVO existing = new GroupCodesVO();
	private GroupCodesVO groupcode = new GroupCodesVO();
	private String autoGroupCode;
	private String ibsCoId;
	private String isStatusActive;

	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}

	public String getIbsCoId() {
		userDetails = authController.getUserDetails();
		ibsCoId = userDetails.getUsername();
		//System.out.println(ibsCoId);
		return ibsCoId;
	}

	public void setIbsCoId(String ibsCoId) {
		this.ibsCoId = ibsCoId;
	}

	public GroupCodesVO getGroupcode() {
		return groupcode;
	}

	public void setGroupcode(GroupCodesVO groupcode) {
		this.groupcode = groupcode;
	}

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;

	public ResourceBundle getMsg() {
		return msg;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;

	public List<ListValueVO> getGroupCodeStatuss() {
		return groupCodeStatuss;
	}

	public void setGroupCodeStatuss(List<ListValueVO> groupCodeStatuss) {
		this.groupCodeStatuss = groupCodeStatuss;
	}

	private List<ListValueVO> groupCodeStatuss;

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public boolean isAuthorize() {
		return !("A".equals(groupcode.getAuthStatus()));
	}

	@PostConstruct
	public void init() {
		try {
			groupCodeStatuss = listservice.get("isActive");
			ListOfValuesUtil.addLocaleDescription(groupCodeStatuss);

			autoGroupCode = groupCodesService.getAutoGroupCode();
			groupcode.setId(autoGroupCode);

	

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

	public GroupCodesService getGroupCodesService() {
		return groupCodesService;
	}

	public void setGroupCodesService(GroupCodesService groupCodesService) {
		this.groupCodesService = groupCodesService;
	}

	@Override
	public String create() {
		return super.create();
	}

	public void loadGroupCode() {
		GroupCodesVO groupVO = new GroupCodesVO();
		groupVO.setId(groupcode.getId());
		// agencyVO.setAgencyCode(agency.getAgencyCode());
		try {
			this.groupcode = groupCodesService.get(groupcode.getId());
			isStatusActive= listservice.getValue(groupcode.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
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
		loadAndShowAuditTrail(groupcode);
		existing = (GroupCodesVO) groupcode.clone();
	}

	// For delete Operation with Authorize check
	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = groupCodesService.deleteGroupCode(groupcode.getId());
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

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public String checkModifyForUpdate() throws ServiceException {
		if (groupcode.getId().equals(existing.getId())
				&& groupcode.getCbsBranchCode().equals(
						existing.getCbsBranchCode())
				&& groupcode.getCbsGroupId().equals(existing.getCbsGroupId())
				&& groupcode.getGroupName().equals(existing.getGroupName())
				&& groupcode.getCbsCoId().equals(existing.getCbsCoId())
				&& groupcode.getIbsCoId().equals(existing.getIbsCoId())
				&& groupcode.getContactNumber().equals(
						existing.getContactNumber())
				&& groupcode.getIsActive().equals(existing.getIsActive())) {
			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		}

		else {
			super.update();
			result = "success";
		}
		return result;
	}

	@Override
	protected GroupCodesService getMaintenanceService() {

		return groupCodesService;
	}

	@Override
	public GroupCodesVO getMaintenanceVO() {

	
		return groupcode;
	}

}
