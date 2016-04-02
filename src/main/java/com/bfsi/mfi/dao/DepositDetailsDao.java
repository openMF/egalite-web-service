package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.DepositDetail;
import com.bfsi.mfi.entity.DepositDetailsServiceRequest;


/**
 * 
 * @author Shabu
 *
 */
public interface DepositDetailsDao {

	public List<DepositDetail> getDeposits(DepositDetailsServiceRequest p_request);

}
