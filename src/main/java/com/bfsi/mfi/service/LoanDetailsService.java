package com.bfsi.mfi.service;


import java.util.List;

import com.bfsi.mfi.entity.LoanDetailsServiceRequest;
import com.bfsi.mfi.entity.LoanDetailsServiceResponse;
import com.bfsi.mfi.vo.LoanPaidSchVO;

/**
 * 
 * @author Shabu
 *
 */
public interface LoanDetailsService {
	public LoanDetailsServiceResponse getLoanDetails(LoanDetailsServiceRequest p_request);
	public List<LoanPaidSchVO> getLoanPaidSch(String p_loanAcNo, LoanDetailsServiceRequest p_request);

}
