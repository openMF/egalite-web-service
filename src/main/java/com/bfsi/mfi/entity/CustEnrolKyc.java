package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "MFI_CUST_ENROL_KYC")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustEnrolKyc  extends MaintenanceEntity {
	public CustEnrolKyc() {
	}

	/*ENROLMENT_ID        VARCHAR2(25) not null,// super class id
	 *  KYC_IMAGE_CUSTOMER  BLOB, 
KYC_ID_1_IMAGE BLOB, KYC_ID_1_TYPE VARCHAR2(1),KYC_ID_1_NUMBER  VARCHAR2(50),KYC_ID_1_PROOF_TYPE VARCHAR2(1),
KYC_ID_2_IMAGE  BLOB, KYC_ID_2_TYPE VARCHAR2(1),KYC_ID_2_NUMBER     VARCHAR2(50),KYC_ID_2_PROOF_TYPE VARCHAR2(1),
KYC_ID_3_IMAGE   BLOB,KYC_ID_3_TYPE VARCHAR2(1),KYC_ID_3_NUMBER     VARCHAR2(50),KYC_ID_3_PROOF_TYPE VARCHAR2(1)*/
	
	
	@Column(name = "KYC_IMAGE_CUSTOMER", nullable = false)
	private byte[] kycImageCustomer; //blob
	
	@Column(name = "KYC_ID_1_IMAGE", nullable = false)
	private byte[] kycId1Image; //blob
	@Column(name = "KYC_ID_1_TYPE", nullable = false)
	private String kycId1Type;
	@Column(name = "KYC_ID_1_NUMBER", nullable = false)
	private String kycId1Number;
	@Column(name = "KYC_ID_1_PROOF_TYPE", nullable = false)
	private String kycId1ProofType;
	
	@Column(name = "KYC_ID_2_IMAGE", nullable = false)
	private byte[] kycId2Image; //blob
	@Column(name = "KYC_ID_2_TYPE", nullable = false)
	private String kycId2Type;
	@Column(name = "KYC_ID_2_NUMBER", nullable = false)
	private String kycId2Number;
	@Column(name = "KYC_ID_2_PROOF_TYPE", nullable = false)
	private String kycId2ProofType;
	
	@Column(name = "KYC_ID_3_IMAGE", nullable = false)
	private byte[] kycId3Image; //blob
	@Column(name = "KYC_ID_3_TYPE", nullable = false)
	private String kycId3Type;
	@Column(name = "KYC_ID_3_NUMBER", nullable = false)
	private String kycId3Number;
	@Column(name = "KYC_ID_3_PROOF_TYPE", nullable = false)
	private String kycId3ProofType;
	
	
	public byte[] getKycImageCustomer() {
		return kycImageCustomer;
	}
	public void setKycImageCustomer(byte[] kycImageCustomer) {
		this.kycImageCustomer = kycImageCustomer;
	}
	public byte[] getKycId1Image() {
		return kycId1Image;
	}
	public void setKycId1Image(byte[] kycId1Image) {
		this.kycId1Image = kycId1Image;
	}
	public String getKycId1Type() {
		return kycId1Type;
	}
	public void setKycId1Type(String kycId1Type) {
		this.kycId1Type = kycId1Type;
	}
	public String getKycId1Number() {
		return kycId1Number;
	}
	public void setKycId1Number(String kycId1Number) {
		this.kycId1Number = kycId1Number;
	}
	public String getKycId1ProofType() {
		return kycId1ProofType;
	}
	public void setKycId1ProofType(String kycId1ProofType) {
		this.kycId1ProofType = kycId1ProofType;
	}
	public byte[] getKycId2Image() {
		return kycId2Image;
	}
	public void setKycId2Image(byte[] kycId2Image) {
		this.kycId2Image = kycId2Image;
	}
	public String getKycId2Type() {
		return kycId2Type;
	}
	public void setKycId2Type(String kycId2Type) {
		this.kycId2Type = kycId2Type;
	}
	public String getKycId2Number() {
		return kycId2Number;
	}
	public void setKycId2Number(String kycId2Number) {
		this.kycId2Number = kycId2Number;
	}
	public String getKycId2ProofType() {
		return kycId2ProofType;
	}
	public void setKycId2ProofType(String kycId2ProofType) {
		this.kycId2ProofType = kycId2ProofType;
	}
	public byte[] getKycId3Image() {
		return kycId3Image;
	}
	public void setKycId3Image(byte[] kycId3Image) {
		this.kycId3Image = kycId3Image;
	}
	public String getKycId3Type() {
		return kycId3Type;
	}
	public void setKycId3Type(String kycId3Type) {
		this.kycId3Type = kycId3Type;
	}
	public String getKycId3Number() {
		return kycId3Number;
	}
	public void setKycId3Number(String kycId3Number) {
		this.kycId3Number = kycId3Number;
	}
	public String getKycId3ProofType() {
		return kycId3ProofType;
	}
	public void setKycId3ProofType(String kycId3ProofType) {
		this.kycId3ProofType = kycId3ProofType;
	}

	
	
	
	
}
