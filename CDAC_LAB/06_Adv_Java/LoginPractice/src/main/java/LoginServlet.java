import java.io.IOException;
import java.lang.module.ModuleDescriptor.Requires;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String username = req.getParameter("username");
		String password= req.getParameter("password");
		
		if(username.equals("admin") && password.equals("admin123")) {
			
			res.sendRedirect("dashboard.jsp");
			
			
		}
		else {
			res.sendRedirect("login.jsp");
			
		}
		
	}
	

}
