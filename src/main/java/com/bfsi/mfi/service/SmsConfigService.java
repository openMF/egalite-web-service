package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.SmsConfig;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.GroupCodesVO;
import com.bfsi.mfi.vo.MfiMbsTxnReceiverVO;
import com.bfsi.mfi.vo.SmsConfigVO;

public interface SmsConfigService extends
		MaintenanceService<SmsConfigVO, SmsConfig> {
	String deleteSmsConfig(String id) throws ServiceException;

	boolean isTxnCodeAvailable(String txnCode) throws ServiceException;

	List<SmsConfigVO> getAuthorized();
}
