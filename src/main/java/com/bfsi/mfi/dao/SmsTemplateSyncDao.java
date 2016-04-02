package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.SmsTemplateDetail;

public interface SmsTemplateSyncDao {
	List<SmsTemplateDetail> getSmsTemplate();
}
