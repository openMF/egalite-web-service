package com.bfsi.mfi.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.rest.constants.Constants;
import com.bfsi.mfi.rest.model.BranchDetail;
import com.bfsi.mfi.rest.model.BranchResponse;
import com.bfsi.mfi.rest.service.BranchSyncService;
import com.bfsi.mfi.service.BranchService;
import com.bfsi.mfi.util.ApplicationUtil;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.BranchVO;

@Component("branchSyncServiceImpl")
@Consumes("application/json")
@Produces("application/json")
@Path("/branch")
public class BranchSyncServiceImpl implements BranchSyncService {
	@Autowired
	private BranchService branchService;

	public BranchService getBranchService() {
		return branchService;
	}

	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}

	@GET
	@Override
	public BranchResponse getBranchList() {
		BranchResponse response = new BranchResponse();
		List<BranchVO> branchList = new ArrayList<BranchVO>();
		List<BranchDetail> branchDetail = new ArrayList<BranchDetail>();
		try {
			branchList = getBranchService().getBranchList();
		} catch (ServiceException e) {
			response.setStatus(Constants.STATUS);
			response.setMessageCode("MFI10001");
			LoggerUtil.mbsJobError("ServiceException while Getting Branch Details : MFI10001 ",e);
			return response;
		}
		for (int i = 0; i < branchList.size(); i++) {
			branchDetail.add(new BranchDetail());
			BeanUtils.copyProperties(branchList.get(i), branchDetail.get(i),new String[]{"branchDate"});
			branchDetail.get(i).setBranchDate(ApplicationUtil.dateAsLongFormat(branchList.get(i).getBranchDate()));
			
		}
		if (!branchDetail.isEmpty()) {
			response.setBranchDetail(branchDetail);
			response.setStatus(true);
		} else {
			response.setStatus(true);
			response.setMessageCode("MFI00257");
		}
		return response;
	}

}
