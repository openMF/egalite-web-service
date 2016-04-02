package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanDao;
import com.bfsi.mfi.entity.DisburseSchedule;
import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.entity.RepaymentLiquidation;
import com.bfsi.mfi.entity.RepaymentSchedule;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanVO;

@Service(value = "loanService")
public class LoanServiceImpl extends ReadOnlyServiceImpl<LoanVO, Loan>
		implements LoanService {

	private static final String SYNC_STATUS_NA = "NA";
	private static final String SYNC_STATUS_ACK = "A";
	@Autowired
	private LoanDao loanDao;

	/*@Override
	public List<LoanDetailsListViewVO> getList() {
		List<LoanDetailsListView> entities = null;
		List<LoanDetailsListViewVO> vos = null;
		
		try {
		   entities = getReadOnlyMaintenanceDao().getList();
			if (entities == null) {
				return new ArrayList<LoanDetailsListViewVO>();
			}

		    vos = new ArrayList<LoanDetailsListViewVO>(entities.size());
			for (LoanDetailsListView entity : entities) {
				LoanDetailsListViewVO vo = getValueObject(entity);
				vos.add(vo);
			}
			LoggerUtil.ibsJobDebug("Calling DAO  for getting loans: ");
		  //return vos;
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while get list of loans :  ", e);
		}
		return vos;
	}*/

	protected Loan getEntity(LoanVO vo) {
		Loan loan = new Loan(); //
		loan.setDisburseSchedule(vo.getDisburseSchedule()); //
		loan.setAgent(vo.getAgent());//
		return vo.getEntity();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected LoanDao getReadOnlyMaintenanceDao() {
		return loanDao;
	}

	public LoanDao getLoanDao() {
		return loanDao;
	}

	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}

	@Override
	protected LoanVO getValueObject(Loan entity) {
		LoanVO loanVO = new LoanVO(entity);
		loanVO.setDisburseSchedule(entity.getDisburseSchedule());//
		loanVO.setAgent(entity.getAgent());//
		return loanVO;
	}

	@Override
	public List<LoanVO> getLoanAccounts(String customerId) {
		// TODO Auto-generated method stub
		List<LoanVO> loanList = new ArrayList<LoanVO>();
	  try{
		List<Loan> loanlist = loanDao.getLoanForCustomer(customerId);
		if (loanlist != null) {
			for (Loan loanEntity : loanlist) {
				LoanVO loanvo = new LoanVO();
				BeanUtils.copyProperties(loanEntity, loanvo);
				loanList.add(loanvo);
			}
		}
		LoggerUtil.ibsJobDebug("Calling DAO  for getting loans for customerId: "+customerId);
	}catch(DataAccessException e){
			throw new ServiceException("DataAccessException while getting loans for customerId : "+customerId, e);
		}
	  return loanList;
	}

	public List<LoanVO> getLoans(String agentId, String batchSize)
			throws ServiceException {
		List<LoanVO> loanList = new ArrayList<LoanVO>();
		List<DisburseSchedule> disbrSchdlist = new ArrayList<DisburseSchedule>();
		List<RepaymentSchedule> repaySchdlist = new ArrayList<RepaymentSchedule>();
		List<RepaymentLiquidation> repayLiq = new ArrayList<RepaymentLiquidation>();

		try {
			List<Loan> loanlist = getLoanDao().getLoanDetails(agentId,
					batchSize);
			List<Loan> loanDetaillist = new ArrayList<Loan>();
			List<String> loanAccNoList = new ArrayList<String>();

			for (Loan loan : loanlist) {
				disbrSchdlist = getLoanDao().getDisbrSchedules(
						loan.getLoanAcNo());
				repaySchdlist = getLoanDao().getRepaySchedules(
						loan.getLoanAcNo());
				repayLiq = getLoanDao().getRepayLiquidation(loan.getLoanAcNo());
				loan.setDisbrSchedule(disbrSchdlist);
				loan.setRepaymentSchedule(repaySchdlist);
				loan.setRepaymentliquidation(repayLiq);

				loanDetaillist.add(loan);
			}

			if (!loanDetaillist.isEmpty()) {
				for (Loan loan : loanDetaillist) {
					LoanVO loanVo = getValueObject(loan);
					loanList.add(loanVo);
					loanAccNoList.add(loan.getLoanAcNo());
				}
				if (!loanList.isEmpty()) {
					getLoanDao()
							.updateLoanStatus(loanAccNoList, SYNC_STATUS_NA);
				}

			}
			LoggerUtil
					.ibsJobDebug("Calling DAO  getting list of loan Account Number with agentId: "
							+ agentId);
			return loanList;
		} catch (DataAccessException e) {
			throw new ServiceException(
					"DataAccessException while getting list of loan Account Number with agentId: "
							+ agentId, e);
		}
	}

	public Boolean updateLoanStaus(List<String> loanAccNoList)
			throws ServiceException {
		if (loanAccNoList != null) {
			try {
				getLoanDao().updateLoanStatus(loanAccNoList, SYNC_STATUS_ACK);
				LoggerUtil.ibsJobDebug("Calling DAO  for updating the status of Loans: ");
			} catch (DataAccessException e) {
				throw new ServiceException(
						"Error while updating the status of Loans :", e);
			}
			return true;
		}

		return false;
	}
}