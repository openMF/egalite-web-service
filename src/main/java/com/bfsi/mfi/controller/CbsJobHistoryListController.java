package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CbsJobHistory;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsJobHistoryService;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CbsJobHistoryVO;

/**
 * Controller for showing the job history of CBS interface displaying when it
 * was last run, how many records were fetched in each run
 * 
 * @author bablu
 * 
 */
@ManagedBean(name = "cbsJobHistoryListController")
@ViewScoped
public class CbsJobHistoryListController extends
		ReadOnlyMaintenanceListController<CbsJobHistoryVO, CbsJobHistory> {
	@ManagedProperty(value = "#{cbsJobHistoryService}")
	private CbsJobHistoryService cbsJobHistoryService;
	private boolean response = false;
	
	@Override
	protected String getViewRecordUrl() {
		return "listCbsJobHistory";
	}

	public CbsJobHistoryService getCbsJobHistoryService() {
		return cbsJobHistoryService;
	}

	public void setCbsJobHistoryService(
			CbsJobHistoryService cbsJobHistoryService) {
		this.cbsJobHistoryService = cbsJobHistoryService;
	}

	protected ReadOnlyMaintenanceService<CbsJobHistoryVO, CbsJobHistory> getReadOnlyMaintenanceService() {
		return cbsJobHistoryService;
	}

	public void startCbsJob() {
		LoggerUtil.ibsJobDebug("Starting CBS Job");
		try {
			response = true;
			cbsJobHistoryService.startCbsJob();
			MessageUtil.addMessage("MFI01204");
			response = false;
			
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while performing CBS Job: MFI01205",e);
			MessageUtil.addMessage("MFI01205");
		}
		catch (Exception e) {
			LoggerUtil.ibsJobError("unhandled exception while performing CBS Job: MFI01205",e);
			MessageUtil.addMessage("MFI01205");
		}
	}
	
}
