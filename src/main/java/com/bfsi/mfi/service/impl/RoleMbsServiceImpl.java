package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.RoleMbsDao;
import com.bfsi.mfi.entity.FunctionMbs;
import com.bfsi.mfi.entity.RoleMbs;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.RoleMbsService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.FunctionMbsVO;
import com.bfsi.mfi.vo.RoleMbsVO;

@Service(value = "roleMbsService")
@Transactional(rollbackFor = { ServiceException.class })
public class RoleMbsServiceImpl extends MaintenanceServiceImpl<RoleMbsVO, RoleMbs>
		implements RoleMbsService {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	private static final String SUPER_ADMIN_USER_NAME = "SU";
	
	@Autowired
	private RoleMbsDao roleMbsDao;

	@SuppressWarnings("unchecked")
	@Override
	protected RoleMbsDao getMaintenanceDao() {
		return roleMbsDao;
	}

	
	@Override
	protected RoleMbs getEntity(RoleMbsVO vo) {
		// copy child functions to vos
		List<FunctionMbs> functions = new ArrayList<FunctionMbs>();
		if (vo.getFunctionsmbs() != null) {
			for (FunctionMbsVO functionVO : vo.getFunctionsmbs()) {
				FunctionMbs function = new FunctionMbs();
				BeanUtils.copyProperties(functionVO, function);
				functions.add(function);
			}
		}
		vo.getEntity().setFunctionsmbs(functions);

		return vo.getEntity();
	}


	@Override
	protected RoleMbsVO getValueObject(RoleMbs entity) {
		RoleMbsVO roleVO = new RoleMbsVO(entity);
		// BeanUtils.copyProperties(entity, roleVO);

		// copy child functions to vos
		List<FunctionMbsVO> functionVos = new ArrayList<FunctionMbsVO>();
		if (entity.getFunctionsmbs() != null) {			
			for (FunctionMbs functionEntity : entity.getFunctionsmbs()) {
				FunctionMbsVO functionVo = new FunctionMbsVO();
				BeanUtils.copyProperties(functionEntity, functionVo);
				functionVos.add(functionVo);
			}
		}
		
		roleVO.setFunctionsmbs(functionVos);
		
		return roleVO;
	}

	@Override
	public RoleMbsVO create(RoleMbsVO role) throws ServiceException {
		// generate id
		String autoRoleId = getAutoRoleId();
		role.setId(autoRoleId);

		// mark it as unauthorized
		role.setAuthStatus("U");

		super.create(role);
		
			LoggerUtil.ibsJobDebug("Getting Selected Function2 :"+role.getFunctionsmbs());
		
			String sam = role.getFunctionsmbs().toString();
			
			sam = sam .replace("[", "");
			sam = sam .replace("]", "");
			for (String funcId : sam.split(", ")){
		         //System.out.println(funcId);
		         roleMbsDao.addEntitlements(role.getId() , funcId);
		         
		      
		}
		
		// auto authorize role record if current user is super admin
				if (isCurrentUserSuperAdmin()) {
					authorize(role);
				}
		
		return role;
	}

	@Override
	public RoleMbsVO update(RoleMbsVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		return super.update(vo);
	}

	// modify rolesEntitlemets.....
	@Override
	public RoleMbsVO updateEntitlements(RoleMbsVO role, RoleMbsVO newRole)
			throws ServiceException {
		update(role);

		try {
			roleMbsDao.deleteRoleEntitlements(getEntity(role));
			roleMbsDao.addRoleEntitlements(getEntity(newRole));
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
			roles = roleMbsDao.getAutoRoleId();
			LoggerUtil.ibsJobDebug("Calling DAO for geting system generated roleId  :");
		} catch (DataAccessException e) {
			throw new ServiceException("Error while auto generated roleId :", e);
		}
		return roles;
	}

	public List<RoleMbsVO> getModifyAllocatedRoles(String userId)
			throws ServiceException {

		List<RoleMbs> userRoles = null;
		try {
			userRoles = roleMbsDao.getModifyAllocatedRoles(userId); // new ArrayList<RoleMbs>();
			LoggerUtil.ibsJobDebug("Calling DAO get modified roles for userId  :"+userId);
		} 
		catch (DataAccessException e) {
			throw new ServiceException("Error while fetch modify allocated roles for userId: "+userId, e);
		}
		// userRoles=roleMbsDao.getModifyAllocatedRoles(userId);
		if (userRoles != null) {
			List<RoleMbsVO> roleVOs = new ArrayList<RoleMbsVO>(userRoles.size());
			for (RoleMbs v : userRoles) {
				RoleMbsVO roleVO = new RoleMbsVO();
				BeanUtils.copyProperties(v, roleVO);
				roleVOs.add(roleVO);
			}
			return roleVOs;
		} else {
			return new ArrayList<RoleMbsVO>();
		}
	}
	
	// For MBS
	public List<RoleMbsVO> getModifyAllocatedRolesForMbs(String userId)
			throws ServiceException {

		List<RoleMbs> userRoles = null;
		try {
			userRoles = roleMbsDao.getModifyAllocatedRolesForMbs(userId); // new ArrayList<RoleMbs>();
			LoggerUtil.ibsJobDebug("Calling DAO get modified roles for userId  :"+userId);
		} 
		catch (DataAccessException e) {
			throw new ServiceException("Error while fetch modify allocated roles for userId: "+userId, e);
		}
		// userRoles=roleMbsDao.getModifyAllocatedRoles(userId);
		if (userRoles != null) {
			List<RoleMbsVO> roleVOs = new ArrayList<RoleMbsVO>(userRoles.size());
			for (RoleMbs v : userRoles) {
				RoleMbsVO roleVO = new RoleMbsVO();
				BeanUtils.copyProperties(v, roleVO);
				roleVOs.add(roleVO);
			}
			return roleVOs;
		} else {
			return new ArrayList<RoleMbsVO>();
		}
	}
	

	@Override
	public boolean isRoleNameAvailable(String roleName) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("Calling DAO  for availability of role name: "+roleName);
			return roleMbsDao.isRoleNameAvailable(roleName);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while checking availability of role name: "+roleName, e);
		}
	}

	@Override
	public int countRoleNameAvailable(String rname) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("DAO call for counting no. of role name : "+rname);
			return roleMbsDao.countRoleNameAvailable(rname);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while counting no of role name :" + rname, e);
		}
	}

	@Override
	public List<RoleMbsVO> getAuthorizedRoles() throws ServiceException {
		List<RoleMbs> entities = null;
		try {
			entities = roleMbsDao.getAuthorizedRoles();
			LoggerUtil.ibsJobDebug("DAO call for retrieving all authorized roles : ");
		} catch (DataAccessException e) {
			throw new ServiceException("Error while retrieving all authorized roles : ", e);
		}

		if (entities == null) {
			return new ArrayList<RoleMbsVO>();
		}

		List<RoleMbsVO> vos = new ArrayList<RoleMbsVO>(entities.size());
		for (RoleMbs entity : entities) {
			RoleMbsVO vo = getValueObject(entity);
			vos.add(vo);
		}
		return vos;
	}
	
	// For MBS RoleMbs
	@Override
	public List<RoleMbsVO> getAuthorizedRolesForMbs() throws ServiceException {
		List<RoleMbs> entities = null;
		try {
			entities = roleMbsDao.getAuthorizedRolesForMbs();
			LoggerUtil.ibsJobDebug("DAO call for retrieving all authorized roles : ");
		} catch (DataAccessException e) {
			throw new ServiceException("Error while retrieving all authorized roles : ", e);
		}

		if (entities == null) {
			return new ArrayList<RoleMbsVO>();
		}

		List<RoleMbsVO> vos = new ArrayList<RoleMbsVO>(entities.size());
		for (RoleMbs entity : entities) {
			RoleMbsVO vo = getValueObject(entity);
			vos.add(vo);
		}
		return vos;
	}
	
	// For delete opertaion
	
		@Override
		public String deleteRole(String id) throws ServiceException {
			String success;
			try {
				success= roleMbsDao.deleteRole(id);
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
				return roleMbsDao.isRoleStatustoInactive(roleId);
			} catch (DataAccessException e) {
				throw new ServiceException("Calling DAO for validating role inactive status : "+roleId, e);
			}
		}
		
		
		
		private boolean isCurrentUserSuperAdmin() {
			UserDetails details = getUserDetails();
			String loggedInUser = details.getUsername();
			return loggedInUser.equals(SUPER_ADMIN_USER_NAME);
		}


		@Override
		public String addEntitlements(String roleId, String funcId)
				throws ServiceException {
			String success;
			try {
				success= roleMbsDao.addEntitlements(roleId, funcId);
				LoggerUtil.ibsJobDebug("Calling DAO for Inserting Entitlements : "+roleId);
			} catch (DataAccessException e) {
				throw new ServiceException("Error while Inserting Entitlements: "+roleId, e);
			}
			return success;
		}


		@Override
		public String addRoleMBS(RoleMbsVO role) throws ServiceException {
		
			String autoRoleId = getAutoRoleId();
			role.setId(autoRoleId);

			// mark it as unauthorized
						role.setAuthStatus("U");
						roleMbsDao.addRoleMBS(role);
						LoggerUtil.ibsJobDebug("Getting Selected Function2 :"+role.getFunctionsmbs());
						
						/*	String sam = role.getFunctionsmbs().toString();
							sam = sam .replace("[", "");
							sam = sam .replace("]", "");
							
							for (String funcId : sam.split(", ")){
						         //System.out.println(funcId);
						         roleMbsDao.addEntitlements(role.getId() , funcId);
						}*/
						for(int i=0; i<role.getFunctionsmbs().size(); i++)
						{
							FunctionMbsVO t = role.getFunctionsmbs().get(i);
							roleMbsDao.addEntitlements(role.getId() , t.getId());
						}
						if(isCurrentUserSuperAdmin()){
								  authorize(role); 
						}
						
						return "success";
					}
		@Override
		public String modifyRoleEntitlements(String id,List<String> list) throws ServiceException {
			String success;
			try {
				success= roleMbsDao.modifyRoleEntitlements(id,list);
				LoggerUtil.ibsJobDebug("Calling DAO for delete role : "+id);
			} catch (DataAccessException e) {
				throw new ServiceException("Error while modifyRoleEntitlements role: "+id, e);
			}
			return success;
		}
}
