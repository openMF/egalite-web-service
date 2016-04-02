package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.BranchDao;
import com.bfsi.mfi.entity.Branch;
import com.bfsi.mfi.entity.CbsCodes;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * DAO for user entity
 * 
 * @author arun
 */
@Repository("branchDao")
public class BranchJdbcDao extends MaintenanceJdbcDao<Branch> implements
		BranchDao {
	
	public List<Branch> getBranchCode() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.QUERY_SELECT_BRANCH_DETAILS, params,
				getBranchRowMapper());
	}

	@Override
	public List<CbsCodes> getUserCbsBranchCode() {
		Map<String, String> params = new HashMap<String, String>();
		params.put(null, null);
		return jdbcTemplate.query(ApplicationQuery.QRY_CBS_BRANCH_CODE, params, new CbsBranchCodeRowMapper());
	}	
	
	private static final class CbsBranchCodeRowMapper implements RowMapper<CbsCodes> {
		public CbsCodes mapRow(ResultSet rs, int rowNum) throws SQLException 
		{	
			CbsCodes cbsCodes = new CbsCodes();
			cbsCodes.setDlValue(rs.getString("DL_VALUE"));
			cbsCodes.setDlDesc(rs.getString("DL_DESC"));
			return cbsCodes;
		}
	}
	
	private static final class BranchRowMapper implements RowMapper<Branch> {
		@Override
		public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {
			Branch branch = new Branch();
			branch.setId(rs.getString("BRANCH_CODE"));
			branch.setParentBrnCode(rs.getString("PARENT_BRN_CODE"));
			branch.setBranchName(rs.getString("BRANCH_NAME"));
			branch.setBrnAdd1(rs.getString("BRANCH_ADD1"));
			branch.setBrnAdd2(rs.getString("BRANCH_ADD2"));
			branch.setBrnAdd3(rs.getString("BRANCH_ADD3"));
			branch.setBrnAdd4(rs.getString("BRANCH_ADD4"));
			branch.setZipCode(rs.getString("ZIP_CODE"));
			branch.setCity(rs.getString("CITY"));
			branch.setState(rs.getString("STATE"));
			branch.setCountry(rs.getString("COUNTRY"));
			branch.setBranchDate(BaseJdbcDao.getUtilDate(rs.getDate("BRANCH_DATE_TODAY")));
			branch.setBranchEodStatus(rs.getString("BRANCH_EOD_STAT"));
			//branch.setChangeDate(BaseJdbcDao.getUtilDate(rs.getDate("DATE_CHANGED")));
			branch.setChangeDate(rs.getString("DATE_CHANGED"));
			branch.setBranchLcy(rs.getString("BRANCH_LCY"));
			branch.setRecordStat(rs.getString("RECORD_STAT"));
			branch.setCbs_upload_Job_Id(rs.getString("CBS_UPLD_JOB_ID"));
			return branch;
		}
	}

	public RowMapper<Branch> getBranchRowMapper() {
		return new BranchRowMapper();
	}
	@Override
	protected String getSelectByPkQuery() {
		//Shabu
		return ApplicationQuery.QUERY_SELECT_BRANCH_BY_PK;
	}
	@Override
	public List<String> getBranchCodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {

		return ApplicationQuery.BRN_QUERY_SELECT_ALL;
	}

	@Override
	protected RowMapper<Branch> getRowMapper() {
		// TODO Auto-generated method stub
		return new BranchRowMapper();
	}

	@Override
	protected String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Branch> getBranchList() {
		List<Branch> branchList = new ArrayList<Branch>();
		Map<String, String> params = new HashMap<String, String>();

		branchList = jdbcTemplate.query(ApplicationQuery.QUERY_SELECT_BRANCH, params,
				new BranchDetailMapper());
		return (branchList != null) ? branchList : new ArrayList<Branch>();
	}

	private static final class BranchDetailMapper implements RowMapper<Branch> {

		public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {
			Branch branch = new Branch();
			branch.setId(rs.getString("BRANCH_CODE"));
			branch.setBranchDate(BaseJdbcDao.getUtilDate(rs.getDate("BRANCH_DATE_TODAY")));
			return branch;
		}
	} 


}
