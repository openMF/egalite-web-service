package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.MaintenanceVO;

/**
 * @author Nirmal kanna S
 * 
 * @param <V>
 * @param <E>
 */
@SuppressWarnings("rawtypes")
public interface ReadOnlyMaintenanceService<V extends MaintenanceVO, E extends MaintenanceEntity> {

	/**
	 * Retrieve all records from table
	 * 
	 * @return
	 * @throws ServiceException
	 */
	List<V> get() throws ServiceException;

	/**
	 * Get Value object from primary key
	 * 
	 * @return
	 */
	V get(String id) throws ServiceException;

}
