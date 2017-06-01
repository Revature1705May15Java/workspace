package com.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory INSTANCE = new ConnectionFactory();

	private ConnectionFactory() {
		//
	}

	public static ConnectionFactory getInstance() {
		return INSTANCE;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "bank";
		String password = "p4ssw0rd";

		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(url, username, password);
	}
}
