package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import model.Patient;
import util.DbConnection;

public class PatientDAO {

	
	public boolean patCreated(Patient p) throws ClassNotFoundException, SQLException {
		
	
		
		
		
		String sql="INSERT INTO PATIENT(name,age,gender,email,address,phoneNo) values(?,?,?,?,?,?)";
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, p.getName());
		ps.setInt(2, p.getAge());
		ps.setString(3, p.getGender());
		ps.setString(4, p.getEmail());
		ps.setString(5, p.getAddress());
		ps.setString(6, p.getPhoneNo());
		
		
		int row=ps.executeUpdate();
		
		
		return row>0;
				
	}
	
	
	
	
	
}
