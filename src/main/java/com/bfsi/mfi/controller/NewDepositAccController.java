package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.MbsReqDpNewAcView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.service.NewDepositAccService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.MbsReqDpNewAcViewVO;


@ManagedBean(name ="newDepositAccController")
@ViewScoped
public class NewDepositAccController extends MaintenanceController<MbsReqDpNewAcViewVO, MbsReqDpNewAcView>{

	@ManagedProperty(value = "#{newDepositAccService}")
	private NewDepositAccService newDepositAccService;
	
	private MbsReqDpNewAcViewVO newdepositRequestVO = new MbsReqDpNewAcViewVO();
	
	public void loadNewDepositAcc() throws ServiceException 
	{
		try
		{ 
			this.newdepositRequestVO = newDepositAccService.get(newdepositRequestVO.getId());
		}
		catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loadNewDepositAcc NewDepositAccController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}
		
	public NewDepositAccService getNewDepositAccService() {
		return newDepositAccService;
	}

	public void setNewDepositAccService(NewDepositAccService newDepositAccService) {
		this.newDepositAccService = newDepositAccService;
	}

	public MbsReqDpNewAcViewVO getNewdepositRequestVO() {
		return newdepositRequestVO;
	}

	public void setNewdepositRequestVO(MbsReqDpNewAcViewVO newdepositRequestVO) {
		this.newdepositRequestVO = newdepositRequestVO;
	}

	@Override
	protected MaintenanceService<MbsReqDpNewAcViewVO, MbsReqDpNewAcView> getMaintenanceService() {
		//return getMaintenanceService();
		return newDepositAccService;
	}

	@Override
	public MbsReqDpNewAcViewVO getMaintenanceVO() {
		//return    (MbsReqDpNewAcViewVO) newDepositAccService;
		return	newdepositRequestVO;
	}

}
