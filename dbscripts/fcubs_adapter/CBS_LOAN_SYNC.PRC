CREATE OR REPLACE
PROCEDURE CBS_LOAN_SYNC
IS

	l_err  varchar2(32767);
	l_errmsg varchar2(32767);
	p_sync_date number;

	CURSOR loan_rec  ( p_sync_date number)
	IS
	SELECT account_number,
		       customer_id,
		       (SELECT CUSTOMER_NAME1 FROM STTM_CUSTOMER@FCUBSREF WHERE CUSTOMER_NO= a.customer_id) CNAME,
			'LOC' LOCATION,
			'LOCATION' LOCATION_NAME,
			(SELECT TRIM(MIN(schedule_due_date)) FROM cltb_account_schedules@FCUBSREF
			 WHERE account_number=A.account_number
			 AND component_name='PRINCIPAL' AND amount_settled=0) NEXT_REPAYMENT_DATE,
			'NORMAL' STATUS,
			(SELECT TRIM(MAX(value_date)) FROM cltb_event_entries@FCUBSREF WHERE event_code='DSBR' AND account_number=a.account_number ) DISBURSEMENT_DATE,
			(SELECT TRIM(MIN(schedule_due_date)) FROM cltb_account_schedules@FCUBSREF
			WHERE account_number=A.account_number
			AND component_name='PRINCIPAL' AND (amount_settled-amount_due)<0) OVER_DUE_DATE, 
			original_st_date SANCTIONED_DATE,
			'N' GROUP_FLAG,
			'GRPNAM' GROUP_NAME,
			(SELECT TRIM(MAX(schedule_due_date)) FROM cltb_account_schedules@FCUBSREF
			WHERE account_number=A.account_number
			AND component_name='PRINCIPAL' AND amount_settled<>0) LAST_REPAYMENT_DATE, 
			'DIBR' DIS_STAT,
			'GRP1' GROUP_NAM,
			'AGENT1' AGENT,
			NULL
		FROM cltb_account_master@FCUBSREF A
		where account_status<>'C' AND EXISTS 
		                                    (SELECT 1 
		                                    FROM cltb_account_events_diary@FCUBSREF b 
		                                    WHERE b.account_number=a.account_number 
	                                    	    AND TO_CHAR(b.checker_dt_stamp,'YYYYMMDD')>p_sync_date);

BEGIN

	BEGIN
	
		SELECT  TO_CHAR(LOAN_SYNC_TIME,'YYYYMMDD') 
		INTO p_sync_date
		FROM iftb_cbs_sync;

	EXCEPTION 
  	WHEN OTHERS THEN
	DBMS_OUTPUT.PUT_LINE('NO DATA IN IFTB_CBS_SYNC');
	END;
	




	FOR l_rec in loan_rec(p_sync_date)
	LOOP
	
	IF loan_rec%FOUND
	THEN
	--DBMS_OUTPUT.PUT_LINE(l_rec.ACCOUNT_NUMBER);
	
		
		BEGIN
		
		DELETE FROM iftw_loan_details 
		WHERE loan_ac_no=l_rec.account_number;
		
		EXCEPTION WHEN NO_DATA_FOUND
		THEN
			NULL;
		END;	
		
	
		INSERT INTO iftw_loan_details
    		VALUES
		(l_rec.account_number,
		l_rec.customer_id,
		l_rec.cname,
		l_rec.LOCATION_NAME,
		l_rec.LOCATION,
		l_rec.NEXT_REPAYMENT_DATE,
		l_rec.STATUS,
		l_rec.DISBURSEMENT_DATE,
		l_rec.OVER_DUE_DATE,
		l_rec.SANCTIONED_DATE,
		l_rec.GROUP_FLAG,
		l_rec.GROUP_NAME,
		l_rec.LAST_REPAYMENT_DATE,
		l_rec.DIS_STAT,
		l_rec.GROUP_NAM,
		l_rec.AGENT,
		NULL);
	END IF;
	
	END LOOP;
	
	BEGIN
		UPDATE iftw_loan_details
		SET SYNC_STATUS='Y';
		
		UPDATE iftb_cbs_sync		
		SET loan_sync='Y';	
		
	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('ERROR');
	END;

COMMIT;

EXCEPTION
WHEN OTHERS THEN

	DBMS_OUTPUT.PUT_LINE('WHEN OTHERS THEN');
END;
