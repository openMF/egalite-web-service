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
import com.bfsi.mfi.entity.DisburseSchedule;
import com.bfsi.mfi.rest.model.LoanConfirmationRequest;
import com.bfsi.mfi.rest.model.LoanConfirmationResponse;
import com.bfsi.mfi.rest.model.LoanDetail;
import com.bfsi.mfi.rest.model.LoanResponse;

import com.bfsi.mfi.entity.RepaymentLiquidation;
import com.bfsi.mfi.entity.RepaymentSchedule;
import com.bfsi.mfi.rest.service.LoanDetailService;
import com.bfsi.mfi.service.LoanService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.LoanVO;

@Component("loanDetailServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/loan")
public class LoanDetailServiceImpl implements LoanDetailService {

	@Autowired
	private LoanService loanService;

	public LoanService getLoanService() {
		return loanService;
	}

	public void setLoanService(LoanService loanService) {
		this.loanService = loanService;
	}

	@Override
	@GET
	@Path("/detail")
	public LoanResponse getLoans() {
		LoanResponse response = new LoanResponse();

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
			response.setLoanDetail(null);
			return response;
		}
		List<LoanDetail> loanlist = new ArrayList<LoanDetail>();
		List<LoanVO> loanVoList = new ArrayList<LoanVO>();
		try {
			loanVoList = getLoanService().getLoans(agentId, batchSize);
			List<RepaymentLiquidation> repayLiq = new ArrayList<RepaymentLiquidation>();

			List<RepaymentSchedule> repaySchdl = new ArrayList<RepaymentSchedule>();
			List<DisburseSchedule> disbrSchdl = new ArrayList<DisburseSchedule>();

			for (int i = 0; i < loanVoList.size(); i++) {
				if (loanVoList.get(i).getNextRepaymentDate() == null)
					loanVoList.get(i).setNextRepaymentDate(new Date(0L));
				if (loanVoList.get(i).getDisbursementDate() == null)
					loanVoList.get(i).setDisbursementDate(new Date(0L));
				if (loanVoList.get(i).getSanctionedDate() == null)
					loanVoList.get(i).setSanctionedDate(new Date(0L));
				if (loanVoList.get(i).getOverDueDate() == null)
					loanVoList.get(i).setOverDueDate(new Date(0L));
				if (loanVoList.get(i).getLastRepaymentDate() == null)
					loanVoList.get(i).setLastRepaymentDate(new Date(0L));
				disbrSchdl = loanVoList.get(i).getDisbrSchedule();
				for (int j = 0; j < disbrSchdl.size(); j++) {
					if (disbrSchdl.get(j).getScheduleDueDate() == null)
						disbrSchdl.get(j).setScheduleDueDate(new Date(0L));
					if (disbrSchdl.get(j).getScheduleStDate() == null)
						disbrSchdl.get(j).setScheduleStDate(new Date(0L));
				}
				loanVoList.get(i).setDisbrSchedule(disbrSchdl);
				/* nambiAK */
				repaySchdl = loanVoList.get(i).getRepaymentSchedule();
				for (int k = 0; k < repaySchdl.size(); k++) {
					if (repaySchdl.get(k).getScheduleDueDate() == null)
						repaySchdl.get(k).setScheduleDueDate(new Date(0L));
					if (repaySchdl.get(k).getScheduleStDate() == null)
						repaySchdl.get(k).setScheduleStDate(new Date(0L));
				}
				loanVoList.get(i).setRepaymentSchedule(repaySchdl);

				repayLiq = loanVoList.get(i).getRepaymentliquidation();
				for (int l = 0; l < repayLiq.size(); l++) {
					if (repayLiq.get(l).getValueDate() == null)
						repayLiq.get(l).setValueDate(new Date(0L));
					if (repayLiq.get(l).getExecutionDate() == null)
						repayLiq.get(l).setExecutionDate(new Date(0L));
				}

				loanVoList.get(i).setRepaymentliquidation(repayLiq);

			}

			for (int i = 0; i < loanVoList.size(); i++) {

				loanlist.add(new LoanDetail());
				// BeanUtils.copyProperties(loanVoList.get(i), loanlist.get(i));
				BeanUtils.copyProperties(loanVoList.get(i), loanlist.get(i),
						new String[] { "agentId", "syncStatus" });

			}
			response.setLoanDetail(loanlist);
			response.setStatus(true);
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
	public LoanConfirmationResponse submitLoanConfirmation(
			LoanConfirmationRequest request) {
		LoanConfirmationResponse response = new LoanConfirmationResponse();

		List<String> loanAccNoList = request.getLoanAccNoList();
		if (loanAccNoList.isEmpty()) {
			response.setStatus(false);
			response.setStatusText(Constants.LOANNUM_LIST_EMPTY);
			return response;
		}
		try {
			response.setStatus(getLoanService().updateLoanStaus(loanAccNoList));
		} catch (ServiceException e) {
			response.setStatus(false);
			response.setStatusText(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

}
