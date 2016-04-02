 create table iftb_cbs_sync
    (
    loan_sync_time   timestamp,
    cust_sync_time   timestamp,
    brn_sync_time    timestamp,
    ccy_sync_time    TIMESTAMP,
    loan_sync        CHAR(1),
    cust_sync        CHAR(1),
    brn_sync         CHAR(1),
    ccy_sync         CHAR(1)
    );
    CREATE TABLE IFTW_CUST_DETAILS AS SELECT *fROM iftb_cust_detail;
    CREATE TABLE IFTW_LOAN_DETAILS AS SELECT *fROM iftb_loan_details1;
    alter table iftw_cust_Details modify phone_number varchar2(15);
    alter table iftb_cust_Details modify phone_number varchar2(15);

