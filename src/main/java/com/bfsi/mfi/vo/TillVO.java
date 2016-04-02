package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.Till;

public class TillVO extends MaintenanceVO<Till> {
	public TillVO() {
		entity = new Till();
	}

	public TillVO(Till entity) {
		super(entity);
	}

	public String getTillId() {
		return entity.getTillId();
	}

	public void setTillId(String tillId) {
		entity.setTillId(tillId);
	}

	public String getCcyCode() {
		return entity.getCcyCode();
	}

	public void setCcyCode(String ccyCode) {
		entity.setCcyCode(ccyCode);
	}
}
