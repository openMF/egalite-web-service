package com.bfsi.mfi.vo;

import org.primefaces.model.DefaultStreamedContent;

import com.bfsi.mfi.entity.CustEnrolBiometric;

public class CustEnrolBiometricVO extends MaintenanceVO<CustEnrolBiometric>{
	public CustEnrolBiometricVO() {
		entity = new CustEnrolBiometric();
	}

	public CustEnrolBiometricVO(CustEnrolBiometric entity) {
		super(entity);
	}

	private DefaultStreamedContent rhlfTempltImage;
	private DefaultStreamedContent rhrfTempltImage;
	private DefaultStreamedContent rhmfTempltImage; //rhmfTemltdata
	private DefaultStreamedContent rhifTempltImage; //rhifTmpltdata
	private DefaultStreamedContent rhtfTempltImage; //rhtfTmpltdata
	
	private DefaultStreamedContent lhlfTempltImage;
	private DefaultStreamedContent lhrfTempltImage;
	private DefaultStreamedContent lhmfTempltImage; 
	private DefaultStreamedContent lhifTempltImage; 
	private DefaultStreamedContent lhtfTempltImage;
	
	private DefaultStreamedContent rhlfImageScanImage; //rhlfImageScan
	private DefaultStreamedContent rhrfImageScanImage;
	private DefaultStreamedContent rhmfImageScanImage;
	private DefaultStreamedContent rhifImageScanImage;
	private DefaultStreamedContent rhtfImageScanImage;
	
	private DefaultStreamedContent lhlfImageScanImage; //lhlfImageScan
	private DefaultStreamedContent lhrfImageScanImage;
	private DefaultStreamedContent lhmfImageScanImage;
	private DefaultStreamedContent lhifImageScanImage;
	private DefaultStreamedContent lhtfImageScanImage;
	
	
	
	public DefaultStreamedContent getRhlfTempltImage() {
		return rhlfTempltImage;
	}

	public void setRhlfTempltImage(DefaultStreamedContent rhlfTempltImage) {
		this.rhlfTempltImage = rhlfTempltImage;
	}

	public DefaultStreamedContent getRhrfTempltImage() {
		return rhrfTempltImage;
	}

	public void setRhrfTempltImage(DefaultStreamedContent rhrfTempltImage) {
		this.rhrfTempltImage = rhrfTempltImage;
	}

	public DefaultStreamedContent getRhmfTempltImage() {
		return rhmfTempltImage;
	}

	public void setRhmfTempltImage(DefaultStreamedContent rhmfTempltImage) {
		this.rhmfTempltImage = rhmfTempltImage;
	}

	public DefaultStreamedContent getRhifTempltImage() {
		return rhifTempltImage;
	}

	public void setRhifTempltImage(DefaultStreamedContent rhifTempltImage) {
		this.rhifTempltImage = rhifTempltImage;
	}

	public DefaultStreamedContent getRhtfTempltImage() {
		return rhtfTempltImage;
	}

	public void setRhtfTempltImage(DefaultStreamedContent rhtfTempltImage) {
		this.rhtfTempltImage = rhtfTempltImage;
	}

	public DefaultStreamedContent getLhlfTempltImage() {
		return lhlfTempltImage;
	}

	public void setLhlfTempltImage(DefaultStreamedContent lhlfTempltImage) {
		this.lhlfTempltImage = lhlfTempltImage;
	}

	public DefaultStreamedContent getLhrfTempltImage() {
		return lhrfTempltImage;
	}

	public void setLhrfTempltImage(DefaultStreamedContent lhrfTempltImage) {
		this.lhrfTempltImage = lhrfTempltImage;
	}

	public DefaultStreamedContent getLhmfTempltImage() {
		return lhmfTempltImage;
	}

	public void setLhmfTempltImage(DefaultStreamedContent lhmfTempltImage) {
		this.lhmfTempltImage = lhmfTempltImage;
	}

	public DefaultStreamedContent getLhifTempltImage() {
		return lhifTempltImage;
	}

	public void setLhifTempltImage(DefaultStreamedContent lhifTempltImage) {
		this.lhifTempltImage = lhifTempltImage;
	}

	public DefaultStreamedContent getLhtfTempltImage() {
		return lhtfTempltImage;
	}

	public void setLhtfTempltImage(DefaultStreamedContent lhtfTempltImage) {
		this.lhtfTempltImage = lhtfTempltImage;
	}

	public DefaultStreamedContent getRhlfImageScanImage() {
		return rhlfImageScanImage;
	}

