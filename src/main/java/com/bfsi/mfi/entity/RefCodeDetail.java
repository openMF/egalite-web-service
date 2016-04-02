package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Bablu kumar
 * 
 */
@Entity(name = "MFI_REF_CODE_DETAIL")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RefCodeDetail extends MaintenanceEntity {
	public RefCodeDetail() {
	}

	@Column(name = "REF_DETAIL_CODE", nullable = false)
	private String refDetailCode;
	@Column(name = "DETAIL_CODE_DESC", nullable = false)
	private String detailCodeDesc;
	@Column(name = "TRANS_VALUE_EGA", nullable = false)
	private String transValueEga;
	@Column(name = "TRANS_VALUE_INT", nullable = false)
	private int transValueInt;
	@Column(name = "IS_VALID", nullable = false)
	private String isValid;
	@Column(name = "CODE_SR_NO", nullable = false)
	private int codeSrNo;

private String validRef;
	
	public String getValidRef() {
		return validRef;
	}

	public void setValidRef(String validRef) {
		this.validRef = validRef;
	}

	
	private String validRefdetail;

	public String getValidRefdetail() {
		return validRefdetail;
	}

	public void setValidRefdetail(String validRefdetail) {
		this.validRefdetail = validRefdetail;
	}

	public String getRefMasterCode() {
		return super.getId();
	}

	public void setRefMasterCode(String refMasterCode) {
		super.setId(refMasterCode);
	}

	public String getRefDetailCode() {
		return refDetailCode;
	}

	public void setRefDetailCode(String refDetailCode) {
		this.refDetailCode = refDetailCode;
	}

	public String getDetailCodeDesc() {
		return detailCodeDesc;
	}

	public void setDetailCodeDesc(String detailCodeDesc) {
		this.detailCodeDesc = detailCodeDesc;
	}

	public String getTransValueEga() {
		return transValueEga;
	}

	public void setTransValueEga(String transValueEga) {
		this.transValueEga = transValueEga;
	}

	public int getTransValueInt() {
		return transValueInt;
	}

	public void setTransValueInt(int transValueInt) {
		this.transValueInt = transValueInt;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public int getCodeSrNo() {
		return codeSrNo;
	}

	public void setCodeSrNo(int codeSrNo) {
		this.codeSrNo = codeSrNo;
	}

}
