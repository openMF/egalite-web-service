package com.bfsi.mfi.service;

import java.util.List;

import com.bfsi.mfi.vo.ListValueVO;

/**
 * @author arun
 * 
 */
public interface ListValueService {

	List<ListValueVO> get(String listName);
	
	String getValue(String id,String listName);

}
