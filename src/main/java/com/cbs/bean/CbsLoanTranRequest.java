package com.cbs.bean;

import java.io.Serializable;

public class CbsLoanTranRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1873630432373839430L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
