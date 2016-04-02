package com.bfsi.mfi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CbsTxnOut;
import com.bfsi.mfi.service.CbsTxnOutService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.CbsTxnOutVO;

/**
 * @author Nirmal kanna S
 *
 */
@ManagedBean(name = "cbsTxnOutListController")
@ViewScoped
public class CbsTxnOutListController extends MaintenanceListController<CbsTxnOutVO, CbsTxnOut>
		implements Serializable 	{

	private static final long serialVersionUID = -1376002694395713795L;
	
	@ManagedProperty(value = "#{cbsTxnOutService}")
	private CbsTxnOutService cbsTxnOutService;
	
	public CbsTxnOutService getCbsTxnOutService() {
		return cbsTxnOutService;
	}

	public void setCbsTxnOutService(CbsTxnOutService cbsTxnOutService) {
		this.cbsTxnOutService = cbsTxnOutService;
	}

	@Override
	protected MaintenanceService<CbsTxnOutVO, CbsTxnOut> getMaintenanceService() {
		return cbsTxnOutService;
	}

	@Override
	protected String getViewRecordUrl() {
		return "viewCbstxnOut";
	}
}