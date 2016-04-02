package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.service.AgentTxnService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgentTransactionVO;

/**
 * @author Nirmal kanna S
 *
 */
@ManagedBean(name = "agentTxnListController")
@ViewScoped
public class AgentTxnListController extends ReadOnlyMaintenanceListController<AgentTransactionVO, AgentTransaction>
{
	@ManagedProperty(value = "#{agentTxnService}")
	private AgentTxnService agentTxnService;
	private static String txnType = null;
	
	@Override
	protected String getViewRecordUrl() 
	{
		String page;
		AgentTransactionVO selected=getSelectedRecord();
		//txnType = selected.getTxnType();
		
		txnType = selected.getTxnCode();
		
		if(txnType .equals("R")) {
			page="viewRepayment";
		}
		else if(txnType.equals("C")) {
			page = "viewInstCollection";
		}
		else if(txnType.equals("M")) {
			page = "viewDepositMaturity";
		}
		else if(txnType.equals("T")) {
			page = "viewDepositRedem";
		}
		else if(txnType.equals("D")) {
			page = "viewDisbursement";
		}
		else {
			LoggerUtil.ibsJobError("Invalid Transaction Type : MFI00702");
            MessageUtil.addMessage("MFI00702");
			page = null;
		}
		return page;
	}

	public AgentTxnService getAgentTxnService() {
		return agentTxnService;
	}

	public void setAgentTxnService(AgentTxnService agentTxnService) {
		this.agentTxnService = agentTxnService;
	}

	protected ReadOnlyMaintenanceService<AgentTransactionVO, AgentTransaction> getReadOnlyMaintenanceService() {
		return agentTxnService;
	}

}