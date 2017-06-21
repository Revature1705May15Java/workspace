package com.ers.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Uses the Singleton Design Pattern to create a connection to the ERS database
 * @author Gian-Carlo
 *
 */
public class ConnectionFactory {
	private static Boolean build = true;
	private static ConnectionFactory cf = null;
	
	/**
	 * No-arg constructor
	 */
	private ConnectionFactory() {
		build = false;
	}
	
	/**
	 * Gets the instance of this class
	 * @return instance of this class
	 */
	public static synchronized ConnectionFactory getInstance() {
		if (build)
			cf = new ConnectionFactory();
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/Gian-Carlo/Documents/Revature/Training/Projects/Employee_Reimbursement/src/com/ers/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
