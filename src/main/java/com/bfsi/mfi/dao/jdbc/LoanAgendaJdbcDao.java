package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.LoanAgendaDao;
import com.bfsi.mfi.entity.Agenda;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository
public class LoanAgendaJdbcDao extends MaintenanceJdbcDao<Agenda> implements LoanAgendaDao {	
	
	@Autowired
	private DataSource dataSource;

		@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectByPkQuery() {

		return ApplicationQuery.QUERY_LOAN_AGENDA_ID;
	}
		
	@Override
	protected String getSelectAllQuery() {
		return ApplicationQuery.QUERY_LOAN_AGENDA_SELECT;
	}

	@Override
	protected RowMapper<Agenda> getRowMapper() {
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
	
	private static final class AgendaMapper implements RowMapper<Agenda> {
		public Agenda mapRow(ResultSet rs, int rowNum) throws SQLException {
			Agenda agenda = new Agenda();
			agenda.setAgendaId(rs.getString("AGENDA_ID"));
			agenda.setSeqNo(rs.getInt("SEQ_NO"));
			agenda.setCbdAccRefNo(rs.getString("CBS_AC_REF_NO"));
			agenda.setModuleCode(rs.getString("MODULE_CODE"));
			agenda.setTxnCode(rs.getString("TXN_CODE"));
			agenda.setAgentId(rs.getString("AGENT_ID"));
			agenda.setLocCode(rs.getString("LOCATION_CODE"));
			//agenda.setAgendaStatus(rs.getInt("AGENDA_STATUS"));
			agenda.setAgendaStatus(rs.getInt("AGENDA_STATUS"));
			agenda.setAgendaUploadTime(rs.getDate("AGN_UPLD_DATETIME"));
			agenda.setBranchCode(rs.getString("BRANCH_CODE"));
			agenda.setCustomerId(rs.getString("CUSTOMER_ID"));
			agenda.setCustomerName(rs.getString("CUSTOMER_NAME"));
			agenda.setAgendaCcyCode(rs.getString("AGN_CCY_CODE"));
			agenda.setAgendaLocCcyCode(rs.getString("AGN_LCY_CODE"));
			agenda.setAgendaCmpName(rs.getString("AGN_CMP_NAME"));
			agenda.setAgendaCmpStartDate(rs.getDate("AGN_CMP_ST_DATE"));
			agenda.setAgendaCmpEndDate(rs.getDate("AGN_CMP_END_DT"));
			agenda.setAgendaMbsDate(rs.getDate("AGN_MBS_DATE"));
			agenda.setAgendaAmount(rs.getDouble("AGN_AGENDA_AMT"));
			agenda.setAgendaAmountCcy(rs.getDouble("AGN_AGENDA_AMT_LCY"));
			agenda.setAgendaSettledAmount(rs.getDouble("AGN_AGENDA_SETTLED_AMT"));
			agenda.setAgendaSettledAmountCcy(rs.getDouble("AGN_AGENDA_SETTLED_AMT_LCY"));
			agenda.setIsFull(rs.getString("FULL_PART_IND"));
			agenda.setLoanDisbType(rs.getString("LN_DISBURSEMENT_TYPE"));
			agenda.setIsLoanFutureSch(rs.getString("LN_IS_FUTURE_SCH"));
			agenda.setIsLoanRedemption(rs.getString("DP_IS_REDEMPTION"));
			agenda.setDeviceId(rs.getString("DEVICE_ID"));
			agenda.setMbsSyncUploadTime(rs.getString("MBS_SYNC_UPLD_TIME"));
			agenda.setMbsTxnId(rs.getString("MBS_TXN_ID"));
			agenda.setCbsUploadJobId(rs.getString("CBS_UPLOAD_JOB_ID"));
			agenda.setIsValid(rs.getString("IS_VALID"));	
			agenda.setMbsSyncUpldTime(rs.getDate("MBS_SYNC_UPLD_TIME"));
			//Newly Added on 09-10-14
			System.out.println(agenda.getMbsSyncUpldTime());
			agenda.setSmsMobileNo(rs.getString("SMS_M_MOBILE"));
			agenda.setIsGroupLoan(rs.getString("IS_GROUP_LOAN"));
			agenda.setIsParentLoan(rs.getString("IS_PARENT_LOAN"));
			agenda.setIsParentCust(rs.getString("IS_PARENT_CUSTOMER"));
			agenda.setParentCustId(rs.getString("PARENT_CUSTOMER_ID"));
			agenda.setParentCbsAcRefNo(rs.getString("PARENT_CBS_AC_REF_NO"));
			//agenda.setTxnDesc(rs.getString("TXN_DESC"));
			
			return agenda;
		}
	}


}
