package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Deposit;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DepositVO;

/**
 * @className : DepositController.java
 * @description : Controller class for 
 * @author : Nirmal kanna S
 * @date : 28-Jan-2014
 * 
 */

@ManagedBean(name = "depositController")
@ViewScoped
public class DepositController extends MaintenanceController<DepositVO, Deposit> 
{
	@ManagedProperty(value = "#{depositService}")
	private DepositService depositService;
	
	private DepositVO depositVO = new DepositVO();

	public void loadDisbursement() throws ServiceException {
		try
		{
			this.depositVO = depositService.get(depositVO.getId());
		}
		catch (ServiceException e) {
			logger.error("Unexpected error while Disbursement Controller" + e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",e.getMessage());
		}
	}

	public DepositService getDepositService() {
		return depositService;
	}

	public void setDepositService(DepositService depositService) {
		this.depositService = depositService;
	}

	public DepositVO getDepositVO() {
		return depositVO;
	}

	public void setDepositVO(DepositVO depositVO) {
		this.depositVO = depositVO;
	}

	@Override
	public DepositVO getMaintenanceVO() {
		return (DepositVO) depositService;
	}

	@Override
	protected MaintenanceService<DepositVO, Deposit> getMaintenanceService() {
		return getMaintenanceService();
	}
}