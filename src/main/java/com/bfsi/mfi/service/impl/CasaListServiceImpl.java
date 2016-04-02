package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CasaDao;
import com.bfsi.mfi.entity.CustAcDetailListView;
import com.bfsi.mfi.service.CasaListService;
import com.bfsi.mfi.vo.CustAcDetailListViewVO;


@Service(value = "casaListService")
public class CasaListServiceImpl extends ReadOnlyServiceImpl<CustAcDetailListViewVO, CustAcDetailListView> 
                                     implements CasaListService{

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
	protected CasaDao getReadOnlyMaintenanceDao() {
		return casaDao;
	}

	@Override
	protected CustAcDetailListView getEntity(CustAcDetailListViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CustAcDetailListViewVO getValueObject(CustAcDetailListView entity) {
		CustAcDetailListViewVO custAcDetailListViewVO = new CustAcDetailListViewVO(entity);
		return custAcDetailListViewVO;
	}

}
