package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.AgentCashRecord;
import com.bfsi.mfi.entity.CashPositionServiceRequest;

/**
 * 
 * @author Shabu
 * 
 */
public interface AgentCashPositionDao {

	public List<AgentCashRecord> getAgentCashRecords(
			CashPositionServiceRequest p_req);

	public void updateAgentCashRecordStatus(String[] p_recvdIds);

}
