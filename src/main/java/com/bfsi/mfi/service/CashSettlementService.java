package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.Cash;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CashSettlementVO;

public interface CashSettlementService extends MaintenanceService<CashSettlementVO, Cash> 
{
	//public Double getSystemPosition(CashSettlementVO vo) throws ServiceException;
	public AgentVO getAgentForValidation(String agentId) throws ServiceException;

	public boolean isRecordAuthorised(String tillId) throws ServiceException;
	
	public String agendaAmtEntry(CashSettlementVO cash) throws ServiceException;
	
	public String addRecordtoCustomer(String id) throws ServiceException;
}