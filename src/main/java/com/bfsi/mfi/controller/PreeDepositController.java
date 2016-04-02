package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.DepositRequestExt;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.PreeDepositService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.DepositRequestVOExt;

@ManagedBean(name ="preeDepositController")
@ViewScoped
public class PreeDepositController extends MaintenanceController<DepositRequestVOExt, DepositRequestExt>{

	
	@ManagedProperty(value = "#{preeDepositService}")
	private PreeDepositService preeDepositService;
	
	private DepositRequestVOExt depositRequestVO=new DepositRequestVOExt();
	
	public void loadpreDeposit() throws ServiceException 
	{
		try
		{
			this.depositRequestVO = preeDepositService.get(depositRequestVO.getRequestId());
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException error while loadpreDeposit PreeDepositController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}
	
	
	
	public PreeDepositService getPreeDepositService() {
		return preeDepositService;
	}



	public void setPreeDepositService(PreeDepositService preeDepositService) {
		this.preeDepositService = preeDepositService;
	}



	public DepositRequestVOExt getDepositRequestVO() {
		return depositRequestVO;
	}



	public void setDepositRequestVO(DepositRequestVOExt depositRequestVO) {
		this.depositRequestVO = depositRequestVO;
	}



	@Override
	protected MaintenanceService<DepositRequestVOExt, DepositRequestExt> getMaintenanceService() {
		// TODO Auto-generated method stub
		return getMaintenanceService();
	}

	@Override
	public DepositRequestVOExt getMaintenanceVO() {
		// TODO Auto-generated method stub
		return (DepositRequestVOExt) preeDepositService;
	}

}
