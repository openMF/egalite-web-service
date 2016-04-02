package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.ListValue;

public class ListValueVO extends MaintenanceVO<ListValue> {
	
	public ListValueVO() {
		entity = new ListValue();
	}
	
	public ListValueVO(ListValue entity) {
		super(entity);
	}
	
	public String getListName() {
		return entity.getListName();
	}

	public void setListName(String listName) {
		entity.setListName(listName);
	}

	public String getListValue() {
		return entity.getListValue();
	}

	public void setListValue(String listValue) {
		entity.setListValue(listValue);
	}

	public String getDesn() {
		return entity.getDesn();

	}

	public void setDesn(String desn) {
		entity.setDesn(desn);
	}
}
