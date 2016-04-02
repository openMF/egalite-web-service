package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.ErrorCodeDao;
import com.bfsi.mfi.entity.ErrorCode;
import com.bfsi.mfi.service.ErrorCodeService;
import com.bfsi.mfi.vo.ErrorCodeVO;

@Service(value = "errorCodeService")
public class ErrorCodeServiceImpl extends MaintenanceServiceImpl<ErrorCodeVO, ErrorCode> implements ErrorCodeService{
	
	@Autowired
	private ErrorCodeDao errorCodeDao;
	
	@SuppressWarnings("unchecked")
	@Override
	protected ErrorCodeDao getMaintenanceDao() {
		return errorCodeDao;
	}

	protected ErrorCode getEntity(ErrorCodeVO vo) {
		return vo.getEntity();
	}
	
	@Override
	protected ErrorCodeVO getValueObject(ErrorCode entity) {
		ErrorCodeVO errcodeVO = new ErrorCodeVO(entity);
		return errcodeVO;
	}
}
