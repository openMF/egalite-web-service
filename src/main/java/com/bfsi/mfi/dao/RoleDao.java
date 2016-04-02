package com.bfsi.mfi.dao;

/**
 * User DAO
 * 
 * @author Jyoti Ranjan
 * 
 * @param <Role>
 */

import java.util.List;

import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.exception.ServiceException;

public interface RoleDao extends MaintenanceDao<Role> {
	
	/**
	 * Adding entitlements to role
	 * 
	 * @param role
	 * @return
	 */
	public void addRoleEntitlements(Role role);

	/**
	 * Deleting entitlements from role.
	 * 
	 * @param role
	 * @return
	 */
	public void deleteRoleEntitlements(Role role);

	/**
	 * Get auto generated role id.
	 * 
	 * @param roleId
	 * @return
	 */
	String getAutoRoleId();

	/**
	 * Get modify roles to user.
	 * 
	 * @param userId
	 * @return
	 */
	public List<Role> getModifyAllocatedRoles(String userId);

	/**
	 * Checks if given role name is available or not
	 * 
	 * @param roleName
	 * @return
	 */
	public boolean isRoleNameAvailable(String roleName);

	/**
	 * Count if given role name.
	 * 
	 * @param roleName
	 * @return int
	 */
	public int countRoleNameAvailable(String rname);

	/**
	 * Get only list of authorized roles.
	 */
	public List<Role> getAuthorizedRoles();
	
	String deleteRole(String id) throws ServiceException;
	//For Modify RoleStatus
		boolean isRoleStatustoInactive(String roleId);
		
   public List<Role> getAuthorizedRolesForMbs();
   public List<Role> getModifyAllocatedRolesForMbs(String userId);

   
}
