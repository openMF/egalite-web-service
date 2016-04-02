package com.bfsi.mfi.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.CashSettlementDao;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.Cash;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CashSettlementService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CashSettlementVO;

@Service(value = "cashSettlementService")
@Transactional(rollbackFor = { ServiceException.class })
public class CashSettlementServiceImpl extends MaintenanceServiceImpl<CashSettlementVO, Cash> 
		implements CashSettlementService 
{

	@Autowired
	private CashSettlementDao cashStlmentDao;

	@SuppressWarnings("unchecked")
	@Override
	protected CashSettlementDao getMaintenanceDao() {
		return cashStlmentDao;
	}

	@Override
	protected Cash getEntity(CashSettlementVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CashSettlementVO getValueObject(Cash entity) {
		CashSettlementVO casvo = new CashSettlementVO(entity);
		return casvo;
	}
	
	@Override
	public CashSettlementVO update(CashSettlementVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		try {
			return super.update(vo);
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while updating auth status", e);
		}
	}
	
@Override
	public CashSettlementVO create(CashSettlementVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		super.create(vo);
		return vo;
	}

	@Override
	public AgentVO getAgentForValidation(String agentId) throws ServiceException {
		AgentVO agentVo = new AgentVO();
		try {
		Agent agent = cashStlmentDao.getAgentForValidation(agentId);
		LoggerUtil.ibsJobDebug("Calling DAO  for validating AgentId For CashSettlement: "+agentId);
		BeanUtils.copyProperties(agent, agentVo);
		return agentVo;
		} catch (DataAccessException e) {
		
			throw new ServiceException("DataAccessException while validating AgentId For CashSettlement: ", e);
		}
	}

	@Override
	public boolean isRecordAuthorised(String tillId) throws ServiceException{
		
		try{
		return cashStlmentDao.isRecordAuthorised(tillId);
		/* if(authorised.equalsIgnoreCase("A"))
		 {
			return true; 
		 }
		 else
		 {
			 return false;
		 }*/
		 
		}catch(DataAccessException e){
			throw new ServiceException("DataAccessException while checking auth  for the agentId: " +tillId, e);
		}
	}

	@Override
	public String agendaAmtEntry(CashSettlementVO cash) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addRecordtoCustomer(String tillId) throws ServiceException {
		try{
			return cashStlmentDao.addRecordtoCustomer(tillId);
			}catch(DataAccessException e){
				throw new ServiceException("DataAccessException while checking auth  for the agentId: " +tillId, e);
			}	
		}
}