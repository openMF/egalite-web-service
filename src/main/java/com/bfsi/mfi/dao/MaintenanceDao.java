package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.MaintenanceEntity;

/**
 * Base DAO to perform CRUD operations
 * 
 * @author arun
 * 
 * @param <T>
 */
public interface MaintenanceDao<T extends MaintenanceEntity> {
	/**
	 * Insert entity into data store
	 * 
	 * @param entity
	 * @return
	 */
	T create(T entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	T update(T entity);

	T delete(T entity);
	/**
	 * @return
	 */
	
	T authorize(T entity);
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
