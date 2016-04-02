package com.bfsi.mfi.entity;

import java.util.List;

import com.bfsi.mfi.vo.LovVO;

public class LovServiceResponse extends ServiceResponse {
	private List<LovVO> lovList;

	public List<LovVO> getLovList() {
		return lovList;
	}

	public void setLovList(List<LovVO> lovList) {
		this.lovList = lovList;
	}

}
