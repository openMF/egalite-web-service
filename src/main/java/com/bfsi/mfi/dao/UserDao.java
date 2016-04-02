package com.bfsi.mfi.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.exception.ServiceException;

/**
 * User DAO
 * 
 * @author arun
 * 
 * @param <User>
 */

public interface UserDao extends MaintenanceDao<User> {
	/**
	 * Fetch entitlements for the given user. Entitlements here refer to the
	 * commands specified for the individual functions assigned through roles
	 * 
	 * @param user
	 * @return
	 */
	List<String> getEntitlements(User user);

	/**
	 * Checks if given user id is available or not
	 * 
	 * @param userId
	 * @return
	 */
	boolean isUserIdAvailable(String userId);

	/**
	 * Checks if given user id is available or not
	 * 
	 * @param id
	 * 
	 * @param userId
	 * @return
	 */
	boolean isPasswordValid(String id, String password);

	/**
	 * Insert to AMTB_USER_ROLES table.
	 */
	public void addRolesToUser(User user);

	/**
	 * Delete to AMTB_USER_ROLES table.
	 */
	public void deleteRolesToUser(User user);

	/**
	 * Checks if given user id is valid or not
	 * 
	 * @param userId
	 * @return
	 */
	public void updateInvalidLoginAttempt(String id);

	/**
	 * Delete the user.
	 */

	public String deleteUser(String id);

	public List<User> getCreditOfficers();

	void updateLastLoggedIn(String userName, Date currentTime)
			throws DataAccessException;

	public void resetPassword(String id, String pswd)
			throws DataAccessException;

	public String unLockUser(String id) throws ServiceException;

	/**
	 * Lock user record in the database by changing the status to Locked if
	 * number of failed login count matches maxFailedLoginCount
	 * 
	 * @param id
	 * @param maxFailedLoginCount
	 * @throws DataAccessException
	 */
	Integer lockUser(String id, int maxFailedLoginCount) throws DataAccessException;
	
	Integer noOfFailedLogins(String id);

	boolean isRoleAuthorized(String id);
		
	void updateAuditTrail(String id, String loggedInUser);
	
	boolean isUserLogined(String id);
	
	boolean logoutUser(String id);
	
	void userSessionExpired(String id);
	
	boolean isUserAuthorized(String id);
	
	int isUserLoggedIn(String id);
	
	String getAppDateToday();
	String getSystemMode();
	
	boolean isRoleActive(String id);
	public void deleteUserLoginHistory();
	public void updateUserLogin(String p_userId);
	
	public User forValidFirstTimeLogin(String id);
	boolean isCbsCoCodeAvailable(String cbsCoCode);
	
	public void firstTimetPaswdReset(String id, String pswd)
			throws DataAccessException;
	
	public List<CbsCodes> getUserCbsCode();
	
	void changePassword(String id, String pswd);

}
