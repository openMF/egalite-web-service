package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.ListValueDao;
import com.bfsi.mfi.entity.ListValue;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ListValueService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.ListValueVO;

@Service(value = "listValueService")
public class ListValueServiceImpl implements ListValueService {

	@Autowired
	private ListValueDao dao;

	public List<ListValueVO> get(String listName) {
		List<ListValue> listValues = dao.get(listName);

		if (listValues != null) {
			List<ListValueVO> listValueVOs = new ArrayList<ListValueVO>(
					listValues.size());
			for (ListValue lov : listValues) {
				ListValueVO listValueVO = new ListValueVO();
				BeanUtils.copyProperties(lov, listValueVO);
				listValueVOs.add(listValueVO);
			}
			return listValueVOs;
		} else {
			return new ArrayList<ListValueVO>();
		}
	}

	@Override
	public String getValue(String id, String listName) {
		
		String value = null;
		try{
			value= dao.getValue(id, listName);
		}catch (ServiceException e) {
			LoggerUtil.mbsJobError("ServiceException While in List Values : MFI10001",e);
		} catch (Exception e) {
			LoggerUtil.mbsJobError("Unhandeled Exception While in List Values : MFI10001",e);
		}
		return value;
	}
}
