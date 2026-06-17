package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnection {

	private static final String URL = getEnv("LIBRARY_DB_URL", "jdbc:mysql://localhost:3306/library_db");
	private static final String USERNAME = getEnv("LIBRARY_DB_USERNAME", "root");
	private static final String PASSWORD = getEnv("LIBRARY_DB_PASSWORD", "");
	
	
	
	
	public static  Connection getConnection() throws SQLException, ClassNotFoundException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
		return con;
		
		
		
	}

	private static String getEnv(String key, String defaultValue) {
		String value = System.getenv(key);
		return value == null || value.trim().isEmpty() ? defaultValue : value;
	}
	
}
