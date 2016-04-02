package com.bfsi.mfi.controller;

import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.entity.SmsConfig;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.SmsConfigService;
import com.bfsi.mfi.service.SmsTemplateService;
import com.bfsi.mfi.service.TxnCodeService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.MfiMbsTxnReceiverVO;
import com.bfsi.mfi.vo.SmsConfigVO;
import com.bfsi.mfi.vo.SmsTemplateVO;

@ManagedBean(name = "smsConfigController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addSmsConfig"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authorizeSmsConfig"),
		@Permission(type = PermissionType.DELETE, name = "deleteSmsConfig"),
		@Permission(type = PermissionType.LIST, name = "listSmsConfig"),
		@Permission(type = PermissionType.MODIFY, name = "modifySmsConfig") })
public class SmsConfigController extends
		MaintenanceController<SmsConfigVO, SmsConfig> {
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	@ManagedProperty(value = "#{smsConfigService}")
	private SmsConfigService smsConfigService;

	@ManagedProperty(value = "#{txnCodeService}")
	private TxnCodeService txnCodeService;

	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;

	@ManagedProperty(value = "#{smsTemplateService}")
	private SmsTemplateService smsTemplateService;

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;

	private String isStatusActive;
	private static String result;
	private static final String OUTCOME_SUCCESS = "success";
	private SmsConfigVO smsconfig = new SmsConfigVO();
	private SmsConfigVO existing = new SmsConfigVO();
	private List<MfiMbsTxnReceiverVO> txnIds;
	private List<ListValueVO> smsConfigStatuss;

	@Override
	public String create() {
		if (validateTxnDesc().equalsIgnoreCase(OUTCOME_SUCCESS))
			return super.create();
		else
			return null;
	}

	@PostConstruct
	public void init() {
		try {
			smsConfigStatuss = listservice.get("isActive");
			ListOfValuesUtil.addLocaleDescription(smsConfigStatuss);
			txnIds = txnCodeService.get();
			templateIds = smsTemplateService.get();
			//System.out.println("Inside Init method");

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

	public void loadSmsConfig() {
		SmsConfigVO smsVO = new SmsConfigVO();
		smsVO.setId(smsconfig.getId());
		try {
			this.smsconfig = smsConfigService.get(smsconfig.getId());
			isStatusActive= listservice.getValue(smsconfig.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
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
		loadAndShowAuditTrail(smsconfig);
		existing = (SmsConfigVO) smsconfig.clone();

	}

	public String validateTxnDesc() {

		String txnCode = smsconfig.getId().trim();
		try {
			if (!smsConfigService.isTxnCodeAvailable(txnCode)) {
				MessageUtil.addMessage("MFI30002");
				result = "failure";
			} else {
				result = OUTCOME_SUCCESS;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while validating txnCode : " + txnCode
							+ ": MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while while validating roleName : "
							+ txnCode + ": MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = "failure";
		}
		return result;
	}

	// For delete Operation with Authorize check
	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = smsConfigService.deleteSmsConfig(smsconfig.getId());
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

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public String checkModifyForUpdate() throws ServiceException {
		if (smsconfig.getId().equals(existing.getId())
				&& smsconfig.getSendSmsFromMbs() == (existing
						.getSendSmsFromMbs())
				&& smsconfig.getSmsTemplateMbs().equals(
						existing.getSmsTemplateMbs())
				&& smsconfig.getSendSmsFromIbs() == (existing
						.getSendSmsFromIbs())
				&& smsconfig.getSmsTemplateIbs().equals(
						existing.getSmsTemplateIbs())
				&& smsconfig.getIsActive().equals(existing.getIsActive())) {//
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
	protected SmsConfigService getMaintenanceService() {
		// TODO Auto-generated method stub
		return smsConfigService;
	}

	@Override
	public SmsConfigVO getMaintenanceVO() {
		// TODO Auto-generated method stub
		return smsconfig;
	}

	public String displaySmsText() {

		//System.out.println(smsconfig.getSmsTemplateMbs());
		for (SmsTemplateVO smsvo : templateIds) {

			if (smsvo.getId().equals(smsconfig.getSmsTemplateMbs())) {
				return smsvo.getTxtSms();

			}
		}

		return "";

	}
	public String	displaySmsTextForIbs()
	{
		//System.out.println(smsconfig.getSmsTemplateIbs());
		for (SmsTemplateVO smsvo : templateIds) {

			if (smsvo.getId().equals(smsconfig.getSmsTemplateIbs())) {
				return smsvo.getTxtSms();

			}
		}

		return "";

	
	}
	public SmsTemplateService getSmsTemplateService() {
		return smsTemplateService;
	}

	public void setSmsTemplateService(SmsTemplateService smsTemplateService) {
		this.smsTemplateService = smsTemplateService;
	}

	public TxnCodeService getTxnCodeService() {
		return txnCodeService;
	}

	public void setTxnCodeService(TxnCodeService txnCodeService) {
		this.txnCodeService = txnCodeService;
	}
	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}
	private static boolean response = false;
	private List<SmsTemplateVO> templateIds;

	public List<SmsTemplateVO> getTemplateIds() {
		return templateIds;
	}

	public void setTemplateIds(List<SmsTemplateVO> templateIds) {
		this.templateIds = templateIds;
	}

	public SmsConfigService getSmsConfigService() {
		return smsConfigService;
	}

	public void setSmsConfigService(SmsConfigService smsConfigService) {
		this.smsConfigService = smsConfigService;
	}

	public List<MfiMbsTxnReceiverVO> getTxnIds() {
		return txnIds;
	}

	public void setTxnIds(List<MfiMbsTxnReceiverVO> txnIds) {
		this.txnIds = txnIds;
	}

	public SmsConfigVO getSmsconfig() {
		return smsconfig;
	}

	public void setSmsconfig(SmsConfigVO smsconfig) {
		this.smsconfig = smsconfig;
	}

	public List<ListValueVO> getSmsConfigStatuss() {
		return smsConfigStatuss;
	}

	public void setSmsConfigStatuss(List<ListValueVO> smsConfigStatuss) {
		this.smsConfigStatuss = smsConfigStatuss;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public boolean isAuthorize() {
		return !("A".equals(smsconfig.getAuthStatus()));
	}
	

	public ResourceBundle getMsg() {
		return msg;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}
}
