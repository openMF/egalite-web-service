package com.cbs.rmi.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.PropertyResourceBundle;

import com.bfsi.mfi.util.LoggerUtil;

/**
 * DBConnection  for Managing Database Activities
 * @author Bfsi-Vishal
 * @version 1.0
 * @since 1.0
 */

public class DBConnection {
	private PropertyResourceBundle resourceBundle = null;
	private static volatile DBConnection connManager = null;
	
	private DBConnection() {
		try {
			LoggerUtil.ibsJobDebug("CBS Connection Started ............................");
			this.resourceBundle = (PropertyResourceBundle) PropertyResourceBundle
				.getBundle("cbsConnection", new Locale("en", "US"));
		
			Class.forName(this.resourceBundle.getString("cbs.jdbc.driverClassName"));
			LoggerUtil.ibsJobDebug("CBS Connection Driver Connected ............................");
				
		} catch (ClassNotFoundException cnfe) {
			LoggerUtil.cbsJobError(
					"ClassNotFoundException Caught while loading driver class",	cnfe);
		} catch (Exception e) {
			LoggerUtil.cbsJobError("Exception Caught while loading driver class", e);
		}
	}
	
	public static DBConnection getInstance() {
		if(connManager == null) {
			synchronized(DBConnection.class) {
				if(connManager == null) {
					connManager = new DBConnection();
				}
			}
		}
		return connManager;
	}
		  
  /**
	 * Get the connection from oracle database. 
	 * @param
	 * @return  Connection
	 * @throws SQLException
	 */

		public Connection getConnection() throws SQLException {
		    Connection connection = null;
		     try {
		    	 LoggerUtil.ibsJobDebug("CBS Connection started 1 ............................"); 
		    	connection = DriverManager.getConnection(this.resourceBundle.getString("cbs.jdbc.url"), this.resourceBundle.getString("cbs.jdbc.username"), this.resourceBundle.getString("cbs.jdbc.password"));
		    	LoggerUtil.ibsJobDebug("CBS Connection started 2 ............................"); 
		    	
		    }  catch (SQLException e) {
		    	LoggerUtil.cbsJobError(
						"SQLException Caught while getConnection :",
						e);		
			}
		    return connection;
		    
		  }
		
		/**
		 * Closes the active Connection if open
		 * @throws SQLException
		 * @throws Exception
		 */
		public void closeConnection(Connection connection) {
			try {
				if (null != connection) {
					if (!connection.isClosed()) {
						connection.close();
						connection = null;
					}
				}
			} catch (SQLException se) {
				
			} catch (Exception e) {
				
			} finally {
				if (connection != null) {
					connection = null;
				}
			}
		}		
}