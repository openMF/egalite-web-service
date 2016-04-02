package com.bfsi.mfi.vo;

import java.util.ArrayList;
import java.util.List;


import com.bfsi.mfi.entity.CashRecSumupView;
import com.bfsi.mfi.entity.CashRecordDetail;

public class CashRecSumupViewVO extends MaintenanceVO<CashRecSumupView>{
	
	public CashRecSumupViewVO() {
		entity = new CashRecSumupView();
	}

	public CashRecSumupViewVO(CashRecSumupView entity) {
		super(entity);
	}

	public String getAgentId() {
		return  entity.getAgentId();
	}

	public void setAgentId(String agentId) {
		entity.setAgentId(agentId);
	}

	public String getTxnDate() {
		return  entity.getTxnDate();
	}

	public void setTxnDate(String txnDate) {
		entity.setTxnDate(txnDate); 
	}

	public Double getDrSum() {
		return  entity.getDrSum();
	}

	public void setDrSum(Double drSum) {
		entity.setDrSum(drSum);
	}

	public Double getCrSum() {
		return  entity.getCrSum();
	}

	public void setCrSum(Double crSum) {
		entity.setCrSum(crSum); 
	}

	public Double getToBeSettled() {
		return  entity.getToBeSettled();
	}

	public void setToBeSettled(Double toBeSettled) {
		entity.setToBeSettled(toBeSettled);
	}

	
	public Object clone() {
		
		CashRecSumupViewVO copyObj = new CashRecSumupViewVO();
		copyObj.setId(super.getId());
		copyObj.setAgentId(getAgentId());
		copyObj.setTxnDate(getTxnDate());
		copyObj.setDrSum(getDrSum());
		copyObj.setCrSum(getCrSum());
		copyObj.setToBeSettled(getToBeSettled());
		
		return copyObj;
	}
	
	public List<CashRecordDetailVO> getCashRecordDetail() {
		List<CashRecordDetailVO> l_recs=new ArrayList<CashRecordDetailVO>();
		
		for(CashRecordDetail e:entity.getCashRecordDetail()){
			CashRecordDetailVO l_rec=new CashRecordDetailVO(e);
			l_recs.add(l_rec);
			
		}
		return l_recs;
	}

	public void setCashRecordDetail(List<CashRecordDetailVO> cashRecordDetail) {
		if(cashRecordDetail!=null)
		{
			List<CashRecordDetail> l_recs=new ArrayList<CashRecordDetail>();
			for(CashRecordDetailVO vo:cashRecordDetail){
				CashRecordDetail l_e=vo.getEntity();
				l_recs.add(l_e);
			}
			entity.setCashRecordDetail(l_recs);
		}
		else
			entity.setCashRecordDetail(null);
	}
	
}
