package com.bfsi.mfi.cbs.request;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsDeposit;
/**
 * 
 * @author Shabu S Francis
 *
 */
public class DepositSyncResponse {
	private List<CbsDeposit> depositList;

	public List<CbsDeposit> getDepositList() {
		return depositList;
	}

	public void setDepositList(List<CbsDeposit> depositList) {
		this.depositList = depositList;
	}

}
