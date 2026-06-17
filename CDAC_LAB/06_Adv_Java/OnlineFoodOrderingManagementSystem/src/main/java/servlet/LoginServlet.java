package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	UserDAO userDao=new UserDAO();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		
		try {
			
			boolean	isValid = userDao.isValid(username, password);
			
			if(isValid) {
				HttpSession session = req.getSession();
				session.setAttribute("userid", username);
				
				res.sendRedirect("menu.jsp");
			}
			else {
				res.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	
		
		
	}

}
