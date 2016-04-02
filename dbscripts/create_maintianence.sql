CREATE TABLE "IBSMFI"."AMTB_AGENCYS"
(
   AGENCY_CODE varchar2(25) PRIMARY KEY NOT NULL,
   AGENCY_DESC varchar2(105),
   ADDRESS1 varchar2(105),
   ADDRESS2 varchar2(105),
   ADDRESS3 varchar2(105),
   ADDRESS4 varchar2(105),
   AUTH_STATUS varchar2(10) DEFAULT 'U',
   CONTACTNUMBER varchar2(20),
   AGENCY_STATUS varchar2(20) DEFAULT 'A'
);

CREATE TABLE "IBSMFI"."AMTB_AGENTS"
(
   AGENT_ID varchar2(100) PRIMARY KEY NOT NULL,
   AGENT_TYPE varchar2(50),
   CREDIT_OFFICER varchar2(50),
   CASH_LIMIT decimal(10),
   DEVICE_ID varchar2(100),
   AGENT_STATUS varchar2(50),
   FIRST_NAME varchar2(100),
   LAST_NAME varchar2(100),
   DATE_OF_BIRTH timestamp,
   GENDER varchar2(50),
   COMM_ADDRESS1 varchar2(100),
   COMM_ADDRESS2 varchar2(100),
   COMM_ADDRESS3 varchar2(100),
   COMM_POST_CODE varchar2(100),
   MOBILE varchar2(20),
   EMAIL_ID varchar2(50),
   AGENT_START_DATE timestamp,
   AGENT_END_DATE timestamp,
   AGENT_LANG varchar2(50),
   ROLE_ID varchar2(50),
   AGENCY_CODE varchar2(50),
   AUTH_STATUS varchar2(50) DEFAULT 'U',
   USER_NAME varchar2(100),
   DATA_KEY varchar2(100),
   REG_KEY varchar2(100),
   REG_KEY_EXPIRY_TIME timestamp,
   REG_STATUS varchar2(50) DEFAULT 'U'
);

CREATE TABLE "IBSMFI"."AMTB_AUDIT_DETAIL"
(
   TABLE_NAME varchar2(100) NOT NULL,
   KEY_ID varchar2(100) NOT NULL,
   VERSION_NO decimal(22) NOT NULL,
   MAKER_ID varchar2(25),
   MAKER_DT timestamp,
   CHECKER_ID varchar2(25),
   CHECKER_DT timestamp,
   OBJECT_XML varchar2(2108),
   CONSTRAINT SYS_C0012434 PRIMARY KEY (TABLE_NAME,KEY_ID,VERSION_NO)
);

CREATE TABLE "IBSMFI"."AMTB_CASH_SETTLEMENT"
(
   ID varchar2(25),
   AGENT_ID varchar2(10) NOT NULL,
   CCY_CODE varchar2(3),
   SYSTEM_POSITION decimal(10),
   TXN_TYPE varchar2(10),
   CASHIN_OUT varchar2(10),
   REMARKS varchar2(10),
   AMOUNT decimal(10),
   TXN_TIME timestamp NOT NULL,
   AUTH_STATUS varchar2(50),
   CONSTRAINT SYS_C0011735 PRIMARY KEY (AGENT_ID,TXN_TIME)
);

CREATE TABLE "IBSMFI"."IFTB_CCY_DETAILS " 
(
   CCY_CODE varchar2(5) PRIMARY KEY NOT NULL,
   CCY_DESC varchar2(100),
   ISO_ALT_CCY varchar2(5),
   CCY_DECIMALS NUMBER
);

CREATE TABLE "IBSMFI"."AMTB_DEVICE"
(
   DEVICE_ID varchar2(25) PRIMARY KEY NOT NULL,
   DEVICE_TYPE varchar2(100),
   UNIQUE_ID varchar2(100),
   ISSUED_DATE timestamp,
   LAST_SYNC timestamp,
   DEVICE_STATUS varchar2(50),
   ISSUED_BY varchar2(100),
   BRAND_MODEL varchar2(100),
   OPERATING_SYSTEM varchar2(100),
   APP_VERSION varchar2(100),
   AUTH_STATUS varchar2(50) DEFAULT 'U',
   MOBILE_NUMBER decimal(22)
);

