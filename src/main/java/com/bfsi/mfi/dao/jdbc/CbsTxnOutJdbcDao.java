package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.CbsTxnOutDao;
import com.bfsi.mfi.entity.CbsTxnOut;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository
public class CbsTxnOutJdbcDao extends MaintenanceJdbcDao<CbsTxnOut> implements CbsTxnOutDao {	
	
	@Autowired
	private DataSource dataSource;

		@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	
		@Override
	protected String getSelectByPkQuery() {
		return ApplicationQuery.CBSTXNOUT_QUERY_SELECT;
	}
			
	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return ApplicationQuery.CBSTXNOUT_QUERY_SELECT_ALL;
	}

	@Override
	protected RowMapper<CbsTxnOut> getRowMapper() {
		// TODO Auto-generated method stub
		return new AgendaMapper();
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
	
	private static final class AgendaMapper implements RowMapper<CbsTxnOut> {
		public CbsTxnOut mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CbsTxnOut cbsTxnOut = new CbsTxnOut();
			
			cbsTxnOut.setMfiOutSeqno(rs.getString("MFI_OUT_SEQNO"));
			cbsTxnOut.setMbsTxnRefNo(rs.getString("MBS_TXN_REF_NO"));
			cbsTxnOut.setCbsAcRefNo(rs.getString("CBS_AC_REF_NO"));
			cbsTxnOut.setCustomerId(rs.getString("CUSTOMER_ID"));
			cbsTxnOut.setCbsBranchCode(rs.getString("CBS_BRANCH_CODE"));
			cbsTxnOut.setModuleCode(rs.getString("MODULE_CODE"));
			cbsTxnOut.setTxnCode(rs.getString("TXN_CODE"));
			cbsTxnOut.setTxnIdentifier(rs.getString("TXN_IDENTIFIER"));
			cbsTxnOut.setSyncType(rs.getString("SYNC_TYPE"));
			cbsTxnOut.setReqOrTxn(rs.getString("IS_REQ_OR_TXN"));
			cbsTxnOut.setSentToCbs(rs.getString("IS_SENT_TO_CBS"));
			cbsTxnOut.setLogTime(rs.getTimestamp("LOG_TIME"));
			cbsTxnOut.setCbsSentTime(rs.getTimestamp("CBS_SENT_TIME"));
			cbsTxnOut.setCbsResponseStat(rs.getString("CBS_RESPONSE_STAT"));
			cbsTxnOut.setCbsResponseTxnRefNo(rs.getString("CBS_RESPONSE_TXN_REF_NO"));
			cbsTxnOut.setCbsRespondTime(rs.getTimestamp("CBS_RESPOND_TIME"));
			cbsTxnOut.setCbsErrorCode(rs.getString("CBS_ERROR_CODE"));
			cbsTxnOut.setCbsErrorDesc(rs.getString("CBS_ERROR_DESC"));
			cbsTxnOut.setIbsAgendaId(rs.getString("IBS_AGENDA_ID"));
			cbsTxnOut.setIbsAgendaSeqNo(rs.getInt("IBS_AGENDA_SEQ_NO"));
			/*cbsTxnOut.setAgnAmtDueCcy(rs.getString("AGN_AMT_DUE_CCY"));
			cbsTxnOut.setAgnAmtDue(rs.getInt("AGN_AMT_DUE"));
			cbsTxnOut.setAgnAmtSettledCcy(rs.getString("AGN_AMT_SETTLED_CCY"));
			cbsTxnOut.setAgnAmtSettled(rs.getInt("AGN_AMT_SETTLED"));*/
			cbsTxnOut.setFullPartialInd(rs.getString("FULL_PARTIAL_IND"));
			/*cbsTxnOut.setCbsAgentId(rs.getString("CBS_AGENT_ID"));
			cbsTxnOut.setCbsLcrCode(rs.getString("CBS_LCR_CODE"));
			cbsTxnOut.setCbsLcrType(rs.getString("CBS_LCR_TYPE"));*/
			cbsTxnOut.setMbsTxnNarrative(rs.getString("MBS_TXN_NARRATIVE"));
			cbsTxnOut.setReqDepNoInst(rs.getInt("REQ_DEP_NO_INST"));
			//cbsTxnOut.setCbsRespondTime(rs.getTimestamp("REQ_RED_REQ_DT"));
			cbsTxnOut.setReqRedFullPartInd(rs.getString("REQ_RED_FULL_PART_IND"));
			cbsTxnOut.setReqMaturityDate(rs.getDate("REQ_MATURITY_DATE"));
			cbsTxnOut.setReqIntRate(rs.getInt("REQ_INT_RATE"));
			cbsTxnOut.setReqDpTenureType(rs.getString("REQ_DP_TENURE_TYPE"));
			cbsTxnOut.setReqDpFrequencyType(rs.getString("REQ_DP_FREQUENCY_TYPE"));
			cbsTxnOut.setReqDpFrequency(rs.getInt("REQ_DP_FREQUENCY"));
			cbsTxnOut.setReqDpTenure(rs.getInt("REQ_DP_TENURE"));
						
			return cbsTxnOut;
			
		}
	}


}
