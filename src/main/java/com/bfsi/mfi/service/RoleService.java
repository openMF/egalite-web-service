package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.RoleVO;

/**
 * @author Jyoti Ranjan
 * 
 */

public interface RoleService extends MaintenanceService<RoleVO, Role> {

	/**
	 *  Update Entitlements to the Role.
	 * 
	 */
	RoleVO updateEntitlements(RoleVO role, RoleVO newrole) throws ServiceException;

	/**
	 *  Get the generated Id for role.
	 * 
	 */
	String getAutoRoleId() throws ServiceException;

	/**
	 *  Modify  allocated roles .
	 * 
	 */
	List<RoleVO> getModifyAllocatedRoles(String userId) throws ServiceException;

	
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
	List<RoleVO> getAuthorizedRoles() throws ServiceException;
	
	String deleteRole(String id) throws ServiceException;
	//For Modify RoleStatus
	boolean isRoleStatustoInactive(String roleId) throws ServiceException;
	
	List<RoleVO> getAuthorizedRolesForMbs() throws ServiceException;
	List<RoleVO> getModifyAllocatedRolesForMbs(String userId) throws ServiceException;
	
	

}