CREATE TABLE "IBSMFI"."AMTB_FUNCTION"
(
   FUNC_ID varchar2(25) PRIMARY KEY NOT NULL,
   BASE_FUNC varchar2(100),
   FUNC_DESC varchar2(100),
   FUNC_COMMAND varchar2(100)
)
;
CREATE TABLE "IBSMFI"."AMTB_LIST_VALUE"
(
   LIST_NAME varchar2(200) NOT NULL,
   LIST_VALUE varchar2(8) NOT NULL,
   DESN varchar2(200),
   STATUS char(1),
   CONSTRAINT SYS_C0011551 PRIMARY KEY (LIST_NAME,LIST_VALUE)
)	
;
CREATE TABLE "IBSMFI"."AMTB_PARAMETERS"
(
   PARAM_NAME varchar2(100) PRIMARY KEY NOT NULL,
   PARAM_TEXT varchar2(100),
   PARAM_TYPE varchar2(100),
   PARAM_VALUE varchar2(100),
   EDITABLE varchar2(10),
   COMPONENTS varchar2(100)
)
;
CREATE TABLE "IBSMFI"."AMTB_ROLE_ENTITLEMENT"
(
   ROLE_ID varchar2(25),
   FUNC_ID varchar2(25)
)
;
CREATE TABLE "IBSMFI"."AMTB_ROLES"
(
   ROLE_ID varchar2(25) PRIMARY KEY NOT NULL,
   ROLE_NAME varchar2(50),
   ROLE_DESC varchar2(100),
   AUTH_STATUS varchar2(50)
)
;
CREATE TABLE "IBSMFI"."AMTB_USER_ROLES"
(
   USER_ID varchar2(25),
   ROLE_ID varchar2(50)
)
;
CREATE TABLE "IBSMFI"."AMTB_USERS"
(
   USER_ID varchar2(25) PRIMARY KEY NOT NULL,
   BRANCH_CODE varchar2(10),
   FIRST_NAME varchar2(100),
   LAST_NAME varchar2(100),
   DATE_OF_BIRTH timestamp,
   GENDER varchar2(50),
   COMMUNICATION_ADDRESS1 varchar2(100),
   COMMUNICATION_ADDRESS2 varchar2(100),
   COMMUNICATION_ADDRESS3 varchar2(100),
   COMMUNICATION_POSTAL_CODE varchar2(20),
   PERMANENT_ADDRESS1 varchar2(100),
   PERMANENT_ADDRESS2 varchar2(100),
   PERMANENT_ADDRESS3 varchar2(100),
   PERMANENT_POSTAL_CODE varchar2(20),
   MOBILE_NUMBER varchar2(20),
   EMAIL_ID varchar2(100),
   PASSWORD varchar2(100),
   USER_TYPE varchar2(50),
   USER_STATUS varchar2(50),
   START_DATE timestamp,
   END_DATE timestamp,
   NO_OF_FAILED_LOGINS decimal(22),
   LAST_LOGIN_DATE timestamp,
   USER_PREV_PASSWORD1 varchar2(100),
   USER_PREV_PASSWORD2 varchar2(100),
   AUTH_STATUS varchar2(50) DEFAULT 'U'

)
;
CREATE TABLE "IBSMFI"."IFTB_BRANCH_DETAILS"
(
   BRANCH_CODE varchar2(10),
   BRANCH_NAME varchar2(100),
   BRN_ADD1 varchar2(100),
   BRN_ADD2 varchar2(100),
   BRN_ADD3 varchar2(100),
   BRN_DATE timestamp,
   BRN_EOD_STAT char(1),
   BRN_LCY varchar2(3),
   SYNC_TIME timestamp,
   SYNC_STAT varchar2(2)
)
;
CREATE TABLE "IBSMFI"."IFTB_CBS_JOB_HISTORY"
(
   JOB_ID varchar2(25) PRIMARY KEY NOT NULL,
   RECORD_TYPE varchar2(50),
   TIMESTAMP timestamp,
   RECORD_ID varchar2(50),
   OPERATION varchar2(1)
)
;
CREATE TABLE "IBSMFI"."IFTB_CBS_SYNC"
(
   LOAN_SYNC_TIME timestamp,
   CUST_SYNC_TIME timestamp,
   BRN_SYNC_TIME timestamp,
   CCY_SYNC_TIME timestamp,
   LOAN_SYNC char(1),
   CUST_SYNC char(1),
   BRN_SYNC char(1),
   CCY_SYNC char(1)
)
;
CREATE TABLE "IBSMFI"."IFTB_CL_LIQ"
(
   LOAN_AC_NO varchar2(25),
   BRANCH_CODE varchar2(5),
   VALUE_DATE timestamp,
   EXECUTION_DATE timestamp,
   PAYMENT_STATUS varchar2(2),
   SETTLE_MODE varchar2(15),
   SETTLE_CCY varchar2(5),
   SETTLE_AMOUNT decimal(22),
   EVENT_SEQ_NO decimal(22)
)
;
CREATE TABLE "IBSMFI"."IFTB_CLACCOUNT_SCHEDULES"
(
   LOAN_AC_NO varchar2(25),
   BRANCH_CODE varchar2(5),
   COMPONENT_NAME varchar2(25),
   SCHEDULE_TYPE varchar2(2),
   SCHEDULE_ST_DATE timestamp,
   SCHEDULE_DUE_DATE timestamp,
   AMOUNT_DUE decimal(22),
   ADJ_AMOUNT decimal(22),
   AMOUNT_SETTLED decimal(22),
   AMOUNT_OVERDUE decimal(22),
   ACCRUED_AMOUNT decimal(22),
   SETTLEMENT_CCY varchar2(5),
   LCY_EQUIVALENT decimal(22)
)
;
CREATE TABLE "IBSMFI"."IFTB_CUST_DETAIL"
(
   CUSTOMER_ID varchar2(15) PRIMARY KEY NOT NULL,
   CUSTOMER_NAME varchar2(100),
   PHONE_NUMBER char(10),
   CITY varchar2(100),
   LOC_CODE varchar2(100),
   LOC_NAME varchar2(100),
   VIEW_FILE varchar2(100),
   CREDIT_OFFICER varchar2(100),
   SYNC_STATUS varchar2(25) NOT NULL,
   SYNC_TIME timestamp,
   RECORD_STAT varchar2(1)
)
;
CREATE TABLE "IBSMFI"."IFTB_DISBR_SCHEDULES"
(
   LOAN_AC_NO varchar2(25),
   BRANCH_CODE varchar2(5),
   COMPONENT_NAME varchar2(25),
   SCHEDULE_ST_DATE timestamp,
   SCHEDULE_DUE_DATE timestamp,
   AMOUNT_TO_DISBR decimal(22),
   DTYPE varchar2(3),
   MANUAL_AMT_DISBR decimal(22),
   CUR_DISBR_AMT decimal(22),
   AMT_DISBURSED decimal(22)
)
;
CREATE TABLE "IBSMFI"."IFTB_DISBURSEMENT"
(
   TXN_ID varchar2(100) PRIMARY KEY NOT NULL,
   TXN_NARRATIVE varchar2(100),
   TXN_AMOUNT decimal(22)
)
;
CREATE TABLE "IBSMFI"."IFTB_FX_RATES"
(
   CCY1 varchar2(3),
   CCY2 varchar2(3),
   BUY_RATE decimal(22),
   SALE_RATE decimal(22),
   BRN_CODE varchar2(10),
   SYNC_TIME timestamp,
   SYNC_STAT varchar2(2),
   RECORD_STAT varchar2(1);
)
;
CREATE TABLE "IBSMFI"."IFTB_LOAN_DETAILS"
(
   LOAN_AC_NO varchar2(25) NOT NULL,
   CUSTOMER_ID varchar2(15),
   CUSTOMER_NAME varchar2(100),
   LOCATION_NAME varchar2(100),
   LOCATION_ID varchar2(100),
   NEXT_REPAYMENT_DATE timestamp,
   OVERDUE_STATUS char(10),
   DISBURSEMENT_DATE timestamp,
   OVER_DUE_DATE timestamp,
   SANCTIONED_DATE timestamp,
   GROUP_FLAG char(10),
   GROUP_NAME varchar2(100),
   LAST_REPAYMENT_DATE timestamp,
   DISBURSEMENT_STATUS char(10),
   GROUP_ID char(10),
   AGENT_ID varchar2(100),
   SYNC_STATUS varchar2(25),
   SYNC_TIME timestamp,
   ALT_ACC_NO varchar2(25),
   LOAN_AC_CCY varchar2(5),
   RECORD_STAT varchar2(1)
)
;
CREATE TABLE "IBSMFI"."IFTB_LOAN_ENRICHMENT"
(
   LOAN_AC_NO varchar2(25),
   AGENT_ID varchar2(25)
)
;
CREATE TABLE "IBSMFI"."IFTB_REPAYMENT"
(
   TXN_ID varchar2(100) PRIMARY KEY NOT NULL,
   TXN_NARRATIVE varchar2(100),
   TXN_AMOUNT decimal(22),
   REPAYMENT_INST varchar2(100)
)
;
CREATE TABLE "IBSMFI"."IFTB_TRANSACTION_STATUS"
(
   TXN_ID varchar2(100) PRIMARY KEY NOT NULL,
   SESSION_ID varchar2(100),
   STATUS varchar2(100)
)
;
CREATE TABLE "IBSMFI"."IFTB_TRANSACTIONS"
(
   TXN_ID varchar2(100) PRIMARY KEY NOT NULL,
   TXN_TIMESTAMP timestamp,
   TXN_TYPE varchar2(100),
   AGENT_ID varchar2(100),
   LOAN_AC_NO varchar2(100),
   CUSTOMER_ID varchar2(100),
   DEVICE_ID varchar2(100),
   AUTH_STATUS varchar2(100),
   SYNC_TIME timestamp,
   TXN_STATUS varchar2(100),
   TXN_AMOUNT decimal(22),
   TXN_CCY varchar2(100)
)
;
CREATE TABLE "IBSMFI"."IFTW_BRANCH_DETAILS"
(
   BRANCH_CODE varchar2(10),
   BRANCH_NAME varchar2(100),
   BRN_ADD1 varchar2(100),
   BRN_ADD2 varchar2(100),
   BRN_ADD3 varchar2(100),
   BRN_ADD4 varchar2(100),
   BRN_DATE timestamp,
   BRN_EOD_STAT varchar2(2),
   BRN_LCY varchar2(5)
)
;
CREATE TABLE "IBSMFI"."IFTW_CL_LIQ"
(
   LOAN_AC_NO varchar2(25),
   BRANCH_CODE varchar2(5),
   VALUE_DATE timestamp,
   EXECUTION_DATE timestamp,
   PAYMENT_STATUS varchar2(2),
   SETTLE_MODE varchar2(15),
   SETTLE_CCY varchar2(5),
   SETTLE_AMOUNT decimal(22),
   EVENT_SEQ_NO decimal(22)
)
;
CREATE TABLE "IBSMFI"."IFTW_CLACCOUNT_SCHEDULES"
(
   LOAN_AC_NO varchar2(25),
   BRANCH_CODE varchar2(5),
   COMPONENT_NAME varchar2(25),
   SCHEDULE_TYPE varchar2(2),
   SCHEDULE_ST_DATE timestamp,
   SCHEDULE_DUE_DATE timestamp,
   AMOUNT_DUE decimal(22),
   ADJ_AMOUNT decimal(22),
   AMOUNT_SETTLED decimal(22),
   AMOUNT_OVERDUE decimal(22),
   ACCRUED_AMOUNT decimal(22),
   SETTLEMENT_CCY varchar2(5),
   LCY_EQUIVALENT decimal(22)
)
;
CREATE TABLE "IBSMFI"."IFTW_CUST_DETAILS"
(
   CUSTOMER_ID varchar2(10) NOT NULL,
   CUSTOMER_NAME varchar2(100),
   PHONE_NUMBER varchar2(15),
   CITY varchar2(100),
   LOC_CODE varchar2(100),
   LOC_NAME varchar2(100),
   VIEW_FILE varchar2(100),
   CREDIT_OFFICER varchar2(100),
   SYNC_STATUS varchar2(25) NOT NULL
)
;
CREATE TABLE "IBSMFI"."IFTW_DISBR_SCHEDULES"
(
   LOAN_AC_NO varchar2(25),
   BRANCH_CODE varchar2(5),
   COMPONENT_NAME varchar2(25),
   SCHEDULE_ST_DATE timestamp,
   SCHEDULE_DUE_DATE timestamp,
   AMOUNT_TO_DISBR decimal(22),
   DTYPE varchar2(3),
   MANUAL_AMT_DISBR decimal(22),
   CUR_DISBR_AMT decimal(22),
   AMT_DISBURSED decimal(22)
)
;
CREATE TABLE "IBSMFI"."IFTW_FX_RATES"
(
   CCY1 varchar2(3),
   CCY2 varchar2(3),
   BUY_RATE decimal(22),
   SALE_RATE decimal(22),
   BRN_CODE varchar2(10)
)
;
CREATE TABLE "IBSMFI"."IFTW_LOAN_DETAILS"
(
   LOAN_AC_NO varchar2(25) NOT NULL,
   CUSTOMER_ID char(10),
   CUSTOMER_NAME varchar2(100),
   LOCATION_NAME varchar2(100),
   LOCATION_ID varchar2(100),
   NEXT_REPAYMENT_DATE timestamp,
   OVERDUE_STATUS char(10),
   DISBURSEMENT_DATE timestamp,
   OVER_DUE_DATE timestamp,
   SANCTIONED_DATE timestamp,
   GROUP_FLAG char(10),
   GROUP_NAME varchar2(100),
   LAST_REPAYMENT_DATE timestamp,
   DISBURSEMENT_STATUS char(10),
   GROUP_ID char(10),
   AGENT_ID varchar2(100),
   SYNC_STATUS varchar2(25),
   ALT_ACC_NO varchar2(25),
   LOAN_AC_CCY varchar2(5),
   RECORD_STAT varchar2(2)
)
;
 CREATE TABLE "IBSMFI"."IFTB_ENRICHED_ENROL"(  
	ENROL_CUSTADD_CODE  VARCHAR2(255 BYTE) NOT NULL ENABLE,
	CUST_ENRICH_HOMEBRANCH VARCHAR2(255 BYTE),
	CUST_ENRICH_CUSTCATEGORY VARCHAR2(255 BYTE),
	CUST_ENRICH_REL_OFFICER VARCHAR2(255 BYTE)
)
;

