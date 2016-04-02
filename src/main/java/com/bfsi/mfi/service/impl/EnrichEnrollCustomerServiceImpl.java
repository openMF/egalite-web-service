package com.bfsi.mfi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.EnrichEnrollCustomerDao;
import com.bfsi.mfi.entity.EnrollCustomer;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.EnrichEnrollCustomerService;
import com.bfsi.mfi.vo.EnrollCustomerVO;

@Service(value = "enrichEnrollCustomerService")
public class EnrichEnrollCustomerServiceImpl extends
		MaintenanceServiceImpl<EnrollCustomerVO, EnrollCustomer> implements
		EnrichEnrollCustomerService {
	@Autowired
	private EnrichEnrollCustomerDao enrichEnrollCustomerDao;

	@SuppressWarnings("unchecked")
	@Override
	protected EnrichEnrollCustomerDao getMaintenanceDao() {
		return enrichEnrollCustomerDao;
	}

	@Override
	protected EnrollCustomer getEntity(EnrollCustomerVO vo) {
		// EnrollCustomer customerEntity = new EnrollCustomer();
		// BeanUtils.copyProperties(vo, customerEntity);
		return vo.getEntity();
	}

	@Override
	protected EnrollCustomerVO getValueObject(EnrollCustomer entity) {
		EnrollCustomerVO enrollCustomerVO = new EnrollCustomerVO(entity);
		// BeanUtils.copyProperties(entity, enrollCustomerVO);
		return enrollCustomerVO;
	}

	@Override
	public boolean modifyEnrichVals(String[] customervals)
			throws ServiceException {
		try {
			return enrichEnrollCustomerDao.modifyEnrichVals(customervals);
		} catch (DataAccessException e) {
			String message = "Error while checking availability of Unique Id:"
					+ enrichEnrollCustomerDao + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
	}

	@Override
	public boolean deleteEnrichedEnroll(String customerCode)
			throws ServiceException {
		try {
			return enrichEnrollCustomerDao.deleteEnrichedEnroll(customerCode);
		} catch (DataAccessException e) {
			String message = "Error while checking availability of Unique Id:"
					+ enrichEnrollCustomerDao + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
	}

	@Override
	public boolean resetEnrichStat(String customerCode) throws ServiceException {
		try {
			return enrichEnrollCustomerDao.resetEnrichStat(customerCode);
		} catch (DataAccessException e) {
			String message = "Error while checking availability of Unique Id:"
					+ enrichEnrollCustomerDao + ". Error: " + e.getMessage();
			logger.error(message, e);
			throw new ServiceException(message, e);
		}
	}

}
