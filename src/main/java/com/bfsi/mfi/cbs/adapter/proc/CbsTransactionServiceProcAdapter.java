package com.bfsi.mfi.cbs.adapter.proc;

import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsBaseRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;

import com.bfsi.mfi.exception.ServiceException;

public class CbsTransactionServiceProcAdapter implements
		CbsTransactionServiceAdapter<CbsBaseRequest,CbsBaseResponse> {

	@Override
	public CbsBaseResponse performTransaction(CbsBaseRequest p_tranRequest)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}


}
