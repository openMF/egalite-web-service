package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.Agent;
import com.bfsi.mfi.entity.AgentTransaction;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.vo.AgentVO;

/**
 * User DAO
 * 
 * @author akrishna
 * @param <User>
 */

public interface AgentDao extends MaintenanceDao<Agent> {

	public List<Agent> getAgendIdForAllocation();

	public AgentVO generateRegKey(String id);

	public String getAutoAgentId();

	public boolean validateDeviceId(String uniqueId, String deviceId);

	public void updateAgentWithDataKey(String agentId, String dataKey);

	public void updateAgentRegistConfirm(String agentId);

	public Agent checkDataKeyAvailable(String agentId);

	public boolean isUserIdAvailable(String userId);

	public Agent getAgentByUserName(String id);

	public Agent getAgentIdByUserName(String userName);

	public String deleteAgent(String id);

	public List<Agent> getAuthorized();
	

	public List<Agent> getAuthAgentHavCreditOfficer();
	public List<Agent> getcountryCodes();
	
	public int validateAgentForTransaction(AgentTransaction p_tran);
	public void addRolesToAgent(Agent agent);
	public List<String> getEntitlements(Agent agent);
	
	public List<String> getAgentRoles(String agentId);
	
	/**
	 * Insert to AMTB_AGENT_ROLES table.
	 */
	public void addRolesToUser(Agent agent);

	/**
	 * Delete to AMTB_AGENT_ROLES table.
	 */
	public void deleteRolesToUser(Agent agent);
	
	public String getMacId(String p_agentId);
	
	public void unregisterAgent(String p_agentId);
	public List<CbsCodes> getCbsAgentCode();

	public List<Agent> getAgentIds();
	
	public String agentDataKey(String agentId);
	
	

}
