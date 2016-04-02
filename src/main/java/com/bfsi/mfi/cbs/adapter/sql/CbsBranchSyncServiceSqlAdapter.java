package com.bfsi.mfi.cbs.adapter.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.jdbc.core.RowMapper;

import com.bfsi.mfi.cbs.adapter.CbsBranchSyncServiceAdapter;
import com.bfsi.mfi.cbs.model.CbsBranch;
import com.bfsi.mfi.cbs.request.BranchSyncRequest;
import com.bfsi.mfi.cbs.response.BranchSyncResponse;
import com.bfsi.mfi.query.InterfaceQuery;

/**
 * 
 * @author Vishal
 *
 */

public class CbsBranchSyncServiceSqlAdapter extends    
CbsBranchSyncServiceAdapter {
	private ServletContext servletContext =null;
	
	@Override
	public BranchSyncResponse extractBranch(BranchSyncRequest p_request) {
		BranchSyncResponse l_res=new BranchSyncResponse();
		l_res.setBranchList(getBranchFromCbs(new Date()));
		return l_res;
	}
	
	private List<CbsBranch> getBranchFromCbs(Date p_syncTime) {
		Map<String, String> l_params = new HashMap<String, String>();
		List<CbsBranch> l_branch = null;
		l_branch = getJdbcTemplate().query(InterfaceQuery.CBS_QUERY_BRANCH, l_params, new BranchMapper());
		return l_branch==null?new ArrayList<CbsBranch>():l_branch;
	}
	
	private static final class BranchMapper implements RowMapper<CbsBranch> {

		@Override
		public CbsBranch mapRow(ResultSet rs, int rowNum) throws SQLException {
			CbsBranch l_branch = new CbsBranch();
			
			l_branch.setBranchCode(rs.getString("BRANCH_CODE"));
			l_branch.setParentBranchCode(rs.getString("PARENT_BRN_CODE"));
			l_branch.setBranchName(rs.getString("BRANCH_NAME"));
			l_branch.setBranchAdd1(rs.getString("BRANCH_ADD1"));
			l_branch.setBranchAdd2(rs.getString("BRANCH_ADD2"));
			l_branch.setBranchAdd3(rs.getString("BRANCH_ADD3"));
			l_branch.setBranchAdd4(rs.getString("BRANCH_ADD4"));
			l_branch.setZipCode(rs.getString("ZIP_CODE"));
			l_branch.setCity(rs.getString("CITY"));
			l_branch.setState(rs.getString("STATE"));
			l_branch.setCountry(rs.getString("COUNTRY"));
			l_branch.setBranchDateToday(rs.getDate("BRANCH_DATE_TODAY"));
			l_branch.setBranchEodStat(rs.getString("BRANCH_EOD_STAT"));
			l_branch.setBranchLcy(rs.getString("BRANCH_LCY"));
			l_branch.setRecordStat(rs.getString("RECORD_STAT"));
			
			return l_branch;
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

}
