package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.ServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AgentVO;
import com.bfsi.mfi.vo.CbsCodesVO;

/**
 * @author arun
 * 
 */
public interface AgentService extends MaintenanceService<AgentVO, Agent> {

	String getAutoAgentId() throws ServiceException;;

	AgentVO generateRegKey(String id) throws ServiceException;;

	List<AgentVO> getAgendIdForAllocation() throws ServiceException;
	
	ServiceResponse agentLoginStatus(String userName, String uniqueId, String registKey)
			throws ServiceException;

	ServiceResponse submitRegistration(String userName, String uniqueId, String registKey)
			throws ServiceException;;

	String generateDataKey(String agentId) throws ServiceException;

	ServiceResponse doRegistrationConfirmaton(String agentId) throws ServiceException;

	String submitRegistrationForForgetKey(String userName, String uniqueId,
			String registKey) throws ServiceException;

	boolean isUserIdAvailable(String userId) throws ServiceException;

	AgentVO getAgentByUserName(String id) throws ServiceException;

	String getAgentIdByUserName(String userName) throws ServiceException;
	
	String deleteAgent(String id) throws ServiceException; 
	
	List<AgentVO> getAuthorized() throws ServiceException;
	
	List<AgentVO> getAuthAgentHavCreditOfficer() throws ServiceException;
	List<AgentVO> getcountryCodes();
	
	List<String> getAgentRoles(String agentId) throws ServiceException;
	String getMacId(String agentId) throws ServiceException;
	
	void unregisterAgent(String p_agentId) throws ServiceException;
	List<CbsCodesVO> getCbsAgentCode() throws ServiceException;

	List<AgentVO> getAgentIds() throws ServiceException;
	
	String getDataKey(String agentId);
}
