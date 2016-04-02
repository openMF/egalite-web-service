package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.MaintenanceEntity;

/**
 * Read only DAO to perform Retrieve operation
 * 
 * @author Nirmal kanna S
 * 
 * @param <T>
 */
public interface ReadOnlyMaintenanceDao<T extends MaintenanceEntity> 
{
	/**
	 * @return
	 */
	
	List<T> get();
	
	/**
	 * Retrieve entity based on Primary Key
	 * 
	 * @param id
	 *            primary key
	 * @return entity based on given PK
	 */
	
	T get(String id);
	
}
