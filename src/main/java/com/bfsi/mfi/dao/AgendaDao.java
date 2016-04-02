package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Agenda;
import com.bfsi.mfi.entity.AgendaServiceRequest;
import com.bfsi.mfi.entity.AgendaUpdate;

public interface AgendaDao extends MaintenanceDao<Agenda> {

	public void updateAgendaStatus(AgendaUpdate p_agenda);

	public List<Agenda> getAgendaDetails(AgendaServiceRequest p_requeat);

}
