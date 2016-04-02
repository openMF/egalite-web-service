package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.CbsDropList;

/**
 *  DAO
 * 
 * @author Nirmal kanna S
 * @param <User>
 */

public interface CbsDropListDao extends MaintenanceDao<CbsDropList> {

		public String getCbsDropListValues(List<CbsDropList> cbsDropList);

}
