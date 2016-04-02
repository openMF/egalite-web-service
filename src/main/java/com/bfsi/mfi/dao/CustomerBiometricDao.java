package com.bfsi.mfi.dao;

import com.bfsi.mfi.entity.CustomerBiometricInfo;
/**
 * 
 * @author Vishal
 *
 */
public interface CustomerBiometricDao {
	void submitCustBiometricInfo(CustomerBiometricInfo p_custBioInfo);

}
