package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.DepositMaturityTxnTracker;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositMaturityTxnService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DepositMaturityTxnTrackerVO;

@ManagedBean(name = "depositMaturityTxnController")
@ViewScoped
public class DepositMaturityTxnController
		extends
		MaintenanceController<DepositMaturityTxnTrackerVO, DepositMaturityTxnTracker> {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{depositMaturityTxnService}")
	private DepositMaturityTxnService depositMaturityTxnService;

	private DepositMaturityTxnTrackerVO depositMaturityVO = new DepositMaturityTxnTrackerVO();

	public void loadDepositMaturity() throws ServiceException {
		try {
			//System.out.println("mbsTxnId=" + depositMaturityVO.getMbsTxnId());
			String id = depositMaturityVO.getMbsTxnId();
			this.depositMaturityVO = depositMaturityTxnService.get(id);
		} catch (ServiceException e) {
			logger.error("Unexpected error while DepositMaturity Controller"
					+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
		}
	}

	public DepositMaturityTxnService getDepositMaturityTxnService() {
		return depositMaturityTxnService;
	}

	public void setDepositMaturityTxnService(
			DepositMaturityTxnService depositMaturityTxnService) {
		this.depositMaturityTxnService = depositMaturityTxnService;
	}

	public DepositMaturityTxnTrackerVO getDepositMaturityVO() {
		return depositMaturityVO;
	}

	public void setDepositMaturityVO(
			DepositMaturityTxnTrackerVO depositMaturityVO) {
		this.depositMaturityVO = depositMaturityVO;
	}

	@Override
	public DepositMaturityTxnTrackerVO getMaintenanceVO() {
		return (DepositMaturityTxnTrackerVO) depositMaturityTxnService;
	}

	@Override
	protected MaintenanceService<DepositMaturityTxnTrackerVO, DepositMaturityTxnTracker> getMaintenanceService() {
		return getMaintenanceService();
	}

}