CREATE TABLE iftb_Mdisburment( LOAN_AC_NO VARCHAR2(25)NOT NULL,
SANCTION_AMT NUMBER,
CUSTOMER_NAME VARCHAR2(105),
DISBURSEMENT_DATE TIMESTAMP(6),
DISBURSEMENT_AMT NUMBER,
AGENT_ID VARCHAR2(25),
MAKER_ID VARCHAR2(25),
CHECKER_ID VARCHAR2(25),
MAKER_DT_STAMP TIMESTAMP,
CHECKER_DT_STAMP TIMESTAMP,
RECORD_STAT VARCHAR2(1),
PRIMARY KEY (LOAN_AC_NO)
);

CREATE TABLE AMTB_REF_CODE_MASTER (REF_MASTER_CODE VARCHAR2(25) PRIMARY KEY NOT NULL, 
CODE_DESC VARCHAR2(105), 
PURPOSE VARCHAR2(105), 
RECORD_STAT VARCHAR2(105) DEFAULT 'CLOSE',
AUTH_STATUS VARCHAR2(10) DEFAULY 'U');

ALTER TABLE "IBSMFI"."AMTB_ROLE_ENTITLEMENT"
ADD CONSTRAINT SYS_C0012008
FOREIGN KEY (ROLE_ID)
REFERENCES "IBSMFI"."AMTB_ROLES"(ROLE_ID)
;
ALTER TABLE "IBSMFI"."AMTB_ROLE_ENTITLEMENT"
ADD CONSTRAINT SYS_C0012009
FOREIGN KEY (FUNC_ID)
REFERENCES "IBSMFI"."AMTB_FUNCTION"(FUNC_ID)
;
ALTER TABLE "IBSMFI"."AMTB_USER_ROLES"
ADD CONSTRAINT SYS_C0011644
FOREIGN KEY (USER_ID)
REFERENCES "IBSMFI"."AMTB_USERS"(USER_ID)
;

