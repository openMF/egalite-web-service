package com.bfsi.mfi.vo;


import com.bfsi.mfi.entity.Document;

public class DocumentVO extends MaintenanceVO<Document> {
	public DocumentVO() {
		entity = new Document();
	}

	public DocumentVO(Document entity) {
		super(entity);
	}

	public String getEnrollmentId() {
		return super.getId();
	}

	public void setEnrollmentId(String enrollmentId) {
		super.setId(enrollmentId);
	}

	public String getDocumentId() {
		return entity.getDocumentId();
	}

	public void setDocumentId(String documentId) {
		entity.setDocumentId(documentId);
	}

	public String getDocumentName() {
		return entity.getDocumentName();
	}

	public void setDocumentName(String documentName) {
		entity.setDocumentName(documentName);
	}

	public String getDocumentTag() {
		return entity.getDocumentTag();
	}

	public void setDocumentTag(String documentTag) {
		entity.setDocumentTag(documentTag);
	}

	public byte[] getDocumentData() {
		return entity.getDocumentData();
	}

	public void setDocumentData(byte[] documentData) {
		entity.setDocumentData(documentData);
	}
}
