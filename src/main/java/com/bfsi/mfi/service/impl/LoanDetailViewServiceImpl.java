package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanDao;
import com.bfsi.mfi.entity.LoanDetailView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanDetailViewService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanDetailViewVO;


@Service(value = "loanDetailViewService")
public class LoanDetailViewServiceImpl extends ReadOnlyServiceImpl<LoanDetailViewVO, LoanDetailView>
implements LoanDetailViewService{
 
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
	protected LoanDetailView getEntity(LoanDetailViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected LoanDetailViewVO getValueObject(LoanDetailView entity) {
		LoanDetailViewVO loanDetailViewVO = new LoanDetailViewVO(entity);
		return loanDetailViewVO;
	}

	
	@Override
	public LoanDetailViewVO getLoanView(String id) {
		LoanDetailView entities = null;
		LoanDetailViewVO vos = null;
		
		try {
		    entities = getReadOnlyMaintenanceDao().getLoanView(id);
			if (entities == null) {
				return new LoanDetailViewVO();
			}
            vos = getValueObject(entities);
			LoggerUtil.ibsJobDebug("Calling DAO  for getting loans details view: ");
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get details view :  ", e);
		}
		return vos;
	}
	
}
