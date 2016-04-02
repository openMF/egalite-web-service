package com.bfsi.mfi.service;


import com.bfsi.mfi.entity.LoanDetailView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.LoanDetailViewVO;


public interface LoanDetailViewService extends 
                     ReadOnlyMaintenanceService<LoanDetailViewVO, LoanDetailView>{
	
	LoanDetailViewVO getLoanView(String id) throws  ServiceException;
}
