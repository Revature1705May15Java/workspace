package ersUtil;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory 
{
	private static Boolean build = true;
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory()
	{
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance()
	{
		if(build == true)
			cf = new ConnectionFactory();
		return cf; 
	}
	
	public Connection getConnection()
	{
		Connection c = null;
		
		try
		{
			Properties p = new Properties(); 
			p.load(new FileReader("C:/Users/tmdin/my_git_repos/1705May15Java/"
					+ "Theresa_Dinh_Code/Week3/ERS/src/Database.properties"));
			Class.forName(p.getProperty("driver")); 
			c = DriverManager.getConnection(p.getProperty("url"), 
					p.getProperty("usr"), p.getProperty("pwd")); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c; 
	}
}
