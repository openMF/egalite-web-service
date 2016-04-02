package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.RepaymentTxn;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.RepaymentTxnService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.RepaymentTxnVO;

/**
 * @className : RepaymentController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 * @date : 22-Jan-2014
 */

@ManagedBean(name = "repayController")
@ViewScoped
public class RepaymentController extends MaintenanceController<RepaymentTxnVO, RepaymentTxn> {
	
	@ManagedProperty(value = "#{repaymentService}")
	private RepaymentTxnService repaymentTxnService;
	
	private RepaymentTxnVO repaymentTxnVO=new RepaymentTxnVO();
	
	public void loadRepayment() throws ServiceException 
	{
		try
		{
			this.repaymentTxnVO = repaymentTxnService.get(repaymentTxnVO.getTxnId());
			LoggerUtil.ibsJobDebug("Repayment Loaded Successfully ...");
	} catch (ServiceException e) {
        LoggerUtil.ibsJobError("ServiceException while loading Repayment: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
	}
	catch (Exception e) {
        LoggerUtil.ibsJobError("Unhandled exception while loading Repayment: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
	}
	}

	@Override
	public RepaymentTxnVO getMaintenanceVO() {
		return (RepaymentTxnVO) repaymentTxnService;
	}

	@Override
	protected MaintenanceService<RepaymentTxnVO, RepaymentTxn> getMaintenanceService() {
		return getMaintenanceService();
	}

	public RepaymentTxnService getRepaymentTxnService() {
		return repaymentTxnService;
	}

	public void setRepaymentTxnService(RepaymentTxnService repaymentTxnService) {
		this.repaymentTxnService = repaymentTxnService;
	}

	public RepaymentTxnVO getRepaymentTxnVO() {
		return repaymentTxnVO;
	}

	public void setRepaymentTxnVO(RepaymentTxnVO repaymentTxnVO) {
		this.repaymentTxnVO = repaymentTxnVO;
	}
}