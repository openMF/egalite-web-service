package com.bfsi.mfi.dao;

import java.util.Map;

import com.bfsi.mfi.entity.EgaCharter;
import com.bfsi.mfi.entity.InitConsole;

/**
 * ListValueDao
 * 
 * @author Nirmal kanna S
 * @param <ListValue>
 */

public interface InitConsoleDao extends MaintenanceDao<InitConsole> {

	 public String cbcConsoleText(String id);
	 public  Map<String,String> getJobStatus();
	public EgaCharter getRunHasStatus(String charCode);
}
