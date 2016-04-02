package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.TxnTrackerDao;
import com.bfsi.mfi.entity.MfiMbsTxnReceiverV;
import com.bfsi.mfi.service.TxnReceiverListViewService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.MfiMbsTxnReceiverVO;

@Service(value = "txnReceiverListViewService")
public class TxnReceiverListViewServiceImpl extends ReadOnlyServiceImpl<MfiMbsTxnReceiverVO, MfiMbsTxnReceiverV>
implements TxnReceiverListViewService  {


	@Autowired
	private TxnTrackerDao txnTrackerDao;

	@SuppressWarnings("unchecked")
	@Override
	public TxnTrackerDao  getReadOnlyMaintenanceDao() {
		return txnTrackerDao;
	}
	

	@Override
	protected MfiMbsTxnReceiverV getEntity(MfiMbsTxnReceiverVO vo) {
		MfiMbsTxnReceiverV userEntity = new MfiMbsTxnReceiverV();
		BeanUtils.copyProperties(vo, userEntity);
		LoggerUtil.ibsJobDebug("validateion in AgentTransaction getEntity");
		return userEntity;
	}

	@Override
	protected MfiMbsTxnReceiverVO getValueObject(MfiMbsTxnReceiverV entity) {
		MfiMbsTxnReceiverVO txnReceiverVO = new MfiMbsTxnReceiverVO();
		BeanUtils.copyProperties(entity, txnReceiverVO);
		LoggerUtil.ibsJobDebug("validateion in AgentTransactionVO getValueObject");
		return txnReceiverVO;
	}
	
	@Override
	public List<MfiMbsTxnReceiverVO> getView(){
		
		List<MfiMbsTxnReceiverV> entities=txnTrackerDao.getView();
		if (entities == null) {
			return new ArrayList<MfiMbsTxnReceiverVO>();
		}
		
		List<MfiMbsTxnReceiverVO> vos = new ArrayList<MfiMbsTxnReceiverVO>(entities.size());
		for (MfiMbsTxnReceiverV entity : entities) {
			MfiMbsTxnReceiverVO vo = getValueObject(entity);
			vos.add(vo);
			
	}
		return vos;

}
	
	

}
