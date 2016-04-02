package com.cbs.bean;

import java.io.Serializable;

public class CbsTransResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3465226123818489320L;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
