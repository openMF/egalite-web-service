package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.RoleMbs;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.RoleMbsVO;

/**
 * @author Jyoti Ranjan
 * 
 */

public interface RoleMbsService extends MaintenanceService<RoleMbsVO, RoleMbs> {

	/**
	 *  Update Entitlements to the Role.
	 * 
	 */
	RoleMbsVO updateEntitlements(RoleMbsVO rolembs, RoleMbsVO newrole) throws ServiceException;
	
	String addEntitlements(String roleId,String newrole) throws ServiceException;
	
	String addRoleMBS(RoleMbsVO rolembs) throws ServiceException;
	
	/**
	 *  Get the generated Id for role.
	 * 
	 */
	String getAutoRoleId() throws ServiceException;

	/**
	 *  Modify  allocated roles .
	 * 
	 */
	List<RoleMbsVO> getModifyAllocatedRoles(String userId) throws ServiceException;

	
	/**
	 * Checks if given role name is already available or not
	 * 
	 * @param roleName
	 * @return true if no roleName exists with given role Name, false otherwise
	 */
	boolean isRoleNameAvailable(String roleName) throws ServiceException;

	/**
	 * Count if given role name is how many time  available.
	 * 
	 * @param roleName
	 * @return number of count  with given roleName.
	 */
	int countRoleNameAvailable(String rname) throws ServiceException;

	/**
	 * Get list of roles which are authorized only.
	 */
	List<RoleMbsVO> getAuthorizedRoles() throws ServiceException;
	
	String deleteRole(String id) throws ServiceException;
	//For Modify RoleStatus
	boolean isRoleStatustoInactive(String roleId) throws ServiceException;
	
	List<RoleMbsVO> getAuthorizedRolesForMbs() throws ServiceException;
	List<RoleMbsVO> getModifyAllocatedRolesForMbs(String userId) throws ServiceException;
	String modifyRoleEntitlements(String id, List<String> list) throws ServiceException;

}
