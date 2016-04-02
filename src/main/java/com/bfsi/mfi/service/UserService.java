package com.bfsi.mfi.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.UserVO;

/**
 * @author arun
 * 
 */
public interface UserService extends MaintenanceService<UserVO, User> {
	
	public static final String USER_STATUS_LOCKED = "L";
	public static final String USER_STATUS_ACTIVE = "A";
	public static final String USER_STATUS_INACTIVE = "I";

	/**
	 * Checks if given user id is already available or not
	 * 
	 * @param userId
	 * @return true if no user exists with given user id, false otherwise
	 */
	
	boolean isUserIdAvailable(String userId) throws ServiceException;

	/**
	 * Validate password based on system paramter
	 * 
	 * @param password
	 * @return
	 */

	List<UserVO> getCreditOfficers();

	String deleteUser(String id) throws ServiceException;

	void resetPassword(String id, String pswd) throws ServiceException;

	boolean validatePassword(String password, String id)
			throws ServiceException, NoSuchAlgorithmException;

	String unLockUser(String id) throws ServiceException;

	int noOfFailedLogins(String id) throws ServiceException;
	
	/**
	 * Update data store with required details on successful login of the given
	 * user. At present store current login time as part of the last login time
	 * 
	 * @param username
	 * @throws ServiceException
	 */
	
	void updateSuccessfulLogin(String username) throws ServiceException;

	boolean isRoleAuthorized(String id) throws ServiceException;
	
	void updateAuditTrail(String id, String loggedInUser) throws ServiceException;

	boolean isUserLogined(String id) throws ServiceException;
	
	boolean logoutUser(String id) throws ServiceException;
	
	void userSessionExpired() throws ServiceException;
	
	boolean isUserAuthorized(String id) throws ServiceException;
	
	boolean isRoleActive(String id)throws ServiceException;
	
	int isUserLoggedIn(String id) throws ServiceException;
	
	User forValidFirstTimeLogin(String id);
	boolean isCbsCoCodeAvailable(String cbsCoCode) throws ServiceException;
	public void firstTimetPaswdReset(String id, String pswd)
			throws DataAccessException;
	
	String getAppDateToday() throws ServiceException;
	String getSystemMode() throws ServiceException;
	List<CbsCodesVO> getUserCbsCode() throws ServiceException;
	
	void changePassword(String id, String pswd) throws ServiceException;

}
