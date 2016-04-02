package com.bfsi.mfi.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.AgentDao;
import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.entity.Role;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.AgentService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CbsCodesVO;
import com.bfsi.mfi.vo.RoleVO;

@Service(value = "agentService")
public class AgentServiceImpl extends MaintenanceServiceImpl<AgentVO, Agent>
		implements AgentService {

	private static final String ERROR_ANE = "Agent Id doesn't Exist";
	private static final String ERROR_ANA = "Agent is not active ";
	private static final String ERROR_IDI = "Invalid device Id";
	private static final String ERROR_ICD = "Invalid Current Date";
	private static final String ERROR_ETO = "Expiration time has out";
	private static final String SUCCESS = "Success";
	private static final String ERROR_IRK = "Invalid Registration Key";
	private static final String ERROR_RIM = "Registration Key is missing";
	private static final String ERROR_ANR = "Agent is  not registered";
	private static final String AGENT_STATUS = "A";
	private static final Object REG_STATUS = "R";
	
	@Autowired
	private AgentDao agentDao;

	@Override
	public AgentVO update(AgentVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		AgentVO agentVO;
		try {
			agentVO = super.update(vo);
			agentDao.deleteRolesToUser(getEntity(vo));
			agentDao.addRolesToUser(getEntity(vo));
			LoggerUtil.ibsJobDebug("Calling DAO  for updating Agent = " +vo.getId());
        } catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while update Agent = "+vo.getId(), e);
        } catch (Exception e) {
                  throw new ServiceException("Unhandled exception while update Agent = "+vo.getId(), e);
        }
		return agentVO;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected AgentDao getMaintenanceDao() {
		return agentDao;
	}
	
	@Override
	protected Agent getEntity(AgentVO vo) {
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
	protected AgentVO getValueObject(Agent entity) {
		AgentVO agentVO = new AgentVO(entity);
		return agentVO;
	}
	

	@Override
	public List<AgentVO> getAgendIdForAllocation() throws ServiceException {
		List<Agent> agent = agentDao.getAgendIdForAllocation();
		
		try {
			if (agent != null) {
				List<AgentVO> agentVOs = new ArrayList<AgentVO>(agent.size());
				for (Agent lov : agent) {
					AgentVO agentVO = new AgentVO();
					BeanUtils.copyProperties(lov, agentVO);
					agentVOs.add(agentVO);
				}
				LoggerUtil.ibsJobDebug("Calling DAO  for getAgendIdForAllocation in if " );
				return agentVOs;
			} else {
				LoggerUtil.ibsJobDebug("Calling DAO  for getAgendIdForAllocation in else" );
				return new ArrayList<AgentVO>();
			}
			
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating getAgendIdForAllocation "+ e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while validating getAgendIdForAllocation: "+ e);
        }
		
	}

	@Override
	public String getAutoAgentId() throws ServiceException {

		String agents;
		try {
			agents = agentDao.getAutoAgentId();
			LoggerUtil.ibsJobDebug("Calling DAO for getAutoAgentId" );
			return agents;
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating getAutoAgentId for Agent: " + e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception while validating getAutoAgentId for Agent: " + e);
        }
	}

	@Override
	public AgentVO generateRegKey(String id) throws ServiceException {
		AgentVO agent = new AgentVO();
		try {
			agent = agentDao.generateRegKey(id);
			LoggerUtil.ibsJobDebug("Calling DAO for generateRegKey" );
			return agent;
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating generateRegKey for Agent = " + agent.getId(), e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while validating generateRegKey for Agent = " + agent.getId(), e);
        }
	}

	// Rest agent login
	@Override
	public ServiceResponse agentLoginStatus(String userName, String uniqueId,
			String dataKey) throws ServiceException {
		ServiceResponse l_res=new ServiceResponse();
		Boolean status = true;
		try {
			Agent agent = getMaintenanceDao().getAgentByUserName(userName);
			if (agent == null)
			{	LoggerUtil.ibsJobError(ERROR_ANE);
			l_res.setMessageCode("MFI10104");
			return l_res;
				}
			if (agent.getDeviceId() == null)
			{
				LoggerUtil.ibsJobError(ERROR_IDI);
				l_res.setMessageCode("MFI10107");
				return l_res;
			}	
			else {
				status = getMaintenanceDao().validateDeviceId(uniqueId,
						agent.getDeviceId());
				if (!(status)) {
					LoggerUtil.ibsJobError(ERROR_IDI);
					l_res.setMessageCode("MFI10107");
					return l_res;
					}
			}
			l_res.setStatus(true);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating agentLoginStatus for Agent = " + userName, e);
        } 
		return l_res;

	}

	// Rest agent registartion
	@Override
	public ServiceResponse submitRegistration(String userName, String uniqueId,
			String registKey) throws ServiceException {
		ServiceResponse l_res=new ServiceResponse();
		Boolean status = true;
		try {
			Agent agent = getMaintenanceDao().getAgentByUserName(userName);
			if (agent == null){
				LoggerUtil.ibsJobError(ERROR_ANE);
				l_res.setMessageCode("MFI10104");
				return l_res;	}
			if (!agent.getIsActive().equals(AGENT_STATUS)){
				LoggerUtil.ibsJobError(ERROR_ANA);
				l_res.setMessageCode("MFI10105");
				return l_res;
				
				}
			if (agent.getRegKey() == null){
				LoggerUtil.ibsJobError(ERROR_RIM);
				l_res.setMessageCode("MFI10106");
				return l_res;
				}
			if (agent.getDeviceId() == null){
				LoggerUtil.ibsJobError(ERROR_IDI);
				l_res.setMessageCode("MFI10107");
				return l_res;
				}
			else {
				status = getMaintenanceDao().validateDeviceId(uniqueId , agent.getDeviceId());
				if (!(status))
				{	l_res.setMessageCode("MFI10107");
				return l_res;
				}
			}
			status = validateAgentCurrentDate(agent.getStartDate() ,	agent.getEndDate());
			if (!(status)) {
				LoggerUtil.ibsJobError(ERROR_ICD);
				l_res.setMessageCode("MFI10108");
				return l_res;
			}
			if (!agent.getRegKey().equals(registKey)) {
				LoggerUtil.ibsJobError(ERROR_IRK);
				l_res.setMessageCode("MFI10109");
				return l_res;
			}
			status = validateExpirationTime(agent.getRegKeyExpiryTime());
			if (!(status)) {
				LoggerUtil.ibsJobError(ERROR_ETO);
				l_res.setMessageCode("MFI10110");
				return l_res;
			}
			l_res.setStatus(true);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating submitRegistration for Agent = " + userName, e);
        } 
		return l_res;
	}

	// Rest agent registartion for forgetKey
	@Override
	public String submitRegistrationForForgetKey(String userName,
			String uniqueId, String registKey) throws ServiceException {
		Boolean status = true;
		try {
			Agent agent = getMaintenanceDao().getAgentByUserName(userName);
			if (agent == null){
				LoggerUtil.ibsJobError(ERROR_ANE);
				return ERROR_ANE;	}
			if (!agent.getIsActive().equals(AGENT_STATUS)){
				LoggerUtil.ibsJobError(ERROR_ANA);
				return ERROR_ANA;	}
			if (!agent.getRegStatus().equals(REG_STATUS)){
				LoggerUtil.ibsJobError(ERROR_ANR);
				return ERROR_ANR;}
			if (agent.getRegKey() == null){
				LoggerUtil.ibsJobError(ERROR_RIM);
				return ERROR_RIM;}
			if (agent.getDeviceId() == null){
				LoggerUtil.ibsJobError(ERROR_IDI);
				return ERROR_IDI;}
			else {
				status = getMaintenanceDao().validateDeviceId(uniqueId,	agent.getDeviceId());
				if (!(status)){
					LoggerUtil.ibsJobError(ERROR_IDI);
					return ERROR_IDI;}
			}
			status = validateAgentCurrentDate(agent.getStartDate(),
					agent.getEndDate());
			if (!(status)) {
				LoggerUtil.ibsJobError(ERROR_ICD);
				return ERROR_ICD;
			}
			if (!agent.getRegKey().equals(registKey)) {
				LoggerUtil.ibsJobError(ERROR_IRK);
				return ERROR_IRK;
			}
			status = validateExpirationTime(agent.getRegKeyExpiryTime());
			if (!(status)) {
				LoggerUtil.ibsJobError(ERROR_ETO);
				return ERROR_ETO;
			}
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating submitRegistrationForForgetKey for Agent = "+userName, e);
        } catch (Exception e) {
                  throw new ServiceException("Unhandled exception while validating submitRegistrationForForgetKey for Agent = "+userName, e);
        }
		return SUCCESS;
	}

	@Override
	public ServiceResponse doRegistrationConfirmaton(String userName)
			throws ServiceException {
		ServiceResponse l_res=new ServiceResponse();
		try {
			getMaintenanceDao().updateAgentRegistConfirm(userName);
			LoggerUtil.ibsJobDebug("doRegistrationConfirmaton completed Successfully");
		} catch (DataAccessException e) {
			LoggerUtil.ibsJobError("Registraion confirm error",e);
            throw new ServiceException("DataAccessException while validating doRegistrationConfirmaton for Agent = "+userName, e);
        }
		l_res.setStatus(true);
		return l_res;
	}

	private Boolean validateExpirationTime(Date expirationTime)
			throws ServiceException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date currentDate = new Date();
		try {
			currentDate = dateFormat.parse(dateFormat.format(currentDate));
			expirationTime = dateFormat.parse(dateFormat.format(expirationTime));
			if (currentDate.compareTo(expirationTime) < 0) {
				LoggerUtil.ibsJobDebug("Validation of validateExpirationTime completed Successfully");
				return true;
			}
			LoggerUtil.ibsJobDebug("validateExpirationTime completed Successfully");
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating validateExpirationTime for Agent = "+ e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while validating validateExpirationTime for Agent = "+ e);
        }
		return false;
	}

	private Boolean validateAgentCurrentDate(Date startDate, Date endDate)
			throws ServiceException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date currentDate = new Date();
		try {
			currentDate = dateFormat.parse(dateFormat.format(currentDate));
			LoggerUtil.ibsJobDebug("Validation of validateAgentCurrentDate completed Successfully");
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating validateExpirationTime for Agent = "+ e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while validating validateExpirationTime for Agent = "+ e);
        }

		if (endDate == null) {
			if (currentDate.compareTo(startDate) > 0) {
				return true;
			}
		} else {
			if (currentDate.compareTo(endDate) < 0) {
				if (currentDate.compareTo(startDate) > 0) {
					return true;
				}
			}
		}
		LoggerUtil.ibsJobDebug("validateAgentCurrentDate completed Successfully");
		return false;
	}

	@Override
	public String generateDataKey(String agentId) throws ServiceException {
		String dataKey = null;
		// This scenario is applicapable only when agent has forgot the password
		dataKey = checkDataKeyAvailable(agentId);
		if (dataKey == null) {
			try {
				LoggerUtil.ibsJobDebug("validation in generateDataKey dataKey == null");
				KeyGenerator kgen = KeyGenerator.getInstance("AES");
				kgen.init(256);
				SecretKey skey = kgen.generateKey();
				byte[] raw = skey.getEncoded();
				dataKey = DatatypeConverter.printBase64Binary(raw);
				getMaintenanceDao().updateAgentWithDataKey(agentId, dataKey);
				LoggerUtil.ibsJobDebug("validation in generateDataKey completed");
			} catch (DataAccessException e) {
	            throw new ServiceException("DataAccessException while validating generateDataKey for Agent = "+ agentId ,e);
	        } catch (Exception e) {
	            throw new ServiceException("Unhandled exception  while validating generateDataKey for Agent = "+ agentId , e);
	        }
		} else {
			try {
				getMaintenanceDao().updateAgentRegistConfirm(agentId);
				LoggerUtil.ibsJobDebug("validation in generateDataKey in else");
			} catch (DataAccessException e) {
	            throw new ServiceException("DataAccessException while validating generateDataKey for Agent = "+ agentId , e);
	        } catch (Exception e) {
	            throw new ServiceException("Unhandled exception  while validating generateDataKey for Agent = "+ agentId , e);
	        }
		}
		return dataKey;
	}

	private static boolean slowEquals(byte[] a, byte[] b) {
		int diff = a.length ^ b.length;
		for (int i = 0; i < a.length && i < b.length; i++)
			diff |= a[i] ^ b[i];
		return diff == 0;
	}

	public static String asHex(byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;

		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append('0');

			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}
		return strbuf.toString();
	}

	private String checkDataKeyAvailable(String agentId) {
		String dataKey = null;
		Agent agent = null;
		try {
			agent = getMaintenanceDao().checkDataKeyAvailable(agentId);
			if (agent != null) {
				dataKey = agent.getDataValue();
				LoggerUtil.ibsJobDebug("validation in checkDataKeyAvailable completed");
			}
		} catch (DataAccessException e) {
           // throw new ServiceException("DataAccessException while validating checkDataKeyAvailable for Agent = "+ agentId , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while validating checkDataKeyAvailable for Agent = "+ agentId , e);
        }
		return dataKey;
	}

	@Override
	public boolean isUserIdAvailable(String userId) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("validation in isUserIdAvailable started");
			return agentDao.isUserIdAvailable(userId);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating isUserIdAvailable for Agent = "+ userId , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while validating isUserIdAvailable for Agent = "+ userId , e);
        }
	}

	@Override
	public AgentVO getAgentByUserName(String id) throws ServiceException {
		try {
			Agent entity = getMaintenanceDao().getAgentByUserName(id);
			LoggerUtil.ibsJobDebug("validation in getAgentByUserName completed");
			
			return getValueObject(entity);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating getAgentByUserName for Agent = "+ id , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while validating getAgentByUserName for Agent = "+ id , e);
        }
	}

	@Override
	public String deleteAgent(String id) throws ServiceException {
		String success;
		try {
			success = agentDao.deleteAgent(id);
			LoggerUtil.ibsJobDebug("validation in deleteAgent success "+id);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while deleteAgent for Agent = "+ id , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while deleteAgent for Agent = "+ id , e);
        }
		return success;
	}

	/*
	 * Added for Authorised agents in drop down list
	 */
	@Override
	public List<AgentVO> getAuthorized() throws ServiceException {
		List<Agent> agent = agentDao.getAuthorized();
		if (agent != null) {
			List<AgentVO> agentVOs = new ArrayList<AgentVO>(agent.size());
			for (Agent lov : agent) {
				AgentVO agentVO = new AgentVO();
				BeanUtils.copyProperties(lov, agentVO);
				agentVOs.add(agentVO);
			}
			LoggerUtil.ibsJobDebug("validation in getAuthorized with agent is not null");
			return agentVOs;
		} else {
			LoggerUtil.ibsJobDebug("validation in getAuthorized with agent is null");
			return new ArrayList<AgentVO>();
		}
	}

	/*
	 * Get agent Authorised agents who have mapped to credit officer in drop
	 * down list.
	 */
	@Override
	public List<AgentVO> getAuthAgentHavCreditOfficer() throws ServiceException {
		List<Agent> agent = agentDao.getAuthAgentHavCreditOfficer();
		if (agent != null) {
			List<AgentVO> agentVOs = new ArrayList<AgentVO>(agent.size());
			for (Agent lov : agent) {
				AgentVO agentVO = new AgentVO();
				BeanUtils.copyProperties(lov, agentVO);
				agentVOs.add(agentVO);
			}
			LoggerUtil.ibsJobDebug("validation in getAuthAgentHavCreditOfficer with agent is not null");
			return agentVOs;
		} else {
			LoggerUtil.ibsJobDebug("validation in getAuthAgentHavCreditOfficer with agent is not null");
			return new ArrayList<AgentVO>();
		}
	}

	@Override
	public String getAgentIdByUserName(String userName) throws ServiceException {
		String agentId = null;
		Agent agent = null;
		try {
			agent = getMaintenanceDao().getAgentIdByUserName(userName);
			agentId = agent.getId();
			LoggerUtil.ibsJobDebug("validation in getAgentIdByUserName with agent = "+ agent.getId());
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while validating getAgentIdByUserName for Agent = "+ userName , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while validating getAgentIdByUserName for Agent = "+ userName , e);
        }
		return agentId;
	}
	
	@Override
	public List<AgentVO> getcountryCodes() {
		List<Agent> agent = agentDao.getcountryCodes();
		if (agent != null) {
			List<AgentVO> agentVOs = new ArrayList<AgentVO>(agent.size());
			for (Agent lov : agent) {
				AgentVO agentVO = new AgentVO();
				BeanUtils.copyProperties(lov, agentVO);
				agentVOs.add(agentVO);
			}
			return agentVOs;
		} else {
			return new ArrayList<AgentVO>();
		}
	}
	
	//private static final String SUPER_ADMIN_USER_NAME = "admin";
		private static final String SUPER_ADMIN_USER_NAME = "SU";
		@Override
		public AgentVO create(AgentVO vo) throws ServiceException {
			// insert user roles
			super.create(vo);
			LoggerUtil.ibsJobDebug("Calling User creation method = " +vo.getId());
			// insert user roles
			try {
				agentDao.addRolesToAgent(vo.getEntity());
				LoggerUtil.ibsJobDebug("Roles added to user Successfully for ... " +vo.getId());
			} catch (DataAccessException e) {
	            throw new ServiceException("DataAccessException while create User = "+vo.getId(), e);
	        } catch (Exception e) {
	            throw new ServiceException("Unhandled exception while create User = "+vo.getId(), e);
	        }
			return vo;
		}

	@Override
	public List<String> getAgentRoles(String agentId) throws ServiceException {
		// TODO Auto-generated method stub
		List<String> agentRoles = null;
		try {
			agentRoles = agentDao.getAgentRoles(agentId);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while fetching getAgentRoles for Agent = "+ agentId , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while fetching getAgentRoles for Agent = "+ agentId , e);
        }
		return agentRoles;
	}
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void unregisterAgent(String p_agentId) throws ServiceException{		
		try {
			agentDao.unregisterAgent(p_agentId);
			
			
		} catch (DataAccessException e) {
			throw new ServiceException("Data Access excepetion while unregister agent",e);
		}
		
		
	}

	@Override
	public String getMacId(String agentId) throws ServiceException {
		String macId = null;
		try {
			macId = agentDao.getMacId(agentId);
		} catch (DataAccessException e) {
            throw new ServiceException("DataAccessException while fetching MacId for Agent = "+ agentId , e);
        } catch (Exception e) {
            throw new ServiceException("Unhandled exception  while fetching MacId for Agent = "+ agentId , e);
        }
		return macId;
	}
	
	@Override
	public List<CbsCodesVO> getCbsAgentCode() throws ServiceException {
		List<CbsCodes> cbsCodesList = agentDao.getCbsAgentCode();
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
	
	
	//for drop down
	@Override
	public List<AgentVO> getAgentIds() throws ServiceException{
		List<Agent> agentsList = agentDao.getAgentIds();
		if (agentsList != null) {
			List<AgentVO> agentVOList = new ArrayList<AgentVO>(agentsList.size());
			for (Agent agent : agentsList) {
				AgentVO agentVO = new AgentVO();
				BeanUtils.copyProperties(agent, agentVO);
				agentVOList.add(agentVO);
			}
			return agentVOList;
		} else {
			return new ArrayList<AgentVO>();
		}
		
	}

	@Override
	public String getDataKey(String agentId) {
		
		return agentDao.agentDataKey(agentId);
	}

	
	
	
	
}
