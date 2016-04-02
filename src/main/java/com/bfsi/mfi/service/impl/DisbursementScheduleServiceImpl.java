package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DisbursementScheduleDao;
import com.bfsi.mfi.entity.LoanDetailDisbrView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DisbursementScheduleService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanDetailDisbrViewVO;

/**
 * @author Jyoti Ranjan
 * 
 */

@Service(value = "disbursementScheduleService")
public class DisbursementScheduleServiceImpl extends MaintenanceServiceImpl<LoanDetailDisbrViewVO, LoanDetailDisbrView>
implements DisbursementScheduleService{

	@Autowired
	private DisbursementScheduleDao disbursementScheduleDao;

	@SuppressWarnings("unchecked")
	@Override
	protected DisbursementScheduleDao getMaintenanceDao() {
		return disbursementScheduleDao;
	}

	@Override
	protected LoanDetailDisbrViewVO getValueObject(LoanDetailDisbrView entity) {
		LoanDetailDisbrViewVO disburseScheduleVO = new LoanDetailDisbrViewVO(entity);
		return disburseScheduleVO;
	}
	
	@Override
	protected LoanDetailDisbrView getEntity(LoanDetailDisbrViewVO vo) {
		return vo.getEntity();
	}
	
	@Override
	public List<LoanDetailDisbrViewVO> getDisbursementSchedule(String loanDisburId)
			throws ServiceException {
		List<LoanDetailDisbrViewVO> disburseList = new ArrayList<LoanDetailDisbrViewVO>();
	 try{	
		List<LoanDetailDisbrView> disbursListEntity =  disbursementScheduleDao.getDisbursementSchedule(loanDisburId);
		if (disbursListEntity != null) {
			for (LoanDetailDisbrView disburseScheduleEntity : disbursListEntity) {
				LoanDetailDisbrViewVO disburseScheduleVO = new LoanDetailDisbrViewVO();
				BeanUtils.copyProperties(disburseScheduleEntity, disburseScheduleVO);
				disburseList.add(disburseScheduleVO);
			}
		}
		LoggerUtil.ibsJobDebug("Calling DAO to get disbursment schedule for loan Disburment Id :"+loanDisburId);
	 }catch(DataAccessException e){
		 throw new ServiceException("DataAccessException while getting disbursment schedule for loan Disburment Id: "+loanDisburId, e);
	 }
		return disburseList;
	}

}

