package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.MfiMbsTxnReceiverVO;

public interface DepositTxnService extends ReadOnlyMaintenanceService<MfiMbsTxnReceiverVO, MfiMbsTxnReceiverV>{
	List<MfiMbsTxnReceiverVO> getView() throws ServiceException;
}
