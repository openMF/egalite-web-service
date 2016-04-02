package com.bfsi.mfi.controller;




import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.bfsi.mfi.entity.Cash;
import com.bfsi.mfi.service.CashSettlementService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.vo.CashSettlementVO;


@ManagedBean(name = "cashSettlementListController")
@ViewScoped
public class CashSettlementListController extends MaintenanceListController<CashSettlementVO, Cash>
{
	@ManagedProperty(value = "#{cashSettlementService}")
	private CashSettlementService cashSettlementService;
		
	public CashSettlementService getCashSettlementService() {
		return cashSettlementService;
	}
	public void setCashSettlementService(CashSettlementService cashSettlementService) {
		this.cashSettlementService = cashSettlementService;
	}
	
	@Override
	protected MaintenanceService<CashSettlementVO, Cash> getMaintenanceService() {
		// TODO Auto-generated method stub
		return cashSettlementService;
	}


	@Override
	protected String getViewRecordUrl() {
		return "viewCashSettlement";
	}
}	