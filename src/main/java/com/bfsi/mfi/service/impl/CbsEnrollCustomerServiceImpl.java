package com.bfsi.mfi.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.cbs.adapter.AdapterFactory;
import com.bfsi.mfi.cbs.adapter.CbsActionType;
import com.bfsi.mfi.cbs.adapter.CbsEnrollCustomerServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsEnrollCustomer;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.dao.CbsEnrollCustomerDao;
import com.bfsi.mfi.service.CbsEnrollCustomerService;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Vishal
 *
 */
@Service(value = "cbsEnrollCustomerService")
public class CbsEnrollCustomerServiceImpl implements CbsEnrollCustomerService {
	
	private final String ROW_NUM = "2";

	
	@Autowired
	private CbsEnrollCustomerDao cbsEnrollCustomerDao;
	 
	private synchronized List<CbsEnrollCustomer> getEnrollCustomer() {
		//LoggerUtil.cbsJobDebug("-----pickEnrollCustomer-------------");
		List<CbsEnrollCustomer> l_enrollCustList = null;		
		try {
			l_enrollCustList = cbsEnrollCustomerDao.getUnprsdEnrollCustomer(ROW_NUM);
			
		} catch (DataAccessException e) {
			LoggerUtil.cbsJobError("DataAccessException while get EnrollCustomer : MFI10001",e);
			return null;
		} 
		if(l_enrollCustList!= null && !l_enrollCustList.isEmpty()) {
			cbsEnrollCustomerDao.updateReqEnrolCustStatus(l_enrollCustList);
		}
		return l_enrollCustList;
	}
	
	private CbsBaseResponse postEnrollCustomerToCbs(CbsEnrollCustomer p_enrollCust) throws Exception {
		
		CbsBaseResponse l_res = sendCustInfoToCbs(p_enrollCust);
		cbsEnrollCustomerDao.updateResEnrolCustStatus(p_enrollCust.getEnrolmentId(),l_res);
		return l_res;

	}	
	
	@Override
	public void processEnrollCustomer(){
		
		LoggerUtil.cbsJobDebug("--enollCustomer start process--");	
		Date busiDate = null;
		//EGA-MN15-000024   START
		CbsBaseResponse l_cbsSerRes =null;
		boolean l_forceExit=false;
		//EGA-MN15-000024   END
		while (true) {
		try {
			 busiDate = cbsEnrollCustomerDao.getCurrentBusinessDate();
			List<CbsEnrollCustomer> l_enrollCustList = getEnrollCustomer();
			if(l_enrollCustList == null || l_enrollCustList.isEmpty()){
				break;
			} else {
				for(CbsEnrollCustomer l_tran : l_enrollCustList){
					l_tran.setBusiDate(busiDate);
					//EGA-MN15-000024   START
					l_cbsSerRes=postEnrollCustomerToCbs(l_tran);
					if(l_cbsSerRes!=null && l_cbsSerRes.getCbsResStat().equals("X")){
						l_forceExit=true;
						break;
					}
					//EGA-MN15-000024   END
				}
				//EGA-MN15-000024   START
				if(l_forceExit)
					break;
				//EGA-MN15-000024   END
			}
		}catch(Exception e){
			LoggerUtil.cbsJobError(
					"Unhandeled Exception while processing transaction : MFI10001", e);
			break;
		}
		}
	}
	
	
	private CbsBaseResponse sendCustInfoToCbs(final CbsEnrollCustomer p_enrollCust) {
		CbsBaseResponse l_res = null;
		ExecutorService l_executor = null;
		try {
			l_executor = Executors.newSingleThreadExecutor();
			Future<CbsBaseResponse> l_future = l_executor
					.submit(new Callable<CbsBaseResponse>() {
						@Override
						public CbsBaseResponse call() throws Exception {
							@SuppressWarnings("unchecked")
							CbsEnrollCustomerServiceAdapter<CbsEnrollCustomer, CbsBaseResponse> l_adapter = 
								((CbsEnrollCustomerServiceAdapter<CbsEnrollCustomer, CbsBaseResponse>) 
				AdapterFactory.getAdapter(CbsActionType.ENROLLCUSTOMER));
							
							 return l_adapter.processEnrollCustomer(p_enrollCust);	
						}
					});
			l_res = l_future.get(2, TimeUnit.MINUTES);
			if (l_res == null)
				return buildCbsResponseOnError();
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Unhadeled Exception : MFI10001", e);
			return buildCbsResponseOnError();
		} finally {
			try {
				l_executor.shutdown();
			} catch (Exception e2) {

			}
		}
		return l_res;
	}
	
	private CbsBaseResponse buildCbsResponseOnError() {

		CbsBaseResponse l_res = new CbsBaseResponse();

		l_res.setCbsResStat("X");
		l_res.setStatus(false);
		l_res.setResponseMessage("Failed while sending transaction to the host");
		l_res.setResponseCode("MFI10001");
		return l_res;

	}

}
