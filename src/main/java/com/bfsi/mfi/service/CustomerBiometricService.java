package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.CustomerBiometricServiceRequest;
import com.bfsi.mfi.entity.ServiceResponse;


public interface CustomerBiometricService {
	public ServiceResponse uploadCustomerBiometricDetails(CustomerBiometricServiceRequest p_enrolReq);
}
