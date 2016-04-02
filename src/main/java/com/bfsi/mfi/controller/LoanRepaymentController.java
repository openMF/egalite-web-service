package com.bfsi.mfi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.MfiMbsTxnLnrepayV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanRepaymentTxnService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MfiMbsTxnLnrepayVO;

@ManagedBean(name = "loanRepaymentController")
@ViewScoped
public class LoanRepaymentController extends MaintenanceController<MfiMbsTxnLnrepayVO, MfiMbsTxnLnrepayV>{

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{loanRepaymentTxnService}")
	private LoanRepaymentTxnService loanRepaymentTxnService;
	
	private MfiMbsTxnLnrepayVO mfiMbsTxnLnrepayVO=new MfiMbsTxnLnrepayVO();
	

	public void loadRepayment() throws ServiceException 
	{
		try
		{
			this.mfiMbsTxnLnrepayVO = loanRepaymentTxnService.get(mfiMbsTxnLnrepayVO.getMbsTxnId());
			//System.out.println("VO object after loading: "+mfiMbsTxnLnrepayVO.getTxnInitTime());
			//System.out.println("VO object after loading: "+mfiMbsTxnLnrepayVO.getTxnSyncTime());
			LoggerUtil.ibsJobDebug("Repayment Loaded Successfully ...");
	} catch (ServiceException e) {
        LoggerUtil.ibsJobError("ServiceException while loading Repayment: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
	}
	catch (Exception e) {
        LoggerUtil.ibsJobError("Unhandled exception while loading Repayment: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
	}
	}

	@Override
	public MfiMbsTxnLnrepayVO getMaintenanceVO() {
		return (MfiMbsTxnLnrepayVO) loanRepaymentTxnService;
	}

	@Override
	protected MaintenanceService<MfiMbsTxnLnrepayVO, MfiMbsTxnLnrepayV> getMaintenanceService() {
		return getMaintenanceService();
	}

/*	public RepaymentTxnService getRepaymentTxnService() {
		return repaymentTxnService;
	}

	public void setRepaymentTxnService(RepaymentTxnService repaymentTxnService) {
		this.repaymentTxnService = repaymentTxnService;
	}

	public RepaymentTxnVO getRepaymentTxnVO() {
		return repaymentTxnVO;
	}

	public void setRepaymentTxnVO(RepaymentTxnVO repaymentTxnVO) {
		this.repaymentTxnVO = repaymentTxnVO;
	}
*/
	
	public LoanRepaymentTxnService getLoanRepaymentTxnService() {
		return loanRepaymentTxnService;
	}

	public void setLoanRepaymentTxnService(
			LoanRepaymentTxnService loanRepaymentTxnService) {
		this.loanRepaymentTxnService = loanRepaymentTxnService;
	}


	
	public MfiMbsTxnLnrepayVO getMfiMbsTxnLnrepayVO() {
		return mfiMbsTxnLnrepayVO;
	}

	public void setMfiMbsTxnLnrepayVO(MfiMbsTxnLnrepayVO mfiMbsTxnLnrepayVO) {
		this.mfiMbsTxnLnrepayVO = mfiMbsTxnLnrepayVO;
	}
	
	
	// For ChildLoan
	private List<MfiMbsTxnLnrepayVO> childLoan = new ArrayList<MfiMbsTxnLnrepayVO>();

	
	public List<MfiMbsTxnLnrepayVO> getChildLoan() {
		return childLoan;
	}


	public void setChildLoan(List<MfiMbsTxnLnrepayVO> childLoan) {
		this.childLoan = childLoan;
	}

	public void childLoanForParent() throws ServiceException {
		try {
			this.childLoan = loanRepaymentTxnService.getchildLoan(mfiMbsTxnLnrepayVO.getCbsAcRefNo());
			LoggerUtil.ibsJobDebug(" Geting child Loan for loanAcNo :"+mfiMbsTxnLnrepayVO.getCbsAcRefNo());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while invoking child Loan : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			 LoggerUtil.ibsJobError("Unhandled exception while invoking child Loan  : MFI10001", e);
             MessageUtil.addMessage("MFI10001",getMaintenanceVO().getId());
		}
	}
}
