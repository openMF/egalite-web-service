package com.bfsi.mfi.service;

import java.util.Date;

import com.bfsi.mfi.entity.IbsResetAgenda;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.IbsResetAgendaVO;

public interface IbsResetAgendaService extends MaintenanceService<IbsResetAgendaVO, IbsResetAgenda>{

	String getAutoGenCode() throws ServiceException;

	String deleteAgenda(String id)throws ServiceException;

	IbsResetAgendaVO getModify(String id)throws ServiceException;

	Date getBusinessDateForReset();
}
