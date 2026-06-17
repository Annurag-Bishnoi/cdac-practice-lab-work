package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	
	private static final String URL = getEnv("PATIENT_DB_URL", "jdbc:mysql://localhost:3306/Patients");
	private static final String USERNAME = getEnv("PATIENT_DB_USERNAME", "root");
	private static final String PASSWORD = getEnv("PATIENT_DB_PASSWORD", "");
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con= DriverManager.getConnection	(URL,USERNAME,PASSWORD);
				
				return con;
		
	}

	private static String getEnv(String key, String defaultValue) {
		String value = System.getenv(key);
		return value == null || value.trim().isEmpty() ? defaultValue : value;
	}
}
