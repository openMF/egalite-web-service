package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.RefCode;
import com.bfsi.mfi.vo.RefCodeVO;

/**
 * @author Bablu kumar
 * 
 */
public interface ReferenceCodeService extends MaintenanceService<RefCodeVO, RefCode> {
	List<RefCodeVO> getAuthorized();
}
