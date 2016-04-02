package com.bfsi.mfi.cbs.response;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsCustomer;

public class CustomerSyncResponse {
	
	private List<CbsCustomer> custList;

	public List<CbsCustomer> getCustList() {
		return custList;
	}

	public void setCustList(List<CbsCustomer> custList) {
		this.custList = custList;
	}

}
