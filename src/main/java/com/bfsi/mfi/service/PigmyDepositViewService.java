package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.PigmyView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.PigmyViewVO;


public interface PigmyDepositViewService extends 
                     ReadOnlyMaintenanceService<PigmyViewVO, PigmyView>{
	
	PigmyViewVO getDepositView(String id) throws  ServiceException;
}
