package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity(name = "MFI_CUST_ENROL_BIOMETRIC")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustEnrolBiometric  extends MaintenanceEntity {
	public CustEnrolBiometric() {
	}

	//ENROLMENT_ID use super id
	/*RHLF_TMPLTDATA RHRF_TMPLTDATA RHMF_TMPLTDATA RHIF_TMPLTDATA RHTF_TMPLTDATA
	LHLF_TMPLTDATA LHRF_TMPLTDATA LHMF_TMPLTDATA LHIF_TMPLTDATA LHTF_TMPLTDATA
	RHLF_IMAGE_SCAN RHRF_IMAGE_SCAN RHMF_IMAGE_SCAN RHIF_IMAGE_SCAN RHTF_IMAGE_SCAN
	LHLF_IMAGE_SCAN LHRF_IMAGE_SCAN LHMF_IMAGE_SCAN LHIF_IMAGE_SCAN LHTF_IMAGE_SCAN*/
	
	@Column(name = "RHLF_TMPLTDATA", nullable = false)
	private byte[] rhlfTepltdata;  //blob
	@Column(name = "RHRF_TMPLTDATA", nullable = false)
	private byte[] rhrfTemltdata; 
	@Column(name = "RHMF_TMPLTDATA", nullable = false)
	private byte[] rhmfTemltdata; 
	@Column(name = "RHIF_TMPLTDATA", nullable = false)
	private byte[] rhifTmpltdata;
	@Column(name = "RHTF_TMPLTDATA", nullable = false)
	private byte[] rhtfTmpltdata; 
	
	@Column(name = "LHLF_TMPLTDATA", nullable = false)
	private byte[] lhlfTmpldata; 
	@Column(name = "LHRF_TMPLTDATA", nullable = false)
	private byte[] lhrfTmpltdata; 
	@Column(name = "LHMF_TMPLTDATA", nullable = false)
	private byte[] lhmfTmpltdata; 
	@Column(name = "LHIF_TMPLTDATA", nullable = false)
	private byte[] lhifTmpltdata;
	@Column(name = "LHTF_TMPLTDATA", nullable = false)
	private byte[] lhtfTmpltdata; 
	
	
	@Column(name = "RHLF_IMAGE_SCAN", nullable = false)
	private byte[] rhlfImageScan;
	@Column(name = "RHRF_IMAGE_SCAN", nullable = false)
	private byte[] rhrfImageScan; 
	@Column(name = "RHMF_IMAGE_SCAN", nullable = false)
	private byte[] rhmfImageScan; 
	@Column(name = "RHIF_IMAGE_SCAN", nullable = false)
	private byte[] rhifImageScan; 
	@Column(name = "RHTF_IMAGE_SCAN", nullable = false)
	private byte[] rhtfImageScan; 
	
	
	@Column(name = "LHLF_IMAGE_SCAN", nullable = false)
	private byte[] lhlfImaageScan; 
	@Column(name = "LHRF_IMAGE_SCAN", nullable = false)
	private byte[] lhrfImageScan;
	@Column(name = "LHMF_IMAGE_SCAN", nullable = false)
	private byte[] lhmfImageScan;
	@Column(name = "LHIF_IMAGE_SCAN", nullable = false)
	private byte[] lhifImageScan; 
	@Column(name = "LHTF_IMAGE_SCAN", nullable = false)
	private byte[] lhtfImageScan;
	
	
	public byte[] getRhlfTepltdata() {
		return rhlfTepltdata;
	}
	public void setRhlfTepltdata(byte[] rhlfTepltdata) {
		this.rhlfTepltdata = rhlfTepltdata;
	}
	public byte[] getRhrfTemltdata() {
		return rhrfTemltdata;
	}
	public void setRhrfTemltdata(byte[] rhrfTemltdata) {
		this.rhrfTemltdata = rhrfTemltdata;
	}
	public byte[] getRhmfTemltdata() {
		return rhmfTemltdata;
	}
	public void setRhmfTemltdata(byte[] rhmfTemltdata) {
		this.rhmfTemltdata = rhmfTemltdata;
	}
	public byte[] getRhifTmpltdata() {
		return rhifTmpltdata;
	}
	public void setRhifTmpltdata(byte[] rhifTmpltdata) {
		this.rhifTmpltdata = rhifTmpltdata;
	}
	public byte[] getRhtfTmpltdata() {
		return rhtfTmpltdata;
	}
	public void setRhtfTmpltdata(byte[] rhtfTmpltdata) {
		this.rhtfTmpltdata = rhtfTmpltdata;
	}
	public byte[] getLhlfTmpldata() {
		return lhlfTmpldata;
	}
	public void setLhlfTmpldata(byte[] lhlfTmpldata) {
		this.lhlfTmpldata = lhlfTmpldata;
	}
	public byte[] getLhrfTmpltdata() {
		return lhrfTmpltdata;
	}
	public void setLhrfTmpltdata(byte[] lhrfTmpltdata) {
		this.lhrfTmpltdata = lhrfTmpltdata;
	}
	public byte[] getLhmfTmpltdata() {
		return lhmfTmpltdata;
	}
	public void setLhmfTmpltdata(byte[] lhmfTmpltdata) {
		this.lhmfTmpltdata = lhmfTmpltdata;
	}
	public byte[] getLhifTmpltdata() {
		return lhifTmpltdata;
	}
	public void setLhifTmpltdata(byte[] lhifTmpltdata) {
		this.lhifTmpltdata = lhifTmpltdata;
	}
	public byte[] getLhtfTmpltdata() {
		return lhtfTmpltdata;
	}
	public void setLhtfTmpltdata(byte[] lhtfTmpltdata) {
		this.lhtfTmpltdata = lhtfTmpltdata;
	}
	public byte[] getRhlfImageScan() {
		return rhlfImageScan;
	}
	public void setRhlfImageScan(byte[] rhlfImageScan) {
		this.rhlfImageScan = rhlfImageScan;
	}
	public byte[] getRhrfImageScan() {
		return rhrfImageScan;
	}
	public void setRhrfImageScan(byte[] rhrfImageScan) {
		this.rhrfImageScan = rhrfImageScan;
	}
	public byte[] getRhmfImageScan() {
		return rhmfImageScan;
	}
	public void setRhmfImageScan(byte[] rhmfImageScan) {
		this.rhmfImageScan = rhmfImageScan;
	}
	public byte[] getRhifImageScan() {
		return rhifImageScan;
	}
	public void setRhifImageScan(byte[] rhifImageScan) {
		this.rhifImageScan = rhifImageScan;
	}
	public byte[] getRhtfImageScan() {
		return rhtfImageScan;
	}
	public void setRhtfImageScan(byte[] rhtfImageScan) {
		this.rhtfImageScan = rhtfImageScan;
	}
	public byte[] getLhlfImaageScan() {
		return lhlfImaageScan;
	}
	public void setLhlfImaageScan(byte[] lhlfImaageScan) {
		this.lhlfImaageScan = lhlfImaageScan;
	}
	public byte[] getLhrfImageScan() {
		return lhrfImageScan;
	}
	public void setLhrfImageScan(byte[] lhrfImageScan) {
		this.lhrfImageScan = lhrfImageScan;
	}
	public byte[] getLhmfImageScan() {
		return lhmfImageScan;
	}
	public void setLhmfImageScan(byte[] lhmfImageScan) {
		this.lhmfImageScan = lhmfImageScan;
	}
	public byte[] getLhifImageScan() {
		return lhifImageScan;
	}
	public void setLhifImageScan(byte[] lhifImageScan) {
		this.lhifImageScan = lhifImageScan;
	}
	public byte[] getLhtfImageScan() {
		return lhtfImageScan;
	}
	public void setLhtfImageScan(byte[] lhtfImageScan) {
		this.lhtfImageScan = lhtfImageScan;
	} 
	
	
}
