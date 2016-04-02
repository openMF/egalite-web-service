package com.bfsi.mfi.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.security.core.userdetails.UserDetails;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.Cash;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.service.CashSettlementService;
import com.bfsi.mfi.service.CashTxnCodeService;
import com.bfsi.mfi.service.CurrencyService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.TillIdService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CashSettlementVO;
import com.bfsi.mfi.vo.CashTxnCodeVO;
import com.bfsi.mfi.vo.CurrencyVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.TillVO;

@ManagedBean(name = "cashSettlementController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addCashSettlement"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authCashSettlement"),
		@Permission(type = PermissionType.DELETE, name = "deleteCashSettlement"),
		@Permission(type = PermissionType.LIST, name = "listCashSettlements"),
		@Permission(type = PermissionType.MODIFY, name = "modifyCashSettlement") })
public class CashSettlementController extends MaintenanceController<CashSettlementVO, Cash> 
{
	@ManagedProperty(value = "#{cashSettlementService}")
	private CashSettlementService cashSettlementService;
	@ManagedProperty(value = "#{agentService}")
	private AgentService agentService;
	@ManagedProperty(value = "#{currencyService}")
	private CurrencyService currencyService;
	@ManagedProperty(value = "#{cashTxnCodeService}")
	private CashTxnCodeService cashTxnCodeService;
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	@ManagedProperty(value = "#{tillIdService}")
	private TillIdService tillIdService;
	
	private List<AgentVO> agentIds;
	private List<CurrencyVO> currencyCodes;
	private List<ListValueVO> txnTypes;
	//private List<ListValueVO> cashInOuts;
	private List<CashTxnCodeVO> cashTxnCode;
	
	private List<ListValueVO> cashStatuss;
	private List<ListValueVO> authStatuss;
	private UserDetails userDetails;
	
	private String autoTillId;
	private String isStatusActive;
	private String isAuthorise;
	
	public String getIsAuthorise() {
		return isAuthorise;
	}

	public void setIsAuthorise(String isAuthorise) {
		this.isAuthorise = isAuthorise;
	}

	public String getIsStatusActive() {
		return isStatusActive;
	}

	public void setIsStatusActive(String isStatusActive) {
		this.isStatusActive = isStatusActive;
	}

	private CashSettlementVO existing = new CashSettlementVO();
	private static final String SUCCESS = "success", FAILURE = "failure";
	
	
	@PostConstruct
	public void init() {
		try 
		{
			agentIds = agentService.getAuthorized();
			//tillIds = tillIdService.getTillIds();
			autoTillId =tillIdService.getAutoTillId();
			cashSettlement.setTillId(autoTillId);
			currencyCodes = currencyService.get();
			cashStatuss = listservice.get("cashStatus");
			ListOfValuesUtil.addLocaleDescription(cashStatuss);
			authStatuss = listservice.get("authStatus");
			ListOfValuesUtil.addLocaleDescription(authStatuss);

			txnTypes = listservice.get("txnType");
			ListOfValuesUtil.addLocaleDescription(txnTypes);
			
			cashTxnCode = cashTxnCodeService.getCashTxnCode();

		//	cashInOuts = listservice.get("cashInOut");
		//	ListOfValuesUtil.addLocaleDescription(cashInOuts);

		} 
		catch (ServiceException e) 
		{
			LoggerUtil.ibsJobError("ServiceException while initializing CashSettlementController: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while initializing CashSettlementController: MFI10001",e);
			MessageUtil.addMessage("MFI10001");
		}
		
	}

	public TillIdService getTillIdService() {
		return tillIdService;
	}

	public void setTillIdService(TillIdService tillIdService) {
		this.tillIdService = tillIdService;
	}

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;
	private static String result;

	private static final String OUTCOME_SUCCESS = "success";
	private List<TillVO> tillIds;

	public List<TillVO> getTillIds() {
		return tillIds;
	}

