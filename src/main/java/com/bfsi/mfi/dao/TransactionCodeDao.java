package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;
import com.bfsi.mfi.exception.ServiceException;

public interface TransactionCodeDao  extends MaintenanceDao<MfiMbsTxnReceiverV>{
	
	List<MfiMbsTxnReceiverV> getTransactionTypes()  throws ServiceException;

}
