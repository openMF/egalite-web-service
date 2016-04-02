package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.RefCodeDetail;
import com.bfsi.mfi.vo.RefCodeVO;

/**
 * ListValueDao
 * 
 * @author Bablu kumar
 * @param <ListValue>
 */

public interface ReferenceCodeDetailDao extends ReadOnlyMaintenanceDao<RefCodeDetail> {
	public List<RefCodeDetail> getrefCodeDetail(String refCodeDetailId);

	public String getrowUpdate(RefCodeDetail refMasterCode);

	public void insertRefCode(RefCodeVO refcode);

}
