package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;

public interface DepositTxnTrackerDao  extends ReadOnlyMaintenanceDao<MfiMbsTxnReceiverV>{
	List<MfiMbsTxnReceiverV> getView();
}
