package com.bfsi.mfi.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.DepositEnrichmentDao;
import com.bfsi.mfi.entity.DepositEnrichment;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositEnrichmentService;
import com.bfsi.mfi.vo.AgentAllocationsForDepositVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.PigmyDepositVO;

@Service(value = "depositEnrichmentService")
@Transactional(rollbackFor = { ServiceException.class })
public class DepositEnrichmentServiceImpl implements DepositEnrichmentService {


	@Autowired
	private DepositEnrichmentDao depositEnrichmentDao;
	

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	
	public DepositEnrichmentDao getDepositEnrichmentDao() {
		return depositEnrichmentDao;
	}

	public void setDepositEnrichmentDao(DepositEnrichmentDao depositEnrichmentDao) {
		this.depositEnrichmentDao = depositEnrichmentDao;
	}

	/**
	 * Converting vo to entity.
	 * 
	 */
	
	protected DepositEnrichment getEntity(AgentAllocationsForDepositVO vo) {
		DepositEnrichment depositEnrichment = new DepositEnrichment();
		depositEnrichment.setPigmyDeposit(vo.getDeposit().getEntity());
		depositEnrichment.setAgent(vo.getAgent().getEntity());
		depositEnrichment.setAllocateUser(vo.getAllocateUser());
		depositEnrichment.setAllocationTime(vo.getAllocationTime());
		depositEnrichment.setLocationCode(vo.getLocationCode());
		
		return depositEnrichment;
	}

	/**
	 * Converting entity to vo.
	 * 
	 */
	protected AgentAllocationsForDepositVO getValueObject(DepositEnrichment entity) {
		AgentAllocationsForDepositVO agentAllocationsForDepositVO = new AgentAllocationsForDepositVO();
		agentAllocationsForDepositVO.setDeposit(new PigmyDepositVO(entity.getDeposit()));
		agentAllocationsForDepositVO.setAgent(new AgentVO(entity.getAgent()));
		agentAllocationsForDepositVO.setAllocateUser(entity.getAllocateUser());
		agentAllocationsForDepositVO.setAllocationTime(entity.getAllocationTime());
		agentAllocationsForDepositVO.setLocationCode(entity.getLocationCode());
		return agentAllocationsForDepositVO;
	}

	/**
	 * Copy child elements agent and list of agents to AgentAllocationsForDepositVOs.
	 * 
	 */
	/*@Override
	public List<AgentAllocationsForDepositVO> get() throws ServiceException {

		List<DepositEnrichment> depositDetails = null;
		try {
			depositDetails = depositEnrichmentDao.get();
		} catch (DataAccessException e) {
			String message = "Error while get deposit details with  agent name :"
					+ depositDetails.size() + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
		return getAllocationVos(depositDetails);
	}*/

	@Transactional
	@Override
	public void insert(List<AgentAllocationsForDepositVO> agentAllocations)
			throws ServiceException {
		for (AgentAllocationsForDepositVO agentAllocation : agentAllocations) {
			try {
				DepositEnrichment entity = getEntity(agentAllocation);
				depositEnrichmentDao.insert(entity);
				//depositEnrichmentDao.updateDeposit(entity);
			} catch (DataAccessException e) {				
				throw new ServiceException("DataAccessException while update agentid in agent allocation.", e);
			}
		}
	}

	@Transactional
	@Override
	public void insertBulk(List<PigmyDepositVO> deposits, AgentVO agentVO, String loggedInUser)
			throws ServiceException {
		List<AgentAllocationsForDepositVO> agentAllocations = new ArrayList<AgentAllocationsForDepositVO>();
		Date date = new Date();
		for (PigmyDepositVO deposit : deposits) {
			AgentAllocationsForDepositVO vo = new AgentAllocationsForDepositVO();
			vo.setDeposit(deposit);
			vo.setAgent(agentVO);//
			vo.setAllocateUser(loggedInUser);
			//vo.setLocationCode();
			vo.setAllocationTime(new Timestamp(date.getTime()));//
			agentAllocations.add(vo);
		}
		insert(agentAllocations);
	}

	@Override
	public List<AgentAllocationsForDepositVO> getUnassigned() throws ServiceException {
		List<DepositEnrichment> depositDetails = null;
		try {
			depositDetails = depositEnrichmentDao.getUnassigned();
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get deposit details with  agent name ", e);
		}
		return getAllocationVos(depositDetails);
	}

	private List<AgentAllocationsForDepositVO> getAllocationVos(
			List<DepositEnrichment> depositDetails) {
		// Converting entity to vos.
		if (depositDetails != null) {
			List<AgentAllocationsForDepositVO> agentAllocationsVOs = new ArrayList<AgentAllocationsForDepositVO>(
					depositDetails.size());
			for (DepositEnrichment depositEnrichment : depositDetails) {
				AgentAllocationsForDepositVO agentAllocationsVO = getValueObject(depositEnrichment);
				agentAllocationsVOs.add(agentAllocationsVO);
			}
			return agentAllocationsVOs;
		} else {
			return new ArrayList<AgentAllocationsForDepositVO>();
		}
	}

}
