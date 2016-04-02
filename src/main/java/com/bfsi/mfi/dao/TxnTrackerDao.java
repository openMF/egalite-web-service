package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;

/**
 * User DAO
 * @author akrishna
 * @param <User>
 */

public interface TxnTrackerDao extends ReadOnlyMaintenanceDao<MfiMbsTxnReceiverV> {
	List<MfiMbsTxnReceiverV> getView();

}
