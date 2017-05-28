package com.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// change to ConnectionFactory and make singleton ConnectionFactory.getInstance().getConnection();
public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "bank";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
	}
}