package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.DepositRedemptionTxnTracker;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositRedemptionTxnService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DepositRedemptionTxnTrackerVO;

@ManagedBean(name = "depositRedemptionTxnController")
@ViewScoped
public class DepositRedemptionTxnController
		extends
		MaintenanceController<DepositRedemptionTxnTrackerVO, DepositRedemptionTxnTracker> {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{depositRedemptionTxnService}")
	private DepositRedemptionTxnService depositRedemptionTxnService;
	private DepositRedemptionTxnTrackerVO depositRedemptionVO = new DepositRedemptionTxnTrackerVO();

	public DepositRedemptionTxnService getDepositRedemptionTxnService() {
		return depositRedemptionTxnService;
	}

	public void setDepositRedemptionTxnService(
			DepositRedemptionTxnService depositRedemptionTxnService) {
		this.depositRedemptionTxnService = depositRedemptionTxnService;
	}

	public DepositRedemptionTxnTrackerVO getDepositRedemptionVO() {
		return depositRedemptionVO;
	}

	public void setDepositRedemptionVO(
			DepositRedemptionTxnTrackerVO depositRedemptionVO) {
		this.depositRedemptionVO = depositRedemptionVO;
	}

	public void loadDepositRedemption() throws ServiceException {
		try {
			//System.out.println("mbsTxnId=" + depositRedemptionVO.getMbsTxnId());
			String id = depositRedemptionVO.getMbsTxnId();
			this.depositRedemptionVO = depositRedemptionTxnService.get(id);
		} catch (ServiceException e) {
			logger.error("Unexpected error while DepositMaturity Controller"
					+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
		}
	}

	@Override
	public DepositRedemptionTxnTrackerVO getMaintenanceVO() {
		return (DepositRedemptionTxnTrackerVO) depositRedemptionTxnService;
	}

	@Override
	protected MaintenanceService<DepositRedemptionTxnTrackerVO, DepositRedemptionTxnTracker> getMaintenanceService() {
		return getMaintenanceService();
	}

}