	public void setTillIds(List<TillVO> tillIds) {
		this.tillIds = tillIds;
	}

	
	public List<ListValueVO> getCashStatuss() {
		return cashStatuss;
	}

	public void setCashStatuss(List<ListValueVO> cashStatuss) {
		this.cashStatuss = cashStatuss;
	}

	private List<CashSettlementVO> cashSettlementlist;

	private CashSettlementVO cashSettlement = new CashSettlementVO();
	private TillVO till = new TillVO();

	public TillVO getTill() {
		return till;
	}

	public void setTill(TillVO till) {
		this.till = till;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public List<ListValueVO> getTxnTypes() {
		/*for (ListValueVO lvo : txnTypes) {
			if (lvo.getDesn().equals("Sync")) {
				txnTypes.remove(lvo);
			}
		}*/
		return txnTypes;
	}

	public void setTxnTypes(List<ListValueVO> txnTypes) {

		this.txnTypes = txnTypes;
	}

	/*public List<ListValueVO> getCashInOuts() {
		return cashInOuts;
	}

	public void setCashInOuts(List<ListValueVO> cashInOuts) {
		this.cashInOuts = cashInOuts;
	}*/

	public boolean isAuthorize() {
		return !("A".equals(cashSettlement.getAuthStatus()));
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	public List<CurrencyVO> getCurrencyCodes() {
		return currencyCodes;
	}

	public void setCurrencyCodes(List<CurrencyVO> currencyCodes) {
		this.currencyCodes = currencyCodes;
	}
	
	public CashTxnCodeService getCashTxnCodeService() {
		return cashTxnCodeService;
	}

	public void setCashTxnCodeService(CashTxnCodeService cashTxnCodeService) {
		this.cashTxnCodeService = cashTxnCodeService;
	}

	public List<CashTxnCodeVO> getCashTxnCode() {
		return cashTxnCode;
	}

	public void setCashTxnCode(List<CashTxnCodeVO> cashTxnCode) {
		this.cashTxnCode = cashTxnCode;
	}

	public static boolean isNumeric(String str) {
		try {
			Integer I = Integer.parseInt(str);

		} catch (NumberFormatException nfe) {
			LoggerUtil.ibsJobError(
					"NumberFormatException while validating: MFI10001", nfe);
			return false;
		}
		return true;
	}

	public void updateRemarks() {

		String str = cashSettlement.getTxnRemarks();
		boolean boo = isNumeric(str);
		if (boo) {
			/*
			 * FacesContext.getCurrentInstance().addMessage( null, new
			 * FacesMessage(FacesMessage.SEVERITY_ERROR, msg
			 * .getString("cashMgmt.message.remarks"), null));
			 */
			MessageUtil.addMessage("MFI00506");

		}
	}

	public String updateSystemPosition() {
		// validate input details

		Date date = new Date();
		AgentVO agentVo = null;

		if (cashSettlement.getAgentId() == null
				|| ("".equals(cashSettlement.getAgentId())))

		{

			LoggerUtil.ibsJobDebug("Please Select AgentId: MFI00500");
			MessageUtil.addMessage("MFI00500");
			return "failure";
		} else {
			try {
				agentVo = cashSettlementService
						.getAgentForValidation(cashSettlement.getAgentId());
				if ((date.compareTo(agentVo.getStartDate()) < 0)
						| !(agentVo.getIsActive().equalsIgnoreCase("A"))) {
					LoggerUtil
							.ibsJobDebug("Transaction Not Allowed for this AgentId: MFI00501");
					MessageUtil.addMessage("MFI00501");
					return "failure";
				} else if (agentVo.getEndDate() != null
						&& (date.compareTo(agentVo.getEndDate()) > 0)) {
					if (cashSettlement.getTxnCode() == null) {

						try {

							LoggerUtil
									.ibsJobDebug("Agent is closed,Only Cash In is allowed: MFI00502");
							MessageUtil.addMessage("MFI00502");

						} catch (ServiceException e) {
							LoggerUtil
									.ibsJobError(
											"ServiceException while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");
						} catch (Exception e) {

							LoggerUtil
									.ibsJobError(
											"Unhandled exception while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");

						}
						return "failure";
					} else if (cashSettlement.getTxnCode()
							.equalsIgnoreCase("2")) {
						try {

							LoggerUtil
									.ibsJobDebug("Agent is closed,Only Cash In is allowed: MFI00502");
							MessageUtil.addMessage("MFI00502");

						} catch (ServiceException e) {
							LoggerUtil
									.ibsJobError(
											"ServiceException while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");
						} catch (Exception e) {
							LoggerUtil
									.ibsJobError(
											"Unhandled exception while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");

						}
						return "failure";
					}

					else {
						try {

							return "success";

						} catch (ServiceException e) {
							LoggerUtil
									.ibsJobError(
											"ServiceException while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");
						} catch (Exception e) {
							LoggerUtil
									.ibsJobError(
											"Unhandled exception while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");

							return "failure";
						}

					}

				} else {
					if (cashSettlement.getTxnCode() == null
							| cashSettlement.getAgentId() == null
							| cashSettlement.getCurrencyCode() == null
							| cashSettlement.getCashTxnTypeText() == null
							| cashSettlement.getTxnRemarks() == null
							| cashSettlement.getCashAmount() == null) {
						try {
							return "failure";
						} catch (ServiceException e) {
							LoggerUtil
									.ibsJobError(
											"ServiceException while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");
						} catch (Exception e) {

							LoggerUtil
									.ibsJobError(
											"Unhandled exception while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");

						}
						return "failure";
					}

					else {
						try {

							return "success";

						} catch (ServiceException e) {
							LoggerUtil
									.ibsJobError(
											"ServiceException while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");
						} catch (Exception e) {

							LoggerUtil
									.ibsJobError(
											"Unhandled exception while initializing CashSettlementController: MFI10001",
											e);
							MessageUtil.addMessage("MFI10001");
						}

					}

				}
				return "success";
			} catch (ServiceException e) {
				LoggerUtil
						.ibsJobError(
								"ServiceException while initializing CashSettlementController: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			} catch (Exception e) {

				LoggerUtil
						.ibsJobError(
								"Unhandled exception while initializing CashSettlementController: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			}

			return "success";

		}
	}

	@SuppressWarnings("unused")
	private int getDecimal(String curencyCode) {

		try {
			return currencyService.getDecimal(curencyCode);
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while initializing CashSettlementController: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			return 0;
		} catch (Exception e) {

			LoggerUtil
					.ibsJobError(
							"Unhandled exception while getting decimal point  baseed on currency: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			return 0;
		}
	}

	/*
	 * @Override public String create() {
	 * 
	 * if (updateSystemPosition().equalsIgnoreCase("success") &&
	 * getValidateAmtDecimal() == true) { return super.create(); } else { return
	 * null; } }
	 */

	/*
	 * private boolean getValidateAmtDecimal() { int countDecimal =
	 * getDecimal(this.cashSettlement.getCurrencyCode()); Double inputAmt =
	 * this.cashSettlement.getAmount(); // validation comes here int
	 * countInputAmountDeci = countInputAmountDeci(inputAmt); Double
	 * valueDecimal = getValueDecimal(inputAmt); if (inputAmt > 0) { if
	 * (countInputAmountDeci == 0) return true; else if (countInputAmountDeci <=
	 * countDecimal) return true; else if (countDecimal == 0 && valueDecimal ==
	 * 0) return true; else {
	 * 
	 * MessageUtil.addMessage("MFI00503"); return false; } } else {
	 * 
	 * MessageUtil.addMessage("MFI00504"); return false; }
	 * 
	 * }
	 * 
	 * public int countInputAmountDeci(Double inputAmt) { BigDecimal amt =
	 * BigDecimal.valueOf(inputAmt); String amtstr = amt.toPlainString(); int
	 * pos = amtstr.indexOf('.'); if (pos < 0) {
	 * 
	 * } return amtstr.substring(pos + 1).length(); }
	 */
	public Double getValueDecimal(Double inputAmt) {
		BigDecimal amt = BigDecimal.valueOf(inputAmt);
		String amtstr = amt.toPlainString();
		int pos = amtstr.indexOf('.');
		if (pos < 0) {

		}
		String Test = amtstr.substring(pos + 1);
		Double d = Double.parseDouble(Test);
		return d;
	}

	public List<AgentVO> getAgentIds() {
		return agentIds;
	}

	public void setAgentIds(List<AgentVO> agentIds) {
		this.agentIds = agentIds;
	}

	
	public List<ListValueVO> getAuthStatuss() {
		return authStatuss;
	}

	public void setAuthStatuss(List<ListValueVO> authStatuss) {
		/*
		 * userDetails = authController.getUserDetails(); Date date = new
		 * Date(); cashSettlement.setVerifyByUserId(userDetails.getUsername());
		 * cashSettlement.setTxnAuthDatetime(new Timestamp(date.getTime()));
		 */

		this.authStatuss = authStatuss;

	}

	public CashSettlementService getCashSettlementService() {
		return cashSettlementService;
	}

	public List<CashSettlementVO> getCashSettlementlist() {
		return cashSettlementlist;
	}

	public void setCashSettlementlist(List<CashSettlementVO> cashSettlementlist) {
		this.cashSettlementlist = cashSettlementlist;
	}

	public void setCashSettlementService(
			CashSettlementService cashSettlementService) {
		this.cashSettlementService = cashSettlementService;
	}

	public CashSettlementVO getCashSettlement() {
		return cashSettlement;
	}

	public void setCashSettlement(CashSettlementVO cashSettlement) {
		this.cashSettlement = cashSettlement;
	}

	public void loadCashSettlement() {
		try {
			this.cashSettlement = cashSettlementService.get(cashSettlement
					.getId());
			
			isStatusActive= listservice.getValue(cashSettlement.getIsActive(),ListValue.LIST_NAME_AGENT_STATUS);
			isAuthorise = listservice.getValue(cashSettlement.getAuthStatus(),ListValue.LIST_NAME_AUTH_STATUS);
			
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while initializing CashSettlementController: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {

			LoggerUtil
					.ibsJobError(
							"Unhandled exception while initializing CashSettlementController: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");

		}
		loadAndShowAuditTrail(cashSettlement);
		existing = (CashSettlementVO) cashSettlement.clone();

	}

	@Override
	public CashSettlementVO getMaintenanceVO() {
		userDetails = authController.getUserDetails();
		Date date = new Date();

		cashSettlement.setInitByUserId(userDetails.getUsername());//
		cashSettlement.setTxnInitDatetime(new Timestamp(date.getTime()));
		return cashSettlement;
	}

	@Override
	protected CashSettlementService getMaintenanceService() {
		return cashSettlementService;
	}

	@Override
	public String getIdForMessage() {
		return "";

	}

	@Override
	public void authorize(ActionEvent event) {

		userDetails = authController.getUserDetails();
		Date date = new Date();
		CashSettlementVO vo = getMaintenanceVO();
		vo.setVerifyByUserId(userDetails.getUsername());
		vo.setTxnAuthDatetime(new Timestamp(date.getTime()));
		super.authorize(event);

	}

	// For delete Operation with Authorize check
	/*public String deleteUnAuthorized() {
		try {
			cashSettlementService.deleteCashSettlement(cashSettlement.getId());
			LoggerUtil
					.ibsJobDebug("CashSettlement  Record deleted successfully.: MFI00505");
			MessageUtil.addMessage("MFI00505", getMaintenanceVO().getId());

			return OUTCOME_SUCCESS;
		} catch (ServiceException e) {

			LoggerUtil
					.ibsJobError(
							"ServiceException while deleting Unauthorized record: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001", getMaintenanceVO().getId());
			return null;
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while deleting Unauthorized record: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			return null;
		}
		// return result;
	}*/

	/**
	 * Allow modification only when any value is changed
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public String checkModifyForUpdate() throws ServiceException {

		if (cashSettlement.getTillId().equals(existing.getTillId())
				&& cashSettlement.getAgentId().equals(existing.getAgentId())
				&& cashSettlement.getCashTxnTypeText().equals(
						existing.getCashTxnTypeText())
				&& cashSettlement.getTxnCode().equals(existing.getTxnCode())
				&& cashSettlement.getCurrencyCode().equals(
						existing.getCurrencyCode())
				&& cashSettlement.getCashAmount().equals(
						existing.getCashAmount())
				&& cashSettlement.getTxnRemarks().equals(
						existing.getTxnRemarks())
				&& cashSettlement.getIsActive().equals(existing.getIsActive())
		// &&
		// cashSettlement.getAuthStatusText().equals(existing.getAuthStatusText())
		// &&
		// cashSettlement.getInitByUserId().equals(existing.getInitByUserId())
		// &&
		// cashSettlement.getVerifyByUserId().equals(existing.getVerifyByUserId())
		// &&
		// cashSettlement.getTxnInitDatetime().equals(existing.getTxnInitDatetime())
		// &&
		// cashSettlement.getTxnAuthDatetime().equals(existing.getTxnAuthDatetime())
		) {

			LoggerUtil.ibsJobDebug("No field Modified: MFI01203");
			MessageUtil.addMessage("MFI01203");
			return null;
		} else if (cashSettlementService.isRecordAuthorised(cashSettlement
				.getTillId())) {
			LoggerUtil.ibsJobDebug("No field Modified: MFI00507");
			MessageUtil.addMessage("MFI00507");
		} else {
			super.update();
			result = "success";
		}
		return result;
	}
	
	public String agendaUpdate()
	{
		String response;
		try{
			response=cashSettlementService.agendaAmtEntry(cashSettlement);
			if(response == OUTCOME_SUCCESS)
			{
				return OUTCOME_SUCCESS;
			}
		}
		finally{
			LoggerUtil.ibsJobDebug("agendaUpdate Completed");
		}
		return response;
	}

	public String createCashSettlement()
	{
		UserDetails userDetails = getUserDetails();
		String loggedInUser = userDetails.getUsername();
		cashSettlement.setInitByUserId(loggedInUser);
		return super.create();
	}
	
	public String cashAuthorize()
	{
		LoggerUtil.ibsJobDebug("Validation in UnAuthorized() method");
		try {
			UserDetails userDetails = getUserDetails();
			String loggedInUser = userDetails.getUsername();
			Date date = new Date();
			
			cashSettlement.setVerifyByUserId(loggedInUser);
			cashSettlement.setTxnAuthDatetime(date);
			cashSettlement.setAuthStatus("A");
			String response = cashSettlementService.addRecordtoCustomer(cashSettlement.getTillId());
			if(response.equalsIgnoreCase(SUCCESS))
			{
				super.authorize();
			}
			else
			{
				MessageUtil.addMessage("MFI10001");
			}
			
		} 
		catch (ServiceException e) {
	        LoggerUtil.ibsJobError("ServiceException while UnAuthorized : MFI10001", e);
	        MessageUtil.addMessage("MFI10001");
	        result = FAILURE;
		}
		catch (Exception e) {
	        LoggerUtil.ibsJobError("Unhandled exception while UnAuthorized: MFI10001", e);
	        MessageUtil.addMessage("MFI10001");
	        result = FAILURE;
		}
		return result;
	}
}
