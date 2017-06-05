package com.ers.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
			prop.load(new FileReader("C:/Users/jaja/my_git_repos/1705May15Java/James_Champ_Code/project01/EmployeeReimbursementSystem/src/com/ers/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		}
		catch(IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
