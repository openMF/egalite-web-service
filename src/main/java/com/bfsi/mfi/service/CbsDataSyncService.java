package com.bfsi.mfi.service;

import javax.servlet.ServletContext;


public abstract interface  CbsDataSyncService {	

	public void syncCbsData(ServletContext p_servletContext);	
}
