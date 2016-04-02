package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.vo.AuditTrailVO;
import com.bfsi.mfi.vo.MaintenanceVO;

/**
 * @author arun
 * 
 * @param <V>
 * @param <E>
 */
@SuppressWarnings("rawtypes")
public interface MaintenanceService<V extends MaintenanceVO, E extends MaintenanceEntity>
		extends ReadOnlyMaintenanceService<V, E> {

	/**
	 * @param vo
	 * @return
	 */
	V create(V vo) throws ServiceException;

	/**
	 * @param vo
	 * @return
	 */
	V update(V vo) throws ServiceException;

	/**
	 * @return
	 */

	/**
	 * Authorize the changes in the given object. Only the latest version willl
	 * be authorized as per the audit trail
	 * 
	 * @param vo
	 * @return
	 */
	V authorize(V vo) throws ServiceException;

	/**
	 * Soft delete given object
	 * 
	 * @param vo
	 * @return
	 */
	V delete(V vo) throws ServiceException;

	/**
	 * Get list of audit trail for the given entity without object xml
	 * 
	 * @return
	 */
	List<AuditTrailVO> getAllAuditTrails(V vo) throws ServiceException;

	/**
	 * Load audit trail details along with object xml
	 * 
	 * @param vo
	 */
	void loadAuditTrailDetails(AuditTrailVO vo) throws ServiceException;

	/**
	 * @param vo
	 * @return Maker user id for the last version of the given record
	 */
	List<String> getMaker(V vo) throws ServiceException;
	
	int getMakerVersion(V vo) throws ServiceException;
	
	//AuditTrailVO getAllAuditTrail(V vo) throws ServiceException;
}
