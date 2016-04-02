package com.bfsi.mfi.vo;

import java.util.Date;

import com.bfsi.mfi.entity.DepositActivity;

/**
 * @author bablu
 * 
 */
public class DepositActivityVO extends MaintenanceVO<DepositActivity> {
	public DepositActivityVO() {
		entity = new DepositActivity();
	}

	public DepositActivityVO(DepositActivity entity) {
		super(entity);
	}

	public String getDepositAccountNumber() {
		return super.getId();
	}

	public void setDepositAccountNumber(String depositAccountNumber) {
		super.setId(depositAccountNumber);
	}

	public String getBranchCode()  {
		return entity.getBranchCode() ;
	}

	public void setBranchCode(String branchCode) {
		entity.setBranchCode(branchCode);
	}
	public String getTxnType()  {
		return entity.getTxnType() ;
	}

	public void setTxnType(String txnType) {
		entity.setTxnType(txnType);
	}
	public Date getTxnTypeStDate()  {
		return entity.getTxnTypeStDate() ;
	}

	public void setTxnTypeStDate(Date txnTypeStDate) {
		entity.setTxnTypeStDate(txnTypeStDate);
	}
	public Date getTxnTypeEndDate()  {
		return entity.getTxnTypeEndDate() ;
	}

	public void setTxnTypeEndDate(Date txnTypeEndDate) {
		entity.setTxnTypeEndDate(txnTypeEndDate);
	}
	public Date getTxnTypeDueDate() {
		return entity.getTxnTypeDueDate();
	}

	public void setTxnTypeDueDate(Date txnTypeDueDate) {
		entity.setTxnTypeDueDate(txnTypeDueDate);
	}
	public String getTxnTypeDesc() {
		return entity.getTxnTypeDesc()  ;
	}

	public void setTxnTypeDesc(String txnTypeDesc){
		entity.setTxnTypeDesc(txnTypeDesc);
	}
	public Date getIbsAgendaPickDate()  {
		return entity.getIbsAgendaPickDate() ;
	}

	public void setIbsAgendaPickDate(Date ibsAgendaPickDate) {
		entity.setIbsAgendaPickDate(ibsAgendaPickDate);
	}
	public String getTxnCcyCode() {
		return entity.getTxnCcyCode() ;
	}

	public void setTxnCcyCode(String txnCcyCode) {
		entity.setTxnCcyCode(txnCcyCode);
	}
	public String getTxnLcyCode()  {
		return entity.getTxnLcyCode() ;
	}

	public void setTxnLcyCode(String txnLcyCode) {
		entity.setTxnLcyCode(txnLcyCode);
	}
	public String getAllocatedCo() {
		return entity.getAllocatedCo() ;
	}

	public void setAllocatedCo(String allocatedCo){
		entity.setAllocatedCo(allocatedCo);
	}
	public Integer getTxnAmtDue() {
		return entity.getTxnAmtDue() ;
	}

	public void setTxnAmtDue(Integer txnAmtDue) {
		entity.setTxnAmtDue(txnAmtDue);
	}
	public Integer getTxnAmtDueLcy() {
		return entity.getTxnAmtDueLcy() ;
	}

	public void setTxnAmtDueLcy(Integer txnAmtDueLcy) {
		entity.setTxnAmtDueLcy(txnAmtDueLcy);
	}
	public Integer getTxnAmtSettled() {
		return entity.getTxnAmtSettled();
	}

	public void setTxnAmtSettled(Integer txnAmtSettled){
		entity.setTxnAmtSettled(txnAmtSettled);
	}
	public Integer getTxnAmtSettledLcy() {
		return entity.getTxnAmtSettledLcy() ;
	}

	public void setTxnAmtSettledLcy(Integer txnAmtSettledLcy){
		entity.setTxnAmtSettledLcy(txnAmtSettledLcy);
	}
	public String getAgendaId() {
		return entity.getAgendaId() ;
	}

	public void setAgendaId(String agendaId){
		entity.setAgendaId(agendaId);
	}
	public String getIsSettled() {
		return entity.getIsSettled() ;
	}

	public void setIsSettled(String isSettled){
		entity.setIsSettled(isSettled);
	}	
}