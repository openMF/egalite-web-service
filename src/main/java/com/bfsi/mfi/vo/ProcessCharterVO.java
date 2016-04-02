package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.ProcessCharter;

public class ProcessCharterVO extends MaintenanceVO<ProcessCharter> {
	
	public ProcessCharterVO(){
		entity = new ProcessCharter();
	}
	
	public ProcessCharterVO(ProcessCharter entity) {
		super(entity);
	}
	
}
