package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.entity.Cash;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.Constants;
import com.bfsi.mfi.rest.model.CashDetail;
import com.bfsi.mfi.rest.model.CashSettlementResponse;
import com.bfsi.mfi.rest.service.CashInfoService;
import com.bfsi.mfi.service.CashSettlementService;
import com.bfsi.mfi.util.LoggerUtil;

@Component("cashInfoServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/cashSettlement")
public class CashInfoServiceImpl implements CashInfoService {
	@Autowired
	private CashSettlementService cashSettlementService;

	public CashSettlementService getCashSettlementService() {
		return cashSettlementService;
	}

	public void setCashSettlementService(
			CashSettlementService cashSettlementService) {
		this.cashSettlementService = cashSettlementService;
	}

	@Override
	@GET
	public CashSettlementResponse getCashSettlement() {
		CashSettlementResponse response = new CashSettlementResponse();
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest req = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpSession sess = req.getSession(false);
		String agentId;
		try {
			agentId = sess.getAttribute("agentId").toString();
		} catch (Exception ex) {
			LoggerUtil.mbsJobError("Unhandeled Exception : MFI10001", ex);
			response.setStatusText(Constants.SESSION_EXPIRED);
			response.setCashDetail(null);
			return response;
		}
		List<Cash> cash = null;
		List<CashDetail> cashDetail = new ArrayList<CashDetail>();
		try {
			cash = new ArrayList<Cash>();
			//cash = getCashSettlementService().getCashBalance(agentId);
		} catch (ServiceException e) {
			response.setStatusText(e.getMessage());
			response.setStatus(false);
			e.printStackTrace();
		}
		for (int i = 0; i < cash.size(); i++) {
			cashDetail.add(new CashDetail());
			BeanUtils.copyProperties(cash.get(i), cashDetail.get(i));
		}
		for (int i = 0; i < cashDetail.size(); i++) {
			if (cashDetail.get(i).getTxnTime() == null)
				cashDetail.get(i).setTxnTime(new Date(0l));
		}
		response.setCashDetail(cashDetail);
		response.setStatus(true);
		return response;
	}

}
