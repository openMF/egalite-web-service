package com.bfsi.mfi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.ExternalDevice;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ExternalDeviceService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.ExternalDeviceVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.UserVO;

@ManagedBean(name = "externalDeviceController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addExternalDevice"),
		@Permission(type = PermissionType.MODIFY, name = "modifyExternalDevice"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authExternalDevice"),
		@Permission(type = PermissionType.LIST, name = "listExternalDevices"),
		@Permission(type = PermissionType.DELETE, name = "deleteExternalDevice") })
public class ExternalDeviceController extends MaintenanceController<ExternalDeviceVO, ExternalDevice> {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	@ManagedProperty(value = "#{externalDeviceService}")
	private ExternalDeviceService externalDeviceService;
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;
	private static boolean response ;
	private static final String OUTCOME_SUCCESS = "success";
    private String isStatusActive;
    private List<UserVO> creditOfficers;
    
    @ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	
	private ExternalDeviceVO device = new ExternalDeviceVO();
	private List<ListValueVO> deviceTypes;
	private List<ListValueVO> deviceStatuss;
	private List<ListValueVO> authStatuss;
	private String autoDeviceId;
	private UploadedFile file;
	
	private ExternalDeviceVO existing = new ExternalDeviceVO();

	@PostConstruct
	public void init() {

		deviceTypes = listservice.get("deviceType");
		ListOfValuesUtil.addLocaleDescription(deviceTypes);

		deviceStatuss = listservice.get("deviceStatus");
		ListOfValuesUtil.addLocaleDescription(deviceStatuss);

		autoDeviceId = externalDeviceService.getAutoDeviceId();
		device.setId(autoDeviceId); //set to superid

		authStatuss = listservice.get("authStatus");
		ListOfValuesUtil.addLocaleDescription(authStatuss);
		
		creditOfficers = userService.getCreditOfficers();
		System.out.println("======================="+creditOfficers.size());
	}

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 * @throws ServiceException 
	 */
	public String checkModifyForUpdate() throws ServiceException {

		device.setMacId(device.getMacId().trim());
		if (device.getId().equals(existing.getId())
				&& device.getManufacturer().equals(existing.getManufacturer())
				&& device.getMacId().equals(existing.getMacId())
				&& device.getIssuedDate().equals(existing.getIssuedDate())
				&& device.getIsActive().equals(existing.getIsActive())
				&& device.getIssuedByCo().equals(existing.getIssuedByCo())
				&& device.getModelNo().equals(existing.getModelNo())
				&& device.getLicenceFile().equals(existing.getLicenceFile())
				&& device.getLicenceFileName().equals(existing.getLicenceFileName())
				){

			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		}
		else if(!(device.getMacId().equals(existing.getMacId())))
		{
			boolean UniqId = validateUniqueId();
			if (UniqId) 
			{
				result = "success";
				super.update();
			}
			else {
				result = "";
			}
		}
		else {
			result = "success";
			super.update();
		}
		return result;
	}

	public void loadDevice() {
		ExternalDeviceVO deviceVO = new ExternalDeviceVO();
		deviceVO.setId(device.getId());
		try {
			this.device = externalDeviceService.get(device.getId());
			isStatusActive= listservice.getValue(device.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while loading ExternalDeviceService: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while loading ExternalDeviceService: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(device);
		existing = (ExternalDeviceVO) device.clone();

	}

	public List<ListValueVO> getDeviceStatuss() {
		return deviceStatuss;
	}

	public void setDeviceStatuss(List<ListValueVO> deviceStatuss) {
		this.deviceStatuss = deviceStatuss;
	}

	public List<ListValueVO> getDeviceTypes() {
		return deviceTypes;
	}

	public void setDeviceTypes(List<ListValueVO> deviceTypes) {
		this.deviceTypes = deviceTypes;
	}

	public ExternalDeviceService getExternalDeviceService() {
		return externalDeviceService;
	}

	public void setExternalDeviceService(ExternalDeviceService externalDeviceService) {
		this.externalDeviceService = externalDeviceService;
	}

	public ExternalDeviceVO getDevice() {
		return device;
	}

	public void setDevice(ExternalDeviceVO device) {
		this.device = device;
	}

	@Override
	public ExternalDeviceVO getMaintenanceVO() {
		return device;
	}

	@Override
	protected ExternalDeviceService getMaintenanceService() {
		return externalDeviceService;
	}

	public boolean validateUniqueId() throws ServiceException {
		String uniqueId = device.getMacId().trim();
		try {
			if (!externalDeviceService.isUniqueIdAvailable(uniqueId)) {
				LoggerUtil.ibsJobDebug("MAC Id already used: MFI40001");
				MessageUtil.addMessage("MFI40001");
				response = false;
			} else {
				response = true;
			}
		}

		catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while Checking userId: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		}
		return response;
	}

	// For ModifyUniqueId
	public String validateModifyUniqueId() throws ServiceException {
		String id = device.getId().trim();
		try {
			if (!externalDeviceService.isModifyUniqueIdAvailable(id)) {
				LoggerUtil.ibsJobDebug("MAC Id already used: MFI40001");
				MessageUtil.addMessage("MFI40001");  
				//result = "failure";
				result = null;
			} else {
				result = "success";
			}
		}

		catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while Checking userId: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}
		return result;
	}

