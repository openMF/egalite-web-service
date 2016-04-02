package com.bfsi.mfi.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author arun
 *
 * @param <V>
 * @param <E>
 */
public abstract class CommonListController<V> {
	/**
	 * Use this if you need only single selection
	 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected V selectedRecord;
	protected List<V> records;
	protected List<V> filteredRecords;
	
	/**
	 * Use this if you need multiple selection
	 */
	private List<V> selectedRecords;

	public List<V> getRecords() {
		return records;
	}

	public void setRecords(List<V> records) {
		this.records = records;
	}

	public List<V> getFilteredRecords() {
		return filteredRecords;
	}

	public void setFilteredRecords(List<V> filteredRecords) {
		this.filteredRecords = filteredRecords;
	}

	public V getSelectedRecord() {
		return selectedRecord;
	}

	public void setSelectedRecord(V selectedRecord) {
		this.selectedRecord = selectedRecord;
	}

	public List<V> getSelectedRecords() {
		return selectedRecords;
	}

	public void setSelectedRecords(List<V> selectedRecords) {
		this.selectedRecords = selectedRecords;
	}

}