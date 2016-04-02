package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.DisbursementTxn;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DisbursementTxnService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DisbursementTxnVO;

/**
 * @className : DisbursementController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 * @date : 28-Jan-2014
 * 
 */

@ManagedBean(name = "disbursementController")
@ViewScoped
public class DisbursementController extends MaintenanceController<DisbursementTxnVO, DisbursementTxn> 
{
	@ManagedProperty(value = "#{disbursementTxnService}")
	private DisbursementTxnService disbursementTxnService;
	
	private DisbursementTxnVO disbursementTxnVO = new DisbursementTxnVO();

	public void loadDisbursement() throws ServiceException {
		try
		{
			this.disbursementTxnVO = disbursementTxnService.get(disbursementTxnVO.getTxnId());
			LoggerUtil.ibsJobDebug("Disbursement Loaded Successfully ...");
	} catch (ServiceException e) {
        LoggerUtil.ibsJobError("ServiceException while validating user password: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
    }
	catch (Exception e) {
        LoggerUtil.ibsJobError("Unhandled exception while validating user password: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
    }
	}
	public DisbursementTxnService getDisbursementTxnService() {
		return disbursementTxnService;
	}

	public void setDisbursementTxnService(DisbursementTxnService disbursementTxnService) {
		this.disbursementTxnService = disbursementTxnService;
	}

	public DisbursementTxnVO getDisbursementTxnVO() {
		return disbursementTxnVO;
	}

	public void setDisbursementTxnVO(DisbursementTxnVO disbursementTxnVO) {
		this.disbursementTxnVO = disbursementTxnVO;
	}

	@Override
	public DisbursementTxnVO getMaintenanceVO() {
		return (DisbursementTxnVO) disbursementTxnService;
	}

	@Override
	protected MaintenanceService<DisbursementTxnVO, DisbursementTxn> getMaintenanceService() {
		return getMaintenanceService();
	}
}