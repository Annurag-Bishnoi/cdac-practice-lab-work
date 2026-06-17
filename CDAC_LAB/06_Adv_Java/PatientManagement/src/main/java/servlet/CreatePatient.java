package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PatientDAO;
import model.Patient;

@WebServlet("/create")
public class CreatePatient extends HttpServlet {

	
	PatientDAO patientdao=new PatientDAO();
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
//	HttpSession session = req.getSession(false);
//		
//		if(session==null || session.getAttribute("username")==null) {
//			res.sendRedirect("login.jsp");
//			return;
//		}
		
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String gender =req.getParameter("gender");
		String email = req.getParameter("email");
		String address=req.getParameter("address");
		String phoneNo=req.getParameter("phoneNo");
		
		Patient p=new Patient(name,age,gender,email,address,phoneNo);
		
		try {
			boolean isCreated =patientdao.patCreated(p);
			
			if(isCreated) {
				 res.sendRedirect("Dashboard.jsp?msg=student_added");
			}
			else {
				res.sendRedirect("Dashboard.jsp?msg=Failed_ToAddStudent");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.sendRedirect("Dashboard.jsp");
		}
		
	}
}
