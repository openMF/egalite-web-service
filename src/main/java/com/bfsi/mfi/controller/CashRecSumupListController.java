package com.bfsi.mfi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CashRecSumupView;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.service.CashRecService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CashRecSumupViewVO;


@ManagedBean(name = "cashRecSumupListController")
@ViewScoped
public class CashRecSumupListController extends  ReadOnlyMaintenanceListController<CashRecSumupViewVO, CashRecSumupView>{

	@ManagedProperty(value = "#{cashRecService}")
	private CashRecService cashRecService;
	
	@ManagedProperty(value = "#{agentService}")
	private AgentService agentService;
	
	private List<AgentVO> agtIds;
	private String agtid;
	private Date tdate;
	private String strDate;
	
	public CashRecService getCashRecService() {
		return cashRecService;
	}

	public void setCashRecService(CashRecService cashRecService) {
		this.cashRecService = cashRecService;
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	public List<AgentVO> getAgtIds() {
		return agtIds;
	}

	public void setAgtIds(List<AgentVO> agtIds) {
		this.agtIds = agtIds;
	}

	public String getAgtid() {
		return agtid;
	}

	public void setAgtid(String agtid) {
		this.agtid = agtid;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	
	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	
	
	
	/* @Override
		protected String getViewRecordUrl() 
	    {
	    	return "viewCashRecord"; //viewCashRecord.xhtml
	    }*/
	
	
	
	@Override
	protected ReadOnlyMaintenanceService<CashRecSumupViewVO, CashRecSumupView> getReadOnlyMaintenanceService() {
		return cashRecService;
	}

	
	@PostConstruct
	public void init() {
		try {
			
			agtIds = agentService.getAgentIds();

		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while loading init listservice: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while loading init listservice: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}
	}
	
	
	
	
	@Override
	public void load() {
		 
		DateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
		try {
			//System.out.println(df.format(tdate).toUpperCase());
			
			if(tdate==null)
				strDate=null;
			else
			    strDate= df.format(tdate).toUpperCase();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*try {
			System.out.println(df.format(dbDate).toUpperCase());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
		     if((this.agtid==null) && (this.strDate==null) )
		      setRecords(null);
			else 
				if((this.agtid==null) && (this.strDate.equals("")))
				{
					setRecords(null);
					MessageUtil.addMessage("MFI01000");
				}
				else{
					
			       setRecords(cashRecService.getSearch(this.agtid,this.strDate));
				}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Service exception while loading records for controller: "+this.getClass().getName() +" : MFI10001", e);
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading records for controller: "+this.getClass().getName() +" : MFI10001", e);
		}
	
	}
	@Override
	protected String getViewRecordUrl() {
		return "viewCashRecDetail";
	}
	
}
