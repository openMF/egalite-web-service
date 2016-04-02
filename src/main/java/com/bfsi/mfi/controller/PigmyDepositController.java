package com.bfsi.mfi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.PigmyDeposit;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositActivityService;
import com.bfsi.mfi.service.PigmyDepositService;
import com.bfsi.mfi.service.PigmyDepositViewService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DepositActivityVO;
import com.bfsi.mfi.vo.PigmyDepositVO;
import com.bfsi.mfi.vo.PigmyViewVO;

@ManagedBean(name = "pigmyDepositController")
@ViewScoped
@PermissionCollection({
	@Permission(type = PermissionType.LIST, name = "listPigmyDesposit")})
public class PigmyDepositController extends MaintenanceController <PigmyDepositVO, PigmyDeposit>{

	@ManagedProperty(value = "#{pigmyDepositService}")
	private PigmyDepositService pigmyDepositService;
	@ManagedProperty(value = "#{depositActivityService}")
	private DepositActivityService depositActivityService;
	@ManagedProperty(value = "#{pigmyDepositViewService}")
	private PigmyDepositViewService pigmyDepositViewService;
	
	private PigmyDepositVO pigmyDeposit = new PigmyDepositVO();
	private PigmyViewVO pigmyViewVO = new PigmyViewVO();
	private DepositActivityVO depositActivityVO = new DepositActivityVO();
	private List<DepositActivityVO> depositAct = new ArrayList<DepositActivityVO>();
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;	
	
	
	public ResourceBundle getMsg() {
		return msg;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	public DepositActivityVO getDepositActivityVO() {
		return depositActivityVO;
	}

	public void setDepositActivityVO(DepositActivityVO depositActivityVO) {
		this.depositActivityVO = depositActivityVO;
	}

	public PigmyDepositService getPigmyDepositService() {
		return pigmyDepositService;
	}

	public void setPigmyDepositService(PigmyDepositService pigmyDepositService) {
		this.pigmyDepositService = pigmyDepositService;
	}

	public PigmyDepositVO getPigmyDeposit() {
		return pigmyDeposit;
	}

	public void setPigmyDeposit(PigmyDepositVO pigmyDeposit) {
		this.pigmyDeposit = pigmyDeposit;
	}

	public PigmyDepositViewService getPigmyDepositViewService() {
		return pigmyDepositViewService;
	}

	public void setPigmyDepositViewService(
			PigmyDepositViewService pigmyDepositViewService) {
		this.pigmyDepositViewService = pigmyDepositViewService;
	}

	public PigmyViewVO getPigmyViewVO() {
		return pigmyViewVO;
	}

	public void setPigmyViewVO(PigmyViewVO pigmyViewVO) {
		this.pigmyViewVO = pigmyViewVO;
	}

	@Override
	protected PigmyDepositService getMaintenanceService() {
		// TODO Auto-generated method stub
		return pigmyDepositService;
	}

	@Override
	public PigmyDepositVO getMaintenanceVO() {
		// TODO Auto-generated method stub
		return pigmyDeposit;
	}
	
	public List<DepositActivityVO> getDepositAct() {
		return depositAct;
	}

	public void setDepositAct(List<DepositActivityVO> depositAct) {
		this.depositAct = depositAct;
	}

	public void loadPigmyDeposit() {
	//	PigmyDepositVO pigmyDepositVO = new PigmyDepositVO();
	//	pigmyDepositVO.setDepositAccountNumber(pigmyDeposit.getDepositAccountNumber()); 
		try {
			//this.pigmyDeposit = pigmyDepositService.get(pigmyDeposit.getId());
			this.pigmyViewVO = pigmyDepositViewService.getDepositView(pigmyViewVO.getId());
			LoggerUtil.ibsJobDebug("Geting deposit account number : "+pigmyViewVO.getId());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while initializing PigmyCustomerController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {			
			LoggerUtil.ibsJobError("Unhandled exception while initializing PigmyCustomerController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}
	
	
	public DepositActivityService getDepositActivityService() {
		return depositActivityService;
	}

	public void setDepositActivityService(
			DepositActivityService depositActivityService) {
		this.depositActivityService = depositActivityService;
	}

	// For Deposit Activity
	public void depositActivity() throws ServiceException {
		try {
			this.depositAct = depositActivityService.getDepositActivityView(pigmyViewVO.getId());
			LoggerUtil.ibsJobDebug(" Geting deposit account number for Activity:"+pigmyViewVO.getId());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while invoking loan schedule: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			 LoggerUtil.ibsJobError("Unhandled exception while invoking loan schedule : MFI10001", e);
             MessageUtil.addMessage("MFI10001",getMaintenanceVO().getId());
		}
	}
}
