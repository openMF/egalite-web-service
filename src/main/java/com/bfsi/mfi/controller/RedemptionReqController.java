package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.MbsReqDpRedemptionView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.RedemptionReqService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MbsReqDpRedemptionViewVO;

@ManagedBean(name ="redemptionReqController")
@ViewScoped
public class RedemptionReqController extends MaintenanceController<MbsReqDpRedemptionViewVO, MbsReqDpRedemptionView> {

	
	@ManagedProperty(value = "#{redemptionReqService}")
	private RedemptionReqService redemptionReqService;
	
	private MbsReqDpRedemptionViewVO depRedemptionRequestVO = new MbsReqDpRedemptionViewVO();
	
	public void loadredemptionReq() throws ServiceException 
	{
		try
		{
			this.depRedemptionRequestVO = redemptionReqService.get(depRedemptionRequestVO.getId());
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loadredemptionReq RedemptionReqController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}
	
	
	public RedemptionReqService getRedemptionReqService() {
		return redemptionReqService;
	}


	public void setRedemptionReqService(RedemptionReqService redemptionReqService) {
		this.redemptionReqService = redemptionReqService;
	}

	public MbsReqDpRedemptionViewVO getDepRedemptionRequestVO() {
		return depRedemptionRequestVO;
	}


	public void setDepRedemptionRequestVO(
			MbsReqDpRedemptionViewVO depRedemptionRequestVO) {
		this.depRedemptionRequestVO = depRedemptionRequestVO;
	}


	@Override
	protected MaintenanceService<MbsReqDpRedemptionViewVO, MbsReqDpRedemptionView> getMaintenanceService() {
		return getMaintenanceService();
	}

	@Override
	public MbsReqDpRedemptionViewVO getMaintenanceVO() {
		return (MbsReqDpRedemptionViewVO) redemptionReqService;
	}
	

}
