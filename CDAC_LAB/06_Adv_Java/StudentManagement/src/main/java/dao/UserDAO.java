package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DbConnection;

public class UserDAO {

    public boolean isValid(String username, String password)
            throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }


	

	
	
	
}
