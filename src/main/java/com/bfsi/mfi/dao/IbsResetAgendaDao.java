package com.bfsi.mfi.dao;

import java.util.Date;

import com.bfsi.mfi.entity.IbsResetAgenda;

public interface IbsResetAgendaDao extends MaintenanceDao<IbsResetAgenda>{

	String getAutoGenId();

	String deleteAgenda(String id);

	IbsResetAgenda getModify(String id);
	
	Date getBusinessDateForReset();
}
