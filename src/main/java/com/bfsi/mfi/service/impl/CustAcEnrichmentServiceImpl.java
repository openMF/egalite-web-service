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

import com.bfsi.mfi.dao.CasaEnrichDao;
import com.bfsi.mfi.entity.CustAcEnrichment;
import com.bfsi.mfi.entity.LoanEnrichment;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CustAcEnrichmentService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentAllocationsVO;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CustAcEnrichmentVO;
import com.bfsi.mfi.vo.LoanVO;


@Service(value = "custAcEnrichmentService")
@Transactional(rollbackFor = { ServiceException.class })
public class CustAcEnrichmentServiceImpl implements CustAcEnrichmentService {
	
	@Autowired
	private CasaEnrichDao casaEnrichDao;
	
	public CasaEnrichDao getCasaEnrichDao() {
		return casaEnrichDao;
	}

	/*public void setCasaEnrichDao(CasaEnrichDao casaEnrichDao) {
		this.casaEnrichDao = casaEnrichDao;
	}*/
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
	
	protected CustAcEnrichment getEntity(CustAcEnrichmentVO vo) {
		CustAcEnrichment custAcEnrichment=new CustAcEnrichment();
		custAcEnrichment.setId(vo.getId());//super id used.
		custAcEnrichment.setAgent(vo.getAgent().getEntity());
		custAcEnrichment.setAllocationBy(vo.getAllocationBy());
		custAcEnrichment.setAllocationTime(vo.getAllocationTime());
		custAcEnrichment.setLocationCode(vo.getLocationCode());
		
		return custAcEnrichment;
	}

	
	protected CustAcEnrichmentVO getValueObject(CustAcEnrichment entity) {
		CustAcEnrichmentVO custAcEnrichmentVO = new CustAcEnrichmentVO();
		custAcEnrichmentVO.setId(entity.getId());
		custAcEnrichmentVO.setAgent(new AgentVO(entity.getAgent()));
		custAcEnrichmentVO.setAllocationBy(entity.getAllocationBy());
		custAcEnrichmentVO.setAllocationTime(entity.getAllocationTime());
		custAcEnrichmentVO.setLocationCode(entity.getLocationCode());
		
		return custAcEnrichmentVO;
	}
	
	
	@Override
	public List<CustAcEnrichmentVO> get() throws ServiceException {

		List<CustAcEnrichment> custAcDetails = null;
		try {
			custAcDetails = casaEnrichDao.get();
			LoggerUtil.ibsJobDebug("Calling DAO for get loan details with  agent name: ");
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get loan details with  agent name : size ="+custAcDetails.size(), e);
		}
		return getAllocationVos(custAcDetails);
	}

	@Transactional
	@Override
	public void insert(List<CustAcEnrichmentVO> agentAllocations)
			throws ServiceException {
		for (CustAcEnrichmentVO agentAllocation : agentAllocations) {
			try {
				CustAcEnrichment entity = getEntity(agentAllocation);
				casaEnrichDao.insert(entity);
				LoggerUtil.ibsJobDebug("Calling DAO for update agentid with allocated customer A/c: ");
			} catch (DataAccessException e) {
				throw new ServiceException("DataAccessException while update agentid :", e);
			}
		}
	}

	@Transactional
	@Override
	public void insertBulk(List<CustAcEnrichmentVO> custacs, AgentVO agentVO, String loggedInUser)
			throws ServiceException {
		List<CustAcEnrichmentVO> agentAllocations = new ArrayList<CustAcEnrichmentVO>();
		Date date = new Date();
		for (CustAcEnrichmentVO cust : custacs) {
			CustAcEnrichmentVO vo = new CustAcEnrichmentVO();
			//vo.setLoan(cust);
			vo.setId(cust.getId());
			vo.setAgent(agentVO);//
			vo.setAllocationBy(loggedInUser);
			vo.setAllocationTime(new Timestamp(date.getTime()));//
			vo.setLocationCode(vo.getLocationCode());
			agentAllocations.add(vo);
		}
		insert(agentAllocations);
	}

	@Override
	public List<CustAcEnrichmentVO> getUnassigned() throws ServiceException {
		List<CustAcEnrichment> custAcDetails = null;
		try {
			custAcDetails = casaEnrichDao.getUnassigned();
			LoggerUtil.ibsJobDebug("Calling DAO for getting unassigned loan details: ");
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get unassigned loan details :", e);
		}
		return getAllocationVos(custAcDetails);
	}

	private List<CustAcEnrichmentVO> getAllocationVos(
			List<CustAcEnrichment> loanDetails) {
		// Converting entity to vos.
		if (loanDetails != null) {
			List<CustAcEnrichmentVO> CustAcEnrichmentVOs = new ArrayList<CustAcEnrichmentVO>(
					loanDetails.size());
			for (CustAcEnrichment CustAcEnrichment : loanDetails) {
				CustAcEnrichmentVO CustAcEnrichmentVO = getValueObject(CustAcEnrichment);
				CustAcEnrichmentVOs.add(CustAcEnrichmentVO);
			}
			return CustAcEnrichmentVOs;
		} else {
			return new ArrayList<CustAcEnrichmentVO>();
		}
	}

	

	
	
	
}
