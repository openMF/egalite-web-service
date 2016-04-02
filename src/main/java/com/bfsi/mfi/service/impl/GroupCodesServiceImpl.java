package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.GroupCodesDao;
import com.bfsi.mfi.entity.Agency;
import com.bfsi.mfi.entity.GroupCodes;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.GroupCodesService;
import com.bfsi.mfi.vo.AgencyVO;
import com.bfsi.mfi.vo.GroupCodesVO;


@Service(value = "groupCodesService")
public class GroupCodesServiceImpl extends MaintenanceServiceImpl<GroupCodesVO, GroupCodes>
                          implements GroupCodesService{

	@Autowired
	private GroupCodesDao groupCodesDao;
	
	@SuppressWarnings("unchecked")
	@Override
	protected GroupCodesDao getMaintenanceDao() {
		return groupCodesDao;
	}

	@Override
	protected GroupCodes getEntity(GroupCodesVO vo) {
		return vo.getEntity();
	}

	@Override
	protected GroupCodesVO getValueObject(GroupCodes entity) {
		GroupCodesVO groupCodesVO = new GroupCodesVO(entity);
		return groupCodesVO;
	}
	
	@Override
	public String getAutoGroupCode() throws ServiceException
	{
		String groupCodes;
		try {
			
			groupCodes = groupCodesDao.getAutoGroupCode();
			return groupCodes;
			
		} catch (DataAccessException e) {
			throw new ServiceException("Error while generating the Automatic group Code: ", e);
		}
	}
	
	@Override
	public List<GroupCodesVO>getAuthorized() {
		List<GroupCodes> groupCode = groupCodesDao.getAuthorized();
		if (groupCode != null) {
			List<GroupCodesVO> groupCodesVO = new ArrayList<GroupCodesVO>(groupCode.size());
			for (GroupCodes lov : groupCode) {
				GroupCodesVO groupCodeVO = new GroupCodesVO();
				BeanUtils.copyProperties(lov, groupCodeVO);
				groupCodesVO.add(groupCodeVO);
			}
			return groupCodesVO;
		} else {
			return new ArrayList<GroupCodesVO>();
		}
	}
	

	
	// For Delete Operation
	@Override
	public String deleteGroupCode(String id) throws ServiceException {
		String success;
		try {
			success= groupCodesDao.deleteGroupCode(id);
		} catch (DataAccessException e) {
			throw new ServiceException("Error while deleting Agency: ", e);
		}
		return success;
	}
	

	
}
