package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.SmsTemplate;

public class SmsTemplateVO extends MaintenanceVO<SmsTemplate>{
	public SmsTemplateVO() {
		entity = new SmsTemplate();
	}

	public SmsTemplateVO(SmsTemplate entity) {
		super(entity);
	}
	
	/*public String getTemplateId() {
		return super.getId();
	}

	public void setTemplateId(String templateId) {
		super.setId(templateId);
	}*/
	
	public String getTxtSms() {
		
		
		
		return entity.getTxtSms();
		
		
	}

	public void setTxtSms(String txtSms) {
	
		entity.setTxtSms(txtSms);
	}

	public String getDynaFields() {
	
		return entity.getDynaFields();
	}

	public void setDynaFields(String dynaFields) {
	
		
		entity.setDynaFields(dynaFields);
	}

	public String getDescription() {
		return entity.getDescription();
	}

	public void setDescription(String description) {
		entity.setDescription(description);
	}
	
	
	public Object clone() {
		SmsTemplateVO copyObj = new SmsTemplateVO();
		copyObj.setId(super.getId());
		copyObj.setTxtSms(getTxtSms());
		copyObj.setDynaFields(getDynaFields());
		copyObj.setDescription(getDescription());
		return copyObj;
	}
	
}
