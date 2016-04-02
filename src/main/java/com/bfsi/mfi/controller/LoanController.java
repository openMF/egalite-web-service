package com.bfsi.mfi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DisbursementScheduleService;
import com.bfsi.mfi.service.LoanDetailViewService;
import com.bfsi.mfi.service.LoanPaymentService;
import com.bfsi.mfi.service.LoanScheduleService;
import com.bfsi.mfi.service.LoanService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DisburseScheduleVO;
import com.bfsi.mfi.vo.LoanDetailDisbrViewVO;
import com.bfsi.mfi.vo.LoanDetailPaidSchViewVO;
import com.bfsi.mfi.vo.LoanDetailSchViewVO;
import com.bfsi.mfi.vo.LoanDetailViewVO;
import com.bfsi.mfi.vo.LoanVO;

@ManagedBean(name = "loanController")
@ViewScoped
public class LoanController extends MaintenanceController<LoanVO, Loan> {
	@ManagedProperty(value = "#{loanService}")
	private LoanService loanService;
	
	@ManagedProperty(value = "#{loanDetailViewService}")
	private LoanDetailViewService loanDetailViewService;
	
	@ManagedProperty(value = "#{loanScheduleService}")
	private LoanScheduleService loanScheduleService;
	@ManagedProperty(value = "#{loanPaymentService}")
	private LoanPaymentService loanPaymentService;
	@ManagedProperty(value = "#{disbursementScheduleService}")
	private DisbursementScheduleService disbursementScheduleService;

	private LoanVO loan = new LoanVO();
	private LoanDetailViewVO loanDetailViewVO = new LoanDetailViewVO();
	private List<LoanDetailSchViewVO> loanScdle = new ArrayList<LoanDetailSchViewVO>();
	private List<LoanDetailPaidSchViewVO> loanPaymentlist = new ArrayList<LoanDetailPaidSchViewVO>();
	private List<LoanDetailDisbrViewVO> disbursementScheduleList = new ArrayList<LoanDetailDisbrViewVO>();
	private DisburseScheduleVO disburseScheduleVO = new DisburseScheduleVO();

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;

	public DisburseScheduleVO getDisburseScheduleVO() {
		return disburseScheduleVO;
	}

	public void setDisburseScheduleVO(DisburseScheduleVO disburseScheduleVO) {
		this.disburseScheduleVO = disburseScheduleVO;
	}

	public LoanVO getLoan() {
		return loan;
	}

	public LoanScheduleService getLoanScheduleService() {
		return loanScheduleService;
	}

	public void setLoanScheduleService(LoanScheduleService loanScheduleService) {
		this.loanScheduleService = loanScheduleService;
	}

	public LoanPaymentService getLoanPaymentService() {
		return loanPaymentService;
	}

	public void setLoanPaymentService(LoanPaymentService loanPaymentService) {
		this.loanPaymentService = loanPaymentService;
	}

	public void setLoan(LoanVO loan) {
		this.loan = loan;
	}

	
	public LoanDetailViewVO getLoanDetailViewVO() {
		return loanDetailViewVO;
	}

	public void setLoanDetailViewVO(LoanDetailViewVO loanDetailViewVO) {
		this.loanDetailViewVO = loanDetailViewVO;
	}

	public List<LoanDetailSchViewVO> getLoanScdle() {
		return loanScdle;
	}

	public void setLoanScdle(List<LoanDetailSchViewVO> loanScdle) {
		this.loanScdle = loanScdle;
	}

	public List<LoanDetailPaidSchViewVO> getLoanPaymentlist() {
		return loanPaymentlist;
	}

	public void setLoanPaymentlist(List<LoanDetailPaidSchViewVO> loanPaymentlist) {
		this.loanPaymentlist = loanPaymentlist;
	}

	public DisbursementScheduleService getDisbursementScheduleService() {
		return disbursementScheduleService;
	}

	public void setDisbursementScheduleService(
			DisbursementScheduleService disbursementScheduleService) {
		this.disbursementScheduleService = disbursementScheduleService;
	}

	public List<LoanDetailDisbrViewVO> getDisbursementScheduleList() {
		return disbursementScheduleList;
	}

	public void setDisbursementScheduleList(
			List<LoanDetailDisbrViewVO> disbursementScheduleList) {
		this.disbursementScheduleList = disbursementScheduleList;
	}

	public LoanVO getloan() {
		return loan;
	}

	public void setloan(LoanVO loan) {
		this.loan = loan;
	}

	public LoanVO getLoanDetails() {
		return loan;
	}

	public void setLoanDetails(LoanVO loan) {
		this.loan = loan;
	}

	@Override
	public LoanVO getMaintenanceVO() {

		return loan;
	}

	public LoanService getLoanService() {
		return loanService;
	}

	public void setLoanService(LoanService loanService) {
		this.loanService = loanService;
	}

	public LoanDetailViewService getLoanDetailViewService() {
		return loanDetailViewService;
	}

	public void setLoanDetailViewService(LoanDetailViewService loanDetailViewService) {
		this.loanDetailViewService = loanDetailViewService;
	}

	public void loadLoan() {

		try {
			//this.loan = loanService.get(loan.getLoanAcNo());
			this.loanDetailViewVO = loanDetailViewService.getLoanView(loanDetailViewVO.getId());
			LoggerUtil.ibsJobDebug("Initializing LoanController :");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while Initializing LoanController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			 LoggerUtil.ibsJobError("Unhandled exception while initializing LoanController: MFI10001", e);
             MessageUtil.addMessage("MFI10001");
		}
	}

	@Override
	protected MaintenanceService<LoanVO, Loan> getMaintenanceService() {
		// TODO Auto-generated method stub
		return null;
	}

	// For Schedule
	public void loanSchedule() throws ServiceException {
		try {
			this.loanScdle = loanScheduleService.getloanSchedule(loanDetailViewVO.getId());
			LoggerUtil.ibsJobDebug(" Geting loan schedule for loanAcNo :"+loanDetailViewVO.getId());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while invoking loan schedule: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			 LoggerUtil.ibsJobError("Unhandled exception while invoking loan schedule : MFI10001", e);
             MessageUtil.addMessage("MFI10001",getMaintenanceVO().getId());
		}
	}

	// For Payment
	public void loanPayment() throws ServiceException {
		try {
			this.loanPaymentlist = loanPaymentService.getloanPayment(loanDetailViewVO.getId());
			LoggerUtil.ibsJobDebug(" Geting loan payment for loanAcNo :"+loanDetailViewVO.getId());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while get loan payment  : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			 LoggerUtil.ibsJobError("Unhandled exception while get loan payment : MFI10001", e);
             MessageUtil.addMessage("MFI10001",getMaintenanceVO().getId());
		}
	}

	/**
	 * For Disbursement Schedule.
	 * */
	public void getDisbursementSchedule() throws ServiceException {
		try {
			this.disbursementScheduleList = disbursementScheduleService
					.getDisbursementSchedule(loanDetailViewVO.getId());
			LoggerUtil.ibsJobDebug(" Geting disbursement schedule for loanAcNo :"+loanDetailViewVO.getId());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while geting disbursement schedule  : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			 LoggerUtil.ibsJobError("Unhandled exception while get disbursement schedule : MFI10001", e);
             MessageUtil.addMessage("MFI10001",getMaintenanceVO().getId());
		}
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
}