package com.bfsi.mfi.entity;

public class CbsTransactionProperties {

	private String serviceMode;
	private String serviceAdapterSoap;
	private String serviceAdapterEjb;
	private String serviceAdapterRest;
	private String serviceAdapterProc;
	private int maxNoOfRetries;
	private long retryInterval;

	public String getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
	}

	public String getServiceAdapterSoap() {
		return serviceAdapterSoap;
	}

	public void setServiceAdapterSoap(String serviceAdapterSoap) {
		this.serviceAdapterSoap = serviceAdapterSoap;
	}

	public String getServiceAdapterEjb() {
		return serviceAdapterEjb;
	}

	public void setServiceAdapterEjb(String serviceAdapterEjb) {
		this.serviceAdapterEjb = serviceAdapterEjb;
	}

	public String getServiceAdapterRest() {
		return serviceAdapterRest;
	}

	public void setServiceAdapterRest(String serviceAdapterRest) {
		this.serviceAdapterRest = serviceAdapterRest;
	}

	public String getServiceAdapterProc() {
		return serviceAdapterProc;
	}

	public void setServiceAdapterProc(String serviceAdapterProc) {
		this.serviceAdapterProc = serviceAdapterProc;
	}

	public int getMaxNoOfRetries() {
		return maxNoOfRetries;
	}

	public void setMaxNoOfRetries(int maxNoOfRetries) {
		this.maxNoOfRetries = maxNoOfRetries;
	}

	public long getRetryInterval() {
		return retryInterval;
	}

	public void setRetryInterval(long retryInterval) {
		this.retryInterval = retryInterval;
	}

}
