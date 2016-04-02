package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LoanRepaymentTxnDao;
import com.bfsi.mfi.entity.MfiMbsTxnLndisbrV;
import com.bfsi.mfi.entity.MfiMbsTxnLnrepayV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanRepaymentTxnService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.MfiMbsTxnLndisbrVO;
import com.bfsi.mfi.vo.MfiMbsTxnLnrepayVO;

@Service(value = "loanRepaymentTxnService")
public class LoanRepaymentTxnServiceImpl extends MaintenanceServiceImpl<MfiMbsTxnLnrepayVO,MfiMbsTxnLnrepayV> implements LoanRepaymentTxnService{


	@Autowired
	private LoanRepaymentTxnDao loanRepaymentTxnDao;

	@Override
	@SuppressWarnings("unchecked")
	public LoanRepaymentTxnDao getMaintenanceDao() {
		return loanRepaymentTxnDao;
	}

	public void setLoanRepaymentTxnDao(LoanRepaymentTxnDao loanRepaymentTxnDao) {
		this.loanRepaymentTxnDao = loanRepaymentTxnDao;
	}

	@Override
	protected MfiMbsTxnLnrepayV getEntity(MfiMbsTxnLnrepayVO vo) {
		return vo.getEntity();
	}

	@Override
	protected MfiMbsTxnLnrepayVO getValueObject(MfiMbsTxnLnrepayV entity) {
		MfiMbsTxnLnrepayVO vo = new MfiMbsTxnLnrepayVO(entity);
		return vo;
	}
	
	// For ChildLoan
		@Override
		public List<MfiMbsTxnLnrepayVO> getchildLoan(String cbsAcRefNo)  throws ServiceException
		{
				List<MfiMbsTxnLnrepayVO> loanList = new ArrayList<MfiMbsTxnLnrepayVO>();
			try{	
				List<MfiMbsTxnLnrepayV> loanListEntity =  loanRepaymentTxnDao.getchildLoan(cbsAcRefNo);
				if (loanListEntity != null) {
					for (MfiMbsTxnLnrepayV loanEntity : loanListEntity) {
						MfiMbsTxnLnrepayVO loanvo = new MfiMbsTxnLnrepayVO();
						BeanUtils.copyProperties(loanEntity, loanvo);
						loanList.add(loanvo);
					}
				}
			  LoggerUtil.ibsJobDebug("Calling DAO to get child for loanAccId : "+cbsAcRefNo);
			}catch(DataAccessException e){
				throw new ServiceException("DataAccessException while get child for loanAccId : "+cbsAcRefNo, e);	
			}
			return loanList;
		}

}
