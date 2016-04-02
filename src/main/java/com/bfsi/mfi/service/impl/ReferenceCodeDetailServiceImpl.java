package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.ReferenceCodeDetailDao;
import com.bfsi.mfi.entity.RefCodeDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ReferenceCodeDetailService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.util.MessageUtil;
import com.bfsi.mfi.vo.RefCodeDetailVO;
import com.bfsi.mfi.vo.RefCodeVO;

/**
 * @author Bablu kumar
 *
 */
@Service(value = "refcodedetailService")
public class ReferenceCodeDetailServiceImpl extends ReadOnlyServiceImpl<RefCodeDetailVO, RefCodeDetail>
		implements ReferenceCodeDetailService {

	@Autowired
	private ReferenceCodeDetailDao referenceCodedetailDao;

	public ReferenceCodeDetailDao getReferenceCodedetailDao() {
		return referenceCodedetailDao;
	}

	public void setReferenceCodedetailDao(
			ReferenceCodeDetailDao referenceCodedetailDao) {
		this.referenceCodedetailDao = referenceCodedetailDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ReferenceCodeDetailDao getReadOnlyMaintenanceDao() {
		return referenceCodedetailDao;
	}

	protected RefCodeDetail getEntity(RefCodeDetailVO vo) {
		return vo.getEntity();
	}

	@Override
	protected RefCodeDetailVO getValueObject(RefCodeDetail entity) {
		RefCodeDetailVO refCodedetailVO = new RefCodeDetailVO(entity);
		return refCodedetailVO;
	}


	@Override
	public List<RefCodeDetailVO> getrefCodeDetail(String refCodeDetailId) throws ServiceException
	{
			List<RefCodeDetailVO> refListDetail = new ArrayList<RefCodeDetailVO>();
			List<RefCodeDetail> refListEntitydetail =  referenceCodedetailDao.getrefCodeDetail(refCodeDetailId);
			if (refListEntitydetail != null) {
				for (RefCodeDetail refcodeEntityPay : refListEntitydetail) {
					RefCodeDetailVO refvo = new RefCodeDetailVO();
					BeanUtils.copyProperties(refcodeEntityPay, refvo);
					refListDetail.add(refvo);
				}
			}
			return refListDetail;

	}
	
	@Override
	public String getrowUpdate(RefCodeDetail refCode) throws ServiceException{
				String success =null;
				try {
					success = referenceCodedetailDao.getrowUpdate(refCode);
				} catch (DataAccessException e) {
					throw new ServiceException("DataAccessException while updating Row", e);
				}
				return success;
			}

	@Override
	public void insertRefCode(RefCodeVO refcode){
				try {
					referenceCodedetailDao.insertRefCode(refcode);
					
				} catch (DataAccessException e) {
					LoggerUtil.ibsJobError("Unexpected error while Inserting Row: MFI10001", e);
					MessageUtil.addMessage("MFI10001");
					try {
						throw new ServiceException("DataAccessException while Inserting Row:", e);
					} catch (ServiceException e1) {
						LoggerUtil.ibsJobError("Unexpected error while Inserting Row: MFI10001", e1);
						MessageUtil.addMessage("MFI10001");
					}
				}
			}
	
}
