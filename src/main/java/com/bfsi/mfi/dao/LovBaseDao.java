package com.bfsi.mfi.dao;

import com.bfsi.mfi.entity.LovBase;

public interface LovBaseDao extends MaintenanceDao<LovBase>{

	boolean isLovIdAvailable(String id);

	String deleteBaseLov(String id);

	boolean isLovStatustoInactive(String id);

}
