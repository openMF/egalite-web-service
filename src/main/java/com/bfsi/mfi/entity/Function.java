package com.bfsi.mfi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Function entity
 * 
 * @author Jyoti Ranjan
 * 
 */

@Entity(name = "AMTB_FUNCTION")
public class Function extends MaintenanceEntity {
	public Function() {
	}

	@Column(name = "BASE_FUNC", nullable = false)
	private String baseFunc;

	@Column(name = "FUNC_DESC", nullable = false)
	private String funcDesc;

	@Column(name = "FUNC_COMMAND", nullable = false)
	private String funcCommand;

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

	public String getFuncCommand() {
		return funcCommand;
	}

	public void setFuncCommand(String funcCommand) {
		this.funcCommand = funcCommand;
	}

}
