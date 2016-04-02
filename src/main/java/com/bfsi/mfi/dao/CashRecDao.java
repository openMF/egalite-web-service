package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CashRecSumupView;
import com.bfsi.mfi.entity.CashRecordDetail;

public interface CashRecDao extends MaintenanceDao<CashRecSumupView>{

	List<CashRecSumupView> getSearch(String agtid, String tdate);
	
	List<CashRecordDetail> cashRecordDetail(String agentId);

}
