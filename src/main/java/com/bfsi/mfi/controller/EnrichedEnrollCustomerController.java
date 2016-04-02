package com.bfsi.mfi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.EnrichEnrollCustomerService;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.EnrollCustomerVO;

@ManagedBean(name = "enrichedEnrollCustomerController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addEnrollmentCustomer"),
		@Permission(type = PermissionType.MODIFY, name = "modifyEnrollmentCustomer"),
		@Permission(type = PermissionType.DELETE, name = "deleteEnrollmentCustomer"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authEnrollmentCustomer"),
		@Permission(type = PermissionType.LIST, name = "listEnrollmentCustomer") })
public class EnrichedEnrollCustomerController extends
		MaintenanceController<EnrollCustomerVO, EnrollCustomer> {

	@ManagedProperty(value = "#{enrichEnrollCustomerService}")
	private EnrichEnrollCustomerService enrichEnrollCustomerService;

	private static String result;
	private EnrollCustomerVO enrollCustomer = new EnrollCustomerVO();

	public EnrichEnrollCustomerService getEnrichEnrollCustomerService() {
		return enrichEnrollCustomerService;
	}

	public void setEnrichEnrollCustomerService(
			EnrichEnrollCustomerService enrichEnrollCustomerService) {
		this.enrichEnrollCustomerService = enrichEnrollCustomerService;
	}

	public static String getResult() {
		return result;
	}

	public static void setResult(String result) {
		EnrichedEnrollCustomerController.result = result;
	}

	public EnrollCustomerVO getEnrollCustomer() {
		return enrollCustomer;
	}

	public void setEnrollCustomer(EnrollCustomerVO enrollCustomer) {
		this.enrollCustomer = enrollCustomer;
	}

	@Override
	protected EnrichEnrollCustomerService getMaintenanceService() {
		return enrichEnrollCustomerService;
	}

	public void loadEnrollCustomer() {
		EnrollCustomerVO enrollCustomerVO = new EnrollCustomerVO();
		enrollCustomerVO.getId();
		try {
			this.enrollCustomer = enrichEnrollCustomerService
					.get(enrollCustomer.getId());
		} catch (ServiceException e) {
			MessageUtil.addInfoMessageWithoutKey("Error", e.getMessage());
		} catch (Exception e) {
			logger.error(
					"Unexpected error while initializing EnrollCustomerController"
							+ e.getMessage(), e);
			MessageUtil.addInfoMessageWithoutKey("Unexpected Error",
					e.getMessage());
		}
		loadAndShowAuditTrail(enrollCustomer); // this gives the audit info ..
												// i.e. the admin names in the
												// bottom of page
		// existing = (EnrollCustomerVO) enrollCustomer.clone();
	}

	public String modifyEnroll() throws ServiceException {
		// String[] enrollCustomerVals ={ enrollCustomer.getId(),
		// enrollCustomer.getLanguage(), enrollCustomer.getGender(),
		// enrollCustomer.getUserType()};

		// try {
		// enrichEnrollCustomerService.modifyEnrichVals(enrollCustomerVals);
		super.update();// For updating the Ref_stat in view table
		result = "success";
		// } catch (ServiceException e) {
		// result="success";
		// e.printStackTrace();

		// }
		return result;
	}

	public String deleteEnrolled() throws ServiceException {
		String enrollCustomerId = enrollCustomer.getId();

		try {
			enrichEnrollCustomerService.resetEnrichStat(enrollCustomerId); // reset before the data
			enrichEnrollCustomerService.deleteEnrichedEnroll(enrollCustomerId); // For update flag 
			result = "delete";
		} catch (ServiceException e) {
			result = "";
			e.printStackTrace();

		}
		return result;
	}

	@Override
	public EnrollCustomerVO getMaintenanceVO() {
		return enrollCustomer;
	}

}
