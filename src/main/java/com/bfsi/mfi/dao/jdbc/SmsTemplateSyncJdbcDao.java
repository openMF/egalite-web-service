package com.bfsi.mfi.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bfsi.mfi.dao.SmsTemplateSyncDao;
import com.bfsi.mfi.entity.SmsTemplateDetail;
import com.bfsi.mfi.query.ApplicationQuery;

/**
 * 
 * @author Vishal
 *
 */
@Repository("smsTemplateSyncDao")
public class SmsTemplateSyncJdbcDao extends BaseJdbcDao implements SmsTemplateSyncDao {

	@Override
	public List<SmsTemplateDetail> getSmsTemplate() {
		Map<String, String> params = new HashMap<String, String>();
		return jdbcTemplate.query(ApplicationQuery.MBS_SYNC_QUERY_SELECT_SMS_TEMPLATE, params,
				new SmsTemplateMapper());		
	}

	
	
	private static final class SmsTemplateMapper implements RowMapper<SmsTemplateDetail> {
		public SmsTemplateDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			SmsTemplateDetail smsTemplate = new SmsTemplateDetail();
			
			smsTemplate.setTxnCode(rs.getString("TXN_CODE"));
			smsTemplate.setTxnSms(rs.getString("TXT_SMS"));
			smsTemplate.setDynFields(rs.getString("DYNAMIC_FIELDS"));			
			return smsTemplate;
		}
	}

	
}
