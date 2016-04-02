package com.bfsi.mfi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.MfiMbsTxnLndisbrV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanDisbursementTxnService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.LoanDetailViewVO;
import com.bfsi.mfi.vo.MfiMbsTxnLndisbrVO;

/**
 * @className : DisbursementController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 * @date : 28-Jan-2014
 * 
 */

@ManagedBean(name = "loanDisbursementController")
@ViewScoped

public class LoanDisbursementController extends MaintenanceController<MfiMbsTxnLndisbrVO, MfiMbsTxnLndisbrV> 
{
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{loanDisbursementTxnService}")
	private LoanDisbursementTxnService loanDisbursementTxnService;
	private MfiMbsTxnLndisbrVO mfiMbsTxnLndisbrVO = new MfiMbsTxnLndisbrVO();
	public void loadDisbursement() throws ServiceException {
		try
		{
			//System.out.println("entered");
			//System.out.println("entered = "+mfiMbsTxnLndisbrVO.getMbsTxnId());
			//System.out.println("entered");
			//this.disbursementTxnVO = disbursementTxnService.get(disbursementTxnVO.getTxnId());
			this.mfiMbsTxnLndisbrVO = loanDisbursementTxnService.get(mfiMbsTxnLndisbrVO.getMbsTxnId());
			LoggerUtil.ibsJobDebug("Disbursement Loaded Successfully ...");
	} catch (ServiceException e) {
        LoggerUtil.ibsJobError("ServiceException while validating user password: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
    }
	catch (Exception e) {
        LoggerUtil.ibsJobError("Unhandled exception while validating user password: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
    }
	}
	

	/*public DisbursementTxnVO getDisbursementTxnVO() {
		return disbursementTxnVO;
	}

	public void setDisbursementTxnVO(DisbursementTxnVO disbursementTxnVO) {
		this.disbursementTxnVO = disbursementTxnVO;
	}*/
	
	public MfiMbsTxnLndisbrVO getMfiMbsTxnLndisbrVO() {
		return mfiMbsTxnLndisbrVO;
	}
	public void setMfiMbsTxnLndisbrVO(MfiMbsTxnLndisbrVO mfiMbsTxnLndisbrVO) {
		this.mfiMbsTxnLndisbrVO = mfiMbsTxnLndisbrVO;
	}

	/*@Override
	public DisbursementTxnVO getMaintenanceVO() {
		return (DisbursementTxnVO) disbursementTxnService;
	}

	@Override
	protected MaintenanceService<DisbursementTxnVO, DisbursementTxn> getMaintenanceService() {
		return getMaintenanceService();
	}*/
	
	public LoanDisbursementTxnService getLoanDisbursementTxnService() {
		return loanDisbursementTxnService;
	}

	public void setLoanDisbursementTxnService(LoanDisbursementTxnService loanDisbursementTxnService) {
		this.loanDisbursementTxnService = loanDisbursementTxnService;
	}

	private MfiMbsTxnLndisbrVO mfiMbsTxnLndisbrV = new MfiMbsTxnLndisbrVO();
	
	public MfiMbsTxnLndisbrVO getMfiMbsTxnLndisbrV() {
		return mfiMbsTxnLndisbrV;
	}

	public void setMfiMbsTxnLndisbrV(MfiMbsTxnLndisbrVO mfiMbsTxnLndisbrV) {
		this.mfiMbsTxnLndisbrV = mfiMbsTxnLndisbrV;
	}

	@Override
	public MfiMbsTxnLndisbrVO getMaintenanceVO() {
		return mfiMbsTxnLndisbrV;
	}

	@Override
	protected MaintenanceService<MfiMbsTxnLndisbrVO, MfiMbsTxnLndisbrV> getMaintenanceService() {
		return getMaintenanceService();
	}
	
	// For ChildLoan
	private List<MfiMbsTxnLndisbrVO> childLoan = new ArrayList<MfiMbsTxnLndisbrVO>();

	
	public List<MfiMbsTxnLndisbrVO> getChildLoan() {
		return childLoan;
	}

	public void setChildLoan(List<MfiMbsTxnLndisbrVO> childLoan) {
		this.childLoan = childLoan;
	}

	private LoanDetailViewVO loanDetailViewVO = new LoanDetailViewVO();
	
	public LoanDetailViewVO getLoanDetailViewVO() {
		return loanDetailViewVO;
	}

	public void setLoanDetailViewVO(LoanDetailViewVO loanDetailViewVO) {
		this.loanDetailViewVO = loanDetailViewVO;
	}

	public void childLoanForParent() throws ServiceException {
		try {
			this.childLoan = loanDisbursementTxnService.getchildLoan(mfiMbsTxnLndisbrVO.getCbsAcRefNo());
			LoggerUtil.ibsJobDebug(" Geting child Loan for loanAcNo :"+mfiMbsTxnLndisbrVO.getCbsAcRefNo());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while invoking child Loan : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			 LoggerUtil.ibsJobError("Unhandled exception while invoking child Loan  : MFI10001", e);
             MessageUtil.addMessage("MFI10001",getMaintenanceVO().getId());
		}
	}
}