alter table iftw_loan_details add( amount_disbursed  number, princ_outstand  number);
alter table iftb_loan_details add( amount_disbursed  number, princ_outstand  number);
alter table iftw_loan_details add( amount_sanctioned  number);
alter table iftb_loan_details add( amount_sanctioned  number);

ALTER TABLE iftw_cust_details ADD
(
address_line1 VARCHAR2(100),
address_line2  VARCHAR2(100),
unique_id_name VARCHAR2(100),
unique_id_value VARCHAR2(100),
DOB VARCHAR2(100),
SEX VARCHAR2(100),
COUNTRY VARCHAR2(100),
IMAGE   BLOB
);

alter table iftw_cust_details add (state varchar2(50));

ALTER TABLE iftb_cust_detail ADD
(
address_line1 VARCHAR2(100),
address_line2  VARCHAR2(100),
unique_id_name VARCHAR2(100),
unique_id_value VARCHAR2(100),
DOB VARCHAR2(100),
SEX VARCHAR2(100),
COUNTRY VARCHAR2(100),
IMAGE   BLOB, 
state  varchar2(50)
);

alter table iftb_loan_enrichment add (allocate_user varchar2(25), allocation_time timestamp);
ALTER TABLE IFTB_LOAN_ENRICHMENT Add PRIMARY KEY (LOAN_AC_NO);

