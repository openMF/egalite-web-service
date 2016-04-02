package com.bfsi.mfi.cbs.response;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsCurrency;

/**
 * 
 * @author Vishal
 *
 */

public class CcySyncResponse {
	
	private List<CbsCurrency> ccyList;

	public List<CbsCurrency> getCcyList() {
		return ccyList;
	}

	public void setCcyList(List<CbsCurrency> ccyList) {
		this.ccyList = ccyList;
	}
	

}
