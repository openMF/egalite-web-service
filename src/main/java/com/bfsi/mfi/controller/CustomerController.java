package com.bfsi.mfi.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.StreamedContent;

import com.bfsi.mfi.entity.Customer;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CustomerService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.LoanService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CustomerVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.LoanVO;

@ManagedBean(name = "customerController")
@SessionScoped
public class CustomerController extends
		ReadOnlyMaintenanceController<CustomerVO, Customer> {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{customerService}")
	private CustomerService customerService;
	@ManagedProperty(value = "#{loanService}")
	private LoanService loanService;
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public List<ListValueVO> getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(List<ListValueVO> syncStatus) {
		this.syncStatus = syncStatus;
	}

	private List<ListValueVO> syncStatus;

	private StreamedContent image;

	public StreamedContent getImage() {
		return image;
	}

	public void setImage(StreamedContent image) {
		this.image = image;
	}

	public LoanService getLoanService() {
		return loanService;
	}

	public void setLoanService(LoanService loanService) {
		this.loanService = loanService;
	}

	private CustomerVO customer = new CustomerVO();
	private List<LoanVO> loanList;

	public List<LoanVO> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<LoanVO> loanList) {
		this.loanList = loanList;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostConstruct
	public void init() {
		syncStatus = listservice.get("txnStatus");
		ListOfValuesUtil.addLocaleDescription(syncStatus);
	}

	public void loadCustomer() {
		try {

			this.customer = customerService.get(customer.getCustomerId());
			//System.out.println(customer.getGender());
			if(customer.getGender() !=null)
			{
				gender = listservice.getValue(customer.getGender(),ListValue.LIST_NAME_GENDER);
			}
			else
			{
				gender = "";
			}
			/*
			 * syncStatus = listservice.get("txnStatus");
			 * ListOfValuesUtil.addLocaleDescription(syncStatus);
			 */
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while initializing CustomerController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			
			LoggerUtil.ibsJobError("Unhandled exception while initializing CustomerController: MFI10001", e);
            MessageUtil.addMessage("MFI10001");
		}

	}

	@Override
	public CustomerVO getMaintenanceVO() {

		return customer;
	}

	@Override
	protected CustomerService getReadOnlyMaintenanceService() {
		return customerService;
	}

}
