package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanDetailsDao;
import com.bfsi.mfi.entity.LoanDetail;
import com.bfsi.mfi.entity.LoanDetailsServiceRequest;
import com.bfsi.mfi.entity.LoanDetailsServiceResponse;
import com.bfsi.mfi.entity.LoanPaidSchDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanDetailsService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanDetailVO;
import com.bfsi.mfi.vo.LoanPaidSchVO;

/**
 * 
 * @author Shabu
 *
 */
@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {
	
	@Autowired
	private LoanDetailsDao loanDetailsDao;

	
	@Override
	public LoanDetailsServiceResponse getLoanDetails(
			LoanDetailsServiceRequest p_request) {
		LoanDetailsServiceResponse l_serRes=new LoanDetailsServiceResponse();
		List<LoanDetail> l_loanList=null;
		List<LoanDetailVO> l_loanListVo=new ArrayList<LoanDetailVO>();
		LoanDetailVO l_loanVo=null;
		if(p_request.getRecvdLoans()==null)
			p_request.setRecvdLoans(new ArrayList<String>());
		try{
		l_loanList=loanDetailsDao.getLoans(p_request);
		for(LoanDetail l_loan:l_loanList){
			l_loanVo=new LoanDetailVO(l_loan);
			l_loanListVo.add(l_loanVo);
		}
		l_serRes.setLoanList(l_loanListVo);
		l_serRes.setStatus(true);
		}
		catch(DataAccessException e){
			throw new ServiceException("Data Access exception while getting loan list",e);
		}
		return l_serRes;
	}


	@Override
	public List<LoanPaidSchVO> getLoanPaidSch(
			String p_loanAcNo , LoanDetailsServiceRequest p_request) {
		List<LoanPaidSchDetail> l_loanPaidSchList = null;
		List<LoanPaidSchVO> l_loanPaidSchListVo = new ArrayList<LoanPaidSchVO>();
		LoanPaidSchVO l_loanPaidSchVo = null;
		try {
			l_loanPaidSchList = loanDetailsDao.getLoanPaidSch(p_loanAcNo, p_request);
			for(LoanPaidSchDetail l_paidSch : l_loanPaidSchList){
				l_loanPaidSchVo = new LoanPaidSchVO(l_paidSch);
				l_loanPaidSchListVo.add(l_loanPaidSchVo);				
			}
			
		} catch(Exception e){
			throw new ServiceException("Data Access exception while getting loan paid Sch list",e);
		}
		return l_loanPaidSchListVo;
	}

}
