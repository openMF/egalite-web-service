package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.UserDao;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.entity.User;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.UserService;
import com.bfsi.mfi.util.HashPasswordUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.RoleVO;
import com.bfsi.mfi.vo.UserVO;

@Service(value = "userService")
@Transactional(rollbackFor = { ServiceException.class })
public class UserServiceImpl extends MaintenanceServiceImpl<UserVO, User>
		implements UserService {

	@Autowired
	private UserDao userDao;
	
	//private static final String SUPER_ADMIN_USER_NAME = "admin";
	private static final String SUPER_ADMIN_USER_NAME = "SU";
	@Override
	public UserVO create(UserVO vo) throws ServiceException {
		if ((vo.getPassword() != null) && (!"".equals(vo.getPassword()))) {
			try {
				String hashedPassword = HashPasswordUtil.hashPassword(vo.getPassword());
				vo.setPassword(hashedPassword);
				LoggerUtil.ibsJobDebug("Calling DAO  for create Agent = " +vo.getId());
			} catch (DataAccessException e) {
	            throw new ServiceException("DataAccessException while create User = "+vo.getId(), e);
	        } catch (Exception e) {
	            throw new ServiceException("Unhandled exception while create User = "+vo.getId(), e);
	        }
		}
		vo.setAuthStatus("U");
		vo.setUserStatus("F");
		super.create(vo);
		LoggerUtil.ibsJobDebug("Calling User creation method = " +vo.getId());
		// insert user roles
		try {
			userDao.addRolesToUser(vo.getEntity());
			LoggerUtil.ibsJobDebug("Roles added to user Successfully for ... " +vo.getId());
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while create User = "+vo.getId(), e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while create User = "+vo.getId(), e);
        }

		// auto authorize user record if current user is super admin
		if (isCurrentUserSuperAdmin()) {
			authorize(vo);
		}
		return vo;
	}

	@Override
	public UserVO update(UserVO vo) throws ServiceException 
	{
		/*if (isCurrentUserSuperAdmin()) {
			vo.setAuthStatus("A");
		}*/
		vo.setAuthStatus("U");
		UserVO userVO = super.update(vo);
		LoggerUtil.ibsJobDebug("Calling Update method for user = " +vo.getId());

		try {
			userDao.deleteRolesToUser(getEntity(vo));
			userDao.addRolesToUser(getEntity(vo));
			LoggerUtil.ibsJobDebug("Calling Update roles method for = " +vo.getId());
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while update User =  "+vo.getId(), e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while update User =  "+vo.getId(), e);
        }

		// auto authorize user record if current user is super admin
		if (isCurrentUserSuperAdmin()) {
			authorize(vo);
			LoggerUtil.ibsJobDebug("Calling authorize method for = " +vo.getId());
		}
		return userVO;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected UserDao getMaintenanceDao() {
		return userDao;
	}

	@Override
	protected User getEntity(UserVO vo) {
		// copy child roles to vos
		List<Role> roles = new ArrayList<Role>();
		if (vo.getAllocatedRoles() != null) {
			for (RoleVO roleVO : vo.getAllocatedRoles()) {
				Role role = new Role();
				BeanUtils.copyProperties(roleVO, role);
				roles.add(role);
			}
		}
		vo.getEntity().setListRoles(roles);
		LoggerUtil.ibsJobDebug("calling User getEntity for user ");
		return vo.getEntity();
	}

	@Override
	protected UserVO getValueObject(User entity) {
		UserVO userVO = new UserVO(entity);
		return userVO;
	}

	@Override
	public boolean isUserIdAvailable(String userId) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("validating  isUserIdAvailable for user = " + userId);
			return userDao.isUserIdAvailable(userId);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isUserIdAvailable for User for user =  "+userId, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isUserIdAvailable for User for user =  "+userId, e);
        }

	}

	@Override
	public boolean validatePassword(String id, String password)
			throws ServiceException {
		try {
			String hashedPassword = HashPasswordUtil.hashPassword(password);
			LoggerUtil.ibsJobDebug("validating  validatePassword for user = " + id);
			return userDao.isPasswordValid(id ,hashedPassword);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validate Password for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while validate Password for user =  "+id, e);
        }
	}

	@Override
	public String deleteUser(String id) throws ServiceException {
		String success;
		try {
			success = userDao.deleteUser(id);
			LoggerUtil.ibsJobDebug("validating deleteUser for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while deleteUser for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while deleteUser for user =  "+id, e);
        }
		return success;
	}

	@Override
	public void resetPassword(String id, String pswd) throws ServiceException {
		try {
			String hashedPassword = HashPasswordUtil.hashPassword(pswd);
			userDao.resetPassword(id, hashedPassword);
			
			//auditTrailJdbcDao.auditUpdate(auditTrail);
			
			LoggerUtil.ibsJobDebug("validating resetPassword for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while resetPassword for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while resetPassword for user =  "+id, e);
        }
	}
	@Override
	public void changePassword(String id, String pswd) throws ServiceException {
		try {
			String hashedPassword = HashPasswordUtil.hashPassword(pswd);
			userDao.changePassword(id, hashedPassword);
			//auditTrailJdbcDao.auditUpdate(auditTrail);
			LoggerUtil.ibsJobDebug("validating resetPassword for user = " + id);
			
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while resetPassword for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while resetPassword for user =  "+id, e);
        }
	}
	
	@Override
	public List<UserVO> getCreditOfficers() {
		List<User> user = userDao.getCreditOfficers();
		if (user != null) {
			List<UserVO> userVOs = new ArrayList<UserVO>(user.size());
			for (User lov : user) {
				UserVO userVO = new UserVO();
				BeanUtils.copyProperties(lov, userVO);
				userVOs.add(userVO);
			}
			return userVOs;
		} else {
			return new ArrayList<UserVO>();
		}
	}

	@Override
	public String unLockUser(String id) throws ServiceException {
		String success;
		try {
			success = userDao.unLockUser(id);
			LoggerUtil.ibsJobDebug("validating unLockUser for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while unLockUser for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while unLockUser for user =  "+id, e);
        }
		return success;
	}

	@Override
	public void updateSuccessfulLogin(String userName) throws ServiceException {
		try {
			Date currentTime = new Date();
			userDao.updateLastLoggedIn(userName, currentTime);
			LoggerUtil.ibsJobDebug("validating updateSuccessfulLogin for user = " + userName);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while updateSuccessfulLogin for user =  "+userName, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while updateSuccessfulLogin for user =  "+userName, e);
        }
	}

	/**
	 * Check if currently logged in user is super admin
	 * 
	 * @return
	 */
	private boolean isCurrentUserSuperAdmin() {
		UserDetails details = getUserDetails();
		String loggedInUser = details.getUsername();
		return loggedInUser.equals(SUPER_ADMIN_USER_NAME);
	}
	
	@Override
	public int noOfFailedLogins(String id) throws ServiceException {
		int value;
		try {
			value = userDao.noOfFailedLogins(id);
			LoggerUtil.ibsJobDebug("validating noOfFailedLogins for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while noOfFailedLogins for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while noOfFailedLogins for user =  "+id, e);
        }
		return value;
	}

	@Override
	public boolean isRoleAuthorized(String id) throws ServiceException 
	{
		boolean response = false;
		try {
			response = userDao.isRoleAuthorized(id);
			if (response) {
				return true;
			}
			LoggerUtil.ibsJobDebug("validating isRoleAuthorized for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isRoleAuthorized for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isRoleAuthorized for user =  "+id, e);
        }
		return response;
	}

	@Override
	public void updateAuditTrail(String id, String loggedInUser)
			throws ServiceException {

		try {
			userDao.updateAuditTrail(id, loggedInUser);
			LoggerUtil.ibsJobDebug("validating updateAuditTrail for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while updateAuditTrail for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while updateAuditTrail for user =  "+id, e);
        }
		
	}

	@Override
	public boolean isUserLogined(String id) throws ServiceException 
	{
		boolean response = false;
		try {
			response = userDao.isUserLogined(id);
			if (response) {
				return true;
			}
			LoggerUtil.ibsJobDebug("validating isUserLogined for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isUserLogined for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isUserLogined for user =  "+id, e);
        }
		return response;
	}

	@Override
	public boolean logoutUser(String id) throws ServiceException {
		boolean response = false;
		try {
			response = userDao.logoutUser(id);
			if (response) {
				return true;
			}
			LoggerUtil.ibsJobDebug("validating logoutUser for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while logoutUser for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while logoutUser for user =  "+id, e);
        }
		return response;
	}

	@Override
	public void userSessionExpired() 
	{
		try 
		{
			UserDetails userDetails = getUserDetails();
			String loggedInUser = userDetails.getUsername();
			userDao.userSessionExpired(loggedInUser);
			LoggerUtil.ibsJobDebug("validating logoutUser for user = " + loggedInUser);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while logoutUser for user =  "+ e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while logoutUser for user =  "+ e);
        }
		
	}

	@Override
	public boolean isUserAuthorized(String id) throws ServiceException 
	{
		boolean response = false;
		try {
			response = userDao.isUserAuthorized(id);
			if (response) {
				return true;
			}
			LoggerUtil.ibsJobDebug("validating logoutUser for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while logoutUser for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while logoutUser for user =  "+id, e);
        }
		return response;
	}
	
	@Override
	public boolean isRoleActive(String id) throws ServiceException 
	{
		boolean response = false;
		try {
			response = userDao.isRoleActive(id);
			if (response) {
				return true;
			}
			LoggerUtil.ibsJobDebug("validating isRoleActive for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isRoleActive for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isRoleActive for user =  "+id, e);
        }
		return response;
	}
	
	@Override
	public int isUserLoggedIn(String id) throws ServiceException 
	{
		int response;
		try {
			response = userDao.isUserLoggedIn(id);
			
			LoggerUtil.ibsJobDebug("validating isUserLoggedIn for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isUserLoggedIn for user = : "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isUserLoggedIn for user = : "+id, e);
        }
		return response;
	}

	@Override
	public User forValidFirstTimeLogin(String id) 
	{
		User user;
		try {
			user = userDao.forValidFirstTimeLogin(id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isUserLoggedIn for user = : "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isUserLoggedIn for user = : "+id, e);
        }
		return user;
	}
	
	@Override
	public void firstTimetPaswdReset(String id, String pswd) throws ServiceException {
		try {
			String hashedPassword = HashPasswordUtil.hashPassword(pswd);
			userDao.firstTimetPaswdReset(id, hashedPassword);
			
			//auditTrailJdbcDao.auditUpdate(auditTrail);
			
			LoggerUtil.ibsJobDebug("validating resetPassword for user = " + id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while resetPassword for user =  "+id, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while resetPassword for user =  "+id, e);
        }
	}
	
	
	@Override
	public boolean isCbsCoCodeAvailable(String cbsCoCode) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("validating  isCbsCoCodeAvailable for user = " + cbsCoCode);
			return userDao.isCbsCoCodeAvailable(cbsCoCode);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while isCbsCoCodeAvailable for User for user =  "+cbsCoCode, e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while isCbsCoCodeAvailable for User for user =  "+cbsCoCode, e);
        }

	}

	@Override
	public String getAppDateToday() {
		try {
			return userDao.getAppDateToday();
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while fetch appDateToday  "+ e);
        } catch (Exception e) {
        	throw new ServiceException("Unhandled exception while fetch appDateToday  "+ e);            
        }
	}

	@Override
	public String getSystemMode() throws ServiceException {
		try {
			return userDao.getSystemMode();
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while fetch getSystemMode  "+ e);
        } catch (Exception e) {
        	throw new ServiceException("Unhandled exception while fetch getSystemMode  "+ e);            
        }
	}

	@Override
	public List<CbsCodesVO> getUserCbsCode() throws ServiceException {
		List<CbsCodes> cbsCodesList = userDao.getUserCbsCode();
		if (cbsCodesList != null) {
			List<CbsCodesVO> cbsCodeVOList = new ArrayList<CbsCodesVO>(cbsCodesList.size());
			for (CbsCodes cbsCodes : cbsCodesList) {
				CbsCodesVO cbsCodeVO = new CbsCodesVO();
				BeanUtils.copyProperties(cbsCodes, cbsCodeVO);
				cbsCodeVOList.add(cbsCodeVO);
			}
			return cbsCodeVOList;
		} else {
			return new ArrayList<CbsCodesVO>();
		}
	}
	

}
