package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.EgaCharter;

public class EgaCharterVO extends MaintenanceVO<EgaCharter>{
	
	public EgaCharterVO() {
		entity = new EgaCharter();
	}

	public EgaCharterVO(EgaCharter entity) {
		super(entity);
	}

	//CHARTER_CODE use as super id
	
	public String getRunStatus() {
		return entity.getRunStatus();
	}
	public void setRunStatus(String runStatus) {
		entity.setRunStatus(runStatus); 
	}
	public String getHasError() {
		return entity.getHasError();
	}
	public void setHasError(String hasError) {
		entity.setHasError(hasError); 
	}
}
