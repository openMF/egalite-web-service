package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.ReferenceCodeDao;
import com.bfsi.mfi.entity.RefCode;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ReferenceCodeService;
import com.bfsi.mfi.vo.RefCodeVO;

/**
 * @author Bablu kumar
 *
 */
@Service(value = "refcodeService")
public class ReferenceCodeServiceImpl extends MaintenanceServiceImpl<RefCodeVO, RefCode>
		implements ReferenceCodeService {

	@Autowired
	private ReferenceCodeDao referenceCodeDao;

	@Override
	public RefCodeVO update(RefCodeVO vo) throws ServiceException {
		vo.setAuthStatus("U");
		try {
			return super.update(vo);
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while updating auth status", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ReferenceCodeDao getMaintenanceDao() {
		return referenceCodeDao;
	}

	protected RefCode getEntity(RefCodeVO vo) {
		return vo.getEntity();
	}

	@Override
	protected RefCodeVO getValueObject(RefCode entity) {
		RefCodeVO refCodeVO = new RefCodeVO(entity);
		return refCodeVO;
	}


	
	@Override
	public List<RefCodeVO> getAuthorized() {
		List<RefCode> refcode = referenceCodeDao.getAuthorized();
		if (refcode != null) {
			List<RefCodeVO> refCodeVOs = new ArrayList<RefCodeVO>(refcode.size());
			for (RefCode lov : refcode) {
				RefCodeVO refCodeVO = new RefCodeVO();
				BeanUtils.copyProperties(lov, refCodeVO);
				refCodeVOs.add(refCodeVO);
			}
			return refCodeVOs;
		} else {
			return new ArrayList<RefCodeVO>();
		}
	}
}
