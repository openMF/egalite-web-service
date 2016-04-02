package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.PigmyDepositDao;
import com.bfsi.mfi.entity.PigmyDeposit;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.PigmyDepositService;
import com.bfsi.mfi.vo.PigmyDepositVO;

@Service(value = "pigmyDepositService")
public class PigmyDepositServiceImpl extends
		MaintenanceServiceImpl<PigmyDepositVO, PigmyDeposit> implements
		PigmyDepositService {

	private static final String SYNC_STATUS_NA = "NA";
	private static final String SYNC_STATUS_ACK = "A";
	public static final String NEW_ACCOUNT_OPENING = "NA";
	public static final String PREMATURE_REDEMPTION = "PW";
	public static final String PREMATURE_OF_DEPOSIT = "PD";

	@Autowired
	private PigmyDepositDao pigmyDepositDao;

	public PigmyDepositDao getPigmyDepositDao() {
		return pigmyDepositDao;
	}

	public void setPigmyDepositDao(PigmyDepositDao pigmyDepositDao) {
		this.pigmyDepositDao = pigmyDepositDao;
	}

	@Override
	protected PigmyDeposit getEntity(PigmyDepositVO vo) {
		return vo.getEntity();
	}

	@Override
	protected PigmyDepositVO getValueObject(PigmyDeposit entity) {
		PigmyDepositVO pigmyDepositVO = new PigmyDepositVO(entity);
		return pigmyDepositVO;
	}

	@Override
	public List<PigmyDepositVO> getPigmyDeposits(String agentId,
			String batchSize) throws ServiceException {
		List<PigmyDepositVO> pigmyDepositVoList = new ArrayList<PigmyDepositVO>();
		List<PigmyDeposit> pigmyDepositList = new ArrayList<PigmyDeposit>();
		List<String> depositAccNoList = new ArrayList<String>();
		try {
			pigmyDepositList = getPigmyDepositDao().getPigmyDepositDetails(
					agentId, batchSize);
			if (!pigmyDepositList.isEmpty()) {
				for (PigmyDeposit pigmyDeposit : pigmyDepositList) {
					PigmyDepositVO pigmyDepositVo = getValueObject(pigmyDeposit);
					pigmyDepositVoList.add(pigmyDepositVo);
					depositAccNoList.add(pigmyDeposit.getId());
				}
			}
			if (!pigmyDepositVoList.isEmpty()) {
				getPigmyDepositDao().updatePigmyDepositStatus(depositAccNoList,
						SYNC_STATUS_NA);
			}
			return pigmyDepositVoList;

		} catch (DataAccessException e) {
			String message = "Error while getting list of pigmy deposit Account Number with agentId:"
					+ agentId + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected PigmyDepositDao getMaintenanceDao() {
		// TODO Auto-generated method stub
		return pigmyDepositDao;
	}

	@Override
	public Boolean updatePigmyDepositStaus(List<String> depositAccNoList)
			throws ServiceException {
		if (depositAccNoList != null) {
			try {
				getPigmyDepositDao().updatePigmyDepositStatus(depositAccNoList,
						SYNC_STATUS_ACK);

			} catch (DataAccessException e) {
				String message = "Error while updating the status of the Pigmy Deposit:"
						+ ". Error: " + e.getMessage();
				logger.error(message, e);
				throw new ServiceException(message, e);
			}
			return true;
		}

		return false;
	}

	

}
