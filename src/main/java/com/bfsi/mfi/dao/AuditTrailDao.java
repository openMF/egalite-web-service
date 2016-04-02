package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.AuditTrail;
import com.bfsi.mfi.entity.MaintenanceEntity;

/**
 * AuditTrailDAO for maintaining audit of entity
 * 
 * @author akrishna
 * 
 */
public interface AuditTrailDao<E extends MaintenanceEntity> {
	/**
	 * Inserts a new record into audit trail for create operation including the
	 * maker user id and current system timestamp. No objectxml will be inserted
	 * as the current record in the table has that.
	 * 
	 * @param auditTrailDetails
	 */
	void auditCreate(AuditTrail<E> auditTrailDetails);

	/**
	 * Inserts a new record into audit trail incrementing the version, including
	 * maker id and timestamp as well as the details of the entity before
	 * modification operation.
	 * 
	 * @param auditTrailDetails
	 */
	void auditUpdate(AuditTrail<E> auditTrailDetails);

	/**
	 * Updates max version of the audit trail with checker id and checker
	 * timestamp without any change to rest of the fields
	 * 
	 * @param auditTrailDetails
	 */
	void auditAuth(AuditTrail<E> auditTrailDetails);

	/**
	 * Retrieves all audit trail information for the given entity. This doesn't
	 * load the object xml as part of it.
	 * 
	 * @param entity
	 * @return
	 */
	List<AuditTrail<E>> getAllAuditTrails(E entity);

	/**
	 * Load object xml into the given audit trail object
	 * 
	 * @param auditTrail
	 *            auditTrail containing details of entity and audit trail
	 */
	void loadAuditXml(AuditTrail<E> auditTrail);

	/**
	 * @param entity
	 *            whose latest version has to be found
	 * @return Max version present for the given entity. 0 if entity is not
	 *         present => new
	 */
	Integer getMaxVersion(E entity);

	/**
	 * @param auditTrail
	 * @return maker id for the last version of the given record
	 */
	List<String> getMakerForMaxVersion(AuditTrail<E> auditTrail);

	int getMakerVersion(AuditTrail<E> auditTrail);

	/**
	 * Checks if the given entity is authorized at least once
	 * 
	 * @param entity
	 * @return
	 */
	boolean isRecordOnceAuthorized(AuditTrail<E> entity);
}
