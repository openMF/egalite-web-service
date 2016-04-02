package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.DepositMaturity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositMaturityService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DepositMaturityVO;

/**
 * @className : DisbursementController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 * @date : 28-Jan-2014
 * 
 */

@ManagedBean(name = "depositMaturityController")
@ViewScoped
public class DepositMaturityController extends MaintenanceController<DepositMaturityVO, DepositMaturity> 
{
	@ManagedProperty(value = "#{depositMaturityService}")
	private DepositMaturityService depositMaturityService;
	
	private DepositMaturityVO depositMaturityVO = new DepositMaturityVO();

	public void loadDepositMaturity() throws ServiceException {
		try
		{
			//System.out.println(depositMaturityVO.getTxnId());
			String id = depositMaturityVO.getTxnId();
			this.depositMaturityVO = depositMaturityService.get(id);
		}
		catch (ServiceException e) {
			logger.error("Unexpected error while DepositMaturity Controller" + e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",e.getMessage());
		}
	}
	
	public DepositMaturityService getDepositMaturityService() {
		return depositMaturityService;
	}

	public void setDepositMaturityService(
			DepositMaturityService depositMaturityService) {
		this.depositMaturityService = depositMaturityService;
	}

	public DepositMaturityVO getDepositMaturityVO() {
		return depositMaturityVO;
	}

	public void setDepositMaturityVO(DepositMaturityVO depositMaturityVO) {
		this.depositMaturityVO = depositMaturityVO;
	}

	@Override
	public DepositMaturityVO getMaintenanceVO() {
		return (DepositMaturityVO) depositMaturityService;
	}

	@Override
	protected MaintenanceService<DepositMaturityVO, DepositMaturity> getMaintenanceService() {
		return getMaintenanceService();
	}
}