	public void setRhlfImageScanImage(DefaultStreamedContent rhlfImageScanImage) {
		this.rhlfImageScanImage = rhlfImageScanImage;
	}

	public DefaultStreamedContent getRhrfImageScanImage() {
		return rhrfImageScanImage;
	}

	public void setRhrfImageScanImage(DefaultStreamedContent rhrfImageScanImage) {
		this.rhrfImageScanImage = rhrfImageScanImage;
	}

	public DefaultStreamedContent getRhmfImageScanImage() {
		return rhmfImageScanImage;
	}

	public void setRhmfImageScanImage(DefaultStreamedContent rhmfImageScanImage) {
		this.rhmfImageScanImage = rhmfImageScanImage;
	}

	public DefaultStreamedContent getRhifImageScanImage() {
		return rhifImageScanImage;
	}

	public void setRhifImageScanImage(DefaultStreamedContent rhifImageScanImage) {
		this.rhifImageScanImage = rhifImageScanImage;
	}

	public DefaultStreamedContent getRhtfImageScanImage() {
		return rhtfImageScanImage;
	}

	public void setRhtfImageScanImage(DefaultStreamedContent rhtfImageScanImage) {
		this.rhtfImageScanImage = rhtfImageScanImage;
	}

	public DefaultStreamedContent getLhlfImageScanImage() {
		return lhlfImageScanImage;
	}

	public void setLhlfImageScanImage(DefaultStreamedContent lhlfImageScanImage) {
		this.lhlfImageScanImage = lhlfImageScanImage;
	}

	public DefaultStreamedContent getLhrfImageScanImage() {
		return lhrfImageScanImage;
	}

	public void setLhrfImageScanImage(DefaultStreamedContent lhrfImageScanImage) {
		this.lhrfImageScanImage = lhrfImageScanImage;
	}

	public DefaultStreamedContent getLhmfImageScanImage() {
		return lhmfImageScanImage;
	}

	public void setLhmfImageScanImage(DefaultStreamedContent lhmfImageScanImage) {
		this.lhmfImageScanImage = lhmfImageScanImage;
	}

	public DefaultStreamedContent getLhifImageScanImage() {
		return lhifImageScanImage;
	}

	public void setLhifImageScanImage(DefaultStreamedContent lhifImageScanImage) {
		this.lhifImageScanImage = lhifImageScanImage;
	}

	public DefaultStreamedContent getLhtfImageScanImage() {
		return lhtfImageScanImage;
	}

	public void setLhtfImageScanImage(DefaultStreamedContent lhtfImageScanImage) {
		this.lhtfImageScanImage = lhtfImageScanImage;
	}

