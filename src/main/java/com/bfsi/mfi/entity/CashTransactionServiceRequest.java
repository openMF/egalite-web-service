package com.bfsi.mfi.entity;


import com.bfsi.mfi.vo.AgentTransactionVO;

public class CashTransactionServiceRequest {

	private AgentTransactionVO tranVo;

	public AgentTransactionVO getTranVo() {
		return tranVo;
	}

	public void setTranVo(AgentTransactionVO tranVo) {
		this.tranVo = tranVo;
	}

}
