package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CashDeposit;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CashDepositTxnService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CashDepositVO;


@ManagedBean(name = "cashDepositTxnController")
@ViewScoped

public class CashDepositTxnController extends
                         MaintenanceController<CashDepositVO, CashDeposit>{
	
	@ManagedProperty(value = "#{cashDepositTxnService}")
	private CashDepositTxnService cashDepositTxnService;
	
	private CashDepositVO cashDepositVO = new CashDepositVO();
	
	public CashDepositTxnService getCashDepositTxnService() {
		return cashDepositTxnService;
	}

	public void setCashDepositTxnService(CashDepositTxnService cashDepositTxnService) {
		this.cashDepositTxnService = cashDepositTxnService;
	}

	public CashDepositVO getCashDepositVO() {
		return cashDepositVO;
	}

	public void setCashDepositVO(CashDepositVO cashDepositVO) {
		this.cashDepositVO = cashDepositVO;
	}
	
	public void loadCashDeposit() throws ServiceException {
		try {
			String id = cashDepositVO.getId();
			this.cashDepositVO = cashDepositTxnService.get(id);
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loadCashDeposit CashDepositTxnController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}
	
	@Override
	public CashDepositVO getMaintenanceVO() {
		return (CashDepositVO) cashDepositTxnService;
	}

	@Override
	protected MaintenanceService<CashDepositVO, CashDeposit> getMaintenanceService() {
		return getMaintenanceService();
	}


}
