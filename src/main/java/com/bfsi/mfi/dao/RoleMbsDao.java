package com.bfsi.mfi.dao;

/**
 * User DAO
 * 
 * @author Jyoti Ranjan
 * 
 * @param <RoleMbs>
 */

import java.util.List;

import com.bfsi.mfi.entity.RoleMbs;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.RoleMbsVO;

public interface RoleMbsDao extends MaintenanceDao<RoleMbs> {
	
	/**
	 * Adding entitlements to role
	 * 
	 * @param role
	 * @return
	 */
	public void addRoleEntitlements(RoleMbs role);

	/**
	 * Deleting entitlements from role.
	 * 
	 * @param role
	 * @return
	 */
	public void deleteRoleEntitlements(RoleMbs role);

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
	public List<RoleMbs> getModifyAllocatedRoles(String userId);

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
	public List<RoleMbs> getAuthorizedRoles();
	
	String deleteRole(String id) throws ServiceException;
	//For Modify RoleStatus
		boolean isRoleStatustoInactive(String roleId);
		
   public List<RoleMbs> getAuthorizedRolesForMbs();
   
   public List<RoleMbs> getModifyAllocatedRolesForMbs(String userId);
   
   public String addEntitlements(String roleId, String funcId) throws ServiceException;
   
   public String addRoleMBS(RoleMbsVO role) throws ServiceException;

   public String modifyRoleEntitlements(String id,List<String> list) throws ServiceException;
}
