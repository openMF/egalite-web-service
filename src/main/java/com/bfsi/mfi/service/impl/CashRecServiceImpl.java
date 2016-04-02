package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.CashRecDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.CashRecSumupView;
import com.bfsi.mfi.entity.CashRecordDetail;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CashRecService;
import com.bfsi.mfi.vo.CashRecSumupViewVO;
import com.bfsi.mfi.vo.CashRecordDetailVO;

@Service(value = "cashRecService")
public class CashRecServiceImpl extends MaintenanceServiceImpl<CashRecSumupViewVO, CashRecSumupView>
implements CashRecService{

	@Autowired
	private CashRecDao cashRecDao;

	@SuppressWarnings("unchecked")
	@Override
	protected CashRecDao  getMaintenanceDao() {
		return cashRecDao;
	}

	@Override
	protected CashRecSumupView getEntity(CashRecSumupViewVO vo) {
		return vo.getEntity();
	}

	@Override
	protected CashRecSumupViewVO getValueObject(CashRecSumupView entity) {
		CashRecSumupViewVO cashRecSumupViewVO = new CashRecSumupViewVO(entity);
		return cashRecSumupViewVO;
	}

	
	
	@Override
	public List<CashRecSumupViewVO> getSearch(String agtid, String tdate)
			throws ServiceException {
		List<CashRecSumupView> cashRecSumupView = cashRecDao.getSearch(agtid,tdate);
		if (cashRecSumupView != null) {
			List<CashRecSumupViewVO> cashRecSumupViewVOs = new ArrayList<CashRecSumupViewVO>(cashRecSumupView.size());
			for (CashRecSumupView lov : cashRecSumupView) {
				CashRecSumupViewVO VO = new CashRecSumupViewVO();
				BeanUtils.copyProperties(lov, VO);
				cashRecSumupViewVOs.add(VO);
			}
			return cashRecSumupViewVOs;
		} else {
			return new ArrayList<CashRecSumupViewVO>();
		}
	}

	@Override
	public List<CashRecordDetailVO> getCashRecordDetail(String agentId) {
		
		List<CashRecordDetailVO> l_eList=new ArrayList<CashRecordDetailVO>();		
		
		for(CashRecordDetail e:cashRecDao.cashRecordDetail(agentId)){
			CashRecordDetailVO vo=new CashRecordDetailVO(e);
			l_eList.add(vo);
		}
		return l_eList;
		
	}


	
	
}
