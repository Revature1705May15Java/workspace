package com.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Connecting to the BankDB database using JDBC
 */
public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "bank_admin";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
	}
}