Alter table amtb_cash_settlement  MODIFY REMARKS varchar2(30);
 
###################################Chakri changes #########################################

alter table IFTB_BRANCH_DETAILS add  job_id varchar(25);
alter table IFTB_CUST_DETAIL  add  job_id varchar(25);
alter table IFTB_FX_RATES add  job_id varchar(25);
alter table IFTB_LOAN_DETAILS add  job_id varchar(25);
alter table iftb_ccy_details   add  record_stat varchar(2);
alter table iftb_ccy_details   add  job_id varchar(25);
alter table iftb_loan_details rename column disbursement_date to last_disbr_date;
alter table iftw_loan_details rename column disbursement_date to last_disbr_date;

alter table iftw_loan_details add( amount_disbursed  number, princ_outstand  number);
alter table iftb_loan_details add( amount_disbursed  number, princ_outstand  number);
alter table iftw_loan_details add( amount_sanctioned  number);--, princ_outstand  number);
alter table iftb_loan_details add( amount_sanctioned  number);
alter table iftw_loan_details add( CREDIT_OFFICER  VARCHAR2(50));--, princ_outstand  number);
alter table iftb_loan_details add( CREDIT_OFFICER  VARCHAR2(50));
ALTER TABLE IFTB_CBS_SYNC  ADD (FX_SYNC_TIME TIMESTAMP,FX_SYNC VARCHAR2(2))
alter table IFTB_BRANCH_DETAILS add record_stat varchar2(1);

