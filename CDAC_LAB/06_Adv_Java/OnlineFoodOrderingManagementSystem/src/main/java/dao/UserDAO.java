package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class UserDAO {

	
	public boolean isValid(String username,String password) throws ClassNotFoundException, SQLException {
		
		Connection con= DBUtil.getConnection();
	
			
		String sql="Select * from users where username=? and password=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		
		return false;
		
		
		
	}
	
	
}
