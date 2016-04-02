package com.bfsi.mfi.cbs.response;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsCustomerAccount;

public class CustomerAccSyncResponse {

	private List<CbsCustomerAccount> custAccList;

	public List<CbsCustomerAccount> getCustAccList() {
		return custAccList;
	}

	public void setCustAccList(List<CbsCustomerAccount> custAccList) {
		this.custAccList = custAccList;
	}

}
