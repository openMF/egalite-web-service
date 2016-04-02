package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.bfsi.mfi.entity.MbsReqReceiverView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CashWithAndDepReqService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MbsReqReceiverViewVO;

@ManagedBean(name = "cashWithandDepreqListController")
@ViewScoped
public class CashWithandDepreqListController extends MaintenanceListController<MbsReqReceiverViewVO, MbsReqReceiverView>{

	@ManagedProperty(value = "#{cashWithAndDepReqService}")
	private CashWithAndDepReqService cashWithAndDepReqService ;

	private MbsReqReceiverViewVO mbsReqReceiverViewVO = new MbsReqReceiverViewVO();
	
	public CashWithAndDepReqService getCashWithAndDepReqService() {
		return cashWithAndDepReqService;
	}

	public void setCashWithAndDepReqService(
			CashWithAndDepReqService cashWithAndDepReqService) {
		this.cashWithAndDepReqService = cashWithAndDepReqService;
	}
	
	public void loadDepositeReq() throws ServiceException 
	{
		try
		{
			this.mbsReqReceiverViewVO = cashWithAndDepReqService.get(mbsReqReceiverViewVO.getId());
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException error while loadDepositeReq DepositeReqListController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
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
				page="viewNewDepositAcc";
			}
			else if(selected.getTxnCode().equals("D22"))
			{
				page= "viewredemptionReq";  
			}
			else if(selected.getTxnCode().equals("D23"))
			{
				page= "viewDepositPrePayReq";  
			}
			else if(selected.getTxnCode().equals("C21"))
			{
				page= "viewCashDeposit"; 
			}
			else if(selected.getTxnCode().equals("C22"))
			{
				page= "viewCashWithdrawal"; //viewCashWithdrawal.xhtml
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
		return cashWithAndDepReqService;
	}
}