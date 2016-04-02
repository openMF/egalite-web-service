package com.bfsi.mfi.controller;

/**
 * @className : RoleMbsListController.java
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
import com.bfsi.mfi.entity.RoleMbs;
import com.bfsi.mfi.service.FunctionService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.RoleMbsService;
import com.bfsi.mfi.vo.FunctionVO;
import com.bfsi.mfi.vo.RoleMbsVO;

@ManagedBean(name = "roleMbsListController")
@ViewScoped
public class RoleMbsListController extends MaintenanceListController<RoleMbsVO, RoleMbs> {
	@ManagedProperty(value = "#{roleMbsService}")
	private RoleMbsService roleMbsService;
	@ManagedProperty(value = "#{functionService}")
	private FunctionService functionService;
	private RoleMbsVO selected;
	private List<RoleMbsVO> roles;
	private List<RoleMbsVO> filteredDevices;

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

	public RoleMbsService getRoleMbsService() {
		return roleMbsService;
	}

	public void setRoleMbsService(RoleMbsService roleMbsService) {
		this.roleMbsService = roleMbsService;
	}


	public List<RoleMbsVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleMbsVO> roles) {
		this.roles = roles;
	}

	public FunctionService getFunctionService() {
		return functionService;
	}

	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public List<RoleMbsVO> getFilteredDevices() {
		return filteredDevices;
	}

	public void setFilteredDevices(List<RoleMbsVO> filteredDevices) {
		this.filteredDevices = filteredDevices;
	}

	public RoleMbsVO getSelected() {
		return selected;
	}

	public void setSelected(RoleMbsVO selected) {
		this.selected = selected;
	}

	public void roleSelect(SelectEvent event) {
		ConfigurableNavigationHandler nh = (ConfigurableNavigationHandler) FacesContext
				.getCurrentInstance().getApplication().getNavigationHandler();
		nh.performNavigation("viewRole?roleId=" + selected.getId()
				+ " &faces-redirect=true");
	}

	@Override
	protected MaintenanceService<RoleMbsVO, RoleMbs> getMaintenanceService() {
		return roleMbsService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewMbsRole";
	}
}
