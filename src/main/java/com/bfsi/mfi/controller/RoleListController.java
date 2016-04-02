package com.bfsi.mfi.controller;

/**
 * @className : RoleListController.java
 * @description : Class for Lists of Roles.
 * @author : Jyoti Ranjan Nayak
 */

import java.util.List;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.service.FunctionService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.RoleService;
import com.bfsi.mfi.vo.FunctionVO;
import com.bfsi.mfi.vo.RoleVO;

@ManagedBean(name = "roleListController")
@ViewScoped
public class RoleListController extends MaintenanceListController<RoleVO, Role> {
	@ManagedProperty(value = "#{roleService}")
	private RoleService roleService;
	@ManagedProperty(value = "#{functionService}")
	private FunctionService functionService;
	private RoleVO selected;
	private List<RoleVO> roles;
	private List<RoleVO> filteredDevices;

	private List<FunctionVO> funvo;

	public List<FunctionVO> getFunvo() {
		return funvo;
	}

	public void setFunvo(List<FunctionVO> funvo) {
		this.funvo = funvo;
	}

	/*
	 * public void openRegistration(ActionEvent event) { try {
	 * FacesContext.getCurrentInstance().getExternalContext()
	 * .dispatch("roleadmin/roleRegistration.xhtml"); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}

	public FunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public List<RoleVO> getFilteredDevices() {
		return filteredDevices;
	}

	public void setFilteredDevices(List<RoleVO> filteredDevices) {
		this.filteredDevices = filteredDevices;
	}

	public RoleVO getSelected() {
		return selected;
	}

	public void setSelected(RoleVO selected) {
		this.selected = selected;
	}

	public void roleSelect(SelectEvent event) {
		ConfigurableNavigationHandler nh = (ConfigurableNavigationHandler) FacesContext
				.getCurrentInstance().getApplication().getNavigationHandler();
		nh.performNavigation("viewRole?roleId=" + selected.getId()
				+ " &faces-redirect=true");
	}

	@Override
	protected MaintenanceService<RoleVO, Role> getMaintenanceService() {
		return roleService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewRole";
	}
}
