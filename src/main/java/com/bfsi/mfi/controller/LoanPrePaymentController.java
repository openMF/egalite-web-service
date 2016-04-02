package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.MfiMbsTxnLnprepayV;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanPrePaymentService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MfiMbsTxnLnprepayVO;


@ManagedBean(name = "loanPrePaymentController")
@ViewScoped
public class LoanPrePaymentController extends MaintenanceController<MfiMbsTxnLnprepayVO, MfiMbsTxnLnprepayV>{
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	@ManagedProperty(value = "#{loanPrePaymentService}")
	private LoanPrePaymentService loanPrePaymentService;
	MfiMbsTxnLnprepayVO mfimbstxnlnprepayVO= new MfiMbsTxnLnprepayVO();
	
	public void loadPreRepayment() throws ServiceException 
	{
		try
		{
			this.mfimbstxnlnprepayVO = loanPrePaymentService.get(mfimbstxnlnprepayVO.getMbsTxnId());
			////System.out.println("VO object after loading: "+mfiMbsTxnLnrepayVO.getTxnInitTime());
			////System.out.println("VO object after loading: "+mfiMbsTxnLnrepayVO.getTxnSyncTime());
			LoggerUtil.ibsJobDebug("Repayment Loaded Successfully ...");
	} catch (ServiceException e) {
        LoggerUtil.ibsJobError("ServiceException while loading PreRepayment: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
	}
	catch (Exception e) {
        LoggerUtil.ibsJobError("Unhandled exception while loading PreRepayment: MFI10001", e);
        MessageUtil.addMessage("MFI10001");
	}
	}
	

	@Override
	public MfiMbsTxnLnprepayVO getMaintenanceVO() {
		return (MfiMbsTxnLnprepayVO) loanPrePaymentService;
	}

	@Override
	protected MaintenanceService<MfiMbsTxnLnprepayVO, MfiMbsTxnLnprepayV> getMaintenanceService() {
		return getMaintenanceService();
	}
	

	
	public MfiMbsTxnLnprepayVO getMfimbstxnlnprepayVO() {
		return mfimbstxnlnprepayVO;
	}

	public void setMfimbstxnlnprepayVO(MfiMbsTxnLnprepayVO mfimbstxnlnprepayVO) {
		this.mfimbstxnlnprepayVO = mfimbstxnlnprepayVO;
	}

	public LoanPrePaymentService getLoanPrePaymentService() {
		return loanPrePaymentService;
	}

	public void setLoanPrePaymentService(LoanPrePaymentService loanPrePaymentService) {
		this.loanPrePaymentService = loanPrePaymentService;
	}
}
