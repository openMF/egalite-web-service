package com.bfsi.mfi.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bfsi.mfi.entity.Document;

public interface DocumentDao extends MaintenanceDao<Document> {

	public void insertDocumentInfo(List<Document> documentList);

	public void updateCustomerDocumentData(byte[] data, String docName,
			String enrollmentId);

	public void insertDocumentInfo(String id, String documentId,
			String documentName, String documentTag);

	List<Document> getCustomerDocuments(String enrollmentId)
			throws DataAccessException;

}
