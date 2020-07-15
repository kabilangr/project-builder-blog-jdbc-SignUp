package utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.omg.CORBA.portable.InputStream;

public class ConnectionManager
{
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException
	{
		
		Properties pro=null;
		pro=loadPropertiesFile();
		final String url=pro.getProperty("url");
		final String driver=pro.getProperty("driver");
		final String name=pro.getProperty("username");
		final String pass=pro.getProperty("password");
		Class.forName(driver);
		Connection ob=null;
		ob=DriverManager.getConnection(url,name,pass);
		return ob;
	}
	public static Properties loadPropertiesFile() throws IOException
	{
		Properties pro=new Properties();
		InputStream in=(InputStream) ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		pro.load(in);
		in.close();
		return pro;
	}
}

