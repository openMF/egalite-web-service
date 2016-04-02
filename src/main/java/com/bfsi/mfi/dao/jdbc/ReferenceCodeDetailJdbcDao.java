package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.ReferenceCodeDetailDao;
import com.bfsi.mfi.entity.RefCodeDetail;
import com.bfsi.mfi.query.ApplicationQuery;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.RefCodeVO;

@Repository("referenceCodedetailDao")
public class ReferenceCodeDetailJdbcDao extends MaintenanceJdbcDao<RefCodeDetail> implements
		ReferenceCodeDetailDao {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	

	@Override
	protected RowMapper<RefCodeDetail> getRowMapper() {
		return new NewLoanMapper();
	}

	@Override
	protected String getInsertQuery() {
		return ApplicationQuery.REFCODEDET_QUERY_INSERT;
	}
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.REFCODEDET_QUERY_SELECT_ALL;
	}

	protected String getSelectByPkQuery() {
		return ApplicationQuery.REFCODEDET_QUERY_SELECT_BY_PK;
	}
	public static final class NewLoanMapper implements RowMapper<RefCodeDetail> {
		public RefCodeDetail mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			RefCodeDetail refCodedetail = new RefCodeDetail();
			refCodedetail.setRefMasterCode(rs.getString("REF_MASTER_CODE"));
			refCodedetail.setRefDetailCode(rs.getString("REF_DETAIL_CODE"));
			refCodedetail.setDetailCodeDesc(rs.getString("DETAIL_CODE_DESC"));
			refCodedetail.setTransValueEga(rs.getString("TRANS_VALUE_EGA"));
			refCodedetail.setTransValueInt(rs.getInt("TRANS_VALUE_INT"));
			refCodedetail.setValidRefdetail(rs.getString("IS_VALID"));
			refCodedetail.setCodeSrNo(rs.getInt("CODE_SR_NO"));
			return refCodedetail;
		}
	}
	
	@Override
	public List<RefCodeDetail> getrefCodeDetail(String refCodeDetailId){

			Map<String, String> params = new HashMap<String, String>();
			params.put("refCodeDetailId", refCodeDetailId);

			List<RefCodeDetail> refdel = jdbcTemplate.query(
					ApplicationQuery.REFCODEDET_QUERY_SELECT_ALL, params, new NewLoanMapper());

			return ((refdel != null) ? refdel
					: new ArrayList<RefCodeDetail>());
	}
	
	// Row Update Ref Code
		@Override
		public String getrowUpdate(RefCodeDetail refCode) {
			
			String success =null;
			try{
				Map<String, String> params = new HashMap<String, String>();
				params.put("refMasterCode",refCode.getRefMasterCode());
				params.put("refDetailCode", refCode.getRefDetailCode());
				params.put("detailCodeDesc", refCode.getDetailCodeDesc());
				params.put("transValueEga", refCode.getTransValueEga());
				params.put("transValueInt", String.valueOf(refCode.getTransValueInt()));
				params.put("isValidText", refCode.getIsValid());
				params.put("codeSrNo", String.valueOf(refCode.getCodeSrNo()));
				
				 jdbcTemplate.update(ApplicationQuery.REFCODEDET_QUERY_UPDATE_ROWEDIT, params);
				 success = "not failure";
			}catch(Exception e)	{
				LoggerUtil.ibsJobError("Unhandeled Exception while update Reference Code : MFI10001", e);
			}
			return success;
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

		// Row Update Ref Code
			@Override
			public void insertRefCode(RefCodeVO refcode) {
				
				String success =null;
				try{
					Map<String, String> params = new HashMap<String, String>();
					params.put("id",refcode.getRefMasterCode());
					params.put("refDetailCode", refcode.getRefDetailCode());
					params.put("detailCodeDesc", refcode.getDetailCodeDesc());
					params.put("transValueEga", refcode.getTransValueEga());
					params.put("transValueInt", String.valueOf(refcode.getTransValueInt()));
					params.put("validRef", refcode.getValidRef());
					params.put("codeSrNo", String.valueOf(refcode.getCodeSrNo()));
					 {
							jdbcTemplate.execute(ApplicationQuery.REFCODEDET_QUERY_INSERT, params,
									new PreparedStatementCallback<Object>() {
										@Override
										public Object doInPreparedStatement(
												PreparedStatement stmt) throws SQLException,
												DataAccessException {
											return stmt.executeUpdate();
										}
					});
					 }
				}
				finally{
					//System.out.println("dfgdfgd");
				}
			}
}
