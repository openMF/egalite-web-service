package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.DepositCollectionTxnTracker;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositCollectionTxnService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DepositCollectionTxnTrackerVO;

@ManagedBean(name = "depositCollectionTxnController")
@ViewScoped
public class DepositCollectionTxnController
		extends
		MaintenanceController<DepositCollectionTxnTrackerVO, DepositCollectionTxnTracker> {

	@ManagedProperty(value = "#{depositCollectionTxnService}")
	private DepositCollectionTxnService depositCollectionTxnService;

	DepositCollectionTxnTrackerVO depositCollectionTxnTrackerVO = new DepositCollectionTxnTrackerVO();

	public void loadDepositCollection() throws ServiceException {
		try {

			this.depositCollectionTxnTrackerVO = depositCollectionTxnService
					.get(depositCollectionTxnTrackerVO.getMbsTxnId());
		} catch (ServiceException e) {
			logger.error(
					"Unexpected error while Disbursement Controller"
							+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
		}
	}

	public DepositCollectionTxnService getDepositCollectionTxnService() {
		return depositCollectionTxnService;
	}

	public void setDepositCollectionTxnService(
			DepositCollectionTxnService depositCollectionTxnService) {
		this.depositCollectionTxnService = depositCollectionTxnService;
	}

	public DepositCollectionTxnTrackerVO getDepositCollectionTxnTrackerVO() {
		return depositCollectionTxnTrackerVO;
	}

	public void setDepositCollectionTxnTrackerVO(
			DepositCollectionTxnTrackerVO depositCollectionTxnTrackerVO) {
		this.depositCollectionTxnTrackerVO = depositCollectionTxnTrackerVO;
	}

	@Override
	public DepositCollectionTxnTrackerVO getMaintenanceVO() {
		return (DepositCollectionTxnTrackerVO) depositCollectionTxnService;
	}

	@Override
	protected MaintenanceService<DepositCollectionTxnTrackerVO, DepositCollectionTxnTracker> getMaintenanceService() {
		return getMaintenanceService();
	}
}
