package com.rev.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static boolean build = true;
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build) {
			cf = new ConnectionFactory();
		}
		
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/jaja/my_git_repos/1705May15Java/James_Champ_Code/week03/BankApp/src/com/rev/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		}
		// TODO: Use more specific exceptions
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
