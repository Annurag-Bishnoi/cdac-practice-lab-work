package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	
	UserDAO userDao=new UserDAO();
	
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		String username = req.getParameter("username");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		
	
		try {
			
		User	user = userDao.isValid(username,password,role);
			
			if(user!=null) {
				HttpSession session = req.getSession();
				
				session.setAttribute("user_id",user.getUser_id());
				
				session.setAttribute("username", user.getUsername());
				session.setAttribute("role", user.getRole_name());
				
				session.setAttribute("fullname",user.getFullname());
				
				
				
				
				
				
				if(user.getRole_name().equals("ADMIN")) {
					res.sendRedirect("AdminDashboard.jsp");
				}
				else if(user.getRole_name().equals("DOCTOR")) {
					res.sendRedirect("DoctorDashboard.jsp");
				}
				else if(user.getRole_name().equals("PATIENT")) {
					res.sendRedirect("PatientDashboard.jsp");
				}
				else if(user.getRole_name().equals("RECEPTIONIST")) {
					res.sendRedirect("Receptionist.jsp");
				}
				else {
					req.setAttribute("error", "Invalid username or password");
		            req.getRequestDispatcher("login.jsp").forward(req, res);

				}
					
				}
			else {
				req.setAttribute("error", "Didnt found username or password");
	            req.getRequestDispatcher("login.jsp").forward(req, res);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 
		
	
		
	}

}
