package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CashWithdrawal;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CashWithdrawalTxnservice;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CashWithdrawalVO;

@ManagedBean(name = "cashWithdrawalTxnController")
@ViewScoped
public class CashWithdrawalTxnController extends
		MaintenanceController<CashWithdrawalVO, CashWithdrawal> {

	@ManagedProperty(value = "#{cashWithdrawalTxnservice}")
	private CashWithdrawalTxnservice cashWithdrawalTxnservice;

	public CashWithdrawalTxnservice getCashWithdrawalTxnservice() {
		return cashWithdrawalTxnservice;
	}

	public void setCashWithdrawalTxnservice(
			CashWithdrawalTxnservice cashWithdrawalTxnservice) {
		this.cashWithdrawalTxnservice = cashWithdrawalTxnservice;
	}

	private CashWithdrawalVO cashWithdrawalVO = new CashWithdrawalVO();

	public CashWithdrawalVO getCashWithdrawalVO() {
		return cashWithdrawalVO;
	}

	public void setCashWithdrawalVO(CashWithdrawalVO cashWithdrawalVO) {
		this.cashWithdrawalVO = cashWithdrawalVO;
	}

	public void loadCashwithdrawal() throws ServiceException {
		try {
			String id = cashWithdrawalVO.getId();
			this.cashWithdrawalVO = cashWithdrawalTxnservice.get(id);
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loadCashwithdrawal CashWithdrawalTxnController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}

	@Override
	public CashWithdrawalVO getMaintenanceVO() {
		return (CashWithdrawalVO) cashWithdrawalTxnservice;
	}

	@Override
	protected MaintenanceService<CashWithdrawalVO, CashWithdrawal> getMaintenanceService() {
		return getMaintenanceService();
	}

}
