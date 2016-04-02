package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.GroupCodes;
import com.bfsi.mfi.service.GroupCodesService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.GroupCodesVO;

@ManagedBean(name = "groupCodesListController")
@ViewScoped
public class GroupCodesListController extends
                          MaintenanceListController<GroupCodesVO, GroupCodes>{
	
	@ManagedProperty(value = "#{groupCodesService}")
	private GroupCodesService groupCodesService;
	
	
	@Override
	protected String getViewRecordUrl() {
		return "viewGroupCodes";
	}

	public GroupCodesService getGroupCodesService() {
		return groupCodesService;
	}

	public void setGroupCodesService(GroupCodesService groupCodesService) {
		this.groupCodesService = groupCodesService;
	}

	@Override
	protected MaintenanceService<GroupCodesVO, GroupCodes> getMaintenanceService() {
		return groupCodesService;
	}

}
