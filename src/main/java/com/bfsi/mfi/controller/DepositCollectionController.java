package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.DepositCollection;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositCollectionService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DepositCollectionVO;

/**
 * @className : DisbursementController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 * @date : 28-Jan-2014
 * 
 */

@ManagedBean(name = "depositCollectionController")
@ViewScoped
public class DepositCollectionController extends MaintenanceController<DepositCollectionVO, DepositCollection> 
{
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{depositCollectionService}")
	private DepositCollectionService depositCollectionService;
	
	private DepositCollectionVO depositCollectionVO = new DepositCollectionVO();

	public void loadDepositCollection() throws ServiceException {
		try
		{
			//System.out.println("entered" + depositCollectionVO.getTxnId());
			this.depositCollectionVO = depositCollectionService.get(depositCollectionVO.getTxnId());
		}
		catch (ServiceException e) {
			logger.error("Unexpected error while Disbursement Controller" + e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",e.getMessage());
		}
	}

	public DepositCollectionService getDepositCollectionService() {
		return depositCollectionService;
	}

	public void setDepositCollectionService(
			DepositCollectionService depositCollectionService) {
		this.depositCollectionService = depositCollectionService;
	}

	public DepositCollectionVO getDepositCollectionVO() {
		return depositCollectionVO;
	}

	public void setDepositCollectionVO(DepositCollectionVO depositCollectionVO) {
		this.depositCollectionVO = depositCollectionVO;
	}

	@Override
	public DepositCollectionVO getMaintenanceVO() {
		return (DepositCollectionVO) depositCollectionService;
	}

	@Override
	protected MaintenanceService<DepositCollectionVO, DepositCollection> getMaintenanceService() {
		return getMaintenanceService();
	}
}