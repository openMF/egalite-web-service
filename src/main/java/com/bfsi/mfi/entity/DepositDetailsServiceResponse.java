package com.bfsi.mfi.entity;

import java.util.List;

import com.bfsi.mfi.vo.DepositDetailVO;

public class DepositDetailsServiceResponse extends ServiceResponse {

	private List<DepositDetailVO> depositList;

	public List<DepositDetailVO> getDepositList() {
		return depositList;
	}

	public void setDepositList(List<DepositDetailVO> depositList) {
		this.depositList = depositList;
	}

}
