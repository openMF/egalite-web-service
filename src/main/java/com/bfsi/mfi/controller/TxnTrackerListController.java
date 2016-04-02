package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.service.TxnReceiverListViewService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MfiMbsTxnReceiverVO;

/**
 * @author Nirmal kanna S
 * 
 */
@ManagedBean(name = "txnTrackerListController")
@ViewScoped
public class TxnTrackerListController
		extends
		ReadOnlyMaintenanceListController<MfiMbsTxnReceiverVO, MfiMbsTxnReceiverV> {

	@ManagedProperty(value = "#{txnReceiverListViewService}")
	private TxnReceiverListViewService txnReceiverListViewService;

	MfiMbsTxnReceiverVO mfiMbsTxnReceiverVO = new MfiMbsTxnReceiverVO();
	private static String txnCode = null;

	public MfiMbsTxnReceiverVO getMfiMbsTxnReceiverVO() {
		return mfiMbsTxnReceiverVO;
	}

	public void setMfiMbsTxnReceiverVO(MfiMbsTxnReceiverVO mfiMbsTxnReceiverVO) {
		this.mfiMbsTxnReceiverVO = mfiMbsTxnReceiverVO;
	}

	@Override
	protected String getViewRecordUrl() {
		String page;
		MfiMbsTxnReceiverVO selected = getSelectedRecord();

		txnCode = selected.getTxnCode();

		if (txnCode.equals("L01")) {
			page = "viewDisbursement";
		} else if (txnCode.equals("L02")) {
			page = "viewRepayment";
		} else if (txnCode.equals("L21")) {
			page = "viewPrePayment";
		} else if (txnCode.equals("D01")) {
			page = "viewInstCollection";
		} else if (txnCode.equals("D02")) {
			page = "viewDepositMaturity";
		} else if (txnCode.equals("D03")) {
			page = "viewDepositRedem";
		}
		else if (txnCode.equals("C22"))
		{
			page = "viewCashWithdrawal";	
		}
		else if (txnCode.equals("C21"))
		{
			page = "viewCashDeposit";	
		}

		else {
			LoggerUtil.ibsJobError("Invalid Transaction Type : MFI00702");
			MessageUtil.addMessage("MFI00702");
			page = null;
		}
		return page;
	}

	public TxnReceiverListViewService getTxnReceiverListViewService() {
		return txnReceiverListViewService;
	}

	public void setTxnReceiverListViewService(
			TxnReceiverListViewService txnReceiverListViewService) {
		this.txnReceiverListViewService = txnReceiverListViewService;
	}

	@Override
	public void load() {
		LoggerUtil.ibsJobDebug("inside load: loading records for controller: "
				+ this.getClass().getName());
		try {
			setRecords(getTxnReceiverListViewService().getView());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"Service exception while loading records for controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while loading records for controller: "
							+ this.getClass().getName() + " : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	protected ReadOnlyMaintenanceService<MfiMbsTxnReceiverVO, MfiMbsTxnReceiverV> getReadOnlyMaintenanceService() {
		return txnReceiverListViewService;
	}

}