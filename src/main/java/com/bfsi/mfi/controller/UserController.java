package com.bfsi.mfi.controller;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.UserDetails;

import com.bfsi.mfi.annotation.Permission;
import com.bfsi.mfi.annotation.PermissionCollection;
import com.bfsi.mfi.annotation.PermissionType;
import com.bfsi.mfi.auth.UserAuthenticationSuccessHandler;
import com.bfsi.mfi.dao.AuditTrailDao;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.BranchService;
import com.bfsi.mfi.service.CbsCodesService;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.service.RoleService;
import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.util.ListOfValuesUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.BranchVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.ListValueVO;
import com.bfsi.mfi.vo.RoleVO;
import com.bfsi.mfi.vo.UserVO;

@ManagedBean(name = "userController")
@ViewScoped
@PermissionCollection({
		@Permission(type = PermissionType.ADD, name = "addUser"),
		@Permission(type = PermissionType.MODIFY, name = "modifyUser"),
		@Permission(type = PermissionType.DELETE, name = "deleteUser"),
		@Permission(type = PermissionType.AUTHORIZE, name = "authUser"),
		@Permission(type = PermissionType.LIST, name = "listUsers"),
		@Permission(type = PermissionType.LIST, name = "clearsession") })
public class UserController extends MaintenanceController<UserVO, User>
		implements Serializable, ActionListener {

	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	private static final long serialVersionUID = -8144614324632010903L;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	@ManagedProperty(value = "#{listValueService}")
	private ListValueService listservice;
	
	@ManagedProperty(value = "#{branchService}")
	private BranchService branchService;
	
	@ManagedProperty(value = "#{roleService}")
	private RoleService roleService;
	
	@ManagedProperty(value = "#{cbsCodesService}")
	private CbsCodesService cbsCodesService;
	
	boolean isCoRequired = true;
	private UserVO user = new UserVO();
	private UserVO modify = new UserVO();

	private List<ListValueVO> userTypes;
	private List<ListValueVO> genders;
	private List<ListValueVO> userStatus;
	private List<BranchVO> branchCodes;
	private List<CbsCodesVO> cbsCodes;
	private List<CbsCodesVO> cbsBrnCodes;
	private List<RoleVO> availableRoles;

	private List<RoleVO> selectedAvailableRoles = new ArrayList<RoleVO>();
	private List<RoleVO> filteredRoles = new ArrayList<RoleVO>();//

	private List<RoleVO> selectedAllocatedRoles = new ArrayList<RoleVO>();
	private List<RoleVO> modifyAvailableRoles = new ArrayList<RoleVO>();
	private List<RoleVO> modifySelectedAvailableRoles = new ArrayList<RoleVO>();
	private List<RoleVO> modifyFilteredRoles = new ArrayList<RoleVO>();
	private List<RoleVO> oldModifyAllocatedRoles = new ArrayList<RoleVO>();
	private List<RoleVO> modifySelectedAllocatedRoles = new ArrayList<RoleVO>();

	private static boolean response = false;
	private static boolean username;
	//private static boolean cbsCoCode = false;
	private static String result = null, loggedInUser;
	private static String passwordMatch = null;
	private String userType;

	private AuditTrailDao<User> auditTrailDao;
	private static final String SUCCESS = "success", FAILURE = "failure", ADMIN = "SU";

	@ManagedProperty(value = "#{msg}")
	private ResourceBundle msg;

	@PostConstruct
	public void init() {
		userTypes = listservice.get(ListValue.LIST_NAME_USER_TYPE);
		ListOfValuesUtil.addLocaleDescription(userTypes);

		genders = listservice.get(ListValue.LIST_NAME_GENDER);
		ListOfValuesUtil.addLocaleDescription(genders);

		userStatus = listservice.get(ListValue.LIST_NAME_AGENT_STATUS);
		ListOfValuesUtil.addLocaleDescription(userStatus);

		try {
			//branchCodes = branchService.getBranchCode();
			cbsBrnCodes = branchService.getUserCbsBranchCode();
			availableRoles = roleService.getAuthorizedRoles(); // change get																// list of roles
			//cbsCodes = cbsCodesService.get();
			
			cbsCodes = userService.getUserCbsCode();
			loadAvailableRoles(user.getAllocatedRoles());
			filteredRoles.clear();
			filteredRoles.addAll(availableRoles);
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while Loading init(Post) Method: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while Loading init(Post) Method: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	public void loadUser() {
		if (user.getId() == null) {
			try {
				this.user = userService.get(userIdToLoad);
				modify = (UserVO) user.clone();
				loadAndShowAuditTrail(user);
				user.setAllocatedRoles(roleService.getModifyAllocatedRoles(user
						.getId()));
				oldModifyAllocatedRoles = roleService
						.getModifyAllocatedRoles(user.getId());

				loadModifiedAvailableRoles(user.getAllocatedRoles());
				modifyFilteredRoles.clear();
				modifyFilteredRoles.addAll(modifyAvailableRoles);
				if(user.getCbsCoCode()!= null && user.getCbsCoCode().trim().length()>0)
				{
					for(CbsCodesVO cbsVo: cbsCodes)
					{
						if(cbsVo!= null && user.getCbsCoCode().equals(cbsVo.getDlValue()))
						{
							isCoRequired = false;
						} else {
							isCoRequired = true;
						}
						}
					if(isCoRequired){
						CbsCodesVO cbsCodeVo= new CbsCodesVO();
						//cbsCodeVo.setDlValue(user.getCbsCoCode()); //comment to avoid dublicate
						//cbsCodes.add(cbsCodeVo);
					}
					}
				
				// set the current co code
			
				LoggerUtil.ibsJobDebug("User page loaded successfully ......");
			} catch (ServiceException e) {
				LoggerUtil
						.ibsJobError(
								"ServiceException while Loading loadUser Method: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			} catch (Exception e) {
				LoggerUtil
						.ibsJobError(
								"Unhandled exception while Loading loadUser Method: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			}
		}

		userType = listservice.getValue(user.getUserType(),
				ListValue.LIST_NAME_USER_TYPE);
		isStatusActive = listservice.getValue(user.getUserStatus(),
				ListValue.LIST_NAME_AGENT_STATUS);
	}

	public void logedInloadUser() {
		if (user.getId() == null) {
			try {
				// EGALITE-163 start
				UserDetails userDetails = getUserDetails();
				userIdToLoad = userDetails.getUsername();
				// EGALITE-163 End
				this.user = userService.get(userIdToLoad);
				modify = (UserVO) user.clone();
				loadAndShowAuditTrail(user);
				user.setAllocatedRoles(roleService.getModifyAllocatedRoles(user
						.getId()));
				oldModifyAllocatedRoles = roleService
						.getModifyAllocatedRoles(user.getId());

				loadModifiedAvailableRoles(user.getAllocatedRoles());
				modifyFilteredRoles.clear();
				modifyFilteredRoles.addAll(modifyAvailableRoles);
				LoggerUtil.ibsJobDebug("User page loaded successfully ......");
			} catch (ServiceException e) {
				LoggerUtil
						.ibsJobError(
								"ServiceException while Loading loadUser Method: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			} catch (Exception e) {
				LoggerUtil
						.ibsJobError(
								"Unhandled exception while Loading loadUser Method: MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
			}
		}

		userType = listservice.getValue(user.getUserType(),
				ListValue.LIST_NAME_USER_TYPE);
		isStatusActive = listservice.getValue(user.getUserStatus(),
				ListValue.LIST_NAME_AGENT_STATUS);
	}

	public void loadChangePswd() {
		try {
			UserDetails userDetails = getUserDetails();
			loggedInUser = userDetails.getUsername();
			this.user = userService.get(loggedInUser);
			LoggerUtil
					.ibsJobDebug("Password Change page loaded successfully ......");
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while loading loadChangePswd: MFI10001",
					e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while loading loadChangePswd: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}

	}

	public void loadUserForReset() {
		try {
			this.user = userService.get(userIdToLoad);
			LoggerUtil.ibsJobDebug("User Reset loaded successfully ......");
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while Loading loadUserForReset Method: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while Loading loadUserForReset Method: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	public String resetPassword() {
		try {
			if ((user.getPassword()).equals(user.getcPassword())) {

				userService.resetPassword(user.getId(), user.getPassword());
				UserDetails userDetails = getUserDetails();
				loggedInUser = userDetails.getUsername();
				userService.updateAuditTrail(user.getId(), loggedInUser);
				LoggerUtil.ibsJobDebug("User Reset successfully ......"
						+ user.getId());
				MessageUtil.addMessage("MFI00718", user.getId());
				result = SUCCESS;
			} else {
				MessageUtil.addMessage("MFI00719");
				return null;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while resetPassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while resetPassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	/**
	 * Validates user Id as user types it. Checks for presence of special
	 * characters and availability of user id
	 * 
	 * @throws ServiceException
	 */
	public boolean validateUserId() throws ServiceException {
		// String userId = user.getId();
		try {
			String userId = user.getId();
			if (!(userId.length() >= 3 && userId.length() <= 10)) {
				LoggerUtil
						.ibsJobError("UserId length should be minimum 3 and maximum 10 : MFI00720");
				MessageUtil.addMessage("MFI00720");
				response = false;
			}
			// check availability of user id
			else if (!userService.isUserIdAvailable(userId)) {
				LoggerUtil.ibsJobError("User Id already exists : MFI00721");
				MessageUtil.addMessage("MFI00721");
				response = false;
			} else {
				LoggerUtil.ibsJobDebug("User Id validated Successfully");
				response = true;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while validateUserId: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while validateUserId: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		}
		return response;
	}


	public void test() throws ServiceException {
			String userId = user.getUserType();
			System.out.println("=======================================" + userId);
	}
	
	public boolean validateDob() throws ServiceException {
		try {
			Date myDate = user.getDob();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dob_date = dateFormat.format(myDate);

			Date date = new Date();
			String curr_date = dateFormat.format(date);

			Date d_date = dateFormat.parse(dob_date);
			Date c_date = dateFormat.parse(curr_date);

			if (d_date.after(c_date)) {
				LoggerUtil
						.ibsJobError("Date of birth should be at least equal to current date : MFI00703");
				MessageUtil.addMessage("MFI00703");
				response = false;
			} else {
				LoggerUtil
						.ibsJobDebug("Date of birth validated Successfully .....");
				response = true;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while validateDob: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while validateDob: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		}
		return response;
	}

	public String create() {
		try {
			passwordMatch = matchWithConfirmPassword();
			username = validateUserId();
			//cbsCoCode = validateCbscoCode();
			UserDetails userDetails = getUserDetails();
			loggedInUser = userDetails.getUsername();
			if ((username) && loggedInUser.equals(ADMIN)
					&& passwordMatch.equalsIgnoreCase("SUCCESS")) {
				super.create();
				LoggerUtil.ibsJobDebug("User Created Successfully .....");
				result = SUCCESS;
			} else if ((username) && (!loggedInUser.equals(ADMIN))
					&& passwordMatch.equalsIgnoreCase("SUCCESS")) {
				super.create();
				LoggerUtil.ibsJobDebug("User Created Successfully .....");
				result = SUCCESS;
			}
			else {
				result = FAILURE;
				return null;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while create user : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while create user: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	/*
	 * public void showDialog() { //System.out.println("success"); RequestContext
	 * context = RequestContext.getCurrentInstance();
	 * context.execute("registrationSuccess.show()"); }
	 */

	public void loadModifiedAvailableRoles(List<RoleVO> modifyAllocatedRoles) {
		modifyAvailableRoles.clear();
		for (RoleVO v : availableRoles) {
			modifyAvailableRoles.add(v);
		}

		for (int i = 0; i < modifyAvailableRoles.size();) {
			RoleVO v = modifyAvailableRoles.get(i);
			boolean roleFound = false;
			for (RoleVO allocatedVo : modifyAllocatedRoles) {
				if (allocatedVo.equals(v)) {
					modifyAvailableRoles.remove(i);
					modifyFilteredRoles.remove(allocatedVo);
					roleFound = true;
					break;
				}
			}

			if (!roleFound) {
				i++;
			}
		}
	}

	// filter and selected value hold
	public void loadAvailableRoles(List<RoleVO> mallocatedRoles) {
		for (int i = 0; i < availableRoles.size();) {
			RoleVO v = availableRoles.get(i);
			boolean roleFound = false;
			for (RoleVO allocatedVo : mallocatedRoles) {
				if (allocatedVo.equals(v)) {
					availableRoles.remove(i);
					filteredRoles.remove(allocatedVo);
					roleFound = true;
					break;
				}
			}

			if (!roleFound) {
				i++;
			}
		}
	}

	/*
	 * public boolean isAuthorize() { return
	 * !("A".equals(user.getAuthStatus())); }
	 */

	/**
	 * Validates password contains password policy or not
	 * 
	 * @throws ServiceException
	 * @throws NoSuchAlgorithmException
	 * 
	 */
	public boolean validatePassword() throws ServiceException {
		String password = user.getPassword();
		String id = user.getId();
		// check Password for change password
		try {
			response = userService.validatePassword(id, password);
			if (!(response)) {
				LoggerUtil.ibsJobError("Invalid existing password : MFI00722");
				MessageUtil.addMessage("MFI00722");
			} else {
				LoggerUtil.ibsJobDebug("Validation success for Password");
				response = true;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while validatePassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while validatePassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		}
		return response;
	}

	public String changePassword() {
		try {
			response = validatePassword();

			if (!(user.getNewPassword()).equals(user.getcPassword())) {

				LoggerUtil
						.ibsJobError("New password and confirm password do not match : MFI00723");
				MessageUtil.addMessage("MFI00723");
				result = null;
			} else if ((user.getPassword()).equals(user.getNewPassword())) {

				LoggerUtil
						.ibsJobError("Existing password and new password should not be the same : MFI00724");
				MessageUtil.addMessage("MFI00724");
				result = null;
			} else if (response) {
				userService.changePassword(user.getId(), user.getNewPassword());
				/*
				 * MessageUtil.addInfoMessage(user.getId() +
				 * "msg.success.pswdchange");
				 */
				LoggerUtil.ibsJobDebug("Password Changed Successfully ....");
				MessageUtil.addMessage("MFI00725", user.getId());
				result = SUCCESS;
			} else {
				result = null;
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while changePassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while changePassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	public String deleteUnAuthorized() throws ServiceException {
		try {
			result = userService.deleteUser(user.getId());
			LoggerUtil.ibsJobDebug("User Deleted Successfully: MFI10001");
			MessageUtil.addMessage("MFI10011", getMaintenanceVO().getId());
			return result = SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while deleteUnAuthorized: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;

		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while deleteUnAuthorized: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	/**
	 * Validates user Id as user types it. Checks for presence of special
	 * characters and availability of user id
	 * 
	 * @throws ServiceException
	 */
	/*
	 * public void validateEmail() { String emailId = user.getEmailId(); if
	 * (emailId .matches(
	 * "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
	 * )) { } else { FacesContext.getCurrentInstance().addMessage( null, new
	 * FacesMessage(FacesMessage.SEVERITY_ERROR, msg
	 * .getString("userMgmt.msg.emailId"), null)); } }
	 */

	public String checkModifyForUpdate() throws ServiceException {

		Date sdate = user.getStartDate();
		Date sdate1 = modify.getStartDate();
		Date edate = user.getEndDate();
		Date edate1 = modify.getEndDate();		
		boolean isCoCodeModify = false;
		if(user.getUserType().equals("1") && user.getCbsCoCode().equals(modify.getCbsCoCode())){
			isCoCodeModify = true;			
		} else if(user.getUserType().equals("2") && user.getCbsCoCode()==null){
			isCoCodeModify = true;			
		} else if(user.getUserType().equals("2") && user.getCbsCoCode() != null && user.getCbsCoCode().equals(modify.getCbsCoCode())){
			isCoCodeModify = true;		
		}
		
		validateUser();
		boolean alloctedLists = oldModifyAllocatedRoles.size() == user
				.getAllocatedRoles().size()
				&& oldModifyAllocatedRoles
						.containsAll(user.getAllocatedRoles());
		int roleLeng = user.getAllocatedRoles().size();

		if (roleLeng <= 0) {
			MessageUtil.addMessage("MFI00729");
			result = null;
			return result;
		}
	

		else if ((user.getFirstName()).equals(modify.getFirstName())
				&& (user.getLastName()).equals(modify.getLastName())
				&& user.getBranchCode().equals(modify.getBranchCode())
				&& user.getUserStatus().equals(modify.getUserStatus())
				&& user.getUserType().equals(modify.getUserType())
				&& dateValidation(sdate).equals(dateValidation(sdate1))
				&& isCoCodeModify				
				&& alloctedLists
				) {  

			if (modify.getEndDate() == null && user.getEndDate() == null) {
				LoggerUtil.ibsJobDebug("No Fields Modified : MFI01203");
				MessageUtil.addMessage("MFI01203");
				return null;
			} else {

				if (modify.getEndDate() != null && user.getEndDate() != null) {
					if (dateValidation(edate).equals(dateValidation(edate1))) {
						LoggerUtil.ibsJobDebug("No Fields Modified : MFI01203");
						MessageUtil.addMessage("MFI01203");
						//result = FAILURE;
						result = null;
						return result;
					} else if (edate.before(sdate)) {
						LoggerUtil
								.ibsJobDebug("No Past End Date Allowed : MFI00734");
						MessageUtil.addMessage("MFI00734");
						result = null;
						return result;
					} else {
						//cbsCoCode = validateCbscoCode();		
						
						super.update();
						LoggerUtil.ibsJobDebug("User Updated Successfully"
								+ user.getId());
						result = SUCCESS;
						
					}

				} else {
					
					super.update();
					LoggerUtil.ibsJobDebug("User Updated Successfully"
							+ user.getId());
					result = SUCCESS;
					
				}
			}
		} else {	 /* EGA-MN15-000001 point :1 start */
			  System.out.println("iiiiii--------------else part-------------");
			  System.out.println("---last Namne----"+user.getLastName()+"-------"+modify.getLastName());
			if(  (user.getCbsCoCode().equalsIgnoreCase(modify.getCbsCoCode()))
					&&  ((user.getFirstName())!=(modify.getFirstName()))
					&& (((user.getLastName())!=(modify.getLastName())))
					&& ((user.getBranchCode())!=(modify.getBranchCode()))
					&& ((user.getUserStatus())!=(modify.getUserStatus()))
					&& ((user.getUserType())!=(modify.getUserType()))
					){ 
				System.out.println("----befor ----super update-----");
				super.update();
				LoggerUtil.ibsJobDebug("User Updated Successfully" + user.getId());
				result = SUCCESS;	
			}else if(validateCbscoCode()){
				super.update();
				LoggerUtil.ibsJobDebug("User Updated Successfully" + user.getId());
				result = SUCCESS;
			}else{
				return null;
			}  /* EGA-MN15-000001 point :1 End */
		}
		return result;
	}

	public static String dateValidation(Date value) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return s.format(value);
	}

	public String userAuthorize() 
	{
		String result;
		try{
			super.authorize();
			user.setAuthStatus("A");
			result = SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError("ServiceException while validatePassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil.ibsJobError("Unhandled exception while validatePassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	public void validateUser() {
		if (modify.getFirstName() == null || modify.getFirstName().equals(" ")) {
			modify.setFirstName("");
		}
		if (modify.getLastName() == null || modify.getLastName().equals(" ")) {
			modify.setLastName("");
		}
		if (modify.getBranchCode() == null
				|| modify.getBranchCode().equals(" ")) {
			modify.setBranchCode("");
		}
		if (modify.getGender() == null || modify.getGender().equals(" ")) {
			modify.setGender("");
		}
		if (modify.getUserStatus() == null
				|| modify.getUserStatus().equals(" ")) {
			modify.setUserStatus("");
		}
		if (modify.getUserType() == null || modify.getUserType().equals(" ")) {
			modify.setUserType("");
		}
		if (modify.getCommAddr1() == null || modify.getCommAddr1().equals(" ")) {
			modify.setCommAddr1("");
		}
		if (modify.getCommAddr2() == null || modify.getCommAddr2().equals(" ")) {
			modify.setCommAddr2("");
		}
		if (modify.getCommAddr3() == null || modify.getCommAddr3().equals(" ")) {
			modify.setCommAddr3("");
		}
		if (modify.getCommAddr4() == null || modify.getCommAddr4().equals(" ")) {
			modify.setCommAddr4("");
		}
		if (modify.getPermAddr1() == null || modify.getPermAddr1().equals(" ")) {
			modify.setPermAddr1("");
		}
		if (modify.getPermAddr2() == null || modify.getPermAddr2().equals(" ")) {
			modify.setPermAddr2("");
		}
		if (modify.getPermAddr3() == null || modify.getPermAddr3().equals(" ")) {
			modify.setPermAddr3("");
		}
		if (modify.getPermAddr4() == null || modify.getPermAddr4().equals(" ")) {
			modify.setPermAddr4("");
		}
		if (modify.getMobile() == null || modify.getMobile().equals(" ")) {
			modify.setMobile("");
		}
		if (modify.getEmailId() == null || modify.getEmailId().equals(" ")) {
			modify.setEmailId("");
		}
	}

	public UserVO getModify() {
		return modify;
	}

	public void setModify(UserVO modify) {
		this.modify = modify;
	}

	public void setMsg(ResourceBundle msg) {
		this.msg = msg;
	}

	public BranchService getBranchService() {
		return branchService;
	}

	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}

	public List<ListValueVO> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<ListValueVO> userTypes) {
		this.userTypes = userTypes;
	}

	public List<ListValueVO> getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(List<ListValueVO> userStatus) {
		this.userStatus = userStatus;
	}

	public List<BranchVO> getBranchCodes() {
		return branchCodes;
	}

	public void setBranchCodes(List<BranchVO> branchCodes) {
		this.branchCodes = branchCodes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ListValueService getListservice() {
		return listservice;
	}

	public void setListservice(ListValueService listservice) {
		this.listservice = listservice;
	}

	public List<ListValueVO> getGenders() {
		return genders;
	}

	public void setGenders(List<ListValueVO> genders) {
		this.genders = genders;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public List<RoleVO> getAvailableRoles() {
		return availableRoles;
	}

	public void setAvailableRoles(List<RoleVO> availableRoles) {
		this.availableRoles = availableRoles;
	}

	public List<RoleVO> getSelectedAvailableRoles() {
		return selectedAvailableRoles;
	}

	public void setSelectedAvailableRoles(List<RoleVO> selectedAvailableRoles) {
		this.selectedAvailableRoles = selectedAvailableRoles;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public List<RoleVO> getSelectedAllocatedRoles() {
		return selectedAllocatedRoles;
	}

	public void setSelectedAllocatedRoles(List<RoleVO> selectedAllocatedRoles) {
		this.selectedAllocatedRoles = selectedAllocatedRoles;
	}

	public List<RoleVO> getModifyAvailableRoles() {
		return modifyAvailableRoles;
	}

	public void setModifyAvailableRoles(List<RoleVO> modifyAvailableRoles) {
		this.modifyAvailableRoles = modifyAvailableRoles;
	}

	public List<RoleVO> getModifySelectedAvailableRoles() {
		return modifySelectedAvailableRoles;
	}

	public void setModifySelectedAvailableRoles(
			List<RoleVO> modifySelectedAvailableRoles) {
		this.modifySelectedAvailableRoles = modifySelectedAvailableRoles;
	}

	public List<RoleVO> getModifySelectedAllocatedRoles() {
		return modifySelectedAllocatedRoles;
	}

	public void setModifySelectedAllocatedRoles(
			List<RoleVO> modifySelectedAllocatedRoles) {
		this.modifySelectedAllocatedRoles = modifySelectedAllocatedRoles;
	}

	@Override
	public UserVO getMaintenanceVO() {
		return user;
	}

	@Override
	protected UserService getMaintenanceService() {
		return userService;
	}

	public void moveToDest() {
		for (RoleVO r : selectedAvailableRoles) {
			user.getAllocatedRoles().add(r);
			availableRoles.remove(r);
			filteredRoles.remove(r);
		}
		selectedAvailableRoles.clear();
	}

	public ActionListener getMoveToDest() {
		return this;
	}

	public void moveToSource() {
		for (RoleVO a : selectedAllocatedRoles) {
			availableRoles.add(a);
			filteredRoles.add(a);
			user.getAllocatedRoles().remove(a);
		}
		selectedAllocatedRoles.clear();
	}

	public ActionListener getMoveToSource() {
		return this;
	}

	// For modify user screen Roles Navigation.
	public void moveToModifyDest() {
		for (RoleVO r : modifySelectedAvailableRoles) {
			modifyAvailableRoles.remove(r);
			modifyFilteredRoles.remove(r);
			user.getAllocatedRoles().add(r);
		}
		modifySelectedAvailableRoles.clear();
	}

	public ActionListener getMoveToModifyDest() {
		return this;
	}

	public void moveToModifySource() {
		for (RoleVO a : modifySelectedAllocatedRoles) {
			modifyAvailableRoles.add(a);
			modifyFilteredRoles.add(a);
			user.getAllocatedRoles().remove(a);
		}
		modifySelectedAllocatedRoles.clear();
	}

	public ActionListener getMoveToModifySource() {
		return this;
	}

	@Override
	public void processAction(ActionEvent event)
			throws AbortProcessingException {
	}

	public void setUserIdToLoad(String userIdToLoad) {
		this.userIdToLoad = userIdToLoad;
	}

	public String getUserIdToLoad() {
		return userIdToLoad;
	}

	@Override
	public boolean isModifyAllowed() {
		UserDetails userDetails = getUserDetails();
		loggedInUser = userDetails.getUsername();

		if ((user.getId()).equals(ADMIN)) {
			LoggerUtil.ibsJobDebug("Modification allowed");
			return false;
		} else if ((user.getId()).equalsIgnoreCase(loggedInUser)) { //
			LoggerUtil.ibsJobDebug("Modification not allowed");
			return true;
		} else {
			LoggerUtil.ibsJobDebug("Modification not allowed");
			return false;
		}
	}

	/**
	 * 
	 * @return true if currently viewed user is locked, else false
	 */
	public boolean isUnlockAllowed() {
		UserDetails userDetails = getUserDetails();
		loggedInUser = userDetails.getUsername();

		if (user.getUserStatus().equals(UserService.USER_STATUS_LOCKED)) {
			if (user.getId().equalsIgnoreCase(loggedInUser)) {
				LoggerUtil.ibsJobDebug("Unlock not allowed");
				response = true;
			} else {
				LoggerUtil.ibsJobDebug("unlock allowed");
				response = false;
			}
		} else {
			LoggerUtil.ibsJobDebug("Unlock not allowed");
			response = true;
		}
		return response;
	}

	public boolean isResetAllowed() throws ServiceException {

		UserDetails userDetails = getUserDetails();
		loggedInUser = userDetails.getUsername();
		int userLogged = userService.isUserLoggedIn(user.getId());

		if (user.getId().equalsIgnoreCase(loggedInUser)) {
			LoggerUtil.ibsJobDebug("Reset  allowed");
			response = true;
		}
		if (!(userLogged == 0)) {
			LoggerUtil.ibsJobDebug("Reset allowed");
			response = true;
		} else {
			LoggerUtil.ibsJobDebug("Reset not allowed");
			response = false;
		}
		return response;
	}

	public String unLockUser() {
		try {
			result = userService.unLockUser(user.getId());

			LoggerUtil.ibsJobDebug("Record Unlocked Successfully : MFI00726"
					+ user.getId());
			MessageUtil.addMessage("MFI00726", user.getId());
			user.setUserStatus(UserService.USER_STATUS_ACTIVE);
			result = SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while unLockUser : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while unLockUser: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	// Handles the user logout
	public void logoutUser() throws IOException {
		try {
			UserDetails userDetails = getUserDetails();
			loggedInUser = userDetails.getUsername();
			userService.logoutUser(loggedInUser);
			LoggerUtil.ibsJobDebug("User Logged out Successfully = "
					+ user.getId());

			ExternalContext ec = FacesContext.getCurrentInstance()
					.getExternalContext();
			ec.invalidateSession();
			ec.redirect(ec.getRequestContextPath() + "/login.xhtml");

		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while logoutUser : MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while logoutUser: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		// return result;
	}

	public boolean clearSession() {
		UserDetails userDetails = getUserDetails();
		loggedInUser = userDetails.getUsername();
		try {
			int count = userService.isUserLoggedIn(user.getId());
			if (count == 0) {
				LoggerUtil.ibsJobDebug("Clear Session not allowed");
				response = true;
			} else {
				if (loggedInUser.equalsIgnoreCase(user.getId())) {
					LoggerUtil.ibsJobDebug("Clear Session not allowed");
					response = true;
				} else {
					LoggerUtil.ibsJobDebug("Clear Session allowed");
					response = false;
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return response;
	}

	public String isSessionCleared() {

		String result;
		try {
			response = userService.logoutUser(user.getId());
			LoggerUtil.ibsJobError("User Session cleared : MFI00727");
			MessageUtil.addMessage("MFI00727");
			user.setUserStatus(UserService.USER_STATUS_ACTIVE);
			/*
			 * Bud Id: EGALITE-93 Vishal Start
			 */
			if (UserAuthenticationSuccessHandler.userTrackor != null) {
				if (UserAuthenticationSuccessHandler.userTrackor
						.containsKey(user.getId())) {
					Map<String, HttpSession> userSessionMap = UserAuthenticationSuccessHandler.userTrackor
							.get(user.getId());
					java.util.Iterator<Entry<String, HttpSession>> valueentries = userSessionMap
							.entrySet().iterator();
					while (valueentries != null && valueentries.hasNext()) {
						Entry childEntry = (Entry) valueentries.next();
						String sessionId = (String) childEntry.getKey();
						HttpSession userSession = (HttpSession) childEntry
								.getValue();
						if (userSession != null) {
							userSession.invalidate();
						}
					}
				}
			}

			/*
			 * Bud Id: EGALITE-93 Vishal End
			 */
			result = SUCCESS;
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while Loading isSessionCleared: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while Loading isSessionCleared: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	public List<RoleVO> getModifyFilteredRoles() {
		return modifyFilteredRoles;
	}

	public void setModifyFilteredRoles(List<RoleVO> modifyFilteredRoles) {
		this.modifyFilteredRoles = modifyFilteredRoles;
	}

	public List<RoleVO> getFilteredRoles() {
		return filteredRoles;
	}

	public void setFilteredRoles(List<RoleVO> filteredRoles) {
		this.filteredRoles = filteredRoles;
	}

	public AuditTrailDao<User> getAuditTrailDao() {
		return auditTrailDao;
	}

	public void setAuditTrailDao(AuditTrailDao<User> auditTrailDao) {
		this.auditTrailDao = auditTrailDao;
	}

	public String matchWithConfirmPassword() {
		try {
			if ((user.getPassword()).equals(user.getcPassword())) {
				result = SUCCESS;
			} else {
				result = FAILURE;
				MessageUtil.addMessage("MFI00719");
				return null;
			}
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while matching password with confirm password : MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while  matching password with confirm password : MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			result = FAILURE;
		}
		return result;
	}

	public String validPass() {
		String pass = user.getPassword();
		String cpass = user.getcPassword();
		String uid = user.getId();
		if (pass.equalsIgnoreCase(cpass)) {
			result = SUCCESS;
		} else {
			// MessageUtil.addMessage("MFI00731");
			result = FAILURE;
		}
		user.setId(uid);
		return result;
	}

	public String userCreate() {
		if (validateUserId() && validateCbscoCode()   ) {  //EGA-MN15-000001 point :1 start--> added..  validateCbscoCode()()
			try {
				int roleLeng = user.getAllocatedRoles().size();
				String passValid = validPass();

				if (passValid == SUCCESS) {
					if (roleLeng <= 0) {
						MessageUtil.addMessage("MFI00729");
						// bugId : EGALITE-148 start
						result = null;
						// bugId : EGALITE-148 end
					} else {
						int userType = Integer.parseInt(user.getUserType());
						if(userType == 2)
						{
							user.setCbsCoCode(null);
						}
						super.create();
						result = SUCCESS;
					}
				} else {
					//result = FAILURE;
					result = null;
				}
			} catch (ServiceException e) {
				LoggerUtil
						.ibsJobError(
								"ServiceException while matching password with confirm password : MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
				//result = FAILURE;
				result = null;
				
			} catch (Exception e) {
				LoggerUtil
						.ibsJobError(
								"Unhandled exception while  matching password with confirm password : MFI10001",
								e);
				MessageUtil.addMessage("MFI10001");
				//result = FAILURE;
				result = null;
			}
		}
		return result;
	}

	public void firstloginUserpaswdchanged() {
		LoggerUtil
				.ibsJobDebug("Force firstloginUserpaswdchanged Change page loaded successfully ......");
		try {
			if ((user.getPassword()).equals(user.getcPassword())) {
				userService.firstTimetPaswdReset(userIdToLoad,
						user.getPassword());
				userService.updateAuditTrail(user.getId(), userIdToLoad);
				LoggerUtil.ibsJobDebug("User Reseted successfully ......"
						+ userIdToLoad);
				MessageUtil.addMessage("MFI00718", userIdToLoad);
				ExternalContext ec = FacesContext.getCurrentInstance()
						.getExternalContext();
				ec.invalidateSession();
				ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
				MessageUtil.addMessage("MFI00718", userIdToLoad);
			} else {
				MessageUtil.addMessage("MFI00719");
			}
		} catch (ServiceException e) {
			LoggerUtil.ibsJobError(
					"ServiceException while resetPassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		} catch (Exception e) {
			LoggerUtil.ibsJobError(
					"Unhandled exception while resetPassword: MFI10001", e);
			MessageUtil.addMessage("MFI10001");
		}
	}

	
	
	/* EGA-MN15-000001 point :1 start */
	public boolean validateCbscoCode() throws ServiceException {
		// String userId = user.getId();
		try {
			String cbsCoCode = user.getCbsCoCode();
			// check availability of user id
			if (!userService.isCbsCoCodeAvailable(cbsCoCode)) {
				LoggerUtil
						.ibsJobError("Cbs Credit Officer Code already exists : MFI40002");
				MessageUtil.addMessage("MFI40002");
				response = false;
				
			} else {
				LoggerUtil
						.ibsJobDebug("Cbs Credit Officer Code validated Successfully");
				response = true;
			}
		} catch (ServiceException e) {
			LoggerUtil
					.ibsJobError(
							"ServiceException while validating Cbs Credit Officer Code: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		} catch (Exception e) {
			LoggerUtil
					.ibsJobError(
							"Unhandled exception while validating Cbs Credit Officer Code: MFI10001",
							e);
			MessageUtil.addMessage("MFI10001");
			response = false;
		}
		return response;
	}
	/* EGA-MN15-000001 point :1 End */
	
	
	public List<CbsCodesVO> getCbsBrnCodes() {
		return cbsBrnCodes;
	}

	public void setCbsBrnCodes(List<CbsCodesVO> cbsBrnCodes) {
		this.cbsBrnCodes = cbsBrnCodes;
	}
	// Handles the Session logout Tag no : EGA-MN15-000023 
			public void logoutUserSession() throws IOException {
				try {
					UserDetails userDetails = getUserDetails();
					loggedInUser = userDetails.getUsername();
					if ( loggedInUser == null){
						userService.logoutUser(loggedInUser);
						LoggerUtil.ibsJobDebug("User Logged out Successfully = "
								+ user.getId());
					ExternalContext ec = FacesContext.getCurrentInstance()
							.getExternalContext();
					ec.invalidateSession();
					ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
					System.out.println("Session Expire Message Info");
					}else {
						userService.logoutUser(loggedInUser);
						LoggerUtil.ibsJobDebug("User Logged out Successfully = "
								+ user.getId());
						ExternalContext ec = FacesContext.getCurrentInstance()
								.getExternalContext();
						ec.invalidateSession();
						ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
					}

				} catch (ServiceException e) {
					LoggerUtil.ibsJobError(
							"ServiceException while logoutUserSession : MFI10001", e);
					MessageUtil.addMessage("MFI10001");
					result = FAILURE;
				} catch (Exception e) {
					LoggerUtil.ibsJobError(
							"Unhandled exception while logoutUserSession: MFI10001", e);
					MessageUtil.addMessage("MFI10001");
					result = FAILURE;
				}
				// return result;
			}


			public CbsCodesService getCbsCodesService() {
				return cbsCodesService;
			}

			public void setCbsCodesService(CbsCodesService cbsCodesService) {
				this.cbsCodesService = cbsCodesService;
			}

			public List<CbsCodesVO> getCbsCodes() {
				return cbsCodes;
			}

			public void setCbsCodes(List<CbsCodesVO> cbsCodes) {
				this.cbsCodes = cbsCodes;
			}

			private String userIdToLoad = null;
			private String isStatusActive;

			public String getIsStatusActive() {
				return isStatusActive;
			}

			public void setIsStatusActive(String isStatusActive) {
				this.isStatusActive = isStatusActive;
			}

			public String getUserType() {
				return userType;
			}

			public void setUserType(String userType) {
				this.userType = userType;
			}

			
			
}
