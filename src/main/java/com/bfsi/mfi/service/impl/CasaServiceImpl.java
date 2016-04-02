package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CasaDao;
import com.bfsi.mfi.entity.CustAcDetailView;
import com.bfsi.mfi.entity.LoanDetailView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CasaService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustAcDetailViewVO;
import com.bfsi.mfi.vo.LoanDetailViewVO;

@Service(value = "casaService")
public class CasaServiceImpl extends ReadOnlyServiceImpl<CustAcDetailViewVO, CustAcDetailView>
implements CasaService{
      
	@Autowired
	private CasaDao casaDao;
	
	public CasaDao getCasaDao() {
		return casaDao;
	}

	public void setCasaDao(CasaDao casaDao) {
		this.casaDao = casaDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected  CasaDao getReadOnlyMaintenanceDao() {
		return casaDao;
	}

	@Override
	protected CustAcDetailView getEntity(CustAcDetailViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CustAcDetailViewVO getValueObject(CustAcDetailView entity) {
		CustAcDetailViewVO custAcViewVO = new CustAcDetailViewVO(entity);
		return custAcViewVO;
	}

	
	
	@Override
	public CustAcDetailViewVO getCustAc(String id) throws ServiceException {
		CustAcDetailView entities = null;
		CustAcDetailViewVO vos = null;
		
		try {
		    entities = getReadOnlyMaintenanceDao().getCustAc(id);
			if (entities == null) {
				return new CustAcDetailViewVO();
			}
            vos = getValueObject(entities);
			LoggerUtil.ibsJobDebug("Calling DAO  for getting loans details view: ");
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get details view :  ", e);
		}
		return vos;
	}
	
}
