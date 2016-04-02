package com.bfsi.mfi.cbs.response;

import java.util.List;

import com.bfsi.mfi.cbs.model.CbsFxRates;

public class FxRatesSyncResponse {
	
	private List<CbsFxRates> fxRatesList;

	public List<CbsFxRates> getFxRatesList() {
		return fxRatesList;
	}

	public void setFxRatesList(List<CbsFxRates> fxRatesList) {
		this.fxRatesList = fxRatesList;
	}

}
