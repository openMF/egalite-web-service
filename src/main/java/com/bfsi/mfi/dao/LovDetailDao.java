package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.LovDetail;

public interface LovDetailDao extends MaintenanceDao<LovDetail>{

	int getInterValue(String lovId);

	boolean isLovStatustoInactive(String idd);

	String getAutoLovId();

	String deleteUnAuthorized(String id);

	List<LovDetail> getDispValue(String lovId);

}
