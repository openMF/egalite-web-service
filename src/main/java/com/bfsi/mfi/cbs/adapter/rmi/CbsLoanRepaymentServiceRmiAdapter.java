package com.bfsi.mfi.cbs.adapter.rmi;

import org.springframework.beans.BeanUtils;

import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsLoanRepaymentRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.util.LoggerUtil;
import com.cbs.bean.CbsBaseTransResponse;
import com.cbs.bean.CbsLoanRepayTranRequest;
import com.cbs.rmi.impl.CbsTranInterfaceImpl;
import com.cbs.service.CbsTranInterface;

/**
 * 
 * @author Shabu
 * 
 */
public class CbsLoanRepaymentServiceRmiAdapter implements
		CbsTransactionServiceAdapter<CbsLoanRepaymentRequest, CbsBaseResponse> {

	@Override
	public CbsBaseResponse performTransaction(
			CbsLoanRepaymentRequest p_tranRequest) throws ServiceException {

		CbsBaseResponse l_res = new CbsBaseResponse();	
		/*CbsLoanRepayTranRequest l_repayReq = new CbsLoanRepayTranRequest();
		LoggerUtil.cbsJobDebug("Inside RMI for========= "+p_tranRequest.getClass().getName());
		l_res.setCbsResStat("P");
		l_res.setCbsResTxnRefNo("112323");
		l_res.setResponseCode("0");
		l_res.setResponseMessage("LOAN REPAYMENT SUCCCESS");
		l_res.setStatus(true);
		try{
			if(p_tranRequest != null){
				BeanUtils.copyProperties(p_tranRequest, l_repayReq);
			}
			
			CbsTranInterface tranIntr = new CbsTranInterfaceImpl();
			CbsBaseTransResponse l_cbsRes = tranIntr.postLoanRepayTrans(l_repayReq);
			
			if(l_cbsRes.getResponseCode().equals("0"))
				l_res.setStatus(true);
			else 
				l_res.setStatus(false);
			BeanUtils.copyProperties(l_cbsRes,l_res);
			
			LoggerUtil.cbsJobDebug("Rmi Response ::"+l_res.toString());
		
		} catch(Exception e){
			e.printStackTrace();
		}*/
		return l_res;
	}

}