UPDATE IFTB_CBS_SYNC set ccy_sync_time=NULL;
UPDATE IFTB_CBS_SYNC set LOAN_sync_time=NULL;
UPDATE IFTB_CBS_SYNC set CUST_sync_time=NULL;
UPDATE IFTB_CBS_SYNC set BRN_sync_time=NULL;
UPDATE IFTB_CBS_SYNC set FX_sync_time=NULL;
ALTER TABLE IFTB_CBS_SYNC MODIFY CCY_SYNC_TIME VARCHAR(16);
ALTER TABLE IFTB_CBS_SYNC MODIFY LOAN_SYNC_TIME VARCHAR(16);
ALTER TABLE IFTB_CBS_SYNC MODIFY CUST_SYNC_TIME VARCHAR(16);
ALTER TABLE IFTB_CBS_SYNC MODIFY BRN_SYNC_TIME VARCHAR(16);
ALTER TABLE IFTB_CBS_SYNC MODIFY FX_SYNC_TIME VARCHAR(16);
UPDATE IFTB_CBS_SYNC set ccy_sync_time='20000101000000';
UPDATE IFTB_CBS_SYNC set LOAN_sync_time='20000101000000';
UPDATE IFTB_CBS_SYNC set CUST_sync_time='20000101000000';
UPDATE IFTB_CBS_SYNC set BRN_sync_time='20000101000000';
UPDATE IFTB_CBS_SYNC set FX_sync_time='20000101000000';
UPDATE IFTB_FX_RATES SET SYNC_TIME=NULL;
ALTER TABLE IFTB_FX_RATES MODIFY SYNC_TIME VARCHAR2(16)


