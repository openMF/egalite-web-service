package com.bfsi.mfi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "MFI_DEPOSIT_ACTIVITY_V")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositActivity extends MaintenanceEntity {
	public DepositActivity() {
	}
	private String depositAccountNumber;
	
	@Column(name = "BRANCH_CODE", nullable = false)
	private String branchCode;
	
	@Column(name = "TXN_TYPE", nullable = false)
	private String txnType;
	
	@Column(name = "TXN_TYPE_ST_DATE", nullable = false)
	private Date txnTypeStDate;
	
	@Column(name = "TXN_TYPE_END_DATE", nullable = false)
	private Date txnTypeEndDate;
	
	@Column(name = "TXN_TYPE_DUE_DATE", nullable = false)
	private Date txnTypeDueDate;
	
	@Column(name = "TXN_TYPE_DESC", nullable = false)
	private String txnTypeDesc;
	
	@Column(name = "IBS_AGENDA_PICK_DATE", nullable = false)
	private Date ibsAgendaPickDate;
	
	@Column(name = "TXN_CCY_CODE", nullable = false)
	private String txnCcyCode;
	
	@Column(name = "TXN_LCY_CODE", nullable = false)
	private String txnLcyCode;
	
	@Column(name = "ALLOCATED_CO", nullable = false)
	private String allocatedCo;
	
	@Column(name = "TXN_AMT_DUE", nullable = false)
	private Integer txnAmtDue;
	
	@Column(name = "TXN_AMT_DUE_LCY", nullable = false)
	private Integer txnAmtDueLcy;
	
	@Column(name = "TXN_AMT_SETTLED", nullable = false)
	private Integer txnAmtSettled;
	
	@Column(name = "TXN_AMT_SETTLED_LCY", nullable = false)
	private Integer txnAmtSettledLcy;
	
	@Column(name = "AGENDA_ID", nullable = false)
	private String agendaId;
	
	@Column(name = "IS_SETTLED", nullable = false)
	private String isSettled;
	
	

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Date getTxnTypeStDate() {
		return txnTypeStDate;
	}

	public void setTxnTypeStDate(Date txnTypeStDate) {
		this.txnTypeStDate = txnTypeStDate;
	}

	public Date getTxnTypeEndDate() {
		return txnTypeEndDate;
	}

	public void setTxnTypeEndDate(Date txnTypeEndDate) {
		this.txnTypeEndDate = txnTypeEndDate;
	}

	public Date getTxnTypeDueDate() {
		return txnTypeDueDate;
	}

	public void setTxnTypeDueDate(Date txnTypeDueDate) {
		this.txnTypeDueDate = txnTypeDueDate;
	}

	public String getTxnTypeDesc() {
		return txnTypeDesc;
	}

	public void setTxnTypeDesc(String txnTypeDesc) {
		this.txnTypeDesc = txnTypeDesc;
	}

	public Date getIbsAgendaPickDate() {
		return ibsAgendaPickDate;
	}

	public void setIbsAgendaPickDate(Date ibsAgendaPickDate) {
		this.ibsAgendaPickDate = ibsAgendaPickDate;
	}

	public String getTxnCcyCode() {
		return txnCcyCode;
	}

	public void setTxnCcyCode(String txnCcyCode) {
		this.txnCcyCode = txnCcyCode;
	}

	public String getTxnLcyCode() {
		return txnLcyCode;
	}

	public void setTxnLcyCode(String txnLcyCode) {
		this.txnLcyCode = txnLcyCode;
	}

	public String getAllocatedCo() {
		return allocatedCo;
	}

	public void setAllocatedCo(String allocatedCo) {
		this.allocatedCo = allocatedCo;
	}

	public Integer getTxnAmtDue() {
		return txnAmtDue;
	}

	public void setTxnAmtDue(Integer txnAmtDue) {
		this.txnAmtDue = txnAmtDue;
	}

	public Integer getTxnAmtDueLcy() {
		return txnAmtDueLcy;
	}

	public void setTxnAmtDueLcy(Integer txnAmtDueLcy) {
		this.txnAmtDueLcy = txnAmtDueLcy;
	}

	public Integer getTxnAmtSettled() {
		return txnAmtSettled;
	}

	public void setTxnAmtSettled(Integer txnAmtSettled) {
		this.txnAmtSettled = txnAmtSettled;
	}

	public Integer getTxnAmtSettledLcy() {
		return txnAmtSettledLcy;
	}

	public void setTxnAmtSettledLcy(Integer txnAmtSettledLcy) {
		this.txnAmtSettledLcy = txnAmtSettledLcy;
	}

	public String getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(String agendaId) {
		this.agendaId = agendaId;
	}

	public String getIsSettled() {
		return isSettled;
	}

	public void setIsSettled(String isSettled) {
		this.isSettled = isSettled;
	}

	public String getDepositAccountNumber() {
		return depositAccountNumber;
	}

	public void setDepositAccountNumber(String depositAccountNumber) {
		this.depositAccountNumber = depositAccountNumber;
	}
	

}