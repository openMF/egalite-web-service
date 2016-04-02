package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.SmsTemplateDetail;

public class SmsTemplateSyncVO  extends MaintenanceVO<SmsTemplateDetail> {
	
	public SmsTemplateSyncVO() {
		entity = new SmsTemplateDetail();
	}

	public SmsTemplateSyncVO(SmsTemplateDetail entity) {
		super(entity);
	}
	
	public String getTxnCode() {
		return this.entity.getTxnCode();
	}

	public void setTxnCode(String txnCode) {
		this.entity.setTxnCode(txnCode);		
	}

	public String getTxnSms() {
		return this.entity.getTxnSms();
	}

	public void setTxnSms(String txnSms) {
		this.entity.setTxnSms(txnSms);
	}

	public String getDynFields() {
		return this.entity.getDynFields();		
	}

	public void setDynFields(String dynFields) {
		this.entity.setDynFields(dynFields);
	}

}
