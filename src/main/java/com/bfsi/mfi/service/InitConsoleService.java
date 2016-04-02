package com.bfsi.mfi.service;

import java.util.Map;

import com.bfsi.mfi.entity.InitConsole;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.EgaCharterVO;
import com.bfsi.mfi.vo.InitConsoleVO;

/**
 * @author Nirmal Kanna S
 * 
 */
public interface InitConsoleService extends MaintenanceService<InitConsoleVO, InitConsole> {

	String cbcConsoleText(String id); 
	Map<String,String> refreshJobStatus() throws ServiceException;
	EgaCharterVO getRunHasStatus(String charCode)throws ServiceException;
}
