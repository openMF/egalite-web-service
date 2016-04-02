package com.bfsi.mfi.cbs.adapter;

import com.bfsi.mfi.cbs.request.CbsBaseRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;
/**
 * 
 * @author Shabu
 *
 */
public interface CbsTransactionServiceAdapter<K extends CbsBaseRequest,V extends CbsBaseResponse> {
	
	public V performTransaction(K p_tranRequest) throws ServiceException;

}
