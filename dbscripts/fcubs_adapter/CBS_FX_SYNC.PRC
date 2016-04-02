create or replace
PROCEDURE CBS_FX_SYNC
IS

	l_err  varchar2(32767);
	l_errmsg varchar2(32767);
	p_sync_date number;

	CURSOR fx_rec  ( p_sync_date number)
	IS
	(SELECT branch_code,CCY1,CCY2, buy_rate,sale_rate FROM cytm_rates@FCUBSREF a
	WHERE a. branch_code=(SELECT ho_branch FROM sttm_bank@FCUBSREF)
	AND a.rate_type='STANDARD'
	AND  TO_CHAR(a.rate_Date,'YYYYMMDD')>p_sync_date);
	
	
BEGIN

	BEGIN
	
		SELECT  TO_CHAR(LOAN_SYNC_TIME,'YYYYMMDD') 
		INTO p_sync_date
		FROM iftb_cbs_sync;

	EXCEPTION 
  	WHEN OTHERS THEN
	DBMS_OUTPUT.PUT_LINE('NO DATA IN IFTB_CBS_SYNC');
	END;
	




	FOR l_rec in fx_rec(p_sync_date)
	LOOP
	
	IF fx_rec%FOUND
	THEN
	DBMS_OUTPUT.PUT_LINE(l_rec.ccy1||l_rec.ccy2);
	
		
		BEGIN
		
		DELETE FROM iftw_fx_rates 
		WHERE ccy1=l_rec.ccy1 AND ccy2=l_rec.ccy2 AND brn_code=l_rec.branch_code;
		
		EXCEPTION WHEN others
		THEN
			NULL;
			DBMS_OUTPUT.PUT_LINE('no data');
		END;	
		
		
	
		INSERT INTO iftw_fx_rates
    		VALUES
		(
		l_rec.ccy1,
		l_rec.ccy2,
		l_rec.buy_rate,
		l_rec.sale_Rate,
		l_rec.branch_code
    		);
		
		
		
	END IF;
	
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('End Loop');
	
	BEGIN
		
		UPDATE iftb_cbs_sync		
		SET ccy_sync='Y';	
		
	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('ERROR');
	END;

COMMIT;

EXCEPTION
WHEN OTHERS THEN

	DBMS_OUTPUT.PUT_LINE('WHEN OTHERS THEN');
END;
