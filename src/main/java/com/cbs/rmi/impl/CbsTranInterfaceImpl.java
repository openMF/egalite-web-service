package com.cbs.rmi.impl;



import com.bfsi.mfi.util.LoggerUtil;
import com.cbs.bean.CbsBaseTransRequest;
import com.cbs.bean.CbsBaseTransResponse;
import com.cbs.bean.CbsCashDepositTranRequest;
import com.cbs.bean.CbsCashWithdrawTranRequest;
import com.cbs.bean.CustomerEnrolInfo;
import com.cbs.service.CbsTranInterface;

public class CbsTranInterfaceImpl implements CbsTranInterface {

	CbsTransactionJdbcDao tranDao = new CbsTransactionJdbcDao();

	public CbsTranInterfaceImpl() throws Exception {
	}

	@Override
	public CbsBaseTransResponse postGenericTransReq(CbsBaseTransRequest p_req)
			throws Exception {

		CbsBaseTransResponse l_res = new CbsBaseTransResponse();
		try {
			l_res = tranDao.postTransaction(p_req);

		} catch (Exception e) {
			LoggerUtil.cbsJobError("Could not send requ: ",e);
			l_res.setCbsResStat("X");
			l_res.setResponseCode("1");
			l_res.setResponseMessage("Send Valid Transaction Request.");
		}

		return l_res;
	}
	
