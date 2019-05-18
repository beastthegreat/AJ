package utils;
import java.sql.*;

public class DBUtils {
	//add a static method to ret DB connection
	public static Connection fetchConnection() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/test";
		//load JDBC driver class
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, "root", "root");
	}
}
