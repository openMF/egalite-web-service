package com.bfsi.mfi.cbs.adapter;

import java.util.List;

import com.bfsi.mfi.cbs.response.DropListSyncResponse;
import com.bfsi.mfi.entity.CbsDropList;

/**
 * 
 * @author Nirmal kanna S
 *
 */

public abstract class CbsDropListServiceAdapter  extends ApplicationContextHolder  {
	
	public abstract  DropListSyncResponse extractDropList();	

}
