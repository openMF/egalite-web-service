package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.RoleDao;
import com.bfsi.mfi.entity.Function;
import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.RoleService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.FunctionVO;
import com.bfsi.mfi.vo.RoleVO;

@Service(value = "roleService")
@Transactional(rollbackFor = { ServiceException.class })
public class RoleServiceImpl extends MaintenanceServiceImpl<RoleVO, Role>
		implements RoleService {
	
	private static final String SUPER_ADMIN_USER_NAME = "SU";
	
	@Autowired
	private RoleDao roleDao;

	@SuppressWarnings("unchecked")
	@Override
	protected RoleDao getMaintenanceDao() {
		return roleDao;
	}

	@Override
	protected Role getEntity(RoleVO vo) {
		// copy child functions to vos
		List<Function> functions = new ArrayList<Function>();
		if (vo.getFunctions() != null) {
			for (FunctionVO functionVO : vo.getFunctions()) {
				Function function = new Function();
				BeanUtils.copyProperties(functionVO, function);
				functions.add(function);
			}
		}
		vo.getEntity().setFunctions(functions);

		return vo.getEntity();
	}

	@Override
	protected RoleVO getValueObject(Role entity) {
		RoleVO roleVO = new RoleVO(entity);
		// BeanUtils.copyProperties(entity, roleVO);

		// copy child functions to vos
		List<FunctionVO> functionVos = new ArrayList<FunctionVO>();
		if (entity.getFunctions() != null) {
			for (Function functionEntity : entity.getFunctions()) {
				FunctionVO functionVo = new FunctionVO();
				BeanUtils.copyProperties(functionEntity, functionVo);
				functionVos.add(functionVo);
			}
		}
		roleVO.setFunctions(functionVos);
		return roleVO;
	}

	@Override
	public RoleVO create(RoleVO role) throws ServiceException {
		// generate id
		//String autoRoleId = getAutoRoleId();
		//role.setId(autoRoleId);

		// mark it as unauthorized
		role.setAuthStatus("U");

		super.create(role);

		try {
			roleDao.addRoleEntitlements(getEntity(role));
			LoggerUtil.ibsJobDebug("Calling DAO while adding entitlements to role: ");
		} catch (DataAccessException e) {
			throw new ServiceException("Error while adding entitlements to role : "+role.getId(), e);
		}
		
		// auto authorize role record if current user is super admin
				if (isCurrentUserSuperAdmin()) {
					authorize(role);
				}
		
		return role;
	}

	@Override
	public RoleVO update(RoleVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		return super.update(vo);
	}

	// modify rolesEntitlemets.....
	@Override
	public RoleVO updateEntitlements(RoleVO role, RoleVO newRole)
			throws ServiceException {
		update(role);

		try {
			roleDao.deleteRoleEntitlements(getEntity(role));
			roleDao.addRoleEntitlements(getEntity(newRole));
			LoggerUtil.ibsJobDebug("Calling DAO  while modify role entitlements : ");
		} catch (DataAccessException e) {
			throw new ServiceException("Error while updating the role entitlements : "+role.getId(), e);
		}
		
			  //auto authorize role record if current user is super admin
			  if(isCurrentUserSuperAdmin()){
				  authorize(role); 
			  }
		return role;
	}

	@Override
	public String getAutoRoleId() throws ServiceException {

		String roles = null;
		try {
			roles = roleDao.getAutoRoleId();
			LoggerUtil.ibsJobDebug("Calling DAO for geting system generated roleId  :");
		} catch (DataAccessException e) {
			throw new ServiceException("Error while auto generated roleId :", e);
		}
		return roles;
	}

	public List<RoleVO> getModifyAllocatedRoles(String userId)
			throws ServiceException {

		List<Role> userRoles = null;
		try {
			userRoles = roleDao.getModifyAllocatedRoles(userId); // new ArrayList<Role>();
			LoggerUtil.ibsJobDebug("Calling DAO get modified roles for userId  :"+userId);
		} 
		catch (DataAccessException e) {
			throw new ServiceException("Error while fetch modify allocated roles for userId: "+userId, e);
		}
		// userRoles=roleDao.getModifyAllocatedRoles(userId);
		if (userRoles != null) {
			List<RoleVO> roleVOs = new ArrayList<RoleVO>(userRoles.size());
			for (Role v : userRoles) {
				RoleVO roleVO = new RoleVO();
				BeanUtils.copyProperties(v, roleVO);
				roleVOs.add(roleVO);
			}
			return roleVOs;
		} else {
			return new ArrayList<RoleVO>();
		}
	}
	
	// For MBS
	public List<RoleVO> getModifyAllocatedRolesForMbs(String userId)
			throws ServiceException {

		List<Role> userRoles = null;
		try {
			userRoles = roleDao.getModifyAllocatedRolesForMbs(userId); // new ArrayList<Role>();
			LoggerUtil.ibsJobDebug("Calling DAO get modified roles for userId  :"+userId);
		} 
		catch (DataAccessException e) {
			throw new ServiceException("Error while fetch modify allocated roles for userId: "+userId, e);
		}
		// userRoles=roleDao.getModifyAllocatedRoles(userId);
		if (userRoles != null) {
			List<RoleVO> roleVOs = new ArrayList<RoleVO>(userRoles.size());
			for (Role v : userRoles) {
				RoleVO roleVO = new RoleVO();
				BeanUtils.copyProperties(v, roleVO);
				roleVOs.add(roleVO);
			}
			return roleVOs;
		} else {
			return new ArrayList<RoleVO>();
		}
	}
	

	@Override
	public boolean isRoleNameAvailable(String roleName) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("Calling DAO  for availability of role name: "+roleName);
			return roleDao.isRoleNameAvailable(roleName);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while checking availability of role name: "+roleName, e);
		}
	}

	@Override
	public int countRoleNameAvailable(String rname) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("DAO call for counting no. of role name : "+rname);
			return roleDao.countRoleNameAvailable(rname);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while counting no of role name :" + rname, e);
		}
	}

	@Override
	public List<RoleVO> getAuthorizedRoles() throws ServiceException {
		List<Role> entities = null;
		try {
			entities = roleDao.getAuthorizedRoles();
			LoggerUtil.ibsJobDebug("DAO call for retrieving all authorized roles : ");
		} catch (DataAccessException e) {
			throw new ServiceException("Error while retrieving all authorized roles : ", e);
		}

		if (entities == null) {
			return new ArrayList<RoleVO>();
		}

		List<RoleVO> vos = new ArrayList<RoleVO>(entities.size());
		for (Role entity : entities) {
			RoleVO vo = getValueObject(entity);
			vos.add(vo);
		}
		return vos;
	}
	
	// For MBS Role
	@Override
	public List<RoleVO> getAuthorizedRolesForMbs() throws ServiceException {
		List<Role> entities = null;
		try {
			entities = roleDao.getAuthorizedRolesForMbs();
			LoggerUtil.ibsJobDebug("DAO call for retrieving all authorized roles : ");
		} catch (DataAccessException e) {
			throw new ServiceException("Error while retrieving all authorized roles : ", e);
		}

		if (entities == null) {
			return new ArrayList<RoleVO>();
		}

		List<RoleVO> vos = new ArrayList<RoleVO>(entities.size());
		for (Role entity : entities) {
			RoleVO vo = getValueObject(entity);
			vos.add(vo);
		}
		return vos;
	}
	
	// For delete opertaion
	
		@Override
		public String deleteRole(String id) throws ServiceException {
			String success;
			try {
				success= roleDao.deleteRole(id);
				LoggerUtil.ibsJobDebug("Calling DAO for delete role : "+id);
			} catch (DataAccessException e) {
				throw new ServiceException("Error while deleting role: "+id, e);
			}
			return success;
		}

		// For ModifyRole Status
		@Override
		public boolean isRoleStatustoInactive(String roleId) throws ServiceException {
			try {
				LoggerUtil.ibsJobDebug("Calling DAO for validating role inactive status  : "+roleId);
				return roleDao.isRoleStatustoInactive(roleId);
			} catch (DataAccessException e) {
				throw new ServiceException("Calling DAO for validating role inactive status : "+roleId, e);
			}
		}
		
		
		

		private boolean isCurrentUserSuperAdmin() {
			UserDetails details = getUserDetails();
			String loggedInUser = details.getUsername();
			return loggedInUser.equals(SUPER_ADMIN_USER_NAME);
		}
}
