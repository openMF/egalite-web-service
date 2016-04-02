package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.MbsReqReceiverView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositeReqService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MbsReqReceiverViewVO;

@ManagedBean(name = "depositeReqListController")
@ViewScoped
public class DepositeReqListController extends MaintenanceListController<MbsReqReceiverViewVO, MbsReqReceiverView> {

	@ManagedProperty(value = "#{depositeReqService}")
	private DepositeReqService depositeReqService ;
	
	private MbsReqReceiverViewVO mbsReqReceiverViewVO = new MbsReqReceiverViewVO();
	
	
	public void loadDepositeReq() throws ServiceException 
	{
		try
		{
			this.mbsReqReceiverViewVO = depositeReqService.get(mbsReqReceiverViewVO.getId());
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException error while loadDepositeReq DepositeReqListController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}

	
	public DepositeReqService getDepositeReqService() {
		return depositeReqService;
	}
	
	
	public void setDepositeReqService(DepositeReqService depositeReqService) {
		this.depositeReqService = depositeReqService;
	}

	
	
	/*public DepositRequestVO getDepositRequestVO() {
		return depositRequestVO;
	}


	public void setDepositRequestVO(DepositRequestVO depositRequestVO) {
		this.depositRequestVO = depositRequestVO;
	}*/


	// Panding for conditions.........................
	@Override
	protected String getViewRecordUrl() {
		{
			String page;
			MbsReqReceiverViewVO selected=getSelectedRecord();
			if(selected.getTxnCode().equals("D21")) //txn_code
			{
				page="/Deposite/viewNewDepositAcc";
			}
			else if(selected.getTxnCode().equals("D22"))
			{
				page= "/Deposite/viewredemptionReq";  
			}
			else if(selected.getTxnCode().equals("D23"))
			{
				page= "/Deposite/viewDepositPrePayReq";  
			}
			else if(selected.getTxnCode().equals("C21"))
			{
				page= "/Deposite/viewCashDeposit"; 
			}
			else if(selected.getTxnCode().equals("C22"))
			{
				page= "/Deposite/viewCashWithdrawal"; //viewCashWithdrawal.xhtml
			}
			else
			{
				LoggerUtil.ibsJobError("Invalid Request Type : MFI00728");
	            MessageUtil.addMessage("MFI00728");
				page = null;
			}
			return page;
		}
	}

	
	@Override
	protected MaintenanceService<MbsReqReceiverViewVO, MbsReqReceiverView> getMaintenanceService() {
		return depositeReqService;
	}

}
