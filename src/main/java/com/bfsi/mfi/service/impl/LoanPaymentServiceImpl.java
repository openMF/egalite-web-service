package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanPaymentDao;
import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.entity.LoanDetailPaidSchView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanPaymentService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanDetailPaidSchViewVO;
import com.bfsi.mfi.vo.LoanVO;

@Service(value = "loanPaymentService")
public class LoanPaymentServiceImpl extends ReadOnlyServiceImpl<LoanDetailPaidSchViewVO, LoanDetailPaidSchView>
		implements LoanPaymentService {


	@Autowired
	private LoanPaymentDao loanDao;

	protected Loan getEntity(LoanVO vo) {
		return vo.getEntity();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected LoanPaymentDao getReadOnlyMaintenanceDao() {
		return loanDao;
	}

	public LoanPaymentDao getLoanDao() {
		return loanDao;
	}

	public void setLoanDao(LoanPaymentDao loanDao) {
		this.loanDao = loanDao;
	}

	@Override
	protected LoanDetailPaidSchViewVO getValueObject(LoanDetailPaidSchView entity) {
		LoanDetailPaidSchViewVO loanVO = new LoanDetailPaidSchViewVO(entity);
		return loanVO;
	}

	@Override
	protected LoanDetailPaidSchView getEntity(LoanDetailPaidSchViewVO vo) {
		return vo.getEntity();
	}
	
	@Override
	public List<LoanDetailPaidSchViewVO> getloanPayment(String loanpayId)  throws ServiceException
	{
			List<LoanDetailPaidSchViewVO> loanListpayment = new ArrayList<LoanDetailPaidSchViewVO>();
		try{
			List<LoanDetailPaidSchView> loanListEntitypayment =  loanDao.getloanPayment(loanpayId);
			if (loanListEntitypayment != null) {
				for (LoanDetailPaidSchView loanEntityPay : loanListEntitypayment) {
					LoanDetailPaidSchViewVO loanvo = new LoanDetailPaidSchViewVO();
					BeanUtils.copyProperties(loanEntityPay, loanvo);
					loanListpayment.add(loanvo);
				}
			}
		 LoggerUtil.ibsJobDebug("Calling DAO for get payment for loanpay id: "+loanpayId);
		}catch(DataAccessException e){
			 throw new ServiceException("DataAccessException while getting payment for loanpay id: "+loanpayId, e);
		}	
	  return loanListpayment;

	}
}