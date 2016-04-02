package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.CustomerBiometricInfo;

/**
 * 
 * @author Vishal
 *
 */
public class CustomerBiometricInfoVO extends
MaintenanceVO<CustomerBiometricInfo> {
	
	public CustomerBiometricInfoVO() {
		this.entity = new CustomerBiometricInfo();
	}

	public CustomerBiometricInfoVO(CustomerBiometricInfo entity) {
		super(entity);
	}
	
	
	public byte[] getRhlfScanData() {
		return entity.getRhlfScanData();
	}
	public void setRhlfScanData(byte[] rhlfScanData) {
		entity.setRhlfScanData(rhlfScanData);
	}
	public byte[] getRhrfScanData() {
		return entity.getRhrfScanData();
	}
	public void setRhrfScanData(byte[] rhrfScanData) {
		entity.setRhrfScanData(rhrfScanData);
	}
	public byte[] getRhmfScanData() {
		return entity.getRhmfScanData();
	}
	public void setRhmfScanData(byte[] rhmfScanData) {
		entity.setRhmfScanData(rhmfScanData);
	}
	public byte[] getRhifScanData() {
		return entity.getRhifScanData();
	}
	public void setRhifScanData(byte[] rhifScanData) {
		entity.setRhifScanData(rhifScanData);
	}
	public byte[] getRhtfScanData() {
		return entity.getRhtfScanData();
	}
	public void setRhtfScanData(byte[] rhtfScanData) {
		entity.setRhtfScanData(rhtfScanData);
	}
	public byte[] getLhlfScanData() {
		return entity.getLhlfScanData();
	}
	public void setLhlfScanData(byte[] lhlfScanData) {
		entity.setLhlfScanData(lhlfScanData);
	}
	public byte[] getLhrfScanData() {
		return entity.getLhrfScanData();
	}
	public void setLhrfScanData(byte[] lhrfScanData) {
		entity.setLhrfScanData(lhrfScanData);
	}
	public byte[] getLhmfScanData() {
		return entity.getLhmfScanData();
	}
	public void setLhmfScanData(byte[] lhmfScanData) {
		entity.setLhmfScanData(lhmfScanData);
	}
	public byte[] getLhifScanData() {
		return entity.getLhifScanData();
	}
	public void setLhifScanData(byte[] lhifScanData) {
		entity.setLhifScanData(lhifScanData);
	}
	public byte[] getLhtfScanData() {
		return entity.getLhtfScanData();
	}
	public void setLhtfScanData(byte[] lhtfScanData) {
		entity.setLhtfScanData(lhtfScanData);
	}
	
	public String getEnrolmentId() {
		return this.entity.getEnrolmentId();
	}

	public void setEnrolmentId(String enrolmentId) {
		this.entity.setEnrolmentId(enrolmentId);
	}

	public byte[] getRhlfTmpltData() {
		return this.entity.getRhlfTmpltData();
	}

	public void setRhlfTmpltData(byte[] rhlfTmpltData) {
		this.entity.setRhlfTmpltData(rhlfTmpltData);
	}

	public byte[] getRhrfTmpltData() {
		return this.entity.getRhrfTmpltData();
	}

	public void setRhrfTmpltData(byte[] rhrfTmpltData) {
		this.entity.setRhrfTmpltData(rhrfTmpltData);
	}

	public byte[] getRhmfTmpltData() {
		return this.entity.getRhmfTmpltData();
	}

	public void setRhmfTmpltData(byte[] rhmfTmpltData) {
		this.entity.setRhmfTmpltData(rhmfTmpltData);
	}

	public byte[] getRhifTmpltData() {
		return this.entity.getRhifTmpltData();
	}

	public void setRhifTmpltData(byte[] rhifTmpltData) {
		this.entity.setRhifTmpltData(rhifTmpltData);
	}

	public byte[] getRhtfTmpltData() {
		return this.entity.getRhlfTmpltData();
	}

	public void setRhtfTmpltData(byte[] rhtfTmpltData) {
		this.entity.setRhtfTmpltData(rhtfTmpltData);
	}

	public byte[] getLhlfTmpltData() {
		return this.entity.getLhlfTmpltData();
	}

	public void setLhlfTmpltData(byte[] lhlfTmpltData) {
		this.entity.setLhlfTmpltData(lhlfTmpltData);
	}

	public byte[] getLhrfTmpltData() {
		return this.entity.getLhrfTmpltData();
	}

	public void setLhrfTmpltData(byte[] lhrfTmpltData) {
		this.entity.setLhrfTmpltData(lhrfTmpltData);
	}

	public byte[] getLhmfTmpltData() {
		return this.entity.getLhmfTmpltData();
	}

	public void setLhmfTmpltData(byte[] lhmfTmpltData) {
		this.entity.setLhmfTmpltData(lhmfTmpltData);
	}

	public byte[] getLhifTmpltData() {
		return this.entity.getLhifTmpltData();
	}

	public void setLhifTmpltData(byte[] lhifTmpltData) {
		this.entity.setLhifTmpltData(lhifTmpltData);
	}

	public byte[] getLhtfTmpltData() {
		return this.entity.getLhtfTmpltData();
	}

	public void setLhtfTmpltData(byte[] lhtfTmpltData) {
		this.entity.setLhtfTmpltData(lhtfTmpltData);
	}
}
