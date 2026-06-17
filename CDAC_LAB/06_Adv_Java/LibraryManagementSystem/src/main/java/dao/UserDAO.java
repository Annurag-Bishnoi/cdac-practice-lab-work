package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DbConnection;

public class UserDAO {

	
	public User isValid(String username,String password) throws ClassNotFoundException, SQLException {
		
		
		User user=null;
		Connection con= DbConnection.getConnection();
	
			
		String sql="Select * from users where username=? and password=? and is_Active= TRUE";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			 user = new User();

             user.setUserId(rs.getInt("user_id"));
             user.setUsername(rs.getString("username"));
             user.setPassword(rs.getString("password"));
             user.setFullName(rs.getString("full_name"));
             user.setEmail(rs.getString("email"));
		}
		
		return user;
		
		
		
	}
	
	
}
