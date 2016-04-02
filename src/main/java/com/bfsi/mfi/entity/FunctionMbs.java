package com.bfsi.mfi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.primefaces.model.TreeNode;

import com.bfsi.mfi.vo.FunctionMbsVO;

/**
 * Function entity
 * 
 * @author Jyoti Ranjan
 * 
 */

@Entity(name = "MFI_FUNCTION")
public class FunctionMbs extends MaintenanceEntity {
	public FunctionMbs() {
	}

	@Column(name = "BASE_FUNC", nullable = false)
	private String baseFunc;

	@Column(name = "FUNC_DESC", nullable = false)
	private String funcDesc;
	

	public String getBaseFunc() {
		return baseFunc;
	}

	public void setBaseFunc(String baseFunc) {
		this.baseFunc = baseFunc;
	}

	public String getFuncDesc() {
		return funcDesc;
	}

	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
	}
	
}
