package com.bfsi.mfi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.RefCode;
import com.bfsi.mfi.entity.RefCodeDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.ReferenceCodeDetailService;
import com.bfsi.mfi.service.ReferenceCodeService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.RefCodeDetailVO;
import com.bfsi.mfi.vo.RefCodeVO;

/**
 * @author Bablu kumar
 *
 */
@ManagedBean(name = "referenceCodeController")
@ViewScoped
@PermissionCollection({
	@Permission(type = PermissionType.ADD, name = "addRefCode"),
	@Permission(type = PermissionType.MODIFY, name = "modifyRefCode"),
	@Permission(type = PermissionType.DELETE, name = "deleteRefCode"),
	@Permission(type = PermissionType.AUTHORIZE, name = "authRefCode"),
	@Permission(type = PermissionType.LIST, name = "listRefCode") })

public class ReferenceCodeController extends MaintenanceController<RefCodeVO, RefCode>{
	
	@ManagedProperty(value = "#{refcodeService}")
	private ReferenceCodeService refcodeService;
	@ManagedProperty(value = "#{refcodedetailService}")
	private ReferenceCodeDetailService refcodedetailService;
	
	private RefCodeVO refcode = new RefCodeVO();
	private RefCodeDetailVO refcodeDetailVo = new RefCodeDetailVO();
	
	
	public RefCodeDetailVO getRefcodeDetailVo() {
		return refcodeDetailVo;
	}
	public void setRefcodeDetailVo(RefCodeDetailVO refcodeDetailVo) {
		this.refcodeDetailVo = refcodeDetailVo;
	}
	private List<ListValueVO> refValid;
	private RefCodeVO existing = new RefCodeVO();
	private RefCodeVO refCodeVO = new RefCodeVO();
	private List<RefCodeDetailVO> refcodelist = new ArrayList<RefCodeDetailVO>();
	private static final String OUTCOME_SUCCESS = "success";
	private static String result;

	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	
	

	public ReferenceCodeDetailService getRefcodedetailService() {
		return refcodedetailService;
	}
	public void setRefcodedetailService(
			ReferenceCodeDetailService refcodedetailService) {
		this.refcodedetailService = refcodedetailService;
	}
	public List<RefCodeDetailVO> getRefcodelist() {
		return refcodelist;
	}
	public void setRefcodelist(List<RefCodeDetailVO> refcodelist) {
		this.refcodelist = refcodelist;
	}
	public RefCodeVO getRefCodeVO() {
		return refCodeVO;
	}
	public void setRefCodeVO(RefCodeVO refCodeVO) {
		this.refCodeVO = refCodeVO;
	}
	public RefCodeVO getrefcode() {
		return refcode;
	}
	public void setrefcode(RefCodeVO refcode) {
		this.refcode = refcode;
	}
	
	public ReferenceCodeService getRefcodeService() {
		return refcodeService;
	}
	public void setRefcodeService(ReferenceCodeService refcodeService) {
		this.refcodeService = refcodeService;
	}
	public RefCodeVO getRefcode() {
		return refcode;
	}
	public void setRefcode(RefCodeVO refcode) {
		this.refcode = refcode;
	}
	@Override
	public RefCodeVO getMaintenanceVO() {
		return refcode;
	}

	public List<ListValueVO> getRefValid() {
		return refValid;
	}
	public void setRefValid(List<ListValueVO> refValid) {
		this.refValid = refValid;
	}
	
	
	@PostConstruct
	public void init() {

		refValid = listservice.get("isValid");
		ListOfValuesUtil.addLocaleDescription(refValid);
	}
	
	@Override
	protected ReferenceCodeService getMaintenanceService() {

		return refcodeService;
	}

	public ReferenceCodeService getReferenceCodeService() {
		return refcodeService;
	}

