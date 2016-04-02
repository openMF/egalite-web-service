package com.bfsi.mfi.vo;

import com.bfsi.mfi.entity.Function;

public class FunctionVO extends MaintenanceVO<Function> {
	public FunctionVO() {
		entity = new Function();
	}
	
	public FunctionVO(Function entity) {
		super(entity);
	}
	public String getBaseFunc() {
		return entity.getBaseFunc();
	}

	public void setBaseFunc(String baseFunc) {
		entity.setBaseFunc(baseFunc); 
	}

	public String getFuncDesc() {
		return entity.getFuncDesc();
	}

	public void setFuncDesc(String funcDesc) {
		entity.setFuncDesc(funcDesc); 
	}

	public String getFuncCommand() {
		return entity.getFuncCommand();
	}

	public void setFuncCommand(String funcCommand) {
		entity.setFuncCommand(funcCommand);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getBaseFunc() == null) ? 0 : getBaseFunc().hashCode());
		result = prime * result
				+ ((getFuncCommand() == null) ? 0 : getFuncCommand().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunctionVO other = (FunctionVO) obj;
		if (getBaseFunc()  == null) {
			if (other.getBaseFunc() != null)
				return false;
		} else if (!getBaseFunc().equals(other.getBaseFunc()))
			return false;
		if (getFuncCommand() == null) {
			if (other.getFuncCommand() != null)
				return false;
		} else if (!getFuncCommand().equals(other.getFuncCommand()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getFuncDesc();
	}
}
