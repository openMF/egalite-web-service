CREATE OR REPLACE PROCEDURE CBS_CUST_SYNC
IS

	l_err  varchar2(32767);
	l_errmsg varchar2(32767);
	p_sync_date number;

	CURSOR cust_rec  ( p_sync_date number)
	IS
	(SELECT distinct customer_no, customer_name1 ,
	(SELECT mobile_number FROM sttm_cust_personal@FCUBSREF where customer_no=a.customer_no) mobile,
	address_line2 city,'LOC' loc_code,'LOCATION' loc_name--, customer_no as view_file,NULL,'SYNC' 
	FROM sttm_customer@FCUBSREF a , cltb_account_master@FCUBSREF b
	WHERE a.customer_no= b.customer_id
	AND RECORD_STAT='O'
	AND to_char(a.checker_dt_stamp,'YYYYMMDD')>p_sync_date)
	;

BEGIN

	BEGIN
	
		SELECT  TO_CHAR(LOAN_SYNC_TIME,'YYYYMMDD') 
		INTO p_sync_date
		FROM iftb_cbs_sync;

	EXCEPTION 
  	WHEN OTHERS THEN
	DBMS_OUTPUT.PUT_LINE('NO DATA IN IFTB_CBS_SYNC');
	END;
	




	FOR l_rec in cust_rec(p_sync_date)
	LOOP
	
	IF cust_rec%FOUND
	THEN
	DBMS_OUTPUT.PUT_LINE(l_rec.CUSTOMER_NO);
	
		
		BEGIN
		
		DELETE FROM iftw_cust_details 
		WHERE customer_id=l_rec.customer_no;
		
		EXCEPTION WHEN others
		THEN
			NULL;
			DBMS_OUTPUT.PUT_LINE('no data');
		END;	
		
		
	
		INSERT INTO iftw_cust_details
    		VALUES
		(l_rec.customer_no,
		l_rec.customer_name1,
		l_rec.mobile,
		l_rec.city,
		l_rec.loc_code,
		l_rec.loc_name,
		l_rec.customer_no||'.xml',
		null,
		'Y'
		);
		
		
		
	END IF;
	
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('End Loop');
	
	BEGIN
		UPDATE iftw_cust_details
		SET SYNC_STATUS='Y';
		
		UPDATE iftb_cbs_sync		
		SET cust_sync='Y';	
		
	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('ERROR');
	END;

COMMIT;

EXCEPTION
WHEN OTHERS THEN

	DBMS_OUTPUT.PUT_LINE('WHEN OTHERS THEN');
END;
