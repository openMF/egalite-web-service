package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.SmsConfigDao;
import com.bfsi.mfi.entity.SmsConfig;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.SmsConfigService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.SmsConfigVO;

@Service(value = "smsConfigService")
public class SmsConfigServiceImpl extends
		MaintenanceServiceImpl<SmsConfigVO, SmsConfig> implements
		SmsConfigService {

	@Autowired
	private SmsConfigDao smsConfigDao;

	@SuppressWarnings("unchecked")
	@Override
	protected SmsConfigDao getMaintenanceDao() {
		return smsConfigDao;
	}

	@Override
	protected SmsConfig getEntity(SmsConfigVO vo) {
		return vo.getEntity();
	}

	@Override
	protected SmsConfigVO getValueObject(SmsConfig entity) {
		SmsConfigVO smsConfigVO = new SmsConfigVO(entity);
		return smsConfigVO;
	}

	@Override
	public boolean isTxnCodeAvailable(String txnCode) throws ServiceException {
		try {
			LoggerUtil.ibsJobDebug("Calling DAO  for availability of TxnCode: "
					+ txnCode);
			return smsConfigDao.isTxnCodeAvailable(txnCode);
		} catch (DataAccessException e) {
			throw new ServiceException(
					"Error while checking availability of TxnCode: " + txnCode,
					e);
		}
	}

	@Override
	public List<SmsConfigVO> getAuthorized() {
		List<SmsConfig> smsConfig = smsConfigDao.getAuthorized();
		if (smsConfig != null) {
			List<SmsConfigVO> smsConfigsVO = new ArrayList<SmsConfigVO>(
					smsConfig.size());
			for (SmsConfig lov : smsConfig) {
				SmsConfigVO smsConfigVO = new SmsConfigVO();
				BeanUtils.copyProperties(lov, smsConfigVO);
				smsConfigsVO.add(smsConfigVO);
			}
			return smsConfigsVO;
		} else {
			return new ArrayList<SmsConfigVO>();
		}
	}

	// For Delete Operation
	@Override
	public String deleteSmsConfig(String id) throws ServiceException {
		String success;
		try {
			success = smsConfigDao.deleteSmsConfig(id);
		} catch (DataAccessException e) {
			throw new ServiceException(
					"Error while deleting Sms Config details: ", e);
		}
		return success;
	}

}
