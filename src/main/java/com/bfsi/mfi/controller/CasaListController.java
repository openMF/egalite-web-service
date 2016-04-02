package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CustAcDetailListView;
import com.bfsi.mfi.service.CasaListService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.vo.CustAcDetailListViewVO;


@ManagedBean(name = "casaListController")
@ViewScoped
public class CasaListController extends
       ReadOnlyMaintenanceListController<CustAcDetailListViewVO, CustAcDetailListView> {
	
	@ManagedProperty(value = "#{casaListService}")
	private CasaListService casaListService;
	
	@Override
	protected String getViewRecordUrl() {
		return "viewCustAcDetails";
	}

	public CasaListService getCasaListService() {
		return casaListService;
	}

	public void setCasaListService(CasaListService casaListService) {
		this.casaListService = casaListService;
	}

	@Override
	protected ReadOnlyMaintenanceService<CustAcDetailListViewVO, CustAcDetailListView> getReadOnlyMaintenanceService() {
		return casaListService;
	}	
}
