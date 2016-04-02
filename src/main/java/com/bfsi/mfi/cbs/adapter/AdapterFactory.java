package com.bfsi.mfi.cbs.adapter;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Shabu S Francis
 *
 */
public final class AdapterFactory {

	private static Map<CbsActionType, String> ADAPTERMAP = null;

	public static final Object getAdapter(CbsActionType p_action)
			throws Exception {

		if (ADAPTERMAP == null)
			initializeAdapterMap();

		return Class.forName(ADAPTERMAP.get(p_action)).newInstance();
	}

	private static void initializeAdapterMap() {

		if (ADAPTERMAP == null)
			synchronized (AdapterFactory.class) {
				if (ADAPTERMAP == null) {
					ADAPTERMAP = new HashMap<CbsActionType, String>();
					ADAPTERMAP.put(CbsActionType.SYNCLOANS, "com.bfsi.mfi.cbs.adapter.sql.CbsLoanSyncServiceSqlAdapter");
					ADAPTERMAP.put(CbsActionType.SYNCDEPOSITS,
									"com.bfsi.mfi.cbs.adapter.sql.CbsDepositSyncServiceSqlAdapter");
					ADAPTERMAP.put(CbsActionType.SYNCBRANCHES, "com.bfsi.mfi.cbs.adapter.sql.CbsBranchSyncServiceSqlAdapter");
					ADAPTERMAP.put(CbsActionType.SYNCCUSTOMERS, "com.bfsi.mfi.cbs.adapter.sql.CbsCustomerSyncServiceSqlAdapter");
					ADAPTERMAP.put(CbsActionType.SYNCCURRENCY, "com.bfsi.mfi.cbs.adapter.sql.CbsCcySyncServiceSqlAdapter");
					ADAPTERMAP.put(CbsActionType.SYNCFXRATES, "com.bfsi.mfi.cbs.adapter.sql.CbsFxRatesSyncServiceSqlAdapter");
					ADAPTERMAP.put(CbsActionType.SYNCCUSTACCOUNTS, "com.bfsi.mfi.cbs.adapter.sql.CbsCustomerAccSyncServiceSqlAdapter");
					ADAPTERMAP.put(CbsActionType.CBSBUSINESSDATE, "com.bfsi.mfi.cbs.adapter.sql.CbsBranchInfoServiceSqlAdapter");
					ADAPTERMAP.put(CbsActionType.CASHDEPOSIT, "com.bfsi.mfi.cbs.adapter.rmi.CbsCashDepositServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.CASHWITHDRAW, "com.bfsi.mfi.cbs.adapter.rmi.CbsCashWithdrawServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.LOANREPAYMENT, "com.bfsi.mfi.cbs.adapter.rmi.CbsLoanRepaymentServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.LOANDISBUREMENT, "com.bfsi.mfi.cbs.adapter.rmi.CbsLoanDisbursementServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.ENROLLCUSTOMER, "com.bfsi.mfi.cbs.adapter.rmi.CbsEnrollCustomerServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.LOANPREPAYMENT, "com.bfsi.mfi.cbs.adapter.rmi.CbsLoanPrepaymentServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.DEPOSITCOLLECTION, "com.bfsi.mfi.cbs.adapter.rmi.CbsDepositCollectionServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.DEPOSITREDEMPTIONPAYOUT, "com.bfsi.mfi.cbs.adapter.rmi.CbsDepositRedemptionPayoutServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.DEPOSITMATURITYPAYOUT, "com.bfsi.mfi.cbs.adapter.rmi.CbsDepositMaturityPayoutServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.DEPOSITPREPAYREQUEST, "com.bfsi.mfi.cbs.adapter.rmi.CbsDepositPrepayReqServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.DEPOSITNEWACCREQUEST, "com.bfsi.mfi.cbs.adapter.rmi.CbsDepositNewAccReqServiceRmiAdapter");
					ADAPTERMAP.put(CbsActionType.TRANSGENRERICREQUEST, "com.bfsi.mfi.cbs.adapter.rmi.CbsTrnasactionGenericAdapter");
					ADAPTERMAP.put(CbsActionType.DROPLISTREQUEST, "com.bfsi.mfi.cbs.adapter.sql.CbsDropListServiceSqlAdapter");
				}
			}
	}

	private AdapterFactory() {

	}

}
