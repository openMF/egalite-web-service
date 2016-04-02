package com.bfsi.mfi.vo;



import com.bfsi.mfi.entity.FunctionMbs;

public class FunctionMbsVO extends MaintenanceVO<FunctionMbs> {
	
	
	public Object clone() {

		FunctionMbsVO copyObj = new FunctionMbsVO();
		copyObj.setId(super.getId());
		copyObj.setAuthStatus(this.getAuthStatus());
		copyObj.setBaseFunc(this.getBaseFunc());
		copyObj.setFuncDesc(this.getFuncDesc());
		return copyObj;
		/*
		 * try{
		 * 
		 * return super.clone(); }catch(Exception e){ return null; }
		 */
	}
	
	
	public FunctionMbsVO() {
		entity = new FunctionMbs();
	}
	
	public FunctionMbsVO(FunctionMbs entity) {
		super(entity);
	}
	public String getBaseFunc() {
		return this.entity.getBaseFunc();
	}

	public void setBaseFunc(String baseFunc) {
		this.entity.setBaseFunc(baseFunc); 
	}
	
	public String getFuncDesc() {
		return entity.getFuncDesc();
	}

	public void setFuncDesc(String funcDesc) {
		entity.setFuncDesc(funcDesc); 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getId() == null) ? 0 : getId().hashCode());
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
		FunctionMbsVO other = (FunctionMbsVO) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
	
	

	/*@Override
	public String toString() {
		return getBaseFunc();
	}*/
	
}
