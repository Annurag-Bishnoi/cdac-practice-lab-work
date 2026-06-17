
package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;

@WebServlet("/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {
	
	OrderDAO orderDao=new OrderDAO();
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		boolean isDeleted;
		try {
			isDeleted = orderDao.deleteOrder(id);
			  if(isDeleted) {
			       res.sendRedirect("viewOrder");
			   } else {
			       res.sendRedirect("viewOrder");
			   }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
		
		
	}
	

}
