package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanDisbursementTxnDao;
import com.bfsi.mfi.entity.LoanDetailSchView;
import com.bfsi.mfi.entity.MfiMbsTxnLndisbrV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanDisbursementTxnService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanDetailSchViewVO;
import com.bfsi.mfi.vo.MfiMbsTxnLndisbrVO;

@Service(value = "loanDisbursementTxnService")

public class LoanDisbursementTxnServiceImpl extends MaintenanceServiceImpl<MfiMbsTxnLndisbrVO,MfiMbsTxnLndisbrV>
		implements LoanDisbursementTxnService {

	@Autowired
	private LoanDisbursementTxnDao dao;

	@SuppressWarnings("unchecked")
	@Override
	public LoanDisbursementTxnDao  getMaintenanceDao() {
		return dao;
	}
	

	/*@Override
	protected DisbursementTxn getEntity(DisbursementTxnVO vo) {
		return vo.getEntity();
	}*/
	@Override
	protected MfiMbsTxnLndisbrV getEntity(MfiMbsTxnLndisbrVO vo) {
		return vo.getEntity();
	}

	/*@Override
	protected DisbursementTxnVO getValueObject(DisbursementTxn entity) {
		DisbursementTxnVO agentVO = new DisbursementTxnVO(entity);
		return agentVO;
	}*/
	@Override
	protected MfiMbsTxnLndisbrVO getValueObject(MfiMbsTxnLndisbrV entity) {
		MfiMbsTxnLndisbrVO agentVO = new MfiMbsTxnLndisbrVO(entity);
		return agentVO;
	}
	
// For ChildLoan
	@Override
	public List<MfiMbsTxnLndisbrVO> getchildLoan(String cbsAcRefNo)  throws ServiceException
	{
			List<MfiMbsTxnLndisbrVO> loanList = new ArrayList<MfiMbsTxnLndisbrVO>();
		try{	
			List<MfiMbsTxnLndisbrV> loanListEntity =  dao.getchildLoan(cbsAcRefNo);
			if (loanListEntity != null) {
				for (MfiMbsTxnLndisbrV loanEntity : loanListEntity) {
					MfiMbsTxnLndisbrVO loanvo = new MfiMbsTxnLndisbrVO();
					BeanUtils.copyProperties(loanEntity, loanvo);
					loanList.add(loanvo);
				}
			}
		  LoggerUtil.ibsJobDebug("Calling DAO to get schedule for loanAccId : "+cbsAcRefNo);
		}catch(DataAccessException e){
			throw new ServiceException("DataAccessException while get schedule for loanAccId : "+cbsAcRefNo, e);	
		}
		return loanList;
	}

}
