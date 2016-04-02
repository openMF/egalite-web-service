package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CleanUp;

public class CleanUpVO extends MaintenanceVO<CleanUp> {
	
	public CleanUpVO(){
		entity = new CleanUp();
	}
	
	public CleanUpVO(CleanUp entity) {
		super(entity);
	}
	
}
