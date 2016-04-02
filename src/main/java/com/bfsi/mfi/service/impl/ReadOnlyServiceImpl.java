package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bfsi.mfi.dao.ReadOnlyMaintenanceDao;
import com.bfsi.mfi.entity.MaintenanceEntity;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.ReadOnlyMaintenanceService;
import com.bfsi.mfi.vo.MaintenanceVO;

public abstract class ReadOnlyServiceImpl<V extends MaintenanceVO, E extends MaintenanceEntity>
		implements ReadOnlyMaintenanceService<V, E> {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected abstract <T extends ReadOnlyMaintenanceDao<E>> T getReadOnlyMaintenanceDao();

	protected abstract E getEntity(V vo);

	protected abstract V getValueObject(E entity);

	@Override
	public List<V> get() {
		List<E> entities = getReadOnlyMaintenanceDao().get();
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
	public V get(String id) throws ServiceException
	{
		E entity = getReadOnlyMaintenanceDao().get(id);
		return getValueObject(entity);
	}


}


