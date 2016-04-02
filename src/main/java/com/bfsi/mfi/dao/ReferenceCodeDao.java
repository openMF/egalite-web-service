package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.RefCode;

/**
 * ListValueDao
 * 
 * @author Bablu kumar
 * @param <ListValue>
 */

public interface ReferenceCodeDao extends MaintenanceDao<RefCode> {

	List<RefCode> getAuthorized();

}
