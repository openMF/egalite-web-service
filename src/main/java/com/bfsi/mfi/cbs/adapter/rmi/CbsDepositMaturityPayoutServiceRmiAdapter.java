package com.bfsi.mfi.cbs.adapter.rmi;

import org.springframework.beans.BeanUtils;

import com.bfsi.mfi.cbs.adapter.CbsTransactionServiceAdapter;
import com.bfsi.mfi.cbs.request.CbsDepositMaturityPayoutRequest;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.util.LoggerUtil;
import com.cbs.bean.CbsBaseTransResponse;
import com.cbs.bean.CbsDepositMatTranRequest;
import com.cbs.rmi.impl.CbsTranInterfaceImpl;
import com.cbs.service.CbsTranInterface;

/**
 * 
 * @author Shabu
 * 
 */
public class CbsDepositMaturityPayoutServiceRmiAdapter
		implements
		CbsTransactionServiceAdapter<CbsDepositMaturityPayoutRequest, CbsBaseResponse> {

	@Override
	public CbsBaseResponse performTransaction(
			CbsDepositMaturityPayoutRequest p_tranRequest)
			throws ServiceException {
		LoggerUtil.cbsJobDebug("Inside RMI for "+p_tranRequest.getClass().getName());
		CbsBaseResponse l_res = new CbsBaseResponse();
		/*CbsDepositMatTranRequest l_matReq = new CbsDepositMatTranRequest();

		l_res.setCbsResStat("P");
		l_res.setCbsResTxnRefNo("112323");
		l_res.setResponseCode("0");
		l_res.setResponseMessage("DEPOSIT MATURITY PAYOUT SUCCCESS");
		l_res.setStatus(true);
		try{
			if(p_tranRequest != null){
				BeanUtils.copyProperties(p_tranRequest, l_matReq);
			}
			
			CbsTranInterface tranIntr = new CbsTranInterfaceImpl();
			CbsBaseTransResponse l_cbsRes = tranIntr.postDisbrMatTrans(l_matReq);
			
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
