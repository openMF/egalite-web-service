package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Branch;
import com.bfsi.mfi.service.BranchService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.vo.BranchVO;

@ManagedBean(name = "branchListController")
@ViewScoped
public class BranchListController extends
	ReadOnlyMaintenanceListController<BranchVO, Branch> {
	@ManagedProperty(value = "#{branchService}")
	private BranchService branchService;

	public BranchService getBranchService() {
		return branchService;
	}

	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}

	@Override
	protected ReadOnlyMaintenanceService<BranchVO, Branch> getReadOnlyMaintenanceService() {
		return branchService;
	}

}
