package com.bfsi.mfi.rest.constants;

public class ServiceConstants {
	public final static int delay = 60 * 1000;
	public final static int interval = 90 * 1000;
	public static final String READY_TO_CBS = "R";
	public static final Object REAPYMENT_STATUS = "R";
	public static final String PROCESSED_STATUS = "P";
	public static final String ACK_STATUS = "A";
	public static final String SOURCE = "EXTSYS";
	public static final String MODULEID = "CL";
	public static final String SERVICE = "FCUBSCLService";
	public static final String AUTHSTAT = "A";
	public static final String DIS_USERID = "KREDIT01";
	public static final String DIS_OPERATION = "CreateDisbursement";
	public static final String DIS_FUNCTIONID = "CLDMNDSB";
	public static final String REPAY_USERID = "KREDIT01";
	public static final String REPAY_OPERATION = "CreatePayment";
	public static final String REPAY_FUNCTIONID = "CLDPYMNT";
	public static final String SUCCESS = "SUCCESS";
	public static final String SETTLE_MODE = "ACC";
	//public static final String SETTLE_ACC = "389809111";
	//Shabu
	public static final String SETTLE_ACC = "111209111";
	public static final String FAILURE = "F";	
	
	/* Withdraw/ Deposit tran parameter */
	public static final String RT_USERID = "SYSTEM";
	public static final String RT_SOURCE ="EXTSYS";
	public static final String  RT_SERVICE ="FCUBSRTService";
	public static final String  RT_OPERATION ="CreateTransaction";
}
