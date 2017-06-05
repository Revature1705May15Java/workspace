package com.ers.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	/**
	 * Used to indicate whether or not a {@code ConnectionFactory} must be
	 * created.
	 */
	private static boolean build = true;
	/**
	 * An instance of this {@code ConnectionFactory}.
	 */
	private static ConnectionFactory cf = null;
	
	/**
	 * Creates a {@code ConnectionFactory} and sets {@code build} to 
	 * {@code false}.
	 */
	private ConnectionFactory() {
		build = false;
	}
	
	/**
	 * Creates a new {@code ConnectionFactory} if one does not already
	 * exist. Returns an instance of a {@code ConnectionFactory} object.
	 * 
	 * @return A {@code ConnectionFactory} object.
	 */
	public static synchronized ConnectionFactory getInstance() {
		if(build) {
			cf = new ConnectionFactory();
		}
		
		return cf;
	}
	
	/**
	 * Reads from a connection properties file and returns a {@code Connection} based 
	 * on the information found in said file.
	 * 
	 * @return	A {@code Connection} to the project's database.
	 */
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
