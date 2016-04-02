package com.bfsi.mfi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.entity.CbsJobHistory;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CbsJobHistoryService;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.CbsJobDetailVO;
import com.bfsi.mfi.vo.CbsJobHistoryVO;
import com.bfsi.mfi.vo.CbsUploadStatusVO;

@ManagedBean(name = "cbsJobHistoryController")
@ViewScoped
public class CbsJobHistoryController extends
		MaintenanceController<CbsJobHistoryVO, CbsJobHistory> {
	@ManagedProperty(value = "#{cbsJobHistoryService}")
	private CbsJobHistoryService cbsJobHistoryService;
	private CbsJobHistoryVO cbsJobHistory = new CbsJobHistoryVO();	
	private CbsJobDetailVO cbsJobDetails = new CbsJobDetailVO();
	
	private List<CbsUploadStatusVO> cbsUploadStatus ;
	private List<CbsJobDetailVO> cbsJobDetail;
	private List<CbsUploadStatusVO> tab1Msgs ;
	private List<CbsUploadStatusVO> tab2Msgs ;
	private List<CbsUploadStatusVO> tab3Msgs ;
	private List<CbsUploadStatusVO> tab5Msgs ;
	private List<CbsUploadStatusVO> tab6Msgs ;
	private List<CbsUploadStatusVO> tab7Msgs ;

	/*
	 * @ManagedProperty(value = "#{msg}") private ResourceBundle msg; private
	 * static String result;
	 */
	
	
	public List<CbsUploadStatusVO> getTab1Msgs() {
		tab1Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory();
		return tab1Msgs;
	}

	public List<CbsUploadStatusVO> getTab2Msgs() {
		tab2Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory2();
		return tab2Msgs;
	}

	public void setTab2Msgs(List<CbsUploadStatusVO> tab2Msgs) {
		this.tab2Msgs = tab2Msgs;
	}

	public List<CbsUploadStatusVO> getTab3Msgs() {
		tab3Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory3();
		return tab3Msgs;
	}

	public void setTab3Msgs(List<CbsUploadStatusVO> tab3Msgs) {
		this.tab3Msgs = tab3Msgs;
	}

	public List<CbsUploadStatusVO> getTab5Msgs() {
		tab5Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory5();
		return tab5Msgs;
	}

	public void setTab5Msgs(List<CbsUploadStatusVO> tab5Msgs) {
		this.tab5Msgs = tab5Msgs;
	}

	public List<CbsUploadStatusVO> getTab6Msgs() {
		tab6Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory6();
		return tab6Msgs;
	}

	public void setTab6Msgs(List<CbsUploadStatusVO> tab6Msgs) {
		this.tab6Msgs = tab6Msgs;
	}

	public List<CbsUploadStatusVO> getTab7Msgs() {
		tab7Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory7();
		return tab7Msgs;
	}

	public void setTab7Msgs(List<CbsUploadStatusVO> tab7Msgs) {
		this.tab7Msgs = tab7Msgs;
	}

	public void setTab1Msgs(List<CbsUploadStatusVO> tab1Msgs) {
		this.tab1Msgs = tab1Msgs;
	}
	
	public List<CbsUploadStatusVO> getCbsUploadStatus() {
		return cbsUploadStatus;
	}

	public void setCbsUploadStatus(List<CbsUploadStatusVO> cbsUploadStatus) {
		this.cbsUploadStatus = cbsUploadStatus;
	}

	public CbsJobDetailVO getCbsJobDetails() {
		return cbsJobDetails;
	}

	public void setCbsJobDetails(CbsJobDetailVO cbsJobDetails) {
		this.cbsJobDetails = cbsJobDetails;
	}

	public List<CbsJobDetailVO> getCbsJobDetail() {
		return cbsJobDetail;
	}

	public void setCbsJobDetail(List<CbsJobDetailVO> cbsJobDetail) {
		this.cbsJobDetail = cbsJobDetail;
	}

	public CbsJobHistoryVO getcbsJobHistory() {
		return cbsJobHistory;
	}

	public void setloan(CbsJobHistoryVO cbsJobHistory) {
		this.cbsJobHistory = cbsJobHistory;
	}

	public CbsJobHistoryVO getLoanDetails() {
		return cbsJobHistory;
	}

	public void setLoanDetails(CbsJobHistoryVO loan) {
		this.cbsJobHistory = loan;
	}

	@Override
	public CbsJobHistoryVO getMaintenanceVO() {

		return cbsJobHistory;
	}

	public CbsJobHistoryService getLoanService() {
		return cbsJobHistoryService;
	}

	public void setCbsJobHistoryService(
			CbsJobHistoryService cbsJobHistoryService) {
		this.cbsJobHistoryService = cbsJobHistoryService;
	}

	public void loadCbsJobHistory() {
		/*
		 * LoanVO loanVO = new LoanVO(); loanVO.setLoanAcNo(loan.getLoanAcNo());
		 */
		LoggerUtil.ibsJobDebug("loading cbs job history");
		try {
			this.cbsJobHistory = cbsJobHistoryService.get(cbsJobHistory
					.getJobId());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading cbs job history: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("unhandled exception while loading cbs job history: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}

	}

	public void loadJobDetail() throws ServiceException {
		LoggerUtil.ibsJobDebug("loading cbs job details");
		cbsJobDetail = new ArrayList<CbsJobDetailVO>();
		
		try {
			String jobId = cbsJobDetails.getJobId();
			if (jobId != null)
				this.cbsJobDetail = cbsJobHistoryService.getjobDetails(jobId);
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Serviceexception while loading cbs job details: MFI01206", e);
			MessageUtil.addMessage("MFI01206");
		}
		catch (Exception e) {
			LoggerUtil.ibsJobError("unhandled exception while loading cbs job details: MFI01206", e);
			MessageUtil.addMessage("MFI01206");
		}

	}
	
	public void loadCbsUploadStatus() {
		
		LoggerUtil.ibsJobDebug("loading cbs Upload Status history");
		try {
			this.cbsUploadStatus = cbsJobHistoryService.loadCbsUploadStatusHistory();
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading loadCbsUploadStatus: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("unhandled exception while loading loadCbsUploadStatus: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}

	}

	@Override
	protected MaintenanceService<CbsJobHistoryVO, CbsJobHistory> getMaintenanceService() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*public void onTabChange(TabChangeEvent event) {
		 System.out.println("which tab rue======"+event.getTab().getId());
		 String tabv=event.getTab().getId();
		 
		if(tabv!=null){
		 try {
				this.cbsUploadStatus = cbsJobHistoryService.loadDynaCbsUploadStatusHistory(event.getTab().getId());
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError("ServiceException while loading loadDynaCbsUploadStatusHistory: MFI10001",e);
				MessageUtil.addMessage("MFI10001");
			} catch (Exception e) {
				LoggerUtil.ibsJobError("unhandled exception while loading loadDynaCbsUploadStatusHistory: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
			}
		 }
		}*/
	
	
	public void loadTab1Msg(){
		try {
			tab1Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory();
			tab2Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory2();
			tab3Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory3();
			tab5Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory5();
			tab6Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory6();
			tab7Msgs = cbsJobHistoryService.loadCbsUploadStatusHistory7();
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading loadCbsUploadStatus: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("unhandled exception while loading loadCbsUploadStatus: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}
	
	
	/*
	 * @Override protected String getAuthorizePermissionString() { // TODO
	 * Auto-generated method stub return null; }
	 */
	/*
	 * public String validateId() throws ServiceException { String Listid =
	 * cbsJobHistory.getRecordId(); try { // check availability of user id if
	 * (!cbsJobHistoryService.selectPk(Listid)) {
	 * FacesContext.getCurrentInstance().addMessage( null,new
	 * FacesMessage(FacesMessage.SEVERITY_ERROR,
	 * msg.getString("userMgmt.msg.userIdExists"), null)); result="failure"; }
	 * else { result="success"; } } catch (ServiceException e) {
	 * logger.error("Unexpected error while Checking userId = " +
	 * e.getMessage(), e);
	 * MessageUtil.addInfoMessageWithoutKey("Unexpected Error", e.getMessage());
	 * result="failure"; } return result; }
	 */

}