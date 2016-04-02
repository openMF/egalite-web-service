package com.bfsi.mfi.vo;

import org.primefaces.model.DefaultStreamedContent;

import com.bfsi.mfi.entity.CustEnrolKyc;

public class CustEnrolKycVO extends MaintenanceVO<CustEnrolKyc>{

	public CustEnrolKycVO() {
		entity = new CustEnrolKyc();
	}

	public CustEnrolKycVO(CustEnrolKyc entity) {
		super(entity);
	}

	private DefaultStreamedContent customerImage;
	private DefaultStreamedContent streamImage1;
	private DefaultStreamedContent streamImage2;
	private DefaultStreamedContent streamImage3;
	
	public DefaultStreamedContent getCustomerImage() {
		return customerImage;
	}

	public void setCustomerImage(DefaultStreamedContent customerImage) {
		this.customerImage = customerImage;
	}

	public DefaultStreamedContent getStreamImage1() {
		return streamImage1;
	}

	public void setStreamImage1(DefaultStreamedContent streamImage1) {
		this.streamImage1 = streamImage1;
	}

	public DefaultStreamedContent getStreamImage2() {
		return streamImage2;
	}

	public void setStreamImage2(DefaultStreamedContent streamImage2) {
		this.streamImage2 = streamImage2;
	}

	public DefaultStreamedContent getStreamImage3() {
		return streamImage3;
	}

	public void setStreamImage3(DefaultStreamedContent streamImage3) {
		this.streamImage3 = streamImage3;
	}

	

	public byte[] getKycImageCustomer() {
		return entity.getKycImageCustomer();
	}
	public void setKycImageCustomer(byte[] kycImageCustomer) {
		entity.setKycImageCustomer(kycImageCustomer); 
	}
	
	public byte[] getKycId1Image() {
		return entity.getKycId1Image();
	}
	public void setKycId1Image(byte[] kycId1Image) {
		entity.setKycId1Image(kycId1Image); 
	}
	
	public String getKycId1Type() {
		return entity.getKycId1Type();
	}
	public void setKycId1Type(String kycId1Type) {
		entity.setKycId1Type(kycId1Type); 
	}
	
	public String getKycId1Number() {
		return entity.getKycId1Number();
	}
	public void setKycId1Number(String kycId1Number) {
		entity.setKycId1Number(kycId1Number); 
	}
	public String getKycId1ProofType() {
		return entity.getKycId1ProofType();
	}
	public void setKycId1ProofType(String kycId1ProofType) {
		entity.setKycId1ProofType(kycId1ProofType); 
	}
	public byte[] getKycId2Image() {
		return entity.getKycId2Image();
	}
	public void setKycId2Image(byte[] kycId2Image) {
		entity.setKycId2Image(kycId2Image); 
	}
	public String getKycId2Type() {
		return entity.getKycId2Type();
	}
	public void setKycId2Type(String kycId2Type) {
		entity.setKycId2Type(kycId2Type); 
	}
	public String getKycId2Number() {
		return entity.getKycId2Number();
	}
	public void setKycId2Number(String kycId2Number) {
		entity.setKycId2Number(kycId2Number); 
	}
	public String getKycId2ProofType() {
		return entity.getKycId2ProofType();
	}
	public void setKycId2ProofType(String kycId2ProofType) {
		entity.setKycId2ProofType(kycId2ProofType);
	}
	public byte[] getKycId3Image() {
		return entity.getKycId3Image();
	}
	public void setKycId3Image(byte[] kycId3Image) {
		entity.setKycId3Image(kycId3Image); 
	}
	public String getKycId3Type() {
		return entity.getKycId3Type();
	}
	public void setKycId3Type(String kycId3Type) {
		entity.setKycId3Type(kycId3Type); 
	}
	public String getKycId3Number() {
		return entity.getKycId3Number();
	}
	public void setKycId3Number(String kycId3Number) {
		entity.setKycId3Number(kycId3Number); 
	}
	public String getKycId3ProofType() {
		return entity.getKycId3ProofType();
	}
	public void setKycId3ProofType(String kycId3ProofType) {
		entity.setKycId3ProofType(kycId3ProofType); 
	}


	public Object clone() {
		CustEnrolKycVO copyObj = new CustEnrolKycVO();
		copyObj.setId(getId());
		copyObj.setKycImageCustomer(getKycImageCustomer());
		
		copyObj.setKycId1Image(getKycId1Image());
		copyObj.setKycId1Type(getKycId1Type());
		copyObj.setKycId1Number(getKycId1Number());
		copyObj.setKycId1ProofType(getKycId1ProofType());
		
		copyObj.setKycId2Image(getKycId2Image());
		copyObj.setKycId2Type(getKycId2Type());
		copyObj.setKycId2Number(getKycId2Number());
		copyObj.setKycId2ProofType(getKycId2ProofType());
		
		copyObj.setKycId3Image(getKycId3Image());
		copyObj.setKycId3Type(getKycId3Type());
		copyObj.setKycId3Number(getKycId3Number());
		copyObj.setKycId3ProofType(getKycId3ProofType());
		
		
		
		return copyObj;
	}
	
}
