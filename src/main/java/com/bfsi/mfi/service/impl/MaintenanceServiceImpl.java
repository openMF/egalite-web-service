package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.bfsi.mfi.dao.AuditTrailDao;
import com.bfsi.mfi.dao.MaintenanceDao;
import com.bfsi.mfi.entity.AuditTrail;
import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.MaintenanceService;
import com.bfsi.mfi.util.LoggerUtil;
import com.bfsi.mfi.vo.AuditTrailVO;
import com.bfsi.mfi.vo.MaintenanceVO;

public abstract class MaintenanceServiceImpl<V extends MaintenanceVO, E extends MaintenanceEntity>
		implements MaintenanceService<V, E> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AuditTrailDao<E> auditTrailDao;

	@Override
	public V create(V vo) throws ServiceException {
		LoggerUtil.ibsJobDebug("Calling abstart create to create the object id:"+vo.getId() +"Object type: "+vo.getClass().getName());
		E entity = getEntity(vo);
		entity.setMaker(getLoggedInUserId());
		entity.setMakerTimestamp(new Date());
		try {
			getMaintenanceDao().create(entity);
			return vo;
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while creating the object id:"+vo.getId() +"Object type: "+vo.getClass().getName(), e);
		}
	}

	public V update(V vo) throws ServiceException {
		LoggerUtil.ibsJobDebug("Calling abstart update to update the object id:"+vo.getId() +"Object type: "+vo.getClass().getName());
		E entity = getEntity(vo);
		entity.setMaker(getLoggedInUserId());
		entity.setMakerTimestamp(new Date());
		try {
			getMaintenanceDao().update(entity);
			return vo;
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while updating the object id:"+vo.getId() +"Object type: "+vo.getClass().getName(), e);
		}
	}

	public V authorize(V vo) throws ServiceException {
		LoggerUtil.ibsJobDebug("Calling abstart authorize to authorize the object id:"+vo.getId() +"Object type: "+vo.getClass().getName());
		E entity = getEntity(vo);
		entity.setChecker(getLoggedInUserId());
		entity.setCheckerTimestamp(new Date());
		try {
			getMaintenanceDao().authorize(entity);
			return vo;
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while authorizing the object id:"+vo.getId() +"Object type: "+vo.getClass().getName(), e);
		}
	}

	public V delete(V vo) throws ServiceException {
		LoggerUtil.ibsJobDebug("Calling abstart delete to delete the object id:"+vo.getId() +"Object type: "+vo.getClass().getName());
		E entity = getEntity(vo);
		entity.setMaker(getLoggedInUserId());
		entity.setMakerTimestamp(new Date());
		try {
			getMaintenanceDao().delete(entity);
			return vo;
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while deleting the object id:"+vo.getId() +"Object type: "+vo.getClass().getName(), e);
		}
	}

	protected abstract <T extends MaintenanceDao<E>> T getMaintenanceDao();

	protected abstract E getEntity(V vo);

	protected abstract V getValueObject(E entity);

	@Override
	public List<V> get() throws ServiceException {
		LoggerUtil.ibsJobDebug("Calling abstart get to get list of records for object: "+this.getClass().getName());
		List<E> entities = null;
		try {
			entities = getMaintenanceDao().get();
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting list of records for object: "+this.getClass().getName(), e);
		}

		if (entities == null) {
			return new ArrayList<V>();
		}

		List<V> vos = new ArrayList<V>(entities.size());
		for (E entity : entities) {
			V vo = getValueObject(entity);
			vos.add(vo);
		}

		return vos;
	}

	@Override
	public V get(String id) throws ServiceException {
		LoggerUtil.ibsJobDebug("Calling abstart get to get  object: "+this.getClass().getName() +" with id: "+id);
		try {
			E entity = getMaintenanceDao().get(id);
			return getValueObject(entity);
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting  object: "+this.getClass().getName()+" with id: "+id, e);
		}
	}

	@Override
	public List<AuditTrailVO> getAllAuditTrails(V vo) throws ServiceException {
		LoggerUtil.ibsJobDebug("Calling abstart getAllAuditTrails for the object id:"+vo.getId() +"Object type: "+vo.getClass().getName());
		E entity = getEntity(vo);
		List<AuditTrail<E>> auditTrailEntities = null;
		try {
			auditTrailEntities = auditTrailDao.getAllAuditTrails(entity);
		} catch (DataAccessException e) {
			throw new ServiceException("DataAccessException while getting all AllAuditTrails for the object id:"+vo.getId() +"Object type: "+vo.getClass().getName(), e);
		}
		List<AuditTrailVO> auditTrailVos = new ArrayList<AuditTrailVO>();

		if (auditTrailEntities != null) {
			for (AuditTrail<E> auditTrailEntity : auditTrailEntities) {
				AuditTrailVO auditTrailVo = new AuditTrailVO();
				BeanUtils.copyProperties(auditTrailEntity, auditTrailVo);
				auditTrailVos.add(auditTrailVo);
			}
		}
		return auditTrailVos;
	}

	@Override
	public void loadAuditTrailDetails(AuditTrailVO vo) throws ServiceException {
		LoggerUtil.ibsJobDebug("getting audit trail details for id : "+vo.getId());
		AuditTrail<E> auditTrailEntity = new AuditTrail<E>();
		BeanUtils.copyProperties(vo, auditTrailEntity);
		try {
			auditTrailDao.loadAuditXml(auditTrailEntity);
		} catch (DataAccessException e) {
			String message = "DataAccessException while retrieving all audit trails for entity :"
					+ auditTrailEntity.getTableName()
					+ " with id "
					+ auditTrailEntity.getKeyId()
					+ ". Error: "
					+ e.getMessage();
			throw new ServiceException(message, e);
		}
		vo.setObjectXml(auditTrailEntity.getObjectXml());
	}

	/**
	 * @return logged in user id
	 */
	public String getLoggedInUserId() {
		LoggerUtil.ibsJobDebug("getting logged in user id");
		UserDetails userDetails =null;
		try{
		 userDetails = getUserDetails();
		}
		catch(Exception e){
			throw new ServiceException("Unexpected error while getting loggedin user id",e);
		}
		return (userDetails != null) ? userDetails.getUsername() : "";
	}

	/**
	 * @return logged in user's details
	 */
	public UserDetails getUserDetails() {
		LoggerUtil.ibsJobDebug("getting logged in user details");
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal);
		} else {
			return null;
		}
	}


	@Override
	public List<String>  getMaker(V vo) throws ServiceException {
		List<String> value;
		E entity = getEntity(vo);
		AuditTrail<E> auditTrail = new AuditTrail<E>(entity);
		LoggerUtil.ibsJobDebug("getting maker with id: "+auditTrail.getKeyId());
		try {
			value =  auditTrailDao.getMakerForMaxVersion(auditTrail);
		} catch (DataAccessException e) {
			String message = "DataAccessException while fetching maker for entity :"
					+ auditTrail.getTableName() + " with id "
					+ auditTrail.getKeyId() + ". Error: " + e.getMessage();
			throw new ServiceException(message, e);
		}
		return value;
	}

	@Override
	public int getMakerVersion(V vo) throws ServiceException {
		int value = 0;
		E entity = getEntity(vo);
		AuditTrail<E> auditTrail = new AuditTrail<E>(entity);
		LoggerUtil.ibsJobDebug("getting maker version with id: "+auditTrail.getKeyId());
		try {
			value= auditTrailDao.getMakerVersion(auditTrail);
		} catch (DataAccessException e) {
			String message = "DataAccessException while fetching maker for entity :"
					+ auditTrail.getTableName() + " with id "
					+ auditTrail.getKeyId() + ". Error: " + e.getMessage();
			throw new ServiceException(message, e);
		}
		return value;
	}
	public AuditTrailDao<E> getAuditTrailDao() {
		return auditTrailDao;
	}

	public void setAuditTrailDao(AuditTrailDao<E> auditTrailDao) {
		this.auditTrailDao = auditTrailDao;
	}

}
