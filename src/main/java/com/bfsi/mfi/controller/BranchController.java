package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.bfsi.mfi.entity.Branch;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.BranchService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.BranchVO;

@ManagedBean(name = "branchController")

public class BranchController extends MaintenanceController<BranchVO, Branch> {

	@ManagedProperty(value = "#{branchService}")
	private BranchService branchService;
	private BranchVO branch = new BranchVO();
	

	public BranchService getBranchService() {
		return branchService;
	}


	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}


	public BranchVO getBranch() {
		return branch;
	}


	public void setBranch(BranchVO branch) {
		this.branch = branch;
	}


	public void loadBranch() {
		BranchVO branchVO = new BranchVO();
		branchVO.setBranchCode(branch.getBranchCode());
		try {
			this.branch = branchService.get(branch.getBranchCode());
			LoggerUtil.ibsJobDebug("Branch Code not Available: MFI00602");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading Branch: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading Branch: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	@Override
	protected BranchService getMaintenanceService() {

		return branchService;
	}

	@Override
	public BranchVO getMaintenanceVO() {
		return branch;
	}
	
	
}