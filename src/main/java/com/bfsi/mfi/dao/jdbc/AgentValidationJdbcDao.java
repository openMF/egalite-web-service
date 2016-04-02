package com.bfsi.mfi.dao.jdbc;

import java.sql.Types;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.AgentValidationDao;
import com.bfsi.mfi.entity.AgentValidationServiceRequest;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Shabu
 *
 */
//EGA-MN15-000017
@Repository
public class AgentValidationJdbcDao extends BaseJdbcDao implements AgentValidationDao {

	@Override
	public String checkAgentValidity(AgentValidationServiceRequest p_request) {
		 Map<String, Object> l_procRes=null;
		 
		 ProcHandler procHandler= new ProcHandler(ApplicationQuery.FN_VALIDATE_AGENT);
			
			procHandler.registerOutputParam("result", Types.VARCHAR);

			procHandler.registerInputParam("p_agent_id", p_request.getAgentId(), Types.VARCHAR);
			procHandler.registerInputParam("p_imie_no", p_request.getImeiNo(), Types.VARCHAR);
			procHandler.registerInputParam("p_location_code", p_request.getLocCode(), Types.VARCHAR);
			procHandler.registerInputParam("p_device_id", p_request.getDeviceId(), Types.VARCHAR);
			procHandler.registerInputParam("p_sim_number", p_request.getSimNo(), Types.VARCHAR);	
			
			l_procRes = procHandler.execute(true);
			LoggerUtil.ibsJobDebug("Result" + l_procRes.get("result").toString());
			
		return l_procRes.get("result").toString();
	}
}
