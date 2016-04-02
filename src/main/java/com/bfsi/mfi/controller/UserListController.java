package com.bfsi.mfi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.vo.UserVO;

@ManagedBean(name = "userListController")
@ViewScoped
public class UserListController extends MaintenanceListController<UserVO, User>
		implements Serializable {
	private static final long serialVersionUID = -1376002694395713795L;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected MaintenanceService<UserVO, User> getMaintenanceService() {
		return userService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewUser";
	}

}