ALTER TABLE iftw_loan_details modify customer_id varchar2(15);
ALTER TABLE iftb_loan_details modify SYNC_TIME varchar2(16);
ALTER TABLE iftb_cust_detail modify SYNC_TIME varchar2(16);
ALTER TABLE iftb_cust_detail modify PHONE_NUMBER varchar2(15);

ALTER TABLE iftb_branch_details modify SYNC_TIME varchar2(16);

ALTER table iftw_loan_details add branch_code varchar2(5);

ALTER table iftb_loan_details add branch_code varchar2(5);
UPDATE iftb_loan_details SET branch_code=SUBSTR(loan_ac_no,1,3);


ALTER TABLE iftb_disbr_schedules ADD mob_txn_id varchar2(25);
ALTER TABLE iftw_disbr_schedules ADD mob_txn_id varchar2(25);


delete from iftb_loan_details;

begin
cbs_loan_sync;
end;

begin
cbs_cust_sync;
end;

UPDATE IFTB_CBS_SYNC set LOAN_sync_time='20000101000000', loan_sync='N';
UPDATE IFTB_CBS_SYNC set CUST_sync_time='20000101000000', cust_sync='N';


ALTER TABLE iftw_loan_details add job_id VARCHAR2(25);
ALTER TABLE iftb_cust_detail add job_id VARCHAR2(25);
ALTER TABLE iftw_cust_details add job_id VARCHAR2(25);
ALTER TABLE iftw_fx_rates add job_id VARCHAR2(25);
ALTER TABLE iftw_branch_details add job_id VARCHAR2(25);
ALTER TABLE iftb_ccy_details add sync_time VARCHAR2(16);
ALTER TABLE iftb_ccy_details add SYNC_STATUS VARCHAR2(25);
ALTER TABLE iftw_ccy_details add job_id VARCHAR2(25);


create table iftb_cbs_job_detail(
JOB_ID varchar2(50),
START_TIME timestamp,
STARTED_BY varchar2(100),
END_TIME timestamp,
constraint pk_jobid primary key(job_id)
);


alter table IFTB_REPAYMENT add TXN_CCY VARCHAR2(5) 
alter table IFTB_DISBURSEMENT add txn_ccy varchar2(5) 

CREATE TABLE IFTB_CUSTOMER_DOCUMENT_DATA ( 
ENROLLMENT_ID varchar2(100),
DOCUMENT_ID varchar2(100),
DOCUMENT_NAME varchar2(100),
DOCUMENT_TAG varchar2(100),
DATA blob,
CONSTRAINT pk_customer PRIMARY KEY(ENROLLMENT_ID, DOCUMENT_ID) 
); 

CREATE TABLE IFTB_CUSTOMER_INFO_DATA ( 
ENROLLMENT_ID varchar2(100) primary key,
FIRST_NAME varchar2(100),
LAST_NAME varchar2(100),
MIDDLE_NAME varchar2(100),
DOB date,
GENDER varchar2(100),
ADDRESS1 varchar2(100),
ADDRESS2 varchar2(100),
CONTACT_NO varchar2(100),
EMAIL_ID varchar2(100),
COUNTRY varchar2(100),
STATE varchar2(100),
ZIP_CODE varchar2(100),
CURRENCY varchar2(100),
RESIDENCE_TYPE varchar2(100),
NATIONALITY varchar2(100),
MARTIAL_STATUS varchar2(100),
PROFESSION varchar2(100),
PROFESSION_REMARK varchar2(100),
ENROLL_DATE date,
ENRICH_STAT varchar2(2),
DEVICE_ID varchar2(100),
SYNC_TIME date,
ACCOUNT_TYPE varchar2(50),
ACCOUNT_TYPE_REMARK varchar2(50)
);

