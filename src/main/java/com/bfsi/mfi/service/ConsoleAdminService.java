package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.ServiceResponse;

/**
 * 
 * @author Shabu
 *
 */
public interface ConsoleAdminService {
	
	public ServiceResponse startSubTask(String p_charterCode);
	public ServiceResponse doConsoleCheckin();
	public ServiceResponse doConsoleCheckout();

}
