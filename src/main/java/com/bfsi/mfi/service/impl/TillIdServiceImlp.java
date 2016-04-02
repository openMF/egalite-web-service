package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.CashSettlementDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.Till;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.TillIdService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.TillVO;

@Service(value = "tillIdService")
@Transactional(rollbackFor = { ServiceException.class })
public class TillIdServiceImlp extends MaintenanceServiceImpl<TillVO, Till> implements TillIdService {
	@Autowired
	private CashSettlementDao cashStlmentDao;
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected CashSettlementDao getMaintenanceDao() {
		return cashStlmentDao;
	}

	@Override
	protected Till getEntity(TillVO vo) {
		return vo.getEntity();
	}

	@Override
	protected TillVO getValueObject(Till entity) {
		TillVO tillvo = new TillVO(entity);
		return tillvo;
	}
	
	@Override
	public List<TillVO> getTillIds()  throws ServiceException
	{
	List<Till>	till=cashStlmentDao.getTillIds();
	if(till !=null)
	  {
		List<TillVO> tillVOs = new ArrayList<TillVO>(till.size());
		for(Till lov:till)
		  {
			TillVO tillvo = new TillVO();
			BeanUtils.copyProperties(lov, tillvo);
			tillVOs.add(tillvo);
		  }
		return tillVOs;
	  }
	else {
		return new ArrayList<TillVO>();
	}
	}

	@Override
	public String getAutoTillId() throws ServiceException {
		String tillId;
		try {
			tillId = cashStlmentDao.getAutoTillId();
			LoggerUtil.ibsJobDebug("Calling DAO for getAutoAgentId" );
			return tillId;
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating getAutoAgentId for Agent: " + e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while validating getAutoAgentId for Agent: " + e);
        }

	}
	

}
