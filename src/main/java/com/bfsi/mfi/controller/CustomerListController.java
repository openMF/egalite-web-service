package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.Customer;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CustomerService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CustomerVO;
@ManagedBean(name = "customerListController")
@ViewScoped
public class CustomerListController extends  ReadOnlyMaintenanceListController<CustomerVO, Customer>{
    
	@ManagedProperty(value = "#{customerService}")
	private CustomerService customerService;
	
	private String custId;
	private String locCode;
	private String locBrCode;
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getLocCode() {
		return locCode;
	}
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
	
	public String getLocBrCode() {
		return locBrCode;
	}
	public void setLocBrCode(String locBrCode) {
		this.locBrCode = locBrCode;
	}
	
	
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
    @Override
	protected String getViewRecordUrl() 
    {
    	return "viewCustomer";
    }
	@Override
	protected ReadOnlyMaintenanceService<CustomerVO, Customer> getReadOnlyMaintenanceService() {
		return customerService;
	}
	
	@Override
	public void load() {
		 // String response = null;
		try {
		     if((this.custId==null) || (this.locCode==null) ||(this.locBrCode==null))
			   setRecords(null);
			else 
				if((this.custId.equals("")) && (this.locCode.equals("")) && (this.locBrCode.equals("")))
				{
					setRecords(null);
					MessageUtil.addMessage("MFI01000");
					//response = null;
				}
				else{
			       setRecords(customerService.getSearch(this.custId,this.locCode,this.locBrCode));
			      // response = "success";
				}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Service exception while loading records for controller: "+this.getClass().getName() +" : MFI10001", e);
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading records for controller: "+this.getClass().getName() +" : MFI10001", e);
		}
	
	}
	
	
	/*public String getMsg() {
		String response = null;
		  try {
			  if((this.custId==null) || (this.locCode==null) ||(this.locBrCode==null)){
				  response = null;
			  }  
			  else 
				if((this.custId.equals("")) && (this.locCode.equals("")) && (this.locBrCode.equals("")))
				   {
					MessageUtil.addMessage("MFI01000");
					response = null;
				    }
				else{
			       setRecords(customerService.getSearch(this.custId,this.locCode,this.locBrCode));
			       //response = "success";
				  }
		 }catch (ServiceException e) {
				LoggerUtil.ibsJobError("Service exception while loading records for controller: "+this.getClass().getName() +" : MFI10001", e);
			} catch (Exception e) {
				LoggerUtil.ibsJobError("Unhandled exception while loading records for controller: "+this.getClass().getName() +" : MFI10001", e);
			}
		 return response;
	  }*/
	
	
}
