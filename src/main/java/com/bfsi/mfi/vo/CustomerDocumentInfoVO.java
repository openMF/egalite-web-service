package com.bfsi.mfi.vo;



import com.bfsi.mfi.entity.CustomerDocumentInfo;

/**
 * 
 * @author Shabu
 *
 */
public class CustomerDocumentInfoVO extends MaintenanceVO<CustomerDocumentInfo> {

	public CustomerDocumentInfoVO() {
		entity = new CustomerDocumentInfo();
	}

	public CustomerDocumentInfoVO(CustomerDocumentInfo entity) {
		super(entity);
	}

	public String getEnrolmentId() {
		return entity.getEnrolmentId();
	}

	public void setEnrolmentId(String enrolmentId) {
		entity.setEnrolmentId(enrolmentId);
	}

	public byte[] getKycCustImage() {
		return entity.getKycCustImage();
	}

	public void setKycCustImage(byte[] kycCustImage) {
		entity.setKycCustImage(kycCustImage);
	}

	public byte[] getKycIdImage1() {
		return entity.getKycIdImage1();
	}

	public void setKycIdImage1(byte[] kycIdImage1) {
		entity.setKycIdImage1(kycIdImage1);
	}

	public String getKycIdType1() {
		return entity.getKycIdType1();
	}

	public void setKycIdType1(String kycIdType1) {
		entity.setKycIdType1(kycIdType1);
	}

	public String getKycIdNo1() {
		return entity.getKycIdNo1();
	}

	public void setKycIdNo1(String kycIdNo1) {
		entity.setKycIdNo1(kycIdNo1);
	}

	public String getKycIdProofType1() {
		return entity.getKycIdProofType1();
	}

	public void setKycIdProofType1(String kycIdProofType1) {
		entity.setKycIdProofType1(kycIdProofType1);
	}

	public byte[] getKycIdImage2() {
		return entity.getKycIdImage2();
	}

	public void setKycIdImage2(byte[] kycIdImage2) {
		entity.setKycIdImage2(kycIdImage2);
	}

	public String getKycIdType2() {
		return entity.getKycIdType2();
	}

	public void setKycIdType2(String kycIdType2) {
		entity.setKycIdType2(kycIdType2);
	}

	public String getKycIdNo2() {
		return entity.getKycIdNo2();
	}

	public void setKycIdNo2(String kycIdNo2) {
		entity.setKycIdNo2(kycIdNo2);
	}

	public String getKycIdProofType2() {
		return entity.getKycIdProofType2();
	}

	public void setKycIdProofType2(String kycIdProofType2) {
		entity.setKycIdProofType2(kycIdProofType2);
	}

	public byte[] getKycIdImage3() {
		return entity.getKycIdImage3();
	}

	public void setKycIdImage3(byte[] kycIdImage3) {
		entity.setKycIdImage3(kycIdImage3);
	}

	public String getKycIdType3() {
		return entity.getKycIdType3();
	}

	public void setKycIdType3(String kycIdType3) {
		entity.setKycIdType3(kycIdType3);
	}

	public String getKycIdNo3() {
		return entity.getKycIdNo3();
	}

	public void setKycIdNo3(String kycIdNo3) {
		entity.setKycIdNo3(kycIdNo3);
	}

	public String getKycIdProofType3() {
		return entity.getKycIdProofType3();
	}

	public void setKycIdProofType3(String kycIdProofType3) {
		entity.setKycIdProofType3(kycIdProofType3);
	}

}
