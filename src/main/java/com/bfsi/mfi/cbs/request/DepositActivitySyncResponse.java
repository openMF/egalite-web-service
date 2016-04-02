package com.bfsi.mfi.cbs.request;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsDepositActivity;
/**
 * 
 * @author Shabu S Francis
 *
 */
public class DepositActivitySyncResponse {
	private List<CbsDepositActivity> depositActivityList;

	public List<CbsDepositActivity> getDepositActivityList() {
		return depositActivityList;
	}

	public void setDepositActivityList(
			List<CbsDepositActivity> depositActivityList) {
		this.depositActivityList = depositActivityList;
	}
}
