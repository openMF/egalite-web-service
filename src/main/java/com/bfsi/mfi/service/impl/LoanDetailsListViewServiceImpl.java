package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanDao;
import com.bfsi.mfi.entity.Customer;
import com.bfsi.mfi.entity.LoanDetailsListView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanDetailsListViewService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustomerVO;
import com.bfsi.mfi.vo.LoanDetailsListViewVO;


@Service(value = "loanDetailsListViewService")
public class LoanDetailsListViewServiceImpl extends ReadOnlyServiceImpl<LoanDetailsListViewVO, LoanDetailsListView> 
implements LoanDetailsListViewService {
	
	@Autowired
	private LoanDao loanDao;
	
	public LoanDao getLoanDao() {
		return loanDao;
	}

	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected LoanDao getReadOnlyMaintenanceDao() {
		return loanDao;
	}

	@Override
	protected LoanDetailsListView getEntity(LoanDetailsListViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected LoanDetailsListViewVO getValueObject(LoanDetailsListView entity) {
		LoanDetailsListViewVO loanDetailsListViewVO = new LoanDetailsListViewVO(entity);
		return loanDetailsListViewVO;
	}

	@Override
	public List<LoanDetailsListViewVO> getList() {
		List<LoanDetailsListView> entities = null;
		List<LoanDetailsListViewVO> vos = null;
		
		try {
		   entities = getReadOnlyMaintenanceDao().getList();
			if (entities == null) {
				return new ArrayList<LoanDetailsListViewVO>();
			}

		    vos = new ArrayList<LoanDetailsListViewVO>(entities.size());
			for (LoanDetailsListView entity : entities) {
				LoanDetailsListViewVO vo = getValueObject(entity);
				vos.add(vo);
			}
			LoggerUtil.ibsJobDebug("Calling DAO  for getting loans details list view: ");
		  //return vos;
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get details list view :  ", e);
		}
		return vos;
	}
	
	
	@Override
	public List<LoanDetailsListViewVO> getSearch(String loanAcNo, String brCode,
            String custId, String cfCode, String agtId, String locCode, String parentLoanAcNo, String parentCustID) throws ServiceException {
		
		try{
			List<LoanDetailsListView> loanList = getReadOnlyMaintenanceDao().getSearch(loanAcNo, brCode, custId, cfCode, agtId, locCode, parentLoanAcNo, parentCustID);
			/*LoggerUtil.ibsJobDebug("Calling DAO  for getting list with submitted criteria: "+loanAcNo +" :"+brCode
					                                                                 +" :"+custId+" :"+cfCode+" :"+agtId+" :"+locCode);*/
			
			if (loanList == null) {
				return new ArrayList<LoanDetailsListViewVO>();
			}
			
			List<LoanDetailsListViewVO> vos = new ArrayList<LoanDetailsListViewVO>(loanList.size());
			for (LoanDetailsListView entity : loanList) {
				LoanDetailsListViewVO vo = getValueObject(entity);
				vos.add(vo);
			}
			LoggerUtil.ibsJobDebug("Calling DAO  for getting loans details list view: ");
			return vos;
		}catch(DataAccessException e){
			throw new ServiceException("DataAccessException while getting list with submitted search criteria : ", e);
		}
		
		
	}
	
	
}