alter table IFTB_TRANSACTIONS 
add TXN_ERROR  VARCHAR2(100)

alter table IFTB_TRANSACTIONS 
add BRANCH_CODE varchar2(100)

create table iftb_cbs_job_detail(
JOB_ID varchar2(50),
START_TIME timestamp,
STARTED_BY varchar2(100),
END_TIME timestamp,
CONSTRAINT pk_jobid PRIMARY KEY(JOB_ID) 
);

alter table IFTB_REPAYMENT 
add TXN_CCY VARCHAR2(5) 

alter table IFTB_DISBURSEMENT 
add TXN_CCY VARCHAR2(5) 


ALTER TABLE iftb_claccount_schedules MODIFY AMOUNT_DUE NUMBER;
ALTER TABLE iftb_claccount_schedules MODIFY ADJ_AMOUNT NUMBER;
ALTER TABLE iftb_claccount_schedules MODIFY AMOUNT_SETTLED NUMBER;
ALTER TABLE iftb_claccount_schedules MODIFY AMOUNT_OVERDUE NUMBER;
ALTER TABLE iftb_claccount_schedules MODIFY ACCRUED_AMOUNT NUMBER;
ALTER TABLE iftb_claccount_schedules MODIFY LCY_EQUIVALENT NUMBER;

ALTER TABLE iftw_claccount_schedules MODIFY AMOUNT_DUE NUMBER;
ALTER TABLE iftw_claccount_schedules MODIFY ADJ_AMOUNT NUMBER;
ALTER TABLE iftw_claccount_schedules MODIFY AMOUNT_SETTLED NUMBER;
ALTER TABLE iftw_claccount_schedules MODIFY AMOUNT_OVERDUE NUMBER;
ALTER TABLE iftw_claccount_schedules MODIFY ACCRUED_AMOUNT NUMBER;
ALTER TABLE iftw_claccount_schedules MODIFY LCY_EQUIVALENT NUMBER;

ALTER TABLE iftb_disbr_schedules MODIFY AMOUNT_TO_DISBR NUMBER;
ALTER TABLE iftb_disbr_schedules MODIFY MANUAL_AMT_DISBR NUMBER;
ALTER TABLE iftb_disbr_schedules MODIFY CUR_DISBR_AMT NUMBER;
ALTER TABLE iftb_disbr_schedules MODIFY AMT_DISBURSED NUMBER;

ALTER TABLE iftw_disbr_schedules MODIFY AMOUNT_TO_DISBR NUMBER;
ALTER TABLE iftw_disbr_schedules MODIFY MANUAL_AMT_DISBR NUMBER;
ALTER TABLE iftw_disbr_schedules MODIFY CUR_DISBR_AMT NUMBER;
ALTER TABLE iftw_disbr_schedules MODIFY AMT_DISBURSED NUMBER;

ALTER TABLE iftb_fx_rates MODIFY BUY_RATE NUMBER;
ALTER TABLE iftb_fx_rates MODIFY SALE_RATE NUMBER;

ALTER TABLE iftW_fx_rates MODIFY BUY_RATE NUMBER;
ALTER TABLE iftW_fx_rates MODIFY SALE_RATE NUMBER;

CREATE TABLE IFTB_ENRICHED_ENROL(
ENROL_CUSTADD_CODE VARCHAR2(255 BYTE) NOT NULL ENABLE,
CUST_ENRICH_HOMEBRANCH VARCHAR2(255 BYTE),
CUST_ENRICH_CUSTCATEGORY VARCHAR2(255 BYTE),
CUST_ENRICH_REL_OFFICER VARCHAR2(255 BYTE)
)

******************************* Starts From dd/mm/2014 ******************************* 

******************************* Ends Here *******************************

******************************* Starts From dd/mm/2014 ******************************* 

******************************* Ends Here *******************************

