package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgentTxnService;
import com.bfsi.mfi.service.LoanDisbursementTxnService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.RepaymentTxnService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgentTransactionVO;
import com.bfsi.mfi.vo.DisbursementTxnVO;
import com.bfsi.mfi.vo.RepaymentTxnVO;

/**
 * @className : AgentTxnController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 * @date : 28-Jan-2014
 * 
 */

@ManagedBean(name = "agentTxnController")
@ViewScoped
public class AgentTxnController extends
		MaintenanceController<AgentTransactionVO, AgentTransaction> {
	@ManagedProperty(value = "#{agentTxnService}")
	private AgentTxnService agentTxnService;
	private RepaymentTxnService repaymentTxnService;
	private LoanDisbursementTxnService disbursementTxnService;

	private AgentTransactionVO agentTxnVO = new AgentTransactionVO();
	private RepaymentTxnVO repaymentTxn = new RepaymentTxnVO();
	private DisbursementTxnVO disbursementTxnVO = new DisbursementTxnVO();

	public void loadAgentTxn() throws ServiceException 
	{
		try {
			this.agentTxnVO = agentTxnService.get(agentTxnVO.getId());
			LoggerUtil.ibsJobDebug("Transaction page loaded successfully");
		} 
		catch (ServiceException e) {
            LoggerUtil.ibsJobError("ServiceException while validating user password: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
        }
		catch (Exception e) {
            LoggerUtil.ibsJobError("Unhandled exception while validating user password: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}

	public RepaymentTxnService getRepaymentTxnService() {
		return repaymentTxnService;
	}

	public void setRepaymentTxnService(RepaymentTxnService repaymentTxnService) {
		this.repaymentTxnService = repaymentTxnService;
	}

	public LoanDisbursementTxnService getDisbursementTxnService() {
		return disbursementTxnService;
	}

	public void setDisbursementTxnService(
			LoanDisbursementTxnService disbursementTxnService) {
		this.disbursementTxnService = disbursementTxnService;
	}

	public RepaymentTxnVO getRepaymentTxn() {
		return repaymentTxn;
	}

	public void setRepaymentTxn(RepaymentTxnVO repaymentTxn) {
		this.repaymentTxn = repaymentTxn;
	}

	public DisbursementTxnVO getDisbursementTxnVO() {
		return disbursementTxnVO;
	}

	public void setDisbursementTxnVO(DisbursementTxnVO disbursementTxnVO) {
		this.disbursementTxnVO = disbursementTxnVO;
	}

	public AgentTxnService getAgentTxnService() {
		return agentTxnService;
	}

	public void setAgentTxnService(AgentTxnService agentTxnService) {
		this.agentTxnService = agentTxnService;
	}

	public AgentTransactionVO getAgentTxnVO() {
		return agentTxnVO;
	}

	public void setAgentTxnVO(AgentTransactionVO agentTxnVO) {
		this.agentTxnVO = agentTxnVO;
	}

	public AgentTransactionVO getMaintenanceVO() {
		return agentTxnVO;
	}

	@Override
	protected MaintenanceService<AgentTransactionVO, AgentTransaction> getMaintenanceService() {
		return getMaintenanceService();
	}
}