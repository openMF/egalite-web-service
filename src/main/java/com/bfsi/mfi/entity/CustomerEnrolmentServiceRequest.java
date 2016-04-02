package com.bfsi.mfi.entity;

import java.util.List;

import com.bfsi.mfi.vo.CustomerEnrolmentInfoVO;

/**
 * 
 * @author Shabu
 * 
 */
public class CustomerEnrolmentServiceRequest {
	private List<CustomerEnrolmentInfoVO> custEnrolVo;

	public List<CustomerEnrolmentInfoVO> getCustEnrolVo() {
		return custEnrolVo;
	}

	public void setCustEnrolVo(List<CustomerEnrolmentInfoVO> custEnrolVo) {
		this.custEnrolVo = custEnrolVo;
	}

}