	public void setReferenceCodeService(ReferenceCodeService refcodeService) {
		this.refcodeService = refcodeService;
	}
	
	
	public ListValueService getListservice() {
		return listservice;
	}
	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}
	public boolean isAuthorize() {
		return !("A".equals(refcode.getAuthStatus()));
	}
	
	public String checkModifyForUpdate() {
	

		if (refcode.getRefMasterCode().equals(existing.getRefMasterCode())
				&& refcode.getCodeDesc().equals(existing.getCodeDesc())
				&& refcode.getPurpose().equals(existing.getPurpose())
				&& refcode.getValidRef().equals(existing.getValidRef())) {
			
			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		
		} else {
			super.update();
		}

		return "success";
	}
	
	
	public void loadReferenceCode()
	{
		RefCodeVO refcodeVO = new RefCodeVO();
		refcodeVO.setRefMasterCode(refcode.getRefMasterCode());
		try {
		this.refcode = refcodeService.get(refcode.getRefMasterCode());
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading RefCodeservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading RefCodeservice: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(refcode);
		existing = (RefCodeVO) refcode.clone();
	}
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	
	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	
	// For RefCodeDetail Update query
	 public String onRowEdit(RowEditEvent event)throws ServiceException 
		{
			try {
				Integer rowIndex = (Integer) event.getComponent().getNamingContainer().getAttributes().get("rowIndex");
				
					RefCodeDetailVO refCodeDetai = (RefCodeDetailVO)refcodelist.get(rowIndex);
					
						RefCodeDetail refCodeDetail = new RefCodeDetail();
						refCodeDetail.setRefMasterCode(refCodeDetai.getRefMasterCode());
						refCodeDetail.setRefDetailCode(refCodeDetai.getRefDetailCode());
						refCodeDetail.setDetailCodeDesc(refCodeDetai.getDetailCodeDesc());
						refCodeDetail.setTransValueEga(refCodeDetai.getTransValueEga());
						refCodeDetail.setTransValueInt(refCodeDetai.getTransValueInt());
						refCodeDetail.setIsValid(refCodeDetai.getValidRefdetail());
						refCodeDetail.setCodeSrNo(refCodeDetai.getCodeSrNo());
				
				refcodedetailService.getrowUpdate(refCodeDetail);
				MessageUtil.addMessage("MFI10009", getMaintenanceVO().getId());
				result = OUTCOME_SUCCESS;
				//return OUTCOME_SUCCESS;
			} 
			catch (ServiceException e) {
				LoggerUtil.ibsJobError("Unhandled exception while deleting record: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
				result = "failure";
			}
			return result;
		}
	     
	    public void onRowCancel(RowEditEvent event) {
	    	MessageUtil.addMessage("MFI01101");
	    	
		    }
	 /* public void onCellEdit(CellEditEvent event) {
	   Object oldValue = event.getOldValue();
	   Object newValue = event.getNewValue();
	    if(newValue != null && !newValue.equals(oldValue)) {
	    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	    FacesContext.getCurrentInstance().addMessage(null, msg);
	    	    }
	    
	    }*/
	// For RefCodeDetail
		public void refCodeDetail() throws ServiceException
		{
			try {
				this.refcodelist = refcodedetailService.getrefCodeDetail(refcode.getRefMasterCode());
			}
			catch (ServiceException e) {
				LoggerUtil.ibsJobError("Unexpected error while getting detail of Ref code: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
			}
			catch (Exception e) {
				LoggerUtil.ibsJobError("Unexpected error while initializing MaintenanceController: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
			}
		}
		

		// For RefCodeDetail Add
				public String refCodeDetailAdd() throws ServiceException
				{
					try {
					refcodedetailService.insertRefCode(refcode);
					return "success";
					}
					catch (Exception e) {
						LoggerUtil.ibsJobError("Unexpected error while initializing MaintenanceController: MFI10001", e);
						MessageUtil.addMessage("MFI10001");
					}
						return null;
					}
					//return null;
				}
				