	public byte[] getRhlfTepltdata() {
		return  entity.getRhlfTepltdata();
	}
	public void setRhlfTepltdata(byte[] rhlfTepltdata) {
		entity.setRhlfTepltdata(rhlfTepltdata); 
	}
	public byte[] getRhrfTemltdata() {
		return  entity.getRhrfTemltdata();
	}
	public void setRhrfTemltdata(byte[] rhrfTemltdata) {
		entity.setRhrfTemltdata(rhrfTemltdata);
	}
	public byte[] getRhmfTemltdata() {
		return  entity.getRhmfTemltdata();
	}
	public void setRhmfTemltdata(byte[] rhmfTemltdata) {
		entity.setRhmfTemltdata(rhmfTemltdata);
	}
	public byte[] getRhifTmpltdata() {
		return  entity.getRhifTmpltdata();
	}
	public void setRhifTmpltdata(byte[] rhifTmpltdata) {
		entity.setRhifTmpltdata(rhifTmpltdata);
	}
	public byte[] getRhtfTmpltdata() {
		return  entity.getRhtfTmpltdata();
	}
	public void setRhtfTmpltdata(byte[] rhtfTmpltdata) {
		entity.setRhtfTmpltdata(rhtfTmpltdata); 
	}
	public byte[] getLhlfTmpldata() {
		return  entity.getLhlfTmpldata();
	}
	public void setLhlfTmpldata(byte[] lhlfTmpldata) {
		entity.setLhlfTmpldata(lhlfTmpldata); 
	}
	public byte[] getLhrfTmpltdata() {
		return  entity.getLhrfTmpltdata();
	}
	public void setLhrfTmpltdata(byte[] lhrfTmpltdata) {
		entity.setLhrfTmpltdata(lhrfTmpltdata);
	}
	public byte[] getLhmfTmpltdata() {
		return  entity.getLhmfTmpltdata();
	}
	public void setLhmfTmpltdata(byte[] lhmfTmpltdata) {
		entity.setLhmfTmpltdata(lhmfTmpltdata);
	}
	public byte[] getLhifTmpltdata() {
		return  entity.getLhifTmpltdata();
	}
	public void setLhifTmpltdata(byte[] lhifTmpltdata) {
		entity.setLhifTmpltdata(lhifTmpltdata);
	}
	public byte[] getLhtfTmpltdata() {
		return  entity.getLhtfTmpltdata();
	}
	public void setLhtfTmpltdata(byte[] lhtfTmpltdata) {
		entity.setLhtfTmpltdata(lhtfTmpltdata);
	}
	public byte[] getRhlfImageScan() {
		return  entity.getRhlfImageScan();
	}
	public void setRhlfImageScan(byte[] rhlfImageScan) {
		entity.setRhlfImageScan(rhlfImageScan); 
	}
	public byte[] getRhrfImageScan() {
		return  entity.getRhrfImageScan();
	}
	public void setRhrfImageScan(byte[] rhrfImageScan) {
		entity.setRhrfImageScan(rhrfImageScan);
	}
	public byte[] getRhmfImageScan() {
		return  entity.getRhmfImageScan();
	}
	public void setRhmfImageScan(byte[] rhmfImageScan) {
		entity.setRhmfImageScan(rhmfImageScan);
	}
	public byte[] getRhifImageScan() {
		return  entity.getRhifImageScan();
	}
	public void setRhifImageScan(byte[] rhifImageScan) {
		entity.setRhifImageScan(rhifImageScan); 
	}
	public byte[] getRhtfImageScan() {
		return  entity.getRhtfImageScan();
	}
	public void setRhtfImageScan(byte[] rhtfImageScan) {
		entity.setRhtfImageScan(rhtfImageScan);
	}
	public byte[] getLhlfImaageScan() {
		return  entity.getLhlfImaageScan();
	}
	public void setLhlfImaageScan(byte[] lhlfImaageScan) {
		entity.setLhlfImaageScan(lhlfImaageScan); 
	}
	public byte[] getLhrfImageScan() {
		return  entity.getLhrfImageScan();
	}
	public void setLhrfImageScan(byte[] lhrfImageScan) {
		entity.setLhrfImageScan(lhrfImageScan);
	}
	public byte[] getLhmfImageScan() {
		return  entity.getLhmfImageScan();
	}
	public void setLhmfImageScan(byte[] lhmfImageScan) {
		entity.setLhmfImageScan(lhmfImageScan);
	}
	public byte[] getLhifImageScan() {
		return  entity.getLhifImageScan();
	}
	public void setLhifImageScan(byte[] lhifImageScan) {
		entity.setLhifImageScan(lhifImageScan);
	}
	public byte[] getLhtfImageScan() {
		return  entity.getLhtfImageScan();
	}
	public void setLhtfImageScan(byte[] lhtfImageScan) {
		entity.setLhtfImageScan(lhtfImageScan);
	} 
	
	
	public Object clone() {
		CustEnrolBiometricVO copyObj = new CustEnrolBiometricVO();
		
		copyObj.setId(getId());
		copyObj.setRhlfTepltdata(getRhlfTepltdata());
		copyObj.setRhrfTemltdata(getRhrfTemltdata());
		copyObj.setRhmfTemltdata(getRhmfTemltdata());
		copyObj.setRhifTmpltdata(getRhifTmpltdata());
		copyObj.setRhtfTmpltdata(getRhtfTmpltdata());
		
		copyObj.setLhlfTmpldata(getLhlfTmpldata());
		copyObj.setLhrfTmpltdata(getLhrfTmpltdata());
		copyObj.setLhmfTmpltdata(getLhmfTmpltdata());
		copyObj.setLhifTmpltdata(getLhifTmpltdata());
		copyObj.setLhtfTmpltdata(getLhtfTmpltdata());
		
		copyObj.setRhlfImageScan(getRhlfImageScan());
		copyObj.setRhrfImageScan(getRhrfImageScan());
		copyObj.setRhmfImageScan(getRhmfImageScan());
		copyObj.setRhifImageScan(getRhifImageScan());
		copyObj.setRhtfImageScan(getRhtfImageScan());
		
		copyObj.setLhlfImaageScan(getLhlfImaageScan());
		copyObj.setLhrfImageScan(getLhrfImageScan());
		copyObj.setLhmfImageScan(getLhmfImageScan());
		copyObj.setLhifImageScan(getLhifImageScan());
		copyObj.setLhtfImageScan(getLhtfImageScan());
		
		return copyObj;
	}
	
}
