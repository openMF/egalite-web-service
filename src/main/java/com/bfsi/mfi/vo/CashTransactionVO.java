package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CashTransaction;

public class CashTransactionVO extends MaintenanceVO<CashTransaction> {
	public CashTransactionVO() {
		entity = new CashTransaction();
	}
	public CashTransactionVO(CashTransaction entity) {
		super(entity);
	}
}