	@Override
	public CbsBaseTransResponse postCustEnrol(CustomerEnrolInfo p_req)
			throws Exception {
		CbsBaseTransResponse l_res = new CbsBaseTransResponse();
		int result = 0;
		try {
			if(p_req == null || p_req.getEnrolmentId() == null){
				l_res.setCbsResStat("X");
				l_res.setResponseCode("1");
				l_res.setResponseMessage("Send Valid Customer Request.");
				return l_res;
			}
			result = tranDao.postCustPersonalEnrolInfo(p_req);			
			if(result != 0 && p_req.getDocument()!=null){
				result = tranDao.postCustDocInfo(p_req.getDocument());
			}
			if(result != 0){
				l_res.setCbsResStat("P");
				//l_res.setResponseMessage("SUCCESS");
				l_res.setResponseCode("0");
				l_res.setResponseMessage("Customer Enrolment Request processed successfuly.");
				l_res.setCbsResTxnRefNo(generateRandomId());
				
			} else {
				l_res.setCbsResStat("E");
				l_res.setResponseCode("1");
				l_res.setResponseMessage("Customer Enrolment Request Failed.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			l_res.setCbsResStat("X");
			l_res.setResponseCode("1");
			l_res.setResponseMessage("Customer Enrolment Request Failed.");
		}
		return l_res;
	}
	
	private String generateRandomId() {
		StringBuffer uniqueRandomId = new StringBuffer(50);
		char c[] = new char[12];
		java.util.Random r = new java.util.Random();
		String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 12; i++) {
			int j = r.nextInt(62);
			if (s.length() > j) {
				c[i] = s.charAt(j);
				uniqueRandomId.append(c[i]);
				//uniqueRandomId += c[i];
			} else {
				i--;
			}
		}
		return uniqueRandomId.toString();
	}

	@Override
	public CbsBaseTransResponse postCashWithdrawReq(
			CbsCashWithdrawTranRequest p_req) throws Exception {
		CbsBaseTransResponse l_res = new CbsBaseTransResponse();
		CbsBaseTransRequest l_bTran = new CbsBaseTransRequest();
		try {
			if(p_req == null ){
				l_res.setCbsResStat("X");
				l_res.setResponseCode("1");
				l_res.setResponseMessage("Send Valid Transaction Request.");
				return l_res;
			}
			//EGA-MN15-000015 Start
			l_res=tranDao.validateCashTransaction(p_req.getCustId(), p_req.getAccNo(), p_req.getBranchCode(), p_req.getTxnCode(), p_req.getAmountSettled());
			
			if(!l_res.getCbsResStat().equals("P"))
				return l_res;
			//EGA-MN15-000015 End
			
			l_bTran.setMfiOutSeqno(p_req.getIbsOutSeqNo());	
			l_bTran.setMbsTxnRefNo(p_req.getTxnRefNo());
			if(p_req.getSeqNo() != null){
				l_bTran.setMbsTxnSeqNo(String.valueOf(p_req.getSeqNo()));
			}			
			l_bTran.setCbsAcRefNo(p_req.getAccNo());
			l_bTran.setCustomerId(p_req.getCustId());
			l_bTran.setCbsBranchCode(p_req.getBranchCode());
			l_bTran.setModuleCode(p_req.getModuleCode());
			l_bTran.setTxnCode(p_req.getTxnCode());
			l_bTran.setTxnIdentifier(p_req.getTxnIdentifier());
			
			//l_bTran.setAgnAmtDue(p_req.getAmountDue());
			l_bTran.setAgnAmtSettled(p_req.getAmountSettled());
			l_bTran.setTxnCcy(p_req.getCcyCode());
			l_bTran.setCbsSentTime(p_req.getTxnInitTime());
			// bussiness Date Added
			l_bTran.setBusiDate(p_req.getBusiDate());
			
			l_res = tranDao.postTransaction(l_bTran);
		} 
			
		catch(Exception e){
			e.printStackTrace();
			l_res.setCbsResStat("X");
			l_res.setResponseCode("1");
			l_res.setResponseMessage("Send Valid Transaction Request.");
		}
		
		return l_res;
	}

	@Override
	public CbsBaseTransResponse postCashDepositReq(
			CbsCashDepositTranRequest p_req) throws Exception {
		CbsBaseTransResponse l_res = new CbsBaseTransResponse();
		CbsBaseTransRequest l_bTran = new CbsBaseTransRequest();
		try {
			if(p_req == null ){
				l_res.setCbsResStat("X");
				l_res.setResponseCode("1");
				l_res.setResponseMessage("Transaction Request has been failed at host.");
				return l_res;
			}
			//EGA-MN15-000015 Start
			l_res=tranDao.validateCashTransaction(p_req.getCustId(), p_req.getAccNo(), p_req.getBranchCode(), p_req.getTxnCode(), p_req.getAmountSettled());
			
			if(!l_res.getCbsResStat().equals("P"))
				return l_res;
			
			//EGA-MN15-000015 End
			l_bTran.setMfiOutSeqno(p_req.getIbsOutSeqNo());	
			l_bTran.setMbsTxnRefNo(p_req.getTxnRefNo());
			if(p_req.getSeqNo() != null){
				l_bTran.setMbsTxnSeqNo(String.valueOf(p_req.getSeqNo()));
			}
			l_bTran.setCbsAcRefNo(p_req.getAccNo());
			l_bTran.setCustomerId(p_req.getCustId());
			l_bTran.setCbsBranchCode(p_req.getBranchCode());
			l_bTran.setModuleCode(p_req.getModuleCode());
			l_bTran.setTxnCode(p_req.getTxnCode());
			l_bTran.setTxnIdentifier(p_req.getTxnIdentifier());
			
			//l_bTran.setAgnAmtDue(p_req.getAmountDue());
			l_bTran.setAgnAmtSettled(p_req.getAmountSettled());
			l_bTran.setTxnCcy(p_req.getCcyCode());
			l_bTran.setCbsSentTime(p_req.getTxnInitTime());
			// bussiness Date Added
			l_bTran.setBusiDate(p_req.getBusiDate());
			
			l_res = tranDao.postTransaction(l_bTran);			
			
		} catch(Exception e){
			e.printStackTrace();
			l_res.setCbsResStat("X");
			l_res.setResponseCode("1");
			l_res.setResponseMessage("Transaction Request has been failed at host.");
		}
		
		return l_res;
	}
	

}
