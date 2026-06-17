package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;


public class UserDAO {

    public boolean validateUser(String username, String password) {

        boolean status = false;

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            Connection con = DBUtil.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
