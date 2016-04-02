package com.bfsi.mfi.entity;

import java.util.List;

import com.bfsi.mfi.vo.CustomerBiometricInfoVO;

/**
 * 
 * @author Vishal
 * 
 */
public class CustomerBiometricServiceRequest {
	private List<CustomerBiometricInfoVO> custBioVo;

	public List<CustomerBiometricInfoVO> getCustBioVo() {
		return custBioVo;
	}

	public void setCustBioVo(List<CustomerBiometricInfoVO> custBioVo) {
		this.custBioVo = custBioVo;
	}

}
