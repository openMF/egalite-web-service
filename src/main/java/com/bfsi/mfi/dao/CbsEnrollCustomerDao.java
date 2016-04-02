package com.bfsi.mfi.dao;

import java.util.Date;
import java.util.List;

import com.bfsi.mfi.cbs.model.CbsEnrollCustomer;
import com.bfsi.mfi.cbs.response.CbsBaseResponse;
import com.bfsi.mfi.exception.ServiceException;

/**
 * 
 * @author Vishal
 *
 */
public interface CbsEnrollCustomerDao {
	public List<CbsEnrollCustomer> getUnprsdEnrollCustomer(String rowNum) throws ServiceException;
	public void updateReqEnrolCustStatus(List<CbsEnrollCustomer> p_custList) throws ServiceException;
	public void updateResEnrolCustStatus(String enrolId, CbsBaseResponse p_res) throws ServiceException;
	public Date getCurrentBusinessDate() throws ServiceException;
}
