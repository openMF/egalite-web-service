package com.bfsi.mfi.cbs.handler;

import com.bfsi.mfi.cbs.CbsTransactionServiceMapping;
import com.bfsi.mfi.cbs.request.CbsCashWithdrawRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.entity.CashTransaction;
import com.bfsi.mfi.entity.ServiceResponse;

public class CbsCashWithdrawalRequestHandler
		extends
		CbsServiceHandler<CashTransaction, ServiceResponse, CbsCashWithdrawRequest> {

	@SuppressWarnings("unchecked")
	@Override
	public ServiceResponse processRequest(CashTransaction p_request) {
		ServiceResponse l_serRes = new ServiceResponse();
		CbsBaseResponse l_hostRes = CbsTransactionServiceMapping
				.getAdapterForTransaction("").performTransaction(
						buildRequest(p_request));
		if (l_hostRes.getStatus()) {
			l_serRes.setStatus(true);
		} else {
			l_serRes.setMessageCode("");
		}
		return l_serRes;
	}

	@Override
	public CbsCashWithdrawRequest buildRequest(CashTransaction p_request) {

		return null;
	}

}
