package com.bfsi.mfi.util;

import java.lang.reflect.Field;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Vishal
 *
 */

public class ApplicationUtil {
	
	/*SOP are Commented ==> Changes for Asomi Nirmal kanna S*/
	
	public static long dateAsLongFormat(Date date) {
		long dateAsLong = 0L;
		try {
			if(date != null){
				dateAsLong = date.getTime();
			}
		} catch(Exception e){
			LoggerUtil.mbsJobError("Unhandeled Exception while convert date as milisecond : MFI10001", e);
		}		
		return dateAsLong;
	}
	
	public static Date longAsDateFormat(long date) {
		Date destDate = null;
		try {
			destDate = new Date(date);			
		} catch(Exception e){
			LoggerUtil.mbsJobError("Unhandeled Exception while convert milisecond as date : MFI10001", e);
		}		
		return destDate;
	}
	
	public static java.sql.Date longAsSqlDateFormat(long date) {
		java.sql.Date destDate = null;
		try {
			destDate = new java.sql.Date(date);			
		} catch(Exception e){
			LoggerUtil.mbsJobError("Unhandeled Exception while convert milisecond as date : MFI10001", e);
		}		
		return destDate;
	}
	
	public static String DateAsStringFormat(Date date, String dateFormat) {
		String dateAsString = null;
		try {
			Format formatter = new SimpleDateFormat(dateFormat);
			dateAsString = formatter.format(date);			
		} catch(Exception e){			
			LoggerUtil.mbsJobError("Unhandeled Exception while convert milisecond as date : MFI10001", e);
		}		
		return dateAsString;
	}	
	
	public static boolean checkNull(String value){
		if(value != null && value.trim().length()> 0){
			return true;
			
		}else {
			return false;
		}
	}

	
	@SuppressWarnings("rawtypes")
	public static <E> String getDynamicQuery(E bean, Class objClass,
			String query) {
		try {
			Field[] field = objClass.getDeclaredFields();
			int counter = 1;
			
			for(Field f : field){
				
				//System.out.println("==========="+counter);
				String name = f.getName();
				try {
					String value   = (String) f.get(bean);
					if(value != null && value.trim().length()>0){
						if(counter == 1){
							query =query + name +"='"+value+"'";
							counter++;
						} else {
							query =query +" and "+ name +"='"+value+"'";
							counter++;
						}
					}
					
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				//System.out.println("======sql query===="+query);
			}
			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return query;
	}
	
	
	
}
