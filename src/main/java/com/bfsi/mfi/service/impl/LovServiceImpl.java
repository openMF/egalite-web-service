package com.bfsi.mfi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bfsi.mfi.dao.LovDao;
import com.bfsi.mfi.entity.LovDetail;
import com.bfsi.mfi.entity.LovServiceResponse;
import com.bfsi.mfi.exception.ServiceException;
import com.bfsi.mfi.service.LovService;
import com.bfsi.mfi.vo.LovVO;

/**
 * 
 * @author Vishal
 *
 */

@Service(value = "lovService")
public class LovServiceImpl implements LovService {
	@Autowired
	LovDao lovDao;

	@Override
	public LovServiceResponse getLovDetails() {
		// TODO Auto-generated method stub
		LovServiceResponse l_res = new LovServiceResponse();
		List<LovDetail> l_lovList=null;
		List<LovVO> l_lovVoList=new ArrayList<LovVO>();
		LovVO l_lovVo = null;
		try {
			l_lovList = lovDao.getLovDetails();
			for(LovDetail l_etity : l_lovList ){
				l_lovVo = new LovVO(l_etity);
				BeanUtils.copyProperties(l_etity, l_lovVo);
				l_lovVoList.add(l_lovVo);				
			}
			l_res.setLovList(l_lovVoList);
			l_res.setStatus(true);
			
		}catch(DataAccessException e){			
			throw new ServiceException("DataAccessException while fetch lov data",e);
		}
		catch (Exception e) {			
			throw new ServiceException("Unhandled Exception while fetch lov data",e);
		}
		return l_res;		
	}

	
	
}
