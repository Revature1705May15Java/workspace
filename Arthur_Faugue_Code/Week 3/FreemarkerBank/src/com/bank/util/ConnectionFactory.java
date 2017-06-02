package com.bank.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static Boolean build=true;
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory(){
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance(){
		if(build==true){
			cf= new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		
		try{
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/User/my_git_repos/1705May15Java/Arthur_Faugue_Code/Week 3/FreemarkerBank/src/com/bank/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "bankingDB";
			String password = "p4ssw0rd";
			conn = DriverManager.getConnection(url, username, password);
		} catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
