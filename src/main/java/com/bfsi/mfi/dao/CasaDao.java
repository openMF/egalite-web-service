package com.bfsi.mfi.dao;

import com.bfsi.mfi.entity.CustAcDetailListView;
import com.bfsi.mfi.entity.CustAcDetailView;

public interface CasaDao extends ReadOnlyMaintenanceDao<CustAcDetailListView> {

	CustAcDetailView getCustAc(String id);

}
