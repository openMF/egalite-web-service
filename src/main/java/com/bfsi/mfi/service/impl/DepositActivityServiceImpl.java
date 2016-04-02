package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.DepositActivityDao;
import com.bfsi.mfi.entity.DepositActivity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.DepositActivityService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.DepositActivityVO;

/**
 * @author Bablu kumar
 * 
 */

@Service(value = "depositActivityService")
public class DepositActivityServiceImpl extends MaintenanceServiceImpl<DepositActivityVO, DepositActivity>
implements DepositActivityService{

	@Autowired
	private DepositActivityDao depositActivityDao;

	@SuppressWarnings("unchecked")
	@Override
	protected DepositActivityDao getMaintenanceDao() {
		return depositActivityDao;
	}
	
	@Override
	protected DepositActivityVO getValueObject(DepositActivity entity) {
		DepositActivityVO depositActivityVO = new DepositActivityVO(entity);
		return depositActivityVO;
	}
	
	@Override
	protected DepositActivity getEntity(DepositActivityVO vo) {
		return vo.getEntity();
	}
	
	@Override
	public List<DepositActivityVO> getDepositActivityView(String id)
			throws ServiceException {
		
		List<DepositActivityVO> depositactivity = new ArrayList<DepositActivityVO>();
	 try{	
		List<DepositActivity> disbursListEntity =  depositActivityDao.getDepositActivityView(id);
		if (disbursListEntity != null) {
			for (DepositActivity disburseScheduleEntity : disbursListEntity) {
				DepositActivityVO depositActivityVO = new DepositActivityVO();
				BeanUtils.copyProperties(disburseScheduleEntity, depositActivityVO);
				depositactivity.add(depositActivityVO);
			}
		}
			LoggerUtil.ibsJobDebug("Calling DAO  for getting Deposit Activity view:"+id );
		LoggerUtil.ibsJobDebug("Calling DAO to get Deposit Activity for Deposit Activity Id :"+id);
	 }catch(DataAccessException e){
		 throw new ServiceException("DataAccessException while getting Deposit Activity for Deposit A/c Number: "+id, e);
	 }
		return depositactivity;
	}

	
}

