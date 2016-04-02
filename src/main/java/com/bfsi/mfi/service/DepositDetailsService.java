package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.DepositDetailsServiceRequest;
import com.bfsi.mfi.entity.DepositDetailsServiceResponse;
/**
 * 
 * @author Shabu
 *
 */
public interface DepositDetailsService {
	
	public DepositDetailsServiceResponse getDepositDetails(
			DepositDetailsServiceRequest p_request);

}
