package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.Constants;
import com.bfsi.mfi.rest.model.BaseResponse;
import com.bfsi.mfi.rest.model.PigmyDepositConfirmationRequest;
import com.bfsi.mfi.rest.model.PigmyDepositDetail;
import com.bfsi.mfi.rest.model.PigmyDepositResponse;
import com.bfsi.mfi.rest.service.PigmyDepositSyncService;
import com.bfsi.mfi.service.PigmyDepositService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.PigmyDepositVO;

@Component("pigmyDepositSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/dep")
public class PigmyDepositSyncServiceImpl implements PigmyDepositSyncService {
	@Autowired
	private PigmyDepositService pigmyDepositService;

	public PigmyDepositService getPigmyDepositService() {
		return pigmyDepositService;
	}

	public void setPigmyDepositService(PigmyDepositService pigmyDepositService) {
		this.pigmyDepositService = pigmyDepositService;
	}

	@Override
	@GET
	@Path("/detail")
	public PigmyDepositResponse getPigmyDeposit() {
		PigmyDepositResponse response = new PigmyDepositResponse();
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		String agentId = null;
		String batchSize = null;
		try {
			agentId = sess.getAttribute("agentId").toString();
			batchSize = sess.getAttribute("batchSize").toString();
		} catch (Exception ex) {
			LoggerUtil.mbsJobError("Unhandeled Exception : MFI10001", ex);
			response.setStatusText(Constants.SESSION_EXPIRED);
			response.setPigmyDepositDetail(null);
			return response;
		}
		List<PigmyDepositVO> pigmyDepositlist = new ArrayList<PigmyDepositVO>();
		List<PigmyDepositDetail> depositDetaillist = new ArrayList<PigmyDepositDetail>();
		try {
			pigmyDepositlist = getPigmyDepositService().getPigmyDeposits(
					agentId, batchSize);
			for (int i = 0; i < pigmyDepositlist.size(); i++) {
				if (pigmyDepositlist.get(i).getDepositOpenedDate() == null)
					pigmyDepositlist.get(i).setDepositOpenedDate(new Date(0L));
				if (pigmyDepositlist.get(i).getLastInstallmentDate() == null)
					pigmyDepositlist.get(i)
							.setLastInstallmentDate(new Date(0L));
				if (pigmyDepositlist.get(i).getMaturityDate() == null)
					pigmyDepositlist.get(i).setMaturityDate(new Date(0L));
				if (pigmyDepositlist.get(i).getLastInstallmentDate() == null)
					pigmyDepositlist.get(i)
							.setLastInstallmentDate(new Date(0L));
				if (pigmyDepositlist.get(i).getOverdueDate() == null)
					pigmyDepositlist.get(i).setOverdueDate(new Date(0L));
				if (pigmyDepositlist.get(i).getOverdueDate() == null)
					pigmyDepositlist.get(i).setOverdueDate(new Date(0L));
				if (pigmyDepositlist.get(i).getRedemptionPayoutDate() == null)
					pigmyDepositlist.get(i).setRedemptionPayoutDate(
							new Date(0L));
				if (pigmyDepositlist.get(i).getNextInstDate() == null)
					pigmyDepositlist.get(i).setNextInstDate(new Date(0L));
			}
			for (int i = 0; i < pigmyDepositlist.size(); i++) {
				depositDetaillist.add(new PigmyDepositDetail());
				BeanUtils.copyProperties(pigmyDepositlist.get(i),
						depositDetaillist.get(i));
				response.setPigmyDepositDetail(depositDetaillist);
				response.setStatus(true);
			}
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setStatusText(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	@POST
	@Path("/confirm")
	public BaseResponse submitDepositConfirmation(
			PigmyDepositConfirmationRequest request) {
		BaseResponse response = new BaseResponse();
		List<String> depositAccNoList = request.getDepositAccNoList();
		if (depositAccNoList.isEmpty()) {
			response.setStatus(false);
			response.setStatusText(Constants.DEPOSITACNUM_LIST_EMPTY);
			return response;
		}

		try {
			response.setStatus(getPigmyDepositService()
					.updatePigmyDepositStaus(depositAccNoList));
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setStatusText(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

}
