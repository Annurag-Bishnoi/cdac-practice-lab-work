package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DbConnection;

public class UserDAO {

	
public User isValid(String username ,String password,String role) throws SQLException, ClassNotFoundException {
	User user=null;
	
	String sql="""
            SELECT 
            u.user_id,
            u.username,
            u.fullname,
            r.role_name
        FROM Users u
        JOIN User_roles ur ON u.user_id = ur.user_id
        JOIN Roles r ON ur.role_id = r.role_id
        WHERE u.username = ?
        AND u.password = ?
        AND r.role_name=?
        AND u.is_active = TRUE
        """;
	
	Connection con=DbConnection.getConnection();
	
	PreparedStatement ps= con.prepareStatement(sql);
	ps.setString(1,username);
	ps.setString(2,password);
	ps.setString(3, role);
	
	ResultSet rs= ps.executeQuery();
	
	while(rs.next()) {	
				user=new User();
				user.setUser_id(rs.getString("user_id"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setRole_name(rs.getString("role_name"));
//				user.setEmail(rs.getString("email"));
	}
	
	
	return user;
}
	
	
	
}
