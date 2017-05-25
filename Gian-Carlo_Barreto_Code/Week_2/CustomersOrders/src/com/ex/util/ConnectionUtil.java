package com.ex.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Connecting to the ExamplesDB database using JDBC
 */
public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "examples";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
	}
}
