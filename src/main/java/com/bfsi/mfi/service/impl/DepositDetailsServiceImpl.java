package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DepositDetailsDao;
import com.bfsi.mfi.entity.DepositDetail;
import com.bfsi.mfi.entity.DepositDetailsServiceRequest;
import com.bfsi.mfi.entity.DepositDetailsServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositDetailsService;
import com.bfsi.mfi.vo.DepositDetailVO;

/**
 * 
 * @author Shabu
 * 
 */
@Service
public class DepositDetailsServiceImpl implements DepositDetailsService {

	@Autowired
	private DepositDetailsDao depositDetailsDao;

	

	@Override
	public DepositDetailsServiceResponse getDepositDetails(
			DepositDetailsServiceRequest p_request) {
		
		DepositDetailsServiceResponse l_res=new DepositDetailsServiceResponse();
		List<DepositDetail> l_depositList=null;
		List<DepositDetailVO> l_depositListVo=new ArrayList<DepositDetailVO>();
		DepositDetailVO l_depositVo=null;
		if(p_request.getRecvdDeposits()==null)
			p_request.setRecvdDeposits(new ArrayList<String>());
		try{
		l_depositList=depositDetailsDao.getDeposits(p_request);
		for(DepositDetail l_deposit:l_depositList){
			l_depositVo=new DepositDetailVO(l_deposit);
			l_depositListVo.add(l_depositVo);
		}
		l_res.setDepositList(l_depositListVo);
		l_res.setStatus(true);
		}
		catch(DataAccessException e){
			throw new ServiceException("Data Access exception while getting deposit list",e);
		}
		return l_res;
	}

}
