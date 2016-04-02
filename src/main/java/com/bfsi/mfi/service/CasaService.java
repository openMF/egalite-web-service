package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.CustAcDetailView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CustAcDetailViewVO;

public interface CasaService extends 
                     ReadOnlyMaintenanceService<CustAcDetailViewVO, CustAcDetailView>{
	
	CustAcDetailViewVO getCustAc(String id) throws  ServiceException;

}
