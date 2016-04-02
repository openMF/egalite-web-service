package com.bfsi.mfi.controller;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CustAcDetailView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CasaService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CustAcDetailViewVO;

@ManagedBean(name = "casaController")
@ViewScoped
public class CasaController extends MaintenanceController<CustAcDetailViewVO, CustAcDetailView>{

	@ManagedProperty(value = "#{casaService}")
	private CasaService casaService;
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	private CustAcDetailViewVO custAcDetailViewVO = new CustAcDetailViewVO();
	
	@Override
	protected MaintenanceService<CustAcDetailViewVO, CustAcDetailView> getMaintenanceService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustAcDetailViewVO getMaintenanceVO() {
		return custAcDetailViewVO;
	}

	public CasaService getCasaService() {
		return casaService;
	}

	public void setCasaService(CasaService casaService) {
		this.casaService = casaService;
	}

	public CustAcDetailViewVO getCustAcDetailViewVO() {
		return custAcDetailViewVO;
	}

	public void setCustAcDetailViewVO(CustAcDetailViewVO custAcDetailViewVO) {
		this.custAcDetailViewVO = custAcDetailViewVO;
	}

	public void loadCustAc() {
		try {
			this.custAcDetailViewVO = casaService.getCustAc(custAcDetailViewVO.getId());
			LoggerUtil.ibsJobDebug("Initializing LoanController :");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while Initializing LoanController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			 LoggerUtil.ibsJobError("Unhandled exception while initializing LoanController: MFI10001", e);
             MessageUtil.addMessage("MFI10001");
		}
	}
	
}
