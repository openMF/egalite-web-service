package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.PigmyDeposit;
import com.bfsi.mfi.entity.PigmyView;

public interface PigmyDepositDao extends MaintenanceDao<PigmyDeposit> {
	List<PigmyDeposit> getPigmyDepositForAllocation();

	List<PigmyDeposit> getPigmyDepositDetails(String agentId, String batchSize);

	void updatePigmyDepositStatus(List<String> depositAccNoList,
			String syncStatusNa);
	PigmyView getDepositView(String id);

	

}
