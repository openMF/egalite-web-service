package com.bfsi.mfi.cbs.adapter.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.jdbc.core.RowMapper;

import com.bfsi.mfi.cbs.adapter.CbsDropListServiceAdapter;
import com.bfsi.mfi.cbs.response.DropListSyncResponse;
import com.bfsi.mfi.entity.CbsDropList;
import com.bfsi.mfi.query.InterfaceQuery;
import com.bfsi.mfi.util.LoggerUtil;

/**
 * 
 * @author Nirmal kanna S
 *
 */

public class CbsDropListServiceSqlAdapter extends CbsDropListServiceAdapter {
	
	private ServletContext servletContext =null;
	
	private static final class DropListMapper implements RowMapper<CbsDropList> {

		@Override
		public CbsDropList mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsDropList cbsDropList = new CbsDropList();
			cbsDropList.setBranchCode(rs.getString("BRANCH_CODE"));
			cbsDropList.setDlType(rs.getString("DL_TYPE"));
			cbsDropList.setDlValue(rs.getString("DL_VALUE"));
			cbsDropList.setDlDesc(rs.getString("DL_DESC"));
			//cbsDropList.setCbsUpldJobId(rs.getString("CBS_UPLD_JOB_ID"));
			//cbsDropList.setIbsInternalErr(rs.getString("IBS_INTERNAL_ERR"));
			//cbsDropList.setIbsErrorDescription(rs.getString("IBS_ERROR_DESCRIPTION"));
			return cbsDropList;
		}

	}

	@Override
	public ServletContext getServletContext() {
		return this.servletContext;
	}

	@Override
	public void setServletContext(ServletContext p_servletContext) {
		servletContext=p_servletContext;
	}

	@Override
	public DropListSyncResponse extractDropList() {
		Map<String, String> l_params = new HashMap<String, String>();
		DropListSyncResponse l_res = new DropListSyncResponse();
		List<CbsDropList> l_dlist = null;
		l_dlist = getJdbcTemplate().query(InterfaceQuery.CBS_DROP_LIST, l_params, new DropListMapper());		
		l_res.setCbsDropLists(l_dlist);
		return l_res;
		
	}

}
