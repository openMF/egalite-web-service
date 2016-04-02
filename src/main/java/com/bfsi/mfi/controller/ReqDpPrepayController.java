package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.MbsReqDpPrepayView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.ReqDpPrepayService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MbsReqDpPrepayViewVO;


@ManagedBean(name ="reqDpPrepayController")
@ViewScoped
public class ReqDpPrepayController extends MaintenanceController<MbsReqDpPrepayViewVO, MbsReqDpPrepayView>{

	@ManagedProperty(value = "#{reqDpPrepayService}")
	private ReqDpPrepayService reqDpPrepayService;
	
private MbsReqDpPrepayViewVO mbsReqDpPrepayViewVO = new MbsReqDpPrepayViewVO();
	
	public void loadReqDpPrepay() throws ServiceException 
	{
		try
		{
			this.mbsReqDpPrepayViewVO = reqDpPrepayService.get(mbsReqDpPrepayViewVO.getId());
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loadReqDpPrepay ReqDpPrepayController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}
	
	
	public ReqDpPrepayService getReqDpPrepayService() {
		return reqDpPrepayService;
	}

	public void setReqDpPrepayService(ReqDpPrepayService reqDpPrepayService) {
		this.reqDpPrepayService = reqDpPrepayService;
	}


	public MbsReqDpPrepayViewVO getMbsReqDpPrepayViewVO() {
		return mbsReqDpPrepayViewVO;
	}

	public void setMbsReqDpPrepayViewVO(MbsReqDpPrepayViewVO mbsReqDpPrepayViewVO) {
		this.mbsReqDpPrepayViewVO = mbsReqDpPrepayViewVO;
	}



	@Override
	protected MaintenanceService<MbsReqDpPrepayViewVO, MbsReqDpPrepayView> getMaintenanceService() {
		return getMaintenanceService();
	}

	@Override
	public MbsReqDpPrepayViewVO getMaintenanceVO() {
		return (MbsReqDpPrepayViewVO) reqDpPrepayService;
	}
	
}
