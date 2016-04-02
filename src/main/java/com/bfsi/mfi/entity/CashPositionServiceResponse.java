package com.bfsi.mfi.entity;

import java.util.List;

import com.bfsi.mfi.vo.AgentCashRecordVO;

/**
 * 
 * @author Shabu
 * 
 */
public class CashPositionServiceResponse extends ServiceResponse {
	List<AgentCashRecordVO> cashRecords;

	public List<AgentCashRecordVO> getCashRecords() {
		return cashRecords;
	}

	public void setCashRecords(List<AgentCashRecordVO> cashRecords) {
		this.cashRecords = cashRecords;
	}

}
