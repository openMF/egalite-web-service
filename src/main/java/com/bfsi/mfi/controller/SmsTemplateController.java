package com.bfsi.mfi.controller;

import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.SmsTemplate;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.SmsTemplateService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.SmsConfigVO;
import com.bfsi.mfi.vo.SmsTemplateVO;

@ManagedBean(name = "smsTemplateController")
@ViewScoped
@PermissionCollection({
	@Permission(type = PermissionType.ADD, name = "addSMSTemplate"),
	@Permission(type = PermissionType.DELETE, name = "deleteSMSTemplate"),
	@Permission(type = PermissionType.LIST, name = "listSmsTemplate"),
	@Permission(type = PermissionType.MODIFY, name = "modifySMSTemplate") 
	})
public class SmsTemplateController extends
		MaintenanceController<SmsTemplateVO, SmsTemplate> {
	@ManagedProperty(value = "#{smsTemplateService}")
	private SmsTemplateService smsTemplateService;
	private SmsTemplateVO smstemplatevo = new SmsTemplateVO();
	private SmsTemplateVO existing = new SmsTemplateVO();

	private String option = "";
	private String inputar = "";
	private String dfld = "";
	private String autoTemplateId;
	
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	
	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;

	public ResourceBundle getMsg() {
		return msg;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public SmsTemplateVO getSmstemplatevo() {
		return smstemplatevo;
	}

	public void setSmstemplatevo(SmsTemplateVO smstemplatevo) {
		this.smstemplatevo = smstemplatevo;
	}

	public SmsTemplateService getSmsTemplateService() {
		return smsTemplateService;
	}

	public void setSmsTemplateService(SmsTemplateService smsTemplateService) {
		this.smsTemplateService = smsTemplateService;
	}

	@Override
	protected SmsTemplateService getMaintenanceService() {

		return smsTemplateService;
	}

	
	
	@PostConstruct
	public void init() {

		autoTemplateId = smsTemplateService.getAutoTemplateId();
		//smstemplatevo.setDeviceId(autoTemplateId);
		smstemplatevo.setId(autoTemplateId);
		smstemplatevo.setTxtSms(getInputar());
		smstemplatevo.setDynaFields(getDfld());
		
	}
	
	public void loadSmsTemplate() {
		SmsTemplateVO smsVO = new SmsTemplateVO();
	
		
		smsVO.setId(smstemplatevo.getId());
		try {
			this.smstemplatevo = smsTemplateService.get(smstemplatevo.getId());
			
			LoggerUtil.ibsJobDebug("SMS Config not Available: MFI00602");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading SMS Config: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil.ibsJobError(
					"Unhandled exception while loading  SMS Config: MFI10001",
					e);
			MessageUtil.addMessage("MFI10001");
		}
		loadAndShowAuditTrail(smstemplatevo);
		existing = (SmsTemplateVO) smstemplatevo.clone();
	

	}
	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public String checkModifyForUpdate() throws ServiceException {
		if (smstemplatevo.getId().equals(existing.getId())
				&& smstemplatevo.getTxtSms().equals(existing.getTxtSms())
				&& smstemplatevo.getDynaFields().equals(existing.getDynaFields())
				&& smstemplatevo.getDescription().equals(existing.getDescription())
				) {
			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		}

		else {
			super.update();
			result = "success";
		}
		return result;
	}
	
	

	@Override
	public SmsTemplateVO getMaintenanceVO() {

		return smstemplatevo;
	}


	
	public String create() {
		LoggerUtil.ibsJobDebug("creating new record for controller : "
				+ this.getClass().getName());
		
		    smstemplatevo.setTxtSms(getInputar());
		   smstemplatevo.setDynaFields(getDfld());
		try {
			 smsTemplateService.createInfo(smstemplatevo);
			MessageUtil.addMessage("MFI10008", getIdForMessage());
			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while creating record: controller: "
							+ this.getClass().getName() + " : MFI10014", e);
			MessageUtil.addMessage("MFI10014");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"unhandled exception while creating record: controller: "
							+ this.getClass().getName() + " : MFI10014", e);
			MessageUtil.addMessage("MFI10014");
		}
		return null;
	}
	
	
	
	

	
	public String getDfld() {
		return dfld=this.dfld+getOption();
	
		
	}

	public void setDfld(String dfld) {
		this.dfld = dfld;
	}
	
	
	
	public String getInputar() {
		
		return inputar = this.inputar + getOption();
	}

	public void setInputar(String inputar) {
		this.inputar = inputar;
	}
	

	// For delete Operation with Authorize check
		public String deleteUnAuthorized() throws ServiceException {
			try {
				result = smsTemplateService.deleteSmsTemplate(smstemplatevo.getId());
				LoggerUtil.ibsJobDebug("SmsConfig Record deleted successfully: "
						+ getMaintenanceVO().getId());
				MessageUtil.addMessage("MFI10011", getMaintenanceVO().getId());

				return OUTCOME_SUCCESS;
			} catch (ServiceException e) {
				LoggerUtil.ibsJobError(
						"Unhandled exception while deleting record: MFI10001", e);
				MessageUtil.addMessage("MFI10001");
			}
			return result;
		}
		

		public String dynafields(){
			String i=smstemplatevo.getDynaFields();
			String newDynaFields= i+ " "+getOption();
		    smstemplatevo.setDynaFields(newDynaFields);
			
		  return   newDynaFields;
		}
		public String textSmss()
		{
			String j =smstemplatevo.getTxtSms();
			String newTextSmss= j+ " "+getOption();
			smstemplatevo.setTxtSms(newTextSmss);
			 return   newTextSmss;
		}
}
