package com.bfsi.mfi.entity;

public class Document extends MaintenanceEntity {
	private String documentId;
	private String documentName;
	private byte[] documentData;
	private String documentTag;

	public byte[] getDocumentData() {
		return documentData;
	}

	public void setDocumentData(byte[] documentData) {
		this.documentData = documentData;
	}

	public String getEnrollmentId() {
		return super.getId();
	}

	public void setEnrollmentId(String enrollmentId) {
		super.setId(enrollmentId);
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentTag() {
		return documentTag;
	}

	public void setDocumentTag(String documentTag) {
		this.documentTag = documentTag;
	}

}
