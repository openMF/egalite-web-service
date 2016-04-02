package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.SmsTemplateSyncDao;
import com.bfsi.mfi.entity.SmsTemplateDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.SmsTemplateSyncService;
import com.bfsi.mfi.vo.SmsTemplateSyncVO;

/**
 * 
 * @author Vishal
 *
 */
@Service(value = "smsTemplateSyncService")
public class SmsTemplateSyncServiceImpl implements SmsTemplateSyncService {
	
	@Autowired
	SmsTemplateSyncDao smsTemplateSyncDao;
	
	@Override
	public List<SmsTemplateSyncVO> getSmsTemplate() {
		List<SmsTemplateSyncVO> l_smsTempVoList = new ArrayList<SmsTemplateSyncVO>(); 
		List<SmsTemplateDetail> l_smsTempList = new ArrayList<SmsTemplateDetail>();
		SmsTemplateSyncVO l_smsTempVo = null;
		try {
			l_smsTempList = smsTemplateSyncDao.getSmsTemplate();
			if(!l_smsTempList.isEmpty()){
				for(SmsTemplateDetail l_smsTempDetail : l_smsTempList){
					l_smsTempVo = new SmsTemplateSyncVO();
					BeanUtils.copyProperties(l_smsTempDetail, l_smsTempVo);
					l_smsTempVoList.add(l_smsTempVo);
				}
			}
		}catch(ServiceException e){
			throw new ServiceException("ServiceException while getting list of Sms Template:MFI10001", e);
		}		
		return l_smsTempVoList;
	}

}
