package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.AgentCashPositionDao;
import com.bfsi.mfi.entity.AgentCashRecord;
import com.bfsi.mfi.entity.CashPositionServiceRequest;
import com.bfsi.mfi.entity.CashPositionServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgentCashPositionService;
import com.bfsi.mfi.vo.AgentCashRecordVO;

/**
 * 
 * @author Shabu
 * 
 */
@Service
public class AgentCashPositionServiceImpl implements AgentCashPositionService {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@Autowired
	private AgentCashPositionDao agentCashPositionDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CashPositionServiceResponse getAgentCashPositionDetails(
			CashPositionServiceRequest p_req) {
		CashPositionServiceResponse l_res=new CashPositionServiceResponse();
		try {
			if (p_req.getRecvdIds() != null && p_req.getRecvdIds().length > 0) {
				agentCashPositionDao.updateAgentCashRecordStatus(p_req.getRecvdIds());
			}
			
			List<AgentCashRecord> l_records=agentCashPositionDao.getAgentCashRecords(p_req);
			
			if(l_records==null){
				l_records=new ArrayList<AgentCashRecord>();
			}
			//System.out.println("Number of records :: "+l_records.size());
			List<AgentCashRecordVO> l_recordsVo=new ArrayList<AgentCashRecordVO>();
			for(AgentCashRecord l_rec:l_records){
				AgentCashRecordVO l_recVo=new AgentCashRecordVO(l_rec);
				l_recordsVo.add(l_recVo);
			}
			l_res.setCashRecords(l_recordsVo);
			l_res.setStatus(true);
		} catch (DataAccessException e) {
			throw new ServiceException("Data Access exception", e);
		}

		return l_res;
	}

}
