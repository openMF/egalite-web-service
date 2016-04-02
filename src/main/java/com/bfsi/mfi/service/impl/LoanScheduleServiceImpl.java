package com.bfsi.mfi.service.impl;

/**
 * @author Jyoti Ranjan
 * 
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanScheduleDao;
import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.entity.LoanDetailSchView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanScheduleService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanDetailSchViewVO;
import com.bfsi.mfi.vo.LoanVO;

@Service(value = "loanScheduleService")
public class LoanScheduleServiceImpl extends ReadOnlyServiceImpl<LoanDetailSchViewVO, LoanDetailSchView>
		implements LoanScheduleService {


	@Autowired
	private LoanScheduleDao loanDao;

	protected Loan getEntity(LoanVO vo) {
		return vo.getEntity();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected LoanScheduleDao getReadOnlyMaintenanceDao() {
		return loanDao;
	}

	public LoanScheduleDao getLoanDao() {
		return loanDao;
	}

	public void setLoanDao(LoanScheduleDao loanDao) {
		this.loanDao = loanDao;
	}

	@Override
	protected LoanDetailSchViewVO getValueObject(LoanDetailSchView entity) {
		LoanDetailSchViewVO loanVO = new LoanDetailSchViewVO(entity);
		return loanVO;
	}

	@Override
	protected LoanDetailSchView getEntity(LoanDetailSchViewVO vo) {
		return vo.getEntity();
	}
	
	@Override
	public List<LoanDetailSchViewVO> getloanSchedule(String loanaccId)  throws ServiceException
	{
			List<LoanDetailSchViewVO> loanList = new ArrayList<LoanDetailSchViewVO>();
		try{	
			List<LoanDetailSchView> loanListEntity =  loanDao.getloanSchedule(loanaccId);
			if (loanListEntity != null) {
				for (LoanDetailSchView loanEntity : loanListEntity) {
					LoanDetailSchViewVO loanvo = new LoanDetailSchViewVO();
					BeanUtils.copyProperties(loanEntity, loanvo);
					loanList.add(loanvo);
				}
			}
		  LoggerUtil.ibsJobDebug("Calling DAO to get schedule for loanAccId : "+loanaccId);
		}catch(DataAccessException e){
			throw new ServiceException("DataAccessException while get schedule for loanAccId : "+loanaccId, e);	
		}
		return loanList;
	}
}