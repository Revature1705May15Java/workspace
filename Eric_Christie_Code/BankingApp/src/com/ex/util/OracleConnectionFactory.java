package com.ex.util;

import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;

import oracle.jdbc.OracleConnection;

public class OracleConnectionFactory {
  
  private static OracleConnectionFactory INSTANCE = null;
  
  private static Boolean build = true;
  private static String propertiesFile = "C:Users/Eric/Employment/Revature/workspace/Eric_Christie_Code/"
      + "BankingApp/src/com/ex/util/database.properties";
  
  private OracleConnectionFactory() {
    build = false;
  }
  
  public static synchronized OracleConnectionFactory getInstance() {
    if (build == true) {
      INSTANCE = new OracleConnectionFactory();
    }
    return INSTANCE;
  }
  
  public OracleConnection getConnection() {
    OracleConnection connection = null;
    try {
      Properties p = new Properties();
      p.load(new FileReader(propertiesFile));
      Class.forName(p.getProperty("driver"));
      connection = (OracleConnection) DriverManager.getConnection(p.getProperty("url"),
          p.getProperty("user"), p.getProperty("password"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }
  
}
