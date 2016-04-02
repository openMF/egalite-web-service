package com.bfsi.mfi.cbs.handler;

import com.bfsi.mfi.cbs.request.CbsBaseRequest;
import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.entity.ServiceResponse;


public abstract class CbsServiceHandler<T extends MaintenanceEntity, V extends ServiceResponse,K extends CbsBaseRequest> {
	
	public abstract V processRequest( T p_request);
	
	public abstract K buildRequest(T p_request);
	
	
	

}
