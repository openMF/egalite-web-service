package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.GroupCodes;

public interface GroupCodesDao extends MaintenanceDao<GroupCodes>{

	String getAutoGroupCode();
	List<GroupCodes> getAuthorized();
	String deleteGroupCode(String id);
	
	

}
