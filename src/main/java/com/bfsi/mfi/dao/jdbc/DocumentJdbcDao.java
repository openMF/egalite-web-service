package com.bfsi.mfi.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.DocumentDao;
import com.bfsi.mfi.entity.Document;
import com.bfsi.mfi.query.ApplicationQuery;

@Repository("documentDao")
public class DocumentJdbcDao extends MaintenanceJdbcDao<Document> implements
		DocumentDao {

	@Override
	public List<Document> getCustomerDocuments(String enrollmentId)
			throws DataAccessException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("enrollmentId", enrollmentId);

		return jdbcTemplate.query(ApplicationQuery.DOC_QUERY_DOCS_FOR_CUSTOMER, params,
				new CustomerDocumentMapper());
	}

	@Override
	protected String getInsertQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSelectAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RowMapper<Document> getRowMapper() {
		// TODO Auto-generated method stub
		return null;
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
	public void insertDocumentInfo(List<Document> documentList) {

		
		 SqlParameterSource[] docParams = SqlParameterSourceUtils
		  .createBatch(documentList.toArray());
		  jdbcTemplate.batchUpdate(ApplicationQuery.DOC_QUERY_INSERT, docParams);
	
		/*Map<String, String> params = new HashMap<String, String>();
		for (Document doc : documentList) {
			params.put("id", doc.getId());
			params.put("documentId", doc.getDocumentId());
			params.put("documentName", doc.getDocumentName());
			params.put("documentTag", doc.getDocumentTag());
			jdbcTemplate.execute(QUERY_INSERT, params,
					new PreparedStatementCallback<Object>() {
						@Override
						public Object doInPreparedStatement(
								PreparedStatement stmt) throws SQLException,
								DataAccessException {
							return stmt.executeUpdate();
						}
					});*/
	

	}

	@Override
	public void updateCustomerDocumentData(byte[] data, String docName,
			String enrollmentId) {
		String sql = ApplicationQuery.DOC_QUERY_DOCS_UPDATE; //"UPDATE IFTB_CUSTOMER_DOCUMENT_DATA SET DATA = ? WHERE ENROLLMENT_ID=? AND DOCUMENT_ID=?";
		jdbcTemplate.getJdbcOperations().update(
				new LobPreparedStatementCreator(sql, data, enrollmentId,
						docName));

	}

	@Override
	public void insertDocumentInfo(String id, String documentId,
			String documentName, String documentTag) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("documentId", documentId);
		params.put("documentName", documentName);
		params.put("documentTag", documentTag);
		jdbcTemplate.execute(ApplicationQuery.DOC_QUERY_INSERT, params,
				new PreparedStatementCallback<Object>() {
					@Override
					public Object doInPreparedStatement(PreparedStatement stmt)
							throws SQLException, DataAccessException {
						return stmt.executeUpdate();
					}
				});

	}

	class CustomerDocumentMapper implements RowMapper<Document> {

		@Override
		public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
			Document document = new Document();
			document.setEnrollmentId(rs.getString("ENROLLMENT_ID"));
			document.setDocumentId(rs.getString("DOCUMENT_ID"));
			document.setDocumentName(rs.getString("DOCUMENT_NAME"));
			document.setDocumentTag(rs.getString("DOCUMENT_TAG"));
			document.setDocumentData(getBinaryData(rs, "DATA")); //FOR IMAGE

			return document;
		}
	}
}
