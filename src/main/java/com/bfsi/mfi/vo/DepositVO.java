package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.Deposit;

public class DepositVO extends MaintenanceVO<Deposit>
{
	public DepositVO() {
		entity = new Deposit();
	}

	public DepositVO(Deposit entity) {
		super(entity);
	}
	
	
	
}
