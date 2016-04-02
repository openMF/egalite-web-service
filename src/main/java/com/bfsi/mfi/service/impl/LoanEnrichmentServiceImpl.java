package com.bfsi.mfi.service.impl;

/**
 * @className : LoanEnrichmentServiceImpl.java 
 * 
 * @author Jyoti Ranjan
 * 
 */

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

import com.bfsi.mfi.dao.LoanEnrichmentDao;
import com.bfsi.mfi.entity.LoanEnrichment;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanEnrichmentService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentAllocationsVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.LoanVO;

@Service(value = "loanEnrichmentService")
@Transactional(rollbackFor = { ServiceException.class })
public class LoanEnrichmentServiceImpl implements LoanEnrichmentService {

	@Autowired
	private LoanEnrichmentDao loanEnrichmentDao;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Converting vo to entity.
	 * 
	 */
	protected LoanEnrichment getEntity(AgentAllocationsVO vo) {
		LoanEnrichment loanEnrichment = new LoanEnrichment();
		loanEnrichment.setLoan(vo.getLoan().getEntity());
		loanEnrichment.setAgent(vo.getAgent().getEntity());
		loanEnrichment.setAllocateUser(vo.getAllocateUser());
		loanEnrichment.setAllocationTime(vo.getAllocationTime());
		loanEnrichment.setLocationCode(vo.getLocationCode());
		
		return loanEnrichment;
	}

	/**
	 * Converting entity to vo.
	 * 
	 */
	protected AgentAllocationsVO getValueObject(LoanEnrichment entity) {
		AgentAllocationsVO agentAllocationVO = new AgentAllocationsVO();
		agentAllocationVO.setLoan(new LoanVO(entity.getLoan()));
		agentAllocationVO.setAgent(new AgentVO(entity.getAgent()));
		agentAllocationVO.setAllocateUser(entity.getAllocateUser());
		agentAllocationVO.setAllocationTime(entity.getAllocationTime());
		agentAllocationVO.setLocationCode(entity.getLocationCode());
		
		return agentAllocationVO;
	}

	/**
	 * Copy child elements agent and list of agents to AgentAllocationsVOs.
	 * 
	 */
	@Override
	public List<AgentAllocationsVO> get() throws ServiceException {

		List<LoanEnrichment> loanDetails = null;
		try {
			loanDetails = loanEnrichmentDao.get();
			LoggerUtil.ibsJobDebug("Calling DAO for get loan details with  agent name: ");
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get loan details with  agent name : size ="+loanDetails.size(), e);
		}
		return getAllocationVos(loanDetails);
	}

	@Transactional
	@Override
	public void insert(List<AgentAllocationsVO> agentAllocations)
			throws ServiceException {
		for (AgentAllocationsVO agentAllocation : agentAllocations) {
			try {
				LoanEnrichment entity = getEntity(agentAllocation);
				loanEnrichmentDao.insert(entity);
				LoggerUtil.ibsJobDebug("Calling DAO for update agentid with allocated loans: ");
			} catch (DataAccessException e) {
				throw new ServiceException("DataAccessException while update agentid :", e);
			}
		}
	}

	@Transactional
	@Override
	public void insertBulk(List<LoanVO> loans, AgentVO agentVO, String loggedInUser)
			throws ServiceException {
		List<AgentAllocationsVO> agentAllocations = new ArrayList<AgentAllocationsVO>();
		Date date = new Date();
		for (LoanVO loan : loans) {
			AgentAllocationsVO vo = new AgentAllocationsVO();
			vo.setLoan(loan);
			vo.setAgent(agentVO);//
			vo.setAllocateUser(loggedInUser);
			vo.setAllocationTime(new Timestamp(date.getTime()));//
			vo.setLocationCode(vo.getLocationCode());
			agentAllocations.add(vo);
		}
		insert(agentAllocations);
	}

	@Override
	public List<AgentAllocationsVO> getUnassigned() throws ServiceException {
		List<LoanEnrichment> loanDetails = null;
		try {
			loanDetails = loanEnrichmentDao.getUnassigned();
			LoggerUtil.ibsJobDebug("Calling DAO for getting unassigned loan details: ");
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get unassigned loan details :", e);
		}
		return getAllocationVos(loanDetails);
	}

	private List<AgentAllocationsVO> getAllocationVos(
			List<LoanEnrichment> loanDetails) {
		// Converting entity to vos.
		if (loanDetails != null) {
			List<AgentAllocationsVO> agentAllocationsVOs = new ArrayList<AgentAllocationsVO>(
					loanDetails.size());
			for (LoanEnrichment loanEnrichment : loanDetails) {
				AgentAllocationsVO agentAllocationsVO = getValueObject(loanEnrichment);
				agentAllocationsVOs.add(agentAllocationsVO);
			}
			return agentAllocationsVOs;
		} else {
			return new ArrayList<AgentAllocationsVO>();
		}
	}

}
