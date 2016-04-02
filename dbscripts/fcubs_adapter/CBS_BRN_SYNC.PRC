create or replace
PROCEDURE CBS_BRN_SYNC
IS

	l_err  varchar2(32767);
	l_errmsg varchar2(32767);
	p_sync_date number;
	l_stat BOOLEAN;
	l_set_sync  timestamp;

	CURSOR brn_rec  ( p_sync_date number)
	IS
	 (SELECT branch_code,branch_name,branch_addr1,branch_addr2,branch_addr3,
	 (select today from sttm_DATES@FCUBSREF where branch_code=a.branch_code) brn_Date,
	 END_OF_INPUT brn_Eod_stat,
	 branch_lcy
 	 FROM sttm_branch@FCUBSREF A WHERE record_stat='O'
	 AND TO_CHAR(a.checker_dt_stamp,'YYYYMMDDHHMMSS')>p_sync_date);
	

BEGIN

	BEGIN
	
		SELECT  TO_CHAR(BRN_SYNC_TIME,'YYYYMMDDHHMMSS') 
		INTO p_sync_date
		FROM iftb_cbs_sync;

	EXCEPTION 
  	WHEN OTHERS THEN
		pr_write_debug('NO DATA IN IFTB_CBS_SYNC');
	END;
	


	l_set_sync:=systimestamp;

	FOR l_rec in brn_rec(p_sync_date)
	LOOP
	
	IF brn_rec%FOUND
	THEN
	pr_write_debug(l_rec.branch_code);
	
	
		
		BEGIN
		
		DELETE FROM iftw_branch_details 
		WHERE branch_code=l_rec.branch_code;
		
		EXCEPTION WHEN others
		THEN
			NULL;
			pr_write_debug('no data');
		END;	
		
		
	
		INSERT INTO iftw_branch_details
    		VALUES
		(l_rec.branch_code,
		l_rec.branch_name,
		l_rec.branch_addr1,
		l_rec.branch_addr2,
		l_rec.branch_addr3,
    		null,
		l_rec.brn_date,
		l_rec.brn_eod_stat,
		l_rec.branch_lcy
		);
		
		
		
	END IF;
	
	END LOOP;
	
	pr_write_debug('End Loop');
	
	/*BEGIN
		
		UPDATE iftb_cbs_sync		
		SET brn_sync='Y',;	
		
	EXCEPTION
	WHEN OTHERS THEN
		pr_write_debug('ERROR');
	END;*/
	
	BEGIN
		
		IBS_BRN_SYNC(l_set_sync,l_stat,l_errmsg);
		
		IF NOT l_stat
		THEN
			pr_write_debug(l_errmsg);
		END IF;
		
		EXCEPTION WHEN OTHERS
		THEN
		
		pr_write_debug(l_errmsg);
			
	END

COMMIT;

EXCEPTION
WHEN OTHERS THEN

	pr_write_debug('WHEN OTHERS THEN');
END;