	// For Validating Issued Date which will not allow future date.
	public boolean validateissuedDate() throws ServiceException {
		try {
			Date myDate = device.getIssuedDate();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dob_date = dateFormat.format(myDate);

			Date date = new Date();
			String curr_date = dateFormat.format(date);

			Date d_date = dateFormat.parse(dob_date);
			Date c_date = dateFormat.parse(curr_date);

			if (d_date.after(c_date)) {
				LoggerUtil.ibsJobDebug("No Future Issued Date Allowed: MFI00802");
				MessageUtil.addMessage("MFI00802");
				response = false;
			}
			else {
				response = true;
			}
			} catch (ServiceException e) {
	            LoggerUtil.ibsJobError("ServiceException while validating DOB: MFI10001", e);
	            MessageUtil.addMessage("MFI10001");
	            response = false;
		     }
		     catch (Exception e) {
		            LoggerUtil.ibsJobError("Unhandled exception while validating DOB: MFI10001", e);
		            MessageUtil.addMessage("MFI10001");
		            response = false;
		     }
		return response;
	}
	
	
	public String create(){
		//System.out.println("upload file++++++++" + this.file);
	     //System.out.println("upload file  get ++++++++" + this.getFile());
		boolean  r_resp;
		
		device.setMacId(device.getMacId().trim());
		try {
			 r_resp = validateUniqueId();
			boolean issuedDate = validateissuedDate();
			if ( r_resp && issuedDate) {
				super.create();
				result = "success";
			} /*else {
				result = "";
			}*/
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while creating External Device: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return result;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	// For Modification with unique ID
	public String callModify() {
		String id;
		try {

			id = validateModifyUniqueId();
			if (id.equals("success")) {
				result = checkModifyForUpdate();
			} else {
				result = "success";
			}

		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unexpected error while Modifing ExternalDevice: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
		return result;
	}

	// For Delete Operation

	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = externalDeviceService.deleteDevice(device.getId());

			LoggerUtil.ibsJobDebug("ExternalDevice Record deleted successfully: "
					+ getMaintenanceVO().getId());
			MessageUtil.addMessage("MFI10011", getMaintenanceVO().getId());
			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("Unhandled exception while deleting record: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}
		return result;
	}

	public List<ListValueVO> getAuthStatuss() {
		return authStatuss;	
	}

	public void setAuthStatuss(List<ListValueVO> authStatuss) {
		this.authStatuss = authStatuss;
	}
	
	
	
	public void upload(FileUploadEvent event) throws IOException {  
		 this.file = event.getFile();
		 device.setLicenceFile(file.getContents());
		 device.setLicenceFileName(file.getFileName());
		////System.out.println("upload file======"+device.getLicenceFile());
		
		FacesMessage message = new FacesMessage("Successfully", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
       // MessageUtil.addMessage("MFI10011", event.getFile().getFileName());
    }

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}  
	
	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}
	public String getIsStatusActive() {
		return isStatusActive;
	}

	public List<UserVO> getCreditOfficers() {
		return creditOfficers;
	}

	public void setCreditOfficers(List<UserVO> creditOfficers) {
		this.creditOfficers = creditOfficers;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}
	
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
	
}