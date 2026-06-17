package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
      
	private static final String URL = getEnv("FOOD_ORDERING_DB_URL", "jdbc:mysql://localhost:3306/foodordering");
	private static final String USERNAME = getEnv("FOOD_ORDERING_DB_USERNAME", "root");
	private static final String PASSWORD = getEnv("FOOD_ORDERING_DB_PASSWORD", "");
	
	
	
	
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
