package com.bfsi.mfi.service;

import com.bfsi.mfi.entity.ManualAgendaSettle;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.ManualAgendaSettleVO;

public interface ManualAgendaSettleService extends MaintenanceService<ManualAgendaSettleVO, ManualAgendaSettle>{

	String getAutoAgedaId()throws ServiceException;

}
