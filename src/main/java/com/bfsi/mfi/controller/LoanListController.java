package com.bfsi.mfi.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.bfsi.mfi.entity.LoanDetailsListView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LoanDetailsListViewService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.LoanDetailsListViewVO;

@ManagedBean(name = "loanListController")
@ViewScoped
public class LoanListController extends
		ReadOnlyMaintenanceListController<LoanDetailsListViewVO, LoanDetailsListView> {
	
	//Adding search fields in list screen.
	private String loanAcNo,brCode,custId,cfCode,agtId,locCode,parentLoanAcNo,parentCustID;
		
	@ManagedProperty(value = "#{loanDetailsListViewService}")
	private LoanDetailsListViewService loanDetailsListViewService;
	
	@Override
	protected String getViewRecordUrl() {
		return "viewLoanAccount";
	}

	/**
	 * Override to get customize LoanList screen with additional data base on conditions. 
	 * @see com.bfsi.mfi.controller.ReadOnlyMaintenanceListController#load()
	 */
	
	@Override
	public void load() {
		//loanAcNo,brCode,custId,cfCode,agtId,locCode;
		try {
			if((this.loanAcNo==null) || (this.brCode==null) ||(this.custId==null)|| (this.cfCode==null) ||(this.agtId==null)||(this.locCode==null)||(this.parentLoanAcNo==null)||(this.parentCustID==null) )
				   setRecords(null);
			else 
				if((this.loanAcNo.equals("")) && (this.brCode.equals("")) && (this.custId.equals(""))
						        && (this.cfCode.equals("")) && (this.agtId.equals(""))&& (this.locCode.equals(""))&& (this.parentLoanAcNo.equals(""))&& (this.parentCustID.equals("")))
				{
					setRecords(null);
					MessageUtil.addMessage("MFI01000");
				}
				else{
					//setRecords(getLoanDetailsListViewService().getList());
					setRecords(getLoanDetailsListViewService().getSearch(this.loanAcNo,this.brCode,this.custId,this.cfCode,this.agtId,this.locCode,this.parentLoanAcNo,this.parentCustID));
					//LoggerUtil.ibsJobDebug("Load list of loans : ");			         
				}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading list of loans : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading list of Loans : MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}
	}
	
	public void openRegistration(ActionEvent event) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.dispatch("/deviceadmin/deviceRegistration.xhtml");
		} catch (IOException e) {
			LoggerUtil.ibsJobError("Input Output exception while invoking registration : MFI00100 ", e);
            MessageUtil.addMessage("MFI00100");
		}
	}

	/*public LoanService getLoanService() {
		return loanService;
	}

	public void setLoanService(LoanService loanService) {
		this.loanService = loanService;
	}*/

	public LoanDetailsListViewService getLoanDetailsListViewService() {
		return loanDetailsListViewService;
	}

	public void setLoanDetailsListViewService(LoanDetailsListViewService loanDetailsListViewService) {
		this.loanDetailsListViewService = loanDetailsListViewService;
	}
	
	protected ReadOnlyMaintenanceService<LoanDetailsListViewVO, LoanDetailsListView> getReadOnlyMaintenanceService() {
		return loanDetailsListViewService;
	}
	public String getLoanAcNo() {
		return loanAcNo;
	}

	public void setLoanAcNo(String loanAcNo) {
		this.loanAcNo = loanAcNo;
	}

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCfCode() {
		return cfCode;
	}

	public void setCfCode(String cfCode) {
		this.cfCode = cfCode;
	}

	public String getAgtId() {
		return agtId;
	}

	public void setAgtId(String agtId) {
		this.agtId = agtId;
	}

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	public String getParentLoanAcNo() {
		return parentLoanAcNo;
	}

	public void setParentLoanAcNo(String parentLoanAcNo) {
		this.parentLoanAcNo = parentLoanAcNo;
	}

	public String getParentCustID() {
		return parentCustID;
	}

	public void setParentCustID(String parentCustID) {
		this.parentCustID = parentCustID;
	}
}