package com.bfsi.mfi.dao;

import java.util.List;

import com.bfsi.mfi.entity.ListValue;

/**
 * ListValueDao
 * 
 * @author Nirmal kanna S
 * @param <ListValue>
 */

public interface ListValueDao {
	
	public List<ListValue> get(String listname);

	public String getValue(String id,String listName);
	
}
