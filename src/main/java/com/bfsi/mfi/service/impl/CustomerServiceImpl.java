package com.bfsi.mfi.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfsi.mfi.dao.CustomerDao;
import com.bfsi.mfi.dao.LoanDao;
import com.bfsi.mfi.entity.Customer;
import com.bfsi.mfi.entity.Loan;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.CustomerService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.CustomerVO;
import com.bfsi.mfi.vo.LoanVO;

@Service(value = "customerService")
@Transactional(rollbackFor = { ServiceException.class })
public class CustomerServiceImpl extends
		ReadOnlyServiceImpl<CustomerVO, Customer> implements CustomerService {

	//private static final String SYNC_STATUS_NA = "NA";
	private static final String SYNC_STATUS_A = "1";
	private static final String SYNC_STATUS_ACK = "A";
	@Autowired
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Autowired
	private LoanDao loanDao;

	public LoanDao getLoanDao() {
		return loanDao;
	}

	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}

	@Override
	protected Customer getEntity(CustomerVO vo) {
		return vo.getEntity();
	

	}

	@Override
	protected CustomerVO getValueObject(Customer entity) {
		CustomerVO custvo = new CustomerVO(entity);
		return custvo;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CustomerDao getReadOnlyMaintenanceDao() {
		// TODO Auto-generated method stub
		return customerDao;
	}

	@Override
	public CustomerVO get(String id) throws ServiceException {
		try {
			CustomerVO customerVO = super.get(id);
			customerVO.setStreamImage(getDocumentContent(customerVO));
			//List<LoanVO> listvo = new ArrayList<LoanVO>();

			//List<Loan> loanList = loanDao.getLoanForCustomer(id);
			//LoggerUtil.ibsJobDebug("Calling DAO  for getting Customer details with  id: "+id);
			//if (loanList != null) {
				//for (Loan loanEntity : loanList) {
					//LoanVO loanvo = new LoanVO();
					//BeanUtils.copyProperties(loanEntity, loanvo);
					//listvo.add(loanvo);
				//}
			//}
			//customerVO.setLoanDetails(listvo);
			return customerVO;

		} catch (DataAccessException e) {
			
			throw new ServiceException("DataAccessException while getting Customer details: "+id, e);
		}

	}
public StreamedContent getDocumentContent(CustomerVO customervo) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		byte[] bytes = customervo.getImage();

		if (bytes != null) {
			InputStream is = new ByteArrayInputStream(bytes);
			StreamedContent image = new DefaultStreamedContent(is);
			return image;
		} else {
			return null;
		}
	}

	@Override
	public List<CustomerVO> getCustomers(String agentId, String locCode, String batchSize,List<String> recvdIds)
			throws ServiceException {
		try {
			List<Customer> customerList = getCustomerDao().getCustomersDetail(
					agentId,locCode, batchSize,recvdIds);
			LoggerUtil.ibsJobDebug("Calling DAO  for getting Customer list associated with agentId: "+agentId);
			List<CustomerVO> customerVoList = new ArrayList<CustomerVO>();
			List<String> customerIdList = new ArrayList<String>();
			if (customerList != null) {
				for (int i = 0; i < customerList.size(); i++) {
					CustomerVO customerVo = getValueObject(customerList.get(i));
					customerVoList.add(customerVo);
					customerIdList.add(customerList.get(i).getCustomerId());
				}
                if(!customerVoList.isEmpty()){
				//getCustomerDao().updateCustomerStatus(customerIdList,SYNC_STATUS_NA );
               // getCustomerDao().updateCustomerStatus(customerIdList,SYNC_STATUS_A );
                }
			}
			return customerVoList;
		} catch (DataAccessException e) {			
			throw new ServiceException("DataAccessException while getting list of Customers with agentId: "+agentId, e);
		}

	}

	@Override
	public Boolean updateCustomerStatus(List<String> customerIdList)
			throws ServiceException {
		if (customerIdList != null) {
			try {
				LoggerUtil.ibsJobDebug("Calling DAO  for updating Customer status: ");
				getCustomerDao().updateCustomerStatus(customerIdList,SYNC_STATUS_ACK );

			} catch (DataAccessException e) {
				
				throw new ServiceException("DataAccessException while updating Customer status: ", e);
			}
			return true;
		}
		return false;
	}

	@Override
	public List<CustomerVO> getSearch(String customerId, String locationCode,String localBranchCode) 
			throws ServiceException{
		
		try{
			List<Customer> customerList = getCustomerDao().getSearch(customerId, locationCode, localBranchCode);
			LoggerUtil.ibsJobDebug("Calling DAO  for getting list with submitted criteria: "+customerId +" :"+locationCode);
			
			if (customerList == null) {
				return new ArrayList<CustomerVO>();
			}
			
			List<CustomerVO> vos = new ArrayList<CustomerVO>(customerList.size());
			for (Customer entity : customerList) {
				CustomerVO vo = getValueObject(entity);
				vos.add(vo);
			}
			
			return vos;
		}catch(DataAccessException e){
			throw new ServiceException("DataAccessException while getting list with submitted criteria : ", e);
		}
		
		
	}
	
	
	
	
}
