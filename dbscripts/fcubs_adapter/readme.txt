Select *From iftw_loan_detals
 
BEGIN
CBS_LOAN_SYNC;
END;
 
select *From IFTW_CUST_DETAILS
BEGIN
cbs_cust_sync;
END;
/
 
select *From IFTW_branch_DETAILS
BEGIN
cbs_brn_sync;
END;
/