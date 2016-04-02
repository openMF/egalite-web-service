package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@Entity(name = "MFI_SMS_TEMPLATE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SmsTemplate extends MaintenanceEntity {
/*	@Column(name = "TEMPLATE_ID", nullable = false)
	private String templateId;*/
	@Column(name = "TXT_SMS", nullable = false)
	private String txtSms;
	@Column(name = "DYNAMIC_FIELDS", nullable = false)
	private String dynaFields;
    @Column(name = "DESCRIPTION", nullable = false)
	private String description;

	public SmsTemplate() {
	}

/*	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}*/

	public String getTxtSms() {
		//System.out.println("+++++++++"+txtSms);
		return txtSms;
	}

	public void setTxtSms(String txtSms) {
	
		this.txtSms = txtSms;
	}

	public String getDynaFields() {

		return dynaFields;
	}

	public void setDynaFields(String dynaFields) {

		this.dynaFields = dynaFields;
	}

	public String getDescription() {

		
		return description;
	}

	public void setDescription(String description) {
	
		this.description = description;
	}

}
