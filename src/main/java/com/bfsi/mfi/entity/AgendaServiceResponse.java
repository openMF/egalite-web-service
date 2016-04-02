package com.bfsi.mfi.entity;

import java.util.List;

import com.bfsi.mfi.vo.AgendaVO;



public class AgendaServiceResponse extends ServiceResponse {

	private List<AgendaVO> agendaList;

	public List<AgendaVO> getAgendaList() {
		return agendaList;
	}

	public void setAgendaList(List<AgendaVO> agendaList) {
		this.agendaList = agendaList;
	}

}
