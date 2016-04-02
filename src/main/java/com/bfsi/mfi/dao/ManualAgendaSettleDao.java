package com.bfsi.mfi.dao;

import java.util.Date;

import com.bfsi.mfi.entity.ManualAgendaSettle;

public interface ManualAgendaSettleDao extends MaintenanceDao<ManualAgendaSettle>{

	String getAutoAgedaId();
	/*EGA-MN15-000008 For Business Date Start*/
	Date getBusinessDateForManualAgendaSettle();
	/*EGA-MN15-000008 For Business Date End*/
	

}
