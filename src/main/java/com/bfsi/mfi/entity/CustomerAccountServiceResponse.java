package com.bfsi.mfi.entity;

import java.util.List;

import com.bfsi.mfi.vo.CustomerAccountVO;


public class CustomerAccountServiceResponse extends ServiceResponse {
	
	private List<CustomerAccountVO> CustomeAccList;

	public List<CustomerAccountVO> getCustomeAccList() {
		return CustomeAccList;
	}

	public void setCustomeAccList(List<CustomerAccountVO> customeAccList) {
		CustomeAccList = customeAccList;
	}

}
