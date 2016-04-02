package com.bfsi.mfi.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.DisburseSchedule;
import com.bfsi.mfi.entity.LoanDetailDisbrView;
import com.bfsi.mfi.service.DisbursementScheduleService;
import com.bfsi.mfi.vo.LoanDetailDisbrViewVO;

@ManagedBean(name = "disbursementScheduleController")
@ViewScoped
@PermissionCollection({
	@Permission(type = PermissionType.ADD, name = "addAgency"),
	@Permission(type = PermissionType.MODIFY, name = "modifyAgency"),
	@Permission(type = PermissionType.DELETE, name = "deleteAgency"),
	@Permission(type = PermissionType.AUTHORIZE, name = "authAgency"),
	@Permission(type = PermissionType.LIST, name = "listAgencies") })
public class DisbursementScheduleController extends  MaintenanceController<LoanDetailDisbrViewVO, LoanDetailDisbrView> 
{
	@ManagedProperty(value = "#{disbursementScheduleService}")
	private DisbursementScheduleService disbursementScheduleService;
	private LoanDetailDisbrViewVO adddbrSchedule = new LoanDetailDisbrViewVO();
	private Date scheduleDueDate;
	private Double amountToDisbr;
	
	public Date getScheduleDueDate() {
		return scheduleDueDate;
	}

	public void setScheduleDueDate(Date scheduleDueDate) {
		this.scheduleDueDate = scheduleDueDate;
	}

	public Double getAmountToDisbr() {
		return amountToDisbr;
	}

	public void setAmountToDisbr(Double amountToDisbr) {
		this.amountToDisbr = amountToDisbr;
	}

	public LoanDetailDisbrViewVO getadddbrSchedule() {
		return adddbrSchedule;
	}

	public void setadddbrSchedule(LoanDetailDisbrViewVO adddbrSchedule) {
		this.adddbrSchedule = adddbrSchedule;
	}

	@Override
	public LoanDetailDisbrViewVO getMaintenanceVO() {

		return adddbrSchedule;
	}

	public DisbursementScheduleService getDisbursementScheduleService() {
		return disbursementScheduleService;
	}

	public void setDisbursementScheduleService(DisbursementScheduleService disbursementScheduleService) {
		this.disbursementScheduleService = disbursementScheduleService;
	}

	@Override
	protected DisbursementScheduleService getMaintenanceService() {
		return disbursementScheduleService;
	}
	
	// For row editing
	private String item;
	 public String getItem() {
	        return item;
	    }
	 
	    public void setItem(String item) {
	        this.item = item;
	    }
	 public void onEdit(RowEditEvent event) {  
	        FacesMessage msg = new FacesMessage("Manual Disbursement Schedule Edited",((DisburseSchedule) event.getObject()).getId());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  
	       
	    public void onCancel(RowEditEvent event) {  
	        FacesMessage msg = new FacesMessage("Manual Disbursement Schedule Cancelled");   
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
	        orderList.remove((DisburseSchedule) event.getObject());
	    }  
	
	 private static final ArrayList<DisburseSchedule> orderList = new ArrayList<DisburseSchedule>();
	 
	    public ArrayList<DisburseSchedule> getOrderList() {
	    	item = "";
	        return orderList;
	    }
	 
	    public String addAction() {
	    	DisburseSchedule orderitem = new DisburseSchedule(this.scheduleDueDate, this.amountToDisbr);
	        orderList.add(orderitem);
	        orderitem.setdType("E");
	        return null;
	    }
}
