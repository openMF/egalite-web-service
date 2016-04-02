package com.bfsi.mfi.service;


import java.util.List;

import com.bfsi.mfi.entity.CashRecSumupView;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CashRecSumupViewVO;
import com.bfsi.mfi.vo.CashRecordDetailVO;

public interface CashRecService extends ReadOnlyMaintenanceService<CashRecSumupViewVO, CashRecSumupView>{

	List<CashRecSumupViewVO> getSearch(String agtid, String strDate) throws ServiceException;
	
	List<CashRecordDetailVO> getCashRecordDetail(String agentId);

}
