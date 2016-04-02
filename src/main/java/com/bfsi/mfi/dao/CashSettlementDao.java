package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.Cash;
import com.bfsi.mfi.entity.Till;
import com.bfsi.mfi.exception.ServiceException;

public interface CashSettlementDao extends MaintenanceDao<Cash> 
{
    Agent getAgentForValidation(String agentId);
	String deleteCashSettlement(String id);
	public List<Till> getTillIds()  throws ServiceException;
	boolean isRecordAuthorised(String tillId);
	
	public String getAutoTillId();
	public String addRecordtoCustomer(String id);
}