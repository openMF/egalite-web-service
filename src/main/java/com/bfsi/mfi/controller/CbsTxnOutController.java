package com.bfsi.mfi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CbsTxnOut;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsTxnOutService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CbsTxnOutVO;


/**
 * @className : AgentController.java
 * @description : Controller class for agents Registration
 * @author : Nirmal kanna S
 */

@ManagedBean(name = "cbsTxnOutController")
@ViewScoped
public class CbsTxnOutController extends MaintenanceController<CbsTxnOutVO, CbsTxnOut>
			implements Serializable
	{
	private static final long serialVersionUID = -8144614324632010903L;
	
	@ManagedProperty(value = "#{cbsTxnOutService}")
	private CbsTxnOutService cbsTxnOutService;
	
	private CbsTxnOutVO cbsTxnOut = new CbsTxnOutVO();
	
	public void loadCbsTxnOut() throws ServiceException {
		
		LoggerUtil.ibsJobDebug("Validation in loadAgent() method");
		//System.out.println("Id=" + cbsTxnOut.getMfiOutSeqno());
		String id = cbsTxnOut.getMfiOutSeqno();
		this.cbsTxnOut = cbsTxnOutService.get(id);
	}

	public CbsTxnOutService getCbsTxnOutService() {
		return cbsTxnOutService;
	}

	public void setCbsTxnOutService(CbsTxnOutService cbsTxnOutService) {
		this.cbsTxnOutService = cbsTxnOutService;
	}

	public CbsTxnOutVO getCbsTxnOut() {
		return cbsTxnOut;
	}

	public void setCbsTxnOut(CbsTxnOutVO cbsTxnOut) {
		this.cbsTxnOut = cbsTxnOut;
	}

	@Override
	public CbsTxnOutVO getMaintenanceVO() {
		return (CbsTxnOutVO) cbsTxnOutService;
	}

	@Override
	protected MaintenanceService<CbsTxnOutVO, CbsTxnOut> getMaintenanceService() {
		return getMaintenanceService();
	}
}